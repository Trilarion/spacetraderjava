package org.spacetrader.main;

import org.spacetrader.main.enums.PoliceRecordType;


public class PoliceRecord {
    private PoliceRecordType _type;
    private int _minScore;

    public PoliceRecord(PoliceRecordType type, int minScore) {
        _type = type;
        _minScore = minScore;
    }

    public static PoliceRecord GetPoliceRecordFromScore(int PoliceRecordScore) {
        int i;
        for (i = 0; i < Consts.PoliceRecords.length && Game.CurrentGame().Commander().getPoliceRecordScore() >= Consts.PoliceRecords[i].MinScore(); i++) {
        }
        return Consts.PoliceRecords[Math.max(0, i - 1)];
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
