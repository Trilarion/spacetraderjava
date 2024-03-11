package org.spacetrader.model.ship;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.SerializableObject;
import org.spacetrader.model.enums.Activity;
import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.model.ship.equipment.EquipmentType;
import org.spacetrader.ui.Strings;
import org.winforms.wfImage;

import java.util.Hashtable;

// TODO part of the model
public class ShipSpec extends SerializableObject {
    private Activity pirates = Activity.NA;
    private Activity police = Activity.NA;
    private Activity traders = Activity.NA;
    private ShipSize size = ShipSize.Tiny;
    private ShipType type = ShipType.Custom;
    private TechLevel minTech = TechLevel.t8;
    private boolean isHullUpgraded = false;
    private int cargoBays = 0;
    private int weaponSlots = 0;
    private int shieldSlots = 0;
    private int gadgetSlots = 0;
    private int crewQuarters = 0;
    private int fuelTanks = 0;
    private int fuelCost = 0;
    private int hullStrength = 0;
    private int repairCost = 0;
    private int price = 0;
    private int occurrence = 0;
    private int imageIndex = Constants.ShipImgUseDefault;

    public ShipSpec() {
    }

    public ShipSpec(ShipType type, ShipSize size, int cargoBays, int weaponSlots, int shieldSlots, int gadgetSlots, int crewQuarters, int fuelTanks,
                    int fuelCost, int hullStrength, int repairCost, int price, int occurrence, Activity police, Activity pirates, Activity traders, TechLevel minTechLevel) {
        this.type = type;
        this.size = size;
        this.cargoBays = cargoBays;
        this.weaponSlots = weaponSlots;
        this.shieldSlots = shieldSlots;
        this.gadgetSlots = gadgetSlots;
        this.crewQuarters = crewQuarters;
        this.fuelTanks = fuelTanks;
        this.fuelCost = fuelCost;
        this.hullStrength = hullStrength;
        this.repairCost = repairCost;
        this.price = price;
        this.occurrence = occurrence;
        this.police = police;
        this.pirates = pirates;
        this.traders = traders;
        minTech = minTechLevel;
    }

    public ShipSpec(Hashtable hash) {
        super(hash);
        type = ShipType.FromInt(GetValueFromHash(hash, "_type", type, Integer.class));
        size = ShipSize.FromInt(GetValueFromHash(hash, "_size", size, Integer.class));
        cargoBays = GetValueFromHash(hash, "_cargoBays", cargoBays);
        weaponSlots = GetValueFromHash(hash, "_weaponSlots", weaponSlots);
        shieldSlots = GetValueFromHash(hash, "_shieldSlots", shieldSlots);
        gadgetSlots = GetValueFromHash(hash, "_gadgetSlots", gadgetSlots);
        crewQuarters = GetValueFromHash(hash, "_crewQuarters", crewQuarters);
        fuelTanks = GetValueFromHash(hash, "_fuelTanks", fuelTanks);
        fuelCost = GetValueFromHash(hash, "_fuelCost", fuelCost);
        hullStrength = GetValueFromHash(hash, "_hullStrength", hullStrength);
        repairCost = GetValueFromHash(hash, "_repairCost", repairCost);
        price = GetValueFromHash(hash, "_price", price);
        occurrence = GetValueFromHash(hash, "_occurrentrence", occurrence);
        police = Activity.fromId(GetValueFromHash(hash, "_police", police, Integer.class));
        pirates = Activity.fromId(GetValueFromHash(hash, "_pirates", pirates, Integer.class));
        traders = Activity.fromId(GetValueFromHash(hash, "_traders", traders, Integer.class));
        minTech = TechLevel.FromInt(GetValueFromHash(hash, "_minTech", /*_minTech*/0, Integer.class));
        isHullUpgraded = GetValueFromHash(hash, "_hullUpgraded", isHullUpgraded);
        imageIndex = GetValueFromHash(hash, "_imageIndex", Constants.ShipImgUseDefault);
        // Get the images if the ship uses the custom images.
        if (imageIndex == ShipType.Custom.getId()) {
            Game.getCurrentGame().getParentWindow().setCustomShipImages(GetValueFromHash(hash, "_images", Game.getCurrentGame().getParentWindow().CustomShipImages()));
        }
        // Get the name if the ship is a custom design.
        if (type == ShipType.Custom) {
            Strings.ShipNames[ShipType.Custom.getId()] = GetValueFromHash(hash, "_name", Strings.ShipNames[ShipType.Custom.getId()]);
            Constants.ShipSpecs[ShipType.Custom.getId()] = new ShipSpec(
                    type, size, cargoBays, weaponSlots, shieldSlots, gadgetSlots, crewQuarters, fuelTanks,
                    fuelCost, hullStrength, repairCost, price, occurrence, police, pirates, traders, minTech);
            UpdateCustomImageOffsetConstants();
        }
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_type", type.getId());
        hash.put("_size", size.getId());
        hash.put("_cargoBays", cargoBays);
        hash.put("_weaponSlots", weaponSlots);
        hash.put("_shieldSlots", shieldSlots);
        hash.put("_gadgetSlots", gadgetSlots);
        hash.put("_crewQuarters", crewQuarters);
        hash.put("_fuelTanks", fuelTanks);
        hash.put("_fuelCost", fuelCost);
        hash.put("_hullStrength", hullStrength);
        hash.put("_repairCost", repairCost);
        hash.put("_price", price);
        hash.put("_occurrentrence", occurrence);
        hash.put("_police", police.getId());
        hash.put("_pirates", pirates.getId());
        hash.put("_traders", traders.getId());
        hash.put("_minTech", minTech.ordinal());
        hash.put("_hullUpgraded", isHullUpgraded);
        // Only save image index if it's not the default.
        if (imageIndex != Constants.ShipImgUseDefault) {
            hash.put("_imageIndex", imageIndex);
        }
        // Save the name if the ship is a custom design.
        if (Type() == ShipType.Custom) {
            hash.put("_name", Name());
        }
        // Save the images if the ship uses the custom images.
        if (ImageIndex() == ShipType.Custom.getId()) {
            hash.put("_images", Game.getCurrentGame().getParentWindow().CustomShipImages());
        }
        return hash;
    }

    protected void SetValues(ShipType type) {
        int typeInt = type.getId();
        this.type = type;
        size = Constants.ShipSpecs[typeInt].size;
        cargoBays = Constants.ShipSpecs[typeInt].cargoBays;
        weaponSlots = Constants.ShipSpecs[typeInt].weaponSlots;
        shieldSlots = Constants.ShipSpecs[typeInt].shieldSlots;
        gadgetSlots = Constants.ShipSpecs[typeInt].gadgetSlots;
        crewQuarters = Constants.ShipSpecs[typeInt].crewQuarters;
        fuelTanks = Constants.ShipSpecs[typeInt].fuelTanks;
        fuelCost = Constants.ShipSpecs[typeInt].fuelCost;
        hullStrength = Constants.ShipSpecs[typeInt].hullStrength;
        repairCost = Constants.ShipSpecs[typeInt].repairCost;
        price = Constants.ShipSpecs[typeInt].price;
        occurrence = Constants.ShipSpecs[typeInt].occurrence;
        police = Constants.ShipSpecs[typeInt].police;
        pirates = Constants.ShipSpecs[typeInt].pirates;
        traders = Constants.ShipSpecs[typeInt].traders;
        minTech = Constants.ShipSpecs[typeInt].minTech;
        isHullUpgraded = Constants.ShipSpecs[typeInt].isHullUpgraded;
        imageIndex = Constants.ShipSpecs[typeInt].imageIndex;
    }

    public int Slots(EquipmentType type) {
        int count = 0;
        switch (type) {
            case Weapon:
                count = getWeaponSlots();
                break;
            case Shield:
                count = getShieldSlots();
                break;
            case Gadget:
                count = getGadgetSlots();
                break;
        }
        return count;
    }

    public void UpdateCustomImageOffsetConstants() {
        wfImage image = Game.getCurrentGame().getParentWindow().CustomShipImages()[0];
        int custIndex = ShipType.Custom.getId();
        // Find the first column of pixels that has a non-white pixel for the X value, and the last column for the width.
        int x = Functions.GetColumnOfFirstNonWhitePixel(image, 1);
        int width = Functions.GetColumnOfFirstNonWhitePixel(image, -1) - x + 1;
        Constants.ShipImageOffsets[custIndex].X = Math.max(2, x);
        Constants.ShipImageOffsets[custIndex].Width = Math.min(62 - Constants.ShipImageOffsets[custIndex].X, width);
    }

    public int CargoBays() {
        return cargoBays;
    }

    public void CargoBays(int value) {
        cargoBays = value;
    }

    public int FuelTanks() {
        return fuelTanks;
    }

    public void FuelTanks(int value) {
        fuelTanks = value;
    }

    public int getWeaponSlots() {
        return weaponSlots;
    }

    public void setWeaponSlots(int weaponSlots) {
        this.weaponSlots = weaponSlots;
    }

    public ShipSize getSize() {
        return size;
    }

    public void setSize(ShipSize size) {
        this.size = size;
    }

    public int getShieldSlots() {
        return shieldSlots;
    }

    public void setShieldSlots(int shieldSlots) {
        this.shieldSlots = shieldSlots;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getHullUpgraded() {
        return isHullUpgraded;
    }

    public void setHullUpgraded(boolean hullUpgraded) {
        isHullUpgraded = hullUpgraded;
    }

    public int getGadgetSlots() {
        return gadgetSlots;
    }

    public void setGadgetSlots(int gadgetSlots) {
        this.gadgetSlots = gadgetSlots;
    }

    public int getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(int fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getCrewQuarters() {
        return crewQuarters;
    }

    public void setCrewQuarters(int crewQuarters) {
        this.crewQuarters = crewQuarters;
    }

    public int HullStrength() {
        return hullStrength + (getHullUpgraded() ? Constants.HullUpgrade : 0);
    }

    public void HullStrength(int value) {
        hullStrength = value;
    }

    public wfImage Image() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetNormal];
    }

    public wfImage ImageDamaged() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetDamage];
    }

    public wfImage ImageDamagedWithShields() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetShieldDamage];
    }

    public int ImageIndex() {
        return (imageIndex == Constants.ShipImgUseDefault ? Type().getId() : imageIndex);
    }

    public void ImageIndex(int value) {
        imageIndex = (value == Type().getId() ? Constants.ShipImgUseDefault : value);
    }

    public wfImage ImageWithShields() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetShield];
    }

    public TechLevel MinimumTechLevel() {
        return minTech;
    }

    public String Name() {
        return Strings.ShipNames[Type().getId()];
    }

    public int getOccurrence() {
        return occurrence;
    }

    public Activity Police() {
        return police;
    }

    public Activity Pirates() {
        return pirates;
    }

    public Activity Traders() {
        return traders;
    }

    public ShipType Type() {
        return type;
    }
}
