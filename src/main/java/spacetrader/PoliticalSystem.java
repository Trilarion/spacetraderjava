package spacetrader;
import org.gts.bst.cargo.TradeItemType;
import org.gts.bst.difficulty.Difficulty;
import org.gts.bst.ship.ShipType;
import spacetrader.enums.Activity;
import spacetrader.enums.OpponentType;
import spacetrader.enums.PoliticalSystemType;
import spacetrader.enums.TechLevel;


public class PoliticalSystem {
  private PoliticalSystemType _type;
  private int _reactionIllegal; // Reaction level of illegal goods 0 = total acceptance (determines how police reacts if they find you carry them)
  private Activity _activityPolice; // Activity level of police force 0 = no police (determines occurrence rate)
  private Activity _activityPirates; // Activity level of pirates 0 = no pirates
  private Activity _activityTraders; // Activity level of traders 0 = no traders
  private TechLevel _minTech; // Mininum tech level needed
  private TechLevel _maxTech; // Maximum tech level where this is found
  private int _bribeLevel; // Indicates how easily someone can be bribed 0 = unbribable/high bribe costs
  private boolean _drugsOk; // Drugs can be traded (if not, people aren't interested or the governemnt is too strict)
  private boolean _firearmsOk; // Firearms can be traded (if not, people aren't interested or the governemnt is too strict)
  private TradeItemType _wanted; // Tradeitem requested in particular in this type of government

  public PoliticalSystem(PoliticalSystemType type, int reactionIllegal, Activity activityPolice,
                         Activity activityPirates, Activity activityTraders, TechLevel minTechLevel, TechLevel maxTechLevel,
                         int bribeLevel, boolean drugsOk, boolean firearmsOk, TradeItemType wanted) {
    _type = type;
    _reactionIllegal = reactionIllegal;
    _activityPolice = activityPolice;
    _activityPirates = activityPirates;
    _activityTraders = activityTraders;
    _minTech = minTechLevel;
    _maxTech = maxTechLevel;
    _bribeLevel = bribeLevel;
    _drugsOk = drugsOk;
    _firearmsOk = firearmsOk;
    _wanted = wanted;
  }

  public boolean ShipTypeLikely(ShipType shipType, OpponentType oppType) {
    boolean likely = false;
    int diffMod = Math.max(0, Game.CurrentGame().Difficulty().CastToInt() - Difficulty.Normal.CastToInt());
    switch(oppType) {
      case Pirate:
        likely = ActivityPirates().CastToInt() + diffMod >= Consts.ShipSpecs[shipType.CastToInt()].Pirates().CastToInt();
        break;
      case Police:
        likely = ActivityPolice().CastToInt() + diffMod >= Consts.ShipSpecs[shipType.CastToInt()].Police().CastToInt();
        break;
      case Trader:
        likely = ActivityTraders().CastToInt() + diffMod >= Consts.ShipSpecs[shipType.CastToInt()].Traders().CastToInt();
        break;
    }
    return likely;
  }

  public Activity ActivityPirates() {
    return _activityPirates;
  }

  public Activity ActivityPolice() {
    return _activityPolice;
  }

  public Activity ActivityTraders() {
    return _activityTraders;
  }

  public int BribeLevel() {
    return _bribeLevel;
  }

  public boolean DrugsOk() {
    return _drugsOk;
  }

  public boolean FirearmsOk() {
    return _firearmsOk;
  }

  public TechLevel MaximumTechLevel() {
    return _maxTech;
  }

  public TechLevel MinimumTechLevel() {
    return _minTech;
  }

  public String Name() {
    return Strings.PoliticalSystemNames[_type.CastToInt()];
  }

  public int ReactionIllegal() {
    return _reactionIllegal;
  }

  public PoliticalSystemType Type() {
    return _type;
  }

  public TradeItemType Wanted() {
    return _wanted;
  }
}
