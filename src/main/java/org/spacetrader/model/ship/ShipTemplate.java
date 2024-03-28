package org.spacetrader.model.ship;

import org.spacetrader.Constants;
import org.spacetrader.controller.Game;
import org.spacetrader.model.SerializableObject;
import org.winforms.image.Image;

import java.util.Hashtable;

public class ShipTemplate extends SerializableObject implements Comparable<ShipTemplate> {

    private Image[] images;
    private ShipSize size = ShipSize.Tiny;
    private String name;
    private int imageIndex = ShipType.Custom.getId();
    private int cargoBays;
    private int weaponSlots;
    private int shieldSlots;
    private int gadgetSlots;
    private int crewQuarters;
    private int fuelTanks;
    private int hullStrength;

    public ShipTemplate(Hashtable ht) {
        name = SerializableObject.GetValueFromHash(ht, "_name", name, String.class);
        size = (SerializableObject.GetValueFromHash(ht, "_size", size));
        imageIndex = SerializableObject.GetValueFromHash(ht, "_imageIndex", imageIndex);
        cargoBays = SerializableObject.GetValueFromHash(ht, "_cargoBays", cargoBays);
        weaponSlots = SerializableObject.GetValueFromHash(ht, "_weaponSlots", weaponSlots);
        shieldSlots = SerializableObject.GetValueFromHash(ht, "_shieldSlots", shieldSlots);
        gadgetSlots = SerializableObject.GetValueFromHash(ht, "_gadgetSlots", gadgetSlots);
        crewQuarters = SerializableObject.GetValueFromHash(ht, "_crewQuarters", crewQuarters);
        fuelTanks = SerializableObject.GetValueFromHash(ht, "_fuelTanks", fuelTanks);
        hullStrength = SerializableObject.GetValueFromHash(ht, "_hullStrength", hullStrength);
        images = SerializableObject.GetValueFromHash(ht, "_images", images);
    }

    public ShipTemplate(ShipSize s, String t) {
        size = s;
        name = t;
        images = Game.getCurrentGame().getParentWindow().CustomShipImages();
    }

    public ShipTemplate(ShipSpec s, String t) {
        name = t;
        size = s.getSize();
        imageIndex = s.ImageIndex();
        cargoBays = s.CargoBays();
        weaponSlots = s.getWeaponSlots();
        shieldSlots = s.getShieldSlots();
        gadgetSlots = s.getGadgetSlots();
        crewQuarters = s.getCrewQuarters();
        fuelTanks = s.FuelTanks();
        hullStrength = s.HullStrength();
        if (imageIndex == Constants.ShipImgUseDefault) {
            images = Game.getCurrentGame().getParentWindow().CustomShipImages();
        }
    }

    @Override
    public int compareTo(ShipTemplate st) {
        if (st == null) {
            return 1;
        } else {
            return name.compareTo(st.name);
        }
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_name", name);
        hash.put("_size", size.getId());
        hash.put("_imageIndex", imageIndex);
        hash.put("_cargoBays", cargoBays);
        hash.put("_weaponSlots", weaponSlots);
        hash.put("_shieldSlots", shieldSlots);
        hash.put("_gadgetSlots", gadgetSlots);
        hash.put("_crewQuarters", crewQuarters);
        hash.put("_fuelTanks", fuelTanks);
        hash.put("_hullStrength", hullStrength);
        if (images != null) {
            hash.put("_images", images);
        }
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }

    public int CargoBays() {
        return cargoBays;
    }

    public void CargoBays(int i) {
        cargoBays = i;
    }

    public int CrewQuarters() {
        return crewQuarters;
    }

    public void CrewQuarters(int i) {
        crewQuarters = i;
    }

    public int FuelTanks() {
        return fuelTanks;
    }

    public void FuelTanks(int i) {
        fuelTanks = i;
    }

    public int GadgetSlots() {
        return gadgetSlots;
    }

    public void GadgetSlots(int i) {
        gadgetSlots = i;
    }

    public int HullStrength() {
        return hullStrength;
    }

    public void HullStrength(int i) {
        hullStrength = i;
    }

    public int ImageIndex() {
        return imageIndex;
    }

    public void ImageIndex(int i) {
        imageIndex = i;
    }

    public Image[] Images() {
        return images;
    }

    public void Images(Image[] is) {
        images = is;
    }

    public String Name() {
        return name;
    }

    public void Name(String s) {
        name = s;
    }

    public int ShieldSlots() {
        return shieldSlots;
    }

    public void ShieldSlots(int i) {
        shieldSlots = i;
    }

    public ShipSize Size() {
        return size;
    }

    public void Size(ShipSize ss) {
        size = ss;
    }

    public int WeaponSlots() {
        return weaponSlots;
    }

    public void WeaponSlots(int i) {
        weaponSlots = i;
    }
}
