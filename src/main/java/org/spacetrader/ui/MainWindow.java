package org.spacetrader.ui;

import org.spacetrader.Constants;
import org.spacetrader.Main;
import org.spacetrader.controller.*;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.model.SerializableObject;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.crew.CrewMember;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.enums.CrewMemberId;
import org.spacetrader.model.enums.GameEndType;
import org.spacetrader.model.enums.StarSystemId;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.events.VeryRareEncounter;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.model.ship.equipment.Gadget;
import org.spacetrader.model.ship.equipment.Shield;
import org.spacetrader.model.ship.equipment.Weapon;
import org.spacetrader.model.system.StarSystem;
import org.spacetrader.util.RegistryKey;
import org.spacetrader.util.Utils;
import org.winforms.dialog.FileDialog;
import org.winforms.menu.SubMenu;
import org.winforms.mouse.MouseButtons;
import org.winforms.resource.ResourceManager;
import org.winforms.util.Font;
import org.winforms.util.Graphics;
import org.winforms.alignment.ContentAlignment;
import org.winforms.alignment.FormStartPosition;
import org.winforms.dialog.DialogResult;
import org.winforms.image.Icon;
import org.winforms.image.Image;
import org.winforms.menu.MenuItem;
import org.winforms.widget.Button;
import org.winforms.widget.Label;
import org.winforms.widget.MenuBar;
import org.winforms.widget.Window;
import org.winforms.widget.*;
import org.winforms.event.CancelEventData;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;
import org.winforms.event.MouseEventData;
import org.winforms.image.ImageList;
import org.winforms.image.ImageListStreamer;
import org.winforms.style.AnchorStyle;
import org.winforms.style.FlatStyle;
import org.winforms.style.FontStyle;
import org.winforms.style.FormBorderStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Hashtable;


public class MainWindow extends Window {

    private final Label[] labelSellPrice;
    private final Label[] labelBuyPrice;
    private final Label[] labelTargetPrice;
    private final Label[] labelTargetDiff;
    private final Label[] labelTargetPct;
    private final Button[] buttonSellQuantity;
    private final Button[] buttonSellAll;
    private final Button[] buttonBuyQuantity;
    private final Button[] buttonBuyMax;
    private final String SAVE_ARRIVAL = "autosave_arrival.sav";
    private final String SAVE_DEPARTURE = "autosave_departure.sav";
    private final int OFF_X = 3;
    private final int OFF_Y = 3;
    private final int OFF_X_WORM = OFF_X + 1;
    private final Color Color_BLACK = java.awt.Color.black;
    private final Color Color_WHITE = java.awt.Color.white;
    private final Button buttonDesign;
    private final Button buttonNews;
    private final Button buttonSpecial;
    private final Button buttonMercenary;
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
    private final MenuItem menuGameSave;
    private final MenuItem menuGameSaveAs;
    private final MenuItem menuRetire;
    private final MenuItem menuViewBank;
    private final MenuItem menuViewCommander;
    private final MenuItem menuViewPersonnel;
    private final MenuItem menuViewQuests;
    private final MenuItem menuViewShip;
    private final FileDialog dialogOpen = FileDialog.createOpenFileDialog();
    private final PictureBox pictureGalacticChart;
    private final PictureBox pictureShortRangeChart;
    private final FileDialog dialogSave = FileDialog.createSaveFileDialog();
    private final StatusBarPanel statusBarPanelBays;
    private final StatusBarPanel statusBarPanelCash;
    private final StatusBarPanel statusBarPanelCosts;
    private final StatusBarPanel statusBarPanelExtra;
    private Game game;
    private Commander commander;
    private String saveGameFile;
    private int saveGameDays = -1;

    public MainWindow() {
        ResourceManager resources = new ResourceManager(Main.class);

        // layout
        MenuBar menuMain = new MenuBar();
        SubMenu menuGame = new SubMenu();
        MenuItem menuGameNew = new MenuItem();
        MenuItem menuGameLoad = new MenuItem();
        menuGameSave = new MenuItem();
        menuGameSaveAs = new MenuItem();
        menuRetire = new MenuItem();
        MenuItem menuGameExit = new MenuItem();
        SubMenu menuView = new SubMenu();
        menuViewCommander = new MenuItem();
        menuViewShip = new MenuItem();
        menuViewPersonnel = new MenuItem();
        menuViewQuests = new MenuItem();
        menuViewBank = new MenuItem();
        MenuItem menuHighScores = new MenuItem();
        MenuItem menuOptions = new MenuItem();
        SubMenu menuHelp = new SubMenu();
        MenuItem menuHelpAbout = new MenuItem();
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
        Button buttonBuyQuantity9 = new Button();
        Label labelBuyPrice9 = new Label();
        Button buttonSellAll9 = new Button();
        Button buttonSellQuantity9 = new Button();
        Label labelSellPrice9 = new Label();
        Label labelTargetPct8 = new Label();
        Label labelTargetDiff8 = new Label();
        Label labelTargetPrice8 = new Label();
        Button buttonBuyMax8 = new Button();
        Button buttonBuyQuantity8 = new Button();
        Label labelBuyPrice8 = new Label();
        Button buttonSellAll8 = new Button();
        Button buttonSellQuantity8 = new Button();
        Label labelSellPrice8 = new Label();
        Label labelTargetPct7 = new Label();
        Label labelTargetDiff7 = new Label();
        Label labelTargetPrice7 = new Label();
        Button buttonBuyMax7 = new Button();
        Button buttonBuyQuantity7 = new Button();
        Label labelBuyPrice7 = new Label();
        Button buttonSellAll7 = new Button();
        Button buttonSellQuantity7 = new Button();
        Label labelSellPrice7 = new Label();
        Label labelTargetPct6 = new Label();
        Label labelTargetDiff6 = new Label();
        Label labelTargetPrice6 = new Label();
        Button buttonBuyMax6 = new Button();
        Button buttonBuyQuantity6 = new Button();
        Label labelBuyPrice6 = new Label();
        Button buttonSellAll6 = new Button();
        Button buttonSellQuantity6 = new Button();
        Label labelSellPrice6 = new Label();
        Label labelTargetPct5 = new Label();
        Label labelTargetDiff5 = new Label();
        Label labelTargetPrice5 = new Label();
        Button buttonBuyMax5 = new Button();
        Button buttonBuyQuantity5 = new Button();
        Label labelBuyPrice5 = new Label();
        Button buttonSellAll5 = new Button();
        Button buttonSellQuantity5 = new Button();
        Label labelSellPrice5 = new Label();
        Label labelTargetPct4 = new Label();
        Label labelTargetDiff4 = new Label();
        Label labelTargetPrice4 = new Label();
        Button buttonBuyMax4 = new Button();
        Button buttonBuyQuantity4 = new Button();
        Label labelBuyPrice4 = new Label();
        Button buttonSellAll4 = new Button();
        Button buttonSellQuantity4 = new Button();
        Label labelSellPrice4 = new Label();
        Label labelTargetPct3 = new Label();
        Label labelTargetDiff3 = new Label();
        Label labelTargetPrice3 = new Label();
        Button buttonBuyMax3 = new Button();
        Button buttonBuyQuantity3 = new Button();
        Label labelBuyPrice3 = new Label();
        Button buttonSellAll3 = new Button();
        Button buttonSellQuantity3 = new Button();
        Label labelSellPrice3 = new Label();
        Label labelTargetPct2 = new Label();
        Label labelTargetDiff2 = new Label();
        Label labelTargetPrice2 = new Label();
        Button buttonBuyMax2 = new Button();
        Button buttonBuyQuantity2 = new Button();
        Label labelBuyPrice2 = new Label();
        Button buttonSellAll2 = new Button();
        Button buttonSellQuantity2 = new Button();
        Label labelSellPrice2 = new Label();
        Label labelTargetPct1 = new Label();
        Label labelTargetDiff1 = new Label();
        Label labelTargetPrice1 = new Label();
        Button buttonBuyMax1 = new Button();
        Button buttonBuyQuantity1 = new Button();
        Label labelBuyPrice1 = new Label();
        Label labelTargetPctLabel = new Label();
        Label labelTargetDiffLabel = new Label();
        Label labelTargetPriceLabel = new Label();
        Label labelTargetPct0 = new Label();
        Label labelTargetDiff0 = new Label();
        Label labelTargetPrice0 = new Label();
        Button buttonBuyMax0 = new Button();
        Button buttonBuyQuantity0 = new Button();
        Label labelBuyPrice0 = new Label();
        Button buttonSellAll1 = new Button();
        Button buttonSellQuantity1 = new Button();
        Label labelSellPrice1 = new Label();
        Button buttonSellAll0 = new Button();
        Button buttonSellQuantity0 = new Button();
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
        buttonMercenary = new Button();
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
        ilChartImages = new ImageList();
        ilShipImages = new ImageList();
        ilDirectionImages = new ImageList();
        ilEquipmentImages = new ImageList();

        // menuMain
        menuMain.addAll(menuGame, menuView, menuHelp);
        // menuGame
        menuGame.addAll(menuGameNew, menuGameLoad, menuGameSave, menuGameSaveAs);
        menuGame.addSeparator();
        menuGame.add(menuRetire);
        menuGame.addSeparator();
        menuGame.add(menuGameExit);
        menuGame.setText("Game");
        // menuGameNew
        menuGameNew.setText("New");
        menuGameNew.asJMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menuGameNew.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                menuGameNewClick();
            }
        });
        // menuGameLoad
        menuGameLoad.setText("Load");
        menuGameLoad.asJMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menuGameLoad.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                menuGameLoadClick();
            }
        });
        // menuGameSave
        menuGameSave.setEnabled(false);
        menuGameSave.setText("Save");
        menuGameSave.asJMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menuGameSave.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                menuGameSaveClick();
            }
        });
        // menuGameSaveAs
        menuGameSaveAs.setEnabled(false);
        menuGameSaveAs.setText("Save As");
        menuGameSaveAs.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                menuGameSaveAsClick();
            }
        });
        // menuRetire
        menuRetire.setEnabled(false);
        menuRetire.setText("Retire");
        menuRetire.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                menuRetireClick();
            }
        });
        // menuGameExit
        menuGameExit.setText("Exit");
        menuGameExit.asJMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menuGameExit.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                close();
            }
        });
        // menuView
        menuView.addAll(menuViewCommander, menuViewShip, menuViewPersonnel, menuViewQuests, menuViewBank);
        menuView.addSeparator();
        menuView.add(menuHighScores);
        menuView.addSeparator();
        menuView.add(menuOptions);
        menuView.setText("View");
        // menuViewCommander
        menuViewCommander.setEnabled(false);
        menuViewCommander.setText("Commander Status");
        menuViewCommander.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                (new DialogViewCommander()).ShowDialog(MainWindow.this);
            }
        });
        // menuViewShip
        menuViewShip.setEnabled(false);
        menuViewShip.setText("Ship");
        menuViewShip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                (new DialogViewShip()).ShowDialog(MainWindow.this);
            }
        });
        // menuViewPersonnel
        menuViewPersonnel.setEnabled(false);
        menuViewPersonnel.setText("Personnel");
        menuViewPersonnel.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                (new DialogViewPersonnel()).ShowDialog(MainWindow.this);
            }
        });
        // menuViewQuests
        menuViewQuests.setEnabled(false);
        menuViewQuests.setText("Quests");
        menuViewQuests.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                (new DialogViewQuests()).ShowDialog(MainWindow.this);
            }
        });
        // menuViewBank
        menuViewBank.setEnabled(false);
        menuViewBank.setText("Bank");
        menuViewBank.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                (new DialogViewBank()).ShowDialog(MainWindow.this);
            }
        });
        // menuHighScores
        menuHighScores.setText("High Scores");
        menuHighScores.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                (new DialogViewHighScores()).ShowDialog(MainWindow.this);
            }
        });
        // menuOptions
        menuOptions.setText("Options");
        menuOptions.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                menuOptionsClick();
            }
        });
        // menuHelp
        menuHelp.add(menuHelpAbout);
        menuHelp.setText("Help");
        // menuHelpAbout
        menuHelpAbout.setText("About Space Trader");
        menuHelpAbout.asJMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menuHelpAbout.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                (new DialogAbout()).ShowDialog(MainWindow.this);
            }
        });
        // pictureGalacticChart
        pictureGalacticChart.setBackgroundColor(java.awt.Color.white);
        pictureGalacticChart.setLocation(new Point(8, 16));
        pictureGalacticChart.setName("pictureGalacticChart");
        pictureGalacticChart.setSize(new Dimension(160, 116));
        pictureGalacticChart.setTabIndex(0);
        pictureGalacticChart.setTabStop(false);
        pictureGalacticChart.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, Graphics graphics) {
                pictureGalacticChartPaint(graphics);
            }
        });
        pictureGalacticChart.setMouseDown(new EventHandler<>() {
            @Override
            public void handle(Object sender, MouseEventData data) {
                pictureGalacticChartMouseDown(data);
            }
        });
        // pictureShortRangeChart
        pictureShortRangeChart.setBackgroundColor(java.awt.Color.white);
        pictureShortRangeChart.setLocation(new Point(8, 16));
        pictureShortRangeChart.setName("pictureShortRangeChart");
        pictureShortRangeChart.setSize(new Dimension(160, 145));
        pictureShortRangeChart.setTabIndex(1);
        pictureShortRangeChart.setTabStop(false);
        pictureShortRangeChart.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, Graphics data) {
                pictureShortRangeChartPaint(data);
            }
        });
        pictureShortRangeChart.setMouseDown(new EventHandler<>() {
            @Override
            public void handle(Object sender, MouseEventData data) {
                pictureShortRangeChartMouseDown(data);
            }
        });
        // statusBar
        statusBar.setLocation(new Point(0, 481)); // TODO layout hardcoded, use layout manager
        statusBar.setName("statusBar");
        statusBar.addAll(Arrays.asList(statusBarPanelCash, statusBarPanelBays, statusBarPanelCosts, statusBarPanelExtra));
        statusBar.showPanels = true;
        statusBar.setSize(new Dimension(768, 24));
        statusBar.sizingGrip = false;
        statusBar.setTabIndex(2);
        statusBar.panelClick = new EventHandler<>() {
            @Override
            public void handle(Object sender, StatusBarPanel data) {
                statusBarPanelClick(data);
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

        // boxShortRangeChart
        boxShortRangeChart.anchor = AnchorStyle.Top_Right;
        boxShortRangeChart.controls.add(pictureShortRangeChart);
        boxShortRangeChart.setLocation(new Point(364, 306));
        boxShortRangeChart.setName("boxShortRangeChart");
        boxShortRangeChart.setSize(new Dimension(176, 168));
        boxShortRangeChart.setTabIndex(6);
        boxShortRangeChart.setTabStop(false);
        boxShortRangeChart.setText("Short-Range Chart");
        // boxGalacticChart
        boxGalacticChart.anchor = AnchorStyle.Top_Right;
        boxGalacticChart.setBackgroundColor(Constants.ColorControl);
        boxGalacticChart.controls.add(labelWormhole);
        boxGalacticChart.controls.add(labelWormholeLabel);
        boxGalacticChart.controls.add(buttonJump);
        boxGalacticChart.controls.add(buttonFind);
        boxGalacticChart.controls.add(pictureGalacticChart);
        boxGalacticChart.setLocation(new Point(180, 306));
        boxGalacticChart.setName("boxGalacticChart");
        boxGalacticChart.setSize(new Dimension(176, 168));
        boxGalacticChart.setTabIndex(5);
        boxGalacticChart.setTabStop(false);
        boxGalacticChart.setText("Galactic Chart");
        // labelWormhole
        labelWormhole.setLocation(new Point(8, 148));
        labelWormhole.setName("labelWormhole");
        labelWormhole.setSize(new Dimension(72, 13));
        labelWormhole.setTabIndex(29);
        labelWormhole.setText("Tarchannen");
        // labelWormholeLabel
        labelWormholeLabel.setLocation(new Point(8, 135));
        labelWormholeLabel.setName("labelWormholeLabel");
        labelWormholeLabel.setSize(new Dimension(72, 13));
        labelWormholeLabel.setTabIndex(28);
        labelWormholeLabel.setText("Wormhole to");
        // buttonJump
        buttonJump.setFlatStyle(FlatStyle.Flat);
        buttonJump.setLocation(new Point(81, 138));
        buttonJump.setName("buttonJump");
        buttonJump.setSize(new Dimension(42, 22));
        buttonJump.setTabIndex(55);
        buttonJump.setText("Jump");
        buttonJump.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJumpClick();
            }
        });
        // buttonFind
        buttonFind.setFlatStyle(FlatStyle.Flat);
        buttonFind.setLocation(new Point(132, 138));
        buttonFind.setName("buttonFind");
        buttonFind.setSize(new Dimension(36, 22));
        buttonFind.setTabIndex(56);
        buttonFind.setText("Find");
        buttonFind.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonFindClick();
            }
        });
        // boxTargetSystem
        boxTargetSystem.anchor = AnchorStyle.Top_Right;
        boxTargetSystem.controls.add(buttonTrack);
        boxTargetSystem.controls.add(buttonNextSystem);
        boxTargetSystem.controls.add(buttonPrevSystem);
        boxTargetSystem.controls.add(labelTargetOutOfRange);
        boxTargetSystem.controls.add(buttonWarp);
        boxTargetSystem.controls.add(labelTargetPolSys);
        boxTargetSystem.controls.add(labelTargetSize);
        boxTargetSystem.controls.add(labelTargetTech);
        boxTargetSystem.controls.add(labelTargetDistance);
        boxTargetSystem.controls.add(labelTargetPirates);
        boxTargetSystem.controls.add(labelTargetPolice);
        boxTargetSystem.controls.add(labelTargetResource);
        boxTargetSystem.controls.add(labelTargetDistanceLabel);
        boxTargetSystem.controls.add(labelTargetPiratesLabel);
        boxTargetSystem.controls.add(labelTargetPoliceLabel);
        boxTargetSystem.controls.add(labelTargetResourceLabel);
        boxTargetSystem.controls.add(labelTargetGovtLabel);
        boxTargetSystem.controls.add(labelTargetTechLabel);
        boxTargetSystem.controls.add(labelTargetSizeLabel);
        boxTargetSystem.controls.add(labelTargetName);
        boxTargetSystem.controls.add(labelTargetNameLabel);
        boxTargetSystem.setLocation(new Point(548, 306));
        boxTargetSystem.setName("boxTargetSystem");
        boxTargetSystem.setSize(new Dimension(216, 168));
        boxTargetSystem.setTabIndex(7);
        boxTargetSystem.setTabStop(false);
        boxTargetSystem.setText("Target System");
        // buttonTrack
        buttonTrack.setFlatStyle(FlatStyle.Flat);
        buttonTrack.setLocation(new Point(160, 140));
        buttonTrack.setName("buttonTrack");
        buttonTrack.setSize(new Dimension(44, 22));
        buttonTrack.setTabIndex(60);
        buttonTrack.setText("Track");
        buttonTrack.setVisible(false);
        buttonTrack.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonTrackClick();
            }
        });
        // buttonNextSystem
        buttonNextSystem.setFlatStyle(FlatStyle.Flat);
        buttonNextSystem.setLocation(new Point(186, 16));
        buttonNextSystem.setName("buttonNextSystem");
        buttonNextSystem.setSize(new Dimension(18, 18));
        buttonNextSystem.setTabIndex(58);
        buttonNextSystem.setText(">");
        buttonNextSystem.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonNextSystemClick();
            }
        });
        // buttonPrevSystem
        buttonPrevSystem.setFlatStyle(FlatStyle.Flat);
        buttonPrevSystem.setLocation(new Point(160, 16));
        buttonPrevSystem.setName("buttonPrevSystem");
        buttonPrevSystem.setSize(new Dimension(18, 18));
        buttonPrevSystem.setTabIndex(57);
        buttonPrevSystem.setText("<");
        buttonPrevSystem.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonPrevSystemClick();
            }
        });
        // labelTargetOutOfRange
        labelTargetOutOfRange.setLocation(new Point(8, 144));
        labelTargetOutOfRange.setName("labelTargetOutOfRange");
        labelTargetOutOfRange.setSize(new Dimension(144, 13));
        labelTargetOutOfRange.setTabIndex(17);
        labelTargetOutOfRange.setText("This system is out of range.");
        // buttonWarp
        buttonWarp.setFlatStyle(FlatStyle.Flat);
        buttonWarp.setLocation(new Point(160, 98));
        buttonWarp.setName("buttonWarp");
        buttonWarp.setSize(new Dimension(44, 44));
        buttonWarp.setTabIndex(59);
        buttonWarp.setText("Warp");
        buttonWarp.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonWarpClick();
            }
        });
        // labelTargetPolSys
        labelTargetPolSys.setLocation(new Point(88, 64));
        labelTargetPolSys.setName("labelTargetPolSys");
        labelTargetPolSys.setSize(new Dimension(91, 13));
        labelTargetPolSys.setTabIndex(15);
        labelTargetPolSys.setText("Communist State");
        // labelTargetSize
        labelTargetSize.setLocation(new Point(88, 32));
        labelTargetSize.setName("labelTargetSize");
        labelTargetSize.setSize(new Dimension(45, 13));
        labelTargetSize.setTabIndex(14);
        labelTargetSize.setText("Medium");
        // labelTargetTech
        labelTargetTech.setLocation(new Point(88, 48));
        labelTargetTech.setName("labelTargetTech");
        labelTargetTech.setSize(new Dimension(82, 13));
        labelTargetTech.setTabIndex(13);
        labelTargetTech.setText("Pre-Agricultural");
        // labelTargetDistance
        labelTargetDistance.setLocation(new Point(88, 128));
        labelTargetDistance.setName("labelTargetDistance");
        labelTargetDistance.setSize(new Dimension(66, 13));
        labelTargetDistance.setTabIndex(12);
        labelTargetDistance.setText("888 parsecs");
        // labelTargetPirates
        labelTargetPirates.setLocation(new Point(88, 112));
        labelTargetPirates.setName("labelTargetPirates");
        labelTargetPirates.setSize(new Dimension(53, 13));
        labelTargetPirates.setTabIndex(11);
        labelTargetPirates.setText("Abundant");
        // labelTargetPolice
        labelTargetPolice.setLocation(new Point(88, 96));
        labelTargetPolice.setName("labelTargetPolice");
        labelTargetPolice.setSize(new Dimension(53, 13));
        labelTargetPolice.setTabIndex(10);
        labelTargetPolice.setText("Abundant");
        // labelTargetResource
        labelTargetResource.setLocation(new Point(88, 80));
        labelTargetResource.setName("labelTargetResource");
        labelTargetResource.setSize(new Dimension(105, 13));
        labelTargetResource.setTabIndex(9);
        labelTargetResource.setText("Sweetwater Oceans");
        // labelTargetDistanceLabel
        labelTargetDistanceLabel.setAutoSize(true);
        labelTargetDistanceLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTargetDistanceLabel.setLocation(new Point(8, 128));
        labelTargetDistanceLabel.setName("labelTargetDistanceLabel");
        labelTargetDistanceLabel.setSize(new Dimension(53, 16));
        labelTargetDistanceLabel.setTabIndex(8);
        labelTargetDistanceLabel.setText("Distance:");
        // labelTargetPiratesLabel
        labelTargetPiratesLabel.setAutoSize(true);
        labelTargetPiratesLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTargetPiratesLabel.setLocation(new Point(8, 112));
        labelTargetPiratesLabel.setName("labelTargetPiratesLabel");
        labelTargetPiratesLabel.setSize(new Dimension(44, 16));
        labelTargetPiratesLabel.setTabIndex(7);
        labelTargetPiratesLabel.setText("Pirates:");
        // labelTargetPoliceLabel
        labelTargetPoliceLabel.setAutoSize(true);
        labelTargetPoliceLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTargetPoliceLabel.setLocation(new Point(8, 96));
        labelTargetPoliceLabel.setName("labelTargetPoliceLabel");
        labelTargetPoliceLabel.setSize(new Dimension(40, 16));
        labelTargetPoliceLabel.setTabIndex(6);
        labelTargetPoliceLabel.setText("Police:");
        // labelTargetResourceLabel
        labelTargetResourceLabel.setAutoSize(true);
        labelTargetResourceLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTargetResourceLabel.setLocation(new Point(8, 80));
        labelTargetResourceLabel.setName("labelTargetResourceLabel");
        labelTargetResourceLabel.setSize(new Dimension(58, 16));
        labelTargetResourceLabel.setTabIndex(5);
        labelTargetResourceLabel.setText("Resource:");
        // labelTargetGovtLabel
        labelTargetGovtLabel.setAutoSize(true);
        labelTargetGovtLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTargetGovtLabel.setLocation(new Point(8, 64));
        labelTargetGovtLabel.setName("labelTargetGovtLabel");
        labelTargetGovtLabel.setSize(new Dimension(72, 16));
        labelTargetGovtLabel.setTabIndex(4);
        labelTargetGovtLabel.setText("Government:");
        // labelTargetTechLabel
        labelTargetTechLabel.setAutoSize(true);
        labelTargetTechLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTargetTechLabel.setLocation(new Point(8, 48));
        labelTargetTechLabel.setName("labelTargetTechLabel");
        labelTargetTechLabel.setSize(new Dimension(65, 16));
        labelTargetTechLabel.setTabIndex(3);
        labelTargetTechLabel.setText("Tech Level:");
        // labelTargetSizeLabel
        labelTargetSizeLabel.setAutoSize(true);
        labelTargetSizeLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F)); // TODO many things repeating, like setAutoSize, setFont, ... move to convenience function
        labelTargetSizeLabel.setLocation(new Point(8, 32));
        labelTargetSizeLabel.setName("labelTargetSizeLabel");
        labelTargetSizeLabel.setSize(new Dimension(31, 16));
        labelTargetSizeLabel.setTabIndex(2);
        labelTargetSizeLabel.setText("Size:");
        // labelTargetName
        labelTargetName.setLocation(new Point(88, 16));
        labelTargetName.setName("labelTargetName");  // TODO are these names really used for anything?
        labelTargetName.setSize(new Dimension(65, 13));
        labelTargetName.setTabIndex(1);
        labelTargetName.setText("Tarchannen");
        // labelTargetNameLabel
        labelTargetNameLabel.setAutoSize(true);
        labelTargetNameLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTargetNameLabel.setLocation(new Point(8, 16));
        labelTargetNameLabel.setName("labelTargetNameLabel");
        labelTargetNameLabel.setSize(new Dimension(39, 16));
        labelTargetNameLabel.setTabIndex(0);
        labelTargetNameLabel.setText("Name:");
        // boxCargo
        boxCargo.anchor = AnchorStyle.Top_Right;
        boxCargo.controls.add(pictureCargoLine3);
        boxCargo.controls.add(pictureCargoLine2);
        boxCargo.controls.add(pictureCargoLine0);
        boxCargo.controls.add(pictureCargoLine1);
        boxCargo.controls.add(labelTargetPct9);
        boxCargo.controls.add(labelTargetDiff9);
        boxCargo.controls.add(labelTargetPrice9);
        boxCargo.controls.add(buttonBuyMax9);
        boxCargo.controls.add(buttonBuyQuantity9);
        boxCargo.controls.add(labelBuyPrice9);
        boxCargo.controls.add(buttonSellAll9);
        boxCargo.controls.add(buttonSellQuantity9);
        boxCargo.controls.add(labelSellPrice9);
        boxCargo.controls.add(labelTargetPct8);
        boxCargo.controls.add(labelTargetDiff8);
        boxCargo.controls.add(labelTargetPrice8);
        boxCargo.controls.add(buttonBuyMax8);
        boxCargo.controls.add(buttonBuyQuantity8);
        boxCargo.controls.add(labelBuyPrice8);
        boxCargo.controls.add(buttonSellAll8);
        boxCargo.controls.add(buttonSellQuantity8);
        boxCargo.controls.add(labelSellPrice8);
        boxCargo.controls.add(labelTargetPct7);
        boxCargo.controls.add(labelTargetDiff7);
        boxCargo.controls.add(labelTargetPrice7);
        boxCargo.controls.add(buttonBuyMax7);
        boxCargo.controls.add(buttonBuyQuantity7);
        boxCargo.controls.add(labelBuyPrice7);
        boxCargo.controls.add(buttonSellAll7);
        boxCargo.controls.add(buttonSellQuantity7);
        boxCargo.controls.add(labelSellPrice7);
        boxCargo.controls.add(labelTargetPct6);
        boxCargo.controls.add(labelTargetDiff6);
        boxCargo.controls.add(labelTargetPrice6);
        boxCargo.controls.add(buttonBuyMax6);
        boxCargo.controls.add(buttonBuyQuantity6);
        boxCargo.controls.add(labelBuyPrice6);
        boxCargo.controls.add(buttonSellAll6);
        boxCargo.controls.add(buttonSellQuantity6);
        boxCargo.controls.add(labelSellPrice6);
        boxCargo.controls.add(labelTargetPct5);
        boxCargo.controls.add(labelTargetDiff5);
        boxCargo.controls.add(labelTargetPrice5);
        boxCargo.controls.add(buttonBuyMax5);
        boxCargo.controls.add(buttonBuyQuantity5);
        boxCargo.controls.add(labelBuyPrice5);
        boxCargo.controls.add(buttonSellAll5);
        boxCargo.controls.add(buttonSellQuantity5);
        boxCargo.controls.add(labelSellPrice5);
        boxCargo.controls.add(labelTargetPct4);
        boxCargo.controls.add(labelTargetDiff4);
        boxCargo.controls.add(labelTargetPrice4);
        boxCargo.controls.add(buttonBuyMax4);
        boxCargo.controls.add(buttonBuyQuantity4);
        boxCargo.controls.add(labelBuyPrice4);
        boxCargo.controls.add(buttonSellAll4);
        boxCargo.controls.add(buttonSellQuantity4);
        boxCargo.controls.add(labelSellPrice4);
        boxCargo.controls.add(labelTargetPct3);
        boxCargo.controls.add(labelTargetDiff3);
        boxCargo.controls.add(labelTargetPrice3);
        boxCargo.controls.add(buttonBuyMax3);
        boxCargo.controls.add(buttonBuyQuantity3);
        boxCargo.controls.add(labelBuyPrice3);
        boxCargo.controls.add(buttonSellAll3);
        boxCargo.controls.add(buttonSellQuantity3);
        boxCargo.controls.add(labelSellPrice3);
        boxCargo.controls.add(labelTargetPct2);
        boxCargo.controls.add(labelTargetDiff2);
        boxCargo.controls.add(labelTargetPrice2);
        boxCargo.controls.add(buttonBuyMax2);
        boxCargo.controls.add(buttonBuyQuantity2);
        boxCargo.controls.add(labelBuyPrice2);
        boxCargo.controls.add(buttonSellAll2);
        boxCargo.controls.add(buttonSellQuantity2);
        boxCargo.controls.add(labelSellPrice2);
        boxCargo.controls.add(labelTargetPct1);
        boxCargo.controls.add(labelTargetDiff1);
        boxCargo.controls.add(labelTargetPrice1);
        boxCargo.controls.add(buttonBuyMax1);
        boxCargo.controls.add(buttonBuyQuantity1);
        boxCargo.controls.add(labelBuyPrice1);
        boxCargo.controls.add(labelTargetPctLabel);
        boxCargo.controls.add(labelTargetDiffLabel);
        boxCargo.controls.add(labelTargetPriceLabel);
        boxCargo.controls.add(labelTargetPct0);
        boxCargo.controls.add(labelTargetDiff0);
        boxCargo.controls.add(labelTargetPrice0);
        boxCargo.controls.add(buttonBuyMax0);
        boxCargo.controls.add(buttonBuyQuantity0);
        boxCargo.controls.add(labelBuyPrice0);
        boxCargo.controls.add(buttonSellAll1);
        boxCargo.controls.add(buttonSellQuantity1);
        boxCargo.controls.add(labelSellPrice1);
        boxCargo.controls.add(buttonSellAll0);
        boxCargo.controls.add(buttonSellQuantity0);
        boxCargo.controls.add(labelSellPrice0);
        boxCargo.controls.add(labelTradeTarget);
        boxCargo.controls.add(labelBuy);
        boxCargo.controls.add(labelSell);
        boxCargo.controls.add(labelTradeCommodity9);
        boxCargo.controls.add(labelTradeCommodity8);
        boxCargo.controls.add(labelTradeCommodity2);
        boxCargo.controls.add(labelTradeCommodity0);
        boxCargo.controls.add(labelTradeCommodity1);
        boxCargo.controls.add(labelTradeCommodity6);
        boxCargo.controls.add(labelTradeCommodity5);
        boxCargo.controls.add(labelTradeCommodity4);
        boxCargo.controls.add(labelTradeCommodity3);
        boxCargo.controls.add(labelTradeCommodity7);
        boxCargo.setLocation(new Point(252, 2));
        boxCargo.setName("boxCargo");
        boxCargo.setSize(new Dimension(512, 300));
        boxCargo.setTabIndex(8);
        boxCargo.setTabStop(false);
        boxCargo.setText("Cargo");
        // pictureCargoLine3
        pictureCargoLine3.setBackgroundColor(java.awt.Color.darkGray);
        pictureCargoLine3.setLocation(new Point(8, 52));
        pictureCargoLine3.setName("pictureCargoLine3");
        pictureCargoLine3.setSize(new Dimension(496, 1));
        pictureCargoLine3.setTabIndex(131);
        pictureCargoLine3.setTabStop(false);
        // pictureCargoLine2
        pictureCargoLine2.setBackgroundColor(java.awt.Color.darkGray);
        pictureCargoLine2.setLocation(new Point(352, 32));
        pictureCargoLine2.setName("pictureCargoLine2");
        pictureCargoLine2.setSize(new Dimension(1, 262));
        pictureCargoLine2.setTabIndex(130);
        pictureCargoLine2.setTabStop(false);
        // pictureCargoLine0
        pictureCargoLine0.setBackgroundColor(java.awt.Color.darkGray);
        pictureCargoLine0.setLocation(new Point(71, 32));
        pictureCargoLine0.setName("pictureCargoLine0");
        pictureCargoLine0.setSize(new Dimension(1, 262));
        pictureCargoLine0.setTabIndex(129);
        pictureCargoLine0.setTabStop(false);
        // pictureCargoLine1
        pictureCargoLine1.setBackgroundColor(java.awt.Color.darkGray);
        pictureCargoLine1.setLocation(new Point(218, 32));
        pictureCargoLine1.setName("pictureCargoLine1");
        pictureCargoLine1.setSize(new Dimension(1, 262));
        pictureCargoLine1.setTabIndex(128);
        pictureCargoLine1.setTabStop(false);
        // labelTargetPct9
        labelTargetPct9.setLocation(new Point(466, 276));
        labelTargetPct9.setName("labelTargetPct9");
        labelTargetPct9.setSize(new Dimension(37, 13));
        labelTargetPct9.setTabIndex(127);
        labelTargetPct9.setText("--------");
        labelTargetPct9.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff9
        labelTargetDiff9.setLocation(new Point(410, 276));
        labelTargetDiff9.setName("labelTargetDiff9");
        labelTargetDiff9.setSize(new Dimension(52, 13));
        labelTargetDiff9.setTabIndex(126);
        labelTargetDiff9.setText("------------");
        labelTargetDiff9.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice9
        labelTargetPrice9.setLocation(new Point(358, 276));
        labelTargetPrice9.setName("labelTargetPrice9");
        labelTargetPrice9.setSize(new Dimension(48, 13));
        labelTargetPrice9.setTabIndex(125);
        labelTargetPrice9.setText("-----------");
        labelTargetPrice9.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax9
        buttonBuyMax9.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax9.setLocation(new Point(262, 272));
        buttonBuyMax9.setName("buttonBuyMax9");
        buttonBuyMax9.setSize(new Dimension(36, 22));
        buttonBuyMax9.setTabIndex(51);
        buttonBuyMax9.setText("Max");
        buttonBuyMax9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity9
        buttonBuyQuantity9.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity9.setLocation(new Point(227, 272));
        buttonBuyQuantity9.setName("buttonBuyQuantity9");
        buttonBuyQuantity9.setSize(new Dimension(28, 22));
        buttonBuyQuantity9.setTabIndex(50);
        buttonBuyQuantity9.setText("88");
        buttonBuyQuantity9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice9
        labelBuyPrice9.setLocation(new Point(302, 276));
        labelBuyPrice9.setName("labelBuyPrice9");
        labelBuyPrice9.setSize(new Dimension(48, 13));
        labelBuyPrice9.setTabIndex(122);
        labelBuyPrice9.setText("not sold");
        labelBuyPrice9.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll9
        buttonSellAll9.setFlatStyle(FlatStyle.Flat);
        buttonSellAll9.setLocation(new Point(115, 272));
        buttonSellAll9.setName("buttonSellAll9");
        buttonSellAll9.setSize(new Dimension(44, 22));
        buttonSellAll9.setTabIndex(49);
        buttonSellAll9.setText("Dump");
        buttonSellAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity9
        buttonSellQuantity9.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity9.setLocation(new Point(80, 272));
        buttonSellQuantity9.setName("buttonSellQuantity9");
        buttonSellQuantity9.setSize(new Dimension(28, 22));
        buttonSellQuantity9.setTabIndex(48);
        buttonSellQuantity9.setText("88");
        buttonSellQuantity9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice9
        labelSellPrice9.setLocation(new Point(163, 276));
        labelSellPrice9.setName("labelSellPrice9");
        labelSellPrice9.setSize(new Dimension(48, 13));
        labelSellPrice9.setTabIndex(119);
        labelSellPrice9.setText("no trade");
        labelSellPrice9.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct8
        labelTargetPct8.setLocation(new Point(466, 252));
        labelTargetPct8.setName("labelTargetPct8");
        labelTargetPct8.setSize(new Dimension(37, 13));
        labelTargetPct8.setTabIndex(118);
        labelTargetPct8.setText("-888%");
        labelTargetPct8.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff8
        labelTargetDiff8.setLocation(new Point(410, 252));
        labelTargetDiff8.setName("labelTargetDiff8");
        labelTargetDiff8.setSize(new Dimension(52, 13));
        labelTargetDiff8.setTabIndex(117);
        labelTargetDiff8.setText("-8,888 cr.");
        labelTargetDiff8.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice8
        labelTargetPrice8.setLocation(new Point(358, 252));
        labelTargetPrice8.setName("labelTargetPrice8");
        labelTargetPrice8.setSize(new Dimension(48, 13));
        labelTargetPrice8.setTabIndex(116);
        labelTargetPrice8.setText("8,888 cr.");
        labelTargetPrice8.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax8
        buttonBuyMax8.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax8.setLocation(new Point(262, 248));
        buttonBuyMax8.setName("buttonBuyMax8");
        buttonBuyMax8.setSize(new Dimension(36, 22));
        buttonBuyMax8.setTabIndex(47);
        buttonBuyMax8.setText("Max");
        buttonBuyMax8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity8
        buttonBuyQuantity8.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity8.setLocation(new Point(227, 248));
        buttonBuyQuantity8.setName("buttonBuyQuantity8");
        buttonBuyQuantity8.setSize(new Dimension(28, 22));
        buttonBuyQuantity8.setTabIndex(46);
        buttonBuyQuantity8.setText("88");
        buttonBuyQuantity8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice8
        labelBuyPrice8.setLocation(new Point(302, 252));
        labelBuyPrice8.setName("labelBuyPrice8");
        labelBuyPrice8.setSize(new Dimension(48, 13));
        labelBuyPrice8.setTabIndex(113);
        labelBuyPrice8.setText("8,888 cr.");
        labelBuyPrice8.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll8
        buttonSellAll8.setFlatStyle(FlatStyle.Flat);
        buttonSellAll8.setLocation(new Point(115, 248));
        buttonSellAll8.setName("buttonSellAll8");
        buttonSellAll8.setSize(new Dimension(44, 22));
        buttonSellAll8.setTabIndex(45);
        buttonSellAll8.setText("All");
        buttonSellAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity8
        buttonSellQuantity8.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity8.setLocation(new Point(80, 248));
        buttonSellQuantity8.setName("buttonSellQuantity8");
        buttonSellQuantity8.setSize(new Dimension(28, 22));
        buttonSellQuantity8.setTabIndex(44);
        buttonSellQuantity8.setText("88");
        buttonSellQuantity8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice8
        labelSellPrice8.setLocation(new Point(163, 252));
        labelSellPrice8.setName("labelSellPrice8");
        labelSellPrice8.setSize(new Dimension(48, 13));
        labelSellPrice8.setTabIndex(110);
        labelSellPrice8.setText("8,888 cr.");
        labelSellPrice8.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct7
        labelTargetPct7.setLocation(new Point(466, 228));
        labelTargetPct7.setName("labelTargetPct7");
        labelTargetPct7.setSize(new Dimension(37, 13));
        labelTargetPct7.setTabIndex(109);
        labelTargetPct7.setText("-888%");
        labelTargetPct7.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff7
        labelTargetDiff7.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Regular, (int) 8.25F));
        labelTargetDiff7.setLocation(new Point(410, 228));
        labelTargetDiff7.setName("labelTargetDiff7");
        labelTargetDiff7.setSize(new Dimension(52, 13));
        labelTargetDiff7.setTabIndex(108);
        labelTargetDiff7.setText("-8,888 cr.");
        labelTargetDiff7.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice7
        labelTargetPrice7.setLocation(new Point(358, 228));
        labelTargetPrice7.setName("labelTargetPrice7");
        labelTargetPrice7.setSize(new Dimension(48, 13));
        labelTargetPrice7.setTabIndex(107);
        labelTargetPrice7.setText("8,888 cr.");
        labelTargetPrice7.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax7
        buttonBuyMax7.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax7.setLocation(new Point(262, 224));
        buttonBuyMax7.setName("buttonBuyMax7");
        buttonBuyMax7.setSize(new Dimension(36, 22));
        buttonBuyMax7.setTabIndex(43);
        buttonBuyMax7.setText("Max");
        buttonBuyMax7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity7
        buttonBuyQuantity7.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity7.setLocation(new Point(227, 224));
        buttonBuyQuantity7.setName("buttonBuyQuantity7");
        buttonBuyQuantity7.setSize(new Dimension(28, 22));
        buttonBuyQuantity7.setTabIndex(42);
        buttonBuyQuantity7.setText("88");
        buttonBuyQuantity7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice7
        labelBuyPrice7.setLocation(new Point(302, 228));
        labelBuyPrice7.setName("labelBuyPrice7");
        labelBuyPrice7.setSize(new Dimension(48, 13));
        labelBuyPrice7.setTabIndex(104);
        labelBuyPrice7.setText("8,888 cr.");
        labelBuyPrice7.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll7
        buttonSellAll7.setFlatStyle(FlatStyle.Flat);
        buttonSellAll7.setLocation(new Point(115, 224));
        buttonSellAll7.setName("buttonSellAll7");
        buttonSellAll7.setSize(new Dimension(44, 22));
        buttonSellAll7.setTabIndex(41);
        buttonSellAll7.setText("All");
        buttonSellAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity7
        buttonSellQuantity7.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity7.setLocation(new Point(80, 224));
        buttonSellQuantity7.setName("buttonSellQuantity7");
        buttonSellQuantity7.setSize(new Dimension(28, 22));
        buttonSellQuantity7.setTabIndex(40);
        buttonSellQuantity7.setText("88");
        buttonSellQuantity7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice7
        labelSellPrice7.setLocation(new Point(163, 228));
        labelSellPrice7.setName("labelSellPrice7");
        labelSellPrice7.setSize(new Dimension(48, 13));
        labelSellPrice7.setTabIndex(101);
        labelSellPrice7.setText("8,888 cr.");
        labelSellPrice7.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct6
        labelTargetPct6.setLocation(new Point(466, 204));
        labelTargetPct6.setName("labelTargetPct6");
        labelTargetPct6.setSize(new Dimension(37, 13));
        labelTargetPct6.setTabIndex(100);
        labelTargetPct6.setText("-888%");
        labelTargetPct6.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff6
        labelTargetDiff6.setLocation(new Point(410, 204));
        labelTargetDiff6.setName("labelTargetDiff6");
        labelTargetDiff6.setSize(new Dimension(52, 13));
        labelTargetDiff6.setTabIndex(99);
        labelTargetDiff6.setText("-8,888 cr.");
        labelTargetDiff6.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice6
        labelTargetPrice6.setLocation(new Point(358, 204));
        labelTargetPrice6.setName("labelTargetPrice6");
        labelTargetPrice6.setSize(new Dimension(48, 13));
        labelTargetPrice6.setTabIndex(98);
        labelTargetPrice6.setText("8,888 cr.");
        labelTargetPrice6.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax6
        buttonBuyMax6.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax6.setLocation(new Point(262, 200));
        buttonBuyMax6.setName("buttonBuyMax6");
        buttonBuyMax6.setSize(new Dimension(36, 22));
        buttonBuyMax6.setTabIndex(39);
        buttonBuyMax6.setText("Max");
        buttonBuyMax6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity6
        buttonBuyQuantity6.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity6.setLocation(new Point(227, 200));
        buttonBuyQuantity6.setName("buttonBuyQuantity6");
        buttonBuyQuantity6.setSize(new Dimension(28, 22));
        buttonBuyQuantity6.setTabIndex(38);
        buttonBuyQuantity6.setText("88");
        buttonBuyQuantity6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice6
        labelBuyPrice6.setLocation(new Point(302, 204));
        labelBuyPrice6.setName("labelBuyPrice6");
        labelBuyPrice6.setSize(new Dimension(48, 13));
        labelBuyPrice6.setTabIndex(95);
        labelBuyPrice6.setText("8,888 cr.");
        labelBuyPrice6.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll6
        buttonSellAll6.setFlatStyle(FlatStyle.Flat);
        buttonSellAll6.setLocation(new Point(115, 200));
        buttonSellAll6.setName("buttonSellAll6");
        buttonSellAll6.setSize(new Dimension(44, 22));
        buttonSellAll6.setTabIndex(37);
        buttonSellAll6.setText("All");
        buttonSellAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity6
        buttonSellQuantity6.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity6.setLocation(new Point(80, 200));
        buttonSellQuantity6.setName("buttonSellQuantity6");
        buttonSellQuantity6.setSize(new Dimension(28, 22));
        buttonSellQuantity6.setTabIndex(36);
        buttonSellQuantity6.setText("88");
        buttonSellQuantity6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice6
        labelSellPrice6.setLocation(new Point(163, 204));
        labelSellPrice6.setName("labelSellPrice6");
        labelSellPrice6.setSize(new Dimension(48, 13));
        labelSellPrice6.setTabIndex(92);
        labelSellPrice6.setText("8,888 cr.");
        labelSellPrice6.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct5
        labelTargetPct5.setLocation(new Point(466, 180));
        labelTargetPct5.setName("labelTargetPct5");
        labelTargetPct5.setSize(new Dimension(37, 13));
        labelTargetPct5.setTabIndex(91);
        labelTargetPct5.setText("-888%");
        labelTargetPct5.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff5
        labelTargetDiff5.setLocation(new Point(410, 180));
        labelTargetDiff5.setName("labelTargetDiff5");
        labelTargetDiff5.setSize(new Dimension(52, 13));
        labelTargetDiff5.setTabIndex(90);
        labelTargetDiff5.setText("-8,888 cr.");
        labelTargetDiff5.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice5
        labelTargetPrice5.setLocation(new Point(358, 180));
        labelTargetPrice5.setName("labelTargetPrice5");
        labelTargetPrice5.setSize(new Dimension(48, 13));
        labelTargetPrice5.setTabIndex(89);
        labelTargetPrice5.setText("8,888 cr.");
        labelTargetPrice5.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax5
        buttonBuyMax5.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax5.setLocation(new Point(262, 176));
        buttonBuyMax5.setName("buttonBuyMax5");
        buttonBuyMax5.setSize(new Dimension(36, 22));
        buttonBuyMax5.setTabIndex(35);
        buttonBuyMax5.setText("Max");
        buttonBuyMax5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity5
        buttonBuyQuantity5.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity5.setLocation(new Point(227, 176));
        buttonBuyQuantity5.setName("buttonBuyQuantity5");
        buttonBuyQuantity5.setSize(new Dimension(28, 22));
        buttonBuyQuantity5.setTabIndex(34);
        buttonBuyQuantity5.setText("88");
        buttonBuyQuantity5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice5
        labelBuyPrice5.setLocation(new Point(302, 180));
        labelBuyPrice5.setName("labelBuyPrice5");
        labelBuyPrice5.setSize(new Dimension(48, 13));
        labelBuyPrice5.setTabIndex(86);
        labelBuyPrice5.setText("8,888 cr.");
        labelBuyPrice5.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll5
        buttonSellAll5.setFlatStyle(FlatStyle.Flat);
        buttonSellAll5.setLocation(new Point(115, 176));
        buttonSellAll5.setName("buttonSellAll5");
        buttonSellAll5.setSize(new Dimension(44, 22));
        buttonSellAll5.setTabIndex(33);
        buttonSellAll5.setText("All");
        buttonSellAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity5
        buttonSellQuantity5.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity5.setLocation(new Point(80, 176));
        buttonSellQuantity5.setName("buttonSellQuantity5");
        buttonSellQuantity5.setSize(new Dimension(28, 22));
        buttonSellQuantity5.setTabIndex(32);
        buttonSellQuantity5.setText("88");
        buttonSellQuantity5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice5
        labelSellPrice5.setLocation(new Point(163, 180));
        labelSellPrice5.setName("labelSellPrice5");
        labelSellPrice5.setSize(new Dimension(48, 13));
        labelSellPrice5.setTabIndex(83);
        labelSellPrice5.setText("8,888 cr.");
        labelSellPrice5.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct4
        labelTargetPct4.setLocation(new Point(466, 156));
        labelTargetPct4.setName("labelTargetPct4");
        labelTargetPct4.setSize(new Dimension(37, 13));
        labelTargetPct4.setTabIndex(82);
        labelTargetPct4.setText("-888%");
        labelTargetPct4.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff4
        labelTargetDiff4.setLocation(new Point(410, 156));
        labelTargetDiff4.setName("labelTargetDiff4");
        labelTargetDiff4.setSize(new Dimension(52, 13));
        labelTargetDiff4.setTabIndex(81);
        labelTargetDiff4.setText("-8,888 cr.");
        labelTargetDiff4.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice4
        labelTargetPrice4.setLocation(new Point(358, 156));
        labelTargetPrice4.setName("labelTargetPrice4");
        labelTargetPrice4.setSize(new Dimension(48, 13));
        labelTargetPrice4.setTabIndex(80);
        labelTargetPrice4.setText("8,888 cr.");
        labelTargetPrice4.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax4
        buttonBuyMax4.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax4.setLocation(new Point(262, 152));
        buttonBuyMax4.setName("buttonBuyMax4");
        buttonBuyMax4.setSize(new Dimension(36, 22));
        buttonBuyMax4.setTabIndex(31);
        buttonBuyMax4.setText("Max");
        buttonBuyMax4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity4
        buttonBuyQuantity4.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity4.setLocation(new Point(227, 152));
        buttonBuyQuantity4.setName("buttonBuyQuantity4");
        buttonBuyQuantity4.setSize(new Dimension(28, 22));
        buttonBuyQuantity4.setTabIndex(30);
        buttonBuyQuantity4.setText("88");
        buttonBuyQuantity4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice4
        labelBuyPrice4.setLocation(new Point(302, 156));
        labelBuyPrice4.setName("labelBuyPrice4");
        labelBuyPrice4.setSize(new Dimension(48, 13));
        labelBuyPrice4.setTabIndex(77);
        labelBuyPrice4.setText("8,888 cr.");
        labelBuyPrice4.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll4
        buttonSellAll4.setFlatStyle(FlatStyle.Flat);
        buttonSellAll4.setLocation(new Point(115, 152));
        buttonSellAll4.setName("buttonSellAll4");
        buttonSellAll4.setSize(new Dimension(44, 22));
        buttonSellAll4.setTabIndex(29);
        buttonSellAll4.setText("All");
        buttonSellAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity4
        buttonSellQuantity4.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity4.setLocation(new Point(80, 152));
        buttonSellQuantity4.setName("buttonSellQuantity4");
        buttonSellQuantity4.setSize(new Dimension(28, 22));
        buttonSellQuantity4.setTabIndex(28);
        buttonSellQuantity4.setText("88");
        buttonSellQuantity4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice4
        labelSellPrice4.setLocation(new Point(163, 156));
        labelSellPrice4.setName("labelSellPrice4");
        labelSellPrice4.setSize(new Dimension(48, 13));
        labelSellPrice4.setTabIndex(74);
        labelSellPrice4.setText("8,888 cr.");
        labelSellPrice4.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct3
        labelTargetPct3.setLocation(new Point(466, 132));
        labelTargetPct3.setName("labelTargetPct3");
        labelTargetPct3.setSize(new Dimension(37, 13));
        labelTargetPct3.setTabIndex(73);
        labelTargetPct3.setText("-888%");
        labelTargetPct3.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff3
        labelTargetDiff3.setLocation(new Point(410, 132));
        labelTargetDiff3.setName("labelTargetDiff3");
        labelTargetDiff3.setSize(new Dimension(52, 13));
        labelTargetDiff3.setTabIndex(72);
        labelTargetDiff3.setText("-8,888 cr.");
        labelTargetDiff3.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice3
        labelTargetPrice3.setLocation(new Point(358, 132));
        labelTargetPrice3.setName("labelTargetPrice3");
        labelTargetPrice3.setSize(new Dimension(48, 13));
        labelTargetPrice3.setTabIndex(71);
        labelTargetPrice3.setText("8,888 cr.");
        labelTargetPrice3.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax3
        buttonBuyMax3.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax3.setLocation(new Point(262, 128));
        buttonBuyMax3.setName("buttonBuyMax3");
        buttonBuyMax3.setSize(new Dimension(36, 22));
        buttonBuyMax3.setTabIndex(27);
        buttonBuyMax3.setText("Max");
        buttonBuyMax3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity3
        buttonBuyQuantity3.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity3.setLocation(new Point(227, 128));
        buttonBuyQuantity3.setName("buttonBuyQuantity3");
        buttonBuyQuantity3.setSize(new Dimension(28, 22));
        buttonBuyQuantity3.setTabIndex(26);
        buttonBuyQuantity3.setText("88");
        buttonBuyQuantity3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice3
        labelBuyPrice3.setLocation(new Point(302, 132));
        labelBuyPrice3.setName("labelBuyPrice3");
        labelBuyPrice3.setSize(new Dimension(48, 13));
        labelBuyPrice3.setTabIndex(68);
        labelBuyPrice3.setText("8,888 cr.");
        labelBuyPrice3.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll3
        buttonSellAll3.setFlatStyle(FlatStyle.Flat);
        buttonSellAll3.setLocation(new Point(115, 128));
        buttonSellAll3.setName("buttonSellAll3");
        buttonSellAll3.setSize(new Dimension(44, 22));
        buttonSellAll3.setTabIndex(25);
        buttonSellAll3.setText("All");
        buttonSellAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity3
        buttonSellQuantity3.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity3.setLocation(new Point(80, 128));
        buttonSellQuantity3.setName("buttonSellQuantity3");
        buttonSellQuantity3.setSize(new Dimension(28, 22));
        buttonSellQuantity3.setTabIndex(24);
        buttonSellQuantity3.setText("88");
        buttonSellQuantity3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice3
        labelSellPrice3.setLocation(new Point(163, 132));
        labelSellPrice3.setName("labelSellPrice3");
        labelSellPrice3.setSize(new Dimension(48, 13));
        labelSellPrice3.setTabIndex(65);
        labelSellPrice3.setText("8,888 cr.");
        labelSellPrice3.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct2
        labelTargetPct2.setLocation(new Point(466, 108));
        labelTargetPct2.setName("labelTargetPct2");
        labelTargetPct2.setSize(new Dimension(37, 13));
        labelTargetPct2.setTabIndex(64);
        labelTargetPct2.setText("-888%");
        labelTargetPct2.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff2
        labelTargetDiff2.setLocation(new Point(410, 108));
        labelTargetDiff2.setName("labelTargetDiff2");
        labelTargetDiff2.setSize(new Dimension(52, 13));
        labelTargetDiff2.setTabIndex(63);
        labelTargetDiff2.setText("-8,888 cr.");
        labelTargetDiff2.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice2
        labelTargetPrice2.setLocation(new Point(358, 108));
        labelTargetPrice2.setName("labelTargetPrice2");
        labelTargetPrice2.setSize(new Dimension(48, 13));
        labelTargetPrice2.setTabIndex(62);
        labelTargetPrice2.setText("8,888 cr.");
        labelTargetPrice2.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax2
        buttonBuyMax2.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax2.setLocation(new Point(262, 104));
        buttonBuyMax2.setName("buttonBuyMax2");
        buttonBuyMax2.setSize(new Dimension(36, 22));
        buttonBuyMax2.setTabIndex(23);
        buttonBuyMax2.setText("Max");
        buttonBuyMax2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity2
        buttonBuyQuantity2.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity2.setLocation(new Point(227, 104));
        buttonBuyQuantity2.setName("buttonBuyQuantity2");
        buttonBuyQuantity2.setSize(new Dimension(28, 22));
        buttonBuyQuantity2.setTabIndex(22);
        buttonBuyQuantity2.setText("88");
        buttonBuyQuantity2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice2
        labelBuyPrice2.setLocation(new Point(302, 108));
        labelBuyPrice2.setName("labelBuyPrice2");
        labelBuyPrice2.setSize(new Dimension(48, 13));
        labelBuyPrice2.setTabIndex(59);
        labelBuyPrice2.setText("8,888 cr.");
        labelBuyPrice2.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll2
        buttonSellAll2.setFlatStyle(FlatStyle.Flat);
        buttonSellAll2.setLocation(new Point(115, 104));
        buttonSellAll2.setName("buttonSellAll2");
        buttonSellAll2.setSize(new Dimension(44, 22));
        buttonSellAll2.setTabIndex(21);
        buttonSellAll2.setText("All");
        buttonSellAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity2
        buttonSellQuantity2.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity2.setLocation(new Point(80, 104));
        buttonSellQuantity2.setName("buttonSellQuantity2");
        buttonSellQuantity2.setSize(new Dimension(28, 22));
        buttonSellQuantity2.setTabIndex(20);
        buttonSellQuantity2.setText("88");
        buttonSellQuantity2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice2
        labelSellPrice2.setLocation(new Point(163, 108));
        labelSellPrice2.setName("labelSellPrice2");
        labelSellPrice2.setSize(new Dimension(48, 13));
        labelSellPrice2.setTabIndex(56);
        labelSellPrice2.setText("8,888 cr.");
        labelSellPrice2.textAlignment = ContentAlignment.TopRight;
        // labelTargetPct1
        labelTargetPct1.setLocation(new Point(466, 84));
        labelTargetPct1.setName("labelTargetPct1");
        labelTargetPct1.setSize(new Dimension(37, 13));
        labelTargetPct1.setTabIndex(55);
        labelTargetPct1.setText("-888%");
        labelTargetPct1.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff1
        labelTargetDiff1.setLocation(new Point(410, 84));
        labelTargetDiff1.setName("labelTargetDiff1");
        labelTargetDiff1.setSize(new Dimension(52, 13));
        labelTargetDiff1.setTabIndex(54);
        labelTargetDiff1.setText("-8,888 cr.");
        labelTargetDiff1.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice1
        labelTargetPrice1.setLocation(new Point(358, 84));
        labelTargetPrice1.setName("labelTargetPrice1");
        labelTargetPrice1.setSize(new Dimension(48, 13));
        labelTargetPrice1.setTabIndex(53);
        labelTargetPrice1.setText("8,888 cr.");
        labelTargetPrice1.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax1
        buttonBuyMax1.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax1.setLocation(new Point(262, 80));
        buttonBuyMax1.setName("buttonBuyMax1");
        buttonBuyMax1.setSize(new Dimension(36, 22));
        buttonBuyMax1.setTabIndex(19);
        buttonBuyMax1.setText("Max");
        buttonBuyMax1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity1
        buttonBuyQuantity1.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity1.setLocation(new Point(227, 80));
        buttonBuyQuantity1.setName("buttonBuyQuantity1");
        buttonBuyQuantity1.setSize(new Dimension(28, 22));
        buttonBuyQuantity1.setTabIndex(18);
        buttonBuyQuantity1.setText("88");
        buttonBuyQuantity1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice1
        labelBuyPrice1.setLocation(new Point(302, 84));
        labelBuyPrice1.setName("labelBuyPrice1");
        labelBuyPrice1.setSize(new Dimension(48, 13));
        labelBuyPrice1.setTabIndex(50);
        labelBuyPrice1.setText("8,888 cr.");
        labelBuyPrice1.textAlignment = ContentAlignment.TopRight;
        // labelTargetPctLabel
        labelTargetPctLabel.setAutoSize(true);
        labelTargetPctLabel.setLocation(new Point(476, 34));
        labelTargetPctLabel.setName("labelTargetPctLabel");
        labelTargetPctLabel.setSize(new Dimension(14, 16));
        labelTargetPctLabel.setTabIndex(49);
        labelTargetPctLabel.setText("%");
        // labelTargetDiffLabel
        labelTargetDiffLabel.setAutoSize(true);
        labelTargetDiffLabel.setLocation(new Point(424, 34));
        labelTargetDiffLabel.setName("labelTargetDiffLabel");
        labelTargetDiffLabel.setSize(new Dimension(18, 16));
        labelTargetDiffLabel.setTabIndex(48);
        labelTargetDiffLabel.setText("+/-");
        // labelTargetPriceLabel
        labelTargetPriceLabel.setAutoSize(true);
        labelTargetPriceLabel.setLocation(new Point(360, 34));
        labelTargetPriceLabel.setName("labelTargetPriceLabel");
        labelTargetPriceLabel.setSize(new Dimension(30, 16));
        labelTargetPriceLabel.setTabIndex(47);
        labelTargetPriceLabel.setText("Price");
        // labelTargetPct0
        labelTargetPct0.setLocation(new Point(466, 60));
        labelTargetPct0.setName("labelTargetPct0");
        labelTargetPct0.setSize(new Dimension(37, 13));
        labelTargetPct0.setTabIndex(46);
        labelTargetPct0.setText("-888%");
        labelTargetPct0.textAlignment = ContentAlignment.TopRight;
        // labelTargetDiff0
        labelTargetDiff0.setLocation(new Point(410, 60));
        labelTargetDiff0.setName("labelTargetDiff0");
        labelTargetDiff0.setSize(new Dimension(52, 13));
        labelTargetDiff0.setTabIndex(45);
        labelTargetDiff0.setText("-8,888 cr.");
        labelTargetDiff0.textAlignment = ContentAlignment.TopRight;
        // labelTargetPrice0
        labelTargetPrice0.setLocation(new Point(358, 60));
        labelTargetPrice0.setName("labelTargetPrice0");
        labelTargetPrice0.setSize(new Dimension(48, 13));
        labelTargetPrice0.setTabIndex(44);
        labelTargetPrice0.setText("8,888 cr.");
        labelTargetPrice0.textAlignment = ContentAlignment.TopRight;
        // buttonBuyMax0
        buttonBuyMax0.setFlatStyle(FlatStyle.Flat);
        buttonBuyMax0.setLocation(new Point(262, 56));
        buttonBuyMax0.setName("buttonBuyMax0");
        buttonBuyMax0.setSize(new Dimension(36, 22));
        buttonBuyMax0.setTabIndex(15);
        buttonBuyMax0.setText("Max");
        buttonBuyMax0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonBuyQuantity0
        buttonBuyQuantity0.setFlatStyle(FlatStyle.Flat);
        buttonBuyQuantity0.setLocation(new Point(227, 56));
        buttonBuyQuantity0.setName("buttonBuyQuantity0");
        buttonBuyQuantity0.setSize(new Dimension(28, 22));
        buttonBuyQuantity0.setTabIndex(14);
        buttonBuyQuantity0.setText("88");
        buttonBuyQuantity0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelBuyPrice0
        labelBuyPrice0.setLocation(new Point(302, 60));
        labelBuyPrice0.setName("labelBuyPrice0");
        labelBuyPrice0.setSize(new Dimension(48, 13));
        labelBuyPrice0.setTabIndex(41);
        labelBuyPrice0.setText("8,888 cr.");
        labelBuyPrice0.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll1
        buttonSellAll1.setFlatStyle(FlatStyle.Flat);
        buttonSellAll1.setLocation(new Point(115, 80));
        buttonSellAll1.setName("buttonSellAll1");
        buttonSellAll1.setSize(new Dimension(44, 22));
        buttonSellAll1.setTabIndex(17);
        buttonSellAll1.setText("All");
        buttonSellAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity1
        buttonSellQuantity1.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity1.setLocation(new Point(80, 80));
        buttonSellQuantity1.setName("buttonSellQuantity1");
        buttonSellQuantity1.setSize(new Dimension(28, 22));
        buttonSellQuantity1.setTabIndex(16);
        buttonSellQuantity1.setText("88");
        buttonSellQuantity1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice1
        labelSellPrice1.setLocation(new Point(163, 84));
        labelSellPrice1.setName("labelSellPrice1");
        labelSellPrice1.setSize(new Dimension(48, 13));
        labelSellPrice1.setTabIndex(38);
        labelSellPrice1.setText("8,888 cr.");
        labelSellPrice1.textAlignment = ContentAlignment.TopRight;
        // buttonSellAll0
        buttonSellAll0.setFlatStyle(FlatStyle.Flat);
        buttonSellAll0.setLocation(new Point(115, 56));
        buttonSellAll0.setName("buttonSellAll0");
        buttonSellAll0.setSize(new Dimension(44, 22));
        buttonSellAll0.setTabIndex(13);
        buttonSellAll0.setText("All");
        buttonSellAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // buttonSellQuantity0
        buttonSellQuantity0.setFlatStyle(FlatStyle.Flat);
        buttonSellQuantity0.setLocation(new Point(80, 56));
        buttonSellQuantity0.setName("buttonSellQuantity0");
        buttonSellQuantity0.setSize(new Dimension(28, 22));
        buttonSellQuantity0.setTabIndex(12);
        buttonSellQuantity0.setText("88");
        buttonSellQuantity0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuySellClick(sender);
            }
        });
        // labelSellPrice0
        labelSellPrice0.setLocation(new Point(163, 60));
        labelSellPrice0.setName("labelSellPrice0");
        labelSellPrice0.setSize(new Dimension(48, 13));
        labelSellPrice0.setTabIndex(35);
        labelSellPrice0.setText("8,888 cr.");
        labelSellPrice0.textAlignment = ContentAlignment.TopRight;
        // labelTradeTarget
        labelTradeTarget.setAutoSize(true);
        labelTradeTarget.setLocation(new Point(391, 16));
        labelTradeTarget.setName("labelTradeTarget");
        labelTradeTarget.setSize(new Dimension(78, 16));
        labelTradeTarget.setTabIndex(28);
        labelTradeTarget.setText("Target System");
        // labelBuy
        labelBuy.setAutoSize(true);
        labelBuy.setLocation(new Point(273, 34));
        labelBuy.setName("labelBuy");
        labelBuy.setSize(new Dimension(24, 16));
        labelBuy.setTabIndex(27);
        labelBuy.setText("Buy");
        // labelSell
        labelSell.setAutoSize(true);
        labelSell.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Regular, (int) 8.25F));
        labelSell.setLocation(new Point(132, 34));
        labelSell.setName("labelSell");
        labelSell.setSize(new Dimension(23, 16));
        labelSell.setTabIndex(26);
        labelSell.setText("Sell");
        // labelTradeCommodity9
        labelTradeCommodity9.setAutoSize(true);
        labelTradeCommodity9.setLocation(new Point(8, 276));
        labelTradeCommodity9.setName("labelTradeCommodity9");
        labelTradeCommodity9.setSize(new Dimension(40, 16));
        labelTradeCommodity9.setTabIndex(25);
        labelTradeCommodity9.setText("Robots");
        // labelTradeCommodity8
        labelTradeCommodity8.setAutoSize(true);
        labelTradeCommodity8.setLocation(new Point(8, 252));
        labelTradeCommodity8.setName("labelTradeCommodity8");
        labelTradeCommodity8.setSize(new Dimension(51, 16));
        labelTradeCommodity8.setTabIndex(24);
        labelTradeCommodity8.setText("Narcotics");
        // labelTradeCommodity2
        labelTradeCommodity2.setAutoSize(true);
        labelTradeCommodity2.setLocation(new Point(8, 108));
        labelTradeCommodity2.setName("labelTradeCommodity2");
        labelTradeCommodity2.setSize(new Dimension(30, 16));
        labelTradeCommodity2.setTabIndex(23);
        labelTradeCommodity2.setText("Food");
        // labelTradeCommodity0
        labelTradeCommodity0.setAutoSize(true);
        labelTradeCommodity0.setLocation(new Point(8, 60));
        labelTradeCommodity0.setName("labelTradeCommodity0");
        labelTradeCommodity0.setSize(new Dimension(34, 16));
        labelTradeCommodity0.setTabIndex(22);
        labelTradeCommodity0.setText("Water");
        // labelTradeCommodity1
        labelTradeCommodity1.setAutoSize(true);
        labelTradeCommodity1.setLocation(new Point(8, 84));
        labelTradeCommodity1.setName("labelTradeCommodity1");
        labelTradeCommodity1.setSize(new Dimension(27, 16));
        labelTradeCommodity1.setTabIndex(21);
        labelTradeCommodity1.setText("Furs");
        // labelTradeCommodity6
        labelTradeCommodity6.setAutoSize(true);
        labelTradeCommodity6.setLocation(new Point(8, 204));
        labelTradeCommodity6.setName("labelTradeCommodity6");
        labelTradeCommodity6.setSize(new Dimension(50, 16));
        labelTradeCommodity6.setTabIndex(20);
        labelTradeCommodity6.setText("Medicine");
        // labelTradeCommodity5
        labelTradeCommodity5.setAutoSize(true);
        labelTradeCommodity5.setLocation(new Point(8, 180));
        labelTradeCommodity5.setName("labelTradeCommodity5");
        labelTradeCommodity5.setSize(new Dimension(49, 16));
        labelTradeCommodity5.setTabIndex(19);
        labelTradeCommodity5.setText("Firearms");
        // labelTradeCommodity4
        labelTradeCommodity4.setAutoSize(true);
        labelTradeCommodity4.setLocation(new Point(8, 156));
        labelTradeCommodity4.setName("labelTradeCommodity4");
        labelTradeCommodity4.setSize(new Dimension(41, 16));
        labelTradeCommodity4.setTabIndex(18);
        labelTradeCommodity4.setText("Games");
        // labelTradeCommodity3
        labelTradeCommodity3.setAutoSize(true);
        labelTradeCommodity3.setLocation(new Point(8, 132));
        labelTradeCommodity3.setName("labelTradeCommodity3");
        labelTradeCommodity3.setSize(new Dimension(23, 16));
        labelTradeCommodity3.setTabIndex(17);
        labelTradeCommodity3.setText("Ore");
        // labelTradeCommodity7
        labelTradeCommodity7.setAutoSize(true);
        labelTradeCommodity7.setLocation(new Point(8, 228));
        labelTradeCommodity7.setName("labelTradeCommodity7");
        labelTradeCommodity7.setSize(new Dimension(53, 16));
        labelTradeCommodity7.setTabIndex(16);
        labelTradeCommodity7.setText("Machines");
        // boxSystem
        boxSystem.controls.add(buttonMercenary);
        boxSystem.controls.add(buttonSpecial);
        boxSystem.controls.add(buttonNews);
        boxSystem.controls.add(labelSystemPressure);
        boxSystem.controls.add(labelSystemPressurePre);
        boxSystem.controls.add(labelSystemPolSys);
        boxSystem.controls.add(labelSystemSize);
        boxSystem.controls.add(labelSystemTech);
        boxSystem.controls.add(labelSystemPirates);
        boxSystem.controls.add(labelSystemPolice);
        boxSystem.controls.add(labelSystemResource);
        boxSystem.controls.add(labelSystemPiratesLabel);
        boxSystem.controls.add(labelSystemPoliceLabel);
        boxSystem.controls.add(labelSystemResourceLabel);
        boxSystem.controls.add(labelSystemGovtLabel);
        boxSystem.controls.add(labelSystemTechLabel);
        boxSystem.controls.add(labelSystemSizeLabel);
        boxSystem.controls.add(labelSystemName);
        boxSystem.controls.add(labelSystemNameLabel);
        boxSystem.setLocation(new Point(4, 2));
        boxSystem.setName("boxSystem");
        boxSystem.setSize(new Dimension(240, 206));
        boxSystem.setTabIndex(1);
        boxSystem.setTabStop(false);
        boxSystem.setText("System Info");
        // buttonMercenary
        buttonMercenary.setFlatStyle(FlatStyle.Flat);
        buttonMercenary.setLocation(new Point(118, 174));
        buttonMercenary.setName("buttonMerc");
        buttonMercenary.setSize(new Dimension(112, 22));
        buttonMercenary.setTabIndex(3);
        buttonMercenary.setText("Mercenary For Hire");
        buttonMercenary.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonMercenaryClick();
            }
        });
        // buttonSpecial
        buttonSpecial.setBackgroundColor(new java.awt.Color(255, 255, 128));
        buttonSpecial.setFlatStyle(FlatStyle.Flat);
        buttonSpecial.setLocation(new Point(58, 174));
        buttonSpecial.setName("buttonSpecial");
        buttonSpecial.setSize(new Dimension(52, 22));
        buttonSpecial.setTabIndex(2);
        buttonSpecial.setText("Special");
        buttonSpecial.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonSpecialClick();
            }
        });
        // buttonNews
        buttonNews.setFlatStyle(FlatStyle.Flat);
        buttonNews.setLocation(new Point(8, 174));
        buttonNews.setName("buttonNews");
        buttonNews.setSize(new Dimension(42, 22));
        buttonNews.setTabIndex(1);
        buttonNews.setText("News");
        buttonNews.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                game.showNewspaper();
            }
        });
        // labelSystemPressure
        labelSystemPressure.setLocation(new Point(8, 147));
        labelSystemPressure.setName("labelSystemPressure");
        labelSystemPressure.setSize(new Dimension(168, 16));
        labelSystemPressure.setTabIndex(18);
        labelSystemPressure.setText("suffering from extreme boredom.");
        // labelSystemPressurePre
        labelSystemPressurePre.setAutoSize(true);
        labelSystemPressurePre.setLocation(new Point(8, 134));
        labelSystemPressurePre.setName("labelSystemPressurePre");
        labelSystemPressurePre.setSize(new Dimension(122, 16));
        labelSystemPressurePre.setTabIndex(17);
        labelSystemPressurePre.setText("This system is currently");
        // labelSystemPolSys
        labelSystemPolSys.setLocation(new Point(88, 64));
        labelSystemPolSys.setName("labelSystemPolSys");
        labelSystemPolSys.setSize(new Dimension(91, 13));
        labelSystemPolSys.setTabIndex(15);
        labelSystemPolSys.setText("Cybernetic State");
        // labelSystemSize
        labelSystemSize.setLocation(new Point(88, 32));
        labelSystemSize.setName("labelSystemSize");
        labelSystemSize.setSize(new Dimension(45, 13));
        labelSystemSize.setTabIndex(14);
        labelSystemSize.setText("Medium");
        // labelSystemTech
        labelSystemTech.setLocation(new Point(88, 48));
        labelSystemTech.setName("labelSystemTech");
        labelSystemTech.setSize(new Dimension(82, 13));
        labelSystemTech.setTabIndex(13);
        labelSystemTech.setText("Pre-Agricultural");
        // labelSystemPirates
        labelSystemPirates.setLocation(new Point(88, 112));
        labelSystemPirates.setName("labelSystemPirates");
        labelSystemPirates.setSize(new Dimension(53, 13));
        labelSystemPirates.setTabIndex(11);
        labelSystemPirates.setText("Abundant");
        // labelSystemPolice
        labelSystemPolice.setLocation(new Point(88, 96));
        labelSystemPolice.setName("labelSystemPolice");
        labelSystemPolice.setSize(new Dimension(53, 13));
        labelSystemPolice.setTabIndex(10);
        labelSystemPolice.setText("Moderate");
        // labelSystemResource
        labelSystemResource.setLocation(new Point(88, 80));
        labelSystemResource.setName("labelSystemResource");
        labelSystemResource.setSize(new Dimension(105, 13));
        labelSystemResource.setTabIndex(9);
        labelSystemResource.setText("Sweetwater Oceans");
        // labelSystemPiratesLabel
        labelSystemPiratesLabel.setAutoSize(true);
        labelSystemPiratesLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSystemPiratesLabel.setLocation(new Point(8, 112));
        labelSystemPiratesLabel.setName("labelSystemPiratesLabel");
        labelSystemPiratesLabel.setSize(new Dimension(44, 16));
        labelSystemPiratesLabel.setTabIndex(7);
        labelSystemPiratesLabel.setText("Pirates:");
        // labelSystemPoliceLabel
        labelSystemPoliceLabel.setAutoSize(true);
        labelSystemPoliceLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSystemPoliceLabel.setLocation(new Point(8, 96));
        labelSystemPoliceLabel.setName("labelSystemPoliceLabel");
        labelSystemPoliceLabel.setSize(new Dimension(40, 16));
        labelSystemPoliceLabel.setTabIndex(6);
        labelSystemPoliceLabel.setText("Police:");
        // labelSystemResourceLabel
        labelSystemResourceLabel.setAutoSize(true);
        labelSystemResourceLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSystemResourceLabel.setLocation(new Point(8, 80));
        labelSystemResourceLabel.setName("labelSystemResourceLabel");
        labelSystemResourceLabel.setSize(new Dimension(58, 16));
        labelSystemResourceLabel.setTabIndex(5);
        labelSystemResourceLabel.setText("Resource:");
        // labelSystemGovtLabel
        labelSystemGovtLabel.setAutoSize(true);
        labelSystemGovtLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSystemGovtLabel.setLocation(new Point(8, 64));
        labelSystemGovtLabel.setName("labelSystemGovtLabel");
        labelSystemGovtLabel.setSize(new Dimension(72, 16));
        labelSystemGovtLabel.setTabIndex(4);
        labelSystemGovtLabel.setText("Government:");
        // labelSystemTechLabel
        labelSystemTechLabel.setAutoSize(true);
        labelSystemTechLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSystemTechLabel.setLocation(new Point(8, 48));
        labelSystemTechLabel.setName("labelSystemTechLabel");
        labelSystemTechLabel.setSize(new Dimension(65, 16));
        labelSystemTechLabel.setTabIndex(3);
        labelSystemTechLabel.setText("Tech Level:");
        // labelSystemSizeLabel
        labelSystemSizeLabel.setAutoSize(true);
        labelSystemSizeLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSystemSizeLabel.setLocation(new Point(8, 32));
        labelSystemSizeLabel.setName("labelSystemSizeLabel");
        labelSystemSizeLabel.setSize(new Dimension(31, 16));
        labelSystemSizeLabel.setTabIndex(2);
        labelSystemSizeLabel.setText("Size:");
        // labelSystemName
        labelSystemName.setLocation(new Point(88, 16));
        labelSystemName.setName("labelSystemName");
        labelSystemName.setSize(new Dimension(65, 13));
        labelSystemName.setTabIndex(1);
        labelSystemName.setText("Tarchannen");
        // labelSystemNameLabel
        labelSystemNameLabel.setAutoSize(true);
        labelSystemNameLabel.setFont(
                new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSystemNameLabel.setLocation(new Point(8, 16));
        labelSystemNameLabel.setName("labelSystemNameLabel");
        labelSystemNameLabel.setSize(new Dimension(39, 16));
        labelSystemNameLabel.setTabIndex(0);
        labelSystemNameLabel.setText("Name:");
        // boxShipYard
        boxShipYard.controls.add(buttonDesign);
        boxShipYard.controls.add(buttonPod);
        boxShipYard.controls.add(labelEscapePod);
        boxShipYard.controls.add(buttonEquip);
        boxShipYard.controls.add(buttonBuyShip);
        boxShipYard.controls.add(labelEquipForSale);
        boxShipYard.controls.add(labelShipsForSale);
        boxShipYard.setLocation(new Point(4, 306));
        boxShipYard.setName("boxShipYard");
        boxShipYard.setSize(new Dimension(168, 168));
        boxShipYard.setTabIndex(4);
        boxShipYard.setTabStop(false);
        boxShipYard.setText("Shipyard");
        // buttonDesign
        buttonDesign.setFlatStyle(FlatStyle.Flat);
        buttonDesign.setLocation(new Point(8, 32));
        buttonDesign.setName("buttonDesign");
        buttonDesign.setSize(new Dimension(54, 22));
        buttonDesign.setTabIndex(55);
        buttonDesign.setText("Design");
        buttonDesign.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonDesignClick();
            }
        });
        // buttonPod
        buttonPod.setFlatStyle(FlatStyle.Flat);
        buttonPod.setLocation(new Point(98, 138));
        buttonPod.setName("buttonPod");
        buttonPod.setSize(new Dimension(58, 22));
        buttonPod.setTabIndex(54);
        buttonPod.setText("Buy Pod");
        buttonPod.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonPodClick();
            }
        });
        // labelEscapePod
        labelEscapePod.setLocation(new Point(8, 122));
        labelEscapePod.setName("labelEscapePod");
        labelEscapePod.setSize(new Dimension(152, 26));
        labelEscapePod.setTabIndex(27);
        labelEscapePod.setText("You can buy an escape pod for 2,000 cr.");
        // buttonEquip
        buttonEquip.setFlatStyle(FlatStyle.Flat);
        buttonEquip.setLocation(new Point(43, 85));
        buttonEquip.setName("buttonEquip");
        buttonEquip.setSize(new Dimension(113, 22));
        buttonEquip.setTabIndex(53);
        buttonEquip.setText("Buy/Sell Equipment");
        buttonEquip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonEquipClick();
            }
        });
        // buttonBuyShip
        buttonBuyShip.setFlatStyle(FlatStyle.Flat);
        buttonBuyShip.setLocation(new Point(70, 32));
        buttonBuyShip.setName("buttonBuyShip");
        buttonBuyShip.setSize(new Dimension(86, 22));
        buttonBuyShip.setTabIndex(52);
        buttonBuyShip.setText("View Ship Info");
        buttonBuyShip.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyShipClick();
            }
        });
        // labelEquipForSale
        labelEquipForSale.setLocation(new Point(8, 69));
        labelEquipForSale.setName("labelEquipForSale");
        labelEquipForSale.setSize(new Dimension(152, 13));
        labelEquipForSale.setTabIndex(21);
        labelEquipForSale.setText("There is equipment for sale.");
        // labelShipsForSale
        labelShipsForSale.setLocation(new Point(8, 16));
        labelShipsForSale.setName("labelShipsForSale");
        labelShipsForSale.setSize(new Dimension(152, 13));
        labelShipsForSale.setTabIndex(20);
        labelShipsForSale.setText("There are new ships for sale.");
        // boxDock
        boxDock.controls.add(buttonRepair);
        boxDock.controls.add(buttonFuel);
        boxDock.controls.add(labelFuelStatus);
        boxDock.controls.add(labelFuelCost);
        boxDock.controls.add(labelHullStatus);
        boxDock.controls.add(labelRepairCost);
        boxDock.setLocation(new Point(4, 212));
        boxDock.setName("boxDock");
        boxDock.setSize(new Dimension(240, 90));
        boxDock.setTabIndex(2);
        boxDock.setTabStop(false);
        boxDock.setText("Dock");
        // buttonRepair
        buttonRepair.setFlatStyle(FlatStyle.Flat);
        buttonRepair.setLocation(new Point(180, 56));
        buttonRepair.setName("buttonRepair");
        buttonRepair.setSize(new Dimension(48, 22));
        buttonRepair.setTabIndex(5);
        buttonRepair.setText("Repair");
        buttonRepair.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonRepairClick();
            }
        });
        // buttonFuel
        buttonFuel.setFlatStyle(FlatStyle.Flat);
        buttonFuel.setLocation(new Point(192, 18));
        buttonFuel.setName("buttonFuel");
        buttonFuel.setSize(new Dimension(36, 22));
        buttonFuel.setTabIndex(4);
        buttonFuel.setText("Fuel");
        buttonFuel.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonFuelClick();
            }
        });
        // labelFuelStatus
        labelFuelStatus.setLocation(new Point(8, 16));
        labelFuelStatus.setName("labelFuelStatus");
        labelFuelStatus.setSize(new Dimension(162, 13));
        labelFuelStatus.setTabIndex(20);
        labelFuelStatus.setText("You have fuel to fly 88 parsecs.");
        // labelFuelCost
        labelFuelCost.setLocation(new Point(8, 31));
        labelFuelCost.setName("labelFuelCost");
        labelFuelCost.setSize(new Dimension(121, 13));
        labelFuelCost.setTabIndex(19);
        labelFuelCost.setText("A full tank costs 888 cr.");
        // labelHullStatus
        labelHullStatus.setLocation(new Point(8, 52));
        labelHullStatus.setName("labelHullStatus");
        labelHullStatus.setSize(new Dimension(152, 13));
        labelHullStatus.setTabIndex(18);
        labelHullStatus.setText("Your hull strength is at 888%.");
        // labelRepairCost
        labelRepairCost.setLocation(new Point(8, 67));
        labelRepairCost.setName("labelRepairCost");
        labelRepairCost.setSize(new Dimension(150, 13));
        labelRepairCost.setTabIndex(19);
        labelRepairCost.setText("Full repairs will cost 8,888 cr.");
        // pictureLine
        pictureLine.setBackgroundColor(java.awt.Color.darkGray);
        pictureLine.setLocation(new Point(0, 0));
        pictureLine.setName("pictureLine");
        pictureLine.setSize(new Dimension(770, 1));
        pictureLine.setTabIndex(132);
        pictureLine.setTabStop(false);
        // dialogOpen
        dialogOpen.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
        // dialogSave
        dialogSave.setFileName("SpaceTrader.sav");
        dialogSave.setFilter("Saved-Game Files (*.sav)|*.sav|All Files (*.*)|*.*");
        // ilChartImages
        ilChartImages.setImageSize(new Dimension(7, 7));
        ilChartImages.setImageStream(((ImageListStreamer) (resources.getObject("ilChartImages.ImageStream"))));
        ilChartImages.setTransparentColor(java.awt.Color.white);
        // ilShipImages
        ilShipImages.setImageSize(new Dimension(64, 52));
        ilShipImages.setImageStream(((ImageListStreamer) (resources.getObject("ilShipImages.ImageStream"))));
        ilShipImages.setTransparentColor(java.awt.Color.white);
        // ilDirectionImages
        ilDirectionImages.setImageSize(new Dimension(13, 13));
        ilDirectionImages.setImageStream(((ImageListStreamer) (resources.getObject("ilDirectionImages.ImageStream"))));
        ilDirectionImages.setTransparentColor(java.awt.Color.white);
        // ilEquipmentImages
        ilEquipmentImages.setImageSize(new Dimension(64, 52));
        ilEquipmentImages.setImageStream(((ImageListStreamer) (resources.getObject("ilEquipmentImages.ImageStream"))));
        ilEquipmentImages.setTransparentColor(java.awt.Color.white);


        // Space Trader Application
        setAutoScaleBaseSize(new Dimension(5, 13));
        setClientSize(new Dimension(1000, 800));  // TODO adapt on screen size, this should be like the minimum size
        controls.add(pictureLine);
        controls.add(boxDock);
        controls.add(boxCargo);
        controls.add(boxTargetSystem);
        controls.add(boxGalacticChart);
        controls.add(boxShortRangeChart);
        setStatusBar(statusBar);
        controls.add(boxSystem);
        controls.add(boxShipYard);
        //TODO: next line is FQN because of field name is identical. GAC
        setFormBorderStyle(FormBorderStyle.FixedSingle);
        setIcon(((Icon) (resources.getObject("$this.Icon"))));
        setMaximizeBox(false);
        setMenu(menuMain);
        setName("SpaceTrader"); // TODO difference setName and setText
        setStartPosition(FormStartPosition.Manual);
        setText("Space Trader");
        setClosing(new EventHandler<>() {
            @Override
            public void handle(Object sender, CancelEventData data) {
                closeWindow(data);
            }
        });
        setLoad(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                loadWindow();
            }
        });
        boxShortRangeChart.resumeLayout(false);
        boxGalacticChart.resumeLayout(false);
        boxTargetSystem.resumeLayout(false);
        boxCargo.resumeLayout(false);
        boxSystem.resumeLayout(false);
        boxShipYard.resumeLayout(false);
        boxDock.resumeLayout(false);
        resumeLayout(false);

        // Make sure all directories exists.
        String[] paths = new String[]{
                Constants.CustomDirectory,
                Constants.CustomImagesDirectory,
                Constants.CustomTemplatesDirectory,
                Constants.DataDirectory,
                Constants.SaveDirectory
        };
        for (String path : paths) {
            if (!Utils.existsFile(path)) {
                Utils.createDirectory(path);
            }
        }
        dialogOpen.setInitialDirectory(Constants.SaveDirectory);
        dialogSave.setInitialDirectory(Constants.SaveDirectory);

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
        buttonSellQuantity = new Button[]{
                buttonSellQuantity0, buttonSellQuantity1, buttonSellQuantity2, buttonSellQuantity3, buttonSellQuantity4,
                buttonSellQuantity5, buttonSellQuantity6, buttonSellQuantity7, buttonSellQuantity8, buttonSellQuantity9
        };
        buttonSellAll = new Button[]{
                buttonSellAll0, buttonSellAll1, buttonSellAll2, buttonSellAll3, buttonSellAll4,
                buttonSellAll5, buttonSellAll6, buttonSellAll7, buttonSellAll8, buttonSellAll9
        };
        buttonBuyQuantity = new Button[]{
                buttonBuyQuantity0, buttonBuyQuantity1, buttonBuyQuantity2, buttonBuyQuantity3, buttonBuyQuantity4,
                buttonBuyQuantity5, buttonBuyQuantity6, buttonBuyQuantity7, buttonBuyQuantity8, buttonBuyQuantity9
        };
        buttonBuyMax = new Button[]{
                buttonBuyMax0, buttonBuyMax1, buttonBuyMax2, buttonBuyMax3, buttonBuyMax4,
                buttonBuyMax5, buttonBuyMax6, buttonBuyMax7, buttonBuyMax8, buttonBuyMax9
        };
        updateAll();
    }

    private void buyCargo(int tradeItem, boolean max) {
        game.buyCargoSystem(tradeItem, max, this);
        updateAll();
    }

    private void sellCargo(int tradeItem, boolean all) {
        if (game.PricesellCargo()[tradeItem] > 0) {
            game.sellCargoSystem(tradeItem, all, this);
        } else {
            game.dumpCargo(tradeItem, this);
        }
        updateAll();
    }

    private void addHighScore(HighScoreRecord highScore) {
        HighScoreRecord[] highScores = ModelUtils.GetHighScores(this);
        highScores[0] = highScore;
        Arrays.sort(highScores);
        ModelUtils.saveFile(Constants.HighScoreFile, SerializableObject.ArrayToArrayList(highScores), this);
    }    

    private void clearHighScores() {
        HighScoreRecord[] highScores = new HighScoreRecord[3];
        ModelUtils.saveFile(Constants.HighScoreFile, SerializableObject.ArrayToArrayList(highScores), this);
    }

    private void endGame() {
        setInGameControlsEnabled(false);
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
        DialogAlert.Alert(alertType, this);
        DialogAlert.Alert(AlertType.GameEndScore, this, ModelUtils.formatNumber(game.Score() / 10), ModelUtils.formatNumber(game.Score() % 10));
        HighScoreRecord candidate = new HighScoreRecord(
                commander.Name(), game.Score(), game.getEndStatus(),
                commander.getDays(), commander.Worth(), game.Difficulty());
        if (candidate.CompareTo(ModelUtils.GetHighScores(this)[0]) > 0) {
            if (game.getCheatEnabled()) {
                DialogAlert.Alert(AlertType.GameEndHighScoreCheat, this);
            } else {
                addHighScore(candidate);
                DialogAlert.Alert(AlertType.GameEndHighScoreAchieved, this);
            }
        } else {
            DialogAlert.Alert(AlertType.GameEndHighScoreMissed, this);
        }
        Game.setCurrentGame(null);
        game = null;
    }

    private void loadGame(String fileName) {
        try {
            Object obj = ModelUtils.loadFile(fileName, false, this);
            if (obj != null) {
                game = new Game((Hashtable) obj, this);
                commander = game.Commander();
                saveGameFile = fileName;
                saveGameDays = commander.getDays();
                setInGameControlsEnabled(true);
                updateAll();
            }
        } catch (FutureVersionException ex) {
            DialogAlert.Alert(AlertType.FileErrorOpen, this, fileName, Strings.FileFutureVersion);
        }
    }

    private void saveGame(String fileName, boolean saveFileName) {
        if (ModelUtils.saveFile(fileName, game.Serialize(), this) && saveFileName) {
            saveGameFile = fileName;
        }
        saveGameDays = commander.getDays();
    }

    private void setInGameControlsEnabled(boolean enabled) {
        menuGameSave.setEnabled(enabled);
        menuGameSaveAs.setEnabled(enabled);
        menuRetire.setEnabled(enabled);
        menuViewCommander.setEnabled(enabled);
        menuViewShip.setEnabled(enabled);
        menuViewPersonnel.setEnabled(enabled);
        menuViewQuests.setEnabled(enabled);
        menuViewBank.setEnabled(enabled);
    }

    private String getRegistrySetting(String settingName, String defaultValue) {
        String settingValue = defaultValue;
        try {
            RegistryKey key = ModelUtils.getRegistryKey();
            Object ObjectValue = key.GetValue(settingName);
            if (ObjectValue != null) {
                settingValue = ObjectValue.toString();
            }
            key.Close();
        } catch (NullPointerException ex) {
            DialogAlert.Alert(AlertType.RegistryError, this, ex.getMessage());
        }
        return settingValue;
    }    

    private void setRegistrySetting(String settingName, String settingValue) {
        try {
            RegistryKey key = ModelUtils.getRegistryKey();
            key.SetValue(settingName, settingValue);
            key.Close();
        } catch (NullPointerException ex) {
            DialogAlert.Alert(AlertType.RegistryError, this, ex.getMessage());
        }
    }

    /**
     * Updates the whole content of the main window.
     */
    public void updateAll() {
        updateCargo();
        updateDock();
        updateShipyard();
        updateStatusBar();
        updateSystemInfo();
        updateTargetSystemInfo();
        updateCharts();
    }

    private void updateCargo() {
        if (game == null || commander.CurrentSystem() == null) {
            for (int i = 0; i < labelSellPrice.length; i++) {
                labelSellPrice[i].setText("");
                labelBuyPrice[i].setText("");
                labelTargetPrice[i].setText("");
                labelTargetDiff[i].setText("");
                labelTargetPct[i].setText("");
                buttonSellQuantity[i].setVisible(false);
                buttonSellAll[i].setVisible(false);
                buttonBuyQuantity[i].setVisible(false);
                buttonBuyMax[i].setVisible(false);
            }
        } else {
            int[] buy = game.PricebuyCargo();
            int[] sell = game.PricesellCargo();
            commander = game.Commander();// todo: is this unnecessary? GAC
            StarSystem warpSys = game.WarpSystem();
            for (int i = 0; i < labelSellPrice.length; i++) {
                int price = warpSys == null ? 0 : Constants.TradeItems[i].getStandardPrice(warpSys);
                labelSellPrice[i].setText(sell[i] > 0 ? ModelUtils.formatMoney(sell[i]) : "no trade");
                buttonSellQuantity[i].setText("" + commander.getShip().Cargo()[i]);
                buttonSellQuantity[i].setVisible(true);
                buttonSellAll[i].setText(sell[i] > 0 ? "All" : "Dump");
                buttonSellAll[i].setVisible(true);
                labelBuyPrice[i].setText(buy[i] > 0 ? ModelUtils.formatMoney(buy[i]) : "not sold");
                buttonBuyQuantity[i].setText("" + commander.CurrentSystem().TradeItems()[i]);
                buttonBuyQuantity[i].setVisible(buy[i] > 0);
                buttonBuyMax[i].setVisible(buy[i] > 0);
                if (sell[i] * commander.getShip().Cargo()[i] > commander.PriceCargo()[i]) {
                    labelSellPrice[i].setFont(labelSystemNameLabel.getFont());
                } else {
                    labelSellPrice[i].setFont(labelSell.getFont());
                }
                if (warpSys != null && warpSys.DestOk() && price > 0) {
                    labelTargetPrice[i].setText(ModelUtils.formatMoney(price));
                } else {
                    labelTargetPrice[i].setText("-----------");
                }
                if (warpSys != null && warpSys.DestOk() && price > 0 && buy[i] > 0) {
                    int diff = price - buy[i];
                    labelTargetDiff[i].setText((diff > 0 ? "+" : "") + ModelUtils.formatMoney(diff));
                    labelTargetPct[i].setText((diff > 0 ? "+" : "") + ModelUtils.formatNumber(100 * diff / buy[i]) + "%");
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

    private void updateCharts() {
        pictureGalacticChart.refresh();
        pictureShortRangeChart.refresh();
        if (game == null) {
            labelWormholeLabel.setVisible(false);
            labelWormhole.setVisible(false);
            buttonJump.setVisible(false);
            buttonFind.setVisible(false);
        } else {
            if (game.isTargetingWormhole()) {
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

    private void updateDock() {
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
                    ModelUtils.StringVars("You have fuel to fly ^1.", ModelUtils.multiples(ship.getFuel(), "parsec")));
            int tanksEmpty = ship.FuelTanks() - ship.getFuel();
            labelFuelCost.setText(tanksEmpty > 0
                    ? ModelUtils.StringVars("A full tank costs ^1", ModelUtils.formatMoney(tanksEmpty * ship.getFuelCost()))
                    : "Your tank is full.");
            buttonFuel.setVisible(tanksEmpty > 0);
            labelHullStatus.setText(
                    ModelUtils.StringVars("Your hull strength is at ^1%.",
                            ModelUtils.formatNumber((int) Math.floor((double) 100 * ship.getHull() / ship.HullStrength()))));
            int hullLoss = ship.HullStrength() - ship.getHull();
            labelRepairCost.setText(hullLoss > 0
                    ? ModelUtils.StringVars("Full repairs will cost ^1", ModelUtils.formatMoney(hullLoss * ship.getRepairCost()))
                    : "No repairs are needed.");
            buttonRepair.setVisible(hullLoss > 0);
        }
    }

    private void updateShipyard() {
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

    public void updateStatusBar() {
        if (game == null) {
            statusBarPanelCash.setText("");
            statusBarPanelBays.setText("");
            statusBarPanelCosts.setText("");
            statusBarPanelExtra.setText("No Game Loaded.");
        } else {
            statusBarPanelCash.setText("Cash: " + ModelUtils.formatMoney(commander.getCash()));
            statusBarPanelBays.setText(
                    "Bays: " + commander.getShip().FilledCargoBays() + "/" + commander.getShip().CargoBays());
            statusBarPanelCosts.setText("Current Costs: " + ModelUtils.formatMoney(game.CurrentCosts()));
            statusBarPanelExtra.setText("");
        }
    }

    private void updateSystemInfo() {
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
            buttonMercenary.setVisible(false);
            buttonSpecial.setVisible(false);
        } else {
            StarSystem system = commander.CurrentSystem();
            CrewMember[] Mercenarys = system.MercenariesForHire();
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
            buttonMercenary.setVisible(Mercenarys.length > 0);
            if (buttonMercenary.getVisible()) {
                buttonMercenary.setToolTip(ModelUtils.StringVars(
                        Strings.MercenariesForHire,
                        Mercenarys.length == 1 ? Mercenarys[0].Name() : Mercenarys.length + Strings.Mercenaries));
            }
            buttonSpecial.setVisible(system.ShowSpecialButton());
            if (buttonSpecial.getVisible()) {
                buttonSpecial.setToolTip(system.SpecialEvent().getTitle());
            }
        }
    }

    private void updateTargetSystemInfo() {
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
            int distance = ModelUtils.distance(commander.CurrentSystem(), system);
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

    private void closeWindow(CancelEventData e) {
        if (game == null || commander.getDays() == saveGameDays
                || DialogAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes) {
            if (windowState == FormWindowState.Normal) {
                setRegistrySetting("X", Left.toString());
                setRegistrySetting("Y", Top.toString());
            }
        } else {
            e.cancel = true;
        }
    }

    private void loadWindow() {
        Left = Integer.parseInt(getRegistrySetting("X", "0"));
        Top = Integer.parseInt(getRegistrySetting("Y", "0"));
        DialogAlert.Alert(AlertType.AppStart, this);
    }

    private void buttonBuySellClick(Object sender) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Quantity");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        if (!name.contains("Buy")) {
            sellCargo(index, all);
        } else {
            buyCargo(index, all);
        }
    }

    private void buttonBuyShipClick() {
        (new DialogShipList()).ShowDialog(this);
        updateAll();
    }

    private void buttonDesignClick() {
        (new DialogShipyard()).ShowDialog(this);
        updateAll();
    }

    private void buttonEquipClick() {
        (new DialogEquipment()).ShowDialog(this);
        updateAll();
    }

    private void buttonFindClick() {
        DialogFind form = new DialogFind();
        if (form.ShowDialog(this) == DialogResult.Ok) {
            Ship ship = commander.getShip();
            String[] words = form.SystemName().split(" ");
            String first = words.length > 0 ? words[0] : "";
            String second = words.length > 1 ? words[1] : "";
            String third = words.length > 2 ? words[2] : "";
            int num1 = ModelUtils.isInt(second) ? Integer.parseInt(second) : 0;
            int num2 = ModelUtils.isInt(third) ? Integer.parseInt(third) : 0;
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
                            game.resetVeryRareEncounters();
                        } else {
                            String text = "";
                            for (VeryRareEncounter veryRareEncounter : game.VeryRareEncounters()) {
                                text += Strings.VeryRareEncounters[veryRareEncounter.getId()] + Strings.newline;
                            }
                            text = text.trim();
                            DialogAlert.Alert(AlertType.Alert, this, "Remaining Very Rare Encounters", text);
                        }
                        break;
                    case Fame:
                        commander.setReputationScore(Math.max(0, num1));
                        break;
                    case Go:
                        game.setSelectedSystemByName(second);
                        if (game.SelectedSystem().Name().equalsIgnoreCase(second)) {
                            if (game.getAutoSave()) {
                                saveGame(SAVE_DEPARTURE, false);
                            }
                            game.warpDirect();
                            if (game.getAutoSave()) {
                                saveGame(SAVE_ARRIVAL, false);
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
                                if (ModelUtils.isInt(skills[i])) {
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
                        (new DialogMonster()).ShowDialog(this);
                        break;
                    case PlanB:
                        game.setAutoSave(true);
                        break;
                    case Posse:
                        if (num1 > 0 && num1 < ship.Crew().length && num2 > 0 && num2 < game.Mercenaries().length
                                && !Utils.arrayContains(Constants.SpecialCrewMemberIds, (CrewMemberId.FromInt(num2)))) {
                            int skill = ship.Trader();
                            ship.Crew()[num1] = game.Mercenaries()[num2];
                            if (ship.Trader() != skill) {
                                game.recalculateBuyPrices(commander.CurrentSystem());
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
                                DialogAlert.Alert(AlertType.Alert, this, "Status of Quests", text);
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
                        (new DialogTest()).ShowDialog(this);
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
                        DialogAlert.Alert(AlertType.Cheater, this);
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
                    game.setTrackedSystemId(game.selectedSystemId());
                }
            }
            updateAll();
        }
    }

    private void buttonFuelClick() {
        DialogBuyFuel form = new DialogBuyFuel();
        if (form.ShowDialog(this) == DialogResult.Ok) {
            int toAdd = form.Amount() / commander.getShip().getFuelCost();
            commander.getShip().setFuel(commander.getShip().getFuel() + toAdd);
            commander.setCash(commander.getCash() - (toAdd * commander.getShip().getFuelCost()));
            updateAll();
        }
    }

    private void buttonJumpClick() {
        if (game.WarpSystem() == null) {
            DialogAlert.Alert(AlertType.ChartJumpNoSystemSelected, this);
        } else if (game.WarpSystem() == commander.CurrentSystem()) {
            DialogAlert.Alert(AlertType.ChartJumpCurrent, this);
        } else if (DialogAlert.Alert(AlertType.ChartJump, this, game.WarpSystem().Name()) == DialogResult.Yes) {
            game.setCanSuperWarp(false);
            try {
                if (game.getAutoSave()) {
                    saveGame(SAVE_DEPARTURE, false);
                }
                game.warp(true);
                if (game.getAutoSave()) {
                    saveGame(SAVE_ARRIVAL, false);
                }
            } catch (GameEndException ex) {
                endGame();
            }
            updateAll();
        }
    }

    private void buttonMercenaryClick() {
        (new DialogViewPersonnel()).ShowDialog(this);
        updateAll();
    }

    private void buttonNextSystemClick() {
        game.selectNextSystemWithinRange(true);
        updateAll();
    }

    private void buttonPodClick() {
        if (DialogAlert.Alert(AlertType.EquipmentEscapePod, this) == DialogResult.Yes) {
            commander.setCash(commander.getCash() - 2000);
            commander.getShip().setEscapePod(true);
            updateAll();
        }
    }

    private void buttonPrevSystemClick() {
        game.selectNextSystemWithinRange(false);
        updateAll();
    }

    private void buttonRepairClick() {
        DialogBuyRepairs form = new DialogBuyRepairs();
        if (form.ShowDialog(this) == DialogResult.Ok) {
            int toAdd = form.Amount() / commander.getShip().getRepairCost();
            commander.getShip().setHull(commander.getShip().getHull() + toAdd);
            commander.setCash(commander.getCash() - (toAdd * commander.getShip().getRepairCost()));
            updateAll();
        }
    }

    private void buttonSpecialClick() {
        SpecialEvent specEvent = commander.CurrentSystem().SpecialEvent();
        String button1, button2;
        DialogResult res1, res2;
        if (specEvent.isMessageOnly()) {
            button1 = "Ok";
            button2 = null;
            res1 = DialogResult.Ok;
            res2 = DialogResult.None;
        } else {
            button1 = "Yes";
            button2 = "No";
            res1 = DialogResult.Yes;
            res2 = DialogResult.No;
        }
        DialogAlert alert = new DialogAlert(specEvent.getTitle(), specEvent.String(), button1, res1, button2, res2, null);
        if (alert.ShowDialog() != DialogResult.No) {
            if (commander.CashToSpend() < specEvent.getPrice()) {
                DialogAlert.Alert(AlertType.SpecialIF, this);
            } else {
                try {
                    game.handleSpecialEvent();
                } catch (GameEndException ex) {
                    endGame();
                }
            }
        }
        updateAll();
    }

    private void buttonTrackClick() {
        game.setTrackedSystemId(game.selectedSystemId());
        updateAll();
    }

    private void buttonWarpClick() {
        try {
            if (game.getAutoSave()) {
                saveGame(SAVE_DEPARTURE, false);
            }
            game.warp(false);
            if (game.getAutoSave()) {
                saveGame(SAVE_ARRIVAL, false);
            }
        } catch (GameEndException ex) {
            endGame();
        }
        updateAll();
    }

    private void menuGameNewClick() {
        DialogNewCommander form = new DialogNewCommander();
        if ((game == null || commander.getDays() == saveGameDays
                || DialogAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes)
                && form.ShowDialog(this) == DialogResult.Ok) {
            game = new Game(
                    form.CommanderName(), form.Difficulty(), form.Pilot(),
                    form.Fighter(), form.Trader(), form.Engineer(), this);
            commander = game.Commander();
            saveGameFile = null;
            saveGameDays = 0;
            setInGameControlsEnabled(true);
            updateAll();
            if (game.Options().getNewsAutoShow()) {
                game.showNewspaper();
            }
        }
    }

    private void menuGameLoadClick() {
        if ((game == null || commander.getDays() == saveGameDays
                || DialogAlert.Alert(AlertType.GameAbandonConfirm, this) == DialogResult.Yes)
                && dialogOpen.showDialog(this) == DialogResult.Ok) {
            loadGame(dialogOpen.getFileName());
        }
    }

    private void menuGameSaveClick() {
        if (game != null) {
            if (saveGameFile != null) {
                saveGame(saveGameFile, false);
            } else {
                menuGameSaveAsClick();
            }
        }
    }

    private void menuGameSaveAsClick() {
        if (game != null && dialogSave.showDialog(this) == DialogResult.Ok) {
            saveGame(dialogSave.getFileName(), true);
        }
    }

    private void menuOptionsClick() {
        DialogOptions form = new DialogOptions();
        if (form.ShowDialog(this) == DialogResult.Ok) {
            game.Options().CopyValues(form.Options());
            updateAll();
        }
    }

    private void menuRetireClick() {
        if (DialogAlert.Alert(AlertType.GameRetire, this) == DialogResult.Yes) {
            game.setEndStatus(GameEndType.Retired);
            endGame();
            updateAll();
        }
    }

    private void pictureGalacticChartMouseDown(MouseEventData e) {
        if (e.button == MouseButtons.Left && game != null) {
            StarSystem[] universe = game.getUniverse();
            boolean clickedSystem = false;
            for (int i = 0; i < universe.length && !clickedSystem; i++) {
                int x = universe[i].X() + OFF_X;
                int y = universe[i].Y() + OFF_Y;
                if (e.x >= x - 2 && e.x <= x + 2 && e.y >= y - 2 && e.y <= y + 2) {
                    clickedSystem = true;
                    game.selectedSystemId(StarSystemId.FromInt(i));
                } else if (ModelUtils.WormholeExists(i, -1)) {
                    int xW = x + OFF_X_WORM;
                    if (e.x >= xW - 2 && e.x <= xW + 2 && e.y >= y - 2 && e.y <= y + 2) {
                        clickedSystem = true;
                        game.selectedSystemId(StarSystemId.FromInt(i));
                        game.setTargetingWormhole();
                    }
                }
            }
            if (clickedSystem) {
                updateAll();
            }
        }
    }

    private void pictureGalacticChartPaint(Graphics graphics) {
        if (game != null) {
            StarSystem[] universe = game.getUniverse();
            int[] wormholes = game.Wormholes();
            StarSystem targetSys = game.SelectedSystem();
            StarSystem currentSys = commander.CurrentSystem();
            int fuel = commander.getShip().getFuel();
            if (fuel > 0) {
                graphics.drawEllipse(Color_BLACK, currentSys.X() + OFF_X - fuel, currentSys.Y() + OFF_Y - fuel, fuel * 2, fuel * 2);
            }
            int index = game.selectedSystemId().getId();
            if (game.isTargetingWormhole()) {
                int destination = wormholes[(Utils.bruteSeek(wormholes, index) + 1) % wormholes.length];
                StarSystem destinationSystem = universe[destination];
                graphics.drawLine(
                        Color_BLACK, targetSys.X() + OFF_X_WORM + OFF_X,
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
                Image image = ilChartImages.getImages()[imageIndex];
                if (universe[i] == game.TrackedSystem()) {
                    graphics.drawLine(
                            Color_BLACK, universe[i].X(), universe[i].Y(),
                            universe[i].X() + image.getWidth() - 1, universe[i].Y() + image.getHeight() - 1);
                    graphics.drawLine(
                            Color_BLACK, universe[i].X(), universe[i].Y() + image.getHeight() - 1,
                            universe[i].X() + image.getWidth() - 1, universe[i].Y());
                }
                ilChartImages.draw(graphics, universe[i].X(), universe[i].Y(), imageIndex);
                if (ModelUtils.WormholeExists(i, -1)) {
                    //  private final int IMG_S_VS = 6;
                    int IMG_S_W = 7;
                    ilChartImages.draw(graphics, universe[i].X() + OFF_X_WORM, universe[i].Y(), IMG_S_W);
                }
            }
        } else {
            graphics.fillRectangle(Color_WHITE, 0, 0, pictureGalacticChart.getWidth(), pictureGalacticChart.getHeight());
        }
    }

    private void pictureShortRangeChartMouseDown(MouseEventData e) {
        if (e.button == MouseButtons.Left && game != null) {
            StarSystem[] universe = game.getUniverse();
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
                    if (e.x >= x - OFF_X && e.x <= x + OFF_X && e.y >= y - OFF_Y && e.y <= y + OFF_Y) {
                        clickedSystem = true;
                        game.selectedSystemId(StarSystemId.FromInt(i));
                    } else if (ModelUtils.WormholeExists(i, -1)) {
                        int xW = x + 9;
                        if (e.x >= xW - OFF_X && e.x <= xW + OFF_X && e.y >= y - OFF_Y && e.y <= y + OFF_Y) {
                            clickedSystem = true;
                            game.selectedSystemId((StarSystemId.FromInt(i)));
                            game.setTargetingWormhole();
                        }
                    }
                }
            }
            if (clickedSystem) {
                updateAll();
            }
        }
    }

    private void pictureShortRangeChartPaint(Graphics graphics) {
        if (game == null) {
            graphics.fillRectangle(Color_WHITE, 0, 0, pictureShortRangeChart.getWidth(), pictureShortRangeChart.getHeight());
        } else {
            int[] wormholes = game.Wormholes();
            int fuel = commander.getShip().getFuel();
            int centerX = pictureShortRangeChart.getWidth() / 2;
            int centerY = pictureShortRangeChart.getHeight() / 2;
            int delta = pictureShortRangeChart.getHeight() / (Constants.MaxRange * 2);
            graphics.drawLine(Color_BLACK, centerX - 1, centerY - 1, centerX + 1, centerY + 1);
            graphics.drawLine(Color_BLACK, centerX - 1, centerY + 1, centerX + 1, centerY - 1);
            if (fuel > 0) {
                graphics.drawEllipse(Color_BLACK, centerX - fuel * delta, centerY - fuel * delta, fuel * delta * 2, fuel * delta * 2);
            }
            StarSystem currentSys = commander.CurrentSystem();
            StarSystem trackSys = game.TrackedSystem();
            if (trackSys != null) {
                int dist = ModelUtils.distance(currentSys, trackSys);
                if (dist > 0) {
                    int dX = (int) Math.round(25 * (trackSys.X() - currentSys.X()) / (double) dist);
                    int dY = (int) Math.round(25 * (trackSys.Y() - currentSys.Y()) / (double) dist);
                    int dX2 = (int) Math.round(4 * (trackSys.Y() - currentSys.Y()) / (double) dist);
                    int dY2 = (int) Math.round(4 * (currentSys.X() - trackSys.X()) / (double) dist);
                    graphics.fillPolygon(new java.awt.Color(220, 20, 60), new Point[]{
                            new Point(centerX + dX, centerY + dY), new Point(centerX - dX2, centerY - dY2), new Point(centerX + dX2, centerY + dY2)
                    });
                }
                if (game.Options().getShowTrackedRange()) {
                    graphics.drawString(
                            ModelUtils.StringVars("^1 to ^2.", ModelUtils.multiples(dist, Strings.DistanceUnit), trackSys.Name()),
                            getFont(), java.awt.Color.black, 0, pictureShortRangeChart.getHeight() - 13);
                }
            }
            // First, draw the names, then the systems.
            // The names may overlap and the systems may be drawn on the names, but at least every system is visible.
            StarSystem[] universe = game.getUniverse();
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < universe.length; i++) {
                    if ((Math.abs(universe[i].X() - currentSys.X()) * delta <= pictureShortRangeChart.getWidth() / 2 - 10)
                            && (Math.abs(universe[i].Y() - currentSys.Y()) * delta <= pictureShortRangeChart.getHeight() / 2 - 10)) {
                        int x = centerX + (universe[i].X() - currentSys.X()) * delta;
                        int y = centerY + (universe[i].Y() - currentSys.Y()) * delta;
                        if (j == 1) {
                            if (universe[i] == game.WarpSystem()) {
                                graphics.drawLine(Color_BLACK, x - 6, y, x + 6, y);
                                graphics.drawLine(Color_BLACK, x, y - 6, x, y + 6);
                            }
                            if (universe[i] == game.TrackedSystem()) {
                                graphics.drawLine(Color_BLACK, x - 5, y - 5, x + 5, y + 5);
                                graphics.drawLine(Color_BLACK, x - 5, y + 5, x + 5, y - 5);
                            }
                            int IMG_G_N = 0;
                            int IMG_G_V = 1;
                            ilChartImages.draw(graphics, x - OFF_X, y - OFF_Y, universe[i].Visited() ? IMG_G_V : IMG_G_N);
                            if (ModelUtils.WormholeExists(i, -1)) {
                                int xW = x + 9;
                                if (game.isTargetingWormhole() && universe[i] == game.SelectedSystem()) {
                                    graphics.drawLine(Color_BLACK, xW - 6, y, xW + 6, y);
                                    graphics.drawLine(Color_BLACK, xW, y - 6, xW, y + 6);
                                }
                                int IMG_G_W = 2;
                                ilChartImages.draw(graphics, xW - OFF_X, y - OFF_Y, IMG_G_W);
                            }
                        } else {
                            Font font = new Font(getFont().fontFamily, 7);
                            Dimension size = graphics.measureString(universe[i].Name(), getFont());
                            graphics.drawString(universe[i].Name(), font, java.awt.Color.black,
                                    x - size.width / 2 + OFF_X, y /*- size.Height*/ - 5);
                            // implementations differ as to which point we start the string at. --aviv
                        }
                    }
                }
            }
        }
    }

    private void statusBarPanelClick(StatusBarPanel statusBarPanel) {
        if (game != null) {
            if (statusBarPanel == statusBarPanelCash) {
                (new DialogViewBank()).ShowDialog(this);
            } else if (statusBarPanel == statusBarPanelCosts) {
                (new DialogCosts()).ShowDialog(this);
            }
        }
    }

    public Image[] CustomShipImages() {
        Image[] images = new Image[Constants.ImagesPerShip];
        int baseIndex = ShipType.Custom.getId() * Constants.ImagesPerShip;
        for (int index = 0; index < Constants.ImagesPerShip; index++) {
            images[index] = ilShipImages.getImages()[baseIndex + index];
        }
        return images;
    }

    public void CustomShipImages(Image[] value) {
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

    public Image[] getCustomShipImages() {
        Image[] images = new Image[Constants.ImagesPerShip];
        int baseIndex = ShipType.Custom.getId() * Constants.ImagesPerShip;
        for (int index = 0; index < Constants.ImagesPerShip; index++) {
            images[index] = ilShipImages.getImages()[baseIndex + index];
        }
        return images;
    }

    public void setCustomShipImages(Image[] value) {
        int baseIndex = ShipType.Custom.getId() * Constants.ImagesPerShip;
        System.arraycopy(value, 0, ilShipImages.getImages(), baseIndex, Constants.ImagesPerShip);
    }
}
