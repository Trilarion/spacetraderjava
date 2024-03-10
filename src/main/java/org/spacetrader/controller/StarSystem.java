package org.spacetrader.controller;

import org.spacetrader.controller.enums.*;
import org.spacetrader.model.cargo.TradeItem;
import org.spacetrader.model.cargo.TradeItemType;
import org.spacetrader.model.events.SpecialEventType;
import org.spacetrader.model.ship.ShipSize;
import org.spacetrader.util.Hashtable;

import java.util.ArrayList;


public class StarSystem extends SerializableObject {
    private PoliticalSystemType _politicalSystemType;
    private ShipyardId _shipyardId = ShipyardId.NA;
    private ShipSize _size;
    private SpecialEventType _specialEventType = SpecialEventType.NA;
    private SpecialResource _specialResource;
    private StarSystemId _id;
    private SystemPressure _systemPressure;
    private TechLevel _techLevel;
    private boolean _visited = false;
    private int _countDown = 0;
    private int _x;
    private int _y;
    private int[] _tradeItems = new int[10];

    public StarSystem(StarSystemId id, int x, int y, ShipSize size, TechLevel techLevel,
                      PoliticalSystemType politicalSystemType, SystemPressure systemPressure, SpecialResource specialResource) {
        _id = id;
        _x = x;
        _y = y;
        _size = size;
        _techLevel = techLevel;
        _politicalSystemType = politicalSystemType;
        _systemPressure = systemPressure;
        _specialResource = specialResource;
        InitializeTradeItems();
    }

    public StarSystem(Hashtable hash) {
        super(hash);
        _id = StarSystemId.FromInt(GetValueFromHash(hash, "_id", Integer.class));
        _x = GetValueFromHash(hash, "_x", _x);
        _y = GetValueFromHash(hash, "_y", _y);
        _size = ShipSize.FromInt(GetValueFromHash(hash, "_size", _size, Integer.class));
        _techLevel = TechLevel.FromInt(GetValueFromHash(hash, "_techLevel", /*_techLevel*/0, Integer.class));
        _politicalSystemType = PoliticalSystemType.FromInt(GetValueFromHash(hash, "_politicalSystemType", _politicalSystemType, Integer.class));
        _systemPressure = SystemPressure.FromInt(GetValueFromHash(hash, "_systemPressure", _systemPressure, Integer.class));
        _specialResource = SpecialResource.FromInt(GetValueFromHash(hash, "_specialResource", _specialResource, Integer.class));
        _specialEventType = SpecialEventType.FromInt(GetValueFromHash(hash, "_specialEventType", _specialEventType, Integer.class));
        _tradeItems = GetValueFromHash(hash, "_tradeItems", _tradeItems, int[].class);
        _countDown = GetValueFromHash(hash, "_countDown", _countDown);
        _visited = GetValueFromHash(hash, "_visited", _visited);
        _shipyardId = ShipyardId.FromInt(GetValueFromHash(hash, "_shipyardId", _shipyardId, Integer.class));
    }

    public void InitializeTradeItems() {
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            if (!ItemTraded(Constants.TradeItems[i])) {
                _tradeItems[i] = 0;
            } else {
                _tradeItems[i] = (this.Size().CastToInt() + 1)
                        * (Functions.GetRandom(9, 14) - Math.abs(Constants.TradeItems[i].TechTopProduction().ordinal() - this.TechLevel().ordinal()));
                // Because of the enormous profits possible, there shouldn't be too many robots or narcotics available.
                if (i >= TradeItemType.Narcotics.CastToInt()) {
                    _tradeItems[i] = ((_tradeItems[i] * (5 - Game.CurrentGame().Difficulty().CastToInt())) / (6 - Game.CurrentGame().Difficulty().CastToInt())) + 1;
                }
                if (this.SpecialResource() == Constants.TradeItems[i].ResourceLowPrice()) {
                    _tradeItems[i] = _tradeItems[i] * 4 / 3;
                }
                if (this.SpecialResource() == Constants.TradeItems[i].ResourceHighPrice()) {
                    _tradeItems[i] = _tradeItems[i] * 3 / 4;
                }
                if (this.SystemPressure() == Constants.TradeItems[i].PressurePriceHike()) {
                    _tradeItems[i] /= 5;
                }
                _tradeItems[i] = _tradeItems[i] - Functions.GetRandom(10) + Functions.GetRandom(10);
                if (_tradeItems[i] < 0) {
                    _tradeItems[i] = 0;
                }
            }
        }
    }

    public boolean ItemTraded(TradeItem item) {
        return ((item.Type() != TradeItemType.Narcotics || PoliticalSystem().DrugsOk())
                && (item.Type() != TradeItemType.Firearms || PoliticalSystem().FirearmsOk()) && TechLevel().ordinal() >= item.TechProduction().ordinal());
    }

    public boolean ItemUsed(TradeItem item) {
        return ((item.Type() != TradeItemType.Narcotics || PoliticalSystem().DrugsOk())
                && (item.Type() != TradeItemType.Firearms || PoliticalSystem().FirearmsOk()) && TechLevel().ordinal() >= item.TechUsage().ordinal());
    }

    @Override
    public Hashtable Serialize() {
        Hashtable ht = super.Serialize();
        ht.add("_id", _id.CastToInt());
        ht.add("_x", _x);
        ht.add("_y", _y);
        ht.add("_size", _size.CastToInt());
        ht.add("_techLevel", _techLevel.ordinal());
        ht.add("_politicalSystemType", _politicalSystemType.CastToInt());
        ht.add("_systemPressure", _systemPressure.CastToInt());
        ht.add("_specialResource", _specialResource.CastToInt());
        ht.add("_specialEventType", _specialEventType.CastToInt());
        ht.add("_tradeItems", _tradeItems);
        ht.add("_countDown", _countDown);
        ht.add("_visited", _visited);
        ht.add("_shipyardId", _shipyardId.CastToInt());
        return ht;
    }

    public boolean ShowSpecialButton() {
        Game game = Game.CurrentGame();
        boolean show = false;
        switch (SpecialEventType()) {
            case Artifact:
            case Dragonfly:
            case Experiment:
            case Jarek:
                show = game.Commander().getPoliceRecordScore() >= Constants.PoliceRecordScoreDubious;
                break;
            case ArtifactDelivery:
                show = game.Commander().getShip().ArtifactOnBoard();
                break;
            case CargoForSale:
                show = game.Commander().getShip().FreeCargoBays() >= 3;
                break;
            case DragonflyBaratas:
                show = game.getQuestStatusDragonfly() > SpecialEvent.StatusDragonflyNotStarted
                        && game.getQuestStatusDragonfly() < SpecialEvent.StatusDragonflyDestroyed;
                break;
            case DragonflyDestroyed:
                show = game.getQuestStatusDragonfly() == SpecialEvent.StatusDragonflyDestroyed;
                break;
            case DragonflyMelina:
                show = game.getQuestStatusDragonfly() > SpecialEvent.StatusDragonflyFlyBaratas
                        && game.getQuestStatusDragonfly() < SpecialEvent.StatusDragonflyDestroyed;
                break;
            case DragonflyRegulas:
                show = game.getQuestStatusDragonfly() > SpecialEvent.StatusDragonflyFlyMelina
                        && game.getQuestStatusDragonfly() < SpecialEvent.StatusDragonflyDestroyed;
                break;
            case DragonflyShield:
            case ExperimentFailed:
            case Gemulon:
            case GemulonFuel:
            case GemulonInvaded:
            case Lottery:
            case ReactorLaser:
            case PrincessQuantum:
            case SculptureHiddenBays:
            case Skill:
            case SpaceMonster:
            case Tribble:
                show = true;
                break;
            case EraseRecord:
            case Wild:
                show = game.Commander().getPoliceRecordScore() < Constants.PoliceRecordScoreDubious;
                break;
            case ExperimentStopped:
                show = game.getQuestStatusExperiment() > SpecialEvent.StatusExperimentNotStarted
                        && game.getQuestStatusExperiment() < SpecialEvent.StatusExperimentPerformed;
                break;
            case GemulonRescued:
                show = game.getQuestStatusGemulon() > SpecialEvent.StatusGemulonNotStarted
                        && game.getQuestStatusGemulon() < SpecialEvent.StatusGemulonTooLate;
                break;
            case Japori:
                show = game.getQuestStatusJapori() == SpecialEvent.StatusJaporiNotStarted
                        && game.Commander().getPoliceRecordScore() >= Constants.PoliceRecordScoreDubious;
                break;
            case JaporiDelivery:
                show = game.getQuestStatusJapori() == SpecialEvent.StatusJaporiInTransit;
                break;
            case JarekGetsOut:
                show = game.Commander().getShip().JarekOnBoard();
                break;
            case Moon:
                show = game.getQuestStatusMoon() == SpecialEvent.StatusMoonNotStarted
                        && game.Commander().Worth() > SpecialEvent.MoonCost * .8;
                break;
            case MoonRetirement:
                show = game.getQuestStatusMoon() == SpecialEvent.StatusMoonBought;
                break;
            case Princess:
                show = game.Commander().getPoliceRecordScore() >= Constants.PoliceRecordScoreLawful
                        && game.Commander().getReputationScore() >= Constants.ReputationScoreAverage;
                break;
            case PrincessCentauri:
                show = game.getQuestStatusPrincess() >= SpecialEvent.StatusPrincessFlyCentauri
                        && game.getQuestStatusPrincess() <= SpecialEvent.StatusPrincessFlyQonos;
                break;
            case PrincessInthara:
                show = game.getQuestStatusPrincess() >= SpecialEvent.StatusPrincessFlyInthara
                        && game.getQuestStatusPrincess() <= SpecialEvent.StatusPrincessFlyQonos;
                break;
            case PrincessQonos:
                show = game.getQuestStatusPrincess() == SpecialEvent.StatusPrincessRescued
                        && !game.Commander().getShip().PrincessOnBoard();
                break;
            case PrincessReturned:
                show = game.Commander().getShip().PrincessOnBoard();
                break;
            case Reactor:
                show = game.getQuestStatusReactor() == SpecialEvent.StatusReactorNotStarted
                        && game.Commander().getPoliceRecordScore() < Constants.PoliceRecordScoreDubious
                        && game.Commander().getReputationScore() >= Constants.ReputationScoreAverage;
                break;
            case ReactorDelivered:
                show = game.Commander().getShip().ReactorOnBoard();
                break;
            case Scarab:
                show = game.getQuestStatusScarab() == SpecialEvent.StatusScarabNotStarted
                        && game.Commander().getReputationScore() >= Constants.ReputationScoreAverage;
                break;
            case ScarabDestroyed:
            case ScarabUpgradeHull:
                show = game.getQuestStatusScarab() == SpecialEvent.StatusScarabDestroyed;
                break;
            case Sculpture:
                show = game.getQuestStatusSculpture() == SpecialEvent.StatusSculptureNotStarted
                        && game.Commander().getPoliceRecordScore() < Constants.PoliceRecordScoreDubious
                        && game.Commander().getReputationScore() >= Constants.ReputationScoreAverage;
                break;
            case SculptureDelivered:
                show = game.getQuestStatusSculpture() == SpecialEvent.StatusSculptureInTransit;
                break;
            case SpaceMonsterKilled:
                show = game.getQuestStatusSpaceMonster() == SpecialEvent.StatusSpaceMonsterDestroyed;
                break;
            case TribbleBuyer:
                show = game.Commander().getShip().getTribbles() > 0;
                break;
            case WildGetsOut:
                show = game.Commander().getShip().WildOnBoard();
                break;
            default:
                break;
        }
        return show;
    }

    public int CountDown() {
        return _countDown;
    }

    public void CountDown(int i) {
        _countDown = i;
    }

    public boolean DestOk() {
        Commander comm = Game.CurrentGame().Commander();
        return this != comm.CurrentSystem() && (Distance() <= comm.getShip().getFuel() || Functions.WormholeExists(comm.CurrentSystem(), this));
    }

    public int Distance() {
        return Functions.Distance(this, Game.CurrentGame().Commander().CurrentSystem());
    }

    public StarSystemId Id() {
        return _id;
    }

    public CrewMember[] MercenariesForHire() {
        Commander cmdr = Game.CurrentGame().Commander();
        CrewMember[] mercs = Game.CurrentGame().Mercenaries();
        ArrayList<CrewMember> forHire = new ArrayList<>(3);
        for (int i = 1; i < mercs.length; i++) {
            if (mercs[i].CurrentSystem() == cmdr.CurrentSystem() && !cmdr.getShip().HasCrew(mercs[i].Id())) {
                forHire.add(mercs[i]);
            }
        }
        return forHire.toArray(new CrewMember[0]);
    }

    public String Name() {
        return Strings.SystemNames[_id.CastToInt()];
    }

    public PoliticalSystem PoliticalSystem() {
        return Constants.PoliticalSystems[_politicalSystemType.CastToInt()];
    }

    public PoliticalSystemType PoliticalSystemType() {
        return _politicalSystemType;
    }

    public void PoliticalSystemType(PoliticalSystemType pst) {
        _politicalSystemType = pst;
    }

    public Shipyard Shipyard() {
        ShipyardId();
        return (_shipyardId == ShipyardId.NA ? null : Constants.Shipyards[_shipyardId.CastToInt()]);
    }

    public ShipyardId ShipyardId() {
        return _shipyardId;
    }

    public void ShipyardId(ShipyardId si) {
        _shipyardId = si;
    }

    public ShipSize Size() {
        return _size;
    }

    public SpecialEvent SpecialEvent() {
        SpecialEventType();
        return (_specialEventType == SpecialEventType.NA ? null : Constants.SpecialEvents[_specialEventType.CastToInt()]);
    }

    public SpecialEventType SpecialEventType() {
        return _specialEventType;
    }

    public void SpecialEventType(SpecialEventType set) {
        _specialEventType = set;
    }

    public SpecialResource SpecialResource() {
        return Visited() ? _specialResource : SpecialResource.Nothing;
    }

    public SystemPressure SystemPressure() {
        return _systemPressure;
    }

    public void SystemPressure(SystemPressure sp) {
        _systemPressure = sp;
    }

    public TechLevel TechLevel() {
        return _techLevel;
    }

    public void TechLevel(TechLevel tl) {
        _techLevel = tl;
    }

    public int[] TradeItems() {
        return _tradeItems;
    }

    public boolean Visited() {
        return _visited;
    }

    public void Visited(boolean b) {
        _visited = b;
    }

    public int X() {
        return _x;
    }

    public void X(int i) {
        _x = i;
    }

    public int Y() {
        return _y;
    }

    public void Y(int i) {
        _y = i;
    }
}
