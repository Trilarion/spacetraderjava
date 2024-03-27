package org.spacetrader.model;

import org.spacetrader.Constants;
import org.spacetrader.model.enums.PoliceRecordType;
import org.spacetrader.ui.Strings;

public class PoliceRecord {
    private final PoliceRecordType type;
    private final int minScore;

    public PoliceRecord(final PoliceRecordType type, final int minScore) {
        this.type = type;
        this.minScore = minScore;
    }

    public static PoliceRecord getPoliceRecordFromScore(final int policeRecordScore) {
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
