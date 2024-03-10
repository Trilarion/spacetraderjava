package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.controller.enums.AlertType;
import org.spacetrader.model.events.EncounterResult;
import org.winforms.Button;
import org.winforms.Container;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;


public class FormEncounter extends wfForm {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Ship commandership = commander.getShip();
    private final Ship opponent = game.getOpponent();
    private final Button buttonFlee;
    private final Button buttonBribe;
    private final Button buttonSurrender;
    private final Button buttonIgnore;
    private final Button buttonBoard;
    private final Button buttonDrink;
    private final Button buttonInt;
    private final Button buttonYield;
    private final Button[] buttons;
    private final ImageList ilContinuous;
    private final ImageList ilTribbles;
    private final Label labelEncounter;
    private final Label labelOpponentShip;
    private final Label labelYouShip;
    private final Label labelYouHull;
    private final Label labelYouShields;
    private final Label labelOpponentShields;
    private final Label labelOpponentHull;
    private final Label labelAction;
    private final PictureBox pictureShipYou;
    private final PictureBox pictureShipOpponent;
    private final PictureBox pictureContinuous;
    private final PictureBox pictureTribbles00;
    private final PictureBox pictureTribbles50;
    private final PictureBox pictureTribbles10;
    private final PictureBox pictureTribbles40;
    private final PictureBox pictureTribbles20;
    private final PictureBox pictureTribbles30;
    private final PictureBox pictureTribbles04;
    private final PictureBox pictureTribbles03;
    private final PictureBox pictureTribbles02;
    private final PictureBox pictureTribbles01;
    private final PictureBox pictureTribbles05;
    private final PictureBox pictureTribbles11;
    private final PictureBox pictureTribbles12;
    private final PictureBox pictureTribbles13;
    private final PictureBox pictureTribbles14;
    private final PictureBox pictureTribbles15;
    private final PictureBox pictureTribbles21;
    private final PictureBox pictureTribbles22;
    private final PictureBox pictureTribbles23;
    private final PictureBox pictureTribbles24;
    private final PictureBox pictureTribbles25;
    private final PictureBox pictureTribbles31;
    private final PictureBox pictureTribbles32;
    private final PictureBox pictureTribbles33;
    private final PictureBox pictureTribbles34;
    private final PictureBox pictureTribbles35;
    private final PictureBox pictureTribbles41;
    private final PictureBox pictureTribbles51;
    private final PictureBox pictureTribbles42;
    private final PictureBox pictureTribbles52;
    private final PictureBox pictureTribbles43;
    private final PictureBox pictureTribbles53;
    private final PictureBox pictureTribbles44;
    private final PictureBox pictureTribbles45;
    private final PictureBox pictureTribbles54;
    private final PictureBox pictureTribbles55;
    private final Timer timerTick;
    private int contImg = 1;
    private EncounterResult _result = EncounterResult.Continue;

    public FormEncounter() {
        IContainer components = new Container();
        ResourceManager resources = new ResourceManager(FormEncounter.class);
        labelEncounter = new Label();
        pictureShipYou = new PictureBox();
        pictureShipOpponent = new PictureBox();
        labelAction = new Label();
        Label labelOpponentLabel = new Label();
        Label labelYouLabel = new Label();
        labelOpponentShip = new Label();
        labelYouShip = new Label();
        labelYouHull = new Label();
        labelYouShields = new Label();
        labelOpponentShields = new Label();
        labelOpponentHull = new Label();
        Button buttonAttack = new Button();
        buttonFlee = new Button();
        Button buttonSubmit = new Button();
        buttonBribe = new Button();
        buttonSurrender = new Button();
        buttonIgnore = new Button();
        Button buttonTrade = new Button();
        Button buttonPlunder = new Button();
        buttonBoard = new Button();
        Button buttonMeet = new Button();
        buttonDrink = new Button();
        buttonInt = new Button();
        buttonYield = new Button();
        pictureContinuous = new PictureBox();
        ilContinuous = new ImageList(components);
        PictureBox pictureEncounterType = new PictureBox();
        ImageList ilEncounterType = new ImageList(components);
        pictureTribbles00 = new PictureBox();
        ilTribbles = new ImageList(components);
        pictureTribbles50 = new PictureBox();
        pictureTribbles10 = new PictureBox();
        pictureTribbles40 = new PictureBox();
        pictureTribbles20 = new PictureBox();
        pictureTribbles30 = new PictureBox();
        pictureTribbles04 = new PictureBox();
        pictureTribbles03 = new PictureBox();
        pictureTribbles02 = new PictureBox();
        pictureTribbles01 = new PictureBox();
        pictureTribbles05 = new PictureBox();
        pictureTribbles11 = new PictureBox();
        pictureTribbles12 = new PictureBox();
        pictureTribbles13 = new PictureBox();
        pictureTribbles14 = new PictureBox();
        pictureTribbles15 = new PictureBox();
        pictureTribbles21 = new PictureBox();
        pictureTribbles22 = new PictureBox();
        pictureTribbles23 = new PictureBox();
        pictureTribbles24 = new PictureBox();
        pictureTribbles25 = new PictureBox();
        pictureTribbles31 = new PictureBox();
        pictureTribbles32 = new PictureBox();
        pictureTribbles33 = new PictureBox();
        pictureTribbles34 = new PictureBox();
        pictureTribbles35 = new PictureBox();
        pictureTribbles41 = new PictureBox();
        pictureTribbles51 = new PictureBox();
        pictureTribbles42 = new PictureBox();
        pictureTribbles52 = new PictureBox();
        pictureTribbles43 = new PictureBox();
        pictureTribbles53 = new PictureBox();
        pictureTribbles44 = new PictureBox();
        pictureTribbles45 = new PictureBox();
        pictureTribbles54 = new PictureBox();
        pictureTribbles55 = new PictureBox();
        timerTick = new Timer(components);
        SuspendLayout();
        // labelEncounter
        labelEncounter.setLocation(new Point(8, 152));
        labelEncounter.setName("labelEncounter");
        labelEncounter.setSize(new FormSize(232, 26));
        labelEncounter.setTabIndex(0);
        labelEncounter.setText("At 20 clicks from Tarchannen, you encounter the famous Captain Ahab.");
        // pictureShipYou
        pictureShipYou.setBackColor(Color.white);
        pictureShipYou.setBorderStyle(BorderStyle.FixedSingle);
        pictureShipYou.setLocation(new Point(26, 24));
        pictureShipYou.setName("pictureShipYou");
        pictureShipYou.setSize(new FormSize(70, 58));
        pictureShipYou.setTabIndex(13);
        pictureShipYou.setTabStop(false);
        pictureShipYou.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventData e) {
                pictureShipYou_Paint(sender, e);
            }
        });
        // pictureShipOpponent
        pictureShipOpponent.setBackColor(Color.white);
        pictureShipOpponent.setBorderStyle(BorderStyle.FixedSingle);
        pictureShipOpponent.setLocation(new Point(138, 24));
        pictureShipOpponent.setName("pictureShipOpponent");
        pictureShipOpponent.setSize(new FormSize(70, 58));
        pictureShipOpponent.setTabIndex(14);
        pictureShipOpponent.setTabStop(false);
        pictureShipOpponent.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventData e) {
                pictureShipOpponent_Paint(sender, e);
            }
        });
        // labelAction
        labelAction.setLocation(new Point(8, 192));
        labelAction.setName("labelAction");
        labelAction.setSize(new FormSize(232, 39));
        labelAction.setTabIndex(15);
        labelAction.setText("\"We know you removed illegal goods from the Marie Celeste. You must give them up at once!\"");
        // labelOpponentLabel
        labelOpponentLabel.setAutoSize(true);
        labelOpponentLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelOpponentLabel.setLocation(new Point(141, 8));
        labelOpponentLabel.setName("labelOpponentLabel");
        labelOpponentLabel.setSize(new FormSize(59, 16));
        labelOpponentLabel.setTabIndex(16);
        labelOpponentLabel.setText("Opponent:");
        // labelYouLabel
        labelYouLabel.setAutoSize(true);
        labelYouLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelYouLabel.setLocation(new Point(45, 8));
        labelYouLabel.setName("labelYouLabel");
        labelYouLabel.setSize(new FormSize(28, 16));
        labelYouLabel.setTabIndex(17);
        labelYouLabel.setText("You:");
        // labelOpponentShip
        labelOpponentShip.setLocation(new Point(138, 88));
        labelOpponentShip.setName("labelOpponentShip");
        labelOpponentShip.setSize(new FormSize(80, 13));
        labelOpponentShip.setTabIndex(18);
        labelOpponentShip.setText("Space Monster");
        // labelYouShip
        labelYouShip.setLocation(new Point(26, 88));
        labelYouShip.setName("labelYouShip");
        labelYouShip.setSize(new FormSize(100, 13));
        labelYouShip.setTabIndex(19);
        labelYouShip.setText("Grasshopper");
        // labelYouHull
        labelYouHull.setLocation(new Point(26, 104));
        labelYouHull.setName("labelYouHull");
        labelYouHull.setSize(new FormSize(68, 13));
        labelYouHull.setTabIndex(20);
        labelYouHull.setText("Hull at 100%");
        // labelYouShields
        labelYouShields.setLocation(new Point(26, 120));
        labelYouShields.setName("labelYouShields");
        labelYouShields.setSize(new FormSize(86, 13));
        labelYouShields.setTabIndex(21);
        labelYouShields.setText("Shields at 100%");
        // labelOpponentShields
        labelOpponentShields.setLocation(new Point(138, 120));
        labelOpponentShields.setName("labelOpponentShields");
        labelOpponentShields.setSize(new FormSize(86, 13));
        labelOpponentShields.setTabIndex(23);
        labelOpponentShields.setText("Shields at 100%");
        // labelOpponentHull
        labelOpponentHull.setLocation(new Point(138, 104));
        labelOpponentHull.setName("labelOpponentHull");
        labelOpponentHull.setSize(new FormSize(68, 13));
        labelOpponentHull.setTabIndex(22);
        labelOpponentHull.setText("Hull at 100%");
        // buttonAttack
        buttonAttack.setFlatStyle(FlatStyle.Flat);
        buttonAttack.setLocation(new Point(8, 240));
        buttonAttack.setName("buttonAttack");
        buttonAttack.setSize(new FormSize(46, 22));
        buttonAttack.setTabIndex(24);
        buttonAttack.setText("Attack");
        buttonAttack.setVisible(false);
        buttonAttack.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonAttack_Click(sender, e);
            }
        });
        // buttonFlee
        buttonFlee.setFlatStyle(FlatStyle.Flat);
        buttonFlee.setLocation(new Point(62, 240));
        buttonFlee.setName("buttonFlee");
        buttonFlee.setSize(new FormSize(36, 22));
        buttonFlee.setTabIndex(25);
        buttonFlee.setText("Flee");
        buttonFlee.setVisible(false);
        buttonFlee.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonFlee_Click(sender, e);
            }
        });
        // buttonSubmit
        buttonSubmit.setFlatStyle(FlatStyle.Flat);
        buttonSubmit.setLocation(new Point(106, 240));
        buttonSubmit.setName("buttonSubmit");
        buttonSubmit.setSize(new FormSize(49, 22));
        buttonSubmit.setTabIndex(26);
        buttonSubmit.setText("Submit");
        buttonSubmit.setVisible(false);
        buttonSubmit.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonSubmit_Click(sender, e);
            }
        });
        // buttonBribe
        buttonBribe.setFlatStyle(FlatStyle.Flat);
        buttonBribe.setLocation(new Point(163, 240));
        buttonBribe.setName("buttonBribe");
        buttonBribe.setSize(new FormSize(41, 22));
        buttonBribe.setTabIndex(27);
        buttonBribe.setText("Bribe");
        buttonBribe.setVisible(false);
        buttonBribe.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonBribe_Click(sender, e);
            }
        });
        // buttonSurrender
        buttonSurrender.setFlatStyle(FlatStyle.Flat);
        buttonSurrender.setLocation(new Point(106, 240));
        buttonSurrender.setName("buttonSurrender");
        buttonSurrender.setSize(new FormSize(65, 22));
        buttonSurrender.setTabIndex(28);
        buttonSurrender.setText("Surrender");
        buttonSurrender.setVisible(false);
        buttonSurrender.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonSurrender_Click(sender, e);
            }
        });
        // buttonIgnore
        buttonIgnore.setFlatStyle(FlatStyle.Flat);
        buttonIgnore.setLocation(new Point(62, 240));
        buttonIgnore.setName("buttonIgnore");
        buttonIgnore.setSize(new FormSize(46, 22));
        buttonIgnore.setTabIndex(29);
        buttonIgnore.setText("Ignore");
        buttonIgnore.setVisible(false);
        buttonIgnore.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonIgnore_Click(sender, e);
            }
        });
        // buttonTrade
        buttonTrade.setFlatStyle(FlatStyle.Flat);
        buttonTrade.setLocation(new Point(116, 240));
        buttonTrade.setName("buttonTrade");
        buttonTrade.setSize(new FormSize(44, 22));
        buttonTrade.setTabIndex(30);
        buttonTrade.setText("Trade");
        buttonTrade.setVisible(false);
        buttonTrade.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonTrade_Click(sender, e);
            }
        });
        // buttonPlunder
        buttonPlunder.setFlatStyle(FlatStyle.Flat);
        buttonPlunder.setLocation(new Point(62, 240));
        buttonPlunder.setName("buttonPlunder");
        buttonPlunder.setSize(new FormSize(53, 22));
        buttonPlunder.setTabIndex(31);
        buttonPlunder.setText("Plunder");
        buttonPlunder.setVisible(false);
        buttonPlunder.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonBoard
        buttonBoard.setFlatStyle(FlatStyle.Flat);
        buttonBoard.setLocation(new Point(8, 240));
        buttonBoard.setName("buttonBoard");
        buttonBoard.setSize(new FormSize(44, 22));
        buttonBoard.setTabIndex(32);
        buttonBoard.setText("Board");
        buttonBoard.setVisible(false);
        buttonBoard.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonBoard_Click(sender, e);
            }
        });
        // buttonMeet
        buttonMeet.setFlatStyle(FlatStyle.Flat);
        buttonMeet.setLocation(new Point(116, 240));
        buttonMeet.setName("buttonMeet");
        buttonMeet.setSize(new FormSize(39, 22));
        buttonMeet.setTabIndex(34);
        buttonMeet.setText("Meet");
        buttonMeet.setVisible(false);
        buttonMeet.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonMeet_Click(sender, e);
            }
        });
        // buttonDrink
        buttonDrink.setFlatStyle(FlatStyle.Flat);
        buttonDrink.setLocation(new Point(8, 240));
        buttonDrink.setName("buttonDrink");
        buttonDrink.setSize(new FormSize(41, 22));
        buttonDrink.setTabIndex(35);
        buttonDrink.setText("Drink");
        buttonDrink.setVisible(false);
        buttonDrink.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonDrink_Click(sender, e);
            }
        });
        // buttonInt
        buttonInt.setFlatStyle(FlatStyle.Flat);
        buttonInt.setLocation(new Point(179, 240));
        buttonInt.setName("buttonInt");
        buttonInt.setSize(new FormSize(30, 22));
        buttonInt.setTabIndex(36);
        buttonInt.setText("Int.");
        buttonInt.setVisible(false);
        buttonInt.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonInt_Click(sender, e);
            }
        });
        // buttonYield
        buttonYield.setFlatStyle(FlatStyle.Flat);
        buttonYield.setLocation(new Point(106, 240));
        buttonYield.setName("buttonYield");
        buttonYield.setSize(new FormSize(39, 22));
        buttonYield.setTabIndex(37);
        buttonYield.setText("Yield");
        buttonYield.setVisible(false);
        buttonYield.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonYield_Click(sender, e);
            }
        });
        // pictureContinuous
        pictureContinuous.setLocation(new Point(214, 247));
        pictureContinuous.setName("pictureContinuous");
        pictureContinuous.setSize(new FormSize(9, 9));
        pictureContinuous.setTabIndex(38);
        pictureContinuous.setTabStop(false);
        pictureContinuous.setVisible(false);
        // ilContinuous
        ilContinuous.setImageSize(new FormSize(9, 9));
        ilContinuous.setImageStream(((ImageListStreamer) (resources.GetObject("ilContinuous.ImageStream"))));
        ilContinuous.setTransparentColor(Color.white);
        // pictureEncounterType
        pictureEncounterType.setLocation(new Point(220, 2));
        pictureEncounterType.setName("pictureEncounterType");
        pictureEncounterType.setSize(new FormSize(12, 12));
        pictureEncounterType.setTabIndex(39);
        pictureEncounterType.setTabStop(false);
        // ilEncounterType
        ilEncounterType.setImageSize(new FormSize(12, 12));
        ilEncounterType.setImageStream(((ImageListStreamer) (resources.GetObject("ilEncounterType.ImageStream"))));
        ilEncounterType.setTransparentColor(Color.white);
        // pictureTribbles00
        pictureTribbles00.setBackColor(SystemColors.Control);
        pictureTribbles00.setLocation(new Point(16, 16));
        pictureTribbles00.setName("pictureTribbles00");
        pictureTribbles00.setSize(new FormSize(12, 12));
        pictureTribbles00.setTabIndex(41);
        pictureTribbles00.setTabStop(false);
        pictureTribbles00.setVisible(false);
        pictureTribbles00.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // ilTribbles
        ilTribbles.setImageSize(new FormSize(12, 12));
        ilTribbles.setImageStream(((ImageListStreamer) (resources.GetObject("ilTribbles.ImageStream"))));
        ilTribbles.setTransparentColor(Color.white);
        // pictureTribbles50
        pictureTribbles50.setBackColor(SystemColors.Control);
        pictureTribbles50.setLocation(new Point(16, 224));
        pictureTribbles50.setName("pictureTribbles50");
        pictureTribbles50.setSize(new FormSize(12, 12));
        pictureTribbles50.setTabIndex(42);
        pictureTribbles50.setTabStop(false);
        pictureTribbles50.setVisible(false);
        pictureTribbles50.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles10
        pictureTribbles10.setBackColor(SystemColors.Control);
        pictureTribbles10.setLocation(new Point(8, 56));
        pictureTribbles10.setName("pictureTribbles10");
        pictureTribbles10.setSize(new FormSize(12, 12));
        pictureTribbles10.setTabIndex(43);
        pictureTribbles10.setTabStop(false);
        pictureTribbles10.setVisible(false);
        pictureTribbles10.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles40
        pictureTribbles40.setBackColor(SystemColors.Control);
        pictureTribbles40.setLocation(new Point(8, 184));
        pictureTribbles40.setName("pictureTribbles40");
        pictureTribbles40.setSize(new FormSize(12, 12));
        pictureTribbles40.setTabIndex(44);
        pictureTribbles40.setTabStop(false);
        pictureTribbles40.setVisible(false);
        pictureTribbles40.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles20
        pictureTribbles20.setBackColor(SystemColors.Control);
        pictureTribbles20.setLocation(new Point(8, 96));
        pictureTribbles20.setName("pictureTribbles20");
        pictureTribbles20.setSize(new FormSize(12, 12));
        pictureTribbles20.setTabIndex(45);
        pictureTribbles20.setTabStop(false);
        pictureTribbles20.setVisible(false);
        pictureTribbles20.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles30
        pictureTribbles30.setBackColor(SystemColors.Control);
        pictureTribbles30.setLocation(new Point(16, 136));
        pictureTribbles30.setName("pictureTribbles30");
        pictureTribbles30.setSize(new FormSize(12, 12));
        pictureTribbles30.setTabIndex(46);
        pictureTribbles30.setTabStop(false);
        pictureTribbles30.setVisible(false);
        pictureTribbles30.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles04
        pictureTribbles04.setBackColor(SystemColors.Control);
        pictureTribbles04.setLocation(new Point(176, 8));
        pictureTribbles04.setName("pictureTribbles04");
        pictureTribbles04.setSize(new FormSize(12, 12));
        pictureTribbles04.setTabIndex(47);
        pictureTribbles04.setTabStop(false);
        pictureTribbles04.setVisible(false);
        pictureTribbles04.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles03
        pictureTribbles03.setBackColor(SystemColors.Control);
        pictureTribbles03.setLocation(new Point(128, 8));
        pictureTribbles03.setName("pictureTribbles03");
        pictureTribbles03.setSize(new FormSize(12, 12));
        pictureTribbles03.setTabIndex(48);
        pictureTribbles03.setTabStop(false);
        pictureTribbles03.setVisible(false);
        pictureTribbles03.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles02
        pictureTribbles02.setBackColor(SystemColors.Control);
        pictureTribbles02.setLocation(new Point(96, 16));
        pictureTribbles02.setName("pictureTribbles02");
        pictureTribbles02.setSize(new FormSize(12, 12));
        pictureTribbles02.setTabIndex(49);
        pictureTribbles02.setTabStop(false);
        pictureTribbles02.setVisible(false);
        pictureTribbles02.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles01
        pictureTribbles01.setBackColor(SystemColors.Control);
        pictureTribbles01.setLocation(new Point(56, 8));
        pictureTribbles01.setName("pictureTribbles01");
        pictureTribbles01.setSize(new FormSize(12, 12));
        pictureTribbles01.setTabIndex(50);
        pictureTribbles01.setTabStop(false);
        pictureTribbles01.setVisible(false);
        pictureTribbles01.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles05
        pictureTribbles05.setBackColor(SystemColors.Control);
        pictureTribbles05.setLocation(new Point(208, 16));
        pictureTribbles05.setName("pictureTribbles05");
        pictureTribbles05.setSize(new FormSize(12, 12));
        pictureTribbles05.setTabIndex(51);
        pictureTribbles05.setTabStop(false);
        pictureTribbles05.setVisible(false);
        pictureTribbles05.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles11
        pictureTribbles11.setBackColor(SystemColors.Control);
        pictureTribbles11.setLocation(new Point(32, 80));
        pictureTribbles11.setName("pictureTribbles11");
        pictureTribbles11.setSize(new FormSize(12, 12));
        pictureTribbles11.setTabIndex(52);
        pictureTribbles11.setTabStop(false);
        pictureTribbles11.setVisible(false);
        pictureTribbles11.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles12
        pictureTribbles12.setBackColor(SystemColors.Control);
        pictureTribbles12.setLocation(new Point(88, 56));
        pictureTribbles12.setName("pictureTribbles12");
        pictureTribbles12.setSize(new FormSize(12, 12));
        pictureTribbles12.setTabIndex(53);
        pictureTribbles12.setTabStop(false);
        pictureTribbles12.setVisible(false);
        pictureTribbles12.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles13
        pictureTribbles13.setBackColor(SystemColors.Control);
        pictureTribbles13.setLocation(new Point(128, 40));
        pictureTribbles13.setName("pictureTribbles13");
        pictureTribbles13.setSize(new FormSize(12, 12));
        pictureTribbles13.setTabIndex(54);
        pictureTribbles13.setTabStop(false);
        pictureTribbles13.setVisible(false);
        pictureTribbles13.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles14
        pictureTribbles14.setBackColor(SystemColors.Control);
        pictureTribbles14.setLocation(new Point(192, 72));
        pictureTribbles14.setName("pictureTribbles14");
        pictureTribbles14.setSize(new FormSize(12, 12));
        pictureTribbles14.setTabIndex(55);
        pictureTribbles14.setTabStop(false);
        pictureTribbles14.setVisible(false);
        pictureTribbles14.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles15
        pictureTribbles15.setBackColor(SystemColors.Control);
        pictureTribbles15.setLocation(new Point(216, 48));
        pictureTribbles15.setName("pictureTribbles15");
        pictureTribbles15.setSize(new FormSize(12, 12));
        pictureTribbles15.setTabIndex(56);
        pictureTribbles15.setTabStop(false);
        pictureTribbles15.setVisible(false);
        pictureTribbles15.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles21
        pictureTribbles21.setBackColor(SystemColors.Control);
        pictureTribbles21.setLocation(new Point(56, 96));
        pictureTribbles21.setName("pictureTribbles21");
        pictureTribbles21.setSize(new FormSize(12, 12));
        pictureTribbles21.setTabIndex(57);
        pictureTribbles21.setTabStop(false);
        pictureTribbles21.setVisible(false);
        pictureTribbles21.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles22
        pictureTribbles22.setBackColor(SystemColors.Control);
        pictureTribbles22.setLocation(new Point(96, 80));
        pictureTribbles22.setName("pictureTribbles22");
        pictureTribbles22.setSize(new FormSize(12, 12));
        pictureTribbles22.setTabIndex(58);
        pictureTribbles22.setTabStop(false);
        pictureTribbles22.setVisible(false);
        pictureTribbles22.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles23
        pictureTribbles23.setBackColor(SystemColors.Control);
        pictureTribbles23.setLocation(new Point(136, 88));
        pictureTribbles23.setName("pictureTribbles23");
        pictureTribbles23.setSize(new FormSize(12, 12));
        pictureTribbles23.setTabIndex(59);
        pictureTribbles23.setTabStop(false);
        pictureTribbles23.setVisible(false);
        pictureTribbles23.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles24
        pictureTribbles24.setBackColor(SystemColors.Control);
        pictureTribbles24.setLocation(new Point(176, 104));
        pictureTribbles24.setName("pictureTribbles24");
        pictureTribbles24.setSize(new FormSize(12, 12));
        pictureTribbles24.setTabIndex(60);
        pictureTribbles24.setTabStop(false);
        pictureTribbles24.setVisible(false);
        pictureTribbles24.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles25
        pictureTribbles25.setBackColor(SystemColors.Control);
        pictureTribbles25.setLocation(new Point(216, 96));
        pictureTribbles25.setName("pictureTribbles25");
        pictureTribbles25.setSize(new FormSize(12, 12));
        pictureTribbles25.setTabIndex(61);
        pictureTribbles25.setTabStop(false);
        pictureTribbles25.setVisible(false);
        pictureTribbles25.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles31
        pictureTribbles31.setBackColor(SystemColors.Control);
        pictureTribbles31.setLocation(new Point(56, 128));
        pictureTribbles31.setName("pictureTribbles31");
        pictureTribbles31.setSize(new FormSize(12, 12));
        pictureTribbles31.setTabIndex(62);
        pictureTribbles31.setTabStop(false);
        pictureTribbles31.setVisible(false);
        pictureTribbles31.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles32
        pictureTribbles32.setBackColor(SystemColors.Control);
        pictureTribbles32.setLocation(new Point(96, 120));
        pictureTribbles32.setName("pictureTribbles32");
        pictureTribbles32.setSize(new FormSize(12, 12));
        pictureTribbles32.setTabIndex(63);
        pictureTribbles32.setTabStop(false);
        pictureTribbles32.setVisible(false);
        pictureTribbles32.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles33
        pictureTribbles33.setBackColor(SystemColors.Control);
        pictureTribbles33.setLocation(new Point(128, 128));
        pictureTribbles33.setName("pictureTribbles33");
        pictureTribbles33.setSize(new FormSize(12, 12));
        pictureTribbles33.setTabIndex(64);
        pictureTribbles33.setTabStop(false);
        pictureTribbles33.setVisible(false);
        pictureTribbles33.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles34
        pictureTribbles34.setBackColor(SystemColors.Control);
        pictureTribbles34.setLocation(new Point(168, 144));
        pictureTribbles34.setName("pictureTribbles34");
        pictureTribbles34.setSize(new FormSize(12, 12));
        pictureTribbles34.setTabIndex(65);
        pictureTribbles34.setTabStop(false);
        pictureTribbles34.setVisible(false);
        pictureTribbles34.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles35
        pictureTribbles35.setBackColor(SystemColors.Control);
        pictureTribbles35.setLocation(new Point(208, 128));
        pictureTribbles35.setName("pictureTribbles35");
        pictureTribbles35.setSize(new FormSize(12, 12));
        pictureTribbles35.setTabIndex(66);
        pictureTribbles35.setTabStop(false);
        pictureTribbles35.setVisible(false);
        pictureTribbles35.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles41
        pictureTribbles41.setBackColor(SystemColors.Control);
        pictureTribbles41.setLocation(new Point(48, 176));
        pictureTribbles41.setName("pictureTribbles41");
        pictureTribbles41.setSize(new FormSize(12, 12));
        pictureTribbles41.setTabIndex(67);
        pictureTribbles41.setTabStop(false);
        pictureTribbles41.setVisible(false);
        pictureTribbles41.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles51
        pictureTribbles51.setBackColor(SystemColors.Control);
        pictureTribbles51.setLocation(new Point(64, 216));
        pictureTribbles51.setName("pictureTribbles51");
        pictureTribbles51.setSize(new FormSize(12, 12));
        pictureTribbles51.setTabIndex(68);
        pictureTribbles51.setTabStop(false);
        pictureTribbles51.setVisible(false);
        pictureTribbles51.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles42
        pictureTribbles42.setBackColor(SystemColors.Control);
        pictureTribbles42.setLocation(new Point(88, 168));
        pictureTribbles42.setName("pictureTribbles42");
        pictureTribbles42.setSize(new FormSize(12, 12));
        pictureTribbles42.setTabIndex(69);
        pictureTribbles42.setTabStop(false);
        pictureTribbles42.setVisible(false);
        pictureTribbles42.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles52
        pictureTribbles52.setBackColor(SystemColors.Control);
        pictureTribbles52.setLocation(new Point(96, 224));
        pictureTribbles52.setName("pictureTribbles52");
        pictureTribbles52.setSize(new FormSize(12, 12));
        pictureTribbles52.setTabIndex(70);
        pictureTribbles52.setTabStop(false);
        pictureTribbles52.setVisible(false);
        pictureTribbles52.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles43
        pictureTribbles43.setBackColor(SystemColors.Control);
        pictureTribbles43.setLocation(new Point(136, 176));
        pictureTribbles43.setName("pictureTribbles43");
        pictureTribbles43.setSize(new FormSize(12, 12));
        pictureTribbles43.setTabIndex(71);
        pictureTribbles43.setTabStop(false);
        pictureTribbles43.setVisible(false);
        pictureTribbles43.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles53
        pictureTribbles53.setBackColor(SystemColors.Control);
        pictureTribbles53.setLocation(new Point(144, 216));
        pictureTribbles53.setName("pictureTribbles53");
        pictureTribbles53.setSize(new FormSize(12, 12));
        pictureTribbles53.setTabIndex(72);
        pictureTribbles53.setTabStop(false);
        pictureTribbles53.setVisible(false);
        pictureTribbles53.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles44
        pictureTribbles44.setBackColor(SystemColors.Control);
        pictureTribbles44.setLocation(new Point(184, 184));
        pictureTribbles44.setName("pictureTribbles44");
        pictureTribbles44.setSize(new FormSize(12, 12));
        pictureTribbles44.setTabIndex(73);
        pictureTribbles44.setTabStop(false);
        pictureTribbles44.setVisible(false);
        pictureTribbles44.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles45
        pictureTribbles45.setBackColor(SystemColors.Control);
        pictureTribbles45.setLocation(new Point(216, 176));
        pictureTribbles45.setName("pictureTribbles45");
        pictureTribbles45.setSize(new FormSize(12, 12));
        pictureTribbles45.setTabIndex(74);
        pictureTribbles45.setTabStop(false);
        pictureTribbles45.setVisible(false);
        pictureTribbles45.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles54
        pictureTribbles54.setBackColor(SystemColors.Control);
        pictureTribbles54.setLocation(new Point(176, 224));
        pictureTribbles54.setName("pictureTribbles54");
        pictureTribbles54.setSize(new FormSize(12, 12));
        pictureTribbles54.setTabIndex(75);
        pictureTribbles54.setTabStop(false);
        pictureTribbles54.setVisible(false);
        pictureTribbles54.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // pictureTribbles55
        pictureTribbles55.setBackColor(SystemColors.Control);
        pictureTribbles55.setLocation(new Point(208, 216));
        pictureTribbles55.setName("pictureTribbles55");
        pictureTribbles55.setSize(new FormSize(12, 12));
        pictureTribbles55.setTabIndex(76);
        pictureTribbles55.setTabStop(false);
        pictureTribbles55.setVisible(false);
        pictureTribbles55.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                pictureTribbles_Click(sender, e);
            }
        });
        // timerTick
        timerTick.setInterval(1000);
        timerTick.Tick = new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                timerTick_Tick(sender, e);
            }
        };
        // FormEncounter
        setAutoScaleBaseSize(new FormSize(5, 13));
        setClientSize(new FormSize(234, 271));
        setControlBox(false);
        Controls.add(pictureTribbles55);
        Controls.add(pictureTribbles54);
        Controls.add(pictureTribbles45);
        Controls.add(pictureTribbles44);
        Controls.add(pictureTribbles53);
        Controls.add(pictureTribbles43);
        Controls.add(pictureTribbles52);
        Controls.add(pictureTribbles42);
        Controls.add(pictureTribbles51);
        Controls.add(pictureTribbles41);
        Controls.add(pictureTribbles35);
        Controls.add(pictureTribbles34);
        Controls.add(pictureTribbles33);
        Controls.add(pictureTribbles32);
        Controls.add(pictureTribbles31);
        Controls.add(pictureTribbles25);
        Controls.add(pictureTribbles24);
        Controls.add(pictureTribbles23);
        Controls.add(pictureTribbles22);
        Controls.add(pictureTribbles21);
        Controls.add(pictureTribbles15);
        Controls.add(pictureTribbles14);
        Controls.add(pictureTribbles13);
        Controls.add(pictureTribbles12);
        Controls.add(pictureTribbles11);
        Controls.add(pictureTribbles05);
        Controls.add(pictureTribbles01);
        Controls.add(pictureTribbles02);
        Controls.add(pictureTribbles03);
        Controls.add(pictureTribbles04);
        Controls.add(pictureTribbles30);
        Controls.add(pictureTribbles20);
        Controls.add(pictureTribbles40);
        Controls.add(pictureTribbles10);
        Controls.add(pictureTribbles50);
        Controls.add(pictureTribbles00);
        Controls.add(pictureEncounterType);
        Controls.add(pictureContinuous);
        Controls.add(buttonYield);
        Controls.add(buttonInt);
        Controls.add(buttonMeet);
        Controls.add(buttonPlunder);
        Controls.add(buttonTrade);
        Controls.add(buttonIgnore);
        Controls.add(buttonSurrender);
        Controls.add(buttonBribe);
        Controls.add(buttonSubmit);
        Controls.add(buttonFlee);
        Controls.add(labelOpponentShields);
        Controls.add(labelOpponentHull);
        Controls.add(labelYouShields);
        Controls.add(labelYouHull);
        Controls.add(labelYouShip);
        Controls.add(labelOpponentShip);
        Controls.add(labelYouLabel);
        Controls.add(labelOpponentLabel);
        Controls.add(labelAction);
        Controls.add(pictureShipOpponent);
        Controls.add(pictureShipYou);
        Controls.add(labelEncounter);
        Controls.add(buttonDrink);
        Controls.add(buttonBoard);
        Controls.add(buttonAttack);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormEncounter");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Encounter");
        ResumeLayout(false);
        // Set up the Game encounter variables.
        game.EncounterBegin();
        // Enable the control box (the X button) if cheats are enabled.
        if (game.getEasyEncounters()) {
            setControlBox(true);
        }
        buttons = new Button[]{
                buttonAttack, buttonBoard, buttonBribe, buttonDrink, buttonFlee, buttonIgnore, buttonInt, buttonMeet, buttonPlunder, buttonSubmit, buttonSurrender, buttonTrade, buttonYield
        };
        UpdateShipInfo();
        UpdateTribbles();
        UpdateButtons();
        if (game.EncounterImageIndex() >= 0) {
            pictureEncounterType.setImage(ilEncounterType.getImages()[game.EncounterImageIndex()]);
        } else {
            pictureEncounterType.setVisible(false);
        }
        labelEncounter.setText(game.EncounterTextInitial());
        labelAction.setText(game.EncounterActionInitial());
    }


    private void DisableAuto() {
        timerTick.Stop();
        game.setEncounterContinueFleeing(false);
        game.setEncounterContinueAttacking(false);
        buttonInt.setVisible(false);
        pictureContinuous.setVisible(false);
    }

    private void ExecuteAction() {
        _result = game.EncounterExecuteAction(this);
        if (_result == EncounterResult.Continue) {
            UpdateButtons();
            UpdateShipStats();
            labelEncounter.setText(game.EncounterText());
            labelAction.setText(game.EncounterAction());
            if (game.getEncounterContinueFleeing() || game.getEncounterContinueAttacking()) {
                timerTick.Start();
            }
        } else {
            Close();
        }
    }

    private void Exit(EncounterResult result) {
        _result = result;
        Close();
    }

    private void UpdateButtons() {
        boolean[] visible = new boolean[buttons.length];
        int YIELD = 12;
        int TRADE = 11;
        int SURRENDER = 10;
        int SUBMIT = 9;
        int PLUNDER = 8;
        int MEET = 7;
        int IGNORE = 5;
        int FLEE = 4;
        int DRINK = 3;
        int BRIBE = 2;
        int BOARD = 1;
        int ATTACK = 0;
        switch (game.getEncounterType()) {
            case BottleGood:
            case BottleOld:
                visible[DRINK] = true;
                visible[IGNORE] = true;
                buttonIgnore.setLeft(buttonDrink.getLeft() + buttonDrink.getWidth() + 8);
                break;
            case CaptainAhab:
            case CaptainConrad:
            case CaptainHuie:
                visible[ATTACK] = true;
                visible[IGNORE] = true;
                visible[MEET] = true;
                break;
            case DragonflyAttack:
            case FamousCaptainAttack:
            case ScorpionAttack:
            case SpaceMonsterAttack:
            case TraderAttack:
                visible[ATTACK] = true;
                visible[FLEE] = true;
                buttonInt.setLeft(buttonFlee.getLeft() + buttonFlee.getWidth() + 8);
                break;
            case DragonflyIgnore:
            case FamousCaptDisabled:
            case PoliceDisabled:
            case PoliceFlee:
            case PoliceIgnore:
            case PirateFlee:
            case PirateIgnore:
            case ScarabIgnore:
            case ScorpionIgnore:
            case SpaceMonsterIgnore:
            case TraderFlee:
            case TraderIgnore:
                visible[ATTACK] = true;
                visible[IGNORE] = true;
                break;
            case MarieCeleste:
                visible[BOARD] = true;
                visible[IGNORE] = true;
                buttonIgnore.setLeft(buttonBoard.getLeft() + buttonBoard.getWidth() + 8);
                break;
            case MarieCelestePolice:
                visible[ATTACK] = true;
                visible[FLEE] = true;
                visible[YIELD] = true;
                visible[BRIBE] = true;
                buttonBribe.setLeft(buttonYield.getLeft() + buttonYield.getWidth() + 8);
                break;
            case PirateAttack:
            case PoliceAttack:
            case PoliceSurrender:
            case ScarabAttack:
                visible[ATTACK] = true;
                visible[FLEE] = true;
                visible[SURRENDER] = true;
                buttonInt.setLeft(buttonSurrender.getLeft() + buttonSurrender.getWidth() + 8);
                break;
            case PirateDisabled:
            case PirateSurrender:
            case TraderDisabled:
            case TraderSurrender:
                visible[ATTACK] = true;
                visible[PLUNDER] = true;
                break;
            case PoliceInspect:
                visible[ATTACK] = true;
                visible[FLEE] = true;
                visible[SUBMIT] = true;
                visible[BRIBE] = true;
                break;
            case TraderBuy:
            case TraderSell:
                visible[ATTACK] = true;
                visible[IGNORE] = true;
                visible[TRADE] = true;
                break;
        }
        int INT = 6;
        if (game.getEncounterContinueAttacking() || game.getEncounterContinueFleeing()) {
            visible[INT] = true;
        }
        for (int i = 0; i < visible.length; i++) {
            if (visible[i] != buttons[i].getVisible()) {
                buttons[i].setVisible(visible[i]);
                if (i == INT) {
                    pictureContinuous.setVisible(visible[i]);
                }
            }
        }
        if (pictureContinuous.getVisible()) {
            pictureContinuous.setImage(ilContinuous.getImages()[contImg = (contImg + 1) % 2]);
        }
    }

    private void UpdateShipInfo() {
        labelYouShip.setText(commandership.Name());
        labelOpponentShip.setText(opponent.Name());
        UpdateShipStats();
    }

    private void UpdateShipStats() {
        labelYouHull.setText(commandership.HullText());
        labelYouShields.setText(commandership.ShieldText());
        labelOpponentHull.setText(opponent.HullText());
        labelOpponentShields.setText(opponent.ShieldText());
        pictureShipYou.Refresh();
        pictureShipOpponent.Refresh();
    }

    private void UpdateTribbles() {
        PictureBox[] tribbles = new PictureBox[]{
                pictureTribbles00, pictureTribbles01, pictureTribbles02, pictureTribbles03, pictureTribbles04, pictureTribbles05,
                pictureTribbles10, pictureTribbles11, pictureTribbles12, pictureTribbles13, pictureTribbles14, pictureTribbles15,
                pictureTribbles20, pictureTribbles21, pictureTribbles22, pictureTribbles23, pictureTribbles24, pictureTribbles25,
                pictureTribbles30, pictureTribbles31, pictureTribbles32, pictureTribbles33, pictureTribbles34, pictureTribbles35,
                pictureTribbles40, pictureTribbles41, pictureTribbles42, pictureTribbles43, pictureTribbles44, pictureTribbles45,
                pictureTribbles50, pictureTribbles51, pictureTribbles52, pictureTribbles53, pictureTribbles54, pictureTribbles55
        };
        int toShow = Math.min(tribbles.length, (int) Math.sqrt(commandership.getTribbles() / Math.ceil(Constants.MaxTribbles / Math.pow(tribbles.length + 1, 2))));
        for (int i = 0; i < toShow; i++) {
            int index = Functions.GetRandom(tribbles.length);
            while (tribbles[index].getVisible()) {
                index = (index + 1) % tribbles.length;
            }
            tribbles[index].setImage(ilTribbles.getImages()[Functions.GetRandom(ilTribbles.getImages().length)]);
            tribbles[index].setVisible(true);
        }
    }

    private void buttonAttack_Click(Object sender, EventData e) {
        DisableAuto();
        if (game.EncounterVerifyAttack(this)) {
            ExecuteAction();
        }
    }

    private void buttonBoard_Click(Object sender, EventData e) {
        if (game.EncounterVerifyBoard(this)) {
            Exit(EncounterResult.Normal);
        }
    }

    private void buttonBribe_Click(Object sender, EventData e) {
        if (game.EncounterVerifyBribe(this)) {
            Exit(EncounterResult.Normal);
        }
    }

    private void buttonDrink_Click(Object sender, EventData e) {
        game.EncounterDrink(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonFlee_Click(Object sender, EventData e) {
        DisableAuto();
        if (game.EncounterVerifyFlee(this)) {
            ExecuteAction();
        }
    }

    private void buttonIgnore_Click(Object sender, EventData e) {
        DisableAuto();
        Exit(EncounterResult.Normal);
    }

    private void buttonInt_Click(Object sender, EventData e) {
        DisableAuto();
    }

    private void buttonMeet_Click(Object sender, EventData e) {
        game.EncounterMeet(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonPlunder_Click(Object sender, EventData e) {
        DisableAuto();
        game.EncounterPlunder(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonSubmit_Click(Object sender, EventData e) {
        if (game.EncounterVerifySubmit(this)) {
            Exit(commandership.IllegalSpecialCargo() ? EncounterResult.Arrested : EncounterResult.Normal);
        }
    }

    private void buttonSurrender_Click(Object sender, EventData e) {
        DisableAuto();
        _result = game.EncounterVerifySurrender(this);
        if (_result != EncounterResult.Continue) {
            Close();
        }
    }

    private void buttonTrade_Click(Object sender, EventData e) {
        game.EncounterTrade(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonYield_Click(Object sender, EventData e) {
        _result = game.EncounterVerifyYield(this);
        if (_result != EncounterResult.Continue) {
            Close();
        }
    }

    private void pictureShipOpponent_Paint(Object sender, PaintEventData e) {
        Functions.PaintShipImage(opponent, e.Graphics, pictureShipOpponent.getBackColor());
    }

    private void pictureShipYou_Paint(Object sender, PaintEventData e) {
        Functions.PaintShipImage(commandership, e.Graphics, pictureShipYou.getBackColor());
    }

    private void pictureTribbles_Click(Object sender, EventData e) {
        FormAlert.Alert(AlertType.TribblesSqueek, this);
    }

    private void timerTick_Tick(Object sender, EventData e) {
        DisableAuto();
        ExecuteAction();
    }

    public EncounterResult Result() {
        return _result;
    }
}
