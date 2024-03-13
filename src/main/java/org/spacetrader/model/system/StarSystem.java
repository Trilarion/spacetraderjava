package org.spacetrader.model.system;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.SerializableObject;
import org.spacetrader.model.PoliticalSystem;
import org.spacetrader.model.cargo.TradeItem;
import org.spacetrader.model.cargo.TradeItemType;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.crew.CrewMember;
import org.spacetrader.model.enums.*;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.events.SpecialEventType;
import org.spacetrader.model.ship.ShipSize;
import org.spacetrader.model.ship.Shipyard;
import org.spacetrader.ui.Strings;

import java.util.ArrayList;
import java.util.Hashtable;


public class StarSystem extends SerializableObject {

    private final StarSystemId systemId;
    private PoliticalSystemType politicalSystemType;
    private ShipyardId shipyardId = ShipyardId.NA;
    private ShipSize size;
    private SpecialEventType specialEventType = SpecialEventType.NA;
    private SpecialResource specialResource;
    private SystemPressure systemPressure;
    private TechLevel techLevel;
    private boolean visited;
    private int countDown;
    private int x;  // TODO make coordinates a point
    private int y;
    private int[] tradeItems = new int[10];  // make 10 a constant

    public StarSystem(StarSystemId id, int x, int y, ShipSize size, TechLevel techLevel,
                      PoliticalSystemType politicalSystemType, SystemPressure systemPressure, SpecialResource specialResource) {
        systemId = id;
        this.x = x;
        this.y = y;
        this.size = size;
        this.techLevel = techLevel;
        this.politicalSystemType = politicalSystemType;
        this.systemPressure = systemPressure;
        this.specialResource = specialResource;
        initializeTradeItems();
    }

    public StarSystem(Hashtable hash) {
        super(hash);
        systemId = StarSystemId.FromInt(GetValueFromHash(hash, "_id", Integer.class));
        x = GetValueFromHash(hash, "_x", x);
        y = GetValueFromHash(hash, "_y", y);
        size = ShipSize.FromInt(GetValueFromHash(hash, "_size", size, Integer.class));
        techLevel = TechLevel.FromInt(GetValueFromHash(hash, "_techLevel", /*_techLevel*/0, Integer.class));
        politicalSystemType = PoliticalSystemType.FromInt(GetValueFromHash(hash, "_politicalSystemType", politicalSystemType, Integer.class));
        systemPressure = SystemPressure.FromInt(GetValueFromHash(hash, "_systemPressure", systemPressure, Integer.class));
        specialResource = SpecialResource.FromInt(GetValueFromHash(hash, "_specialResource", specialResource, Integer.class));
        specialEventType = SpecialEventType.FromInt(GetValueFromHash(hash, "_specialEventType", specialEventType, Integer.class));
        tradeItems = GetValueFromHash(hash, "_tradeItems", tradeItems, int[].class);
        countDown = GetValueFromHash(hash, "_countDown", countDown);
        visited = GetValueFromHash(hash, "_visited", visited);
        shipyardId = ShipyardId.FromInt(GetValueFromHash(hash, "_shipyardId", shipyardId, Integer.class));
    }

    public void initializeTradeItems() {
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            if (ItemTraded(Constants.TradeItems[i])) {
                tradeItems[i] = (Size().getId() + 1)
                        * (Functions.GetRandom(9, 14) - Math.abs(Constants.TradeItems[i].TechTopProduction().ordinal() - TechLevel().ordinal()));
                // Because of the enormous profits possible, there shouldn't be too many robots or narcotics available.
                if (i >= TradeItemType.Narcotics.getId()) {
                    tradeItems[i] = ((tradeItems[i] * (5 - Game.getCurrentGame().Difficulty().getId())) / (6 - Game.getCurrentGame().Difficulty().getId())) + 1;
                }
                if (SpecialResource() == Constants.TradeItems[i].ResourceLowPrice()) {
                    tradeItems[i] = tradeItems[i] * 4 / 3;
                }
                if (SpecialResource() == Constants.TradeItems[i].ResourceHighPrice()) {
                    tradeItems[i] = tradeItems[i] * 3 / 4;
                }
                if (SystemPressure() == Constants.TradeItems[i].PressurePriceHike()) {
                    tradeItems[i] /= 5;
                }
                tradeItems[i] = tradeItems[i] - Functions.GetRandom(10) + Functions.GetRandom(10);
                if (0 > tradeItems[i]) {
                    tradeItems[i] = 0;
                }
            } else {
                tradeItems[i] = 0;
            }
        }
    }

    public boolean ItemTraded(TradeItem item) {
        return ((TradeItemType.Narcotics != item.Type() || PoliticalSystem().DrugsOk())
                && (TradeItemType.Firearms != item.Type() || PoliticalSystem().FirearmsOk()) && TechLevel().ordinal() >= item.TechProduction().ordinal());
    }

    public boolean ItemUsed(TradeItem item) {
        return ((TradeItemType.Narcotics != item.Type() || PoliticalSystem().DrugsOk())
                && (TradeItemType.Firearms != item.Type() || PoliticalSystem().FirearmsOk()) && TechLevel().ordinal() >= item.TechUsage().ordinal());
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_id", systemId.getId());
        hash.put("_x", x);
        hash.put("_y", y);
        hash.put("_size", size.getId());
        hash.put("_techLevel", techLevel.ordinal());
        hash.put("_politicalSystemType", politicalSystemType.getId());
        hash.put("_systemPressure", systemPressure.getId());
        hash.put("_specialResource", specialResource.getId());
        hash.put("_specialEventType", specialEventType.getId());
        hash.put("_tradeItems", tradeItems);
        hash.put("_countDown", countDown);
        hash.put("_visited", visited);
        hash.put("_shipyardId", shipyardId.getId());
        return hash;
    }

    public boolean ShowSpecialButton() {
        Game game = Game.getCurrentGame();
        boolean show = false;
        switch (SpecialEventType()) {
            case Artifact:
            case Dragonfly:
            case Experiment:
            case Jarek:
                show = Constants.PoliceRecordScoreDubious <= game.Commander().getPoliceRecordScore();
                break;
            case ArtifactDelivery:
                show = game.Commander().getShip().ArtifactOnBoard();
                break;
            case CargoForSale:
                show = 3 <= game.Commander().getShip().FreeCargoBays();
                break;
            case DragonflyBaratas:
                show = SpecialEvent.StatusDragonflyNotStarted < game.getQuestStatusDragonfly()
                        && SpecialEvent.StatusDragonflyDestroyed > game.getQuestStatusDragonfly();
                break;
            case DragonflyDestroyed:
                show = SpecialEvent.StatusDragonflyDestroyed == game.getQuestStatusDragonfly();
                break;
            case DragonflyMelina:
                show = SpecialEvent.StatusDragonflyFlyBaratas < game.getQuestStatusDragonfly()
                        && SpecialEvent.StatusDragonflyDestroyed > game.getQuestStatusDragonfly();
                break;
            case DragonflyRegulas:
                show = SpecialEvent.StatusDragonflyFlyMelina < game.getQuestStatusDragonfly()
                        && SpecialEvent.StatusDragonflyDestroyed > game.getQuestStatusDragonfly();
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
                show = Constants.PoliceRecordScoreDubious > game.Commander().getPoliceRecordScore();
                break;
            case ExperimentStopped:
                show = SpecialEvent.StatusExperimentNotStarted < game.getQuestStatusExperiment()
                        && SpecialEvent.StatusExperimentPerformed > game.getQuestStatusExperiment();
                break;
            case GemulonRescued:
                show = SpecialEvent.StatusGemulonNotStarted < game.getQuestStatusGemulon()
                        && SpecialEvent.StatusGemulonTooLate > game.getQuestStatusGemulon();
                break;
            case Japori:
                show = SpecialEvent.StatusJaporiNotStarted == game.getQuestStatusJapori()
                        && Constants.PoliceRecordScoreDubious <= game.Commander().getPoliceRecordScore();
                break;
            case JaporiDelivery:
                show = SpecialEvent.StatusJaporiInTransit == game.getQuestStatusJapori();
                break;
            case JarekGetsOut:
                show = game.Commander().getShip().JarekOnBoard();
                break;
            case Moon:
                show = SpecialEvent.StatusMoonNotStarted == game.getQuestStatusMoon()
                        && SpecialEvent.MoonCost * .8 < game.Commander().Worth();
                break;
            case MoonRetirement:
                show = SpecialEvent.StatusMoonBought == game.getQuestStatusMoon();
                break;
            case Princess:
                show = Constants.PoliceRecordScoreLawful <= game.Commander().getPoliceRecordScore()
                        && Constants.ReputationScoreAverage <= game.Commander().getReputationScore();
                break;
            case PrincessCentauri:
                show = SpecialEvent.StatusPrincessFlyCentauri <= game.getQuestStatusPrincess()
                        && SpecialEvent.StatusPrincessFlyQonos >= game.getQuestStatusPrincess();
                break;
            case PrincessInthara:
                show = SpecialEvent.StatusPrincessFlyInthara <= game.getQuestStatusPrincess()
                        && SpecialEvent.StatusPrincessFlyQonos >= game.getQuestStatusPrincess();
                break;
            case PrincessQonos:
                show = SpecialEvent.StatusPrincessRescued == game.getQuestStatusPrincess()
                        && !game.Commander().getShip().PrincessOnBoard();
                break;
            case PrincessReturned:
                show = game.Commander().getShip().PrincessOnBoard();
                break;
            case Reactor:
                show = SpecialEvent.StatusReactorNotStarted == game.getQuestStatusReactor()
                        && Constants.PoliceRecordScoreDubious > game.Commander().getPoliceRecordScore()
                        && Constants.ReputationScoreAverage <= game.Commander().getReputationScore();
                break;
            case ReactorDelivered:
                show = game.Commander().getShip().ReactorOnBoard();
                break;
            case Scarab:
                show = SpecialEvent.StatusScarabNotStarted == game.getQuestStatusScarab()
                        && Constants.ReputationScoreAverage <= game.Commander().getReputationScore();
                break;
            case ScarabDestroyed:
            case ScarabUpgradeHull:
                show = SpecialEvent.StatusScarabDestroyed == game.getQuestStatusScarab();
                break;
            case Sculpture:
                show = SpecialEvent.StatusSculptureNotStarted == game.getQuestStatusSculpture()
                        && Constants.PoliceRecordScoreDubious > game.Commander().getPoliceRecordScore()
                        && Constants.ReputationScoreAverage <= game.Commander().getReputationScore();
                break;
            case SculptureDelivered:
                show = SpecialEvent.StatusSculptureInTransit == game.getQuestStatusSculpture();
                break;
            case SpaceMonsterKilled:
                show = SpecialEvent.StatusSpaceMonsterDestroyed == game.getQuestStatusSpaceMonster();
                break;
            case TribbleBuyer:
                show = 0 < game.Commander().getShip().getTribbles();
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
        return countDown;
    }

    public void CountDown(int i) {
        countDown = i;
    }

    public boolean DestOk() {
        Commander comm = Game.getCurrentGame().Commander();
        return this != comm.CurrentSystem() && (Distance() <= comm.getShip().getFuel() || Functions.WormholeExists(comm.CurrentSystem(), this));
    }

    public int Distance() {
        return Functions.distance(this, Game.getCurrentGame().Commander().CurrentSystem());
    }

    public StarSystemId Id() {
        return systemId;
    }

    public CrewMember[] MercenariesForHire() {
        Commander commander = Game.getCurrentGame().Commander();
        CrewMember[] mercs = Game.getCurrentGame().Mercenaries();
        ArrayList<CrewMember> forHire = new ArrayList<>(3);
        for (int i = 1; i < mercs.length; i++) {
            if (mercs[i].CurrentSystem() == commander.CurrentSystem() && !commander.getShip().HasCrew(mercs[i].Id())) {
                forHire.add(mercs[i]);
            }
        }
        return forHire.toArray(new CrewMember[0]);
    }

    public String Name() {
        return Strings.SystemNames[systemId.getId()];
    }

    public PoliticalSystem PoliticalSystem() {
        return Constants.PoliticalSystems[politicalSystemType.getId()];
    }

    public PoliticalSystemType PoliticalSystemType() {
        return politicalSystemType;
    }

    public void PoliticalSystemType(PoliticalSystemType pst) {
        politicalSystemType = pst;
    }

    public Shipyard Shipyard() {
        ShipyardId();
        return (ShipyardId.NA == shipyardId ? null : Constants.Shipyards[shipyardId.getId()]);
    }

    public ShipyardId ShipyardId() {
        return shipyardId;
    }

    public void ShipyardId(ShipyardId si) {
        shipyardId = si;
    }

    public ShipSize Size() {
        return size;
    }

    public SpecialEvent SpecialEvent() {
        SpecialEventType();
        return (SpecialEventType.NA == specialEventType ? null : Constants.SpecialEvents[specialEventType.getId()]);
    }

    public SpecialEventType SpecialEventType() {
        return specialEventType;
    }

    public void SpecialEventType(SpecialEventType set) {
        specialEventType = set;
    }

    public SpecialResource SpecialResource() {
        return Visited() ? specialResource : SpecialResource.Nothing;
    }

    public SystemPressure SystemPressure() {
        return systemPressure;
    }

    public void SystemPressure(SystemPressure sp) {
        systemPressure = sp;
    }

    public TechLevel TechLevel() {
        return techLevel;
    }

    public void TechLevel(TechLevel tl) {
        techLevel = tl;
    }

    public int[] TradeItems() {
        return tradeItems;
    }

    public boolean Visited() {
        return visited;
    }

    public void Visited(boolean b) {
        visited = b;
    }

    public int X() {
        return x;
    }

    public void X(int i) {
        x = i;
    }

    public int Y() {
        return y;
    }

    public void Y(int i) {
        y = i;
    }
}
