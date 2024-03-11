package org.spacetrader.model.ship.equipment;

import org.spacetrader.model.enums.SkillType;
import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.ui.Strings;
import org.spacetrader.util.Log;

import java.util.Hashtable;


public class Gadget extends Equipment {
    private final GadgetType type;
    private final SkillType skillBonus;

    public Gadget(GadgetType type, SkillType skillBonus, int price, TechLevel minTechLevel, int chance) {
        super(EquipmentType.Gadget, price, minTechLevel, chance);
        this.type = type;
        this.skillBonus = skillBonus;
    }

    public Gadget(Hashtable hash) {
        super(hash);
        type = GadgetType.FromInt(GetValueFromHash(hash, "_type", Integer.class));
        skillBonus = (GetValueFromHash(hash, "_skillBonus", SkillType.NA, SkillType.class));
    }

    @Override
    public Equipment Clone() {
        return new Gadget(type, skillBonus, price, minTech, chance);
    }

    @Override
    public EquipmentSubType SubType() {
        return Type();
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_type", type.asInteger());
        hash.put("_skillBonus", skillBonus.getId());
        return hash;
    }

    @Override
    public String Name() {
        return Strings.GadgetNames[type.asInteger()];
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
        return type;
    }

    public SkillType SkillBonus() {
        return skillBonus;
    }
}
