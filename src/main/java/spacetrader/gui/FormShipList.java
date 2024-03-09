package spacetrader.gui;
import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import jwinforms.Button;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.Font;
import jwinforms.FormSize;
import jwinforms.GraphicsUnit;
import jwinforms.GroupBox;
import jwinforms.Label;
import jwinforms.PictureBox;
import jwinforms.WinformControl;
import jwinforms.WinformForm;
import jwinforms.enums.BorderStyle;
import jwinforms.enums.ContentAlignment;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FontStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;
import spacetrader.Commander;
import spacetrader.Consts;
import spacetrader.Functions;
import spacetrader.Game;
import spacetrader.Ship;
import spacetrader.ShipSpec;
import spacetrader.SpecialEvent;
import spacetrader.Strings;
import spacetrader.enums.AlertType;


public class FormShipList extends WinformForm {
  private Button btnClose;
  private Button btnBuy0;
  private Label lblName0;
  private Button btnInfo0;
  private Label lblPrice0;
  private Label lblPrice1;
  private Button btnInfo1;
  private Label lblName1;
  private Button btnBuy1;
  private Label lblPrice2;
  private Button btnInfo2;
  private Label lblName2;
  private Button btnBuy2;
  private Label lblPrice3;
  private Button btnInfo3;
  private Label lblName3;
  private Button btnBuy3;
  private Label lblPrice4;
  private Button btnInfo4;
  private Label lblName4;
  private Button btnBuy4;
  private Label lblPrice5;
  private Button btnInfo5;
  private Label lblName5;
  private Button btnBuy5;
  private Label lblPrice6;
  private Button btnInfo6;
  private Label lblName6;
  private Button btnBuy6;
  private Label lblPrice7;
  private Button btnInfo7;
  private Label lblName7;
  private Button btnBuy7;
  private Label lblPrice8;
  private Button btnInfo8;
  private Label lblName8;
  private Button btnBuy8;
  private Label lblPrice9;
  private Button btnInfo9;
  private Label lblName9;
  private Button btnBuy9;
  private GroupBox boxShipInfo;
  private Label lblSizeLabel;
  private Label lblNameLabel;
  private Label lblBaysLabel;
  private Label lblRangeLabel;
  private Label lblHullLabel;
  private Label lblWeaponLabel;
  private Label lblShieldLabel;
  private Label lblCrewLabel;
  private Label lblGadgetLabel;
  private PictureBox picShip;
  private Label lblName;
  private Label lblSize;
  private Label lblBays;
  private Label lblRange;
  private Label lblHull;
  private Label lblWeapon;
  private Label lblShield;
  private Label lblGadget;
  private Label lblCrew;
  private Label[] lblPrice;
  private Button[] btnBuy;
  private final Game game = Game.CurrentGame();
  private final Commander cmdr = game.Commander();
  private final Ship ship = cmdr.getShip();
  private int[] prices = new int[Consts.ShipSpecs.length];

  public FormShipList() {
    InitializeComponent();
    lblPrice = new Label[]{
      lblPrice0,
      lblPrice1,
      lblPrice2,
      lblPrice3,
      lblPrice4,
      lblPrice5,
      lblPrice6,
      lblPrice7,
      lblPrice8,
      lblPrice9,};
    btnBuy = new Button[]{
      btnBuy0,
      btnBuy1,
      btnBuy2,
      btnBuy3,
      btnBuy4,
      btnBuy5,
      btnBuy6,
      btnBuy7,
      btnBuy8,
      btnBuy9,};
    UpdateAll();
    Info(ship.Type().CastToInt());
    if(ship.getTribbles() > 0 && !game.getTribbleMessage()) {
      FormAlert.Alert(AlertType.TribblesTradeIn, this);
      game.setTribbleMessage(true);
    }
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    btnClose = new Button();
    btnBuy0 = new Button();
    lblName0 = new Label();
    btnInfo0 = new Button();
    lblPrice0 = new Label();
    lblPrice1 = new Label();
    btnInfo1 = new Button();
    lblName1 = new Label();
    btnBuy1 = new Button();
    lblPrice2 = new Label();
    btnInfo2 = new Button();
    lblName2 = new Label();
    btnBuy2 = new Button();
    lblPrice3 = new Label();
    btnInfo3 = new Button();
    lblName3 = new Label();
    btnBuy3 = new Button();
    lblPrice4 = new Label();
    btnInfo4 = new Button();
    lblName4 = new Label();
    btnBuy4 = new Button();
    lblPrice5 = new Label();
    btnInfo5 = new Button();
    lblName5 = new Label();
    btnBuy5 = new Button();
    lblPrice6 = new Label();
    btnInfo6 = new Button();
    lblName6 = new Label();
    btnBuy6 = new Button();
    lblPrice7 = new Label();
    btnInfo7 = new Button();
    lblName7 = new Label();
    btnBuy7 = new Button();
    lblPrice8 = new Label();
    btnInfo8 = new Button();
    lblName8 = new Label();
    btnBuy8 = new Button();
    lblPrice9 = new Label();
    btnInfo9 = new Button();
    lblName9 = new Label();
    btnBuy9 = new Button();
    boxShipInfo = new GroupBox();
    lblCrew = new Label();
    lblGadget = new Label();
    lblShield = new Label();
    lblWeapon = new Label();
    lblHull = new Label();
    lblRange = new Label();
    lblBays = new Label();
    lblSize = new Label();
    lblName = new Label();
    picShip = new PictureBox();
    lblGadgetLabel = new Label();
    lblCrewLabel = new Label();
    lblShieldLabel = new Label();
    lblWeaponLabel = new Label();
    lblHullLabel = new Label();
    lblRangeLabel = new Label();
    lblBaysLabel = new Label();
    lblNameLabel = new Label();
    lblSizeLabel = new Label();
    boxShipInfo.SuspendLayout();
    SuspendLayout();
    // btnClose
    btnClose.setDialogResult(DialogResult.Cancel);
    btnClose.setLocation(new Point(-32, -32));
    btnClose.setName("btnClose");
    btnClose.setSize(new FormSize(32, 32));
    btnClose.setTabIndex(32);
    btnClose.setTabStop(false);
    btnClose.setText("X");
    // btnBuy0
    btnBuy0.setFlatStyle(FlatStyle.Flat);
    btnBuy0.setLocation(new Point(8, 8));
    btnBuy0.setName("btnBuy0");
    btnBuy0.setSize(new FormSize(35, 22));
    btnBuy0.setTabIndex(1);
    btnBuy0.setText("Buy");
    btnBuy0.setVisible(false);
    btnBuy0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName0
    lblName0.setLocation(new Point(48, 12));
    lblName0.setName("lblName0");
    lblName0.setSize(new FormSize(70, 13));
    lblName0.setTabIndex(34);
    lblName0.setText("Flea");
    // btnInfo0
    btnInfo0.setFlatStyle(FlatStyle.Flat);
    btnInfo0.setLocation(new Point(120, 8));
    btnInfo0.setName("btnInfo0");
    btnInfo0.setSize(new FormSize(34, 22));
    btnInfo0.setTabIndex(11);
    btnInfo0.setText("Info");
    btnInfo0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice0
    lblPrice0.setLocation(new Point(160, 12));
    lblPrice0.setName("lblPrice0");
    lblPrice0.setSize(new FormSize(64, 13));
    lblPrice0.setTabIndex(36);
    lblPrice0.setText("-888,888 cr.");
    lblPrice0.TextAlign = ContentAlignment.TopRight;
    // lblPrice1
    lblPrice1.setLocation(new Point(160, 36));
    lblPrice1.setName("lblPrice1");
    lblPrice1.setSize(new FormSize(64, 13));
    lblPrice1.setTabIndex(40);
    lblPrice1.setText("-888,888 cr.");
    lblPrice1.TextAlign = ContentAlignment.TopRight;
    // btnInfo1
    btnInfo1.setFlatStyle(FlatStyle.Flat);
    btnInfo1.setLocation(new Point(120, 32));
    btnInfo1.setName("btnInfo1");
    btnInfo1.setSize(new FormSize(34, 22));
    btnInfo1.setTabIndex(12);
    btnInfo1.setText("Info");
    btnInfo1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName1
    lblName1.setLocation(new Point(48, 36));
    lblName1.setName("lblName1");
    lblName1.setSize(new FormSize(70, 13));
    lblName1.setTabIndex(38);
    lblName1.setText("Gnat");
    // btnBuy1
    btnBuy1.setFlatStyle(FlatStyle.Flat);
    btnBuy1.setLocation(new Point(8, 32));
    btnBuy1.setName("btnBuy1");
    btnBuy1.setSize(new FormSize(35, 22));
    btnBuy1.setTabIndex(2);
    btnBuy1.setText("Buy");
    btnBuy1.setVisible(false);
    btnBuy1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice2
    lblPrice2.setLocation(new Point(160, 60));
    lblPrice2.setName("lblPrice2");
    lblPrice2.setSize(new FormSize(64, 13));
    lblPrice2.setTabIndex(44);
    lblPrice2.setText("-888,888 cr.");
    lblPrice2.TextAlign = ContentAlignment.TopRight;
    // btnInfo2
    btnInfo2.setFlatStyle(FlatStyle.Flat);
    btnInfo2.setLocation(new Point(120, 56));
    btnInfo2.setName("btnInfo2");
    btnInfo2.setSize(new FormSize(34, 22));
    btnInfo2.setTabIndex(13);
    btnInfo2.setText("Info");
    btnInfo2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName2
    lblName2.setLocation(new Point(48, 60));
    lblName2.setName("lblName2");
    lblName2.setSize(new FormSize(70, 13));
    lblName2.setTabIndex(42);
    lblName2.setText("Firefly");
    // btnBuy2
    btnBuy2.setFlatStyle(FlatStyle.Flat);
    btnBuy2.setLocation(new Point(8, 56));
    btnBuy2.setName("btnBuy2");
    btnBuy2.setSize(new FormSize(35, 22));
    btnBuy2.setTabIndex(3);
    btnBuy2.setText("Buy");
    btnBuy2.setVisible(false);
    btnBuy2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice3
    lblPrice3.setLocation(new Point(160, 84));
    lblPrice3.setName("lblPrice3");
    lblPrice3.setSize(new FormSize(64, 13));
    lblPrice3.setTabIndex(48);
    lblPrice3.setText("-888,888 cr.");
    lblPrice3.TextAlign = ContentAlignment.TopRight;
    // btnInfo3
    btnInfo3.setFlatStyle(FlatStyle.Flat);
    btnInfo3.setLocation(new Point(120, 80));
    btnInfo3.setName("btnInfo3");
    btnInfo3.setSize(new FormSize(34, 22));
    btnInfo3.setTabIndex(14);
    btnInfo3.setText("Info");
    btnInfo3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName3
    lblName3.setLocation(new Point(48, 84));
    lblName3.setName("lblName3");
    lblName3.setSize(new FormSize(70, 13));
    lblName3.setTabIndex(46);
    lblName3.setText("Mosquito");
    // btnBuy3
    btnBuy3.setFlatStyle(FlatStyle.Flat);
    btnBuy3.setLocation(new Point(8, 80));
    btnBuy3.setName("btnBuy3");
    btnBuy3.setSize(new FormSize(35, 22));
    btnBuy3.setTabIndex(4);
    btnBuy3.setText("Buy");
    btnBuy3.setVisible(false);
    btnBuy3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice4
    lblPrice4.setLocation(new Point(160, 108));
    lblPrice4.setName("lblPrice4");
    lblPrice4.setSize(new FormSize(64, 13));
    lblPrice4.setTabIndex(52);
    lblPrice4.setText("-888,888 cr.");
    lblPrice4.TextAlign = ContentAlignment.TopRight;
    // btnInfo4
    btnInfo4.setFlatStyle(FlatStyle.Flat);
    btnInfo4.setLocation(new Point(120, 104));
    btnInfo4.setName("btnInfo4");
    btnInfo4.setSize(new FormSize(34, 22));
    btnInfo4.setTabIndex(15);
    btnInfo4.setText("Info");
    btnInfo4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName4
    lblName4.setLocation(new Point(48, 108));
    lblName4.setName("lblName4");
    lblName4.setSize(new FormSize(70, 13));
    lblName4.setTabIndex(50);
    lblName4.setText("Bumblebee");
    // btnBuy4
    btnBuy4.setFlatStyle(FlatStyle.Flat);
    btnBuy4.setLocation(new Point(8, 104));
    btnBuy4.setName("btnBuy4");
    btnBuy4.setSize(new FormSize(35, 22));
    btnBuy4.setTabIndex(5);
    btnBuy4.setText("Buy");
    btnBuy4.setVisible(false);
    btnBuy4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice5
    lblPrice5.setLocation(new Point(160, 132));
    lblPrice5.setName("lblPrice5");
    lblPrice5.setSize(new FormSize(64, 13));
    lblPrice5.setTabIndex(56);
    lblPrice5.setText("got one");
    lblPrice5.TextAlign = ContentAlignment.TopRight;
    // btnInfo5
    btnInfo5.setFlatStyle(FlatStyle.Flat);
    btnInfo5.setLocation(new Point(120, 128));
    btnInfo5.setName("btnInfo5");
    btnInfo5.setSize(new FormSize(34, 22));
    btnInfo5.setTabIndex(16);
    btnInfo5.setText("Info");
    btnInfo5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName5
    lblName5.setLocation(new Point(48, 132));
    lblName5.setName("lblName5");
    lblName5.setSize(new FormSize(70, 13));
    lblName5.setTabIndex(54);
    lblName5.setText("Beetle");
    // btnBuy5
    btnBuy5.setFlatStyle(FlatStyle.Flat);
    btnBuy5.setLocation(new Point(8, 128));
    btnBuy5.setName("btnBuy5");
    btnBuy5.setSize(new FormSize(35, 22));
    btnBuy5.setTabIndex(6);
    btnBuy5.setText("Buy");
    btnBuy5.setVisible(false);
    btnBuy5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice6
    lblPrice6.setLocation(new Point(160, 156));
    lblPrice6.setName("lblPrice6");
    lblPrice6.setSize(new FormSize(64, 13));
    lblPrice6.setTabIndex(60);
    lblPrice6.setText("-888,888 cr.");
    lblPrice6.TextAlign = ContentAlignment.TopRight;
    // btnInfo6
    btnInfo6.setFlatStyle(FlatStyle.Flat);
    btnInfo6.setLocation(new Point(120, 152));
    btnInfo6.setName("btnInfo6");
    btnInfo6.setSize(new FormSize(34, 22));
    btnInfo6.setTabIndex(17);
    btnInfo6.setText("Info");
    btnInfo6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName6
    lblName6.setLocation(new Point(48, 156));
    lblName6.setName("lblName6");
    lblName6.setSize(new FormSize(70, 13));
    lblName6.setTabIndex(58);
    lblName6.setText("Hornet");
    // btnBuy6
    btnBuy6.setFlatStyle(FlatStyle.Flat);
    btnBuy6.setLocation(new Point(8, 152));
    btnBuy6.setName("btnBuy6");
    btnBuy6.setSize(new FormSize(35, 22));
    btnBuy6.setTabIndex(7);
    btnBuy6.setText("Buy");
    btnBuy6.setVisible(false);
    btnBuy6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice7
    lblPrice7.setLocation(new Point(160, 180));
    lblPrice7.setName("lblPrice7");
    lblPrice7.setSize(new FormSize(64, 13));
    lblPrice7.setTabIndex(64);
    lblPrice7.setText("-888,888 cr.");
    lblPrice7.TextAlign = ContentAlignment.TopRight;
    // btnInfo7
    btnInfo7.setFlatStyle(FlatStyle.Flat);
    btnInfo7.setLocation(new Point(120, 176));
    btnInfo7.setName("btnInfo7");
    btnInfo7.setSize(new FormSize(34, 22));
    btnInfo7.setTabIndex(18);
    btnInfo7.setText("Info");
    btnInfo7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName7
    lblName7.setLocation(new Point(48, 180));
    lblName7.setName("lblName7");
    lblName7.setSize(new FormSize(70, 13));
    lblName7.setTabIndex(62);
    lblName7.setText("Grasshopper");
    // btnBuy7
    btnBuy7.setFlatStyle(FlatStyle.Flat);
    btnBuy7.setLocation(new Point(8, 176));
    btnBuy7.setName("btnBuy7");
    btnBuy7.setSize(new FormSize(35, 22));
    btnBuy7.setTabIndex(8);
    btnBuy7.setText("Buy");
    btnBuy7.setVisible(false);
    btnBuy7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice8
    lblPrice8.setLocation(new Point(160, 204));
    lblPrice8.setName("lblPrice8");
    lblPrice8.setSize(new FormSize(64, 13));
    lblPrice8.setTabIndex(68);
    lblPrice8.setText("-888,888 cr.");
    lblPrice8.TextAlign = ContentAlignment.TopRight;
    // btnInfo8
    btnInfo8.setFlatStyle(FlatStyle.Flat);
    btnInfo8.setLocation(new Point(120, 200));
    btnInfo8.setName("btnInfo8");
    btnInfo8.setSize(new FormSize(34, 22));
    btnInfo8.setTabIndex(19);
    btnInfo8.setText("Info");
    btnInfo8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName8
    lblName8.setLocation(new Point(48, 204));
    lblName8.setName("lblName8");
    lblName8.setSize(new FormSize(70, 13));
    lblName8.setTabIndex(66);
    lblName8.setText("Termite");
    // btnBuy8
    btnBuy8.setFlatStyle(FlatStyle.Flat);
    btnBuy8.setLocation(new Point(8, 200));
    btnBuy8.setName("btnBuy8");
    btnBuy8.setSize(new FormSize(35, 22));
    btnBuy8.setTabIndex(9);
    btnBuy8.setText("Buy");
    btnBuy8.setVisible(false);
    btnBuy8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblPrice9
    lblPrice9.setLocation(new Point(160, 228));
    lblPrice9.setName("lblPrice9");
    lblPrice9.setSize(new FormSize(64, 13));
    lblPrice9.setTabIndex(72);
    lblPrice9.setText("not sold");
    lblPrice9.TextAlign = ContentAlignment.TopRight;
    // btnInfo9
    btnInfo9.setFlatStyle(FlatStyle.Flat);
    btnInfo9.setLocation(new Point(120, 224));
    btnInfo9.setName("btnInfo9");
    btnInfo9.setSize(new FormSize(34, 22));
    btnInfo9.setTabIndex(20);
    btnInfo9.setText("Info");
    btnInfo9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // lblName9
    lblName9.setLocation(new Point(48, 228));
    lblName9.setName("lblName9");
    lblName9.setSize(new FormSize(70, 13));
    lblName9.setTabIndex(70);
    lblName9.setText("Wasp");
    // btnBuy9
    btnBuy9.setFlatStyle(FlatStyle.Flat);
    btnBuy9.setLocation(new Point(8, 224));
    btnBuy9.setName("btnBuy9");
    btnBuy9.setSize(new FormSize(35, 22));
    btnBuy9.setTabIndex(10);
    btnBuy9.setText("Buy");
    btnBuy9.setVisible(false);
    btnBuy9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInfo_Click(sender, e);
      }
    });
    // boxShipInfo
    boxShipInfo.Controls.addAll((new WinformControl[]{
          lblCrew,
          lblGadget,
          lblShield,
          lblWeapon,
          lblHull,
          lblRange,
          lblBays,
          lblSize,
          lblName,
          picShip,
          lblGadgetLabel,
          lblCrewLabel,
          lblShieldLabel,
          lblWeaponLabel,
          lblHullLabel,
          lblRangeLabel,
          lblBaysLabel,
          lblNameLabel,
          lblSizeLabel}));
    boxShipInfo.setLocation(new Point(232, 0));
    boxShipInfo.setName("boxShipInfo");
    boxShipInfo.setSize(new FormSize(200, 248));
    boxShipInfo.setTabIndex(73);
    boxShipInfo.setTabStop(false);
    boxShipInfo.setText("Ship Information");
    // lblCrew
    lblCrew.setLocation(new Point(96, 224));
    lblCrew.setName("lblCrew");
    lblCrew.setSize(new FormSize(10, 13));
    lblCrew.setTabIndex(43);
    lblCrew.setText("8");
    // lblGadget
    lblGadget.setLocation(new Point(96, 208));
    lblGadget.setName("lblGadget");
    lblGadget.setSize(new FormSize(10, 13));
    lblGadget.setTabIndex(42);
    lblGadget.setText("8");
    // lblShield
    lblShield.setLocation(new Point(96, 192));
    lblShield.setName("lblShield");
    lblShield.setSize(new FormSize(10, 13));
    lblShield.setTabIndex(41);
    lblShield.setText("8");
    // lblWeapon
    lblWeapon.setLocation(new Point(96, 176));
    lblWeapon.setName("lblWeapon");
    lblWeapon.setSize(new FormSize(10, 13));
    lblWeapon.setTabIndex(40);
    lblWeapon.setText("8");
    // lblHull
    lblHull.setLocation(new Point(96, 160));
    lblHull.setName("lblHull");
    lblHull.setSize(new FormSize(23, 13));
    lblHull.setTabIndex(39);
    lblHull.setText("888");
    // lblRange
    lblRange.setLocation(new Point(96, 144));
    lblRange.setName("lblRange");
    lblRange.setSize(new FormSize(59, 13));
    lblRange.setTabIndex(38);
    lblRange.setText("88 parsecs");
    // lblBays
    lblBays.setLocation(new Point(96, 128));
    lblBays.setName("lblBays");
    lblBays.setSize(new FormSize(17, 13));
    lblBays.setTabIndex(37);
    lblBays.setText("88");
    // lblSize
    lblSize.setLocation(new Point(96, 112));
    lblSize.setName("lblSize");
    lblSize.setSize(new FormSize(45, 13));
    lblSize.setTabIndex(36);
    lblSize.setText("Medium");
    // lblName
    lblName.setLocation(new Point(96, 96));
    lblName.setName("lblName");
    lblName.setSize(new FormSize(100, 13));
    lblName.setTabIndex(35);
    lblName.setText("Grasshopper");
    // picShip
    picShip.setBackColor(Color.white);
    picShip.setBorderStyle(BorderStyle.FixedSingle);
    picShip.setLocation(new Point(67, 25));
    picShip.setName("picShip");
    picShip.setSize(new FormSize(66, 54));
    picShip.setTabIndex(12);
    picShip.setTabStop(false);
    // lblGadgetLabel
    lblGadgetLabel.setAutoSize(true);
    lblGadgetLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblGadgetLabel.setLocation(new Point(8, 208));
    lblGadgetLabel.setName("lblGadgetLabel");
    lblGadgetLabel.setSize(new FormSize(76, 13));
    lblGadgetLabel.setTabIndex(11);
    lblGadgetLabel.setText("Gadget Slots:");
    // lblCrewLabel
    lblCrewLabel.setAutoSize(true);
    lblCrewLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblCrewLabel.setLocation(new Point(8, 224));
    lblCrewLabel.setName("lblCrewLabel");
    lblCrewLabel.setSize(new FormSize(84, 13));
    lblCrewLabel.setTabIndex(10);
    lblCrewLabel.setText("Crew Quarters:");
    // lblShieldLabel
    lblShieldLabel.setAutoSize(true);
    lblShieldLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblShieldLabel.setLocation(new Point(8, 192));
    lblShieldLabel.setName("lblShieldLabel");
    lblShieldLabel.setSize(new FormSize(70, 13));
    lblShieldLabel.setTabIndex(9);
    lblShieldLabel.setText("Shield Slots:");
    // lblWeaponLabel
    lblWeaponLabel.setAutoSize(true);
    lblWeaponLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblWeaponLabel.setLocation(new Point(8, 176));
    lblWeaponLabel.setName("lblWeaponLabel");
    lblWeaponLabel.setSize(new FormSize(81, 13));
    lblWeaponLabel.setTabIndex(8);
    lblWeaponLabel.setText("Weapon Slots:");
    // lblHullLabel
    lblHullLabel.setAutoSize(true);
    lblHullLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblHullLabel.setLocation(new Point(8, 160));
    lblHullLabel.setName("lblHullLabel");
    lblHullLabel.setSize(new FormSize(73, 13));
    lblHullLabel.setTabIndex(7);
    lblHullLabel.setText("Hull Strength");
    // lblRangeLabel
    lblRangeLabel.setAutoSize(true);
    lblRangeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblRangeLabel.setLocation(new Point(8, 144));
    lblRangeLabel.setName("lblRangeLabel");
    lblRangeLabel.setSize(new FormSize(42, 13));
    lblRangeLabel.setTabIndex(6);
    lblRangeLabel.setText("Range:");
    // lblBaysLabel
    lblBaysLabel.setAutoSize(true);
    lblBaysLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblBaysLabel.setLocation(new Point(8, 128));
    lblBaysLabel.setName("lblBaysLabel");
    lblBaysLabel.setSize(new FormSize(69, 13));
    lblBaysLabel.setTabIndex(5);
    lblBaysLabel.setText("Cargo Bays:");
    // lblNameLabel
    lblNameLabel.setAutoSize(true);
    lblNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblNameLabel.setLocation(new Point(8, 96));
    lblNameLabel.setName("lblNameLabel");
    lblNameLabel.setSize(new FormSize(39, 13));
    lblNameLabel.setTabIndex(4);
    lblNameLabel.setText("Name:");
    // lblSizeLabel
    lblSizeLabel.setAutoSize(true);
    lblSizeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSizeLabel.setLocation(new Point(8, 112));
    lblSizeLabel.setName("lblSizeLabel");
    lblSizeLabel.setSize(new FormSize(31, 13));
    lblSizeLabel.setTabIndex(3);
    lblSizeLabel.setText("Size:");
    // FormShipList
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnClose);
    setClientSize(new FormSize(438, 255));
    Controls.addAll(Arrays.asList(
        boxShipInfo,
        lblPrice9,
        btnInfo9,
        lblName9,
        btnBuy9,
        lblPrice8,
        btnInfo8,
        lblName8,
        btnBuy8,
        lblPrice7,
        btnInfo7,
        lblName7,
        btnBuy7,
        lblPrice6,
        btnInfo6,
        lblName6,
        btnBuy6,
        lblPrice5,
        btnInfo5,
        lblName5,
        btnBuy5,
        lblPrice4,
        btnInfo4,
        lblName4,
        btnBuy4,
        lblPrice3,
        btnInfo3,
        lblName3,
        btnBuy3,
        lblPrice2,
        btnInfo2,
        lblName2,
        btnBuy2,
        lblPrice1,
        btnInfo1,
        lblName1,
        btnBuy1,
        lblPrice0,
        btnInfo0,
        lblName0,
        btnBuy0,
        btnClose));
    setFormBorderStyle(FormBorderStyle.FixedDialog);
    setMaximizeBox(false);
    setMinimizeBox(false);
    setName("FormShipList");
    setShowInTaskbar(false);
    setStartPosition(FormStartPosition.CenterParent);
    setText("Ship List");
    boxShipInfo.ResumeLayout(false);
    ResumeLayout(false);
  }

  private void Buy(int id) {
    Info(id);
    if(cmdr.TradeShip(Consts.ShipSpecs[id], prices[id], this)) {
      if(game.getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
        game.setQuestStatusScarab(SpecialEvent.StatusScarabNotStarted);
      }
      UpdateAll();
      game.getParentWindow().UpdateAll();
    }
  }

  private void Info(int id) {
    ShipSpec spec = Consts.ShipSpecs[id];
    picShip.setImage(spec.Image());
    lblName.setText(spec.Name());
    lblSize.setText(Strings.Sizes[spec.getSize().CastToInt()]);
    lblBays.setText(Functions.FormatNumber(spec.CargoBays()));
    lblRange.setText(Functions.Multiples(spec.FuelTanks(), Strings.DistanceUnit));
    lblHull.setText(Functions.FormatNumber(spec.HullStrength()));
    lblWeapon.setText(Functions.FormatNumber(spec.getWeaponSlots()));
    lblShield.setText(Functions.FormatNumber(spec.getShieldSlots()));
    lblGadget.setText(Functions.FormatNumber(spec.getGadgetSlots()));
    lblCrew.setText(Functions.FormatNumber(spec.getCrewQuarters()));
  }

  private void UpdateAll() {
    for(int i = 0; i < lblPrice.length; i++) {
      btnBuy[i].setVisible(false);
      if(Consts.ShipSpecs[i].MinimumTechLevel().ordinal() > cmdr.CurrentSystem().TechLevel().ordinal()) {
        lblPrice[i].setText("not sold");
      } else if(Consts.ShipSpecs[i].Type() == ship.Type()) {
        lblPrice[i].setText(Strings.ShipBuyGotOne);
      } else {
        btnBuy[i].setVisible(true);
        prices[i] = Consts.ShipSpecs[i].getPrice() - ship.Worth(false);
        lblPrice[i].setText(Functions.FormatMoney(prices[i]));
      }
    }
  }

  private void btnBuyInfo_Click(Object sender, EventArgs e) {
    String name = ((Button)sender).getName();
    int index = Integer.parseInt(name.substring(name.length() - 1));
    if(name.indexOf("Buy") < 0) {
      Info(index);
    } else {
      Buy(index);
    }
  }
}
