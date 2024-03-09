package spacetrader.gui;
import jwinforms.Button;
import jwinforms.Container;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.FormSize;
import jwinforms.Graphics;
import jwinforms.IContainer;
import jwinforms.ImageList;
import jwinforms.ImageListStreamer;
import jwinforms.Label;
import jwinforms.ResourceManager;
import jwinforms.SizeF;
import jwinforms.Timer;
import jwinforms.WinformForm;
import jwinforms.WinformPane;
import jwinforms.enums.ColorDepth;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;
import spacetrader.Functions;
import spacetrader.Game;
import spacetrader.Strings;
import spacetrader.enums.AlertType;
import spacetrader.enums.GameEndType;


public class FormAlert extends WinformForm {
  private static final String _80_CHARS = "01234567890123456789012345678901234567890123456789012345678901234567890123456789";
  private static final int SPLASH_INDEX = 4;
  private Button btn1;
  private Button btn2;
  private ImageList ilImages;
  private Label lblText;
  private Timer tmrTick;
  private IContainer components;

  private FormAlert() {
    InitializeComponent();
  }

  public FormAlert(String title, String text, String button1Text, DialogResult button1Result, String button2Text, DialogResult button2Result, String[] args) {
    this();
    Graphics g = CreateGraphics();
    // Replace any variables.
    if(args != null) {
      title = Functions.StringVars(title, args);
      text = Functions.StringVars(text, args);
    }
    lblText.setWidth(g.MeasureString((text.length() > 80 ? _80_CHARS : text), getFont()).width + 25);
    lblText.setText(text);
    lblText.setHeight(30 + 30 * text.length() / 80);
    // Size the buttons.
    btn1.setText(button1Text);
    btn1.setDialogResult(button1Result);
    btn1.setWidth(Math.max(40, g.MeasureString(btn1.getText(), getFont()).width + 35));
    int btnWidth = btn1.getWidth();
    if(button2Text != null) {
      btn2.setText(button2Text);
      btn2.setWidth(Math.max((int)Math.ceil(g.MeasureString(btn2.getText(), getFont()).width) + 10, 40));
      btn2.setVisible(true);
      btn2.setDialogResult(button2Result);
      btnWidth += btn2.getWidth() + 6;
    }
    // Size the form.
    setWidth(Math.max(btnWidth, lblText.getWidth()) + 16);
    setHeight(lblText.getHeight() + 75);
    // Locate the controls.
    lblText.setLeft((getWidth() - lblText.getWidth()) / 2);
    btn1.setTop(lblText.getHeight() + 19);
    btn1.setLeft((getWidth() - btnWidth) / 2);
    btn2.setTop(btn1.getTop());
    btn2.setLeft(btn1.getLeft() + btn1.getWidth() + 6);
    // Set the title.
    setText(title);
  }

  public FormAlert(String title, int imageIndex) {
    this();
    // Make sure the extra controls are hidden.
    lblText.setVisible(false);
    btn2.setVisible(false);
    // Move btn1 off-screen.
    btn1.setLeft(-btn1.getWidth());
    btn1.setTop(-btn1.getHeight());
    setAcceptButton(btn1);
    setCancelButton(btn1);
    // Set the background image.
    setBackgroundImage(ilImages.getImages()[imageIndex]);
    setClientSize((new SizeF(getBackgroundImage().getWidth(), getBackgroundImage().getHeight())));
    // Set the title.
    setText(title);
    // If this is the splash screen, get rid of the title bar and start the timer.
    if(imageIndex == SPLASH_INDEX) {
      setFormBorderStyle(FormBorderStyle.None);
      tmrTick.Start();
    }
  }

  private void FormAlert_Click(Object sender, EventArgs e) {
    // If the button is off-screen, this is an image and can be clicked away.
    if(btn1.getLeft() < 0) {
      Close();
    }
  }

  private void InitializeComponent() {
    // Required method for Designer support - do not modify the contents of this method with the code editor.
    components = new Container();
    ResourceManager resources = new ResourceManager(FormAlert.class);
    lblText = new Label();
    btn1 = new Button();
    btn2 = new Button();
    ilImages = new ImageList(components);
    tmrTick = new Timer(components);
    SuspendLayout();
    // lblText
    lblText.setLocation(new java.awt.Point(8, 8));
    lblText.setName("lblText");
    lblText.setTabIndex(3);
    lblText.setText("X");
    // btn1
    btn1.setDialogResult(DialogResult.OK);
    btn1.setFlatStyle(FlatStyle.Flat);
    btn1.setLocation(new java.awt.Point(115, 32));
    btn1.setName("btn1");
    btn1.setSize(new FormSize(40, 22));
    btn1.setTabIndex(1);
    btn1.setText("Ok");
    // btn2
    btn2.setDialogResult(DialogResult.No);
    btn2.setFlatStyle(FlatStyle.Flat);
    btn2.setLocation(new java.awt.Point(200, 32));
    btn2.setName("btn2");
    btn2.setSize(new FormSize(40, 22));
    btn2.setTabIndex(2);
    btn2.setText("No");
    btn2.setVisible(false);
    // ilImages
    ilImages.ColorDepth = ColorDepth.Depth24Bit;
    ilImages.setImageSize(new FormSize(160, 160));
    ilImages.setImageStream(((ImageListStreamer)(resources.GetObject("ilImages.ImageStream"))));
    ilImages.setTransparentColor(null);
    // tmrTick
    tmrTick.setInterval(4000);
    tmrTick.Tick = new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        tmrTick_Tick();
      }
    };
    // FormAlert
    setAutoScaleBaseSize(new FormSize(5, 13));
    setClientSize(new FormSize(270, 63));
    setControlBox(false);
    Controls.add(btn2);
    Controls.add(btn1);
    Controls.add(lblText);
    setFormBorderStyle(FormBorderStyle.FixedDialog);
    setName("FormAlert");
    setShowInTaskbar(false);
    setStartPosition(FormStartPosition.CenterParent);
    setText("Title");
    setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        FormAlert_Click(sender, e);
      }
    });
    ResumeLayout(false);
  }

  private void tmrTick_Tick() {
    Close();
  }

  public static DialogResult Alert(AlertType at, WinformPane wp) {
    return Alert(at, wp, new String[]{});
  }

  public static DialogResult Alert(AlertType at, WinformPane wp, String s) {
    return Alert(at, wp, new String[]{s});
  }

  public static DialogResult Alert(AlertType at, WinformPane wp, String s, String t) {
    return Alert(at, wp, new String[]{s, t});
  }

  public static DialogResult Alert(AlertType at, WinformPane wp, String s, String t, String u) {
    return Alert(at, wp, new String[]{s, t, u});
  }

  public static DialogResult Alert(AlertType at, WinformPane wp, String[] ss) {
    DialogResult dr = DialogResult.None;
    if(ss.length == 0) {
      ss = null;
    }
    switch(at) {
      case Alert:
        dr = (new FormAlert("^1", "^2", "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case AntidoteOnBoard:
        dr = (new FormAlert("Antidote", "Ten of your cargo bays now contain antidote for the Japori system.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case AntidoteDestroyed:
        dr = (new FormAlert("Antidote Destroyed", "The antidote for the Japori system has been destroyed with your ship. You should return to ^1 and get some more.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case AntidoteTaken:
        dr = (new FormAlert("Antidote Taken", "The Space Corps removed the antidote for Japori from your ship and delivered it, fulfilling your assignment.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case AppStart:
        (new FormAlert("Space Trader for Windows", SPLASH_INDEX)).ShowDialog(wp);
        break;
      case ArrivalBuyNewspaper:
        dr = (new FormAlert("Buy Newspaper?", "The local newspaper costs ^1. Do you wish to buy a copy?",
            "Buy Newspaper", DialogResult.Yes, "Cancel", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case ArrivalIFFuel:
        dr = (new FormAlert("No Full Tanks", "You do not have enough money to buy full tanks.", "Ok",
            DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ArrivalIFFuelRepairs:
        dr = (new FormAlert("Not Enough Money", "You don't have enough money to get a full tank or full hull repairs.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ArrivalIFNewspaper:
        dr = (new FormAlert("Can't Afford it!", "Sorry! A newspaper costs ^1 in this system. You don't have enough money!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ArrivalIFRepairs:
        dr = (new FormAlert("No Full Repairs", "You don't have enough money to get your hull fully repaired.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ArtifactLost:
        dr = (new FormAlert("Artifact Lost", "The alien artifact has been lost in the wreckage of your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ArtifactRelinquished:
        dr = (new FormAlert("Artifact Relinquished", "The aliens take the artifact from you.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case CargoIF:
        dr = (new FormAlert("Not Enough Money", "You don't have enough money to spend on any of these goods.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case CargoNoEmptyBays:
        dr = (new FormAlert("No Empty Bays", "You don't have any empty cargo holds available at the moment",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case CargoNoneAvailable:
        dr = (new FormAlert("Nothing Available", "None of these goods are available.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case CargoNoneToSell:
        dr = (new FormAlert("None To ^1", "You have none of these goods in your cargo bays.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case CargoNotInterested:
        dr = (new FormAlert("Not Interested", "Nobody in this system is interested in buying these goods.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case CargoNotSold:
        dr = (new FormAlert("Not Available", "That item is not available in this system.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ChartJump:
        dr = (new FormAlert("Use Singularity?", "Do you wish to use the Portable Singularity to transport immediately to ^1?",
            "Use Singularity", DialogResult.Yes, "Don't use it", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case ChartJumpCurrent:
        dr = (new FormAlert("Cannot Jump", "You are tracking the system where you are currently located. It's useless to jump to your current location.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ChartJumpNoSystemSelected:
        dr = (new FormAlert("No System Selected", "To use the Portable Singularity, track a system before clicking on this button.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ChartTrackSystem:
        dr = (new FormAlert("Track System?", "^1?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case ChartWormholeUnreachable:
        dr = (new FormAlert("Wormhole Unreachable", "The wormhole to ^1 is only accessible from ^2.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case Cheater:
        dr = (new FormAlert("Cheater!", "Cheaters never prosper! (Well, not with that command, anyway.)",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case CrewFireMercenary:
        dr = (new FormAlert("Fire Mercenary", "Are you sure you wish to fire ^1?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case CrewNoQuarters:
        dr = (new FormAlert("No Quarters Available", "You do not have any crew quarters available for ^1.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case DebtNoBuy:
        dr = (new FormAlert("You Have A Debt", "You can't buy that as long as you have debts.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case DebtNone:
        dr = (new FormAlert("No Debt", "You have no debts.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case DebtReminder:
        dr = (new FormAlert("Loan Notification", "The Bank's Loan Officer reminds you that your debt continues to accrue interest. You currently owe ^1.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case DebtTooLargeGrounded:
        dr = (new FormAlert("Large Debt", "Your debt is too large.  You are not allowed to leave this system until your debt is lowered.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case DebtTooLargeLoan:
        dr = (new FormAlert("Debt Too High", "Your debt is too high to get another loan.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case DebtTooLargeTrade:
        dr = (new FormAlert("Large Debt", "Your debt is too large.  Nobody will trade with you.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case DebtWarning:
        dr = (new FormAlert("Warning: Large Debt", "Your debt is getting too large. Reduce it quickly or your ship will be put on a chain!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case Egg:
        dr = (new FormAlert("Egg", "Congratulations! An eccentric Easter Bunny decides to exchange your trade goods for a special present!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterAliensSurrender:
        dr = (new FormAlert("Surrender", "If you surrender to the aliens, they will take the artifact. Are you sure you wish to do that?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterArrested:
        dr = (new FormAlert("Arrested", "You are arrested and taken to the space station, where you are brought before a court of law.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterAttackCaptain:
        dr = (new FormAlert("Really Attack?", "Famous Captains get famous by, among other things, destroying everyone who attacks them. Do you really want to attack?",
            "Really Attack", DialogResult.Yes, "OK, I Won't", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterAttackNoDisruptors:
        dr = (new FormAlert("No Disabling Weapons", "You have no disabling weapons! You would only be able to destroy your opponent, which would defeat the purpose of your quest.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterAttackNoLasers:
        dr = (new FormAlert("No Hull-Damaging Weapons", "You only have disabling weapons, but your opponent cannot be disabled!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterAttackNoWeapons:
        dr = (new FormAlert("No Weapons", "You can't attack without weapons!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterAttackPolice:
        dr = (new FormAlert("Attack Police", "Are you sure you wish to attack the police? This will turn you into a criminal!",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterAttackTrader:
        dr = (new FormAlert("Attack Trader", "Are you sure you wish to attack the trader? This will immediately set your police record to dubious!",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterBothDestroyed:
        dr = (new FormAlert("Both Destroyed", "You and your opponent have managed to destroy each other.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterDisabledOpponent:
        dr = (new FormAlert("Opponent Disabled", "You have disabled your opponent. Without life support they'll have to hibernate. You notify Space Corps, and they come and tow the ^1 to the planet, where the crew is revived and then arrested. ^2",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterDrinkContents:
        dr = (new FormAlert("Drink Contents?", "You have come across an extremely rare bottle of Captain Marmoset's Amazing Skill Tonic! The \"use-by\" date is illegible, but might still be good. Would you like to drink it?",
            "Yes, Drink It", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterDumpAll:
        dr = (new FormAlert("Dump All?", "You paid ^1 credits for these items. Are you sure you want to just dump them?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterDumpWarning:
        Game.CurrentGame().setLitterWarning(true);
        dr = (new FormAlert("Space Littering", "Dumping cargo in space is considered littering. If the police find your dumped goods and track them to you, this will influence your record. Do you really wish to dump?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterEscaped:
        dr = (new FormAlert("Escaped", "You have managed to escape your opponent.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterEscapedHit:
        dr = (new FormAlert("You Escaped", "You got hit, but still managed to escape.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterEscapePodActivated:
        dr = (new FormAlert("Escape Pod Activated", "Just before the final demise of your ship, your escape pod activates and ejects you. After a few days, Space Corps picks you up and drops you off at a nearby space port.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterLooting:
        dr = (new FormAlert("Looting", "The pirates board your ship and transfer as much of your cargo to their own ship as their cargo bays can hold.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterMarieCeleste:
        dr = (new FormAlert("Engage Marie Celeste", "The ship is empty: there is nothing in the ship's log, but the crew has vanished, leaving food on the tables and cargo in the holds. Do you wish to offload the cargo to your own hold?",
            "Yes, Take Cargo", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterMarieCelesteNoBribe:
        dr = (new FormAlert("No Bribe", "We would love to take your money, but Space Command already knows you've got illegal goods onboard.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterOpponentEscaped:
        dr = (new FormAlert("Opponent Escaped", "Your opponent has managed to escape.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPiratesBounty:
        dr = (new FormAlert("Bounty", "You ^1 the pirate ship^2 and earned a bounty of ^3.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPiratesExamineReactor:
        dr = (new FormAlert("Pirates Examine Reactor", "The pirates poke around the Ion Reactor while trying to figure out if it is valuable. They finally conclude that the Reactor is worthless, not to mention dangerous, and leave it on your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPiratesFindNoCargo:
        dr = (new FormAlert("Pirates Find No Cargo", "The pirates are very angry that they find no cargo on your ship. To stop them from destroying you, you have no choice but to pay them an amount equal to 5% of your current worth - ^1.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPiratesSurrenderPrincess:
        dr = (new FormAlert("You Have the Princess", "Pirates are not nice people, and there's no telling what they might do to the Princess. Better to die fighting than give her up to them!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPiratesTakeSculpture:
        dr = (new FormAlert("Pirates Take Sculpture", "As the pirates ransack your ship, they find the stolen sculpture. \"This is worth thousands!\" one pirate exclaims, as he stuffs it into his pack.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceBribe:
        dr = (new FormAlert("Bribe", "These police officers are willing to forego inspection for the amount of ^1.",
            "Offer Bribe", DialogResult.Yes, "Forget It", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceBribeCant:
        dr = (new FormAlert("No Bribe", "These police officers can't be bribed.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceBribeLowCash:
        dr = (new FormAlert("Not Enough Cash", "You don't have enough cash for a bribe.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceFine:
        dr = (new FormAlert("Caught", "The police discovers illegal goods in your cargo holds. These goods impounded and you are fined ^1 credits.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceNothingFound:
        dr = (new FormAlert("Nothing Found", "The police find nothing illegal in your cargo holds, and apologize for the inconvenience.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceNothingIllegal:
        dr = (new FormAlert("You Have Nothing Illegal", "Are you sure you want to do that? You are not carrying illegal goods, so you have nothing to fear!",
            "Yes, I still want to", DialogResult.Yes, "OK, I won't", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceSubmit:
        dr = (new FormAlert("You Have Illegal Goods", "Are you sure you want to let the police search you? You are carrying ^1! ^2",
            "Yes, let them", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterPoliceSurrender:
        dr = (new FormAlert("Surrender", "^1If you surrender, you will spend some time in prison and will have to pay a hefty fine. ^2Are you sure you want to do that?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterPostMarie:
        dr = (new FormAlert("Contraband Removed", "The Customs Police confiscated all of your illegal cargo, but since you were cooperative, you avoided stronger fines or penalties.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterPostMarieFlee:
        dr = (new FormAlert("Criminal Act!", "Are you sure you want to do that? The Customs Police know you have engaged in criminal activity, and will report it!",
            "Yes, I still want to", DialogResult.Yes, "OK, I won't", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterScoop:
        dr = (new FormAlert("Scoop Canister", "A canister from the destroyed ship, labeled ^1, drifts within range of your scoops.",
            "Pick It Up", DialogResult.Yes, "Let It Go", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterScoopNoRoom:
        dr = (new FormAlert("No Room To Scoop", "You don't have any room in your cargo holds. Do you wish to jettison goods to make room, or just let it go.",
            "Make Room", DialogResult.Yes, "Let it go", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EncounterScoopNoScoop:
        dr = (new FormAlert("No Scoop", "You regret finding nothing in your holds that can be dumped, and let the canister go.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterSurrenderRefused:
        dr = (new FormAlert("To The Death!", "Surrender? Hah! We want your HEAD!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterTonicConsumedGood:
        dr = (new FormAlert("Tonic Consumed", "Mmmmm. Captain Marmoset's Amazing Skill Tonic not only fills you with energy, but tastes like a fine single-malt." + Strings.newline,
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterTonicConsumedStrange:
        dr = (new FormAlert("Tonic Consumed", "While you don't know what it was supposed to taste like, you get the feeling that this dose of tonic was a bit off.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterTradeCompleted:
        dr = (new FormAlert("Trade Completed", "Thanks for ^1 the ^2. It's been a pleasure doing business with you.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterYouLose:
        dr = (new FormAlert("You Lose", "Your ship has been destroyed by your opponent.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EncounterYouWin:
        dr = (new FormAlert("You Win", "You have destroyed your opponent.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentAlreadyOwn:
        dr = (new FormAlert("You Already Have One", "It's not useful to buy more than one of this item.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentBuy:
        dr = (new FormAlert("Buy ^1", "Do you wish to buy this item for ^2 credits?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EquipmentEscapePod:
        dr = (new FormAlert("Escape Pod", "Do you want to buy an escape pod for 2000 credits?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case EquipmentExtraBaysInUse:
        dr = (new FormAlert("Cargo Bays Full", "The extra cargo bays are still filled with goods. You can only sell them when they're empty.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentFuelCompactor:
        dr = (new FormAlert("Fuel Compactor", "You now have a fuel compactor installed on your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentHiddenCompartments:
        dr = (new FormAlert("Hidden Compartments", "You now have hidden compartments equivalent to 5 extra cargo bays installed in your ship. Police won't find illegal cargo hidden in these compartments.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentIF:
        dr = (new FormAlert("Not Enough Money", "You don't have enough money to spend on this item.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentLightningShield:
        dr = (new FormAlert("Lightning Shield", "You now have one lightning shield installed on your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentMorgansLaser:
        dr = (new FormAlert("Morgan's Laser", "You now have Henry Morgan's special laser installed on your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentNotEnoughSlots:
        dr = (new FormAlert("Not Enough Slots", "You have already filled all of your available slots for this type of item.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentQuantumDisruptor:
        dr = (new FormAlert("Quantum Disruptor", "You now have one quantum disruptor installed on your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case EquipmentSell:
        dr = (new FormAlert("Sell Item", "Are you sure you want to sell this item?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case FileErrorOpen:
        dr = (new FormAlert("Error", "An error occurred while trying to open ^1." + Strings.newline + Strings.newline + "^2",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case FileErrorSave:
        dr = (new FormAlert("Error", "An error occurred while trying to save ^1." + Strings.newline + Strings.newline + "^2",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case FleaBuilt:
        dr = (new FormAlert("Flea Built", "In 3 days and with 500 credits, you manage to convert your pod into a Flea.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case GameAbandonConfirm:
        dr = (new FormAlert("Are You Sure?", "Are you sure you want to abandon your current game?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case GameClearHighScores:
        dr = (new FormAlert("Clear High Scores", "Are you sure you wish to clear the high score table?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case GameEndBoughtMoon:
        (new FormAlert("You Have Retired", GameEndType.BoughtMoon.CastToInt())).ShowDialog(wp);
        break;
      case GameEndBoughtMoonGirl:
        (new FormAlert("You Have Retired with the Princess", GameEndType.BoughtMoonGirl.CastToInt())).ShowDialog(wp);
        break;
      case GameEndHighScoreAchieved:
        dr = (new FormAlert("Congratulations!", "You have made the high-score list!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case GameEndHighScoreCheat:
        dr = (new FormAlert("Naughy, Naughty!", "You would have made the high-score list if you weren't a Cheat!.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case GameEndHighScoreMissed:
        dr = (new FormAlert("Sorry", "Alas! This is not enough to enter the high-score list.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case GameEndKilled:
        (new FormAlert("You Are Dead", GameEndType.Killed.CastToInt())).ShowDialog(wp);
        break;
      case GameEndRetired:
        (new FormAlert("You Have Retired", GameEndType.Retired.CastToInt())).ShowDialog(wp);
        break;
      case GameEndScore:
        dr = (new FormAlert("Score", "You achieved a score of ^1.^2%.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case GameRetire:
        dr = (new FormAlert("Retire", "Are you sure you wish to retire?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case InsuranceNoEscapePod:
        dr = (new FormAlert("No Escape Pod", "Insurance isn't useful for you, since you don't have an escape pod.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case InsurancePayoff:
        dr = (new FormAlert("Insurance", "Since your ship was insured, the bank pays you the total worth of the destroyed ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case InsuranceStop:
        dr = (new FormAlert("Stop Insurance", "Do you really wish to stop your insurance and lose your no-claim?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case JailConvicted:
        dr = (new FormAlert("Convicted", "You are convicted to ^1 in prison and a fine of ^2.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case JailFleaReceived:
        dr = (new FormAlert("Flea Received", "When you leave prison, the police have left a second-hand Flea for you so you can continue your travels.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case JailHiddenCargoBaysRemoved:
        dr = (new FormAlert("Hidden Compartments Removed", "When your ship is impounded, the police go over it with a fine-tooth comb. Your hidden compartments are found and removed.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case JailIllegalGoodsImpounded:
        dr = (new FormAlert("Illegal Goods Impounded", "The police also impound all of the illegal goods you have on board.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case JailInsuranceLost:
        dr = (new FormAlert("Insurance Lost", "Since you cannot pay your insurance while you're in prison, it is retracted.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case JailMercenariesLeave:
        dr = (new FormAlert("Mercenaries Leave", "Any mercenaries who were traveling with you have left.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case JailShipSold:
        dr = (new FormAlert("Ship Sold", "Because you don't have the credits to pay your fine, your ship is sold.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case JarekTakenHome:
        dr = (new FormAlert("Jarek Taken Home", "The Space Corps decides to give ambassador Jarek a lift home to Devidia.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case LeavingIFInsurance:
        dr = (new FormAlert("Not Enough Money", "You don't have enough cash to pay for your insurance.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case LeavingIFMercenaries:
        dr = (new FormAlert("Pay Mercenaries", "You don't have enough cash to pay your mercenaries to come with you on this trip. Fire them or make sure you have enough cash.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case LeavingIFWormholeTax:
        dr = (new FormAlert("Wormhole Tax", "You don't have enough money to pay for the wormhole tax.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case MeetCaptainAhab:
        dr = (new FormAlert("Meet Captain Ahab", "Captain Ahab is in need of a spare shield for an upcoming mission. He offers to trade you some piloting lessons for your reflective shield. Do you wish to trade?",
            "Yes, Trade Shield", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case MeetCaptainConrad:
        dr = (new FormAlert("Meet Captain Conrad", "Captain Conrad is in need of a military laser. She offers to trade you some engineering training for your military laser. Do you wish to trade?",
            "Yes, Trade Laser", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case MeetCaptainHuie:
        dr = (new FormAlert("Meet Captain Huie", "Captain Huie is in need of a military laser. She offers to exchange some bargaining training for your military laser. Do you wish to trade?",
            "Yes, Trade Laser", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case NewGameConfirm:
        dr = (new FormAlert("New Game", "Are you sure you wish to start a new game?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case NewGameMoreSkillPoints:
        dr = (new FormAlert("More Skill Points", "You haven't awarded all 20 skill points yet.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case OptionsNoGame:
        dr = (new FormAlert("No Game Active", "You don't have a game open, so you can only change the default options.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case PreciousHidden:
        dr = (new FormAlert("Precious Cargo Hidden", "You quickly hide ^1 in your hidden cargo bays before the pirates board your ship. This would never work with the police, but pirates are usually in more of a hurry.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case PrincessTakenHome:
        dr = (new FormAlert("Princess Taken Home", "The Space Corps decides to give the Princess a ride home to Galvon since you obviously weren't up to the task.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ReactorConfiscated:
        dr = (new FormAlert("Police Confiscate Reactor", "The Police confiscate the Ion reactor as evidence of your dealings with unsavory characters.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ReactorDestroyed:
        dr = (new FormAlert("Reactor Destroyed", "The destruction of your ship was made much more spectacular by the added explosion of the Ion Reactor.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ReactorOnBoard:
        dr = (new FormAlert("Reactor", "Five of your cargo bays now contain the unstable Ion Reactor, and ten of your bays contain enriched fuel.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ReactorMeltdown:
        dr = (new FormAlert("Reactor Meltdown!", "Just as you approach the docking bay, the reactor explodes into a huge radioactive fireball!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ReactorWarningFuel:
        dr = (new FormAlert("Reactor Warning", "You notice the Ion Reactor has begun to consume fuel rapidly. In a single day, it has burned up nearly half a bay of fuel!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ReactorWarningFuelGone:
        dr = (new FormAlert("Reactor Warning", "The Ion Reactor is emitting a shrill whine, and it's shaking. The display indicates that it is suffering from fuel starvation.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ReactorWarningTemp:
        dr = (new FormAlert("Reactor Warning", "The Ion Reactor is smoking and making loud noises. The display warns that the core is close to the melting temperature.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case RegistryError:
        dr = (new FormAlert("Error...", "Error accessing the Registry: ^1",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SculptureConfiscated:
        dr = (new FormAlert("Police Confiscate Sculpture", "The Police confiscate the stolen sculpture and return it to its rightful owner.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SculptureSaved:
        dr = (new FormAlert("Sculpture Saved", "On your way to the escape pod, you grab the stolen sculpture. Oh well, at least you saved something.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyConfirm:
        dr = (new FormAlert("Buy New Ship", "Are you sure you wish to trade in your ^1 for a new ^2^3?",
            "Yes", DialogResult.Yes, "No", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case ShipBuyCrewQuarters:
        dr = (new FormAlert("Too Many Crewmembers", "The new ship you picked doesn't have enough quarters for all of your crewmembers. First you will have to fire one or more of them.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyIF:
        dr = (new FormAlert("Not Enough Money", "You don't have enough money to buy this ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyIFTransfer:
        dr = (new FormAlert("Not Enough Money", "You won't have enough money to buy this ship and pay the cost to transfer all of your unique equipment. You should choose carefully which items you wish to transfer!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyNoSlots:
        dr = (new FormAlert("Can't Transfer Item", "If you trade your ship in for a ^1, you won't be able to transfer your ^2 because the new ship has insufficient ^3 slots!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyNotAvailable:
        dr = (new FormAlert("Ship Not Available", "That type of ship is not available in the current system.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyNoTransfer:
        dr = (new FormAlert("Can't Transfer Item", "Unfortunately, if you make this trade, you won't be able to afford to transfer your ^1 to the new ship!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyPassengerQuarters:
        dr = (new FormAlert("Passenger Needs Quarters", "You must get a ship with enough crew quarters so that ^1 can stay on board.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyReactor:
        dr = (new FormAlert("Shipyard Engineer", "Sorry! We can't take your ship as a trade-in. That Ion Reactor looks dangerous, and we have no way of removing it. Come back when you've gotten rid of it.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipBuyTransfer:
        dr = (new FormAlert("Transfer ^1", "I'll transfer your ^2 to your new ship for ^3 credits.",
            "Do it!", DialogResult.Yes, "No thanks", DialogResult.No, ss)).ShowDialog(wp);
        break;
      case ShipDesignIF:
        dr = (new FormAlert("Not Enough Money", "You don't have enough money to create this design.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipDesignThanks:
        dr = (new FormAlert("Thank you!", "^1 thanks you for your business!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case ShipHullUpgraded:
        dr = (new FormAlert("Hull Upgraded", "Technicians spend the day retrofitting the hull of your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialCleanRecord:
        dr = (new FormAlert("Clean Record", "The hacker resets your police record to Clean.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialExperimentPerformed:
        dr = (new FormAlert("Experiment Performed", "The galaxy is abuzz with news of a terrible malfunction in Dr. Fehler's laboratory. Evidently, he was not warned in time and he performed his experiment ... with disastrous results!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialIF:
        dr = (new FormAlert("Not Enough Money", "You don't have enough cash to spend to accept this offer.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialMoonBought:
        dr = (new FormAlert("Moon Bought", "You bought a moon in the Utopia system. Go there to claim it.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialNoQuarters:
        dr = (new FormAlert("No Free Quarters", "There are currently no free crew quarters on your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialNotEnoughBays:
        dr = (new FormAlert("Not Enough Bays", "You don't have enough empty cargo bays at the moment.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialPassengerConcernedJarek:
        dr = (new FormAlert("Ship's Comm.", "Commander? Jarek here. Do you require any assistance in charting a course to Devidia?",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialPassengerConcernedPrincess:
        dr = (new FormAlert("Ship's Comm.", "[Ziyal] Oh Captain? (giggles) Would it help if I got out and pushed?",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialPassengerConcernedWild:
        dr = (new FormAlert("Ship's Comm.", "Bridge? This is Jonathan. Are we there yet? Heh, heh. Sorry, I couldn't resist.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialPassengerImpatientJarek:
        dr = (new FormAlert("Ship's Comm.", "Captain! This is the Ambassador speaking. We should have been there by now?!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialPassengerImpatientPrincess:
        dr = (new FormAlert("Ship's Comm.", "Sir! Are you taking me home or merely taking the place of my previous captors?!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialPassengerImpatientWild:
        dr = (new FormAlert("Ship's Comm.", "Commander! Wild here. What's taking us so long?!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialPassengerOnBoard:
        dr = (new FormAlert("Passenger On Board", "You have taken ^1 on board. While on board ^1 will lend you expertise, but may stop helping if the journey takes too long.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialSealedCanisters:
        dr = (new FormAlert("Sealed Canisters", "You bought the sealed canisters and put them in your cargo bays.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialSkillIncrease:
        dr = (new FormAlert("Skill Increase", "The alien increases one of your skills.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialTimespaceFabricRip:
        dr = (new FormAlert("Timespace Fabric Rip", "You have flown through a tear in the timespace continuum caused by Dr. Fehler's failed experiment. You may not have reached your planned destination!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case SpecialTrainingCompleted:
        dr = (new FormAlert("Training Completed", "After a few hours of training with a top expert, you feel your abilities have improved significantly.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TravelArrival:
        dr = (new FormAlert("Arrival", "You arrive at your destination.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TravelUneventfulTrip:
        dr = (new FormAlert("Uneventful Trip", "After an uneventful trip, you arrive at your destination.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesAllDied:
        dr = (new FormAlert("All The Tribbles Died", "The radiation from the Ion Reactor is deadly to Tribbles. All of the Tribbles on board your ship have died.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesAteFood:
        dr = (new FormAlert("Tribbles Ate Food", "You find that, instead of food, some of your cargo bays contain only tribbles!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesGone:
        dr = (new FormAlert("No More Tribbles", "The alien uses his alien technology to beam over your whole collection of tribbles to his ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesHalfDied:
        dr = (new FormAlert("Half The Tribbles Died", "The radiation from the Ion Reactor seems to be deadly to Tribbles. Half the Tribbles on board died.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesKilled:
        dr = (new FormAlert("Tribbles Killed", "Your tribbles all died in the explosion.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesMostDied:
        dr = (new FormAlert("Most Tribbles Died", "You find that, instead of narcotics, some of your cargo bays contain only dead tribbles!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesOwn:
        dr = (new FormAlert("A Tribble", "You are now the proud owner of a little, cute, furry tribble.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesRemoved:
        dr = (new FormAlert("Tribbles Removed", "The tribbles were sold with your ship.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesInspector:
        dr = (new FormAlert("Space Port Inspector", "Our scan reports you have ^1 tribbles on board your ship. Tribbles are pests worse than locusts! You are running the risk of getting a hefty fine!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesSqueek:
        dr = (new FormAlert("A Tribble", "Squeek!",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case TribblesTradeIn:
        dr = (new FormAlert("You've Got Tribbles", "Hm. I see you got a tribble infestation on your current ship. I'm sorry, but that severely reduces the trade-in price.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildArrested:
        dr = (new FormAlert("Wild Arrested", "Jonathan Wild is arrested, and taken away to stand trial.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildChatsPirates:
        dr = (new FormAlert("Wild Chats With Pirates", "The Pirate Captain turns out to be an old associate of Jonathan Wild's. They talk about old times, and you get the feeling that Wild would switch ships if the Pirates had any quarters available.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildGoesPirates:
        dr = (new FormAlert("Wild Goes With Pirates", "The Pirate Captain turns out to be an old associate of Jonathan Wild's, and invites him to go to Kravat aboard the Pirate ship. Wild accepts the offer and thanks you for the ride.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildLeavesShip:
        dr = (new FormAlert("Wild Leaves Ship", "Jonathan Wild leaves your ship, and goes into hiding on ^1.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildSculpture:
        dr = (new FormAlert("Wild Eyes Sculpture", "Jonathan Wild sees the stolen sculpture. \"Wow, I only know of one of these left in the whole Universe!\" he exclaims, \"Geurge Locas must be beside himself with it being stolen.\" He seems very impressed with you, which makes you feel much better about the item your delivering.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildWontBoardLaser:
        dr = (new FormAlert("Wild Won't Board Ship", "Jonathan Wild isn't willing to go with you if you're not armed with at least a Beam Laser. He'd rather take his chances hiding out here." + Strings.newline,
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildWontBoardReactor:
        dr = (new FormAlert("Wild Won't Board Ship", "Jonathan Wild doesn't like the looks of that Ion Reactor. He thinks it's too dangerous, and won't get on board.",
            "Ok", DialogResult.OK, null, DialogResult.None, ss)).ShowDialog(wp);
        break;
      case WildWontStayAboardLaser:
        dr = (new FormAlert("Wild Won't Stay Aboard", "Jonathan Wild isn't about to go with you if you're not armed with at least a Beam Laser. He'd rather take his chances hiding out here on ^1." + Strings.newline,
            "Say Goodbye to Wild", DialogResult.OK, "Cancel", DialogResult.Cancel, ss)).ShowDialog(wp);
        break;
      case WildWontStayAboardReactor:
        dr = (new FormAlert("Wild Won't Stay Aboard", "Jonathan Wild isn't willing to go with you if you bring that Reactor on board. He'd rather take his chances hiding out here on ^1." + Strings.newline,
            "Say Goodbye to Wild", DialogResult.OK, "Cancel", DialogResult.Cancel, ss)).ShowDialog(wp);
        break;
    }
    return dr;
  }
}
