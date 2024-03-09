package org.spacetrader.main;
import org.spacetrader.main.util.Hashtable;
import org.spacetrader.difficulty.Difficulty;
import org.spacetrader.main.enums.GameEndType;


public class HighScoreRecord extends STSerializableObject implements Comparable<HighScoreRecord> {
  private Difficulty _difficulty;
  private GameEndType _type;
  private String _name;
  private int _score;
  private int _days;
  private int _worth;

  public HighScoreRecord(String name, int score, GameEndType type, int days, int worth, Difficulty difficulty) {
    _name = name;
    _score = score;
    _type = type;
    _days = days;
    _worth = worth;
    _difficulty = difficulty;
  }

  public HighScoreRecord(Hashtable hash) {
    super(hash);
    _name = GetValueFromHash(hash, "_name", String.class);
    _score = GetValueFromHash(hash, "_score", Integer.class);
    _type = GetValueFromHash(hash, "_type", GameEndType.class);
    _days = GetValueFromHash(hash, "_days", Integer.class);
    _worth = GetValueFromHash(hash, "_worth", Integer.class);
    _difficulty = GetValueFromHash(hash, "_difficulty", Difficulty.class);
  }

  public int CompareTo(HighScoreRecord value) {
    return compareTo(value);
  }

  @Override
  public int compareTo(HighScoreRecord value) {
    int compared;
    HighScoreRecord highScore = value;
    if(value == null) {
      compared = 1;
    } else if(highScore.Score() < Score()) {
      compared = 1;
    } else if(highScore.Score() > Score()) {
      compared = -1;
    } else if(highScore.Worth() < Worth()) {
      compared = 1;
    } else if(highScore.Worth() > Worth()) {
      compared = -1;
    } else if(highScore.Days() < Days()) {
      compared = 1;
    } else if(highScore.Days() > Days()) {
      compared = -1;
    } else {
      compared = 0;
    }
    return compared;
  }

  @Override
  public Hashtable Serialize() {
    Hashtable hash = super.Serialize();
    hash.add("_name", _name);
    hash.add("_score", _score);
    hash.add("_type", _type.CastToInt());
    hash.add("_days", _days);
    hash.add("_worth", _worth);
    hash.add("_difficulty", _difficulty.CastToInt());
    return hash;
  }

  public int Days() {
    return _days;
  }

  public Difficulty Difficulty() {
    return _difficulty;
  }

  public String Name() {
    return _name;
  }

  public int Score() {
    return _score;
  }

  public GameEndType Type() {
    return _type;
  }

  public int Worth() {
    return _worth;
  }
}
