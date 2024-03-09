package org.spacetrader.main.enums;


public enum SpecialResource implements SpaceTraderEnum {
    NA(""), // = -1,
    Nothing("Nothing Special"), // = 0,
    MineralRich("Mineral Rich"), // = 1,
    MineralPoor("Mineral Poor"), // = 2,
    Desert("Desert"), // = 3,
    SweetOceans("Sweetwater Oceans"), // = 4,
    RichSoil("Rich Soil"), // = 5,
    PoorSoil("Poor Soil"), // = 6,
    RichFauna("Rich Fauna"), // = 7,
    Lifeless("Lifeless"), // = 8,
    WeirdMushrooms("Wierd Mushrooms"), // = 9,
    SpecialHerbs("Special Herbs"), // = 10,
    Artistic("Artistic Populace"), // = 11,
    Warlike("Warlike Populace"), // = 12
    ;
    public final String name;

    SpecialResource(String s) {
        name = s;
    }

    public static SpecialResource FromInt(int i) {
        return values()[i + 1];
    }

    @Override
    public int CastToInt() {
        return ordinal() - 1;
    }
}
