package org.spacetrader.controller;

import org.spacetrader.controller.enums.ReputationType;
import org.spacetrader.ui.Strings;


// TODO part of the model
public class Reputation {
    private final ReputationType _type;
    private final int _minScore;

    public Reputation(ReputationType type, int minScore) {
        _type = type;
        _minScore = minScore;
    }

    public static Reputation GetReputationFromScore(int ReputationScore) {
        int i;
        for (i = 0; i < Constants.Reputations.length && Game.getCurrentGame().Commander().getReputationScore() >= Constants.Reputations[i].MinScore(); i++) {
        }
        return Constants.Reputations[Math.max(0, i - 1)];
    }

    public int MinScore() {
        return _minScore;
    }

    public String Name() {
        return Strings.ReputationNames[_type.CastToInt()];
    }

    public ReputationType Type() {
        return _type;
    }
}
