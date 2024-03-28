package org.spacetrader.controller;

import org.spacetrader.model.SerializableObject;
import org.spacetrader.model.enums.Difficulty;
import org.spacetrader.model.enums.GameEndType;

import java.util.Hashtable;


public class HighScoreRecord extends SerializableObject implements Comparable<HighScoreRecord> {
    private final Difficulty difficulty;
    private final GameEndType gameEndType;
    private final String name;
    private final int score;
    private final int days;
    private final int worth;

    public HighScoreRecord(String name, int score, GameEndType gameEndType, int days, int worth, Difficulty difficulty) {
        this.name = name;
        this.score = score;
        this.gameEndType = gameEndType;
        this.days = days;
        this.worth = worth;
        this.difficulty = difficulty;
    }

    public HighScoreRecord(Hashtable hash) {
        super(hash);
        name = SerializableObject.GetValueFromHash(hash, "_name", String.class);
        score = SerializableObject.GetValueFromHash(hash, "_score", Integer.class);
        gameEndType = SerializableObject.GetValueFromHash(hash, "_type", GameEndType.class);
        days = SerializableObject.GetValueFromHash(hash, "_days", Integer.class);
        worth = SerializableObject.GetValueFromHash(hash, "_worth", Integer.class);
        difficulty = SerializableObject.GetValueFromHash(hash, "_difficulty", Difficulty.class);
    }

    public int CompareTo(HighScoreRecord value) {
        return compareTo(value);
    }

    @Override
    public int compareTo(HighScoreRecord record) {
        int compared;
        if (record == null) {
            compared = 1;
        } else if (record.Score() < Score()) {
            compared = 1;
        } else if (record.Score() > Score()) {
            compared = -1;
        } else if (record.Worth() < Worth()) {
            compared = 1;
        } else if (record.Worth() > Worth()) {
            compared = -1;
        } else if (record.Days() < Days()) {
            compared = 1;
        } else if (record.Days() > Days()) {
            compared = -1;
        } else {
            compared = 0;
        }
        return compared;
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_name", name);
        hash.put("_score", score);
        hash.put("_type", gameEndType.getId());
        hash.put("_days", days);
        hash.put("_worth", worth);
        hash.put("_difficulty", difficulty.getId());
        return hash;
    }

    public int Days() {
        return days;
    }

    public Difficulty Difficulty() {
        return difficulty;
    }

    public String Name() {
        return name;
    }

    public int Score() {
        return score;
    }

    public GameEndType Type() {
        return gameEndType;
    }

    public int Worth() {
        return worth;
    }
}
