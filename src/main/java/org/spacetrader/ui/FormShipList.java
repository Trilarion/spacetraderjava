package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.controller.enums.AlertType;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormShipList extends wfForm {
    private final Game game = Game.CurrentGame();
    private final Commander cmdr = game.Commander();
    private final Ship ship = cmdr.getShip();
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
    private Button[] buttonBuy;
    private int[] prices = new int[Constants.ShipSpecs.length];

    public FormShipList() {
        Button buttonClose = new Button();
        Button buttonBuy0 = new Button();
        Label lblName0 = new Label();
        Button buttonInfo0 = new Button();
        Label lblPrice0 = new Label();
        Label lblPrice1 = new Label();
        Button buttonInfo1 = new Button();
        Label lblName1 = new Label();
        Button buttonBuy1 = new Button();
        Label lblPrice2 = new Label();
        Button buttonInfo2 = new Button();
        Label lblName2 = new Label();
        Button buttonBuy2 = new Button();
        Label lblPrice3 = new Label();
        Button buttonInfo3 = new Button();
        Label lblName3 = new Label();
        Button buttonBuy3 = new Button();
        Label lblPrice4 = new Label();
        Button buttonInfo4 = new Button();
        Label lblName4 = new Label();
        Button buttonBuy4 = new Button();
        Label lblPrice5 = new Label();
        Button buttonInfo5 = new Button();
        Label lblName5 = new Label();
        Button buttonBuy5 = new Button();
        Label lblPrice6 = new Label();
        Button buttonInfo6 = new Button();
        Label lblName6 = new Label();
        Button buttonBuy6 = new Button();
        Label lblPrice7 = new Label();
        Button buttonInfo7 = new Button();
        Label lblName7 = new Label();
        Button buttonBuy7 = new Button();
        Label lblPrice8 = new Label();
        Button buttonInfo8 = new Button();
        Label lblName8 = new Label();
        Button buttonBuy8 = new Button();
        Label lblPrice9 = new Label();
        Button buttonInfo9 = new Button();
        Label lblName9 = new Label();
        Button buttonBuy9 = new Button();
        GroupBox boxShipInfo = new GroupBox();
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
        Label lblGadgetLabel = new Label();
        Label lblCrewLabel = new Label();
        Label lblShieldLabel = new Label();
        Label lblWeaponLabel = new Label();
        Label lblHullLabel = new Label();
        Label lblRangeLabel = new Label();
        Label lblBaysLabel = new Label();
        Label lblNameLabel = new Label();
        Label lblSizeLabel = new Label();
        boxShipInfo.SuspendLayout();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new FormSize(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // buttonBuy0
        buttonBuy0.setFlatStyle(FlatStyle.Flat);
        buttonBuy0.setLocation(new Point(8, 8));
        buttonBuy0.setName("buttonBuy0");
        buttonBuy0.setSize(new FormSize(35, 22));
        buttonBuy0.setTabIndex(1);
        buttonBuy0.setText("Buy");
        buttonBuy0.setVisible(false);
        buttonBuy0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName0
        lblName0.setLocation(new Point(48, 12));
        lblName0.setName("lblName0");
        lblName0.setSize(new FormSize(70, 13));
        lblName0.setTabIndex(34);
        lblName0.setText("Flea");
        // buttonInfo0
        buttonInfo0.setFlatStyle(FlatStyle.Flat);
        buttonInfo0.setLocation(new Point(120, 8));
        buttonInfo0.setName("buttonInfo0");
        buttonInfo0.setSize(new FormSize(34, 22));
        buttonInfo0.setTabIndex(11);
        buttonInfo0.setText("Info");
        buttonInfo0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
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
        // buttonInfo1
        buttonInfo1.setFlatStyle(FlatStyle.Flat);
        buttonInfo1.setLocation(new Point(120, 32));
        buttonInfo1.setName("buttonInfo1");
        buttonInfo1.setSize(new FormSize(34, 22));
        buttonInfo1.setTabIndex(12);
        buttonInfo1.setText("Info");
        buttonInfo1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName1
        lblName1.setLocation(new Point(48, 36));
        lblName1.setName("lblName1");
        lblName1.setSize(new FormSize(70, 13));
        lblName1.setTabIndex(38);
        lblName1.setText("Gnat");
        // buttonBuy1
        buttonBuy1.setFlatStyle(FlatStyle.Flat);
        buttonBuy1.setLocation(new Point(8, 32));
        buttonBuy1.setName("buttonBuy1");
        buttonBuy1.setSize(new FormSize(35, 22));
        buttonBuy1.setTabIndex(2);
        buttonBuy1.setText("Buy");
        buttonBuy1.setVisible(false);
        buttonBuy1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice2
        lblPrice2.setLocation(new Point(160, 60));
        lblPrice2.setName("lblPrice2");
        lblPrice2.setSize(new FormSize(64, 13));
        lblPrice2.setTabIndex(44);
        lblPrice2.setText("-888,888 cr.");
        lblPrice2.TextAlign = ContentAlignment.TopRight;
        // buttonInfo2
        buttonInfo2.setFlatStyle(FlatStyle.Flat);
        buttonInfo2.setLocation(new Point(120, 56));
        buttonInfo2.setName("buttonInfo2");
        buttonInfo2.setSize(new FormSize(34, 22));
        buttonInfo2.setTabIndex(13);
        buttonInfo2.setText("Info");
        buttonInfo2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName2
        lblName2.setLocation(new Point(48, 60));
        lblName2.setName("lblName2");
        lblName2.setSize(new FormSize(70, 13));
        lblName2.setTabIndex(42);
        lblName2.setText("Firefly");
        // buttonBuy2
        buttonBuy2.setFlatStyle(FlatStyle.Flat);
        buttonBuy2.setLocation(new Point(8, 56));
        buttonBuy2.setName("buttonBuy2");
        buttonBuy2.setSize(new FormSize(35, 22));
        buttonBuy2.setTabIndex(3);
        buttonBuy2.setText("Buy");
        buttonBuy2.setVisible(false);
        buttonBuy2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice3
        lblPrice3.setLocation(new Point(160, 84));
        lblPrice3.setName("lblPrice3");
        lblPrice3.setSize(new FormSize(64, 13));
        lblPrice3.setTabIndex(48);
        lblPrice3.setText("-888,888 cr.");
        lblPrice3.TextAlign = ContentAlignment.TopRight;
        // buttonInfo3
        buttonInfo3.setFlatStyle(FlatStyle.Flat);
        buttonInfo3.setLocation(new Point(120, 80));
        buttonInfo3.setName("buttonInfo3");
        buttonInfo3.setSize(new FormSize(34, 22));
        buttonInfo3.setTabIndex(14);
        buttonInfo3.setText("Info");
        buttonInfo3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName3
        lblName3.setLocation(new Point(48, 84));
        lblName3.setName("lblName3");
        lblName3.setSize(new FormSize(70, 13));
        lblName3.setTabIndex(46);
        lblName3.setText("Mosquito");
        // buttonBuy3
        buttonBuy3.setFlatStyle(FlatStyle.Flat);
        buttonBuy3.setLocation(new Point(8, 80));
        buttonBuy3.setName("buttonBuy3");
        buttonBuy3.setSize(new FormSize(35, 22));
        buttonBuy3.setTabIndex(4);
        buttonBuy3.setText("Buy");
        buttonBuy3.setVisible(false);
        buttonBuy3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice4
        lblPrice4.setLocation(new Point(160, 108));
        lblPrice4.setName("lblPrice4");
        lblPrice4.setSize(new FormSize(64, 13));
        lblPrice4.setTabIndex(52);
        lblPrice4.setText("-888,888 cr.");
        lblPrice4.TextAlign = ContentAlignment.TopRight;
        // buttonInfo4
        buttonInfo4.setFlatStyle(FlatStyle.Flat);
        buttonInfo4.setLocation(new Point(120, 104));
        buttonInfo4.setName("buttonInfo4");
        buttonInfo4.setSize(new FormSize(34, 22));
        buttonInfo4.setTabIndex(15);
        buttonInfo4.setText("Info");
        buttonInfo4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName4
        lblName4.setLocation(new Point(48, 108));
        lblName4.setName("lblName4");
        lblName4.setSize(new FormSize(70, 13));
        lblName4.setTabIndex(50);
        lblName4.setText("Bumblebee");
        // buttonBuy4
        buttonBuy4.setFlatStyle(FlatStyle.Flat);
        buttonBuy4.setLocation(new Point(8, 104));
        buttonBuy4.setName("buttonBuy4");
        buttonBuy4.setSize(new FormSize(35, 22));
        buttonBuy4.setTabIndex(5);
        buttonBuy4.setText("Buy");
        buttonBuy4.setVisible(false);
        buttonBuy4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice5
        lblPrice5.setLocation(new Point(160, 132));
        lblPrice5.setName("lblPrice5");
        lblPrice5.setSize(new FormSize(64, 13));
        lblPrice5.setTabIndex(56);
        lblPrice5.setText("got one");
        lblPrice5.TextAlign = ContentAlignment.TopRight;
        // buttonInfo5
        buttonInfo5.setFlatStyle(FlatStyle.Flat);
        buttonInfo5.setLocation(new Point(120, 128));
        buttonInfo5.setName("buttonInfo5");
        buttonInfo5.setSize(new FormSize(34, 22));
        buttonInfo5.setTabIndex(16);
        buttonInfo5.setText("Info");
        buttonInfo5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName5
        lblName5.setLocation(new Point(48, 132));
        lblName5.setName("lblName5");
        lblName5.setSize(new FormSize(70, 13));
        lblName5.setTabIndex(54);
        lblName5.setText("Beetle");
        // buttonBuy5
        buttonBuy5.setFlatStyle(FlatStyle.Flat);
        buttonBuy5.setLocation(new Point(8, 128));
        buttonBuy5.setName("buttonBuy5");
        buttonBuy5.setSize(new FormSize(35, 22));
        buttonBuy5.setTabIndex(6);
        buttonBuy5.setText("Buy");
        buttonBuy5.setVisible(false);
        buttonBuy5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice6
        lblPrice6.setLocation(new Point(160, 156));
        lblPrice6.setName("lblPrice6");
        lblPrice6.setSize(new FormSize(64, 13));
        lblPrice6.setTabIndex(60);
        lblPrice6.setText("-888,888 cr.");
        lblPrice6.TextAlign = ContentAlignment.TopRight;
        // buttonInfo6
        buttonInfo6.setFlatStyle(FlatStyle.Flat);
        buttonInfo6.setLocation(new Point(120, 152));
        buttonInfo6.setName("buttonInfo6");
        buttonInfo6.setSize(new FormSize(34, 22));
        buttonInfo6.setTabIndex(17);
        buttonInfo6.setText("Info");
        buttonInfo6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName6
        lblName6.setLocation(new Point(48, 156));
        lblName6.setName("lblName6");
        lblName6.setSize(new FormSize(70, 13));
        lblName6.setTabIndex(58);
        lblName6.setText("Hornet");
        // buttonBuy6
        buttonBuy6.setFlatStyle(FlatStyle.Flat);
        buttonBuy6.setLocation(new Point(8, 152));
        buttonBuy6.setName("buttonBuy6");
        buttonBuy6.setSize(new FormSize(35, 22));
        buttonBuy6.setTabIndex(7);
        buttonBuy6.setText("Buy");
        buttonBuy6.setVisible(false);
        buttonBuy6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice7
        lblPrice7.setLocation(new Point(160, 180));
        lblPrice7.setName("lblPrice7");
        lblPrice7.setSize(new FormSize(64, 13));
        lblPrice7.setTabIndex(64);
        lblPrice7.setText("-888,888 cr.");
        lblPrice7.TextAlign = ContentAlignment.TopRight;
        // buttonInfo7
        buttonInfo7.setFlatStyle(FlatStyle.Flat);
        buttonInfo7.setLocation(new Point(120, 176));
        buttonInfo7.setName("buttonInfo7");
        buttonInfo7.setSize(new FormSize(34, 22));
        buttonInfo7.setTabIndex(18);
        buttonInfo7.setText("Info");
        buttonInfo7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName7
        lblName7.setLocation(new Point(48, 180));
        lblName7.setName("lblName7");
        lblName7.setSize(new FormSize(70, 13));
        lblName7.setTabIndex(62);
        lblName7.setText("Grasshopper");
        // buttonBuy7
        buttonBuy7.setFlatStyle(FlatStyle.Flat);
        buttonBuy7.setLocation(new Point(8, 176));
        buttonBuy7.setName("buttonBuy7");
        buttonBuy7.setSize(new FormSize(35, 22));
        buttonBuy7.setTabIndex(8);
        buttonBuy7.setText("Buy");
        buttonBuy7.setVisible(false);
        buttonBuy7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice8
        lblPrice8.setLocation(new Point(160, 204));
        lblPrice8.setName("lblPrice8");
        lblPrice8.setSize(new FormSize(64, 13));
        lblPrice8.setTabIndex(68);
        lblPrice8.setText("-888,888 cr.");
        lblPrice8.TextAlign = ContentAlignment.TopRight;
        // buttonInfo8
        buttonInfo8.setFlatStyle(FlatStyle.Flat);
        buttonInfo8.setLocation(new Point(120, 200));
        buttonInfo8.setName("buttonInfo8");
        buttonInfo8.setSize(new FormSize(34, 22));
        buttonInfo8.setTabIndex(19);
        buttonInfo8.setText("Info");
        buttonInfo8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName8
        lblName8.setLocation(new Point(48, 204));
        lblName8.setName("lblName8");
        lblName8.setSize(new FormSize(70, 13));
        lblName8.setTabIndex(66);
        lblName8.setText("Termite");
        // buttonBuy8
        buttonBuy8.setFlatStyle(FlatStyle.Flat);
        buttonBuy8.setLocation(new Point(8, 200));
        buttonBuy8.setName("buttonBuy8");
        buttonBuy8.setSize(new FormSize(35, 22));
        buttonBuy8.setTabIndex(9);
        buttonBuy8.setText("Buy");
        buttonBuy8.setVisible(false);
        buttonBuy8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblPrice9
        lblPrice9.setLocation(new Point(160, 228));
        lblPrice9.setName("lblPrice9");
        lblPrice9.setSize(new FormSize(64, 13));
        lblPrice9.setTabIndex(72);
        lblPrice9.setText("not sold");
        lblPrice9.TextAlign = ContentAlignment.TopRight;
        // buttonInfo9
        buttonInfo9.setFlatStyle(FlatStyle.Flat);
        buttonInfo9.setLocation(new Point(120, 224));
        buttonInfo9.setName("buttonInfo9");
        buttonInfo9.setSize(new FormSize(34, 22));
        buttonInfo9.setTabIndex(20);
        buttonInfo9.setText("Info");
        buttonInfo9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // lblName9
        lblName9.setLocation(new Point(48, 228));
        lblName9.setName("lblName9");
        lblName9.setSize(new FormSize(70, 13));
        lblName9.setTabIndex(70);
        lblName9.setText("Wasp");
        // buttonBuy9
        buttonBuy9.setFlatStyle(FlatStyle.Flat);
        buttonBuy9.setLocation(new Point(8, 224));
        buttonBuy9.setName("buttonBuy9");
        buttonBuy9.setSize(new FormSize(35, 22));
        buttonBuy9.setTabIndex(10);
        buttonBuy9.setText("Buy");
        buttonBuy9.setVisible(false);
        buttonBuy9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonBuyInfo_Click(sender, e);
            }
        });
        // boxShipInfo
        boxShipInfo.Controls.addAll(lblCrew,
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
                lblSizeLabel);
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
        lblGadgetLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblGadgetLabel.setLocation(new Point(8, 208));
        lblGadgetLabel.setName("lblGadgetLabel");
        lblGadgetLabel.setSize(new FormSize(76, 13));
        lblGadgetLabel.setTabIndex(11);
        lblGadgetLabel.setText("Gadget Slots:");
        // lblCrewLabel
        lblCrewLabel.setAutoSize(true);
        lblCrewLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblCrewLabel.setLocation(new Point(8, 224));
        lblCrewLabel.setName("lblCrewLabel");
        lblCrewLabel.setSize(new FormSize(84, 13));
        lblCrewLabel.setTabIndex(10);
        lblCrewLabel.setText("Crew Quarters:");
        // lblShieldLabel
        lblShieldLabel.setAutoSize(true);
        lblShieldLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblShieldLabel.setLocation(new Point(8, 192));
        lblShieldLabel.setName("lblShieldLabel");
        lblShieldLabel.setSize(new FormSize(70, 13));
        lblShieldLabel.setTabIndex(9);
        lblShieldLabel.setText("Shield Slots:");
        // lblWeaponLabel
        lblWeaponLabel.setAutoSize(true);
        lblWeaponLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblWeaponLabel.setLocation(new Point(8, 176));
        lblWeaponLabel.setName("lblWeaponLabel");
        lblWeaponLabel.setSize(new FormSize(81, 13));
        lblWeaponLabel.setTabIndex(8);
        lblWeaponLabel.setText("Weapon Slots:");
        // lblHullLabel
        lblHullLabel.setAutoSize(true);
        lblHullLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblHullLabel.setLocation(new Point(8, 160));
        lblHullLabel.setName("lblHullLabel");
        lblHullLabel.setSize(new FormSize(73, 13));
        lblHullLabel.setTabIndex(7);
        lblHullLabel.setText("Hull Strength");
        // lblRangeLabel
        lblRangeLabel.setAutoSize(true);
        lblRangeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblRangeLabel.setLocation(new Point(8, 144));
        lblRangeLabel.setName("lblRangeLabel");
        lblRangeLabel.setSize(new FormSize(42, 13));
        lblRangeLabel.setTabIndex(6);
        lblRangeLabel.setText("Range:");
        // lblBaysLabel
        lblBaysLabel.setAutoSize(true);
        lblBaysLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblBaysLabel.setLocation(new Point(8, 128));
        lblBaysLabel.setName("lblBaysLabel");
        lblBaysLabel.setSize(new FormSize(69, 13));
        lblBaysLabel.setTabIndex(5);
        lblBaysLabel.setText("Cargo Bays:");
        // lblNameLabel
        lblNameLabel.setAutoSize(true);
        lblNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblNameLabel.setLocation(new Point(8, 96));
        lblNameLabel.setName("lblNameLabel");
        lblNameLabel.setSize(new FormSize(39, 13));
        lblNameLabel.setTabIndex(4);
        lblNameLabel.setText("Name:");
        // lblSizeLabel
        lblSizeLabel.setAutoSize(true);
        lblSizeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblSizeLabel.setLocation(new Point(8, 112));
        lblSizeLabel.setName("lblSizeLabel");
        lblSizeLabel.setSize(new FormSize(31, 13));
        lblSizeLabel.setTabIndex(3);
        lblSizeLabel.setText("Size:");
        // FormShipList
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(438, 255));
        Controls.addAll(Arrays.asList(
                boxShipInfo,
                lblPrice9,
                buttonInfo9,
                lblName9,
                buttonBuy9,
                lblPrice8,
                buttonInfo8,
                lblName8,
                buttonBuy8,
                lblPrice7,
                buttonInfo7,
                lblName7,
                buttonBuy7,
                lblPrice6,
                buttonInfo6,
                lblName6,
                buttonBuy6,
                lblPrice5,
                buttonInfo5,
                lblName5,
                buttonBuy5,
                lblPrice4,
                buttonInfo4,
                lblName4,
                buttonBuy4,
                lblPrice3,
                buttonInfo3,
                lblName3,
                buttonBuy3,
                lblPrice2,
                buttonInfo2,
                lblName2,
                buttonBuy2,
                lblPrice1,
                buttonInfo1,
                lblName1,
                buttonBuy1,
                lblPrice0,
                buttonInfo0,
                lblName0,
                buttonBuy0,
                buttonClose));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormShipList");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Ship List");
        boxShipInfo.ResumeLayout(false);
        ResumeLayout(false);
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
        buttonBuy = new Button[]{
                buttonBuy0,
                buttonBuy1,
                buttonBuy2,
                buttonBuy3,
                buttonBuy4,
                buttonBuy5,
                buttonBuy6,
                buttonBuy7,
                buttonBuy8,
                buttonBuy9,};
        UpdateAll();
        Info(ship.Type().CastToInt());
        if (ship.getTribbles() > 0 && !game.getTribbleMessage()) {
            FormAlert.Alert(AlertType.TribblesTradeIn, this);
            game.setTribbleMessage(true);
        }
    }


    private void Buy(int id) {
        Info(id);
        if (cmdr.TradeShip(Constants.ShipSpecs[id], prices[id], this)) {
            if (game.getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
                game.setQuestStatusScarab(SpecialEvent.StatusScarabNotStarted);
            }
            UpdateAll();
            game.getParentWindow().UpdateAll();
        }
    }

    private void Info(int id) {
        ShipSpec spec = Constants.ShipSpecs[id];
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
        for (int i = 0; i < lblPrice.length; i++) {
            buttonBuy[i].setVisible(false);
            if (Constants.ShipSpecs[i].MinimumTechLevel().ordinal() > cmdr.CurrentSystem().TechLevel().ordinal()) {
                lblPrice[i].setText("not sold");
            } else if (Constants.ShipSpecs[i].Type() == ship.Type()) {
                lblPrice[i].setText(Strings.ShipBuyGotOne);
            } else {
                buttonBuy[i].setVisible(true);
                prices[i] = Constants.ShipSpecs[i].getPrice() - ship.Worth(false);
                lblPrice[i].setText(Functions.FormatMoney(prices[i]));
            }
        }
    }

    private void buttonBuyInfo_Click(Object sender, EventArgs e) {
        String name = ((Button) sender).getName();
        int index = Integer.parseInt(name.substring(name.length() - 1));
        if (!name.contains("Buy")) {
            Info(index);
        } else {
            Buy(index);
        }
    }
}
