package org.spacetrader.model.ship;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Game;
import org.spacetrader.model.enums.ShipyardId;
import org.spacetrader.model.enums.ShipyardSkill;
import org.spacetrader.ui.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents a shipyard orbiting a solar system in the universe.
// In a shipyard, the player can design his own ship and have it constructed, for a fee.
public class Shipyard {

    public static final int[] COST_FUEL = {1, 1, 1, 3, 5, 10};
    public static final int[] COST_HULL = {1, 5, 10, 15, 20, 40};
    public static final int[] BASE_FUEL = {15, 14, 13, 12, 11, 10};
    public static final int[] BASE_HULL = {10, 25, 50, 100, 150, 200};
    public static final int[] DESIGN_FEE = {2000, 5000, 10000, 20000, 40000, 100000};
    public static final int[] MAX_UNITS = {50, 100, 150, 200, 250, 999};
    public static final int[] PER_UNIT_FUEL = {3, 2, 1, 1, 1, 1};
    public static final int[] PER_UNIT_HULL = {35, 30, 25, 20, 15, 10};
    public static final int[] PRICE_PER_UNIT = {75, 250, 500, 750, 1000, 1200};
    public static final int[] UNITS_CREW = {20, 20, 20, 20, 20, 20};
    public static final int[] UNITS_FUEL = {1, 1, 1, 5, 10, 15};
    public static final int[] UNITS_GADGET = {5, 5, 5, 5, 5, 5};
    public static final int[] UNITS_HULL = {1, 2, 3, 4, 5, 6};
    public static final int[] UNITS_SHIELD = {10, 10, 10, 8, 8, 8};
    public static final int[] UNITS_WEAPON = {15, 15, 15, 10, 10, 10};
    // Fee and Price Per Unit 10% less for the specialty size, and 10% more for sizes more than 1 away from the specialty size.
    public static final int ADJUST_SIZE_DEFAULT = 100;
    public static final int ADJUST_SIZE_SPECIALTY = 90;
    public static final int ADJUST_SIZE_WEAKNESS = 110;
    // One of the costs will be adjusted based on the shipyard's skill.
    public static final int ADJUST_SKILL_CREW = 2;
    public static final int ADJUST_SKILL_FUEL = 2;
    public static final int ADJUST_SKILL_HULL = 5;
    public static final int ADJUST_SKILL_SHIELD = 2;
    public static final int ADJUST_SKILL_WEAPON = 2;
    // There is a crowding penalty for coming too close to the maximum. A modest penalty is imposed at one level, and a more severe penalty at a higher level.
    public static final int PENALTY_FIRST_PCT = 80;
    public static final int PENALTY_FIRST_FEE = 25;
    public static final int PENALTY_SECOND_PCT = 90;
    public static final int PENALTY_SECOND_FEE = 75;
    private final ShipyardId _id;
    private final ShipSize _specialtySize;
    private final ShipyardSkill _skill;
    // Internal Variables
    private int modCrew;
    private int modFuel;
    private int modHull;
    private int modShield;
    private int modWeapon;

    public Shipyard(ShipyardId si, ShipSize ss, ShipyardSkill ys) {
        _id = si;
        _specialtySize = ss;
        _skill = ys;
        switch (_skill) {
            case CrewQuarters:
                modCrew = ADJUST_SKILL_CREW;
                break;
            case FuelBase:
                modFuel = ADJUST_SKILL_FUEL;
                break;
            case HullPerUnit:
                modHull = ADJUST_SKILL_HULL;
                break;
            case ShieldSlotUnits:
                modShield = ADJUST_SKILL_SHIELD;
                break;
            case WeaponSlotUnits:
                modWeapon = ADJUST_SKILL_WEAPON;
                break;
        }
    }

    // Calculate the ship's price (worth here, not the price paid), the fuel cost, and the repair cost.
    public void CalculateDependantVariables() {
        ShipSpec().setPrice(BasePrice() + PenaltyCost());
        ShipSpec().setFuelCost(CostFuel());
        ShipSpec().setRepairCost(CostHull());
    }

    public int AdjustedDesignFee() {
        return DESIGN_FEE[ShipSpec().getSize().getId()] * CostAdjustment() / ADJUST_SIZE_DEFAULT;
    }

    public int AdjustedPenaltyCost() {
        return PenaltyCost() * CostAdjustment() / ADJUST_SIZE_DEFAULT;
    }

    public int AdjustedPrice() {
        return BasePrice() * CostAdjustment() / ADJUST_SIZE_DEFAULT;
    }

    public List<ShipSize> AvailableSizes() {
        ArrayList<ShipSize> list = new ArrayList<>(6);
        int begin = Math.max(ShipSize.Tiny.getId(), _specialtySize.getId() - 2);
        int end = Math.min(ShipSize.Gargantuan.getId(), _specialtySize.getId() + 2);
        list.addAll(Arrays.asList(ShipSize.values()).subList(begin, end + 1));
        return list;
    }

    public int BaseFuel() {
        return BASE_FUEL[ShipSpec().getSize().getId()] + modFuel;
    }

    public int BaseHull() {
        return BASE_HULL[ShipSpec().getSize().getId()];
    }

    public int BasePrice() {
        return UnitsUsed() * PricePerUnit();
    }

    public int CostAdjustment() {
        int adjustment;
        switch (Math.abs(_specialtySize.getId() - ShipSpec().getSize().getId())) {
            case 0:
                adjustment = ADJUST_SIZE_SPECIALTY;
                break;
            case 1:
                adjustment = ADJUST_SIZE_DEFAULT;
                break;
            default:
                adjustment = ADJUST_SIZE_WEAKNESS;
                break;
        }
        return adjustment;
    }

    public int CostFuel() {
        return COST_FUEL[ShipSpec().getSize().getId()];
    }

    public int CostHull() {
        return COST_HULL[ShipSpec().getSize().getId()];
    }

    public String Engineer() {
        return Strings.ShipyardEngineers[_id.getId()];
    }

    public ShipyardId Id() {
        return _id;
    }

    public int MaxUnits() {
        return MAX_UNITS[ShipSpec().getSize().getId()];
    }

    public String Name() {
        return Strings.ShipyardNames[_id.getId()];
    }

    public int PenaltyCost() {
        int penalty = 0;
        if (PENALTY_SECOND_PCT <= PercentOfMaxUnits()) {
            penalty = PENALTY_SECOND_FEE;
        } else if (PENALTY_FIRST_PCT <= PercentOfMaxUnits()) {
            penalty = PENALTY_FIRST_FEE;
        }
        return BasePrice() * penalty / 100;
    }

    public int PercentOfMaxUnits() {
        return UnitsUsed() * 100 / MaxUnits();
    }

    public int PerUnitFuel() {
        return PER_UNIT_FUEL[ShipSpec().getSize().getId()];
    }

    public int PerUnitHull() {
        return PER_UNIT_HULL[ShipSpec().getSize().getId()] + modHull;
    }

    public int PricePerUnit() {
        return PRICE_PER_UNIT[ShipSpec().getSize().getId()];
    }

    public ShipSpec ShipSpec() {
        return Constants.ShipSpecs[ShipType.Custom.getId()];
    }

    public ShipyardSkill Skill() {
        return _skill;
    }

    public ShipSize SpecialtySize() {
        return _specialtySize;
    }

    public int TotalCost() {
        return AdjustedPrice() + AdjustedPenaltyCost() + AdjustedDesignFee() - TradeIn();
    }

    public int TradeIn() {
        return Game.getCurrentGame().Commander().getShip().Worth(false);
    }

    public int UnitsCrew() {
        return UNITS_CREW[ShipSpec().getSize().getId()] - modCrew;
    }

    public int UnitsFuel() {
        return UNITS_FUEL[ShipSpec().getSize().getId()];
    }

    public int UnitsGadgets() {
        return UNITS_GADGET[ShipSpec().getSize().getId()];
    }

    public int UnitsHull() {
        return UNITS_HULL[ShipSpec().getSize().getId()];
    }

    public int UnitsShields() {
        return UNITS_SHIELD[ShipSpec().getSize().getId()] - modShield;
    }

    public int UnitsWeapons() {
        return UNITS_WEAPON[ShipSpec().getSize().getId()] - modWeapon;
    }

    public int UnitsUsed() {
        int cargoBays = ShipSpec().CargoBays();
        int crew = ShipSpec().getCrewQuarters() * UnitsCrew();
        int fuel = (int) Math.ceil((double) (ShipSpec().FuelTanks() - BaseFuel()) / PerUnitFuel() * UnitsFuel());
        int gadgets = ShipSpec().getGadgetSlots() * UnitsGadgets();
        int hull = (ShipSpec().HullStrength() - BaseHull()) / PerUnitHull() * UnitsHull();
        int shield = ShipSpec().getShieldSlots() * UnitsShields();
        int weapons = ShipSpec().getWeaponSlots() * UnitsWeapons();
        return cargoBays + crew + fuel + gadgets + hull + shield + weapons;
    }
}
