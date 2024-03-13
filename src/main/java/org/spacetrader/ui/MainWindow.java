package org.spacetrader.ui;

import org.spacetrader.Main;
import org.spacetrader.controller.*;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.crew.CrewMember;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.enums.GameEndType;
import org.spacetrader.model.enums.StarSystemId;
import org.spacetrader.model.enums.CrewMemberId;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.events.VeryRareEncounter;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.model.ship.equipment.Gadget;
import org.spacetrader.model.ship.equipment.Shield;
import org.spacetrader.model.ship.equipment.Weapon;
import org.spacetrader.model.system.StarSystem;
import org.spacetrader.util.Directory;
import org.spacetrader.util.RegistryKey;
import org.spacetrader.util.Util;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Icon;
import org.winforms.Label;
import org.winforms.MenuItem;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Hashtable;


public class MainWindow extends wfWindow {

    private final Label[] labelSellPrice;
    private final Label[] labelBuyPrice;
    private final Label[] labelTargetPrice;
    private final Label[] labelTargetDiff;
    private final Label[] labelTargetPct;
    private final Button[] buttonSellQty;
    private final Button[] buttonSellAll;
    private final Button[] buttonBuyQty;
    private final Button[] buttonBuyMax;
    private final String SAVE_ARRIVAL = "autosave_arrival.sav";
    private final String SAVE_DEPARTURE = "autosave_departure.sav";
    private final int OFF_X = 3;
    private final int OFF_Y = 3;
    private final int OFF_X_WORM = OFF_X + 1;
    private final Pen PEN_BLACK = new Pen(Color.black);
    private final Pen PEN_WHITE = new Pen(Color.white);
    private final Button buttonDesign;
    private final Button buttonNews;
    private final Button buttonSpecial;
    private final Button buttonMerc;
    private final Button buttonFuel;
    private final Button buttonRepair;
    private final Button buttonBuyShip;
    private final Button buttonEquip;
    private final Button buttonPod;
    private final Button buttonJump;
    private final Button buttonFind;
    private final Button buttonPrevSystem;
    private final Button buttonNextSystem;
    private final Button buttonTrack;
    private final Button buttonWarp;
    private final ImageList ilChartImages;
    private final ImageList ilDirectionImages;
    private final ImageList ilEquipmentImages;
    private final ImageList ilShipImages;
    private final Label labelBuy;
    private final Label labelEquipForSale;
    private final Label labelEscapePod;
    private final Label labelFuelCost;
    private final Label labelFuelStatus;
    private final Label labelHullStatus;
    private final Label labelRepairCost;
    private final Label labelSell;
    private final Label labelShipsForSale;
    private final Label labelSystemName;
    private final Label labelSystemNameLabel;
    private final Label labelSystemPirates;
    private final Label labelSystemPolice;
    private final Label labelSystemPolSys;
    private final Label labelSystemPressure;
    private final Label labelSystemPressurePre;
    private final Label labelSystemResource;
    private final Label labelSystemSize;
    private final Label labelSystemTech;
    private final Label labelTargetDistance;
    private final Label labelTargetName;
    private final Label labelTargetOutOfRange;
    private final Label labelTargetPirates;
    private final Label labelTargetPolice;
    private final Label labelTargetPolSys;
    private final Label labelTargetResource;
    private final Label labelTargetSize;
    private final Label labelTargetTech;
    private final Label labelWormhole;
    private final Label labelWormholeLabel;
    private final MenuItem mnuGameSave;
    private final MenuItem mnuGameSaveAs;
    private final MenuItem mnuRetire;
    private final MenuItem mnuViewBank;
    private final MenuItem mnuViewCommander;
    private final MenuItem mnuViewPersonnel;
    private final MenuItem mnuViewQuests;
    private final MenuItem mnuViewShip;
    private final OpenFileDialog dlgOpen;
    private final PictureBox pictureGalacticChart;
    private final PictureBox pictureShortRangeChart;
    private final SaveFileDialog dlgSave;
    private final StatusBarPanel statusBarPanelBays;
    private final StatusBarPanel statusBarPanelCash;
    private final StatusBarPanel statusBarPanelCosts;
    private final StatusBarPanel statusBarPanelExtra;
    private final ToolTip tipSpecial;
    private final ToolTip tipMerc;
    private Game game = null;
    private Commander commander = null;
    private String SaveGameFile = null;
    private int SaveGameDays = -1;

    public MainWindow() {
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
        pictureGalacticChart = new PictureBox();
        pictureShortRangeChart = new PictureBox();
        StatusBar statusBar = new StatusBar();
        statusBarPanelCash = new StatusBarPanel();
        statusBarPanelBays = new StatusBarPanel();
        statusBarPanelCosts = new StatusBarPanel();
        statusBarPanelExtra = new StatusBarPanel(StatusBarPanelAutoSize.Spring);
        GroupBox boxShortRangeChart = new GroupBox();
        GroupBox boxGalacticChart = new GroupBox();
        labelWormhole = new Label();
        labelWormholeLabel = new Label();
        buttonJump = new Button();
        buttonFind = new Button();
        GroupBox boxTargetSystem = new GroupBox();
        buttonTrack = new Button();
        buttonNextSystem = new Button();
        buttonPrevSystem = new Button();
        labelTargetOutOfRange = new Label();
        buttonWarp = new Button();
        labelTargetPolSys = new Label();
        labelTargetSize = new Label();
        labelTargetTech = new Label();
        labelTargetDistance = new Label();
        labelTargetPirates = new Label();
        labelTargetPolice = new Label();
        labelTargetResource = new Label();
        Label labelTargetDistanceLabel = new Label();
        Label labelTargetPiratesLabel = new Label();
        Label labelTargetPoliceLabel = new Label();
        Label labelTargetResourceLabel = new Label();
        Label labelTargetGovtLabel = new Label();
        Label labelTargetTechLabel = new Label();
        Label labelTargetSizeLabel = new Label();
        labelTargetName = new Label();
        Label labelTargetNameLabel = new Label();
        GroupBox boxCargo = new GroupBox();
        PictureBox pictureCargoLine3 = new PictureBox();
        PictureBox pictureCargoLine2 = new PictureBox();
        PictureBox pictureCargoLine0 = new PictureBox();
        PictureBox pictureCargoLine1 = new PictureBox();
        Label labelTargetPct9 = new Label();
        Label labelTargetDiff9 = new Label();
        Label labelTargetPrice9 = new Label();
        Button buttonBuyMax9 = new Button();
        Button buttonBuyQty9 = new Button();
        Label labelBuyPrice9 = new Label();
        Button buttonSellAll9 = new Button();
        Button buttonSellQty9 = new Button();
        Label labelSellPrice9 = new Label();
        Label labelTargetPct8 = new Label();
        Label labelTargetDiff8 = new Label();
        Label labelTargetPrice8 = new Label();
        Button buttonBuyMax8 = new Button();
        Button buttonBuyQty8 = new Button();
        Label labelBuyPrice8 = new Label();
        Button buttonSellAll8 = new Button();
        Button buttonSellQty8 = new Button();
        Label labelSellPrice8 = new Label();
        Label labelTargetPct7 = new Label();
        Label labelTargetDiff7 = new Label();
        Label labelTargetPrice7 = new Label();
        Button buttonBuyMax7 = new Button();
        Button buttonBuyQty7 = new Button();
        Label labelBuyPrice7 = new Label();
        Button buttonSellAll7 = new Button();
        Button buttonSellQty7 = new Button();
        Label labelSellPrice7 = new Label();
        Label labelTargetPct6 = new Label();
        Label labelTargetDiff6 = new Label();
        Label labelTargetPrice6 = new Label();
        Button buttonBuyMax6 = new Button();
        Button buttonBuyQty6 = new Button();
        Label labelBuyPrice6 = new Label();
        Button buttonSellAll6 = new Button();
        Button buttonSellQty6 = new Button();
        Label labelSellPrice6 = new Label();
        Label labelTargetPct5 = new Label();
        Label labelTargetDiff5 = new Label();
        Label labelTargetPrice5 = new Label();
        Button buttonBuyMax5 = new Button();
        Button buttonBuyQty5 = new Button();
        Label labelBuyPrice5 = new Label();
        Button buttonSellAll5 = new Button();
        Button buttonSellQty5 = new Button();
        Label labelSellPrice5 = new Label();
        Label labelTargetPct4 = new Label();
        Label labelTargetDiff4 = new Label();
        Label labelTargetPrice4 = new Label();
        Button buttonBuyMax4 = new Button();
        Button buttonBuyQty4 = new Button();
        Label labelBuyPrice4 = new Label();
        Button buttonSellAll4 = new Button();
        Button buttonSellQty4 = new Button();
        Label labelSellPrice4 = new Label();
        Label labelTargetPct3 = new Label();
        Label labelTargetDiff3 = new Label();
        Label labelTargetPrice3 = new Label();
        Button buttonBuyMax3 = new Button();
        Button buttonBuyQty3 = new Button();
        Label labelBuyPrice3 = new Label();
        Button buttonSellAll3 = new Button();
        Button buttonSellQty3 = new Button();
        Label labelSellPrice3 = new Label();
        Label labelTargetPct2 = new Label();
        Label labelTargetDiff2 = new Label();
        Label labelTargetPrice2 = new Label();
        Button buttonBuyMax2 = new Button();
        Button buttonBuyQty2 = new Button();
        Label labelBuyPrice2 = new Label();
        Button buttonSellAll2 = new Button();
        Button buttonSellQty2 = new Button();
        Label labelSellPrice2 = new Label();
        Label labelTargetPct1 = new Label();
        Label labelTargetDiff1 = new Label();
        Label labelTargetPrice1 = new Label();
        Button buttonBuyMax1 = new Button();
        Button buttonBuyQty1 = new Button();
        Label labelBuyPrice1 = new Label();
        Label labelTargetPctLabel = new Label();
        Label labelTargetDiffLabel = new Label();
        Label labelTargetPriceLabel = new Label();
        Label labelTargetPct0 = new Label();
        Label labelTargetDiff0 = new Label();
        Label labelTargetPrice0 = new Label();
        Button buttonBuyMax0 = new Button();
        Button buttonBuyQty0 = new Button();
        Label labelBuyPrice0 = new Label();
        Button buttonSellAll1 = new Button();
        Button buttonSellQty1 = new Button();
        Label labelSellPrice1 = new Label();
        Button buttonSellAll0 = new Button();
        Button buttonSellQty0 = new Button();
        Label labelSellPrice0 = new Label();
        Label labelTradeTarget = new Label();
        labelBuy = new Label();
        labelSell = new Label();
        Label labelTradeCommodity9 = new Label();
        Label labelTradeCommodity8 = new Label();
        Label labelTradeCommodity2 = new Label();
        Label labelTradeCommodity0 = new Label();
        Label labelTradeCommodity1 = new Label();
        Label labelTradeCommodity6 = new Label();
        Label labelTradeCommodity5 = new Label();
        Label labelTradeCommodity4 = new Label();
        Label labelTradeCommodity3 = new Label();
        Label labelTradeCommodity7 = new Label();
        GroupBox boxSystem = new GroupBox();
        buttonMerc = new Button();
        buttonSpecial = new Button();
        buttonNews = new Button();
        labelSystemPressure = new Label();
        labelSystemPressurePre = new Label();
        labelSystemPolSys = new Label();
        labelSystemSize = new Label();
        labelSystemTech = new Label();
        labelSystemPirates = new Label();
        labelSystemPolice = new Label();
        labelSystemResource = new Label();
        Label labelSystemPiratesLabel = new Label();
        Label labelSystemPoliceLabel = new Label();
        Label labelSystemResourceLabel = new Label();
        Label labelSystemGovtLabel = new Label();
        Label labelSystemTechLabel = new Label();
        Label labelSystemSizeLabel = new Label();
        labelSystemName = new Label();
        labelSystemNameLabel = new Label();
        GroupBox boxShipYard = new GroupBox();
        buttonDesign = new Button();
        buttonPod = new Button();
        labelEscapePod = new Label();
        buttonEquip = new Button();
        buttonBuyShip = new Button();
        labelEquipForSale = new Label();
        labelShipsForSale = new Label();
        GroupBox boxDock = new GroupBox();
        buttonRepair = new Button();
        buttonFuel = new Button();
        labelFuelStatus = new Label();
        labelFuelCost = new Label();
        labelHullStatus = new Label();
        labelRepairCost = new Label();
        PictureBox pictureLine = new PictureBox();
        dlgOpen = new OpenFileDialog();
        dlgSave = new SaveFileDialog();
        ilChartImages = new ImageList();
        ilShipImages = new ImageList();
        ilDirectionImages = new ImageList();
        tipSpecial = new ToolTip();
        tipMerc = new ToolTip();
        ilEquipmentImages = new ImageList();
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
            public void handle(Object sender, EventData data) {
                mnuGameNew_Click(sender, data);
            }
        });
        // mnuGameLoad
        mnuGameLoad.Index = 1;
        mnuGameLoad.Shortcut = Shortcut.CtrlL;
        mnuGameLoad.setText("&Load...");
        mnuGameLoad.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                mnuGameLoad_Click(sender, data);
            }
        });
        // mnuGameSave
        mnuGameSave.setEnabled(false);
        mnuGameSave.Index = 2;
        mnuGameSave.Shortcut = Shortcut.CtrlS;
        mnuGameSave.setText("&Save");
        mnuGameSave.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                mnuGameSave_Click(sender, data);
            }
        });
        // mnuGameSaveAs
        mnuGameSaveAs.setEnabled(false);
        mnuGameSaveAs.Index = 3;
        mnuGameSaveAs.Shortcut = Shortcut.CtrlA;
        mnuGameSaveAs.setText("Save &As...");
        mnuGameSaveAs.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                mnuGameSaveAs_Click(sender, data);
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
            public void handle(Object sender, EventData data) {
                mnuRetire_Click(sender, data);
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
            public void handle(Object sender, EventData data) {
                mnuGameExit_Click(sender, data);
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
            public void handle(Object sender, EventData data) {
                mnuViewCommander_Click(sender, data);
            }
        });
        // mnuViewShip
        mnuViewShip.setEnabled(false);
        mnuViewShip.Index = 1;
        mnuViewShip.Shortcut = Shortcut.CtrlH;
        mnuViewShip.setText("&Ship");
        mnuViewShip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                mnuViewShip_Click(sender, data);
            }
        });
        // mnuViewPersonnel
        mnuViewPersonnel.setEnabled(false);
        mnuViewPersonnel.Index = 2;
        mnuViewPersonnel.Shortcut = Shortcut.CtrlP;
        mnuViewPersonnel.setText("&Personnel");
        mnuViewPersonnel.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                mnuViewPersonnel_Click(sender, data);
            }
        });
        // mnuViewQuests
        mnuViewQuests.setEnabled(false);
        mnuViewQuests.Index = 3;
        mnuViewQuests.Shortcut = Shortcut.CtrlQ;
        mnuViewQuests.setText("&Quests");
        mnuViewQuests.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                mnuViewQuests_Click(sender, data);
            }
        });
        // mnuViewBank
        mnuViewBank.setEnabled(false);
        mnuViewBank.Index = 4;
        mnuViewBank.Shortcut = Shortcut.CtrlB;
        mnuViewBank.setText("&Bank");
        mnuViewBank.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                mnuViewBank_Click(sender, data);
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
            public void handle(Object sender, EventData data) {
                mnuHighScores_Click(sender, data);
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
            public void handle(Object sender, EventData data) {
                mnuOptions_Click(sender, data);
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
            public void handle(Object sender, EventData data) {
                mnuHelpAbout_Click(sender, data);
            }
        });
        // pictureGalacticChart
        pictureGalacticChart.setBackColor(Color.white);
        pictureGalacticChart.setLocation(new Point(8, 16));
        pictureGalacticChart.setName("pictureGalacticChart");
        pictureGalacticChart.setSize(new SizeF(116, 160));
        pictureGalacticChart.setTabIndex(0);
        pictureGalacticChart.setTabStop(false);
        pictureGalacticChart.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventData data) {
                pictureGalacticChart_Paint(sender, data);
            }
        });
        pictureGalacticChart.setMouseDown(new EventHandler<>() {
            @Override
            public void handle(Object sender, MouseEventData data) {
                pictureGalacticChart_MouseDown(sender, data);
            }
        });
        // pictureShortRangeChart
        pictureShortRangeChart.setBackColor(Color.white);
        pictureShortRangeChart.setLocation(new Point(8, 16));
        pictureShortRangeChart.setName("pictureShortRangeChart");
        pictureShortRangeChart.setSize(new SizeF(145, 160));
        pictureShortRangeChart.setTabIndex(1);
        pictureShortRangeChart.setTabStop(false);
        pictureShortRangeChart.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventData data) {
                pictureShortRangeChart_Paint(sender, data);
            }
        });
        pictureShortRangeChart.setMouseDown(new EventHandler<>() {
            @Override
            public void handle(Object sender, MouseEventData data) {
                pictureShortRangeChart_MouseDown(sender, data);
            }
        });
        // statusBar
        statusBar.setLocation(new Point(0, 481));
        statusBar.setName("statusBar");
        statusBar.Panels.addAll(Arrays.asList(statusBarPanelCash, statusBarPanelBays, statusBarPanelCosts, statusBarPanelExtra));
        statusBar.ShowPanels = true;
        statusBar.setSize(new SizeF(24, 768));
        statusBar.SizingGrip = false;
        statusBar.setTabIndex(2);
        statusBar.PanelClick = new EventHandler<>() {
            @Override
            public void handle(Object sender, StatusBarPanelClickEventData data) {
                statusBar_PanelClick(sender, data);
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
        boxShortRangeChart.Controls.add(pictureShortRangeChart);
        boxShortRangeChart.setLocation(new Point(364, 306));
        boxShortRangeChart.setName("boxShortRangeChart");
        boxShortRangeChart.setSize(new SizeF(168, 176));
        boxShortRangeChart.setTabIndex(6);
        boxShortRangeChart.setTabStop(false);
        boxShortRangeChart.setText("Short-Range Chart");
        // boxGalacticChart
        boxGalacticChart.Anchor = AnchorStyles.Top_Right;
        boxGalacticChart.setBackColor(SystemColors.Control);
        boxGalacticChart.Controls.add(labelWormhole);
        boxGalacticChart.Controls.add(labelWormholeLabel);
        boxGalacticChart.Controls.add(buttonJump);
        boxGalacticChart.Controls.add(buttonFind);
        boxGalacticChart.Controls.add(pictureGalacticChart);
        boxGalacticChart.setLocation(new Point(180, 306));
        boxGalacticChart.setName("boxGalacticChart");
        boxGalacticChart.setSize(new SizeF(168, 176));
        boxGalacticChart.setTabIndex(5);
        boxGalacticChart.setTabStop(false);
        boxGalacticChart.setText("Galactic Chart");
        // labelWormhole
        labelWormhole.setLocation(new Point(8, 148));
        labelWormhole.setName("labelWormhole");
        labelWormhole.setSize(new SizeF(13, 72));
        labelWormhole.setTabIndex(29);
        labelWormhole.setText("Tarchannen");
        // labelWormholeLabel
        labelWormholeLabel.setLocation(new Point(8, 135));
        labelWormholeLabel.setName("labelWormholeLabel");
        labelWormholeLabel.setSize(new SizeF(13, 72));
        labelWormholeLabel.setTabIndex(28);
        labelWormholeLabel.setText("Wormhole to");
        // buttonJump
        buttonJump.setFlatStyle(FlatStyle.Flat);
        buttonJump.setLocation(new Point(81, 138));
        buttonJump.setName("buttonJump");
        buttonJump.setSize(new SizeF(22, 42));
        buttonJump.setTabIndex(55);
        buttonJump.setText("Jump");
        buttonJump.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJump_Click(sender, data);
            }
        });
        // buttonFind
        buttonFind.setFlatStyle(FlatStyle.Flat);
        buttonFind.setLocation(new Point(132, 138));
        buttonFind.setName("buttonFind");
        buttonFind.setSize(new SizeF(22, 36));
        buttonFind.setTabIndex(56);
        buttonFind.setText("Find");
        buttonFind.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonFind_Click(sender, data);
            }
        });
        // boxTargetSystem
        boxTargetSystem.Anchor = AnchorStyles.Top_Right;
        boxTargetSystem.Controls.add(buttonTrack);
        boxTargetSystem.Controls.add(buttonNextSystem);
        boxTargetSystem.Controls.add(buttonPrevSystem);
        boxTargetSystem.Controls.add(labelTargetOutOfRange);
        boxTargetSystem.Controls.add(buttonWarp);
        boxTargetSystem.Controls.add(labelTargetPolSys);
        boxTargetSystem.Controls.add(labelTargetSize);
        boxTargetSystem.Controls.add(labelTargetTech);
        boxTargetSystem.Controls.add(labelTargetDistance);
        boxTargetSystem.Controls.add(labelTargetPirates);
        boxTargetSystem.Controls.add(labelTargetPolice);
        boxTargetSystem.Controls.add(labelTargetResource);
        boxTargetSystem.Controls.add(labelTargetDistanceLabel);
        boxTargetSystem.Controls.add(labelTargetPiratesLabel);
        boxTargetSystem.Controls.add(labelTargetPoliceLabel);
        boxTargetSystem.Controls.add(labelTargetResourceLabel);
        boxTargetSystem.Controls.add(labelTargetGovtLabel);
        boxTargetSystem.Controls.add(labelTargetTechLabel);
        boxTargetSystem.Controls.add(labelTargetSizeLabel);
        boxTargetSystem.Controls.add(labelTargetName);
        boxTargetSystem.Controls.add(labelTargetNameLabel);
        boxTargetSystem.setLocation(new Point(548, 306));
        boxTargetSystem.setName("boxTargetSystem");
        boxTargetSystem.setSize(new SizeF(168, 216));
        boxTargetSystem.setTabIndex(7);
        boxTargetSystem.setTabStop(false);
        boxTargetSystem.setText("Target System");
        // buttonTrack
        buttonTrack.setFlatStyle(FlatStyle.Flat);
        buttonTrack.setLocation(new Point(160, 140));
        buttonTrack.setName("buttonTrack");
        buttonTrack.setSize(new SizeF(22, 44));
        buttonTrack.setTabIndex(60);
        buttonTrack.setText("Track");
        buttonTrack.setVisible(false);
        buttonTrack.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonTrack_Click(sender, data);
            }
        });
        // buttonNextSystem
        buttonNextSystem.setFlatStyle(FlatStyle.Flat);
        buttonNextSystem.setLocation(new Point(186, 16));
        buttonNextSystem.setName("buttonNextSystem");
        buttonNextSystem.setSize(new SizeF(18, 18));
        buttonNextSystem.setTabIndex(58);
        buttonNextSystem.setText(">");
        buttonNextSystem.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonNextSystem_Click(sender, data);
            }
        });
        // buttonPrevSystem
        buttonPrevSystem.setFlatStyle(FlatStyle.Flat);
        buttonPrevSystem.setLocation(new Point(160, 16));
        buttonPrevSystem.setName("buttonPrevSystem");
        buttonPrevSystem.setSize(new SizeF(18, 18));
        buttonPrevSystem.setTabIndex(57);
        buttonPrevSystem.setText("<");
        buttonPrevSystem.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonPrevSystem_Click(sender, data);
            }
        });
        // labelTargetOutOfRange
        labelTargetOutOfRange.setLocation(new Point(8, 144));
        labelTargetOutOfRange.setName("labelTargetOutOfRange");
        labelTargetOutOfRange.setSize(new SizeF(13, 144));
        labelTargetOutOfRange.setTabIndex(17);
        labelTargetOutOfRange.setText("This system is out of range.");
        // buttonWarp
        buttonWarp.setFlatStyle(FlatStyle.Flat);
        buttonWarp.setLocation(new Point(160, 98));
        buttonWarp.setName("buttonWarp");
        buttonWarp.setSize(new SizeF(44, 44));
        buttonWarp.setTabIndex(59);
        buttonWarp.setText("Warp");
        buttonWarp.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonWarp_Click(sender, data);
            }
        });
        // labelTargetPolSys
        labelTargetPolSys.setLocation(new Point(88, 64));
        labelTargetPolSys.setName("labelTargetPolSys");
        labelTargetPolSys.setSize(new SizeF(13, 91));
        labelTargetPolSys.setTabIndex(15);
        labelTargetPolSys.setText("Communist State");
        // labelTargetSize
        labelTargetSize.setLocation(new Point(88, 32));
        labelTargetSize.setName("labelTargetSize");
        labelTargetSize.setSize(new SizeF(13, 45));
        labelTargetSize.setTabIndex(14);
        labelTargetSize.setText("Medium");
        // labelTargetTech
        labelTargetTech.setLocation(new Point(88, 48));
        labelTargetTech.setName("labelTargetTech");
        labelTargetTech.setSize(new SizeF(13, 82));
        labelTargetTech.setTabIndex(13);
        labelTargetTech.setText("Pre-Agricultural");
        // labelTargetDistance
        labelTargetDistance.setLocation(new Point(88, 128));
        labelTargetDistance.setName("labelTargetDistance");
        labelTargetDistance.setSize(new SizeF(13, 66));
        labelTargetDistance.setTabIndex(12);
        labelTargetDistance.setText("888 parsecs");
        // labelTargetPirates
        labelTargetPirates.setLocation(new Point(88, 112));
        labelTargetPirates.setName("labelTargetPirates");
        labelTargetPirates.setSize(new SizeF(13, 53));
        labelTargetPirates.setTabIndex(11);
        labelTargetPirates.setText("Abundant");
        // labelTargetPolice
        labelTargetPolice.setLocation(new Point(88, 96));
        labelTargetPolice.setName("labelTargetPolice");
        labelTargetPolice.setSize(new SizeF(13, 53));
        labelTargetPolice.setTabIndex(10);
        labelTargetPolice.setText("Abundant");
        // labelTargetResource
        labelTargetResource.setLocation(new Point(88, 80));
        labelTargetResource.setName("labelTargetResource");
        labelTargetResource.setSize(new SizeF(13, 105));
        labelTargetResource.setTabIndex(9);
        labelTargetResource.setText("Sweetwater Oceans");
        // labelTargetDistanceLabel
        labelTargetDistanceLabel.setAutoSize(true);
        labelTargetDistanceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetDistanceLabel.setLocation(new Point(8, 128));
        labelTargetDistanceLabel.setName("labelTargetDistanceLabel");
        labelTargetDistanceLabel.setSize(new SizeF(16, 53));
        labelTargetDistanceLabel.setTabIndex(8);
        labelTargetDistanceLabel.setText("Distance:");
        // labelTargetPiratesLabel
        labelTargetPiratesLabel.setAutoSize(true);
        labelTargetPiratesLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetPiratesLabel.setLocation(new Point(8, 112));
        labelTargetPiratesLabel.setName("labelTargetPiratesLabel");
        labelTargetPiratesLabel.setSize(new SizeF(16, 44));
        labelTargetPiratesLabel.setTabIndex(7);
        labelTargetPiratesLabel.setText("Pirates:");
        // labelTargetPoliceLabel
        labelTargetPoliceLabel.setAutoSize(true);
        labelTargetPoliceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetPoliceLabel.setLocation(new Point(8, 96));
        labelTargetPoliceLabel.setName("labelTargetPoliceLabel");
        labelTargetPoliceLabel.setSize(new SizeF(16, 40));
        labelTargetPoliceLabel.setTabIndex(6);
        labelTargetPoliceLabel.setText("Police:");
        // labelTargetResourceLabel
        labelTargetResourceLabel.setAutoSize(true);
        labelTargetResourceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetResourceLabel.setLocation(new Point(8, 80));
        labelTargetResourceLabel.setName("labelTargetResourceLabel");
        labelTargetResourceLabel.setSize(new SizeF(16, 58));
        labelTargetResourceLabel.setTabIndex(5);
        labelTargetResourceLabel.setText("Resource:");
        // labelTargetGovtLabel
        labelTargetGovtLabel.setAutoSize(true);
        labelTargetGovtLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetGovtLabel.setLocation(new Point(8, 64));
        labelTargetGovtLabel.setName("labelTargetGovtLabel");
        labelTargetGovtLabel.setSize(new SizeF(16, 72));
        labelTargetGovtLabel.setTabIndex(4);
        labelTargetGovtLabel.setText("Government:");
        // labelTargetTechLabel
        labelTargetTechLabel.setAutoSize(true);
        labelTargetTechLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetTechLabel.setLocation(new Point(8, 48));
        labelTargetTechLabel.setName("labelTargetTechLabel");
        labelTargetTechLabel.setSize(new SizeF(16, 65));
        labelTargetTechLabel.setTabIndex(3);
        labelTargetTechLabel.setText("Tech Level:");
        // labelTargetSizeLabel
        labelTargetSizeLabel.setAutoSize(true);
        labelTargetSizeLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetSizeLabel.setLocation(new Point(8, 32));
        labelTargetSizeLabel.setName("labelTargetSizeLabel");
        labelTargetSizeLabel.setSize(new SizeF(16, 31));
        labelTargetSizeLabel.setTabIndex(2);
        labelTargetSizeLabel.setText("Size:");
        // labelTargetName
        labelTargetName.setLocation(new Point(88, 16));
        labelTargetName.setName("labelTargetName");
        labelTargetName.setSize(new SizeF(13, 65));
        labelTargetName.setTabIndex(1);
        labelTargetName.setText("Tarchannen");
        // labelTargetNameLabel
        labelTargetNameLabel.setAutoSize(true);
        labelTargetNameLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTargetNameLabel.setLocation(new Point(8, 16));
        labelTargetNameLabel.setName("labelTargetNameLabel");
        labelTargetNameLabel.setSize(new SizeF(16, 39));
        labelTargetNameLabel.setTabIndex(0);
        labelTargetNameLabel.setText("Name:");
        // boxCargo
        boxCargo.Anchor = AnchorStyles.Top_Right;
        boxCargo.Controls.add(pictureCargoLine3);
        boxCargo.Controls.add(pictureCargoLine2);
        boxCargo.Controls.add(pictureCargoLine0);
        boxCargo.Controls.add(pictureCargoLine1);
        boxCargo.Controls.add(labelTargetPct9);
        boxCargo.Controls.add(labelTargetDiff9);
        boxCargo.Controls.add(labelTargetPrice9);
        boxCargo.Controls.add(buttonBuyMax9);
        boxCargo.Controls.add(buttonBuyQty9);
        boxCargo.Controls.add(labelBuyPrice9);
        boxCargo.Controls.add(buttonSellAll9);
        boxCargo.Controls.add(buttonSellQty9);
        boxCargo.Controls.add(labelSellPrice9);
        boxCargo.Controls.add(labelTargetPct8);
        boxCargo.Controls.add(labelTargetDiff8);
        boxCargo.Controls.add(labelTargetPrice8);
        boxCargo.Controls.add(buttonBuyMax8);
        boxCargo.Controls.add(buttonBuyQty8);
        boxCargo.Controls.add(labelBuyPrice8);
        boxCargo.Controls.add(buttonSellAll8);
        boxCargo.Controls.add(buttonSellQty8);
        boxCargo.Controls.add(labelSellPrice8);
        boxCargo.Controls.add(labelTargetPct7);
        boxCargo.Controls.add(labelTargetDiff7);
        boxCargo.Controls.add(labelTargetPrice7);
        boxCargo.Controls.add(buttonBuyMax7);
        boxCargo.Controls.add(buttonBuyQty7);
        boxCargo.Controls.add(labelBuyPrice7);
        boxCargo.Controls.add(buttonSellAll7);
        boxCargo.Controls.add(buttonSellQty7);
        boxCargo.Controls.add(labelSellPrice7);
        boxCargo.Controls.add(labelTargetPct6);
        boxCargo.Controls.add(labelTargetDiff6);
        boxCargo.Controls.add(labelTargetPrice6);
        boxCargo.Controls.add(buttonBuyMax6);
        boxCargo.Controls.add(buttonBuyQty6);
        boxCargo.Controls.add(labelBuyPrice6);
        boxCargo.Controls.add(buttonSellAll6);
        boxCargo.Controls.add(buttonSellQty6);
        boxCargo.Controls.add(labelSellPrice6);
        boxCargo.Controls.add(labelTargetPct5);
        boxCargo.Controls.add(labelTargetDiff5);
        boxCargo.Controls.add(labelTargetPrice5);
        boxCargo.Controls.add(buttonBuyMax5);
        boxCargo.Controls.add(buttonBuyQty5);
        boxCargo.Controls.add(labelBuyPrice5);
        boxCargo.Controls.add(buttonSellAll5);
        boxCargo.Controls.add(buttonSellQty5);
        boxCargo.Controls.add(labelSellPrice5);
        boxCargo.Controls.add(labelTargetPct4);
        boxCargo.Controls.add(labelTargetDiff4);
        boxCargo.Controls.add(labelTargetPrice4);
        boxCargo.Controls.add(buttonBuyMax4);
        boxCargo.Controls.add(buttonBuyQty4);
        boxCargo.Controls.add(labelBuyPrice4);
        boxCargo.Controls.add(buttonSellAll4);
        boxCargo.Controls.add(buttonSellQty4);
        boxCargo.Controls.add(labelSellPrice4);
        boxCargo.Controls.add(labelTargetPct3);
        boxCargo.Controls.add(labelTargetDiff3);
        boxCargo.Controls.add(labelTargetPrice3);
        boxCargo.Controls.add(buttonBuyMax3);
        boxCargo.Controls.add(buttonBuyQty3);
        boxCargo.Controls.add(labelBuyPrice3);
        boxCargo.Controls.add(buttonSellAll3);
        boxCargo.Controls.add(buttonSellQty3);
        boxCargo.Controls.add(labelSellPrice3);
        boxCargo.Controls.add(labelTargetPct2);
        boxCargo.Controls.add(labelTargetDiff2);
        boxCargo.Controls.add(labelTargetPrice2);
        boxCargo.Controls.add(buttonBuyMax2);
        boxCargo.Controls.add(buttonBuyQty2);
        boxCargo.Controls.add(labelBuyPrice2);
        boxCargo.Controls.add(buttonSellAll2);
        boxCargo.Controls.add(buttonSellQty2);
        boxCargo.Controls.add(labelSellPrice2);
        boxCargo.Controls.add(labelTargetPct1);
        boxCargo.Controls.add(labelTargetDiff1);
        boxCargo.Controls.add(labelTargetPrice1);
        boxCargo.Controls.add(buttonBuyMax1);
        boxCargo.Controls.add(buttonBuyQty1);
        boxCargo.Controls.add(labelBuyPrice1);
        boxCargo.Controls.add(labelTargetPctLabel);
        boxCargo.Controls.add(labelTargetDiffLabel);
        boxCargo.Controls.add(labelTargetPriceLabel);
        boxCargo.Controls.add(labelTargetPct0);
        boxCargo.Controls.add(labelTargetDiff0);
        boxCargo.Controls.add(labelTargetPrice0);
        boxCargo.Controls.add(buttonBuyMax0);
        boxCargo.Controls.add(buttonBuyQty0);
        boxCargo.Controls.add(labelBuyPrice0);
        boxCargo.Controls.add(buttonSellAll1);
        boxCargo.Controls.add(buttonSellQty1);
        boxCargo.Controls.add(labelSellPrice1);
        boxCargo.Controls.add(buttonSellAll0);
        boxCargo.Controls.add(buttonSellQty0);
        boxCargo.Controls.add(labelSellPrice0);
        boxCargo.Controls.add(labelTradeTarget);
        boxCargo.Controls.add(labelBuy);
        boxCargo.Controls.add(labelSell);
        boxCargo.Controls.add(labelTradeCommodity9);
        boxCargo.Controls.add(labelTradeCommodity8);
        boxCargo.Controls.add(labelTradeCommodity2);
        boxCargo.Controls.add(labelTradeCommodity0);
        boxCargo.Controls.add(labelTradeCommodity1);
        boxCargo.Controls.add(labelTradeCommodity6);
        boxCargo.Controls.add(labelTradeCommodity5);
        boxCargo.Controls.add(labelTradeCommodity4);
        boxCargo.Controls.add(labelTradeCommodity3);
        boxCargo.Controls.add(labelTradeCommodity7);
        boxCargo.setLocation(new Point(252, 2));
        boxCargo.setName("boxCargo");
        boxCargo.setSize(new SizeF(300, 512));
        boxCargo.setTabIndex(8);
        boxCargo.setTabStop(false);
        boxCargo.setText("Cargo");
        // pictureCargoLine3
        pictureCargoLine3.setBackColor(Color.darkGray);
        pictureCargoLine3.setLocation(new Point(8, 52));
        pictureCargoLine3.setName("pictureCargoLine3");
        pictureCargoLine3.setSize(new SizeF(1, 496));
        pictureCargoLine3.setTabIndex(131);
        pictureCargoLine3.setTabStop(false);
        // pictureCargoLine2
        pictureCargoLine2.setBackColor(Color.darkGray);
        pictureCargoLine2.setLocation(new Point(352, 32));
        pictureCargoLine2.setName("pictureCargoLine2");
        pictureCargoLine2.setSize(new SizeF(262, 1));
        pictureCargoLine2.setTabIndex(130);
        pictureCargoLine2.setTabStop(false);
        // pictureCargoLine0
        pictureCargoLine0.setBackColor(Color.darkGray);
        pictureCargoLine0.setLocation(new Point(71, 32));
        pictureCargoLine0.setName("pictureCargoLine0");
        pictureCargoLine0.setSize(new SizeF(262, 1));
        pictureCargoLine0.setTabIndex(129);
        pictureCargoLine0.setTabStop(false);
        // pictureCargoLine1
        pictureCargoLine1.setBackColor(Color.darkGray);
        pictureCargoLine1.setLocation(new Point(218, 32));
        pictureCargoLine1.setName("pictureCargoLine1");
        pictureCargoLine1.setSize(new SizeF(262, 1));
        pictureCargoLine1.setTabIndex(128);
        pictureCargoLine1.setTabStop(false);
        // labelTargetPct9
        labelTargetPct9.setLocation(new Point(466, 276));
        labelTargetPct9.setName("labelTargetPct9");
        labelTargetPct9.setSize(new SizeF(13, 37));
        labelTargetPct9.setTabIndex(127);
        labelTargetPct9.setText("--------");
        labelTargetPct9.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff9
        labelTargetDiff9.setLocation(new Point(410, 276));
        labelTargetDiff9.setName("labelTargetDiff9");
        labelTargetDiff9.setSize(new SizeF(13, 52));
        labelTargetDiff9.setTabIndex(126);
        labelTargetDiff9.setText("------------");
        labelTargetDiff9.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice9
        labelTargetPrice9.setLocation(new Point(358, 276));
        labelTargetPrice9.setName("labelTargetPrice9");
        labelTargetPrice9.setSize(new SizeF(13, 48));
        labelTargetPrice9.setTabIndex(125);
        labelTargetPrice9.setText("-----------");
        labelTargetPrice9.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax9
        buttonBuyMax9.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax9.setLocation(new Point(262, 272));
        buttonBuyMax9.setName("buttonBuyMax9");
        buttonBuyMax9.setSize(new SizeF(22, 36));
        buttonBuyMax9.setTabIndex(51);
        buttonBuyMax9.setText("Max");
        buttonBuyMax9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty9
        buttonBuyQty9.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty9.setLocation(new Point(227, 272));
        buttonBuyQty9.setName("buttonBuyQty9");
        buttonBuyQty9.setSize(new SizeF(22, 28));
        buttonBuyQty9.setTabIndex(50);
        buttonBuyQty9.setText("88");
        buttonBuyQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice9
        labelBuyPrice9.setLocation(new Point(302, 276));
        labelBuyPrice9.setName("labelBuyPrice9");
        labelBuyPrice9.setSize(new SizeF(13, 48));
        labelBuyPrice9.setTabIndex(122);
        labelBuyPrice9.setText("not sold");
        labelBuyPrice9.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll9
        buttonSellAll9.setFlatStyle(FlatStyle.Flat);
        buttonSellAll9.setLocation(new Point(115, 272));
        buttonSellAll9.setName("buttonSellAll9");
        buttonSellAll9.setSize(new SizeF(22, 44));
        buttonSellAll9.setTabIndex(49);
        buttonSellAll9.setText("Dump");
        buttonSellAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty9
        buttonSellQty9.setFlatStyle(FlatStyle.Flat);
        buttonSellQty9.setLocation(new Point(80, 272));
        buttonSellQty9.setName("buttonSellQty9");
        buttonSellQty9.setSize(new SizeF(22, 28));
        buttonSellQty9.setTabIndex(48);
        buttonSellQty9.setText("88");
        buttonSellQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice9
        labelSellPrice9.setLocation(new Point(163, 276));
        labelSellPrice9.setName("labelSellPrice9");
        labelSellPrice9.setSize(new SizeF(13, 48));
        labelSellPrice9.setTabIndex(119);
        labelSellPrice9.setText("no trade");
        labelSellPrice9.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct8
        labelTargetPct8.setLocation(new Point(466, 252));
        labelTargetPct8.setName("labelTargetPct8");
        labelTargetPct8.setSize(new SizeF(13, 37));
        labelTargetPct8.setTabIndex(118);
        labelTargetPct8.setText("-888%");
        labelTargetPct8.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff8
        labelTargetDiff8.setLocation(new Point(410, 252));
        labelTargetDiff8.setName("labelTargetDiff8");
        labelTargetDiff8.setSize(new SizeF(13, 52));
        labelTargetDiff8.setTabIndex(117);
        labelTargetDiff8.setText("-8,888 cr.");
        labelTargetDiff8.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice8
        labelTargetPrice8.setLocation(new Point(358, 252));
        labelTargetPrice8.setName("labelTargetPrice8");
        labelTargetPrice8.setSize(new SizeF(13, 48));
        labelTargetPrice8.setTabIndex(116);
        labelTargetPrice8.setText("8,888 cr.");
        labelTargetPrice8.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax8
        buttonBuyMax8.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax8.setLocation(new Point(262, 248));
        buttonBuyMax8.setName("buttonBuyMax8");
        buttonBuyMax8.setSize(new SizeF(22, 36));
        buttonBuyMax8.setTabIndex(47);
        buttonBuyMax8.setText("Max");
        buttonBuyMax8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty8
        buttonBuyQty8.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty8.setLocation(new Point(227, 248));
        buttonBuyQty8.setName("buttonBuyQty8");
        buttonBuyQty8.setSize(new SizeF(22, 28));
        buttonBuyQty8.setTabIndex(46);
        buttonBuyQty8.setText("88");
        buttonBuyQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice8
        labelBuyPrice8.setLocation(new Point(302, 252));
        labelBuyPrice8.setName("labelBuyPrice8");
        labelBuyPrice8.setSize(new SizeF(13, 48));
        labelBuyPrice8.setTabIndex(113);
        labelBuyPrice8.setText("8,888 cr.");
        labelBuyPrice8.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll8
        buttonSellAll8.setFlatStyle(FlatStyle.Flat);
        buttonSellAll8.setLocation(new Point(115, 248));
        buttonSellAll8.setName("buttonSellAll8");
        buttonSellAll8.setSize(new SizeF(22, 44));
        buttonSellAll8.setTabIndex(45);
        buttonSellAll8.setText("All");
        buttonSellAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty8
        buttonSellQty8.setFlatStyle(FlatStyle.Flat);
        buttonSellQty8.setLocation(new Point(80, 248));
        buttonSellQty8.setName("buttonSellQty8");
        buttonSellQty8.setSize(new SizeF(22, 28));
        buttonSellQty8.setTabIndex(44);
        buttonSellQty8.setText("88");
        buttonSellQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice8
        labelSellPrice8.setLocation(new Point(163, 252));
        labelSellPrice8.setName("labelSellPrice8");
        labelSellPrice8.setSize(new SizeF(13, 48));
        labelSellPrice8.setTabIndex(110);
        labelSellPrice8.setText("8,888 cr.");
        labelSellPrice8.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct7
        labelTargetPct7.setLocation(new Point(466, 228));
        labelTargetPct7.setName("labelTargetPct7");
        labelTargetPct7.setSize(new SizeF(13, 37));
        labelTargetPct7.setTabIndex(109);
        labelTargetPct7.setText("-888%");
        labelTargetPct7.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff7
        labelTargetDiff7.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Regular, GraphicsUnit.Point, ((byte) (0))));
        labelTargetDiff7.setLocation(new Point(410, 228));
        labelTargetDiff7.setName("labelTargetDiff7");
        labelTargetDiff7.setSize(new SizeF(13, 52));
        labelTargetDiff7.setTabIndex(108);
        labelTargetDiff7.setText("-8,888 cr.");
        labelTargetDiff7.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice7
        labelTargetPrice7.setLocation(new Point(358, 228));
        labelTargetPrice7.setName("labelTargetPrice7");
        labelTargetPrice7.setSize(new SizeF(13, 48));
        labelTargetPrice7.setTabIndex(107);
        labelTargetPrice7.setText("8,888 cr.");
        labelTargetPrice7.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax7
        buttonBuyMax7.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax7.setLocation(new Point(262, 224));
        buttonBuyMax7.setName("buttonBuyMax7");
        buttonBuyMax7.setSize(new SizeF(22, 36));
        buttonBuyMax7.setTabIndex(43);
        buttonBuyMax7.setText("Max");
        buttonBuyMax7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty7
        buttonBuyQty7.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty7.setLocation(new Point(227, 224));
        buttonBuyQty7.setName("buttonBuyQty7");
        buttonBuyQty7.setSize(new SizeF(22, 28));
        buttonBuyQty7.setTabIndex(42);
        buttonBuyQty7.setText("88");
        buttonBuyQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice7
        labelBuyPrice7.setLocation(new Point(302, 228));
        labelBuyPrice7.setName("labelBuyPrice7");
        labelBuyPrice7.setSize(new SizeF(13, 48));
        labelBuyPrice7.setTabIndex(104);
        labelBuyPrice7.setText("8,888 cr.");
        labelBuyPrice7.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll7
        buttonSellAll7.setFlatStyle(FlatStyle.Flat);
        buttonSellAll7.setLocation(new Point(115, 224));
        buttonSellAll7.setName("buttonSellAll7");
        buttonSellAll7.setSize(new SizeF(22, 44));
        buttonSellAll7.setTabIndex(41);
        buttonSellAll7.setText("All");
        buttonSellAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty7
        buttonSellQty7.setFlatStyle(FlatStyle.Flat);
        buttonSellQty7.setLocation(new Point(80, 224));
        buttonSellQty7.setName("buttonSellQty7");
        buttonSellQty7.setSize(new SizeF(22, 28));
        buttonSellQty7.setTabIndex(40);
        buttonSellQty7.setText("88");
        buttonSellQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice7
        labelSellPrice7.setLocation(new Point(163, 228));
        labelSellPrice7.setName("labelSellPrice7");
        labelSellPrice7.setSize(new SizeF(13, 48));
        labelSellPrice7.setTabIndex(101);
        labelSellPrice7.setText("8,888 cr.");
        labelSellPrice7.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct6
        labelTargetPct6.setLocation(new Point(466, 204));
        labelTargetPct6.setName("labelTargetPct6");
        labelTargetPct6.setSize(new SizeF(13, 37));
        labelTargetPct6.setTabIndex(100);
        labelTargetPct6.setText("-888%");
        labelTargetPct6.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff6
        labelTargetDiff6.setLocation(new Point(410, 204));
        labelTargetDiff6.setName("labelTargetDiff6");
        labelTargetDiff6.setSize(new SizeF(13, 52));
        labelTargetDiff6.setTabIndex(99);
        labelTargetDiff6.setText("-8,888 cr.");
        labelTargetDiff6.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice6
        labelTargetPrice6.setLocation(new Point(358, 204));
        labelTargetPrice6.setName("labelTargetPrice6");
        labelTargetPrice6.setSize(new SizeF(13, 48));
        labelTargetPrice6.setTabIndex(98);
        labelTargetPrice6.setText("8,888 cr.");
        labelTargetPrice6.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax6
        buttonBuyMax6.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax6.setLocation(new Point(262, 200));
        buttonBuyMax6.setName("buttonBuyMax6");
        buttonBuyMax6.setSize(new SizeF(22, 36));
        buttonBuyMax6.setTabIndex(39);
        buttonBuyMax6.setText("Max");
        buttonBuyMax6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty6
        buttonBuyQty6.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty6.setLocation(new Point(227, 200));
        buttonBuyQty6.setName("buttonBuyQty6");
        buttonBuyQty6.setSize(new SizeF(22, 28));
        buttonBuyQty6.setTabIndex(38);
        buttonBuyQty6.setText("88");
        buttonBuyQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice6
        labelBuyPrice6.setLocation(new Point(302, 204));
        labelBuyPrice6.setName("labelBuyPrice6");
        labelBuyPrice6.setSize(new SizeF(13, 48));
        labelBuyPrice6.setTabIndex(95);
        labelBuyPrice6.setText("8,888 cr.");
        labelBuyPrice6.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll6
        buttonSellAll6.setFlatStyle(FlatStyle.Flat);
        buttonSellAll6.setLocation(new Point(115, 200));
        buttonSellAll6.setName("buttonSellAll6");
        buttonSellAll6.setSize(new SizeF(22, 44));
        buttonSellAll6.setTabIndex(37);
        buttonSellAll6.setText("All");
        buttonSellAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty6
        buttonSellQty6.setFlatStyle(FlatStyle.Flat);
        buttonSellQty6.setLocation(new Point(80, 200));
        buttonSellQty6.setName("buttonSellQty6");
        buttonSellQty6.setSize(new SizeF(22, 28));
        buttonSellQty6.setTabIndex(36);
        buttonSellQty6.setText("88");
        buttonSellQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice6
        labelSellPrice6.setLocation(new Point(163, 204));
        labelSellPrice6.setName("labelSellPrice6");
        labelSellPrice6.setSize(new SizeF(13, 48));
        labelSellPrice6.setTabIndex(92);
        labelSellPrice6.setText("8,888 cr.");
        labelSellPrice6.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct5
        labelTargetPct5.setLocation(new Point(466, 180));
        labelTargetPct5.setName("labelTargetPct5");
        labelTargetPct5.setSize(new SizeF(13, 37));
        labelTargetPct5.setTabIndex(91);
        labelTargetPct5.setText("-888%");
        labelTargetPct5.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff5
        labelTargetDiff5.setLocation(new Point(410, 180));
        labelTargetDiff5.setName("labelTargetDiff5");
        labelTargetDiff5.setSize(new SizeF(13, 52));
        labelTargetDiff5.setTabIndex(90);
        labelTargetDiff5.setText("-8,888 cr.");
        labelTargetDiff5.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice5
        labelTargetPrice5.setLocation(new Point(358, 180));
        labelTargetPrice5.setName("labelTargetPrice5");
        labelTargetPrice5.setSize(new SizeF(13, 48));
        labelTargetPrice5.setTabIndex(89);
        labelTargetPrice5.setText("8,888 cr.");
        labelTargetPrice5.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax5
        buttonBuyMax5.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax5.setLocation(new Point(262, 176));
        buttonBuyMax5.setName("buttonBuyMax5");
        buttonBuyMax5.setSize(new SizeF(22, 36));
        buttonBuyMax5.setTabIndex(35);
        buttonBuyMax5.setText("Max");
        buttonBuyMax5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty5
        buttonBuyQty5.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty5.setLocation(new Point(227, 176));
        buttonBuyQty5.setName("buttonBuyQty5");
        buttonBuyQty5.setSize(new SizeF(22, 28));
        buttonBuyQty5.setTabIndex(34);
        buttonBuyQty5.setText("88");
        buttonBuyQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice5
        labelBuyPrice5.setLocation(new Point(302, 180));
        labelBuyPrice5.setName("labelBuyPrice5");
        labelBuyPrice5.setSize(new SizeF(13, 48));
        labelBuyPrice5.setTabIndex(86);
        labelBuyPrice5.setText("8,888 cr.");
        labelBuyPrice5.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll5
        buttonSellAll5.setFlatStyle(FlatStyle.Flat);
        buttonSellAll5.setLocation(new Point(115, 176));
        buttonSellAll5.setName("buttonSellAll5");
        buttonSellAll5.setSize(new SizeF(22, 44));
        buttonSellAll5.setTabIndex(33);
        buttonSellAll5.setText("All");
        buttonSellAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty5
        buttonSellQty5.setFlatStyle(FlatStyle.Flat);
        buttonSellQty5.setLocation(new Point(80, 176));
        buttonSellQty5.setName("buttonSellQty5");
        buttonSellQty5.setSize(new SizeF(22, 28));
        buttonSellQty5.setTabIndex(32);
        buttonSellQty5.setText("88");
        buttonSellQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice5
        labelSellPrice5.setLocation(new Point(163, 180));
        labelSellPrice5.setName("labelSellPrice5");
        labelSellPrice5.setSize(new SizeF(13, 48));
        labelSellPrice5.setTabIndex(83);
        labelSellPrice5.setText("8,888 cr.");
        labelSellPrice5.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct4
        labelTargetPct4.setLocation(new Point(466, 156));
        labelTargetPct4.setName("labelTargetPct4");
        labelTargetPct4.setSize(new SizeF(13, 37));
        labelTargetPct4.setTabIndex(82);
        labelTargetPct4.setText("-888%");
        labelTargetPct4.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff4
        labelTargetDiff4.setLocation(new Point(410, 156));
        labelTargetDiff4.setName("labelTargetDiff4");
        labelTargetDiff4.setSize(new SizeF(13, 52));
        labelTargetDiff4.setTabIndex(81);
        labelTargetDiff4.setText("-8,888 cr.");
        labelTargetDiff4.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice4
        labelTargetPrice4.setLocation(new Point(358, 156));
        labelTargetPrice4.setName("labelTargetPrice4");
        labelTargetPrice4.setSize(new SizeF(13, 48));
        labelTargetPrice4.setTabIndex(80);
        labelTargetPrice4.setText("8,888 cr.");
        labelTargetPrice4.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax4
        buttonBuyMax4.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax4.setLocation(new Point(262, 152));
        buttonBuyMax4.setName("buttonBuyMax4");
        buttonBuyMax4.setSize(new SizeF(22, 36));
        buttonBuyMax4.setTabIndex(31);
        buttonBuyMax4.setText("Max");
        buttonBuyMax4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty4
        buttonBuyQty4.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty4.setLocation(new Point(227, 152));
        buttonBuyQty4.setName("buttonBuyQty4");
        buttonBuyQty4.setSize(new SizeF(22, 28));
        buttonBuyQty4.setTabIndex(30);
        buttonBuyQty4.setText("88");
        buttonBuyQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice4
        labelBuyPrice4.setLocation(new Point(302, 156));
        labelBuyPrice4.setName("labelBuyPrice4");
        labelBuyPrice4.setSize(new SizeF(13, 48));
        labelBuyPrice4.setTabIndex(77);
        labelBuyPrice4.setText("8,888 cr.");
        labelBuyPrice4.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll4
        buttonSellAll4.setFlatStyle(FlatStyle.Flat);
        buttonSellAll4.setLocation(new Point(115, 152));
        buttonSellAll4.setName("buttonSellAll4");
        buttonSellAll4.setSize(new SizeF(22, 44));
        buttonSellAll4.setTabIndex(29);
        buttonSellAll4.setText("All");
        buttonSellAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty4
        buttonSellQty4.setFlatStyle(FlatStyle.Flat);
        buttonSellQty4.setLocation(new Point(80, 152));
        buttonSellQty4.setName("buttonSellQty4");
        buttonSellQty4.setSize(new SizeF(22, 28));
        buttonSellQty4.setTabIndex(28);
        buttonSellQty4.setText("88");
        buttonSellQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice4
        labelSellPrice4.setLocation(new Point(163, 156));
        labelSellPrice4.setName("labelSellPrice4");
        labelSellPrice4.setSize(new SizeF(13, 48));
        labelSellPrice4.setTabIndex(74);
        labelSellPrice4.setText("8,888 cr.");
        labelSellPrice4.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct3
        labelTargetPct3.setLocation(new Point(466, 132));
        labelTargetPct3.setName("labelTargetPct3");
        labelTargetPct3.setSize(new SizeF(13, 37));
        labelTargetPct3.setTabIndex(73);
        labelTargetPct3.setText("-888%");
        labelTargetPct3.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff3
        labelTargetDiff3.setLocation(new Point(410, 132));
        labelTargetDiff3.setName("labelTargetDiff3");
        labelTargetDiff3.setSize(new SizeF(13, 52));
        labelTargetDiff3.setTabIndex(72);
        labelTargetDiff3.setText("-8,888 cr.");
        labelTargetDiff3.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice3
        labelTargetPrice3.setLocation(new Point(358, 132));
        labelTargetPrice3.setName("labelTargetPrice3");
        labelTargetPrice3.setSize(new SizeF(13, 48));
        labelTargetPrice3.setTabIndex(71);
        labelTargetPrice3.setText("8,888 cr.");
        labelTargetPrice3.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax3
        buttonBuyMax3.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax3.setLocation(new Point(262, 128));
        buttonBuyMax3.setName("buttonBuyMax3");
        buttonBuyMax3.setSize(new SizeF(22, 36));
        buttonBuyMax3.setTabIndex(27);
        buttonBuyMax3.setText("Max");
        buttonBuyMax3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty3
        buttonBuyQty3.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty3.setLocation(new Point(227, 128));
        buttonBuyQty3.setName("buttonBuyQty3");
        buttonBuyQty3.setSize(new SizeF(22, 28));
        buttonBuyQty3.setTabIndex(26);
        buttonBuyQty3.setText("88");
        buttonBuyQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice3
        labelBuyPrice3.setLocation(new Point(302, 132));
        labelBuyPrice3.setName("labelBuyPrice3");
        labelBuyPrice3.setSize(new SizeF(13, 48));
        labelBuyPrice3.setTabIndex(68);
        labelBuyPrice3.setText("8,888 cr.");
        labelBuyPrice3.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll3
        buttonSellAll3.setFlatStyle(FlatStyle.Flat);
        buttonSellAll3.setLocation(new Point(115, 128));
        buttonSellAll3.setName("buttonSellAll3");
        buttonSellAll3.setSize(new SizeF(22, 44));
        buttonSellAll3.setTabIndex(25);
        buttonSellAll3.setText("All");
        buttonSellAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty3
        buttonSellQty3.setFlatStyle(FlatStyle.Flat);
        buttonSellQty3.setLocation(new Point(80, 128));
        buttonSellQty3.setName("buttonSellQty3");
        buttonSellQty3.setSize(new SizeF(22, 28));
        buttonSellQty3.setTabIndex(24);
        buttonSellQty3.setText("88");
        buttonSellQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice3
        labelSellPrice3.setLocation(new Point(163, 132));
        labelSellPrice3.setName("labelSellPrice3");
        labelSellPrice3.setSize(new SizeF(13, 48));
        labelSellPrice3.setTabIndex(65);
        labelSellPrice3.setText("8,888 cr.");
        labelSellPrice3.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct2
        labelTargetPct2.setLocation(new Point(466, 108));
        labelTargetPct2.setName("labelTargetPct2");
        labelTargetPct2.setSize(new SizeF(13, 37));
        labelTargetPct2.setTabIndex(64);
        labelTargetPct2.setText("-888%");
        labelTargetPct2.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff2
        labelTargetDiff2.setLocation(new Point(410, 108));
        labelTargetDiff2.setName("labelTargetDiff2");
        labelTargetDiff2.setSize(new SizeF(13, 52));
        labelTargetDiff2.setTabIndex(63);
        labelTargetDiff2.setText("-8,888 cr.");
        labelTargetDiff2.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice2
        labelTargetPrice2.setLocation(new Point(358, 108));
        labelTargetPrice2.setName("labelTargetPrice2");
        labelTargetPrice2.setSize(new SizeF(13, 48));
        labelTargetPrice2.setTabIndex(62);
        labelTargetPrice2.setText("8,888 cr.");
        labelTargetPrice2.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax2
        buttonBuyMax2.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax2.setLocation(new Point(262, 104));
        buttonBuyMax2.setName("buttonBuyMax2");
        buttonBuyMax2.setSize(new SizeF(22, 36));
        buttonBuyMax2.setTabIndex(23);
        buttonBuyMax2.setText("Max");
        buttonBuyMax2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty2
        buttonBuyQty2.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty2.setLocation(new Point(227, 104));
        buttonBuyQty2.setName("buttonBuyQty2");
        buttonBuyQty2.setSize(new SizeF(22, 28));
        buttonBuyQty2.setTabIndex(22);
        buttonBuyQty2.setText("88");
        buttonBuyQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice2
        labelBuyPrice2.setLocation(new Point(302, 108));
        labelBuyPrice2.setName("labelBuyPrice2");
        labelBuyPrice2.setSize(new SizeF(13, 48));
        labelBuyPrice2.setTabIndex(59);
        labelBuyPrice2.setText("8,888 cr.");
        labelBuyPrice2.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll2
        buttonSellAll2.setFlatStyle(FlatStyle.Flat);
        buttonSellAll2.setLocation(new Point(115, 104));
        buttonSellAll2.setName("buttonSellAll2");
        buttonSellAll2.setSize(new SizeF(22, 44));
        buttonSellAll2.setTabIndex(21);
        buttonSellAll2.setText("All");
        buttonSellAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty2
        buttonSellQty2.setFlatStyle(FlatStyle.Flat);
        buttonSellQty2.setLocation(new Point(80, 104));
        buttonSellQty2.setName("buttonSellQty2");
        buttonSellQty2.setSize(new SizeF(22, 28));
        buttonSellQty2.setTabIndex(20);
        buttonSellQty2.setText("88");
        buttonSellQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice2
        labelSellPrice2.setLocation(new Point(163, 108));
        labelSellPrice2.setName("labelSellPrice2");
        labelSellPrice2.setSize(new SizeF(13, 48));
        labelSellPrice2.setTabIndex(56);
        labelSellPrice2.setText("8,888 cr.");
        labelSellPrice2.TextAlign = ContentAlignment.TopRight;
        // labelTargetPct1
        labelTargetPct1.setLocation(new Point(466, 84));
        labelTargetPct1.setName("labelTargetPct1");
        labelTargetPct1.setSize(new SizeF(13, 37));
        labelTargetPct1.setTabIndex(55);
        labelTargetPct1.setText("-888%");
        labelTargetPct1.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff1
        labelTargetDiff1.setLocation(new Point(410, 84));
        labelTargetDiff1.setName("labelTargetDiff1");
        labelTargetDiff1.setSize(new SizeF(13, 52));
        labelTargetDiff1.setTabIndex(54);
        labelTargetDiff1.setText("-8,888 cr.");
        labelTargetDiff1.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice1
        labelTargetPrice1.setLocation(new Point(358, 84));
        labelTargetPrice1.setName("labelTargetPrice1");
        labelTargetPrice1.setSize(new SizeF(13, 48));
        labelTargetPrice1.setTabIndex(53);
        labelTargetPrice1.setText("8,888 cr.");
        labelTargetPrice1.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax1
        buttonBuyMax1.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax1.setLocation(new Point(262, 80));
        buttonBuyMax1.setName("buttonBuyMax1");
        buttonBuyMax1.setSize(new SizeF(22, 36));
        buttonBuyMax1.setTabIndex(19);
        buttonBuyMax1.setText("Max");
        buttonBuyMax1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty1
        buttonBuyQty1.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty1.setLocation(new Point(227, 80));
        buttonBuyQty1.setName("buttonBuyQty1");
        buttonBuyQty1.setSize(new SizeF(22, 28));
        buttonBuyQty1.setTabIndex(18);
        buttonBuyQty1.setText("88");
        buttonBuyQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice1
        labelBuyPrice1.setLocation(new Point(302, 84));
        labelBuyPrice1.setName("labelBuyPrice1");
        labelBuyPrice1.setSize(new SizeF(13, 48));
        labelBuyPrice1.setTabIndex(50);
        labelBuyPrice1.setText("8,888 cr.");
        labelBuyPrice1.TextAlign = ContentAlignment.TopRight;
        // labelTargetPctLabel
        labelTargetPctLabel.setAutoSize(true);
        labelTargetPctLabel.setLocation(new Point(476, 34));
        labelTargetPctLabel.setName("labelTargetPctLabel");
        labelTargetPctLabel.setSize(new SizeF(16, 14));
        labelTargetPctLabel.setTabIndex(49);
        labelTargetPctLabel.setText("%");
        // labelTargetDiffLabel
        labelTargetDiffLabel.setAutoSize(true);
        labelTargetDiffLabel.setLocation(new Point(424, 34));
        labelTargetDiffLabel.setName("labelTargetDiffLabel");
        labelTargetDiffLabel.setSize(new SizeF(16, 18));
        labelTargetDiffLabel.setTabIndex(48);
        labelTargetDiffLabel.setText("+/-");
        // labelTargetPriceLabel
        labelTargetPriceLabel.setAutoSize(true);
        labelTargetPriceLabel.setLocation(new Point(360, 34));
        labelTargetPriceLabel.setName("labelTargetPriceLabel");
        labelTargetPriceLabel.setSize(new SizeF(16, 30));
        labelTargetPriceLabel.setTabIndex(47);
        labelTargetPriceLabel.setText("Price");
        // labelTargetPct0
        labelTargetPct0.setLocation(new Point(466, 60));
        labelTargetPct0.setName("labelTargetPct0");
        labelTargetPct0.setSize(new SizeF(13, 37));
        labelTargetPct0.setTabIndex(46);
        labelTargetPct0.setText("-888%");
        labelTargetPct0.TextAlign = ContentAlignment.TopRight;
        // labelTargetDiff0
        labelTargetDiff0.setLocation(new Point(410, 60));
        labelTargetDiff0.setName("labelTargetDiff0");
        labelTargetDiff0.setSize(new SizeF(13, 52));
        labelTargetDiff0.setTabIndex(45);
        labelTargetDiff0.setText("-8,888 cr.");
        labelTargetDiff0.TextAlign = ContentAlignment.TopRight;
        // labelTargetPrice0
        labelTargetPrice0.setLocation(new Point(358, 60));
        labelTargetPrice0.setName("labelTargetPrice0");
        labelTargetPrice0.setSize(new SizeF(13, 48));
        labelTargetPrice0.setTabIndex(44);
        labelTargetPrice0.setText("8,888 cr.");
        labelTargetPrice0.TextAlign = ContentAlignment.TopRight;
        // buttonBuyMax0
        buttonBuyMax0.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax0.setLocation(new Point(262, 56));
        buttonBuyMax0.setName("buttonBuyMax0");
        buttonBuyMax0.setSize(new SizeF(22, 36));
        buttonBuyMax0.setTabIndex(15);
        buttonBuyMax0.setText("Max");
        buttonBuyMax0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonBuyQty0
        buttonBuyQty0.setFlatStyle(FlatStyle.Flat);
        buttonBuyQty0.setLocation(new Point(227, 56));
        buttonBuyQty0.setName("buttonBuyQty0");
        buttonBuyQty0.setSize(new SizeF(22, 28));
        buttonBuyQty0.setTabIndex(14);
        buttonBuyQty0.setText("88");
        buttonBuyQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelBuyPrice0
        labelBuyPrice0.setLocation(new Point(302, 60));
        labelBuyPrice0.setName("labelBuyPrice0");
        labelBuyPrice0.setSize(new SizeF(13, 48));
        labelBuyPrice0.setTabIndex(41);
        labelBuyPrice0.setText("8,888 cr.");
        labelBuyPrice0.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll1
        buttonSellAll1.setFlatStyle(FlatStyle.Flat);
        buttonSellAll1.setLocation(new Point(115, 80));
        buttonSellAll1.setName("buttonSellAll1");
        buttonSellAll1.setSize(new SizeF(22, 44));
        buttonSellAll1.setTabIndex(17);
        buttonSellAll1.setText("All");
        buttonSellAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty1
        buttonSellQty1.setFlatStyle(FlatStyle.Flat);
        buttonSellQty1.setLocation(new Point(80, 80));
        buttonSellQty1.setName("buttonSellQty1");
        buttonSellQty1.setSize(new SizeF(22, 28));
        buttonSellQty1.setTabIndex(16);
        buttonSellQty1.setText("88");
        buttonSellQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice1
        labelSellPrice1.setLocation(new Point(163, 84));
        labelSellPrice1.setName("labelSellPrice1");
        labelSellPrice1.setSize(new SizeF(13, 48));
        labelSellPrice1.setTabIndex(38);
        labelSellPrice1.setText("8,888 cr.");
        labelSellPrice1.TextAlign = ContentAlignment.TopRight;
        // buttonSellAll0
        buttonSellAll0.setFlatStyle(FlatStyle.Flat);
        buttonSellAll0.setLocation(new Point(115, 56));
        buttonSellAll0.setName("buttonSellAll0");
        buttonSellAll0.setSize(new SizeF(22, 44));
        buttonSellAll0.setTabIndex(13);
        buttonSellAll0.setText("All");
        buttonSellAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // buttonSellQty0
        buttonSellQty0.setFlatStyle(FlatStyle.Flat);
        buttonSellQty0.setLocation(new Point(80, 56));
        buttonSellQty0.setName("buttonSellQty0");
        buttonSellQty0.setSize(new SizeF(22, 28));
        buttonSellQty0.setTabIndex(12);
        buttonSellQty0.setText("88");
        buttonSellQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySell_Click(sender, data);
            }
        });
        // labelSellPrice0
        labelSellPrice0.setLocation(new Point(163, 60));
        labelSellPrice0.setName("labelSellPrice0");
        labelSellPrice0.setSize(new SizeF(13, 48));
        labelSellPrice0.setTabIndex(35);
        labelSellPrice0.setText("8,888 cr.");
        labelSellPrice0.TextAlign = ContentAlignment.TopRight;
        // labelTradeTarget
        labelTradeTarget.setAutoSize(true);
        labelTradeTarget.setLocation(new Point(391, 16));
        labelTradeTarget.setName("labelTradeTarget");
        labelTradeTarget.setSize(new SizeF(16, 78));
        labelTradeTarget.setTabIndex(28);
        labelTradeTarget.setText("Target System");
        // labelBuy
        labelBuy.setAutoSize(true);
        labelBuy.setLocation(new Point(273, 34));
        labelBuy.setName("labelBuy");
        labelBuy.setSize(new SizeF(16, 24));
        labelBuy.setTabIndex(27);
        labelBuy.setText("Buy");
        // labelSell
        labelSell.setAutoSize(true);
        labelSell.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Regular, GraphicsUnit.Point, ((byte) (0))));
        labelSell.setLocation(new Point(132, 34));
        labelSell.setName("labelSell");
        labelSell.setSize(new SizeF(16, 23));
        labelSell.setTabIndex(26);
        labelSell.setText("Sell");
        // labelTradeCommodity9
        labelTradeCommodity9.setAutoSize(true);
        labelTradeCommodity9.setLocation(new Point(8, 276));
        labelTradeCommodity9.setName("labelTradeCommodity9");
        labelTradeCommodity9.setSize(new SizeF(16, 40));
        labelTradeCommodity9.setTabIndex(25);
        labelTradeCommodity9.setText("Robots");
        // labelTradeCommodity8
        labelTradeCommodity8.setAutoSize(true);
        labelTradeCommodity8.setLocation(new Point(8, 252));
        labelTradeCommodity8.setName("labelTradeCommodity8");
        labelTradeCommodity8.setSize(new SizeF(16, 51));
        labelTradeCommodity8.setTabIndex(24);
        labelTradeCommodity8.setText("Narcotics");
        // labelTradeCommodity2
        labelTradeCommodity2.setAutoSize(true);
        labelTradeCommodity2.setLocation(new Point(8, 108));
        labelTradeCommodity2.setName("labelTradeCommodity2");
        labelTradeCommodity2.setSize(new SizeF(16, 30));
        labelTradeCommodity2.setTabIndex(23);
        labelTradeCommodity2.setText("Food");
        // labelTradeCommodity0
        labelTradeCommodity0.setAutoSize(true);
        labelTradeCommodity0.setLocation(new Point(8, 60));
        labelTradeCommodity0.setName("labelTradeCommodity0");
        labelTradeCommodity0.setSize(new SizeF(16, 34));
        labelTradeCommodity0.setTabIndex(22);
        labelTradeCommodity0.setText("Water");
        // labelTradeCommodity1
        labelTradeCommodity1.setAutoSize(true);
        labelTradeCommodity1.setLocation(new Point(8, 84));
        labelTradeCommodity1.setName("labelTradeCommodity1");
        labelTradeCommodity1.setSize(new SizeF(16, 27));
        labelTradeCommodity1.setTabIndex(21);
        labelTradeCommodity1.setText("Furs");
        // labelTradeCommodity6
        labelTradeCommodity6.setAutoSize(true);
        labelTradeCommodity6.setLocation(new Point(8, 204));
        labelTradeCommodity6.setName("labelTradeCommodity6");
        labelTradeCommodity6.setSize(new SizeF(16, 50));
        labelTradeCommodity6.setTabIndex(20);
        labelTradeCommodity6.setText("Medicine");
        // labelTradeCommodity5
        labelTradeCommodity5.setAutoSize(true);
        labelTradeCommodity5.setLocation(new Point(8, 180));
        labelTradeCommodity5.setName("labelTradeCommodity5");
        labelTradeCommodity5.setSize(new SizeF(16, 49));
        labelTradeCommodity5.setTabIndex(19);
        labelTradeCommodity5.setText("Firearms");
        // labelTradeCommodity4
        labelTradeCommodity4.setAutoSize(true);
        labelTradeCommodity4.setLocation(new Point(8, 156));
        labelTradeCommodity4.setName("labelTradeCommodity4");
        labelTradeCommodity4.setSize(new SizeF(16, 41));
        labelTradeCommodity4.setTabIndex(18);
        labelTradeCommodity4.setText("Games");
        // labelTradeCommodity3
        labelTradeCommodity3.setAutoSize(true);
        labelTradeCommodity3.setLocation(new Point(8, 132));
        labelTradeCommodity3.setName("labelTradeCommodity3");
        labelTradeCommodity3.setSize(new SizeF(16, 23));
        labelTradeCommodity3.setTabIndex(17);
        labelTradeCommodity3.setText("Ore");
        // labelTradeCommodity7
        labelTradeCommodity7.setAutoSize(true);
        labelTradeCommodity7.setLocation(new Point(8, 228));
        labelTradeCommodity7.setName("labelTradeCommodity7");
        labelTradeCommodity7.setSize(new SizeF(16, 53));
        labelTradeCommodity7.setTabIndex(16);
        labelTradeCommodity7.setText("Machines");
        // boxSystem
        boxSystem.Controls.add(buttonMerc);
        boxSystem.Controls.add(buttonSpecial);
        boxSystem.Controls.add(buttonNews);
        boxSystem.Controls.add(labelSystemPressure);
        boxSystem.Controls.add(labelSystemPressurePre);
        boxSystem.Controls.add(labelSystemPolSys);
        boxSystem.Controls.add(labelSystemSize);
        boxSystem.Controls.add(labelSystemTech);
        boxSystem.Controls.add(labelSystemPirates);
        boxSystem.Controls.add(labelSystemPolice);
        boxSystem.Controls.add(labelSystemResource);
        boxSystem.Controls.add(labelSystemPiratesLabel);
        boxSystem.Controls.add(labelSystemPoliceLabel);
        boxSystem.Controls.add(labelSystemResourceLabel);
        boxSystem.Controls.add(labelSystemGovtLabel);
        boxSystem.Controls.add(labelSystemTechLabel);
        boxSystem.Controls.add(labelSystemSizeLabel);
        boxSystem.Controls.add(labelSystemName);
        boxSystem.Controls.add(labelSystemNameLabel);
        boxSystem.setLocation(new Point(4, 2));
        boxSystem.setName("boxSystem");
        boxSystem.setSize(new SizeF(206, 240));
        boxSystem.setTabIndex(1);
        boxSystem.setTabStop(false);
        boxSystem.setText("System Info");
        // buttonMerc
        buttonMerc.setFlatStyle(FlatStyle.Flat);
        buttonMerc.setLocation(new Point(118, 174));
        buttonMerc.setName("buttonMerc");
        buttonMerc.setSize(new SizeF(22, 112));
        buttonMerc.setTabIndex(3);
        buttonMerc.setText("Mercenary For Hire");
        buttonMerc.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonMerc_Click(sender, data);
            }
        });
        // buttonSpecial
        buttonSpecial.setBackColor(new Color(255, 255, 128));
        buttonSpecial.setFlatStyle(FlatStyle.Flat);
        buttonSpecial.setLocation(new Point(58, 174));
        buttonSpecial.setName("buttonSpecial");
        buttonSpecial.setSize(new SizeF(22, 52));
        buttonSpecial.setTabIndex(2);
        buttonSpecial.setText("Special");
        buttonSpecial.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonSpecial_Click(sender, data);
            }
        });
        // buttonNews
        buttonNews.setFlatStyle(FlatStyle.Flat);
        buttonNews.setLocation(new Point(8, 174));
        buttonNews.setName("buttonNews");
        buttonNews.setSize(new SizeF(22, 42));
        buttonNews.setTabIndex(1);
        buttonNews.setText("News");
        buttonNews.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonNews_Click(sender, data);
            }
        });
        // labelSystemPressure
        labelSystemPressure.setLocation(new Point(8, 147));
        labelSystemPressure.setName("labelSystemPressure");
        labelSystemPressure.setSize(new SizeF(16, 168));
        labelSystemPressure.setTabIndex(18);
        labelSystemPressure.setText("suffering from extreme boredom.");
        // labelSystemPressurePre
        labelSystemPressurePre.setAutoSize(true);
        labelSystemPressurePre.setLocation(new Point(8, 134));
        labelSystemPressurePre.setName("labelSystemPressurePre");
        labelSystemPressurePre.setSize(new SizeF(16, 122));
        labelSystemPressurePre.setTabIndex(17);
        labelSystemPressurePre.setText("This system is currently");
        // labelSystemPolSys
        labelSystemPolSys.setLocation(new Point(88, 64));
        labelSystemPolSys.setName("labelSystemPolSys");
        labelSystemPolSys.setSize(new SizeF(13, 91));
        labelSystemPolSys.setTabIndex(15);
        labelSystemPolSys.setText("Cybernetic State");
        // labelSystemSize
        labelSystemSize.setLocation(new Point(88, 32));
        labelSystemSize.setName("labelSystemSize");
        labelSystemSize.setSize(new SizeF(13, 45));
        labelSystemSize.setTabIndex(14);
        labelSystemSize.setText("Medium");
        // labelSystemTech
        labelSystemTech.setLocation(new Point(88, 48));
        labelSystemTech.setName("labelSystemTech");
        labelSystemTech.setSize(new SizeF(13, 82));
        labelSystemTech.setTabIndex(13);
        labelSystemTech.setText("Pre-Agricultural");
        // labelSystemPirates
        labelSystemPirates.setLocation(new Point(88, 112));
        labelSystemPirates.setName("labelSystemPirates");
        labelSystemPirates.setSize(new SizeF(13, 53));
        labelSystemPirates.setTabIndex(11);
        labelSystemPirates.setText("Abundant");
        // labelSystemPolice
        labelSystemPolice.setLocation(new Point(88, 96));
        labelSystemPolice.setName("labelSystemPolice");
        labelSystemPolice.setSize(new SizeF(13, 53));
        labelSystemPolice.setTabIndex(10);
        labelSystemPolice.setText("Moderate");
        // labelSystemResource
        labelSystemResource.setLocation(new Point(88, 80));
        labelSystemResource.setName("labelSystemResource");
        labelSystemResource.setSize(new SizeF(13, 105));
        labelSystemResource.setTabIndex(9);
        labelSystemResource.setText("Sweetwater Oceans");
        // labelSystemPiratesLabel
        labelSystemPiratesLabel.setAutoSize(true);
        labelSystemPiratesLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSystemPiratesLabel.setLocation(new Point(8, 112));
        labelSystemPiratesLabel.setName("labelSystemPiratesLabel");
        labelSystemPiratesLabel.setSize(new SizeF(16, 44));
        labelSystemPiratesLabel.setTabIndex(7);
        labelSystemPiratesLabel.setText("Pirates:");
        // labelSystemPoliceLabel
        labelSystemPoliceLabel.setAutoSize(true);
        labelSystemPoliceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSystemPoliceLabel.setLocation(new Point(8, 96));
        labelSystemPoliceLabel.setName("labelSystemPoliceLabel");
        labelSystemPoliceLabel.setSize(new SizeF(16, 40));
        labelSystemPoliceLabel.setTabIndex(6);
        labelSystemPoliceLabel.setText("Police:");
        // labelSystemResourceLabel
        labelSystemResourceLabel.setAutoSize(true);
        labelSystemResourceLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSystemResourceLabel.setLocation(new Point(8, 80));
        labelSystemResourceLabel.setName("labelSystemResourceLabel");
        labelSystemResourceLabel.setSize(new SizeF(16, 58));
        labelSystemResourceLabel.setTabIndex(5);
        labelSystemResourceLabel.setText("Resource:");
        // labelSystemGovtLabel
        labelSystemGovtLabel.setAutoSize(true);
        labelSystemGovtLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSystemGovtLabel.setLocation(new Point(8, 64));
        labelSystemGovtLabel.setName("labelSystemGovtLabel");
        labelSystemGovtLabel.setSize(new SizeF(16, 72));
        labelSystemGovtLabel.setTabIndex(4);
        labelSystemGovtLabel.setText("Government:");
        // labelSystemTechLabel
        labelSystemTechLabel.setAutoSize(true);
        labelSystemTechLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSystemTechLabel.setLocation(new Point(8, 48));
        labelSystemTechLabel.setName("labelSystemTechLabel");
        labelSystemTechLabel.setSize(new SizeF(16, 65));
        labelSystemTechLabel.setTabIndex(3);
        labelSystemTechLabel.setText("Tech Level:");
        // labelSystemSizeLabel
        labelSystemSizeLabel.setAutoSize(true);
        labelSystemSizeLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSystemSizeLabel.setLocation(new Point(8, 32));
        labelSystemSizeLabel.setName("labelSystemSizeLabel");
        labelSystemSizeLabel.setSize(new SizeF(16, 31));
        labelSystemSizeLabel.setTabIndex(2);
        labelSystemSizeLabel.setText("Size:");
        // labelSystemName
        labelSystemName.setLocation(new Point(88, 16));
        labelSystemName.setName("labelSystemName");
        labelSystemName.setSize(new SizeF(13, 65));
        labelSystemName.setTabIndex(1);
        labelSystemName.setText("Tarchannen");
        // labelSystemNameLabel
        labelSystemNameLabel.setAutoSize(true);
        labelSystemNameLabel.setFont(
                new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSystemNameLabel.setLocation(new Point(8, 16));
        labelSystemNameLabel.setName("labelSystemNameLabel");
        labelSystemNameLabel.setSize(new SizeF(16, 39));
        labelSystemNameLabel.setTabIndex(0);
        labelSystemNameLabel.setText("Name:");
        // boxShipYard
        boxShipYard.Controls.add(buttonDesign);
        boxShipYard.Controls.add(buttonPod);
        boxShipYard.Controls.add(labelEscapePod);
        boxShipYard.Controls.add(buttonEquip);
        boxShipYard.Controls.add(buttonBuyShip);
        boxShipYard.Controls.add(labelEquipForSale);
        boxShipYard.Controls.add(labelShipsForSale);
        boxShipYard.setLocation(new Point(4, 306));
        boxShipYard.setName("boxShipYard");
        boxShipYard.setSize(new SizeF(168, 168));
        boxShipYard.setTabIndex(4);
        boxShipYard.setTabStop(false);
        boxShipYard.setText("Shipyard");
        // buttonDesign
        buttonDesign.setFlatStyle(FlatStyle.Flat);
        buttonDesign.setLocation(new Point(8, 32));
        buttonDesign.setName("buttonDesign");
        buttonDesign.setSize(new SizeF(22, 54));
        buttonDesign.setTabIndex(55);
        buttonDesign.setText("Design");
        buttonDesign.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonDesign_Click(sender, data);
            }
        });
        // buttonPod
        buttonPod.setFlatStyle(FlatStyle.Flat);
        buttonPod.setLocation(new Point(98, 138));
        buttonPod.setName("buttonPod");
        buttonPod.setSize(new SizeF(22, 58));
        buttonPod.setTabIndex(54);
        buttonPod.setText("Buy Pod");
        buttonPod.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonPod_Click(sender, data);
            }
        });
        // labelEscapePod
        labelEscapePod.setLocation(new Point(8, 122));
        labelEscapePod.setName("labelEscapePod");
        labelEscapePod.setSize(new SizeF(26, 152));
        labelEscapePod.setTabIndex(27);
        labelEscapePod.setText("You can buy an escape pod for  2,000 cr.");
        // buttonEquip
        buttonEquip.setFlatStyle(FlatStyle.Flat);
        buttonEquip.setLocation(new Point(43, 85));
        buttonEquip.setName("buttonEquip");
        buttonEquip.setSize(new SizeF(22, 113));
        buttonEquip.setTabIndex(53);
        buttonEquip.setText("Buy/Sell Equipment");
        buttonEquip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonEquip_Click(sender, data);
            }
        });
        // buttonBuyShip
        buttonBuyShip.setFlatStyle(FlatStyle.Flat);
        buttonBuyShip.setLocation(new Point(70, 32));
        buttonBuyShip.setName("buttonBuyShip");
        buttonBuyShip.setSize(new SizeF(22, 86));
        buttonBuyShip.setTabIndex(52);
        buttonBuyShip.setText("View Ship Info");
        buttonBuyShip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyShip_Click(sender, data);
            }
        });
        // labelEquipForSale
        labelEquipForSale.setLocation(new Point(8, 69));
        labelEquipForSale.setName("labelEquipForSale");
        labelEquipForSale.setSize(new SizeF(13, 152));
        labelEquipForSale.setTabIndex(21);
        labelEquipForSale.setText("There is equipment for sale.");
        // labelShipsForSale
        labelShipsForSale.setLocation(new Point(8, 16));
        labelShipsForSale.setName("labelShipsForSale");
        labelShipsForSale.setSize(new SizeF(13, 152));
        labelShipsForSale.setTabIndex(20);
        labelShipsForSale.setText("There are new ships for sale.");
        // boxDock
        boxDock.Controls.add(buttonRepair);
        boxDock.Controls.add(buttonFuel);
        boxDock.Controls.add(labelFuelStatus);
        boxDock.Controls.add(labelFuelCost);
        boxDock.Controls.add(labelHullStatus);
        boxDock.Controls.add(labelRepairCost);
        boxDock.setLocation(new Point(4, 212));
        boxDock.setName("boxDock");
        boxDock.setSize(new SizeF(90, 240));
        boxDock.setTabIndex(2);
        boxDock.setTabStop(false);
        boxDock.setText("Dock");
        // buttonRepair
        buttonRepair.setFlatStyle(FlatStyle.Flat);
        buttonRepair.setLocation(new Point(180, 56));
        buttonRepair.setName("buttonRepair");
        buttonRepair.setSize(new SizeF(22, 48));
        buttonRepair.setTabIndex(5);
        buttonRepair.setText("Repair");
        buttonRepair.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonRepair_Click(sender, data);
            }
        });
        // buttonFuel
        buttonFuel.setFlatStyle(FlatStyle.Flat);
        buttonFuel.setLocation(new Point(192, 18));
        buttonFuel.setName("buttonFuel");
        buttonFuel.setSize(new SizeF(22, 36));
        buttonFuel.setTabIndex(4);
        buttonFuel.setText("Fuel");
        buttonFuel.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonFuel_Click(sender, data);
            }
        });
        // labelFuelStatus
        labelFuelStatus.setLocation(new Point(8, 16));
        labelFuelStatus.setName("labelFuelStatus");
        labelFuelStatus.setSize(new SizeF(13, 162));
        labelFuelStatus.setTabIndex(20);
        labelFuelStatus.setText("You have fuel to fly 88 parsecs.");
        // labelFuelCost
        labelFuelCost.setLocation(new Point(8, 31));
        labelFuelCost.setName("labelFuelCost");
        labelFuelCost.setSize(new SizeF(13, 121));
        labelFuelCost.setTabIndex(19);
        labelFuelCost.setText("A full tank costs 888 cr.");
        // labelHullStatus
        labelHullStatus.setLocation(new Point(8, 52));
        labelHullStatus.setName("labelHullStatus");
        labelHullStatus.setSize(new SizeF(13, 152));
        labelHullStatus.setTabIndex(18);
        labelHullStatus.setText("Your hull strength is at 888%.");
        // labelRepairCost
        labelRepairCost.setLocation(new Point(8, 67));
        labelRepairCost.setName("labelRepairCost");
        labelRepairCost.setSize(new SizeF(13, 150));
        labelRepairCost.setTabIndex(19);
        labelRepairCost.setText("Full repairs will cost 8,888 cr.");
        // pictureLine
        pictureLine.setBackColor(Color.darkGray);
        pictureLine.setLocation(new Point(0, 0));
        pictureLine.setName("pictureLine");
        pictureLine.setSize(new SizeF(1, 770));
        pictureLine.setTabIndex(132);
        pictureLine.setTabStop(false);
        // dlgOpen
        dlgOpen.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
        // dlgSave
        dlgSave.setFileName("SpaceTrader.sav");
        dlgSave.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
        // ilChartImages
        ilChartImages.setImageSize(new SizeF(7, 7));
        ilChartImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilChartImages.ImageStream"))));
        ilChartImages.setTransparentColor(Color.white);
        // ilShipImages
        ilShipImages.setImageSize(new SizeF(52, 64));
        ilShipImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilShipImages.ImageStream"))));
        ilShipImages.setTransparentColor(Color.white);
        // ilDirectionImages
        ilDirectionImages.setImageSize(new SizeF(13, 13));
        ilDirectionImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilDirectionImages.ImageStream"))));
        ilDirectionImages.setTransparentColor(Color.white);
        // ilEquipmentImages
        ilEquipmentImages.setImageSize(new SizeF(52, 64));
        ilEquipmentImages.setImageStream(((ImageListStreamer) (resources.GetObject("ilEquipmentImages.ImageStream"))));
        ilEquipmentImages.setTransparentColor(Color.white);
        // ApplicationST
        setAutoScaleBaseSize(new SizeF(13, 5));
        setClientSize(new SizeF(505, 768));
        Controls.add(pictureLine);
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
            public void handle(Object sender, CancelEventData data) {
                SpaceTrader_Closing(sender, data);
            }
        });
        setLoad(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                SpaceTrader_Load(sender, data);
            }
        });
                                        boxShortRangeChart.ResumeLayout(false);
        boxGalacticChart.ResumeLayout(false);
        boxTargetSystem.ResumeLayout(false);
        boxCargo.ResumeLayout(false);
        boxSystem.ResumeLayout(false);
        boxShipYard.ResumeLayout(false);
        boxDock.ResumeLayout(false);
        ResumeLayout(false);
        InitFileStructure();
        labelSellPrice = new Label[]{
                labelSellPrice0, labelSellPrice1, labelSellPrice2, labelSellPrice3, labelSellPrice4,
                labelSellPrice5, labelSellPrice6, labelSellPrice7, labelSellPrice8, labelSellPrice9
        };
        labelBuyPrice = new Label[]{
                labelBuyPrice0, labelBuyPrice1, labelBuyPrice2, labelBuyPrice3, labelBuyPrice4,
                labelBuyPrice5, labelBuyPrice6, labelBuyPrice7, labelBuyPrice8, labelBuyPrice9
        };
        labelTargetPrice = new Label[]{
                labelTargetPrice0, labelTargetPrice1, labelTargetPrice2, labelTargetPrice3, labelTargetPrice4,
                labelTargetPrice5, labelTargetPrice6, labelTargetPrice7, labelTargetPrice8, labelTargetPrice9
        };
        labelTargetDiff = new Label[]{
                labelTargetDiff0, labelTargetDiff1, labelTargetDiff2, labelTargetDiff3, labelTargetDiff4,
                labelTargetDiff5, labelTargetDiff6, labelTargetDiff7, labelTargetDiff8, labelTargetDiff9
        };
        labelTargetPct = new Label[]{
                labelTargetPct0, labelTargetPct1, labelTargetPct2, labelTargetPct3, labelTargetPct4,
                labelTargetPct5, labelTargetPct6, labelTargetPct7, labelTargetPct8, labelTargetPct9
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
        MainWindow.this.UpdateAll();
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
                commander.Name(), game.Score(), game.getEndStatus(),
                commander.getDays(), commander.Worth(), game.Difficulty());
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
        Game.setCurrentGame(null);
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
            if (!Directory.exists(path)) {
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
                commander = game.Commander();
                SaveGameFile = fileName;
                SaveGameDays = commander.getDays();
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
        SaveGameDays = commander.getDays();
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
        if (game == null || commander.CurrentSystem() == null) {
            for (int i = 0; i < labelSellPrice.length; i++) {
                labelSellPrice[i].setText("");
                labelBuyPrice[i].setText("");
                labelTargetPrice[i].setText("");
                labelTargetDiff[i].setText("");
                labelTargetPct[i].setText("");
                buttonSellQty[i].setVisible(false);
                buttonSellAll[i].setVisible(false);
                buttonBuyQty[i].setVisible(false);
                buttonBuyMax[i].setVisible(false);
            }
        } else {
            int[] buy = game.PriceCargoBuy();
            int[] sell = game.PriceCargoSell();
            commander = game.Commander();//todo: is this unnecessary? GAC
            StarSystem warpSys = game.WarpSystem();
            for (int i = 0; i < labelSellPrice.length; i++) {
                int price = warpSys == null ? 0 : Constants.TradeItems[i].getStandardPrice(warpSys);
                labelSellPrice[i].setText(sell[i] > 0 ? Functions.FormatMoney(sell[i]) : "no trade");
                buttonSellQty[i].setText("" + commander.getShip().Cargo()[i]);
                buttonSellQty[i].setVisible(true);
                buttonSellAll[i].setText(sell[i] > 0 ? "All" : "Dump");
                buttonSellAll[i].setVisible(true);
                labelBuyPrice[i].setText(buy[i] > 0 ? Functions.FormatMoney(buy[i]) : "not sold");
                buttonBuyQty[i].setText("" + commander.CurrentSystem().TradeItems()[i]);
                buttonBuyQty[i].setVisible(buy[i] > 0);
                buttonBuyMax[i].setVisible(buy[i] > 0);
                if (sell[i] * commander.getShip().Cargo()[i] > commander.PriceCargo()[i]) {
                    labelSellPrice[i].setFont(labelSystemNameLabel.getFont());
                } else {
                    labelSellPrice[i].setFont(labelSell.getFont());
                }
                if (warpSys != null && warpSys.DestOk() && price > 0) {
                    labelTargetPrice[i].setText(Functions.FormatMoney(price));
                } else {
                    labelTargetPrice[i].setText("-----------");
                }
                if (warpSys != null && warpSys.DestOk() && price > 0 && buy[i] > 0) {
                    int diff = price - buy[i];
                    labelTargetDiff[i].setText((diff > 0 ? "+" : "") + Functions.FormatMoney(diff));
                    labelTargetPct[i].setText((diff > 0 ? "+" : "") + Functions.FormatNumber(100 * diff / buy[i]) + "%");
                    labelBuyPrice[i].setFont(
                            (diff > 0 && commander.CurrentSystem().TradeItems()[i] > 0)
                                    ? labelSystemNameLabel.getFont() : labelBuy.getFont());
                } else {
                    labelTargetDiff[i].setText("------------");
                    labelTargetPct[i].setText("--------");
                    labelBuyPrice[i].setFont(labelBuy.getFont());
                }
                labelTargetPrice[i].setFont(labelBuyPrice[i].getFont());
                labelTargetDiff[i].setFont(labelBuyPrice[i].getFont());
                labelTargetPct[i].setFont(labelBuyPrice[i].getFont());
            }
        }
    }

    private void UpdateCharts() {
        pictureGalacticChart.Refresh();
        pictureShortRangeChart.Refresh();
        if (game == null) {
            labelWormholeLabel.setVisible(false);
            labelWormhole.setVisible(false);
            buttonJump.setVisible(false);
            buttonFind.setVisible(false);
        } else {
            if (game.TargetWormhole()) {
                labelWormholeLabel.setVisible(true);
                labelWormhole.setVisible(true);
                labelWormhole.setText(game.WarpSystem().Name());
            } else {
                labelWormholeLabel.setVisible(false);
                labelWormhole.setVisible(false);
            }
            buttonJump.setVisible(game.getCanSuperWarp());
            buttonFind.setVisible(true);
        }
    }

    private void UpdateDock() {
        if (game == null) {
            labelFuelStatus.setText("");
            labelFuelCost.setText("");
            buttonFuel.setVisible(false);
            labelHullStatus.setText("");
            labelRepairCost.setText("");
            buttonRepair.setVisible(false);
        } else {
            Ship ship = commander.getShip();
            labelFuelStatus.setText(
                    Functions.StringVars("You have fuel to fly ^1.", Functions.Multiples(ship.getFuel(), "parsec")));
            int tanksEmpty = ship.FuelTanks() - ship.getFuel();
            labelFuelCost.setText(tanksEmpty > 0
                    ? Functions.StringVars("A full tank costs ^1", Functions.FormatMoney(tanksEmpty * ship.getFuelCost()))
                    : "Your tank is full.");
            buttonFuel.setVisible(tanksEmpty > 0);
            labelHullStatus.setText(
                    Functions.StringVars("Your hull strength is at ^1%.",
                            Functions.FormatNumber((int) Math.floor((double) 100 * ship.getHull() / ship.HullStrength()))));
            int hullLoss = ship.HullStrength() - ship.getHull();
            labelRepairCost.setText(hullLoss > 0
                    ? Functions.StringVars("Full repairs will cost ^1", Functions.FormatMoney(hullLoss * ship.getRepairCost()))
                    : "No repairs are needed.");
            buttonRepair.setVisible(hullLoss > 0);
        }
    }

    private void UpdateShipyard() {
        if (game == null) {
            labelShipsForSale.setText("");
            labelEquipForSale.setText("");
            labelEscapePod.setText("");
            buttonPod.setVisible(false);
            buttonBuyShip.setVisible(false);
            buttonDesign.setVisible(false);
            buttonEquip.setVisible(false);
        } else {
            boolean noTech =
                    commander.CurrentSystem().TechLevel().ordinal()
                            < Constants.ShipSpecs[ShipType.Flea.getId()].MinimumTechLevel().ordinal();
            labelShipsForSale.setText(noTech ? Strings.ShipyardShipNoSale : Strings.ShipyardShipForSale);
            buttonBuyShip.setVisible(true);
            buttonDesign.setVisible((commander.CurrentSystem().Shipyard() != null));
            labelEquipForSale.setText(noTech ? Strings.ShipyardEquipNoSale : Strings.ShipyardEquipForSale);
            buttonEquip.setVisible(true);
            buttonPod.setVisible(false);
            if (commander.getShip().getEscapePod()) {
                labelEscapePod.setText(Strings.ShipyardPodInstalled);
            } else if (noTech) {
                labelEscapePod.setText(Strings.ShipyardPodNoSale);
            } else if (commander.getCash() < 2000) {
                labelEscapePod.setText(Strings.ShipyardPodIF);
            } else {
                labelEscapePod.setText(Strings.ShipyardPodCost);
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
            statusBarPanelCash.setText("Cash: " + Functions.FormatMoney(commander.getCash()));
            statusBarPanelBays.setText(
                    "Bays: " + commander.getShip().FilledCargoBays() + "/" + commander.getShip().CargoBays());
            statusBarPanelCosts.setText("Current Costs: " + Functions.FormatMoney(game.CurrentCosts()));
            statusBarPanelExtra.setText("");
        }
    }

    private void UpdateSystemInfo() {
        if (game == null || commander.CurrentSystem() == null) {
            labelSystemName.setText("");
            labelSystemSize.setText("");
            labelSystemTech.setText("");
            labelSystemPolSys.setText("");
            labelSystemResource.setText("");
            labelSystemPolice.setText("");
            labelSystemPirates.setText("");
            labelSystemPressure.setText("");
            labelSystemPressurePre.setVisible(false);
            buttonNews.setVisible(false);
            buttonMerc.setVisible(false);
            buttonSpecial.setVisible(false);
        } else {
            StarSystem system = commander.CurrentSystem();
            CrewMember[] mercs = system.MercenariesForHire();
            labelSystemName.setText(system.Name());
            labelSystemSize.setText(Strings.Sizes[system.Size().getId()]);
            labelSystemTech.setText(system.TechLevel().name);
            labelSystemPolSys.setText(system.PoliticalSystem().Name());
            labelSystemResource.setText(system.SpecialResource().name);
            labelSystemPolice.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPolice().getId()]);
            labelSystemPirates.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPirates().getId()]);
            labelSystemPressure.setText(system.SystemPressure().name);
            labelSystemPressurePre.setVisible(true);
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
            labelTargetName.setText("");
            labelTargetSize.setText("");
            labelTargetTech.setText("");
            labelTargetPolSys.setText("");
            labelTargetResource.setText("");
            labelTargetPolice.setText("");
            labelTargetPirates.setText("");
            labelTargetDistance.setText("");
            labelTargetOutOfRange.setVisible(false);
            buttonWarp.setVisible(false);
            buttonTrack.setVisible(false);
        } else {
            StarSystem system = game.WarpSystem();
            int distance = Functions.Distance(commander.CurrentSystem(), system);
            labelTargetName.setText(system.Name());
            labelTargetSize.setText(Strings.Sizes[system.Size().getId()]);
            labelTargetTech.setText(system.TechLevel().name);
            labelTargetPolSys.setText(system.PoliticalSystem().Name());
            labelTargetResource.setText(system.Visited() ? system.SpecialResource().name : Strings.Unknown);
            labelTargetPolice.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPolice().getId()]);
            labelTargetPirates.setText(Strings.ActivityLevels[system.PoliticalSystem().ActivityPirates().getId()]);
            labelTargetDistance.setText("" + distance);
            labelTargetOutOfRange.setVisible(!system.DestOk() && system != commander.CurrentSystem());
            buttonWarp.setVisible(system.DestOk());
            buttonTrack.setVisible(labelTargetOutOfRange.getVisible() && system != game.TrackedSystem());
        }
    }

    private void SpaceTrader_Closing(Object sender, CancelEventData e) {
        if (game == null || commander.getDays() == SaveGameDays
                || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes) {
            if (WindowState == FormWindowState.Normal) {
                SetRegistrySetting("X", Left.toString());
                SetRegistrySetting("Y", Top.toString());
            }
        } else {
            e.Cancel = true;
        }
    }

    private void SpaceTrader_Load(Object sender, EventData e) {
        Left = Integer.parseInt(GetRegistrySetting("X", "0"));
        Top = Integer.parseInt(GetRegistrySetting("Y", "0"));
        FormAlert.Alert(AlertType.AppStart, this);
    }

    private void buttonBuySell_Click(Object sender, EventData e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Qty");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        if (!name.contains("Buy")) {
            CargoSell(index, all);
        } else {
            CargoBuy(index, all);
        }
    }

    private void buttonBuyShip_Click(Object sender, EventData e) {
        (new FormShipList()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonDesign_Click(Object sender, EventData e) {
        (new FormShipyard()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonEquip_Click(Object sender, EventData e) {
        (new FormEquipment()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonFind_Click(Object sender, EventData e) {
        FormFind form = new FormFind();
        if (form.ShowDialog(this) == DialogResult.OK) {
            Ship ship = commander.getShip();
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
                        commander.setDays(Math.max(0, num1));
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
                                text += Strings.VeryRareEncounters[veryRareEncounter.getId()] + Strings.newline;
                            }
                            text = text.trim();
                            FormAlert.Alert(AlertType.Alert, this, "Remaining Very Rare Encounters", text);
                        }
                        break;
                    case Fame:
                        commander.setReputationScore(Math.max(0, num1));
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
                                commander.setKillsPirate(Math.max(0, num2));
                                break;
                            case Police:
                                commander.setKillsPolice(Math.max(0, num2));
                                break;
                            case Trader:
                                commander.setKillsTrader(Math.max(0, num2));
                                break;
                        }
                    }
                    break;
                    case Indemnity:
                        commander.NoClaim(Math.max(0, num1));
                        break;
                    case IOU:
                        commander.setDebt(Math.max(0, num1));
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
                                && !Util.arrayContains(Constants.SpecialCrewMemberIds, (CrewMemberId.FromInt(num2)))) {
                            int skill = ship.Trader();
                            ship.Crew()[num1] = game.Mercenaries()[num2];
                            if (ship.Trader() != skill) {
                                game.RecalculateBuyPrices(commander.CurrentSystem());
                            }
                        }
                        break;
                    case RapSheet:
                        commander.setPoliceRecordScore(num1);
                        break;
                    case Rarity:
                        game.setChanceOfVeryRareEncounter(Math.max(0, Math.min(1000, num1)));
                        break;
                    case Scratch:
                        commander.setCash(Math.max(0, num1));
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

    private void buttonFuel_Click(Object sender, EventData e) {
        FormBuyFuel form = new FormBuyFuel();
        if (form.ShowDialog(this) == DialogResult.OK) {
            int toAdd = form.Amount() / commander.getShip().getFuelCost();
            commander.getShip().setFuel(commander.getShip().getFuel() + toAdd);
            commander.setCash(commander.getCash() - (toAdd * commander.getShip().getFuelCost()));
            UpdateAll();
        }
    }

    private void buttonJump_Click(Object sender, EventData e) {
        if (game.WarpSystem() == null) {
            FormAlert.Alert(AlertType.ChartJumpNoSystemSelected, this);
        } else if (game.WarpSystem() == commander.CurrentSystem()) {
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

    private void buttonMerc_Click(Object sender, EventData e) {
        (new FormViewPersonnel()).ShowDialog(this);
        UpdateAll();
    }

    private void buttonNews_Click(Object sender, EventData e) {
        game.ShowNewspaper();
    }

    private void buttonNextSystem_Click(Object sender, EventData e) {
        game.SelectNextSystemWithinRange(true);
        UpdateAll();
    }

    private void buttonPod_Click(Object sender, EventData e) {
        if (FormAlert.Alert(AlertType.EquipmentEscapePod, this) == DialogResult.Yes) {
            commander.setCash(commander.getCash() - 2000);
            commander.getShip().setEscapePod(true);
            UpdateAll();
        }
    }

    private void buttonPrevSystem_Click(Object sender, EventData e) {
        game.SelectNextSystemWithinRange(false);
        UpdateAll();
    }

    private void buttonRepair_Click(Object sender, EventData e) {
        FormBuyRepairs form = new FormBuyRepairs();
        if (form.ShowDialog(this) == DialogResult.OK) {
            int toAdd = form.Amount() / commander.getShip().getRepairCost();
            commander.getShip().setHull(commander.getShip().getHull() + toAdd);
            commander.setCash(commander.getCash() - (toAdd * commander.getShip().getRepairCost()));
            UpdateAll();
        }
    }

    private void buttonSpecial_Click(Object sender, EventData e) {
        SpecialEvent specEvent = commander.CurrentSystem().SpecialEvent();
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
            if (commander.CashToSpend() < specEvent.Price()) {
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

    private void buttonTrack_Click(Object sender, EventData e) {
        game.setTrackedSystemId(game.SelectedSystemId());
        UpdateAll();
    }

    private void buttonWarp_Click(Object sender, EventData e) {
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

    private void mnuGameExit_Click(Object sender, EventData e) {
        Close();
    }

    private void mnuGameNew_Click(Object sender, EventData e) {
        FormNewCommander form = new FormNewCommander();
        if ((game == null || commander.getDays() == SaveGameDays
                || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes)
                && form.ShowDialog(this) == DialogResult.OK) {
            game = new Game(
                    form.CommanderName(), form.Difficulty(), form.Pilot(),
                    form.Fighter(), form.Trader(), form.Engineer(), this);
            commander = game.Commander();
            SaveGameFile = null;
            SaveGameDays = 0;
            SetInGameControlsEnabled(true);
            UpdateAll();
            if (game.Options().getNewsAutoShow()) {
                game.ShowNewspaper();
            }
        }
    }

    private void mnuGameLoad_Click(Object sender, EventData e) {
        if ((game == null || commander.getDays() == SaveGameDays
                || FormAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes)
                && dlgOpen.ShowDialog(this) == DialogResult.OK) {
            LoadGame(dlgOpen.getFileName());
        }
    }

    private void mnuGameSave_Click(Object sender, EventData e) {
        if (game != null) {
            if (SaveGameFile != null) {
                SaveGame(SaveGameFile, false);
            } else {
                mnuGameSaveAs_Click(sender, e);
            }
        }
    }

    private void mnuGameSaveAs_Click(Object sender, EventData e) {
        if (game != null && dlgSave.ShowDialog(this) == DialogResult.OK) {
            SaveGame(dlgSave.getFileName(), true);
        }
    }

    private void mnuHelpAbout_Click(Object sender, EventData e) {
        (new FormAbout()).ShowDialog(this);
    }

    private void mnuHighScores_Click(Object sender, EventData e) {
        (new FormViewHighScores()).ShowDialog(this);
    }

    private void mnuOptions_Click(Object sender, EventData e) {
        FormOptions form = new FormOptions();
        if (form.ShowDialog(this) == DialogResult.OK) {
            game.Options().CopyValues(form.Options());
            UpdateAll();
        }
    }

    private void mnuRetire_Click(Object sender, EventData e) {
        if (FormAlert.Alert(AlertType.GameRetire, this) == DialogResult.Yes) {
            game.setEndStatus(GameEndType.Retired);
            GameEnd();
            UpdateAll();
        }
    }

    private void mnuViewBank_Click(Object sender, EventData e) {
        (new FormViewBank()).ShowDialog(this);
    }

    private void mnuViewCommander_Click(Object sender, EventData e) {
        (new FormViewCommander()).ShowDialog(this);
    }

    private void mnuViewPersonnel_Click(Object sender, EventData e) {
        (new FormViewPersonnel()).ShowDialog(this);
    }

    private void mnuViewQuests_Click(Object sender, EventData e) {
        (new FormViewQuests()).ShowDialog(this);
    }

    private void mnuViewShip_Click(Object sender, EventData e) {
        (new FormViewShip()).ShowDialog(this);
    }

    private void pictureGalacticChart_MouseDown(Object sender, MouseEventData e) {
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

    private void pictureGalacticChart_Paint(Object sender, PaintEventData e) {
        if (game != null) {
            StarSystem[] universe = game.Universe();
            int[] wormholes = game.Wormholes();
            StarSystem targetSys = game.SelectedSystem();
            StarSystem currentSys = commander.CurrentSystem();
            int fuel = commander.getShip().getFuel();
            if (fuel > 0) {
                e.Graphics.DrawEllipse(PEN_BLACK, currentSys.X() + OFF_X - fuel, currentSys.Y() + OFF_Y - fuel, fuel * 2, fuel * 2);
            }
            int index = game.SelectedSystemId().getId();
            if (game.TargetWormhole()) {
                int destination = wormholes[(Util.bruteSeek(wormholes, index) + 1) % wormholes.length];
                StarSystem destinationSystem = universe[destination];
                e.Graphics.DrawLine(
                        PEN_BLACK, targetSys.X() + OFF_X_WORM + OFF_X,
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
                            PEN_BLACK, universe[i].X(), universe[i].Y(),
                            universe[i].X() + image.getWidth() - 1, universe[i].Y() + image.getHeight() - 1);
                    e.Graphics.DrawLine(
                            PEN_BLACK, universe[i].X(), universe[i].Y() + image.getHeight() - 1,
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
            e.Graphics.FillRectangle(PEN_WHITE, 0, 0, pictureGalacticChart.getWidth(), pictureGalacticChart.getHeight());
        }
    }

    private void pictureShortRangeChart_MouseDown(Object sender, MouseEventData e) {
        if (e.Button == MouseButtons.Left && game != null) {
            StarSystem[] universe = game.Universe();
            StarSystem currentSys = commander.CurrentSystem();
            boolean clickedSystem = false;
            int centerX = pictureShortRangeChart.getWidth() / 2;
            int centerY = pictureShortRangeChart.getHeight() / 2;
            int delta = pictureShortRangeChart.getHeight() / (Constants.MaxRange * 2);
            for (int i = 0; i < universe.length && !clickedSystem; i++) {
                if ((Math.abs(universe[i].X() - currentSys.X()) * delta <= pictureShortRangeChart.getWidth() / 2 - 10)
                        && (Math.abs(universe[i].Y() - currentSys.Y()) * delta <= pictureShortRangeChart.getHeight() / 2 - 10)) {
                    int x = centerX + (universe[i].X() - currentSys.X()) * delta;
                    int y = centerY + (universe[i].Y() - currentSys.Y()) * delta;
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

    private void pictureShortRangeChart_Paint(Object sender, PaintEventData e) {
        if (game == null) {
            e.Graphics.FillRectangle(PEN_WHITE, 0, 0, pictureShortRangeChart.getWidth(), pictureShortRangeChart.getHeight());
        } else {
            int[] wormholes = game.Wormholes();
            int fuel = commander.getShip().getFuel();
            int centerX = pictureShortRangeChart.getWidth() / 2;
            int centerY = pictureShortRangeChart.getHeight() / 2;
            int delta = pictureShortRangeChart.getHeight() / (Constants.MaxRange * 2);
            e.Graphics.DrawLine(PEN_BLACK, centerX - 1, centerY - 1, centerX + 1, centerY + 1);
            e.Graphics.DrawLine(PEN_BLACK, centerX - 1, centerY + 1, centerX + 1, centerY - 1);
            if (fuel > 0) {
                e.Graphics.DrawEllipse(PEN_BLACK, centerX - fuel * delta, centerY - fuel * delta, fuel * delta * 2, fuel * delta * 2);
            }
            StarSystem currentSys = commander.CurrentSystem();
            StarSystem trackSys = game.TrackedSystem();
            if (trackSys != null) {
                int dist = Functions.Distance(currentSys, trackSys);
                if (dist > 0) {
                    int dX = (int) Math.round(25 * (trackSys.X() - currentSys.X()) / (double) dist);
                    int dY = (int) Math.round(25 * (trackSys.Y() - currentSys.Y()) / (double) dist);
                    int dX2 = (int) Math.round(4 * (trackSys.Y() - currentSys.Y()) / (double) dist);
                    int dY2 = (int) Math.round(4 * (currentSys.X() - trackSys.X()) / (double) dist);
                    e.Graphics.FillPolygon(new Pen(new Color(220, 20, 60)), new Point[]{
                            new Point(centerX + dX, centerY + dY), new Point(centerX - dX2, centerY - dY2), new Point(centerX + dX2, centerY + dY2)
                    });
                }
                if (game.Options().getShowTrackedRange()) {
                    e.Graphics.DrawString(
                            Functions.StringVars("^1 to ^2.", Functions.Multiples(dist, Strings.DistanceUnit), trackSys.Name()),
                            getFont(), new Pen(Color.black), 0, pictureShortRangeChart.getHeight() - 13);
                }
            }
            // First, draw the names, then the systems.
            // The names may overlap and the systems may be drawn on the names, but at least every system is visible.
            StarSystem[] universe = game.Universe();
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < universe.length; i++) {
                    if ((Math.abs(universe[i].X() - currentSys.X()) * delta <= pictureShortRangeChart.getWidth() / 2 - 10)
                            && (Math.abs(universe[i].Y() - currentSys.Y()) * delta <= pictureShortRangeChart.getHeight() / 2 - 10)) {
                        int x = centerX + (universe[i].X() - currentSys.X()) * delta;
                        int y = centerY + (universe[i].Y() - currentSys.Y()) * delta;
                        if (j == 1) {
                            if (universe[i] == game.WarpSystem()) {
                                e.Graphics.DrawLine(PEN_BLACK, x - 6, y, x + 6, y);
                                e.Graphics.DrawLine(PEN_BLACK, x, y - 6, x, y + 6);
                            }
                            if (universe[i] == game.TrackedSystem()) {
                                e.Graphics.DrawLine(PEN_BLACK, x - 5, y - 5, x + 5, y + 5);
                                e.Graphics.DrawLine(PEN_BLACK, x - 5, y + 5, x + 5, y - 5);
                            }
                            int IMG_G_N = 0;
                            int IMG_G_V = 1;
                            ilChartImages.Draw(e.Graphics, x - OFF_X, y - OFF_Y, universe[i].Visited() ? IMG_G_V : IMG_G_N);
                            if (Functions.WormholeExists(i, -1)) {
                                int xW = x + 9;
                                if (game.TargetWormhole() && universe[i] == game.SelectedSystem()) {
                                    e.Graphics.DrawLine(PEN_BLACK, xW - 6, y, xW + 6, y);
                                    e.Graphics.DrawLine(PEN_BLACK, xW, y - 6, xW, y + 6);
                                }
                                int IMG_G_W = 2;
                                ilChartImages.Draw(e.Graphics, xW - OFF_X, y - OFF_Y, IMG_G_W);
                            }
                        } else {
                            Font font = new Font(getFont().FontFamily, 7);
                            SizeF size = e.Graphics.MeasureString(universe[i].Name(), getFont());
                            e.Graphics.DrawString(universe[i].Name(), font, new Pen(Color.black),
                                    x - size.width / 2 + OFF_X, y /*- size.Height*/ - 5);
                            // implementations differ as to which point we start the string at. --aviv
                        }
                    }
                }
            }
        }
    }

    private void statusBar_PanelClick(Object sender, StatusBarPanelClickEventData e) {
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
        int baseIndex = ShipType.Custom.getId() * Constants.ImagesPerShip;
        for (int index = 0; index < Constants.ImagesPerShip; index++) {
            images[index] = ilShipImages.getImages()[baseIndex + index];
        }
        return images;
    }

    public void CustomShipImages(wfImage[] value) {
        int baseIndex = ShipType.Custom.getId() * Constants.ImagesPerShip;
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
        int baseIndex = ShipType.Custom.getId() * Constants.ImagesPerShip;
        for (int index = 0; index < Constants.ImagesPerShip; index++) {
            images[index] = ilShipImages.getImages()[baseIndex + index];
        }
        return images;
    }

    public void setCustomShipImages(wfImage[] value) {
        int baseIndex = ShipType.Custom.getId() * Constants.ImagesPerShip;
        System.arraycopy(value, 0, ilShipImages.getImages(), baseIndex, Constants.ImagesPerShip);
    }
}
