package org.gts.bst.difficulty;
import spacetrader.enums.SpaceTraderEnum;


public enum Difficulty implements SpaceTraderEnum {
  Beginner(2),
  Easy(1),
  Normal(0),
  Hard(-1),
  Impossible(-2);
  private final int skillAdjust;

  private Difficulty(int skillAdjust) {
    this.skillAdjust = skillAdjust;
  }

  @Override
  public int CastToInt() {
    return ordinal();
  }

  public int adjustSkill(int skill) {
    return skill + skillAdjust;
  }

  public static Difficulty FromInt(int i) {
    return values()[i];
  }
}
