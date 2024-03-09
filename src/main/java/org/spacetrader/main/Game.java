package org.spacetrader.main;

import java.util.Arrays;
import java.util.Iterator;

import org.jwinforms.WinformPane;
import org.jwinforms.enums.DialogResult;
import org.spacetrader.main.stub.ArrayList;
import org.spacetrader.main.util.Hashtable;
import org.spacetrader.main.util.Util;
import org.spacetrader.Main;
import org.spacetrader.cargo.CargoBuyOp;
import org.spacetrader.cargo.CargoSellOp;
import org.spacetrader.cargo.TradeItem;
import org.spacetrader.cargo.TradeItemType;
import org.spacetrader.crew.CrewMemberId;
import org.spacetrader.difficulty.Difficulty;
import org.spacetrader.events.EncounterResult;
import org.spacetrader.events.EncounterType;
import org.spacetrader.events.NewsEvent;
import org.spacetrader.events.SpecialEventType;
import org.spacetrader.events.VeryRareEncounter;
import org.spacetrader.ship.ShipSize;
import org.spacetrader.ship.ShipType;
import org.spacetrader.ship.equip.EquipmentType;
import org.spacetrader.ship.equip.GadgetType;
import org.spacetrader.ship.equip.ShieldType;
import org.spacetrader.ship.equip.WeaponType;
import org.spacetrader.main.enums.AlertType;
import org.spacetrader.main.enums.GameEndType;
import org.spacetrader.main.enums.OpponentType;
import org.spacetrader.main.enums.PoliticalSystemType;
import org.spacetrader.main.enums.ShipyardId;
import org.spacetrader.main.enums.SkillType;
import org.spacetrader.main.enums.SpecialResource;
import org.spacetrader.main.enums.StarSystemId;
import org.spacetrader.main.enums.SystemPressure;
import org.spacetrader.main.enums.TechLevel;
import org.spacetrader.main.gui.FormAlert;
import org.spacetrader.main.gui.FormCargoBuy;
import org.spacetrader.main.gui.FormCargoSell;
import org.spacetrader.main.gui.FormEncounter;
import org.spacetrader.main.gui.FormJettison;
import org.spacetrader.main.gui.FormPlunder;


public class Game extends STSerializableObject {
    public static final int GalaxyHeight = 110;
    public static final int GalaxyWidth = 154;
    public static final int MinDistance = 7;
    private static Game game;
    private Commander cmdr;
    // Game Data
    private StarSystem[] _universe;
    private int[] _wormholes = new int[6];
    private CrewMember[] _mercenaries = new CrewMember[Strings.CrewMemberNames.length];
    private Ship _dragonfly = new Ship(ShipType.Dragonfly);
    private Ship _scarab = new Ship(ShipType.Scarab);
    private Ship _scorpion = new Ship(ShipType.Scorpion);
    private Ship _spaceMonster = new Ship(ShipType.SpaceMonster);
    private Ship _opponent = new Ship(ShipType.Gnat);
    private boolean _opponentDisabled = false;
    private int _chanceOfTradeInOrbit = 100;
    private int _clicks = 0; // Distance from target system, 0 = arrived
    private boolean _raided = false; // True when the commander has been raided during the trip
    private boolean _inspected = false; // True when the commander has been inspected during the trip
    private boolean _tribbleMessage = false; // Is true if the Ship Yard on the current system informed you about the tribbles
    private boolean _arrivedViaWormhole = false; // flag to indicate whether player arrived on current planet via wormhole
    private boolean _paidForNewspaper = false; // once you buy a paper on a system, you don't have to pay again.
    private boolean _litterWarning = false; // Warning against littering has been issued.
    private ArrayList<Integer> _newsEvents = new ArrayList<>(30);
    // Current Selections
    private Difficulty _difficulty = Difficulty.Normal; // Difficulty level
    private boolean _cheatEnabled = false;
    private boolean _autoSave = false;
    private boolean _easyEncounters = false;
    private GameEndType _endStatus = GameEndType.NA;
    private EncounterType _encounterType = EncounterType.FromInt(0); // Type of current encounter
    private StarSystemId _selectedSystemId = StarSystemId.NA; // Current system on chart
    private StarSystemId _warpSystemId = StarSystemId.NA; // Target system for warp
    private StarSystemId _trackedSystemId = StarSystemId.NA; // The short-range chart will display an arrow towards this system if the value is not null
    private boolean _targetWormhole = false; // Wormhole selected?
    private int[] _priceCargoBuy = new int[10];
    private int[] _priceCargoSell = new int[10];
    // Status of Quests
    private int _questStatusArtifact = 0; // 0 = not given yet, 1 = Artifact on board, 2 = Artifact no longer on board (either delivered or lost)
    private int _questStatusDragonfly = 0; // 0 = not available, 1 = Go to Baratas, 2 = Go to Melina, 3 = Go to Regulas, 4 = Go to Zalkon, 5 = Dragonfly destroyed, 6 = Got Shield
    private int _questStatusExperiment = 0; // 0 = not given yet, 1-11 = days from start; 12 = performed, 13 = cancelled
    private int _questStatusGemulon = 0; // 0 = not given yet, 1-7 = days from start, 8 = too late, 9 = in time, 10 = done
    private int _questStatusJapori = 0; // 0 = no disease, 1 = Go to Japori (always at least 10 medicine cannisters), 2 = Assignment finished or canceled
    private int _questStatusJarek = 0; // 0 = not delivered, 1-11 = on board, 12 = delivered
    private int _questStatusMoon = 0; // 0 = not bought, 1 = bought, 2 = claimed
    private int _questStatusPrincess = 0; // 0 = not available, 1 = Go to Centauri, 2 = Go to Inthara, 3 = Go to Qonos, 4 = Princess Rescued, 5-14 = On Board, 15 = Princess Returned, 16 = Got Quantum Disruptor
    private int _questStatusReactor = 0; // 0 = not encountered, 1-20 = days of mission (bays of fuel left = 10 - (ReactorStatus / 2), 21 = delivered, 22 = Done
    private int _questStatusScarab = 0; // 0 = not given yet, 1 = not destroyed, 2 = destroyed - upgrade not performed, 3 = destroyed - hull upgrade performed
    private int _questStatusSculpture = 0; // 0 = not given yet, 1 = on board, 2 = delivered, 3 = done
    private int _questStatusSpaceMonster = 0; // 0 = not available, 1 = Space monster is in Acamar system, 2 = Space monster is destroyed, 3 = Claimed reward
    private int _questStatusWild = 0; // 0 = not delivered, 1-11 = on board, 12 = delivered
    private int _fabricRipProbability = 0; // if Experiment = 12, this is the probability of being warped to a random planet.
    private boolean _justLootedMarie = false; // flag to indicate whether player looted Marie Celeste
    private boolean _canSuperWarp = false; // Do you have the Portable Singularity on board?
    private int _chanceOfVeryRareEncounter = 5;
    private ArrayList<VeryRareEncounter> _veryRareEncounters = new ArrayList<>(6); // Array of Very Rare encounters not done yet.
    // Options
    private GameOptions _options = new GameOptions(true);
    // The rest of the member variables are not saved between games.
    private Main _parentWin = null;
    private boolean _encounterContinueFleeing = false;
    private boolean _encounterContinueAttacking = false;
    private boolean _encounterCmdrFleeing = false;
    private boolean _encounterCmdrHit = false;
    private boolean _encounterOppFleeingPrev = false;
    private boolean _encounterOppFleeing = false;
    private boolean _encounterOppHit = false;

    public Game(String name, Difficulty difficulty, int pilot, int fighter, int trader, int engineer, Main parentWin) {
        game = Game.CurrentGame();
        _parentWin = parentWin;
        _difficulty = difficulty;
        // Keep Generating a new universe until PlaceSpecialEvents and PlaceShipyards return true, indicating all special events and shipyards were placed.
        do {
            GenerateUniverse();
        } while (!(PlaceSpecialEvents() && PlaceShipyards()));
        InitializeCommander(name, new CrewMember(CrewMemberId.Commander, pilot, fighter, trader, engineer, StarSystemId.NA));
        GenerateCrewMemberList();
        CreateShips();
        CalculatePrices(cmdr.CurrentSystem());
        Game.this.ResetVeryRareEncounters();
        if (_difficulty.CastToInt() < Difficulty.Normal.CastToInt()) {
            cmdr.CurrentSystem().SpecialEventType(SpecialEventType.Lottery);
        }
        //TODO: The following code block is run if the commander name is left blank
        // You get $1M, cheat mode on, easy encounters, can super-warp...
        {
            // TODO: JAF - DEBUG
            cmdr.setCash(1000000);
            _cheatEnabled = true;
            _easyEncounters = true;
            _canSuperWarp = true;
        }
    }

    @SuppressWarnings("unchecked")
    public Game(Hashtable hash, Main parentWin) {
        super(hash);
        game = Game.CurrentGame();
        _parentWin = parentWin;
        String version = GetValueFromHash(hash, "_version", String.class);
        if (version.compareTo(Consts.CurrentVersion) > 0) {
            throw new FutureVersionException();
        }
        _universe = (StarSystem[]) ArrayListToArray(GetValueFromHash(hash, "_universe", ArrayList.class), "StarSystem");
        _wormholes = GetValueFromHash(hash, "_wormholes", _wormholes, int[].class);
        _mercenaries = (CrewMember[]) ArrayListToArray(GetValueFromHash(hash, "_mercenaries", ArrayList.class), "CrewMember");
        cmdr = new Commander(GetValueFromHash(hash, "_commander", Hashtable.class));
        _dragonfly = new Ship(GetValueFromHash(hash, "_dragonfly", _dragonfly.Serialize(), Hashtable.class));
        _scarab = new Ship(GetValueFromHash(hash, "_scarab", _scarab.Serialize(), Hashtable.class));
        _scorpion = new Ship(GetValueFromHash(hash, "_scorpion", _scorpion.Serialize(), Hashtable.class));
        _spaceMonster = new Ship(GetValueFromHash(hash, "_spaceMonster", _spaceMonster.Serialize(), Hashtable.class));
        _opponent = new Ship(GetValueFromHash(hash, "_opponent", _opponent.Serialize(), Hashtable.class));
        _chanceOfTradeInOrbit = GetValueFromHash(hash, "_chanceOfTradeInOrbit", _chanceOfTradeInOrbit);
        _clicks = GetValueFromHash(hash, "_clicks", _clicks);
        _raided = GetValueFromHash(hash, "_raided", _raided);
        _inspected = GetValueFromHash(hash, "_inspected", _inspected);
        _tribbleMessage = GetValueFromHash(hash, "_tribbleMessage", _tribbleMessage);
        _arrivedViaWormhole = GetValueFromHash(hash, "_arrivedViaWormhole", _arrivedViaWormhole);
        _paidForNewspaper = GetValueFromHash(hash, "_paidForNewspaper", _paidForNewspaper);
        _litterWarning = GetValueFromHash(hash, "_litterWarning", _litterWarning);
        _newsEvents = new ArrayList<>(Arrays.asList(GetValueFromHash(hash, "_newsEvents", _newsEvents.ToArray(new Integer[0]))));
        _difficulty = Difficulty.FromInt(GetValueFromHash(hash, "_difficulty", _difficulty, Integer.class));
        _cheatEnabled = GetValueFromHash(hash, "_cheatEnabled", _cheatEnabled);
        _autoSave = GetValueFromHash(hash, "_autoSave", _autoSave);
        _easyEncounters = GetValueFromHash(hash, "_easyEncounters", _easyEncounters);
        _endStatus = GameEndType.FromInt(GetValueFromHash(hash, "_endStatus", _endStatus, Integer.class));
        _encounterType = EncounterType.FromInt(GetValueFromHash(hash, "_encounterType", _encounterType, Integer.class));
        _selectedSystemId = StarSystemId.FromInt(GetValueFromHash(hash, "_selectedSystemId", _selectedSystemId, Integer.class));
        _warpSystemId = StarSystemId.FromInt(GetValueFromHash(hash, "_warpSystemId", _warpSystemId, Integer.class));
        _trackedSystemId = StarSystemId.FromInt(GetValueFromHash(hash, "_trackedSystemId", _trackedSystemId, Integer.class));
        _targetWormhole = GetValueFromHash(hash, "_targetWormhole", _targetWormhole);
        _priceCargoBuy = GetValueFromHash(hash, "_priceCargoBuy", _priceCargoBuy, int[].class);
        _priceCargoSell = GetValueFromHash(hash, "_priceCargoSell", _priceCargoSell, int[].class);
        _questStatusArtifact = GetValueFromHash(hash, "_questStatusArtifact", _questStatusArtifact);
        _questStatusDragonfly = GetValueFromHash(hash, "_questStatusDragonfly", _questStatusDragonfly);
        _questStatusExperiment = GetValueFromHash(hash, "_questStatusExperiment", _questStatusExperiment);
        _questStatusGemulon = GetValueFromHash(hash, "_questStatusGemulon", _questStatusGemulon);
        _questStatusJapori = GetValueFromHash(hash, "_questStatusJapori", _questStatusJapori);
        _questStatusJarek = GetValueFromHash(hash, "_questStatusJarek", _questStatusJarek);
        _questStatusMoon = GetValueFromHash(hash, "_questStatusMoon", _questStatusMoon);
        _questStatusPrincess = GetValueFromHash(hash, "_questStatusPrincess", _questStatusPrincess);
        _questStatusReactor = GetValueFromHash(hash, "_questStatusReactor", _questStatusReactor);
        _questStatusScarab = GetValueFromHash(hash, "_questStatusScarab", _questStatusScarab);
        _questStatusSculpture = GetValueFromHash(hash, "_questStatusSculpture", _questStatusSculpture);
        _questStatusSpaceMonster = GetValueFromHash(hash, "_questStatusSpaceMonster", _questStatusSpaceMonster);
        _questStatusWild = GetValueFromHash(hash, "_questStatusWild", _questStatusWild);
        _fabricRipProbability = GetValueFromHash(hash, "_fabricRipProbability", _fabricRipProbability);
        _justLootedMarie = GetValueFromHash(hash, "_justLootedMarie", _justLootedMarie);
        _canSuperWarp = GetValueFromHash(hash, "_canSuperWarp", _canSuperWarp);
        _chanceOfVeryRareEncounter = GetValueFromHash(hash, "_chanceOfVeryRareEncounter", _chanceOfVeryRareEncounter);
        _veryRareEncounters = new ArrayList(
                Arrays.asList(GetValueFromHash(hash, "_veryRareEncounters", _veryRareEncounters.ToArray(new Integer[0]))));
        _options = new GameOptions(GetValueFromHash(hash, "_options", _options.Serialize(), Hashtable.class));
    }

    public static Game CurrentGame() {
        return game;
    }

    public static void CurrentGame(Game g) {
        game = g;
    }

    @Override
    public Hashtable Serialize() {
        Hashtable ht = super.Serialize();
        ht.add("_version", "2.00");
        ht.add("_universe", ArrayToArrayList(_universe));
        ht.add("_commander", cmdr.Serialize());
        ht.add("_wormholes", _wormholes);
        ht.add("_mercenaries", ArrayToArrayList(_mercenaries));
        ht.add("_dragonfly", _dragonfly.Serialize());
        ht.add("_scarab", _scarab.Serialize());
        ht.add("_scorpion", _scorpion.Serialize());
        ht.add("_spaceMonster", _spaceMonster.Serialize());
        ht.add("_opponent", _opponent.Serialize());
        ht.add("_chanceOfTradeInOrbit", _chanceOfTradeInOrbit);
        ht.add("_clicks", _clicks);
        ht.add("_raided", _raided);
        ht.add("_inspected", _inspected);
        ht.add("_tribbleMessage", _tribbleMessage);
        ht.add("_arrivedViaWormhole", _arrivedViaWormhole);
        ht.add("_paidForNewspaper", _paidForNewspaper);
        ht.add("_litterWarning", _litterWarning);
        ht.add("_newsEvents", _newsEvents);
        ht.add("_difficulty", _difficulty.CastToInt());
        ht.add("_cheatEnabled", _cheatEnabled);
        ht.add("_autoSave", _autoSave);
        ht.add("_easyEncounters", _easyEncounters);
        ht.add("_endStatus", _endStatus.CastToInt());
        ht.add("_encounterType", _encounterType.CastToInt());
        ht.add("_selectedSystemId", _selectedSystemId.CastToInt());
        ht.add("_warpSystemId", _warpSystemId.CastToInt());
        ht.add("_trackedSystemId", _trackedSystemId.CastToInt());
        ht.add("_targetWormhole", _targetWormhole);
        ht.add("_priceCargoBuy", _priceCargoBuy);
        ht.add("_priceCargoSell", _priceCargoSell);
        ht.add("_questStatusArtifact", _questStatusArtifact);
        ht.add("_questStatusDragonfly", _questStatusDragonfly);
        ht.add("_questStatusExperiment", _questStatusExperiment);
        ht.add("_questStatusGemulon", _questStatusGemulon);
        ht.add("_questStatusJapori", _questStatusJapori);
        ht.add("_questStatusJarek", _questStatusJarek);
        ht.add("_questStatusMoon", _questStatusMoon);
        ht.add("_questStatusPrincess", _questStatusPrincess);
        ht.add("_questStatusReactor", _questStatusReactor);
        ht.add("_questStatusScarab", _questStatusScarab);
        ht.add("_questStatusSculpture", _questStatusSculpture);
        ht.add("_questStatusSpaceMonster", _questStatusSpaceMonster);
        ht.add("_questStatusWild", _questStatusWild);
        ht.add("_fabricRipProbability", _fabricRipProbability);
        ht.add("_justLootedMarie", _justLootedMarie);
        ht.add("_canSuperWarp", _canSuperWarp);
        ht.add("_chanceOfVeryRareEncounter", _chanceOfVeryRareEncounter);
        ht.add("_veryRareEncounters", ArrayListToIntArray(_veryRareEncounters));
        ht.add("_options", _options.Serialize());
        return ht;
    }

    private boolean DetermineEncounter() {
        // If there is a specific encounter that needs to happen, it will, otherwise we'll generate a random encounter.
        return DetermineNonRandomEncounter() || DetermineRandomEncounter();
    }

    private boolean DetermineNonRandomEncounter() {
        boolean showEncounter = false;
        // Encounter with space monster
        if (getClicks() == 1 && WarpSystem().Id() == StarSystemId.Acamar && getQuestStatusSpaceMonster() == SpecialEvent.StatusSpaceMonsterAtAcamar) {
            setOpponent(_spaceMonster);
            setEncounterType(cmdr.getShip().Cloaked() ? EncounterType.SpaceMonsterIgnore : EncounterType.SpaceMonsterAttack);
            showEncounter = true;
        } else if (getArrivedViaWormhole() && getClicks() == 20 && WarpSystem().SpecialEventType() != SpecialEventType.NA
                && WarpSystem().SpecialEvent().Type() == SpecialEventType.ScarabDestroyed
                && getQuestStatusScarab() == SpecialEvent.StatusScarabHunting) {
            // Encounter with the stolen Scarab
            setOpponent(_scarab);
            setEncounterType(cmdr.getShip().Cloaked() ? EncounterType.ScarabIgnore : EncounterType.ScarabAttack);
            showEncounter = true;
        } else if (getClicks() == 1 && WarpSystem().Id() == StarSystemId.Zalkon && getQuestStatusDragonfly() == SpecialEvent.StatusDragonflyFlyZalkon) {
            // Encounter with stolen Dragonfly
            setOpponent(Dragonfly());
            setEncounterType(cmdr.getShip().Cloaked() ? EncounterType.DragonflyIgnore : EncounterType.DragonflyAttack);
            showEncounter = true;
        } else if (getClicks() == 1 && WarpSystem().Id() == StarSystemId.Qonos && getQuestStatusPrincess() == SpecialEvent.StatusPrincessFlyQonos) {
            // Encounter with kidnappers in the Scorpion
            setOpponent(_scorpion);
            setEncounterType(cmdr.getShip().Cloaked() ? EncounterType.ScorpionIgnore : EncounterType.ScorpionAttack);
            showEncounter = true;
        } else if (getClicks() == 1 && getJustLootedMarie()) {
            // ah, just when you thought you were gonna get away with it...
            GenerateOpponent(OpponentType.Police);
            setEncounterType(EncounterType.MarieCelestePolice);
            setJustLootedMarie(false);
            showEncounter = true;
        }
        return showEncounter;
    }

    private boolean DeterminePirateEncounter(boolean mantis) {
        boolean showEncounter = false;
        if (mantis) {
            GenerateOpponent(OpponentType.Mantis);
            setEncounterType(EncounterType.PirateAttack);
        } else {
            GenerateOpponent(OpponentType.Pirate);
            // If you have a cloak, they don't see you
            if (cmdr.getShip().Cloaked()) {
                setEncounterType(EncounterType.PirateIgnore);
            } else if (getOpponent().Type().CastToInt() > cmdr.getShip().Type().CastToInt()
                    || getOpponent().Type().CastToInt() >= ShipType.Grasshopper.CastToInt()
                    || Functions.GetRandom(Consts.ReputationScoreElite) > (cmdr.getReputationScore() * 4)
                    / (1 + getOpponent().Type().CastToInt())) {
                // Pirates will mostly attack, but they are cowardly: if your rep is too high, they tend to flee
                // if Pirates are in a better ship, they won't flee, even if you have a very scary reputation.
                setEncounterType(EncounterType.PirateAttack);
            } else {
                setEncounterType(EncounterType.PirateFlee);
            }
        }
        // If they ignore you or flee and you can't see them, the encounter doesn't take place
        // If you automatically don't want to confront someone who ignores you, the encounter may not take place
        if (getEncounterType() == EncounterType.PirateAttack || !(getOpponent().Cloaked() || _options.getAlwaysIgnorePirates())) {
            showEncounter = true;
        }
        return showEncounter;
    }

    private boolean DeterminePoliceEncounter() {
        boolean showEncounter = false;
        GenerateOpponent(OpponentType.Police);
        // If you are cloaked, they don't see you
        setEncounterType(EncounterType.PoliceIgnore);
        if (!cmdr.getShip().Cloaked()) {
            if (cmdr.getPoliceRecordScore() < Consts.PoliceRecordScoreDubious) {
                // If you're a criminal, the police will tend to attack
                // JAF - fixed this; there was code that didn't do anything.
                // if you're suddenly stuck in a lousy ship, Police won't flee even if you have a fearsome reputation.
                if (getOpponent().WeaponStrength() > 0
                        && (cmdr.getReputationScore() < Consts.ReputationScoreAverage
                        || Functions.GetRandom(Consts.ReputationScoreElite) > (cmdr.getReputationScore() / (1 + getOpponent().Type().CastToInt())))
                        || getOpponent().Type().CastToInt() > cmdr.getShip().Type().CastToInt()) {
                    if (cmdr.getPoliceRecordScore() >= Consts.PoliceRecordScoreCriminal) {
                        getEncounterType();
                        setEncounterType(EncounterType.PoliceSurrender);
                    } else {
                        setEncounterType(EncounterType.PoliceAttack);
                    }
                } else if (getOpponent().Cloaked()) {
                    setEncounterType(EncounterType.PoliceIgnore);
                } else {
                    setEncounterType(EncounterType.PoliceFlee);
                }
            } else if (!getInspected()
                    && (cmdr.getPoliceRecordScore() < Consts.PoliceRecordScoreClean
                    || (cmdr.getPoliceRecordScore() < Consts.PoliceRecordScoreLawful && Functions.GetRandom(12 - _difficulty.CastToInt()) < 1)
                    || (cmdr.getPoliceRecordScore() >= Consts.PoliceRecordScoreLawful && Functions.GetRandom(40) == 0))) {
                // If you're reputation is dubious, the police will inspect you
                // If your record is clean, the police will inspect you with a chance of 10% on Normal
                // If your record indicates you are a lawful trader, the chance on inspection drops to 2.5%
                setEncounterType(EncounterType.PoliceInspect);
                setInspected(true);
            }
        }
        // If they ignore you or flee and you can't see them, the encounter doesn't take place
        // If you automatically don't want to confront someone who ignores you, the encounter may not take place. Otherwise it will - JAF
        if (getEncounterType() == EncounterType.PoliceAttack || getEncounterType() == EncounterType.PoliceInspect
                || !(getOpponent().Cloaked() || _options.getAlwaysIgnorePolice())) {
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
        if (WarpSystem().Id() == StarSystemId.Gemulon && getQuestStatusGemulon() == SpecialEvent.StatusGemulonTooLate) {
            if (Functions.GetRandom(10) > 4) {
                mantis = true;
            }
        } else {
            // Check if it is time for an encounter
            int encounter = Functions.GetRandom(44 - (2 * _difficulty.CastToInt()));
            int policeModifier = Math.max(1, 3 - PoliceRecord.GetPoliceRecordFromScore(cmdr.getPoliceRecordScore()).Type().CastToInt());
            // encounters are half as likely if you're in a flea.
            if (cmdr.getShip().Type() == ShipType.Flea) {
                encounter *= 2;
            }
            if (encounter < WarpSystem().PoliticalSystem().ActivityPirates().CastToInt()) { // When you are already raided, other pirates have little to gain
                pirate = !getRaided();
            } else if (encounter < WarpSystem().PoliticalSystem().ActivityPirates().CastToInt() + WarpSystem().PoliticalSystem().ActivityPolice().CastToInt() * policeModifier) {
                // policeModifier adapts itself to your criminal record: you'll encounter more police if you are a hardened criminal.
                police = true;
            } else if (encounter
                    < WarpSystem().PoliticalSystem().ActivityPirates().CastToInt()
                    + WarpSystem().PoliticalSystem().ActivityPolice().CastToInt() * policeModifier
                    + WarpSystem().PoliticalSystem().ActivityTraders().CastToInt()) {
                trader = true;
            } else if (cmdr.getShip().WildOnBoard() && WarpSystem().Id() == StarSystemId.Kravat) {
                // if you're coming in to Kravat & you have Wild onboard, there'll be swarms o' cops.
                police = Functions.GetRandom(100) < 100 / Math.max(2, Math.min(4, 5 - _difficulty.CastToInt()));
            } else if (cmdr.getShip().ArtifactOnBoard() && Functions.GetRandom(20) <= 3) {
                mantis = true;
            }
        }
        if (police) {
            showEncounter = DeterminePoliceEncounter();
        } else if (pirate || mantis) {
            showEncounter = DeterminePirateEncounter(mantis);
        } else if (trader) {
            showEncounter = DetermineTraderEncounter();
        } else if (cmdr.getDays() > 10 && Functions.GetRandom(1000) < getChanceOfVeryRareEncounter() && _veryRareEncounters.size() > 0) {
            showEncounter = DetermineVeryRareEncounter();
        }
        return showEncounter;
    }

    private boolean DetermineTraderEncounter() {
        boolean showEncounter = false;
        GenerateOpponent(OpponentType.Trader);
        // If you are cloaked, they don't see you
        setEncounterType(EncounterType.TraderIgnore);
        if (!cmdr.getShip().Cloaked()) {
            // If you're a criminal, traders tend to flee if you've got at least some reputation
            if (!cmdr.getShip().Cloaked() && cmdr.getPoliceRecordScore() <= Consts.PoliceRecordScoreCriminal
                    && Functions.GetRandom(Consts.ReputationScoreElite) <= (cmdr.getReputationScore() * 10) / (1 + getOpponent().Type().CastToInt())) {
                setEncounterType(EncounterType.TraderFlee);
            } else if (Functions.GetRandom(1000) < getChanceOfTradeInOrbit()) { // Will there be trade in orbit?
                if (cmdr.getShip().FreeCargoBays() > 0 && getOpponent().HasTradeableItems()) {
                    setEncounterType(EncounterType.TraderSell);
                } else if (cmdr.getShip().HasTradeableItems()) {
                    // we fudge on whether the trader has capacity to carry the stuff he's buying.
                    setEncounterType(EncounterType.TraderBuy);
                }
            }
        }
        // If they ignore you or flee and you can't see them, the encounter doesn't take place
        // If you automatically don't want to confront someone who ignores you, the encounter may not take place; otherwise it will.
        if (!getOpponent().Cloaked()
                && !(_options.getAlwaysIgnoreTraders() && (getEncounterType() == EncounterType.TraderIgnore || getEncounterType() == EncounterType.TraderFlee))
                && !((getEncounterType() == EncounterType.TraderBuy || getEncounterType() == EncounterType.TraderSell) && _options.getAlwaysIgnoreTradeInOrbit())) {
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
        switch (_veryRareEncounters.get(Functions.GetRandom(_veryRareEncounters.size()))) {
            case MarieCeleste:
                // Marie Celeste cannot be at Acamar, Qonos, or Zalkon as it may cause problems with the Space Monster, Scorpion, or Dragonfly
                if (getClicks() > 1 && cmdr.getCurrentSystemId() != StarSystemId.Acamar
                        && cmdr.getCurrentSystemId() != StarSystemId.Zalkon
                        && cmdr.getCurrentSystemId() != StarSystemId.Qonos) {
                    _veryRareEncounters.remove(VeryRareEncounter.MarieCeleste);
                    setEncounterType(EncounterType.MarieCeleste);
                    GenerateOpponent(OpponentType.Trader);
                    for (int i = 0; i < getOpponent().Cargo().length; i++) {
                        getOpponent().Cargo()[i] = 0;
                    }
                    getOpponent().Cargo()[TradeItemType.Narcotics.CastToInt()] = Math.min(getOpponent().CargoBays(), 5);
                    showEncounter = true;
                }
                break;
            case CaptainAhab:
                if (cmdr.getShip().HasShield(ShieldType.Reflective) && cmdr.Pilot() < 10
                        && cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreCriminal) {
                    _veryRareEncounters.remove(VeryRareEncounter.CaptainAhab);
                    getEncounterType();
                    setEncounterType(EncounterType.CaptainAhab);
                    GenerateOpponent(OpponentType.FamousCaptain);
                    showEncounter = true;
                }
                break;
            case CaptainConrad:
                if (cmdr.getShip().HasWeapon(WeaponType.MilitaryLaser, true) && cmdr.Engineer() < 10
                        && cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreCriminal) {
                    _veryRareEncounters.remove(VeryRareEncounter.CaptainConrad);
                    getEncounterType();
                    setEncounterType(EncounterType.CaptainConrad);
                    GenerateOpponent(OpponentType.FamousCaptain);

                    showEncounter = true;
                }
                break;
            case CaptainHuie:
                if (cmdr.getShip().HasWeapon(WeaponType.MilitaryLaser, true) && cmdr.Trader() < 10
                        && cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreCriminal) {
                    _veryRareEncounters.remove(VeryRareEncounter.CaptainHuie);
                    getEncounterType();
                    setEncounterType(EncounterType.CaptainHuie);
                    GenerateOpponent(OpponentType.FamousCaptain);
                    showEncounter = true;
                }
                break;
            case BottleOld:
                _veryRareEncounters.remove(VeryRareEncounter.BottleOld);
                setEncounterType(EncounterType.BottleOld);
                GenerateOpponent(OpponentType.Bottle);
                showEncounter = true;
                break;
            case BottleGood:
                _veryRareEncounters.remove(VeryRareEncounter.BottleGood);
                setEncounterType(EncounterType.BottleGood);
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
        if (!(_difficulty == Difficulty.Beginner && defender.CommandersShip() && fleeing) && (attacker.CommandersShip() && getOpponentDisabled()
                && attacker.HasGadget(GadgetType.TargetingSystem) || Functions.GetRandom(attacker.Fighter() + defender.getSize().CastToInt()) >= (fleeing ? 2 : 1)
                * Functions.GetRandom(5 + defender.Pilot() / 2))) {
            // If the defender is disabled, it only takes one shot to destroy it completely.
            if (attacker.CommandersShip() && getOpponentDisabled()) {
                defender.setHull(0);
            } else {
                int attackerLasers = attacker.WeaponStrength(WeaponType.PulseLaser, WeaponType.MorgansLaser);
                int attackerDisruptors = attacker.WeaponStrength(WeaponType.PhotonDisruptor, WeaponType.QuantumDistruptor);
                if (defender.Type() == ShipType.Scarab) {
                    attackerLasers -= attacker.WeaponStrength(WeaponType.BeamLaser, WeaponType.MilitaryLaser);
                    attackerDisruptors -= attacker.WeaponStrength(WeaponType.PhotonDisruptor, WeaponType.PhotonDisruptor);
                }
                int attackerWeapons = attackerLasers + attackerDisruptors;
                int disrupt = 0;
                // Attempt to disable the opponent if they're not already disabled, their shields are down, we have disabling weapons, and the option is checked.
                if (defender.Disableable() && defender.ShieldCharge() == 0 && !getOpponentDisabled()
                        && _options.getDisableOpponents() && attackerDisruptors > 0) {
                    disrupt = Functions.GetRandom(attackerDisruptors * (100 + 2 * attacker.Fighter()) / 100);
                } else {
                    int damage = attackerWeapons == 0 ? 0 : Functions.GetRandom(attackerWeapons * (100 + 2 * attacker.Fighter()) / 100);
                    if (damage > 0) {
                        hit = true;
                        // Reactor on board -- damage is boosted!
                        if (defender.ReactorOnBoard()) {
                            damage *= (int) (1 + (_difficulty.CastToInt() + 1) * (_difficulty.CastToInt() < Difficulty.Normal.CastToInt() ? 0.25 : 0.33));
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
                            damage = Math.max(1, damage - Functions.GetRandom(defender.Engineer()));
                            disrupt = damage * attackerDisruptors / attackerWeapons;
                            // Only that damage coming from Lasers will deplete the hull.
                            damage -= disrupt;
                            // At least 2 shots on Normal level are needed to destroy the hull
                            // (3 on Easy, 4 on Beginner, 1 on Hard or Impossible). For opponents, it is always 2.
                            damage = Math.min(damage, defender.HullStrength() / (defender.CommandersShip() ? Math.max(1, Difficulty.Impossible.CastToInt()
                                    - _difficulty.CastToInt()) : 2));
                            // If the hull is hardened, damage is halved.
                            if (getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
                                damage /= 2;
                            }
                            defender.setHull(Math.max(0, defender.getHull() - damage));
                        }
                    }
                }
                // Did the opponent get disabled? (Disruptors are 3 times more effective against the ship's systems than they are against the shields).
                if (defender.getHull() > 0 && defender.Disableable() && Functions.GetRandom(100) < disrupt * Consts.DisruptorSystemsMultiplier * 100 / defender.getHull()) {
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
        for (int i = 0; i < _universe.length; i++) {
            int distance = Functions.Distance(_universe[baseSystem.CastToInt()], _universe[i]);
            if (distance >= 70 && distance < bestDistance && _universe[i].SpecialEventType() == SpecialEventType.NA) {
                system = i;
                bestDistance = distance;
            }
        }
        if (system >= 0) {
            _universe[system].SpecialEventType(specEvent);
        }
        return (system >= 0);
    }

    private boolean PlaceShipyards() {
        boolean goodUniverse = true;
        ArrayList<Integer> systemIdList = new ArrayList<>();
        for (int system = 0; system < _universe.length; system++) {
            if (_universe[system].TechLevel() == TechLevel.t7) {
                systemIdList.add(system);
            }
        }
        if (systemIdList.size() < Consts.Shipyards.length) {
            goodUniverse = false;
        } else {
            // Assign the shipyards to High-Tech systems.
            for (int shipyard = 0; shipyard < Consts.Shipyards.length; shipyard++) {
                _universe[systemIdList.get(Functions.GetRandom(systemIdList.size()))].ShipyardId(ShipyardId.FromInt(shipyard));
            }
        }
        return goodUniverse;
    }

    private boolean PlaceSpecialEvents() {
        boolean goodUniverse = true;
        int system;
        _universe[StarSystemId.Baratas.CastToInt()].SpecialEventType(SpecialEventType.DragonflyBaratas);
        _universe[StarSystemId.Melina.CastToInt()].SpecialEventType(SpecialEventType.DragonflyMelina);
        _universe[StarSystemId.Regulas.CastToInt()].SpecialEventType(SpecialEventType.DragonflyRegulas);
        _universe[StarSystemId.Zalkon.CastToInt()].SpecialEventType(SpecialEventType.DragonflyDestroyed);
        _universe[StarSystemId.Daled.CastToInt()].SpecialEventType(SpecialEventType.ExperimentStopped);
        _universe[StarSystemId.Gemulon.CastToInt()].SpecialEventType(SpecialEventType.GemulonRescued);
        _universe[StarSystemId.Japori.CastToInt()].SpecialEventType(SpecialEventType.JaporiDelivery);
        _universe[StarSystemId.Devidia.CastToInt()].SpecialEventType(SpecialEventType.JarekGetsOut);
        _universe[StarSystemId.Utopia.CastToInt()].SpecialEventType(SpecialEventType.MoonRetirement);
        _universe[StarSystemId.Nix.CastToInt()].SpecialEventType(SpecialEventType.ReactorDelivered);
        _universe[StarSystemId.Acamar.CastToInt()].SpecialEventType(SpecialEventType.SpaceMonsterKilled);
        _universe[StarSystemId.Kravat.CastToInt()].SpecialEventType(SpecialEventType.WildGetsOut);
        _universe[StarSystemId.Endor.CastToInt()].SpecialEventType(SpecialEventType.SculptureDelivered);
        _universe[StarSystemId.Galvon.CastToInt()].SpecialEventType(SpecialEventType.Princess);
        _universe[StarSystemId.Centauri.CastToInt()].SpecialEventType(SpecialEventType.PrincessCentauri);
        _universe[StarSystemId.Inthara.CastToInt()].SpecialEventType(SpecialEventType.PrincessInthara);
        _universe[StarSystemId.Qonos.CastToInt()].SpecialEventType(SpecialEventType.PrincessQonos);
        // Assign a wormhole location endpoint for the Scarab.
        for (system = 0; system < _wormholes.length && _universe[_wormholes[system]].SpecialEventType() != SpecialEventType.NA; system++) {
        }
        if (system < _wormholes.length) {
            _universe[_wormholes[system]].SpecialEventType(SpecialEventType.ScarabDestroyed);
        } else {
            goodUniverse = false;
        }
        // Find a Hi-Tech system without a special event.
        if (goodUniverse) {
            for (system = 0; system < _universe.length && !(_universe[system].SpecialEventType() == SpecialEventType.NA && _universe[system].TechLevel() == TechLevel.t7); system++) {
            }
            if (system < _universe.length) {
                _universe[system].SpecialEventType(SpecialEventType.ArtifactDelivery);
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
            for (int i = 0; i < Consts.SpecialEvents.length; i++) {
                for (int j = 0; j < Consts.SpecialEvents[i].Occurrence(); j++) {
                    do {
                        system = Functions.GetRandom(_universe.length);
                    } while (_universe[system].SpecialEventType() != SpecialEventType.NA);
                    _universe[system].SpecialEventType(Consts.SpecialEvents[i].Type());
                }
            }
        }
        return goodUniverse;
    }

    private void Arrival() {
        cmdr.CurrentSystem(WarpSystem());
        cmdr.CurrentSystem().Visited(true);
        setPaidForNewspaper(false);
        if (TrackedSystem() == cmdr.CurrentSystem() && _options.getTrackAutoOff()) {
            setTrackedSystemId(StarSystemId.NA);
        }
        ArrivalCheckReactor();
        ArrivalCheckTribbles();
        ArrivalCheckDebt();
        ArrivalPerformRepairs();
        ArrivalUpdatePressuresAndQuantities();
        ArrivalCheckEasterEgg();
        CalculatePrices(cmdr.CurrentSystem());
        NewsAddEventsOnArrival();
        if (_options.getNewsAutoShow()) {
            ShowNewspaper();
        }
    }

    private void ArrivalCheckDebt() {
        // Check for Large Debt - 06/30/01 SRA
        if (cmdr.getDebt() >= Consts.DebtWarning) {
            FormAlert.Alert(AlertType.DebtWarning, getParentWindow());
        } else if (cmdr.getDebt() > 0 && _options.getRemindLoans() && cmdr.getDays() % 5 == 0) { // Debt Reminder
            FormAlert.Alert(AlertType.DebtReminder, getParentWindow(), Functions.Multiples(cmdr.getDebt(), Strings.MoneyUnit));
        }
    }

    private void ArrivalCheckEasterEgg() {
        /* This Easter Egg gives the commander a Lighting Shield */
        if (cmdr.CurrentSystem().Id() == StarSystemId.Og) {
            boolean egg = true;
            for (int i = 0; i < cmdr.getShip().Cargo().length && egg; i++) {
                if (cmdr.getShip().Cargo()[i] != 1) {
                    egg = false;
                }
            }
            if (egg && cmdr.getShip().FreeSlotsShield() > 0) {
                FormAlert.Alert(AlertType.Egg, getParentWindow());
                cmdr.getShip().AddEquipment(Consts.Shields[ShieldType.Lightning.id]);
                for (int i = 0; i < cmdr.getShip().Cargo().length; i++) {
                    cmdr.getShip().Cargo()[i] = 0;
                    cmdr.PriceCargo()[i] = 0;
                }
            }
        }
    }

    private void ArrivalCheckReactor() {
        if (getQuestStatusReactor() == SpecialEvent.StatusReactorDate) {
            FormAlert.Alert(AlertType.ReactorMeltdown, getParentWindow());
            setQuestStatusReactor(SpecialEvent.StatusReactorNotStarted);
            if (cmdr.getShip().getEscapePod()) {
                EscapeWithPod();
            } else {
                FormAlert.Alert(AlertType.ReactorDestroyed, getParentWindow());
                throw new GameEndException(GameEndType.Killed);
            }
        } else {
            // Reactor warnings:
            if (getQuestStatusReactor() == SpecialEvent.StatusReactorFuelOk + 1) { // now they know the quest has a time constraint!
                FormAlert.Alert(AlertType.ReactorWarningFuel, getParentWindow());
            } else if (getQuestStatusReactor() == SpecialEvent.StatusReactorDate - 4) { // better deliver it soon!
                FormAlert.Alert(AlertType.ReactorWarningFuelGone, getParentWindow());
            } else if (getQuestStatusReactor() == SpecialEvent.StatusReactorDate - 2) { // last warning!
                FormAlert.Alert(AlertType.ReactorWarningTemp, getParentWindow());
            }
        }
    }

    private void ArrivalCheckTribbles() {
        Ship ship = cmdr.getShip();
        if (ship.getTribbles() > 0) {
            int previousTribbles = ship.getTribbles();
            int narc = TradeItemType.Narcotics.CastToInt();
            int food = TradeItemType.Food.CastToInt();
            if (ship.ReactorOnBoard()) {
                if (ship.getTribbles() < 20) {
                    ship.setTribbles(0);
                    FormAlert.Alert(AlertType.TribblesAllDied, getParentWindow());
                } else {
                    ship.setTribbles(ship.getTribbles() / 2);
                    FormAlert.Alert(AlertType.TribblesHalfDied, getParentWindow());
                }
            } else if (ship.Cargo()[narc] > 0) {
                int dead = Math.min(1 + Functions.GetRandom(3), ship.Cargo()[narc]);
                cmdr.PriceCargo()[narc] = cmdr.PriceCargo()[narc] * (ship.Cargo()[narc] - dead) / ship.Cargo()[narc];
                ship.Cargo()[narc] -= dead;
                ship.Cargo()[TradeItemType.Furs.CastToInt()] += dead;
                ship.setTribbles(ship.getTribbles() - Math.min(dead * (Functions.GetRandom(5) + 98), ship.getTribbles() - 1));
                FormAlert.Alert(AlertType.TribblesMostDied, getParentWindow());
            } else {
                if (ship.Cargo()[food] > 0 && ship.getTribbles() < Consts.MaxTribbles) {
                    int eaten = ship.Cargo()[food] - Functions.GetRandom(ship.Cargo()[food]);
                    cmdr.PriceCargo()[food] -= cmdr.PriceCargo()[food] * eaten / ship.Cargo()[food];
                    ship.Cargo()[food] -= eaten;
                    ship.setTribbles(ship.getTribbles() + (eaten * 100));
                    FormAlert.Alert(AlertType.TribblesAteFood, getParentWindow());
                }
                if (ship.getTribbles() < Consts.MaxTribbles) {
                    ship.setTribbles(ship.getTribbles() + (1 + Functions.GetRandom(ship.Cargo()[food] > 0 ? ship.getTribbles() : ship.getTribbles() / 2)));
                }
                if (ship.getTribbles() > Consts.MaxTribbles) {
                    ship.setTribbles(Consts.MaxTribbles);
                }
                if ((previousTribbles < 100 && ship.getTribbles() >= 100)
                        || (previousTribbles < 1000 && ship.getTribbles() >= 1000)
                        || (previousTribbles < 10000 && ship.getTribbles() >= 10000)
                        || (previousTribbles < 50000 && ship.getTribbles() >= 50000)
                        || (previousTribbles < Consts.MaxTribbles && ship.getTribbles() == Consts.MaxTribbles)) {
                    String qty = ship.getTribbles() == Consts.MaxTribbles ? Strings.TribbleDangerousNumber : Functions.FormatNumber(ship.getTribbles());
                    FormAlert.Alert(AlertType.TribblesInspector, getParentWindow(), qty);
                }
            }
            setTribbleMessage(false);
        }
    }

    private void ArrivalPerformRepairs() {
        Ship ship = cmdr.getShip();
        if (ship.getHull() < ship.HullStrength()) {
            ship.setHull(ship.getHull() + Math.min(ship.HullStrength() - ship.getHull(), Functions.GetRandom(ship.Engineer())));
        }
        for (int i = 0; i < ship.Shields().length; ++i) {
            if (ship.Shields()[i] != null) {
                ship.Shields()[i].setCharge(ship.Shields()[i].Power());
            }
        }
        boolean fuelOk = true;
        int toAdd = ship.FuelTanks() - ship.getFuel();
        if (_options.getAutoFuel() && toAdd > 0) {
            if (cmdr.getCash() >= toAdd * ship.getFuelCost()) {
                ship.setFuel(ship.getFuel() + toAdd);
                cmdr.setCash(cmdr.getCash() - (toAdd * ship.getFuelCost()));
            } else {
                fuelOk = false;
            }
        }
        boolean repairOk = true;
        toAdd = ship.HullStrength() - ship.getHull();
        if (_options.getAutoRepair() && toAdd > 0) {
            if (cmdr.getCash() >= toAdd * ship.getRepairCost()) {
                ship.setHull(ship.getHull() + toAdd);
                cmdr.setCash(cmdr.getCash() - (toAdd * ship.getRepairCost()));
            } else {
                repairOk = false;
            }
        }
        if (!fuelOk && !repairOk) {
            FormAlert.Alert(AlertType.ArrivalIFFuelRepairs, getParentWindow());
        } else if (!fuelOk) {
            FormAlert.Alert(AlertType.ArrivalIFFuel, getParentWindow());
        } else if (!repairOk) {
            FormAlert.Alert(AlertType.ArrivalIFRepairs, getParentWindow());
        }
    }

    private void ArrivalUpdatePressuresAndQuantities() {
        for (int i = 0; i < _universe.length; i++) {
            if (Functions.GetRandom(100) < 15) {
                _universe[i].SystemPressure((SystemPressure.FromInt(_universe[i].SystemPressure() == SystemPressure.None
                        ? Functions.GetRandom(SystemPressure.War.CastToInt(), SystemPressure.Employment.CastToInt() + 1) : SystemPressure.None.CastToInt())));
            }
            if (_universe[i].CountDown() > 0) {
                _universe[i].CountDown(_universe[i].CountDown() - 1);
                if (_universe[i].CountDown() > CountDownStart()) {
                    _universe[i].CountDown(CountDownStart());
                } else if (_universe[i].CountDown() <= 0) {
                    _universe[i].InitializeTradeItems();
                } else {
                    for (int j = 0; j < Consts.TradeItems.length; j++) {
                        if (WarpSystem().ItemTraded(Consts.TradeItems[j])) {
                            _universe[i].TradeItems()[j] = Math.max(0, _universe[i].TradeItems()[j] + Functions.GetRandom(-4, 5));
                        }
                    }
                }
            }
        }
    }

    private void CalculatePrices(StarSystem system) {
        for (int i = 0; i < Consts.TradeItems.length; i++) {
            int price = Consts.TradeItems[i].StandardPrice(system);
            if (price > 0) {
                // In case of a special status, adapt price accordingly
                if (Consts.TradeItems[i].PressurePriceHike() == system.SystemPressure()) {
                    price = price * 3 / 2;
                }
                // Randomize price a bit
                int variance = Math.min(Consts.TradeItems[i].PriceVariance(), price - 1);
                price += Functions.GetRandom(-variance, variance + 1);
                // Criminals have to pay off an intermediary
                if (cmdr.getPoliceRecordScore() < Consts.PoliceRecordScoreDubious) {
                    price = price * 90 / 100;
                }
            }
            _priceCargoSell[i] = price;
        }
        RecalculateBuyPrices(system);
    }

    private void CargoBuy(int tradeItem, boolean max, WinformPane owner, CargoBuyOp op) {
        int freeBays = cmdr.getShip().FreeCargoBays();
        int[] items = null;
        int unitPrice = 0;
        int cashToSpend = cmdr.getCash();
        switch (op) {
            case BuySystem:
                freeBays = Math.max(0, cmdr.getShip().FreeCargoBays() - _options.getLeaveEmpty());
                items = cmdr.CurrentSystem().TradeItems();
                unitPrice = _priceCargoBuy[tradeItem];
                cashToSpend = cmdr.CashToSpend();
                break;
            case BuyTrader:
                items = getOpponent().Cargo();
                TradeItem item = Consts.TradeItems[tradeItem];
                int chance = item.Illegal() ? 45 : 10;
                double adj = Functions.GetRandom(100) < chance ? 1.1 : (item.Illegal() ? 0.8 : 0.9);
                unitPrice = Math.min(item.MaxTradePrice(), Math.max(item.MinTradePrice(), (int) Math.round(_priceCargoBuy[tradeItem] * adj / item.RoundOff()) * item.RoundOff()));
                break;
            case InPlunder:
                items = getOpponent().Cargo();
                break;
        }
        if (op == CargoBuyOp.BuySystem && cmdr.getDebt() > Consts.DebtTooLarge) {
            FormAlert.Alert(AlertType.DebtTooLargeTrade, owner);
        } else if (op == CargoBuyOp.BuySystem && (items[tradeItem] <= 0 || unitPrice <= 0)) {
            FormAlert.Alert(AlertType.CargoNoneAvailable, owner);
        } else if (freeBays == 0) {
            FormAlert.Alert(AlertType.CargoNoEmptyBays, owner);
        } else if (op != CargoBuyOp.InPlunder && cashToSpend < unitPrice) {
            FormAlert.Alert(AlertType.CargoIF, owner);
        } else {
            int qty = 0;
            int maxAmount = Math.min(freeBays, items[tradeItem]);
            if (op == CargoBuyOp.BuySystem) {
                maxAmount = Math.min(maxAmount, cmdr.CashToSpend() / unitPrice);
            }
            if (max) {
                qty = maxAmount;
            } else {
                FormCargoBuy form = new FormCargoBuy(tradeItem, maxAmount, op);
                if (form.ShowDialog(owner) == DialogResult.OK) {
                    qty = form.Amount();
                }
            }
            if (qty > 0) {
                int totalPrice = qty * unitPrice;
                cmdr.getShip().Cargo()[tradeItem] += qty;
                items[tradeItem] -= qty;
                cmdr.setCash(cmdr.getCash() - totalPrice);
                cmdr.PriceCargo()[tradeItem] += totalPrice;
            }
        }
    }

    private void CargoSell(int tradeItem, boolean all, WinformPane owner, CargoSellOp op) {
        int qtyInHand = cmdr.getShip().Cargo()[tradeItem];
        int unitPrice;
        switch (op) {
            case SellSystem:
                unitPrice = _priceCargoSell[tradeItem];
                break;
            case SellTrader:
                TradeItem item = Consts.TradeItems[tradeItem];
                int chance = item.Illegal() ? 45 : 10;
                double adj = Functions.GetRandom(100) < chance ? (item.Illegal() ? 0.8 : 0.9) : 1.1;
                unitPrice = Math.min(item.MaxTradePrice(), Math.max(item.MinTradePrice(), (int) Math.round(_priceCargoSell[tradeItem] * adj / item.RoundOff()) * item.RoundOff()));
                break;
            default:
                unitPrice = 0;
                break;
        }
        if (qtyInHand == 0) {
            FormAlert.Alert(AlertType.CargoNoneToSell, owner, Strings.CargoSellOps[op.CastToInt()]);
        } else if (op == CargoSellOp.SellSystem && unitPrice <= 0) {
            FormAlert.Alert(AlertType.CargoNotInterested, owner);
        } else {
            if (op != CargoSellOp.Jettison || getLitterWarning() || cmdr.getPoliceRecordScore() <= Consts.PoliceRecordScoreDubious
                    || FormAlert.Alert(AlertType.EncounterDumpWarning, owner) == DialogResult.Yes) {
                int unitCost = 0;
                int maxAmount = (op == CargoSellOp.SellTrader) ? Math.min(qtyInHand, getOpponent().FreeCargoBays()) : qtyInHand;
                if (op == CargoSellOp.Dump) {
                    unitCost = 5 * (_difficulty.CastToInt() + 1);
                    maxAmount = Math.min(maxAmount, cmdr.CashToSpend() / unitCost);
                }
                int price = unitPrice > 0 ? unitPrice : -unitCost;
                int qty = 0;
                if (all) {
                    qty = maxAmount;
                } else {
                    FormCargoSell form = new FormCargoSell(tradeItem, maxAmount, op, price);
                    if (form.ShowDialog(owner) == DialogResult.OK) {
                        qty = form.Amount();
                    }
                }
                if (qty > 0) {
                    int totalPrice = qty * price;
                    cmdr.getShip().Cargo()[tradeItem] -= qty;
                    cmdr.PriceCargo()[tradeItem] = (cmdr.PriceCargo()[tradeItem] * (qtyInHand - qty)) / qtyInHand;
                    cmdr.setCash(cmdr.getCash() + totalPrice);
                    if (op == CargoSellOp.Jettison) {
                        if (Functions.GetRandom(10) < _difficulty.CastToInt() + 1) {
                            if (cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreDubious) {
                                cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreDubious);
                            } else {
                                cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() - 1);
                            }
                            NewsAddEvent(NewsEvent.CaughtLittering);
                        }
                    }
                }
            }
        }
    }

    private void CreateShips() {
        // set the details of the Dragonfly...
        Dragonfly().Crew()[0] = Mercenaries()[CrewMemberId.Dragonfly.CastToInt()];
        Dragonfly().AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
        Dragonfly().AddEquipment(Consts.WeapObjs[WeaponType.PulseLaser.id]);
        Dragonfly().AddEquipment(Consts.Shields[ShieldType.Lightning.id]);
        Dragonfly().AddEquipment(Consts.Shields[ShieldType.Lightning.id]);
        Dragonfly().AddEquipment(Consts.Shields[ShieldType.Lightning.id]);
        Dragonfly().AddEquipment(Consts.Gadgets[GadgetType.AutoRepairSystem.asInteger()]);
        Dragonfly().AddEquipment(Consts.Gadgets[GadgetType.TargetingSystem.asInteger()]);
        // set the details of the Scarab...
        _scarab.Crew()[0] = Mercenaries()[CrewMemberId.Scarab.CastToInt()];
        _scarab.AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
        _scarab.AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
        // set the details of the Scorpion...
        _scorpion.Crew()[0] = Mercenaries()[CrewMemberId.Scorpion.CastToInt()];
        _scorpion.AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
        _scorpion.AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
        _scorpion.AddEquipment(Consts.Shields[ShieldType.Reflective.id]);
        _scorpion.AddEquipment(Consts.Shields[ShieldType.Reflective.id]);
        _scorpion.AddEquipment(Consts.Gadgets[GadgetType.AutoRepairSystem.asInteger()]);
        _scorpion.AddEquipment(Consts.Gadgets[GadgetType.TargetingSystem.asInteger()]);
        // set the details of the Space Monster...
        _spaceMonster.Crew()[0] = Mercenaries()[CrewMemberId.SpaceMonster.CastToInt()];
        _spaceMonster.AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
        _spaceMonster.AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
        _spaceMonster.AddEquipment(Consts.WeapObjs[WeaponType.MilitaryLaser.id]);
    }

    private void EncounterDefeatDragonfly() {
        cmdr.setKillsPirate(cmdr.getKillsPirate() + 1);
        cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillPirate);
        setQuestStatusDragonfly(SpecialEvent.StatusDragonflyDestroyed);
    }

    private void EncounterDefeatScarab() {
        cmdr.setKillsPirate(cmdr.getKillsPirate() + 1);
        cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillPirate);
        setQuestStatusScarab(SpecialEvent.StatusScarabDestroyed);
    }

    private void EncounterDefeatScorpion() {
        cmdr.setKillsPirate(cmdr.getKillsPirate() + 1);
        cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillPirate);
        setQuestStatusPrincess(SpecialEvent.StatusPrincessRescued);
    }

    private void EncounterScoop(WinformPane owner) {
        // Chance 50% to pick something up on Normal level, 33% on Hard level, 25% on Impossible level, and 100% on Easy or Beginner.
        if ((_difficulty.CastToInt() < Difficulty.Normal.CastToInt() || Functions.GetRandom(_difficulty.CastToInt()) == 0)
                && getOpponent().FilledCargoBays() > 0) {
            // Changed this to actually pick a good that was in the opponent's cargo hold - JAF.
            int index = Functions.GetRandom(getOpponent().FilledCargoBays());
            int tradeItem = -1;
            for (int sum = 0; sum <= index; sum += getOpponent().Cargo()[++tradeItem]) {
            }
            if (FormAlert.Alert(AlertType.EncounterScoop, owner, Consts.TradeItems[tradeItem].Name()) == DialogResult.Yes) {
                boolean jettisoned = false;
                if (cmdr.getShip().FreeCargoBays() == 0 && FormAlert.Alert(AlertType.EncounterScoopNoRoom, owner) == DialogResult.Yes) {
                    (new FormJettison()).ShowDialog(owner);
                    jettisoned = true;
                }
                if (cmdr.getShip().FreeCargoBays() > 0) {
                    cmdr.getShip().Cargo()[tradeItem]++;
                } else if (jettisoned) {
                    FormAlert.Alert(AlertType.EncounterScoopNoScoop, owner);
                }
            }
        }
    }

    private void EncounterUpdateEncounterType(int prevCmdrHull, int prevOppHull) {
        int chance = Functions.GetRandom(100);
        if (getOpponent().getHull() < prevOppHull || getOpponentDisabled()) {
            switch (getEncounterType()) {
                case FamousCaptainAttack:
                    if (getOpponentDisabled()) {
                        setEncounterType(EncounterType.FamousCaptDisabled);
                    }
                    break;
                case PirateAttack:
                case PirateFlee:
                case PirateSurrender:
                    if (getOpponentDisabled()) {
                        setEncounterType(EncounterType.PirateDisabled);
                    } else if (getOpponent().getHull() < (prevOppHull * 2) / 3) {
                        if (cmdr.getShip().getHull() < (prevCmdrHull * 2) / 3) {
                            if (chance < 60) {
                                getEncounterType();
                                setEncounterType(EncounterType.PirateFlee);
                            }
                        } else {
                            if (chance < 10 && getOpponent().Type() != ShipType.Mantis) {
                                setEncounterType(EncounterType.PirateSurrender);
                            } else {
                                setEncounterType(EncounterType.PirateFlee);
                            }
                        }
                    }
                    break;
                case PoliceAttack:
                case PoliceFlee:
                    if (getOpponentDisabled()) {
                        setEncounterType(EncounterType.PoliceDisabled);
                    } else if (getOpponent().getHull() < prevOppHull / 2 && (cmdr.getShip().getHull() >= prevCmdrHull / 2 || chance < 40)) {
                        setEncounterType(EncounterType.PoliceFlee);
                    }
                    break;
                case TraderAttack:
                case TraderFlee:
                case TraderSurrender:
                    if (getOpponentDisabled()) {
                        setEncounterType(EncounterType.TraderDisabled);
                    } else if (getOpponent().getHull() < (prevOppHull * 2) / 3) {
                        if (chance < 60) {
                            setEncounterType(EncounterType.TraderSurrender);
                        } else {
                            setEncounterType(EncounterType.TraderFlee);
                        }
                    } else if (getOpponent().getHull() < (prevOppHull * 9) / 10 && (cmdr.getShip().getHull() < (prevCmdrHull * 2) / 3 && chance < 20
                            || cmdr.getShip().getHull() < (prevCmdrHull * 9) / 10 && chance < 60 || cmdr.getShip().getHull() >= (prevCmdrHull * 9) / 10)) {
                        // If you get damaged a lot, the trader tends to keep shooting;
                        // if you get damaged a little, the trader may keep shooting;
                        // if you get damaged very little or not at all, the trader will flee.
                        setEncounterType(EncounterType.TraderFlee);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void EncounterWon(WinformPane owner) {
        if (getEncounterType().CastToInt() >= EncounterType.PirateAttack.CastToInt()
                && getEncounterType().CastToInt() <= EncounterType.PirateDisabled.CastToInt()
                && getOpponent().Type() != ShipType.Mantis
                && cmdr.getPoliceRecordScore() >= Consts.PoliceRecordScoreDubious) {
            FormAlert.Alert(AlertType.EncounterPiratesBounty, owner, Strings.EncounterPiratesDestroyed, "", Functions.Multiples(getOpponent().Bounty(), Strings.MoneyUnit));
        } else {
            FormAlert.Alert(AlertType.EncounterYouWin, owner);
        }
        switch (getEncounterType()) {
            case FamousCaptainAttack:
                cmdr.setKillsTrader(cmdr.getKillsTrader() + 1);
                if (cmdr.getReputationScore() < Consts.ReputationScoreDangerous) {
                    cmdr.setReputationScore(Consts.ReputationScoreDangerous);
                } else {
                    cmdr.setReputationScore(cmdr.getReputationScore() + Consts.ScoreKillCaptain);
                }
                // bump news flag from attacked to ship destroyed
                NewsReplaceEvent(NewsLatestEvent(), NewsEvent.FromInt(NewsLatestEvent() + 1).CastToInt());
                break;
            case DragonflyAttack:
                EncounterDefeatDragonfly();
                break;
            case PirateAttack:
            case PirateFlee:
            case PirateSurrender:
                cmdr.setKillsPirate(cmdr.getKillsPirate() + 1);
                if (getOpponent().Type() != ShipType.Mantis) {
                    if (cmdr.getPoliceRecordScore() >= Consts.PoliceRecordScoreDubious) {
                        cmdr.setCash(cmdr.getCash() + getOpponent().Bounty());
                    }
                    cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillPirate);
                    EncounterScoop(owner);
                }
                break;
            case PoliceAttack:
            case PoliceFlee:
                cmdr.setKillsPolice(cmdr.getKillsPolice() + 1);
                cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillPolice);
                break;
            case ScarabAttack:
                EncounterDefeatScarab();
                break;
            case SpaceMonsterAttack:
                cmdr.setKillsPirate(cmdr.getKillsPirate() + 1);
                cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillPirate);
                setQuestStatusSpaceMonster(SpecialEvent.StatusSpaceMonsterDestroyed);
                break;
            case TraderAttack:
            case TraderFlee:
            case TraderSurrender:
                cmdr.setKillsTrader(cmdr.getKillsTrader() + 1);
                cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillTrader);
                EncounterScoop(owner);
                break;
            default:
                break;
        }
        cmdr.setReputationScore(cmdr.getReputationScore() + (getOpponent().Type().CastToInt() / 2 + 1));
    }

    private void GenerateCrewMemberList() {
        int[] used = new int[_universe.length];
        int d = _difficulty.CastToInt();
        // Zeethibal may be on Kravat
        used[StarSystemId.Kravat.CastToInt()] = 1;
        // special individuals:
        // Zeethibal, Jonathan Wild's Nephew - skills will be set later.
        // Wild, Jonathan Wild earns his keep now - JAF.
        // Jarek, Ambassador Jarek earns his keep now - JAF.
        // Dummy pilots for opponents.
        Mercenaries()[CrewMemberId.Zeethibal.CastToInt()] = new CrewMember(CrewMemberId.Zeethibal, 5, 5, 5, 5, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Opponent.CastToInt()] = new CrewMember(CrewMemberId.Opponent, 5, 5, 5, 5, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Wild.CastToInt()] = new CrewMember(CrewMemberId.Wild, 7, 10, 2, 5, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Jarek.CastToInt()] = new CrewMember(CrewMemberId.Jarek, 3, 2, 10, 4, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Princess.CastToInt()] = new CrewMember(CrewMemberId.Princess, 4, 3, 8, 9, StarSystemId.NA);
        Mercenaries()[CrewMemberId.FamousCaptain.CastToInt()] = new CrewMember(CrewMemberId.FamousCaptain, 10, 10, 10, 10, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Dragonfly.CastToInt()] = new CrewMember(CrewMemberId.Dragonfly, 4 + d, 6 + d, 1, 6 + d, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Scarab.CastToInt()] = new CrewMember(CrewMemberId.Scarab, 5 + d, 6 + d, 1, 6 + d, StarSystemId.NA);
        Mercenaries()[CrewMemberId.Scorpion.CastToInt()] = new CrewMember(CrewMemberId.Scorpion, 8 + d, 8 + d, 1, 6 + d, StarSystemId.NA);
        Mercenaries()[CrewMemberId.SpaceMonster.CastToInt()] = new CrewMember(CrewMemberId.SpaceMonster, 8 + d, 8 + d, 1, 1 + d, StarSystemId.NA);
        // JAF - Changing this to allow multiple mercenaries in each system, but no more than three.
        for (int i = 1; i < Mercenaries().length; i++) {
            // Only create a CrewMember Object if one doesn't already exist in this slot in the array.
            if (Mercenaries()[i] == null) {
                StarSystemId id;
                boolean ok = false;
                do {
                    id = StarSystemId.FromInt(Functions.GetRandom(_universe.length));
                    if (used[id.CastToInt()] < 3) {
                        used[id.CastToInt()]++;
                        ok = true;
                    }
                } while (!ok);
                Mercenaries()[i] = new CrewMember(CrewMemberId.FromInt(i), Functions.RandomSkill(), Functions.RandomSkill(), Functions.RandomSkill(), Functions.RandomSkill(), id);
            }
        }
    }

    private void GenerateOpponent(OpponentType oppType) {
        setOpponent(new Ship(oppType));
    }

    private void GenerateUniverse() {
        _universe = new StarSystem[Strings.SystemNames.length];
        int i, j;
        for (i = 0; i < _universe.length; i++) {
            StarSystemId id = (StarSystemId.FromInt(i));
            SystemPressure pressure = SystemPressure.None;
            SpecialResource specRes = SpecialResource.Nothing;
            ShipSize size = ShipSize.FromInt(Functions.GetRandom(ShipSize.Huge.CastToInt() + 1));
            PoliticalSystem polSys = Consts.PoliticalSystems[Functions.GetRandom(Consts.PoliticalSystems.length)];
            TechLevel tech = TechLevel.FromInt(Functions.GetRandom(polSys.MinimumTechLevel().ordinal(), polSys.MaximumTechLevel().ordinal() + 1));
            // Galvon must be a Monarchy.
            if (id == StarSystemId.Galvon) {
                size = ShipSize.Large;
                polSys = Consts.PoliticalSystems[PoliticalSystemType.Monarchy.CastToInt()];
                tech = TechLevel.t7;
            }
            if (Functions.GetRandom(100) < 15) {
                pressure = SystemPressure.FromInt(Functions.GetRandom(SystemPressure.War.CastToInt(), SystemPressure.Employment.CastToInt() + 1));
            }
            if (Functions.GetRandom(5) >= 3) {
                specRes = SpecialResource.FromInt(Functions.GetRandom(SpecialResource.MineralRich.CastToInt(), SpecialResource.Warlike.CastToInt() + 1));
            }
            int x = 0;
            int y = 0;
            if (i < _wormholes.length) {
                // Place the first systems somewhere in the center.
                x = ((GalaxyWidth * (1 + 2 * (i % 3))) / 6) - Functions.GetRandom(-Consts.CloseDistance + 1, Consts.CloseDistance);
                y = ((GalaxyHeight * (i < 3 ? 1 : 3)) / 4) - Functions.GetRandom(-Consts.CloseDistance + 1, Consts.CloseDistance);
                _wormholes[i] = i;
            } else {
                boolean ok = false;
                while (!ok) {
                    x = Functions.GetRandom(1, GalaxyWidth);
                    y = Functions.GetRandom(1, GalaxyHeight);
                    boolean closeFound = false;
                    boolean tooClose = false;
                    for (j = 0; j < i && !tooClose; j++) {
                        // Minimum distance between any two systems not to be accepted.
                        if (Functions.Distance(_universe[j], x, y) < MinDistance) {
                            tooClose = true;
                        }
                        // There should be at least one system which is close enough.
                        if (Functions.Distance(_universe[j], x, y) < Consts.CloseDistance) {
                            closeFound = true;
                        }
                    }
                    ok = (closeFound && !tooClose);
                }
            }
            _universe[i] = new StarSystem(id, x, y, size, tech, polSys.Type(), pressure, specRes);
        }
        // Randomize the system locations a bit more, otherwise the systems with the first names in the alphabet are all in the center.
        for (i = 0; i < _universe.length; i++) {
            j = Functions.GetRandom(_universe.length);
            if (!Functions.WormholeExists(j, -1)) {
                int x = _universe[i].X();
                int y = _universe[i].Y();
                _universe[i].X(_universe[j].X());
                _universe[i].Y(_universe[j].Y());
                _universe[j].X(x);
                _universe[j].Y(y);
                int w = Util.BruteSeek(_wormholes, i);
                if (w >= 0) {
                    _wormholes[w] = j;
                }
            }
        }
        // Randomize wormhole order
        for (i = 0; i < _wormholes.length; i++) {
            j = Functions.GetRandom(_wormholes.length);
            int w = _wormholes[i];
            _wormholes[i] = _wormholes[j];
            _wormholes[j] = w;
        }
    }

    private void InitializeCommander(String name, CrewMember commanderCrewMember) {
        cmdr = new Commander(commanderCrewMember);
        Mercenaries()[CrewMemberId.Commander.CastToInt()] = Commander();
        Strings.CrewMemberNames[CrewMemberId.Commander.CastToInt()] = name;
        while (cmdr.CurrentSystem() == null) {
            StarSystem system = _universe[Functions.GetRandom(_universe.length)];
            if (system.SpecialEventType() == SpecialEventType.NA
                    && system.TechLevel().ordinal() > TechLevel.t0.ordinal()
                    && system.TechLevel().ordinal() < TechLevel.t7.ordinal()) {
                // Make sure at least three other systems can be reached
                int close = 0;
                for (int i = 0; i < _universe.length && close < 3; i++) {
                    if (i != system.Id().CastToInt() && Functions.Distance(_universe[i], system) <= cmdr.getShip().FuelTanks()) {
                        close++;
                    }
                }
                if (close >= 3) {
                    cmdr.CurrentSystem(system);
                }
            }
        }
        cmdr.CurrentSystem().Visited(true);
    }

    private void NormalDeparture(int fuel) {
        cmdr.setCash(cmdr.getCash() - (MercenaryCosts() + InsuranceCosts() + WormholeCosts()));
        cmdr.getShip().setFuel(cmdr.getShip().getFuel() - fuel);
        cmdr.PayInterest();
        IncDays(1, getParentWindow());
    }

    public ArrayList<Integer> NewsEvents() {
        return _newsEvents;
    }

    public ArrayList<VeryRareEncounter> VeryRareEncounters() {
        return _veryRareEncounters;
    }

    public Commander Commander() {
        return cmdr;
    }

    public CrewMember[] Mercenaries() {
        return _mercenaries;
    }

    public Difficulty Difficulty() {
        return _difficulty;
    }

    public EncounterResult EncounterExecuteAction(WinformPane owner) {
        EncounterResult result = EncounterResult.Continue;
        int prevCmdrHull = cmdr.getShip().getHull();
        int prevOppHull = getOpponent().getHull();
        setEncounterCmdrHit(false);
        setEncounterOppHit(false);
        setEncounterOppFleeingPrev(getEncounterOppFleeing());
        setEncounterOppFleeing(false);
        // Fire shots
        switch (getEncounterType()) {
            case DragonflyAttack:
            case FamousCaptainAttack:
            case MarieCelestePolice:
            case PirateAttack:
            case PoliceAttack:
            case ScarabAttack:
            case ScorpionAttack:
            case SpaceMonsterAttack:
            case TraderAttack:
                setEncounterCmdrHit(EncounterExecuteAttack(getOpponent(), cmdr.getShip(), getEncounterCmdrFleeing()));
                setEncounterOppHit(!getEncounterCmdrFleeing() && EncounterExecuteAttack(cmdr.getShip(), getOpponent(), false));
                break;
            case PirateFlee:
            case PirateSurrender:
            case PoliceFlee:
            case TraderFlee:
            case TraderSurrender:
                setEncounterOppHit(!getEncounterCmdrFleeing() && EncounterExecuteAttack(cmdr.getShip(), getOpponent(), true));
                setEncounterOppFleeing(true);
                break;
            default:
                setEncounterOppHit(!getEncounterCmdrFleeing() && EncounterExecuteAttack(cmdr.getShip(), getOpponent(), false));
                break;
        }
        // Determine whether someone gets destroyed
        if (cmdr.getShip().getHull() <= 0) {
            if (cmdr.getShip().getEscapePod()) {
                result = EncounterResult.EscapePod;
            } else {
                FormAlert.Alert(getOpponent().getHull() <= 0 ? AlertType.EncounterBothDestroyed : AlertType.EncounterYouLose, owner);
                result = EncounterResult.Killed;
            }
        } else if (getOpponentDisabled()) {
            if (getOpponent().Type() == ShipType.Dragonfly || getOpponent().Type() == ShipType.Scarab || getOpponent().Type() == ShipType.Scorpion) {
                String str2 = "";
                switch (getOpponent().Type()) {
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
                FormAlert.Alert(AlertType.EncounterDisabledOpponent, owner, EncounterShipText(), str2);
                cmdr.setReputationScore(cmdr.getReputationScore() + (getOpponent().Type().CastToInt() / 2 + 1));
                result = EncounterResult.Normal;
            } else {
                EncounterUpdateEncounterType(prevCmdrHull, prevOppHull);
                setEncounterOppFleeing(false);
            }
        } else if (getOpponent().getHull() <= 0) {
            EncounterWon(owner);
            result = EncounterResult.Normal;
        } else {
            boolean escaped = false;
            // Determine whether someone gets away.
            if (getEncounterCmdrFleeing()
                    && (_difficulty == Difficulty.Beginner || (Functions.GetRandom(7) + cmdr.getShip().Pilot() / 3) * 2 >= Functions.GetRandom(getOpponent().Pilot())
                    * (2 + _difficulty.CastToInt()))) {
                FormAlert.Alert(getEncounterCmdrHit() ? AlertType.EncounterEscapedHit : AlertType.EncounterEscaped, owner);
                escaped = true;
            } else if (getEncounterOppFleeing() && Functions.GetRandom(cmdr.getShip().Pilot()) * 4 <= Functions.GetRandom(7 + getOpponent().Pilot() / 3) * 2) {
                FormAlert.Alert(AlertType.EncounterOpponentEscaped, owner);
                escaped = true;
            }

            if (escaped) {
                result = EncounterResult.Normal;
            } else {
                // Determine whether the opponent's actions must be changed
                EncounterType prevEncounter = getEncounterType();
                EncounterUpdateEncounterType(prevCmdrHull, prevOppHull);
                // Update the opponent fleeing flag.
                switch (getEncounterType()) {
                    case PirateFlee:
                    case PirateSurrender:
                    case PoliceFlee:
                    case TraderFlee:
                    case TraderSurrender:
                        setEncounterOppFleeing(true);
                        break;
                    default:
                        setEncounterOppFleeing(false);
                        break;
                }
                if (_options.getContinuousAttack()
                        && (getEncounterCmdrFleeing() || !getEncounterOppFleeing() || _options.getContinuousAttackFleeing()
                        && (getEncounterType() == prevEncounter || getEncounterType() != EncounterType.PirateSurrender
                        && getEncounterType() != EncounterType.TraderSurrender))) {
                    if (getEncounterCmdrFleeing()) {
                        setEncounterContinueFleeing(true);
                    } else {
                        setEncounterContinueAttacking(true);
                    }
                }
            }
        }
        return result;
    }

    public EncounterResult EncounterVerifySurrender(WinformPane owner) {
        EncounterResult result = EncounterResult.Continue;
        if (getOpponent().Type() == ShipType.Mantis) {
            if (cmdr.getShip().ArtifactOnBoard()) {
                if (FormAlert.Alert(AlertType.EncounterAliensSurrender, owner) == DialogResult.Yes) {
                    FormAlert.Alert(AlertType.ArtifactRelinquished, owner);
                    setQuestStatusArtifact(SpecialEvent.StatusArtifactNotStarted);
                    result = EncounterResult.Normal;
                }
            } else {
                FormAlert.Alert(AlertType.EncounterSurrenderRefused, owner);
            }
        } else if (getEncounterType() == EncounterType.PoliceAttack || getEncounterType() == EncounterType.PoliceSurrender) {
            if (cmdr.getPoliceRecordScore() <= Consts.PoliceRecordScorePsychopath) {
                FormAlert.Alert(AlertType.EncounterSurrenderRefused, owner);
            } else if (FormAlert.Alert(AlertType.EncounterPoliceSurrender, owner, new String[]{
                    cmdr.getShip().IllegalSpecialCargoDescription(Strings.EncounterPoliceSurrenderCargo, true, false),
                    cmdr.getShip().IllegalSpecialCargoActions()}) == DialogResult.Yes) {
                result = EncounterResult.Arrested;
            }
        } else if (cmdr.getShip().PrincessOnBoard() && !cmdr.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
            FormAlert.Alert(AlertType.EncounterPiratesSurrenderPrincess, owner);
        } else {
            setRaided(true);
            if (cmdr.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
                ArrayList<String> precious = new ArrayList<>();
                if (cmdr.getShip().PrincessOnBoard()) {
                    precious.add(Strings.EncounterHidePrincess);
                }
                if (cmdr.getShip().SculptureOnBoard()) {
                    precious.add(Strings.EncounterHideSculpture);
                }
                FormAlert.Alert(AlertType.PreciousHidden, owner, Functions.StringVars(Strings.ListStrings[precious.size()], precious.toArray(new String[0])));
            } else if (cmdr.getShip().SculptureOnBoard()) {
                setQuestStatusSculpture(SpecialEvent.StatusSculptureNotStarted);
                FormAlert.Alert(AlertType.EncounterPiratesTakeSculpture, owner);
            }
            ArrayList<Integer> cargoToSteal = cmdr.getShip().StealableCargo();
            if (cargoToSteal.size() == 0) {
                int blackmail = Math.min(25000, Math.max(500, cmdr.Worth() / 20));
                int cashPayment = Math.min(cmdr.getCash(), blackmail);
                cmdr.setDebt(cmdr.getDebt() + (blackmail - cashPayment));
                cmdr.setCash(cmdr.getCash() - cashPayment);
                FormAlert.Alert(AlertType.EncounterPiratesFindNoCargo, owner, Functions.Multiples(blackmail, Strings.MoneyUnit));
            } else {
                FormAlert.Alert(AlertType.EncounterLooting, owner);
                // Pirates steal as much as they have room for, which could be everything - JAF.
                // Take most high-priced items - JAF.
                while (getOpponent().FreeCargoBays() > 0 && cargoToSteal.size() > 0) {
                    int item = cargoToSteal.get(0);
                    cmdr.PriceCargo()[item] -= cmdr.PriceCargo()[item] / cmdr.getShip().Cargo()[item];
                    cmdr.getShip().Cargo()[item]--;
                    getOpponent().Cargo()[item]++;
                    cargoToSteal.remove(0);
                }
            }
            if (cmdr.getShip().WildOnBoard()) {
                if (getOpponent().getCrewQuarters() > 1) { // Wild hops onto Pirate Ship
                    setQuestStatusWild(SpecialEvent.StatusWildNotStarted);
                    FormAlert.Alert(AlertType.WildGoesPirates, owner);
                } else { // no room on pirate ship
                    FormAlert.Alert(AlertType.WildChatsPirates, owner);
                }
            }
            // pirates puzzled by reactor
            if (cmdr.getShip().ReactorOnBoard()) {
                FormAlert.Alert(AlertType.EncounterPiratesExamineReactor, owner);
            }
            result = EncounterResult.Normal;
        }
        return result;
    }

    public EncounterResult EncounterVerifyYield(WinformPane owner) {
        EncounterResult result = EncounterResult.Continue;
        if (cmdr.getShip().IllegalSpecialCargo()) {
            if (FormAlert.Alert(AlertType.EncounterPoliceSurrender, owner, new String[]{
                    cmdr.getShip().IllegalSpecialCargoDescription(Strings.EncounterPoliceSurrenderCargo, true, true),
                    cmdr.getShip().IllegalSpecialCargoActions()}) == DialogResult.Yes) {
                result = EncounterResult.Arrested;
            }
        } else {
            String str1 = cmdr.getShip().IllegalSpecialCargoDescription("", false, true);
            if (FormAlert.Alert(AlertType.EncounterPoliceSubmit, owner, str1, "") == DialogResult.Yes) {
                // Police Record becomes dubious, if it wasn't already.
                if (cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreDubious) {
                    cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreDubious);
                }
                cmdr.getShip().RemoveIllegalGoods();
                result = EncounterResult.Normal;
            }
        }
        return result;
    }

    public EncounterType getEncounterType() {
        return _encounterType;
    }

    public void setEncounterType(EncounterType encounterType) {
        _encounterType = encounterType;
    }

    public GameEndType getEndStatus() {
        return _endStatus;
    }

    public void setEndStatus(GameEndType endStatus) {
        _endStatus = endStatus;
    }

    public GameOptions Options() {
        return _options;
    }

    public int NewsLatestEvent() {
        return _newsEvents.get(_newsEvents.size() - 1);
    }

    public Ship Dragonfly() {
        return _dragonfly;
    }

    public Ship getOpponent() {
        return _opponent;
    }

    public void setOpponent(Ship opponent) {
        _opponent = opponent;
    }

    public Ship Scarab() {
        return _scarab;
    }

    public Ship Scorpion() {
        return _scorpion;
    }

    public Ship SpaceMonster() {
        return _spaceMonster;
    }

    public Main getParentWindow() {
        return _parentWin;
    }

    public void setParentWindow(Main parentWindow) {
        _parentWin = parentWindow;
    }

    public StarSystem SelectedSystem() {
        return (_selectedSystemId == StarSystemId.NA ? null : _universe[_selectedSystemId.CastToInt()]);
    }

    public StarSystem TrackedSystem() {
        return _trackedSystemId == StarSystemId.NA ? null : _universe[_trackedSystemId.CastToInt()];
    }

    public StarSystem WarpSystem() {
        return _warpSystemId == StarSystemId.NA ? null : _universe[_warpSystemId.CastToInt()];
    }

    public StarSystem[] Universe() {
        return _universe;
    }

    public StarSystemId getTrackedSystemId() {
        return _trackedSystemId;
    }

    public void setTrackedSystemId(StarSystemId trackedSystemId) {
        _trackedSystemId = trackedSystemId;
    }

    public StarSystemId SelectedSystemId() {
        return _selectedSystemId;
    }

    public StarSystemId WarpSystemId() {
        return _warpSystemId;
    }

    public String EncounterAction() {
        String action;
        if (getOpponentDisabled()) {
            action = Functions.StringVars("The ^1 has been disabled.", EncounterShipText());
        } else if (getEncounterOppFleeing()) {
            if (getEncounterType() == EncounterType.PirateSurrender || getEncounterType() == EncounterType.TraderSurrender) {
                action = Functions.StringVars("The ^1 hails that they wish to surrender to you.", EncounterShipText());
            } else {
                action = Functions.StringVars("The ^1 is fleeing.", EncounterShipText());
            }
        } else {
            action = Functions.StringVars(Strings.EncounterActionOppAttacks, EncounterShipText());
        }
        return action;
    }

    public String EncounterActionInitial() {
        String text = "";
        // Set up the fleeing variable initially.
        setEncounterOppFleeing(false);
        switch (getEncounterType()) {
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
                text = cmdr.getShip().Cloaked() ? Strings.EncounterTextOpponentNoNotice : Strings.EncounterTextOpponentIgnore;
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
                setEncounterOppFleeing(true);
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
        String shipText = getOpponent().Name();
        switch (getEncounterType()) {
            case FamousCaptainAttack:
            case FamousCaptDisabled:
                shipText = Strings.EncounterShipCaptain;
                break;
            case PirateAttack:
            case PirateDisabled:
            case PirateFlee:
            case PirateSurrender:
                shipText = getOpponent().Type() == ShipType.Mantis ? Strings.EncounterShipMantis : Strings.EncounterShipPirate;
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
        String cmdrStatus;
        if (getEncounterCmdrFleeing()) {
            cmdrStatus = Functions.StringVars("The ^1 is still following you.", EncounterShipText());
        } else if (getEncounterOppHit()) {
            cmdrStatus = Functions.StringVars("You hit the ^1.", EncounterShipText());
        } else {
            cmdrStatus = Functions.StringVars("You missed the ^1.", EncounterShipText());
        }
        String oppStatus;
        if (getEncounterOppFleeingPrev()) {
            oppStatus = Functions.StringVars("The ^1 didn't get away.", EncounterShipText());
        } else if (getEncounterCmdrHit()) {
            oppStatus = Functions.StringVars("The ^1 hits you.", EncounterShipText());
        } else {
            oppStatus = Functions.StringVars("The ^1 missed you.", EncounterShipText());
        }
        return cmdrStatus + Strings.newline + oppStatus;
    }

    public String EncounterTextInitial() {
        String encounterPretext = "";
        switch (getEncounterType()) {
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
                if (getOpponent().Type() == ShipType.Mantis) {
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
        return Functions.StringVars(Strings.EncounterText,
                new String[]{
                        Functions.Multiples(getClicks(), "click"), WarpSystem().Name(), encounterPretext, getOpponent().Name().toLowerCase()
                });
    }

    public String NewspaperHead() {
        String[] heads = Strings.NewsMastheads[cmdr.CurrentSystem().PoliticalSystemType().CastToInt()];
        String head = heads[cmdr.CurrentSystem().Id().CastToInt() % heads.length];
        return Functions.StringVars(head, cmdr.CurrentSystem().Name());
    }

    public String NewspaperText() {
        StarSystem curSys = cmdr.CurrentSystem();
        ArrayList<String> items = new ArrayList<>();
        // We're using the GetRandom2 function so that the same number is generated each time for the same "version" of the newspaper. -JAF
        Functions.RandSeed(curSys.Id().CastToInt(), cmdr.getDays());
        for (Iterator<?> en = _newsEvents.iterator(); en.hasNext(); ) {
            items.add(Functions.StringVars(Strings.NewsEvent[((NewsEvent) en.next()).CastToInt()], new String[]{
                    cmdr.Name(), cmdr.CurrentSystem().Name(), cmdr.getShip().Name()}));
        }
        if (curSys.SystemPressure() != SystemPressure.None) {
            items.add(Strings.NewsPressureInternal[curSys.SystemPressure().CastToInt()]);
        }
        if (cmdr.getPoliceRecordScore() <= Consts.PoliceRecordScoreVillain) {
            String baseStr = Strings.NewsPoliceRecordPsychopath[Functions.GetRandom2(Strings.NewsPoliceRecordPsychopath.length)];
            items.add(Functions.StringVars(baseStr, cmdr.Name(), curSys.Name()));
        } else if (cmdr.getPoliceRecordScore() >= Consts.PoliceRecordScoreHero) {
            String baseStr = Strings.NewsPoliceRecordHero[Functions.GetRandom2(Strings.NewsPoliceRecordHero.length)];
            items.add(Functions.StringVars(baseStr, cmdr.Name(), curSys.Name()));
        }
        // and now, finally, useful news (if any); base probability of a story showing up is (50 / MAXTECHLEVEL) * Current Tech Level
        // This is then modified by adding 10% for every level of play less than Impossible
        boolean realNews = false;
        int minProbability = Consts.StoryProbability * curSys.TechLevel().ordinal() + 10 * (5 - _difficulty.CastToInt());
        for (int i = 0; i < _universe.length; i++) {
            if (_universe[i].DestOk() && _universe[i] != curSys) {
                // Special stories that always get shown: moon, millionaire, shipyard
                if (_universe[i].SpecialEventType() != SpecialEventType.NA) {
                    if (_universe[i].SpecialEventType() == SpecialEventType.Moon) {
                        items.add(Functions.StringVars(Strings.NewsMoonForSale, _universe[i].Name()));
                    } else if (_universe[i].SpecialEventType() == SpecialEventType.TribbleBuyer) {
                        items.add(Functions.StringVars(Strings.NewsTribbleBuyer, _universe[i].Name()));
                    }
                }
                if (_universe[i].ShipyardId() != ShipyardId.NA) {
                    items.add(Functions.StringVars(Strings.NewsShipyard, _universe[i].Name()));
                }
                // And not-always-shown stories
                if (_universe[i].SystemPressure() != SystemPressure.None
                        && Functions.GetRandom2(100) <= Consts.StoryProbability * curSys.TechLevel().ordinal() + 10 * (5 - _difficulty.CastToInt())) {
                    int index = Functions.GetRandom2(Strings.NewsPressureExternal.length);
                    String baseStr = Strings.NewsPressureExternal[index];
                    String pressure = Strings.NewsPressureExternalPressures[_universe[i].SystemPressure().CastToInt()];
                    items.add(Functions.StringVars(baseStr, pressure, _universe[i].Name()));
                    realNews = true;
                }
            }
        }
        // if there's no useful news, we throw up at least one headline from our canned news list.
        if (!realNews) {
            String[] headlines = Strings.NewsHeadlines[curSys.PoliticalSystemType().CastToInt()];
            boolean[] shown = new boolean[headlines.length];
            int toShow = Functions.GetRandom2(headlines.length);
            for (int i = 0; i <= toShow; i++) {
                int index = Functions.GetRandom2(headlines.length);
                if (!shown[index]) {
                    items.add(headlines[index]);
                    shown[index] = true;
                }
            }
        }
        return Util.StringsJoin(Strings.newline + Strings.newline, Functions.ArrayListtoStringArray(items));
    }

    @SuppressWarnings("fallthrough")
    public boolean EncounterVerifyAttack(WinformPane owner) {
        boolean attack = true;
        if (cmdr.getShip().WeaponStrength() == 0) {
            FormAlert.Alert(AlertType.EncounterAttackNoWeapons, owner);
            attack = false;
        } else if (!getOpponent().Disableable() && cmdr.getShip().WeaponStrength(WeaponType.PulseLaser, WeaponType.MorgansLaser) == 0) {
            FormAlert.Alert(AlertType.EncounterAttackNoLasers, owner);
            attack = false;
        } else if (getOpponent().Type() == ShipType.Scorpion && cmdr.getShip().WeaponStrength(WeaponType.PhotonDisruptor, WeaponType.QuantumDistruptor) == 0) {
            FormAlert.Alert(AlertType.EncounterAttackNoDisruptors, owner);
            attack = false;
        } else {
            switch (getEncounterType()) {
                case DragonflyIgnore:
                case PirateIgnore:
                case ScarabIgnore:
                case ScorpionIgnore:
                case SpaceMonsterIgnore:
                    setEncounterType(EncounterType.FromInt(getEncounterType().CastToInt() - 1));
                    break;
                case PoliceInspect:
                    if (!cmdr.getShip().DetectableIllegalCargoOrPassengers() && FormAlert.Alert(AlertType.EncounterPoliceNothingIllegal, owner) != DialogResult.Yes) {
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
                    if (cmdr.getPoliceRecordScore() <= Consts.PoliceRecordScoreCriminal || FormAlert.Alert(AlertType.EncounterAttackPolice, owner) == DialogResult.Yes) {
                        if (cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreCriminal) {
                            cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreCriminal);
                        }
                        cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreAttackPolice);
                        if (getEncounterType() != EncounterType.PoliceFlee) {
                            setEncounterType(EncounterType.PoliceAttack);
                        }
                    } else {
                        attack = false;
                    }
                    break;
                case TraderBuy:
                case TraderIgnore:
                case TraderSell:
                    if (cmdr.getPoliceRecordScore() < Consts.PoliceRecordScoreClean) {
                        cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreAttackTrader);
                    } else if (FormAlert.Alert(AlertType.EncounterAttackTrader, owner) == DialogResult.Yes) {
                        cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreDubious);
                    } else {
                        attack = false;
                    }
                    // Fall through...
                    if (!attack) {
                        break;
                    }// else goto case TraderAttack;
                case TraderAttack:
                case TraderSurrender:
                    if (Functions.GetRandom(Consts.ReputationScoreElite) <= cmdr.getReputationScore() * 10 / (getOpponent().Type().CastToInt() + 1)
                            || getOpponent().WeaponStrength() == 0) {
                        setEncounterType(EncounterType.TraderFlee);
                    } else {
                        setEncounterType(EncounterType.TraderAttack);
                    }
                    break;
                case CaptainAhab:
                case CaptainConrad:
                case CaptainHuie:
                    if (FormAlert.Alert(AlertType.EncounterAttackCaptain, owner) == DialogResult.Yes) {
                        if (cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreVillain) {
                            cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreVillain);
                        }
                        cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreAttackTrader);
                        switch (getEncounterType()) {
                            case CaptainAhab:
                                NewsAddEvent(NewsEvent.CaptAhabAttacked);
                                break;
                            case CaptainConrad:
                                NewsAddEvent(NewsEvent.CaptConradAttacked);
                                break;
                            case CaptainHuie:
                                NewsAddEvent(NewsEvent.CaptHuieAttacked);
                                break;
                        }
                        setEncounterType(EncounterType.FamousCaptainAttack);
                    } else {
                        attack = false;
                    }
                    break;
            }
            // Make sure the fleeing flag isn't set if we're attacking.
            if (attack) {
                setEncounterCmdrFleeing(false);
            }
        }
        return attack;
    }

    public boolean EncounterVerifyBoard(WinformPane owner) {
        boolean board = false;
        if (FormAlert.Alert(AlertType.EncounterMarieCeleste, owner) == DialogResult.Yes) {
            board = true;
            int narcs = cmdr.getShip().Cargo()[TradeItemType.Narcotics.CastToInt()];
            (new FormPlunder()).ShowDialog(owner);
            if (cmdr.getShip().Cargo()[TradeItemType.Narcotics.CastToInt()] > narcs) {
                setJustLootedMarie(true);
            }
        }
        return board;
    }

    public boolean EncounterVerifyBribe(WinformPane owner) {
        boolean bribed = false;
        if (getEncounterType() == EncounterType.MarieCelestePolice) {
            FormAlert.Alert(AlertType.EncounterMarieCelesteNoBribe, owner);
        } else if (WarpSystem().PoliticalSystem().BribeLevel() <= 0) {
            FormAlert.Alert(AlertType.EncounterPoliceBribeCant, owner);
        } else if (cmdr.getShip().DetectableIllegalCargoOrPassengers() || FormAlert.Alert(AlertType.EncounterPoliceNothingIllegal, owner) == DialogResult.Yes) {
            // Bribe depends on how easy it is to bribe the police and commander's current worth
            int diffMod = 10 + 5 * (Difficulty.Impossible.CastToInt() - _difficulty.CastToInt());
            int passMod = cmdr.getShip().IllegalSpecialCargo() ? (_difficulty.CastToInt() <= Difficulty.Normal.CastToInt() ? 2 : 3) : 1;
            int bribe = Math.max(100, Math.min(10000, (int) Math.ceil((double) cmdr.Worth() / WarpSystem().PoliticalSystem().BribeLevel() / diffMod / 100) * 100 * passMod));
            if (FormAlert.Alert(AlertType.EncounterPoliceBribe, owner, Functions.Multiples(bribe, Strings.MoneyUnit)) == DialogResult.Yes) {
                if (cmdr.getCash() >= bribe) {
                    cmdr.setCash(cmdr.getCash() - bribe);
                    bribed = true;
                } else {
                    FormAlert.Alert(AlertType.EncounterPoliceBribeLowCash, owner);
                }
            }
        }
        return bribed;
    }

    public boolean EncounterVerifyFlee(WinformPane owner) {
        setEncounterCmdrFleeing(false);
        if (getEncounterType() != EncounterType.PoliceInspect || cmdr.getShip().DetectableIllegalCargoOrPassengers()
                || FormAlert.Alert(AlertType.EncounterPoliceNothingIllegal, owner) == DialogResult.Yes) {
            setEncounterCmdrFleeing(true);
            if (getEncounterType() == EncounterType.MarieCelestePolice && FormAlert.Alert(AlertType.EncounterPostMarieFlee, owner) == DialogResult.No) {
                setEncounterCmdrFleeing(false);
            } else if (getEncounterType() == EncounterType.PoliceInspect || getEncounterType() == EncounterType.MarieCelestePolice) {
                int scoreMod = getEncounterType() == EncounterType.PoliceInspect ? Consts.ScoreFleePolice : Consts.ScoreAttackPolice;
                int scoreMin = getEncounterType() == EncounterType.PoliceInspect
                        ? Consts.PoliceRecordScoreDubious - (_difficulty.CastToInt() < Difficulty.Normal.CastToInt() ? 0 : 1) : Consts.PoliceRecordScoreCriminal;
                setEncounterType(EncounterType.PoliceAttack);
                cmdr.setPoliceRecordScore(Math.min(cmdr.getPoliceRecordScore() + scoreMod, scoreMin));
            }
        }
        return getEncounterCmdrFleeing();
    }

    public boolean EncounterVerifySubmit(WinformPane owner) {
        boolean submit = false;
        if (cmdr.getShip().DetectableIllegalCargoOrPassengers()) {
            String str1 = cmdr.getShip().IllegalSpecialCargoDescription("", true, true);
            String str2 = cmdr.getShip().IllegalSpecialCargo() ? Strings.EncounterPoliceSubmitArrested : "";
            if (FormAlert.Alert(AlertType.EncounterPoliceSubmit, owner, str1, str2) == DialogResult.Yes) {
                submit = true;
                // If you carry illegal goods, they are impounded and you are fined
                if (cmdr.getShip().DetectableIllegalCargo()) {
                    cmdr.getShip().RemoveIllegalGoods();
                    int fine = (int) Math.max(100, Math.min(10000,
                            Math.ceil((double) cmdr.Worth() / ((Difficulty.Impossible.CastToInt() - _difficulty.CastToInt() + 2) * 10) / 50) * 50));
                    int cashPayment = Math.min(cmdr.getCash(), fine);
                    cmdr.setDebt(cmdr.getDebt() + (fine - cashPayment));
                    cmdr.setCash(cmdr.getCash() - cashPayment);
                    FormAlert.Alert(AlertType.EncounterPoliceFine, owner, Functions.Multiples(fine, Strings.MoneyUnit));
                    cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreTrafficking);
                }
            }
        } else {
            submit = true;
            // If you aren't carrying illegal cargo or passengers, the police will increase your lawfulness record
            FormAlert.Alert(AlertType.EncounterPoliceNothingFound, owner);
            cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() - Consts.ScoreTrafficking);
        }
        return submit;
    }

    public boolean getArrivedViaWormhole() {
        return _arrivedViaWormhole;
    }

    public void setArrivedViaWormhole(boolean arrivedViaWormhole) {
        _arrivedViaWormhole = arrivedViaWormhole;
    }

    public boolean getAutoSave() {
        return _autoSave;
    }

    public void setAutoSave(boolean autoSave) {
        _autoSave = autoSave;
    }

    public boolean getCanSuperWarp() {
        return _canSuperWarp;
    }

    public void setCanSuperWarp(boolean canSuperWarp) {
        _canSuperWarp = canSuperWarp;
    }

    public boolean getCheatEnabled() {
        return _cheatEnabled;
    }

    public void setCheatEnabled(boolean cheatEnabled) {
        _cheatEnabled = cheatEnabled;
    }

    public boolean getEasyEncounters() {
        return _easyEncounters;
    }

    public void setEasyEncounters(boolean easyEncounters) {
        _easyEncounters = easyEncounters;
    }

    public boolean getEncounterCmdrFleeing() {
        return _encounterCmdrFleeing;
    }

    public void setEncounterCmdrFleeing(boolean encounterCmdrFleeing) {
        _encounterCmdrFleeing = encounterCmdrFleeing;
    }

    public boolean getEncounterCmdrHit() {
        return _encounterCmdrHit;
    }

    public void setEncounterCmdrHit(boolean encounterCmdrHit) {
        _encounterCmdrHit = encounterCmdrHit;
    }

    public boolean getEncounterContinueAttacking() {
        return _encounterContinueAttacking;
    }

    public boolean setEncounterContinueAttacking(boolean encounterContinueAttacking) {
        _encounterContinueAttacking = encounterContinueAttacking;
        return encounterContinueAttacking;
    }

    public boolean getEncounterContinueFleeing() {
        return _encounterContinueFleeing;
    }

    public void setEncounterContinueFleeing(boolean encounterContinueFleeing) {
        _encounterContinueFleeing = encounterContinueFleeing;
    }

    public boolean getEncounterOppFleeing() {
        return _encounterOppFleeing;
    }

    public void setEncounterOppFleeing(boolean encounterOppFleeing) {
        _encounterOppFleeing = encounterOppFleeing;
    }

    public boolean getEncounterOppFleeingPrev() {
        return _encounterOppFleeingPrev;
    }

    public void setEncounterOppFleeingPrev(boolean encounterOppFleeingPrev) {
        _encounterOppFleeingPrev = encounterOppFleeingPrev;
    }

    public boolean getEncounterOppHit() {
        return _encounterOppHit;
    }

    public void setEncounterOppHit(boolean encounterOppHit) {
        _encounterOppHit = encounterOppHit;
    }

    public boolean getInspected() {
        return _inspected;
    }

    public void setInspected(boolean inspected) {
        _inspected = inspected;
    }

    public boolean getJustLootedMarie() {
        return _justLootedMarie;
    }

    public void setJustLootedMarie(boolean justLootedMarie) {
        _justLootedMarie = justLootedMarie;
    }

    public boolean getLitterWarning() {
        return _litterWarning;
    }

    public void setLitterWarning(boolean litterWarning) {
        _litterWarning = litterWarning;
    }

    public boolean getOpponentDisabled() {
        return _opponentDisabled;
    }

    public boolean setOpponentDisabled(boolean opponentDisabled) {
        _opponentDisabled = opponentDisabled;
        return opponentDisabled;
    }

    public boolean getPaidForNewspaper() {
        return _paidForNewspaper;
    }

    public void setPaidForNewspaper(boolean paidForNewspaper) {
        _paidForNewspaper = paidForNewspaper;
    }

    public boolean getRaided() {
        return _raided;
    }

    public void setRaided(boolean raided) {
        _raided = raided;
    }

    public boolean getTribbleMessage() {
        return _tribbleMessage;
    }

    public void setTribbleMessage(boolean b) {
        _tribbleMessage = b;
    }

    public boolean TargetWormhole() {
        return _targetWormhole;
    }

    public boolean Travel() {
        // Returns true if an encounter occurred.
        // if timespace is ripped, we may switch the warp system here.
        if (getQuestStatusExperiment() == SpecialEvent.StatusExperimentPerformed && getFabricRipProbability() > 0
                && (getFabricRipProbability() == Consts.FabricRipInitialProbability || Functions.GetRandom(100) < getFabricRipProbability())) {
            FormAlert.Alert(AlertType.SpecialTimespaceFabricRip, getParentWindow());
            SelectedSystemId(StarSystemId.FromInt(Functions.GetRandom(_universe.length)));
        }
        boolean uneventful = true;
        setRaided(false);
        setInspected(false);
        setLitterWarning(false);
        setClicks(Consts.StartClicks);
        while (getClicks() > 0) {
            cmdr.getShip().PerformRepairs();
            if (DetermineEncounter()) {
                uneventful = false;
                FormEncounter form = new FormEncounter();
                form.ShowDialog(getParentWindow());
                getParentWindow().UpdateStatusBar();
                switch (form.Result()) {
                    case Arrested:
                        setClicks(0);
                        Arrested();
                        break;
                    case EscapePod:
                        setClicks(0);
                        EscapeWithPod();
                        break;
                    case Killed:
                        throw new GameEndException(GameEndType.Killed);
                }
            }
            setClicks(getClicks() - 1);
        }
        return !uneventful;
    }

    public int CountDownStart() {
        return _difficulty.CastToInt() + 3;
    }

    public int CurrentCosts() {
        return InsuranceCosts() + InterestCosts() + MercenaryCosts() + WormholeCosts();
    }

    public int EncounterImageIndex() {
        int encounterImage = -1;
        switch (getEncounterType()) {
            case BottleGood:
            case BottleOld:
            case CaptainAhab:
            case CaptainConrad:
            case CaptainHuie:
            case MarieCeleste:
                encounterImage = Consts.EncounterImgSpecial;
                break;
            case DragonflyAttack:
            case DragonflyIgnore:
            case ScarabAttack:
            case ScarabIgnore:
            case ScorpionAttack:
            case ScorpionIgnore:
                encounterImage = Consts.EncounterImgPirate;
                break;
            case MarieCelestePolice:
            case PoliceAttack:
            case PoliceFlee:
            case PoliceIgnore:
            case PoliceInspect:
            case PoliceSurrender:
                encounterImage = Consts.EncounterImgPolice;
                break;
            case PirateAttack:
            case PirateFlee:
            case PirateIgnore:
                if (getOpponent().Type() == ShipType.Mantis) {
                    encounterImage = Consts.EncounterImgAlien;
                } else {
                    encounterImage = Consts.EncounterImgPirate;
                }
                break;
            case SpaceMonsterAttack:
            case SpaceMonsterIgnore:
                encounterImage = Consts.EncounterImgAlien;
                break;
            case TraderBuy:
            case TraderFlee:
            case TraderIgnore:
            case TraderSell:
                encounterImage = Consts.EncounterImgTrader;
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
        return _chanceOfTradeInOrbit;
    }

    public void setChanceOfTradeInOrbit(int chanceOfTradeInOrbit) {
        _chanceOfTradeInOrbit = chanceOfTradeInOrbit;
    }

    public int getChanceOfVeryRareEncounter() {
        return _chanceOfVeryRareEncounter;
    }

    public void setChanceOfVeryRareEncounter(int chanceOfVeryRareEncounter) {
        _chanceOfVeryRareEncounter = chanceOfVeryRareEncounter;
    }

    public int getClicks() {
        return _clicks;
    }

    public void setClicks(int clicks) {
        _clicks = clicks;
    }

    public int getFabricRipProbability() {
        return _fabricRipProbability;
    }

    public void setFabricRipProbability(int fabricRipProbability) {
        _fabricRipProbability = fabricRipProbability;
    }

    public int getQuestStatusArtifact() {
        return _questStatusArtifact;
    }

    public void setQuestStatusArtifact(int questStatusArtifact) {
        _questStatusArtifact = questStatusArtifact;
    }

    public int getQuestStatusDragonfly() {
        return _questStatusDragonfly;
    }

    public void setQuestStatusDragonfly(int questStatusDragonfly) {
        _questStatusDragonfly = questStatusDragonfly;
    }

    public int getQuestStatusExperiment() {
        return _questStatusExperiment;
    }

    public void setQuestStatusExperiment(int questStatusExperiment) {
        _questStatusExperiment = questStatusExperiment;
    }

    public int getQuestStatusGemulon() {
        return _questStatusGemulon;
    }

    public void setQuestStatusGemulon(int questStatusGemulon) {
        _questStatusGemulon = questStatusGemulon;
    }

    public int getQuestStatusJapori() {
        return _questStatusJapori;
    }

    public void setQuestStatusJapori(int questStatusJapori) {
        _questStatusJapori = questStatusJapori;
    }

    public int getQuestStatusJarek() {
        return _questStatusJarek;
    }

    public void setQuestStatusJarek(int questStatusJarek) {
        _questStatusJarek = questStatusJarek;
    }

    public int getQuestStatusMoon() {
        return _questStatusMoon;
    }

    public void setQuestStatusMoon(int questStatusMoon) {
        _questStatusMoon = questStatusMoon;
    }

    public int getQuestStatusPrincess() {
        return _questStatusPrincess;
    }

    public void setQuestStatusPrincess(int questStatusPrincess) {
        _questStatusPrincess = questStatusPrincess;
    }

    public int getQuestStatusReactor() {
        return _questStatusReactor;
    }

    public void setQuestStatusReactor(int questStatusReactor) {
        _questStatusReactor = questStatusReactor;
    }

    public int getQuestStatusScarab() {
        return _questStatusScarab;
    }

    public void setQuestStatusScarab(int questStatusScarab) {
        _questStatusScarab = questStatusScarab;
    }

    public int getQuestStatusSculpture() {
        return _questStatusSculpture;
    }

    public void setQuestStatusSculpture(int questStatusSculpture) {
        _questStatusSculpture = questStatusSculpture;
    }

    public int getQuestStatusSpaceMonster() {
        return _questStatusSpaceMonster;
    }

    public void setQuestStatusSpaceMonster(int questStatusSpaceMonster) {
        _questStatusSpaceMonster = questStatusSpaceMonster;
    }

    public int getQuestStatusWild() {
        return _questStatusWild;
    }

    public void setQuestStatusWild(int questStatusWild) {
        _questStatusWild = questStatusWild;
    }

    public int InsuranceCosts() {
        return cmdr.getInsurance() ? (int) Math.max(1, cmdr.getShip().BaseWorth(true) * Consts.InsRate * (100 - cmdr.NoClaim()) / 100) : 0;
    }

    public int InterestCosts() {
        return cmdr.getDebt() > 0 ? (int) Math.max(1, cmdr.getDebt() * Consts.IntRate) : 0;
    }

    public int MercenaryCosts() {
        int total = 0;
        for (int i = 1; i < cmdr.getShip().Crew().length && cmdr.getShip().Crew()[i] != null; i++) {
            total += cmdr.getShip().Crew()[i].Rate();
        }
        return total;
    }

    public int Score() {
        int worth = cmdr.Worth() < 1000000 ? cmdr.Worth() : 1000000 + ((cmdr.Worth() - 1000000) / 10);
        int daysMoon = 0;
        int modifier = 0;
        switch (getEndStatus()) {
            case Killed:
                modifier = 90;
                break;
            case Retired:
                modifier = 95;
                break;
            case BoughtMoon:
                daysMoon = Math.max(0, (_difficulty.CastToInt() + 1) * 100 - cmdr.getDays());
                modifier = 100;
                break;
        }
        return (_difficulty.CastToInt() + 1) * modifier * (daysMoon * 1000 + worth) / 250000;
    }

    public int WormholeCosts() {
        return Functions.WormholeExists(cmdr.CurrentSystem(), WarpSystem()) ? Consts.WormDist * cmdr.getShip().getFuelCost() : 0;
    }

    public int[] Destinations() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < _universe.length; i++) {
            if (_universe[i].DestOk()) {
                list.add(i);
            }
        }
        int[] ids = new int[list.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = list.get(i);
        }
        return ids;
    }

    public int[] PriceCargoBuy() {
        return _priceCargoBuy;
    }

    public int[] PriceCargoSell() {
        return _priceCargoSell;
    }

    public int[] Wormholes() {
        return _wormholes;
    }

    public void Arrested() {
        int term = Math.max(30, -cmdr.getPoliceRecordScore());
        int fine = (1 + cmdr.Worth() * Math.min(80, -cmdr.getPoliceRecordScore()) / 50000) * 500;
        if (cmdr.getShip().WildOnBoard()) {
            fine = (int) (fine * 1.05);
        }
        FormAlert.Alert(AlertType.EncounterArrested, getParentWindow());
        FormAlert.Alert(AlertType.JailConvicted, getParentWindow(), Functions.Multiples(term, Strings.TimeUnit), Functions.Multiples(fine, Strings.MoneyUnit));
        if (cmdr.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
            while (cmdr.getShip().HasGadget(GadgetType.HiddenCargoBays)) {
                cmdr.getShip().RemoveEquipment(EquipmentType.Gadget, GadgetType.HiddenCargoBays);
            }
            FormAlert.Alert(AlertType.JailHiddenCargoBaysRemoved, getParentWindow());
        }
        if (cmdr.getShip().ReactorOnBoard()) {
            FormAlert.Alert(AlertType.ReactorConfiscated, getParentWindow());
            setQuestStatusReactor(SpecialEvent.StatusReactorNotStarted);
        }
        if (cmdr.getShip().SculptureOnBoard()) {
            FormAlert.Alert(AlertType.SculptureConfiscated, getParentWindow());
            setQuestStatusSculpture(SpecialEvent.StatusSculptureNotStarted);
        }
        if (cmdr.getShip().WildOnBoard()) {
            FormAlert.Alert(AlertType.WildArrested, getParentWindow());
            NewsAddEvent(NewsEvent.WildArrested);
            setQuestStatusWild(SpecialEvent.StatusWildNotStarted);
        }
        if (cmdr.getShip().AnyIllegalCargo()) {
            FormAlert.Alert(AlertType.JailIllegalGoodsImpounded, getParentWindow());
            cmdr.getShip().RemoveIllegalGoods();
        }
        if (cmdr.getInsurance()) {
            FormAlert.Alert(AlertType.JailInsuranceLost, getParentWindow());
            cmdr.setInsurance(false);
            cmdr.NoClaim(0);
        }
        if (cmdr.getShip().CrewCount() - cmdr.getShip().SpecialCrew().length > 1) {
            FormAlert.Alert(AlertType.JailMercenariesLeave, getParentWindow());
            for (int i = 1; i < cmdr.getShip().Crew().length; i++) {
                cmdr.getShip().Crew()[i] = null;
            }
        }
        if (cmdr.getShip().JarekOnBoard()) {
            FormAlert.Alert(AlertType.JarekTakenHome, getParentWindow());
            setQuestStatusJarek(SpecialEvent.StatusJarekNotStarted);
        }
        if (cmdr.getShip().PrincessOnBoard()) {
            FormAlert.Alert(AlertType.PrincessTakenHome, getParentWindow());
            setQuestStatusPrincess(SpecialEvent.StatusPrincessNotStarted);
        }
        if (getQuestStatusJapori() == SpecialEvent.StatusJaporiInTransit) {
            FormAlert.Alert(AlertType.AntidoteTaken, getParentWindow());
            setQuestStatusJapori(SpecialEvent.StatusJaporiDone);
        }
        if (cmdr.getCash() >= fine) {
            cmdr.setCash(cmdr.getCash() - fine);
        } else {
            cmdr.setCash(Math.max(0, cmdr.getCash() + cmdr.getShip().Worth(true) - fine));
            FormAlert.Alert(AlertType.JailShipSold, getParentWindow());
            if (cmdr.getShip().getTribbles() > 0) {
                FormAlert.Alert(AlertType.TribblesRemoved, getParentWindow());
            }
            FormAlert.Alert(AlertType.FleaBuilt, getParentWindow());
            CreateFlea();
        }
        if (cmdr.getDebt() > 0) {
            int paydown = Math.min(cmdr.getCash(), cmdr.getDebt());
            cmdr.setDebt(cmdr.getDebt() - paydown);
            cmdr.setCash(cmdr.getCash() - paydown);
            if (cmdr.getDebt() > 0) {
                for (int i = 0; i < term; i++) {
                    cmdr.PayInterest();
                }
            }
        }
        cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreDubious);
        IncDays(term, getParentWindow());
    }

    public void CargoBuySystem(int tradeItem, boolean max, WinformPane owner) {
        CargoBuy(tradeItem, max, owner, CargoBuyOp.BuySystem);
    }

    public void CargoBuyTrader(int tradeItem, WinformPane owner) {
        CargoBuy(tradeItem, false, owner, CargoBuyOp.BuyTrader);
    }

    public void CargoDump(int tradeItem, WinformPane owner) {
        CargoSell(tradeItem, false, owner, CargoSellOp.Dump);
    }

    public void CargoJettison(int tradeItem, boolean all, WinformPane owner) {
        CargoSell(tradeItem, all, owner, CargoSellOp.Jettison);
    }

    public void CargoPlunder(int tradeItem, boolean max, WinformPane owner) {
        CargoBuy(tradeItem, max, owner, CargoBuyOp.InPlunder);
    }

    public void CargoSellSystem(int tradeItem, boolean all, WinformPane owner) {
        CargoSell(tradeItem, all, owner, CargoSellOp.SellSystem);
    }

    public void CargoSellTrader(int tradeItem, WinformPane owner) {
        CargoSell(tradeItem, false, owner, CargoSellOp.SellTrader);
    }

    public void CreateFlea() {
        cmdr.setShip(new Ship(ShipType.Flea));
        cmdr.getShip().Crew()[0] = Commander();
        cmdr.setInsurance(false);
        cmdr.NoClaim(0);
    }

    public void EncounterBegin() {
        // Set up the encounter variables.
        setEncounterContinueFleeing(setEncounterContinueAttacking(setOpponentDisabled(false)));
    }

    public void EncounterDrink(WinformPane owner) {
        if (FormAlert.Alert(AlertType.EncounterDrinkContents, owner) == DialogResult.Yes) {
            if (getEncounterType() == EncounterType.BottleGood) {
                // two points if you're on beginner-normal, one otherwise
                cmdr.IncreaseRandomSkill();
                if (_difficulty.CastToInt() <= Difficulty.Normal.CastToInt()) {
                    cmdr.IncreaseRandomSkill();
                }
                FormAlert.Alert(AlertType.EncounterTonicConsumedGood, owner);
            } else {
                cmdr.TonicTweakRandomSkill();
                FormAlert.Alert(AlertType.EncounterTonicConsumedStrange, owner);
            }
        }
    }

    public void EncounterMeet(WinformPane owner) {
        AlertType initialAlert = AlertType.Alert;
        int skill = 0;
        EquipmentType equipType = EquipmentType.Gadget;
        Object equipSubType = null;

        switch (getEncounterType()) {
            case CaptainAhab:
                // Trade a reflective shield for skill points in piloting?
                initialAlert = AlertType.MeetCaptainAhab;
                equipType = EquipmentType.Shield;
                equipSubType = ShieldType.Reflective;
                skill = SkillType.Pilot.CastToInt();
                break;
            case CaptainConrad:
                // Trade a military laser for skill points in engineering?
                initialAlert = AlertType.MeetCaptainConrad;
                equipType = EquipmentType.Weapon;
                equipSubType = WeaponType.MilitaryLaser;
                skill = SkillType.Engineer.CastToInt();
                break;
            case CaptainHuie:
                // Trade a military laser for skill points in trading?
                initialAlert = AlertType.MeetCaptainHuie;
                equipType = EquipmentType.Weapon;
                equipSubType = WeaponType.MilitaryLaser;
                skill = SkillType.Trader.CastToInt();
                break;
        }
        if (FormAlert.Alert(initialAlert, owner) == DialogResult.Yes) {
            // Remove the equipment we're trading.
            cmdr.getShip().RemoveEquipment(equipType, equipSubType);
            // Add points to the appropriate skill - two points if beginner-normal, one otherwise.
            cmdr.Skills()[skill] = Math.min(Consts.MaxSkill, cmdr.Skills()[skill] + (_difficulty.CastToInt() <= Difficulty.Normal.CastToInt() ? 2 : 1));
            FormAlert.Alert(AlertType.SpecialTrainingCompleted, owner);
        }
    }

    public void EncounterPlunder(WinformPane owner) {
        (new FormPlunder()).ShowDialog(owner);
        if (getEncounterType().CastToInt() >= EncounterType.TraderAttack.CastToInt()) {
            cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScorePlunderTrader);
            if (getOpponentDisabled()) {
                cmdr.setKillsTrader(cmdr.getKillsTrader() + 1);
            }
        } else if (getOpponentDisabled()) {
            if (cmdr.getPoliceRecordScore() >= Consts.PoliceRecordScoreDubious) {
                FormAlert.Alert(AlertType.EncounterPiratesBounty, owner, Strings.EncounterPiratesDisabled,
                        Strings.EncounterPiratesLocation, Functions.Multiples(getOpponent().Bounty(), Strings.MoneyUnit));
                cmdr.setCash(cmdr.getCash() + getOpponent().Bounty());
            }
            cmdr.setKillsPirate(cmdr.getKillsPirate() + 1);
            cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreKillPirate);
        } else {
            cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScorePlunderPirate);
        }
        cmdr.setReputationScore(cmdr.getReputationScore() + (getOpponent().Type().CastToInt() / 2 + 1));
    }

    public void EncounterTrade(WinformPane owner) {
        boolean buy = (getEncounterType() == EncounterType.TraderBuy);
        int item = (buy ? cmdr.getShip() : getOpponent()).GetRandomTradeableItem();
        String alertStr = buy ? "selling" : "buying";
        int cash = cmdr.getCash();
        if (getEncounterType() == EncounterType.TraderBuy) {
            CargoSellTrader(item, owner);
        } else { // EncounterType.TraderSell
            CargoBuyTrader(item, owner);
        }
        if (cmdr.getCash() != cash) {
            FormAlert.Alert(AlertType.EncounterTradeCompleted, owner, alertStr, Consts.TradeItems[item].Name());
        }
    }

    public void EscapeWithPod() {
        FormAlert.Alert(AlertType.EncounterEscapePodActivated, getParentWindow());
        if (cmdr.getShip().SculptureOnBoard()) {
            FormAlert.Alert(AlertType.SculptureSaved, getParentWindow());
        }
        if (cmdr.getShip().ReactorOnBoard()) {
            FormAlert.Alert(AlertType.ReactorDestroyed, getParentWindow());
            setQuestStatusReactor(SpecialEvent.StatusReactorDone);
        }
        if (cmdr.getShip().getTribbles() > 0) {
            FormAlert.Alert(AlertType.TribblesKilled, getParentWindow());
        }
        if (getQuestStatusJapori() == SpecialEvent.StatusJaporiInTransit) {
            int system;
            for (system = 0; system < _universe.length && _universe[system].SpecialEventType() != SpecialEventType.Japori; system++) {
            }
            FormAlert.Alert(AlertType.AntidoteDestroyed, getParentWindow(), _universe[system].Name());
            setQuestStatusJapori(SpecialEvent.StatusJaporiNotStarted);
        }
        if (cmdr.getShip().ArtifactOnBoard()) {
            FormAlert.Alert(AlertType.ArtifactLost, getParentWindow());
            setQuestStatusArtifact(SpecialEvent.StatusArtifactDone);
        }
        if (cmdr.getShip().JarekOnBoard()) {
            FormAlert.Alert(AlertType.JarekTakenHome, getParentWindow());
            setQuestStatusJarek(SpecialEvent.StatusJarekNotStarted);
        }
        if (cmdr.getShip().PrincessOnBoard()) {
            FormAlert.Alert(AlertType.PrincessTakenHome, getParentWindow());
            setQuestStatusPrincess(SpecialEvent.StatusPrincessNotStarted);
        }
        if (cmdr.getShip().WildOnBoard()) {
            FormAlert.Alert(AlertType.WildArrested, getParentWindow());
            cmdr.setPoliceRecordScore(cmdr.getPoliceRecordScore() + Consts.ScoreCaughtWithWild);
            NewsAddEvent(NewsEvent.WildArrested);
            setQuestStatusWild(SpecialEvent.StatusWildNotStarted);
        }
        if (cmdr.getInsurance()) {
            FormAlert.Alert(AlertType.InsurancePayoff, getParentWindow());
            cmdr.setCash(cmdr.getCash() + cmdr.getShip().BaseWorth(true));
        }
        if (cmdr.getCash() > Consts.FleaConversionCost) {
            cmdr.setCash(cmdr.getCash() - Consts.FleaConversionCost);
        } else {
            cmdr.setDebt(cmdr.getDebt() + (Consts.FleaConversionCost - cmdr.getCash()));
            cmdr.setCash(0);
        }
        FormAlert.Alert(AlertType.FleaBuilt, getParentWindow());
        IncDays(3, getParentWindow());
        CreateFlea();
    }

    public void HandleSpecialEvent() {
        StarSystem curSys = cmdr.CurrentSystem();
        Ship ship = cmdr.getShip();
        boolean remove = true;
        switch (curSys.SpecialEventType()) {
            case Artifact:
                setQuestStatusArtifact(SpecialEvent.StatusArtifactOnBoard);
                break;
            case ArtifactDelivery:
                setQuestStatusArtifact(SpecialEvent.StatusArtifactDone);
                break;
            case CargoForSale:
                FormAlert.Alert(AlertType.SpecialSealedCanisters, getParentWindow());
                int tradeItem = Functions.GetRandom(Consts.TradeItems.length);
                ship.Cargo()[tradeItem] += 3;
                cmdr.PriceCargo()[tradeItem] += cmdr.CurrentSystem().SpecialEvent().Price();
                break;
            case Dragonfly:
            case DragonflyBaratas:
            case DragonflyMelina:
            case DragonflyRegulas:
                setQuestStatusDragonfly(getQuestStatusDragonfly() + 1);
                break;
            case DragonflyDestroyed:
                curSys.SpecialEventType(SpecialEventType.DragonflyShield);
                remove = false;
                break;
            case DragonflyShield:
                if (ship.FreeSlotsShield() == 0) {
                    FormAlert.Alert(AlertType.EquipmentNotEnoughSlots, getParentWindow());
                    remove = false;
                } else {
                    FormAlert.Alert(AlertType.EquipmentLightningShield, getParentWindow());
                    ship.AddEquipment(Consts.Shields[ShieldType.Lightning.id]);
                    setQuestStatusDragonfly(SpecialEvent.StatusDragonflyDone);
                }
                break;
            case EraseRecord:
                FormAlert.Alert(AlertType.SpecialCleanRecord, getParentWindow());
                cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreClean);
                RecalculateSellPrices(curSys);
                break;
            case Experiment:
                setQuestStatusExperiment(SpecialEvent.StatusExperimentStarted);
                break;
            case ExperimentFailed:
                break;
            case ExperimentStopped:
                setQuestStatusExperiment(SpecialEvent.StatusExperimentCancelled);
                setCanSuperWarp(true);
                break;
            case Gemulon:
                setQuestStatusGemulon(SpecialEvent.StatusGemulonStarted);
                break;
            case GemulonFuel:
                if (ship.FreeSlotsGadget() == 0) {
                    FormAlert.Alert(AlertType.EquipmentNotEnoughSlots, getParentWindow());
                    remove = false;
                } else {
                    FormAlert.Alert(AlertType.EquipmentFuelCompactor, getParentWindow());
                    ship.AddEquipment(Consts.Gadgets[GadgetType.FuelCompactor.asInteger()]);
                    setQuestStatusGemulon(SpecialEvent.StatusGemulonDone);
                }
                break;
            case GemulonRescued:
                curSys.SpecialEventType(SpecialEventType.GemulonFuel);
                setQuestStatusGemulon(SpecialEvent.StatusGemulonFuel);
                remove = false;
                break;
            case Japori:
                // The japori quest should not be removed since you can fail and start it over again.
                remove = false;
                if (ship.FreeCargoBays() < 10) {
                    FormAlert.Alert(AlertType.CargoNoEmptyBays, getParentWindow());
                } else {
                    FormAlert.Alert(AlertType.AntidoteOnBoard, getParentWindow());
                    setQuestStatusJapori(SpecialEvent.StatusJaporiInTransit);
                }
                break;
            case JaporiDelivery:
                setQuestStatusJapori(SpecialEvent.StatusJaporiDone);
                cmdr.IncreaseRandomSkill();
                cmdr.IncreaseRandomSkill();
                break;
            case Jarek:
                if (ship.FreeCrewQuarters() == 0) {
                    FormAlert.Alert(AlertType.SpecialNoQuarters, getParentWindow());
                    remove = false;
                } else {
                    CrewMember jarek = Mercenaries()[CrewMemberId.Jarek.CastToInt()];
                    FormAlert.Alert(AlertType.SpecialPassengerOnBoard, getParentWindow(), jarek.Name());
                    ship.Hire(jarek);
                    setQuestStatusJarek(SpecialEvent.StatusJarekStarted);
                }
                break;
            case JarekGetsOut:
                setQuestStatusJarek(SpecialEvent.StatusJarekDone);
                ship.Fire(CrewMemberId.Jarek);
                break;
            case Lottery:
                break;
            case Moon:
                FormAlert.Alert(AlertType.SpecialMoonBought, getParentWindow());
                setQuestStatusMoon(SpecialEvent.StatusMoonBought);
                break;
            case MoonRetirement:
                setQuestStatusMoon(SpecialEvent.StatusMoonDone);
                throw new GameEndException(GameEndType.BoughtMoon);
            case Princess:
                curSys.SpecialEventType(SpecialEventType.PrincessReturned);
                remove = false;
                setQuestStatusPrincess(getQuestStatusPrincess() + 1);
                break;
            case PrincessCentauri:
            case PrincessInthara:
                setQuestStatusPrincess(getQuestStatusPrincess() + 1);
                break;
            case PrincessQonos:
                if (ship.FreeCrewQuarters() == 0) {
                    FormAlert.Alert(AlertType.SpecialNoQuarters, getParentWindow());
                    remove = false;
                } else {
                    CrewMember princess = Mercenaries()[CrewMemberId.Princess.CastToInt()];
                    FormAlert.Alert(AlertType.SpecialPassengerOnBoard, getParentWindow(), princess.Name());
                    ship.Hire(princess);
                }
                break;
            case PrincessQuantum:
                if (ship.FreeSlotsWeapon() == 0) {
                    FormAlert.Alert(AlertType.EquipmentNotEnoughSlots, getParentWindow());
                    remove = false;
                } else {
                    FormAlert.Alert(AlertType.EquipmentQuantumDisruptor, getParentWindow());
                    ship.AddEquipment(Consts.WeapObjs[WeaponType.QuantumDistruptor.id]);
                    setQuestStatusPrincess(SpecialEvent.StatusPrincessDone);
                }
                break;
            case PrincessReturned:
                ship.Fire(CrewMemberId.Princess);
                curSys.SpecialEventType(SpecialEventType.PrincessQuantum);
                setQuestStatusPrincess(SpecialEvent.StatusPrincessReturned);
                remove = false;
                break;
            case Reactor:
                if (ship.FreeCargoBays() < 15) {
                    FormAlert.Alert(AlertType.CargoNoEmptyBays, getParentWindow());
                    remove = false;
                } else {
                    if (ship.WildOnBoard()) {
                        if (FormAlert.Alert(AlertType.WildWontStayAboardReactor, getParentWindow(), curSys.Name()) == DialogResult.OK) {
                            FormAlert.Alert(AlertType.WildLeavesShip, getParentWindow(), curSys.Name());
                            setQuestStatusWild(SpecialEvent.StatusWildNotStarted);
                        } else {
                            remove = false;
                        }
                    }
                    if (remove) {
                        FormAlert.Alert(AlertType.ReactorOnBoard, getParentWindow());
                        setQuestStatusReactor(SpecialEvent.StatusReactorFuelOk);
                    }
                }
                break;
            case ReactorDelivered:
                curSys.SpecialEventType(SpecialEventType.ReactorLaser);
                setQuestStatusReactor(SpecialEvent.StatusReactorDelivered);
                remove = false;
                break;
            case ReactorLaser:
                if (ship.FreeSlotsWeapon() == 0) {
                    FormAlert.Alert(AlertType.EquipmentNotEnoughSlots, getParentWindow());
                    remove = false;
                } else {
                    FormAlert.Alert(AlertType.EquipmentMorgansLaser, getParentWindow());
                    ship.AddEquipment(Consts.WeapObjs[WeaponType.MorgansLaser.id]);
                    setQuestStatusReactor(SpecialEvent.StatusReactorDone);
                }
                break;
            case Scarab:
                setQuestStatusScarab(SpecialEvent.StatusScarabHunting);
                break;
            case ScarabDestroyed:
                setQuestStatusScarab(SpecialEvent.StatusScarabDestroyed);
                curSys.SpecialEventType(SpecialEventType.ScarabUpgradeHull);
                remove = false;
                break;
            case ScarabUpgradeHull:
                FormAlert.Alert(AlertType.ShipHullUpgraded, getParentWindow());
                ship.setHullUpgraded(true);
                ship.setHull(ship.getHull() + Consts.HullUpgrade);
                setQuestStatusScarab(SpecialEvent.StatusScarabDone);
                remove = false;
                break;
            case Sculpture:
                setQuestStatusSculpture(SpecialEvent.StatusSculptureInTransit);
                break;
            case SculptureDelivered:
                setQuestStatusSculpture(SpecialEvent.StatusSculptureDelivered);
                curSys.SpecialEventType(SpecialEventType.SculptureHiddenBays);
                remove = false;
                break;
            case SculptureHiddenBays:
                setQuestStatusSculpture(SpecialEvent.StatusSculptureDone);
                if (ship.FreeSlotsGadget() == 0) {
                    FormAlert.Alert(AlertType.EquipmentNotEnoughSlots, getParentWindow());
                    remove = false;
                } else {
                    FormAlert.Alert(AlertType.EquipmentHiddenCompartments, getParentWindow());
                    ship.AddEquipment(Consts.Gadgets[GadgetType.HiddenCargoBays.asInteger()]);
                    setQuestStatusSculpture(SpecialEvent.StatusSculptureDone);
                }
                break;
            case Skill:
                FormAlert.Alert(AlertType.SpecialSkillIncrease, getParentWindow());
                cmdr.IncreaseRandomSkill();
                break;
            case SpaceMonster:
                setQuestStatusSpaceMonster(SpecialEvent.StatusSpaceMonsterAtAcamar);
                break;
            case SpaceMonsterKilled:
                setQuestStatusSpaceMonster(SpecialEvent.StatusSpaceMonsterDone);
                break;
            case Tribble:
                FormAlert.Alert(AlertType.TribblesOwn, getParentWindow());
                ship.setTribbles(1);
                break;
            case TribbleBuyer:
                FormAlert.Alert(AlertType.TribblesGone, getParentWindow());
                cmdr.setCash(cmdr.getCash() + (ship.getTribbles() / 2));
                ship.setTribbles(0);
                break;
            case Wild:
                if (ship.FreeCrewQuarters() == 0) {
                    FormAlert.Alert(AlertType.SpecialNoQuarters, getParentWindow());
                    remove = false;
                } else if (!ship.HasWeapon(WeaponType.BeamLaser, false)) {
                    FormAlert.Alert(AlertType.WildWontBoardLaser, getParentWindow());
                    remove = false;
                } else if (ship.ReactorOnBoard()) {
                    FormAlert.Alert(AlertType.WildWontBoardReactor, getParentWindow());
                    remove = false;
                } else {
                    CrewMember wild = Mercenaries()[CrewMemberId.Wild.CastToInt()];
                    FormAlert.Alert(AlertType.SpecialPassengerOnBoard, getParentWindow(), wild.Name());
                    ship.Hire(wild);
                    setQuestStatusWild(SpecialEvent.StatusWildStarted);
                    if (ship.SculptureOnBoard()) {
                        FormAlert.Alert(AlertType.WildSculpture, getParentWindow());
                    }
                }
                break;
            case WildGetsOut:
                // Zeethibal has a 10 in player's lowest score, an 8 in the next lowest score, and 5 elsewhere.
                CrewMember zeethibal = Mercenaries()[CrewMemberId.Zeethibal.CastToInt()];
                zeethibal.CurrentSystem(_universe[StarSystemId.Kravat.CastToInt()]);
                int lowest1 = cmdr.NthLowestSkill(1);
                int lowest2 = cmdr.NthLowestSkill(2);
                for (int i = 0; i < zeethibal.Skills().length; i++) {
                    zeethibal.Skills()[i] = (i == lowest1 ? 10 : (i == lowest2 ? 8 : 5));
                }
                setQuestStatusWild(SpecialEvent.StatusWildDone);
                cmdr.setPoliceRecordScore(Consts.PoliceRecordScoreClean);
                ship.Fire(CrewMemberId.Wild);
                RecalculateSellPrices(curSys);
                break;
        }
        if (curSys.SpecialEvent().Price() != 0) {
            cmdr.setCash(cmdr.getCash() - curSys.SpecialEvent().Price());
        }
        if (remove) {
            curSys.SpecialEventType(SpecialEventType.NA);
        }
    }

    public void IncDays(int num, WinformPane owner) {
        cmdr.setDays(cmdr.getDays() + num);
        if (cmdr.getInsurance()) {
            cmdr.NoClaim(cmdr.NoClaim() + num);
        }
        // Police Record will gravitate towards neutral (0).
        if (cmdr.getPoliceRecordScore() > Consts.PoliceRecordScoreClean) {
            cmdr.setPoliceRecordScore(Math.max(Consts.PoliceRecordScoreClean, cmdr.getPoliceRecordScore() - num / 3));
        } else if (cmdr.getPoliceRecordScore() < Consts.PoliceRecordScoreDubious) {
            cmdr.setPoliceRecordScore(Math.min(Consts.PoliceRecordScoreDubious, cmdr.getPoliceRecordScore()
                    + num / (_difficulty.CastToInt() <= Difficulty.Normal.CastToInt() ? 1 : _difficulty.CastToInt())));
        }
        // The Space Monster's strength increases 5% per day until it is back to full strength.
        if (_spaceMonster.getHull() < _spaceMonster.HullStrength()) {
            _spaceMonster.setHull(Math.min(_spaceMonster.HullStrength(), (int) (_spaceMonster.getHull() * Math.pow(1.05, num))));
        }
        if (getQuestStatusGemulon() > SpecialEvent.StatusGemulonNotStarted && getQuestStatusGemulon() < SpecialEvent.StatusGemulonTooLate) {
            setQuestStatusGemulon(Math.min(getQuestStatusGemulon() + num, SpecialEvent.StatusGemulonTooLate));
            if (getQuestStatusGemulon() == SpecialEvent.StatusGemulonTooLate) {
                StarSystem gemulon = _universe[StarSystemId.Gemulon.CastToInt()];
                gemulon.SpecialEventType(SpecialEventType.GemulonInvaded);
                gemulon.TechLevel(TechLevel.t0);
                gemulon.PoliticalSystemType(PoliticalSystemType.Anarchy);
            }
        }
        if (cmdr.getShip().ReactorOnBoard()) {
            setQuestStatusReactor(Math.min(getQuestStatusReactor() + num, SpecialEvent.StatusReactorDate));
        }
        if (getQuestStatusExperiment() > SpecialEvent.StatusExperimentNotStarted
                && getQuestStatusExperiment() < SpecialEvent.StatusExperimentPerformed) {
            setQuestStatusExperiment(Math.min(getQuestStatusExperiment() + num, SpecialEvent.StatusExperimentPerformed));
            if (getQuestStatusExperiment() == SpecialEvent.StatusExperimentPerformed) {
                setFabricRipProbability(Consts.FabricRipInitialProbability);
                _universe[StarSystemId.Daled.CastToInt()].SpecialEventType(SpecialEventType.ExperimentFailed);
                FormAlert.Alert(AlertType.SpecialExperimentPerformed, owner);
                NewsAddEvent(NewsEvent.ExperimentPerformed);
            }
        } else if (getQuestStatusExperiment() == SpecialEvent.StatusExperimentPerformed && getFabricRipProbability() > 0) {
            setFabricRipProbability(getFabricRipProbability() - num);
        }
        if (cmdr.getShip().JarekOnBoard()) {
            if (getQuestStatusJarek() == SpecialEvent.StatusJarekImpatient / 2) {
                FormAlert.Alert(AlertType.SpecialPassengerConcernedJarek, owner);
            } else if (getQuestStatusJarek() == SpecialEvent.StatusJarekImpatient - 1) {
                FormAlert.Alert(AlertType.SpecialPassengerImpatientJarek, owner);
                Mercenaries()[CrewMemberId.Jarek.CastToInt()].Pilot(0);
                Mercenaries()[CrewMemberId.Jarek.CastToInt()].Fighter(0);
                Mercenaries()[CrewMemberId.Jarek.CastToInt()].Trader(0);
                Mercenaries()[CrewMemberId.Jarek.CastToInt()].Engineer(0);
            }
            if (getQuestStatusJarek() < SpecialEvent.StatusJarekImpatient) {
                setQuestStatusJarek(getQuestStatusJarek() + 1);
            }
        }
        if (cmdr.getShip().PrincessOnBoard()) {
            if (getQuestStatusPrincess() == (SpecialEvent.StatusPrincessImpatient + SpecialEvent.StatusPrincessRescued) / 2) {
                FormAlert.Alert(AlertType.SpecialPassengerConcernedPrincess, owner);
            } else if (getQuestStatusPrincess() == SpecialEvent.StatusPrincessImpatient - 1) {
                FormAlert.Alert(AlertType.SpecialPassengerImpatientPrincess, owner);
                Mercenaries()[CrewMemberId.Princess.CastToInt()].Pilot(0);
                Mercenaries()[CrewMemberId.Princess.CastToInt()].Fighter(0);
                Mercenaries()[CrewMemberId.Princess.CastToInt()].Trader(0);
                Mercenaries()[CrewMemberId.Princess.CastToInt()].Engineer(0);
            }
            if (getQuestStatusPrincess() < SpecialEvent.StatusPrincessImpatient) {
                setQuestStatusPrincess(getQuestStatusPrincess() + 1);
            }
        }
        if (cmdr.getShip().WildOnBoard()) {
            if (getQuestStatusWild() == SpecialEvent.StatusWildImpatient / 2) {
                FormAlert.Alert(AlertType.SpecialPassengerConcernedWild, owner);
            } else if (getQuestStatusWild() == SpecialEvent.StatusWildImpatient - 1) {
                FormAlert.Alert(AlertType.SpecialPassengerImpatientWild, owner);
                Mercenaries()[CrewMemberId.Wild.CastToInt()].Pilot(0);
                Mercenaries()[CrewMemberId.Wild.CastToInt()].Fighter(0);
                Mercenaries()[CrewMemberId.Wild.CastToInt()].Trader(0);
                Mercenaries()[CrewMemberId.Wild.CastToInt()].Engineer(0);
            }
            if (getQuestStatusWild() < SpecialEvent.StatusWildImpatient) {
                setQuestStatusWild(getQuestStatusWild() + 1);
            }
        }
    }

    public void NewsAddEvent(NewsEvent ne) {
        _newsEvents.add(ne.CastToInt());
    }

    public void NewsAddEventsOnArrival() {
        if (cmdr.CurrentSystem().SpecialEventType() != SpecialEventType.NA) {
            switch (cmdr.CurrentSystem().SpecialEventType()) {
                case ArtifactDelivery:
                    if (cmdr.getShip().ArtifactOnBoard()) {
                        NewsAddEvent(NewsEvent.ArtifactDelivery);
                    }
                    break;
                case Dragonfly:
                    NewsAddEvent(NewsEvent.Dragonfly);
                    break;
                case DragonflyBaratas:
                    if (getQuestStatusDragonfly() == SpecialEvent.StatusDragonflyFlyBaratas) {
                        NewsAddEvent(NewsEvent.DragonflyBaratas);
                    }
                    break;
                case DragonflyDestroyed:
                    if (getQuestStatusDragonfly() == SpecialEvent.StatusDragonflyFlyZalkon) {
                        NewsAddEvent(NewsEvent.DragonflyZalkon);
                    } else if (getQuestStatusDragonfly() == SpecialEvent.StatusDragonflyDestroyed) {
                        NewsAddEvent(NewsEvent.DragonflyDestroyed);
                    }
                    break;
                case DragonflyMelina:
                    if (getQuestStatusDragonfly() == SpecialEvent.StatusDragonflyFlyMelina) {
                        NewsAddEvent(NewsEvent.DragonflyMelina);
                    }
                    break;
                case DragonflyRegulas:
                    if (getQuestStatusDragonfly() == SpecialEvent.StatusDragonflyFlyRegulas) {
                        NewsAddEvent(NewsEvent.DragonflyRegulas);
                    }
                    break;
                case ExperimentFailed:
                    NewsAddEvent(NewsEvent.ExperimentFailed);
                    break;
                case ExperimentStopped:
                    if (getQuestStatusExperiment() > SpecialEvent.StatusExperimentNotStarted
                            && getQuestStatusExperiment() < SpecialEvent.StatusExperimentPerformed) {
                        NewsAddEvent(NewsEvent.ExperimentStopped);
                    }
                    break;
                case Gemulon:
                    NewsAddEvent(NewsEvent.Gemulon);
                    break;
                case GemulonRescued:
                    if (getQuestStatusGemulon() > SpecialEvent.StatusGemulonNotStarted) {
                        if (getQuestStatusGemulon() < SpecialEvent.StatusGemulonTooLate) {
                            NewsAddEvent(NewsEvent.GemulonRescued);
                        } else {
                            NewsAddEvent(NewsEvent.GemulonInvaded);
                        }
                    }
                    break;
                case Japori:
                    if (getQuestStatusJapori() == SpecialEvent.StatusJaporiNotStarted) {
                        NewsAddEvent(NewsEvent.Japori);
                    }
                    break;
                case JaporiDelivery:
                    if (getQuestStatusJapori() == SpecialEvent.StatusJaporiInTransit) {
                        NewsAddEvent(NewsEvent.JaporiDelivery);
                    }
                    break;
                case JarekGetsOut:
                    if (cmdr.getShip().JarekOnBoard()) {
                        NewsAddEvent(NewsEvent.JarekGetsOut);
                    }
                    break;
                case Princess:
                    NewsAddEvent(NewsEvent.Princess);
                    break;
                case PrincessCentauri:
                    if (getQuestStatusPrincess() == SpecialEvent.StatusPrincessFlyCentauri) {
                        NewsAddEvent(NewsEvent.PrincessCentauri);
                    }
                    break;
                case PrincessInthara:
                    if (getQuestStatusPrincess() == SpecialEvent.StatusPrincessFlyInthara) {
                        NewsAddEvent(NewsEvent.PrincessInthara);
                    }
                    break;
                case PrincessQonos:
                    if (getQuestStatusPrincess() == SpecialEvent.StatusPrincessFlyQonos) {
                        NewsAddEvent(NewsEvent.PrincessQonos);
                    } else if (getQuestStatusPrincess() == SpecialEvent.StatusPrincessRescued) {
                        NewsAddEvent(NewsEvent.PrincessRescued);
                    }
                    break;
                case PrincessReturned:
                    if (getQuestStatusPrincess() == SpecialEvent.StatusPrincessReturned) {
                        NewsAddEvent(NewsEvent.PrincessReturned);
                    }
                    break;
                case Scarab:
                    NewsAddEvent(NewsEvent.Scarab);
                    break;
                case ScarabDestroyed:
                    if (getQuestStatusScarab() == SpecialEvent.StatusScarabHunting) {
                        NewsAddEvent(NewsEvent.ScarabHarass);
                    } else if (getQuestStatusScarab() >= SpecialEvent.StatusScarabDestroyed) {
                        NewsAddEvent(NewsEvent.ScarabDestroyed);
                    }
                    break;
                case Sculpture:
                    NewsAddEvent(NewsEvent.SculptureStolen);
                    break;
                case SculptureDelivered:
                    NewsAddEvent(NewsEvent.SculptureTracked);
                    break;
                case SpaceMonsterKilled:
                    if (getQuestStatusSpaceMonster() == SpecialEvent.StatusSpaceMonsterAtAcamar) {
                        NewsAddEvent(NewsEvent.SpaceMonster);
                    } else if (getQuestStatusSpaceMonster() >= SpecialEvent.StatusSpaceMonsterDestroyed) {
                        NewsAddEvent(NewsEvent.SpaceMonsterKilled);
                    }
                    break;
                case WildGetsOut:
                    if (cmdr.getShip().WildOnBoard()) {
                        NewsAddEvent(NewsEvent.WildGetsOut);
                    }
                    break;
            }
        }
    }

    public void NewsReplaceEvent(int oldEvent, int newEvent) {
        if (_newsEvents.indexOf(oldEvent) >= 0) {
            _newsEvents.remove(oldEvent);
        }
        _newsEvents.add(newEvent);
    }

    public void NewsResetEvents() {
        _newsEvents.clear();
    }

    public void RecalculateBuyPrices(StarSystem system) {
        for (int i = 0; i < Consts.TradeItems.length; i++) {
            if (!system.ItemTraded(Consts.TradeItems[i])) {
                _priceCargoBuy[i] = 0;
            } else {
                _priceCargoBuy[i] = _priceCargoSell[i];
                if (cmdr.getPoliceRecordScore() < Consts.PoliceRecordScoreDubious) {
                    _priceCargoBuy[i] = _priceCargoBuy[i] * 100 / 90;
                }
                // BuyPrice = SellPrice + 1 to 12% (depending on trader skill (minimum is 1, max 12))
                _priceCargoBuy[i] = _priceCargoBuy[i] * (103 + Consts.MaxSkill - cmdr.getShip().Trader()) / 100;
                if (_priceCargoBuy[i] <= _priceCargoSell[i]) {
                    _priceCargoBuy[i] = _priceCargoSell[i] + 1;
                }
            }
        }
    }

    public void RecalculateSellPrices(StarSystem system) { // After erasure of police record, selling prices must be recalculated
        for (int i = 0; i < Consts.TradeItems.length; i++) {
            _priceCargoSell[i] = _priceCargoSell[i] * 100 / 90;
        }
    }

    public void ResetVeryRareEncounters() {
        _veryRareEncounters.clear();
        _veryRareEncounters.add(VeryRareEncounter.MarieCeleste);
        _veryRareEncounters.add(VeryRareEncounter.CaptainAhab);
        _veryRareEncounters.add(VeryRareEncounter.CaptainConrad);
        _veryRareEncounters.add(VeryRareEncounter.CaptainHuie);
        _veryRareEncounters.add(VeryRareEncounter.BottleOld);
        _veryRareEncounters.add(VeryRareEncounter.BottleGood);
    }

    public void SelectNextSystemWithinRange(boolean forward) {
        int[] dest = Destinations();
        if (dest.length > 0) {
            int index = Util.BruteSeek(dest, _warpSystemId.CastToInt());
            if (index < 0) {
                index = forward ? 0 : dest.length - 1;
            } else {
                index = (dest.length + index + (forward ? 1 : -1)) % dest.length;
            }
            if (Functions.WormholeExists(cmdr.CurrentSystem(), _universe[dest[index]])) {
                SelectedSystemId(cmdr.getCurrentSystemId());
                TargetWormhole(true);
            } else {
                SelectedSystemId(StarSystemId.FromInt(dest[index]));
            }
        }
    }

    public void SelectedSystemId(StarSystemId value) {
        _selectedSystemId = value;
        _warpSystemId = value;
        _targetWormhole = false;
    }

    public void ShowNewspaper() {
        if (!getPaidForNewspaper()) {
            int cost = _difficulty.CastToInt() + 1;
            if (cmdr.getCash() < cost) {
                FormAlert.Alert(AlertType.ArrivalIFNewspaper, getParentWindow(), Functions.Multiples(cost, "credit"));
            } else if (_options.getNewsAutoPay()
                    || FormAlert.Alert(AlertType.ArrivalBuyNewspaper, getParentWindow(), Functions.Multiples(cost, "credit")) == DialogResult.Yes) {
                cmdr.setCash(cmdr.getCash() - cost);
                setPaidForNewspaper(true);
                getParentWindow().UpdateAll();
            }
        }
        if (getPaidForNewspaper()) {
            FormAlert.Alert(AlertType.Alert, getParentWindow(), NewspaperHead(), NewspaperText());
        }
    }

    public void TargetWormhole(boolean b) {
        _targetWormhole = b;
        if (_targetWormhole) {
            int wormIndex = Util.BruteSeek(_wormholes, _selectedSystemId.CastToInt());
            _warpSystemId = StarSystemId.FromInt(_wormholes[(wormIndex + 1) % _wormholes.length]);
        }
    }

    public void Warp(boolean viaSingularity) {
        if (cmdr.getDebt() > Consts.DebtTooLarge) {
            FormAlert.Alert(AlertType.DebtTooLargeGrounded, getParentWindow());
        } else if (cmdr.getCash() < MercenaryCosts()) {
            FormAlert.Alert(AlertType.LeavingIFMercenaries, getParentWindow());
        } else if (cmdr.getCash() < MercenaryCosts() + InsuranceCosts()) {
            FormAlert.Alert(AlertType.LeavingIFInsurance, getParentWindow());
        } else if (cmdr.getCash() < MercenaryCosts() + InsuranceCosts() + WormholeCosts()) {
            FormAlert.Alert(AlertType.LeavingIFWormholeTax, getParentWindow());
        } else {
            boolean wildOk = true;
            // if Wild is aboard, make sure ship is armed!
            if (cmdr.getShip().WildOnBoard() && !cmdr.getShip().HasWeapon(WeaponType.BeamLaser, false)) {
                if (FormAlert.Alert(AlertType.WildWontStayAboardLaser, getParentWindow(), cmdr.CurrentSystem().Name()) == DialogResult.Cancel) {
                    wildOk = false;
                } else {
                    FormAlert.Alert(AlertType.WildLeavesShip, getParentWindow(), cmdr.CurrentSystem().Name());
                    setQuestStatusWild(SpecialEvent.StatusWildNotStarted);
                }
            }
            if (wildOk) {
                setArrivedViaWormhole(Functions.WormholeExists(cmdr.CurrentSystem(), WarpSystem()));
                if (viaSingularity) {
                    NewsAddEvent(NewsEvent.ExperimentArrival);
                } else {
                    NormalDeparture(viaSingularity || getArrivedViaWormhole() ? 0 : Functions.Distance(cmdr.CurrentSystem(), WarpSystem()));
                }
                cmdr.CurrentSystem().CountDown(CountDownStart());
                NewsResetEvents();
                CalculatePrices(WarpSystem());
                if (Travel()) {
                    // Clicks will be -1 if we were arrested or used the escape pod.
                    /*
                     * if (Clicks == 0) FormAlert.Alert(AlertType.TravelArrival, ParentWindow);
                     */
                } else {
                    FormAlert.Alert(AlertType.TravelUneventfulTrip, getParentWindow());
                }
                Arrival();
            }
        }
    }

    public void WarpDirect() {
        _warpSystemId = _selectedSystemId;
        cmdr.CurrentSystem().CountDown(CountDownStart());
        NewsResetEvents();
        CalculatePrices(WarpSystem());
        Arrival();
    }

    public void setSelectedSystemByName(String value) {
        String nameToFind = value;
        boolean found = false;
        for (int i = 0; i < _universe.length && !found; i++) {
            String name = _universe[i].Name();
            if (name.toLowerCase().indexOf(nameToFind.toLowerCase()) >= 0) {
                SelectedSystemId(StarSystemId.FromInt(i));
                found = true;
            }
        }
    }
}
