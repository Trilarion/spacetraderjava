package org.spacetrader.model.ship;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.SerializableObject;
import org.spacetrader.model.enums.Activity;
import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.model.ship.equipment.EquipmentType;
import org.spacetrader.ui.Strings;
import org.winforms.image.Image;

import java.util.Hashtable;

public class ShipSpec extends SerializableObject {
    private Activity pirates = Activity.NA;
    private Activity police = Activity.NA;
    private Activity traders = Activity.NA;
    private ShipSize size = ShipSize.Tiny;
    private ShipType type = ShipType.Custom;
    private TechLevel minTech = TechLevel.t8;
    private boolean isHullUpgraded;
    private int cargoBays;
    private int weaponSlots;
    private int shieldSlots;
    private int gadgetSlots;
    private int crewQuarters;
    private int fuelTanks;
    private int fuelCost;
    private int hullStrength;
    private int repairCost;
    private int price;
    private int occurrence;
    private int imageIndex = Constants.ShipImgUseDefault;

    public ShipSpec() {
    }

    public ShipSpec(final ShipType type, final ShipSize size, final int cargoBays, final int weaponSlots, final int shieldSlots, final int gadgetSlots, final int crewQuarters, final int fuelTanks,
                    final int fuelCost, final int hullStrength, final int repairCost, final int price, final int occurrence, final Activity police, final Activity pirates, final Activity traders, final TechLevel minTechLevel) {
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

    public ShipSpec(final Hashtable hash) {
        super(hash);
        type = ShipType.FromInt(SerializableObject.GetValueFromHash(hash, "_type", type, Integer.class));
        size = ShipSize.FromInt(SerializableObject.GetValueFromHash(hash, "_size", size, Integer.class));
        cargoBays = SerializableObject.GetValueFromHash(hash, "_cargoBays", cargoBays);
        weaponSlots = SerializableObject.GetValueFromHash(hash, "_weaponSlots", weaponSlots);
        shieldSlots = SerializableObject.GetValueFromHash(hash, "_shieldSlots", shieldSlots);
        gadgetSlots = SerializableObject.GetValueFromHash(hash, "_gadgetSlots", gadgetSlots);
        crewQuarters = SerializableObject.GetValueFromHash(hash, "_crewQuarters", crewQuarters);
        fuelTanks = SerializableObject.GetValueFromHash(hash, "_fuelTanks", fuelTanks);
        fuelCost = SerializableObject.GetValueFromHash(hash, "_fuelCost", fuelCost);
        hullStrength = SerializableObject.GetValueFromHash(hash, "_hullStrength", hullStrength);
        repairCost = SerializableObject.GetValueFromHash(hash, "_repairCost", repairCost);
        price = SerializableObject.GetValueFromHash(hash, "_price", price);
        occurrence = SerializableObject.GetValueFromHash(hash, "_occurrence", occurrence);
        police = Activity.fromId(SerializableObject.GetValueFromHash(hash, "_police", police, Integer.class));
        pirates = Activity.fromId(SerializableObject.GetValueFromHash(hash, "_pirates", pirates, Integer.class));
        traders = Activity.fromId(SerializableObject.GetValueFromHash(hash, "_traders", traders, Integer.class));
        minTech = TechLevel.FromInt(SerializableObject.GetValueFromHash(hash, "_minTech", /*_minTech*/0, Integer.class));
        isHullUpgraded = SerializableObject.GetValueFromHash(hash, "_hullUpgraded", isHullUpgraded);
        imageIndex = SerializableObject.GetValueFromHash(hash, "_imageIndex", Constants.ShipImgUseDefault);
        // Get the images if the ship uses the custom images.
        if (imageIndex == ShipType.Custom.getId()) {
            Game.getCurrentGame().getParentWindow().setCustomShipImages(SerializableObject.GetValueFromHash(hash, "_images", Game.getCurrentGame().getParentWindow().CustomShipImages()));
        }
        // Get the name if the ship is a custom design.
        if (type == ShipType.Custom) {
            Strings.ShipNames[ShipType.Custom.getId()] = SerializableObject.GetValueFromHash(hash, "_name", Strings.ShipNames[ShipType.Custom.getId()]);
            Constants.ShipSpecs[ShipType.Custom.getId()] = new ShipSpec(
                    type, size, cargoBays, weaponSlots, shieldSlots, gadgetSlots, crewQuarters, fuelTanks,
                    fuelCost, hullStrength, repairCost, price, occurrence, police, pirates, traders, minTech);
            UpdateCustomImageOffsetConstants();
        }
    }

    @Override
    public Hashtable Serialize() {
        final Hashtable hash = super.Serialize();
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
        hash.put("_occurrence", occurrence);
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

    protected void SetValues(final ShipType type) {
        final int typeInt = type.getId();
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

    public int Slots(final EquipmentType type) {
        int count = 0;
        switch (type) {
            case Weapon:
                count = weaponSlots;
                break;
            case Shield:
                count = shieldSlots;
                break;
            case Gadget:
                count = gadgetSlots;
                break;
        }
        return count;
    }

    public void UpdateCustomImageOffsetConstants() {
        final Image image = Game.getCurrentGame().getParentWindow().CustomShipImages()[0];
        final int custIndex = ShipType.Custom.getId();
        // Find the first column of pixels that has a non-white pixel for the X value, and the last column for the width.
        final int x = ModelUtils.GetColumnOfFirstNonWhitePixel(image, 1);
        final int width = ModelUtils.GetColumnOfFirstNonWhitePixel(image, -1) - x + 1;
        Constants.ShipImageOffsets[custIndex].x = Math.max(2, x);
        Constants.ShipImageOffsets[custIndex].width = Math.min(62 - Constants.ShipImageOffsets[custIndex].x, width);
    }

    public int CargoBays() {
        return cargoBays;
    }

    public void CargoBays(final int value) {
        cargoBays = value;
    }

    public int FuelTanks() {
        return fuelTanks;
    }

    public void FuelTanks(final int value) {
        fuelTanks = value;
    }

    public int getWeaponSlots() {
        return weaponSlots;
    }

    public void setWeaponSlots(final int weaponSlots) {
        this.weaponSlots = weaponSlots;
    }

    public ShipSize getSize() {
        return size;
    }

    public void setSize(final ShipSize size) {
        this.size = size;
    }

    public int getShieldSlots() {
        return shieldSlots;
    }

    public void setShieldSlots(final int shieldSlots) {
        this.shieldSlots = shieldSlots;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(final int repairCost) {
        this.repairCost = repairCost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public boolean getHullUpgraded() {
        return isHullUpgraded;
    }

    public void setHullUpgraded(final boolean hullUpgraded) {
        isHullUpgraded = hullUpgraded;
    }

    public int getGadgetSlots() {
        return gadgetSlots;
    }

    public void setGadgetSlots(final int gadgetSlots) {
        this.gadgetSlots = gadgetSlots;
    }

    public int getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(final int fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getCrewQuarters() {
        return crewQuarters;
    }

    public void setCrewQuarters(final int crewQuarters) {
        this.crewQuarters = crewQuarters;
    }

    public int HullStrength() {
        return hullStrength + (isHullUpgraded ? Constants.HullUpgrade : 0);
    }

    public void HullStrength(final int value) {
        hullStrength = value;
    }

    public Image Image() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetNormal];
    }

    public Image ImageDamaged() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetDamage];
    }

    public Image ImageDamagedWithShields() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetShieldDamage];
    }

    public int ImageIndex() {
        return (imageIndex == Constants.ShipImgUseDefault ? Type().getId() : imageIndex);
    }

    public void ImageIndex(final int value) {
        imageIndex = (value == Type().getId() ? Constants.ShipImgUseDefault : value);
    }

    public Image ImageWithShields() {
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
