package org.spacetrader.controller;

import org.spacetrader.model.PoliceRecord;
import org.spacetrader.model.PoliticalSystem;
import org.spacetrader.model.Reputation;
import org.spacetrader.model.cargo.TradeItem;
import org.spacetrader.model.cargo.TradeItemType;
import org.spacetrader.model.enums.*;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.events.SpecialEventType;
import org.spacetrader.model.ship.ShipSize;
import org.spacetrader.model.ship.ShipSpec;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.model.ship.Shipyard;
import org.spacetrader.model.ship.equipment.*;
import org.spacetrader.util.Path;
import org.winforms.Rectangle;

// TODO lots of constants, maybe make several classes (name spaces), maybe some can become enums
public class Constants {
    // Directory structure and File Constants.
    public static final String BaseDirectory = System.getProperty("user.dir");
    public static final String CustomDirectory = Path.combine(BaseDirectory, "custom");
    public static final String CustomImagesDirectory = Path.combine(CustomDirectory, "images");
    public static final String CustomTemplatesDirectory = Path.combine(CustomDirectory, "templates");
    public static final String DataDirectory = Path.combine(BaseDirectory, "data");
    public static final String HighScoreFile = Path.combine(DataDirectory, "HighScores.bin");
    public static final String DefaultSettingsFile = Path.combine(DataDirectory, "DefaultSettings.bin");
    public static final String SaveDirectory = Path.combine(BaseDirectory, "save");
    // Price paid by government for each negative PoliceScore point
    //public static final int BountyModifier = 1000;
    public static final int CloseDistance = 13;
    public static final int MaxRange = 20;
    public static final int WormDist = 25;
    public static final int DebtWarning = 75000;
    public static final int DebtTooLarge = 100000;
    public static final double InsRate = 0.0025;
    public static final double IntRate = 0.1;
    public static final int MaxNoClaim = 90;
    public static final int SkillBonus = 3;
    public static final int CloakBonus = 2;
    public static final int MaxSkill = 10;
    public static final int StartClicks = 20;
    public static final int MaxFuelTanks = 20;
    public static final int FuelCompactorTanks = 3;
    public static final int HullUpgrade = 50;
    public static final int MaxShip = 9;
    public static final int MaxSlots = 5;
    public static final int FleaConversionCost = 500;
    public static final int PodTransferCost = 200;
    public static final int ImagesPerShip = 4;
    public static final int ShipImgOffsetNormal = 0;
    public static final int ShipImgOffsetDamage = 1;
    public static final int ShipImgOffsetShield = 2;
    public static final int ShipImgOffsetShieldDamage = 3;
    public static final int ShipImgUseDefault = -1;
    public static final int EncounterImgAlien = 0;
    public static final int EncounterImgPirate = 1;
    public static final int EncounterImgPolice = 2;
    public static final int EncounterImgSpecial = 3;
    public static final int EncounterImgTrader = 4;
    public static final int StoryProbability = 50 / 8;
    public static final int FabricRipInitialProbability = 25;
    public static final int DirectionUp = 0;
    public static final int DirectionDown = 1;
    public static final int DirectionLeft = 2;
    public static final int DirectionRight = 3;
    public static final int DisruptorSystemsMultiplier = 3;
    public static final int MaxTribbles = 100000;
    public static final int PoliceRecordScorePsychopath = -100;
    public static final int PoliceRecordScoreVillain = -70;
    public static final int PoliceRecordScoreCriminal = -30;
    public static final int PoliceRecordScoreCrook = -10;
    public static final int PoliceRecordScoreDubious = -5;
    public static final int PoliceRecordScoreClean = 0;
    public static final int PoliceRecordScoreLawful = 5;
    public static final int PoliceRecordScoreTrusted = 10;
    public static final int PoliceRecordScoreLiked = 25;
    public static final int PoliceRecordScoreHero = 75;

    public static final int ReputationScoreHarmless = 0;  // TODO enum
    public static final int ReputationScoreMostlyHarmless = 10;
    public static final int ReputationScorePoor = 20;
    public static final int ReputationScoreAverage = 40;
    public static final int ReputationScoreAboveAverage = 80;
    public static final int ReputationScoreCompetent = 150;
    public static final int ReputationScoreDangerous = 300;
    public static final int ReputationScoreDeadly = 600;
    public static final int ReputationScoreElite = 1500;
    public static final int ScoreAttackPirate = 0;
    public static final int ScoreAttackPolice = -3;
    public static final int ScoreAttackTrader = -2;
    public static final int ScoreCaughtWithWild = -4;
    public static final int ScoreFleePolice = -2;
    public static final int ScoreKillCaptain = 100;
    public static final int ScoreKillPirate = 1;
    public static final int ScoreKillPolice = -6;
    public static final int ScoreKillTrader = -4;
    public static final int ScorePlunderPirate = -1;
    public static final int ScorePlunderTrader = -2;
    public static final int ScoreTrafficking = -1;
    public static final String ShipTemplateSeparator = "----------------------------";
    public static final Weapon[] WeaponObjects = {
            new Weapon(WeaponType.PulseLaser, 15, false, 2000, TechLevel.t5, 50),
            new Weapon(WeaponType.BeamLaser, 25, false, 12500, TechLevel.t6, 35),
            new Weapon(WeaponType.MilitaryLaser, 35, false, 35000, TechLevel.t7, 15),
            new Weapon(WeaponType.MorgansLaser, 85, false, 50000, TechLevel.t8, 0),
            new Weapon(WeaponType.PhotonDisruptor, 20, true, 15000, TechLevel.t6, 0),
            new Weapon(WeaponType.QuantumDisruptor, 60, true, 50000, TechLevel.t8, 0)
    };
    public static final Shield[] Shields = {
            new Shield(ShieldType.Energy, 100, 5000, TechLevel.t5, 70),
            new Shield(ShieldType.Reflective, 200, 20000, TechLevel.t6, 30),
            // The weapons below cannot be bought
            new Shield(ShieldType.Lightning, 350, 45000, TechLevel.t8, 0)
    };
    public static final Gadget[] Gadgets = {
            new Gadget(GadgetType.ExtraCargoBays, SkillType.NA, 2500, TechLevel.t4, 35), // 5 extra holds
            new Gadget(GadgetType.AutoRepairSystem, SkillType.Engineer, 7500, TechLevel.t5, 20), // Increases engineer's effectivity
            new Gadget(GadgetType.NavigatingSystem, SkillType.Pilot, 15000, TechLevel.t6, 20), // Increases pilot's effectivity
            new Gadget(GadgetType.TargetingSystem, SkillType.Fighter, 25000, TechLevel.t6, 20), // Increases fighter's effectivity
            new Gadget(GadgetType.CloakingDevice, SkillType.Pilot, 100000, TechLevel.t7, 5), // If you have a good engineer, neither pirates nor police will notice you
            // The gadgets below can't be bought
            new Gadget(GadgetType.FuelCompactor, SkillType.NA, 30000, TechLevel.t8, 0),
            new Gadget(GadgetType.HiddenCargoBays, SkillType.NA, 60000, TechLevel.t8, 0)
    };
    public static final String CurrentVersion = "2.00";
    // TODO many of these can become enums.
    public static final PoliceRecord[] PoliceRecords = {
            new PoliceRecord(PoliceRecordType.Psychopath, PoliceRecordScorePsychopath),
            new PoliceRecord(PoliceRecordType.Villain, PoliceRecordScoreVillain),
            new PoliceRecord(PoliceRecordType.Criminal, PoliceRecordScoreCriminal),
            new PoliceRecord(PoliceRecordType.Crook, PoliceRecordScoreCrook),
            new PoliceRecord(PoliceRecordType.Dubious, PoliceRecordScoreDubious),
            new PoliceRecord(PoliceRecordType.Clean, PoliceRecordScoreClean),
            new PoliceRecord(PoliceRecordType.Lawful, PoliceRecordScoreLawful),
            new PoliceRecord(PoliceRecordType.Trusted, PoliceRecordScoreTrusted),
            new PoliceRecord(PoliceRecordType.Liked, PoliceRecordScoreLiked),
            new PoliceRecord(PoliceRecordType.Hero, PoliceRecordScoreHero)
    };
    public static final PoliticalSystem[] PoliticalSystems = {
            new PoliticalSystem(PoliticalSystemType.Anarchy, 0, Activity.Absent, Activity.Swarms, Activity.Minimal,
                    TechLevel.t0, TechLevel.t5, 7, true, true, TradeItemType.Food),
            new PoliticalSystem(PoliticalSystemType.Capitalist, 2, Activity.Some, Activity.Few, Activity.Swarms,
                    TechLevel.t4, TechLevel.t7, 1, true, true, TradeItemType.Ore),
            new PoliticalSystem(PoliticalSystemType.Communist, 6, Activity.Abundant, Activity.Moderate, Activity.Moderate,
                    TechLevel.t1, TechLevel.t5, 5, true, true, TradeItemType.NA),
            new PoliticalSystem(PoliticalSystemType.Confederacy, 5, Activity.Moderate, Activity.Some, Activity.Many,
                    TechLevel.t1, TechLevel.t6, 3, true, true, TradeItemType.Games),
            new PoliticalSystem(PoliticalSystemType.Corporate, 2, Activity.Abundant, Activity.Few, Activity.Swarms,
                    TechLevel.t4, TechLevel.t7, 2, true, true, TradeItemType.Robots),
            new PoliticalSystem(PoliticalSystemType.Cybernetic, 0, Activity.Swarms, Activity.Swarms, Activity.Many,
                    TechLevel.t6, TechLevel.t7, 0, false, false, TradeItemType.Ore),
            new PoliticalSystem(PoliticalSystemType.Democracy, 4, Activity.Some, Activity.Few, Activity.Many,
                    TechLevel.t3, TechLevel.t7, 2, true, true, TradeItemType.Games),
            new PoliticalSystem(PoliticalSystemType.Dictatorship, 3, Activity.Moderate, Activity.Many, Activity.Some,
                    TechLevel.t0, TechLevel.t7, 2, true, true, TradeItemType.NA),
            new PoliticalSystem(PoliticalSystemType.Fascist, 7, Activity.Swarms, Activity.Swarms, Activity.Minimal,
                    TechLevel.t4, TechLevel.t7, 0, false, true, TradeItemType.Machines),
            new PoliticalSystem(PoliticalSystemType.Feudal, 1, Activity.Minimal, Activity.Abundant, Activity.Few,
                    TechLevel.t0, TechLevel.t3, 6, true, true, TradeItemType.Firearms),
            new PoliticalSystem(PoliticalSystemType.Military, 7, Activity.Swarms, Activity.Absent, Activity.Abundant,
                    TechLevel.t2, TechLevel.t7, 0, false, true, TradeItemType.Robots),
            new PoliticalSystem(PoliticalSystemType.Monarchy, 3, Activity.Moderate, Activity.Some, Activity.Moderate,
                    TechLevel.t0, TechLevel.t5, 4, true, true, TradeItemType.Medicine),
            new PoliticalSystem(PoliticalSystemType.Pacifist, 7, Activity.Few, Activity.Minimal, Activity.Many, TechLevel.t0,
                    TechLevel.t3, 1, true, false, TradeItemType.NA),
            new PoliticalSystem(PoliticalSystemType.Socialist, 4, Activity.Few, Activity.Many, Activity.Some, TechLevel.t0,
                    TechLevel.t5, 6, true, true, TradeItemType.NA),
            new PoliticalSystem(PoliticalSystemType.Satori, 0, Activity.Minimal, Activity.Minimal, Activity.Minimal,
                    TechLevel.t0, TechLevel.t1, 0, false, false, TradeItemType.NA),
            new PoliticalSystem(PoliticalSystemType.Technocracy, 1, Activity.Abundant, Activity.Some, Activity.Abundant,
                    TechLevel.t4, TechLevel.t7, 2, true, true, TradeItemType.Water),
            new PoliticalSystem(PoliticalSystemType.Theocracy, 5, Activity.Abundant, Activity.Minimal, Activity.Moderate,
                    TechLevel.t0, TechLevel.t4, 0, true, true, TradeItemType.Narcotics)
    };

    public static final Reputation[] Reputations = {
            new Reputation(ReputationType.Harmless, ReputationScoreHarmless),
            new Reputation(ReputationType.MostlyHarmless, ReputationScoreMostlyHarmless),
            new Reputation(ReputationType.Poor, ReputationScorePoor),
            new Reputation(ReputationType.Average, ReputationScoreAverage),
            new Reputation(ReputationType.AboveAverage, ReputationScoreAboveAverage),
            new Reputation(ReputationType.Competent, ReputationScoreCompetent),
            new Reputation(ReputationType.Dangerous, ReputationScoreDangerous),
            new Reputation(ReputationType.Deadly, ReputationScoreDeadly),
            new Reputation(ReputationType.Elite, ReputationScoreElite)
    };
    public static final Rectangle[] ShipImageOffsets = {
            // We only care about X and Width, so set Y and Height to 0.
            new Rectangle(22, 0, 19, 0), // Flea
            new Rectangle(18, 0, 27, 0), // Gnat
            new Rectangle(18, 0, 27, 0), // Firefly
            new Rectangle(18, 0, 27, 0), // Mosquito
            new Rectangle(12, 0, 40, 0), // Bumblebee
            new Rectangle(12, 0, 40, 0), // Beetle
            new Rectangle(7, 0, 50, 0), // Hornet
            new Rectangle(7, 0, 50, 0), // Grasshopper
            new Rectangle(2, 0, 60, 0), // Termite
            new Rectangle(2, 0, 60, 0), // Wasp
            new Rectangle(7, 0, 49, 0), // Space Monster
            new Rectangle(21, 0, 22, 0), // Dragonfly
            new Rectangle(15, 0, 34, 0), // Mantis
            new Rectangle(7, 0, 49, 0), // Scarab
            new Rectangle(9, 0, 46, 0), // Bottle
            new Rectangle(2, 0, 60, 0), // Custom
            new Rectangle(2, 0, 60, 0) // Scorpion
    };
    public static final ShipSpec[] ShipSpecs = {
            //           Type                  ShipSize        Bays W  S  G  Cr F   FC Hull RC  Price   %   Police             Pirates           Traders          MinTechLevel
            new ShipSpec(ShipType.Flea, ShipSize.Tiny, 10, 0, 0, 0, 1, 20, 1, 25, 1, 2000, 2, Activity.NA, Activity.NA, Activity.Absent, TechLevel.t4),
            new ShipSpec(ShipType.Gnat, ShipSize.Small, 15, 1, 0, 1, 1, 14, 1, 100, 2, 10000, 28, Activity.Absent, Activity.Absent, Activity.Absent, TechLevel.t5),
            new ShipSpec(ShipType.Firefly, ShipSize.Small, 20, 1, 1, 1, 1, 17, 1, 100, 3, 25000, 20, Activity.Absent, Activity.Absent, Activity.Absent, TechLevel.t5),
            new ShipSpec(ShipType.Mosquito, ShipSize.Small, 15, 2, 1, 1, 1, 13, 1, 100, 5, 30000, 20, Activity.Absent, Activity.Minimal, Activity.Absent, TechLevel.t5),
            new ShipSpec(ShipType.Bumblebee, ShipSize.Medium, 25, 1, 2, 2, 2, 15, 1, 100, 7, 60000, 15, Activity.Minimal, Activity.Minimal, Activity.Absent, TechLevel.t5),
            new ShipSpec(ShipType.Beetle, ShipSize.Medium, 50, 0, 1, 1, 3, 14, 1, 50, 10, 80000, 3, Activity.NA, Activity.NA, Activity.Absent, TechLevel.t5),
            new ShipSpec(ShipType.Hornet, ShipSize.Large, 20, 3, 2, 1, 2, 16, 2, 150, 15, 100000, 6, Activity.Few, Activity.Some, Activity.Minimal, TechLevel.t6),
            new ShipSpec(ShipType.Grasshopper, ShipSize.Large, 30, 2, 2, 3, 3, 15, 3, 150, 15, 150000, 2, Activity.Some, Activity.Moderate, Activity.Few, TechLevel.t6),
            new ShipSpec(ShipType.Termite, ShipSize.Huge, 60, 1, 3, 2, 3, 13, 4, 200, 20, 225000, 2, Activity.Moderate, Activity.Many, Activity.Some, TechLevel.t7),
            new ShipSpec(ShipType.Wasp, ShipSize.Huge, 35, 3, 2, 2, 3, 14, 5, 200, 20, 300000, 2, Activity.Many, Activity.Abundant, Activity.Moderate, TechLevel.t7),
            // The ships below can't be bought (mostly)
            new ShipSpec(ShipType.SpaceMonster, ShipSize.Huge, 0, 3, 0, 0, 1, 1, 1, 500, 1, 500000, 0, Activity.NA, Activity.NA, Activity.NA, TechLevel.t8),
            new ShipSpec(ShipType.Dragonfly, ShipSize.Small, 0, 2, 3, 2, 1, 1, 1, 10, 1, 500000, 0, Activity.NA, Activity.NA, Activity.NA, TechLevel.t8),
            new ShipSpec(ShipType.Mantis, ShipSize.Medium, 0, 3, 1, 3, 3, 1, 1, 300, 1, 500000, 0, Activity.NA, Activity.NA, Activity.NA, TechLevel.t8),
            new ShipSpec(ShipType.Scarab, ShipSize.Large, 20, 2, 0, 0, 2, 1, 1, 400, 1, 500000, 0, Activity.NA, Activity.NA, Activity.NA, TechLevel.t8),
            new ShipSpec(ShipType.Bottle, ShipSize.Small, 0, 0, 0, 0, 0, 1, 1, 10, 1, 100, 0, Activity.NA, Activity.NA, Activity.NA, TechLevel.t8),
            new ShipSpec(ShipType.Custom, ShipSize.Huge, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Activity.NA, Activity.NA, Activity.NA, TechLevel.t8),
            new ShipSpec(ShipType.Scorpion, ShipSize.Huge, 30, 2, 2, 2, 2, 1, 1, 300, 1, 500000, 0, Activity.NA, Activity.NA, Activity.NA, TechLevel.t8)};
    public static final Shipyard[] Shipyards = {
            new Shipyard(ShipyardId.Corellian, ShipSize.Large, ShipyardSkill.CrewQuarters),
            new Shipyard(ShipyardId.Incom, ShipSize.Medium, ShipyardSkill.ShieldSlotUnits),
            new Shipyard(ShipyardId.Kuat, ShipSize.Huge, ShipyardSkill.HullPerUnit),
            new Shipyard(ShipyardId.Sienar, ShipSize.Tiny, ShipyardSkill.WeaponSlotUnits),
            new Shipyard(ShipyardId.Sorosuub, ShipSize.Small, ShipyardSkill.FuelBase)
    };
    public static final CrewMemberId[] SpecialCrewMemberIds = {
            CrewMemberId.Commander, CrewMemberId.Dragonfly, CrewMemberId.FamousCaptain, CrewMemberId.Jarek, CrewMemberId.Opponent,
            CrewMemberId.Princess, CrewMemberId.Scarab, CrewMemberId.Scorpion, CrewMemberId.SpaceMonster, CrewMemberId.Wild
    };
    public static final SpecialEvent[] SpecialEvents = {
            new SpecialEvent(SpecialEventType.Artifact, 0, 1, false),
            new SpecialEvent(SpecialEventType.ArtifactDelivery, -20000, 0, true),
            new SpecialEvent(SpecialEventType.CargoForSale, 1000, 3, false),
            new SpecialEvent(SpecialEventType.Dragonfly, 0, 1, true),
            new SpecialEvent(SpecialEventType.DragonflyBaratas, 0, 0, true),
            new SpecialEvent(SpecialEventType.DragonflyDestroyed, 0, 0, true),
            new SpecialEvent(SpecialEventType.DragonflyMelina, 0, 0, true),
            new SpecialEvent(SpecialEventType.DragonflyRegulas, 0, 0, true),
            new SpecialEvent(SpecialEventType.DragonflyShield, 0, 0, false),
            new SpecialEvent(SpecialEventType.EraseRecord, 5000, 3, false),
            new SpecialEvent(SpecialEventType.Experiment, 0, 0, true),
            new SpecialEvent(SpecialEventType.ExperimentFailed, 0, 0, true),
            new SpecialEvent(SpecialEventType.ExperimentStopped, 0, 0, true),
            new SpecialEvent(SpecialEventType.Gemulon, 0, 0, true),
            new SpecialEvent(SpecialEventType.GemulonFuel, 0, 0, false),
            new SpecialEvent(SpecialEventType.GemulonInvaded, 0, 0, true),
            new SpecialEvent(SpecialEventType.GemulonRescued, 0, 0, true),
            new SpecialEvent(SpecialEventType.Japori, 0, 1, false),
            new SpecialEvent(SpecialEventType.JaporiDelivery, 0, 0, true),
            new SpecialEvent(SpecialEventType.Jarek, 0, 1, false),
            new SpecialEvent(SpecialEventType.JarekGetsOut, 0, 0, true),
            new SpecialEvent(SpecialEventType.Lottery, -1000, 0, true),
            new SpecialEvent(SpecialEventType.Moon, 500000, 4, false),
            new SpecialEvent(SpecialEventType.MoonRetirement, 0, 0, false),
            new SpecialEvent(SpecialEventType.Reactor, 0, 0, false),
            new SpecialEvent(SpecialEventType.ReactorDelivered, 0, 0, true),
            new SpecialEvent(SpecialEventType.ReactorLaser, 0, 0, false),
            new SpecialEvent(SpecialEventType.Scarab, 0, 1, true),
            new SpecialEvent(SpecialEventType.ScarabDestroyed, 0, 0, true),
            new SpecialEvent(SpecialEventType.ScarabUpgradeHull, 0, 0, false),
            new SpecialEvent(SpecialEventType.Skill, 3000, 3, false),
            new SpecialEvent(SpecialEventType.SpaceMonster, 0, 1, true),
            new SpecialEvent(SpecialEventType.SpaceMonsterKilled, -15000, 0, true),
            new SpecialEvent(SpecialEventType.Tribble, 1000, 1, false),
            new SpecialEvent(SpecialEventType.TribbleBuyer, 0, 3, false),
            new SpecialEvent(SpecialEventType.Wild, 0, 1, false),
            new SpecialEvent(SpecialEventType.WildGetsOut, 0, 0, true),
            new SpecialEvent(SpecialEventType.Sculpture, -2000, 0, false),
            new SpecialEvent(SpecialEventType.SculptureDelivered, 0, 0, true),
            new SpecialEvent(SpecialEventType.SculptureHiddenBays, 0, 0, false),
            new SpecialEvent(SpecialEventType.Princess, 0, 0, true),
            new SpecialEvent(SpecialEventType.PrincessCentauri, 0, 0, true),
            new SpecialEvent(SpecialEventType.PrincessInthara, 0, 0, true),
            new SpecialEvent(SpecialEventType.PrincessQonos, 0, 0, false),
            new SpecialEvent(SpecialEventType.PrincessQuantum, 0, 0, false),
            new SpecialEvent(SpecialEventType.PrincessReturned, 0, 0, true)
    };
    public static final TradeItem[] TradeItems = {
            new TradeItem(TradeItemType.Water, TechLevel.t0, TechLevel.t0, TechLevel.t2, 30, 3, 4, SystemPressure.Drought, SpecialResource.SweetOceans, SpecialResource.Desert, 30, 50, 1),
            new TradeItem(TradeItemType.Furs, TechLevel.t0, TechLevel.t0, TechLevel.t0, 250, 10, 10, SystemPressure.Cold, SpecialResource.RichFauna, SpecialResource.Lifeless, 230, 280, 5),
            new TradeItem(TradeItemType.Food, TechLevel.t1, TechLevel.t0, TechLevel.t1, 100, 5, 5, SystemPressure.CropFailure, SpecialResource.RichSoil, SpecialResource.PoorSoil, 90, 160, 5),
            new TradeItem(TradeItemType.Ore, TechLevel.t2, TechLevel.t2, TechLevel.t3, 350, 20, 10, SystemPressure.War, SpecialResource.MineralRich, SpecialResource.MineralPoor, 350, 420, 10),
            new TradeItem(TradeItemType.Games, TechLevel.t3, TechLevel.t1, TechLevel.t6, 250, -10, 5, SystemPressure.Boredom, SpecialResource.Artistic, SpecialResource.NA, 160, 270, 5),
            new TradeItem(TradeItemType.Firearms, TechLevel.t3, TechLevel.t1, TechLevel.t5, 1250, -75, 100, SystemPressure.War, SpecialResource.Warlike, SpecialResource.NA, 600, 1100, 25),
            new TradeItem(TradeItemType.Medicine, TechLevel.t4, TechLevel.t1, TechLevel.t6, 650, -20, 10, SystemPressure.Plague, SpecialResource.SpecialHerbs, SpecialResource.NA, 400, 700, 25),
            new TradeItem(TradeItemType.Machines, TechLevel.t4, TechLevel.t3, TechLevel.t5, 900, -30, 5, SystemPressure.Employment, SpecialResource.NA, SpecialResource.NA, 600, 800, 25),
            new TradeItem(TradeItemType.Narcotics, TechLevel.t5, TechLevel.t0, TechLevel.t5, 3500, -125, 150, SystemPressure.Boredom, SpecialResource.WeirdMushrooms, SpecialResource.NA, 2000, 3000, 50),
            new TradeItem(TradeItemType.Robots, TechLevel.t6, TechLevel.t4, TechLevel.t7, 5000, -150, 100, SystemPressure.Employment, SpecialResource.NA, SpecialResource.NA, 3500, 5000, 100)
    };
    // This comes at the end because it depends on other Constant Arrays
    public static final Equipment[] EquipmentForSale = {
            WeaponObjects[WeaponType.PulseLaser.id],
            WeaponObjects[WeaponType.BeamLaser.id],
            WeaponObjects[WeaponType.MilitaryLaser.id],
            WeaponObjects[WeaponType.PhotonDisruptor.id],
            Shields[ShieldType.Energy.id],
            Shields[ShieldType.Reflective.id],
            Gadgets[GadgetType.ExtraCargoBays.asInteger()],
            Gadgets[GadgetType.AutoRepairSystem.asInteger()],
            Gadgets[GadgetType.NavigatingSystem.asInteger()],
            Gadgets[GadgetType.TargetingSystem.asInteger()],
            Gadgets[GadgetType.CloakingDevice.asInteger()]
    };
}
