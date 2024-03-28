package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum Activity implements IdentifiableEnum {
    Absent, // = 0,
    Minimal, // = 1,
    Few, // = 2,
    Some, // = 3,
    Moderate, // = 4,
    Many, // = 5,
    Abundant, // = 6,
    Swarms, // = 7,
    NA;// = 100

    public static Activity fromId(int id) {
        return (id == 100) ? Activity.NA : Activity.values()[id];
    }

    @Override
    public int getId() {
        return (this == Activity.NA) ? 100 : ordinal();
    }
}
//TODO go over all NAs, see if can use null, or at least normalize.
//TODO go over all CastToInt, see if needed.
