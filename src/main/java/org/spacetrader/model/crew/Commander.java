package org.spacetrader.model.crew;

import org.spacetrader.controller.*;
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
import org.spacetrader.ui.FormAlert;
import org.spacetrader.ui.Strings;
import org.winforms.enums.DialogResult;
import org.winforms.Pane;

import java.util.Hashtable;

// TODO part of model
public class Commander extends CrewMember {

    private Ship ship = new Ship(ShipType.Gnat);
    private boolean insurance = false;
    private int cash = 1000;
    private int debt = 0;
    private int killsPirate = 0;
    private int killsPolice = 0;
    private int killsTrader = 0;
    private int policeRecordScore = 0;
    private int reputationScore = 0;
    private int days = 0;
    private int noclaim = 0;
    private int[] priceCargo = new int[10]; // Total price paid for trade goods

    public Commander(CrewMember crewMember) {
        super(crewMember);
        // Start off with a crew of only the commander and a Pulse Laser.
        ship.Crew()[0] = this;
        ship.addEquipment(Constants.WeaponObjects[WeaponType.PulseLaser.id]);
    }

    public Commander(Hashtable hash) {
        super(hash);
        cash = GetValueFromHash(hash, "_cash", cash);
        debt = GetValueFromHash(hash, "_debt", debt);
        killsPirate = GetValueFromHash(hash, "_killsPirate", killsPirate);
        killsPolice = GetValueFromHash(hash, "_killsPolice", killsPolice);
        killsTrader = GetValueFromHash(hash, "_killsTrader", killsTrader);
        policeRecordScore = GetValueFromHash(hash, "_policeRecordScore", policeRecordScore);
        reputationScore = GetValueFromHash(hash, "_reputationScore", reputationScore);
        days = GetValueFromHash(hash, "_days", days);
        insurance = GetValueFromHash(hash, "_insurance", insurance);
        noclaim = GetValueFromHash(hash, "_noclaim", noclaim);
        ship = new Ship(GetValueFromHash(hash, "_ship"/*,_ship*/, Hashtable.class));
        priceCargo = GetValueFromHash(hash, "_priceCargo", priceCargo, int[].class);
        Game.getCurrentGame().Mercenaries()[CrewMemberId.Commander.getId()] = this;
        Strings.CrewMemberNames[CrewMemberId.Commander.getId()] = GetValueFromHash(hash, "_name", Strings.CrewMemberNames[CrewMemberId.Commander.getId()]);
    }

    public void PayInterest() {
        if (getDebt() > 0) {
            int interest = Math.max(1, (int) (getDebt() * Constants.IntRate));
            if (getCash() > interest) {
                setCash(getCash() - interest);
            } else {
                setDebt(getDebt() + (interest - getCash()));
                setCash(0);
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
        if (netPrice > 0 && getDebt() > 0) {
            FormAlert.Alert(AlertType.DebtNoBuy, owner);
        } else if (netPrice > CashToSpend()) {
            FormAlert.Alert(AlertType.ShipBuyIF, owner);
        } else if (specToBuy.getCrewQuarters() < getShip().SpecialCrew().length) {
            String passengers = getShip().SpecialCrew()[1].Name();
            if (getShip().SpecialCrew().length > 2) {
                passengers += " and " + getShip().SpecialCrew()[2].Name();
            }
            FormAlert.Alert(AlertType.ShipBuyPassengerQuarters, owner, passengers);
        } else if (specToBuy.getCrewQuarters() < getShip().CrewCount()) {
            FormAlert.Alert(AlertType.ShipBuyCrewQuarters, owner);
        } else if (getShip().ReactorOnBoard()) {
            FormAlert.Alert(AlertType.ShipBuyReactor, owner);
        } else {
            Equipment[] special = new Equipment[]{
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
                if (getShip().HasEquipment(special[i])) {
                    if (specToBuy.Slots(special[i].EquipmentType()) == 0) {
                        FormAlert.Alert(AlertType.ShipBuyNoSlots, owner, newShipName, special[i].Name(), Strings.EquipmentTypes[special[i].EquipmentType().getId()]);
                    } else {
                        extraCost += special[i].TransferPrice();
                        add[i] = true;
                    }
                }
            }
            if (getShip().getEscapePod()) {
                addPod = true;
                extraCost += Constants.PodTransferCost;
            }
            if (netPrice + extraCost > CashToSpend()) {
                FormAlert.Alert(AlertType.ShipBuyIFTransfer, owner);
            }
            extraCost = 0;
            for (int i = 0; i < special.length; i++) {
                if (add[i]) {
                    if (netPrice + extraCost + special[i].TransferPrice() > CashToSpend()) {
                        FormAlert.Alert(AlertType.ShipBuyNoTransfer, owner, special[i].Name());
                    } else if (FormAlert.Alert(AlertType.ShipBuyTransfer, owner, special[i].Name(), special[i].Name().toLowerCase(), Functions.FormatNumber(special[i].TransferPrice())) == DialogResult.Yes) {
                        extraCost += special[i].TransferPrice();
                    } else {
                        add[i] = false;
                    }
                }
            }
            if (addPod) {
                if (netPrice + extraCost + Constants.PodTransferCost > CashToSpend()) {
                    FormAlert.Alert(AlertType.ShipBuyNoTransfer, owner, Strings.ShipInfoEscapePod);
                } else if (FormAlert.Alert(AlertType.ShipBuyTransfer, owner, Strings.ShipInfoEscapePod,
                        Strings.ShipInfoEscapePod.toLowerCase(), Functions.FormatNumber(Constants.PodTransferCost)) == DialogResult.Yes) {
                    extraCost += Constants.PodTransferCost;
                } else {
                    addPod = false;
                }
            }
            if (FormAlert.Alert(AlertType.ShipBuyConfirm, owner, getShip().Name(), newShipName, (add[0] || add[1]
                    || add[2] || addPod ? Strings.ShipBuyTransfer : "")) == DialogResult.Yes) {
                CrewMember[] oldCrew = getShip().Crew();
                setShip(new Ship(specToBuy.Type()));
                setCash(getCash() - (netPrice + extraCost));
                System.arraycopy(oldCrew, 0, getShip().Crew(), 0, Math.min(oldCrew.length, getShip().Crew().length));
                for (int i = 0; i < special.length; i++) {
                    if (add[i]) {
                        getShip().addEquipment(special[i]);
                    }
                }
                if (addPod) {
                    getShip().setEscapePod(true);
                } else if (getInsurance()) {
                    setInsurance(false);
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
        return getShip().getPrice() + cash - debt + (Game.getCurrentGame().getQuestStatusMoon() > 0 ? SpecialEvent.MoonCost : 0);
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
