package org.spacetrader.model;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Game;
import org.spacetrader.model.enums.ReputationType;
import org.spacetrader.ui.Strings;


public class Reputation {
    private final ReputationType type;
    private final int minScore;

    public Reputation(ReputationType type, int minScore) {
        this.type = type;
        this.minScore = minScore;
    }

    public static Reputation getReputationFromScore(int reputationScore) {
        int i;
        for (i = 0; i < Constants.Reputations.length && reputationScore >= Constants.Reputations[i].minScore; i++) {
        }
        return Constants.Reputations[Math.max(0, i - 1)];
    }

    public int getMinScore() {
        return minScore;
    }

    public String getName() {
        return Strings.ReputationNames[type.getId()];
    }

    public ReputationType getType() {
        return type;
    }
}
