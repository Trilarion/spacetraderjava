package org.spacetrader.controller;

import org.spacetrader.controller.enums.GameEndType;
import org.spacetrader.model.Difficulty;
import org.spacetrader.util.Hashtable;


public class HighScoreRecord extends SerializableObject implements Comparable<HighScoreRecord> {
    private Difficulty difficulty;
    private GameEndType gameEndType;
    private String name;
    private int score;
    private int days;
    private int worth;

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
        name = GetValueFromHash(hash, "_name", String.class);
        score = GetValueFromHash(hash, "_score", Integer.class);
        gameEndType = GetValueFromHash(hash, "_type", GameEndType.class);
        days = GetValueFromHash(hash, "_days", Integer.class);
        worth = GetValueFromHash(hash, "_worth", Integer.class);
        difficulty = GetValueFromHash(hash, "_difficulty", Difficulty.class);
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
        hash.add("_name", name);
        hash.add("_score", score);
        hash.add("_type", gameEndType.CastToInt());
        hash.add("_days", days);
        hash.add("_worth", worth);
        hash.add("_difficulty", difficulty.CastToInt());
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
