package org.spacetrader.ui;

import org.spacetrader.model.events.VeryRareEncounter;
import org.spacetrader.model.ship.equipment.WeaponType;

// TODO for internationalization, this should be in a properties file
public interface Strings {
    String newline = "\n";
    String sellCargoStatementDump = "You can ^1 up to ^2.";
    String CargoTitle = "^1 ^2";
    String CargoUnit = "unit";
    String DistanceUnit = "parsec";
    String EncounterActionOppAttacks = "The ^1 attacks.";
    String EncounterHidePrincess = "the Princess";
    String EncounterHideSculpture = "the stolen sculpture";
    String EncounterHullStrength = "Hull at ^1%";
    String EncounterPiratesDestroyed = "destroyed";
    String EncounterPiratesDisabled = "disabled";
    String EncounterPiratesLocation = " (informing the police of the pirate's location)";
    String EncounterPoliceSubmitArrested = "You will be arrested!";
    String EncounterPoliceSubmitGoods = "illegal goods";
    String EncounterPoliceSubmitReactor = "an illegal Ion Reactor";
    String EncounterPoliceSubmitSculpture = "a stolen sculpture";
    String EncounterPoliceSubmitWild = "Jonathan Wild";
    String EncounterPoliceSurrenderCargo = "You have ^1 on board! ";
    String EncounterPoliceSurrenderAction = "They will ^1. ";
    String EncounterPoliceSurrenderReactor = "destroy the reactor";
    String EncounterPoliceSurrenderSculpt = "confiscate the sculpture";
    String EncounterPoliceSurrenderWild = "arrest Wild, too";
    String EncounterPretextAlien = "an alien";
    String EncounterPretextBottle = "a floating";
    String EncounterPretextCaptainAhab = "the famous Captain Ahab in a";
    String EncounterPretextCaptainConrad = "the famous Captain Conrad in a";
    String EncounterPretextCaptainHuie = "the famous Captain Huie in a";
    String EncounterPretextMarie = "a drifting";
    String EncounterPretextMariePolice = "the Customs Police in a";
    String EncounterPretextPirate = "a pirate";
    String EncounterPretextPolice = "a police";
    String EncounterPretextScorpion = "the kidnappers in a";
    String EncounterPretextSpaceMonster = "a horrifying";
    String EncounterPretextStolen = "a stolen";
    String EncounterPretextTrader = "a trader";
    String EncounterPrincessRescued = newline + newline + "You land your ship near where the Space Corps has landed with the Scorpion in tow. The Princess is revived from hibernation and you get to see her for the first time. Instead of the spoiled child you were expecting, Ziyal is possible the most beautiful woman you've ever seen. \"What took you so long?\" she demands. You notice a twinkle in her eye, and then she smiles. Not only is she beautiful, but she's got a sense of humor. She says, \"Thank you for freeing me. I am in your debt.\" With that she give you a kiss on the cheek, then leaves. You hear her mumble, \"Now about a ride home.\"";
    String EncounterShieldStrength = "Shields at ^1%";
    String EncounterShieldNone = "No Shields";
    String EncounterShipCaptain = "Captain";
    String EncounterShipMantis = "alien ship";
    String EncounterShipPirate = "pirate ship";
    String EncounterShipPolice = "police ship";
    String EncounterShipTrader = "trader ship";
    String EncounterText = "At ^1 from ^2 you encounter ^3 ^4.";
    String EncounterTextBottle = "It appears to be a rare bottle of Captain Marmoset's Skill Tonic!";
    String EncounterTextFamousCaptain = "The Captain requests a brief meeting with you.";
    String EncounterTextMarieCeleste = "The Marie Celeste appears to be completely abandoned.";
    String EncounterTextOpponentAttack = "Your opponent attacks.";
    String EncounterTextOpponentFlee = "Your opponent is fleeing.";
    String EncounterTextOpponentIgnore = "It ignores you.";
    String EncounterTextOpponentNoNotice = "It doesn't notice you.";
    String EncounterTextPoliceInspection = "The police summon you to submit to an inspection.";
    String EncounterTextPolicePostMarie = "\"We know you removed illegal goods from the Marie Celeste. You must give them up at once!\"";
    String EncounterTextPoliceSurrender = "The police hail they want you to surrender.";
    String EncounterTextTrader = "You are hailed with an offer to trade goods.";
    String EquipmentNoneForSale = "None for sale";
    String EquipmentNoSlots = "No slots";
    String EquipmentFreeSlot = " - FREE SLOT - ";
    String FileFormatBad = "The file is not a Space Trader for Windows file, or is the wrong version or has been corrupted.";
    String FileFutureVersion = "The version of the file is greater than the current version. You should upgrade to the latest version of Space Trader for Windows.";
    String HighScoreStatus = "^1 in ^2, worth ^3 on ^4 level.";
    String Mercenaries = " mercenaries";
    String MercenariesForHire = "^1 available for hire.";
    String MercenaryFire = "Fire";
    String MercenaryHire = "Hire";
    String MercOnBoard = "Member of Crew (^1)";
    String MoneyRateSuffix = "^1 daily";
    String MoneyUnit = "credit";
    String NA = "N/A";
    String NewsMoonForSale = "Seller in ^1 System has Utopian Moon available.";
    String NewsShipyard = "Shipyard in ^1 System offers to design custom ships.";
    String NewsTribbleBuyer = "Collector in ^1 System seeks to purchase Tribbles.";
    String PersonnelNoMercenaries = "No one for hire";
    String PersonnelNoQuarters = "No quarters available";
    String PersonnelVacancy = "Vacancy";
    String QuestNone = "There are no open quests.";
    String QuestArtifact = "Deliver the alien artifact to Professor Berger at some hi-tech system.";
    String QuestDragonflyBaratas = "Follow the Dragonfly to Baratas.";
    String QuestDragonflyMelina = "Follow the Dragonfly to Melina.";
    String QuestDragonflyRegulas = "Follow the Dragonfly to Regulas.";
    String QuestDragonflyShield = "Get your lightning shield at Zalkon.";
    String QuestDragonflyZalkon = "Follow the Dragonfly to Zalkon.";
    String QuestExperimentInformDays = "Stop Dr. Fehler's experiment at Daled within ^1.";
    String QuestExperimentInformTomorrow = "Stop Dr. Fehler's experiment at Daled by tomorrow.";
    String QuestGemulonFuel = "Get your fuel compactor at Gemulon.";
    String QuestGemulonInformDays = "Inform Gemulon about alien invasion within ^1.";
    String QuestGemulonInformTomorrow = "Inform Gemulon about alien invasion by tomorrow.";
    String QuestJarek = "Take ambassador Jarek to Devidia.";
    String QuestJarekImpatient = QuestJarek + newline + "Jarek is wondering why the journey is taking so long, and is no longer of much help in negotiating trades.";
    String QuestJaporiDeliver = "Deliver antidote to Japori.";
    String QuestMoon = "Claim your moon at Utopia.";
    String QuestPrincessCentauri = "Follow the Scorpion to Centauri.";
    String QuestPrincessInthara = "Follow the Scorpion to Inthara.";
    String QuestPrincessQonos = "Follow the Scorpion to Qonos.";
    String QuestPrincessQuantum = "Get your Quantum Disruptor at Galvon.";
    String QuestPrincessReturn = "Transport ^1 from Qonos to Galvon.";
    String QuestPrincessReturning = "Return ^1 to Galvon.";
    String QuestPrincessReturningImpatient = QuestPrincessReturning + newline + "She is becoming anxious to arrive at home, and is no longer of any help in engineering functions.";
    String QuestReactor = "Deliver the unstable reactor to Nix for Henry Morgan.";
    String QuestReactorFuel = "Deliver the unstable reactor to Nix before it consumes all its fuel.";
    String QuestReactorLaser = "Get your special laser at Nix.";
    String QuestScarabFind = "Find and destroy the Scarab (which is hiding at the exit to a wormhole).";
    String QuestScarabHull = "Get your hull upgraded at ^1.";
    String QuestScarabNotify = "Notify the authorities at ^1 that the Scarab has been destroyed.";
    String QuestSculpture = "Deliver the stolen sculpture to Endor.";
    String QuestSculptureHiddenBays = "Have hidden compartments installed at Endor.";
    String QuestSpaceMonsterKill = "Kill the space monster at Acamar.";
    String QuestTribbles = "Get rid of those pesky tribbles.";
    String QuestWild = "Smuggle Jonathan Wild to Kravat.";
    String QuestWildImpatient = QuestWild + Strings.newline + "Wild is getting impatient, and will no longer aid your crew along the way.";
    String ShipBuyGotOne = "got one";
    String ShipBuyTransfer = ", and transfer your unique equipment to the new ship";
    String ShipInfoEscapePod = "Escape Pod";
    String ShipNameCurrentShip = "<current ship>";
    String ShipNameCustomShip = "Custom Ship";
    String ShipNameModified = "<modified>";
    String ShipNameTemplateSuffixDefault = " (Default)";
    String ShipNameTemplateSuffixMinimum = " (Minimum)";
    String ShipyardEquipForSale = "There is equipment for sale.";
    String ShipyardEquipNoSale = "No equipment for sale.";
    String ShipyardPodCost = "You can buy an escape pod for 2,000 cr.";
    String ShipyardPodIF = "You need 2,000 cr. to buy an escape pod.";
    String ShipyardPodInstalled = "You have an escape pod installed.";
    String ShipyardPodNoSale = "No escape pods for sale.";
    String ShipyardShipForSale = "There are ships for sale.";
    String ShipyardShipNoSale = "No ships for sale.";
    String ShipyardSizeItem = "^1 (Max ^2)";
    String ShipyardTitle = "Ship Design at ^1 Shipyards";
    String ShipyardUnit = "Unit";
    String ShipyardWarning = "Bear in mind that getting too close to the maximum number of units will result in a \"Crowding Penalty\" due to the engineering difficulty of squeezing everything in.  There is a modest penalty at 80%, and a more severe one at 90%.";
    String ShipyardWelcome = "Welcome to ^1 Shipyards! Our best engineer, ^2, is at your service.";
    String SpecialCargoArtifact = "An alien artifact.";
    String SpecialCargoExperiment = "A portable singularity.";
    String SpecialCargoJapori = "10 bays of antidote.";
    String SpecialCargoJarek = "A haggling computer.";
    String SpecialCargoNone = "No special items.";
    String SpecialCargoReactor = "An unstable reactor taking up 5 bays.";
    String SpecialCargoSculpture = "A stolen plastic sculpture of a man holding some kind of light sword.";
    String SpecialCargoReactorBays = " of enriched fuel.";
    String SpecialCargoTribblesInfest = "An infestation of tribbles.";
    String SpecialCargoTribblesCute = "cute, furry tribble";
    String TimeUnit = "day";
    String TribbleDangerousNumber = "a dangerous number of";
    String Unknown = "Unknown";
    String[] ActivityLevels = {"Absent", "Minimal", "Few", "Some", "Moderate", "Many", "Abundant", "Swarms"};
    String[] buyCargoOps = {"Buy", "Buy", "Steal"};
    String[] sellCargoOps = {"Sell", "Sell", "Dump", "Jettison"};
    String[] CrewMemberNames = {"Commander",
            "Alyssa", "Armatur", "Bentos", "C2U2", "Chi'Ti", "Crystal", "Dane",
            "Deirdre", "Doc", "Draco", "Iranda", "Jeremiah", "Jujubal",
            "Krydon", "Luis", "Mercedez", "Milete", "Muri-L", "Mystyc",
            "Nandi", "Orestes", "Pancho", "PS37", "Quarck", "Sosumi", "Uma",
            "Wesley", "Wonton", "Yorvick", "Zeethibal", // anagram for Elizabeth
            // The rest are mercenaries I added - JAF
            "Opponent", // crew of opponent mantis, pirate, police, and trader ships
            "Wild", // now earns his keep!
            "Jarek", // now earns his keep!
            "Captain", // crew of famous captain ships
            "Dragonfly", // dummy crew member used in opponent ship
            "Scarab", // dummy crew member used in opponent ship
            "SpaceMonster", // dummy crew member used in opponent ship
            "Aragorn", // My first son's middle name, and from Lord of the Rings
            "Brady", // My third son's middle name, and QB of the New England Patriots
            "Eight of Nine", // From Star Trek - Seven's younger sibling ;)
            "Fangorn", // From Lord of the Rings
            "Gagarin", // The first man in space
            "Hoshi", // From ST: Enterprise
            "Jackson", // From Stargate - and my nephew's first name
            "Kaylee", // From FireFly
            "Marcus", // My second son's middle name
            "O'Neill", // From Stargate
            "Ripley", // From the Alien series
            "Stilgar", // From Dune
            "Taggart", // From Galaxy Quest
            "Vansen", // From Space: Above and Beyond
            "Xizor", // From Star Wars: Shadows of the Empire
            "Ziyal", // From ST: Deep Space 9
            "Scorpion" // dummy crew member used in opponent ship
    };
    String[] DifficultyLevels = {"Beginner",
            "Easy", "Normal", "Hard", "Impossible"};
    String[][] EquipmentDescriptions = {
            new String[]{
                    "The Pulse Laser is the weakest weapon available. It's small size allows only enough energy to build up to emit pulses of light.",
                    "The Beam Laser is larger than the Pulse Laser, so can build up enough charge to power what are essentially two Pulse Lasers. The resulting effect appears more like a constant beam.",
                    "The Military Laser is the largest commecially available weapon. It can build up enough charge to power three Pulse Lasers in series, resulting in a more dense and concentrated beam.",
                    "Morgan's Laser has been constructed from a Beam Laser, which has been attached to an Ion Reactor that builds up an immense charge, resulting in the strongest weapon known to exist.",
                    "The Photon Disruptor is a relatively weak weapon, but has the ability to disable an opponent's electrical systems, rendering them helpless.",
                    "The Quantum Disruptor is a very powerful disabling weapon. Once an opponent's sheilds are down it will usually require only a single shot with the Quantum Disruptor to disable them."},
            new String[]{
                    "The Energy Shield is a very basic deflector shield. Its operating principle is to absorb the energy directed at it.",
                    "The Reflective Shield is twice as powerful as the Energy Shield. It works by reflecting the energy directed at it instead of absorbing that energy.",
                    "The Lightning Shield is the most powerful shield known to exist. It features a Reflective Shield operating on a rotating frequency, which causes what looks like lightning to play across the shield barrier."},
            new String[]{
                    "Extra Cargo Bays to store anything your ship can take on as cargo.",
                    "The Auto-Repair System works to reduce the damage your ship sustains in battle, and repairs some damage in between encounters. It also boosts all other engineering functions.",
                    "The Navigating System increases the overall Pilot skill of the ship, making it harder to hit in battle, and making it easier to flee an encounter.",
                    "The Targeting System increases the overall Fighter skill of the ship, which increases the amount of damage done to an opponent in battle.",
                    "The Cloaking Device can enable your ship to evade detection by an opponent, but only if the Engineer skill of your ship is greater than that of your opponent. It also makes your ship harder to hit in battle.",
                    "The Fuel Compactor that you got as a reward for warning Gemulon of the invasion will increase the range of your ship by 3 parsecs.",
                    "These extra bays will not be detected during routine police searches. They may be detected if you are arrested and the police perform a more thorough search."}};
    String[] EquipmentTypes = {"Weapon", "Shield", "Gadget"};
    String[] GadgetNames = {"5 Extra Cargo Bays",
            "Auto-Repair System", "Navigating System", "Targeting System",
            "Cloaking Device", "Fuel Compactor", "5 Hidden Cargo Bays"};
    String[] GameCompletionTypes = {"Was killed",
            "Retired", "Claimed moon"};
    String[] ListStrings = {"", "^1", "^1 and ^2",
            "^1, ^2, and ^3", "^1, ^2, ^3, and ^4"};
    /*
     * In News Events, the following variables can be used: ^1 Commander Name ^2
     * Current System ^3 Commander's Ship Type
     */
    String[] NewsEvent = {
            "Scientist Adds Alien Artifact to Museum Collection.",
            "Police Trace Orbiting Space Litter to ^1.",
            "Experimental Craft Stolen! Critics Demand Securrentity Review.",
            "Investigators Report Strange Craft.",
            "Spectacular Display as Stolen Ship Destroyed in Fierce Space Battle.",
            "Rumors Continue: Melina Orbitted by Odd Starcraft.",
            "Strange Ship Observed in Regulas Orbit.",
            "Unidentified Ship: A Threat to Zalkon?",
            "Huge Explosion Reported at Research Facility.",
            "Travelers Report Spacetime Damage, Warp Problems!",
            "Scientists Cancel High-profile Test! Committee to Investigate Design.",
            "Travelers Claim Sighting of Ship Materializing in Orbit!",
            "Editorial: Who Will Warn Gemulon?",
            "Alien Invasion Devastates Planet!",
            "Invasion Imminent! Plans in Place to Repel Hostile Invaders.",
            "Thug Assaults Captain Ahab!",
            "Destruction of Captain Ahab's Ship Causes Anger!",
            "Captain Conrad Comes Under Attack By Criminal!",
            "Captain Conrad's Ship Destroyed by Villain!",
            "Famed Captain Huie Attacked by Brigand!",
            "Citizens Mourn Destruction of Captain Huie's Ship!",
            "Editorial: We Must Help Japori!",
            "Disease Antidotes Arrive! Health Officials Optimistic.",
            "Ambassador Jarek Returns from Crisis.",
            "Securrentity Scandal: Test Craft Confirmed Stolen.",
            "Wormhole Traffic Delayed as Stolen Craft Destroyed.",
            "Wormhole Travelers Harassed by Unusual Ship!",
            "Space Monster Threatens Homeworld!",
            "Hero Slays Space Monster! Parade, Honors Planned for Today.",
            "Notorious Criminal Jonathan Wild Arrested!",
            "Rumors Suggest Known Criminal J. Wild May Come to Kravat!",
            "Priceless collector's item stolen from home of Geurge Locas!",
            "Space Corps follows ^3 with alleged stolen sculpture to ^2.",
            "Member of Royal Family kidnapped!",
            "Aggressive Ship Seen in Orbit Around Centauri",
            "Dangerous Scorpion Damages Several Other Ships Near Inthara",
            "Kidnappers Holding Out at Qonos",
            "Scorpion Defeated! Kidnapped Member of Galvon Royal Family Freed!",
            "Beloved Royal Returns Home!"};
    String[][] NewsHeadlines = {
            new String[]{"Riots, Looting Mar Factional Negotiations.",
                    "Communities Seek Consensus.",
                    "Successful Bakunin Day Rally!",
                    "Major Faction Conflict Expected for the Weekend!"},
            new String[]{"Editorial: Taxes Too High!",
                    "Market Indices Read Record Levels!",
                    "Corporate Profits Up!",
                    "Restrictions on Corporate Freedom Abolished by Courts!"},
            new String[]{"Party Reports Productivity Increase.",
                    "Counter-Revolutionary Bureaucrats Purged from Party!",
                    "Party: Bold New Future Predicted!",
                    "Politburo Approves New 5-Year Plan!"},
            new String[]{
                    "States Dispute Natural Resource Rights!",
                    "States Denied Federal Funds over Local Laws!",
                    "Southern States Resist Federal Taxation for Capital Projects!",
                    "States Request Federal Intervention in Citrus Conflict!"},
            new String[]{"Robot Shortages Predicted for Q4.",
                    "Profitable Quarter Predicted.",
                    "CEO: Corporate Rebranding Progressing.",
                    "Advertising Budgets to Increase."},
            new String[]{"Olympictures: Software Beats Wetware in All Events!",
                    "New Network Protocols To Be Deployed.",
                    "Storage Banks to be Upgraded!",
                    "System Backup Rescheduled."},
            new String[]{"Local Elections on Schedule!",
                    "Polls: Voter Satisfaction High!",
                    "Campaign Spending Aids Economy!",
                    "Police, Politicians Vow Improvements."},
            new String[]{"New Palace Planned; Taxes Increase.",
                    "Future Presents More Opportunities for Sacrifice!",
                    "Insurrection Crushed: Rebels Executed!",
                    "Police Powers to Increase!"},
            new String[]{
                    "Drug Smugglers Sentenced to Death!",
                    "Aliens Required to Carry Visible Identification at All Times!",
                    "Foreign Sabotage Suspected.",
                    "Stricter Immigration Laws Installed."},
            new String[]{"Farmers Drafted to Defend Lord's Castle!",
                    "Report: Kingdoms Near Flashpoint!",
                    "Baron Ignores Ultimatum!", "War of Succession Threatens!"},
            new String[]{"Court-Martials Up 2% This Year.",
                    "Editorial: Why Wait to Invade?",
                    "HQ: Invasion Plans Reviewed.",
                    "Weapons Research Increases Kill-Ratio!"},
            new String[]{"King to Attend Celebrations.",
                    "Queen's Birthday Celebration Ends in Riots!",
                    "King Commissions New Artworks.",
                    "Prince Exiled for Palace Plot!"},
            new String[]{"Dialog Averts Eastern Conflict!",
                    "Universal Peace: Is it Possible?",
                    "Editorial: Life in Harmony.",
                    "Polls: Happiness Quotient High!"},
            new String[]{"Government Promises Increased Welfare Benefits!",
                    "State Denies Food Rationing Required to Prevent Famine.",
                    "'Welfare Actually Boosts Economy,' Minister Says.",
                    "Hoarder Lynched by Angry Mob!"},
            new String[]{"Millions at Peace.", "Sun Rises.",
                    "Countless Hearts Awaken.", "Serenity Reigns."},
            new String[]{"New Processor Hits 10 ZettaHerz!",
                    "Nanobot Output Exceeds Expectation.",
                    "Last Human Judge Retires.",
                    "Software Bug Causes Mass Confusion."},
            new String[]{"High Priest to Hold Special Services.",
                    "Temple Restoration Fund at 81%.",
                    "Sacred Texts on Public Display.",
                    "Dozen Blasphemers Excommunicated!"}};
    String[][] NewsMastheads = {
            new String[]{"The ^1 Arsenal", "The Grassroot", "Kick It!"},
            new String[]{"The Objectivist", "The ^1 Market", "The Invisible Hand"},
            new String[]{"The Daily Worker", "The People's Voice", "The ^1 Proletariat"},
            new String[]{"Planet News", "The ^1 Times", "Interstate Update"},
            new String[]{"^1 Memo", "News From The Board", "Status Report"},
            new String[]{"Pulses", "Binary Stream", "The System Clock"},
            new String[]{"The Daily Planet", "The ^1 Majority", "Unanimity"},
            new String[]{"The Command", "Leader's Voice", "The ^1 Mandate"},
            new String[]{"State Tribune", "Motherland News", "Homeland Report"},
            new String[]{"News from the Keep", "The Town Crier", "The ^1 Herald"},
            new String[]{"General Report", "^1 Dispatch", "The ^1 Sentry"},
            new String[]{"Royal Times", "The Loyal Subject", "The Fanfare"},
            new String[]{"Pax Humani", "Principle", "The ^1 Chorus"},
            new String[]{"All for One", "Brotherhood", "The People's Syndicate"},
            new String[]{"The Daily Koan", "Haiku", "One Hand Clapping"},
            new String[]{"The Future", "Hardware Dispatch", "TechNews"},
            new String[]{"The Spiritual Advisor", "Church Tidings", "The Temple Tribune"}
    };
    String[] NewsPoliceRecordHero = {
            "Locals Welcome Visiting Hero ^1!",
            "Famed Hero ^1 to Visit System!",
            "Large Turnout At Spaceport to Welcome ^1!"};
    String[] NewsPoliceRecordPsychopath = {
            "Police Warning: ^1 Will Dock At ^2!",
            "Notorious Criminal ^1 Sighted in ^2!",
            "Locals Rally to Deny Spaceport Access to ^1!",
            "Terror Strikes Locals on Arrival of ^1!"};
    String[] NewsPressureExternal = {
            "Reports of ^1 in the ^2 System.", "News of ^1 in the ^2 System.",
            "New Rumors of ^1 in the ^2 System.",
            "Sources report ^1 in the ^2 System.",
            "Notice: ^1 in the ^2 System.",
            "Evidence Suggests ^1 in the ^2 System."};
    String[] NewsPressureExternalPressures = {"",
            "Strife and War", "Plague Outbreaks", "Severe Drought",
            "Terrible Boredom", "Cold Weather", "Crop Failures",
            "Labor Shortages"};
    String[] NewsPressureInternal = {"",
            "War News: Offensives Continue!", "Plague Spreads! Outlook Grim.",
            "No Rain in Sight!", "Editors: Won't Someone Entertain Us?",
            "Cold Snap Continues!", "Serious Crop Failure! Must We Ration?",
            "Jobless Rate at All-Time Low!"};
    String[] PoliceRecordNames = {"Psychopath",
            "Villain", "Criminal", "Crook", "Dubious", "Clean", "Lawful",
            "Trusted", "Liked", "Hero"};
    String[] PoliticalSystemNames = {"Anarchy",
            "Capitalist State", "Communist State", "Confederacy",
            "Corporate State", "Cybernetic State", "Democracy", "Dictatorship",
            "Fascist State", "Feudal State", "Military State", "Monarchy",
            "Pacifist State", "Socialist State", "State of Satori",
            "Technocracy", "Theocracy"};
    String[] ReputationNames = {"Harmless",
            "Mostly harmless", "Poor", "Average", "Above average", "Competent",
            "Dangerous", "Deadly", "Elite"};
    String[] ShieldNames = {"Energy Shield",
            "Reflective Shield", "Lightning Shield"};
    String[] ShipNames = {"Flea", "Gnat",
            "Firefly", "Mosquito", "Bumblebee", "Beetle", "Hornet",
            "Grasshopper", "Termite", "Wasp", "Space Monster", "Dragonfly",
            "Mantis", "Scarab", "Bottle", Strings.ShipNameCustomShip, "Scorpion"};
    String[] ShipyardEngineers = {"Wedge", "Luke",
            "Lando", "Mara", "Obi-Wan"};
    String[] ShipyardNames = {
            "Corellian Engineering", "Incom Corporation", "Kuat Drive Yards",
            "Sienar Fleet Systems", "Sorosuub Engineering"};
    String[] ShipyardSkillDescriptions = {
            "All ships constructed at this shipyard use 2 fewer units per crew quarter.",
            "All ships constructed at this shipyard have 2 extra base fuel tanks.",
            "All ships constructed at this shipyard have the hull points increment by 5 more than usual.",
            "All ships constructed at this shipyard get shield slots for 2 fewer units.",
            "All ships constructed at this shipyard get weapon slots for 2 fewer units."};
    String[] ShipyardSkills = {"Crew Quartering", "Fuel Efficienty", "Hull Strength", "Shielding", "Weaponry"};
    String[] Sizes = {"Tiny", "Small", "Medium", "Large", "Huge", "Gargantuan"};
    String[] SpecialEventStrings = {
            "This alien artifact should be delivered to professor Berger, who is currently traveling. You can probably find him at a hi-tech solar system. The alien race which produced this artifact seems keen on getting it back, however, and may hinder the carrier. Are you, for a price, willing to deliver it?",
            "This is professor Berger. I thank you for delivering the alien artifact to me. I hope the aliens weren't too much of a nuisance. I have transferred 20000 credits to your account, which I assume compensates for your troubles.",
            "A trader in second-hand goods offers you 3 sealed cargo canisters for the sum of 1000 credits. It could be a good deal: they could contain robots. Then again, it might just be water. Do you want the canisters?",
            "This is Colonel Jackson of the Space Corps. An experimental ship, code-named \"Dragonfly\", has been stolen. It is equipped with very special, almost indestructible shields. It shouldn't fall into the wrong hands and we will reward you if you destroy it. It has been last seen in the Baratas system.",
            "A small ship of a weird design docked here recently for repairs. The engineer who worked on it said that it had a weak hull, but incredibly strong shields. I heard it took off in the direction of the Melina system.",
            "Hello, Commander. This is Colonel Jackson again. On behalf of the Space Corps, I thank you for your valuable assistance in destroying the Dragonfly. As a reward, we will install one of the experimental shields on your ship. Return here for that when you're ready.",
            "A ship with shields that seemed to be like lightning recently fought many other ships in our system. I have never seen anything like it before. After it left, I heard it went to the Regulas system.",
            "A small ship with shields like I have never seen before was here a few days ago. It destroyed at least ten police ships! Last thing I heard was that it went to the Zalkon system.",
            "Colonel Jackson here. Do you want us to install a lightning shield on your current ship?",
            "A hacker conveys to you that he has cracked the passwords to the galaxy-wide police computer network, and that he can erase your police record for the sum of 5000 credits. Do you want him to do that?",
            "While reviewing the plans for Dr. Fehler's new space-warping drive, Dr. Lowenstam discovered a critical error. If you don't go to Daled and stop the experiment within ten days, the time-space continuum itself could be damaged!",
            "Dr. Fehler can't understand why the experiment failed. But the failure has had a dramatic and disastrous effect on the fabric of space-time itself. It seems that Dr. Fehler won't be getting tenure any time soon... and you may have trouble when you warp!",
            "Upon your warning, Dr. Fehler calls off the experiment. As your  reward, you are given a Portable Singularity. This device will, for one time only, instantaneously transport you to any system in the galaxy. The Singularity can be accessed  by clicking the \"J\" (Jump) button on the Galactic Chart.",
            "We received word that aliens will invade Gemulon seven days from now. We know exactly at which coordinates they will arrive, but we can't warn Gemulon because an ion storm disturbs all forms of communication. We need someone, anyone, to deliver this info to Gemulon within six days.",
            "Do you wish us to install the fuel compactor on your current ship? (You need a free gadget slot)",
            "Alas, Gemulon has been invaded by aliens, which has thrown us back to pre-agricultural times. If only we had known the exact coordinates where they first arrived at our system, we might have prevented this tragedy from happening.",
            "This information of the arrival of the alien invasion force allows us to prepare a defense. You have saved our way of life. As a reward, we have a fuel compactor gadget for you, which will increase the travel distance by 3 parsecs for any ship. Return here to get it installed.",
            "A strange disease has invaded the Japori system. We would like you to deliver these ten canisters of special antidote to Japori. Note that, if you accept, ten of your cargo bays will remain in use on your way to Japori. Do you accept this mission?",
            "Thank you for delivering the medicine to us. We don't have any money to reward you, but we do have an alien fast-learning machine with which we will increase your skills.",
            "A recent change in the political climate of this solar system has forced Ambassador Jarek to flee back to his home system, Devidia. Would you be willing to give him a lift?",
            "Ambassador Jarek is very grateful to you for delivering him back to Devidia. As a reward, he gives you an experimental handheld haggling computer, which allows you to gain larger discounts when purchasing goods and equipment.",
            "You are lucky! While docking on the space port, you receive a message that you won 1000 credits in a lottery. The prize had been added to your account.",
            "There is a small but habitable moon for sale in the Utopia system, for the very reasonable sum of half a million credits. If you accept it, you can retire to it and live a peaceful, happy, and wealthy life. Do you wish to buy it?",
            "Welcome to the Utopia system. Your own moon is available for you to retire to it, if you feel inclined to do that. Are you ready to retire and lead a happy, peaceful, and wealthy life?",
            "Galactic criminal Henry Morgan wants this illegal ion reactor delivered to Nix. It's a very dangerous mission! The reactor and its fuel are bulky, taking up 15 bays. Worse, it's not stable -- its resonant energy will weaken your shields and hull strength while it's aboard your ship. Are you willing to deliver it?",
            "Henry Morgan takes delivery of the reactor with great glee. His men immediately set about stabilizing the fuel system. As a reward, Morgan offers you a special, high-powered laser that he designed. Return with an empty weapon slot when you want them to install it.",
            "Morgan's technicians are standing by with something that looks a lot like a military laser -- if you ignore the additional cooling vents and anodized ducts. Do you want them to install Morgan's special laser?",
            "Captain Renwick developed a new organic hull material for his ship which cannot be damaged except by Pulse lasers. While he was celebrating this success, pirates boarded and stole the craft, which they have named the Scarab. Rumors suggest it's being hidden at the exit to a wormhole. Destroy the ship for a reward!",
            "Space Corps is indebted to you for destroying the Scarab and the pirates who stole it. As a reward, we can have Captain Renwick upgrade the hull of your ship. Note that his upgrades won't be transferable if you buy a new ship! Come back with the ship you wish to upgrade.",
            "The organic hull used in the Scarab is still not ready for day-to-day use. But Captain Renwick can certainly upgrade your hull with some of his retrofit technology. It's light stuff, and won't reduce your ship's range. Should he upgrade your ship?",
            "An alien with a fast-learning machine offers to increase one of your skills for the reasonable sum of 3000 credits. You won't be able to picturek that skill, though. Do you accept his offer?",
            "A space monster has invaded the Acamar system and is disturbing the trade routes. You'll be rewarded handsomely if you manage to destroy it.",
            "We thank you for destroying the space monster that circled our system for so long. Please accept 15000 credits as reward for your heroic deed.",
            "A merchant prince offers you a very special and wondrous item for the sum of 1000 credits. Do you accept?",
            "An eccentric alien billionaire wants to buy your collection of tribbles and offers half a credit for each of them. Do you accept his offer?",
            "Law Enforcement is closing in on notorious criminal kingpin Jonathan Wild. He would reward you handsomely for smuggling him home to Kravat. You'd have to avoid capture by the Police on the way. Are you willing to give him a berth?",
            "Jonathan Wild is most grateful to you for spiriting him to safety. As a reward, he has one of his Cyber Criminals hack into the Police Database, and clean up your record. He also offers you the opportunity to take his talented nephew Zeethibal along as a Mercenary with no pay.",
            "A hooded figure approaches you and asks if you'd be willing to deliver some recently aquired merchandise to Endor. He's holding a small sculpture of a man holding some kind of light sword that you strongly suspect was stolen. It appears to be made of plastic and not very valuable. \"I'll pay you 2,000 credits now, plus 15,000 on delivery,\" the figure says. After seeing the look on your face he adds, \"It's a collector's item. Will you deliver it or not?\"",
            "Yet another dark, hooded figure approaches. \"Do you have the action fig- umm, the sculpture?\" You hand it over and hear what sounds very much like a giggle from under the hood. \"I know you were promised 15,000 credits on delivery, but I'm strapped for cash right now. However, I have something better for you. I have an acquaintance who can install hidden compartments in your ship.\" Return with an empty gadget slot when you're ready to have it installed.",
            "You're taken to a warehouse and whisked through the door. A grubby alien of some humanoid species - you're not sure which one - approaches. \"So you're the being who needs Hidden Compartments. Should I install them in your ship?\" (It requires a free gadget slot.)",
            "A member of the Royal Family of Galvon has been kidnapped! Princess Ziyal was abducted by men while travelling across the planet. They escaped in a hi-tech ship called the Scorpion. Please rescue her! (You'll need to equip your ship with disruptors to be able to defeat the Scorpion without destroying it.) A ship bristling with weapons was blasting out of the system. It's trajectory before going to warp indicates that its destination was Centauri.",
            "A ship had its shields upgraded to Lighting Shields just two days ago. A shipyard worker overheard one of the crew saying they were headed to Inthara.",
            "Just yesterday a ship was seen in docking bay 327. A trader sold goods to a member of the crew, who was a native of Qonos. It's possible that's where they were going next.",
            "The Galvonian Ambassador to Qonos approaches you. The Princess needs a ride home. Will you take her? I don't think she'll feel safe with anyone else.",
            "His Majesty's Shipyard: Do you want us to install a quantum disruptor on your current ship?",
            "The King and Queen are extremely grateful to you for returning their daughter to them. The King says, \"Ziyal is priceless to us, but we feel we must offer you something as a reward. Visit my shipyard captain and he'll install one of our new Quantum Disruptors.\""
    };
    String[] SpecialEventTitles = {
            "Alien Artifact", "Artifact Delivery", "Cargo For Sale", "Dragonfly", "Dragonfly Destroyed", "Weird Ship", "Lightning Ship",
            "Lightning Shield", "Strange Ship", "Erase Record", "Dangerous Experiment", "Experiment Failed", "Disaster Averted",
            "Alien Invasion", "Fuel Compactor", "Gemulon Invaded", "Gemulon Rescued", "Japori Disease", "Medicine Delivery",
            "Ambassador Jarek", "Jarek Gets Out", "Lottery Winner", "Moon For Sale", "Retirement", "Morgan's Reactor",
            "Reactor Delivered", "Install Morgan's Laser", "Scarab Stolen", "Scarab Destroyed", "Upgrade Hull", "Skill Increase",
            "Space Monster", "Monster Killed", "Merchant Prince", "Tribble Buyer", "Jonathan Wild", "Wild Gets Out",
            "Stolen Sculpture", "Sculpture Delivered", "Install Hidden Compartments", "Kidnapped", "Aggressive Ship",
            "Dangerous Scorpion", "Royal Rescue", "Quantum Disruptor", "Royal Return"
    };
    // Many of these names are from Star Trek: The Next Generation, or are small changes to names of this series. A few have different origins.
    // JAF - Except where noted these comments are the previous author's.
    String[] SystemNames = {
            "Acamar", // JAF - TNG "The Vengeance Factor (Acamar III)"
            "Adahn", // The alternate personality for The Nameless One in "Planescape: Torment"
            "Aldea", // JAF - TNG "When the Bough Breaks"
            "Andevian", // JAF - ST Andoria?
            "Antedi", // JAF - TNG "Manhunt" (Antede III)
            "Balosnee", "Baratas", // JAF - TNG "The Emissary" (Barradas III)
            "Brax", // One of the heroes in Master of Magic
            "Bretel", // This is a Dutch device for keeping your pants up.
            "Calondia", // JAF - TNG "The Price" (Caldonia)
            "Campor", // JAF - TNG "Bloodlines" (Camor V) or DS9 "Defiant" (Campa III)
            "Capelle", // The city I lived in while programming this game
            "Carzon", // JAF - Character from DS9 (Kurzon)?
            "Castor", // A Greek demi-god
            "Cestus", // JAF - several ST episodes (Cestus III)
            "Cheron", // JAF - TOS "Let That Be Your Last Battlefield"
            "Courteney", // After Courteney Cox...
            "Daled", // JAF - TNG "The Dauphin" (Daled IV)
            "Damast", "Davlos", // JAF - DS9 "Time's Orphan" (Davlos Prime) or DS9 "Visionary" (Davlos III)
            "Deneb", // JAF - TOS "Wolf in the Fold" (Deneb II) or TOS "Where No Man Has Gone Before" and TNG "Encounter at Farpoint" (Deneb IV)
            "Deneva", // JAF - TOS "Operation -- Annihilate!"
            "Devidia", // JAF - TNG "Time's Arrow" (Devidia II)
            "Draylon", // JAF - DS9 "Sanctuary" (Draylon II)
            "Drema", // JAF - TNG "Pen Pals" (Drema IV)
            "Endor", // JAF - From Return of the Jedi
            "Esmee", // One of the witches in Pratchett's Discworld
            "Exo", // JAF - TOS "What Are Little Girls Made Of?" (Exo III)
            "Ferris", // Iron
            "Festen", // A great Scandinavian movie
            "Fourmi", // An ant, in French
            "Frolix", // A solar system in one of Philip K. Dick's novels
            "Gemulon", // JAF - TNG "Final Mission" (Gamalon V) or DS9 "Paradise" (Germulon V)
            "Guinifer", // One way of writing the name of king Arthur's wife
            "Hades", // The underworld
            "Hamlet", // From Shakespeare
            "Helena", // Of Troy
            "Hulist", // A Dutch plant
            "Iodine", // An element
            "Iralius", "Janus", // A seldom encountered Dutch boy's name
            "Japori", // JAF - DS9 "Improbable Cause" (Jaforay II)?
            "Jarada", // JAF - DS9 "Progress" (Jarido)?
            "Jason", // A Greek hero
            "Kaylon", // JAF - TNG "Half a Life" (Kalon II)
            "Khefka", // JAF - DS9 "Invasive Procedures" (Kafka IV)
            "Kira", // My dog's name
            "Klaatu", // From a classic SF movie
            "Klaestron", // JAF - DS9 "Dax" (Klaestron IV)
            "Korma", // An Indian sauce
            "Kravat", // Interesting spelling of the French word for "tie"
            "Krios", // JAF - TNG "The Mind's Eye"
            "Laertes", // A king in a Greek tragedy
            "Largo", // JAF - DS9 "Babel" (Largo V)
            "Lave", // The starting system in Elite
            "Ligon", // JAF - TNG "Code of Honor" (Ligon II)
            "Lowry", // The name of the "hero" in Terry Gilliam's "Brazil"
            "Magrat", // The second of the witches in Pratchett's Discworld
            "Malcoria", // JAF - "Star Trek: First Contact" (Malkor III)?
            "Melina", // JAF - TNG "Silicon Avatar" (Malona IV)?
            "Mentar", // The Psilon home system in Master of Orion
            "Merik", // JAF - TOS "The Cloud Minders" (Merak II)
            "Mintaka", // JAF - TNG "Who Watches the Watchers" (Mintaka III)
            "Montor", // A city in Ultima III and Ultima VII part 2
            "Mordan", // JAF - TNG "Too Short a Season" (Mordan IV)
            "Myrthe", // The name of my daughter
            "Nelvana", // JAF - TNG "The Defector" (Nelvana III)
            "Nix", // An interesting spelling of a word meaning "nothing" in Dutch
            "Nyle", // An interesting spelling of the great river
            "Odet", "Og", // The last of the witches in Pratchett's Discworld
            "Omega", // The end of it all
            "Omphalos", // Greek for navel
            "Orias", "Othello", // From Shakespeare
            "Parade", // This word means the same in Dutch and in English
            "Penthara", // JAF - TNG "A Matter of Time" (Penthara IV)
            "Picard", // The enigmatic captain from ST:TNG
            "Pollux", // Brother of Castor
            "Quator", // JAF - TNG "Unification: Part I" (Qualar II)?
            "Rakhar", // JAF - DS9 "Vortex"
            "Ran", // A film by Akira Kurosawa
            "Regulas", // JAF - "Star Trek II: The Wrath of Khan" (Regula) or DS9 "Fascination" (Regulus III) or TOS "Amok Time" (Regulus V)
            "Relva", // JAF - TNG "Coming of Age" (Relva VII)
            "Rhymus", "Rochani", // JAF - DS9 "Dramatis Personae" (Rochanie III)
            "Rubicum", // The river Ceasar crossed to get into Rome
            "Rutia", // JAF - TNG "The High Ground" (Ruteeya IV)
            "Sarpeidon", // JAF - DS9 "Tacking into the Wind" (Sarpeidon V) or TOS "All Our Yesterdays" (Sarpeidon)
            "Sefalla", "Seltrice", "Sigma", "Sol", // That's our own solar system
            "Somari", "Stakoron", "Styris", // JAF - TNG "Code of Honor" (Styrus IV)
            "Talani", // JAF - DS9 "Armageddon Game" (T'Lani III and T'Lani Prime)
            "Tamus", "Tantalos", // A king from a Greek tragedy
            "Tanuga", "Tarchannen", "Terosa", // JAF - DS9 "Second Sight" (Terosa Prime)
            "Thera", // A seldom encountered Dutch girl's name
            "Titan", // The largest moon of Jupiter
            "Torin", // A hero from Master of Magic
            "Triacus", // JAF - TOS "And the Children Shall Lead"
            "Turkana", // JAF - TNG "Legacy" (Turkana IV)
            "Tyrus", "Umberlee", // A god from AD&D, which has a prominent role in Baldur's Gate
            "Utopia", // The ultimate goal
            "Vadera",
            "Vagra", // JAF - TNG "Skin of Evil" (Vagra II)
            "Vandor", // JAF - TNG "We'll Always Have Paris" (Vando VI)?
            "Ventax", // JAF - TNG "Devil's Due" (Ventax II)
            "Xenon",
            "Xerxes", // A Greek hero
            "Yew", // A city which is in almost all of the Ultima games
            "Yojimbo", // A film by Akira Kurosawa
            "Zalkon", // TNG "Transfigurations" (Zalcon)
            "Zuul", // From the first Ghostbusters movie
            // The rest are systems I added - JAF
            "Centauri", // As in Alpha Centauri - the closest star outside our solar system
            "Galvon", // Star Trek: The Next Generation "Data's Day"
            "Inthara", // Star Trek: Voyager "Retrospect"
            "Meridian", // Star Trek: Deep Space Nine "Meridian"
            "Qonos", // Star Trek - Klinon Homeworld (QonoS - Kronos)
            "Rae", // My wife's middle name
            "Weytahn", // Star Trek: Enterprise "Cease Fire"
            "Zonama" // From the Star Wars: New Jedi Order series (and Rogue Planet)
    };
    String[] VeryRareEncounters = {
            //TODO: Only used in SpaceTrader.buttonFind_Click(Object,EventData)
            VeryRareEncounter.MarieCeleste.name, VeryRareEncounter.CaptainAhab.name, VeryRareEncounter.CaptainConrad.name,
            VeryRareEncounter.CaptainHuie.name, VeryRareEncounter.BottleOld.name, VeryRareEncounter.BottleGood.name
    };
    String[] WeaponNames = {
            //TODO: Only used in Equipment.BaseImageIndex()
            WeaponType.PulseLaser.name, WeaponType.BeamLaser.name, WeaponType.MilitaryLaser.name,
            WeaponType.MorgansLaser.name, WeaponType.PhotonDisruptor.name, WeaponType.QuantumDisruptor.name
    };
}
