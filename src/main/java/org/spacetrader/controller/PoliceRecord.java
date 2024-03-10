package org.spacetrader.controller;

import org.spacetrader.controller.enums.PoliceRecordType;
import org.spacetrader.ui.Strings;

// TODO part of the model
public class PoliceRecord {
    private final PoliceRecordType _type;
    private final int _minScore;

    public PoliceRecord(PoliceRecordType type, int minScore) {
        _type = type;
        _minScore = minScore;
    }

    public static PoliceRecord GetPoliceRecordFromScore(int PoliceRecordScore) {
        int i;
        for (i = 0; i < Constants.PoliceRecords.length && Game.getCurrentGame().Commander().getPoliceRecordScore() >= Constants.PoliceRecords[i].MinScore(); i++) {
        }
        return Constants.PoliceRecords[Math.max(0, i - 1)];
    }

    public int MinScore() {
        return _minScore;
    }

    public String Name() {
        return Strings.PoliceRecordNames[_type.CastToInt()];
    }

    public PoliceRecordType Type() {
        return _type;
    }
}
