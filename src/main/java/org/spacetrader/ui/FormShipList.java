package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.ShipSpec;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormShipList extends wfForm {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Ship ship = commander.getShip();
    private final PictureBox pictureShip;
    private final Label labelName;
    private final Label labelSize;
    private final Label labelBays;
    private final Label labelRange;
    private final Label labelHull;
    private final Label labelWeapon;
    private final Label labelShield;
    private final Label labelGadget;
    private final Label labelCrew;
    private final Label[] labelPrice;
    private final Button[] buttonBuy;
    private final int[] prices = new int[Constants.ShipSpecs.length];

    public FormShipList() {
        Button buttonClose = new Button();
        Button buttonBuy0 = new Button();
        Label labelName0 = new Label();
        Button buttonInfo0 = new Button();
        Label labelPrice0 = new Label();
        Label labelPrice1 = new Label();
        Button buttonInfo1 = new Button();
        Label labelName1 = new Label();
        Button buttonBuy1 = new Button();
        Label labelPrice2 = new Label();
        Button buttonInfo2 = new Button();
        Label labelName2 = new Label();
        Button buttonBuy2 = new Button();
        Label labelPrice3 = new Label();
        Button buttonInfo3 = new Button();
        Label labelName3 = new Label();
        Button buttonBuy3 = new Button();
        Label labelPrice4 = new Label();
        Button buttonInfo4 = new Button();
        Label labelName4 = new Label();
        Button buttonBuy4 = new Button();
        Label labelPrice5 = new Label();
        Button buttonInfo5 = new Button();
        Label labelName5 = new Label();
        Button buttonBuy5 = new Button();
        Label labelPrice6 = new Label();
        Button buttonInfo6 = new Button();
        Label labelName6 = new Label();
        Button buttonBuy6 = new Button();
        Label labelPrice7 = new Label();
        Button buttonInfo7 = new Button();
        Label labelName7 = new Label();
        Button buttonBuy7 = new Button();
        Label labelPrice8 = new Label();
        Button buttonInfo8 = new Button();
        Label labelName8 = new Label();
        Button buttonBuy8 = new Button();
        Label labelPrice9 = new Label();
        Button buttonInfo9 = new Button();
        Label labelName9 = new Label();
        Button buttonBuy9 = new Button();
        GroupBox boxShipInfo = new GroupBox();
        labelCrew = new Label();
        labelGadget = new Label();
        labelShield = new Label();
        labelWeapon = new Label();
        labelHull = new Label();
        labelRange = new Label();
        labelBays = new Label();
        labelSize = new Label();
        labelName = new Label();
        pictureShip = new PictureBox();
        Label labelGadgetLabel = new Label();
        Label labelCrewLabel = new Label();
        Label labelShieldLabel = new Label();
        Label labelWeaponLabel = new Label();
        Label labelHullLabel = new Label();
        Label labelRangeLabel = new Label();
        Label labelBaysLabel = new Label();
        Label labelNameLabel = new Label();
        Label labelSizeLabel = new Label();
        boxShipInfo.SuspendLayout();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new SizeF(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // buttonBuy0
        buttonBuy0.setFlatStyle(FlatStyle.Flat);
        buttonBuy0.setLocation(new Point(8, 8));
        buttonBuy0.setName("buttonBuy0");
        buttonBuy0.setSize(new SizeF(22, 35));
        buttonBuy0.setTabIndex(1);
        buttonBuy0.setText("Buy");
        buttonBuy0.setVisible(false);
        buttonBuy0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName0
        labelName0.setLocation(new Point(48, 12));
        labelName0.setName("labelName0");
        labelName0.setSize(new SizeF(13, 70));
        labelName0.setTabIndex(34);
        labelName0.setText("Flea");
        // buttonInfo0
        buttonInfo0.setFlatStyle(FlatStyle.Flat);
        buttonInfo0.setLocation(new Point(120, 8));
        buttonInfo0.setName("buttonInfo0");
        buttonInfo0.setSize(new SizeF(22, 34));
        buttonInfo0.setTabIndex(11);
        buttonInfo0.setText("Info");
        buttonInfo0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice0
        labelPrice0.setLocation(new Point(160, 12));
        labelPrice0.setName("labelPrice0");
        labelPrice0.setSize(new SizeF(13, 64));
        labelPrice0.setTabIndex(36);
        labelPrice0.setText("-888,888 cr.");
        labelPrice0.TextAlign = ContentAlignment.TopRight;
        // labelPrice1
        labelPrice1.setLocation(new Point(160, 36));
        labelPrice1.setName("labelPrice1");
        labelPrice1.setSize(new SizeF(13, 64));
        labelPrice1.setTabIndex(40);
        labelPrice1.setText("-888,888 cr.");
        labelPrice1.TextAlign = ContentAlignment.TopRight;
        // buttonInfo1
        buttonInfo1.setFlatStyle(FlatStyle.Flat);
        buttonInfo1.setLocation(new Point(120, 32));
        buttonInfo1.setName("buttonInfo1");
        buttonInfo1.setSize(new SizeF(22, 34));
        buttonInfo1.setTabIndex(12);
        buttonInfo1.setText("Info");
        buttonInfo1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName1
        labelName1.setLocation(new Point(48, 36));
        labelName1.setName("labelName1");
        labelName1.setSize(new SizeF(13, 70));
        labelName1.setTabIndex(38);
        labelName1.setText("Gnat");
        // buttonBuy1
        buttonBuy1.setFlatStyle(FlatStyle.Flat);
        buttonBuy1.setLocation(new Point(8, 32));
        buttonBuy1.setName("buttonBuy1");
        buttonBuy1.setSize(new SizeF(22, 35));
        buttonBuy1.setTabIndex(2);
        buttonBuy1.setText("Buy");
        buttonBuy1.setVisible(false);
        buttonBuy1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice2
        labelPrice2.setLocation(new Point(160, 60));
        labelPrice2.setName("labelPrice2");
        labelPrice2.setSize(new SizeF(13, 64));
        labelPrice2.setTabIndex(44);
        labelPrice2.setText("-888,888 cr.");
        labelPrice2.TextAlign = ContentAlignment.TopRight;
        // buttonInfo2
        buttonInfo2.setFlatStyle(FlatStyle.Flat);
        buttonInfo2.setLocation(new Point(120, 56));
        buttonInfo2.setName("buttonInfo2");
        buttonInfo2.setSize(new SizeF(22, 34));
        buttonInfo2.setTabIndex(13);
        buttonInfo2.setText("Info");
        buttonInfo2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName2
        labelName2.setLocation(new Point(48, 60));
        labelName2.setName("labelName2");
        labelName2.setSize(new SizeF(13, 70));
        labelName2.setTabIndex(42);
        labelName2.setText("Firefly");
        // buttonBuy2
        buttonBuy2.setFlatStyle(FlatStyle.Flat);
        buttonBuy2.setLocation(new Point(8, 56));
        buttonBuy2.setName("buttonBuy2");
        buttonBuy2.setSize(new SizeF(22, 35));
        buttonBuy2.setTabIndex(3);
        buttonBuy2.setText("Buy");
        buttonBuy2.setVisible(false);
        buttonBuy2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice3
        labelPrice3.setLocation(new Point(160, 84));
        labelPrice3.setName("labelPrice3");
        labelPrice3.setSize(new SizeF(13, 64));
        labelPrice3.setTabIndex(48);
        labelPrice3.setText("-888,888 cr.");
        labelPrice3.TextAlign = ContentAlignment.TopRight;
        // buttonInfo3
        buttonInfo3.setFlatStyle(FlatStyle.Flat);
        buttonInfo3.setLocation(new Point(120, 80));
        buttonInfo3.setName("buttonInfo3");
        buttonInfo3.setSize(new SizeF(22, 34));
        buttonInfo3.setTabIndex(14);
        buttonInfo3.setText("Info");
        buttonInfo3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName3
        labelName3.setLocation(new Point(48, 84));
        labelName3.setName("labelName3");
        labelName3.setSize(new SizeF(13, 70));
        labelName3.setTabIndex(46);
        labelName3.setText("Mosquito");
        // buttonBuy3
        buttonBuy3.setFlatStyle(FlatStyle.Flat);
        buttonBuy3.setLocation(new Point(8, 80));
        buttonBuy3.setName("buttonBuy3");
        buttonBuy3.setSize(new SizeF(22, 35));
        buttonBuy3.setTabIndex(4);
        buttonBuy3.setText("Buy");
        buttonBuy3.setVisible(false);
        buttonBuy3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice4
        labelPrice4.setLocation(new Point(160, 108));
        labelPrice4.setName("labelPrice4");
        labelPrice4.setSize(new SizeF(13, 64));
        labelPrice4.setTabIndex(52);
        labelPrice4.setText("-888,888 cr.");
        labelPrice4.TextAlign = ContentAlignment.TopRight;
        // buttonInfo4
        buttonInfo4.setFlatStyle(FlatStyle.Flat);
        buttonInfo4.setLocation(new Point(120, 104));
        buttonInfo4.setName("buttonInfo4");
        buttonInfo4.setSize(new SizeF(22, 34));
        buttonInfo4.setTabIndex(15);
        buttonInfo4.setText("Info");
        buttonInfo4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName4
        labelName4.setLocation(new Point(48, 108));
        labelName4.setName("labelName4");
        labelName4.setSize(new SizeF(13, 70));
        labelName4.setTabIndex(50);
        labelName4.setText("Bumblebee");
        // buttonBuy4
        buttonBuy4.setFlatStyle(FlatStyle.Flat);
        buttonBuy4.setLocation(new Point(8, 104));
        buttonBuy4.setName("buttonBuy4");
        buttonBuy4.setSize(new SizeF(22, 35));
        buttonBuy4.setTabIndex(5);
        buttonBuy4.setText("Buy");
        buttonBuy4.setVisible(false);
        buttonBuy4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice5
        labelPrice5.setLocation(new Point(160, 132));
        labelPrice5.setName("labelPrice5");
        labelPrice5.setSize(new SizeF(13, 64));
        labelPrice5.setTabIndex(56);
        labelPrice5.setText("got one");
        labelPrice5.TextAlign = ContentAlignment.TopRight;
        // buttonInfo5
        buttonInfo5.setFlatStyle(FlatStyle.Flat);
        buttonInfo5.setLocation(new Point(120, 128));
        buttonInfo5.setName("buttonInfo5");
        buttonInfo5.setSize(new SizeF(22, 34));
        buttonInfo5.setTabIndex(16);
        buttonInfo5.setText("Info");
        buttonInfo5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName5
        labelName5.setLocation(new Point(48, 132));
        labelName5.setName("labelName5");
        labelName5.setSize(new SizeF(13, 70));
        labelName5.setTabIndex(54);
        labelName5.setText("Beetle");
        // buttonBuy5
        buttonBuy5.setFlatStyle(FlatStyle.Flat);
        buttonBuy5.setLocation(new Point(8, 128));
        buttonBuy5.setName("buttonBuy5");
        buttonBuy5.setSize(new SizeF(22, 35));
        buttonBuy5.setTabIndex(6);
        buttonBuy5.setText("Buy");
        buttonBuy5.setVisible(false);
        buttonBuy5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice6
        labelPrice6.setLocation(new Point(160, 156));
        labelPrice6.setName("labelPrice6");
        labelPrice6.setSize(new SizeF(13, 64));
        labelPrice6.setTabIndex(60);
        labelPrice6.setText("-888,888 cr.");
        labelPrice6.TextAlign = ContentAlignment.TopRight;
        // buttonInfo6
        buttonInfo6.setFlatStyle(FlatStyle.Flat);
        buttonInfo6.setLocation(new Point(120, 152));
        buttonInfo6.setName("buttonInfo6");
        buttonInfo6.setSize(new SizeF(22, 34));
        buttonInfo6.setTabIndex(17);
        buttonInfo6.setText("Info");
        buttonInfo6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName6
        labelName6.setLocation(new Point(48, 156));
        labelName6.setName("labelName6");
        labelName6.setSize(new SizeF(13, 70));
        labelName6.setTabIndex(58);
        labelName6.setText("Hornet");
        // buttonBuy6
        buttonBuy6.setFlatStyle(FlatStyle.Flat);
        buttonBuy6.setLocation(new Point(8, 152));
        buttonBuy6.setName("buttonBuy6");
        buttonBuy6.setSize(new SizeF(22, 35));
        buttonBuy6.setTabIndex(7);
        buttonBuy6.setText("Buy");
        buttonBuy6.setVisible(false);
        buttonBuy6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice7
        labelPrice7.setLocation(new Point(160, 180));
        labelPrice7.setName("labelPrice7");
        labelPrice7.setSize(new SizeF(13, 64));
        labelPrice7.setTabIndex(64);
        labelPrice7.setText("-888,888 cr.");
        labelPrice7.TextAlign = ContentAlignment.TopRight;
        // buttonInfo7
        buttonInfo7.setFlatStyle(FlatStyle.Flat);
        buttonInfo7.setLocation(new Point(120, 176));
        buttonInfo7.setName("buttonInfo7");
        buttonInfo7.setSize(new SizeF(22, 34));
        buttonInfo7.setTabIndex(18);
        buttonInfo7.setText("Info");
        buttonInfo7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName7
        labelName7.setLocation(new Point(48, 180));
        labelName7.setName("labelName7");
        labelName7.setSize(new SizeF(13, 70));
        labelName7.setTabIndex(62);
        labelName7.setText("Grasshopper");
        // buttonBuy7
        buttonBuy7.setFlatStyle(FlatStyle.Flat);
        buttonBuy7.setLocation(new Point(8, 176));
        buttonBuy7.setName("buttonBuy7");
        buttonBuy7.setSize(new SizeF(22, 35));
        buttonBuy7.setTabIndex(8);
        buttonBuy7.setText("Buy");
        buttonBuy7.setVisible(false);
        buttonBuy7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice8
        labelPrice8.setLocation(new Point(160, 204));
        labelPrice8.setName("labelPrice8");
        labelPrice8.setSize(new SizeF(13, 64));
        labelPrice8.setTabIndex(68);
        labelPrice8.setText("-888,888 cr.");
        labelPrice8.TextAlign = ContentAlignment.TopRight;
        // buttonInfo8
        buttonInfo8.setFlatStyle(FlatStyle.Flat);
        buttonInfo8.setLocation(new Point(120, 200));
        buttonInfo8.setName("buttonInfo8");
        buttonInfo8.setSize(new SizeF(22, 34));
        buttonInfo8.setTabIndex(19);
        buttonInfo8.setText("Info");
        buttonInfo8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName8
        labelName8.setLocation(new Point(48, 204));
        labelName8.setName("labelName8");
        labelName8.setSize(new SizeF(13, 70));
        labelName8.setTabIndex(66);
        labelName8.setText("Termite");
        // buttonBuy8
        buttonBuy8.setFlatStyle(FlatStyle.Flat);
        buttonBuy8.setLocation(new Point(8, 200));
        buttonBuy8.setName("buttonBuy8");
        buttonBuy8.setSize(new SizeF(22, 35));
        buttonBuy8.setTabIndex(9);
        buttonBuy8.setText("Buy");
        buttonBuy8.setVisible(false);
        buttonBuy8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelPrice9
        labelPrice9.setLocation(new Point(160, 228));
        labelPrice9.setName("labelPrice9");
        labelPrice9.setSize(new SizeF(13, 64));
        labelPrice9.setTabIndex(72);
        labelPrice9.setText("not sold");
        labelPrice9.TextAlign = ContentAlignment.TopRight;
        // buttonInfo9
        buttonInfo9.setFlatStyle(FlatStyle.Flat);
        buttonInfo9.setLocation(new Point(120, 224));
        buttonInfo9.setName("buttonInfo9");
        buttonInfo9.setSize(new SizeF(22, 34));
        buttonInfo9.setTabIndex(20);
        buttonInfo9.setText("Info");
        buttonInfo9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // labelName9
        labelName9.setLocation(new Point(48, 228));
        labelName9.setName("labelName9");
        labelName9.setSize(new SizeF(13, 70));
        labelName9.setTabIndex(70);
        labelName9.setText("Wasp");
        // buttonBuy9
        buttonBuy9.setFlatStyle(FlatStyle.Flat);
        buttonBuy9.setLocation(new Point(8, 224));
        buttonBuy9.setName("buttonBuy9");
        buttonBuy9.setSize(new SizeF(22, 35));
        buttonBuy9.setTabIndex(10);
        buttonBuy9.setText("Buy");
        buttonBuy9.setVisible(false);
        buttonBuy9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonBuyInfo_Click(sender, data);
            }
        });
        // boxShipInfo
        boxShipInfo.Controls.addAll(labelCrew,
                labelGadget,
                labelShield,
                labelWeapon,
                labelHull,
                labelRange,
                labelBays,
                labelSize,
                labelName,
                pictureShip,
                labelGadgetLabel,
                labelCrewLabel,
                labelShieldLabel,
                labelWeaponLabel,
                labelHullLabel,
                labelRangeLabel,
                labelBaysLabel,
                labelNameLabel,
                labelSizeLabel);
        boxShipInfo.setLocation(new Point(232, 0));
        boxShipInfo.setName("boxShipInfo");
        boxShipInfo.setSize(new SizeF(248, 200));
        boxShipInfo.setTabIndex(73);
        boxShipInfo.setTabStop(false);
        boxShipInfo.setText("Ship Information");
        // labelCrew
        labelCrew.setLocation(new Point(96, 224));
        labelCrew.setName("labelCrew");
        labelCrew.setSize(new SizeF(13, 10));
        labelCrew.setTabIndex(43);
        labelCrew.setText("8");
        // labelGadget
        labelGadget.setLocation(new Point(96, 208));
        labelGadget.setName("labelGadget");
        labelGadget.setSize(new SizeF(13, 10));
        labelGadget.setTabIndex(42);
        labelGadget.setText("8");
        // labelShield
        labelShield.setLocation(new Point(96, 192));
        labelShield.setName("labelShield");
        labelShield.setSize(new SizeF(13, 10));
        labelShield.setTabIndex(41);
        labelShield.setText("8");
        // labelWeapon
        labelWeapon.setLocation(new Point(96, 176));
        labelWeapon.setName("labelWeapon");
        labelWeapon.setSize(new SizeF(13, 10));
        labelWeapon.setTabIndex(40);
        labelWeapon.setText("8");
        // labelHull
        labelHull.setLocation(new Point(96, 160));
        labelHull.setName("labelHull");
        labelHull.setSize(new SizeF(13, 23));
        labelHull.setTabIndex(39);
        labelHull.setText("888");
        // labelRange
        labelRange.setLocation(new Point(96, 144));
        labelRange.setName("labelRange");
        labelRange.setSize(new SizeF(13, 59));
        labelRange.setTabIndex(38);
        labelRange.setText("88 parsecs");
        // labelBays
        labelBays.setLocation(new Point(96, 128));
        labelBays.setName("labelBays");
        labelBays.setSize(new SizeF(13, 17));
        labelBays.setTabIndex(37);
        labelBays.setText("88");
        // labelSize
        labelSize.setLocation(new Point(96, 112));
        labelSize.setName("labelSize");
        labelSize.setSize(new SizeF(13, 45));
        labelSize.setTabIndex(36);
        labelSize.setText("Medium");
        // labelName
        labelName.setLocation(new Point(96, 96));
        labelName.setName("labelName");
        labelName.setSize(new SizeF(13, 100));
        labelName.setTabIndex(35);
        labelName.setText("Grasshopper");
        // pictureShip
        pictureShip.setBackColor(Color.white);
        pictureShip.setBorderStyle(BorderStyle.FixedSingle);
        pictureShip.setLocation(new Point(67, 25));
        pictureShip.setName("pictureShip");
        pictureShip.setSize(new SizeF(54, 66));
        pictureShip.setTabIndex(12);
        pictureShip.setTabStop(false);
        // labelGadgetLabel
        labelGadgetLabel.setAutoSize(true);
        labelGadgetLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelGadgetLabel.setLocation(new Point(8, 208));
        labelGadgetLabel.setName("labelGadgetLabel");
        labelGadgetLabel.setSize(new SizeF(13, 76));
        labelGadgetLabel.setTabIndex(11);
        labelGadgetLabel.setText("Gadget Slots:");
        // labelCrewLabel
        labelCrewLabel.setAutoSize(true);
        labelCrewLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelCrewLabel.setLocation(new Point(8, 224));
        labelCrewLabel.setName("labelCrewLabel");
        labelCrewLabel.setSize(new SizeF(13, 84));
        labelCrewLabel.setTabIndex(10);
        labelCrewLabel.setText("Crew Quarters:");
        // labelShieldLabel
        labelShieldLabel.setAutoSize(true);
        labelShieldLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelShieldLabel.setLocation(new Point(8, 192));
        labelShieldLabel.setName("labelShieldLabel");
        labelShieldLabel.setSize(new SizeF(13, 70));
        labelShieldLabel.setTabIndex(9);
        labelShieldLabel.setText("Shield Slots:");
        // labelWeaponLabel
        labelWeaponLabel.setAutoSize(true);
        labelWeaponLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelWeaponLabel.setLocation(new Point(8, 176));
        labelWeaponLabel.setName("labelWeaponLabel");
        labelWeaponLabel.setSize(new SizeF(13, 81));
        labelWeaponLabel.setTabIndex(8);
        labelWeaponLabel.setText("Weapon Slots:");
        // labelHullLabel
        labelHullLabel.setAutoSize(true);
        labelHullLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelHullLabel.setLocation(new Point(8, 160));
        labelHullLabel.setName("labelHullLabel");
        labelHullLabel.setSize(new SizeF(13, 73));
        labelHullLabel.setTabIndex(7);
        labelHullLabel.setText("Hull Strength");
        // labelRangeLabel
        labelRangeLabel.setAutoSize(true);
        labelRangeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelRangeLabel.setLocation(new Point(8, 144));
        labelRangeLabel.setName("labelRangeLabel");
        labelRangeLabel.setSize(new SizeF(13, 42));
        labelRangeLabel.setTabIndex(6);
        labelRangeLabel.setText("Range:");
        // labelBaysLabel
        labelBaysLabel.setAutoSize(true);
        labelBaysLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelBaysLabel.setLocation(new Point(8, 128));
        labelBaysLabel.setName("labelBaysLabel");
        labelBaysLabel.setSize(new SizeF(13, 69));
        labelBaysLabel.setTabIndex(5);
        labelBaysLabel.setText("Cargo Bays:");
        // labelNameLabel
        labelNameLabel.setAutoSize(true);
        labelNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelNameLabel.setLocation(new Point(8, 96));
        labelNameLabel.setName("labelNameLabel");
        labelNameLabel.setSize(new SizeF(13, 39));
        labelNameLabel.setTabIndex(4);
        labelNameLabel.setText("Name:");
        // labelSizeLabel
        labelSizeLabel.setAutoSize(true);
        labelSizeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSizeLabel.setLocation(new Point(8, 112));
        labelSizeLabel.setName("labelSizeLabel");
        labelSizeLabel.setSize(new SizeF(13, 31));
        labelSizeLabel.setTabIndex(3);
        labelSizeLabel.setText("Size:");
        // FormShipList
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonClose);
        setClientSize(new SizeF(255, 438));
        Controls.addAll(Arrays.asList(
                boxShipInfo,
                labelPrice9,
                buttonInfo9,
                labelName9,
                buttonBuy9,
                labelPrice8,
                buttonInfo8,
                labelName8,
                buttonBuy8,
                labelPrice7,
                buttonInfo7,
                labelName7,
                buttonBuy7,
                labelPrice6,
                buttonInfo6,
                labelName6,
                buttonBuy6,
                labelPrice5,
                buttonInfo5,
                labelName5,
                buttonBuy5,
                labelPrice4,
                buttonInfo4,
                labelName4,
                buttonBuy4,
                labelPrice3,
                buttonInfo3,
                labelName3,
                buttonBuy3,
                labelPrice2,
                buttonInfo2,
                labelName2,
                buttonBuy2,
                labelPrice1,
                buttonInfo1,
                labelName1,
                buttonBuy1,
                labelPrice0,
                buttonInfo0,
                labelName0,
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
        labelPrice = new Label[]{
                labelPrice0,
                labelPrice1,
                labelPrice2,
                labelPrice3,
                labelPrice4,
                labelPrice5,
                labelPrice6,
                labelPrice7,
                labelPrice8,
                labelPrice9,};
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
        Info(ship.Type().getId());
        if (ship.getTribbles() > 0 && !game.getTribbleMessage()) {
            FormAlert.Alert(AlertType.TribblesTradeIn, this);
            game.setTribbleMessage(true);
        }
    }


    private void Buy(int id) {
        Info(id);
        if (commander.TradeShip(Constants.ShipSpecs[id], prices[id], this)) {
            if (game.getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
                game.setQuestStatusScarab(SpecialEvent.StatusScarabNotStarted);
            }
            UpdateAll();
            game.getParentWindow().UpdateAll();
        }
    }

    private void Info(int id) {
        ShipSpec spec = Constants.ShipSpecs[id];
        pictureShip.setImage(spec.Image());
        labelName.setText(spec.Name());
        labelSize.setText(Strings.Sizes[spec.getSize().getId()]);
        labelBays.setText(Functions.FormatNumber(spec.CargoBays()));
        labelRange.setText(Functions.Multiples(spec.FuelTanks(), Strings.DistanceUnit));
        labelHull.setText(Functions.FormatNumber(spec.HullStrength()));
        labelWeapon.setText(Functions.FormatNumber(spec.getWeaponSlots()));
        labelShield.setText(Functions.FormatNumber(spec.getShieldSlots()));
        labelGadget.setText(Functions.FormatNumber(spec.getGadgetSlots()));
        labelCrew.setText(Functions.FormatNumber(spec.getCrewQuarters()));
    }

    private void UpdateAll() {
        for (int i = 0; i < labelPrice.length; i++) {
            buttonBuy[i].setVisible(false);
            if (Constants.ShipSpecs[i].MinimumTechLevel().ordinal() > commander.CurrentSystem().TechLevel().ordinal()) {
                labelPrice[i].setText("not sold");
            } else if (Constants.ShipSpecs[i].Type() == ship.Type()) {
                labelPrice[i].setText(Strings.ShipBuyGotOne);
            } else {
                buttonBuy[i].setVisible(true);
                prices[i] = Constants.ShipSpecs[i].getPrice() - ship.Worth(false);
                labelPrice[i].setText(Functions.FormatMoney(prices[i]));
            }
        }
    }

    private void buttonBuyInfo_Click(Object sender, EventData e) {
        String name = ((Button) sender).getName();
        int index = Integer.parseInt(name.substring(name.length() - 1));
        if (!name.contains("Buy")) {
            Info(index);
        } else {
            Buy(index);
        }
    }
}
