package org.spacetrader.main;

import org.jwinforms.WfImage;
import org.spacetrader.main.util.Hashtable;
import org.spacetrader.ship.ShipSize;
import org.spacetrader.ship.ShipType;


public class ShipTemplate extends STSerializableObject implements Comparable<ShipTemplate> {
    private WfImage[] _images = null;
    private ShipSize _size = ShipSize.Tiny;
    private String _name = null;
    private int _imageIndex = ShipType.Custom.CastToInt();
    private int _cargoBays = 0;
    private int _weaponSlots = 0;
    private int _shieldSlots = 0;
    private int _gadgetSlots = 0;
    private int _crewQuarters = 0;
    private int _fuelTanks = 0;
    private int _hullStrength = 0;

    public ShipTemplate(Hashtable ht) {
        _name = GetValueFromHash(ht, "_name", _name, String.class);
        _size = (GetValueFromHash(ht, "_size", _size));
        _imageIndex = GetValueFromHash(ht, "_imageIndex", _imageIndex);
        _cargoBays = GetValueFromHash(ht, "_cargoBays", _cargoBays);
        _weaponSlots = GetValueFromHash(ht, "_weaponSlots", _weaponSlots);
        _shieldSlots = GetValueFromHash(ht, "_shieldSlots", _shieldSlots);
        _gadgetSlots = GetValueFromHash(ht, "_gadgetSlots", _gadgetSlots);
        _crewQuarters = GetValueFromHash(ht, "_crewQuarters", _crewQuarters);
        _fuelTanks = GetValueFromHash(ht, "_fuelTanks", _fuelTanks);
        _hullStrength = GetValueFromHash(ht, "_hullStrength", _hullStrength);
        _images = GetValueFromHash(ht, "_images", _images);
    }

    public ShipTemplate(ShipSize s, String t) {
        _size = s;
        _name = t;
        _images = Game.CurrentGame().getParentWindow().CustomShipImages();
    }

    public ShipTemplate(ShipSpec s, String t) {
        _name = t;
        _size = s.getSize();
        _imageIndex = s.ImageIndex();
        _cargoBays = s.CargoBays();
        _weaponSlots = s.getWeaponSlots();
        _shieldSlots = s.getShieldSlots();
        _gadgetSlots = s.getGadgetSlots();
        _crewQuarters = s.getCrewQuarters();
        _fuelTanks = s.FuelTanks();
        _hullStrength = s.HullStrength();
        if (_imageIndex == Consts.ShipImgUseDefault) {
            _images = Game.CurrentGame().getParentWindow().CustomShipImages();
        }
    }

    @Override
    public int compareTo(ShipTemplate st) {
        if (st == null) {
            return 1;
        } else {
            return _name.compareTo(st._name);
        }
    }

    @Override
    public Hashtable Serialize() {
        Hashtable ht = super.Serialize();
        ht.add("_name", _name);
        ht.add("_size", _size.CastToInt());
        ht.add("_imageIndex", _imageIndex);
        ht.add("_cargoBays", _cargoBays);
        ht.add("_weaponSlots", _weaponSlots);
        ht.add("_shieldSlots", _shieldSlots);
        ht.add("_gadgetSlots", _gadgetSlots);
        ht.add("_crewQuarters", _crewQuarters);
        ht.add("_fuelTanks", _fuelTanks);
        ht.add("_hullStrength", _hullStrength);
        if (_images != null) {
            ht.add("_images", _images);
        }
        return ht;
    }

    @Override
    public String toString() {
        return _name;
    }

    public int CargoBays() {
        return _cargoBays;
    }

    public void CargoBays(int i) {
        _cargoBays = i;
    }

    public int CrewQuarters() {
        return _crewQuarters;
    }

    public void CrewQuarters(int i) {
        _crewQuarters = i;
    }

    public int FuelTanks() {
        return _fuelTanks;
    }

    public void FuelTanks(int i) {
        _fuelTanks = i;
    }

    public int GadgetSlots() {
        return _gadgetSlots;
    }

    public void GadgetSlots(int i) {
        _gadgetSlots = i;
    }

    public int HullStrength() {
        return _hullStrength;
    }

    public void HullStrength(int i) {
        _hullStrength = i;
    }

    public int ImageIndex() {
        return _imageIndex;
    }

    public void ImageIndex(int i) {
        _imageIndex = i;
    }

    public WfImage[] Images() {
        return _images;
    }

    public void Images(WfImage[] is) {
        _images = is;
    }

    public String Name() {
        return _name;
    }

    public void Name(String s) {
        _name = s;
    }

    public int ShieldSlots() {
        return _shieldSlots;
    }

    public void ShieldSlots(int i) {
        _shieldSlots = i;
    }

    public ShipSize Size() {
        return _size;
    }

    public void Size(ShipSize ss) {
        _size = ss;
    }

    public int WeaponSlots() {
        return _weaponSlots;
    }

    public void WeaponSlots(int i) {
        _weaponSlots = i;
    }
}
