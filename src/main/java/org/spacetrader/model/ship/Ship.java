package org.spacetrader.model.ship;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.SerializableObject;
import org.spacetrader.model.PoliticalSystem;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.crew.CrewMember;
import org.spacetrader.model.enums.*;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.ship.equipment.*;
import org.spacetrader.model.system.StarSystem;
import org.spacetrader.ui.Strings;
import org.spacetrader.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

// part of the model
public class Ship extends ShipSpec {

    private CrewMember[] crew;
    private Gadget[] gadgets;
    private Shield[] shields;
    private Weapon[] weapons;
    private boolean EscapePod;
    private boolean pod;
    private int fuel;
    private int hull;
    private int tribbles;
    private int[] cargo = new int[10];

    // The following does not need to be saved. It's more of a temp variable.
    private boolean[] tradeableItems;

    public Ship(ShipType type) {
        SetValues(type);
    }

    public Ship(OpponentType opponentType) {
        if (OpponentType.FamousCaptain == opponentType) {
            SetValues(Constants.ShipSpecs[Constants.MaxShip].Type());
            for (int i = 0; i < shields.length; i++) {
                addEquipment(Constants.Shields[ShieldType.Reflective.id]);
            }
            for (int i = 0; i < weapons.length; i++) {
                addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
            }
            addEquipment(Constants.Gadgets[GadgetType.NavigatingSystem.asInteger()]);
            addEquipment(Constants.Gadgets[GadgetType.TargetingSystem.asInteger()]);
            Crew()[0] = Game.getCurrentGame().Mercenaries()[CrewMemberId.FamousCaptain.getId()];
        } else if (OpponentType.Bottle == opponentType) {
            SetValues(ShipType.Bottle);
        } else {
            int tries = OpponentType.Mantis == opponentType
                    ? Game.getCurrentGame().Difficulty().getId() + 1
                    : Math.max(1, Game.getCurrentGame().Commander().Worth() / 150000 + Game.getCurrentGame().Difficulty().getId() - Difficulty.Normal.getId());
            generateOpponentShip(opponentType);
            generateOpponentAddCrew();
            generateOpponentAddGadgets(tries);
            generateOpponentAddShields(tries);
            generateOpponentAddWeapons(tries);
            if (OpponentType.Mantis != opponentType) {
                generateOpponentSetHullStrength();
            }
            if (OpponentType.Police != opponentType) {
                generateOpponentAddCargo(OpponentType.Pirate == opponentType);
            }
        }
    }


    public Ship(Hashtable hash) {
        super(hash);
        fuel = SerializableObject.GetValueFromHash(hash, "_fuel", Integer.class);
        hull = SerializableObject.GetValueFromHash(hash, "_hull", Integer.class);
        tribbles = SerializableObject.GetValueFromHash(hash, "_tribbles", tribbles);
        cargo = SerializableObject.GetValueFromHash(hash, "_cargo", cargo, int[].class);
        weapons = (Weapon[]) SerializableObject.ArrayListToArray(SerializableObject.GetValueFromHash(hash, "_weapons", ArrayList.class), "Weapon");
        shields = (Shield[]) SerializableObject.ArrayListToArray(SerializableObject.GetValueFromHash(hash, "_shields", ArrayList.class), "Shield");
        gadgets = (Gadget[]) SerializableObject.ArrayListToArray(SerializableObject.GetValueFromHash(hash, "_gadgets", ArrayList.class), "Gadget");
        pod = SerializableObject.GetValueFromHash(hash, "_pod", pod);
        int[] crewIds = SerializableObject.GetValueFromHash(hash, "_crewIds", (new int[0]), int[].class);
        crew = new CrewMember[crewIds.length];
        for (int index = 0; index < crew.length; index++) {
            CrewMemberId id = CrewMemberId.FromInt(crewIds[index]);
            crew[index] = (CrewMemberId.NA == id ? null : Game.getCurrentGame().Mercenaries()[id.getId()]);
        }
    }

    public void addEquipment(Equipment item) {
        Equipment[] equip = getEquipmentByType(item.EquipmentType());
        int slot = -1;
        for (int i = 0; i < equip.length && -1 == slot; i++) {
            if (null == equip[i]) {
                slot = i;
            }
        }
        if (0 <= slot) {
            equip[slot] = item.Clone();
        }
    }

    public int getBaseWorth(boolean forInsurance) {
        int price =
                // Trade-in value is three-fourths the original price
                getPrice() * (0 < getTribbles() && !forInsurance ? 1 : 3) / 4
                        // subtract repair costs
                        - (HullStrength() - hull) * getRepairCost()
                        // subtract costs to fill tank with fuel
                        - (FuelTanks() - fuel) * getFuelCost();
        // Add 3/4 of the price of each item of equipment
        for (Weapon weapon : weapons) {
            if (null != weapon) {
                price += weapon.SellPrice();
            }
        }
        for (Shield shield : shields) {
            if (null != shield) {
                price += shield.SellPrice();
            }
        }
        for (Gadget gadget : gadgets) {
            if (null != gadget) {
                price += gadget.SellPrice();
            }
        }
        return price;
    }

    public int getBounty() {
        int price = getPrice();
        for (Weapon weapon : weapons) {
            if (null != weapon) {
                price += weapon.Price();
            }
        }
        for (Shield shield : shields) {
            if (null != shield) {
                price += shield.Price();
            }
        }
        // Gadgets aren't counted in the price, because they are already taken into account in the skill adjustment of the price.
        price = price * (2 * Pilot() + Engineer() + 3 * Fighter()) / 60;
        // Divide by 200 to get the bounty, then round down to the nearest 25.
        int bounty = price / 200 / 25 * 25;
        return Math.max(25, Math.min(2500, bounty));
    }

    public Equipment[] getEquipmentByType(EquipmentType type) {
        Equipment[] equip = null;
        switch (type) {
            case Weapon:
                equip = weapons;
                break;
            case Shield:
                equip = shields;
                break;
            case Gadget:
                equip = gadgets;
                break;
        }
        return equip;
    }

    /**
     * @param crewId The surviving crew member??
     */
    public void handleFire(CrewMemberId crewId) {
        int skill = Trader();
        boolean found = false;
        CrewMember merc = null;
        for (int i = 0; i < Crew().length; i++) {
            if (null != Crew()[i] && Crew()[i].Id() == crewId) {
                found = true;
                merc = Crew()[i];
            }
            if (found) {
                Crew()[i] = (i < Crew().length - 1) ? Crew()[i + 1] : null;
            }
        }
        if (Trader() != skill) {
            Game.getCurrentGame().RecalculateBuyPrices(Game.getCurrentGame().Commander().CurrentSystem());
        }
        if (null != merc && !Util.arrayContains(Constants.SpecialCrewMemberIds, (merc.Id()))) {
            StarSystem[] universe = Game.getCurrentGame().getUniverse();
            // The leaving Mercenary travels to a nearby random system.
            merc.setCurrentSystemId(StarSystemId.NA);
            while (StarSystemId.NA == merc.getCurrentSystemId()) {
                StarSystem system = universe[Functions.GetRandom(universe.length)];
                if (Constants.MaxRange > Functions.distance(system, Game.getCurrentGame().Commander().CurrentSystem())) {
                    merc.setCurrentSystemId(system.Id());
                }
            }
        }
    }

    private void generateOpponentAddCargo(boolean pirate) {
        if (0 < CargoBays()) {
            Difficulty diff = Game.getCurrentGame().Difficulty();
            int baysToFill = CargoBays();
            if (diff.getId() >= Difficulty.Normal.getId()) {
                baysToFill = Math.min(15, 3 + Functions.GetRandom(baysToFill - 5));
            }
            if (pirate) {
                if (diff.getId() < Difficulty.Normal.getId()) {
                    baysToFill = baysToFill * 4 / 5;
                } else {
                    baysToFill = Math.max(1, baysToFill / diff.getId());
                }
            }
            for (int bays, i = 0; i < baysToFill; i += bays) {
                int item = Functions.GetRandom(Constants.TradeItems.length);
                bays = Math.min(baysToFill - i, 1 + Functions.GetRandom(10 - item));
                Cargo()[item] += bays;
            }
        }
    }

    private void generateOpponentAddCrew() {
        CrewMember[] mercs = Game.getCurrentGame().Mercenaries();
        Difficulty diff = Game.getCurrentGame().Difficulty();
        Crew()[0] = mercs[CrewMemberId.Opponent.getId()];
        Crew()[0].Pilot(1 + Functions.GetRandom(Constants.MaxSkill));
        Crew()[0].Fighter(1 + Functions.GetRandom(Constants.MaxSkill));
        Crew()[0].Trader(1 + Functions.GetRandom(Constants.MaxSkill));
        if (StarSystemId.Kravat == Game.getCurrentGame().WarpSystem().Id() && WildOnBoard() && Functions.GetRandom(10) < diff.getId() + 1) {
            Crew()[0].Engineer(Constants.MaxSkill);
        } else {
            Crew()[0].Engineer(1 + Functions.GetRandom(Constants.MaxSkill));
        }
        int numCrew;
        if (Difficulty.Impossible == diff) {
            numCrew = getCrewQuarters();
        } else {
            numCrew = 1 + Functions.GetRandom(getCrewQuarters());
            if (Difficulty.Hard == diff && numCrew < getCrewQuarters()) {
                numCrew++;
            }
        }
        for (int i = 1; i < numCrew; i++) {
            // Keep getting a new random mercenary until we have a non-special one.
            while (null == Crew()[i] || Util.arrayContains(Constants.SpecialCrewMemberIds, Crew()[i].Id())) {
                Crew()[i] = mercs[Functions.GetRandom(mercs.length)];
            }
        }
    }

    private void generateOpponentAddGadgets(int tries) {
        if (0 < getGadgetSlots()) {
            int numGadgets;
            if (Difficulty.Impossible == Game.getCurrentGame().Difficulty()) {
                numGadgets = getGadgetSlots();
            } else {
                numGadgets = Functions.GetRandom(getGadgetSlots() + 1);
                if (numGadgets < getGadgetSlots() && (4 < tries || (2 < tries && 0 < Functions.GetRandom(2)))) {
                    numGadgets++;
                }
            }
            for (int i = 0; i < numGadgets; i++) {
                int bestGadgetType = 0;
                for (int j = 0; j < tries; j++) {
                    int x = Functions.GetRandom(100);
                    int sum = Constants.Gadgets[0].Chance();
                    int gadgetType = 0;
                    while (sum < x && gadgetType <= Constants.Gadgets.length - 1) {
                        gadgetType++;
                        sum += Constants.Gadgets[gadgetType].Chance();
                    }
                    if (!HasGadget(Constants.Gadgets[gadgetType].Type()) && gadgetType > bestGadgetType) {
                        bestGadgetType = gadgetType;
                    }
                }
                addEquipment(Constants.Gadgets[bestGadgetType]);
            }
        }
    }

    public int getTribbles() {
        return tribbles;
    }

    public void setTribbles(int tribbles) {
        this.tribbles = tribbles;
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public boolean getEscapePod() {
        return EscapePod;
    }

    public void setEscapePod(boolean escapePod) {
        EscapePod = escapePod;
    }

    private void generateOpponentAddShields(int tries) {
        if (0 < getShieldSlots()) {
            int numShields;
            if (Difficulty.Impossible == Game.getCurrentGame().Difficulty()) {
                numShields = getShieldSlots();
            } else {
                numShields = Functions.GetRandom(getShieldSlots() + 1);
                if (numShields < getShieldSlots() && (3 < tries || (1 < tries && 0 < Functions.GetRandom(2)))) {
                    numShields++;
                }
            }
            for (int i = 0; i < numShields; i++) {
                int bestShieldType = 0;
                for (int j = 0; j < tries; j++) {
                    int x = Functions.GetRandom(100);
                    int sum = Constants.Shields[0].Chance();
                    int shieldType = 0;
                    while (sum < x && shieldType <= Constants.Shields.length - 1) {
                        shieldType++;
                        sum += Constants.Shields[shieldType].Chance();
                    }
                    if (!HasShield(Constants.Shields[shieldType].Type()) && shieldType > bestShieldType) {
                        bestShieldType = shieldType;
                    }
                }
                addEquipment(Constants.Shields[bestShieldType]);
                shields[i].setCharge(0);
                for (int j = 0; 5 > j; j++) {
                    int charge = 1 + Functions.GetRandom(shields[i].Power());
                    if (charge > shields[i].getCharge()) {
                        shields[i].setCharge(charge);
                    }
                }
            }
        }
    }

    private void generateOpponentAddWeapons(int tries) {
        if (0 < getWeaponSlots()) {
            int numWeapons;
            if (Difficulty.Impossible == Game.getCurrentGame().Difficulty()) {
                numWeapons = getWeaponSlots();
            } else if (1 == getWeaponSlots()) {
                numWeapons = 1;
            } else {
                numWeapons = 1 + Functions.GetRandom(getWeaponSlots());
                if (numWeapons < getWeaponSlots() && (4 < tries || (3 < tries && 0 < Functions.GetRandom(2)))) {
                    numWeapons++;
                }
            }
            for (int i = 0; i < numWeapons; i++) {
                int bestWeaponType = 0;
                for (int j = 0; j < tries; j++) {
                    int x = Functions.GetRandom(100);
                    int sum = Constants.WeaponObjects[0].Chance();
                    int weaponType = 0;
                    while (sum < x && weaponType <= Constants.WeaponObjects.length - 1) {
                        weaponType++;
                        sum += Constants.WeaponObjects[weaponType].Chance();
                    }
                    if (!HasWeapon(WeaponType.fromId(weaponType), true) && weaponType > bestWeaponType) {
                        bestWeaponType = weaponType;
                    }
                }
                addEquipment(Constants.WeaponObjects[bestWeaponType]);
            }
        }
    }

    private void generateOpponentSetHullStrength() {
        // If there are shields, the hull will probably be stronger
        if (0 == ShieldStrength() || 0 == Functions.GetRandom(5)) {
            hull = 0;
            for (int i = 0; 5 > i; i++) {
                int hull = 1 + Functions.GetRandom(HullStrength());
                if (hull > this.hull) {
                    this.hull = hull;
                }
            }
        }
    }

    private void generateOpponentShip(OpponentType opponentType) {
        Commander commander = Game.getCurrentGame().Commander();
        PoliticalSystem polSys = Game.getCurrentGame().WarpSystem().PoliticalSystem();
        if (OpponentType.Mantis == opponentType) {
            SetValues(ShipType.Mantis);
        } else {
            ShipType oppShipType;
            int tries = 1;
            switch (opponentType) {
                case Pirate:
                    // Pirates become better when you get richer
                    tries = 1 + commander.Worth() / 100000;
                    tries = Math.max(1, tries + Game.getCurrentGame().Difficulty().getId() - Difficulty.Normal.getId());
                    break;
                case Police:
                    // The police will try to hunt you down with better ships if you are a villain,
                    // and they will try even harder when you are considered to be a psychopath (or are transporting Jonathan Wild)
                    if (Constants.PoliceRecordScorePsychopath > commander.getPoliceRecordScore() || commander.getShip().WildOnBoard()) {
                        tries = 5;
                    } else if (Constants.PoliceRecordScoreVillain > commander.getPoliceRecordScore()) {
                        tries = 3;
                    } else {
                        tries = 1;
                    }
                    tries = Math.max(1, tries + Game.getCurrentGame().Difficulty().getId() - Difficulty.Normal.getId());
                    break;
            }
            if (OpponentType.Trader == opponentType) {
                oppShipType = ShipType.Flea;
            } else {
                oppShipType = ShipType.Gnat;
            }
            int total = 0;
            for (int i = 0; Constants.MaxShip > i; i++) {
                ShipSpec spec = Constants.ShipSpecs[i];
                if (polSys.ShipTypeLikely(spec.Type(), opponentType)) {
                    total += spec.getOccurrence();
                }
            }
            for (int i = 0; i < tries; i++) {
                int x = Functions.GetRandom(total);
                int sum = -1;
                int j = -1;
                do {
                    j++;
                    if (polSys.ShipTypeLikely(Constants.ShipSpecs[j].Type(), opponentType)) {
                        if (0 < sum) {
                            sum += Constants.ShipSpecs[j].getOccurrence();
                        } else {
                            sum = Constants.ShipSpecs[j].getOccurrence();
                        }
                    }
                } while (sum < x && Constants.MaxShip > j);
                if (j > oppShipType.getId()) {
                    oppShipType = Constants.ShipSpecs[j].Type();
                }
            }
            SetValues(oppShipType);
        }
    }

    //
    //

    /**
     * Returns the index of a trade good that is on a given ship that can be bought/sold in the current system.
     * JAF - Made this MUCH simpler by storing an array of booleans indicating the tradeable goods when HasTradeableItem is called.
     */
    public int getRandomTradeableItem() {
        int index = Functions.GetRandom(tradeableItems.length);
        while (!tradeableItems[index]) {
            index = (index + 1) % tradeableItems.length;
        }
        return index;
    }

    public boolean HasCrew(CrewMemberId id) {
        boolean found = false;
        for (int i = 0; i < Crew().length && !found; i++) {
            if (null != Crew()[i] && Crew()[i].Id() == id) {
                found = true;
            }
        }
        return found;
    }

    public boolean HasEquipment(Equipment item) {
        boolean found = false;
        switch (item.EquipmentType()) {
            case Weapon:
                found = HasWeapon(((Weapon) item).Type(), true);
                break;
            case Shield:
                found = HasShield(((Shield) item).Type());
                break;
            case Gadget:
                found = HasGadget(((Gadget) item).Type());
                break;
        }
        return found;
    }

    public boolean HasGadget(GadgetType gadgetType) {
        boolean found = false;
        for (int i = 0; i < gadgets.length && !found; i++) {
            if (null != gadgets[i] && gadgets[i].Type() == gadgetType) {
                found = true;
            }
        }
        return found;
    }

    public boolean HasShield(ShieldType shieldType) {
        boolean found = false;
        for (int i = 0; i < shields.length && !found; i++) {
            if (null != shields[i] && shields[i].Type() == shieldType) {
                found = true;
            }
        }
        return found;
    }

    // Determines if a given ship is carrying items that can be bought or sold in the current system.
    public boolean HasTradeableItems() {
        boolean found = false;
        boolean criminal = Constants.PoliceRecordScoreDubious > Game.getCurrentGame().Commander().getPoliceRecordScore();
        tradeableItems = new boolean[10];
        for (int i = 0; i < Cargo().length; i++) {
            // Trade only if trader is selling and the item has a buy price on the local system,
            // or trader is buying, and there is a sell price on the local system.
            // Criminals can only buy or sell illegal goods, Noncriminals cannot buy or sell such items.
            // Simplified this - JAF
            if (0 < Cargo()[i]
                    && criminal == Constants.TradeItems[i].isIllegal()
                    && ((!CommandersShip() && 0 < Game.getCurrentGame().PriceCargoBuy()[i]) || (CommandersShip() && 0 < Game.getCurrentGame().PriceCargoSell()[i]))) {
                found = true;
                tradeableItems[i] = true;
            }
        }
        return found;
    }

    public boolean HasWeapon(WeaponType weaponType, boolean exactCompare) {
        boolean found = false;
        for (int i = 0; i < weapons.length && !found; i++) {
            if (null != weapons[i] && (weapons[i].Type() == weaponType || !exactCompare && weapons[i].Type().id > weaponType.id)) {
                found = true;
            }
        }
        return found;
    }

    public void Hire(CrewMember merc) {
        int skill = Trader();
        int slot = -1;
        for (int i = 0; i < Crew().length && -1 == slot; i++) {
            if (null == Crew()[i]) {
                slot = i;
            }
        }
        if (0 <= slot) {
            Crew()[slot] = merc;
        }
        if (Trader() != skill) {
            Game.getCurrentGame().RecalculateBuyPrices(Game.getCurrentGame().Commander().CurrentSystem());
        }
    }

    public String IllegalSpecialCargoActions() {
        ArrayList<String> actions = new ArrayList<>();
        if (ReactorOnBoard()) {
            actions.add(Strings.EncounterPoliceSurrenderReactor);
        } else if (WildOnBoard()) {
            actions.add(Strings.EncounterPoliceSurrenderWild);
        }
        if (SculptureOnBoard()) {
            actions.add(Strings.EncounterPoliceSurrenderSculpt);
        }
        return actions.isEmpty()
                ? "" : Functions.StringVars(Strings.EncounterPoliceSurrenderAction, Functions.FormatList(Functions.arrayListtoStringArray(actions)));
    }

    public String IllegalSpecialCargoDescription(String wrapper, boolean includePassengers, boolean includeTradeItems) {
        ArrayList<String> items = new ArrayList<>();
        if (includePassengers && WildOnBoard()) {
            items.add(Strings.EncounterPoliceSubmitWild);
        }
        if (ReactorOnBoard()) {
            items.add(Strings.EncounterPoliceSubmitReactor);
        }
        if (SculptureOnBoard()) {
            items.add(Strings.EncounterPoliceSubmitSculpture);
        }
        if (includeTradeItems && DetectableIllegalCargo()) {
            items.add(Strings.EncounterPoliceSubmitGoods);
        }
        String allItems = Functions.FormatList(Functions.arrayListtoStringArray(items));
        if (!allItems.isEmpty() && !wrapper.isEmpty()) {
            allItems = Functions.StringVars(wrapper, allItems);
        }
        return allItems;
    }

    public void PerformRepairs() {
        // A disabled ship cannot be repaired.
        if (CommandersShip() || !Game.getCurrentGame().getOpponentDisabled()) {
            // Engineer may do some repairs
            int repairs = Functions.GetRandom(Engineer());
            if (0 < repairs) {
                int used = Math.min(repairs, HullStrength() - hull);
                hull = hull + used;
                repairs -= used;
            }
            // Shields are easier to repair
            if (0 < repairs) {
                repairs *= 2;
                for (int i = 0; i < shields.length && 0 < repairs; i++) {
                    if (null != shields[i]) {
                        int used = Math.min(repairs, shields[i].Power() - shields[i].getCharge());
                        shields[i].setCharge(shields[i].getCharge() + used);
                        repairs -= used;
                    }
                }
            }
        }
    }

    public void RemoveEquipment(EquipmentType type, int slot) {
        Equipment[] equip = getEquipmentByType(type);
        int last = equip.length - 1;
        for (int i = slot; i < last; i++) {
            equip[i] = equip[i + 1];
        }
        equip[last] = null;
    }

    public void RemoveEquipment(EquipmentType type, Object subType) {
        boolean found = false;
        Equipment[] equip = getEquipmentByType(type);
        for (int i = 0; i < equip.length && !found; i++) {
            if (null != equip[i] && equip[i].TypeEquals(subType)) {
                RemoveEquipment(type, i);
                found = true;
            }
        }
    }

    public void RemoveIllegalGoods() {
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            if (Constants.TradeItems[i].isIllegal()) {
                Cargo()[i] = 0;
                Game.getCurrentGame().Commander().PriceCargo()[i] = 0;
            }
        }
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        // We don't want the actual CrewMember Objects - we just want the ids.
        int[] crewIds = new int[crew.length];
        for (int i = 0; i < crewIds.length; i++) {
            crewIds[i] = (null == crew[i] ? CrewMemberId.NA : crew[i].Id()).getId();
        }
        hash.put("_fuel", fuel);
        hash.put("_hull", hull);
        hash.put("_tribbles", tribbles);
        hash.put("_cargo", cargo);
        hash.put("_weapons", SerializableObject.ArrayToArrayList(weapons));
        hash.put("_shields", SerializableObject.ArrayToArrayList(shields));
        hash.put("_gadgets", SerializableObject.ArrayToArrayList(gadgets));
        hash.put("_crewIds", crewIds);
        hash.put("_pod", pod);
        return hash;
    }

    @Override
    protected void SetValues(ShipType type) {
        super.SetValues(type);
        weapons = new Weapon[getWeaponSlots()];
        shields = new Shield[getShieldSlots()];
        gadgets = new Gadget[getGadgetSlots()];
        crew = new CrewMember[getCrewQuarters()];
        fuel = FuelTanks();
        hull = HullStrength();
    }

    public int WeaponStrength() {
        return WeaponStrength(WeaponType.PulseLaser, WeaponType.QuantumDisruptor);
    }

    public int WeaponStrength(WeaponType min, WeaponType max) {
        int total = 0;
        for (Weapon weapon : weapons) {
            if (null != weapon && weapon.Type().id >= min.id && weapon.Type().id <= max.id) {
                total += weapon.Power();
            }
        }
        return total;
    }

    public int Worth(boolean forInsurance) {
        int price = getBaseWorth(forInsurance);
        for (int i = 0; i < cargo.length; i++) {
            price += Game.getCurrentGame().Commander().PriceCargo()[i];
        }
        return price;
    }

    public boolean AnyIllegalCargo() {
        int illegalCargo = 0;
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            if (Constants.TradeItems[i].isIllegal()) {
                illegalCargo += Cargo()[i];
            }
        }
        return 0 < illegalCargo;
    }

    public boolean ArtifactOnBoard() {
        return CommandersShip() && SpecialEvent.StatusArtifactOnBoard == Game.getCurrentGame().getQuestStatusArtifact();
    }

    public int[] Cargo() {
        return cargo;
    }

    // Changed the semantics of Filled versus total Cargo Bays. Bays used for transporting special items
    // are now included in the total bays and in the filled bays. JAF
    @Override
    public int CargoBays() {
        int bays = super.CargoBays();
        for (Gadget gadget : gadgets) {
            if (null != gadget && (GadgetType.ExtraCargoBays == gadget.Type() || GadgetType.HiddenCargoBays == gadget.Type())) {
                bays += 5;
            }
        }
        return super.CargoBays() + ExtraCargoBays() + HiddenCargoBays();
    }

    public boolean Cloaked() {
        int oppEng = CommandersShip() ? Game.getCurrentGame().getOpponent().Engineer() : Game.getCurrentGame().Commander().getShip().Engineer();
        return HasGadget(GadgetType.CloakingDevice) && Engineer() > oppEng;
    }

    public boolean CommandersShip() {
        return this == Game.getCurrentGame().Commander().getShip();
    }

    public CrewMember[] Crew() {
        return crew;
    }

    public int CrewCount() {
        int total = 0;
        for (int i = 0; i < Crew().length; i++) {
            if (null != Crew()[i]) {
                total++;
            }
        }
        return total;
    }

    public boolean DetectableIllegalCargo() {
        int illegalCargo = 0;
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            if (Constants.TradeItems[i].isIllegal()) {
                illegalCargo += Cargo()[i];
            }
        }

        return 0 < (illegalCargo - HiddenCargoBays());
    }

    public boolean DetectableIllegalCargoOrPassengers() {
        return DetectableIllegalCargo() || IllegalSpecialCargo();
    }

    public boolean Disableable() {
        return !CommandersShip() && ShipType.Bottle != Type() && ShipType.Mantis != Type() && ShipType.SpaceMonster != Type();
    }

    public int Engineer() {
        return Skills()[SkillType.Engineer.getId()];
    }

    public int ExtraCargoBays() {
        int bays = 0;
        for (Gadget gadget : gadgets) {
            if (null != gadget && GadgetType.ExtraCargoBays == gadget.Type()) {
                bays += 5;
            }
        }
        return bays;
    }

    public int Fighter() {
        return Skills()[SkillType.Fighter.getId()];
    }

    // Changed the semantics of Filled versus total Cargo Bays. Bays used for transporting special items
    // are now included in the total bays and in the filled bays. JAF
    public int FilledCargoBays() {
        int filled = FilledNormalCargoBays();
        if (CommandersShip() && SpecialEvent.StatusJaporiInTransit == Game.getCurrentGame().getQuestStatusJapori()) {
            filled += 10;
        }
        if (ReactorOnBoard()) {
            filled += 5 + 10 - (Game.getCurrentGame().getQuestStatusReactor() - 1) / 2;
        }
        return filled;
    }

    public int FilledNormalCargoBays() {
        int filled = 0;
        for (int cargo : cargo) {
            filled += cargo;
        }
        return filled;
    }

    public int FreeCargoBays() {
        return CargoBays() - FilledCargoBays();
    }

    public int FreeCrewQuarters() {
        int count = 0;
        for (int i = 0; i < Crew().length; i++) {
            if (null == Crew()[i]) {
                count++;
            }
        }
        return count;
    }

    public int FreeSlots() {
        return FreeSlotsGadget() + FreeSlotsShield() + FreeSlotsWeapon();
    }

    public int FreeSlotsGadget() {
        int count = 0;
        for (Gadget gadget : gadgets) {
            if (null == gadget) {
                count++;
            }
        }
        return count;
    }

    public int FreeSlotsShield() {
        int count = 0;
        for (Shield shield : shields) {
            if (null == shield) {
                count++;
            }
        }
        return count;
    }

    public int FreeSlotsWeapon() {
        int count = 0;
        for (Weapon weapon : weapons) {
            if (null == weapon) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int FuelTanks() {
        return super.FuelTanks() + (HasGadget(GadgetType.FuelCompactor) ? Constants.FuelCompactorTanks : 0);
    }

    public Gadget[] Gadgets() {
        return gadgets;
    }

    public boolean HagglingComputerOnBoard() {
        return CommandersShip() && SpecialEvent.StatusJarekDone == Game.getCurrentGame().getQuestStatusJarek();
    }

    public int HiddenCargoBays() {
        int bays = 0;
        for (Gadget gadget : gadgets) {
            if (null != gadget && GadgetType.HiddenCargoBays == gadget.Type()) {
                bays += 5;
            }
        }
        return bays;
    }

    public String HullText() {
        return Functions.StringVars(Strings.EncounterHullStrength, Functions.FormatNumber((int) Math.floor((double) 100 * hull / HullStrength())));
    }

    public boolean IllegalSpecialCargo() {
        return WildOnBoard() || ReactorOnBoard() || SculptureOnBoard();
    }

    public boolean JarekOnBoard() {
        return HasCrew(CrewMemberId.Jarek);
    }

    public int Pilot() {
        return Skills()[SkillType.Pilot.getId()];
    }

    public boolean PrincessOnBoard() {
        return HasCrew(CrewMemberId.Princess);
    }

    public boolean ReactorOnBoard() {
        int status = Game.getCurrentGame().getQuestStatusReactor();
        return CommandersShip() && SpecialEvent.StatusReactorNotStarted < status && SpecialEvent.StatusReactorDelivered > status;
    }

    public boolean SculptureOnBoard() {
        return CommandersShip() && SpecialEvent.StatusSculptureInTransit == Game.getCurrentGame().getQuestStatusSculpture();
    }

    public int ShieldCharge() {
        int total = 0;
        for (Shield shield : shields) {
            if (null != shield) {
                total += shield.getCharge();
            }
        }
        return total;
    }

    public Shield[] Shields() {
        return shields;
    }

    public int ShieldStrength() {
        int total = 0;
        for (Shield shield : shields) {
            if (null != shield) {
                total += shield.Power();
            }
        }
        return total;
    }

    public String ShieldText() {
        return (0 < shields.length && null != shields[0])
                ? Functions.StringVars(Strings.EncounterShieldStrength, Functions.FormatNumber((int) Math.floor((double) 100 * ShieldCharge() / ShieldStrength())))
                : Strings.EncounterShieldNone;
    }

    public int[] Skills() {
        int[] skills = new int[4];
        // Get the best skill value among the crew for each skill.
        for (int skill = 0; skill < skills.length; skill++) {
            int max = 1;
            for (int crew = 0; crew < Crew().length; crew++) {
                if (null != Crew()[crew] && Crew()[crew].Skills()[skill] > max) {
                    max = Crew()[crew].Skills()[skill];
                }
            }
            skills[skill] = Math.max(1, Functions.adjustSkillForDifficulty(max));
        }
        // Adjust skills based on any gadgets on board.
        for (Gadget gadget : gadgets) {
            if (null != gadget && SkillType.NA != gadget.SkillBonus()) {
                skills[gadget.SkillBonus().getId()] += Constants.SkillBonus;
            }
        }
        return skills;
    }

    // Crew members that are not hired/fired - Commander, Jarek, Princess, and Wild - JAF
    public CrewMember[] SpecialCrew() {
        ArrayList<CrewMember> list = new ArrayList<>();
        for (int i = 0; i < Crew().length; i++) {
            if (null != Crew()[i] && Util.arrayContains(Constants.SpecialCrewMemberIds, Crew()[i].Id())) {
                list.add(Crew()[i]);
            }
        }
        CrewMember[] crew = new CrewMember[list.size()];
        for (int i = 0; i < crew.length; i++) {
            crew[i] = list.get(i);
        }
        return crew;
    }

    // Sort all cargo based on value and put some of it in hidden bays, if they are present.
    public ArrayList<Integer> StealableCargo() {
        // Put all the cargo items in a list and sort it. Reverse it so the most expensive items are first.
        ArrayList<Integer> tradeItems = new ArrayList<>();
        for (int tradeItem = 0; tradeItem < Cargo().length; tradeItem++) {
            for (int count = 0; count < Cargo()[tradeItem]; count++) {
                tradeItems.add(tradeItem);
            }
        }
        Collections.sort(tradeItems);
        Collections.reverse(tradeItems);
        int hidden = HiddenCargoBays();
        if (PrincessOnBoard()) {
            hidden--;
        }
        if (SculptureOnBoard()) {
            hidden--;
        }
        if (0 < hidden) {
            tradeItems.subList(0, hidden).clear();
        }
        return tradeItems;
    }

    public boolean[] TradeableItems() {
        return tradeableItems;
    }

    public int Trader() {
        return Skills()[SkillType.Trader.getId()] + (HagglingComputerOnBoard() ? 1 : 0);
    }

    public Weapon[] Weapons() {
        return weapons;
    }

    public boolean WildOnBoard() {
        return HasCrew(CrewMemberId.Wild);
    }
}
