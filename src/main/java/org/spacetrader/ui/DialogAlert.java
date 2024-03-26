package org.spacetrader.ui;

import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.enums.GameEndType;
import org.winforms.controls.Button;
import org.winforms.Graphics;
import org.winforms.controls.Label;
import org.winforms.*;
import org.winforms.controls.Dialog;
import org.winforms.enums.*;

import java.awt.*;


public class DialogAlert extends Dialog {
    private static final String _80_CHARS = "01234567890123456789012345678901234567890123456789012345678901234567890123456789";
    private static final int SPLASH_INDEX = 4;
    private final Button button1;
    private final Button button2;
    private final ImageList ilImages;
    private final Label labelText;
    private final Timer timerTick;

    private DialogAlert() {

        ResourceManager resources = new ResourceManager(DialogAlert.class);
        labelText = new Label();
        button1 = new Button();
        button2 = new Button();
        ilImages = new ImageList();
        timerTick = new Timer();
        suspendLayout();
        // labelText
        labelText.setLocation(new java.awt.Point(8, 8));
        labelText.setName("labelText");
        labelText.setTabIndex(3);
        labelText.setText("X");
        // button1
        button1.setDialogResult(DialogResult.OK);
        button1.setFlatStyle(FlatStyle.Flat);
        button1.setLocation(new java.awt.Point(115, 32));
        button1.setName("button1");
        button1.setSize(new Dimension(40, 22));
        button1.setTabIndex(1);
        button1.setText("Ok");
        // button2
        button2.setDialogResult(DialogResult.No);
        button2.setFlatStyle(FlatStyle.Flat);
        button2.setLocation(new java.awt.Point(200, 32));
        button2.setName("button2");
        button2.setSize(new Dimension(40, 22));
        button2.setTabIndex(2);
        button2.setText("No");
        button2.setVisible(false);
        // ilImages
        ilImages.colorDepth = ColorDepth.Depth24Bit;
        ilImages.setImageSize(new Dimension(160, 160));
        ilImages.setImageStream(((ImageListStreamer) (resources.getObject("ilImages.ImageStream"))));
        ilImages.setTransparentColor(null);
        // timerTick
        timerTick.setInterval(4000);
        timerTick.tick = new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                timerTick_Tick();
            }
        };
        // FormAlert
        setAutoScaleBaseSize(new Dimension(5, 13));
        setClientSize(new Dimension(270, 80));
        setControlBox(false);
        Controls.add(button2);
        Controls.add(button1);
        Controls.add(labelText);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormAlert");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Title");
        setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                FormAlert_Click(sender, data);
            }
        });
        resumeLayout(false);
    }

    public DialogAlert(String title, String text, String button1Text, DialogResult button1Result, String button2Text, DialogResult button2Result, String[] args) {
        this();
        Graphics graphics = CreateGraphics();
        // Replace any variables.
        if (null != args) {
            title = Functions.StringVars(title, args);
            text = Functions.StringVars(text, args);
        }
        labelText.setWidth(graphics.measureString((80 < text.length() ? _80_CHARS : text), getFont()).width + 25);
        labelText.setText(text);
        labelText.setHeight(30 + 30 * text.length() / 80);
        // Size the buttons.
        button1.setText(button1Text);
        button1.setDialogResult(button1Result);
        button1.setWidth(Math.max(40, graphics.measureString(button1.getText(), getFont()).width + 35));
        int buttonWidth = button1.getWidth();
        if (null != button2Text) {
            button2.setText(button2Text);
            button2.setWidth(Math.max((int) Math.ceil(graphics.measureString(button2.getText(), getFont()).width) + 10, 40));
            button2.setVisible(true);
            button2.setDialogResult(button2Result);
            buttonWidth += button2.getWidth() + 6;
        }
        // Size the form.
        setWidth(Math.max(buttonWidth, labelText.getWidth()) + 16);
        setHeight(labelText.getHeight() + 75);
        // Locate the controls.
        labelText.setLeft((getWidth() - labelText.getWidth()) / 2);
        button1.setTop(labelText.getHeight() + 19);
        button1.setLeft((getWidth() - buttonWidth) / 2);
        button2.setTop(button1.getTop());
        button2.setLeft(button1.getLeft() + button1.getWidth() + 6);
        // Set the title.
        setText(title);
    }

    public DialogAlert(String title, int imageIndex) {
        this();
        // Make sure the extra controls are hidden.
        labelText.setVisible(false);
        button2.setVisible(false);
        // Move button1 off-screen.
        button1.setLeft(-button1.getWidth());
        button1.setTop(-button1.getHeight());
        setAcceptButton(button1);
        setCancelButton(button1);
        // Set the background image.
        setBackgroundImage(ilImages.getImages()[imageIndex]);
        setClientSize((new Dimension(getBackgroundImage().getHeight(), getBackgroundImage().getWidth())));
        // Set the title.
        setText(title);
        // If this is the splash screen, get rid of the title bar and start the timer.
        if (SPLASH_INDEX == imageIndex) {
            setFormBorderStyle(FormBorderStyle.None);
            timerTick.Start();
        }
    }

    public static DialogResult Alert(AlertType at, Pane wp) {
        return Alert(at, wp, new String[]{});
    }

    public static DialogResult Alert(AlertType at, Pane wp, String s) {
        return Alert(at, wp, new String[]{s});
    }

    public static DialogResult Alert(AlertType at, Pane wp, String s, String t) {
        return Alert(at, wp, new String[]{s, t});
    }

    public static DialogResult Alert(AlertType at, Pane wp, String s, String t, String u) {
        return Alert(at, wp, new String[]{s, t, u});
    }

    public static DialogResult Alert(AlertType at, Pane wp, String[] ss) {
        DialogResult dr = DialogResult.None;
        if (0 == ss.length) {
            ss = null;
        }
        switch (at) {
            case Alert:
                dr = (new DialogAlert("^1", "^2", "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case AntidoteOnBoard:
                dr = (new DialogAlert("Antidote", "Ten of your cargo bays now contain antidote for the Japori system.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case AntidoteDestroyed:
                dr = (new DialogAlert("Antidote Destroyed", "The antidote for the Japori system has been destroyed with your ship. You should return to ^1 and get some more.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case AntidoteTaken:
                dr = (new DialogAlert("Antidote Taken", "The Space Corps removed the antidote for Japori from your ship and delivered it, fulfilling your assignment.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case AppStart:
                (new DialogAlert("Space Trader for Windows", SPLASH_INDEX)).ShowDialog(wp);
                break;
            case ArrivalBuyNewspaper:
                dr = (new DialogAlert("Buy Newspaper?", "The local newspaper costs ^1. Do you wish to buy a copy?",
                        "Buy Newspaper", DialogResult.Yes, "Cancel", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case ArrivalIFFuel:
                dr = (new DialogAlert("No Full Tanks", "You do not have enough money to buy full tanks.", "Ok",
                        DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ArrivalIFFuelRepairs:
                dr = (new DialogAlert("Not Enough Money", "You don't have enough money to get a full tank or full hull repairs.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ArrivalIFNewspaper:
                dr = (new DialogAlert("Can't Afford it!", "Sorry! A newspaper costs ^1 in this system. You don't have enough money!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ArrivalIFRepairs:
                dr = (new DialogAlert("No Full Repairs", "You don't have enough money to get your hull fully repaired.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ArtifactLost:
                dr = (new DialogAlert("Artifact Lost", "The alien artifact has been lost in the wreckage of your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ArtifactRelinquished:
                dr = (new DialogAlert("Artifact Relinquished", "The aliens take the artifact from you.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case CargoIF:
                dr = (new DialogAlert("Not Enough Money", "You don't have enough money to spend on any of these goods.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case CargoNoEmptyBays:
                dr = (new DialogAlert("No Empty Bays", "You don't have any empty cargo holds available at the moment",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case CargoNoneAvailable:
                dr = (new DialogAlert("Nothing Available", "None of these goods are available.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case CargoNoneToSell:
                dr = (new DialogAlert("None To ^1", "You have none of these goods in your cargo bays.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case CargoNotInterested:
                dr = (new DialogAlert("Not Interested", "Nobody in this system is interested in buying these goods.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case CargoNotSold:
                dr = (new DialogAlert("Not Available", "That item is not available in this system.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ChartJump:
                dr = (new DialogAlert("Use Singularity?", "Do you wish to use the Portable Singularity to transport immediately to ^1?",
                        "Use Singularity", DialogResult.Yes, "Don't use it", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case ChartJumpCurrent:
                dr = (new DialogAlert("Cannot Jump", "You are tracking the system where you are currently located. It's useless to jump to your current location.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ChartJumpNoSystemSelected:
                dr = (new DialogAlert("No System Selected", "To use the Portable Singularity, track a system before clicking on this button.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ChartTrackSystem:
                dr = (new DialogAlert("Track System?", "^1?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case ChartWormholeUnreachable:
                dr = (new DialogAlert("Wormhole Unreachable", "The wormhole to ^1 is only accessible from ^2.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case Cheater:
                dr = (new DialogAlert("Cheater!", "Cheaters never prosper! (Well, not with that command, anyway.)",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case CrewFireMercenary:
                dr = (new DialogAlert("Fire Mercenary", "Are you sure you wish to fire ^1?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case CrewNoQuarters:
                dr = (new DialogAlert("No Quarters Available", "You do not have any crew quarters available for ^1.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case DebtNoBuy:
                dr = (new DialogAlert("You Have A Debt", "You can't buy that as long as you have debts.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case DebtNone:
                dr = (new DialogAlert("No Debt", "You have no debts.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case DebtReminder:
                dr = (new DialogAlert("Loan Notification", "The Bank's Loan Officer reminds you that your debt continues to accrue interest. You currently owe ^1.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case DebtTooLargeGrounded:
                dr = (new DialogAlert("Large Debt", "Your debt is too large.  You are not allowed to leave this system until your debt is lowered.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case DebtTooLargeLoan:
                dr = (new DialogAlert("Debt Too High", "Your debt is too high to get another loan.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case DebtTooLargeTrade:
                dr = (new DialogAlert("Large Debt", "Your debt is too large.  Nobody will trade with you.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case DebtWarning:
                dr = (new DialogAlert("Warning: Large Debt", "Your debt is getting too large. Reduce it quickly or your ship will be put on a chain!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case Egg:
                dr = (new DialogAlert("Egg", "Congratulations! An eccentric Easter Bunny decides to exchange your trade goods for a special present!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterAliensSurrender:
                dr = (new DialogAlert("Surrender", "If you surrender to the aliens, they will take the artifact. Are you sure you wish to do that?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterArrested:
                dr = (new DialogAlert("Arrested", "You are arrested and taken to the space station, where you are brought before a court of law.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterAttackCaptain:
                dr = (new DialogAlert("Really Attack?", "Famous Captains get famous by, among other things, destroying everyone who attacks them. Do you really want to attack?",
                        "Really Attack", DialogResult.Yes, "OK, I Won't", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterAttackNoDisruptors:
                dr = (new DialogAlert("No Disabling Weapons", "You have no disabling weapons! You would only be able to destroy your opponent, which would defeat the purpose of your quest.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterAttackNoLasers:
                dr = (new DialogAlert("No Hull-Damaging Weapons", "You only have disabling weapons, but your opponent cannot be disabled!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterAttackNoWeapons:
                dr = (new DialogAlert("No Weapons", "You can't attack without weapons!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterAttackPolice:
                dr = (new DialogAlert("Attack Police", "Are you sure you wish to attack the police? This will turn you into a criminal!",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterAttackTrader:
                dr = (new DialogAlert("Attack Trader", "Are you sure you wish to attack the trader? This will immediately set your police record to dubious!",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterBothDestroyed:
                dr = (new DialogAlert("Both Destroyed", "You and your opponent have managed to destroy each other.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterDisabledOpponent:
                dr = (new DialogAlert("Opponent Disabled", "You have disabled your opponent. Without life support they'll have to hibernate. You notify Space Corps, and they come and tow the ^1 to the planet, where the crew is revived and then arrested. ^2",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterDrinkContents:
                dr = (new DialogAlert("Drink Contents?", "You have come across an extremely rare bottle of Captain Marmoset's Amazing Skill Tonic! The \"use-by\" date is illegible, but might still be good. Would you like to drink it?",
                        "Yes, Drink It", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterDumpAll:
                dr = (new DialogAlert("Dump All?", "You paid ^1 credits for these items. Are you sure you want to just dump them?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterDumpWarning:
                Game.getCurrentGame().setLitterWarning(true);
                dr = (new DialogAlert("Space Littering", "Dumping cargo in space is considered littering. If the police find your dumped goods and track them to you, this will influence your record. Do you really wish to dump?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterEscaped:
                dr = (new DialogAlert("Escaped", "You have managed to escape your opponent.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterEscapedHit:
                dr = (new DialogAlert("You Escaped", "You got hit, but still managed to escape.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterEscapePodActivated:
                dr = (new DialogAlert("Escape Pod Activated", "Just before the final demise of your ship, your escape pod activates and ejects you. After a few days, Space Corps pictureks you up and drops you off at a nearby space port.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterLooting:
                dr = (new DialogAlert("Looting", "The pirates board your ship and transfer as much of your cargo to their own ship as their cargo bays can hold.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterMarieCeleste:
                dr = (new DialogAlert("Engage Marie Celeste", "The ship is empty: there is nothing in the ship's log, but the crew has vanished, leaving food on the tables and cargo in the holds. Do you wish to offload the cargo to your own hold?",
                        "Yes, Take Cargo", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterMarieCelesteNoBribe:
                dr = (new DialogAlert("No Bribe", "We would love to take your money, but Space Command already knows you've got illegal goods onboard.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterOpponentEscaped:
                dr = (new DialogAlert("Opponent Escaped", "Your opponent has managed to escape.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPiratesBounty:
                dr = (new DialogAlert("Bounty", "You ^1 the pirate ship^2 and earned a bounty of ^3.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPiratesExamineReactor:
                dr = (new DialogAlert("Pirates Examine Reactor", "The pirates poke around the Ion Reactor while trying to figure out if it is valuable. They finally conclude that the Reactor is worthless, not to mention dangerous, and leave it on your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPiratesFindNoCargo:
                dr = (new DialogAlert("Pirates Find No Cargo", "The pirates are very angry that they find no cargo on your ship. To stop them from destroying you, you have no choice but to pay them an amount equal to 5% of your current worth - ^1.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPiratesSurrenderPrincess:
                dr = (new DialogAlert("You Have the Princess", "Pirates are not nice people, and there's no telling what they might do to the Princess. Better to die fighting than give her up to them!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPiratesTakeSculpture:
                dr = (new DialogAlert("Pirates Take Sculpture", "As the pirates ransack your ship, they find the stolen sculpture. \"This is worth thousands!\" one pirate exclaims, as he stuffs it into his pack.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceBribe:
                dr = (new DialogAlert("Bribe", "These police officers are willing to forego inspection for the amount of ^1.",
                        "Offer Bribe", DialogResult.Yes, "Forget It", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceBribeCant:
                dr = (new DialogAlert("No Bribe", "These police officers can't be bribed.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceBribeLowCash:
                dr = (new DialogAlert("Not Enough Cash", "You don't have enough cash for a bribe.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceFine:
                dr = (new DialogAlert("Caught", "The police discovers illegal goods in your cargo holds. These goods impounded and you are fined ^1 credits.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceNothingFound:
                dr = (new DialogAlert("Nothing Found", "The police find nothing illegal in your cargo holds, and apologize for the inconvenience.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceNothingIllegal:
                dr = (new DialogAlert("You Have Nothing Illegal", "Are you sure you want to do that? You are not carrying illegal goods, so you have nothing to fear!",
                        "Yes, I still want to", DialogResult.Yes, "OK, I won't", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceSubmit:
                dr = (new DialogAlert("You Have Illegal Goods", "Are you sure you want to let the police search you? You are carrying ^1! ^2",
                        "Yes, let them", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterPoliceSurrender:
                dr = (new DialogAlert("Surrender", "^1If you surrender, you will spend some time in prison and will have to pay a hefty fine. ^2Are you sure you want to do that?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterPostMarie:
                dr = (new DialogAlert("Contraband Removed", "The Customs Police confiscated all of your illegal cargo, but since you were cooperative, you avoided stronger fines or penalties.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterPostMarieFlee:
                dr = (new DialogAlert("Criminal Act!", "Are you sure you want to do that? The Customs Police know you have engaged in criminal activity, and will report it!",
                        "Yes, I still want to", DialogResult.Yes, "OK, I won't", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterScoop:
                dr = (new DialogAlert("Scoop Canister", "A canister from the destroyed ship, labeled ^1, drifts within range of your scoops.",
                        "Pick It Up", DialogResult.Yes, "Let It Go", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterScoopNoRoom:
                dr = (new DialogAlert("No Room To Scoop", "You don't have any room in your cargo holds. Do you wish to jettison goods to make room, or just let it go.",
                        "Make Room", DialogResult.Yes, "Let it go", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EncounterScoopNoScoop:
                dr = (new DialogAlert("No Scoop", "You regret finding nothing in your holds that can be dumped, and let the canister go.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterSurrenderRefused:
                dr = (new DialogAlert("To The Death!", "Surrender? Hah! We want your HEAD!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterTonicConsumedGood:
                dr = (new DialogAlert("Tonic Consumed", "Mmmmm. Captain Marmoset's Amazing Skill Tonic not only fills you with energy, but tastes like a fine single-malt." + Strings.newline,
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterTonicConsumedStrange:
                dr = (new DialogAlert("Tonic Consumed", "While you don't know what it was supposed to taste like, you get the feeling that this dose of tonic was a bit off.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterTradeCompleted:
                dr = (new DialogAlert("Trade Completed", "Thanks for ^1 the ^2. It's been a pleasure doing business with you.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterYouLose:
                dr = (new DialogAlert("You Lose", "Your ship has been destroyed by your opponent.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EncounterYouWin:
                dr = (new DialogAlert("You Win", "You have destroyed your opponent.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentAlreadyOwn:
                dr = (new DialogAlert("You Already Have One", "It's not useful to buy more than one of this item.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentBuy:
                dr = (new DialogAlert("Buy ^1", "Do you wish to buy this item for ^2 credits?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EquipmentEscapePod:
                dr = (new DialogAlert("Escape Pod", "Do you want to buy an escape pod for 2000 credits?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case EquipmentExtraBaysInUse:
                dr = (new DialogAlert("Cargo Bays Full", "The extra cargo bays are still filled with goods. You can only sell them when they're empty.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentFuelCompactor:
                dr = (new DialogAlert("Fuel Compactor", "You now have a fuel compactor installed on your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentHiddenCompartments:
                dr = (new DialogAlert("Hidden Compartments", "You now have hidden compartments equivalent to 5 extra cargo bays installed in your ship. Police won't find illegal cargo hidden in these compartments.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentIF:
                dr = (new DialogAlert("Not Enough Money", "You don't have enough money to spend on this item.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentLightningShield:
                dr = (new DialogAlert("Lightning Shield", "You now have one lightning shield installed on your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentMorgansLaser:
                dr = (new DialogAlert("Morgan's Laser", "You now have Henry Morgan's special laser installed on your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentNotEnoughSlots:
                dr = (new DialogAlert("Not Enough Slots", "You have already filled all of your available slots for this type of item.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentQuantumDisruptor:
                dr = (new DialogAlert("Quantum Disruptor", "You now have one quantum disruptor installed on your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case EquipmentSell:
                dr = (new DialogAlert("Sell Item", "Are you sure you want to sell this item?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case FileErrorOpen:
                dr = (new DialogAlert("Error", "An error occurrentred while trying to open ^1." + Strings.newline + Strings.newline + "^2",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case FileErrorSave:
                dr = (new DialogAlert("Error", "An error occurrentred while trying to save ^1." + Strings.newline + Strings.newline + "^2",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case FleaBuilt:
                dr = (new DialogAlert("Flea Built", "In 3 days and with 500 credits, you manage to convert your pod into a Flea.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case GameAbandonConfirm:
                dr = (new DialogAlert("Are You Sure?", "Are you sure you want to abandon your current game?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case GameClearHighScores:
                dr = (new DialogAlert("Clear High Scores", "Are you sure you wish to clear the high score table?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case GameEndBoughtMoon:
                (new DialogAlert("You Have Retired", GameEndType.BoughtMoon.getId())).ShowDialog(wp);
                break;
            case GameEndBoughtMoonGirl:
                (new DialogAlert("You Have Retired with the Princess", GameEndType.BoughtMoonGirl.getId())).ShowDialog(wp);
                break;
            case GameEndHighScoreAchieved:
                dr = (new DialogAlert("Congratulations!", "You have made the high-score list!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case GameEndHighScoreCheat:
                dr = (new DialogAlert("Naughy, Naughty!", "You would have made the high-score list if you weren't a Cheat!.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case GameEndHighScoreMissed:
                dr = (new DialogAlert("Sorry", "Alas! This is not enough to enter the high-score list.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case GameEndKilled:
                (new DialogAlert("You Are Dead", GameEndType.Killed.getId())).ShowDialog(wp);
                break;
            case GameEndRetired:
                (new DialogAlert("You Have Retired", GameEndType.Retired.getId())).ShowDialog(wp);
                break;
            case GameEndScore:
                dr = (new DialogAlert("Score", "You achieved a score of ^1.^2%.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case GameRetire:
                dr = (new DialogAlert("Retire", "Are you sure you wish to retire?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case InsuranceNoEscapePod:
                dr = (new DialogAlert("No Escape Pod", "Insurance isn't useful for you, since you don't have an escape pod.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case InsurancePayoff:
                dr = (new DialogAlert("Insurance", "Since your ship was insured, the bank pays you the total worth of the destroyed ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case InsuranceStop:
                dr = (new DialogAlert("Stop Insurance", "Do you really wish to stop your insurance and lose your no-claim?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case JailConvicted:
                dr = (new DialogAlert("Convicted", "You are convicted to ^1 in prison and a fine of ^2.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case JailFleaReceived:
                dr = (new DialogAlert("Flea Received", "When you leave prison, the police have left a second-hand Flea for you so you can continue your travels.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case JailHiddenCargoBaysRemoved:
                dr = (new DialogAlert("Hidden Compartments Removed", "When your ship is impounded, the police go over it with a fine-tooth comb. Your hidden compartments are found and removed.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case JailIllegalGoodsImpounded:
                dr = (new DialogAlert("Illegal Goods Impounded", "The police also impound all of the illegal goods you have on board.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case JailInsuranceLost:
                dr = (new DialogAlert("Insurance Lost", "Since you cannot pay your insurance while you're in prison, it is retracted.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case JailMercenariesLeave:
                dr = (new DialogAlert("Mercenaries Leave", "Any mercenaries who were traveling with you have left.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case JailShipSold:
                dr = (new DialogAlert("Ship Sold", "Because you don't have the credits to pay your fine, your ship is sold.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case JarekTakenHome:
                dr = (new DialogAlert("Jarek Taken Home", "The Space Corps decides to give ambassador Jarek a lift home to Devidia.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case LeavingIFInsurance:
                dr = (new DialogAlert("Not Enough Money", "You don't have enough cash to pay for your insurance.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case LeavingIFMercenaries:
                dr = (new DialogAlert("Pay Mercenaries", "You don't have enough cash to pay your mercenaries to come with you on this trip. Fire them or make sure you have enough cash.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case LeavingIFWormholeTax:
                dr = (new DialogAlert("Wormhole Tax", "You don't have enough money to pay for the wormhole tax.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case MeetCaptainAhab:
                dr = (new DialogAlert("Meet Captain Ahab", "Captain Ahab is in need of a spare shield for an upcoming mission. He offers to trade you some piloting lessons for your reflective shield. Do you wish to trade?",
                        "Yes, Trade Shield", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case MeetCaptainConrad:
                dr = (new DialogAlert("Meet Captain Conrad", "Captain Conrad is in need of a military laser. She offers to trade you some engineering training for your military laser. Do you wish to trade?",
                        "Yes, Trade Laser", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case MeetCaptainHuie:
                dr = (new DialogAlert("Meet Captain Huie", "Captain Huie is in need of a military laser. She offers to exchange some bargaining training for your military laser. Do you wish to trade?",
                        "Yes, Trade Laser", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case NewGameConfirm:
                dr = (new DialogAlert("New Game", "Are you sure you wish to start a new game?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case NewGameMoreSkillPoints:
                dr = (new DialogAlert("More Skill Points", "You haven't awarded all 20 skill points yet.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case PreciousHidden:
                dr = (new DialogAlert("Precious Cargo Hidden", "You quickly hide ^1 in your hidden cargo bays before the pirates board your ship. This would never work with the police, but pirates are usually in more of a hurry.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case PrincessTakenHome:
                dr = (new DialogAlert("Princess Taken Home", "The Space Corps decides to give the Princess a ride home to Galvon since you obviously weren't up to the task.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ReactorConfiscated:
                dr = (new DialogAlert("Police Confiscate Reactor", "The Police confiscate the Ion reactor as evidence of your dealings with unsavory characters.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ReactorDestroyed:
                dr = (new DialogAlert("Reactor Destroyed", "The destruction of your ship was made much more spectacular by the added explosion of the Ion Reactor.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ReactorOnBoard:
                dr = (new DialogAlert("Reactor", "Five of your cargo bays now contain the unstable Ion Reactor, and ten of your bays contain enriched fuel.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ReactorMeltdown:
                dr = (new DialogAlert("Reactor Meltdown!", "Just as you approach the docking bay, the reactor explodes into a huge radioactive fireball!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ReactorWarningFuel:
                dr = (new DialogAlert("Reactor Warning", "You notice the Ion Reactor has begun to consume fuel rapidly. In a single day, it has burned up nearly half a bay of fuel!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ReactorWarningFuelGone:
                dr = (new DialogAlert("Reactor Warning", "The Ion Reactor is emitting a shrill whine, and it's shaking. The display indicates that it is suffering from fuel starvation.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ReactorWarningTemp:
                dr = (new DialogAlert("Reactor Warning", "The Ion Reactor is smoking and making loud noises. The display warns that the core is close to the melting temperature.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case RegistryError:
                dr = (new DialogAlert("Error...", "Error accessing the Registry: ^1",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SculptureConfiscated:
                dr = (new DialogAlert("Police Confiscate Sculpture", "The Police confiscate the stolen sculpture and return it to its rightful owner.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SculptureSaved:
                dr = (new DialogAlert("Sculpture Saved", "On your way to the escape pod, you grab the stolen sculpture. Oh well, at least you saved something.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyConfirm:
                dr = (new DialogAlert("Buy New Ship", "Are you sure you wish to trade in your ^1 for a new ^2^3?",
                        "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case ShipBuyCrewQuarters:
                dr = (new DialogAlert("Too Many Crewmembers", "The new ship you pictureked doesn't have enough quarters for all of your crewmembers. First you will have to fire one or more of them.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyIF:
                dr = (new DialogAlert("Not Enough Money", "You don't have enough money to buy this ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyIFTransfer:
                dr = (new DialogAlert("Not Enough Money", "You won't have enough money to buy this ship and pay the cost to transfer all of your unique equipment. You should choose carefully which items you wish to transfer!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyNoSlots:
                dr = (new DialogAlert("Can't Transfer Item", "If you trade your ship in for a ^1, you won't be able to transfer your ^2 because the new ship has insufficient ^3 slots!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyNotAvailable:
                dr = (new DialogAlert("Ship Not Available", "That type of ship is not available in the current system.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyNoTransfer:
                dr = (new DialogAlert("Can't Transfer Item", "Unfortunately, if you make this trade, you won't be able to afford to transfer your ^1 to the new ship!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyPassengerQuarters:
                dr = (new DialogAlert("Passenger Needs Quarters", "You must get a ship with enough crew quarters so that ^1 can stay on board.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyReactor:
                dr = (new DialogAlert("Shipyard Engineer", "Sorry! We can't take your ship as a trade-in. That Ion Reactor looks dangerous, and we have no way of removing it. Come back when you've gotten rid of it.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipBuyTransfer:
                dr = (new DialogAlert("Transfer ^1", "I'll transfer your ^2 to your new ship for ^3 credits.",
                        "Do it!", DialogResult.Yes, "No thanks", DialogResult.No, ss)).ShowDialog(wp);
                break;
            case ShipDesignIF:
                dr = (new DialogAlert("Not Enough Money", "You don't have enough money to create this design.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipDesignThanks:
                dr = (new DialogAlert("Thank you!", "^1 thanks you for your business!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case ShipHullUpgraded:
                dr = (new DialogAlert("Hull Upgraded", "Technicians spend the day retrofitting the hull of your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialCleanRecord:
                dr = (new DialogAlert("Clean Record", "The hacker resets your police record to Clean.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialExperimentPerformed:
                dr = (new DialogAlert("Experiment Performed", "The galaxy is abuzz with news of a terrible malfunction in Dr. Fehler's laboratory. Evidently, he was not warned in time and he performed his experiment ... with disastrous results!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialIF:
                dr = (new DialogAlert("Not Enough Money", "You don't have enough cash to spend to accept this offer.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialMoonBought:
                dr = (new DialogAlert("Moon Bought", "You bought a moon in the Utopia system. Go there to claim it.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialNoQuarters:
                dr = (new DialogAlert("No Free Quarters", "There are currently no free crew quarters on your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialNotEnoughBays:
                dr = (new DialogAlert("Not Enough Bays", "You don't have enough empty cargo bays at the moment.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialPassengerConcernedJarek:
                dr = (new DialogAlert("Ship's Comm.", "Commander? Jarek here. Do you require any assistance in charting a course to Devidia?",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialPassengerConcernedPrincess:
                dr = (new DialogAlert("Ship's Comm.", "[Ziyal] Oh Captain? (giggles) Would it help if I got out and pushed?",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialPassengerConcernedWild:
                dr = (new DialogAlert("Ship's Comm.", "Bridge? This is Jonathan. Are we there yet? Heh, heh. Sorry, I couldn't resist.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialPassengerImpatientJarek:
                dr = (new DialogAlert("Ship's Comm.", "Captain! This is the Ambassador speaking. We should have been there by now?!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialPassengerImpatientPrincess:
                dr = (new DialogAlert("Ship's Comm.", "Sir! Are you taking me home or merely taking the place of my previous captors?!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialPassengerImpatientWild:
                dr = (new DialogAlert("Ship's Comm.", "Commander! Wild here. What's taking us so long?!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialPassengerOnBoard:
                dr = (new DialogAlert("Passenger On Board", "You have taken ^1 on board. While on board ^1 will lend you expertise, but may stop helping if the journey takes too long.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialSealedCanisters:
                dr = (new DialogAlert("Sealed Canisters", "You bought the sealed canisters and put them in your cargo bays.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialSkillIncrease:
                dr = (new DialogAlert("Skill Increase", "The alien increases one of your skills.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialSpacetimeFabricRip:
                dr = (new DialogAlert("Spacetime Fabric Rip", "You have flown through a tear in the spacetime continuum caused by Dr. Fehler's failed experiment. You may not have reached your planned destination!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case SpecialTrainingCompleted:
                dr = (new DialogAlert("Training Completed", "After a few hours of training with a top expert, you feel your abilities have improved significantly.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TravelArrival:
                dr = (new DialogAlert("Arrival", "You arrive at your destination.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TravelUneventfulTrip:
                dr = (new DialogAlert("Uneventful Trip", "After an uneventful trip, you arrive at your destination.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesAllDied:
                dr = (new DialogAlert("All The Tribbles Died", "The radiation from the Ion Reactor is deadly to Tribbles. All of the Tribbles on board your ship have died.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesAteFood:
                dr = (new DialogAlert("Tribbles Ate Food", "You find that, instead of food, some of your cargo bays contain only tribbles!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesGone:
                dr = (new DialogAlert("No More Tribbles", "The alien uses his alien technology to beam over your whole collection of tribbles to his ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesHalfDied:
                dr = (new DialogAlert("Half The Tribbles Died", "The radiation from the Ion Reactor seems to be deadly to Tribbles. Half the Tribbles on board died.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesKilled:
                dr = (new DialogAlert("Tribbles Killed", "Your tribbles all died in the explosion.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesMostDied:
                dr = (new DialogAlert("Most Tribbles Died", "You find that, instead of narcotics, some of your cargo bays contain only dead tribbles!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesOwn:
                dr = (new DialogAlert("A Tribble", "You are now the proud owner of a little, cute, furry tribble.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesRemoved:
                dr = (new DialogAlert("Tribbles Removed", "The tribbles were sold with your ship.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesInspector:
                dr = (new DialogAlert("Space Port Inspector", "Our scan reports you have ^1 tribbles on board your ship. Tribbles are pests worse than locusts! You are running the risk of getting a hefty fine!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesSqueek:
                dr = (new DialogAlert("A Tribble", "Squeek!",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case TribblesTradeIn:
                dr = (new DialogAlert("You've Got Tribbles", "Hm. I see you got a tribble infestation on your current ship. I'm sorry, but that severely reduces the trade-in price.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildArrested:
                dr = (new DialogAlert("Wild Arrested", "Jonathan Wild is arrested, and taken away to stand trial.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildChatsPirates:
                dr = (new DialogAlert("Wild Chats With Pirates", "The Pirate Captain turns out to be an old associate of Jonathan Wild's. They talk about old times, and you get the feeling that Wild would switch ships if the Pirates had any quarters available.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildGoesPirates:
                dr = (new DialogAlert("Wild Goes With Pirates", "The Pirate Captain turns out to be an old associate of Jonathan Wild's, and invites him to go to Kravat aboard the Pirate ship. Wild accepts the offer and thanks you for the ride.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildLeavesShip:
                dr = (new DialogAlert("Wild Leaves Ship", "Jonathan Wild leaves your ship, and goes into hiding on ^1.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildSculpture:
                dr = (new DialogAlert("Wild Eyes Sculpture", "Jonathan Wild sees the stolen sculpture. \"Wow, I only know of one of these left in the whole Universe!\" he exclaims, \"Geurge Locas must be beside himself with it being stolen.\" He seems very impressed with you, which makes you feel much better about the item your delivering.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildWontBoardLaser:
                dr = (new DialogAlert("Wild Won't Board Ship", "Jonathan Wild isn't willing to go with you if you're not armed with at least a Beam Laser. He'd rather take his chances hiding out here." + Strings.newline,
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildWontBoardReactor:
                dr = (new DialogAlert("Wild Won't Board Ship", "Jonathan Wild doesn't like the looks of that Ion Reactor. He thinks it's too dangerous, and won't get on board.",
                        "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
                break;
            case WildWontStayAboardLaser:
                dr = (new DialogAlert("Wild Won't Stay Aboard", "Jonathan Wild isn't about to go with you if you're not armed with at least a Beam Laser. He'd rather take his chances hiding out here on ^1." + Strings.newline,
                        "Say Goodbye to Wild", DialogResult.OK, "Cancel", DialogResult.Cancel, ss)).ShowDialog(wp);
                break;
            case WildWontStayAboardReactor:
                dr = (new DialogAlert("Wild Won't Stay Aboard", "Jonathan Wild isn't willing to go with you if you bring that Reactor on board. He'd rather take his chances hiding out here on ^1." + Strings.newline,
                        "Say Goodbye to Wild", DialogResult.OK, "Cancel", DialogResult.Cancel, ss)).ShowDialog(wp);
                break;
        }
        return dr;
    }

    private void FormAlert_Click(Object sender, EventData e) {
        // If the button is off-screen, this is an image and can be clicked away.
        if (0 > button1.getLeft()) {
            Close();
        }
    }

    private void timerTick_Tick() {
        Close();
    }
}
