package org.spacetrader.model.system;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.SerializableObject;
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

    public StarSystem(final StarSystemId id, final int x, final int y, final ShipSize size, final TechLevel techLevel,
                      final PoliticalSystemType politicalSystemType, final SystemPressure systemPressure, final SpecialResource specialResource) {
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

    public StarSystem(final Hashtable hash) {
        super(hash);
        systemId = StarSystemId.FromInt(SerializableObject.GetValueFromHash(hash, "_id", Integer.class));
        x = SerializableObject.GetValueFromHash(hash, "_x", x);
        y = SerializableObject.GetValueFromHash(hash, "_y", y);
        size = ShipSize.FromInt(SerializableObject.GetValueFromHash(hash, "_size", size, Integer.class));
        techLevel = TechLevel.FromInt(SerializableObject.GetValueFromHash(hash, "_techLevel", /*_techLevel*/0, Integer.class));
        politicalSystemType = PoliticalSystemType.FromInt(SerializableObject.GetValueFromHash(hash, "_politicalSystemType", politicalSystemType, Integer.class));
        systemPressure = SystemPressure.FromInt(SerializableObject.GetValueFromHash(hash, "_systemPressure", systemPressure, Integer.class));
        specialResource = SpecialResource.FromInt(SerializableObject.GetValueFromHash(hash, "_specialResource", specialResource, Integer.class));
        specialEventType = SpecialEventType.FromInt(SerializableObject.GetValueFromHash(hash, "_specialEventType", specialEventType, Integer.class));
        tradeItems = SerializableObject.GetValueFromHash(hash, "_tradeItems", tradeItems, int[].class);
        countDown = SerializableObject.GetValueFromHash(hash, "_countDown", countDown);
        visited = SerializableObject.GetValueFromHash(hash, "_visited", visited);
        shipyardId = ShipyardId.FromInt(SerializableObject.GetValueFromHash(hash, "_shipyardId", shipyardId, Integer.class));
    }

    public void initializeTradeItems() {
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            if (ItemTraded(Constants.TradeItems[i])) {
                tradeItems[i] = (Size().getId() + 1)
                        * (ModelUtils.GetRandom(9, 14) - Math.abs(Constants.TradeItems[i].TechTopProduction().ordinal() - TechLevel().ordinal()));
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
                tradeItems[i] = tradeItems[i] - ModelUtils.GetRandom(10) + ModelUtils.GetRandom(10);
                if (tradeItems[i] < 0) {
                    tradeItems[i] = 0;
                }
            } else {
                tradeItems[i] = 0;
            }
        }
    }

    public boolean ItemTraded(final TradeItem item) {
        return ((item.Type() != TradeItemType.Narcotics || PoliticalSystem().DrugsOk())
                && (item.Type() != TradeItemType.Firearms || PoliticalSystem().FirearmsOk()) && TechLevel().ordinal() >= item.TechProduction().ordinal());
    }

    public boolean ItemUsed(final TradeItem item) {
        return ((item.Type() != TradeItemType.Narcotics || PoliticalSystem().DrugsOk())
                && (item.Type() != TradeItemType.Firearms || PoliticalSystem().FirearmsOk()) && TechLevel().ordinal() >= item.TechUsage().ordinal());
    }

    @Override
    public Hashtable Serialize() {
        final Hashtable hash = super.Serialize();
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
        final Game game = Game.getCurrentGame();
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
                        && game.Commander().Worth() > SpecialEvent.MoonCost * 0.8;
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
        return countDown;
    }

    public void CountDown(final int i) {
        countDown = i;
    }

    public boolean DestOk() {
        final Commander comm = Game.getCurrentGame().Commander();
        return this != comm.CurrentSystem() && (Distance() <= comm.getShip().getFuel() || ModelUtils.WormholeExists(comm.CurrentSystem(), this));
    }

    public int Distance() {
        return ModelUtils.distance(this, Game.getCurrentGame().Commander().CurrentSystem());
    }

    public StarSystemId Id() {
        return systemId;
    }

    public CrewMember[] MercenariesForHire() {
        final Commander commander = Game.getCurrentGame().Commander();
        final CrewMember[] mercs = Game.getCurrentGame().Mercenaries();
        final ArrayList<CrewMember> forHire = new ArrayList<>(3);
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

    public void PoliticalSystemType(final PoliticalSystemType pst) {
        politicalSystemType = pst;
    }

    public Shipyard Shipyard() {
        ShipyardId();
        return (shipyardId == ShipyardId.NA ? null : Constants.Shipyards[shipyardId.getId()]);
    }

    public ShipyardId ShipyardId() {
        return shipyardId;
    }

    public void ShipyardId(final ShipyardId si) {
        shipyardId = si;
    }

    public ShipSize Size() {
        return size;
    }

    public SpecialEvent SpecialEvent() {
        SpecialEventType();
        return (specialEventType == SpecialEventType.NA ? null : Constants.SpecialEvents[specialEventType.getId()]);
    }

    public SpecialEventType SpecialEventType() {
        return specialEventType;
    }

    public void SpecialEventType(final SpecialEventType set) {
        specialEventType = set;
    }

    public SpecialResource SpecialResource() {
        return Visited() ? specialResource : SpecialResource.Nothing;
    }

    public SystemPressure SystemPressure() {
        return systemPressure;
    }

    public void SystemPressure(final SystemPressure sp) {
        systemPressure = sp;
    }

    public TechLevel TechLevel() {
        return techLevel;
    }

    public void TechLevel(final TechLevel tl) {
        techLevel = tl;
    }

    public int[] TradeItems() {
        return tradeItems;
    }

    public boolean Visited() {
        return visited;
    }

    public void Visited(final boolean b) {
        visited = b;
    }

    public int X() {
        return x;
    }

    public void X(final int i) {
        x = i;
    }

    public int Y() {
        return y;
    }

    public void Y(final int i) {
        y = i;
    }
}
