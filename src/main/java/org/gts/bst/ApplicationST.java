package org.gts.bst;
import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.UIManager;
import jwinforms.Brush;
import jwinforms.Button;
import jwinforms.CancelEventArgs;
import jwinforms.Container;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.Font;
import jwinforms.FormSize;
import jwinforms.GraphicsUnit;
import jwinforms.GroupBox;
import jwinforms.IContainer;
import jwinforms.ISupportInitialize;
import jwinforms.Icon;
import jwinforms.ImageList;
import jwinforms.ImageListStreamer;
import jwinforms.Label;
import jwinforms.MainMenu;
import jwinforms.MenuItem;
import jwinforms.MouseButtons;
import jwinforms.MouseEventArgs;
import jwinforms.OpenFileDialog;
import jwinforms.PaintEventArgs;
import jwinforms.Pen;
import jwinforms.PictureBox;
import jwinforms.ResourceManager;
import jwinforms.SaveFileDialog;
import jwinforms.Shortcut;
import jwinforms.SizeF;
import jwinforms.SolidBrush;
import jwinforms.StatusBar;
import jwinforms.StatusBarPanel;
import jwinforms.StatusBarPanelClickEventArgs;
import jwinforms.SubMenu;
import jwinforms.SystemColors;
import jwinforms.ToolTip;
import jwinforms.WfImage;
import jwinforms.WinformWindow;
import jwinforms.enums.AnchorStyles;
import jwinforms.enums.ContentAlignment;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FontStyle;
import jwinforms.enums.FormStartPosition;
import jwinforms.enums.StatusBarPanelAutoSize;
import org.gts.bst.crew.CrewMemberId;
import org.gts.bst.events.VeryRareEncounter;
import org.gts.bst.ship.ShipType;
import org.gts.bst.ship.equip.Gadget;
import org.gts.bst.ship.equip.Shield;
import org.gts.bst.ship.equip.Weapon;
import spacetrader.Commander;
import spacetrader.Consts;
import spacetrader.CrewMember;
import spacetrader.Functions;
import spacetrader.FutureVersionException;
import spacetrader.Game;
import spacetrader.GameEndException;
import spacetrader.HighScoreRecord;
import spacetrader.STSerializableObject;
import spacetrader.Ship;
import spacetrader.SpecialEvent;
import spacetrader.StarSystem;
import spacetrader.Strings;
import spacetrader.enums.AlertType;
import spacetrader.enums.GameEndType;
import spacetrader.enums.StarSystemId;
import spacetrader.gui.FormAbout;
import spacetrader.gui.FormAlert;
import spacetrader.gui.FormBuyFuel;
import spacetrader.gui.FormBuyRepairs;
import spacetrader.gui.FormCosts;
import spacetrader.gui.FormEquipment;
import spacetrader.gui.FormFind;
import spacetrader.gui.FormMonster;
import spacetrader.gui.FormNewCommander;
import spacetrader.gui.FormOptions;
import spacetrader.gui.FormShipList;
import spacetrader.gui.FormShipyard;
import spacetrader.gui.FormTest;
import spacetrader.gui.FormViewBank;
import spacetrader.gui.FormViewCommander;
import spacetrader.gui.FormViewHighScores;
import spacetrader.gui.FormViewPersonnel;
import spacetrader.gui.FormViewQuests;
import spacetrader.gui.FormViewShip;
import spacetrader.gui.SomeStringsForSwitch;
import spacetrader.stub.Directory;
import spacetrader.stub.RegistryKey;
import spacetrader.util.Hashtable;
import spacetrader.util.Util;


public class ApplicationST extends WinformWindow {
  private Button btnDesign;
  private Button btnNews;
  private Button btnSpecial;
  private Button btnMerc;
  private Button btnFuel;
  private Button btnRepair;
  private Button btnBuyShip;
  private Button btnEquip;
  private Button btnPod;
  private Button btnBuyMax0;
  private Button btnBuyQty0;
  private Button btnSellQty0;
  private Button btnSellAll0;
  private Button btnBuyMax1;
  private Button btnBuyQty1;
  private Button btnSellQty1;
  private Button btnSellAll1;
  private Button btnSellQty2;
  private Button btnSellAll2;
  private Button btnBuyQty2;
  private Button btnBuyMax2;
  private Button btnSellQty3;
  private Button btnSellAll3;
  private Button btnBuyQty3;
  private Button btnBuyMax3;
  private Button btnSellQty4;
  private Button btnSellAll4;
  private Button btnBuyQty4;
  private Button btnBuyMax4;
  private Button btnSellQty5;
  private Button btnSellAll5;
  private Button btnBuyQty5;
  private Button btnBuyMax5;
  private Button btnSellQty6;
  private Button btnSellAll6;
  private Button btnBuyQty6;
  private Button btnBuyMax6;
  private Button btnSellQty7;
  private Button btnSellAll7;
  private Button btnBuyQty7;
  private Button btnBuyMax7;
  private Button btnSellQty8;
  private Button btnSellAll8;
  private Button btnBuyQty8;
  private Button btnBuyMax8;
  private Button btnSellQty9;
  private Button btnSellAll9;
  private Button btnBuyQty9;
  private Button btnBuyMax9;
  private Button btnJump;
  private Button btnFind;
  private Button btnPrevSystem;
  private Button btnNextSystem;
  private Button btnTrack;
  private Button btnWarp;
  private ImageList ilChartImages;
  private ImageList ilDirectionImages;
  private ImageList ilEquipmentImages;
  private ImageList ilShipImages;
  private Label lblBuy;
  private Label lblBuyPrice0;
  private Label lblBuyPrice1;
  private Label lblBuyPrice2;
  private Label lblBuyPrice3;
  private Label lblBuyPrice4;
  private Label lblBuyPrice5;
  private Label lblBuyPrice6;
  private Label lblBuyPrice7;
  private Label lblBuyPrice8;
  private Label lblBuyPrice9;
  private Label lblEquipForSale;
  private Label lblEscapePod;
  private Label lblFuelCost;
  private Label lblFuelStatus;
  private Label lblHullStatus;
  private Label lblRepairCost;
  private Label lblSell;
  private Label lblSellPrice0;
  private Label lblSellPrice1;
  private Label lblSellPrice2;
  private Label lblSellPrice3;
  private Label lblSellPrice4;
  private Label lblSellPrice5;
  private Label lblSellPrice6;
  private Label lblSellPrice7;
  private Label lblSellPrice8;
  private Label lblSellPrice9;
  private Label lblShipsForSale;
  private Label lblSystemGovtLabel;
  private Label lblSystemName;
  private Label lblSystemNameLabel;
  private Label lblSystemPirates;
  private Label lblSystemPiratesLabel;
  private Label lblSystemPolice;
  private Label lblSystemPoliceLabel;
  private Label lblSystemPolSys;
  private Label lblSystemPressure;
  private Label lblSystemPressurePre;
  private Label lblSystemResource;
  private Label lblSystemResourseLabel;
  private Label lblSystemSize;
  private Label lblSystemSizeLabel;
  private Label lblSystemTech;
  private Label lblSystemTechLabel;
  private Label lblTargetDiff0;
  private Label lblTargetDiff1;
  private Label lblTargetDiff2;
  private Label lblTargetDiff3;
  private Label lblTargetDiff4;
  private Label lblTargetDiff5;
  private Label lblTargetDiff6;
  private Label lblTargetDiff7;
  private Label lblTargetDiff8;
  private Label lblTargetDiff9;
  private Label lblTargetDiffLabel;
  private Label lblTargetDistance;
  private Label lblTargetDistanceLabel;
  private Label lblTargetGovtLabel;
  private Label lblTargetName;
  private Label lblTargetNameLabel;
  private Label lblTargetOutOfRange;
  private Label lblTargetPct0;
  private Label lblTargetPct1;
  private Label lblTargetPct2;
  private Label lblTargetPct3;
  private Label lblTargetPct4;
  private Label lblTargetPct5;
  private Label lblTargetPct6;
  private Label lblTargetPct7;
  private Label lblTargetPct8;
  private Label lblTargetPct9;
  private Label lblTargetPctLabel;
  private Label lblTargetPirates;
  private Label lblTargetPiratesLabel;
  private Label lblTargetPolice;
  private Label lblTargetPoliceLabel;
  private Label lblTargetPolSys;
  private Label lblTargetPrice0;
  private Label lblTargetPrice1;
  private Label lblTargetPrice2;
  private Label lblTargetPrice3;
  private Label lblTargetPrice4;
  private Label lblTargetPrice5;
  private Label lblTargetPrice6;
  private Label lblTargetPrice7;
  private Label lblTargetPrice8;
  private Label lblTargetPrice9;
  private Label lblTargetPriceLabel;
  private Label lblTargetResource;
  private Label lblTargetResourceLabel;
  private Label lblTargetSize;
  private Label lblTargetTech;
  private Label lblTargetTechLabel;
  private Label lblTargetSizeLabel;
  private Label lblTradeCmdty0;
  private Label lblTradeCmdty1;
  private Label lblTradeCmdty2;
  private Label lblTradeCmdty3;
  private Label lblTradeCmdty4;
  private Label lblTradeCmdty5;
  private Label lblTradeCmdty6;
  private Label lblTradeCmdty7;
  private Label lblTradeCmdty8;
  private Label lblTradeCmdty9;
  private Label lblTradeTarget;
  private Label lblWormhole;
  private Label lblWormholeLabel;
  private GroupBox boxCargo;
  private GroupBox boxDock;
  private GroupBox boxGalacticChart;
  private GroupBox boxShipYard;
  private GroupBox boxShortRangeChart;
  private GroupBox boxSystem;
  private GroupBox boxTargetSystem;
  private MainMenu mnuMain;
  private SubMenu mnuGame;
  private MenuItem mnuGameExit;
  private MenuItem mnuGameLine1;
  private MenuItem mnuGameLine2;
  private MenuItem mnuGameLoad;
  private MenuItem mnuGameNew;
  private MenuItem mnuGameSave;
  private MenuItem mnuGameSaveAs;
  private SubMenu mnuHelp;
  private MenuItem mnuHelpAbout;
  private MenuItem mnuHighScores;
  private MenuItem mnuOptions;
  private MenuItem mnuRetire;
  private SubMenu mnuView;
  private MenuItem mnuViewBank;
  private MenuItem mnuViewCommander;
  private MenuItem mnuViewLine1;
  private MenuItem mnuViewLine2;
  private MenuItem mnuViewPersonnel;
  private MenuItem mnuViewQuests;
  private MenuItem mnuViewShip;
  private OpenFileDialog dlgOpen;
  private PictureBox picCargoLine0;
  private PictureBox picCargoLine1;
  private PictureBox picCargoLine2;
  private PictureBox picCargoLine3;
  private PictureBox picGalacticChart;
  private PictureBox picLine;
  private PictureBox picShortRangeChart;
  private SaveFileDialog dlgSave;
  private StatusBar statusBar;
  private StatusBarPanel statusBarPanelBays;
  private StatusBarPanel statusBarPanelCash;
  private StatusBarPanel statusBarPanelCosts;
  private StatusBarPanel statusBarPanelExtra;
  private ToolTip tipSpecial;
  private ToolTip tipMerc;
  private IContainer components;
  private final Label[] lblSellPrice;
  private final Label[] lblBuyPrice;
  private final Label[] lblTargetPrice;
  private final Label[] lblTargetDiff;
  private final Label[] lblTargetPct;
  private final Button[] btnSellQty;
  private final Button[] btnSellAll;
  private final Button[] btnBuyQty;
  private final Button[] btnBuyMax;
  private final String SAVE_ARRIVAL = "autosave_arrival.sav";
  private final String SAVE_DEPARTURE = "autosave_departure.sav";
  private final int OFF_X = 3;
  private final int OFF_Y = 3;
  private final int OFF_X_WORM = OFF_X + 1;
  private final int IMG_G_N = 0;
  private final int IMG_G_V = 1;
  private final int IMG_G_W = 2;
  private final int IMG_S_N = 3;
//  private final int IMG_S_NS = 4;
  private final int IMG_S_V = 5;
//  private final int IMG_S_VS = 6;
  private final int IMG_S_W = 7;
  private Game game = null;
  private Commander cmdr = null;
  private final Pen DEFAULT_PEN = new Pen(Color.black);
  private final Brush DEFAULT_BRUSH = new SolidBrush(Color.white);
  private String SaveGameFile = null;
  private int SaveGameDays = -1;

  public ApplicationST(String s) {
    InitializeComponent();
    InitFileStructure();
    lblSellPrice = new Label[]{
      lblSellPrice0, lblSellPrice1, lblSellPrice2, lblSellPrice3, lblSellPrice4,
      lblSellPrice5, lblSellPrice6, lblSellPrice7, lblSellPrice8, lblSellPrice9
    };
    lblBuyPrice = new Label[]{
      lblBuyPrice0, lblBuyPrice1, lblBuyPrice2, lblBuyPrice3, lblBuyPrice4,
      lblBuyPrice5, lblBuyPrice6, lblBuyPrice7, lblBuyPrice8, lblBuyPrice9
    };
    lblTargetPrice = new Label[]{
      lblTargetPrice0, lblTargetPrice1, lblTargetPrice2, lblTargetPrice3, lblTargetPrice4,
      lblTargetPrice5, lblTargetPrice6, lblTargetPrice7, lblTargetPrice8, lblTargetPrice9
    };
    lblTargetDiff = new Label[]{
      lblTargetDiff0, lblTargetDiff1, lblTargetDiff2, lblTargetDiff3, lblTargetDiff4,
      lblTargetDiff5, lblTargetDiff6, lblTargetDiff7, lblTargetDiff8, lblTargetDiff9
    };
    lblTargetPct = new Label[]{
      lblTargetPct0, lblTargetPct1, lblTargetPct2, lblTargetPct3, lblTargetPct4,
      lblTargetPct5, lblTargetPct6, lblTargetPct7, lblTargetPct8, lblTargetPct9
    };
    btnSellQty = new Button[]{
      btnSellQty0, btnSellQty1, btnSellQty2, btnSellQty3, btnSellQty4,
      btnSellQty5, btnSellQty6, btnSellQty7, btnSellQty8, btnSellQty9
    };
    btnSellAll = new Button[]{
      btnSellAll0, btnSellAll1, btnSellAll2, btnSellAll3, btnSellAll4,
      btnSellAll5, btnSellAll6, btnSellAll7, btnSellAll8, btnSellAll9
    };
    btnBuyQty = new Button[]{
      btnBuyQty0, btnBuyQty1, btnBuyQty2, btnBuyQty3, btnBuyQty4,
      btnBuyQty5, btnBuyQty6, btnBuyQty7, btnBuyQty8, btnBuyQty9
    };
    btnBuyMax = new Button[]{
      btnBuyMax0, btnBuyMax1, btnBuyMax2, btnBuyMax3, btnBuyMax4,
      btnBuyMax5, btnBuyMax6, btnBuyMax7, btnBuyMax8, btnBuyMax9
    };
    if(s != null) {
      LoadGame(s);
    }
    ApplicationST.this.UpdateAll();
  }

  public static void main(String[] s) throws Exception {
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    UIManager.put("swing.boldMetal", Boolean.FALSE);
    ApplicationST st = new ApplicationST(s.length > 0 ? s[0] : null);
    st.ShowWindow();
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    components = new Container();
    ResourceManager resources = new ResourceManager(ApplicationST.class);
    mnuMain = new MainMenu();
    mnuGame = new SubMenu();
    mnuGameNew = new MenuItem();
    mnuGameLoad = new MenuItem();
    mnuGameSave = new MenuItem();
    mnuGameSaveAs = new MenuItem();
    mnuGameLine1 = new MenuItem();
    mnuRetire = new MenuItem();
    mnuGameLine2 = new MenuItem();
    mnuGameExit = new MenuItem();
    mnuView = new SubMenu();
    mnuViewCommander = new MenuItem();
    mnuViewShip = new MenuItem();
    mnuViewPersonnel = new MenuItem();
    mnuViewQuests = new MenuItem();
    mnuViewBank = new MenuItem();
    mnuViewLine1 = new MenuItem();
    mnuHighScores = new MenuItem();
    mnuViewLine2 = new MenuItem();
    mnuOptions = new MenuItem();
    mnuHelp = new SubMenu();
    mnuHelpAbout = new MenuItem();
    picGalacticChart = new PictureBox();
    picShortRangeChart = new PictureBox();
    statusBar = new StatusBar();
    statusBarPanelCash = new StatusBarPanel();
    statusBarPanelBays = new StatusBarPanel();
    statusBarPanelCosts = new StatusBarPanel();
    statusBarPanelExtra = new StatusBarPanel(StatusBarPanelAutoSize.Spring);
    boxShortRangeChart = new GroupBox();
    boxGalacticChart = new GroupBox();
    lblWormhole = new Label();
    lblWormholeLabel = new Label();
    btnJump = new Button();
    btnFind = new Button();
    boxTargetSystem = new GroupBox();
    btnTrack = new Button();
    btnNextSystem = new Button();
    btnPrevSystem = new Button();
    lblTargetOutOfRange = new Label();
    btnWarp = new Button();
    lblTargetPolSys = new Label();
    lblTargetSize = new Label();
    lblTargetTech = new Label();
    lblTargetDistance = new Label();
    lblTargetPirates = new Label();
    lblTargetPolice = new Label();
    lblTargetResource = new Label();
    lblTargetDistanceLabel = new Label();
    lblTargetPiratesLabel = new Label();
    lblTargetPoliceLabel = new Label();
    lblTargetResourceLabel = new Label();
    lblTargetGovtLabel = new Label();
    lblTargetTechLabel = new Label();
    lblTargetSizeLabel = new Label();
    lblTargetName = new Label();
    lblTargetNameLabel = new Label();
    boxCargo = new GroupBox();
    picCargoLine3 = new PictureBox();
    picCargoLine2 = new PictureBox();
    picCargoLine0 = new PictureBox();
    picCargoLine1 = new PictureBox();
    lblTargetPct9 = new Label();
    lblTargetDiff9 = new Label();
    lblTargetPrice9 = new Label();
    btnBuyMax9 = new Button();
    btnBuyQty9 = new Button();
    lblBuyPrice9 = new Label();
    btnSellAll9 = new Button();
    btnSellQty9 = new Button();
    lblSellPrice9 = new Label();
    lblTargetPct8 = new Label();
    lblTargetDiff8 = new Label();
    lblTargetPrice8 = new Label();
    btnBuyMax8 = new Button();
    btnBuyQty8 = new Button();
    lblBuyPrice8 = new Label();
    btnSellAll8 = new Button();
    btnSellQty8 = new Button();
    lblSellPrice8 = new Label();
    lblTargetPct7 = new Label();
    lblTargetDiff7 = new Label();
    lblTargetPrice7 = new Label();
    btnBuyMax7 = new Button();
    btnBuyQty7 = new Button();
    lblBuyPrice7 = new Label();
    btnSellAll7 = new Button();
    btnSellQty7 = new Button();
    lblSellPrice7 = new Label();
    lblTargetPct6 = new Label();
    lblTargetDiff6 = new Label();
    lblTargetPrice6 = new Label();
    btnBuyMax6 = new Button();
    btnBuyQty6 = new Button();
    lblBuyPrice6 = new Label();
    btnSellAll6 = new Button();
    btnSellQty6 = new Button();
    lblSellPrice6 = new Label();
    lblTargetPct5 = new Label();
    lblTargetDiff5 = new Label();
    lblTargetPrice5 = new Label();
    btnBuyMax5 = new Button();
    btnBuyQty5 = new Button();
    lblBuyPrice5 = new Label();
    btnSellAll5 = new Button();
    btnSellQty5 = new Button();
    lblSellPrice5 = new Label();
    lblTargetPct4 = new Label();
    lblTargetDiff4 = new Label();
    lblTargetPrice4 = new Label();
    btnBuyMax4 = new Button();
    btnBuyQty4 = new Button();
    lblBuyPrice4 = new Label();
    btnSellAll4 = new Button();
    btnSellQty4 = new Button();
    lblSellPrice4 = new Label();
    lblTargetPct3 = new Label();
    lblTargetDiff3 = new Label();
    lblTargetPrice3 = new Label();
    btnBuyMax3 = new Button();
    btnBuyQty3 = new Button();
    lblBuyPrice3 = new Label();
    btnSellAll3 = new Button();
    btnSellQty3 = new Button();
    lblSellPrice3 = new Label();
    lblTargetPct2 = new Label();
    lblTargetDiff2 = new Label();
    lblTargetPrice2 = new Label();
    btnBuyMax2 = new Button();
    btnBuyQty2 = new Button();
    lblBuyPrice2 = new Label();
    btnSellAll2 = new Button();
    btnSellQty2 = new Button();
    lblSellPrice2 = new Label();
    lblTargetPct1 = new Label();
    lblTargetDiff1 = new Label();
    lblTargetPrice1 = new Label();
    btnBuyMax1 = new Button();
    btnBuyQty1 = new Button();
    lblBuyPrice1 = new Label();
    lblTargetPctLabel = new Label();
    lblTargetDiffLabel = new Label();
    lblTargetPriceLabel = new Label();
    lblTargetPct0 = new Label();
    lblTargetDiff0 = new Label();
    lblTargetPrice0 = new Label();
    btnBuyMax0 = new Button();
    btnBuyQty0 = new Button();
    lblBuyPrice0 = new Label();
    btnSellAll1 = new Button();
    btnSellQty1 = new Button();
    lblSellPrice1 = new Label();
    btnSellAll0 = new Button();
    btnSellQty0 = new Button();
    lblSellPrice0 = new Label();
    lblTradeTarget = new Label();
    lblBuy = new Label();
    lblSell = new Label();
    lblTradeCmdty9 = new Label();
    lblTradeCmdty8 = new Label();
    lblTradeCmdty2 = new Label();
    lblTradeCmdty0 = new Label();
    lblTradeCmdty1 = new Label();
    lblTradeCmdty6 = new Label();
    lblTradeCmdty5 = new Label();
    lblTradeCmdty4 = new Label();
    lblTradeCmdty3 = new Label();
    lblTradeCmdty7 = new Label();
    boxSystem = new GroupBox();
    btnMerc = new Button();
    btnSpecial = new Button();
    btnNews = new Button();
    lblSystemPressure = new Label();
    lblSystemPressurePre = new Label();
    lblSystemPolSys = new Label();
    lblSystemSize = new Label();
    lblSystemTech = new Label();
    lblSystemPirates = new Label();
    lblSystemPolice = new Label();
    lblSystemResource = new Label();
    lblSystemPiratesLabel = new Label();
    lblSystemPoliceLabel = new Label();
    lblSystemResourseLabel = new Label();
    lblSystemGovtLabel = new Label();
    lblSystemTechLabel = new Label();
    lblSystemSizeLabel = new Label();
    lblSystemName = new Label();
    lblSystemNameLabel = new Label();
    boxShipYard = new GroupBox();
    btnDesign = new Button();
    btnPod = new Button();
    lblEscapePod = new Label();
    btnEquip = new Button();
    btnBuyShip = new Button();
    lblEquipForSale = new Label();
    lblShipsForSale = new Label();
    boxDock = new GroupBox();
    btnRepair = new Button();
    btnFuel = new Button();
    lblFuelStatus = new Label();
    lblFuelCost = new Label();
    lblHullStatus = new Label();
    lblRepairCost = new Label();
    picLine = new PictureBox();
    dlgOpen = new OpenFileDialog();
    dlgSave = new SaveFileDialog();
    ilChartImages = new ImageList(components);
    ilShipImages = new ImageList(components);
    ilDirectionImages = new ImageList(components);
    tipSpecial = new ToolTip(components);
    tipMerc = new ToolTip(components);
    ilEquipmentImages = new ImageList(components);
    ((ISupportInitialize)(statusBarPanelCash)).BeginInit();
    ((ISupportInitialize)(statusBarPanelBays)).BeginInit();
    ((ISupportInitialize)(statusBarPanelCosts)).BeginInit();
    ((ISupportInitialize)(statusBarPanelExtra)).BeginInit();
    boxShortRangeChart.SuspendLayout();
    boxGalacticChart.SuspendLayout();
    boxTargetSystem.SuspendLayout();
    boxCargo.SuspendLayout();
    boxSystem.SuspendLayout();
    boxShipYard.SuspendLayout();
    boxDock.SuspendLayout();
    SuspendLayout();
    // mnuMain
    mnuMain.addAll(mnuGame, mnuView, mnuHelp);
    // mnuGame
    mnuGame.Index = 0;
    mnuGame.addAll(
        mnuGameNew, mnuGameLoad, mnuGameSave, mnuGameSaveAs,
        mnuGameLine1, mnuRetire, mnuGameLine2, mnuGameExit);
    mnuGame.setText("&Game");
    // mnuGameNew
    mnuGameNew.Index = 0;
    mnuGameNew.setText("&New...");
    mnuGameNew.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuGameNew_Click(sender, e);
      }
    });
    // mnuGameLoad
    mnuGameLoad.Index = 1;
    mnuGameLoad.Shortcut = Shortcut.CtrlL;
    mnuGameLoad.setText("&Load...");
    mnuGameLoad.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuGameLoad_Click(sender, e);
      }
    });
    // mnuGameSave
    mnuGameSave.setEnabled(false);
    mnuGameSave.Index = 2;
    mnuGameSave.Shortcut = Shortcut.CtrlS;
    mnuGameSave.setText("&Save");
    mnuGameSave.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuGameSave_Click(sender, e);
      }
    });
    // mnuGameSaveAs
    mnuGameSaveAs.setEnabled(false);
    mnuGameSaveAs.Index = 3;
    mnuGameSaveAs.Shortcut = Shortcut.CtrlA;
    mnuGameSaveAs.setText("Save &As...");
    mnuGameSaveAs.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuGameSaveAs_Click(sender, e);
      }
    });
    // mnuGameLine1
    mnuGameLine1.Index = 4;
    mnuGameLine1.setText("-");
    // mnuRetire
    mnuRetire.setEnabled(false);
    mnuRetire.Index = 5;
    mnuRetire.setText("&Retire");
    mnuRetire.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuRetire_Click(sender, e);
      }
    });
    // mnuGameLine2
    mnuGameLine2.Index = 6;
    mnuGameLine2.setText("-");
    // mnuGameExit
    mnuGameExit.Index = 7;
    mnuGameExit.setText("E&xit");
    mnuGameExit.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuGameExit_Click(sender, e);
      }
    });
    // mnuView
    mnuView.Index = 1;
    mnuView.addAll(
        mnuViewCommander, mnuViewShip, mnuViewPersonnel, mnuViewQuests,
        mnuViewBank, mnuViewLine1, mnuHighScores, mnuViewLine2, mnuOptions);
    mnuView.setText("&View");
    // mnuViewCommander
    mnuViewCommander.setEnabled(false);
    mnuViewCommander.Index = 0;
    mnuViewCommander.Shortcut = Shortcut.CtrlC;
    mnuViewCommander.setText("&Commander Status");
    mnuViewCommander.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuViewCommander_Click(sender, e);
      }
    });
    // mnuViewShip
    mnuViewShip.setEnabled(false);
    mnuViewShip.Index = 1;
    mnuViewShip.Shortcut = Shortcut.CtrlH;
    mnuViewShip.setText("&Ship");
    mnuViewShip.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuViewShip_Click(sender, e);
      }
    });
    // mnuViewPersonnel
    mnuViewPersonnel.setEnabled(false);
    mnuViewPersonnel.Index = 2;
    mnuViewPersonnel.Shortcut = Shortcut.CtrlP;
    mnuViewPersonnel.setText("&Personnel");
    mnuViewPersonnel.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuViewPersonnel_Click(sender, e);
      }
    });
    // mnuViewQuests
    mnuViewQuests.setEnabled(false);
    mnuViewQuests.Index = 3;
    mnuViewQuests.Shortcut = Shortcut.CtrlQ;
    mnuViewQuests.setText("&Quests");
    mnuViewQuests.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuViewQuests_Click(sender, e);
      }
    });
    // mnuViewBank
    mnuViewBank.setEnabled(false);
    mnuViewBank.Index = 4;
    mnuViewBank.Shortcut = Shortcut.CtrlB;
    mnuViewBank.setText("&Bank");
    mnuViewBank.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuViewBank_Click(sender, e);
      }
    });
    // mnuViewLine1
    mnuViewLine1.Index = 5;
    mnuViewLine1.setText("-");
    // mnuHighScores
    mnuHighScores.Index = 6;
    mnuHighScores.setText("&High Scores");
    mnuHighScores.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuHighScores_Click(sender, e);
      }
    });
    // mnuViewLine2
    mnuViewLine2.Index = 7;
    mnuViewLine2.setText("-");
    // mnuOptions
    mnuOptions.Index = 8;
    mnuOptions.setText("Options");
    mnuOptions.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuOptions_Click(sender, e);
      }
    });
    // mnuHelp
    mnuHelp.Index = 2;
    mnuHelp.add(mnuHelpAbout);
    mnuHelp.setText("&Help");
    // mnuHelpAbout
    mnuHelpAbout.Index = 0;
    mnuHelpAbout.setText("&About Space Trader");
    mnuHelpAbout.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        mnuHelpAbout_Click(sender, e);
      }
    });
    // picGalacticChart
    picGalacticChart.setBackColor(Color.white);
    picGalacticChart.setLocation(new Point(8, 16));
    picGalacticChart.setName("picGalacticChart");
    picGalacticChart.setSize(new FormSize(160, 116));
    picGalacticChart.setTabIndex(0);
    picGalacticChart.setTabStop(false);
    picGalacticChart.setPaint(new EventHandler<Object, PaintEventArgs>() {
      @Override
      public void handle(Object sender, PaintEventArgs e) {
        picGalacticChart_Paint(sender, e);
      }
    });
    picGalacticChart.setMouseDown(new EventHandler<Object, MouseEventArgs>() {
      @Override
      public void handle(Object sender, MouseEventArgs e) {
        picGalacticChart_MouseDown(sender, e);
      }
    });
    // picShortRangeChart
    picShortRangeChart.setBackColor(Color.white);
    picShortRangeChart.setLocation(new Point(8, 16));
    picShortRangeChart.setName("picShortRangeChart");
    picShortRangeChart.setSize(new FormSize(160, 145));
    picShortRangeChart.setTabIndex(1);
    picShortRangeChart.setTabStop(false);
    picShortRangeChart.setPaint(new EventHandler<Object, PaintEventArgs>() {
      @Override
      public void handle(Object sender, PaintEventArgs e) {
        picShortRangeChart_Paint(sender, e);
      }
    });
    picShortRangeChart.setMouseDown(new EventHandler<Object, MouseEventArgs>() {
      @Override
      public void handle(Object sender, MouseEventArgs e) {
        picShortRangeChart_MouseDown(sender, e);
      }
    });
    // statusBar
    statusBar.setLocation(new Point(0, 481));
    statusBar.setName("statusBar");
    statusBar.Panels.addAll(Arrays.asList(new StatusBarPanel[]{
          statusBarPanelCash, statusBarPanelBays, statusBarPanelCosts, statusBarPanelExtra
        }));
    statusBar.ShowPanels = true;
    statusBar.setSize(new FormSize(768, 24));
    statusBar.SizingGrip = false;
    statusBar.setTabIndex(2);
    statusBar.PanelClick = new EventHandler<Object, StatusBarPanelClickEventArgs>() {
      @Override
      public void handle(Object sender, StatusBarPanelClickEventArgs e) {
        statusBar_PanelClick(sender, e);
      }
    };
    // statusBarPanelCash
    statusBarPanelCash.setMinWidth(112);
    statusBarPanelCash.setText(" Cash: 88,888,888 cr.");
    statusBarPanelCash.setWidth(112);
    // statusBarPanelBays
    statusBarPanelBays.setMinWidth(80);
    statusBarPanelBays.setText(" Bays: 88/88");
    statusBarPanelBays.setWidth(80);
    // statusBarPanelCosts
    statusBarPanelCosts.setMinWidth(120);
    statusBarPanelCosts.setText(" Current Costs: 888 cr.");
    statusBarPanelCosts.setWidth(120);
    // statusBarPanelExtra
    //statusBarPanelExtra.AutoSize = StatusBarPanelAutoSize.Spring;
    //statusBarPanelExtra.setMinWidth(120);
    //statusBarPanelExtra.setWidth();

    // boxShortRangeChart
    boxShortRangeChart.Anchor = AnchorStyles.Top_Right;
    boxShortRangeChart.Controls.add(picShortRangeChart);
    boxShortRangeChart.setLocation(new Point(364, 306));
    boxShortRangeChart.setName("boxShortRangeChart");
    boxShortRangeChart.setSize(new FormSize(176, 168));
    boxShortRangeChart.setTabIndex(6);
    boxShortRangeChart.setTabStop(false);
    boxShortRangeChart.setText("Short-Range Chart");
    // boxGalacticChart
    boxGalacticChart.Anchor = AnchorStyles.Top_Right;
    boxGalacticChart.setBackColor(SystemColors.Control);
    boxGalacticChart.Controls.add(lblWormhole);
    boxGalacticChart.Controls.add(lblWormholeLabel);
    boxGalacticChart.Controls.add(btnJump);
    boxGalacticChart.Controls.add(btnFind);
    boxGalacticChart.Controls.add(picGalacticChart);
    boxGalacticChart.setLocation(new Point(180, 306));
    boxGalacticChart.setName("boxGalacticChart");
    boxGalacticChart.setSize(new FormSize(176, 168));
    boxGalacticChart.setTabIndex(5);
    boxGalacticChart.setTabStop(false);
    boxGalacticChart.setText("Galactic Chart");
    // lblWormhole
    lblWormhole.setLocation(new Point(8, 148));
    lblWormhole.setName("lblWormhole");
    lblWormhole.setSize(new FormSize(72, 13));
    lblWormhole.setTabIndex(29);
    lblWormhole.setText("Tarchannen");
    // lblWormholeLabel
    lblWormholeLabel.setLocation(new Point(8, 135));
    lblWormholeLabel.setName("lblWormholeLabel");
    lblWormholeLabel.setSize(new FormSize(72, 13));
    lblWormholeLabel.setTabIndex(28);
    lblWormholeLabel.setText("Wormhole to");
    // btnJump
    btnJump.setFlatStyle(FlatStyle.Flat);
    btnJump.setLocation(new Point(81, 138));
    btnJump.setName("btnJump");
    btnJump.setSize(new FormSize(42, 22));
    btnJump.setTabIndex(55);
    btnJump.setText("Jump");
    btnJump.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnJump_Click(sender, e);
      }
    });
    // btnFind
    btnFind.setFlatStyle(FlatStyle.Flat);
    btnFind.setLocation(new Point(132, 138));
    btnFind.setName("btnFind");
    btnFind.setSize(new FormSize(36, 22));
    btnFind.setTabIndex(56);
    btnFind.setText("Find");
    btnFind.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnFind_Click(sender, e);
      }
    });
    // boxTargetSystem
    boxTargetSystem.Anchor = AnchorStyles.Top_Right;
    boxTargetSystem.Controls.add(btnTrack);
    boxTargetSystem.Controls.add(btnNextSystem);
    boxTargetSystem.Controls.add(btnPrevSystem);
    boxTargetSystem.Controls.add(lblTargetOutOfRange);
    boxTargetSystem.Controls.add(btnWarp);
    boxTargetSystem.Controls.add(lblTargetPolSys);
    boxTargetSystem.Controls.add(lblTargetSize);
    boxTargetSystem.Controls.add(lblTargetTech);
    boxTargetSystem.Controls.add(lblTargetDistance);
    boxTargetSystem.Controls.add(lblTargetPirates);
    boxTargetSystem.Controls.add(lblTargetPolice);
    boxTargetSystem.Controls.add(lblTargetResource);
    boxTargetSystem.Controls.add(lblTargetDistanceLabel);
    boxTargetSystem.Controls.add(lblTargetPiratesLabel);
    boxTargetSystem.Controls.add(lblTargetPoliceLabel);
    boxTargetSystem.Controls.add(lblTargetResourceLabel);
    boxTargetSystem.Controls.add(lblTargetGovtLabel);
    boxTargetSystem.Controls.add(lblTargetTechLabel);
    boxTargetSystem.Controls.add(lblTargetSizeLabel);
    boxTargetSystem.Controls.add(lblTargetName);
    boxTargetSystem.Controls.add(lblTargetNameLabel);
    boxTargetSystem.setLocation(new Point(548, 306));
    boxTargetSystem.setName("boxTargetSystem");
    boxTargetSystem.setSize(new FormSize(216, 168));
    boxTargetSystem.setTabIndex(7);
    boxTargetSystem.setTabStop(false);
    boxTargetSystem.setText("Target System");
    // btnTrack
    btnTrack.setFlatStyle(FlatStyle.Flat);
    btnTrack.setLocation(new Point(160, 140));
    btnTrack.setName("btnTrack");
    btnTrack.setSize(new FormSize(44, 22));
    btnTrack.setTabIndex(60);
    btnTrack.setText("Track");
    btnTrack.setVisible(false);
    btnTrack.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnTrack_Click(sender, e);
      }
    });
    // btnNextSystem
    btnNextSystem.setFlatStyle(FlatStyle.Flat);
    btnNextSystem.setLocation(new Point(186, 16));
    btnNextSystem.setName("btnNextSystem");
    btnNextSystem.setSize(new FormSize(18, 18));
    btnNextSystem.setTabIndex(58);
    btnNextSystem.setText(">");
    btnNextSystem.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnNextSystem_Click(sender, e);
      }
    });
    // btnPrevSystem
    btnPrevSystem.setFlatStyle(FlatStyle.Flat);
    btnPrevSystem.setLocation(new Point(160, 16));
    btnPrevSystem.setName("btnPrevSystem");
    btnPrevSystem.setSize(new FormSize(18, 18));
    btnPrevSystem.setTabIndex(57);
    btnPrevSystem.setText("<");
    btnPrevSystem.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPrevSystem_Click(sender, e);
      }
    });
    // lblTargetOutOfRange
    lblTargetOutOfRange.setLocation(new Point(8, 144));
    lblTargetOutOfRange.setName("lblTargetOutOfRange");
    lblTargetOutOfRange.setSize(new FormSize(144, 13));
    lblTargetOutOfRange.setTabIndex(17);
    lblTargetOutOfRange.setText("This system is out of range.");
    // btnWarp
    btnWarp.setFlatStyle(FlatStyle.Flat);
    btnWarp.setLocation(new Point(160, 98));
    btnWarp.setName("btnWarp");
    btnWarp.setSize(new FormSize(44, 44));
    btnWarp.setTabIndex(59);
    btnWarp.setText("Warp");
    btnWarp.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnWarp_Click(sender, e);
      }
    });
    // lblTargetPolSys
    lblTargetPolSys.setLocation(new Point(88, 64));
    lblTargetPolSys.setName("lblTargetPolSys");
    lblTargetPolSys.setSize(new FormSize(91, 13));
    lblTargetPolSys.setTabIndex(15);
    lblTargetPolSys.setText("Communist State");
    // lblTargetSize
    lblTargetSize.setLocation(new Point(88, 32));
    lblTargetSize.setName("lblTargetSize");
    lblTargetSize.setSize(new FormSize(45, 13));
    lblTargetSize.setTabIndex(14);
    lblTargetSize.setText("Medium");
    // lblTargetTech
    lblTargetTech.setLocation(new Point(88, 48));
    lblTargetTech.setName("lblTargetTech");
    lblTargetTech.setSize(new FormSize(82, 13));
    lblTargetTech.setTabIndex(13);
    lblTargetTech.setText("Pre-Agricultural");
    // lblTargetDistance
    lblTargetDistance.setLocation(new Point(88, 128));
    lblTargetDistance.setName("lblTargetDistance");
    lblTargetDistance.setSize(new FormSize(66, 13));
    lblTargetDistance.setTabIndex(12);
    lblTargetDistance.setText("888 parsecs");
    // lblTargetPirates
    lblTargetPirates.setLocation(new Point(88, 112));
    lblTargetPirates.setName("lblTargetPirates");
    lblTargetPirates.setSize(new FormSize(53, 13));
    lblTargetPirates.setTabIndex(11);
    lblTargetPirates.setText("Abundant");
    // lblTargetPolice
    lblTargetPolice.setLocation(new Point(88, 96));
    lblTargetPolice.setName("lblTargetPolice");
    lblTargetPolice.setSize(new FormSize(53, 13));
    lblTargetPolice.setTabIndex(10);
    lblTargetPolice.setText("Abundant");
    // lblTargetResource
    lblTargetResource.setLocation(new Point(88, 80));
    lblTargetResource.setName("lblTargetResource");
    lblTargetResource.setSize(new FormSize(105, 13));
    lblTargetResource.setTabIndex(9);
    lblTargetResource.setText("Sweetwater Oceans");
    // lblTargetDistanceLabel
    lblTargetDistanceLabel.setAutoSize(true);
    lblTargetDistanceLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetDistanceLabel.setLocation(new Point(8, 128));
    lblTargetDistanceLabel.setName("lblTargetDistanceLabel");
    lblTargetDistanceLabel.setSize(new FormSize(53, 16));
    lblTargetDistanceLabel.setTabIndex(8);
    lblTargetDistanceLabel.setText("Distance:");
    // lblTargetPiratesLabel
    lblTargetPiratesLabel.setAutoSize(true);
    lblTargetPiratesLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetPiratesLabel.setLocation(new Point(8, 112));
    lblTargetPiratesLabel.setName("lblTargetPiratesLabel");
    lblTargetPiratesLabel.setSize(new FormSize(44, 16));
    lblTargetPiratesLabel.setTabIndex(7);
    lblTargetPiratesLabel.setText("Pirates:");
    // lblTargetPoliceLabel
    lblTargetPoliceLabel.setAutoSize(true);
    lblTargetPoliceLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetPoliceLabel.setLocation(new Point(8, 96));
    lblTargetPoliceLabel.setName("lblTargetPoliceLabel");
    lblTargetPoliceLabel.setSize(new FormSize(40, 16));
    lblTargetPoliceLabel.setTabIndex(6);
    lblTargetPoliceLabel.setText("Police:");
    // lblTargetResourceLabel
    lblTargetResourceLabel.setAutoSize(true);
    lblTargetResourceLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetResourceLabel.setLocation(new Point(8, 80));
    lblTargetResourceLabel.setName("lblTargetResourceLabel");
    lblTargetResourceLabel.setSize(new FormSize(58, 16));
    lblTargetResourceLabel.setTabIndex(5);
    lblTargetResourceLabel.setText("Resource:");
    // lblTargetGovtLabel
    lblTargetGovtLabel.setAutoSize(true);
    lblTargetGovtLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetGovtLabel.setLocation(new Point(8, 64));
    lblTargetGovtLabel.setName("lblTargetGovtLabel");
    lblTargetGovtLabel.setSize(new FormSize(72, 16));
    lblTargetGovtLabel.setTabIndex(4);
    lblTargetGovtLabel.setText("Government:");
    // lblTargetTechLabel
    lblTargetTechLabel.setAutoSize(true);
    lblTargetTechLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetTechLabel.setLocation(new Point(8, 48));
    lblTargetTechLabel.setName("lblTargetTechLabel");
    lblTargetTechLabel.setSize(new FormSize(65, 16));
    lblTargetTechLabel.setTabIndex(3);
    lblTargetTechLabel.setText("Tech Level:");
    // lblTargetSizeLabel
    lblTargetSizeLabel.setAutoSize(true);
    lblTargetSizeLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetSizeLabel.setLocation(new Point(8, 32));
    lblTargetSizeLabel.setName("lblTargetSizeLabel");
    lblTargetSizeLabel.setSize(new FormSize(31, 16));
    lblTargetSizeLabel.setTabIndex(2);
    lblTargetSizeLabel.setText("Size:");
    // lblTargetName
    lblTargetName.setLocation(new Point(88, 16));
    lblTargetName.setName("lblTargetName");
    lblTargetName.setSize(new FormSize(65, 13));
    lblTargetName.setTabIndex(1);
    lblTargetName.setText("Tarchannen");
    // lblTargetNameLabel
    lblTargetNameLabel.setAutoSize(true);
    lblTargetNameLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblTargetNameLabel.setLocation(new Point(8, 16));
    lblTargetNameLabel.setName("lblTargetNameLabel");
    lblTargetNameLabel.setSize(new FormSize(39, 16));
    lblTargetNameLabel.setTabIndex(0);
    lblTargetNameLabel.setText("Name:");
    // boxCargo
    boxCargo.Anchor = AnchorStyles.Top_Right;
    boxCargo.Controls.add(picCargoLine3);
    boxCargo.Controls.add(picCargoLine2);
    boxCargo.Controls.add(picCargoLine0);
    boxCargo.Controls.add(picCargoLine1);
    boxCargo.Controls.add(lblTargetPct9);
    boxCargo.Controls.add(lblTargetDiff9);
    boxCargo.Controls.add(lblTargetPrice9);
    boxCargo.Controls.add(btnBuyMax9);
    boxCargo.Controls.add(btnBuyQty9);
    boxCargo.Controls.add(lblBuyPrice9);
    boxCargo.Controls.add(btnSellAll9);
    boxCargo.Controls.add(btnSellQty9);
    boxCargo.Controls.add(lblSellPrice9);
    boxCargo.Controls.add(lblTargetPct8);
    boxCargo.Controls.add(lblTargetDiff8);
    boxCargo.Controls.add(lblTargetPrice8);
    boxCargo.Controls.add(btnBuyMax8);
    boxCargo.Controls.add(btnBuyQty8);
    boxCargo.Controls.add(lblBuyPrice8);
    boxCargo.Controls.add(btnSellAll8);
    boxCargo.Controls.add(btnSellQty8);
    boxCargo.Controls.add(lblSellPrice8);
    boxCargo.Controls.add(lblTargetPct7);
    boxCargo.Controls.add(lblTargetDiff7);
    boxCargo.Controls.add(lblTargetPrice7);
    boxCargo.Controls.add(btnBuyMax7);
    boxCargo.Controls.add(btnBuyQty7);
    boxCargo.Controls.add(lblBuyPrice7);
    boxCargo.Controls.add(btnSellAll7);
    boxCargo.Controls.add(btnSellQty7);
    boxCargo.Controls.add(lblSellPrice7);
    boxCargo.Controls.add(lblTargetPct6);
    boxCargo.Controls.add(lblTargetDiff6);
    boxCargo.Controls.add(lblTargetPrice6);
    boxCargo.Controls.add(btnBuyMax6);
    boxCargo.Controls.add(btnBuyQty6);
    boxCargo.Controls.add(lblBuyPrice6);
    boxCargo.Controls.add(btnSellAll6);
    boxCargo.Controls.add(btnSellQty6);
    boxCargo.Controls.add(lblSellPrice6);
    boxCargo.Controls.add(lblTargetPct5);
    boxCargo.Controls.add(lblTargetDiff5);
    boxCargo.Controls.add(lblTargetPrice5);
    boxCargo.Controls.add(btnBuyMax5);
    boxCargo.Controls.add(btnBuyQty5);
    boxCargo.Controls.add(lblBuyPrice5);
    boxCargo.Controls.add(btnSellAll5);
    boxCargo.Controls.add(btnSellQty5);
    boxCargo.Controls.add(lblSellPrice5);
    boxCargo.Controls.add(lblTargetPct4);
    boxCargo.Controls.add(lblTargetDiff4);
    boxCargo.Controls.add(lblTargetPrice4);
    boxCargo.Controls.add(btnBuyMax4);
    boxCargo.Controls.add(btnBuyQty4);
    boxCargo.Controls.add(lblBuyPrice4);
    boxCargo.Controls.add(btnSellAll4);
    boxCargo.Controls.add(btnSellQty4);
    boxCargo.Controls.add(lblSellPrice4);
    boxCargo.Controls.add(lblTargetPct3);
    boxCargo.Controls.add(lblTargetDiff3);
    boxCargo.Controls.add(lblTargetPrice3);
    boxCargo.Controls.add(btnBuyMax3);
    boxCargo.Controls.add(btnBuyQty3);
    boxCargo.Controls.add(lblBuyPrice3);
    boxCargo.Controls.add(btnSellAll3);
    boxCargo.Controls.add(btnSellQty3);
    boxCargo.Controls.add(lblSellPrice3);
    boxCargo.Controls.add(lblTargetPct2);
    boxCargo.Controls.add(lblTargetDiff2);
    boxCargo.Controls.add(lblTargetPrice2);
    boxCargo.Controls.add(btnBuyMax2);
    boxCargo.Controls.add(btnBuyQty2);
    boxCargo.Controls.add(lblBuyPrice2);
    boxCargo.Controls.add(btnSellAll2);
    boxCargo.Controls.add(btnSellQty2);
    boxCargo.Controls.add(lblSellPrice2);
    boxCargo.Controls.add(lblTargetPct1);
    boxCargo.Controls.add(lblTargetDiff1);
    boxCargo.Controls.add(lblTargetPrice1);
    boxCargo.Controls.add(btnBuyMax1);
    boxCargo.Controls.add(btnBuyQty1);
    boxCargo.Controls.add(lblBuyPrice1);
    boxCargo.Controls.add(lblTargetPctLabel);
    boxCargo.Controls.add(lblTargetDiffLabel);
    boxCargo.Controls.add(lblTargetPriceLabel);
    boxCargo.Controls.add(lblTargetPct0);
    boxCargo.Controls.add(lblTargetDiff0);
    boxCargo.Controls.add(lblTargetPrice0);
    boxCargo.Controls.add(btnBuyMax0);
    boxCargo.Controls.add(btnBuyQty0);
    boxCargo.Controls.add(lblBuyPrice0);
    boxCargo.Controls.add(btnSellAll1);
    boxCargo.Controls.add(btnSellQty1);
    boxCargo.Controls.add(lblSellPrice1);
    boxCargo.Controls.add(btnSellAll0);
    boxCargo.Controls.add(btnSellQty0);
    boxCargo.Controls.add(lblSellPrice0);
    boxCargo.Controls.add(lblTradeTarget);
    boxCargo.Controls.add(lblBuy);
    boxCargo.Controls.add(lblSell);
    boxCargo.Controls.add(lblTradeCmdty9);
    boxCargo.Controls.add(lblTradeCmdty8);
    boxCargo.Controls.add(lblTradeCmdty2);
    boxCargo.Controls.add(lblTradeCmdty0);
    boxCargo.Controls.add(lblTradeCmdty1);
    boxCargo.Controls.add(lblTradeCmdty6);
    boxCargo.Controls.add(lblTradeCmdty5);
    boxCargo.Controls.add(lblTradeCmdty4);
    boxCargo.Controls.add(lblTradeCmdty3);
    boxCargo.Controls.add(lblTradeCmdty7);
    boxCargo.setLocation(new Point(252, 2));
    boxCargo.setName("boxCargo");
    boxCargo.setSize(new FormSize(512, 300));
    boxCargo.setTabIndex(8);
    boxCargo.setTabStop(false);
    boxCargo.setText("Cargo");
    // picCargoLine3
    picCargoLine3.setBackColor(Color.darkGray);
    picCargoLine3.setLocation(new Point(8, 52));
    picCargoLine3.setName("picCargoLine3");
    picCargoLine3.setSize(new FormSize(496, 1));
    picCargoLine3.setTabIndex(131);
    picCargoLine3.setTabStop(false);
    // picCargoLine2
    picCargoLine2.setBackColor(Color.darkGray);
    picCargoLine2.setLocation(new Point(352, 32));
    picCargoLine2.setName("picCargoLine2");
    picCargoLine2.setSize(new FormSize(1, 262));
    picCargoLine2.setTabIndex(130);
    picCargoLine2.setTabStop(false);
    // picCargoLine0
    picCargoLine0.setBackColor(Color.darkGray);
    picCargoLine0.setLocation(new Point(71, 32));
    picCargoLine0.setName("picCargoLine0");
    picCargoLine0.setSize(new FormSize(1, 262));
    picCargoLine0.setTabIndex(129);
    picCargoLine0.setTabStop(false);
    // picCargoLine1
    picCargoLine1.setBackColor(Color.darkGray);
    picCargoLine1.setLocation(new Point(218, 32));
    picCargoLine1.setName("picCargoLine1");
    picCargoLine1.setSize(new FormSize(1, 262));
    picCargoLine1.setTabIndex(128);
    picCargoLine1.setTabStop(false);
    // lblTargetPct9
    lblTargetPct9.setLocation(new Point(466, 276));
    lblTargetPct9.setName("lblTargetPct9");
    lblTargetPct9.setSize(new FormSize(37, 13));
    lblTargetPct9.setTabIndex(127);
    lblTargetPct9.setText("--------");
    lblTargetPct9.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff9
    lblTargetDiff9.setLocation(new Point(410, 276));
    lblTargetDiff9.setName("lblTargetDiff9");
    lblTargetDiff9.setSize(new FormSize(52, 13));
    lblTargetDiff9.setTabIndex(126);
    lblTargetDiff9.setText("------------");
    lblTargetDiff9.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice9
    lblTargetPrice9.setLocation(new Point(358, 276));
    lblTargetPrice9.setName("lblTargetPrice9");
    lblTargetPrice9.setSize(new FormSize(48, 13));
    lblTargetPrice9.setTabIndex(125);
    lblTargetPrice9.setText("-----------");
    lblTargetPrice9.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax9
    btnBuyMax9.setFlatStyle(FlatStyle.Flat);
    btnBuyMax9.setLocation(new Point(262, 272));
    btnBuyMax9.setName("btnBuyMax9");
    btnBuyMax9.setSize(new FormSize(36, 22));
    btnBuyMax9.setTabIndex(51);
    btnBuyMax9.setText("Max");
    btnBuyMax9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty9
    btnBuyQty9.setFlatStyle(FlatStyle.Flat);
    btnBuyQty9.setLocation(new Point(227, 272));
    btnBuyQty9.setName("btnBuyQty9");
    btnBuyQty9.setSize(new FormSize(28, 22));
    btnBuyQty9.setTabIndex(50);
    btnBuyQty9.setText("88");
    btnBuyQty9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice9
    lblBuyPrice9.setLocation(new Point(302, 276));
    lblBuyPrice9.setName("lblBuyPrice9");
    lblBuyPrice9.setSize(new FormSize(48, 13));
    lblBuyPrice9.setTabIndex(122);
    lblBuyPrice9.setText("not sold");
    lblBuyPrice9.TextAlign = ContentAlignment.TopRight;
    // btnSellAll9
    btnSellAll9.setFlatStyle(FlatStyle.Flat);
    btnSellAll9.setLocation(new Point(115, 272));
    btnSellAll9.setName("btnSellAll9");
    btnSellAll9.setSize(new FormSize(44, 22));
    btnSellAll9.setTabIndex(49);
    btnSellAll9.setText("Dump");
    btnSellAll9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty9
    btnSellQty9.setFlatStyle(FlatStyle.Flat);
    btnSellQty9.setLocation(new Point(80, 272));
    btnSellQty9.setName("btnSellQty9");
    btnSellQty9.setSize(new FormSize(28, 22));
    btnSellQty9.setTabIndex(48);
    btnSellQty9.setText("88");
    btnSellQty9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice9
    lblSellPrice9.setLocation(new Point(163, 276));
    lblSellPrice9.setName("lblSellPrice9");
    lblSellPrice9.setSize(new FormSize(48, 13));
    lblSellPrice9.setTabIndex(119);
    lblSellPrice9.setText("no trade");
    lblSellPrice9.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct8
    lblTargetPct8.setLocation(new Point(466, 252));
    lblTargetPct8.setName("lblTargetPct8");
    lblTargetPct8.setSize(new FormSize(37, 13));
    lblTargetPct8.setTabIndex(118);
    lblTargetPct8.setText("-888%");
    lblTargetPct8.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff8
    lblTargetDiff8.setLocation(new Point(410, 252));
    lblTargetDiff8.setName("lblTargetDiff8");
    lblTargetDiff8.setSize(new FormSize(52, 13));
    lblTargetDiff8.setTabIndex(117);
    lblTargetDiff8.setText("-8,888 cr.");
    lblTargetDiff8.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice8
    lblTargetPrice8.setLocation(new Point(358, 252));
    lblTargetPrice8.setName("lblTargetPrice8");
    lblTargetPrice8.setSize(new FormSize(48, 13));
    lblTargetPrice8.setTabIndex(116);
    lblTargetPrice8.setText("8,888 cr.");
    lblTargetPrice8.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax8
    btnBuyMax8.setFlatStyle(FlatStyle.Flat);
    btnBuyMax8.setLocation(new Point(262, 248));
    btnBuyMax8.setName("btnBuyMax8");
    btnBuyMax8.setSize(new FormSize(36, 22));
    btnBuyMax8.setTabIndex(47);
    btnBuyMax8.setText("Max");
    btnBuyMax8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty8
    btnBuyQty8.setFlatStyle(FlatStyle.Flat);
    btnBuyQty8.setLocation(new Point(227, 248));
    btnBuyQty8.setName("btnBuyQty8");
    btnBuyQty8.setSize(new FormSize(28, 22));
    btnBuyQty8.setTabIndex(46);
    btnBuyQty8.setText("88");
    btnBuyQty8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice8
    lblBuyPrice8.setLocation(new Point(302, 252));
    lblBuyPrice8.setName("lblBuyPrice8");
    lblBuyPrice8.setSize(new FormSize(48, 13));
    lblBuyPrice8.setTabIndex(113);
    lblBuyPrice8.setText("8,888 cr.");
    lblBuyPrice8.TextAlign = ContentAlignment.TopRight;
    // btnSellAll8
    btnSellAll8.setFlatStyle(FlatStyle.Flat);
    btnSellAll8.setLocation(new Point(115, 248));
    btnSellAll8.setName("btnSellAll8");
    btnSellAll8.setSize(new FormSize(44, 22));
    btnSellAll8.setTabIndex(45);
    btnSellAll8.setText("All");
    btnSellAll8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty8
    btnSellQty8.setFlatStyle(FlatStyle.Flat);
    btnSellQty8.setLocation(new Point(80, 248));
    btnSellQty8.setName("btnSellQty8");
    btnSellQty8.setSize(new FormSize(28, 22));
    btnSellQty8.setTabIndex(44);
    btnSellQty8.setText("88");
    btnSellQty8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice8
    lblSellPrice8.setLocation(new Point(163, 252));
    lblSellPrice8.setName("lblSellPrice8");
    lblSellPrice8.setSize(new FormSize(48, 13));
    lblSellPrice8.setTabIndex(110);
    lblSellPrice8.setText("8,888 cr.");
    lblSellPrice8.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct7
    lblTargetPct7.setLocation(new Point(466, 228));
    lblTargetPct7.setName("lblTargetPct7");
    lblTargetPct7.setSize(new FormSize(37, 13));
    lblTargetPct7.setTabIndex(109);
    lblTargetPct7.setText("-888%");
    lblTargetPct7.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff7
    lblTargetDiff7.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Regular, GraphicsUnit.Point, ((byte)(0))));
    lblTargetDiff7.setLocation(new Point(410, 228));
    lblTargetDiff7.setName("lblTargetDiff7");
    lblTargetDiff7.setSize(new FormSize(52, 13));
    lblTargetDiff7.setTabIndex(108);
    lblTargetDiff7.setText("-8,888 cr.");
    lblTargetDiff7.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice7
    lblTargetPrice7.setLocation(new Point(358, 228));
    lblTargetPrice7.setName("lblTargetPrice7");
    lblTargetPrice7.setSize(new FormSize(48, 13));
    lblTargetPrice7.setTabIndex(107);
    lblTargetPrice7.setText("8,888 cr.");
    lblTargetPrice7.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax7
    btnBuyMax7.setFlatStyle(FlatStyle.Flat);
    btnBuyMax7.setLocation(new Point(262, 224));
    btnBuyMax7.setName("btnBuyMax7");
    btnBuyMax7.setSize(new FormSize(36, 22));
    btnBuyMax7.setTabIndex(43);
    btnBuyMax7.setText("Max");
    btnBuyMax7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty7
    btnBuyQty7.setFlatStyle(FlatStyle.Flat);
    btnBuyQty7.setLocation(new Point(227, 224));
    btnBuyQty7.setName("btnBuyQty7");
    btnBuyQty7.setSize(new FormSize(28, 22));
    btnBuyQty7.setTabIndex(42);
    btnBuyQty7.setText("88");
    btnBuyQty7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice7
    lblBuyPrice7.setLocation(new Point(302, 228));
    lblBuyPrice7.setName("lblBuyPrice7");
    lblBuyPrice7.setSize(new FormSize(48, 13));
    lblBuyPrice7.setTabIndex(104);
    lblBuyPrice7.setText("8,888 cr.");
    lblBuyPrice7.TextAlign = ContentAlignment.TopRight;
    // btnSellAll7
    btnSellAll7.setFlatStyle(FlatStyle.Flat);
    btnSellAll7.setLocation(new Point(115, 224));
    btnSellAll7.setName("btnSellAll7");
    btnSellAll7.setSize(new FormSize(44, 22));
    btnSellAll7.setTabIndex(41);
    btnSellAll7.setText("All");
    btnSellAll7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty7
    btnSellQty7.setFlatStyle(FlatStyle.Flat);
    btnSellQty7.setLocation(new Point(80, 224));
    btnSellQty7.setName("btnSellQty7");
    btnSellQty7.setSize(new FormSize(28, 22));
    btnSellQty7.setTabIndex(40);
    btnSellQty7.setText("88");
    btnSellQty7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice7
    lblSellPrice7.setLocation(new Point(163, 228));
    lblSellPrice7.setName("lblSellPrice7");
    lblSellPrice7.setSize(new FormSize(48, 13));
    lblSellPrice7.setTabIndex(101);
    lblSellPrice7.setText("8,888 cr.");
    lblSellPrice7.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct6
    lblTargetPct6.setLocation(new Point(466, 204));
    lblTargetPct6.setName("lblTargetPct6");
    lblTargetPct6.setSize(new FormSize(37, 13));
    lblTargetPct6.setTabIndex(100);
    lblTargetPct6.setText("-888%");
    lblTargetPct6.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff6
    lblTargetDiff6.setLocation(new Point(410, 204));
    lblTargetDiff6.setName("lblTargetDiff6");
    lblTargetDiff6.setSize(new FormSize(52, 13));
    lblTargetDiff6.setTabIndex(99);
    lblTargetDiff6.setText("-8,888 cr.");
    lblTargetDiff6.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice6
    lblTargetPrice6.setLocation(new Point(358, 204));
    lblTargetPrice6.setName("lblTargetPrice6");
    lblTargetPrice6.setSize(new FormSize(48, 13));
    lblTargetPrice6.setTabIndex(98);
    lblTargetPrice6.setText("8,888 cr.");
    lblTargetPrice6.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax6
    btnBuyMax6.setFlatStyle(FlatStyle.Flat);
    btnBuyMax6.setLocation(new Point(262, 200));
    btnBuyMax6.setName("btnBuyMax6");
    btnBuyMax6.setSize(new FormSize(36, 22));
    btnBuyMax6.setTabIndex(39);
    btnBuyMax6.setText("Max");
    btnBuyMax6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty6
    btnBuyQty6.setFlatStyle(FlatStyle.Flat);
    btnBuyQty6.setLocation(new Point(227, 200));
    btnBuyQty6.setName("btnBuyQty6");
    btnBuyQty6.setSize(new FormSize(28, 22));
    btnBuyQty6.setTabIndex(38);
    btnBuyQty6.setText("88");
    btnBuyQty6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice6
    lblBuyPrice6.setLocation(new Point(302, 204));
    lblBuyPrice6.setName("lblBuyPrice6");
    lblBuyPrice6.setSize(new FormSize(48, 13));
    lblBuyPrice6.setTabIndex(95);
    lblBuyPrice6.setText("8,888 cr.");
    lblBuyPrice6.TextAlign = ContentAlignment.TopRight;
    // btnSellAll6
    btnSellAll6.setFlatStyle(FlatStyle.Flat);
    btnSellAll6.setLocation(new Point(115, 200));
    btnSellAll6.setName("btnSellAll6");
    btnSellAll6.setSize(new FormSize(44, 22));
    btnSellAll6.setTabIndex(37);
    btnSellAll6.setText("All");
    btnSellAll6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty6
    btnSellQty6.setFlatStyle(FlatStyle.Flat);
    btnSellQty6.setLocation(new Point(80, 200));
    btnSellQty6.setName("btnSellQty6");
    btnSellQty6.setSize(new FormSize(28, 22));
    btnSellQty6.setTabIndex(36);
    btnSellQty6.setText("88");
    btnSellQty6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice6
    lblSellPrice6.setLocation(new Point(163, 204));
    lblSellPrice6.setName("lblSellPrice6");
    lblSellPrice6.setSize(new FormSize(48, 13));
    lblSellPrice6.setTabIndex(92);
    lblSellPrice6.setText("8,888 cr.");
    lblSellPrice6.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct5
    lblTargetPct5.setLocation(new Point(466, 180));
    lblTargetPct5.setName("lblTargetPct5");
    lblTargetPct5.setSize(new FormSize(37, 13));
    lblTargetPct5.setTabIndex(91);
    lblTargetPct5.setText("-888%");
    lblTargetPct5.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff5
    lblTargetDiff5.setLocation(new Point(410, 180));
    lblTargetDiff5.setName("lblTargetDiff5");
    lblTargetDiff5.setSize(new FormSize(52, 13));
    lblTargetDiff5.setTabIndex(90);
    lblTargetDiff5.setText("-8,888 cr.");
    lblTargetDiff5.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice5
    lblTargetPrice5.setLocation(new Point(358, 180));
    lblTargetPrice5.setName("lblTargetPrice5");
    lblTargetPrice5.setSize(new FormSize(48, 13));
    lblTargetPrice5.setTabIndex(89);
    lblTargetPrice5.setText("8,888 cr.");
    lblTargetPrice5.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax5
    btnBuyMax5.setFlatStyle(FlatStyle.Flat);
    btnBuyMax5.setLocation(new Point(262, 176));
    btnBuyMax5.setName("btnBuyMax5");
    btnBuyMax5.setSize(new FormSize(36, 22));
    btnBuyMax5.setTabIndex(35);
    btnBuyMax5.setText("Max");
    btnBuyMax5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty5
    btnBuyQty5.setFlatStyle(FlatStyle.Flat);
    btnBuyQty5.setLocation(new Point(227, 176));
    btnBuyQty5.setName("btnBuyQty5");
    btnBuyQty5.setSize(new FormSize(28, 22));
    btnBuyQty5.setTabIndex(34);
    btnBuyQty5.setText("88");
    btnBuyQty5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice5
    lblBuyPrice5.setLocation(new Point(302, 180));
    lblBuyPrice5.setName("lblBuyPrice5");
    lblBuyPrice5.setSize(new FormSize(48, 13));
    lblBuyPrice5.setTabIndex(86);
    lblBuyPrice5.setText("8,888 cr.");
    lblBuyPrice5.TextAlign = ContentAlignment.TopRight;
    // btnSellAll5
    btnSellAll5.setFlatStyle(FlatStyle.Flat);
    btnSellAll5.setLocation(new Point(115, 176));
    btnSellAll5.setName("btnSellAll5");
    btnSellAll5.setSize(new FormSize(44, 22));
    btnSellAll5.setTabIndex(33);
    btnSellAll5.setText("All");
    btnSellAll5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty5
    btnSellQty5.setFlatStyle(FlatStyle.Flat);
    btnSellQty5.setLocation(new Point(80, 176));
    btnSellQty5.setName("btnSellQty5");
    btnSellQty5.setSize(new FormSize(28, 22));
    btnSellQty5.setTabIndex(32);
    btnSellQty5.setText("88");
    btnSellQty5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice5
    lblSellPrice5.setLocation(new Point(163, 180));
    lblSellPrice5.setName("lblSellPrice5");
    lblSellPrice5.setSize(new FormSize(48, 13));
    lblSellPrice5.setTabIndex(83);
    lblSellPrice5.setText("8,888 cr.");
    lblSellPrice5.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct4
    lblTargetPct4.setLocation(new Point(466, 156));
    lblTargetPct4.setName("lblTargetPct4");
    lblTargetPct4.setSize(new FormSize(37, 13));
    lblTargetPct4.setTabIndex(82);
    lblTargetPct4.setText("-888%");
    lblTargetPct4.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff4
    lblTargetDiff4.setLocation(new Point(410, 156));
    lblTargetDiff4.setName("lblTargetDiff4");
    lblTargetDiff4.setSize(new FormSize(52, 13));
    lblTargetDiff4.setTabIndex(81);
    lblTargetDiff4.setText("-8,888 cr.");
    lblTargetDiff4.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice4
    lblTargetPrice4.setLocation(new Point(358, 156));
    lblTargetPrice4.setName("lblTargetPrice4");
    lblTargetPrice4.setSize(new FormSize(48, 13));
    lblTargetPrice4.setTabIndex(80);
    lblTargetPrice4.setText("8,888 cr.");
    lblTargetPrice4.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax4
    btnBuyMax4.setFlatStyle(FlatStyle.Flat);
    btnBuyMax4.setLocation(new Point(262, 152));
    btnBuyMax4.setName("btnBuyMax4");
    btnBuyMax4.setSize(new FormSize(36, 22));
    btnBuyMax4.setTabIndex(31);
    btnBuyMax4.setText("Max");
    btnBuyMax4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty4
    btnBuyQty4.setFlatStyle(FlatStyle.Flat);
    btnBuyQty4.setLocation(new Point(227, 152));
    btnBuyQty4.setName("btnBuyQty4");
    btnBuyQty4.setSize(new FormSize(28, 22));
    btnBuyQty4.setTabIndex(30);
    btnBuyQty4.setText("88");
    btnBuyQty4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice4
    lblBuyPrice4.setLocation(new Point(302, 156));
    lblBuyPrice4.setName("lblBuyPrice4");
    lblBuyPrice4.setSize(new FormSize(48, 13));
    lblBuyPrice4.setTabIndex(77);
    lblBuyPrice4.setText("8,888 cr.");
    lblBuyPrice4.TextAlign = ContentAlignment.TopRight;
    // btnSellAll4
    btnSellAll4.setFlatStyle(FlatStyle.Flat);
    btnSellAll4.setLocation(new Point(115, 152));
    btnSellAll4.setName("btnSellAll4");
    btnSellAll4.setSize(new FormSize(44, 22));
    btnSellAll4.setTabIndex(29);
    btnSellAll4.setText("All");
    btnSellAll4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty4
    btnSellQty4.setFlatStyle(FlatStyle.Flat);
    btnSellQty4.setLocation(new Point(80, 152));
    btnSellQty4.setName("btnSellQty4");
    btnSellQty4.setSize(new FormSize(28, 22));
    btnSellQty4.setTabIndex(28);
    btnSellQty4.setText("88");
    btnSellQty4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice4
    lblSellPrice4.setLocation(new Point(163, 156));
    lblSellPrice4.setName("lblSellPrice4");
    lblSellPrice4.setSize(new FormSize(48, 13));
    lblSellPrice4.setTabIndex(74);
    lblSellPrice4.setText("8,888 cr.");
    lblSellPrice4.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct3
    lblTargetPct3.setLocation(new Point(466, 132));
    lblTargetPct3.setName("lblTargetPct3");
    lblTargetPct3.setSize(new FormSize(37, 13));
    lblTargetPct3.setTabIndex(73);
    lblTargetPct3.setText("-888%");
    lblTargetPct3.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff3
    lblTargetDiff3.setLocation(new Point(410, 132));
    lblTargetDiff3.setName("lblTargetDiff3");
    lblTargetDiff3.setSize(new FormSize(52, 13));
    lblTargetDiff3.setTabIndex(72);
    lblTargetDiff3.setText("-8,888 cr.");
    lblTargetDiff3.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice3
    lblTargetPrice3.setLocation(new Point(358, 132));
    lblTargetPrice3.setName("lblTargetPrice3");
    lblTargetPrice3.setSize(new FormSize(48, 13));
    lblTargetPrice3.setTabIndex(71);
    lblTargetPrice3.setText("8,888 cr.");
    lblTargetPrice3.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax3
    btnBuyMax3.setFlatStyle(FlatStyle.Flat);
    btnBuyMax3.setLocation(new Point(262, 128));
    btnBuyMax3.setName("btnBuyMax3");
    btnBuyMax3.setSize(new FormSize(36, 22));
    btnBuyMax3.setTabIndex(27);
    btnBuyMax3.setText("Max");
    btnBuyMax3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty3
    btnBuyQty3.setFlatStyle(FlatStyle.Flat);
    btnBuyQty3.setLocation(new Point(227, 128));
    btnBuyQty3.setName("btnBuyQty3");
    btnBuyQty3.setSize(new FormSize(28, 22));
    btnBuyQty3.setTabIndex(26);
    btnBuyQty3.setText("88");
    btnBuyQty3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice3
    lblBuyPrice3.setLocation(new Point(302, 132));
    lblBuyPrice3.setName("lblBuyPrice3");
    lblBuyPrice3.setSize(new FormSize(48, 13));
    lblBuyPrice3.setTabIndex(68);
    lblBuyPrice3.setText("8,888 cr.");
    lblBuyPrice3.TextAlign = ContentAlignment.TopRight;
    // btnSellAll3
    btnSellAll3.setFlatStyle(FlatStyle.Flat);
    btnSellAll3.setLocation(new Point(115, 128));
    btnSellAll3.setName("btnSellAll3");
    btnSellAll3.setSize(new FormSize(44, 22));
    btnSellAll3.setTabIndex(25);
    btnSellAll3.setText("All");
    btnSellAll3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty3
    btnSellQty3.setFlatStyle(FlatStyle.Flat);
    btnSellQty3.setLocation(new Point(80, 128));
    btnSellQty3.setName("btnSellQty3");
    btnSellQty3.setSize(new FormSize(28, 22));
    btnSellQty3.setTabIndex(24);
    btnSellQty3.setText("88");
    btnSellQty3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice3
    lblSellPrice3.setLocation(new Point(163, 132));
    lblSellPrice3.setName("lblSellPrice3");
    lblSellPrice3.setSize(new FormSize(48, 13));
    lblSellPrice3.setTabIndex(65);
    lblSellPrice3.setText("8,888 cr.");
    lblSellPrice3.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct2
    lblTargetPct2.setLocation(new Point(466, 108));
    lblTargetPct2.setName("lblTargetPct2");
    lblTargetPct2.setSize(new FormSize(37, 13));
    lblTargetPct2.setTabIndex(64);
    lblTargetPct2.setText("-888%");
    lblTargetPct2.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff2
    lblTargetDiff2.setLocation(new Point(410, 108));
    lblTargetDiff2.setName("lblTargetDiff2");
    lblTargetDiff2.setSize(new FormSize(52, 13));
    lblTargetDiff2.setTabIndex(63);
    lblTargetDiff2.setText("-8,888 cr.");
    lblTargetDiff2.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice2
    lblTargetPrice2.setLocation(new Point(358, 108));
    lblTargetPrice2.setName("lblTargetPrice2");
    lblTargetPrice2.setSize(new FormSize(48, 13));
    lblTargetPrice2.setTabIndex(62);
    lblTargetPrice2.setText("8,888 cr.");
    lblTargetPrice2.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax2
    btnBuyMax2.setFlatStyle(FlatStyle.Flat);
    btnBuyMax2.setLocation(new Point(262, 104));
    btnBuyMax2.setName("btnBuyMax2");
    btnBuyMax2.setSize(new FormSize(36, 22));
    btnBuyMax2.setTabIndex(23);
    btnBuyMax2.setText("Max");
    btnBuyMax2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty2
    btnBuyQty2.setFlatStyle(FlatStyle.Flat);
    btnBuyQty2.setLocation(new Point(227, 104));
    btnBuyQty2.setName("btnBuyQty2");
    btnBuyQty2.setSize(new FormSize(28, 22));
    btnBuyQty2.setTabIndex(22);
    btnBuyQty2.setText("88");
    btnBuyQty2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice2
    lblBuyPrice2.setLocation(new Point(302, 108));
    lblBuyPrice2.setName("lblBuyPrice2");
    lblBuyPrice2.setSize(new FormSize(48, 13));
    lblBuyPrice2.setTabIndex(59);
    lblBuyPrice2.setText("8,888 cr.");
    lblBuyPrice2.TextAlign = ContentAlignment.TopRight;
    // btnSellAll2
    btnSellAll2.setFlatStyle(FlatStyle.Flat);
    btnSellAll2.setLocation(new Point(115, 104));
    btnSellAll2.setName("btnSellAll2");
    btnSellAll2.setSize(new FormSize(44, 22));
    btnSellAll2.setTabIndex(21);
    btnSellAll2.setText("All");
    btnSellAll2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty2
    btnSellQty2.setFlatStyle(FlatStyle.Flat);
    btnSellQty2.setLocation(new Point(80, 104));
    btnSellQty2.setName("btnSellQty2");
    btnSellQty2.setSize(new FormSize(28, 22));
    btnSellQty2.setTabIndex(20);
    btnSellQty2.setText("88");
    btnSellQty2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice2
    lblSellPrice2.setLocation(new Point(163, 108));
    lblSellPrice2.setName("lblSellPrice2");
    lblSellPrice2.setSize(new FormSize(48, 13));
    lblSellPrice2.setTabIndex(56);
    lblSellPrice2.setText("8,888 cr.");
    lblSellPrice2.TextAlign = ContentAlignment.TopRight;
    // lblTargetPct1
    lblTargetPct1.setLocation(new Point(466, 84));
    lblTargetPct1.setName("lblTargetPct1");
    lblTargetPct1.setSize(new FormSize(37, 13));
    lblTargetPct1.setTabIndex(55);
    lblTargetPct1.setText("-888%");
    lblTargetPct1.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff1
    lblTargetDiff1.setLocation(new Point(410, 84));
    lblTargetDiff1.setName("lblTargetDiff1");
    lblTargetDiff1.setSize(new FormSize(52, 13));
    lblTargetDiff1.setTabIndex(54);
    lblTargetDiff1.setText("-8,888 cr.");
    lblTargetDiff1.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice1
    lblTargetPrice1.setLocation(new Point(358, 84));
    lblTargetPrice1.setName("lblTargetPrice1");
    lblTargetPrice1.setSize(new FormSize(48, 13));
    lblTargetPrice1.setTabIndex(53);
    lblTargetPrice1.setText("8,888 cr.");
    lblTargetPrice1.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax1
    btnBuyMax1.setFlatStyle(FlatStyle.Flat);
    btnBuyMax1.setLocation(new Point(262, 80));
    btnBuyMax1.setName("btnBuyMax1");
    btnBuyMax1.setSize(new FormSize(36, 22));
    btnBuyMax1.setTabIndex(19);
    btnBuyMax1.setText("Max");
    btnBuyMax1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty1
    btnBuyQty1.setFlatStyle(FlatStyle.Flat);
    btnBuyQty1.setLocation(new Point(227, 80));
    btnBuyQty1.setName("btnBuyQty1");
    btnBuyQty1.setSize(new FormSize(28, 22));
    btnBuyQty1.setTabIndex(18);
    btnBuyQty1.setText("88");
    btnBuyQty1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice1
    lblBuyPrice1.setLocation(new Point(302, 84));
    lblBuyPrice1.setName("lblBuyPrice1");
    lblBuyPrice1.setSize(new FormSize(48, 13));
    lblBuyPrice1.setTabIndex(50);
    lblBuyPrice1.setText("8,888 cr.");
    lblBuyPrice1.TextAlign = ContentAlignment.TopRight;
    // lblTargetPctLabel
    lblTargetPctLabel.setAutoSize(true);
    lblTargetPctLabel.setLocation(new Point(476, 34));
    lblTargetPctLabel.setName("lblTargetPctLabel");
    lblTargetPctLabel.setSize(new FormSize(14, 16));
    lblTargetPctLabel.setTabIndex(49);
    lblTargetPctLabel.setText("%");
    // lblTargetDiffLabel
    lblTargetDiffLabel.setAutoSize(true);
    lblTargetDiffLabel.setLocation(new Point(424, 34));
    lblTargetDiffLabel.setName("lblTargetDiffLabel");
    lblTargetDiffLabel.setSize(new FormSize(18, 16));
    lblTargetDiffLabel.setTabIndex(48);
    lblTargetDiffLabel.setText("+/-");
    // lblTargetPriceLabel
    lblTargetPriceLabel.setAutoSize(true);
    lblTargetPriceLabel.setLocation(new Point(360, 34));
    lblTargetPriceLabel.setName("lblTargetPriceLabel");
    lblTargetPriceLabel.setSize(new FormSize(30, 16));
    lblTargetPriceLabel.setTabIndex(47);
    lblTargetPriceLabel.setText("Price");
    // lblTargetPct0
    lblTargetPct0.setLocation(new Point(466, 60));
    lblTargetPct0.setName("lblTargetPct0");
    lblTargetPct0.setSize(new FormSize(37, 13));
    lblTargetPct0.setTabIndex(46);
    lblTargetPct0.setText("-888%");
    lblTargetPct0.TextAlign = ContentAlignment.TopRight;
    // lblTargetDiff0
    lblTargetDiff0.setLocation(new Point(410, 60));
    lblTargetDiff0.setName("lblTargetDiff0");
    lblTargetDiff0.setSize(new FormSize(52, 13));
    lblTargetDiff0.setTabIndex(45);
    lblTargetDiff0.setText("-8,888 cr.");
    lblTargetDiff0.TextAlign = ContentAlignment.TopRight;
    // lblTargetPrice0
    lblTargetPrice0.setLocation(new Point(358, 60));
    lblTargetPrice0.setName("lblTargetPrice0");
    lblTargetPrice0.setSize(new FormSize(48, 13));
    lblTargetPrice0.setTabIndex(44);
    lblTargetPrice0.setText("8,888 cr.");
    lblTargetPrice0.TextAlign = ContentAlignment.TopRight;
    // btnBuyMax0
    btnBuyMax0.setFlatStyle(FlatStyle.Flat);
    btnBuyMax0.setLocation(new Point(262, 56));
    btnBuyMax0.setName("btnBuyMax0");
    btnBuyMax0.setSize(new FormSize(36, 22));
    btnBuyMax0.setTabIndex(15);
    btnBuyMax0.setText("Max");
    btnBuyMax0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnBuyQty0
    btnBuyQty0.setFlatStyle(FlatStyle.Flat);
    btnBuyQty0.setLocation(new Point(227, 56));
    btnBuyQty0.setName("btnBuyQty0");
    btnBuyQty0.setSize(new FormSize(28, 22));
    btnBuyQty0.setTabIndex(14);
    btnBuyQty0.setText("88");
    btnBuyQty0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblBuyPrice0
    lblBuyPrice0.setLocation(new Point(302, 60));
    lblBuyPrice0.setName("lblBuyPrice0");
    lblBuyPrice0.setSize(new FormSize(48, 13));
    lblBuyPrice0.setTabIndex(41);
    lblBuyPrice0.setText("8,888 cr.");
    lblBuyPrice0.TextAlign = ContentAlignment.TopRight;
    // btnSellAll1
    btnSellAll1.setFlatStyle(FlatStyle.Flat);
    btnSellAll1.setLocation(new Point(115, 80));
    btnSellAll1.setName("btnSellAll1");
    btnSellAll1.setSize(new FormSize(44, 22));
    btnSellAll1.setTabIndex(17);
    btnSellAll1.setText("All");
    btnSellAll1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty1
    btnSellQty1.setFlatStyle(FlatStyle.Flat);
    btnSellQty1.setLocation(new Point(80, 80));
    btnSellQty1.setName("btnSellQty1");
    btnSellQty1.setSize(new FormSize(28, 22));
    btnSellQty1.setTabIndex(16);
    btnSellQty1.setText("88");
    btnSellQty1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice1
    lblSellPrice1.setLocation(new Point(163, 84));
    lblSellPrice1.setName("lblSellPrice1");
    lblSellPrice1.setSize(new FormSize(48, 13));
    lblSellPrice1.setTabIndex(38);
    lblSellPrice1.setText("8,888 cr.");
    lblSellPrice1.TextAlign = ContentAlignment.TopRight;
    // btnSellAll0
    btnSellAll0.setFlatStyle(FlatStyle.Flat);
    btnSellAll0.setLocation(new Point(115, 56));
    btnSellAll0.setName("btnSellAll0");
    btnSellAll0.setSize(new FormSize(44, 22));
    btnSellAll0.setTabIndex(13);
    btnSellAll0.setText("All");
    btnSellAll0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // btnSellQty0
    btnSellQty0.setFlatStyle(FlatStyle.Flat);
    btnSellQty0.setLocation(new Point(80, 56));
    btnSellQty0.setName("btnSellQty0");
    btnSellQty0.setSize(new FormSize(28, 22));
    btnSellQty0.setTabIndex(12);
    btnSellQty0.setText("88");
    btnSellQty0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuySell_Click(sender, e);
      }
    });
    // lblSellPrice0
    lblSellPrice0.setLocation(new Point(163, 60));
    lblSellPrice0.setName("lblSellPrice0");
    lblSellPrice0.setSize(new FormSize(48, 13));
    lblSellPrice0.setTabIndex(35);
    lblSellPrice0.setText("8,888 cr.");
    lblSellPrice0.TextAlign = ContentAlignment.TopRight;
    // lblTradeTarget
    lblTradeTarget.setAutoSize(true);
    lblTradeTarget.setLocation(new Point(391, 16));
    lblTradeTarget.setName("lblTradeTarget");
    lblTradeTarget.setSize(new FormSize(78, 16));
    lblTradeTarget.setTabIndex(28);
    lblTradeTarget.setText("Target System");
    // lblBuy
    lblBuy.setAutoSize(true);
    lblBuy.setLocation(new Point(273, 34));
    lblBuy.setName("lblBuy");
    lblBuy.setSize(new FormSize(24, 16));
    lblBuy.setTabIndex(27);
    lblBuy.setText("Buy");
    // lblSell
    lblSell.setAutoSize(true);
    lblSell.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Regular, GraphicsUnit.Point, ((byte)(0))));
    lblSell.setLocation(new Point(132, 34));
    lblSell.setName("lblSell");
    lblSell.setSize(new FormSize(23, 16));
    lblSell.setTabIndex(26);
    lblSell.setText("Sell");
    // lblTradeCmdty9
    lblTradeCmdty9.setAutoSize(true);
    lblTradeCmdty9.setLocation(new Point(8, 276));
    lblTradeCmdty9.setName("lblTradeCmdty9");
    lblTradeCmdty9.setSize(new FormSize(40, 16));
    lblTradeCmdty9.setTabIndex(25);
    lblTradeCmdty9.setText("Robots");
    // lblTradeCmdty8
    lblTradeCmdty8.setAutoSize(true);
    lblTradeCmdty8.setLocation(new Point(8, 252));
    lblTradeCmdty8.setName("lblTradeCmdty8");
    lblTradeCmdty8.setSize(new FormSize(51, 16));
    lblTradeCmdty8.setTabIndex(24);
    lblTradeCmdty8.setText("Narcotics");
    // lblTradeCmdty2
    lblTradeCmdty2.setAutoSize(true);
    lblTradeCmdty2.setLocation(new Point(8, 108));
    lblTradeCmdty2.setName("lblTradeCmdty2");
    lblTradeCmdty2.setSize(new FormSize(30, 16));
    lblTradeCmdty2.setTabIndex(23);
    lblTradeCmdty2.setText("Food");
    // lblTradeCmdty0
    lblTradeCmdty0.setAutoSize(true);
    lblTradeCmdty0.setLocation(new Point(8, 60));
    lblTradeCmdty0.setName("lblTradeCmdty0");
    lblTradeCmdty0.setSize(new FormSize(34, 16));
    lblTradeCmdty0.setTabIndex(22);
    lblTradeCmdty0.setText("Water");
    // lblTradeCmdty1
    lblTradeCmdty1.setAutoSize(true);
    lblTradeCmdty1.setLocation(new Point(8, 84));
    lblTradeCmdty1.setName("lblTradeCmdty1");
    lblTradeCmdty1.setSize(new FormSize(27, 16));
    lblTradeCmdty1.setTabIndex(21);
    lblTradeCmdty1.setText("Furs");
    // lblTradeCmdty6
    lblTradeCmdty6.setAutoSize(true);
    lblTradeCmdty6.setLocation(new Point(8, 204));
    lblTradeCmdty6.setName("lblTradeCmdty6");
    lblTradeCmdty6.setSize(new FormSize(50, 16));
    lblTradeCmdty6.setTabIndex(20);
    lblTradeCmdty6.setText("Medicine");
    // lblTradeCmdty5
    lblTradeCmdty5.setAutoSize(true);
    lblTradeCmdty5.setLocation(new Point(8, 180));
    lblTradeCmdty5.setName("lblTradeCmdty5");
    lblTradeCmdty5.setSize(new FormSize(49, 16));
    lblTradeCmdty5.setTabIndex(19);
    lblTradeCmdty5.setText("Firearms");
    // lblTradeCmdty4
    lblTradeCmdty4.setAutoSize(true);
    lblTradeCmdty4.setLocation(new Point(8, 156));
    lblTradeCmdty4.setName("lblTradeCmdty4");
    lblTradeCmdty4.setSize(new FormSize(41, 16));
    lblTradeCmdty4.setTabIndex(18);
    lblTradeCmdty4.setText("Games");
    // lblTradeCmdty3
    lblTradeCmdty3.setAutoSize(true);
    lblTradeCmdty3.setLocation(new Point(8, 132));
    lblTradeCmdty3.setName("lblTradeCmdty3");
    lblTradeCmdty3.setSize(new FormSize(23, 16));
    lblTradeCmdty3.setTabIndex(17);
    lblTradeCmdty3.setText("Ore");
    // lblTradeCmdty7
    lblTradeCmdty7.setAutoSize(true);
    lblTradeCmdty7.setLocation(new Point(8, 228));
    lblTradeCmdty7.setName("lblTradeCmdty7");
    lblTradeCmdty7.setSize(new FormSize(53, 16));
    lblTradeCmdty7.setTabIndex(16);
    lblTradeCmdty7.setText("Machines");
    // boxSystem
    boxSystem.Controls.add(btnMerc);
    boxSystem.Controls.add(btnSpecial);
    boxSystem.Controls.add(btnNews);
    boxSystem.Controls.add(lblSystemPressure);
    boxSystem.Controls.add(lblSystemPressurePre);
    boxSystem.Controls.add(lblSystemPolSys);
    boxSystem.Controls.add(lblSystemSize);
    boxSystem.Controls.add(lblSystemTech);
    boxSystem.Controls.add(lblSystemPirates);
    boxSystem.Controls.add(lblSystemPolice);
    boxSystem.Controls.add(lblSystemResource);
    boxSystem.Controls.add(lblSystemPiratesLabel);
    boxSystem.Controls.add(lblSystemPoliceLabel);
    boxSystem.Controls.add(lblSystemResourseLabel);
    boxSystem.Controls.add(lblSystemGovtLabel);
    boxSystem.Controls.add(lblSystemTechLabel);
    boxSystem.Controls.add(lblSystemSizeLabel);
    boxSystem.Controls.add(lblSystemName);
    boxSystem.Controls.add(lblSystemNameLabel);
    boxSystem.setLocation(new Point(4, 2));
    boxSystem.setName("boxSystem");
    boxSystem.setSize(new FormSize(240, 206));
    boxSystem.setTabIndex(1);
    boxSystem.setTabStop(false);
    boxSystem.setText("System Info");
    // btnMerc
    btnMerc.setFlatStyle(FlatStyle.Flat);
    btnMerc.setLocation(new Point(118, 174));
    btnMerc.setName("btnMerc");
    btnMerc.setSize(new FormSize(112, 22));
    btnMerc.setTabIndex(3);
    btnMerc.setText("Mercenary For Hire");
    btnMerc.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnMerc_Click(sender, e);
      }
    });
    // btnSpecial
    btnSpecial.setBackColor(new Color(255, 255, 128));
    btnSpecial.setFlatStyle(FlatStyle.Flat);
    btnSpecial.setLocation(new Point(58, 174));
    btnSpecial.setName("btnSpecial");
    btnSpecial.setSize(new FormSize(52, 22));
    btnSpecial.setTabIndex(2);
    btnSpecial.setText("Special");
    btnSpecial.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnSpecial_Click(sender, e);
      }
    });
    // btnNews
    btnNews.setFlatStyle(FlatStyle.Flat);
    btnNews.setLocation(new Point(8, 174));
    btnNews.setName("btnNews");
    btnNews.setSize(new FormSize(42, 22));
    btnNews.setTabIndex(1);
    btnNews.setText("News");
    btnNews.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnNews_Click(sender, e);
      }
    });
    // lblSystemPressure
    lblSystemPressure.setLocation(new Point(8, 147));
    lblSystemPressure.setName("lblSystemPressure");
    lblSystemPressure.setSize(new FormSize(168, 16));
    lblSystemPressure.setTabIndex(18);
    lblSystemPressure.setText("suffering from extreme boredom.");
    // lblSystemPressurePre
    lblSystemPressurePre.setAutoSize(true);
    lblSystemPressurePre.setLocation(new Point(8, 134));
    lblSystemPressurePre.setName("lblSystemPressurePre");
    lblSystemPressurePre.setSize(new FormSize(122, 16));
    lblSystemPressurePre.setTabIndex(17);
    lblSystemPressurePre.setText("This system is currently");
    // lblSystemPolSys
    lblSystemPolSys.setLocation(new Point(88, 64));
    lblSystemPolSys.setName("lblSystemPolSys");
    lblSystemPolSys.setSize(new FormSize(91, 13));
    lblSystemPolSys.setTabIndex(15);
    lblSystemPolSys.setText("Cybernetic State");
    // lblSystemSize
    lblSystemSize.setLocation(new Point(88, 32));
    lblSystemSize.setName("lblSystemSize");
    lblSystemSize.setSize(new FormSize(45, 13));
    lblSystemSize.setTabIndex(14);
    lblSystemSize.setText("Medium");
    // lblSystemTech
    lblSystemTech.setLocation(new Point(88, 48));
    lblSystemTech.setName("lblSystemTech");
    lblSystemTech.setSize(new FormSize(82, 13));
    lblSystemTech.setTabIndex(13);
    lblSystemTech.setText("Pre-Agricultural");
    // lblSystemPirates
    lblSystemPirates.setLocation(new Point(88, 112));
    lblSystemPirates.setName("lblSystemPirates");
    lblSystemPirates.setSize(new FormSize(53, 13));
    lblSystemPirates.setTabIndex(11);
    lblSystemPirates.setText("Abundant");
    // lblSystemPolice
    lblSystemPolice.setLocation(new Point(88, 96));
    lblSystemPolice.setName("lblSystemPolice");
    lblSystemPolice.setSize(new FormSize(53, 13));
    lblSystemPolice.setTabIndex(10);
    lblSystemPolice.setText("Moderate");
    // lblSystemResource
    lblSystemResource.setLocation(new Point(88, 80));
    lblSystemResource.setName("lblSystemResource");
    lblSystemResource.setSize(new FormSize(105, 13));
    lblSystemResource.setTabIndex(9);
    lblSystemResource.setText("Sweetwater Oceans");
    // lblSystemPiratesLabel
    lblSystemPiratesLabel.setAutoSize(true);
    lblSystemPiratesLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSystemPiratesLabel.setLocation(new Point(8, 112));
    lblSystemPiratesLabel.setName("lblSystemPiratesLabel");
    lblSystemPiratesLabel.setSize(new FormSize(44, 16));
    lblSystemPiratesLabel.setTabIndex(7);
    lblSystemPiratesLabel.setText("Pirates:");
    // lblSystemPoliceLabel
    lblSystemPoliceLabel.setAutoSize(true);
    lblSystemPoliceLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSystemPoliceLabel.setLocation(new Point(8, 96));
    lblSystemPoliceLabel.setName("lblSystemPoliceLabel");
    lblSystemPoliceLabel.setSize(new FormSize(40, 16));
    lblSystemPoliceLabel.setTabIndex(6);
    lblSystemPoliceLabel.setText("Police:");
    // lblSystemResourseLabel
    lblSystemResourseLabel.setAutoSize(true);
    lblSystemResourseLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSystemResourseLabel.setLocation(new Point(8, 80));
    lblSystemResourseLabel.setName("lblSystemResourseLabel");
    lblSystemResourseLabel.setSize(new FormSize(58, 16));
    lblSystemResourseLabel.setTabIndex(5);
    lblSystemResourseLabel.setText("Resource:");
    // lblSystemGovtLabel
    lblSystemGovtLabel.setAutoSize(true);
    lblSystemGovtLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSystemGovtLabel.setLocation(new Point(8, 64));
    lblSystemGovtLabel.setName("lblSystemGovtLabel");
    lblSystemGovtLabel.setSize(new FormSize(72, 16));
    lblSystemGovtLabel.setTabIndex(4);
    lblSystemGovtLabel.setText("Government:");
    // lblSystemTechLabel
    lblSystemTechLabel.setAutoSize(true);
    lblSystemTechLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSystemTechLabel.setLocation(new Point(8, 48));
    lblSystemTechLabel.setName("lblSystemTechLabel");
    lblSystemTechLabel.setSize(new FormSize(65, 16));
    lblSystemTechLabel.setTabIndex(3);
    lblSystemTechLabel.setText("Tech Level:");
    // lblSystemSizeLabel
    lblSystemSizeLabel.setAutoSize(true);
    lblSystemSizeLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSystemSizeLabel.setLocation(new Point(8, 32));
    lblSystemSizeLabel.setName("lblSystemSizeLabel");
    lblSystemSizeLabel.setSize(new FormSize(31, 16));
    lblSystemSizeLabel.setTabIndex(2);
    lblSystemSizeLabel.setText("Size:");
    // lblSystemName
    lblSystemName.setLocation(new Point(88, 16));
    lblSystemName.setName("lblSystemName");
    lblSystemName.setSize(new FormSize(65, 13));
    lblSystemName.setTabIndex(1);
    lblSystemName.setText("Tarchannen");
    // lblSystemNameLabel
    lblSystemNameLabel.setAutoSize(true);
    lblSystemNameLabel.setFont(
        new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblSystemNameLabel.setLocation(new Point(8, 16));
    lblSystemNameLabel.setName("lblSystemNameLabel");
    lblSystemNameLabel.setSize(new FormSize(39, 16));
    lblSystemNameLabel.setTabIndex(0);
    lblSystemNameLabel.setText("Name:");
    // boxShipYard
    boxShipYard.Controls.add(btnDesign);
    boxShipYard.Controls.add(btnPod);
    boxShipYard.Controls.add(lblEscapePod);
    boxShipYard.Controls.add(btnEquip);
    boxShipYard.Controls.add(btnBuyShip);
    boxShipYard.Controls.add(lblEquipForSale);
    boxShipYard.Controls.add(lblShipsForSale);
    boxShipYard.setLocation(new Point(4, 306));
    boxShipYard.setName("boxShipYard");
    boxShipYard.setSize(new FormSize(168, 168));
    boxShipYard.setTabIndex(4);
    boxShipYard.setTabStop(false);
    boxShipYard.setText("Shipyard");
    // btnDesign
    btnDesign.setFlatStyle(FlatStyle.Flat);
    btnDesign.setLocation(new Point(8, 32));
    btnDesign.setName("btnDesign");
    btnDesign.setSize(new FormSize(54, 22));
    btnDesign.setTabIndex(55);
    btnDesign.setText("Design");
    btnDesign.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnDesign_Click(sender, e);
      }
    });
    // btnPod
    btnPod.setFlatStyle(FlatStyle.Flat);
    btnPod.setLocation(new Point(98, 138));
    btnPod.setName("btnPod");
    btnPod.setSize(new FormSize(58, 22));
    btnPod.setTabIndex(54);
    btnPod.setText("Buy Pod");
    btnPod.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPod_Click(sender, e);
      }
    });
    // lblEscapePod
    lblEscapePod.setLocation(new Point(8, 122));
    lblEscapePod.setName("lblEscapePod");
    lblEscapePod.setSize(new FormSize(152, 26));
    lblEscapePod.setTabIndex(27);
    lblEscapePod.setText("You can buy an escape pod for  2,000 cr.");
    // btnEquip
    btnEquip.setFlatStyle(FlatStyle.Flat);
    btnEquip.setLocation(new Point(43, 85));
    btnEquip.setName("btnEquip");
    btnEquip.setSize(new FormSize(113, 22));
    btnEquip.setTabIndex(53);
    btnEquip.setText("Buy/Sell Equipment");
    btnEquip.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnEquip_Click(sender, e);
      }
    });
    // btnBuyShip
    btnBuyShip.setFlatStyle(FlatStyle.Flat);
    btnBuyShip.setLocation(new Point(70, 32));
    btnBuyShip.setName("btnBuyShip");
    btnBuyShip.setSize(new FormSize(86, 22));
    btnBuyShip.setTabIndex(52);
    btnBuyShip.setText("View Ship Info");
    btnBuyShip.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyShip_Click(sender, e);
      }
    });
    // lblEquipForSale
    lblEquipForSale.setLocation(new Point(8, 69));
    lblEquipForSale.setName("lblEquipForSale");
    lblEquipForSale.setSize(new FormSize(152, 13));
    lblEquipForSale.setTabIndex(21);
    lblEquipForSale.setText("There is equipment for sale.");
    // lblShipsForSale
    lblShipsForSale.setLocation(new Point(8, 16));
    lblShipsForSale.setName("lblShipsForSale");
    lblShipsForSale.setSize(new FormSize(152, 13));
    lblShipsForSale.setTabIndex(20);
    lblShipsForSale.setText("There are new ships for sale.");
    // boxDock
    boxDock.Controls.add(btnRepair);
    boxDock.Controls.add(btnFuel);
    boxDock.Controls.add(lblFuelStatus);
    boxDock.Controls.add(lblFuelCost);
    boxDock.Controls.add(lblHullStatus);
    boxDock.Controls.add(lblRepairCost);
    boxDock.setLocation(new Point(4, 212));
    boxDock.setName("boxDock");
    boxDock.setSize(new FormSize(240, 90));
    boxDock.setTabIndex(2);
    boxDock.setTabStop(false);
    boxDock.setText("Dock");
    // btnRepair
    btnRepair.setFlatStyle(FlatStyle.Flat);
    btnRepair.setLocation(new Point(180, 56));
    btnRepair.setName("btnRepair");
    btnRepair.setSize(new FormSize(48, 22));
    btnRepair.setTabIndex(5);
    btnRepair.setText("Repair");
    btnRepair.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnRepair_Click(sender, e);
      }
    });
    // btnFuel
    btnFuel.setFlatStyle(FlatStyle.Flat);
    btnFuel.setLocation(new Point(192, 18));
    btnFuel.setName("btnFuel");
    btnFuel.setSize(new FormSize(36, 22));
    btnFuel.setTabIndex(4);
    btnFuel.setText("Fuel");
    btnFuel.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnFuel_Click(sender, e);
      }
    });
    // lblFuelStatus
    lblFuelStatus.setLocation(new Point(8, 16));
    lblFuelStatus.setName("lblFuelStatus");
    lblFuelStatus.setSize(new FormSize(162, 13));
    lblFuelStatus.setTabIndex(20);
    lblFuelStatus.setText("You have fuel to fly 88 parsecs.");
    // lblFuelCost
    lblFuelCost.setLocation(new Point(8, 31));
    lblFuelCost.setName("lblFuelCost");
    lblFuelCost.setSize(new FormSize(121, 13));
    lblFuelCost.setTabIndex(19);
    lblFuelCost.setText("A full tank costs 888 cr.");
    // lblHullStatus
    lblHullStatus.setLocation(new Point(8, 52));
    lblHullStatus.setName("lblHullStatus");
    lblHullStatus.setSize(new FormSize(152, 13));
    lblHullStatus.setTabIndex(18);
    lblHullStatus.setText("Your hull strength is at 888%.");
    // lblRepairCost
    lblRepairCost.setLocation(new Point(8, 67));
    lblRepairCost.setName("lblRepairCost");
    lblRepairCost.setSize(new FormSize(150, 13));
    lblRepairCost.setTabIndex(19);
    lblRepairCost.setText("Full repairs will cost 8,888 cr.");
    // picLine
    picLine.setBackColor(Color.darkGray);
    picLine.setLocation(new Point(0, 0));
    picLine.setName("picLine");
    picLine.setSize(new FormSize(770, 1));
    picLine.setTabIndex(132);
    picLine.setTabStop(false);
    // dlgOpen
    dlgOpen.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
    // dlgSave
    dlgSave.setFileName("SpaceTrader.sav");
    dlgSave.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
    // ilChartImages
    ilChartImages.setImageSize(new FormSize(7, 7));
    ilChartImages.setImageStream(((ImageListStreamer)(resources.GetObject("ilChartImages.ImageStream"))));
    ilChartImages.setTransparentColor(Color.white);
    // ilShipImages
    ilShipImages.setImageSize(new FormSize(64, 52));
    ilShipImages.setImageStream(((ImageListStreamer)(resources.GetObject("ilShipImages.ImageStream"))));
    ilShipImages.setTransparentColor(Color.white);
    // ilDirectionImages
    ilDirectionImages.setImageSize(new FormSize(13, 13));
    ilDirectionImages.setImageStream(((ImageListStreamer)(resources.GetObject("ilDirectionImages.ImageStream"))));
    ilDirectionImages.setTransparentColor(Color.white);
    // ilEquipmentImages
    ilEquipmentImages.setImageSize(new FormSize(64, 52));
    ilEquipmentImages.setImageStream(((ImageListStreamer)(resources.GetObject("ilEquipmentImages.ImageStream"))));
    ilEquipmentImages.setTransparentColor(Color.white);
    // ApplicationST
    setAutoScaleBaseSize(new FormSize(5, 13));
    setClientSize(new FormSize(768, 505));
    Controls.add(picLine);
    Controls.add(boxDock);
    Controls.add(boxCargo);
    Controls.add(boxTargetSystem);
    Controls.add(boxGalacticChart);
    Controls.add(boxShortRangeChart);
    setStatusBar(statusBar);
    Controls.add(boxSystem);
    Controls.add(boxShipYard);
    //TODO: next line is FQN because of field name is identical. GAC
    setFormBorderStyle(jwinforms.enums.FormBorderStyle.FixedSingle);
    setIcon(((Icon)(resources.GetObject("$this.Icon"))));
    setMaximizeBox(false);
    setMenu(mnuMain);
    setName("SpaceTrader");
    setStartPosition(FormStartPosition.Manual);
    setText("Space Trader");
    setClosing(new EventHandler<Object, CancelEventArgs>() {
      @Override
      public void handle(Object sender, CancelEventArgs e) {
        SpaceTrader_Closing(sender, e);
      }
    });
    setLoad(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SpaceTrader_Load(sender, e);
      }
    });
    ((ISupportInitialize)(statusBarPanelCash)).EndInit();
    ((ISupportInitialize)(statusBarPanelBays)).EndInit();
    ((ISupportInitialize)(statusBarPanelCosts)).EndInit();
    ((ISupportInitialize)(statusBarPanelExtra)).EndInit();
    boxShortRangeChart.ResumeLayout(false);
    boxGalacticChart.ResumeLayout(false);
    boxTargetSystem.ResumeLayout(false);
    boxCargo.ResumeLayout(false);
    boxSystem.ResumeLayout(false);
    boxShipYard.ResumeLayout(false);
    boxDock.ResumeLayout(false);
    ResumeLayout(false);
  }

  private void AddHighScore(HighScoreRecord highScore) {
    HighScoreRecord[] highScores = Functions.GetHighScores(this);
    highScores[0] = highScore;
    Arrays.sort(highScores);
    Functions.SaveFile(Consts.HighScoreFile, STSerializableObject.ArrayToArrayList(highScores), this);
  }

  private void CargoBuy(int tradeItem, boolean max) {
    game.CargoBuySystem(tradeItem, max, this);
    UpdateAll();
  }

  private void CargoSell(int tradeItem, boolean all) {
    if(game.PriceCargoSell()[tradeItem] > 0) {
      game.CargoSellSystem(tradeItem, all, this);
    } else {
      game.CargoDump(tradeItem, this);
    }
    UpdateAll();
  }

  private void ClearHighScores() {
    HighScoreRecord[] highScores = new HighScoreRecord[3];
    Functions.SaveFile(Consts.HighScoreFile, STSerializableObject.ArrayToArrayList(highScores), this);
  }

  private void GameEnd() {
    SetInGameControlsEnabled(false);
    AlertType alertType = AlertType.Alert;
    switch(game.getEndStatus()) {
      case Killed:
        alertType = AlertType.GameEndKilled;
        break;
      case Retired:
        alertType = AlertType.GameEndRetired;
        break;
      case BoughtMoon:
        alertType = AlertType.GameEndBoughtMoon;
        break;
    }
    FormAlert.Alert(alertType, this);
    FormAlert.Alert(AlertType.GameEndScore, this, Functions.FormatNumber(game.Score() / 10), Functions.FormatNumber(game.Score() % 10));
    HighScoreRecord candidate = new HighScoreRecord(
        cmdr.Name(), game.Score(), game.getEndStatus(),
        cmdr.getDays(), cmdr.Worth(), game.Difficulty());
    if(candidate.CompareTo(Functions.GetHighScores(this)[0]) > 0) {
      if(game.getCheatEnabled()) {
        FormAlert.Alert(AlertType.GameEndHighScoreCheat, this);
      } else {
        AddHighScore(candidate);
        FormAlert.Alert(AlertType.GameEndHighScoreAchieved, this);
      }
    } else {
      FormAlert.Alert(AlertType.GameEndHighScoreMissed, this);
    }
    Game.CurrentGame(null);
    game = null;
  }

  private String GetRegistrySetting(String settingName, String defaultValue) {
    String settingValue = defaultValue;
    try {
      RegistryKey key = Functions.GetRegistryKey();
      Object ObjectValue = key.GetValue(settingName);
      if(ObjectValue != null) {
        settingValue = ObjectValue.toString();
      }
      key.Close();
    } catch(NullPointerException ex) {
      FormAlert.Alert(AlertType.RegistryError, this, ex.getMessage());
    }
    return settingValue;
  }

  // Make sure all directories exists.
  private void InitFileStructure() {
    String[] paths = new String[]{
      Consts.CustomDirectory,
      Consts.CustomImagesDirectory,
      Consts.CustomTemplatesDirectory,
      Consts.DataDirectory,
      Consts.SaveDirectory
    };
    for(String path : paths) {
      if(!Directory.Exists(path)) {
        Directory.CreateDirectory(path);
      }
    }
    dlgOpen.setInitialDirectory(Consts.SaveDirectory);
    dlgSave.setInitialDirectory(Consts.SaveDirectory);
  }

  private void LoadGame(String fileName) {
    try {
      Object obj = Functions.LoadFile(fileName, false, this);
      if(obj != null) {
        game = new Game((Hashtable)obj, this);
        cmdr = game.Commander();
        SaveGameFile = fileName;
        SaveGameDays = cmdr.getDays();
        SetInGameControlsEnabled(true);
        UpdateAll();
      }
    } catch(FutureVersionException ex) {
      FormAlert.Alert(AlertType.FileErrorOpen, this, fileName, Strings.FileFutureVersion);
    }
  }

  private void SaveGame(String fileName, boolean saveFileName) {
    if(Functions.SaveFile(fileName, game.Serialize(), this) && saveFileName) {
      SaveGameFile = fileName;
    }
    SaveGameDays = cmdr.getDays();
  }

  private void SetInGameControlsEnabled(boolean enabled) {
    mnuGameSave.setEnabled(enabled);
    mnuGameSaveAs.setEnabled(enabled);
    mnuRetire.setEnabled(enabled);
    mnuViewCommander.setEnabled(enabled);
    mnuViewShip.setEnabled(enabled);
    mnuViewPersonnel.setEnabled(enabled);
    mnuViewQuests.setEnabled(enabled);
    mnuViewBank.setEnabled(enabled);
  }

  private void SetRegistrySetting(String settingName, String settingValue) {
    try {
      RegistryKey key = Functions.GetRegistryKey();
      key.SetValue(settingName, settingValue);
      key.Close();
    } catch(NullPointerException ex) {
      FormAlert.Alert(AlertType.RegistryError, this, ex.getMessage());
    }
  }

  public void UpdateAll() {
    UpdateCargo();
    UpdateDock();
    UpdateShipyard();
    UpdateStatusBar();
    UpdateSystemInfo();
    UpdateTargetSystemInfo();
    UpdateCharts();
  }

  private void UpdateCargo() {
    if(game == null || cmdr.CurrentSystem() == null) {
      for(int i = 0; i < lblSellPrice.length; i++) {
        lblSellPrice[i].setText("");
        lblBuyPrice[i].setText("");
        lblTargetPrice[i].setText("");
        lblTargetDiff[i].setText("");
        lblTargetPct[i].setText("");
        btnSellQty[i].setVisible(false);
        btnSellAll[i].setVisible(false);
        btnBuyQty[i].setVisible(false);
        btnBuyMax[i].setVisible(false);
      }
    } else {
      int[] buy = game.PriceCargoBuy();
      int[] sell = game.PriceCargoSell();
      cmdr = game.Commander();//todo: is this unnecessary? GAC
      StarSystem warpSys = game.WarpSystem();
      for(int i = 0; i < lblSellPrice.length; i++) {
        int price = warpSys == null ? 0 : Consts.TradeItems[i].StandardPrice(warpSys);
        lblSellPrice[i].setText(sell[i] > 0 ? Functions.FormatMoney(sell[i]) : "no trade");
        btnSellQty[i].setText("" + cmdr.getShip().Cargo()[i]);
        btnSellQty[i].setVisible(true);
        btnSellAll[i].setText(sell[i] > 0 ? "All" : "Dump");
        btnSellAll[i].setVisible(true);
        lblBuyPrice[i].setText(buy[i] > 0 ? Functions.FormatMoney(buy[i]) : "not sold");
        btnBuyQty[i].setText("" + cmdr.CurrentSystem().TradeItems()[i]);
        btnBuyQty[i].setVisible(buy[i] > 0);
        btnBuyMax[i].setVisible(buy[i] > 0);
        if(sell[i] * cmdr.getShip().Cargo()[i] > cmdr.PriceCargo()[i]) {
          lblSellPrice[i].setFont(lblSystemNameLabel.getFont());
        } else {
          lblSellPrice[i].setFont(lblSell.getFont());
        }
        if(warpSys != null && warpSys.DestOk() && price > 0) {
          lblTargetPrice[i].setText(Functions.FormatMoney(price));
        } else {
          lblTargetPrice[i].setText("-----------");
        }
        if(warpSys != null && warpSys.DestOk() && price > 0 && buy[i] > 0) {
          int diff = price - buy[i];
          lblTargetDiff[i].setText((diff > 0 ? "+" : "") + Functions.FormatMoney(diff));
          lblTargetPct[i].setText((diff > 0 ? "+" : "") + Functions.FormatNumber(100 * diff / buy[i]) + "%");
          lblBuyPrice[i].setFont(
              (diff > 0 && cmdr.CurrentSystem().TradeItems()[i] > 0)
              ? lblSystemNameLabel.getFont() : lblBuy.getFont());
        } else {
          lblTargetDiff[i].setText("------------");
          lblTargetPct[i].setText("--------");
          lblBuyPrice[i].setFont(lblBuy.getFont());
        }
        lblTargetPrice[i].setFont(lblBuyPrice[i].getFont());
        lblTargetDiff[i].setFont(lblBuyPrice[i].getFont());
        lblTargetPct[i].setFont(lblBuyPrice[i].getFont());
      }
    }
  }

  private void UpdateCharts() {
    picGalacticChart.Refresh();
    picShortRangeChart.Refresh();
    if(game == null) {
      lblWormholeLabel.setVisible(false);
      lblWormhole.setVisible(false);
      btnJump.setVisible(false);
      btnFind.setVisible(false);
    } else {
      if(game.TargetWormhole()) {
        lblWormholeLabel.setVisible(true);
        lblWormhole.setVisible(true);
        lblWormhole.setText(game.WarpSystem().Name());
      } else {
        lblWormholeLabel.setVisible(false);
        lblWormhole.setVisible(false);
      }
      btnJump.setVisible(game.getCanSuperWarp());
      btnFind.setVisible(true);
    }
  }

  private void UpdateDock() {
    if(game == null) {
      lblFuelStatus.setText("");
      lblFuelCost.setText("");
      btnFuel.setVisible(false);
      lblHullStatus.setText("");
      lblRepairCost.setText("");
      btnRepair.setVisible(false);
    } else {
      Ship ship = cmdr.getShip();
      lblFuelStatus.setText(
          Functions.StringVars("You have fuel to fly ^1.", Functions.Multiples(ship.getFuel(), "parsec")));
      int tanksEmpty = ship.FuelTanks() - ship.getFuel();
      lblFuelCost.setText(tanksEmpty > 0
          ? Functions.StringVars("A full tank costs ^1", Functions.FormatMoney(tanksEmpty * ship.getFuelCost()))
          : "Your tank is full.");
      btnFuel.setVisible(tanksEmpty > 0);
      lblHullStatus.setText(
          Functions.StringVars("Your hull strength is at ^1%.",
          Functions.FormatNumber((int)Math.floor((double)100 * ship.getHull() / ship.HullStrength()))));
      int hullLoss = ship.HullStrength() - ship.getHull();
      lblRepairCost.setText(hullLoss > 0
          ? Functions.StringVars("Full repairs will cost ^1", Functions.FormatMoney(hullLoss * ship.getRepairCost()))
          : "No repairs are needed.");
      btnRepair.setVisible(hullLoss > 0);
    }
  }

  private void UpdateShipyard() {
    if(game == null) {
      lblShipsForSale.setText("");
      lblEquipForSale.setText("");
      lblEscapePod.setText("");
      btnPod.setVisible(false);
      btnBuyShip.setVisible(false);
      btnDesign.setVisible(false);
      btnEquip.setVisible(false);
    } else {
      boolean noTech =
          cmdr.CurrentSystem().TechLevel().ordinal()
          < Consts.ShipSpecs[ShipType.Flea.CastToInt()].MinimumTechLevel().ordinal();
      lblShipsForSale.setText(noTech ? Strings.ShipyardShipNoSale : Strings.ShipyardShipForSale);
      btnBuyShip.setVisible(true);
      btnDesign.setVisible((cmdr.CurrentSystem().Shipyard() != null));
      lblEquipForSale.setText(noTech ? Strings.ShipyardEquipNoSale : Strings.ShipyardEquipForSale);
      btnEquip.setVisible(true);
      btnPod.setVisible(false);
      if(cmdr.getShip().getEscapePod()) {
        lblEscapePod.setText(Strings.ShipyardPodInstalled);
      } else if(noTech) {
        lblEscapePod.setText(Strings.ShipyardPodNoSale);
      } else if(cmdr.getCash() < 2000) {
        lblEscapePod.setText(Strings.ShipyardPodIF);
      } else {
        lblEscapePod.setText(Strings.ShipyardPodCost);
        btnPod.setVisible(true);
      }
    }
  }

  public void UpdateStatusBar() {
    if(game == null) {
      statusBarPanelCash.setText("");
      statusBarPanelBays.setText("");
      statusBarPanelCosts.setText("");
      statusBarPanelExtra.setText("No Game Loaded.");
    } else {
      statusBarPanelCash.setText("Cash: " + Functions.FormatMoney(cmdr.getCash()));
      statusBarPanelBays.setText(
          "Bays: " + cmdr.getShip().FilledCargoBays() + "/" + cmdr.getShip().CargoBays());
      statusBarPanelCosts.setText("Current Costs: " + Functions.FormatMoney(game.CurrentCosts()));
      statusBarPanelExtra.setText("");
    }
  }

  private void UpdateSystemInfo() {
    if(game == null || cmdr.CurrentSystem() == null) {
      lblSystemName.setText("");
      lblSystemSize.setText("");
      lblSystemTech.setText("");
      lblSystemPolSys.setText("");
      lblSystemResource.setText("");
      lblSystemPolice.setText("");
      lblSystemPirates.setText("");
      lblSystemPressure.setText("");
      lblSystemPressurePre.setVisible(false);
      btnNews.setVisible(false);
      btnMerc.setVisible(false);
      btnSpecial.setVisible(false);
    } else {
      StarSystem system = cmdr.CurrentSystem();
      CrewMember[] mercs = system.MercenariesForHire();
      lblSystemName.setText(system.Name());
      lblSystemSize.setText(Strings.Sizes[system.Size().CastToInt()]);
      lblSystemTech.setText(system.TechLevel().name);
      lblSystemPolSys.setText(system.PoliticalSystem().Name());
      lblSystemResource.setText(system.SpecialResource().name);
      lblSystemPolice.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPolice().CastToInt()]);
      lblSystemPirates.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPirates().CastToInt()]);
      lblSystemPressure.setText(system.SystemPressure().name);
      lblSystemPressurePre.setVisible(true);
      btnNews.setVisible(true);
      btnMerc.setVisible(mercs.length > 0);
      if(btnMerc.getVisible()) {
        tipMerc.SetToolTip(btnMerc, Functions.StringVars(
            Strings.MercenariesForHire,
            mercs.length == 1 ? mercs[0].Name() : mercs.length + Strings.Mercenaries));
      }
      btnSpecial.setVisible(system.ShowSpecialButton());
      if(btnSpecial.getVisible()) {
        tipSpecial.SetToolTip(btnSpecial, system.SpecialEvent().Title());
      }
    }
  }

  private void UpdateTargetSystemInfo() {
    btnNextSystem.setVisible(game != null);
    btnPrevSystem.setVisible(game != null);
    if(game == null || game.WarpSystem() == null) {
      lblTargetName.setText("");
      lblTargetSize.setText("");
      lblTargetTech.setText("");
      lblTargetPolSys.setText("");
      lblTargetResource.setText("");
      lblTargetPolice.setText("");
      lblTargetPirates.setText("");
      lblTargetDistance.setText("");
      lblTargetOutOfRange.setVisible(false);
      btnWarp.setVisible(false);
      btnTrack.setVisible(false);
    } else {
      StarSystem system = game.WarpSystem();
      int distance = Functions.Distance(cmdr.CurrentSystem(), system);
      lblTargetName.setText(system.Name());
      lblTargetSize.setText(Strings.Sizes[system.Size().CastToInt()]);
      lblTargetTech.setText(system.TechLevel().name);
      lblTargetPolSys.setText(system.PoliticalSystem().Name());
      lblTargetResource.setText(system.Visited() ? system.SpecialResource().name : Strings.Unknown);
      lblTargetPolice.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPolice().CastToInt()]);
      lblTargetPirates.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPirates().CastToInt()]);
      lblTargetDistance.setText("" + distance);
      lblTargetOutOfRange.setVisible(!system.DestOk() && system != cmdr.CurrentSystem());
      btnWarp.setVisible(system.DestOk());
      btnTrack.setVisible(lblTargetOutOfRange.getVisible() && system != game.TrackedSystem());
    }
  }

  private void SpaceTrader_Closing(Object sender, CancelEventArgs e) {
    if(game == null || cmdr.getDays() == SaveGameDays
        || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes) {
      if(WindowState == FormWindowState.Normal) {
        SetRegistrySetting("X", Left.toString());
        SetRegistrySetting("Y", Top.toString());
      }
    } else {
      e.Cancel = true;
    }
  }

  private void SpaceTrader_Load(Object sender, EventArgs e) {
    Left = Integer.parseInt(GetRegistrySetting("X", "0"));
    Top = Integer.parseInt(GetRegistrySetting("Y", "0"));
    FormAlert.Alert(AlertType.AppStart, this);
  }

  private void btnBuySell_Click(Object sender, EventArgs e) {
    String name = ((Button)sender).getName();
    boolean all = name.indexOf("Qty") < 0;
    int index = Integer.parseInt(name.substring(name.length() - 1));
    if(name.indexOf("Buy") < 0) {
      CargoSell(index, all);
    } else {
      CargoBuy(index, all);
    }
  }

  private void btnBuyShip_Click(Object sender, EventArgs e) {
    (new FormShipList()).ShowDialog(this);
    UpdateAll();
  }

  private void btnDesign_Click(Object sender, EventArgs e) {
    (new FormShipyard()).ShowDialog(this);
    UpdateAll();
  }

  private void btnEquip_Click(Object sender, EventArgs e) {
    (new FormEquipment()).ShowDialog(this);
    UpdateAll();
  }

  private void btnFind_Click(Object sender, EventArgs e) {
    FormFind form = new FormFind();
    if(form.ShowDialog(this) == DialogResult.OK) {
      Ship ship = cmdr.getShip();
      String[] words = form.SystemName().split(" ");
      String first = words.length > 0 ? words[0] : "";
      String second = words.length > 1 ? words[1] : "";
      String third = words.length > 2 ? words[2] : "";
      int num1 = Functions.IsInt(second) ? Integer.parseInt(second) : 0;
      int num2 = Functions.IsInt(third) ? Integer.parseInt(third) : 0;
      boolean find = false;
      if(game.getCheatEnabled()) {
        switch(SomeStringsForSwitch.find(first)) {
          case Bazaar:
            game.setChanceOfTradeInOrbit(Math.max(0, Math.min(1000, num1)));
            break;
          case Cover:
            if(num1 >= 0 && num1 < ship.Shields().length && num2 >= 0 && num2 < Consts.Shields.length) {
              ship.Shields()[num1] = (Shield)Consts.Shields[num2].Clone();
            }
            break;
          case DeLorean:
            cmdr.setDays(Math.max(0, num1));
            break;
          case Diamond:
            ship.setHullUpgraded(!ship.getHullUpgraded());
            break;
          case Energize:
            game.setCanSuperWarp(!game.getCanSuperWarp());
            break;
          case Events:
            if(second.equals("Reset")) {
              game.ResetVeryRareEncounters();
            } else {
              String text = "";
              for(Iterator<VeryRareEncounter> list = game.VeryRareEncounters().iterator(); list.hasNext();) {
                text += Strings.VeryRareEncounters[list.next().CastToInt()] + Strings.newline;
              }
              text = text.trim();
              FormAlert.Alert(AlertType.Alert, this, "Remaining Very Rare Encounters", text);
            }
            break;
          case Fame:
            cmdr.setReputationScore(Math.max(0, num1));
            break;
          case Go:
            game.setSelectedSystemByName(second);
            if(game.SelectedSystem().Name().toLowerCase().equals(second.toLowerCase())) {
              if(game.getAutoSave()) {
                SaveGame(SAVE_DEPARTURE, false);
              }
              game.WarpDirect();
              if(game.getAutoSave()) {
                SaveGame(SAVE_ARRIVAL, false);
              }
            }
            break;
          case Ice: {
            switch(SomeStringsForSwitch.find(second)) {
              case Pirate:
                cmdr.setKillsPirate(Math.max(0, num2));
                break;
              case Police:
                cmdr.setKillsPolice(Math.max(0, num2));
                break;
              case Trader:
                cmdr.setKillsTrader(Math.max(0, num2));
                break;
            }
          }
          break;
          case Indemnity:
            cmdr.NoClaim(Math.max(0, num1));
            break;
          case IOU:
            cmdr.setDebt(Math.max(0, num1));
            break;
          case Iron:
            if(num1 >= 0 && num1 < ship.Weapons().length && num2 >= 0 && num2 < Consts.WeapObjs.length) {
              ship.Weapons()[num1] = (Weapon)Consts.WeapObjs[num2].Clone();
            }
            break;
          case Juice:
            ship.setFuel(Math.max(0, Math.min(ship.FuelTanks(), num1)));
            break;
          case Knack:
            if(num1 >= 0 && num1 < game.Mercenaries().length) {
              String[] skills = third.split(",");
              for(int i = 0; i < game.Mercenaries()[num1].Skills().length && i < skills.length; i++) {
                if(Functions.IsInt(skills[i])) {
                  game.Mercenaries()[num1].Skills()[i] =
                      Math.max(1, Math.min(Consts.MaxSkill, Integer.parseInt(skills[i])));
                }
              }
            }
            break;
          case L_Engle:
            game.setFabricRipProbability(Math.max(0, Math.min(Consts.FabricRipInitialProbability, num1)));
            break;
          case LifeBoat:
            ship.setEscapePod(!ship.getEscapePod());
            break;
          case MonsterCom:
            (new FormMonster()).ShowDialog(this);
            break;
          case PlanB:
            game.setAutoSave(true);
            break;
          case Posse:
            if(num1 > 0 && num1 < ship.Crew().length && num2 > 0 && num2 < game.Mercenaries().length
                && !Util.ArrayContains(Consts.SpecialCrewMemberIds, (CrewMemberId.FromInt(num2)))) {
              int skill = ship.Trader();
              ship.Crew()[num1] = game.Mercenaries()[num2];
              if(ship.Trader() != skill) {
                game.RecalculateBuyPrices(cmdr.CurrentSystem());
              }
            }
            break;
          case RapSheet:
            cmdr.setPoliceRecordScore(num1);
            break;
          case Rarity:
            game.setChanceOfVeryRareEncounter(Math.max(0, Math.min(1000, num1)));
            break;
          case Scratch:
            cmdr.setCash(Math.max(0, num1));
            break;
          case Skin:
            ship.setHull(Math.max(0, Math.min(ship.HullStrength(), num1)));
            break;
          case Status: {
            switch(SomeStringsForSwitch.find(second)) {
              case Artifact:
                game.setQuestStatusArtifact(Math.max(0, num2));
                break;
              case Dragonfly:
                game.setQuestStatusDragonfly(Math.max(0, num2));
                break;
              case Experiment:
                game.setQuestStatusExperiment(Math.max(0, num2));
                break;
              case Gemulon:
                game.setQuestStatusGemulon(Math.max(0, num2));
                break;
              case Japori:
                game.setQuestStatusJapori(Math.max(0, num2));
                break;
              case Jarek:
                game.setQuestStatusJarek(Math.max(0, num2));
                break;
              case Moon:
                game.setQuestStatusMoon(Math.max(0, num2));
                break;
              case Reactor:
                game.setQuestStatusReactor(Math.max(0, num2));
                break;
              case Princess:
                game.setQuestStatusPrincess(Math.max(0, num2));
                break;
              case Scarab:
                game.setQuestStatusScarab(Math.max(0, num2));
                break;
              case Sculpture:
                game.setQuestStatusSculpture(Math.max(0, num2));
                break;
              case SpaceMonster:
                game.setQuestStatusSpaceMonster(Math.max(0, num2));
                break;
              case Wild:
                game.setQuestStatusWild(Math.max(0, num2));
                break;
              default:
                String text = "Artifact: "
                    + game.getQuestStatusArtifact() + Strings.newline + "Dragonfly: "
                    + game.getQuestStatusDragonfly() + Strings.newline + "Experiment: "
                    + game.getQuestStatusExperiment() + Strings.newline + "Gemulon: "
                    + game.getQuestStatusGemulon() + Strings.newline + "Japori: "
                    + game.getQuestStatusJapori() + Strings.newline + "Jarek: "
                    + game.getQuestStatusJarek() + Strings.newline + "Moon: " + game.getQuestStatusMoon()
                    + Strings.newline + "Princess: " + game.getQuestStatusPrincess() + Strings.newline
                    + "Reactor: " + game.getQuestStatusReactor() + Strings.newline + "Scarab: "
                    + game.getQuestStatusScarab() + Strings.newline + "Sculpture: "
                    + game.getQuestStatusSculpture() + Strings.newline + "SpaceMonster: "
                    + game.getQuestStatusSpaceMonster() + Strings.newline + "Wild: "
                    + game.getQuestStatusWild();
                FormAlert.Alert(AlertType.Alert, this, "Status of Quests", text);
                break;
            }
          }
          break;
          case Swag:
            if(num1 >= 0 && num1 < ship.Cargo().length) {
              ship.Cargo()[num1] = Math.max(0, Math.min(ship.FreeCargoBays() + ship.Cargo()[num1], num2));
            }
            break;
          case Test:
            (new FormTest()).ShowDialog(this);
            break;
          case Tool:
            if(num1 >= 0 && num1 < ship.Gadgets().length && num2 >= 0 && num2 < Consts.Gadgets.length) {
              ship.Gadgets()[num1] = (Gadget)Consts.Gadgets[num2].Clone();
            }
            break;
          case Varmints:
            ship.setTribbles(Math.max(0, num1));
            break;
          case Yellow:
            game.setEasyEncounters(true);
            break;
          default:
            find = true;
            break;
        }
      } else {
        switch(SomeStringsForSwitch.find(first)) {
          case Cheetah:
            FormAlert.Alert(AlertType.Cheater, this);
            game.setCheatEnabled(true);
            break;
          default:
            find = true;
            break;
        }
      }
      if(find) {
        game.setSelectedSystemByName(form.SystemName());
        if(form.TrackSystem() && game.SelectedSystem().Name().toLowerCase().equals(form.SystemName().toLowerCase())) {
          game.setTrackedSystemId(game.SelectedSystemId());
        }
      }
      UpdateAll();
    }
  }

  private void btnFuel_Click(Object sender, EventArgs e) {
    FormBuyFuel form = new FormBuyFuel();
    if(form.ShowDialog(this) == DialogResult.OK) {
      int toAdd = form.Amount() / cmdr.getShip().getFuelCost();
      cmdr.getShip().setFuel(cmdr.getShip().getFuel() + toAdd);
      cmdr.setCash(cmdr.getCash() - (toAdd * cmdr.getShip().getFuelCost()));
      UpdateAll();
    }
  }

  private void btnJump_Click(Object sender, EventArgs e) {
    if(game.WarpSystem() == null) {
      FormAlert.Alert(AlertType.ChartJumpNoSystemSelected, this);
    } else if(game.WarpSystem() == cmdr.CurrentSystem()) {
      FormAlert.Alert(AlertType.ChartJumpCurrent, this);
    } else if(FormAlert.Alert(AlertType.ChartJump, this, game.WarpSystem().Name()) == DialogResult.Yes) {
      game.setCanSuperWarp(false);
      try {
        if(game.getAutoSave()) {
          SaveGame(SAVE_DEPARTURE, false);
        }
        game.Warp(true);
        if(game.getAutoSave()) {
          SaveGame(SAVE_ARRIVAL, false);
        }
      } catch(GameEndException ex) {
        GameEnd();
      }
      UpdateAll();
    }
  }

  private void btnMerc_Click(Object sender, EventArgs e) {
    (new FormViewPersonnel()).ShowDialog(this);
    UpdateAll();
  }

  private void btnNews_Click(Object sender, EventArgs e) {
    game.ShowNewspaper();
  }

  private void btnNextSystem_Click(Object sender, EventArgs e) {
    game.SelectNextSystemWithinRange(true);
    UpdateAll();
  }

  private void btnPod_Click(Object sender, EventArgs e) {
    if(FormAlert.Alert(AlertType.EquipmentEscapePod, this) == DialogResult.Yes) {
      cmdr.setCash(cmdr.getCash() - 2000);
      cmdr.getShip().setEscapePod(true);
      UpdateAll();
    }
  }

  private void btnPrevSystem_Click(Object sender, EventArgs e) {
    game.SelectNextSystemWithinRange(false);
    UpdateAll();
  }

  private void btnRepair_Click(Object sender, EventArgs e) {
    FormBuyRepairs form = new FormBuyRepairs();
    if(form.ShowDialog(this) == DialogResult.OK) {
      int toAdd = form.Amount() / cmdr.getShip().getRepairCost();
      cmdr.getShip().setHull(cmdr.getShip().getHull() + toAdd);
      cmdr.setCash(cmdr.getCash() - (toAdd * cmdr.getShip().getRepairCost()));
      UpdateAll();
    }
  }

  private void btnSpecial_Click(Object sender, EventArgs e) {
    SpecialEvent specEvent = cmdr.CurrentSystem().SpecialEvent();
    String btn1, btn2;
    DialogResult res1, res2;
    if(specEvent.MessageOnly()) {
      btn1 = "Ok";
      btn2 = null;
      res1 = DialogResult.OK;
      res2 = DialogResult.None;
    } else {
      btn1 = "Yes";
      btn2 = "No";
      res1 = DialogResult.Yes;
      res2 = DialogResult.No;
    }
    FormAlert alert = new FormAlert(specEvent.Title(), specEvent.String(), btn1, res1, btn2, res2, null);
    if(alert.ShowDialog() != DialogResult.No) {
      if(cmdr.CashToSpend() < specEvent.Price()) {
        FormAlert.Alert(AlertType.SpecialIF, this);
      } else {
        try {
          game.HandleSpecialEvent();
        } catch(GameEndException ex) {
          GameEnd();
        }
      }
    }
    UpdateAll();
  }

  private void btnTrack_Click(Object sender, EventArgs e) {
    game.setTrackedSystemId(game.SelectedSystemId());
    UpdateAll();
  }

  private void btnWarp_Click(Object sender, EventArgs e) {
    try {
      if(game.getAutoSave()) {
        SaveGame(SAVE_DEPARTURE, false);
      }
      game.Warp(false);
      if(game.getAutoSave()) {
        SaveGame(SAVE_ARRIVAL, false);
      }
    } catch(GameEndException ex) {
      GameEnd();
    }
    UpdateAll();
  }

  private void mnuGameExit_Click(Object sender, EventArgs e) {
    Close();
  }

  private void mnuGameNew_Click(Object sender, EventArgs e) {
    FormNewCommander form = new FormNewCommander();
    if((game == null || cmdr.getDays() == SaveGameDays
        || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes)
        && form.ShowDialog(this) == DialogResult.OK) {
      game = new Game(
          form.CommanderName(), form.Difficulty(), form.Pilot(),
          form.Fighter(), form.Trader(), form.Engineer(), this);
      cmdr = game.Commander();
      SaveGameFile = null;
      SaveGameDays = 0;
      SetInGameControlsEnabled(true);
      UpdateAll();
      if(game.Options().getNewsAutoShow()) {
        game.ShowNewspaper();
      }
    }
  }

  private void mnuGameLoad_Click(Object sender, EventArgs e) {
    if((game == null || cmdr.getDays() == SaveGameDays
        || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes)
        && dlgOpen.ShowDialog(this) == DialogResult.OK) {
      LoadGame(dlgOpen.getFileName());
    }
  }

  private void mnuGameSave_Click(Object sender, EventArgs e) {
    if(game != null) {
      if(SaveGameFile != null) {
        SaveGame(SaveGameFile, false);
      } else {
        mnuGameSaveAs_Click(sender, e);
      }
    }
  }

  private void mnuGameSaveAs_Click(Object sender, EventArgs e) {
    if(game != null && dlgSave.ShowDialog(this) == DialogResult.OK) {
      SaveGame(dlgSave.getFileName(), true);
    }
  }

  private void mnuHelpAbout_Click(Object sender, EventArgs e) {
    (new FormAbout()).ShowDialog(this);
  }

  private void mnuHighScores_Click(Object sender, EventArgs e) {
    (new FormViewHighScores()).ShowDialog(this);
  }

  private void mnuOptions_Click(Object sender, EventArgs e) {
    FormOptions form = new FormOptions();
    if(form.ShowDialog(this) == DialogResult.OK) {
      game.Options().CopyValues(form.Options());
      UpdateAll();
    }
  }

  private void mnuRetire_Click(Object sender, EventArgs e) {
    if(FormAlert.Alert(AlertType.GameRetire, this) == DialogResult.Yes) {
      game.setEndStatus(GameEndType.Retired);
      GameEnd();
      UpdateAll();
    }
  }

  private void mnuViewBank_Click(Object sender, EventArgs e) {
    (new FormViewBank()).ShowDialog(this);
  }

  private void mnuViewCommander_Click(Object sender, EventArgs e) {
    (new FormViewCommander()).ShowDialog(this);
  }

  private void mnuViewPersonnel_Click(Object sender, EventArgs e) {
    (new FormViewPersonnel()).ShowDialog(this);
  }

  private void mnuViewQuests_Click(Object sender, EventArgs e) {
    (new FormViewQuests()).ShowDialog(this);
  }

  private void mnuViewShip_Click(Object sender, EventArgs e) {
    (new FormViewShip()).ShowDialog(this);
  }

  private void picGalacticChart_MouseDown(Object sender, MouseEventArgs e) {
    if(e.Button == MouseButtons.Left && game != null) {
      StarSystem[] universe = game.Universe();
      boolean clickedSystem = false;
      for(int i = 0; i < universe.length && !clickedSystem; i++) {
        int x = universe[i].X() + OFF_X;
        int y = universe[i].Y() + OFF_Y;
        if(e.X >= x - 2 && e.X <= x + 2 && e.Y >= y - 2 && e.Y <= y + 2) {
          clickedSystem = true;
          game.SelectedSystemId(StarSystemId.FromInt(i));
        } else if(Functions.WormholeExists(i, -1)) {
          int xW = x + OFF_X_WORM;
          if(e.X >= xW - 2 && e.X <= xW + 2 && e.Y >= y - 2 && e.Y <= y + 2) {
            clickedSystem = true;
            game.SelectedSystemId(StarSystemId.FromInt(i));
            game.TargetWormhole(true);
          }
        }
      }
      if(clickedSystem) {
        UpdateAll();
      }
    }
  }

  private void picGalacticChart_Paint(Object sender, PaintEventArgs e) {
    if(game != null) {
      StarSystem[] universe = game.Universe();
      int[] wormholes = game.Wormholes();
      StarSystem targetSys = game.SelectedSystem();
      StarSystem curSys = cmdr.CurrentSystem();
      int fuel = cmdr.getShip().getFuel();
      if(fuel > 0) {
        e.Graphics.DrawEllipse(DEFAULT_PEN, curSys.X() + OFF_X - fuel, curSys.Y() + OFF_Y - fuel, fuel * 2, fuel * 2);
      }
      int index = game.SelectedSystemId().CastToInt();
      if(game.TargetWormhole()) {
        int dest = wormholes[(Util.BruteSeek(wormholes, index) + 1) % wormholes.length];
        StarSystem destSys = universe[dest];
        e.Graphics.DrawLine(
            DEFAULT_PEN, targetSys.X() + OFF_X_WORM + OFF_X,
            targetSys.Y() + OFF_Y, destSys.X() + OFF_X, destSys.Y() + OFF_Y);
      }
      for(int i = 0; i < universe.length; i++) {
        int imageIndex = universe[i].Visited() ? IMG_S_V : IMG_S_N;
        if(universe[i] == game.WarpSystem()) {
          imageIndex++;
        }
        WfImage image = ilChartImages.getImages()[imageIndex];
        if(universe[i] == game.TrackedSystem()) {
          e.Graphics.DrawLine(
              DEFAULT_PEN, universe[i].X(), universe[i].Y(),
              universe[i].X() + image.getWidth() - 1, universe[i].Y() + image.getHeight() - 1);
          e.Graphics.DrawLine(
              DEFAULT_PEN, universe[i].X(), universe[i].Y() + image.getHeight() - 1,
              universe[i].X() + image.getWidth() - 1, universe[i].Y());
        }
        ilChartImages.Draw(e.Graphics, universe[i].X(), universe[i].Y(), imageIndex);
        if(Functions.WormholeExists(i, -1)) {
          ilChartImages.Draw(e.Graphics, universe[i].X() + OFF_X_WORM, universe[i].Y(), IMG_S_W);
        }
      }
    } else {
      e.Graphics.FillRectangle(DEFAULT_BRUSH, 0, 0, picGalacticChart.getWidth(), picGalacticChart.getHeight());
    }
  }

  private void picShortRangeChart_MouseDown(Object sender, MouseEventArgs e) {
    if(e.Button == MouseButtons.Left && game != null) {
      StarSystem[] universe = game.Universe();
      StarSystem curSys = cmdr.CurrentSystem();
      boolean clickedSystem = false;
      int centerX = picShortRangeChart.getWidth() / 2;
      int centerY = picShortRangeChart.getHeight() / 2;
      int delta = picShortRangeChart.getHeight() / (Consts.MaxRange * 2);
      for(int i = 0; i < universe.length && !clickedSystem; i++) {
        if((Math.abs(universe[i].X() - curSys.X()) * delta <= picShortRangeChart.getWidth() / 2 - 10)
            && (Math.abs(universe[i].Y() - curSys.Y()) * delta <= picShortRangeChart.getHeight() / 2 - 10)) {
          int x = centerX + (universe[i].X() - curSys.X()) * delta;
          int y = centerY + (universe[i].Y() - curSys.Y()) * delta;
          if(e.X >= x - OFF_X && e.X <= x + OFF_X && e.Y >= y - OFF_Y && e.Y <= y + OFF_Y) {
            clickedSystem = true;
            game.SelectedSystemId(StarSystemId.FromInt(i));
          } else if(Functions.WormholeExists(i, -1)) {
            int xW = x + 9;
            if(e.X >= xW - OFF_X && e.X <= xW + OFF_X && e.Y >= y - OFF_Y && e.Y <= y + OFF_Y) {
              clickedSystem = true;
              game.SelectedSystemId((StarSystemId.FromInt(i)));
              game.TargetWormhole(true);
            }
          }
        }
      }
      if(clickedSystem) {
        UpdateAll();
      }
    }
  }

  private void picShortRangeChart_Paint(Object sender, PaintEventArgs e) {
    if(game == null) {
      e.Graphics.FillRectangle(DEFAULT_BRUSH, 0, 0, picShortRangeChart.getWidth(), picShortRangeChart.getHeight());
    } else {
      int[] wormholes = game.Wormholes();
      int fuel = cmdr.getShip().getFuel();
      int centerX = picShortRangeChart.getWidth() / 2;
      int centerY = picShortRangeChart.getHeight() / 2;
      int delta = picShortRangeChart.getHeight() / (Consts.MaxRange * 2);
      e.Graphics.DrawLine(DEFAULT_PEN, centerX - 1, centerY - 1, centerX + 1, centerY + 1);
      e.Graphics.DrawLine(DEFAULT_PEN, centerX - 1, centerY + 1, centerX + 1, centerY - 1);
      if(fuel > 0) {
        e.Graphics.DrawEllipse(DEFAULT_PEN, centerX - fuel * delta, centerY - fuel * delta, fuel * delta * 2, fuel * delta * 2);
      }
      StarSystem curSys = cmdr.CurrentSystem();
      StarSystem trackSys = game.TrackedSystem();
      if(trackSys != null) {
        int dist = Functions.Distance(curSys, trackSys);
        if(dist > 0) {
          int dX = (int)Math.round(25 * (trackSys.X() - curSys.X()) / (double)dist);
          int dY = (int)Math.round(25 * (trackSys.Y() - curSys.Y()) / (double)dist);
          int dX2 = (int)Math.round(4 * (trackSys.Y() - curSys.Y()) / (double)dist);
          int dY2 = (int)Math.round(4 * (curSys.X() - trackSys.X()) / (double)dist);
          e.Graphics.FillPolygon(new SolidBrush(new Color(220, 20, 60)), new Point[]{
                new Point(centerX + dX, centerY + dY), new Point(centerX - dX2, centerY - dY2), new Point(centerX + dX2, centerY + dY2)
              });
        }
        if(game.Options().getShowTrackedRange()) {
          e.Graphics.DrawString(
              Functions.StringVars("^1 to ^2.", Functions.Multiples(dist, Strings.DistanceUnit), trackSys.Name()),
              getFont(), new SolidBrush(Color.black), 0, picShortRangeChart.getHeight() - 13);
        }
      }
      // First, draw the names, then the systems.
      // The names may overlap and the systems may be drawn on the names, but at least every system is visible.
      StarSystem[] universe = game.Universe();
      for(int j = 0; j < 2; j++) {
        for(int i = 0; i < universe.length; i++) {
          if((Math.abs(universe[i].X() - curSys.X()) * delta <= picShortRangeChart.getWidth() / 2 - 10)
              && (Math.abs(universe[i].Y() - curSys.Y()) * delta <= picShortRangeChart.getHeight() / 2 - 10)) {
            int x = centerX + (universe[i].X() - curSys.X()) * delta;
            int y = centerY + (universe[i].Y() - curSys.Y()) * delta;
            if(j == 1) {
              if(universe[i] == game.WarpSystem()) {
                e.Graphics.DrawLine(DEFAULT_PEN, x - 6, y, x + 6, y);
                e.Graphics.DrawLine(DEFAULT_PEN, x, y - 6, x, y + 6);
              }
              if(universe[i] == game.TrackedSystem()) {
                e.Graphics.DrawLine(DEFAULT_PEN, x - 5, y - 5, x + 5, y + 5);
                e.Graphics.DrawLine(DEFAULT_PEN, x - 5, y + 5, x + 5, y - 5);
              }
              ilChartImages.Draw(e.Graphics, x - OFF_X, y - OFF_Y, universe[i].Visited() ? IMG_G_V : IMG_G_N);
              if(Functions.WormholeExists(i, -1)) {
                int xW = x + 9;
                if(game.TargetWormhole() && universe[i] == game.SelectedSystem()) {
                  e.Graphics.DrawLine(DEFAULT_PEN, xW - 6, y, xW + 6, y);
                  e.Graphics.DrawLine(DEFAULT_PEN, xW, y - 6, xW, y + 6);
                }
                ilChartImages.Draw(e.Graphics, xW - OFF_X, y - OFF_Y, IMG_G_W);
              }
            } else {
              Font font = new Font(getFont().FontFamily, 7);
              SizeF size = e.Graphics.MeasureString(universe[i].Name(), getFont());
              e.Graphics.DrawString(universe[i].Name(), font, new SolidBrush(Color.black),
                  x - size.width / 2 + OFF_X, y /*- size.Height*/ - 5);
              // implementations differ as to which point we start the string at. --aviv
            }
          }
        }
      }
    }
  }

  private void statusBar_PanelClick(Object sender, StatusBarPanelClickEventArgs e) {
    if(game != null) {
      if(e.StatusBarPanel == statusBarPanelCash) {
        mnuViewBank_Click(sender, e);
      } else if(e.StatusBarPanel == statusBarPanelCosts) {
        (new FormCosts()).ShowDialog(this);
      }
    }
  }

  public WfImage[] CustomShipImages() {
    WfImage[] images = new WfImage[Consts.ImagesPerShip];
    int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
    for(int index = 0; index < Consts.ImagesPerShip; index++) {
      images[index] = ilShipImages.getImages()[baseIndex + index];
    }
    return images;
  }

  public void CustomShipImages(WfImage[] value) {
    WfImage[] images = value;
    int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
    System.arraycopy(images, 0, ilShipImages.getImages(), baseIndex, Consts.ImagesPerShip);
  }

  public ImageList DirectionImages() {
    return ilDirectionImages;
  }

  public ImageList EquipmentImages() {
    return ilEquipmentImages;
  }

  public ImageList ShipImages() {
    return ilShipImages;
  }

  public WfImage[] getCustomShipImages() {
    WfImage[] images = new WfImage[Consts.ImagesPerShip];
    int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
    for(int index = 0; index < Consts.ImagesPerShip; index++) {
      images[index] = ilShipImages.getImages()[baseIndex + index];
    }
    return images;
  }

  public void setCustomShipImages(WfImage[] value) {
    WfImage[] images = value;
    int baseIndex = ShipType.Custom.CastToInt() * Consts.ImagesPerShip;
    System.arraycopy(images, 0, ilShipImages.getImages(), baseIndex, Consts.ImagesPerShip);
  }
}
