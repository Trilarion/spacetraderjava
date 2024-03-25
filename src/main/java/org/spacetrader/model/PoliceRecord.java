package org.spacetrader.model;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Game;
import org.spacetrader.model.enums.PoliceRecordType;
import org.spacetrader.ui.Strings;

public class PoliceRecord {
    private final PoliceRecordType type;
    private final int minScore;

    public PoliceRecord(PoliceRecordType type, int minScore) {
        this.type = type;
        this.minScore = minScore;
    }

    public static PoliceRecord getPoliceRecordFromScore(int policeRecordScore) {
        int i;
        for (i = 0; i < Constants.PoliceRecords.length && policeRecordScore >= Constants.PoliceRecords[i].minScore(); i++) {
        }
        return Constants.PoliceRecords[Math.max(0, i - 1)];
    }

    public int minScore() {
        return minScore;
    }

    public String getName() {
        return Strings.PoliceRecordNames[type.getId()];
    }

    public PoliceRecordType getType() {
        return type;
    }
}
