package org.spacetrader.model.crew;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.SerializableObject;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.enums.CrewMemberId;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.ShipSpec;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.model.ship.equipment.Equipment;
import org.spacetrader.model.ship.equipment.GadgetType;
import org.spacetrader.model.ship.equipment.ShieldType;
import org.spacetrader.model.ship.equipment.WeaponType;
import org.spacetrader.ui.DialogAlert;
import org.spacetrader.ui.Strings;
import org.winforms.dialog.Pane;
import org.winforms.dialog.DialogResult;

import java.util.Hashtable;


public class Commander extends CrewMember {

    private Ship ship = new Ship(ShipType.Gnat);
    private boolean insurance;
    private int cash = 1000;
    private int debt;
    private int killsPirate;
    private int killsPolice;
    private int killsTrader;
    private int policeRecordScore;
    private int reputationScore;
    private int days;
    private int noclaim;
    private int[] priceCargo = new int[10]; // Total price paid for trade goods

    public Commander(CrewMember crewMember) {
        super(crewMember);
        // Start off with a crew of only the commander and a Pulse Laser.
        ship.Crew()[0] = this;
        ship.addEquipment(Constants.WeaponObjects[WeaponType.PulseLaser.id]);
    }

    public Commander(Hashtable hash) {
        super(hash);
        cash = SerializableObject.GetValueFromHash(hash, "_cash", cash);
        debt = SerializableObject.GetValueFromHash(hash, "_debt", debt);
        killsPirate = SerializableObject.GetValueFromHash(hash, "_killsPirate", killsPirate);
        killsPolice = SerializableObject.GetValueFromHash(hash, "_killsPolice", killsPolice);
        killsTrader = SerializableObject.GetValueFromHash(hash, "_killsTrader", killsTrader);
        policeRecordScore = SerializableObject.GetValueFromHash(hash, "_policeRecordScore", policeRecordScore);
        reputationScore = SerializableObject.GetValueFromHash(hash, "_reputationScore", reputationScore);
        days = SerializableObject.GetValueFromHash(hash, "_days", days);
        insurance = SerializableObject.GetValueFromHash(hash, "_insurance", insurance);
        noclaim = SerializableObject.GetValueFromHash(hash, "_noclaim", noclaim);
        ship = new Ship(SerializableObject.GetValueFromHash(hash, "_ship"/*,_ship*/, Hashtable.class));
        priceCargo = SerializableObject.GetValueFromHash(hash, "_priceCargo", priceCargo, int[].class);
        Game.getCurrentGame().Mercenaries()[CrewMemberId.Commander.getId()] = this;
        Strings.CrewMemberNames[CrewMemberId.Commander.getId()] = SerializableObject.GetValueFromHash(hash, "_name", Strings.CrewMemberNames[CrewMemberId.Commander.getId()]);
    }

    public void PayInterest() {
        if (debt > 0) {
            int interest = Math.max(1, (int) (debt * Constants.IntRate));
            if (cash > interest) {
                cash = cash - interest;
            } else {
                debt = debt + (interest - cash);
                cash = 0;
            }
        }
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_cash", cash);
        hash.put("_debt", debt);
        hash.put("_killsPirate", killsPirate);
        hash.put("_killsPolice", killsPolice);
        hash.put("_killsTrader", killsTrader);
        hash.put("_policeRecordScore", policeRecordScore);
        hash.put("_reputationScore", reputationScore);
        hash.put("_days", days);
        hash.put("_insurance", insurance);
        hash.put("_noclaim", noclaim);
        hash.put("_ship", ship.Serialize());
        hash.put("_priceCargo", priceCargo);
        hash.put("_name", Name());
        return hash;
    }

    public boolean TradeShip(ShipSpec specToBuy, int netPrice, Pane owner) {
        return TradeShip(specToBuy, netPrice, specToBuy.Name(), owner);
    }

    public boolean TradeShip(ShipSpec specToBuy, int netPrice, String newShipName, Pane owner) {
        boolean traded = false;
        if (netPrice > 0 && debt > 0) {
            DialogAlert.Alert(AlertType.DebtNoBuy, owner);
        } else if (netPrice > CashToSpend()) {
            DialogAlert.Alert(AlertType.ShipBuyIF, owner);
        } else if (specToBuy.getCrewQuarters() < ship.SpecialCrew().length) {
            String passengers = ship.SpecialCrew()[1].Name();
            if (ship.SpecialCrew().length > 2) {
                passengers += " and " + ship.SpecialCrew()[2].Name();
            }
            DialogAlert.Alert(AlertType.ShipBuyPassengerQuarters, owner, passengers);
        } else if (specToBuy.getCrewQuarters() < ship.CrewCount()) {
            DialogAlert.Alert(AlertType.ShipBuyCrewQuarters, owner);
        } else if (ship.ReactorOnBoard()) {
            DialogAlert.Alert(AlertType.ShipBuyReactor, owner);
        } else {
            Equipment[] special = {
                    Constants.WeaponObjects[WeaponType.MorgansLaser.id],
                    Constants.WeaponObjects[WeaponType.QuantumDisruptor.id],
                    Constants.Shields[ShieldType.Lightning.id],
                    Constants.Gadgets[GadgetType.FuelCompactor.asInteger()],
                    Constants.Gadgets[GadgetType.HiddenCargoBays.asInteger()]
            };
            boolean[] add = new boolean[special.length];
            boolean addPod = false;
            int extraCost = 0;
            for (int i = 0; i < special.length; i++) {
                if (ship.HasEquipment(special[i])) {
                    if (specToBuy.Slots(special[i].EquipmentType()) == 0) {
                        DialogAlert.Alert(AlertType.ShipBuyNoSlots, owner, newShipName, special[i].Name(), Strings.EquipmentTypes[special[i].EquipmentType().getId()]);
                    } else {
                        extraCost += special[i].TransferPrice();
                        add[i] = true;
                    }
                }
            }
            if (ship.getEscapePod()) {
                addPod = true;
                extraCost += Constants.PodTransferCost;
            }
            if (netPrice + extraCost > CashToSpend()) {
                DialogAlert.Alert(AlertType.ShipBuyIFTransfer, owner);
            }
            extraCost = 0;
            for (int i = 0; i < special.length; i++) {
                if (add[i]) {
                    if (netPrice + extraCost + special[i].TransferPrice() > CashToSpend()) {
                        DialogAlert.Alert(AlertType.ShipBuyNoTransfer, owner, special[i].Name());
                    } else if (DialogAlert.Alert(AlertType.ShipBuyTransfer, owner, special[i].Name(), special[i].Name().toLowerCase(), ModelUtils.formatNumber(special[i].TransferPrice())) == DialogResult.Yes) {
                        extraCost += special[i].TransferPrice();
                    } else {
                        add[i] = false;
                    }
                }
            }
            if (addPod) {
                if (netPrice + extraCost + Constants.PodTransferCost > CashToSpend()) {
                    DialogAlert.Alert(AlertType.ShipBuyNoTransfer, owner, Strings.ShipInfoEscapePod);
                } else if (DialogAlert.Alert(AlertType.ShipBuyTransfer, owner, Strings.ShipInfoEscapePod,
                        Strings.ShipInfoEscapePod.toLowerCase(), ModelUtils.formatNumber(Constants.PodTransferCost)) == DialogResult.Yes) {
                    extraCost += Constants.PodTransferCost;
                } else {
                    addPod = false;
                }
            }
            if (DialogAlert.Alert(AlertType.ShipBuyConfirm, owner, ship.Name(), newShipName, (add[0] || add[1]
                    || add[2] || addPod ? Strings.ShipBuyTransfer : "")) == DialogResult.Yes) {
                CrewMember[] oldCrew = ship.Crew();
                ship = new Ship(specToBuy.Type());
                cash = cash - (netPrice + extraCost);
                System.arraycopy(oldCrew, 0, ship.Crew(), 0, Math.min(oldCrew.length, ship.Crew().length));
                for (int i = 0; i < special.length; i++) {
                    if (add[i]) {
                        ship.addEquipment(special[i]);
                    }
                }
                if (addPod) {
                    ship.setEscapePod(true);
                } else if (insurance) {
                    insurance = false;
                    NoClaim(0);
                }
                traded = true;
            }
        }
        return traded;
    }

    public int CashToSpend() {
        return cash - (Game.getCurrentGame().Options().getReserveMoney() ? Game.getCurrentGame().CurrentCosts() : 0);
    }

    public int NoClaim() {
        return noclaim;
    }

    public void NoClaim(int value) {
        noclaim = Math.max(0, Math.min(Constants.MaxNoClaim, value));
    }

    public int[] PriceCargo() {
        return priceCargo;
    }

    public int Worth() {
        return ship.getPrice() + cash - debt + (Game.getCurrentGame().getQuestStatusMoon() > 0 ? SpecialEvent.MoonCost : 0);
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getReputationScore() {
        return reputationScore;
    }

    public void setReputationScore(int reputationScore) {
        this.reputationScore = reputationScore;
    }

    public int getPoliceRecordScore() {
        return policeRecordScore;
    }

    public void setPoliceRecordScore(int policeRecordScore) {
        this.policeRecordScore = policeRecordScore;
    }

    public int getKillsTrader() {
        return killsTrader;
    }

    public void setKillsTrader(int killsTrader) {
        this.killsTrader = killsTrader;
    }

    public int getKillsPolice() {
        return killsPolice;
    }

    public void setKillsPolice(int killsPolice) {
        this.killsPolice = killsPolice;
    }

    public int getKillsPirate() {
        return killsPirate;
    }

    public void setKillsPirate(int killsPirate) {
        this.killsPirate = killsPirate;
    }

    public boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
