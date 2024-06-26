package org.spacetrader.controller;

import org.spacetrader.Constants;
import org.spacetrader.model.*;
import org.spacetrader.model.cargo.CargoBuyOperation;
import org.spacetrader.model.cargo.CargoSellOperation;
import org.spacetrader.model.cargo.TradeItem;
import org.spacetrader.model.cargo.TradeItemType;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.crew.CrewMember;
import org.spacetrader.model.enums.*;
import org.spacetrader.model.events.*;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.ShipSize;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.model.ship.equipment.EquipmentType;
import org.spacetrader.model.ship.equipment.GadgetType;
import org.spacetrader.model.ship.equipment.ShieldType;
import org.spacetrader.model.ship.equipment.WeaponType;
import org.spacetrader.model.system.StarSystem;
import org.spacetrader.ui.*;
import org.spacetrader.util.Utils;
import org.winforms.dialog.Pane;
import org.winforms.dialog.DialogResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

// TODO this should not have a reference to the parent window, it's part of the model, not the controller
public class Game extends SerializableObject {

    private static Game game; // TODO this doesn't work, is a singleton pattern intended, than how to serialize, better have a even bigger singleton (World)
    private final Commander commander;
    // Game Data
    private StarSystem[] universe;
    private int[] wormholes = new int[6];
    private CrewMember[] mercenaries = new CrewMember[Strings.CrewMemberNames.length];
    private Ship dragonfly = new Ship(ShipType.Dragonfly);
    private Ship scarab = new Ship(ShipType.Scarab);
    private Ship scorpion = new Ship(ShipType.Scorpion);
    private Ship spaceMonster = new Ship(ShipType.SpaceMonster);
    private Ship opponent = new Ship(ShipType.Gnat);
    private boolean opponentDisabled;
    private int chanceOfTradeInOrbit = 100;
    private int clicks; // Distance from target system, 0 = arrived
    private boolean raided; // True when the commander has been raided during the trip
    private boolean inspected; // True when the commander has been inspected during the trip
    private boolean tribbleMessage; // Is true if the shipyard on the current system informed you about the tribbles
    private boolean arrivedViaWormhole; // flag to indicate whether player arrived at current planet via wormhole
    private boolean paidForNewspaper; // once you buy a paper on a system, you don't have to pay again.
    private boolean litterWarning; // Warning against littering has been issued.
    private ArrayList<Integer> newsEvents = new ArrayList<>(30);
    // Current Selections
    private Difficulty difficulty = Difficulty.Normal; // Difficulty level
    private boolean cheatEnabled;
    private boolean autoSave;
    private boolean easyEncounters;
    private GameEndType endStatus = GameEndType.NA;
    private EncounterType encounterType = EncounterType.FromInt(0); // Type of current encounter
    private StarSystemId selectedSystemId = StarSystemId.NA; // Current system on chart
    private StarSystemId warpSystemId = StarSystemId.NA; // Target system for warp
    private StarSystemId trackedSystemId = StarSystemId.NA; // The short-range chart will display an arrow towards this system if the value is not null
    private boolean targetingWormhole; // Wormhole selected?
    private int[] buyCargoPrices = new int[10];
    private int[] sellCargoPrices = new int[10];
    // Status of Quests
    private int questStatusArtifact; // 0 = not given yet, 1 = Artifact on board, 2 = Artifact no longer on board (either delivered or lost)
    private int questStatusDragonfly; // 0 = not available, 1 = Go to Baratas, 2 = Go to Melina, 3 = Go to Regulas, 4 = Go to Zalkon, 5 = Dragonfly destroyed, 6 = Got Shield
    private int questStatusExperiment; // 0 = not given yet, 1-11 = days from start; 12 = performed, 13 = cancelled
    private int questStatusGemulon; // 0 = not given yet, 1-7 = days from start, 8 = too late, 9 = in time, 10 = done
    private int questStatusJapori; // 0 = no disease, 1 = Go to Japori (always at least 10 medicine canisters), 2 = Assignment finished or canceled
    private int questStatusJarek; // 0 = not delivered, 1-11 = on board, 12 = delivered
    private int questStatusMoon; // 0 = not bought, 1 = bought, 2 = claimed
    private int questStatusPrincess; // 0 = not available, 1 = Go to Centauri, 2 = Go to Inthara, 3 = Go to Qonos, 4 = Princess Rescued, 5-14 = On Board, 15 = Princess Returned, 16 = Got Quantum Disruptor
    private int questStatusReactor; // 0 = not encountered, 1-20 = days of mission (bays of fuel left = 10 - (ReactorStatus / 2), 21 = delivered, 22 = Done
    private int questStatusScarab; // 0 = not given yet, 1 = not destroyed, 2 = destroyed - upgrade not performed, 3 = destroyed - hull upgrade performed
    private int questStatusSculpture; // 0 = not given yet, 1 = on board, 2 = delivered, 3 = done
    private int questStatusSpaceMonster; // 0 = not available, 1 = Space monster is in Acamar system, 2 = Space monster is destroyed, 3 = Claimed reward
    private int questStatusWild; // 0 = not delivered, 1-11 = on board, 12 = delivered
    private int fabricRipProbability; // if Experiment = 12, this is the probability of being warped to a random planet.
    private boolean justLootedMarie; // flag to indicate whether player looted Marie Celeste
    private boolean canSuperWarp; // Do you have the Portable Singularity on board?
    private int chanceOfVeryRareEncounter = 5;
    private ArrayList<VeryRareEncounter> veryRareEncounters = new ArrayList<>(6); // Array of Very Rare encounters not done yet.
    // Options
    private GameOptions options = new GameOptions(true);
    // The rest of the member variables are not saved between games.
    private MainWindow mainWindow;  // TODO should the game hold a reference to main window? maybe not (mostly used for showing alerts)
    private boolean encounterContinueFleeing;
    private boolean encounterContinueAttacking;
    private boolean encounterCmdrFleeing;
    private boolean encounterCmdrHit;
    private boolean encounterOppFleeingPrev;
    private boolean encounterOppFleeing;
    private boolean encounterOppHit;

    public Game(String name, Difficulty difficulty, int pilot, int fighter, int trader, int engineer, MainWindow mainWindow) {
        game = this;
        this.mainWindow = mainWindow;
        this.difficulty = difficulty;
        // Keep Generating a new universe until PlaceSpecialEvents and PlaceShipyards return true, indicating all special events and shipyards were placed.
        do {
            // generate universe
            universe = new StarSystem[Strings.SystemNames.length];
            int i, j;
            for (i = 0; i < universe.length; i++) {
                StarSystemId id = (StarSystemId.FromInt(i));
                SystemPressure pressure = SystemPressure.None;
                SpecialResource specRes = SpecialResource.Nothing;
                ShipSize size = ShipSize.FromInt(ModelUtils.getRandom(ShipSize.Huge.getId() + 1));
                PoliticalSystem polSys = Constants.PoliticalSystems[ModelUtils.getRandom(Constants.PoliticalSystems.length)];
                TechLevel tech = TechLevel.FromInt(ModelUtils.getRandom(polSys.MinimumTechLevel().ordinal(), polSys.MaximumTechLevel().ordinal() + 1));
                // Galvon must be a Monarchy.
                if (id == StarSystemId.Galvon) {
                    size = ShipSize.Large;
                    polSys = Constants.PoliticalSystems[PoliticalSystemType.Monarchy.getId()];
                    tech = TechLevel.t7;
                }
                if (ModelUtils.getRandom(100) < 15) {
                    pressure = SystemPressure.FromInt(ModelUtils.getRandom(SystemPressure.War.getId(), SystemPressure.Employment.getId() + 1));
                }
                if (ModelUtils.getRandom(5) >= 3) {
                    specRes = SpecialResource.FromInt(ModelUtils.getRandom(SpecialResource.MineralRich.getId(), SpecialResource.Warlike.getId() + 1));
                }
                int x = 0;
                int y = 0;
                if (i < wormholes.length) {
                    // Place the first systems somewhere in the center.
                    x = ((Constants.GalaxyWidth * (1 + 2 * (i % 3))) / 6) - ModelUtils.getRandom(-Constants.CloseDistance + 1, Constants.CloseDistance);
                    y = ((Constants.GalaxyHeight * (i < 3 ? 1 : 3)) / 4) - ModelUtils.getRandom(-Constants.CloseDistance + 1, Constants.CloseDistance);
                    wormholes[i] = i;
                } else {
                    boolean ok = false;
                    while (!ok) {
                        x = ModelUtils.getRandom(1, Constants.GalaxyWidth);
                        y = ModelUtils.getRandom(1, Constants.GalaxyHeight);
                        boolean closeFound = false;
                        boolean tooClose = false;
                        for (j = 0; j < i && !tooClose; j++) {
                            // Minimum distance between any two systems not to be accepted.
                            if (ModelUtils.distance(universe[j], x, y) < Constants.MinDistance) {
                                tooClose = true;
                            }
                            // There should be at least one system which is close enough.
                            if (ModelUtils.distance(universe[j], x, y) < Constants.CloseDistance) {
                                closeFound = true;
                            }
                        }
                        ok = (closeFound && !tooClose);
                    }
                }
                universe[i] = new StarSystem(id, x, y, size, tech, polSys.Type(), pressure, specRes);
            }
            // Randomize the system locations a bit more, otherwise the systems with the first names in the alphabet are all in the center.
            for (i = 0; i < universe.length; i++) {
                j = ModelUtils.getRandom(universe.length);
                if (!ModelUtils.WormholeExists(j, -1)) {
                    int x = universe[i].X();
                    int y = universe[i].Y();
                    universe[i].X(universe[j].X());
                    universe[i].Y(universe[j].Y());
                    universe[j].X(x);
                    universe[j].Y(y);
                    int w = Utils.bruteSeek(wormholes, i);
                    if (w >= 0) {
                        wormholes[w] = j;
                    }
                }
            }
            // Randomize wormhole order
            for (i = 0; i < wormholes.length; i++) {
                j = ModelUtils.getRandom(wormholes.length);
                int w = wormholes[i];
                wormholes[i] = wormholes[j];
                wormholes[j] = w;
            }
        } while (!(PlaceSpecialEvents() && PlaceShipyards()));
        // initialize commander
        CrewMember commanderCrewMember = new CrewMember(CrewMemberId.Commander, pilot, fighter, trader, engineer, StarSystemId.NA);
        commander = new Commander(commanderCrewMember);
        Mercenaries()[CrewMemberId.Commander.getId()] = Commander();
        Strings.CrewMemberNames[CrewMemberId.Commander.getId()] = name;
        while (commander.CurrentSystem() == null) {
            StarSystem system = universe[ModelUtils.getRandom(universe.length)];
            if (system.SpecialEventType() == SpecialEventType.NA
                    && system.TechLevel().ordinal() > TechLevel.t0.ordinal()
                    && system.TechLevel().ordinal() < TechLevel.t7.ordinal()) {
                // Make sure at least three other systems can be reached
                int close = 0;
                for (int i = 0; i < universe.length && close < 3; i++) {
                    if (i != system.Id().getId() && ModelUtils.distance(universe[i], system) <= commander.getShip().FuelTanks()) {
                        close++;
                    }
                }
                if (close >= 3) {
                    commander.CurrentSystem(system);
                }
            }
        }
        commander.CurrentSystem().Visited(true);
        GenerateCrewMemberList();
        CreateShips();
        CalculatePrices(commander.CurrentSystem());
        resetVeryRareEncounters();
        if (this.difficulty.getId() < Difficulty.Normal.getId()) {
            commander.CurrentSystem().SpecialEventType(SpecialEventType.Lottery);
        }
        //TODO: The following code block is run if the commander name is left blank
        // You get $1M, cheat mode on, easy encounters, can super-warp...
        {
            // TODO: JAF - DEBUG
            commander.setCash(1000000);
            cheatEnabled = true;
            easyEncounters = true;
            canSuperWarp = true;
        }
    }


    public Game(Hashtable hash, MainWindow mainWindow) {
        super(hash);
        Game.game = game;
        this.mainWindow = mainWindow;
        String version = SerializableObject.GetValueFromHash(hash, "_version", String.class);
        if (version.compareTo(Constants.CurrentVersion) > 0) {
            throw new FutureVersionException();
        }
        universe = (StarSystem[]) SerializableObject.ArrayListToArray(SerializableObject.GetValueFromHash(hash, "_universe", ArrayList.class), "StarSystem");
        wormholes = SerializableObject.GetValueFromHash(hash, "_wormholes", wormholes, int[].class);
        mercenaries = (CrewMember[]) SerializableObject.ArrayListToArray(SerializableObject.GetValueFromHash(hash, "_mercenaries", ArrayList.class), "CrewMember");
        commander = new Commander(SerializableObject.GetValueFromHash(hash, "_commander", Hashtable.class));
        dragonfly = new Ship(SerializableObject.GetValueFromHash(hash, "_dragonfly", dragonfly.Serialize(), Hashtable.class));
        scarab = new Ship(SerializableObject.GetValueFromHash(hash, "_scarab", scarab.Serialize(), Hashtable.class));
        scorpion = new Ship(SerializableObject.GetValueFromHash(hash, "_scorpion", scorpion.Serialize(), Hashtable.class));
        spaceMonster = new Ship(SerializableObject.GetValueFromHash(hash, "_spaceMonster", spaceMonster.Serialize(), Hashtable.class));
        opponent = new Ship(SerializableObject.GetValueFromHash(hash, "_opponent", opponent.Serialize(), Hashtable.class));
        chanceOfTradeInOrbit = SerializableObject.GetValueFromHash(hash, "_chanceOfTradeInOrbit", chanceOfTradeInOrbit);
        clicks = SerializableObject.GetValueFromHash(hash, "_clicks", clicks);
        raided = SerializableObject.GetValueFromHash(hash, "_raided", raided);
        inspected = SerializableObject.GetValueFromHash(hash, "_inspected", inspected);
        tribbleMessage = SerializableObject.GetValueFromHash(hash, "_tribbleMessage", tribbleMessage);
        arrivedViaWormhole = SerializableObject.GetValueFromHash(hash, "_arrivedViaWormhole", arrivedViaWormhole);
        paidForNewspaper = SerializableObject.GetValueFromHash(hash, "_paidForNewspaper", paidForNewspaper);
        litterWarning = SerializableObject.GetValueFromHash(hash, "_litterWarning", litterWarning);
        newsEvents = new ArrayList<>(Arrays.asList(SerializableObject.GetValueFromHash(hash, "_newsEvents", newsEvents.toArray(new Integer[0]))));
        difficulty = Difficulty.FromInt(SerializableObject.GetValueFromHash(hash, "_difficulty", difficulty, Integer.class));
        cheatEnabled = SerializableObject.GetValueFromHash(hash, "_cheatEnabled", cheatEnabled);
        autoSave = SerializableObject.GetValueFromHash(hash, "_autoSave", autoSave);
        easyEncounters = SerializableObject.GetValueFromHash(hash, "_easyEncounters", easyEncounters);
        endStatus = GameEndType.FromInt(SerializableObject.GetValueFromHash(hash, "_endStatus", endStatus, Integer.class));
        encounterType = EncounterType.FromInt(SerializableObject.GetValueFromHash(hash, "_encounterType", encounterType, Integer.class));
        selectedSystemId = StarSystemId.FromInt(SerializableObject.GetValueFromHash(hash, "_selectedSystemId", selectedSystemId, Integer.class));
        warpSystemId = StarSystemId.FromInt(SerializableObject.GetValueFromHash(hash, "_warpSystemId", warpSystemId, Integer.class));
        trackedSystemId = StarSystemId.FromInt(SerializableObject.GetValueFromHash(hash, "_trackedSystemId", trackedSystemId, Integer.class));
        targetingWormhole = SerializableObject.GetValueFromHash(hash, "_targetWormhole", targetingWormhole);
        buyCargoPrices = SerializableObject.GetValueFromHash(hash, "_pricebuyCargo", buyCargoPrices, int[].class);
        sellCargoPrices = SerializableObject.GetValueFromHash(hash, "_pricesellCargo", sellCargoPrices, int[].class);
        questStatusArtifact = SerializableObject.GetValueFromHash(hash, "_questStatusArtifact", questStatusArtifact);
        questStatusDragonfly = SerializableObject.GetValueFromHash(hash, "_questStatusDragonfly", questStatusDragonfly);
        questStatusExperiment = SerializableObject.GetValueFromHash(hash, "_questStatusExperiment", questStatusExperiment);
        questStatusGemulon = SerializableObject.GetValueFromHash(hash, "_questStatusGemulon", questStatusGemulon);
        questStatusJapori = SerializableObject.GetValueFromHash(hash, "_questStatusJapori", questStatusJapori);
        questStatusJarek = SerializableObject.GetValueFromHash(hash, "_questStatusJarek", questStatusJarek);
        questStatusMoon = SerializableObject.GetValueFromHash(hash, "_questStatusMoon", questStatusMoon);
        questStatusPrincess = SerializableObject.GetValueFromHash(hash, "_questStatusPrincess", questStatusPrincess);
        questStatusReactor = SerializableObject.GetValueFromHash(hash, "_questStatusReactor", questStatusReactor);
        questStatusScarab = SerializableObject.GetValueFromHash(hash, "_questStatusScarab", questStatusScarab);
        questStatusSculpture = SerializableObject.GetValueFromHash(hash, "_questStatusSculpture", questStatusSculpture);
        questStatusSpaceMonster = SerializableObject.GetValueFromHash(hash, "_questStatusSpaceMonster", questStatusSpaceMonster);
        questStatusWild = SerializableObject.GetValueFromHash(hash, "_questStatusWild", questStatusWild);
        fabricRipProbability = SerializableObject.GetValueFromHash(hash, "_fabricRipProbability", fabricRipProbability);
        justLootedMarie = SerializableObject.GetValueFromHash(hash, "_justLootedMarie", justLootedMarie);
        canSuperWarp = SerializableObject.GetValueFromHash(hash, "_canSuperWarp", canSuperWarp);
        chanceOfVeryRareEncounter = SerializableObject.GetValueFromHash(hash, "_chanceOfVeryRareEncounter", chanceOfVeryRareEncounter);
        veryRareEncounters = new ArrayList(
                Arrays.asList(SerializableObject.GetValueFromHash(hash, "_veryRareEncounters", veryRareEncounters.toArray(new Integer[0]))));
        options = new GameOptions(SerializableObject.GetValueFromHash(hash, "_options", options.Serialize(), Hashtable.class));
    }

    public static Game getCurrentGame() {
        return Game.game;
    }

    public static void setCurrentGame(Game game) {
        Game.game = game;
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_version", "2.00");
        hash.put("_universe", SerializableObject.ArrayToArrayList(universe));
        hash.put("_commander", commander.Serialize());
        hash.put("_wormholes", wormholes);
        hash.put("_mercenaries", SerializableObject.ArrayToArrayList(mercenaries));
        hash.put("_dragonfly", dragonfly.Serialize());
        hash.put("_scarab", scarab.Serialize());
        hash.put("_scorpion", scorpion.Serialize());
        hash.put("_spaceMonster", spaceMonster.Serialize());
        hash.put("_opponent", opponent.Serialize());
        hash.put("_chanceOfTradeInOrbit", chanceOfTradeInOrbit);
        hash.put("_clicks", clicks);
        hash.put("_raided", raided);
        hash.put("_inspected", inspected);
        hash.put("_tribbleMessage", tribbleMessage);
        hash.put("_arrivedViaWormhole", arrivedViaWormhole);
        hash.put("_paidForNewspaper", paidForNewspaper);
        hash.put("_litterWarning", litterWarning);
        hash.put("_newsEvents", newsEvents);
        hash.put("_difficulty", difficulty.getId());
        hash.put("_cheatEnabled", cheatEnabled);
        hash.put("_autoSave", autoSave);
        hash.put("_easyEncounters", easyEncounters);
        hash.put("_endStatus", endStatus.getId());
        hash.put("_encounterType", encounterType.getId());
        hash.put("_selectedSystemId", selectedSystemId.getId());
        hash.put("_warpSystemId", warpSystemId.getId());
        hash.put("_trackedSystemId", trackedSystemId.getId());
        hash.put("_targetWormhole", targetingWormhole);
        hash.put("_pricebuyCargo", buyCargoPrices);
        hash.put("_pricesellCargo", sellCargoPrices);
        hash.put("_questStatusArtifact", questStatusArtifact);
        hash.put("_questStatusDragonfly", questStatusDragonfly);
        hash.put("_questStatusExperiment", questStatusExperiment);
        hash.put("_questStatusGemulon", questStatusGemulon);
        hash.put("_questStatusJapori", questStatusJapori);
        hash.put("_questStatusJarek", questStatusJarek);
        hash.put("_questStatusMoon", questStatusMoon);
        hash.put("_questStatusPrincess", questStatusPrincess);
        hash.put("_questStatusReactor", questStatusReactor);
        hash.put("_questStatusScarab", questStatusScarab);
        hash.put("_questStatusSculpture", questStatusSculpture);
        hash.put("_questStatusSpaceMonster", questStatusSpaceMonster);
        hash.put("_questStatusWild", questStatusWild);
        hash.put("_fabricRipProbability", fabricRipProbability);
        hash.put("_justLootedMarie", justLootedMarie);
        hash.put("_canSuperWarp", canSuperWarp);
        hash.put("_chanceOfVeryRareEncounter", chanceOfVeryRareEncounter);
        hash.put("_veryRareEncounters", SerializableObject.ArrayListToIntArray(veryRareEncounters));
        hash.put("_options", options.Serialize());
        return hash;
    }

    private boolean DetermineEncounter() {
        // If there is a specific encounter that needs to happen, it will, otherwise we'll generate a random encounter.
        return DetermineNonRandomEncounter() || DetermineRandomEncounter();
    }

    private boolean DetermineNonRandomEncounter() {
        boolean showEncounter = false;
        // Encounter with space monster
        if (clicks == 1 && WarpSystem().Id() == StarSystemId.Acamar && questStatusSpaceMonster == SpecialEvent.StatusSpaceMonsterAtAcamar) {
            opponent = spaceMonster;
            encounterType = commander.getShip().Cloaked() ? EncounterType.SpaceMonsterIgnore : EncounterType.SpaceMonsterAttack;
            showEncounter = true;
        } else if (arrivedViaWormhole && clicks == 20 && WarpSystem().SpecialEventType() != SpecialEventType.NA
                && WarpSystem().SpecialEvent().getType() == SpecialEventType.ScarabDestroyed
                && questStatusScarab == SpecialEvent.StatusScarabHunting) {
            // Encounter with the stolen Scarab
            opponent = scarab;
            encounterType = commander.getShip().Cloaked() ? EncounterType.ScarabIgnore : EncounterType.ScarabAttack;
            showEncounter = true;
        } else if (clicks == 1 && WarpSystem().Id() == StarSystemId.Zalkon && questStatusDragonfly == SpecialEvent.StatusDragonflyFlyZalkon) {
            // Encounter with stolen Dragonfly
            opponent = Dragonfly();
            encounterType = commander.getShip().Cloaked() ? EncounterType.DragonflyIgnore : EncounterType.DragonflyAttack;
            showEncounter = true;
        } else if (clicks == 1 && WarpSystem().Id() == StarSystemId.Qonos && questStatusPrincess == SpecialEvent.StatusPrincessFlyQonos) {
            // Encounter with kidnappers in the Scorpion
            opponent = scorpion;
            encounterType = commander.getShip().Cloaked() ? EncounterType.ScorpionIgnore : EncounterType.ScorpionAttack;
            showEncounter = true;
        } else if (clicks == 1 && justLootedMarie) {
            // ah, just when you thought you were going to get get away with it...
            GenerateOpponent(OpponentType.Police);
            encounterType = EncounterType.MarieCelestePolice;
            justLootedMarie = false;
            showEncounter = true;
        }
        return showEncounter;
    }

    private boolean DeterminePirateEncounter(boolean mantis) {
        boolean showEncounter = false;
        if (mantis) {
            GenerateOpponent(OpponentType.Mantis);
            encounterType = EncounterType.PirateAttack;
        } else {
            GenerateOpponent(OpponentType.Pirate);
            // If you have a cloak, they don't see you
            if (commander.getShip().Cloaked()) {
                encounterType = EncounterType.PirateIgnore;
            } else if (opponent.Type().getId() > commander.getShip().Type().getId()
                    || opponent.Type().getId() >= ShipType.Grasshopper.getId()
                    || ModelUtils.getRandom(Constants.ReputationScoreElite) > (commander.getReputationScore() * 4)
                    / (1 + opponent.Type().getId())) {
                // Pirates will mostly attack, but they are cowardly: if your rep is too high, they tend to flee
                // if Pirates are in a better ship, they won't flee, even if you have a very scary reputation.
                encounterType = EncounterType.PirateAttack;
            } else {
                encounterType = EncounterType.PirateFlee;
            }
        }
        // If they ignore you or flee and you can't see them, the encounter doesn't take place
        // If you automatically don't want to confront someone who ignores you, the encounter may not take place
        if (encounterType == EncounterType.PirateAttack || !(opponent.Cloaked() || options.getAlwaysIgnorePirates())) {
            showEncounter = true;
        }
        return showEncounter;
    }

    private boolean DeterminePoliceEncounter() {
        boolean showEncounter = false;
        GenerateOpponent(OpponentType.Police);
        // If you are cloaked, they don't see you
        encounterType = EncounterType.PoliceIgnore;
        if (!commander.getShip().Cloaked()) {
            if (commander.getPoliceRecordScore() < Constants.PoliceRecordScoreDubious) {
                // If you're a criminal, the police will tend to attack
                // JAF - fixed this; there was code that didn't do anything.
                // if you're suddenly stuck in a lousy ship, Police won't flee even if you have a fearsome reputation.
                if (opponent.WeaponStrength() > 0
                        && (commander.getReputationScore() < Constants.ReputationScoreAverage
                        || ModelUtils.getRandom(Constants.ReputationScoreElite) > (commander.getReputationScore() / (1 + opponent.Type().getId())))
                        || opponent.Type().getId() > commander.getShip().Type().getId()) {
                    if (commander.getPoliceRecordScore() >= Constants.PoliceRecordScoreCriminal) {
                        getEncounterType();
                        encounterType = EncounterType.PoliceSurrender;
                    } else {
                        encounterType = EncounterType.PoliceAttack;
                    }
                } else if (opponent.Cloaked()) {
                    encounterType = EncounterType.PoliceIgnore;
                } else {
                    encounterType = EncounterType.PoliceFlee;
                }
            } else if (!inspected
                    && (commander.getPoliceRecordScore() < Constants.PoliceRecordScoreClean
                    || (commander.getPoliceRecordScore() < Constants.PoliceRecordScoreLawful && ModelUtils.getRandom(12 - difficulty.getId()) < 1)
                    || (commander.getPoliceRecordScore() >= Constants.PoliceRecordScoreLawful && ModelUtils.getRandom(40) == 0))) {
                // If you're reputation is dubious, the police will inspect you
                // If your record is clean, the police will inspect you with a chance of 10% on Normal
                // If your record indicates you are a lawful trader, the chance on inspection drops to 2.5%
                encounterType = EncounterType.PoliceInspect;
                inspected = true;
            }
        }
        // If they ignore you or flee and you can't see them, the encounter doesn't take place
        // If you automatically don't want to confront someone who ignores you, the encounter may not take place. Otherwise it will - JAF
        if (encounterType == EncounterType.PoliceAttack || encounterType == EncounterType.PoliceInspect
                || !(opponent.Cloaked() || options.getAlwaysIgnorePolice())) {
            showEncounter = true;
        }
        return showEncounter;
    }

    private boolean DetermineRandomEncounter() {
        boolean showEncounter = false;
        boolean mantis = false;
        boolean pirate = false;
        boolean police = false;
        boolean trader = false;
        if (WarpSystem().Id() == StarSystemId.Gemulon && questStatusGemulon == SpecialEvent.StatusGemulonTooLate) {
            if (ModelUtils.getRandom(10) > 4) {
                mantis = true;
            }
        } else {
            // Check if it is time for an encounter
            int encounter = ModelUtils.getRandom(44 - (2 * difficulty.getId()));
            int policeModifier = Math.max(1, 3 - PoliceRecord.getPoliceRecordFromScore(commander.getPoliceRecordScore()).getType().getId());
            // encounters are half as likely if you're in a flea.
            if (commander.getShip().Type() == ShipType.Flea) {
                encounter *= 2;
            }
            if (encounter < WarpSystem().PoliticalSystem().ActivityPirates().getId()) { // When you are already raided, other pirates have little to gain
                pirate = !raided;
            } else if (encounter < WarpSystem().PoliticalSystem().ActivityPirates().getId() + WarpSystem().PoliticalSystem().ActivityPolice().getId() * policeModifier) {
                // policeModifier adapts itself to your criminal record: you'll encounter more police if you are a hardened criminal.
                police = true;
            } else if (encounter
                    < WarpSystem().PoliticalSystem().ActivityPirates().getId()
                    + WarpSystem().PoliticalSystem().ActivityPolice().getId() * policeModifier
                    + WarpSystem().PoliticalSystem().ActivityTraders().getId()) {
                trader = true;
            } else if (commander.getShip().WildOnBoard() && WarpSystem().Id() == StarSystemId.Kravat) {
                // if you're coming in to Kravat & you have Wild onboard, there'll be swarms o' cops.
                police = ModelUtils.getRandom(100) < 100 / Math.max(2, Math.min(4, 5 - difficulty.getId()));
            } else if (commander.getShip().ArtifactOnBoard() && ModelUtils.getRandom(20) <= 3) {
                mantis = true;
            }
        }
        if (police) {
            showEncounter = DeterminePoliceEncounter();
        } else if (pirate || mantis) {
            showEncounter = DeterminePirateEncounter(mantis);
        } else if (trader) {
            showEncounter = DetermineTraderEncounter();
        } else if (commander.getDays() > 10 && ModelUtils.getRandom(1000) < chanceOfVeryRareEncounter && !veryRareEncounters.isEmpty()) {
            showEncounter = DetermineVeryRareEncounter();
        }
        return showEncounter;
    }

    private boolean DetermineTraderEncounter() {
        boolean showEncounter = false;
        GenerateOpponent(OpponentType.Trader);
        // If you are cloaked, they don't see you
        encounterType = EncounterType.TraderIgnore;
        if (!commander.getShip().Cloaked()) {
            // If you're a criminal, traders tend to flee if you've got at least some reputation
            if (!commander.getShip().Cloaked() && commander.getPoliceRecordScore() <= Constants.PoliceRecordScoreCriminal
                    && ModelUtils.getRandom(Constants.ReputationScoreElite) <= (commander.getReputationScore() * 10) / (1 + opponent.Type().getId())) {
                encounterType = EncounterType.TraderFlee;
            } else if (ModelUtils.getRandom(1000) < chanceOfTradeInOrbit) { // Will there be trade in orbit?
                if (commander.getShip().FreeCargoBays() > 0 && opponent.HasTradeableItems()) {
                    encounterType = EncounterType.TraderSell;
                } else if (commander.getShip().HasTradeableItems()) {
                    // we fudge on whether the trader has capacity to carry the stuff he's buying.
                    encounterType = EncounterType.TraderBuy;
                }
            }
        }
        // If they ignore you or flee and you can't see them, the encounter doesn't take place
        // If you automatically don't want to confront someone who ignores you, the encounter may not take place; otherwise it will.
        if (!opponent.Cloaked()
                && !(options.getAlwaysIgnoreTraders() && (encounterType == EncounterType.TraderIgnore || encounterType == EncounterType.TraderFlee))
                && !((encounterType == EncounterType.TraderBuy || encounterType == EncounterType.TraderSell) && options.getAlwaysIgnoreTradeInOrbit())) {
            showEncounter = true;
        }
        return showEncounter;
    }

    private boolean DetermineVeryRareEncounter() {
        boolean showEncounter = false;
        // Very Rare Random Events:
        // 1. Encounter the abandoned Marie Celeste, which you may loot.
        // 2. Captain Ahab will trade your Reflective Shield for skill points in Piloting.
        // 3. Captain Conrad will trade your Military Laser for skill points in Engineering.
        // 4. Captain Huie will trade your Military Laser for points in Trading.
        // 5. Encounter an out-of-date bottle of Captain Marmoset's Skill Tonic. This will affect skills depending on game difficulty level.
        // 6. Encounter a good bottle of Captain Marmoset's Skill Tonic, which will invoke IncreaseRandomSkill one or two times, depending on game difficulty.
        switch (veryRareEncounters.get(ModelUtils.getRandom(veryRareEncounters.size()))) {
            case MarieCeleste:
                // Marie Celeste cannot be at Acamar, Qonos, or Zalkon as it may cause problems with the Space Monster, Scorpion, or Dragonfly
                if (clicks > 1 && commander.getCurrentSystemId() != StarSystemId.Acamar
                        && commander.getCurrentSystemId() != StarSystemId.Zalkon
                        && commander.getCurrentSystemId() != StarSystemId.Qonos) {
                    veryRareEncounters.remove(VeryRareEncounter.MarieCeleste);
                    encounterType = EncounterType.MarieCeleste;
                    GenerateOpponent(OpponentType.Trader);
                    Arrays.fill(opponent.Cargo(), 0);
                    opponent.Cargo()[TradeItemType.Narcotics.getId()] = Math.min(opponent.CargoBays(), 5);
                    showEncounter = true;
                }
                break;
            case CaptainAhab:
                if (commander.getShip().HasShield(ShieldType.Reflective) && commander.Pilot() < 10
                        && commander.getPoliceRecordScore() > Constants.PoliceRecordScoreCriminal) {
                    veryRareEncounters.remove(VeryRareEncounter.CaptainAhab);
                    getEncounterType();
                    encounterType = EncounterType.CaptainAhab;
                    GenerateOpponent(OpponentType.FamousCaptain);
                    showEncounter = true;
                }
                break;
            case CaptainConrad:
                if (commander.getShip().HasWeapon(WeaponType.MilitaryLaser, true) && commander.Engineer() < 10
                        && commander.getPoliceRecordScore() > Constants.PoliceRecordScoreCriminal) {
                    veryRareEncounters.remove(VeryRareEncounter.CaptainConrad);
                    getEncounterType();
                    encounterType = EncounterType.CaptainConrad;
                    GenerateOpponent(OpponentType.FamousCaptain);

                    showEncounter = true;
                }
                break;
            case CaptainHuie:
                if (commander.getShip().HasWeapon(WeaponType.MilitaryLaser, true) && commander.Trader() < 10
                        && commander.getPoliceRecordScore() > Constants.PoliceRecordScoreCriminal) {
                    veryRareEncounters.remove(VeryRareEncounter.CaptainHuie);
                    getEncounterType();
                    encounterType = EncounterType.CaptainHuie;
                    GenerateOpponent(OpponentType.FamousCaptain);
                    showEncounter = true;
                }
                break;
            case BottleOld:
                veryRareEncounters.remove(VeryRareEncounter.BottleOld);
                encounterType = EncounterType.BottleOld;
                GenerateOpponent(OpponentType.Bottle);
                showEncounter = true;
                break;
            case BottleGood:
                veryRareEncounters.remove(VeryRareEncounter.BottleGood);
                encounterType = EncounterType.BottleGood;
                GenerateOpponent(OpponentType.Bottle);
                showEncounter = true;
                break;
        }
        return showEncounter;
    }

    private boolean EncounterExecuteAttack(Ship attacker, Ship defender, boolean fleeing) {
        boolean hit = false;
        // On beginner level, if you flee, you will escape unharmed.
        // Otherwise, Fighterskill attacker is pitted against pilotskill defender;
        // if defender is fleeing the attacker has a free shot, but the chance to hit is smaller
        // JAF - if the opponent is disabled and attacker has targeting system, they WILL be hit.
        if (!(difficulty == Difficulty.Beginner && defender.CommandersShip() && fleeing) && (attacker.CommandersShip() && opponentDisabled
                && attacker.HasGadget(GadgetType.TargetingSystem) || ModelUtils.getRandom(attacker.Fighter() + defender.getSize().getId()) >= (fleeing ? 2 : 1)
                * ModelUtils.getRandom(5 + defender.Pilot() / 2))) {
            // If the defender is disabled, it only takes one shot to destroy it completely.
            if (attacker.CommandersShip() && opponentDisabled) {
                defender.setHull(0);
            } else {
                int attackerLasers = attacker.WeaponStrength(WeaponType.PulseLaser, WeaponType.MorgansLaser);
                int attackerDisruptors = attacker.WeaponStrength(WeaponType.PhotonDisruptor, WeaponType.QuantumDisruptor);
                if (defender.Type() == ShipType.Scarab) {
                    attackerLasers -= attacker.WeaponStrength(WeaponType.BeamLaser, WeaponType.MilitaryLaser);
                    attackerDisruptors -= attacker.WeaponStrength(WeaponType.PhotonDisruptor, WeaponType.PhotonDisruptor);
                }
                int attackerWeapons = attackerLasers + attackerDisruptors;
                int disrupt = 0;
                // Attempt to disable the opponent if they're not already disabled, their shields are down, we have disabling weapons, and the option is checked.
                if (defender.Disableable() && defender.ShieldCharge() == 0 && !opponentDisabled
                        && options.getDisableOpponents() && attackerDisruptors > 0) {
                    disrupt = ModelUtils.getRandom(attackerDisruptors * (100 + 2 * attacker.Fighter()) / 100);
                } else {
                    int damage = attackerWeapons == 0 ? 0 : ModelUtils.getRandom(attackerWeapons * (100 + 2 * attacker.Fighter()) / 100);
                    if (damage > 0) {
                        hit = true;
                        // Reactor on board -- damage is boosted!
                        if (defender.ReactorOnBoard()) {
                            damage *= (int) (1 + (difficulty.getId() + 1) * (difficulty.getId() < Difficulty.Normal.getId() ? 0.25 : 0.33));
                        }
                        // First, shields are depleted
                        for (int i = 0; i < defender.Shields().length && defender.Shields()[i] != null && damage > 0; i++) {
                            int applied = Math.min(defender.Shields()[i].getCharge(), damage);
                            defender.Shields()[i].setCharge(defender.Shields()[i].getCharge() - applied);
                            damage -= applied;
                        }
                        // If there still is damage after the shields have been depleted, this is subtracted from the hull, modified by the engineering skill of the defender.
                        // JAF - If the player only has disabling weapons, no damage will be done to the hull.
                        if (damage > 0) {
                            damage = Math.max(1, damage - ModelUtils.getRandom(defender.Engineer()));
                            disrupt = damage * attackerDisruptors / attackerWeapons;
                            // Only that damage coming from Lasers will deplete the hull.
                            damage -= disrupt;
                            // At least 2 shots on Normal level are needed to destroy the hull
                            // (3 on Easy, 4 on Beginner, 1 on Hard or Impossible). For opponents, it is always 2.
                            damage = Math.min(damage, defender.HullStrength() / (defender.CommandersShip() ? Math.max(1, Difficulty.Impossible.getId()
                                    - difficulty.getId()) : 2));
                            // If the hull is hardened, damage is halved.
                            if (questStatusScarab == SpecialEvent.StatusScarabDone) {
                                damage /= 2;
                            }
                            defender.setHull(Math.max(0, defender.getHull() - damage));
                        }
                    }
                }
                // Did the opponent get disabled? (Disruptors are 3 times more effective against the ship's systems than they are against the shields).
                if (defender.getHull() > 0 && defender.Disableable() && ModelUtils.getRandom(100) < disrupt * Constants.DisruptorSystemsMultiplier * 100 / defender.getHull()) {
                    setOpponentDisabled(true);
                }
                // Make sure the Scorpion doesn't get destroyed.
                if (defender.Type() == ShipType.Scorpion && defender.getHull() == 0) {
                    defender.setHull(1);
                    setOpponentDisabled(true);
                }
            }
        }
        return hit;
    }

    private boolean FindDistantSystem(StarSystemId baseSystem, SpecialEventType specEvent) {
        int bestDistance = 999;
        int system = -1;
        for (int i = 0; i < universe.length; i++) {
            int distance = ModelUtils.distance(universe[baseSystem.getId()], universe[i]);
            if (distance >= 70 && distance < bestDistance && universe[i].SpecialEventType() == SpecialEventType.NA) {
                system = i;
                bestDistance = distance;
            }
        }
        if (system >= 0) {
            universe[system].SpecialEventType(specEvent);
        }
        return (system >= 0);
    }

    private boolean PlaceShipyards() {
        boolean goodUniverse = true;
        ArrayList<Integer> systemIdList = new ArrayList<>();
        for (int system = 0; system < universe.length; system++) {
            if (universe[system].TechLevel() == TechLevel.t7) {
                systemIdList.add(system);
            }
        }
        if (systemIdList.size() < Constants.Shipyards.length) {
            goodUniverse = false;
        } else {
            // Assign the shipyards to High-Tech systems.
            for (int shipyard = 0; shipyard < Constants.Shipyards.length; shipyard++) {
                universe[systemIdList.get(ModelUtils.getRandom(systemIdList.size()))].ShipyardId(ShipyardId.FromInt(shipyard));
            }
        }
        return goodUniverse;
    }

    private boolean PlaceSpecialEvents() {
        boolean goodUniverse = true;
        int system;
        universe[StarSystemId.Baratas.getId()].SpecialEventType(SpecialEventType.DragonflyBaratas);
        universe[StarSystemId.Melina.getId()].SpecialEventType(SpecialEventType.DragonflyMelina);
        universe[StarSystemId.Regulas.getId()].SpecialEventType(SpecialEventType.DragonflyRegulas);
        universe[StarSystemId.Zalkon.getId()].SpecialEventType(SpecialEventType.DragonflyDestroyed);
        universe[StarSystemId.Daled.getId()].SpecialEventType(SpecialEventType.ExperimentStopped);
        universe[StarSystemId.Gemulon.getId()].SpecialEventType(SpecialEventType.GemulonRescued);
        universe[StarSystemId.Japori.getId()].SpecialEventType(SpecialEventType.JaporiDelivery);
        universe[StarSystemId.Devidia.getId()].SpecialEventType(SpecialEventType.JarekGetsOut);
        universe[StarSystemId.Utopia.getId()].SpecialEventType(SpecialEventType.MoonRetirement);
        universe[StarSystemId.Nix.getId()].SpecialEventType(SpecialEventType.ReactorDelivered);
        universe[StarSystemId.Acamar.getId()].SpecialEventType(SpecialEventType.SpaceMonsterKilled);
        universe[StarSystemId.Kravat.getId()].SpecialEventType(SpecialEventType.WildGetsOut);
        universe[StarSystemId.Endor.getId()].SpecialEventType(SpecialEventType.SculptureDelivered);
        universe[StarSystemId.Galvon.getId()].SpecialEventType(SpecialEventType.Princess);
        universe[StarSystemId.Centauri.getId()].SpecialEventType(SpecialEventType.PrincessCentauri);
        universe[StarSystemId.Inthara.getId()].SpecialEventType(SpecialEventType.PrincessInthara);
        universe[StarSystemId.Qonos.getId()].SpecialEventType(SpecialEventType.PrincessQonos);
        // Assign a wormhole location endpoint for the Scarab.
        for (system = 0; system < wormholes.length && universe[wormholes[system]].SpecialEventType() != SpecialEventType.NA; system++) {
        }
        if (system < wormholes.length) {
            universe[wormholes[system]].SpecialEventType(SpecialEventType.ScarabDestroyed);
        } else {
            goodUniverse = false;
        }
        // Find a Hi-Tech system without a special event.
        if (goodUniverse) {
            for (system = 0; system < universe.length && !(universe[system].SpecialEventType() == SpecialEventType.NA && universe[system].TechLevel() == TechLevel.t7); system++) {
            }
            if (system < universe.length) {
                universe[system].SpecialEventType(SpecialEventType.ArtifactDelivery);
            } else {
                goodUniverse = false;
            }
        }
        // Find the closest system at least 70 parsecs away from Nix that doesn't already have a special event.
        if (goodUniverse && !FindDistantSystem(StarSystemId.Nix, SpecialEventType.Reactor)) {
            goodUniverse = false;
        }
        // Find the closest system at least 70 parsecs away from Gemulon that doesn't already have a special event.
        if (goodUniverse && !FindDistantSystem(StarSystemId.Gemulon, SpecialEventType.Gemulon)) {
            goodUniverse = false;
        }
        // Find the closest system at least 70 parsecs away from Daled that doesn't already have a special event.
        if (goodUniverse && !FindDistantSystem(StarSystemId.Daled, SpecialEventType.Experiment)) {
            goodUniverse = false;
        }
        // Find the closest system at least 70 parsecs away from Endor that doesn't already have a special event.
        if (goodUniverse && !FindDistantSystem(StarSystemId.Endor, SpecialEventType.Sculpture)) {
            goodUniverse = false;
        }
        // Assign the rest of the events randomly.
        if (goodUniverse) {
            for (int i = 0; i < Constants.SpecialEvents.length; i++) {
                for (int j = 0; j < Constants.SpecialEvents[i].getOccurrence(); j++) {
                    do {
                        system = ModelUtils.getRandom(universe.length);
                    } while (universe[system].SpecialEventType() != SpecialEventType.NA);
                    universe[system].SpecialEventType(Constants.SpecialEvents[i].getType());
                }
            }
        }
        return goodUniverse;
    }

    private void Arrival() {
        commander.CurrentSystem(WarpSystem());
        commander.CurrentSystem().Visited(true);
        paidForNewspaper = false;
        if (TrackedSystem() == commander.CurrentSystem() && options.getTrackAutoOff()) {
            trackedSystemId = StarSystemId.NA;
        }
        ArrivalCheckReactor();
        ArrivalCheckTribbles();
        ArrivalCheckDebt();
        ArrivalPerformRepairs();
        ArrivalUpdatePressuresAndQuantities();
        ArrivalCheckEasterEgg();
        CalculatePrices(commander.CurrentSystem());
        addNewsEventsOnArrival();
        if (options.getNewsAutoShow()) {
            showNewspaper();
        }
    }

    private void ArrivalCheckDebt() {
        // Check for Large Debt - 06/30/01 SRA
        if (commander.getDebt() >= Constants.DebtWarning) {
            DialogAlert.Alert(AlertType.DebtWarning, mainWindow);
        } else if (commander.getDebt() > 0 && options.getRemindLoans() && commander.getDays() % 5 == 0) { // Debt Reminder
            DialogAlert.Alert(AlertType.DebtReminder, mainWindow, ModelUtils.multiples(commander.getDebt(), Strings.MoneyUnit));
        }
    }

    private void ArrivalCheckEasterEgg() {
        /* This Easter Egg gives the commander a Lighting Shield */
        if (commander.CurrentSystem().Id() == StarSystemId.Og) {
            boolean egg = true;
            for (int i = 0; i < commander.getShip().Cargo().length && egg; i++) {
                if (commander.getShip().Cargo()[i] != 1) {
                    egg = false;
                }
            }
            if (egg && commander.getShip().FreeSlotsShield() > 0) {
                DialogAlert.Alert(AlertType.Egg, mainWindow);
                commander.getShip().addEquipment(Constants.Shields[ShieldType.Lightning.id]);
                for (int i = 0; i < commander.getShip().Cargo().length; i++) {
                    commander.getShip().Cargo()[i] = 0;
                    commander.PriceCargo()[i] = 0;
                }
            }
        }
    }

    private void ArrivalCheckReactor() {
        if (questStatusReactor == SpecialEvent.StatusReactorDate) {
            DialogAlert.Alert(AlertType.ReactorMeltdown, mainWindow);
            questStatusReactor = SpecialEvent.StatusReactorNotStarted;
            if (commander.getShip().getEscapePod()) {
                escapeWithPod();
            } else {
                DialogAlert.Alert(AlertType.ReactorDestroyed, mainWindow);
                throw new GameEndException(GameEndType.Killed);
            }
        } else {
            // Reactor warnings:
            if (questStatusReactor == SpecialEvent.StatusReactorFuelOk + 1) { // now they know the quest has a time constraint!
                DialogAlert.Alert(AlertType.ReactorWarningFuel, mainWindow);
            } else if (questStatusReactor == SpecialEvent.StatusReactorDate - 4) { // better deliver it soon!
                DialogAlert.Alert(AlertType.ReactorWarningFuelGone, mainWindow);
            } else if (questStatusReactor == SpecialEvent.StatusReactorDate - 2) { // last warning!
                DialogAlert.Alert(AlertType.ReactorWarningTemp, mainWindow);
            }
        }
    }

    private void ArrivalCheckTribbles() {
        Ship ship = commander.getShip();
        if (ship.getTribbles() > 0) {
            int previousTribbles = ship.getTribbles();
            int narc = TradeItemType.Narcotics.getId();
            int food = TradeItemType.Food.getId();
            if (ship.ReactorOnBoard()) {
                if (ship.getTribbles() < 20) {
                    ship.setTribbles(0);
                    DialogAlert.Alert(AlertType.TribblesAllDied, mainWindow);
                } else {
                    ship.setTribbles(ship.getTribbles() / 2);
                    DialogAlert.Alert(AlertType.TribblesHalfDied, mainWindow);
                }
            } else if (ship.Cargo()[narc] > 0) {
                int dead = Math.min(1 + ModelUtils.getRandom(3), ship.Cargo()[narc]);
                commander.PriceCargo()[narc] = commander.PriceCargo()[narc] * (ship.Cargo()[narc] - dead) / ship.Cargo()[narc];
                ship.Cargo()[narc] -= dead;
                ship.Cargo()[TradeItemType.Furs.getId()] += dead;
                ship.setTribbles(ship.getTribbles() - Math.min(dead * (ModelUtils.getRandom(5) + 98), ship.getTribbles() - 1));
                DialogAlert.Alert(AlertType.TribblesMostDied, mainWindow);
            } else {
                if (ship.Cargo()[food] > 0 && ship.getTribbles() < Constants.MaxTribbles) {
                    int eaten = ship.Cargo()[food] - ModelUtils.getRandom(ship.Cargo()[food]);
                    commander.PriceCargo()[food] -= commander.PriceCargo()[food] * eaten / ship.Cargo()[food];
                    ship.Cargo()[food] -= eaten;
                    ship.setTribbles(ship.getTribbles() + (eaten * 100));
                    DialogAlert.Alert(AlertType.TribblesAteFood, mainWindow);
                }
                if (ship.getTribbles() < Constants.MaxTribbles) {
                    ship.setTribbles(ship.getTribbles() + (1 + ModelUtils.getRandom(ship.Cargo()[food] > 0 ? ship.getTribbles() : ship.getTribbles() / 2)));
                }
                if (ship.getTribbles() > Constants.MaxTribbles) {
                    ship.setTribbles(Constants.MaxTribbles);
                }
                if ((previousTribbles < 100 && ship.getTribbles() >= 100)
                        || (previousTribbles < 1000 && ship.getTribbles() >= 1000)
                        || (previousTribbles < 10000 && ship.getTribbles() >= 10000)
                        || (previousTribbles < 50000 && ship.getTribbles() >= 50000)
                        || (previousTribbles < Constants.MaxTribbles && ship.getTribbles() == Constants.MaxTribbles)) {
                    String qty = ship.getTribbles() == Constants.MaxTribbles ? Strings.TribbleDangerousNumber : ModelUtils.formatNumber(ship.getTribbles());
                    DialogAlert.Alert(AlertType.TribblesInspector, mainWindow, qty);
                }
            }
            tribbleMessage = false;
        }
    }

    private void ArrivalPerformRepairs() {
        Ship ship = commander.getShip();
        if (ship.getHull() < ship.HullStrength()) {
            ship.setHull(ship.getHull() + Math.min(ship.HullStrength() - ship.getHull(), ModelUtils.getRandom(ship.Engineer())));
        }
        for (int i = 0; i < ship.Shields().length; ++i) {
            if (ship.Shields()[i] != null) {
                ship.Shields()[i].setCharge(ship.Shields()[i].Power());
            }
        }
        boolean fuelOk = true;
        int toAdd = ship.FuelTanks() - ship.getFuel();
        if (options.getAutoFuel() && toAdd > 0) {
            if (commander.getCash() >= toAdd * ship.getFuelCost()) {
                ship.setFuel(ship.getFuel() + toAdd);
                commander.setCash(commander.getCash() - (toAdd * ship.getFuelCost()));
            } else {
                fuelOk = false;
            }
        }
        boolean repairOk = true;
        toAdd = ship.HullStrength() - ship.getHull();
        if (options.getAutoRepair() && toAdd > 0) {
            if (commander.getCash() >= toAdd * ship.getRepairCost()) {
                ship.setHull(ship.getHull() + toAdd);
                commander.setCash(commander.getCash() - (toAdd * ship.getRepairCost()));
            } else {
                repairOk = false;
            }
        }
        if (!fuelOk && !repairOk) {
            DialogAlert.Alert(AlertType.ArrivalIFFuelRepairs, mainWindow);
        } else if (!fuelOk) {
            DialogAlert.Alert(AlertType.ArrivalIFFuel, mainWindow);
        } else if (!repairOk) {
            DialogAlert.Alert(AlertType.ArrivalIFRepairs, mainWindow);
        }
    }

    private void ArrivalUpdatePressuresAndQuantities() {
        for (StarSystem starSystem : universe) {
            if (ModelUtils.getRandom(100) < 15) {
                starSystem.SystemPressure((SystemPressure.FromInt(starSystem.SystemPressure() == SystemPressure.None
                        ? ModelUtils.getRandom(SystemPressure.War.getId(), SystemPressure.Employment.getId() + 1) : SystemPressure.None.getId())));
            }
            if (starSystem.CountDown() > 0) {
                starSystem.CountDown(starSystem.CountDown() - 1);
                if (starSystem.CountDown() > CountDownStart()) {
                    starSystem.CountDown(CountDownStart());
                } else if (starSystem.CountDown() <= 0) {
                    starSystem.initializeTradeItems();
                } else {
                    for (int j = 0; j < Constants.TradeItems.length; j++) {
                        if (WarpSystem().ItemTraded(Constants.TradeItems[j])) {
                            starSystem.TradeItems()[j] = Math.max(0, starSystem.TradeItems()[j] + ModelUtils.getRandom(-4, 5));
                        }
                    }
                }
            }
        }
    }

    private void CalculatePrices(StarSystem system) {
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            int price = Constants.TradeItems[i].getStandardPrice(system);
            if (price > 0) {
                // In case of a special status, adapt price accordingly
                if (Constants.TradeItems[i].PressurePriceHike() == system.SystemPressure()) {
                    price = price * 3 / 2;
                }
                // Randomize price a bit
                int variance = Math.min(Constants.TradeItems[i].PriceVariance(), price - 1);
                price += ModelUtils.getRandom(-variance, variance + 1);
                // Criminals have to pay off an intermediary
                if (commander.getPoliceRecordScore() < Constants.PoliceRecordScoreDubious) {
                    price = price * 90 / 100;
                }
            }
            sellCargoPrices[i] = price;
        }
        recalculateBuyPrices(system);
    }

    private void buyCargo(int tradeItem, boolean max, Pane owner, CargoBuyOperation op) {
        int freeBays = commander.getShip().FreeCargoBays();
        int[] items = null;
        int unitPrice = 0;
        int cashToSpend = commander.getCash();
        switch (op) {
            case BuySystem:
                freeBays = Math.max(0, commander.getShip().FreeCargoBays() - options.getLeaveEmpty());
                items = commander.CurrentSystem().TradeItems();
                unitPrice = buyCargoPrices[tradeItem];
                cashToSpend = commander.CashToSpend();
                break;
            case BuyTrader:
                items = opponent.Cargo();
                TradeItem item = Constants.TradeItems[tradeItem];
                int chance = item.isIllegal() ? 45 : 10;
                double adj = ModelUtils.getRandom(100) < chance ? 1.1 : (item.isIllegal() ? 0.8 : 0.9);
                unitPrice = Math.min(item.MaxTradePrice(), Math.max(item.MinTradePrice(), (int) Math.round(buyCargoPrices[tradeItem] * adj / item.RoundOff()) * item.RoundOff()));
                break;
            case InPlunder:
                items = opponent.Cargo();
                break;
        }
        if (op == CargoBuyOperation.BuySystem && commander.getDebt() > Constants.DebtTooLarge) {
            DialogAlert.Alert(AlertType.DebtTooLargeTrade, owner);
        } else if (op == CargoBuyOperation.BuySystem && (items[tradeItem] <= 0 || unitPrice <= 0)) {
            DialogAlert.Alert(AlertType.CargoNoneAvailable, owner);
        } else if (freeBays == 0) {
            DialogAlert.Alert(AlertType.CargoNoEmptyBays, owner);
        } else if (op != CargoBuyOperation.InPlunder && cashToSpend < unitPrice) {
            DialogAlert.Alert(AlertType.CargoIF, owner);
        } else {
            int qty = 0;
            int maxAmount = Math.min(freeBays, items[tradeItem]);
            if (op == CargoBuyOperation.BuySystem) {
                maxAmount = Math.min(maxAmount, commander.CashToSpend() / unitPrice);
            }
            if (max) {
                qty = maxAmount;
            } else {
                DialogCargoBuy form = new DialogCargoBuy(tradeItem, maxAmount, op);
                if (form.ShowDialog(owner) == DialogResult.Ok) {
                    qty = form.Amount();
                }
            }
            if (qty > 0) {
                int totalPrice = qty * unitPrice;
                commander.getShip().Cargo()[tradeItem] += qty;
                items[tradeItem] -= qty;
                commander.setCash(commander.getCash() - totalPrice);
                commander.PriceCargo()[tradeItem] += totalPrice;
            }
        }
    }

    private void sellCargo(int tradeItem, boolean all, Pane owner, CargoSellOperation op) {
        int qtyInHand = commander.getShip().Cargo()[tradeItem];
        int unitPrice;
        switch (op) {
            case SellSystem:
                unitPrice = sellCargoPrices[tradeItem];
                break;
            case SellTrader:
                TradeItem item = Constants.TradeItems[tradeItem];
                int chance = item.isIllegal() ? 45 : 10;
                double adj = ModelUtils.getRandom(100) < chance ? (item.isIllegal() ? 0.8 : 0.9) : 1.1;
                unitPrice = Math.min(item.MaxTradePrice(), Math.max(item.MinTradePrice(), (int) Math.round(sellCargoPrices[tradeItem] * adj / item.RoundOff()) * item.RoundOff()));
                break;
            default:
                unitPrice = 0;
                break;
        }
        if (qtyInHand == 0) {
            DialogAlert.Alert(AlertType.CargoNoneToSell, owner, Strings.sellCargoOps[op.getId()]);
        } else if (op == CargoSellOperation.SellSystem && unitPrice <= 0) {
            DialogAlert.Alert(AlertType.CargoNotInterested, owner);
        } else {
            if (op != CargoSellOperation.Jettison || litterWarning || commander.getPoliceRecordScore() <= Constants.PoliceRecordScoreDubious
                    || DialogAlert.Alert(AlertType.EncounterDumpWarning, owner) == DialogResult.Yes) {
                int unitCost = 0;
                int maxAmount = (op == CargoSellOperation.SellTrader) ? Math.min(qtyInHand, opponent.FreeCargoBays()) : qtyInHand;
                if (op == CargoSellOperation.Dump) {
                    unitCost = 5 * (difficulty.getId() + 1);
                    maxAmount = Math.min(maxAmount, commander.CashToSpend() / unitCost);
                }
                int price = unitPrice > 0 ? unitPrice : -unitCost;
                int qty = 0;
                if (all) {
                    qty = maxAmount;
                } else {
                    DialogCargoSell form = new DialogCargoSell(tradeItem, maxAmount, op, price);
                    if (form.ShowDialog(owner) == DialogResult.Ok) {
                        qty = form.Amount();
                    }
                }
                if (qty > 0) {
                    int totalPrice = qty * price;
                    commander.getShip().Cargo()[tradeItem] -= qty;
                    commander.PriceCargo()[tradeItem] = (commander.PriceCargo()[tradeItem] * (qtyInHand - qty)) / qtyInHand;
                    commander.setCash(commander.getCash() + totalPrice);
                    if (op == CargoSellOperation.Jettison) {
                        if (ModelUtils.getRandom(10) < difficulty.getId() + 1) {
                            if (commander.getPoliceRecordScore() > Constants.PoliceRecordScoreDubious) {
                                commander.setPoliceRecordScore(Constants.PoliceRecordScoreDubious);
                            } else {
                                commander.setPoliceRecordScore(commander.getPoliceRecordScore() - 1);
                            }
                            addNewsEvent(NewsEvent.CaughtLittering);
                        }
                    }
                }
            }
        }
    }

    private void CreateShips() {
        // set the details of the Dragonfly...
        Dragonfly().Crew()[0] = Mercenaries()[CrewMemberId.Dragonfly.getId()];
        Dragonfly().addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
        Dragonfly().addEquipment(Constants.WeaponObjects[WeaponType.PulseLaser.id]);
        Dragonfly().addEquipment(Constants.Shields[ShieldType.Lightning.id]);
        Dragonfly().addEquipment(Constants.Shields[ShieldType.Lightning.id]);
        Dragonfly().addEquipment(Constants.Shields[ShieldType.Lightning.id]);
        Dragonfly().addEquipment(Constants.Gadgets[GadgetType.AutoRepairSystem.asInteger()]);
        Dragonfly().addEquipment(Constants.Gadgets[GadgetType.TargetingSystem.asInteger()]);
        // set the details of the Scarab...
        scarab.Crew()[0] = Mercenaries()[CrewMemberId.Scarab.getId()];
        scarab.addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
        scarab.addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
        // set the details of the Scorpion...
        scorpion.Crew()[0] = Mercenaries()[CrewMemberId.Scorpion.getId()];
        scorpion.addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
        scorpion.addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
        scorpion.addEquipment(Constants.Shields[ShieldType.Reflective.id]);
        scorpion.addEquipment(Constants.Shields[ShieldType.Reflective.id]);
        scorpion.addEquipment(Constants.Gadgets[GadgetType.AutoRepairSystem.asInteger()]);
        scorpion.addEquipment(Constants.Gadgets[GadgetType.TargetingSystem.asInteger()]);
        // set the details of the Space Monster...
        spaceMonster.Crew()[0] = Mercenaries()[CrewMemberId.SpaceMonster.getId()];
        spaceMonster.addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
        spaceMonster.addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
        spaceMonster.addEquipment(Constants.WeaponObjects[WeaponType.MilitaryLaser.id]);
    }

    private void EncounterDefeatDragonfly() {
        commander.setKillsPirate(commander.getKillsPirate() + 1);
        commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillPirate);
        questStatusDragonfly = SpecialEvent.StatusDragonflyDestroyed;
    }

    private void EncounterDefeatScarab() {
        commander.setKillsPirate(commander.getKillsPirate() + 1);
        commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillPirate);
        questStatusScarab = SpecialEvent.StatusScarabDestroyed;
    }

    private void EncounterDefeatScorpion() {
        commander.setKillsPirate(commander.getKillsPirate() + 1);
        commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillPirate);
        questStatusPrincess = SpecialEvent.StatusPrincessRescued;
    }

    private void EncounterScoop(Pane owner) {
        // Chance 50% to picturek something up on Normal level, 33% on Hard level, 25% on Impossible level, and 100% on Easy or Beginner.
        if ((difficulty.getId() < Difficulty.Normal.getId() || ModelUtils.getRandom(difficulty.getId()) == 0)
                && opponent.FilledCargoBays() > 0) {
            // Changed this to actually picturek a good that was in the opponent's cargo hold - JAF.
            int index = ModelUtils.getRandom(opponent.FilledCargoBays());
            int tradeItem = -1;
            for (int sum = 0; sum <= index; sum += opponent.Cargo()[++tradeItem]) {
            }
            if (DialogAlert.Alert(AlertType.EncounterScoop, owner, Constants.TradeItems[tradeItem].Name()) == DialogResult.Yes) {
                boolean jettisoned = false;
                if (commander.getShip().FreeCargoBays() == 0 && DialogAlert.Alert(AlertType.EncounterScoopNoRoom, owner) == DialogResult.Yes) {
                    (new DialogJettison()).ShowDialog(owner);
                    jettisoned = true;
                }
                if (commander.getShip().FreeCargoBays() > 0) {
                    commander.getShip().Cargo()[tradeItem]++;
                } else if (jettisoned) {
                    DialogAlert.Alert(AlertType.EncounterScoopNoScoop, owner);
                }
            }
        }
    }

    private void EncounterUpdateEncounterType(int prevCmdrHull, int prevOppHull) {
        int chance = ModelUtils.getRandom(100);
        if (opponent.getHull() < prevOppHull || opponentDisabled) {
            switch (encounterType) {
                case FamousCaptainAttack:
                    if (opponentDisabled) {
                        encounterType = EncounterType.FamousCaptDisabled;
                    }
                    break;
                case PirateAttack:
                case PirateFlee:
                case PirateSurrender:
                    if (opponentDisabled) {
                        encounterType = EncounterType.PirateDisabled;
                    } else if (opponent.getHull() < (prevOppHull * 2) / 3) {
                        if (commander.getShip().getHull() < (prevCmdrHull * 2) / 3) {
                            if (chance < 60) {
                                getEncounterType();
                                encounterType = EncounterType.PirateFlee;
                            }
                        } else {
                            if (chance < 10 && opponent.Type() != ShipType.Mantis) {
                                encounterType = EncounterType.PirateSurrender;
                            } else {
                                encounterType = EncounterType.PirateFlee;
                            }
                        }
                    }
                    break;
                case PoliceAttack:
                case PoliceFlee:
                    if (opponentDisabled) {
                        encounterType = EncounterType.PoliceDisabled;
                    } else if (opponent.getHull() < prevOppHull / 2 && (commander.getShip().getHull() >= prevCmdrHull / 2 || chance < 40)) {
                        encounterType = EncounterType.PoliceFlee;
                    }
                    break;
                case TraderAttack:
                case TraderFlee:
                case TraderSurrender:
                    if (opponentDisabled) {
                        encounterType = EncounterType.TraderDisabled;
                    } else if (opponent.getHull() < (prevOppHull * 2) / 3) {
                        if (chance < 60) {
                            encounterType = EncounterType.TraderSurrender;
                        } else {
                            encounterType = EncounterType.TraderFlee;
                        }
                    } else if (opponent.getHull() < (prevOppHull * 9) / 10 && (commander.getShip().getHull() < (prevCmdrHull * 2) / 3 && chance < 20
                            || commander.getShip().getHull() < (prevCmdrHull * 9) / 10 && chance < 60 || commander.getShip().getHull() >= (prevCmdrHull * 9) / 10)) {
                        // If you get damaged a lot, the trader tends to keep shooting;
                        // if you get damaged a little, the trader may keep shooting;
                        // if you get damaged very little or not at all, the trader will flee.
                        encounterType = EncounterType.TraderFlee;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void EncounterWon(Pane owner) {
        if (encounterType.getId() >= EncounterType.PirateAttack.getId()
                && encounterType.getId() <= EncounterType.PirateDisabled.getId()
                && opponent.Type() != ShipType.Mantis
                && commander.getPoliceRecordScore() >= Constants.PoliceRecordScoreDubious) {
            DialogAlert.Alert(AlertType.EncounterPiratesBounty, owner, Strings.EncounterPiratesDestroyed, "", ModelUtils.multiples(opponent.getBounty(), Strings.MoneyUnit));
        } else {
            DialogAlert.Alert(AlertType.EncounterYouWin, owner);
        }
        switch (encounterType) {
            case FamousCaptainAttack:
                commander.setKillsTrader(commander.getKillsTrader() + 1);
                if (commander.getReputationScore() < Constants.ReputationScoreDangerous) {
                    commander.setReputationScore(Constants.ReputationScoreDangerous);
                } else {
                    commander.setReputationScore(commander.getReputationScore() + Constants.ScoreKillCaptain);
                }
                // bump news flag from attacked to ship destroyed
                replaceNewsEvent(NewsLatestEvent(), NewsEvent.FromInt(NewsLatestEvent() + 1).getId());
                break;
            case DragonflyAttack:
                EncounterDefeatDragonfly();
                break;
            case PirateAttack:
            case PirateFlee:
            case PirateSurrender:
                commander.setKillsPirate(commander.getKillsPirate() + 1);
                if (opponent.Type() != ShipType.Mantis) {
                    if (commander.getPoliceRecordScore() >= Constants.PoliceRecordScoreDubious) {
                        commander.setCash(commander.getCash() + opponent.getBounty());
                    }
                    commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillPirate);
                    EncounterScoop(owner);
                }
                break;
            case PoliceAttack:
            case PoliceFlee:
                commander.setKillsPolice(commander.getKillsPolice() + 1);
                commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillPolice);
                break;
            case ScarabAttack:
                EncounterDefeatScarab();
                break;
            case SpaceMonsterAttack:
                commander.setKillsPirate(commander.getKillsPirate() + 1);
                commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillPirate);
                questStatusSpaceMonster = SpecialEvent.StatusSpaceMonsterDestroyed;
                break;
            case TraderAttack:
            case TraderFlee:
            case TraderSurrender:
                commander.setKillsTrader(commander.getKillsTrader() + 1);
                commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillTrader);
                EncounterScoop(owner);
                break;
            default:
                break;
        }
        commander.setReputationScore(commander.getReputationScore() + (opponent.Type().getId() / 2 + 1));
    }

    private void GenerateCrewMemberList() {
        int[] used = new int[universe.length];
        int d = difficulty.getId();
        // Zeethibal may be on Kravat
        used[StarSystemId.Kravat.getId()] = 1;
        // special individuals:
        // Zeethibal, Jonathan Wild's Nephew - skills will be set later.
        // Wild, Jonathan Wild earns his keep now - JAF.
        // Jarek, Ambassador Jarek earns his keep now - JAF.
        // Dummy pilots for opponents.
        Mercenaries()[CrewMemberId.Zeethibal.getId()] = new CrewMember(CrewMemberId.Zeethibal, 5, 5, 5, 5, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Opponent.getId()] = new CrewMember(CrewMemberId.Opponent, 5, 5, 5, 5, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Wild.getId()] = new CrewMember(CrewMemberId.Wild, 7, 10, 2, 5, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Jarek.getId()] = new CrewMember(CrewMemberId.Jarek, 3, 2, 10, 4, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Princess.getId()] = new CrewMember(CrewMemberId.Princess, 4, 3, 8, 9, StarSystemId.NA);
        Mercenaries()[CrewMemberId.FamousCaptain.getId()] = new CrewMember(CrewMemberId.FamousCaptain, 10, 10, 10, 10, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Dragonfly.getId()] = new CrewMember(CrewMemberId.Dragonfly, 4 + d, 6 + d, 1, 6 + d, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Scarab.getId()] = new CrewMember(CrewMemberId.Scarab, 5 + d, 6 + d, 1, 6 + d, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Scorpion.getId()] = new CrewMember(CrewMemberId.Scorpion, 8 + d, 8 + d, 1, 6 + d, StarSystemId.NA);
        Mercenaries()[CrewMemberId.SpaceMonster.getId()] = new CrewMember(CrewMemberId.SpaceMonster, 8 + d, 8 + d, 1, 1 + d, StarSystemId.NA);
        // JAF - Changing this to allow multiple mercenaries in each system, but no more than three.
        for (int i = 1; i < Mercenaries().length; i++) {
            // Only create a CrewMember Object if one doesn't already exist in this slot in the array.
            if (Mercenaries()[i] == null) {
                StarSystemId id;
                boolean ok = false;
                do {
                    id = StarSystemId.FromInt(ModelUtils.getRandom(universe.length));
                    if (used[id.getId()] < 3) {
                        used[id.getId()]++;
                        ok = true;
                    }
                } while (!ok);
                Mercenaries()[i] = new CrewMember(CrewMemberId.FromInt(i), ModelUtils.getRandomSkill(), ModelUtils.getRandomSkill(), ModelUtils.getRandomSkill(), ModelUtils.getRandomSkill(), id);
            }
        }
    }

    private void GenerateOpponent(OpponentType oppType) {
        opponent = new Ship(oppType);
    }

    private void NormalDeparture(int fuel) {
        commander.setCash(commander.getCash() - (MercenaryCosts() + InsuranceCosts() + WormholeCosts()));
        commander.getShip().setFuel(commander.getShip().getFuel() - fuel);
        commander.PayInterest();
        increaseDays(1, mainWindow);
    }

    public ArrayList<Integer> NewsEvents() {
        return newsEvents;
    }

    public ArrayList<VeryRareEncounter> VeryRareEncounters() {
        return veryRareEncounters;
    }

    public Commander Commander() {
        return commander;
    }

    public CrewMember[] Mercenaries() {
        return mercenaries;
    }

    public Difficulty Difficulty() {
        return difficulty;
    }

    public EncounterResult EncounterExecuteAction(Pane owner) {
        EncounterResult result = EncounterResult.Continue;
        int prevCmdrHull = commander.getShip().getHull();
        int prevOppHull = opponent.getHull();
        encounterCmdrHit = false;
        encounterOppHit = false;
        encounterOppFleeingPrev = encounterOppFleeing;
        encounterOppFleeing = false;
        // Fire shots
        switch (encounterType) {
            case DragonflyAttack:
            case FamousCaptainAttack:
            case MarieCelestePolice:
            case PirateAttack:
            case PoliceAttack:
            case ScarabAttack:
            case ScorpionAttack:
            case SpaceMonsterAttack:
            case TraderAttack:
                encounterCmdrHit = EncounterExecuteAttack(opponent, commander.getShip(), encounterCmdrFleeing);
                encounterOppHit = !encounterCmdrFleeing && EncounterExecuteAttack(commander.getShip(), opponent, false);
                break;
            case PirateFlee:
            case PirateSurrender:
            case PoliceFlee:
            case TraderFlee:
            case TraderSurrender:
                encounterOppHit = !encounterCmdrFleeing && EncounterExecuteAttack(commander.getShip(), opponent, true);
                encounterOppFleeing = true;
                break;
            default:
                encounterOppHit = !encounterCmdrFleeing && EncounterExecuteAttack(commander.getShip(), opponent, false);
                break;
        }
        // Determine whether someone gets destroyed
        if (commander.getShip().getHull() <= 0) {
            if (commander.getShip().getEscapePod()) {
                result = EncounterResult.EscapePod;
            } else {
                DialogAlert.Alert(opponent.getHull() <= 0 ? AlertType.EncounterBothDestroyed : AlertType.EncounterYouLose, owner);
                result = EncounterResult.Killed;
            }
        } else if (opponentDisabled) {
            if (opponent.Type() == ShipType.Dragonfly || opponent.Type() == ShipType.Scarab || opponent.Type() == ShipType.Scorpion) {
                String str2 = "";
                switch (opponent.Type()) {
                    case Dragonfly:
                        EncounterDefeatDragonfly();
                        break;
                    case Scarab:
                        EncounterDefeatScarab();
                        break;
                    case Scorpion:
                        str2 = Strings.EncounterPrincessRescued;
                        EncounterDefeatScorpion();
                        break;
                }
                DialogAlert.Alert(AlertType.EncounterDisabledOpponent, owner, EncounterShipText(), str2);
                commander.setReputationScore(commander.getReputationScore() + (opponent.Type().getId() / 2 + 1));
                result = EncounterResult.Normal;
            } else {
                EncounterUpdateEncounterType(prevCmdrHull, prevOppHull);
                encounterOppFleeing = false;
            }
        } else if (opponent.getHull() <= 0) {
            EncounterWon(owner);
            result = EncounterResult.Normal;
        } else {
            boolean escaped = false;
            // Determine whether someone gets away.
            if (encounterCmdrFleeing
                    && (difficulty == Difficulty.Beginner || (ModelUtils.getRandom(7) + commander.getShip().Pilot() / 3) * 2 >= ModelUtils.getRandom(opponent.Pilot())
                    * (2 + difficulty.getId()))) {
                DialogAlert.Alert(encounterCmdrHit ? AlertType.EncounterEscapedHit : AlertType.EncounterEscaped, owner);
                escaped = true;
            } else if (encounterOppFleeing && ModelUtils.getRandom(commander.getShip().Pilot()) * 4 <= ModelUtils.getRandom(7 + opponent.Pilot() / 3) * 2) {
                DialogAlert.Alert(AlertType.EncounterOpponentEscaped, owner);
                escaped = true;
            }

            if (escaped) {
                result = EncounterResult.Normal;
            } else {
                // Determine whether the opponent's actions must be changed
                EncounterType prevEncounter = encounterType;
                EncounterUpdateEncounterType(prevCmdrHull, prevOppHull);
                // Update the opponent fleeing flag.
                switch (encounterType) {
                    case PirateFlee:
                    case PirateSurrender:
                    case PoliceFlee:
                    case TraderFlee:
                    case TraderSurrender:
                        encounterOppFleeing = true;
                        break;
                    default:
                        encounterOppFleeing = false;
                        break;
                }
                if (options.getContinuousAttack()
                        && (encounterCmdrFleeing || !encounterOppFleeing || options.getContinuousAttackFleeing()
                        && (encounterType == prevEncounter || encounterType != EncounterType.PirateSurrender
                        && encounterType != EncounterType.TraderSurrender))) {
                    if (encounterCmdrFleeing) {
                        encounterContinueFleeing = true;
                    } else {
                        setEncounterContinueAttacking(true);
                    }
                }
            }
        }
        return result;
    }

    public EncounterResult EncounterVerifySurrender(Pane owner) {
        EncounterResult result = EncounterResult.Continue;
        if (opponent.Type() == ShipType.Mantis) {
            if (commander.getShip().ArtifactOnBoard()) {
                if (DialogAlert.Alert(AlertType.EncounterAliensSurrender, owner) == DialogResult.Yes) {
                    DialogAlert.Alert(AlertType.ArtifactRelinquished, owner);
                    questStatusArtifact = SpecialEvent.StatusArtifactNotStarted;
                    result = EncounterResult.Normal;
                }
            } else {
                DialogAlert.Alert(AlertType.EncounterSurrenderRefused, owner);
            }
        } else if (encounterType == EncounterType.PoliceAttack || encounterType == EncounterType.PoliceSurrender) {
            if (commander.getPoliceRecordScore() <= Constants.PoliceRecordScorePsychopath) {
                DialogAlert.Alert(AlertType.EncounterSurrenderRefused, owner);
            } else if (DialogAlert.Alert(AlertType.EncounterPoliceSurrender, owner, new String[]{
                    commander.getShip().IllegalSpecialCargoDescription(Strings.EncounterPoliceSurrenderCargo, true, false),
                    commander.getShip().IllegalSpecialCargoActions()}) == DialogResult.Yes) {
                result = EncounterResult.Arrested;
            }
        } else if (commander.getShip().PrincessOnBoard() && !commander.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
            DialogAlert.Alert(AlertType.EncounterPiratesSurrenderPrincess, owner);
        } else {
            raided = true;
            if (commander.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
                ArrayList<String> precious = new ArrayList<>();
                if (commander.getShip().PrincessOnBoard()) {
                    precious.add(Strings.EncounterHidePrincess);
                }
                if (commander.getShip().SculptureOnBoard()) {
                    precious.add(Strings.EncounterHideSculpture);
                }
                DialogAlert.Alert(AlertType.PreciousHidden, owner, ModelUtils.StringVars(Strings.ListStrings[precious.size()], precious.toArray(new String[0])));
            } else if (commander.getShip().SculptureOnBoard()) {
                questStatusSculpture = SpecialEvent.StatusSculptureNotStarted;
                DialogAlert.Alert(AlertType.EncounterPiratesTakeSculpture, owner);
            }
            ArrayList<Integer> cargoToSteal = commander.getShip().StealableCargo();
            if (cargoToSteal.isEmpty()) {
                int blackmail = Math.min(25000, Math.max(500, commander.Worth() / 20));
                int cashPayment = Math.min(commander.getCash(), blackmail);
                commander.setDebt(commander.getDebt() + (blackmail - cashPayment));
                commander.setCash(commander.getCash() - cashPayment);
                DialogAlert.Alert(AlertType.EncounterPiratesFindNoCargo, owner, ModelUtils.multiples(blackmail, Strings.MoneyUnit));
            } else {
                DialogAlert.Alert(AlertType.EncounterLooting, owner);
                // Pirates steal as much as they have room for, which could be everything - JAF.
                // Take most high-priced items - JAF.
                while (opponent.FreeCargoBays() > 0 && !cargoToSteal.isEmpty()) {
                    int item = cargoToSteal.get(0);
                    commander.PriceCargo()[item] -= commander.PriceCargo()[item] / commander.getShip().Cargo()[item];
                    commander.getShip().Cargo()[item]--;
                    opponent.Cargo()[item]++;
                    cargoToSteal.remove(0);
                }
            }
            if (commander.getShip().WildOnBoard()) {
                if (opponent.getCrewQuarters() > 1) { // Wild hops onto Pirate Ship
                    questStatusWild = SpecialEvent.StatusWildNotStarted;
                    DialogAlert.Alert(AlertType.WildGoesPirates, owner);
                } else { // no room on pirate ship
                    DialogAlert.Alert(AlertType.WildChatsPirates, owner);
                }
            }
            // pirates puzzled by reactor
            if (commander.getShip().ReactorOnBoard()) {
                DialogAlert.Alert(AlertType.EncounterPiratesExamineReactor, owner);
            }
            result = EncounterResult.Normal;
        }
        return result;
    }

    public EncounterResult EncounterVerifyYield(Pane owner) {
        EncounterResult result = EncounterResult.Continue;
        if (commander.getShip().IllegalSpecialCargo()) {
            if (DialogAlert.Alert(AlertType.EncounterPoliceSurrender, owner, new String[]{
                    commander.getShip().IllegalSpecialCargoDescription(Strings.EncounterPoliceSurrenderCargo, true, true),
                    commander.getShip().IllegalSpecialCargoActions()}) == DialogResult.Yes) {
                result = EncounterResult.Arrested;
            }
        } else {
            String str1 = commander.getShip().IllegalSpecialCargoDescription("", false, true);
            if (DialogAlert.Alert(AlertType.EncounterPoliceSubmit, owner, str1, "") == DialogResult.Yes) {
                // Police Record becomes dubious, if it wasn't already.
                if (commander.getPoliceRecordScore() > Constants.PoliceRecordScoreDubious) {
                    commander.setPoliceRecordScore(Constants.PoliceRecordScoreDubious);
                }
                commander.getShip().RemoveIllegalGoods();
                result = EncounterResult.Normal;
            }
        }
        return result;
    }

    public EncounterType getEncounterType() {
        return encounterType;
    }

    public void setEncounterType(EncounterType encounterType) {
        this.encounterType = encounterType;
    }

    public GameEndType getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(GameEndType endStatus) {
        this.endStatus = endStatus;
    }

    public GameOptions Options() {
        return options;
    }

    public int NewsLatestEvent() {
        return newsEvents.get(newsEvents.size() - 1);
    }

    public Ship Dragonfly() {
        return dragonfly;
    }

    public Ship getOpponent() {
        return opponent;
    }

    public void setOpponent(Ship opponent) {
        this.opponent = opponent;
    }

    public Ship Scarab() {
        return scarab;
    }

    public Ship Scorpion() {
        return scorpion;
    }

    public Ship SpaceMonster() {
        return spaceMonster;
    }

    public MainWindow getParentWindow() {
        return mainWindow;
    }

    public void setParentWindow(MainWindow parentWindow) {
        mainWindow = parentWindow;
    }

    public StarSystem SelectedSystem() {
        return (selectedSystemId == StarSystemId.NA ? null : universe[selectedSystemId.getId()]);
    }

    public StarSystem TrackedSystem() {
        return trackedSystemId == StarSystemId.NA ? null : universe[trackedSystemId.getId()];
    }

    public StarSystem WarpSystem() {
        return warpSystemId == StarSystemId.NA ? null : universe[warpSystemId.getId()];
    }

    public StarSystem[] getUniverse() {
        return universe;
    }

    public StarSystemId getTrackedSystemId() {
        return trackedSystemId;
    }

    public void setTrackedSystemId(StarSystemId trackedSystemId) {
        this.trackedSystemId = trackedSystemId;
    }

    public StarSystemId selectedSystemId() {
        return selectedSystemId;
    }

    public StarSystemId WarpSystemId() {
        return warpSystemId;
    }

    public String EncounterAction() {
        String action;
        if (opponentDisabled) {
            action = ModelUtils.StringVars("The ^1 has been disabled.", EncounterShipText());
        } else if (encounterOppFleeing) {
            if (encounterType == EncounterType.PirateSurrender || encounterType == EncounterType.TraderSurrender) {
                action = ModelUtils.StringVars("The ^1 hails that they wish to surrender to you.", EncounterShipText());
            } else {
                action = ModelUtils.StringVars("The ^1 is fleeing.", EncounterShipText());
            }
        } else {
            action = ModelUtils.StringVars(Strings.EncounterActionOppAttacks, EncounterShipText());
        }
        return action;
    }

    public String EncounterActionInitial() {
        String text = "";
        // Set up the fleeing variable initially.
        encounterOppFleeing = false;
        switch (encounterType) {
            case BottleGood:
            case BottleOld:
                text = Strings.EncounterTextBottle;
                break;
            case CaptainAhab:
            case CaptainConrad:
            case CaptainHuie:
                text = Strings.EncounterTextFamousCaptain;
                break;
            case DragonflyAttack:
            case PirateAttack:
            case PoliceAttack:
            case ScarabAttack:
            case ScorpionAttack:
            case SpaceMonsterAttack:
                text = Strings.EncounterTextOpponentAttack;
                break;
            case DragonflyIgnore:
            case PirateIgnore:
            case PoliceIgnore:
            case ScarabIgnore:
            case ScorpionIgnore:
            case SpaceMonsterIgnore:
            case TraderIgnore:
                text = commander.getShip().Cloaked() ? Strings.EncounterTextOpponentNoNotice : Strings.EncounterTextOpponentIgnore;
                break;
            case MarieCeleste:
                text = Strings.EncounterTextMarieCeleste;
                break;
            case MarieCelestePolice:
                text = Strings.EncounterTextPolicePostMarie;
                break;
            case PirateFlee:
            case PoliceFlee:
            case TraderFlee:
                text = Strings.EncounterTextOpponentFlee;
                encounterOppFleeing = true;
                break;
            case PoliceInspect:
                text = Strings.EncounterTextPoliceInspection;
                break;
            case PoliceSurrender:
                text = Strings.EncounterTextPoliceSurrender;
                break;
            case TraderBuy:
            case TraderSell:
                text = Strings.EncounterTextTrader;
                break;
            case FamousCaptainAttack:
            case FamousCaptDisabled:
            case PoliceDisabled:
            case PirateDisabled:
            case PirateSurrender:
            case TraderAttack:
            case TraderDisabled:
            case TraderSurrender:
                // These should never be the initial encounter type.
                break;
        }
        return text;
    }

    public String EncounterShipText() {
        String shipText = opponent.Name();
        switch (encounterType) {
            case FamousCaptainAttack:
            case FamousCaptDisabled:
                shipText = Strings.EncounterShipCaptain;
                break;
            case PirateAttack:
            case PirateDisabled:
            case PirateFlee:
            case PirateSurrender:
                shipText = opponent.Type() == ShipType.Mantis ? Strings.EncounterShipMantis : Strings.EncounterShipPirate;
                break;
            case PoliceAttack:
            case PoliceDisabled:
            case PoliceFlee:
                shipText = Strings.EncounterShipPolice;
                break;
            case TraderAttack:
            case TraderDisabled:
            case TraderFlee:
            case TraderSurrender:
                shipText = Strings.EncounterShipTrader;
                break;
            default:
                break;
        }
        return shipText;
    }

    public String EncounterText() {
        String commanderStatus;
        if (encounterCmdrFleeing) {
            commanderStatus = ModelUtils.StringVars("The ^1 is still following you.", EncounterShipText());
        } else if (encounterOppHit) {
            commanderStatus = ModelUtils.StringVars("You hit the ^1.", EncounterShipText());
        } else {
            commanderStatus = ModelUtils.StringVars("You missed the ^1.", EncounterShipText());
        }
        String oppStatus;
        if (encounterOppFleeingPrev) {
            oppStatus = ModelUtils.StringVars("The ^1 didn't get away.", EncounterShipText());
        } else if (encounterCmdrHit) {
            oppStatus = ModelUtils.StringVars("The ^1 hits you.", EncounterShipText());
        } else {
            oppStatus = ModelUtils.StringVars("The ^1 missed you.", EncounterShipText());
        }
        return commanderStatus + Strings.newline + oppStatus;
    }

    public String EncounterTextInitial() {
        String encounterPretext = "";
        switch (encounterType) {
            case BottleGood:
            case BottleOld:
                encounterPretext = Strings.EncounterPretextBottle;
                break;
            case DragonflyAttack:
            case DragonflyIgnore:
            case ScarabAttack:
            case ScarabIgnore:
                encounterPretext = Strings.EncounterPretextStolen;
                break;
            case CaptainAhab:
                encounterPretext = Strings.EncounterPretextCaptainAhab;
                break;
            case CaptainConrad:
                encounterPretext = Strings.EncounterPretextCaptainConrad;
                break;
            case CaptainHuie:
                encounterPretext = Strings.EncounterPretextCaptainHuie;
                break;
            case MarieCeleste:
                encounterPretext = Strings.EncounterPretextMarie;
                break;
            case MarieCelestePolice:
            case PoliceAttack:
            case PoliceFlee:
            case PoliceIgnore:
            case PoliceInspect:
            case PoliceSurrender:
                encounterPretext = Strings.EncounterPretextPolice;
                break;
            case PirateAttack:
            case PirateFlee:
            case PirateIgnore:
                if (opponent.Type() == ShipType.Mantis) {
                    encounterPretext = Strings.EncounterPretextAlien;
                } else {
                    encounterPretext = Strings.EncounterPretextPirate;
                }
                break;
            case ScorpionAttack:
            case ScorpionIgnore:
                encounterPretext = Strings.EncounterPretextScorpion;
                break;
            case SpaceMonsterAttack:
            case SpaceMonsterIgnore:
                encounterPretext = Strings.EncounterPretextSpaceMonster;
                break;
            case TraderBuy:
            case TraderFlee:
            case TraderIgnore:
            case TraderSell:
                encounterPretext = Strings.EncounterPretextTrader;
                break;
            case FamousCaptainAttack:
            case FamousCaptDisabled:
            case PoliceDisabled:
            case PirateDisabled:
            case PirateSurrender:
            case TraderAttack:
            case TraderDisabled:
            case TraderSurrender:
                // These should never be the initial encounter type.
                break;
        }
        return ModelUtils.StringVars(Strings.EncounterText,
                new String[]{
                        ModelUtils.multiples(clicks, "click"), WarpSystem().Name(), encounterPretext, opponent.Name().toLowerCase()
                });
    }

    public String NewspaperHead() {
        String[] heads = Strings.NewsMastheads[commander.CurrentSystem().PoliticalSystemType().getId()];
        String head = heads[commander.CurrentSystem().Id().getId() % heads.length];
        return ModelUtils.StringVars(head, commander.CurrentSystem().Name());
    }

    public String NewspaperText() {
        StarSystem currentSys = commander.CurrentSystem();
        ArrayList<String> items = new ArrayList<>();
        // We're using the GetRandom2 function so that the same number is generated each time for the same "version" of the newspaper. -JAF
        ModelUtils.RandSeed(currentSys.Id().getId(), commander.getDays());
        for (Integer newsEvent : newsEvents) {
            items.add(ModelUtils.StringVars(Strings.NewsEvent[newsEvent], new String[]{
                    commander.Name(), commander.CurrentSystem().Name(), commander.getShip().Name()}));
        }
        if (currentSys.SystemPressure() != SystemPressure.None) {
            items.add(Strings.NewsPressureInternal[currentSys.SystemPressure().getId()]);
        }
        if (commander.getPoliceRecordScore() <= Constants.PoliceRecordScoreVillain) {
            String baseStr = Strings.NewsPoliceRecordPsychopath[ModelUtils.getRandom2(Strings.NewsPoliceRecordPsychopath.length)];
            items.add(ModelUtils.StringVars(baseStr, commander.Name(), currentSys.Name()));
        } else if (commander.getPoliceRecordScore() >= Constants.PoliceRecordScoreHero) {
            String baseStr = Strings.NewsPoliceRecordHero[ModelUtils.getRandom2(Strings.NewsPoliceRecordHero.length)];
            items.add(ModelUtils.StringVars(baseStr, commander.Name(), currentSys.Name()));
        }
        // and now, finally, useful news (if any); base probability of a story showing up is (50 / MAXTECHLEVEL) * Current Tech Level
        // This is then modified by adding 10% for every level of play less than Impossible
        boolean realNews = false;
        int minProbability = Constants.StoryProbability * currentSys.TechLevel().ordinal() + 10 * (5 - difficulty.getId());
        for (StarSystem starSystem : universe) {
            if (starSystem.DestOk() && starSystem != currentSys) {
                // Special stories that always get shown: moon, millionaire, shipyard
                if (starSystem.SpecialEventType() != SpecialEventType.NA) {
                    if (starSystem.SpecialEventType() == SpecialEventType.Moon) {
                        items.add(ModelUtils.StringVars(Strings.NewsMoonForSale, starSystem.Name()));
                    } else if (starSystem.SpecialEventType() == SpecialEventType.TribbleBuyer) {
                        items.add(ModelUtils.StringVars(Strings.NewsTribbleBuyer, starSystem.Name()));
                    }
                }
                if (starSystem.ShipyardId() != ShipyardId.NA) {
                    items.add(ModelUtils.StringVars(Strings.NewsShipyard, starSystem.Name()));
                }
                // And not-always-shown stories
                if (starSystem.SystemPressure() != SystemPressure.None
                        && ModelUtils.getRandom2(100) <= Constants.StoryProbability * currentSys.TechLevel().ordinal() + 10 * (5 - difficulty.getId())) {
                    int index = ModelUtils.getRandom2(Strings.NewsPressureExternal.length);
                    String baseStr = Strings.NewsPressureExternal[index];
                    String pressure = Strings.NewsPressureExternalPressures[starSystem.SystemPressure().getId()];
                    items.add(ModelUtils.StringVars(baseStr, pressure, starSystem.Name()));
                    realNews = true;
                }
            }
        }
        // if there's no useful news, we throw up at least one headline from our canned news list.
        if (!realNews) {
            String[] headlines = Strings.NewsHeadlines[currentSys.PoliticalSystemType().getId()];
            boolean[] shown = new boolean[headlines.length];
            int toShow = ModelUtils.getRandom2(headlines.length);
            for (int i = 0; i <= toShow; i++) {
                int index = ModelUtils.getRandom2(headlines.length);
                if (!shown[index]) {
                    items.add(headlines[index]);
                    shown[index] = true;
                }
            }
        }
        return Utils.stringsJoin(Strings.newline + Strings.newline, ModelUtils.arrayListtoStringArray(items));
    }

    @SuppressWarnings("fallthrough")
    public boolean EncounterVerifyAttack(Pane owner) {
        boolean attack = true;
        if (commander.getShip().WeaponStrength() == 0) {
            DialogAlert.Alert(AlertType.EncounterAttackNoWeapons, owner);
            attack = false;
        } else if (!opponent.Disableable() && commander.getShip().WeaponStrength(WeaponType.PulseLaser, WeaponType.MorgansLaser) == 0) {
            DialogAlert.Alert(AlertType.EncounterAttackNoLasers, owner);
            attack = false;
        } else if (opponent.Type() == ShipType.Scorpion && commander.getShip().WeaponStrength(WeaponType.PhotonDisruptor, WeaponType.QuantumDisruptor) == 0) {
            DialogAlert.Alert(AlertType.EncounterAttackNoDisruptors, owner);
            attack = false;
        } else {
            switch (encounterType) {
                case DragonflyIgnore:
                case PirateIgnore:
                case ScarabIgnore:
                case ScorpionIgnore:
                case SpaceMonsterIgnore:
                    encounterType = EncounterType.FromInt(encounterType.getId() - 1);
                    break;
                case PoliceInspect:
                    if (!commander.getShip().DetectableIllegalCargoOrPassengers() && DialogAlert.Alert(AlertType.EncounterPoliceNothingIllegal, owner) != DialogResult.Yes) {
                        attack = false;
                    }
                    // Fall through...
                    if (!attack) {
                        break;
                    } // goto case PoliceIgnore;
                case MarieCelestePolice:
                case PoliceFlee:
                case PoliceIgnore:
                case PoliceSurrender:
                    if (commander.getPoliceRecordScore() <= Constants.PoliceRecordScoreCriminal || DialogAlert.Alert(AlertType.EncounterAttackPolice, owner) == DialogResult.Yes) {
                        if (commander.getPoliceRecordScore() > Constants.PoliceRecordScoreCriminal) {
                            commander.setPoliceRecordScore(Constants.PoliceRecordScoreCriminal);
                        }
                        commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreAttackPolice);
                        if (encounterType != EncounterType.PoliceFlee) {
                            encounterType = EncounterType.PoliceAttack;
                        }
                    } else {
                        attack = false;
                    }
                    break;
                case TraderBuy:
                case TraderIgnore:
                case TraderSell:
                    if (commander.getPoliceRecordScore() < Constants.PoliceRecordScoreClean) {
                        commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreAttackTrader);
                    } else if (DialogAlert.Alert(AlertType.EncounterAttackTrader, owner) == DialogResult.Yes) {
                        commander.setPoliceRecordScore(Constants.PoliceRecordScoreDubious);
                    } else {
                        attack = false;
                    }
                    // Fall through...
                    if (!attack) {
                        break;
                    }// else goto case TraderAttack;
                case TraderAttack:
                case TraderSurrender:
                    if (ModelUtils.getRandom(Constants.ReputationScoreElite) <= commander.getReputationScore() * 10 / (opponent.Type().getId() + 1)
                            || opponent.WeaponStrength() == 0) {
                        encounterType = EncounterType.TraderFlee;
                    } else {
                        encounterType = EncounterType.TraderAttack;
                    }
                    break;
                case CaptainAhab:
                case CaptainConrad:
                case CaptainHuie:
                    if (DialogAlert.Alert(AlertType.EncounterAttackCaptain, owner) == DialogResult.Yes) {
                        if (commander.getPoliceRecordScore() > Constants.PoliceRecordScoreVillain) {
                            commander.setPoliceRecordScore(Constants.PoliceRecordScoreVillain);
                        }
                        commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreAttackTrader);
                        switch (encounterType) {
                            case CaptainAhab:
                                addNewsEvent(NewsEvent.CaptAhabAttacked);
                                break;
                            case CaptainConrad:
                                addNewsEvent(NewsEvent.CaptConradAttacked);
                                break;
                            case CaptainHuie:
                                addNewsEvent(NewsEvent.CaptHuieAttacked);
                                break;
                        }
                        encounterType = EncounterType.FamousCaptainAttack;
                    } else {
                        attack = false;
                    }
                    break;
            }
            // Make sure the fleeing flag isn't set if we're attacking.
            if (attack) {
                encounterCmdrFleeing = false;
            }
        }
        return attack;
    }

    public boolean EncounterVerifyBoard(Pane owner) {
        boolean board = false;
        if (DialogAlert.Alert(AlertType.EncounterMarieCeleste, owner) == DialogResult.Yes) {
            board = true;
            int narcs = commander.getShip().Cargo()[TradeItemType.Narcotics.getId()];
            (new DialogPlunder()).ShowDialog(owner);
            if (commander.getShip().Cargo()[TradeItemType.Narcotics.getId()] > narcs) {
                justLootedMarie = true;
            }
        }
        return board;
    }

    public boolean EncounterVerifyBribe(Pane owner) {
        boolean bribed = false;
        if (encounterType == EncounterType.MarieCelestePolice) {
            DialogAlert.Alert(AlertType.EncounterMarieCelesteNoBribe, owner);
        } else if (WarpSystem().PoliticalSystem().BribeLevel() <= 0) {
            DialogAlert.Alert(AlertType.EncounterPoliceBribeCant, owner);
        } else if (commander.getShip().DetectableIllegalCargoOrPassengers() || DialogAlert.Alert(AlertType.EncounterPoliceNothingIllegal, owner) == DialogResult.Yes) {
            // Bribe depends on how easy it is to bribe the police and commander's current worth
            int diffMod = 10 + 5 * (Difficulty.Impossible.getId() - difficulty.getId());
            int passMod = commander.getShip().IllegalSpecialCargo() ? (difficulty.getId() <= Difficulty.Normal.getId() ? 2 : 3) : 1;
            int bribe = Math.max(100, Math.min(10000, (int) Math.ceil((double) commander.Worth() / WarpSystem().PoliticalSystem().BribeLevel() / diffMod / 100) * 100 * passMod));
            if (DialogAlert.Alert(AlertType.EncounterPoliceBribe, owner, ModelUtils.multiples(bribe, Strings.MoneyUnit)) == DialogResult.Yes) {
                if (commander.getCash() >= bribe) {
                    commander.setCash(commander.getCash() - bribe);
                    bribed = true;
                } else {
                    DialogAlert.Alert(AlertType.EncounterPoliceBribeLowCash, owner);
                }
            }
        }
        return bribed;
    }

    public boolean EncounterVerifyFlee(Pane owner) {
        encounterCmdrFleeing = false;
        if (encounterType != EncounterType.PoliceInspect || commander.getShip().DetectableIllegalCargoOrPassengers()
                || DialogAlert.Alert(AlertType.EncounterPoliceNothingIllegal, owner) == DialogResult.Yes) {
            encounterCmdrFleeing = true;
            if (encounterType == EncounterType.MarieCelestePolice && DialogAlert.Alert(AlertType.EncounterPostMarieFlee, owner) == DialogResult.No) {
                encounterCmdrFleeing = false;
            } else if (encounterType == EncounterType.PoliceInspect || encounterType == EncounterType.MarieCelestePolice) {
                int scoreMod = encounterType == EncounterType.PoliceInspect ? Constants.ScoreFleePolice : Constants.ScoreAttackPolice;
                int scoreMin = encounterType == EncounterType.PoliceInspect
                        ? Constants.PoliceRecordScoreDubious - (difficulty.getId() < Difficulty.Normal.getId() ? 0 : 1) : Constants.PoliceRecordScoreCriminal;
                encounterType = EncounterType.PoliceAttack;
                commander.setPoliceRecordScore(Math.min(commander.getPoliceRecordScore() + scoreMod, scoreMin));
            }
        }
        return encounterCmdrFleeing;
    }

    public boolean EncounterVerifySubmit(Pane owner) {
        boolean submit = false;
        if (commander.getShip().DetectableIllegalCargoOrPassengers()) {
            String str1 = commander.getShip().IllegalSpecialCargoDescription("", true, true);
            String str2 = commander.getShip().IllegalSpecialCargo() ? Strings.EncounterPoliceSubmitArrested : "";
            if (DialogAlert.Alert(AlertType.EncounterPoliceSubmit, owner, str1, str2) == DialogResult.Yes) {
                submit = true;
                // If you carry illegal goods, they are impounded and you are fined
                if (commander.getShip().DetectableIllegalCargo()) {
                    commander.getShip().RemoveIllegalGoods();
                    int fine = (int) Math.max(100, Math.min(10000,
                            Math.ceil((double) commander.Worth() / ((Difficulty.Impossible.getId() - difficulty.getId() + 2) * 10) / 50) * 50));
                    int cashPayment = Math.min(commander.getCash(), fine);
                    commander.setDebt(commander.getDebt() + (fine - cashPayment));
                    commander.setCash(commander.getCash() - cashPayment);
                    DialogAlert.Alert(AlertType.EncounterPoliceFine, owner, ModelUtils.multiples(fine, Strings.MoneyUnit));
                    commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreTrafficking);
                }
            }
        } else {
            submit = true;
            // If you aren't carrying illegal cargo or passengers, the police will increase your lawfulness record
            DialogAlert.Alert(AlertType.EncounterPoliceNothingFound, owner);
            commander.setPoliceRecordScore(commander.getPoliceRecordScore() - Constants.ScoreTrafficking);
        }
        return submit;
    }

    public boolean getArrivedViaWormhole() {
        return arrivedViaWormhole;
    }

    public void setArrivedViaWormhole(boolean arrivedViaWormhole) {
        this.arrivedViaWormhole = arrivedViaWormhole;
    }

    public boolean getAutoSave() {
        return autoSave;
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    public boolean getCanSuperWarp() {
        return canSuperWarp;
    }

    public void setCanSuperWarp(boolean canSuperWarp) {
        this.canSuperWarp = canSuperWarp;
    }

    public boolean getCheatEnabled() {
        return cheatEnabled;
    }

    public void setCheatEnabled(boolean cheatEnabled) {
        this.cheatEnabled = cheatEnabled;
    }

    public boolean getEasyEncounters() {
        return easyEncounters;
    }

    public void setEasyEncounters(boolean easyEncounters) {
        this.easyEncounters = easyEncounters;
    }

    public boolean getEncounterCmdrFleeing() {
        return encounterCmdrFleeing;
    }

    public void setEncounterCmdrFleeing(boolean encounterCmdrFleeing) {
        this.encounterCmdrFleeing = encounterCmdrFleeing;
    }

    public boolean getEncounterCmdrHit() {
        return encounterCmdrHit;
    }

    public void setEncounterCmdrHit(boolean encounterCmdrHit) {
        this.encounterCmdrHit = encounterCmdrHit;
    }

    public boolean getEncounterContinueAttacking() {
        return encounterContinueAttacking;
    }

    public boolean setEncounterContinueAttacking(boolean encounterContinueAttacking) {
        this.encounterContinueAttacking = encounterContinueAttacking;
        return encounterContinueAttacking;
    }

    public boolean getEncounterContinueFleeing() {
        return encounterContinueFleeing;
    }

    public void setEncounterContinueFleeing(boolean encounterContinueFleeing) {
        this.encounterContinueFleeing = encounterContinueFleeing;
    }

    public boolean getEncounterOppFleeing() {
        return encounterOppFleeing;
    }

    public void setEncounterOppFleeing(boolean encounterOppFleeing) {
        this.encounterOppFleeing = encounterOppFleeing;
    }

    public boolean getEncounterOppFleeingPrev() {
        return encounterOppFleeingPrev;
    }

    public void setEncounterOppFleeingPrev(boolean encounterOppFleeingPrev) {
        this.encounterOppFleeingPrev = encounterOppFleeingPrev;
    }

    public boolean getEncounterOppHit() {
        return encounterOppHit;
    }

    public void setEncounterOppHit(boolean encounterOppHit) {
        this.encounterOppHit = encounterOppHit;
    }

    public boolean getInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public boolean getJustLootedMarie() {
        return justLootedMarie;
    }

    public void setJustLootedMarie(boolean justLootedMarie) {
        this.justLootedMarie = justLootedMarie;
    }

    public boolean getLitterWarning() {
        return litterWarning;
    }

    public void setLitterWarning(boolean litterWarning) {
        this.litterWarning = litterWarning;
    }

    public boolean getOpponentDisabled() {
        return opponentDisabled;
    }

    public boolean setOpponentDisabled(boolean opponentDisabled) {
        this.opponentDisabled = opponentDisabled;
        return opponentDisabled;
    }

    public boolean getPaidForNewspaper() {
        return paidForNewspaper;
    }

    public void setPaidForNewspaper(boolean paidForNewspaper) {
        this.paidForNewspaper = paidForNewspaper;
    }

    public boolean getRaided() {
        return raided;
    }

    public void setRaided(boolean raided) {
        this.raided = raided;
    }

    public boolean getTribbleMessage() {
        return tribbleMessage;
    }

    public void setTribbleMessage(boolean b) {
        tribbleMessage = b;
    }

    public boolean isTargetingWormhole() {
        return targetingWormhole;
    }

    public boolean Travel() {
        // Returns true if an encounter occurrentred.
        // if spacetime is ripped, we may switch the warp system here.
        if (questStatusExperiment == SpecialEvent.StatusExperimentPerformed && fabricRipProbability > 0
                && (fabricRipProbability == Constants.FabricRipInitialProbability || ModelUtils.getRandom(100) < fabricRipProbability)) {
            DialogAlert.Alert(AlertType.SpecialSpacetimeFabricRip, mainWindow);
            selectedSystemId(StarSystemId.FromInt(ModelUtils.getRandom(universe.length)));
        }
        boolean uneventful = true;
        raided = false;
        inspected = false;
        litterWarning = false;
        clicks = Constants.StartClicks;
        while (clicks > 0) {
            commander.getShip().PerformRepairs();
            if (DetermineEncounter()) {
                uneventful = false;
                DialogEncounter form = new DialogEncounter();
                form.ShowDialog(mainWindow);
                mainWindow.updateStatusBar();
                switch (form.Result()) {
                    case Arrested:
                        clicks = 0;
                        Arrested();
                        break;
                    case EscapePod:
                        clicks = 0;
                        escapeWithPod();
                        break;
                    case Killed:
                        throw new GameEndException(GameEndType.Killed);
                }
            }
            clicks = clicks - 1;
        }
        return !uneventful;
    }

    public int CountDownStart() {
        return difficulty.getId() + 3;
    }

    public int CurrentCosts() {
        return InsuranceCosts() + InterestCosts() + MercenaryCosts() + WormholeCosts();
    }

    public int EncounterImageIndex() {
        int encounterImage = -1;
        switch (encounterType) {
            case BottleGood:
            case BottleOld:
            case CaptainAhab:
            case CaptainConrad:
            case CaptainHuie:
            case MarieCeleste:
                encounterImage = Constants.EncounterImgSpecial;
                break;
            case DragonflyAttack:
            case DragonflyIgnore:
            case ScarabAttack:
            case ScarabIgnore:
            case ScorpionAttack:
            case ScorpionIgnore:
                encounterImage = Constants.EncounterImgPirate;
                break;
            case MarieCelestePolice:
            case PoliceAttack:
            case PoliceFlee:
            case PoliceIgnore:
            case PoliceInspect:
            case PoliceSurrender:
                encounterImage = Constants.EncounterImgPolice;
                break;
            case PirateAttack:
            case PirateFlee:
            case PirateIgnore:
                if (opponent.Type() == ShipType.Mantis) {
                    encounterImage = Constants.EncounterImgAlien;
                } else {
                    encounterImage = Constants.EncounterImgPirate;
                }
                break;
            case SpaceMonsterAttack:
            case SpaceMonsterIgnore:
                encounterImage = Constants.EncounterImgAlien;
                break;
            case TraderBuy:
            case TraderFlee:
            case TraderIgnore:
            case TraderSell:
                encounterImage = Constants.EncounterImgTrader;
                break;
            case FamousCaptainAttack:
            case FamousCaptDisabled:
            case PoliceDisabled:
            case PirateDisabled:
            case PirateSurrender:
            case TraderAttack:
            case TraderDisabled:
            case TraderSurrender:
                // These should never be the initial encounter type.
                break;
        }
        return encounterImage;
    }

    public int getChanceOfTradeInOrbit() {
        return chanceOfTradeInOrbit;
    }

    public void setChanceOfTradeInOrbit(int chanceOfTradeInOrbit) {
        this.chanceOfTradeInOrbit = chanceOfTradeInOrbit;
    }

    public int getChanceOfVeryRareEncounter() {
        return chanceOfVeryRareEncounter;
    }

    public void setChanceOfVeryRareEncounter(int chanceOfVeryRareEncounter) {
        this.chanceOfVeryRareEncounter = chanceOfVeryRareEncounter;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getFabricRipProbability() {
        return fabricRipProbability;
    }

    public void setFabricRipProbability(int fabricRipProbability) {
        this.fabricRipProbability = fabricRipProbability;
    }

    public int getQuestStatusArtifact() {
        return questStatusArtifact;
    }

    public void setQuestStatusArtifact(int questStatusArtifact) {
        this.questStatusArtifact = questStatusArtifact;
    }

    public int getQuestStatusDragonfly() {
        return questStatusDragonfly;
    }

    public void setQuestStatusDragonfly(int questStatusDragonfly) {
        this.questStatusDragonfly = questStatusDragonfly;
    }

    public int getQuestStatusExperiment() {
        return questStatusExperiment;
    }

    public void setQuestStatusExperiment(int questStatusExperiment) {
        this.questStatusExperiment = questStatusExperiment;
    }

    public int getQuestStatusGemulon() {
        return questStatusGemulon;
    }

    public void setQuestStatusGemulon(int questStatusGemulon) {
        this.questStatusGemulon = questStatusGemulon;
    }

    public int getQuestStatusJapori() {
        return questStatusJapori;
    }

    public void setQuestStatusJapori(int questStatusJapori) {
        this.questStatusJapori = questStatusJapori;
    }

    public int getQuestStatusJarek() {
        return questStatusJarek;
    }

    public void setQuestStatusJarek(int questStatusJarek) {
        this.questStatusJarek = questStatusJarek;
    }

    public int getQuestStatusMoon() {
        return questStatusMoon;
    }

    public void setQuestStatusMoon(int questStatusMoon) {
        this.questStatusMoon = questStatusMoon;
    }

    public int getQuestStatusPrincess() {
        return questStatusPrincess;
    }

    public void setQuestStatusPrincess(int questStatusPrincess) {
        this.questStatusPrincess = questStatusPrincess;
    }

    public int getQuestStatusReactor() {
        return questStatusReactor;
    }

    public void setQuestStatusReactor(int questStatusReactor) {
        this.questStatusReactor = questStatusReactor;
    }

    public int getQuestStatusScarab() {
        return questStatusScarab;
    }

    public void setQuestStatusScarab(int questStatusScarab) {
        this.questStatusScarab = questStatusScarab;
    }

    public int getQuestStatusSculpture() {
        return questStatusSculpture;
    }

    public void setQuestStatusSculpture(int questStatusSculpture) {
        this.questStatusSculpture = questStatusSculpture;
    }

    public int getQuestStatusSpaceMonster() {
        return questStatusSpaceMonster;
    }

    public void setQuestStatusSpaceMonster(int questStatusSpaceMonster) {
        this.questStatusSpaceMonster = questStatusSpaceMonster;
    }

    public int getQuestStatusWild() {
        return questStatusWild;
    }

    public void setQuestStatusWild(int questStatusWild) {
        this.questStatusWild = questStatusWild;
    }

    public int InsuranceCosts() {
        return commander.getInsurance() ? (int) Math.max(1, commander.getShip().getBaseWorth(true) * Constants.InsRate * (100 - commander.NoClaim()) / 100) : 0;
    }

    public int InterestCosts() {
        return commander.getDebt() > 0 ? (int) Math.max(1, commander.getDebt() * Constants.IntRate) : 0;
    }

    public int MercenaryCosts() {
        int total = 0;
        for (int i = 1; i < commander.getShip().Crew().length && commander.getShip().Crew()[i] != null; i++) {
            total += commander.getShip().Crew()[i].Rate();
        }
        return total;
    }

    public int Score() {
        int worth = commander.Worth() < 1000000 ? commander.Worth() : 1000000 + ((commander.Worth() - 1000000) / 10);
        int daysMoon = 0;
        int modifier = 0;
        switch (endStatus) {
            case Killed:
                modifier = 90;
                break;
            case Retired:
                modifier = 95;
                break;
            case BoughtMoon:
                daysMoon = Math.max(0, (difficulty.getId() + 1) * 100 - commander.getDays());
                modifier = 100;
                break;
        }
        return (difficulty.getId() + 1) * modifier * (daysMoon * 1000 + worth) / 250000;
    }

    public int WormholeCosts() {
        return ModelUtils.WormholeExists(commander.CurrentSystem(), WarpSystem()) ? Constants.WormDist * commander.getShip().getFuelCost() : 0;
    }

    public int[] Destinations() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < universe.length; i++) {
            if (universe[i].DestOk()) {
                list.add(i);
            }
        }
        int[] ids = new int[list.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = list.get(i);
        }
        return ids;
    }

    public int[] PricebuyCargo() {
        return buyCargoPrices;
    }

    public int[] PricesellCargo() {
        return sellCargoPrices;
    }

    public int[] Wormholes() {
        return wormholes;
    }

    public void Arrested() {
        int term = Math.max(30, -commander.getPoliceRecordScore());
        int fine = (1 + commander.Worth() * Math.min(80, -commander.getPoliceRecordScore()) / 50000) * 500;
        if (commander.getShip().WildOnBoard()) {
            fine = (int) (fine * 1.05);
        }
        DialogAlert.Alert(AlertType.EncounterArrested, mainWindow);
        DialogAlert.Alert(AlertType.JailConvicted, mainWindow, ModelUtils.multiples(term, Strings.TimeUnit), ModelUtils.multiples(fine, Strings.MoneyUnit));
        if (commander.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
            while (commander.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
                commander.getShip().RemoveEquipment(EquipmentType.Gadget, GadgetType.HiddenCargoBays);
            }
            DialogAlert.Alert(AlertType.JailHiddenCargoBaysRemoved, mainWindow);
        }
        if (commander.getShip().ReactorOnBoard()) {
            DialogAlert.Alert(AlertType.ReactorConfiscated, mainWindow);
            questStatusReactor = SpecialEvent.StatusReactorNotStarted;
        }
        if (commander.getShip().SculptureOnBoard()) {
            DialogAlert.Alert(AlertType.SculptureConfiscated, mainWindow);
            questStatusSculpture = SpecialEvent.StatusSculptureNotStarted;
        }
        if (commander.getShip().WildOnBoard()) {
            DialogAlert.Alert(AlertType.WildArrested, mainWindow);
            addNewsEvent(NewsEvent.WildArrested);
            questStatusWild = SpecialEvent.StatusWildNotStarted;
        }
        if (commander.getShip().AnyIllegalCargo()) {
            DialogAlert.Alert(AlertType.JailIllegalGoodsImpounded, mainWindow);
            commander.getShip().RemoveIllegalGoods();
        }
        if (commander.getInsurance()) {
            DialogAlert.Alert(AlertType.JailInsuranceLost, mainWindow);
            commander.setInsurance(false);
            commander.NoClaim(0);
        }
        if (commander.getShip().CrewCount() - commander.getShip().SpecialCrew().length > 1) {
            DialogAlert.Alert(AlertType.JailMercenariesLeave, mainWindow);
            for (int i = 1; i < commander.getShip().Crew().length; i++) {
                commander.getShip().Crew()[i] = null;
            }
        }
        if (commander.getShip().JarekOnBoard()) {
            DialogAlert.Alert(AlertType.JarekTakenHome, mainWindow);
            questStatusJarek = SpecialEvent.StatusJarekNotStarted;
        }
        if (commander.getShip().PrincessOnBoard()) {
            DialogAlert.Alert(AlertType.PrincessTakenHome, mainWindow);
            questStatusPrincess = SpecialEvent.StatusPrincessNotStarted;
        }
        if (questStatusJapori == SpecialEvent.StatusJaporiInTransit) {
            DialogAlert.Alert(AlertType.AntidoteTaken, mainWindow);
            questStatusJapori = SpecialEvent.StatusJaporiDone;
        }
        if (commander.getCash() >= fine) {
            commander.setCash(commander.getCash() - fine);
        } else {
            commander.setCash(Math.max(0, commander.getCash() + commander.getShip().Worth(true) - fine));
            DialogAlert.Alert(AlertType.JailShipSold, mainWindow);
            if (commander.getShip().getTribbles() > 0) {
                DialogAlert.Alert(AlertType.TribblesRemoved, mainWindow);
            }
            DialogAlert.Alert(AlertType.FleaBuilt, mainWindow);
            createFlea();
        }
        if (commander.getDebt() > 0) {
            int paydown = Math.min(commander.getCash(), commander.getDebt());
            commander.setDebt(commander.getDebt() - paydown);
            commander.setCash(commander.getCash() - paydown);
            if (commander.getDebt() > 0) {
                for (int i = 0; i < term; i++) {
                    commander.PayInterest();
                }
            }
        }
        commander.setPoliceRecordScore(Constants.PoliceRecordScoreDubious);
        increaseDays(term, mainWindow);
    }

    public void buyCargoSystem(int tradeItem, boolean max, Pane owner) {
        buyCargo(tradeItem, max, owner, CargoBuyOperation.BuySystem);
    }

    public void buyCargoTrader(int tradeItem, Pane owner) {
        buyCargo(tradeItem, false, owner, CargoBuyOperation.BuyTrader);
    }

    public void dumpCargo(int tradeItem, Pane owner) {
        sellCargo(tradeItem, false, owner, CargoSellOperation.Dump);
    }

    public void jettisonCargo(int tradeItem, boolean all, Pane owner) {
        sellCargo(tradeItem, all, owner, CargoSellOperation.Jettison);
    }

    public void plunderCargo(int tradeItem, boolean max, Pane owner) {
        buyCargo(tradeItem, max, owner, CargoBuyOperation.InPlunder);
    }

    public void sellCargoSystem(int tradeItem, boolean all, Pane owner) {
        sellCargo(tradeItem, all, owner, CargoSellOperation.SellSystem);
    }

    public void sellCargoTrader(int tradeItem, Pane owner) {
        sellCargo(tradeItem, false, owner, CargoSellOperation.SellTrader);
    }

    public void createFlea() {
        commander.setShip(new Ship(ShipType.Flea));
        commander.getShip().Crew()[0] = Commander();
        commander.setInsurance(false);
        commander.NoClaim(0);
    }

    public void beginEncounter() {
        // Set up the encounter variables.
        encounterContinueFleeing = setEncounterContinueAttacking(setOpponentDisabled(false));
    }

    public void EncounterDrink(Pane owner) {
        if (DialogAlert.Alert(AlertType.EncounterDrinkContents, owner) == DialogResult.Yes) {
            if (encounterType == EncounterType.BottleGood) {
                // two points if you're on beginner-normal, one otherwise
                commander.IncreaseRandomSkill();
                if (difficulty.getId() <= Difficulty.Normal.getId()) {
                    commander.IncreaseRandomSkill();
                }
                DialogAlert.Alert(AlertType.EncounterTonicConsumedGood, owner);
            } else {
                commander.TonicTweakRandomSkill();
                DialogAlert.Alert(AlertType.EncounterTonicConsumedStrange, owner);
            }
        }
    }

    public void EncounterMeet(Pane owner) {
        AlertType initialAlert = AlertType.Alert;
        int skill = 0;
        EquipmentType equipType = EquipmentType.Gadget;
        Object equipSubType = null;

        switch (encounterType) {
            case CaptainAhab:
                // Trade a reflective shield for skill points in piloting?
                initialAlert = AlertType.MeetCaptainAhab;
                equipType = EquipmentType.Shield;
                equipSubType = ShieldType.Reflective;
                skill = SkillType.Pilot.getId();
                break;
            case CaptainConrad:
                // Trade a military laser for skill points in engineering?
                initialAlert = AlertType.MeetCaptainConrad;
                equipType = EquipmentType.Weapon;
                equipSubType = WeaponType.MilitaryLaser;
                skill = SkillType.Engineer.getId();
                break;
            case CaptainHuie:
                // Trade a military laser for skill points in trading?
                initialAlert = AlertType.MeetCaptainHuie;
                equipType = EquipmentType.Weapon;
                equipSubType = WeaponType.MilitaryLaser;
                skill = SkillType.Trader.getId();
                break;
        }
        if (DialogAlert.Alert(initialAlert, owner) == DialogResult.Yes) {
            // Remove the equipment we're trading.
            commander.getShip().RemoveEquipment(equipType, equipSubType);
            // Add points to the appropriate skill - two points if beginner-normal, one otherwise.
            commander.Skills()[skill] = Math.min(Constants.MaxSkill, commander.Skills()[skill] + (difficulty.getId() <= Difficulty.Normal.getId() ? 2 : 1));
            DialogAlert.Alert(AlertType.SpecialTrainingCompleted, owner);
        }
    }

    public void EncounterPlunder(Pane owner) {
        (new DialogPlunder()).ShowDialog(owner);
        if (encounterType.getId() >= EncounterType.TraderAttack.getId()) {
            commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScorePlunderTrader);
            if (opponentDisabled) {
                commander.setKillsTrader(commander.getKillsTrader() + 1);
            }
        } else if (opponentDisabled) {
            if (commander.getPoliceRecordScore() >= Constants.PoliceRecordScoreDubious) {
                DialogAlert.Alert(AlertType.EncounterPiratesBounty, owner, Strings.EncounterPiratesDisabled,
                        Strings.EncounterPiratesLocation, ModelUtils.multiples(opponent.getBounty(), Strings.MoneyUnit));
                commander.setCash(commander.getCash() + opponent.getBounty());
            }
            commander.setKillsPirate(commander.getKillsPirate() + 1);
            commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreKillPirate);
        } else {
            commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScorePlunderPirate);
        }
        commander.setReputationScore(commander.getReputationScore() + (opponent.Type().getId() / 2 + 1));
    }

    public void EncounterTrade(Pane owner) {
        boolean buy = (encounterType == EncounterType.TraderBuy);
        int item = (buy ? commander.getShip() : opponent).getRandomTradeableItem();
        String alertStr = buy ? "selling" : "buying";
        int cash = commander.getCash();
        if (encounterType == EncounterType.TraderBuy) {
            sellCargoTrader(item, owner);
        } else { // EncounterType.TraderSell
            buyCargoTrader(item, owner);
        }
        if (commander.getCash() != cash) {
            DialogAlert.Alert(AlertType.EncounterTradeCompleted, owner, alertStr, Constants.TradeItems[item].Name());
        }
    }

    public void escapeWithPod() {
        DialogAlert.Alert(AlertType.EncounterEscapePodActivated, mainWindow);
        if (commander.getShip().SculptureOnBoard()) {
            DialogAlert.Alert(AlertType.SculptureSaved, mainWindow);
        }
        if (commander.getShip().ReactorOnBoard()) {
            DialogAlert.Alert(AlertType.ReactorDestroyed, mainWindow);
            questStatusReactor = SpecialEvent.StatusReactorDone;
        }
        if (commander.getShip().getTribbles() > 0) {
            DialogAlert.Alert(AlertType.TribblesKilled, mainWindow);
        }
        if (questStatusJapori == SpecialEvent.StatusJaporiInTransit) {
            int system;
            for (system = 0; system < universe.length && universe[system].SpecialEventType() != SpecialEventType.Japori; system++) {
            }
            DialogAlert.Alert(AlertType.AntidoteDestroyed, mainWindow, universe[system].Name());
            questStatusJapori = SpecialEvent.StatusJaporiNotStarted;
        }
        if (commander.getShip().ArtifactOnBoard()) {
            DialogAlert.Alert(AlertType.ArtifactLost, mainWindow);
            questStatusArtifact = SpecialEvent.StatusArtifactDone;
        }
        if (commander.getShip().JarekOnBoard()) {
            DialogAlert.Alert(AlertType.JarekTakenHome, mainWindow);
            questStatusJarek = SpecialEvent.StatusJarekNotStarted;
        }
        if (commander.getShip().PrincessOnBoard()) {
            DialogAlert.Alert(AlertType.PrincessTakenHome, mainWindow);
            questStatusPrincess = SpecialEvent.StatusPrincessNotStarted;
        }
        if (commander.getShip().WildOnBoard()) {
            DialogAlert.Alert(AlertType.WildArrested, mainWindow);
            commander.setPoliceRecordScore(commander.getPoliceRecordScore() + Constants.ScoreCaughtWithWild);
            addNewsEvent(NewsEvent.WildArrested);
            questStatusWild = SpecialEvent.StatusWildNotStarted;
        }
        if (commander.getInsurance()) {
            DialogAlert.Alert(AlertType.InsurancePayoff, mainWindow);
            commander.setCash(commander.getCash() + commander.getShip().getBaseWorth(true));
        }
        if (commander.getCash() > Constants.FleaConversionCost) {
            commander.setCash(commander.getCash() - Constants.FleaConversionCost);
        } else {
            commander.setDebt(commander.getDebt() + (Constants.FleaConversionCost - commander.getCash()));
            commander.setCash(0);
        }
        DialogAlert.Alert(AlertType.FleaBuilt, mainWindow);
        increaseDays(3, mainWindow);
        createFlea();
    }

    public void handleSpecialEvent() {
        StarSystem currentSys = commander.CurrentSystem();
        Ship ship = commander.getShip();
        boolean remove = true;
        switch (currentSys.SpecialEventType()) {
            case Artifact:
                questStatusArtifact = SpecialEvent.StatusArtifactOnBoard;
                break;
            case ArtifactDelivery:
                questStatusArtifact = SpecialEvent.StatusArtifactDone;
                break;
            case CargoForSale:
                DialogAlert.Alert(AlertType.SpecialSealedCanisters, mainWindow);
                int tradeItem = ModelUtils.getRandom(Constants.TradeItems.length);
                ship.Cargo()[tradeItem] += 3;
                commander.PriceCargo()[tradeItem] += commander.CurrentSystem().SpecialEvent().getPrice();
                break;
            case Dragonfly:
            case DragonflyBaratas:
            case DragonflyMelina:
            case DragonflyRegulas:
                questStatusDragonfly = questStatusDragonfly + 1;
                break;
            case DragonflyDestroyed:
                currentSys.SpecialEventType(SpecialEventType.DragonflyShield);
                remove = false;
                break;
            case DragonflyShield:
                if (ship.FreeSlotsShield() == 0) {
                    DialogAlert.Alert(AlertType.EquipmentNotEnoughSlots, mainWindow);
                    remove = false;
                } else {
                    DialogAlert.Alert(AlertType.EquipmentLightningShield, mainWindow);
                    ship.addEquipment(Constants.Shields[ShieldType.Lightning.id]);
                    questStatusDragonfly = SpecialEvent.StatusDragonflyDone;
                }
                break;
            case EraseRecord:
                DialogAlert.Alert(AlertType.SpecialCleanRecord, mainWindow);
                commander.setPoliceRecordScore(Constants.PoliceRecordScoreClean);
                recalculateSellPrices(currentSys);
                break;
            case Experiment:
                questStatusExperiment = SpecialEvent.StatusExperimentStarted;
                break;
            case ExperimentFailed:
                break;
            case ExperimentStopped:
                questStatusExperiment = SpecialEvent.StatusExperimentCancelled;
                canSuperWarp = true;
                break;
            case Gemulon:
                questStatusGemulon = SpecialEvent.StatusGemulonStarted;
                break;
            case GemulonFuel:
                if (ship.FreeSlotsGadget() == 0) {
                    DialogAlert.Alert(AlertType.EquipmentNotEnoughSlots, mainWindow);
                    remove = false;
                } else {
                    DialogAlert.Alert(AlertType.EquipmentFuelCompactor, mainWindow);
                    ship.addEquipment(Constants.Gadgets[GadgetType.FuelCompactor.asInteger()]);
                    questStatusGemulon = SpecialEvent.StatusGemulonDone;
                }
                break;
            case GemulonRescued:
                currentSys.SpecialEventType(SpecialEventType.GemulonFuel);
                questStatusGemulon = SpecialEvent.StatusGemulonFuel;
                remove = false;
                break;
            case Japori:
                // The japori quest should not be removed since you can fail and start it over again.
                remove = false;
                if (ship.FreeCargoBays() < 10) {
                    DialogAlert.Alert(AlertType.CargoNoEmptyBays, mainWindow);
                } else {
                    DialogAlert.Alert(AlertType.AntidoteOnBoard, mainWindow);
                    questStatusJapori = SpecialEvent.StatusJaporiInTransit;
                }
                break;
            case JaporiDelivery:
                questStatusJapori = SpecialEvent.StatusJaporiDone;
                commander.IncreaseRandomSkill();
                commander.IncreaseRandomSkill();
                break;
            case Jarek:
                if (ship.FreeCrewQuarters() == 0) {
                    DialogAlert.Alert(AlertType.SpecialNoQuarters, mainWindow);
                    remove = false;
                } else {
                    CrewMember jarek = Mercenaries()[CrewMemberId.Jarek.getId()];
                    DialogAlert.Alert(AlertType.SpecialPassengerOnBoard, mainWindow, jarek.Name());
                    ship.Hire(jarek);
                    questStatusJarek = SpecialEvent.StatusJarekStarted;
                }
                break;
            case JarekGetsOut:
                questStatusJarek = SpecialEvent.StatusJarekDone;
                ship.handleFire(CrewMemberId.Jarek);
                break;
            case Lottery:
                break;
            case Moon:
                DialogAlert.Alert(AlertType.SpecialMoonBought, mainWindow);
                questStatusMoon = SpecialEvent.StatusMoonBought;
                break;
            case MoonRetirement:
                questStatusMoon = SpecialEvent.StatusMoonDone;
                throw new GameEndException(GameEndType.BoughtMoon);
            case Princess:
                currentSys.SpecialEventType(SpecialEventType.PrincessReturned);
                remove = false;
                questStatusPrincess = questStatusPrincess + 1;
                break;
            case PrincessCentauri:
            case PrincessInthara:
                questStatusPrincess = questStatusPrincess + 1;
                break;
            case PrincessQonos:
                if (ship.FreeCrewQuarters() == 0) {
                    DialogAlert.Alert(AlertType.SpecialNoQuarters, mainWindow);
                    remove = false;
                } else {
                    CrewMember princess = Mercenaries()[CrewMemberId.Princess.getId()];
                    DialogAlert.Alert(AlertType.SpecialPassengerOnBoard, mainWindow, princess.Name());
                    ship.Hire(princess);
                }
                break;
            case PrincessQuantum:
                if (ship.FreeSlotsWeapon() == 0) {
                    DialogAlert.Alert(AlertType.EquipmentNotEnoughSlots, mainWindow);
                    remove = false;
                } else {
                    DialogAlert.Alert(AlertType.EquipmentQuantumDisruptor, mainWindow);
                    ship.addEquipment(Constants.WeaponObjects[WeaponType.QuantumDisruptor.id]);
                    questStatusPrincess = SpecialEvent.StatusPrincessDone;
                }
                break;
            case PrincessReturned:
                ship.handleFire(CrewMemberId.Princess);
                currentSys.SpecialEventType(SpecialEventType.PrincessQuantum);
                questStatusPrincess = SpecialEvent.StatusPrincessReturned;
                remove = false;
                break;
            case Reactor:
                if (ship.FreeCargoBays() < 15) {
                    DialogAlert.Alert(AlertType.CargoNoEmptyBays, mainWindow);
                    remove = false;
                } else {
                    if (ship.WildOnBoard()) {
                        if (DialogAlert.Alert(AlertType.WildWontStayAboardReactor, mainWindow, currentSys.Name()) == DialogResult.Ok) {
                            DialogAlert.Alert(AlertType.WildLeavesShip, mainWindow, currentSys.Name());
                            questStatusWild = SpecialEvent.StatusWildNotStarted;
                        } else {
                            remove = false;
                        }
                    }
                    if (remove) {
                        DialogAlert.Alert(AlertType.ReactorOnBoard, mainWindow);
                        questStatusReactor = SpecialEvent.StatusReactorFuelOk;
                    }
                }
                break;
            case ReactorDelivered:
                currentSys.SpecialEventType(SpecialEventType.ReactorLaser);
                questStatusReactor = SpecialEvent.StatusReactorDelivered;
                remove = false;
                break;
            case ReactorLaser:
                if (ship.FreeSlotsWeapon() == 0) {
                    DialogAlert.Alert(AlertType.EquipmentNotEnoughSlots, mainWindow);
                    remove = false;
                } else {
                    DialogAlert.Alert(AlertType.EquipmentMorgansLaser, mainWindow);
                    ship.addEquipment(Constants.WeaponObjects[WeaponType.MorgansLaser.id]);
                    questStatusReactor = SpecialEvent.StatusReactorDone;
                }
                break;
            case Scarab:
                questStatusScarab = SpecialEvent.StatusScarabHunting;
                break;
            case ScarabDestroyed:
                questStatusScarab = SpecialEvent.StatusScarabDestroyed;
                currentSys.SpecialEventType(SpecialEventType.ScarabUpgradeHull);
                remove = false;
                break;
            case ScarabUpgradeHull:
                DialogAlert.Alert(AlertType.ShipHullUpgraded, mainWindow);
                ship.setHullUpgraded(true);
                ship.setHull(ship.getHull() + Constants.HullUpgrade);
                questStatusScarab = SpecialEvent.StatusScarabDone;
                remove = false;
                break;
            case Sculpture:
                questStatusSculpture = SpecialEvent.StatusSculptureInTransit;
                break;
            case SculptureDelivered:
                questStatusSculpture = SpecialEvent.StatusSculptureDelivered;
                currentSys.SpecialEventType(SpecialEventType.SculptureHiddenBays);
                remove = false;
                break;
            case SculptureHiddenBays:
                questStatusSculpture = SpecialEvent.StatusSculptureDone;
                if (ship.FreeSlotsGadget() == 0) {
                    DialogAlert.Alert(AlertType.EquipmentNotEnoughSlots, mainWindow);
                    remove = false;
                } else {
                    DialogAlert.Alert(AlertType.EquipmentHiddenCompartments, mainWindow);
                    ship.addEquipment(Constants.Gadgets[GadgetType.HiddenCargoBays.asInteger()]);
                    questStatusSculpture = SpecialEvent.StatusSculptureDone;
                }
                break;
            case Skill:
                DialogAlert.Alert(AlertType.SpecialSkillIncrease, mainWindow);
                commander.IncreaseRandomSkill();
                break;
            case SpaceMonster:
                questStatusSpaceMonster = SpecialEvent.StatusSpaceMonsterAtAcamar;
                break;
            case SpaceMonsterKilled:
                questStatusSpaceMonster = SpecialEvent.StatusSpaceMonsterDone;
                break;
            case Tribble:
                DialogAlert.Alert(AlertType.TribblesOwn, mainWindow);
                ship.setTribbles(1);
                break;
            case TribbleBuyer:
                DialogAlert.Alert(AlertType.TribblesGone, mainWindow);
                commander.setCash(commander.getCash() + (ship.getTribbles() / 2));
                ship.setTribbles(0);
                break;
            case Wild:
                if (ship.FreeCrewQuarters() == 0) {
                    DialogAlert.Alert(AlertType.SpecialNoQuarters, mainWindow);
                    remove = false;
                } else if (!ship.HasWeapon(WeaponType.BeamLaser, false)) {
                    DialogAlert.Alert(AlertType.WildWontBoardLaser, mainWindow);
                    remove = false;
                } else if (ship.ReactorOnBoard()) {
                    DialogAlert.Alert(AlertType.WildWontBoardReactor, mainWindow);
                    remove = false;
                } else {
                    CrewMember wild = Mercenaries()[CrewMemberId.Wild.getId()];
                    DialogAlert.Alert(AlertType.SpecialPassengerOnBoard, mainWindow, wild.Name());
                    ship.Hire(wild);
                    questStatusWild = SpecialEvent.StatusWildStarted;
                    if (ship.SculptureOnBoard()) {
                        DialogAlert.Alert(AlertType.WildSculpture, mainWindow);
                    }
                }
                break;
            case WildGetsOut:
                // Zeethibal has a 10 in player's lowest score, an 8 in the next lowest score, and 5 elsewhere.
                CrewMember zeethibal = Mercenaries()[CrewMemberId.Zeethibal.getId()];
                zeethibal.CurrentSystem(universe[StarSystemId.Kravat.getId()]);
                int lowest1 = commander.NthLowestSkill(1);
                int lowest2 = commander.NthLowestSkill(2);
                for (int i = 0; i < zeethibal.Skills().length; i++) {
                    zeethibal.Skills()[i] = (i == lowest1 ? 10 : (i == lowest2 ? 8 : 5));
                }
                questStatusWild = SpecialEvent.StatusWildDone;
                commander.setPoliceRecordScore(Constants.PoliceRecordScoreClean);
                ship.handleFire(CrewMemberId.Wild);
                recalculateSellPrices(currentSys);
                break;
        }
        if (currentSys.SpecialEvent().getPrice() != 0) {
            commander.setCash(commander.getCash() - currentSys.SpecialEvent().getPrice());
        }
        if (remove) {
            currentSys.SpecialEventType(SpecialEventType.NA);
        }
    }

    public void increaseDays(int num, Pane owner) {
        commander.setDays(commander.getDays() + num);
        if (commander.getInsurance()) {
            commander.NoClaim(commander.NoClaim() + num);
        }
        // Police Record will gravitate towards neutral (0).
        if (commander.getPoliceRecordScore() > Constants.PoliceRecordScoreClean) {
            commander.setPoliceRecordScore(Math.max(Constants.PoliceRecordScoreClean, commander.getPoliceRecordScore() - num / 3));
        } else if (commander.getPoliceRecordScore() < Constants.PoliceRecordScoreDubious) {
            commander.setPoliceRecordScore(Math.min(Constants.PoliceRecordScoreDubious, commander.getPoliceRecordScore()
                    + num / (difficulty.getId() <= Difficulty.Normal.getId() ? 1 : difficulty.getId())));
        }
        // The Space Monster's strength increases 5% per day until it is back to full strength.
        if (spaceMonster.getHull() < spaceMonster.HullStrength()) {
            spaceMonster.setHull(Math.min(spaceMonster.HullStrength(), (int) (spaceMonster.getHull() * Math.pow(1.05, num))));
        }
        if (questStatusGemulon > SpecialEvent.StatusGemulonNotStarted && questStatusGemulon < SpecialEvent.StatusGemulonTooLate) {
            questStatusGemulon = Math.min(questStatusGemulon + num, SpecialEvent.StatusGemulonTooLate);
            if (questStatusGemulon == SpecialEvent.StatusGemulonTooLate) {
                StarSystem gemulon = universe[StarSystemId.Gemulon.getId()];
                gemulon.SpecialEventType(SpecialEventType.GemulonInvaded);
                gemulon.TechLevel(TechLevel.t0);
                gemulon.PoliticalSystemType(PoliticalSystemType.Anarchy);
            }
        }
        if (commander.getShip().ReactorOnBoard()) {
            questStatusReactor = Math.min(questStatusReactor + num, SpecialEvent.StatusReactorDate);
        }
        if (questStatusExperiment > SpecialEvent.StatusExperimentNotStarted
                && questStatusExperiment < SpecialEvent.StatusExperimentPerformed) {
            questStatusExperiment = Math.min(questStatusExperiment + num, SpecialEvent.StatusExperimentPerformed);
            if (questStatusExperiment == SpecialEvent.StatusExperimentPerformed) {
                fabricRipProbability = Constants.FabricRipInitialProbability;
                universe[StarSystemId.Daled.getId()].SpecialEventType(SpecialEventType.ExperimentFailed);
                DialogAlert.Alert(AlertType.SpecialExperimentPerformed, owner);
                addNewsEvent(NewsEvent.ExperimentPerformed);
            }
        } else if (questStatusExperiment == SpecialEvent.StatusExperimentPerformed && fabricRipProbability > 0) {
            fabricRipProbability = fabricRipProbability - num;
        }
        if (commander.getShip().JarekOnBoard()) {
            if (questStatusJarek == SpecialEvent.StatusJarekImpatient / 2) {
                DialogAlert.Alert(AlertType.SpecialPassengerConcernedJarek, owner);
            } else if (questStatusJarek == SpecialEvent.StatusJarekImpatient - 1) {
                DialogAlert.Alert(AlertType.SpecialPassengerImpatientJarek, owner);
                Mercenaries()[CrewMemberId.Jarek.getId()].Pilot(0);
                Mercenaries()[CrewMemberId.Jarek.getId()].Fighter(0);
                Mercenaries()[CrewMemberId.Jarek.getId()].Trader(0);
                Mercenaries()[CrewMemberId.Jarek.getId()].Engineer(0);
            }
            if (questStatusJarek < SpecialEvent.StatusJarekImpatient) {
                questStatusJarek = questStatusJarek + 1;
            }
        }
        if (commander.getShip().PrincessOnBoard()) {
            if (questStatusPrincess == (SpecialEvent.StatusPrincessImpatient + SpecialEvent.StatusPrincessRescued) / 2) {
                DialogAlert.Alert(AlertType.SpecialPassengerConcernedPrincess, owner);
            } else if (questStatusPrincess == SpecialEvent.StatusPrincessImpatient - 1) {
                DialogAlert.Alert(AlertType.SpecialPassengerImpatientPrincess, owner);
                Mercenaries()[CrewMemberId.Princess.getId()].Pilot(0);
                Mercenaries()[CrewMemberId.Princess.getId()].Fighter(0);
                Mercenaries()[CrewMemberId.Princess.getId()].Trader(0);
                Mercenaries()[CrewMemberId.Princess.getId()].Engineer(0);
            }
            if (questStatusPrincess < SpecialEvent.StatusPrincessImpatient) {
                questStatusPrincess = questStatusPrincess + 1;
            }
        }
        if (commander.getShip().WildOnBoard()) {
            if (questStatusWild == SpecialEvent.StatusWildImpatient / 2) {
                DialogAlert.Alert(AlertType.SpecialPassengerConcernedWild, owner);
            } else if (questStatusWild == SpecialEvent.StatusWildImpatient - 1) {
                DialogAlert.Alert(AlertType.SpecialPassengerImpatientWild, owner);
                Mercenaries()[CrewMemberId.Wild.getId()].Pilot(0);
                Mercenaries()[CrewMemberId.Wild.getId()].Fighter(0);
                Mercenaries()[CrewMemberId.Wild.getId()].Trader(0);
                Mercenaries()[CrewMemberId.Wild.getId()].Engineer(0);
            }
            if (questStatusWild < SpecialEvent.StatusWildImpatient) {
                questStatusWild = questStatusWild + 1;
            }
        }
    }

    public void addNewsEvent(NewsEvent newsEvent) {
        newsEvents.add(newsEvent.getId());
    }

    public void addNewsEventsOnArrival() {
        if (commander.CurrentSystem().SpecialEventType() != SpecialEventType.NA) {
            switch (commander.CurrentSystem().SpecialEventType()) {
                case ArtifactDelivery:
                    if (commander.getShip().ArtifactOnBoard()) {
                        addNewsEvent(NewsEvent.ArtifactDelivery);
                    }
                    break;
                case Dragonfly:
                    addNewsEvent(NewsEvent.Dragonfly);
                    break;
                case DragonflyBaratas:
                    if (questStatusDragonfly == SpecialEvent.StatusDragonflyFlyBaratas) {
                        addNewsEvent(NewsEvent.DragonflyBaratas);
                    }
                    break;
                case DragonflyDestroyed:
                    if (questStatusDragonfly == SpecialEvent.StatusDragonflyFlyZalkon) {
                        addNewsEvent(NewsEvent.DragonflyZalkon);
                    } else if (questStatusDragonfly == SpecialEvent.StatusDragonflyDestroyed) {
                        addNewsEvent(NewsEvent.DragonflyDestroyed);
                    }
                    break;
                case DragonflyMelina:
                    if (questStatusDragonfly == SpecialEvent.StatusDragonflyFlyMelina) {
                        addNewsEvent(NewsEvent.DragonflyMelina);
                    }
                    break;
                case DragonflyRegulas:
                    if (questStatusDragonfly == SpecialEvent.StatusDragonflyFlyRegulas) {
                        addNewsEvent(NewsEvent.DragonflyRegulas);
                    }
                    break;
                case ExperimentFailed:
                    addNewsEvent(NewsEvent.ExperimentFailed);
                    break;
                case ExperimentStopped:
                    if (questStatusExperiment > SpecialEvent.StatusExperimentNotStarted
                            && questStatusExperiment < SpecialEvent.StatusExperimentPerformed) {
                        addNewsEvent(NewsEvent.ExperimentStopped);
                    }
                    break;
                case Gemulon:
                    addNewsEvent(NewsEvent.Gemulon);
                    break;
                case GemulonRescued:
                    if (questStatusGemulon > SpecialEvent.StatusGemulonNotStarted) {
                        if (questStatusGemulon < SpecialEvent.StatusGemulonTooLate) {
                            addNewsEvent(NewsEvent.GemulonRescued);
                        } else {
                            addNewsEvent(NewsEvent.GemulonInvaded);
                        }
                    }
                    break;
                case Japori:
                    if (questStatusJapori == SpecialEvent.StatusJaporiNotStarted) {
                        addNewsEvent(NewsEvent.Japori);
                    }
                    break;
                case JaporiDelivery:
                    if (questStatusJapori == SpecialEvent.StatusJaporiInTransit) {
                        addNewsEvent(NewsEvent.JaporiDelivery);
                    }
                    break;
                case JarekGetsOut:
                    if (commander.getShip().JarekOnBoard()) {
                        addNewsEvent(NewsEvent.JarekGetsOut);
                    }
                    break;
                case Princess:
                    addNewsEvent(NewsEvent.Princess);
                    break;
                case PrincessCentauri:
                    if (questStatusPrincess == SpecialEvent.StatusPrincessFlyCentauri) {
                        addNewsEvent(NewsEvent.PrincessCentauri);
                    }
                    break;
                case PrincessInthara:
                    if (questStatusPrincess == SpecialEvent.StatusPrincessFlyInthara) {
                        addNewsEvent(NewsEvent.PrincessInthara);
                    }
                    break;
                case PrincessQonos:
                    if (questStatusPrincess == SpecialEvent.StatusPrincessFlyQonos) {
                        addNewsEvent(NewsEvent.PrincessQonos);
                    } else if (questStatusPrincess == SpecialEvent.StatusPrincessRescued) {
                        addNewsEvent(NewsEvent.PrincessRescued);
                    }
                    break;
                case PrincessReturned:
                    if (questStatusPrincess == SpecialEvent.StatusPrincessReturned) {
                        addNewsEvent(NewsEvent.PrincessReturned);
                    }
                    break;
                case Scarab:
                    addNewsEvent(NewsEvent.Scarab);
                    break;
                case ScarabDestroyed:
                    if (questStatusScarab == SpecialEvent.StatusScarabHunting) {
                        addNewsEvent(NewsEvent.ScarabHarass);
                    } else if (questStatusScarab >= SpecialEvent.StatusScarabDestroyed) {
                        addNewsEvent(NewsEvent.ScarabDestroyed);
                    }
                    break;
                case Sculpture:
                    addNewsEvent(NewsEvent.SculptureStolen);
                    break;
                case SculptureDelivered:
                    addNewsEvent(NewsEvent.SculptureTracked);
                    break;
                case SpaceMonsterKilled:
                    if (questStatusSpaceMonster == SpecialEvent.StatusSpaceMonsterAtAcamar) {
                        addNewsEvent(NewsEvent.SpaceMonster);
                    } else if (questStatusSpaceMonster >= SpecialEvent.StatusSpaceMonsterDestroyed) {
                        addNewsEvent(NewsEvent.SpaceMonsterKilled);
                    }
                    break;
                case WildGetsOut:
                    if (commander.getShip().WildOnBoard()) {
                        addNewsEvent(NewsEvent.WildGetsOut);
                    }
                    break;
            }
        }
    }

    public void replaceNewsEvent(int oldEvent, int newEvent) {
        if (newsEvents.contains(oldEvent)) {
            newsEvents.remove(oldEvent);
        }
        newsEvents.add(newEvent);
    }

    public void clearNewsEvents() {
        newsEvents.clear();
    }

    public void recalculateBuyPrices(StarSystem system) {
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            if (system.ItemTraded(Constants.TradeItems[i])) {
                buyCargoPrices[i] = sellCargoPrices[i];
                if (commander.getPoliceRecordScore() < Constants.PoliceRecordScoreDubious) {
                    buyCargoPrices[i] = buyCargoPrices[i] * 100 / 90;
                }
                // BuyPrice = SellPrice + 1 to 12% (depending on trader skill (minimum is 1, max 12))
                buyCargoPrices[i] = buyCargoPrices[i] * (103 + Constants.MaxSkill - commander.getShip().Trader()) / 100;
                if (buyCargoPrices[i] <= sellCargoPrices[i]) {
                    buyCargoPrices[i] = sellCargoPrices[i] + 1;
                }
            } else {
                buyCargoPrices[i] = 0;
            }
        }
    }

    public void recalculateSellPrices(StarSystem system) { // After erasure of police record, selling prices must be recalculated
        for (int i = 0; i < Constants.TradeItems.length; i++) {
            sellCargoPrices[i] = sellCargoPrices[i] * 100 / 90;
        }
    }

    public void resetVeryRareEncounters() {
        veryRareEncounters.clear();
        veryRareEncounters.add(VeryRareEncounter.MarieCeleste);
        veryRareEncounters.add(VeryRareEncounter.CaptainAhab);
        veryRareEncounters.add(VeryRareEncounter.CaptainConrad);
        veryRareEncounters.add(VeryRareEncounter.CaptainHuie);
        veryRareEncounters.add(VeryRareEncounter.BottleOld);
        veryRareEncounters.add(VeryRareEncounter.BottleGood);
    }

    public void selectNextSystemWithinRange(boolean forward) {
        int[] destinations = Destinations();
        if (destinations.length > 0) {
            int index = Utils.bruteSeek(destinations, warpSystemId.getId());
            if (index < 0) {
                index = forward ? 0 : destinations.length - 1;
            } else {
                index = (destinations.length + index + (forward ? 1 : -1)) % destinations.length;
            }
            if (ModelUtils.WormholeExists(commander.CurrentSystem(), universe[destinations[index]])) {
                selectedSystemId(commander.getCurrentSystemId());
                setTargetingWormhole();
            } else {
                selectedSystemId(StarSystemId.FromInt(destinations[index]));
            }
        }
    }

    public void selectedSystemId(StarSystemId value) {
        selectedSystemId = value;
        warpSystemId = value;
        targetingWormhole = false;
    }

    public void showNewspaper() {
        if (!paidForNewspaper) {
            int cost = difficulty.getId() + 1;
            if (commander.getCash() < cost) {
                DialogAlert.Alert(AlertType.ArrivalIFNewspaper, mainWindow, ModelUtils.multiples(cost, "credit"));
            } else if (options.getNewsAutoPay()
                    || DialogAlert.Alert(AlertType.ArrivalBuyNewspaper, mainWindow, ModelUtils.multiples(cost, "credit")) == DialogResult.Yes) {
                commander.setCash(commander.getCash() - cost);
                paidForNewspaper = true;
                mainWindow.updateAll();
            }
        }
        if (paidForNewspaper) {
            DialogAlert.Alert(AlertType.Alert, mainWindow, NewspaperHead(), NewspaperText());
        }
    }

    public void setTargetingWormhole() {
        targetingWormhole = true;
        int wormIndex = Utils.bruteSeek(wormholes, selectedSystemId.getId());
        warpSystemId = StarSystemId.FromInt(wormholes[(wormIndex + 1) % wormholes.length]);
    }

    public void warp(boolean viaSingularity) {
        if (commander.getDebt() > Constants.DebtTooLarge) {
            DialogAlert.Alert(AlertType.DebtTooLargeGrounded, mainWindow);
        } else if (commander.getCash() < MercenaryCosts()) {
            DialogAlert.Alert(AlertType.LeavingIFMercenaries, mainWindow);
        } else if (commander.getCash() < MercenaryCosts() + InsuranceCosts()) {
            DialogAlert.Alert(AlertType.LeavingIFInsurance, mainWindow);
        } else if (commander.getCash() < MercenaryCosts() + InsuranceCosts() + WormholeCosts()) {
            DialogAlert.Alert(AlertType.LeavingIFWormholeTax, mainWindow);
        } else {
            boolean wildOk = true;
            // if Wild is aboard, make sure ship is armed!
            if (commander.getShip().WildOnBoard() && !commander.getShip().HasWeapon(WeaponType.BeamLaser, false)) {
                if (DialogAlert.Alert(AlertType.WildWontStayAboardLaser, mainWindow, commander.CurrentSystem().Name()) == DialogResult.Cancel) {
                    wildOk = false;
                } else {
                    DialogAlert.Alert(AlertType.WildLeavesShip, mainWindow, commander.CurrentSystem().Name());
                    questStatusWild = SpecialEvent.StatusWildNotStarted;
                }
            }
            if (wildOk) {
                arrivedViaWormhole = ModelUtils.WormholeExists(commander.CurrentSystem(), WarpSystem());
                if (viaSingularity) {
                    addNewsEvent(NewsEvent.ExperimentArrival);
                } else {
                    NormalDeparture(viaSingularity || arrivedViaWormhole ? 0 : ModelUtils.distance(commander.CurrentSystem(), WarpSystem()));
                }
                commander.CurrentSystem().CountDown(CountDownStart());
                clearNewsEvents();
                CalculatePrices(WarpSystem());
                if (Travel()) {
                    // Clicks will be -1 if we were arrested or used the escape pod.
                    /*
                     * if (Clicks == 0) FormAlert.Alert(AlertType.TravelArrival, ParentWindow);
                     */
                } else {
                    DialogAlert.Alert(AlertType.TravelUneventfulTrip, mainWindow);
                }
                Arrival();
            }
        }
    }

    public void warpDirect() {
        warpSystemId = selectedSystemId;
        commander.CurrentSystem().CountDown(CountDownStart());
        clearNewsEvents();
        CalculatePrices(WarpSystem());
        Arrival();
    }

    public void setSelectedSystemByName(String value) {
        boolean found = false;
        for (int i = 0; i < universe.length && !found; i++) {
            String name = universe[i].Name();
            if (name.toLowerCase().contains(value.toLowerCase())) {
                selectedSystemId(StarSystemId.FromInt(i));
                found = true;
            }
        }
    }
}
