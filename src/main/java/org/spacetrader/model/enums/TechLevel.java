package org.spacetrader.model.enums;


public enum TechLevel {
    pt(-1, "PT", "Pre-Species/Non-Existence"),
    t0(0, "T0", "Pre-Agricultural"), // = 0, pre-agricultural
    t1(1, "T1", "Agricultural"), // = 1, agricultural
    t2(2, "T2", "Medieval"), // = 2, medieval
    t3(3, "T3", "Renaissance"), // = 3, renaissance
    t4(4, "T4", "Early Industrial"), // = 4, early industrial
    t5(5, "T5", "Industrial"), // = 5, industrial
    t6(6, "T6", "Post-Industrial"), // = 6, post-industrial
    t7(7, "T7", "High Tech"), // = 7, high-tech
    t8(8, "T8", "Unavailable"),// = 8 unavailable
    xt(9, "XT", "Post-Technology");

    public final String abbreviation;
    public final String name;
    public final int id;
    public final int value;

    TechLevel(final int value, final String abbreviation, final String name) {
        this.value = value;
        this.abbreviation = abbreviation;
        this.name = name;
        id = ordinal();
    }

    public static TechLevel FromInt(final int i) {
        return TechLevel.values()[i];
    }
}
