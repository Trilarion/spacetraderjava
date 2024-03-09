package spacetrader;
import spacetrader.enums.ReputationType;


public class Reputation {
  private ReputationType _type;
  private int _minScore;

  public Reputation(ReputationType type, int minScore) {
    _type = type;
    _minScore = minScore;
  }

  public static Reputation GetReputationFromScore(int ReputationScore) {
    int i;
    for(i = 0; i < Consts.Reputations.length && Game.CurrentGame().Commander().getReputationScore() >= Consts.Reputations[i].MinScore(); i++) {
    }
    return Consts.Reputations[Math.max(0, i - 1)];
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
