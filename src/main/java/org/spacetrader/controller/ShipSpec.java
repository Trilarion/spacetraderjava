package org.spacetrader.controller;

import org.spacetrader.controller.enums.Activity;
import org.spacetrader.model.TechLevel;
import org.spacetrader.model.ship.ShipSize;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.model.ship.equipment.EquipmentType;
import org.spacetrader.ui.Strings;
import org.winforms.wfImage;

import java.util.Hashtable;

// TODO part of the model
public class ShipSpec extends SerializableObject {
    private Activity _pirates = Activity.NA;
    private Activity _police = Activity.NA;
    private Activity _traders = Activity.NA;
    private ShipSize _size = ShipSize.Tiny;
    private ShipType _type = ShipType.Custom;
    private TechLevel _minTech = TechLevel.t8;
    private boolean _hullUpgraded = false;
    private int _cargoBays = 0;
    private int _weaponSlots = 0;
    private int _shieldSlots = 0;
    private int _gadgetSlots = 0;
    private int _crewQuarters = 0;
    private int _fuelTanks = 0;
    private int _fuelCost = 0;
    private int _hullStrength = 0;
    private int _repairCost = 0;
    private int _price = 0;
    private int _occurrentrence = 0;
    private int _imageIndex = Constants.ShipImgUseDefault;

    public ShipSpec() {
    }

    public ShipSpec(ShipType type, ShipSize size, int cargoBays, int weaponSlots, int shieldSlots, int gadgetSlots, int crewQuarters, int fuelTanks,
                    int fuelCost, int hullStrength, int repairCost, int price, int occurrentrence, Activity police, Activity pirates, Activity traders, TechLevel minTechLevel) {
        _type = type;
        _size = size;
        _cargoBays = cargoBays;
        _weaponSlots = weaponSlots;
        _shieldSlots = shieldSlots;
        _gadgetSlots = gadgetSlots;
        _crewQuarters = crewQuarters;
        _fuelTanks = fuelTanks;
        _fuelCost = fuelCost;
        _hullStrength = hullStrength;
        _repairCost = repairCost;
        _price = price;
        _occurrentrence = occurrentrence;
        _police = police;
        _pirates = pirates;
        _traders = traders;
        _minTech = minTechLevel;
    }

    public ShipSpec(Hashtable hash) {
        super(hash);
        _type = ShipType.FromInt(GetValueFromHash(hash, "_type", _type, Integer.class));
        _size = ShipSize.FromInt(GetValueFromHash(hash, "_size", _size, Integer.class));
        _cargoBays = GetValueFromHash(hash, "_cargoBays", _cargoBays);
        _weaponSlots = GetValueFromHash(hash, "_weaponSlots", _weaponSlots);
        _shieldSlots = GetValueFromHash(hash, "_shieldSlots", _shieldSlots);
        _gadgetSlots = GetValueFromHash(hash, "_gadgetSlots", _gadgetSlots);
        _crewQuarters = GetValueFromHash(hash, "_crewQuarters", _crewQuarters);
        _fuelTanks = GetValueFromHash(hash, "_fuelTanks", _fuelTanks);
        _fuelCost = GetValueFromHash(hash, "_fuelCost", _fuelCost);
        _hullStrength = GetValueFromHash(hash, "_hullStrength", _hullStrength);
        _repairCost = GetValueFromHash(hash, "_repairCost", _repairCost);
        _price = GetValueFromHash(hash, "_price", _price);
        _occurrentrence = GetValueFromHash(hash, "_occurrentrence", _occurrentrence);
        _police = Activity.FromInt(GetValueFromHash(hash, "_police", _police, Integer.class));
        _pirates = Activity.FromInt(GetValueFromHash(hash, "_pirates", _pirates, Integer.class));
        _traders = Activity.FromInt(GetValueFromHash(hash, "_traders", _traders, Integer.class));
        _minTech = TechLevel.FromInt(GetValueFromHash(hash, "_minTech", /*_minTech*/0, Integer.class));
        _hullUpgraded = GetValueFromHash(hash, "_hullUpgraded", _hullUpgraded);
        _imageIndex = GetValueFromHash(hash, "_imageIndex", Constants.ShipImgUseDefault);
        // Get the images if the ship uses the custom images.
        if (_imageIndex == ShipType.Custom.CastToInt()) {
            Game.getCurrentGame().getParentWindow().setCustomShipImages(GetValueFromHash(hash, "_images", Game.getCurrentGame().getParentWindow().CustomShipImages()));
        }
        // Get the name if the ship is a custom design.
        if (_type == ShipType.Custom) {
            Strings.ShipNames[ShipType.Custom.CastToInt()] = GetValueFromHash(hash, "_name", Strings.ShipNames[ShipType.Custom.CastToInt()]);
            Constants.ShipSpecs[ShipType.Custom.CastToInt()] = new ShipSpec(
                    _type, _size, _cargoBays, _weaponSlots, _shieldSlots, _gadgetSlots, _crewQuarters, _fuelTanks,
                    _fuelCost, _hullStrength, _repairCost, _price, _occurrentrence, _police, _pirates, _traders, _minTech);
            UpdateCustomImageOffsetConstants();
        }
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_type", _type.CastToInt());
        hash.put("_size", _size.CastToInt());
        hash.put("_cargoBays", _cargoBays);
        hash.put("_weaponSlots", _weaponSlots);
        hash.put("_shieldSlots", _shieldSlots);
        hash.put("_gadgetSlots", _gadgetSlots);
        hash.put("_crewQuarters", _crewQuarters);
        hash.put("_fuelTanks", _fuelTanks);
        hash.put("_fuelCost", _fuelCost);
        hash.put("_hullStrength", _hullStrength);
        hash.put("_repairCost", _repairCost);
        hash.put("_price", _price);
        hash.put("_occurrentrence", _occurrentrence);
        hash.put("_police", _police.CastToInt());
        hash.put("_pirates", _pirates.CastToInt());
        hash.put("_traders", _traders.CastToInt());
        hash.put("_minTech", _minTech.ordinal());
        hash.put("_hullUpgraded", _hullUpgraded);
        // Only save image index if it's not the default.
        if (_imageIndex != Constants.ShipImgUseDefault) {
            hash.put("_imageIndex", _imageIndex);
        }
        // Save the name if the ship is a custom design.
        if (Type() == ShipType.Custom) {
            hash.put("_name", Name());
        }
        // Save the images if the ship uses the custom images.
        if (ImageIndex() == ShipType.Custom.CastToInt()) {
            hash.put("_images", Game.getCurrentGame().getParentWindow().CustomShipImages());
        }
        return hash;
    }

    protected void SetValues(ShipType type) {
        int typeInt = type.CastToInt();
        _type = type;
        _size = Constants.ShipSpecs[typeInt]._size;
        _cargoBays = Constants.ShipSpecs[typeInt]._cargoBays;
        _weaponSlots = Constants.ShipSpecs[typeInt]._weaponSlots;
        _shieldSlots = Constants.ShipSpecs[typeInt]._shieldSlots;
        _gadgetSlots = Constants.ShipSpecs[typeInt]._gadgetSlots;
        _crewQuarters = Constants.ShipSpecs[typeInt]._crewQuarters;
        _fuelTanks = Constants.ShipSpecs[typeInt]._fuelTanks;
        _fuelCost = Constants.ShipSpecs[typeInt]._fuelCost;
        _hullStrength = Constants.ShipSpecs[typeInt]._hullStrength;
        _repairCost = Constants.ShipSpecs[typeInt]._repairCost;
        _price = Constants.ShipSpecs[typeInt]._price;
        _occurrentrence = Constants.ShipSpecs[typeInt]._occurrentrence;
        _police = Constants.ShipSpecs[typeInt]._police;
        _pirates = Constants.ShipSpecs[typeInt]._pirates;
        _traders = Constants.ShipSpecs[typeInt]._traders;
        _minTech = Constants.ShipSpecs[typeInt]._minTech;
        _hullUpgraded = Constants.ShipSpecs[typeInt]._hullUpgraded;
        _imageIndex = Constants.ShipSpecs[typeInt]._imageIndex;
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
        int custIndex = ShipType.Custom.CastToInt();
        // Find the first column of pixels that has a non-white pixel for the X value, and the last column for the width.
        int x = Functions.GetColumnOfFirstNonWhitePixel(image, 1);
        int width = Functions.GetColumnOfFirstNonWhitePixel(image, -1) - x + 1;
        Constants.ShipImageOffsets[custIndex].X = Math.max(2, x);
        Constants.ShipImageOffsets[custIndex].Width = Math.min(62 - Constants.ShipImageOffsets[custIndex].X, width);
    }

    public int CargoBays() {
        return _cargoBays;
    }

    public void CargoBays(int value) {
        _cargoBays = value;
    }

    public int FuelTanks() {
        return _fuelTanks;
    }

    public void FuelTanks(int value) {
        _fuelTanks = value;
    }

    public int getWeaponSlots() {
        return _weaponSlots;
    }

    public void setWeaponSlots(int weaponSlots) {
        _weaponSlots = weaponSlots;
    }

    public ShipSize getSize() {
        return _size;
    }

    public void setSize(ShipSize size) {
        _size = size;
    }

    public int getShieldSlots() {
        return _shieldSlots;
    }

    public void setShieldSlots(int shieldSlots) {
        _shieldSlots = shieldSlots;
    }

    public int getRepairCost() {
        return _repairCost;
    }

    public void setRepairCost(int repairCost) {
        _repairCost = repairCost;
    }

    public int getPrice() {
        return _price;
    }

    public void setPrice(int price) {
        _price = price;
    }

    public boolean getHullUpgraded() {
        return _hullUpgraded;
    }

    public void setHullUpgraded(boolean hullUpgraded) {
        _hullUpgraded = hullUpgraded;
    }

    public int getGadgetSlots() {
        return _gadgetSlots;
    }

    public void setGadgetSlots(int gadgetSlots) {
        _gadgetSlots = gadgetSlots;
    }

    public int getFuelCost() {
        return _fuelCost;
    }

    public void setFuelCost(int fuelCost) {
        _fuelCost = fuelCost;
    }

    public int getCrewQuarters() {
        return _crewQuarters;
    }

    public void setCrewQuarters(int crewQuarters) {
        _crewQuarters = crewQuarters;
    }

    public int HullStrength() {
        return _hullStrength + (getHullUpgraded() ? Constants.HullUpgrade : 0);
    }

    public void HullStrength(int value) {
        _hullStrength = value;
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
        return (_imageIndex == Constants.ShipImgUseDefault ? Type().CastToInt() : _imageIndex);
    }

    public void ImageIndex(int value) {
        _imageIndex = (value == Type().CastToInt() ? Constants.ShipImgUseDefault : value);
    }

    public wfImage ImageWithShields() {
        return Game.getCurrentGame().getParentWindow().ShipImages().getImages()[ImageIndex() * Constants.ImagesPerShip + Constants.ShipImgOffsetShield];
    }

    public TechLevel MinimumTechLevel() {
        return _minTech;
    }

    public String Name() {
        return Strings.ShipNames[Type().CastToInt()];
    }

    public int Occurrentrence() {
        return _occurrentrence;
    }

    public Activity Police() {
        return _police;
    }

    public Activity Pirates() {
        return _pirates;
    }

    public Activity Traders() {
        return _traders;
    }

    public ShipType Type() {
        return _type;
    }
}
