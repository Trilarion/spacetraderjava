package org.spacetrader.model.ship.equipment;

import org.spacetrader.ui.Strings;
import org.spacetrader.controller.enums.SkillType;
import org.spacetrader.model.TechLevel;
import java.util.Hashtable;
import org.spacetrader.util.Log;


public class Gadget extends Equipment {
    private GadgetType _type;
    private SkillType _skillBonus;

    public Gadget(GadgetType type, SkillType skillBonus, int price, TechLevel minTechLevel, int chance) {
        super(EquipmentType.Gadget, price, minTechLevel, chance);
        _type = type;
        _skillBonus = skillBonus;
    }

    public Gadget(Hashtable hash) {
        super(hash);
        _type = GadgetType.FromInt(GetValueFromHash(hash, "_type", Integer.class));
        _skillBonus = (GetValueFromHash(hash, "_skillBonus", SkillType.NA, SkillType.class));
    }

    @Override
    public Equipment Clone() {
        return new Gadget(_type, _skillBonus, _price, _minTech, _chance);
    }

    @Override
    public EquipmentSubType SubType() {
        return Type();
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_type", _type.asInteger());
        hash.put("_skillBonus", _skillBonus.CastToInt());
        return hash;
    }

    @Override
    public String Name() {
        return Strings.GadgetNames[_type.asInteger()];
    }

    @Override
    public boolean TypeEquals(Object type) {
        boolean equal = false;
        try {
            if (Type() == type) {
                equal = true;
            }
        } catch (Exception e) {
            Log.write("Ignored Exception " + e);
        }
        return equal;
    }

    public GadgetType Type() {
        return _type;
    }

    public SkillType SkillBonus() {
        return _skillBonus;
    }
}
