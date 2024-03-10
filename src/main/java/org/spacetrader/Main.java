package org.spacetrader;

import org.spacetrader.controller.*;
import org.spacetrader.controller.enums.AlertType;
import org.spacetrader.controller.enums.GameEndType;
import org.spacetrader.controller.enums.StarSystemId;
import org.spacetrader.model.CrewMemberId;
import org.spacetrader.model.events.VeryRareEncounter;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.model.ship.equip.Gadget;
import org.spacetrader.model.ship.equip.Shield;
import org.spacetrader.model.ship.equip.Weapon;
import org.spacetrader.ui.*;
import org.spacetrader.util.Directory;
import org.spacetrader.util.Hashtable;
import org.spacetrader.util.RegistryKey;
import org.spacetrader.util.Util;
import org.winforms.Button;
import org.winforms.Container;
import org.winforms.Font;
import org.winforms.Icon;
import org.winforms.Label;
import org.winforms.MenuItem;
import org.winforms.*;
import org.winforms.enums.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class Main extends wfWindow {

    private final Label[] lblSellPrice;
    private final Label[] lblBuyPrice;
    private final Label[] lblTargetPrice;
    private final Label[] lblTargetDiff;
    private final Label[] lblTargetPct;
    private final Button[] buttonSellQty;
    private final Button[] buttonSellAll;
    private final Button[] buttonBuyQty;
    private final Button[] buttonBuyMax;
    private final String SAVE_ARRIVAL = "autosave_arrival.sav";
    private final String SAVE_DEPARTURE = "autosave_departure.sav";
    private final int OFF_X = 3;
    private final int OFF_Y = 3;
    private final int OFF_X_WORM = OFF_X + 1;
    private final Pen DEFAULT_PEN = new Pen(Color.black);
    private final Brush DEFAULT_BRUSH = new SolidBrush(Color.white);
    private Button buttonDesign;
    private Button buttonNews;
    private Button buttonSpecial;
    private Button buttonMerc;
    private Button buttonFuel;
    private Button buttonRepair;
    private Button buttonBuyShip;
    private Button buttonEquip;
    private Button buttonPod;
    private Button buttonJump;
    private Button buttonFind;
    private Button buttonPrevSystem;
    private Button buttonNextSystem;
    private Button buttonTrack;
    private Button buttonWarp;
    private ImageList ilChartImages;
    private ImageList ilDirectionImages;
    private ImageList ilEquipmentImages;
    private ImageList ilShipImages;
    private Label lblBuy;
    private Label lblEquipForSale;
    private Label lblEscapePod;
    private Label lblFuelCost;
    private Label lblFuelStatus;
    private Label lblHullStatus;
    private Label lblRepairCost;
    private Label lblSell;
    private Label lblShipsForSale;
    private Label lblSystemName;
    private Label lblSystemNameLabel;
    private Label lblSystemPirates;
    private Label lblSystemPolice;
    private Label lblSystemPolSys;
    private Label lblSystemPressure;
    private Label lblSystemPressurePre;
    private Label lblSystemResource;
    private Label lblSystemSize;
    private Label lblSystemTech;
    private Label lblTargetDistance;
    private Label lblTargetName;
    private Label lblTargetOutOfRange;
    private Label lblTargetPirates;
    private Label lblTargetPolice;
    private Label lblTargetPolSys;
    private Label lblTargetResource;
    private Label lblTargetSize;
    private Label lblTargetTech;
    private Label lblWormhole;
    private Label lblWormholeLabel;
    private MenuItem mnuGameSave;
    private MenuItem mnuGameSaveAs;
    private MenuItem mnuRetire;
    private MenuItem mnuViewBank;
    private MenuItem mnuViewCommander;
    private MenuItem mnuViewPersonnel;
    private MenuItem mnuViewQuests;
    private MenuItem mnuViewShip;
    private OpenFileDialog dlgOpen;
    private PictureBox picGalacticChart;
    private PictureBox picShortRangeChart;
    private SaveFileDialog dlgSave;
    private StatusBarPanel statusBarPanelBays;
    private StatusBarPanel statusBarPanelCash;
    private StatusBarPanel statusBarPanelCosts;
    private StatusBarPanel statusBarPanelExtra;
    private ToolTip tipSpecial;
    private ToolTip tipMerc;
    private Game game = null;
    private Commander cmdr = null;
    private String SaveGameFile = null;
    private int SaveGameDays = -1;

    public Main() {
        IContainer components = new Container();
        ResourceManager resources = new ResourceManager(Main.class);
        MainMenu mnuMain = new MainMenu();
        SubMenu mnuGame = new SubMenu();
        MenuItem mnuGameNew = new MenuItem();
        MenuItem mnuGameLoad = new MenuItem();
        mnuGameSave = new MenuItem();
        mnuGameSaveAs = new MenuItem();
        MenuItem mnuGameLine1 = new MenuItem();
        mnuRetire = new MenuItem();
        MenuItem mnuGameLine2 = new MenuItem();
        MenuItem mnuGameExit = new MenuItem();
        SubMenu mnuView = new SubMenu();
        mnuViewCommander = new MenuItem();
        mnuViewShip = new MenuItem();
        mnuViewPersonnel = new MenuItem();
        mnuViewQuests = new MenuItem();
        mnuViewBank = new MenuItem();
        MenuItem mnuViewLine1 = new MenuItem();
        MenuItem mnuHighScores = new MenuItem();
        MenuItem mnuViewLine2 = new MenuItem();
        MenuItem mnuOptions = new MenuItem();
        SubMenu mnuHelp = new SubMenu();
        MenuItem mnuHelpAbout = new MenuItem();
        picGalacticChart = new PictureBox();
        picShortRangeChart = new PictureBox();
        StatusBar statusBar = new StatusBar();
        statusBarPanelCash = new StatusBarPanel();
        statusBarPanelBays = new StatusBarPanel();
        statusBarPanelCosts = new StatusBarPanel();
        statusBarPanelExtra = new StatusBarPanel(StatusBarPanelAutoSize.Spring);
        GroupBox boxShortRangeChart = new GroupBox();
        GroupBox boxGalacticChart = new GroupBox();
        lblWormhole = new Label();
        lblWormholeLabel = new Label();
        buttonJump = new Button();
        buttonFind = new Button();
        GroupBox boxTargetSystem = new GroupBox();
        buttonTrack = new Button();
        buttonNextSystem = new Button();
        buttonPrevSystem = new Button();
        lblTargetOutOfRange = new Label();
        buttonWarp = new Button();
        lblTargetPolSys = new Label();
        lblTargetSize = new Label();
        lblTargetTech = new Label();
        lblTargetDistance = new Label();
        lblTargetPirates = new Label();
        lblTargetPolice = new Label();
        lblTargetResource = new Label();
        Label lblTargetDistanceLabel = new Label();
        Label lblTargetPiratesLabel = new Label();
        Label lblTargetPoliceLabel = new Label();
        Label lblTargetResourceLabel = new Label();
        Label lblTargetGovtLabel = new Label();
        Label lblTargetTechLabel = new Label();
        Label lblTargetSizeLabel = new Label();
        lblTargetName = new Label();
        Label lblTargetNameLabel = new Label();
        GroupBox boxCargo = new GroupBox();
        PictureBox picCargoLine3 = new PictureBox();
        PictureBox picCargoLine2 = new PictureBox();
        PictureBox picCargoLine0 = new PictureBox();
        PictureBox picCargoLine1 = new PictureBox();
        Label lblTargetPct9 = new Label();
        Label lblTargetDiff9 = new Label();
        Label lblTargetPrice9 = new Label();
        Button buttonBuyMax9 = new Button();
        Button buttonBuyQty9 = new Button();
        Label lblBuyPrice9 = new Label();
        Button buttonSellAll9 = new Button();
        Button buttonSellQty9 = new Button();
        Label lblSellPrice9 = new Label();
        Label lblTargetPct8 = new Label();
        Label lblTargetDiff8 = new Label();
        Label lblTargetPrice8 = new Label();
        Button buttonBuyMax8 = new Button();
        Button buttonBuyQty8 = new Button();
        Label lblBuyPrice8 = new Label();
        Button buttonSellAll8 = new Button();
        Button buttonSellQty8 = new Button();
        Label lblSellPrice8 = new Label();
        Label lblTargetPct7 = new Label();
        Label lblTargetDiff7 = new Label();
        Label lblTargetPrice7 = new Label();
        Button buttonBuyMax7 = new Button();
        Button buttonBuyQty7 = new Button();
        Label lblBuyPrice7 = new Label();
        Button buttonSellAll7 = new Button();
        Button buttonSellQty7 = new Button();
        Label lblSellPrice7 = new Label();
        Label lblTargetPct6 = new Label();
        Label lblTargetDiff6 = new Label();
        Label lblTargetPrice6 = new Label();
        Button buttonBuyMax6 = new Button();
        Button buttonBuyQty6 = new Button();
        Label lblBuyPrice6 = new Label();
        Button buttonSellAll6 = new Button();
        Button buttonSellQty6 = new Button();
        Label lblSellPrice6 = new Label();
        Label lblTargetPct5 = new Label();
        Label lblTargetDiff5 = new Label();
        Label lblTargetPrice5 = new Label();
        Button buttonBuyMax5 = new Button();
        Button buttonBuyQty5 = new Button();
        Label lblBuyPrice5 = new Label();
        Button buttonSellAll5 = new Button();
        Button buttonSellQty5 = new Button();
        Label lblSellPrice5 = new Label();
        Label lblTargetPct4 = new Label();
        Label lblTargetDiff4 = new Label();
        Label lblTargetPrice4 = new Label();
        Button buttonBuyMax4 = new Button();
        Button buttonBuyQty4 = new Button();
        Label lblBuyPrice4 = new Label();
        Button buttonSellAll4 = new Button();
        Button buttonSellQty4 = new Button();
        Label lblSellPrice4 = new Label();
        Label lblTargetPct3 = new Label();
        Label lblTargetDiff3 = new Label();
        Label lblTargetPrice3 = new Label();
        Button buttonBuyMax3 = new Button();
        Button buttonBuyQty3 = new Button();
        Label lblBuyPrice3 = new Label();
        Button buttonSellAll3 = new Button();
        Button buttonSellQty3 = new Button();
        Label lblSellPrice3 = new Label();
        Label lblTargetPct2 = new Label();
        Label lblTargetDiff2 = new Label();
        Label lblTargetPrice2 = new Label();
        Button buttonBuyMax2 = new Button();
        Button buttonBuyQty2 = new Button();
        Label lblBuyPrice2 = new Label();
        Button buttonSellAll2 = new Button();
        Button buttonSellQty2 = new Button();
        Label lblSellPrice2 = new Label();
        Label lblTargetPct1 = new Label();
        Label lblTargetDiff1 = new Label();
        Label lblTargetPrice1 = new Label();
        Button buttonBuyMax1 = new Button();
        Button buttonBuyQty1 = new Button();
        Label lblBuyPrice1 = new Label();
        Label lblTargetPctLabel = new Label();
        Label lblTargetDiffLabel = new Label();
        Label lblTargetPriceLabel = new Label();
        Label lblTargetPct0 = new Label();
        Label lblTargetDiff0 = new Label();
        Label lblTargetPrice0 = new Label();
        Button buttonBuyMax0 = new Button();
        Button buttonBuyQty0 = new Button();
        Label lblBuyPrice0 = new Label();
        Button buttonSellAll1 = new Button();
        Button buttonSellQty1 = new Button();
        Label lblSellPrice1 = new Label();
        Button buttonSellAll0 = new Button();
        Button buttonSellQty0 = new Button();
        Label lblSellPrice0 = new Label();
        Label lblTradeTarget = new Label();
        lblBuy = new Label();
        lblSell = new Label();
        Label lblTradeCommodity9 = new Label();
        Label lblTradeCommodity8 = new Label();
        Label lblTradeCommodity2 = new Label();
        Label lblTradeCommodity0 = new Label();
        Label lblTradeCommodity1 = new Label();
        Label lblTradeCommodity6 = new Label();
        Label lblTradeCommodity5 = new Label();
        Label lblTradeCommodity4 = new Label();
        Label lblTradeCommodity3 = new Label();
        Label lblTradeCommodity7 = new Label();
        GroupBox boxSystem = new GroupBox();
        buttonMerc = new Button();
        buttonSpecial = new Button();
        buttonNews = new Button();
        lblSystemPressure = new Label();
        lblSystemPressurePre = new Label();
        lblSystemPolSys = new Label();
        lblSystemSize = new Label();
        lblSystemTech = new Label();
        lblSystemPirates = new Label();
        lblSystemPolice = new Label();
        lblSystemResource = new Label();
        Label lblSystemPiratesLabel = new Label();
        Label lblSystemPoliceLabel = new Label();
        Label lblSystemResourceLabel = new Label();
        Label lblSystemGovtLabel = new Label();
        Label lblSystemTechLabel = new Label();
        Label lblSystemSizeLabel = new Label();
        lblSystemName = new Label();
        lblSystemNameLabel = new Label();
        GroupBox boxShipYard = new GroupBox();
        buttonDesign = new Button();
        buttonPod = new Button();
        lblEscapePod = new Label();
        buttonEquip = new Button();
        buttonBuyShip = new Button();
        lblEquipForSale = new Label();
        lblShipsForSale = new Label();
        GroupBox boxDock = new GroupBox();
        buttonRepair = new Button();
        buttonFuel = new Button();
        lblFuelStatus = new Label();
        lblFuelCost = new Label();
        lblHullStatus = new Label();
        lblRepairCost = new Label();
        PictureBox picLine = new PictureBox();
        dlgOpen = new OpenFileDialog();
        dlgSave = new SaveFileDialog();
        ilChartImages = new ImageList(components);
        ilShipImages = new ImageList(components);
        ilDirectionImages = new ImageList(components);
        tipSpecial = new ToolTip(components);
        tipMerc = new ToolTip(components);
        ilEquipmentImages = new ImageList(components);
        ((ISupportInitialize) (statusBarPanelCash)).BeginInit();
        ((ISupportInitialize) (statusBarPanelBays)).BeginInit();
        ((ISupportInitialize) (statusBarPanelCosts)).BeginInit();
        ((ISupportInitialize) (statusBarPanelExtra)).BeginInit();
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
        mnuGameNew.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                mnuGameNew_Click(sender, e);
            }
        });
        // mnuGameLoad
        mnuGameLoad.Index = 1;
        mnuGameLoad.Shortcut = Shortcut.CtrlL;
        mnuGameLoad.setText("&Load...");
        mnuGameLoad.setClick(new EventHandler<>() {
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
        mnuGameSave.setClick(new EventHandler<>() {
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
        mnuGameSaveAs.setClick(new EventHandler<>() {
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
        mnuRetire.setClick(new EventHandler<>() {
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
        mnuGameExit.setClick(new EventHandler<>() {
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
        mnuViewCommander.setClick(new EventHandler<>() {
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
        mnuViewShip.setClick(new EventHandler<>() {
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
        mnuViewPersonnel.setClick(new EventHandler<>() {
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
        mnuViewQuests.setClick(new EventHandler<>() {
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
        mnuViewBank.setClick(new EventHandler<>() {
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
        mnuHighScores.setClick(new EventHandler<>() {
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
        mnuOptions.setClick(new EventHandler<>() {
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
        mnuHelpAbout.setClick(new EventHandler<>() {
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
        picGalacticChart.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventArgs e) {
                picGalacticChart_Paint(sender, e);
            }
        });
        picGalacticChart.setMouseDown(new EventHandler<>() {
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
        picShortRangeChart.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventArgs e) {
                picShortRangeChart_Paint(sender, e);
            }
        });
        picShortRangeChart.setMouseDown(new EventHandler<>() {
            @Override
            public void handle(Object sender, MouseEventArgs e) {
                picShortRangeChart_MouseDown(sender, e);
            }
        });
        // statusBar
        statusBar.setLocation(new Point(0, 481));
        statusBar.setName("statusBar");
        statusBar.Panels.addAll(Arrays.asList(statusBarPanelCash, statusBarPanelBays, statusBarPanelCosts, statusBarPanelExtra));
        statusBar.ShowPanels = true;
        statusBar.setSize(new FormSize(768, 24));
        statusBar.SizingGrip = false;
        statusBar.setTabIndex(2);
        statusBar.PanelClick = new EventHandler<>() {
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
        boxGalacticChart.Controls.add(buttonJump);
        boxGalacticChart.Controls.add(buttonFind);
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
        // buttonJump
        buttonJump.setFlatStyle(FlatStyle.Flat);
        buttonJump.setLocation(new Point(81, 138));
        buttonJump.setName("buttonJump");
        buttonJump.setSize(new FormSize(42, 22));
        buttonJump.setTabIndex(55);
        buttonJump.setText("Jump");
        buttonJump.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJump_Click(sender, e);
            }
        });
        // buttonFind
        buttonFind.setFlatStyle(FlatStyle.Flat);
        buttonFind.setLocation(new Point(132, 138));
        buttonFind.setName("buttonFind");
        buttonFind.setSize(new FormSize(36, 22));
        buttonFind.setTabIndex(56);
        buttonFind.setText("Find");
        buttonFind.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonFind_Click(sender, e);
            }
        });
        // boxTargetSystem
        boxTargetSystem.Anchor = AnchorStyles.Top_Right;
        boxTargetSystem.Controls.add(buttonTrack);
        boxTargetSystem.Controls.add(buttonNextSystem);
        boxTargetSystem.Controls.add(buttonPrevSystem);
        boxTargetSystem.Controls.add(lblTargetOutOfRange);
        boxTargetSystem.Controls.add(buttonWarp);
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
        // buttonTrack
        buttonTrack.setFlatStyle(FlatStyle.Flat);
        buttonTrack.setLocation(new Point(160, 140));
        buttonTrack.setName("buttonTrack");
        buttonTrack.setSize(new FormSize(44, 22));
        buttonTrack.setTabIndex(60);
        buttonTrack.setText("Track");
        buttonTrack.setVisible(false);
        buttonTrack.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonTrack_Click(sender, e);
            }
        });
        // buttonNextSystem
        buttonNextSystem.setFlatStyle(FlatStyle.Flat);
        buttonNextSystem.setLocation(new Point(186, 16));
        buttonNextSystem.setName("buttonNextSystem");
        buttonNextSystem.setSize(new FormSize(18, 18));
        buttonNextSystem.setTabIndex(58);
        buttonNextSystem.setText(">");
        buttonNextSystem.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonNextSystem_Click(sender, e);
            }
        });
        // buttonPrevSystem
        buttonPrevSystem.setFlatStyle(FlatStyle.Flat);
        buttonPrevSystem.setLocation(new Point(160, 16));
        buttonPrevSystem.setName("buttonPrevSystem");
        buttonPrevSystem.setSize(new FormSize(18, 18));
        buttonPrevSystem.setTabIndex(57);
        buttonPrevSystem.setText("<");
        buttonPrevSystem.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPrevSystem_Click(sender, e);
            }
        });
        // lblTargetOutOfRange
        lblTargetOutOfRange.setLocation(new Point(8, 144));
        lblTargetOutOfRange.setName("lblTargetOutOfRange");
        lblTargetOutOfRange.setSize(new FormSize(144, 13));
        lblTargetOutOfRange.setTabIndex(17);
        lblTargetOutOfRange.setText("This system is out of range.");
        // buttonWarp
        buttonWarp.setFlatStyle(FlatStyle.Flat);
        buttonWarp.setLocation(new Point(160, 98));
        buttonWarp.setName("buttonWarp");
        buttonWarp.setSize(new FormSize(44, 44));
        buttonWarp.setTabIndex(59);
        buttonWarp.setText("Warp");
        buttonWarp.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonWarp_Click(sender, e);
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
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTargetDistanceLabel.setLocation(new Point(8, 128));
        lblTargetDistanceLabel.setName("lblTargetDistanceLabel");
        lblTargetDistanceLabel.setSize(new FormSize(53, 16));
        lblTargetDistanceLabel.setTabIndex(8);
        lblTargetDistanceLabel.setText("Distance:");
        // lblTargetPiratesLabel
        lblTargetPiratesLabel.setAutoSize(true);
        lblTargetPiratesLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTargetPiratesLabel.setLocation(new Point(8, 112));
        lblTargetPiratesLabel.setName("lblTargetPiratesLabel");
        lblTargetPiratesLabel.setSize(new FormSize(44, 16));
        lblTargetPiratesLabel.setTabIndex(7);
        lblTargetPiratesLabel.setText("Pirates:");
        // lblTargetPoliceLabel
        lblTargetPoliceLabel.setAutoSize(true);
        lblTargetPoliceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTargetPoliceLabel.setLocation(new Point(8, 96));
        lblTargetPoliceLabel.setName("lblTargetPoliceLabel");
        lblTargetPoliceLabel.setSize(new FormSize(40, 16));
        lblTargetPoliceLabel.setTabIndex(6);
        lblTargetPoliceLabel.setText("Police:");
        // lblTargetResourceLabel
        lblTargetResourceLabel.setAutoSize(true);
        lblTargetResourceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTargetResourceLabel.setLocation(new Point(8, 80));
        lblTargetResourceLabel.setName("lblTargetResourceLabel");
        lblTargetResourceLabel.setSize(new FormSize(58, 16));
        lblTargetResourceLabel.setTabIndex(5);
        lblTargetResourceLabel.setText("Resource:");
        // lblTargetGovtLabel
        lblTargetGovtLabel.setAutoSize(true);
        lblTargetGovtLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTargetGovtLabel.setLocation(new Point(8, 64));
        lblTargetGovtLabel.setName("lblTargetGovtLabel");
        lblTargetGovtLabel.setSize(new FormSize(72, 16));
        lblTargetGovtLabel.setTabIndex(4);
        lblTargetGovtLabel.setText("Government:");
        // lblTargetTechLabel
        lblTargetTechLabel.setAutoSize(true);
        lblTargetTechLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTargetTechLabel.setLocation(new Point(8, 48));
        lblTargetTechLabel.setName("lblTargetTechLabel");
        lblTargetTechLabel.setSize(new FormSize(65, 16));
        lblTargetTechLabel.setTabIndex(3);
        lblTargetTechLabel.setText("Tech Level:");
        // lblTargetSizeLabel
        lblTargetSizeLabel.setAutoSize(true);
        lblTargetSizeLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
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
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
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
        boxCargo.Controls.add(buttonBuyMax9);
        boxCargo.Controls.add(buttonBuyQty9);
        boxCargo.Controls.add(lblBuyPrice9);
        boxCargo.Controls.add(buttonSellAll9);
        boxCargo.Controls.add(buttonSellQty9);
        boxCargo.Controls.add(lblSellPrice9);
        boxCargo.Controls.add(lblTargetPct8);
        boxCargo.Controls.add(lblTargetDiff8);
        boxCargo.Controls.add(lblTargetPrice8);
        boxCargo.Controls.add(buttonBuyMax8);
        boxCargo.Controls.add(buttonBuyQty8);
        boxCargo.Controls.add(lblBuyPrice8);
        boxCargo.Controls.add(buttonSellAll8);
        boxCargo.Controls.add(buttonSellQty8);
        boxCargo.Controls.add(lblSellPrice8);
        boxCargo.Controls.add(lblTargetPct7);
        boxCargo.Controls.add(lblTargetDiff7);
        boxCargo.Controls.add(lblTargetPrice7);
        boxCargo.Controls.add(buttonBuyMax7);
        boxCargo.Controls.add(buttonBuyQty7);
        boxCargo.Controls.add(lblBuyPrice7);
        boxCargo.Controls.add(buttonSellAll7);
        boxCargo.Controls.add(buttonSellQty7);
        boxCargo.Controls.add(lblSellPrice7);
        boxCargo.Controls.add(lblTargetPct6);
        boxCargo.Controls.add(lblTargetDiff6);
        boxCargo.Controls.add(lblTargetPrice6);
        boxCargo.Controls.add(buttonBuyMax6);
        boxCargo.Controls.add(buttonBuyQty6);
        boxCargo.Controls.add(lblBuyPrice6);
        boxCargo.Controls.add(buttonSellAll6);
        boxCargo.Controls.add(buttonSellQty6);
        boxCargo.Controls.add(lblSellPrice6);
        boxCargo.Controls.add(lblTargetPct5);
        boxCargo.Controls.add(lblTargetDiff5);
        boxCargo.Controls.add(lblTargetPrice5);
        boxCargo.Controls.add(buttonBuyMax5);
        boxCargo.Controls.add(buttonBuyQty5);
        boxCargo.Controls.add(lblBuyPrice5);
        boxCargo.Controls.add(buttonSellAll5);
        boxCargo.Controls.add(buttonSellQty5);
        boxCargo.Controls.add(lblSellPrice5);
        boxCargo.Controls.add(lblTargetPct4);
        boxCargo.Controls.add(lblTargetDiff4);
        boxCargo.Controls.add(lblTargetPrice4);
        boxCargo.Controls.add(buttonBuyMax4);
        boxCargo.Controls.add(buttonBuyQty4);
        boxCargo.Controls.add(lblBuyPrice4);
        boxCargo.Controls.add(buttonSellAll4);
        boxCargo.Controls.add(buttonSellQty4);
        boxCargo.Controls.add(lblSellPrice4);
        boxCargo.Controls.add(lblTargetPct3);
        boxCargo.Controls.add(lblTargetDiff3);
        boxCargo.Controls.add(lblTargetPrice3);
        boxCargo.Controls.add(buttonBuyMax3);
        boxCargo.Controls.add(buttonBuyQty3);
        boxCargo.Controls.add(lblBuyPrice3);
        boxCargo.Controls.add(buttonSellAll3);
        boxCargo.Controls.add(buttonSellQty3);
        boxCargo.Controls.add(lblSellPrice3);
        boxCargo.Controls.add(lblTargetPct2);
        boxCargo.Controls.add(lblTargetDiff2);
        boxCargo.Controls.add(lblTargetPrice2);
        boxCargo.Controls.add(buttonBuyMax2);
        boxCargo.Controls.add(buttonBuyQty2);
        boxCargo.Controls.add(lblBuyPrice2);
        boxCargo.Controls.add(buttonSellAll2);
        boxCargo.Controls.add(buttonSellQty2);
        boxCargo.Controls.add(lblSellPrice2);
        boxCargo.Controls.add(lblTargetPct1);
        boxCargo.Controls.add(lblTargetDiff1);
        boxCargo.Controls.add(lblTargetPrice1);
        boxCargo.Controls.add(buttonBuyMax1);
        boxCargo.Controls.add(buttonBuyQty1);
        boxCargo.Controls.add(lblBuyPrice1);
        boxCargo.Controls.add(lblTargetPctLabel);
        boxCargo.Controls.add(lblTargetDiffLabel);
        boxCargo.Controls.add(lblTargetPriceLabel);
        boxCargo.Controls.add(lblTargetPct0);
        boxCargo.Controls.add(lblTargetDiff0);
        boxCargo.Controls.add(lblTargetPrice0);
        boxCargo.Controls.add(buttonBuyMax0);
        boxCargo.Controls.add(buttonBuyQty0);
        boxCargo.Controls.add(lblBuyPrice0);
        boxCargo.Controls.add(buttonSellAll1);
        boxCargo.Controls.add(buttonSellQty1);
        boxCargo.Controls.add(lblSellPrice1);
        boxCargo.Controls.add(buttonSellAll0);
        boxCargo.Controls.add(buttonSellQty0);
        boxCargo.Controls.add(lblSellPrice0);
        boxCargo.Controls.add(lblTradeTarget);
        boxCargo.Controls.add(lblBuy);
        boxCargo.Controls.add(lblSell);
        boxCargo.Controls.add(lblTradeCommodity9);
        boxCargo.Controls.add(lblTradeCommodity8);
        boxCargo.Controls.add(lblTradeCommodity2);
        boxCargo.Controls.add(lblTradeCommodity0);
        boxCargo.Controls.add(lblTradeCommodity1);
        boxCargo.Controls.add(lblTradeCommodity6);
        boxCargo.Controls.add(lblTradeCommodity5);
        boxCargo.Controls.add(lblTradeCommodity4);
        boxCargo.Controls.add(lblTradeCommodity3);
        boxCargo.Controls.add(lblTradeCommodity7);
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
        // buttonBuyMax9
        buttonBuyMax9.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax9.setLocation(new Point(262, 272));
        buttonBuyMax9.setName("buttonBuyMax9");
        buttonBuyMax9.setSize(new FormSize(36, 22));
        buttonBuyMax9.setTabIndex(51);
        buttonBuyMax9.setText("Max");
        buttonBuyMax9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty9
        buttonBuyQty9.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty9.setLocation(new Point(227, 272));
        buttonBuyQty9.setName("buttonBuyQty9");
        buttonBuyQty9.setSize(new FormSize(28, 22));
        buttonBuyQty9.setTabIndex(50);
        buttonBuyQty9.setText("88");
        buttonBuyQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice9
        lblBuyPrice9.setLocation(new Point(302, 276));
        lblBuyPrice9.setName("lblBuyPrice9");
        lblBuyPrice9.setSize(new FormSize(48, 13));
        lblBuyPrice9.setTabIndex(122);
        lblBuyPrice9.setText("not sold");
        lblBuyPrice9.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll9
        buttonSellAll9.setFlatStyle(FlatStyle.Flat);
        buttonSellAll9.setLocation(new Point(115, 272));
        buttonSellAll9.setName("buttonSellAll9");
        buttonSellAll9.setSize(new FormSize(44, 22));
        buttonSellAll9.setTabIndex(49);
        buttonSellAll9.setText("Dump");
        buttonSellAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty9
        buttonSellQty9.setFlatStyle(FlatStyle.Flat);
        buttonSellQty9.setLocation(new Point(80, 272));
        buttonSellQty9.setName("buttonSellQty9");
        buttonSellQty9.setSize(new FormSize(28, 22));
        buttonSellQty9.setTabIndex(48);
        buttonSellQty9.setText("88");
        buttonSellQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax8
        buttonBuyMax8.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax8.setLocation(new Point(262, 248));
        buttonBuyMax8.setName("buttonBuyMax8");
        buttonBuyMax8.setSize(new FormSize(36, 22));
        buttonBuyMax8.setTabIndex(47);
        buttonBuyMax8.setText("Max");
        buttonBuyMax8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty8
        buttonBuyQty8.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty8.setLocation(new Point(227, 248));
        buttonBuyQty8.setName("buttonBuyQty8");
        buttonBuyQty8.setSize(new FormSize(28, 22));
        buttonBuyQty8.setTabIndex(46);
        buttonBuyQty8.setText("88");
        buttonBuyQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice8
        lblBuyPrice8.setLocation(new Point(302, 252));
        lblBuyPrice8.setName("lblBuyPrice8");
        lblBuyPrice8.setSize(new FormSize(48, 13));
        lblBuyPrice8.setTabIndex(113);
        lblBuyPrice8.setText("8,888 cr.");
        lblBuyPrice8.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll8
        buttonSellAll8.setFlatStyle(FlatStyle.Flat);
        buttonSellAll8.setLocation(new Point(115, 248));
        buttonSellAll8.setName("buttonSellAll8");
        buttonSellAll8.setSize(new FormSize(44, 22));
        buttonSellAll8.setTabIndex(45);
        buttonSellAll8.setText("All");
        buttonSellAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty8
        buttonSellQty8.setFlatStyle(FlatStyle.Flat);
        buttonSellQty8.setLocation(new Point(80, 248));
        buttonSellQty8.setName("buttonSellQty8");
        buttonSellQty8.setSize(new FormSize(28, 22));
        buttonSellQty8.setTabIndex(44);
        buttonSellQty8.setText("88");
        buttonSellQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Regular, GraphicsUnit.Point, ((byte) (0))));
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
        // buttonBuyMax7
        buttonBuyMax7.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax7.setLocation(new Point(262, 224));
        buttonBuyMax7.setName("buttonBuyMax7");
        buttonBuyMax7.setSize(new FormSize(36, 22));
        buttonBuyMax7.setTabIndex(43);
        buttonBuyMax7.setText("Max");
        buttonBuyMax7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty7
        buttonBuyQty7.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty7.setLocation(new Point(227, 224));
        buttonBuyQty7.setName("buttonBuyQty7");
        buttonBuyQty7.setSize(new FormSize(28, 22));
        buttonBuyQty7.setTabIndex(42);
        buttonBuyQty7.setText("88");
        buttonBuyQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice7
        lblBuyPrice7.setLocation(new Point(302, 228));
        lblBuyPrice7.setName("lblBuyPrice7");
        lblBuyPrice7.setSize(new FormSize(48, 13));
        lblBuyPrice7.setTabIndex(104);
        lblBuyPrice7.setText("8,888 cr.");
        lblBuyPrice7.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll7
        buttonSellAll7.setFlatStyle(FlatStyle.Flat);
        buttonSellAll7.setLocation(new Point(115, 224));
        buttonSellAll7.setName("buttonSellAll7");
        buttonSellAll7.setSize(new FormSize(44, 22));
        buttonSellAll7.setTabIndex(41);
        buttonSellAll7.setText("All");
        buttonSellAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty7
        buttonSellQty7.setFlatStyle(FlatStyle.Flat);
        buttonSellQty7.setLocation(new Point(80, 224));
        buttonSellQty7.setName("buttonSellQty7");
        buttonSellQty7.setSize(new FormSize(28, 22));
        buttonSellQty7.setTabIndex(40);
        buttonSellQty7.setText("88");
        buttonSellQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax6
        buttonBuyMax6.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax6.setLocation(new Point(262, 200));
        buttonBuyMax6.setName("buttonBuyMax6");
        buttonBuyMax6.setSize(new FormSize(36, 22));
        buttonBuyMax6.setTabIndex(39);
        buttonBuyMax6.setText("Max");
        buttonBuyMax6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty6
        buttonBuyQty6.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty6.setLocation(new Point(227, 200));
        buttonBuyQty6.setName("buttonBuyQty6");
        buttonBuyQty6.setSize(new FormSize(28, 22));
        buttonBuyQty6.setTabIndex(38);
        buttonBuyQty6.setText("88");
        buttonBuyQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice6
        lblBuyPrice6.setLocation(new Point(302, 204));
        lblBuyPrice6.setName("lblBuyPrice6");
        lblBuyPrice6.setSize(new FormSize(48, 13));
        lblBuyPrice6.setTabIndex(95);
        lblBuyPrice6.setText("8,888 cr.");
        lblBuyPrice6.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll6
        buttonSellAll6.setFlatStyle(FlatStyle.Flat);
        buttonSellAll6.setLocation(new Point(115, 200));
        buttonSellAll6.setName("buttonSellAll6");
        buttonSellAll6.setSize(new FormSize(44, 22));
        buttonSellAll6.setTabIndex(37);
        buttonSellAll6.setText("All");
        buttonSellAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty6
        buttonSellQty6.setFlatStyle(FlatStyle.Flat);
        buttonSellQty6.setLocation(new Point(80, 200));
        buttonSellQty6.setName("buttonSellQty6");
        buttonSellQty6.setSize(new FormSize(28, 22));
        buttonSellQty6.setTabIndex(36);
        buttonSellQty6.setText("88");
        buttonSellQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax5
        buttonBuyMax5.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax5.setLocation(new Point(262, 176));
        buttonBuyMax5.setName("buttonBuyMax5");
        buttonBuyMax5.setSize(new FormSize(36, 22));
        buttonBuyMax5.setTabIndex(35);
        buttonBuyMax5.setText("Max");
        buttonBuyMax5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty5
        buttonBuyQty5.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty5.setLocation(new Point(227, 176));
        buttonBuyQty5.setName("buttonBuyQty5");
        buttonBuyQty5.setSize(new FormSize(28, 22));
        buttonBuyQty5.setTabIndex(34);
        buttonBuyQty5.setText("88");
        buttonBuyQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice5
        lblBuyPrice5.setLocation(new Point(302, 180));
        lblBuyPrice5.setName("lblBuyPrice5");
        lblBuyPrice5.setSize(new FormSize(48, 13));
        lblBuyPrice5.setTabIndex(86);
        lblBuyPrice5.setText("8,888 cr.");
        lblBuyPrice5.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll5
        buttonSellAll5.setFlatStyle(FlatStyle.Flat);
        buttonSellAll5.setLocation(new Point(115, 176));
        buttonSellAll5.setName("buttonSellAll5");
        buttonSellAll5.setSize(new FormSize(44, 22));
        buttonSellAll5.setTabIndex(33);
        buttonSellAll5.setText("All");
        buttonSellAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty5
        buttonSellQty5.setFlatStyle(FlatStyle.Flat);
        buttonSellQty5.setLocation(new Point(80, 176));
        buttonSellQty5.setName("buttonSellQty5");
        buttonSellQty5.setSize(new FormSize(28, 22));
        buttonSellQty5.setTabIndex(32);
        buttonSellQty5.setText("88");
        buttonSellQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax4
        buttonBuyMax4.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax4.setLocation(new Point(262, 152));
        buttonBuyMax4.setName("buttonBuyMax4");
        buttonBuyMax4.setSize(new FormSize(36, 22));
        buttonBuyMax4.setTabIndex(31);
        buttonBuyMax4.setText("Max");
        buttonBuyMax4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty4
        buttonBuyQty4.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty4.setLocation(new Point(227, 152));
        buttonBuyQty4.setName("buttonBuyQty4");
        buttonBuyQty4.setSize(new FormSize(28, 22));
        buttonBuyQty4.setTabIndex(30);
        buttonBuyQty4.setText("88");
        buttonBuyQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice4
        lblBuyPrice4.setLocation(new Point(302, 156));
        lblBuyPrice4.setName("lblBuyPrice4");
        lblBuyPrice4.setSize(new FormSize(48, 13));
        lblBuyPrice4.setTabIndex(77);
        lblBuyPrice4.setText("8,888 cr.");
        lblBuyPrice4.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll4
        buttonSellAll4.setFlatStyle(FlatStyle.Flat);
        buttonSellAll4.setLocation(new Point(115, 152));
        buttonSellAll4.setName("buttonSellAll4");
        buttonSellAll4.setSize(new FormSize(44, 22));
        buttonSellAll4.setTabIndex(29);
        buttonSellAll4.setText("All");
        buttonSellAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty4
        buttonSellQty4.setFlatStyle(FlatStyle.Flat);
        buttonSellQty4.setLocation(new Point(80, 152));
        buttonSellQty4.setName("buttonSellQty4");
        buttonSellQty4.setSize(new FormSize(28, 22));
        buttonSellQty4.setTabIndex(28);
        buttonSellQty4.setText("88");
        buttonSellQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax3
        buttonBuyMax3.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax3.setLocation(new Point(262, 128));
        buttonBuyMax3.setName("buttonBuyMax3");
        buttonBuyMax3.setSize(new FormSize(36, 22));
        buttonBuyMax3.setTabIndex(27);
        buttonBuyMax3.setText("Max");
        buttonBuyMax3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty3
        buttonBuyQty3.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty3.setLocation(new Point(227, 128));
        buttonBuyQty3.setName("buttonBuyQty3");
        buttonBuyQty3.setSize(new FormSize(28, 22));
        buttonBuyQty3.setTabIndex(26);
        buttonBuyQty3.setText("88");
        buttonBuyQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice3
        lblBuyPrice3.setLocation(new Point(302, 132));
        lblBuyPrice3.setName("lblBuyPrice3");
        lblBuyPrice3.setSize(new FormSize(48, 13));
        lblBuyPrice3.setTabIndex(68);
        lblBuyPrice3.setText("8,888 cr.");
        lblBuyPrice3.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll3
        buttonSellAll3.setFlatStyle(FlatStyle.Flat);
        buttonSellAll3.setLocation(new Point(115, 128));
        buttonSellAll3.setName("buttonSellAll3");
        buttonSellAll3.setSize(new FormSize(44, 22));
        buttonSellAll3.setTabIndex(25);
        buttonSellAll3.setText("All");
        buttonSellAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty3
        buttonSellQty3.setFlatStyle(FlatStyle.Flat);
        buttonSellQty3.setLocation(new Point(80, 128));
        buttonSellQty3.setName("buttonSellQty3");
        buttonSellQty3.setSize(new FormSize(28, 22));
        buttonSellQty3.setTabIndex(24);
        buttonSellQty3.setText("88");
        buttonSellQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax2
        buttonBuyMax2.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax2.setLocation(new Point(262, 104));
        buttonBuyMax2.setName("buttonBuyMax2");
        buttonBuyMax2.setSize(new FormSize(36, 22));
        buttonBuyMax2.setTabIndex(23);
        buttonBuyMax2.setText("Max");
        buttonBuyMax2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty2
        buttonBuyQty2.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty2.setLocation(new Point(227, 104));
        buttonBuyQty2.setName("buttonBuyQty2");
        buttonBuyQty2.setSize(new FormSize(28, 22));
        buttonBuyQty2.setTabIndex(22);
        buttonBuyQty2.setText("88");
        buttonBuyQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice2
        lblBuyPrice2.setLocation(new Point(302, 108));
        lblBuyPrice2.setName("lblBuyPrice2");
        lblBuyPrice2.setSize(new FormSize(48, 13));
        lblBuyPrice2.setTabIndex(59);
        lblBuyPrice2.setText("8,888 cr.");
        lblBuyPrice2.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll2
        buttonSellAll2.setFlatStyle(FlatStyle.Flat);
        buttonSellAll2.setLocation(new Point(115, 104));
        buttonSellAll2.setName("buttonSellAll2");
        buttonSellAll2.setSize(new FormSize(44, 22));
        buttonSellAll2.setTabIndex(21);
        buttonSellAll2.setText("All");
        buttonSellAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty2
        buttonSellQty2.setFlatStyle(FlatStyle.Flat);
        buttonSellQty2.setLocation(new Point(80, 104));
        buttonSellQty2.setName("buttonSellQty2");
        buttonSellQty2.setSize(new FormSize(28, 22));
        buttonSellQty2.setTabIndex(20);
        buttonSellQty2.setText("88");
        buttonSellQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax1
        buttonBuyMax1.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax1.setLocation(new Point(262, 80));
        buttonBuyMax1.setName("buttonBuyMax1");
        buttonBuyMax1.setSize(new FormSize(36, 22));
        buttonBuyMax1.setTabIndex(19);
        buttonBuyMax1.setText("Max");
        buttonBuyMax1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty1
        buttonBuyQty1.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty1.setLocation(new Point(227, 80));
        buttonBuyQty1.setName("buttonBuyQty1");
        buttonBuyQty1.setSize(new FormSize(28, 22));
        buttonBuyQty1.setTabIndex(18);
        buttonBuyQty1.setText("88");
        buttonBuyQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
        // buttonBuyMax0
        buttonBuyMax0.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax0.setLocation(new Point(262, 56));
        buttonBuyMax0.setName("buttonBuyMax0");
        buttonBuyMax0.setSize(new FormSize(36, 22));
        buttonBuyMax0.setTabIndex(15);
        buttonBuyMax0.setText("Max");
        buttonBuyMax0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonBuyQty0
        buttonBuyQty0.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty0.setLocation(new Point(227, 56));
        buttonBuyQty0.setName("buttonBuyQty0");
        buttonBuyQty0.setSize(new FormSize(28, 22));
        buttonBuyQty0.setTabIndex(14);
        buttonBuyQty0.setText("88");
        buttonBuyQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblBuyPrice0
        lblBuyPrice0.setLocation(new Point(302, 60));
        lblBuyPrice0.setName("lblBuyPrice0");
        lblBuyPrice0.setSize(new FormSize(48, 13));
        lblBuyPrice0.setTabIndex(41);
        lblBuyPrice0.setText("8,888 cr.");
        lblBuyPrice0.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll1
        buttonSellAll1.setFlatStyle(FlatStyle.Flat);
        buttonSellAll1.setLocation(new Point(115, 80));
        buttonSellAll1.setName("buttonSellAll1");
        buttonSellAll1.setSize(new FormSize(44, 22));
        buttonSellAll1.setTabIndex(17);
        buttonSellAll1.setText("All");
        buttonSellAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty1
        buttonSellQty1.setFlatStyle(FlatStyle.Flat);
        buttonSellQty1.setLocation(new Point(80, 80));
        buttonSellQty1.setName("buttonSellQty1");
        buttonSellQty1.setSize(new FormSize(28, 22));
        buttonSellQty1.setTabIndex(16);
        buttonSellQty1.setText("88");
        buttonSellQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // lblSellPrice1
        lblSellPrice1.setLocation(new Point(163, 84));
        lblSellPrice1.setName("lblSellPrice1");
        lblSellPrice1.setSize(new FormSize(48, 13));
        lblSellPrice1.setTabIndex(38);
        lblSellPrice1.setText("8,888 cr.");
        lblSellPrice1.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll0
        buttonSellAll0.setFlatStyle(FlatStyle.Flat);
        buttonSellAll0.setLocation(new Point(115, 56));
        buttonSellAll0.setName("buttonSellAll0");
        buttonSellAll0.setSize(new FormSize(44, 22));
        buttonSellAll0.setTabIndex(13);
        buttonSellAll0.setText("All");
        buttonSellAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
            }
        });
        // buttonSellQty0
        buttonSellQty0.setFlatStyle(FlatStyle.Flat);
        buttonSellQty0.setLocation(new Point(80, 56));
        buttonSellQty0.setName("buttonSellQty0");
        buttonSellQty0.setSize(new FormSize(28, 22));
        buttonSellQty0.setTabIndex(12);
        buttonSellQty0.setText("88");
        buttonSellQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuySell_Click(sender, e);
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
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Regular, GraphicsUnit.Point, ((byte) (0))));
        lblSell.setLocation(new Point(132, 34));
        lblSell.setName("lblSell");
        lblSell.setSize(new FormSize(23, 16));
        lblSell.setTabIndex(26);
        lblSell.setText("Sell");
        // lblTradeCommodity9
        lblTradeCommodity9.setAutoSize(true);
        lblTradeCommodity9.setLocation(new Point(8, 276));
        lblTradeCommodity9.setName("lblTradeCommodity9");
        lblTradeCommodity9.setSize(new FormSize(40, 16));
        lblTradeCommodity9.setTabIndex(25);
        lblTradeCommodity9.setText("Robots");
        // lblTradeCommodity8
        lblTradeCommodity8.setAutoSize(true);
        lblTradeCommodity8.setLocation(new Point(8, 252));
        lblTradeCommodity8.setName("lblTradeCommodity8");
        lblTradeCommodity8.setSize(new FormSize(51, 16));
        lblTradeCommodity8.setTabIndex(24);
        lblTradeCommodity8.setText("Narcotics");
        // lblTradeCommodity2
        lblTradeCommodity2.setAutoSize(true);
        lblTradeCommodity2.setLocation(new Point(8, 108));
        lblTradeCommodity2.setName("lblTradeCommodity2");
        lblTradeCommodity2.setSize(new FormSize(30, 16));
        lblTradeCommodity2.setTabIndex(23);
        lblTradeCommodity2.setText("Food");
        // lblTradeCommodity0
        lblTradeCommodity0.setAutoSize(true);
        lblTradeCommodity0.setLocation(new Point(8, 60));
        lblTradeCommodity0.setName("lblTradeCommodity0");
        lblTradeCommodity0.setSize(new FormSize(34, 16));
        lblTradeCommodity0.setTabIndex(22);
        lblTradeCommodity0.setText("Water");
        // lblTradeCommodity1
        lblTradeCommodity1.setAutoSize(true);
        lblTradeCommodity1.setLocation(new Point(8, 84));
        lblTradeCommodity1.setName("lblTradeCommodity1");
        lblTradeCommodity1.setSize(new FormSize(27, 16));
        lblTradeCommodity1.setTabIndex(21);
        lblTradeCommodity1.setText("Furs");
        // lblTradeCommodity6
        lblTradeCommodity6.setAutoSize(true);
        lblTradeCommodity6.setLocation(new Point(8, 204));
        lblTradeCommodity6.setName("lblTradeCommodity6");
        lblTradeCommodity6.setSize(new FormSize(50, 16));
        lblTradeCommodity6.setTabIndex(20);
        lblTradeCommodity6.setText("Medicine");
        // lblTradeCommodity5
        lblTradeCommodity5.setAutoSize(true);
        lblTradeCommodity5.setLocation(new Point(8, 180));
        lblTradeCommodity5.setName("lblTradeCommodity5");
        lblTradeCommodity5.setSize(new FormSize(49, 16));
        lblTradeCommodity5.setTabIndex(19);
        lblTradeCommodity5.setText("Firearms");
        // lblTradeCommodity4
        lblTradeCommodity4.setAutoSize(true);
        lblTradeCommodity4.setLocation(new Point(8, 156));
        lblTradeCommodity4.setName("lblTradeCommodity4");
        lblTradeCommodity4.setSize(new FormSize(41, 16));
        lblTradeCommodity4.setTabIndex(18);
        lblTradeCommodity4.setText("Games");
        // lblTradeCommodity3
        lblTradeCommodity3.setAutoSize(true);
        lblTradeCommodity3.setLocation(new Point(8, 132));
        lblTradeCommodity3.setName("lblTradeCommodity3");
        lblTradeCommodity3.setSize(new FormSize(23, 16));
        lblTradeCommodity3.setTabIndex(17);
        lblTradeCommodity3.setText("Ore");
        // lblTradeCommodity7
        lblTradeCommodity7.setAutoSize(true);
        lblTradeCommodity7.setLocation(new Point(8, 228));
        lblTradeCommodity7.setName("lblTradeCommodity7");
        lblTradeCommodity7.setSize(new FormSize(53, 16));
        lblTradeCommodity7.setTabIndex(16);
        lblTradeCommodity7.setText("Machines");
        // boxSystem
        boxSystem.Controls.add(buttonMerc);
        boxSystem.Controls.add(buttonSpecial);
        boxSystem.Controls.add(buttonNews);
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
        boxSystem.Controls.add(lblSystemResourceLabel);
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
        // buttonMerc
        buttonMerc.setFlatStyle(FlatStyle.Flat);
        buttonMerc.setLocation(new Point(118, 174));
        buttonMerc.setName("buttonMerc");
        buttonMerc.setSize(new FormSize(112, 22));
        buttonMerc.setTabIndex(3);
        buttonMerc.setText("Mercenary For Hire");
        buttonMerc.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonMerc_Click(sender, e);
            }
        });
        // buttonSpecial
        buttonSpecial.setBackColor(new Color(255, 255, 128));
        buttonSpecial.setFlatStyle(FlatStyle.Flat);
        buttonSpecial.setLocation(new Point(58, 174));
        buttonSpecial.setName("buttonSpecial");
        buttonSpecial.setSize(new FormSize(52, 22));
        buttonSpecial.setTabIndex(2);
        buttonSpecial.setText("Special");
        buttonSpecial.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonSpecial_Click(sender, e);
            }
        });
        // buttonNews
        buttonNews.setFlatStyle(FlatStyle.Flat);
        buttonNews.setLocation(new Point(8, 174));
        buttonNews.setName("buttonNews");
        buttonNews.setSize(new FormSize(42, 22));
        buttonNews.setTabIndex(1);
        buttonNews.setText("News");
        buttonNews.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonNews_Click(sender, e);
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
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblSystemPiratesLabel.setLocation(new Point(8, 112));
        lblSystemPiratesLabel.setName("lblSystemPiratesLabel");
        lblSystemPiratesLabel.setSize(new FormSize(44, 16));
        lblSystemPiratesLabel.setTabIndex(7);
        lblSystemPiratesLabel.setText("Pirates:");
        // lblSystemPoliceLabel
        lblSystemPoliceLabel.setAutoSize(true);
        lblSystemPoliceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblSystemPoliceLabel.setLocation(new Point(8, 96));
        lblSystemPoliceLabel.setName("lblSystemPoliceLabel");
        lblSystemPoliceLabel.setSize(new FormSize(40, 16));
        lblSystemPoliceLabel.setTabIndex(6);
        lblSystemPoliceLabel.setText("Police:");
        // lblSystemResourceLabel
        lblSystemResourceLabel.setAutoSize(true);
        lblSystemResourceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblSystemResourceLabel.setLocation(new Point(8, 80));
        lblSystemResourceLabel.setName("lblSystemResourceLabel");
        lblSystemResourceLabel.setSize(new FormSize(58, 16));
        lblSystemResourceLabel.setTabIndex(5);
        lblSystemResourceLabel.setText("Resource:");
        // lblSystemGovtLabel
        lblSystemGovtLabel.setAutoSize(true);
        lblSystemGovtLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblSystemGovtLabel.setLocation(new Point(8, 64));
        lblSystemGovtLabel.setName("lblSystemGovtLabel");
        lblSystemGovtLabel.setSize(new FormSize(72, 16));
        lblSystemGovtLabel.setTabIndex(4);
        lblSystemGovtLabel.setText("Government:");
        // lblSystemTechLabel
        lblSystemTechLabel.setAutoSize(true);
        lblSystemTechLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblSystemTechLabel.setLocation(new Point(8, 48));
        lblSystemTechLabel.setName("lblSystemTechLabel");
        lblSystemTechLabel.setSize(new FormSize(65, 16));
        lblSystemTechLabel.setTabIndex(3);
        lblSystemTechLabel.setText("Tech Level:");
        // lblSystemSizeLabel
        lblSystemSizeLabel.setAutoSize(true);
        lblSystemSizeLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
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
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblSystemNameLabel.setLocation(new Point(8, 16));
        lblSystemNameLabel.setName("lblSystemNameLabel");
        lblSystemNameLabel.setSize(new FormSize(39, 16));
        lblSystemNameLabel.setTabIndex(0);
        lblSystemNameLabel.setText("Name:");
        // boxShipYard
        boxShipYard.Controls.add(buttonDesign);
        boxShipYard.Controls.add(buttonPod);
        boxShipYard.Controls.add(lblEscapePod);
        boxShipYard.Controls.add(buttonEquip);
        boxShipYard.Controls.add(buttonBuyShip);
        boxShipYard.Controls.add(lblEquipForSale);
        boxShipYard.Controls.add(lblShipsForSale);
        boxShipYard.setLocation(new Point(4, 306));
        boxShipYard.setName("boxShipYard");
        boxShipYard.setSize(new FormSize(168, 168));
        boxShipYard.setTabIndex(4);
        boxShipYard.setTabStop(false);
        boxShipYard.setText("Shipyard");
        // buttonDesign
        buttonDesign.setFlatStyle(FlatStyle.Flat);
        buttonDesign.setLocation(new Point(8, 32));
        buttonDesign.setName("buttonDesign");
        buttonDesign.setSize(new FormSize(54, 22));
        buttonDesign.setTabIndex(55);
        buttonDesign.setText("Design");
        buttonDesign.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonDesign_Click(sender, e);
            }
        });
        // buttonPod
        buttonPod.setFlatStyle(FlatStyle.Flat);
        buttonPod.setLocation(new Point(98, 138));
        buttonPod.setName("buttonPod");
        buttonPod.setSize(new FormSize(58, 22));
        buttonPod.setTabIndex(54);
        buttonPod.setText("Buy Pod");
        buttonPod.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPod_Click(sender, e);
            }
        });
        // lblEscapePod
        lblEscapePod.setLocation(new Point(8, 122));
        lblEscapePod.setName("lblEscapePod");
        lblEscapePod.setSize(new FormSize(152, 26));
        lblEscapePod.setTabIndex(27);
        lblEscapePod.setText("You can buy an escape pod for  2,000 cr.");
        // buttonEquip
        buttonEquip.setFlatStyle(FlatStyle.Flat);
        buttonEquip.setLocation(new Point(43, 85));
        buttonEquip.setName("buttonEquip");
        buttonEquip.setSize(new FormSize(113, 22));
        buttonEquip.setTabIndex(53);
        buttonEquip.setText("Buy/Sell Equipment");
        buttonEquip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonEquip_Click(sender, e);
            }
        });
        // buttonBuyShip
        buttonBuyShip.setFlatStyle(FlatStyle.Flat);
        buttonBuyShip.setLocation(new Point(70, 32));
        buttonBuyShip.setName("buttonBuyShip");
        buttonBuyShip.setSize(new FormSize(86, 22));
        buttonBuyShip.setTabIndex(52);
        buttonBuyShip.setText("View Ship Info");
        buttonBuyShip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyShip_Click(sender, e);
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
        boxDock.Controls.add(buttonRepair);
        boxDock.Controls.add(buttonFuel);
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
        // buttonRepair
        buttonRepair.setFlatStyle(FlatStyle.Flat);
        buttonRepair.setLocation(new Point(180, 56));
        buttonRepair.setName("buttonRepair");
        buttonRepair.setSize(new FormSize(48, 22));
        buttonRepair.setTabIndex(5);
        buttonRepair.setText("Repair");
        buttonRepair.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonRepair_Click(sender, e);
            }
        });
        // buttonFuel
        buttonFuel.setFlatStyle(FlatStyle.Flat);
        buttonFuel.setLocation(new Point(192, 18));
        buttonFuel.setName("buttonFuel");
        buttonFuel.setSize(new FormSize(36, 22));
        buttonFuel.setTabIndex(4);
        buttonFuel.setText("Fuel");
        buttonFuel.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonFuel_Click(sender, e);
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
        ilChartImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilChartImages.ImageStream"))));
        ilChartImages.setTransparentColor(Color.white);
        // ilShipImages
        ilShipImages.setImageSize(new FormSize(64, 52));
        ilShipImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilShipImages.ImageStream"))));
        ilShipImages.setTransparentColor(Color.white);
        // ilDirectionImages
        ilDirectionImages.setImageSize(new FormSize(13, 13));
        ilDirectionImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilDirectionImages.ImageStream"))));
        ilDirectionImages.setTransparentColor(Color.white);
        // ilEquipmentImages
        ilEquipmentImages.setImageSize(new FormSize(64, 52));
        ilEquipmentImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilEquipmentImages.ImageStream"))));
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
        setFormBorderStyle(FormBorderStyle.FixedSingle);
        setIcon(((Icon) (resources.GetObject("$this.Icon"))));
        setMaximizeBox(false);
        setMenu(mnuMain);
        setName("SpaceTrader");
        setStartPosition(FormStartPosition.Manual);
        setText("Space Trader");
        setClosing(new EventHandler<>() {
            @Override
            public void handle(Object sender, CancelEventArgs e) {
                SpaceTrader_Closing(sender, e);
            }
        });
        setLoad(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                SpaceTrader_Load(sender, e);
            }
        });
        ((ISupportInitialize) (statusBarPanelCash)).EndInit();
        ((ISupportInitialize) (statusBarPanelBays)).EndInit();
        ((ISupportInitialize) (statusBarPanelCosts)).EndInit();
        ((ISupportInitialize) (statusBarPanelExtra)).EndInit();
        boxShortRangeChart.ResumeLayout(false);
        boxGalacticChart.ResumeLayout(false);
        boxTargetSystem.ResumeLayout(false);
        boxCargo.ResumeLayout(false);
        boxSystem.ResumeLayout(false);
        boxShipYard.ResumeLayout(false);
        boxDock.ResumeLayout(false);
        ResumeLayout(false);
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
        buttonSellQty = new Button[]{
                buttonSellQty0, buttonSellQty1, buttonSellQty2, buttonSellQty3, buttonSellQty4,
                buttonSellQty5, buttonSellQty6, buttonSellQty7, buttonSellQty8, buttonSellQty9
        };
        buttonSellAll = new Button[]{
                buttonSellAll0, buttonSellAll1, buttonSellAll2, buttonSellAll3, buttonSellAll4,
                buttonSellAll5, buttonSellAll6, buttonSellAll7, buttonSellAll8, buttonSellAll9
        };
        buttonBuyQty = new Button[]{
                buttonBuyQty0, buttonBuyQty1, buttonBuyQty2, buttonBuyQty3, buttonBuyQty4,
                buttonBuyQty5, buttonBuyQty6, buttonBuyQty7, buttonBuyQty8, buttonBuyQty9
        };
        buttonBuyMax = new Button[]{
                buttonBuyMax0, buttonBuyMax1, buttonBuyMax2, buttonBuyMax3, buttonBuyMax4,
                buttonBuyMax5, buttonBuyMax6, buttonBuyMax7, buttonBuyMax8, buttonBuyMax9
        };
        Main.this.UpdateAll();
    }

    /**
     * Main entry point for the game.
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Main mainWindow = new Main();
        mainWindow.ShowWindow();
    }

    public static void runForm(wfForm wf) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.updateComponentTreeUI(wf.asSwingObject());
        DialogResult res = wf.ShowDialog(null);
        System.out.println("Dialog result: " + res);
    }

    private void AddHighScore(HighScoreRecord highScore) {
        HighScoreRecord[] highScores = Functions.GetHighScores(this);
        highScores[0] = highScore;
        Arrays.sort(highScores);
        Functions.SaveFile(Constants.HighScoreFile, SerializableObject.ArrayToArrayList(highScores), this);
    }

    private void CargoBuy(int tradeItem, boolean max) {
        game.CargoBuySystem(tradeItem, max, this);
        UpdateAll();
    }

    private void CargoSell(int tradeItem, boolean all) {
        if (game.PriceCargoSell()[tradeItem] > 0) {
            game.CargoSellSystem(tradeItem, all, this);
        } else {
            game.CargoDump(tradeItem, this);
        }
        UpdateAll();
    }

    private void ClearHighScores() {
        HighScoreRecord[] highScores = new HighScoreRecord[3];
        Functions.SaveFile(Constants.HighScoreFile, SerializableObject.ArrayToArrayList(highScores), this);
    }

    private void GameEnd() {
        SetInGameControlsEnabled(false);
        AlertType alertType = AlertType.Alert;
        switch (game.getEndStatus()) {
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
        if (candidate.CompareTo(Functions.GetHighScores(this)[0]) > 0) {
            if (game.getCheatEnabled()) {
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
            if (ObjectValue != null) {
                settingValue = ObjectValue.toString();
            }
            key.Close();
        } catch (NullPointerException ex) {
            FormAlert.Alert(AlertType.RegistryError, this, ex.getMessage());
        }
        return settingValue;
    }

    // Make sure all directories exists.
    private void InitFileStructure() {
        String[] paths = new String[]{
                Constants.CustomDirectory,
                Constants.CustomImagesDirectory,
                Constants.CustomTemplatesDirectory,
                Constants.DataDirectory,
                Constants.SaveDirectory
        };
        for (String path : paths) {
            if (!Directory.Exists(path)) {
                Directory.CreateDirectory(path);
            }
        }
        dlgOpen.setInitialDirectory(Constants.SaveDirectory);
        dlgSave.setInitialDirectory(Constants.SaveDirectory);
    }

    private void LoadGame(String fileName) {
        try {
            Object obj = Functions.LoadFile(fileName, false, this);
            if (obj != null) {
                game = new Game((Hashtable) obj, this);
                cmdr = game.Commander();
                SaveGameFile = fileName;
                SaveGameDays = cmdr.getDays();
                SetInGameControlsEnabled(true);
                UpdateAll();
            }
        } catch (FutureVersionException ex) {
            FormAlert.Alert(AlertType.FileErrorOpen, this, fileName, Strings.FileFutureVersion);
        }
    }

    private void SaveGame(String fileName, boolean saveFileName) {
        if (Functions.SaveFile(fileName, game.Serialize(), this) && saveFileName) {
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
        } catch (NullPointerException ex) {
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
        if (game == null || cmdr.CurrentSystem() == null) {
            for (int i = 0; i < lblSellPrice.length; i++) {
                lblSellPrice[i].setText("");
                lblBuyPrice[i].setText("");
                lblTargetPrice[i].setText("");
                lblTargetDiff[i].setText("");
                lblTargetPct[i].setText("");
                buttonSellQty[i].setVisible(false);
                buttonSellAll[i].setVisible(false);
                buttonBuyQty[i].setVisible(false);
                buttonBuyMax[i].setVisible(false);
            }
        } else {
            int[] buy = game.PriceCargoBuy();
            int[] sell = game.PriceCargoSell();
            cmdr = game.Commander();//todo: is this unnecessary? GAC
            StarSystem warpSys = game.WarpSystem();
            for (int i = 0; i < lblSellPrice.length; i++) {
                int price = warpSys == null ? 0 : Constants.TradeItems[i].StandardPrice(warpSys);
                lblSellPrice[i].setText(sell[i] > 0 ? Functions.FormatMoney(sell[i]) : "no trade");
                buttonSellQty[i].setText("" + cmdr.getShip().Cargo()[i]);
                buttonSellQty[i].setVisible(true);
                buttonSellAll[i].setText(sell[i] > 0 ? "All" : "Dump");
                buttonSellAll[i].setVisible(true);
                lblBuyPrice[i].setText(buy[i] > 0 ? Functions.FormatMoney(buy[i]) : "not sold");
                buttonBuyQty[i].setText("" + cmdr.CurrentSystem().TradeItems()[i]);
                buttonBuyQty[i].setVisible(buy[i] > 0);
                buttonBuyMax[i].setVisible(buy[i] > 0);
                if (sell[i] * cmdr.getShip().Cargo()[i] > cmdr.PriceCargo()[i]) {
                    lblSellPrice[i].setFont(lblSystemNameLabel.getFont());
                } else {
                    lblSellPrice[i].setFont(lblSell.getFont());
                }
                if (warpSys != null && warpSys.DestOk() && price > 0) {
                    lblTargetPrice[i].setText(Functions.FormatMoney(price));
                } else {
                    lblTargetPrice[i].setText("-----------");
                }
                if (warpSys != null && warpSys.DestOk() && price > 0 && buy[i] > 0) {
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
        if (game == null) {
            lblWormholeLabel.setVisible(false);
            lblWormhole.setVisible(false);
            buttonJump.setVisible(false);
            buttonFind.setVisible(false);
        } else {
            if (game.TargetWormhole()) {
                lblWormholeLabel.setVisible(true);
                lblWormhole.setVisible(true);
                lblWormhole.setText(game.WarpSystem().Name());
            } else {
                lblWormholeLabel.setVisible(false);
                lblWormhole.setVisible(false);
            }
            buttonJump.setVisible(game.getCanSuperWarp());
            buttonFind.setVisible(true);
        }
    }

    private void UpdateDock() {
        if (game == null) {
            lblFuelStatus.setText("");
            lblFuelCost.setText("");
            buttonFuel.setVisible(false);
            lblHullStatus.setText("");
            lblRepairCost.setText("");
            buttonRepair.setVisible(false);
        } else {
            Ship ship = cmdr.getShip();
            lblFuelStatus.setText(
                    Functions.StringVars("You have fuel to fly ^1.", Functions.Multiples(ship.getFuel(), "parsec")));
            int tanksEmpty = ship.FuelTanks() - ship.getFuel();
            lblFuelCost.setText(tanksEmpty > 0
                    ? Functions.StringVars("A full tank costs ^1", Functions.FormatMoney(tanksEmpty * ship.getFuelCost()))
                    : "Your tank is full.");
            buttonFuel.setVisible(tanksEmpty > 0);
            lblHullStatus.setText(
                    Functions.StringVars("Your hull strength is at ^1%.",
                            Functions.FormatNumber((int) Math.floor((double) 100 * ship.getHull() / ship.HullStrength()))));
            int hullLoss = ship.HullStrength() - ship.getHull();
            lblRepairCost.setText(hullLoss > 0
                    ? Functions.StringVars("Full repairs will cost ^1", Functions.FormatMoney(hullLoss * ship.getRepairCost()))
                    : "No repairs are needed.");
            buttonRepair.setVisible(hullLoss > 0);
        }
    }

    private void UpdateShipyard() {
        if (game == null) {
            lblShipsForSale.setText("");
            lblEquipForSale.setText("");
            lblEscapePod.setText("");
            buttonPod.setVisible(false);
            buttonBuyShip.setVisible(false);
            buttonDesign.setVisible(false);
            buttonEquip.setVisible(false);
        } else {
            boolean noTech =
                    cmdr.CurrentSystem().TechLevel().ordinal()
                            < Constants.ShipSpecs[ShipType.Flea.CastToInt()].MinimumTechLevel().ordinal();
            lblShipsForSale.setText(noTech ? Strings.ShipyardShipNoSale : Strings.ShipyardShipForSale);
            buttonBuyShip.setVisible(true);
            buttonDesign.setVisible((cmdr.CurrentSystem().Shipyard() != null));
            lblEquipForSale.setText(noTech ? Strings.ShipyardEquipNoSale : Strings.ShipyardEquipForSale);
            buttonEquip.setVisible(true);
            buttonPod.setVisible(false);
            if (cmdr.getShip().getEscapePod()) {
                lblEscapePod.setText(Strings.ShipyardPodInstalled);
            } else if (noTech) {
                lblEscapePod.setText(Strings.ShipyardPodNoSale);
            } else if (cmdr.getCash() < 2000) {
                lblEscapePod.setText(Strings.ShipyardPodIF);
            } else {
                lblEscapePod.setText(Strings.ShipyardPodCost);
                buttonPod.setVisible(true);
            }
        }
    }

    public void UpdateStatusBar() {
        if (game == null) {
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
        if (game == null || cmdr.CurrentSystem() == null) {
            lblSystemName.setText("");
            lblSystemSize.setText("");
            lblSystemTech.setText("");
            lblSystemPolSys.setText("");
            lblSystemResource.setText("");
            lblSystemPolice.setText("");
            lblSystemPirates.setText("");
            lblSystemPressure.setText("");
            lblSystemPressurePre.setVisible(false);
            buttonNews.setVisible(false);
            buttonMerc.setVisible(false);
            buttonSpecial.setVisible(false);
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
            buttonNews.setVisible(true);
            buttonMerc.setVisible(mercs.length > 0);
            if (buttonMerc.getVisible()) {
                tipMerc.SetToolTip(buttonMerc, Functions.StringVars(
                        Strings.MercenariesForHire,
                        mercs.length == 1 ? mercs[0].Name() : mercs.length + Strings.Mercenaries));
            }
            buttonSpecial.setVisible(system.ShowSpecialButton());
            if (buttonSpecial.getVisible()) {
                tipSpecial.SetToolTip(buttonSpecial, system.SpecialEvent().Title());
            }
        }
    }

    private void UpdateTargetSystemInfo() {
        buttonNextSystem.setVisible(game != null);
        buttonPrevSystem.setVisible(game != null);
        if (game == null || game.WarpSystem() == null) {
            lblTargetName.setText("");
            lblTargetSize.setText("");
            lblTargetTech.setText("");
            lblTargetPolSys.setText("");
            lblTargetResource.setText("");
            lblTargetPolice.setText("");
            lblTargetPirates.setText("");
            lblTargetDistance.setText("");
            lblTargetOutOfRange.setVisible(false);
            buttonWarp.setVisible(false);
            buttonTrack.setVisible(false);
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
            buttonWarp.setVisible(system.DestOk());
            buttonTrack.setVisible(lblTargetOutOfRange.getVisible() && system != game.TrackedSystem());
        }
    }

    private void SpaceTrader_Closing(Object sender, CancelEventArgs e) {
        if (game == null || cmdr.getDays() == SaveGameDays
                || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes) {
            if (WindowState == FormWindowState.Normal) {
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

    private void buttonBuySell_Click(Object sender, EventArgs e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Qty");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        if (!name.contains("Buy")) {
            CargoSell(index, all);
        } else {
            CargoBuy(index, all);
        }
    }

    private void buttonBuyShip_Click(Object sender, EventArgs e) {
        (new FormShipList()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonDesign_Click(Object sender, EventArgs e) {
        (new FormShipyard()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonEquip_Click(Object sender, EventArgs e) {
        (new FormEquipment()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonFind_Click(Object sender, EventArgs e) {
        FormFind form = new FormFind();
        if (form.ShowDialog(this) == DialogResult.OK) {
            Ship ship = cmdr.getShip();
            String[] words = form.SystemName().split(" ");
            String first = words.length > 0 ? words[0] : "";
            String second = words.length > 1 ? words[1] : "";
            String third = words.length > 2 ? words[2] : "";
            int num1 = Functions.IsInt(second) ? Integer.parseInt(second) : 0;
            int num2 = Functions.IsInt(third) ? Integer.parseInt(third) : 0;
            boolean find = false;
            if (game.getCheatEnabled()) {
                switch (SomeStringsForSwitch.find(first)) {
                    case Bazaar:
                        game.setChanceOfTradeInOrbit(Math.max(0, Math.min(1000, num1)));
                        break;
                    case Cover:
                        if (num1 >= 0 && num1 < ship.Shields().length && num2 >= 0 && num2 < Constants.Shields.length) {
                            ship.Shields()[num1] = (Shield) Constants.Shields[num2].Clone();
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
                        if (second.equals("Reset")) {
                            game.ResetVeryRareEncounters();
                        } else {
                            String text = "";
                            for (VeryRareEncounter veryRareEncounter : game.VeryRareEncounters()) {
                                text += Strings.VeryRareEncounters[veryRareEncounter.CastToInt()] + Strings.newline;
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
                        if (game.SelectedSystem().Name().equalsIgnoreCase(second)) {
                            if (game.getAutoSave()) {
                                SaveGame(SAVE_DEPARTURE, false);
                            }
                            game.WarpDirect();
                            if (game.getAutoSave()) {
                                SaveGame(SAVE_ARRIVAL, false);
                            }
                        }
                        break;
                    case Ice: {
                        switch (SomeStringsForSwitch.find(second)) {
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
                        if (num1 >= 0 && num1 < ship.Weapons().length && num2 >= 0 && num2 < Constants.WeaponObjects.length) {
                            ship.Weapons()[num1] = (Weapon) Constants.WeaponObjects[num2].Clone();
                        }
                        break;
                    case Juice:
                        ship.setFuel(Math.max(0, Math.min(ship.FuelTanks(), num1)));
                        break;
                    case Knack:
                        if (num1 >= 0 && num1 < game.Mercenaries().length) {
                            String[] skills = third.split(",");
                            for (int i = 0; i < game.Mercenaries()[num1].Skills().length && i < skills.length; i++) {
                                if (Functions.IsInt(skills[i])) {
                                    game.Mercenaries()[num1].Skills()[i] =
                                            Math.max(1, Math.min(Constants.MaxSkill, Integer.parseInt(skills[i])));
                                }
                            }
                        }
                        break;
                    case L_Engle:
                        game.setFabricRipProbability(Math.max(0, Math.min(Constants.FabricRipInitialProbability, num1)));
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
                        if (num1 > 0 && num1 < ship.Crew().length && num2 > 0 && num2 < game.Mercenaries().length
                                && !Util.ArrayContains(Constants.SpecialCrewMemberIds, (CrewMemberId.FromInt(num2)))) {
                            int skill = ship.Trader();
                            ship.Crew()[num1] = game.Mercenaries()[num2];
                            if (ship.Trader() != skill) {
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
                        switch (SomeStringsForSwitch.find(second)) {
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
                        if (num1 >= 0 && num1 < ship.Cargo().length) {
                            ship.Cargo()[num1] = Math.max(0, Math.min(ship.FreeCargoBays() + ship.Cargo()[num1], num2));
                        }
                        break;
                    case Test:
                        (new FormTest()).ShowDialog(this);
                        break;
                    case Tool:
                        if (num1 >= 0 && num1 < ship.Gadgets().length && num2 >= 0 && num2 < Constants.Gadgets.length) {
                            ship.Gadgets()[num1] = (Gadget) Constants.Gadgets[num2].Clone();
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
                switch (SomeStringsForSwitch.find(first)) {
                    case Cheetah:
                        FormAlert.Alert(AlertType.Cheater, this);
                        game.setCheatEnabled(true);
                        break;
                    default:
                        find = true;
                        break;
                }
            }
            if (find) {
                game.setSelectedSystemByName(form.SystemName());
                if (form.TrackSystem() && game.SelectedSystem().Name().equalsIgnoreCase(form.SystemName())) {
                    game.setTrackedSystemId(game.SelectedSystemId());
                }
            }
            UpdateAll();
        }
    }

    private void buttonFuel_Click(Object sender, EventArgs e) {
        FormBuyFuel form = new FormBuyFuel();
        if (form.ShowDialog(this) == DialogResult.OK) {
            int toAdd = form.Amount() / cmdr.getShip().getFuelCost();
            cmdr.getShip().setFuel(cmdr.getShip().getFuel() + toAdd);
            cmdr.setCash(cmdr.getCash() - (toAdd * cmdr.getShip().getFuelCost()));
            UpdateAll();
        }
    }

    private void buttonJump_Click(Object sender, EventArgs e) {
        if (game.WarpSystem() == null) {
            FormAlert.Alert(AlertType.ChartJumpNoSystemSelected, this);
        } else if (game.WarpSystem() == cmdr.CurrentSystem()) {
            FormAlert.Alert(AlertType.ChartJumpCurrent, this);
        } else if (FormAlert.Alert(AlertType.ChartJump, this, game.WarpSystem().Name()) == DialogResult.Yes) {
            game.setCanSuperWarp(false);
            try {
                if (game.getAutoSave()) {
                    SaveGame(SAVE_DEPARTURE, false);
                }
                game.Warp(true);
                if (game.getAutoSave()) {
                    SaveGame(SAVE_ARRIVAL, false);
                }
            } catch (GameEndException ex) {
                GameEnd();
            }
            UpdateAll();
        }
    }

    private void buttonMerc_Click(Object sender, EventArgs e) {
        (new FormViewPersonnel()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonNews_Click(Object sender, EventArgs e) {
        game.ShowNewspaper();
    }

    private void buttonNextSystem_Click(Object sender, EventArgs e) {
        game.SelectNextSystemWithinRange(true);
        UpdateAll();
    }

    private void buttonPod_Click(Object sender, EventArgs e) {
        if (FormAlert.Alert(AlertType.EquipmentEscapePod, this) == DialogResult.Yes) {
            cmdr.setCash(cmdr.getCash() - 2000);
            cmdr.getShip().setEscapePod(true);
            UpdateAll();
        }
    }

    private void buttonPrevSystem_Click(Object sender, EventArgs e) {
        game.SelectNextSystemWithinRange(false);
        UpdateAll();
    }

    private void buttonRepair_Click(Object sender, EventArgs e) {
        FormBuyRepairs form = new FormBuyRepairs();
        if (form.ShowDialog(this) == DialogResult.OK) {
            int toAdd = form.Amount() / cmdr.getShip().getRepairCost();
            cmdr.getShip().setHull(cmdr.getShip().getHull() + toAdd);
            cmdr.setCash(cmdr.getCash() - (toAdd * cmdr.getShip().getRepairCost()));
            UpdateAll();
        }
    }

    private void buttonSpecial_Click(Object sender, EventArgs e) {
        SpecialEvent specEvent = cmdr.CurrentSystem().SpecialEvent();
        String button1, button2;
        DialogResult res1, res2;
        if (specEvent.MessageOnly()) {
            button1 = "Ok";
            button2 = null;
            res1 = DialogResult.OK;
            res2 = DialogResult.None;
        } else {
            button1 = "Yes";
            button2 = "No";
            res1 = DialogResult.Yes;
            res2 = DialogResult.No;
        }
        FormAlert alert = new FormAlert(specEvent.Title(), specEvent.String(), button1, res1, button2, res2, null);
        if (alert.ShowDialog() != DialogResult.No) {
            if (cmdr.CashToSpend() < specEvent.Price()) {
                FormAlert.Alert(AlertType.SpecialIF, this);
            } else {
                try {
                    game.HandleSpecialEvent();
                } catch (GameEndException ex) {
                    GameEnd();
                }
            }
        }
        UpdateAll();
    }

    private void buttonTrack_Click(Object sender, EventArgs e) {
        game.setTrackedSystemId(game.SelectedSystemId());
        UpdateAll();
    }

    private void buttonWarp_Click(Object sender, EventArgs e) {
        try {
            if (game.getAutoSave()) {
                SaveGame(SAVE_DEPARTURE, false);
            }
            game.Warp(false);
            if (game.getAutoSave()) {
                SaveGame(SAVE_ARRIVAL, false);
            }
        } catch (GameEndException ex) {
            GameEnd();
        }
        UpdateAll();
    }

    private void mnuGameExit_Click(Object sender, EventArgs e) {
        Close();
    }

    private void mnuGameNew_Click(Object sender, EventArgs e) {
        FormNewCommander form = new FormNewCommander();
        if ((game == null || cmdr.getDays() == SaveGameDays
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
            if (game.Options().getNewsAutoShow()) {
                game.ShowNewspaper();
            }
        }
    }

    private void mnuGameLoad_Click(Object sender, EventArgs e) {
        if ((game == null || cmdr.getDays() == SaveGameDays
                || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes)
                && dlgOpen.ShowDialog(this) == DialogResult.OK) {
            LoadGame(dlgOpen.getFileName());
        }
    }

    private void mnuGameSave_Click(Object sender, EventArgs e) {
        if (game != null) {
            if (SaveGameFile != null) {
                SaveGame(SaveGameFile, false);
            } else {
                mnuGameSaveAs_Click(sender, e);
            }
        }
    }

    private void mnuGameSaveAs_Click(Object sender, EventArgs e) {
        if (game != null && dlgSave.ShowDialog(this) == DialogResult.OK) {
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
        if (form.ShowDialog(this) == DialogResult.OK) {
            game.Options().CopyValues(form.Options());
            UpdateAll();
        }
    }

    private void mnuRetire_Click(Object sender, EventArgs e) {
        if (FormAlert.Alert(AlertType.GameRetire, this) == DialogResult.Yes) {
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
        if (e.Button == MouseButtons.Left && game != null) {
            StarSystem[] universe = game.Universe();
            boolean clickedSystem = false;
            for (int i = 0; i < universe.length && !clickedSystem; i++) {
                int x = universe[i].X() + OFF_X;
                int y = universe[i].Y() + OFF_Y;
                if (e.X >= x - 2 && e.X <= x + 2 && e.Y >= y - 2 && e.Y <= y + 2) {
                    clickedSystem = true;
                    game.SelectedSystemId(StarSystemId.FromInt(i));
                } else if (Functions.WormholeExists(i, -1)) {
                    int xW = x + OFF_X_WORM;
                    if (e.X >= xW - 2 && e.X <= xW + 2 && e.Y >= y - 2 && e.Y <= y + 2) {
                        clickedSystem = true;
                        game.SelectedSystemId(StarSystemId.FromInt(i));
                        game.TargetWormhole(true);
                    }
                }
            }
            if (clickedSystem) {
                UpdateAll();
            }
        }
    }

    private void picGalacticChart_Paint(Object sender, PaintEventArgs e) {
        if (game != null) {
            StarSystem[] universe = game.Universe();
            int[] wormholes = game.Wormholes();
            StarSystem targetSys = game.SelectedSystem();
            StarSystem curSys = cmdr.CurrentSystem();
            int fuel = cmdr.getShip().getFuel();
            if (fuel > 0) {
                e.Graphics.DrawEllipse(DEFAULT_PEN, curSys.X() + OFF_X - fuel, curSys.Y() + OFF_Y - fuel, fuel * 2, fuel * 2);
            }
            int index = game.SelectedSystemId().CastToInt();
            if (game.TargetWormhole()) {
                int destination = wormholes[(Util.BruteSeek(wormholes, index) + 1) % wormholes.length];
                StarSystem destinationSystem = universe[destination];
                e.Graphics.DrawLine(
                        DEFAULT_PEN, targetSys.X() + OFF_X_WORM + OFF_X,
                        targetSys.Y() + OFF_Y, destinationSystem.X() + OFF_X, destinationSystem.Y() + OFF_Y);
            }
            for (int i = 0; i < universe.length; i++) {
                //  private final int IMG_S_NS = 4;
                int IMG_S_V = 5;
                int IMG_S_N = 3;
                int imageIndex = universe[i].Visited() ? IMG_S_V : IMG_S_N;
                if (universe[i] == game.WarpSystem()) {
                    imageIndex++;
                }
                wfImage image = ilChartImages.getImages()[imageIndex];
                if (universe[i] == game.TrackedSystem()) {
                    e.Graphics.DrawLine(
                            DEFAULT_PEN, universe[i].X(), universe[i].Y(),
                            universe[i].X() + image.getWidth() - 1, universe[i].Y() + image.getHeight() - 1);
                    e.Graphics.DrawLine(
                            DEFAULT_PEN, universe[i].X(), universe[i].Y() + image.getHeight() - 1,
                            universe[i].X() + image.getWidth() - 1, universe[i].Y());
                }
                ilChartImages.Draw(e.Graphics, universe[i].X(), universe[i].Y(), imageIndex);
                if (Functions.WormholeExists(i, -1)) {
                    //  private final int IMG_S_VS = 6;
                    int IMG_S_W = 7;
                    ilChartImages.Draw(e.Graphics, universe[i].X() + OFF_X_WORM, universe[i].Y(), IMG_S_W);
                }
            }
        } else {
            e.Graphics.FillRectangle(DEFAULT_BRUSH, 0, 0, picGalacticChart.getWidth(), picGalacticChart.getHeight());
        }
    }

    private void picShortRangeChart_MouseDown(Object sender, MouseEventArgs e) {
        if (e.Button == MouseButtons.Left && game != null) {
            StarSystem[] universe = game.Universe();
            StarSystem curSys = cmdr.CurrentSystem();
            boolean clickedSystem = false;
            int centerX = picShortRangeChart.getWidth() / 2;
            int centerY = picShortRangeChart.getHeight() / 2;
            int delta = picShortRangeChart.getHeight() / (Constants.MaxRange * 2);
            for (int i = 0; i < universe.length && !clickedSystem; i++) {
                if ((Math.abs(universe[i].X() - curSys.X()) * delta <= picShortRangeChart.getWidth() / 2 - 10)
                        && (Math.abs(universe[i].Y() - curSys.Y()) * delta <= picShortRangeChart.getHeight() / 2 - 10)) {
                    int x = centerX + (universe[i].X() - curSys.X()) * delta;
                    int y = centerY + (universe[i].Y() - curSys.Y()) * delta;
                    if (e.X >= x - OFF_X && e.X <= x + OFF_X && e.Y >= y - OFF_Y && e.Y <= y + OFF_Y) {
                        clickedSystem = true;
                        game.SelectedSystemId(StarSystemId.FromInt(i));
                    } else if (Functions.WormholeExists(i, -1)) {
                        int xW = x + 9;
                        if (e.X >= xW - OFF_X && e.X <= xW + OFF_X && e.Y >= y - OFF_Y && e.Y <= y + OFF_Y) {
                            clickedSystem = true;
                            game.SelectedSystemId((StarSystemId.FromInt(i)));
                            game.TargetWormhole(true);
                        }
                    }
                }
            }
            if (clickedSystem) {
                UpdateAll();
            }
        }
    }

    private void picShortRangeChart_Paint(Object sender, PaintEventArgs e) {
        if (game == null) {
            e.Graphics.FillRectangle(DEFAULT_BRUSH, 0, 0, picShortRangeChart.getWidth(), picShortRangeChart.getHeight());
        } else {
            int[] wormholes = game.Wormholes();
            int fuel = cmdr.getShip().getFuel();
            int centerX = picShortRangeChart.getWidth() / 2;
            int centerY = picShortRangeChart.getHeight() / 2;
            int delta = picShortRangeChart.getHeight() / (Constants.MaxRange * 2);
            e.Graphics.DrawLine(DEFAULT_PEN, centerX - 1, centerY - 1, centerX + 1, centerY + 1);
            e.Graphics.DrawLine(DEFAULT_PEN, centerX - 1, centerY + 1, centerX + 1, centerY - 1);
            if (fuel > 0) {
                e.Graphics.DrawEllipse(DEFAULT_PEN, centerX - fuel * delta, centerY - fuel * delta, fuel * delta * 2, fuel * delta * 2);
            }
            StarSystem curSys = cmdr.CurrentSystem();
            StarSystem trackSys = game.TrackedSystem();
            if (trackSys != null) {
                int dist = Functions.Distance(curSys, trackSys);
                if (dist > 0) {
                    int dX = (int) Math.round(25 * (trackSys.X() - curSys.X()) / (double) dist);
                    int dY = (int) Math.round(25 * (trackSys.Y() - curSys.Y()) / (double) dist);
                    int dX2 = (int) Math.round(4 * (trackSys.Y() - curSys.Y()) / (double) dist);
                    int dY2 = (int) Math.round(4 * (curSys.X() - trackSys.X()) / (double) dist);
                    e.Graphics.FillPolygon(new SolidBrush(new Color(220, 20, 60)), new Point[]{
                            new Point(centerX + dX, centerY + dY), new Point(centerX - dX2, centerY - dY2), new Point(centerX + dX2, centerY + dY2)
                    });
                }
                if (game.Options().getShowTrackedRange()) {
                    e.Graphics.DrawString(
                            Functions.StringVars("^1 to ^2.", Functions.Multiples(dist, Strings.DistanceUnit), trackSys.Name()),
                            getFont(), new SolidBrush(Color.black), 0, picShortRangeChart.getHeight() - 13);
                }
            }
            // First, draw the names, then the systems.
            // The names may overlap and the systems may be drawn on the names, but at least every system is visible.
            StarSystem[] universe = game.Universe();
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < universe.length; i++) {
                    if ((Math.abs(universe[i].X() - curSys.X()) * delta <= picShortRangeChart.getWidth() / 2 - 10)
                            && (Math.abs(universe[i].Y() - curSys.Y()) * delta <= picShortRangeChart.getHeight() / 2 - 10)) {
                        int x = centerX + (universe[i].X() - curSys.X()) * delta;
                        int y = centerY + (universe[i].Y() - curSys.Y()) * delta;
                        if (j == 1) {
                            if (universe[i] == game.WarpSystem()) {
                                e.Graphics.DrawLine(DEFAULT_PEN, x - 6, y, x + 6, y);
                                e.Graphics.DrawLine(DEFAULT_PEN, x, y - 6, x, y + 6);
                            }
                            if (universe[i] == game.TrackedSystem()) {
                                e.Graphics.DrawLine(DEFAULT_PEN, x - 5, y - 5, x + 5, y + 5);
                                e.Graphics.DrawLine(DEFAULT_PEN, x - 5, y + 5, x + 5, y - 5);
                            }
                            int IMG_G_N = 0;
                            int IMG_G_V = 1;
                            ilChartImages.Draw(e.Graphics, x - OFF_X, y - OFF_Y, universe[i].Visited() ? IMG_G_V : IMG_G_N);
                            if (Functions.WormholeExists(i, -1)) {
                                int xW = x + 9;
                                if (game.TargetWormhole() && universe[i] == game.SelectedSystem()) {
                                    e.Graphics.DrawLine(DEFAULT_PEN, xW - 6, y, xW + 6, y);
                                    e.Graphics.DrawLine(DEFAULT_PEN, xW, y - 6, xW, y + 6);
                                }
                                int IMG_G_W = 2;
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
        if (game != null) {
            if (e.StatusBarPanel == statusBarPanelCash) {
                mnuViewBank_Click(sender, e);
            } else if (e.StatusBarPanel == statusBarPanelCosts) {
                (new FormCosts()).ShowDialog(this);
            }
        }
    }

    public wfImage[] CustomShipImages() {
        wfImage[] images = new wfImage[Constants.ImagesPerShip];
        int baseIndex = ShipType.Custom.CastToInt() * Constants.ImagesPerShip;
        for (int index = 0; index < Constants.ImagesPerShip; index++) {
            images[index] = ilShipImages.getImages()[baseIndex + index];
        }
        return images;
    }

    public void CustomShipImages(wfImage[] value) {
        int baseIndex = ShipType.Custom.CastToInt() * Constants.ImagesPerShip;
        System.arraycopy(value, 0, ilShipImages.getImages(), baseIndex, Constants.ImagesPerShip);
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

    public wfImage[] getCustomShipImages() {
        wfImage[] images = new wfImage[Constants.ImagesPerShip];
        int baseIndex = ShipType.Custom.CastToInt() * Constants.ImagesPerShip;
        for (int index = 0; index < Constants.ImagesPerShip; index++) {
            images[index] = ilShipImages.getImages()[baseIndex + index];
        }
        return images;
    }

    public void setCustomShipImages(wfImage[] value) {
        int baseIndex = ShipType.Custom.CastToInt() * Constants.ImagesPerShip;
        System.arraycopy(value, 0, ilShipImages.getImages(), baseIndex, Constants.ImagesPerShip);
    }
}
