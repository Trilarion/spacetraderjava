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
    private final Game game = Game.CurrentGame();
    private final Commander cmdr = game.Commander();
    private final Ship cmdrship = cmdr.getShip();
    private final Ship opponent = game.getOpponent();
    private Button buttonFlee;
    private Button buttonBribe;
    private Button buttonSurrender;
    private Button buttonIgnore;
    private Button buttonBoard;
    private Button buttonDrink;
    private Button buttonInt;
    private Button buttonYield;
    private Button[] buttons;
    private ImageList ilContinuous;
    private ImageList ilTribbles;
    private Label lblEncounter;
    private Label lblOpponentShip;
    private Label lblYouShip;
    private Label lblYouHull;
    private Label lblYouShields;
    private Label lblOpponentShields;
    private Label lblOpponentHull;
    private Label lblAction;
    private PictureBox picShipYou;
    private PictureBox picShipOpponent;
    private PictureBox picContinuous;
    private PictureBox picTribbles00;
    private PictureBox picTribbles50;
    private PictureBox picTribbles10;
    private PictureBox picTribbles40;
    private PictureBox picTribbles20;
    private PictureBox picTribbles30;
    private PictureBox picTribbles04;
    private PictureBox picTribbles03;
    private PictureBox picTribbles02;
    private PictureBox picTribbles01;
    private PictureBox picTribbles05;
    private PictureBox picTribbles11;
    private PictureBox picTribbles12;
    private PictureBox picTribbles13;
    private PictureBox picTribbles14;
    private PictureBox picTribbles15;
    private PictureBox picTribbles21;
    private PictureBox picTribbles22;
    private PictureBox picTribbles23;
    private PictureBox picTribbles24;
    private PictureBox picTribbles25;
    private PictureBox picTribbles31;
    private PictureBox picTribbles32;
    private PictureBox picTribbles33;
    private PictureBox picTribbles34;
    private PictureBox picTribbles35;
    private PictureBox picTribbles41;
    private PictureBox picTribbles51;
    private PictureBox picTribbles42;
    private PictureBox picTribbles52;
    private PictureBox picTribbles43;
    private PictureBox picTribbles53;
    private PictureBox picTribbles44;
    private PictureBox picTribbles45;
    private PictureBox picTribbles54;
    private PictureBox picTribbles55;
    private Timer tmrTick;
    private int contImg = 1;
    private EncounterResult _result = EncounterResult.Continue;

    public FormEncounter() {
        IContainer components = new Container();
        ResourceManager resources = new ResourceManager(FormEncounter.class);
        lblEncounter = new Label();
        picShipYou = new PictureBox();
        picShipOpponent = new PictureBox();
        lblAction = new Label();
        Label lblOpponentLabel = new Label();
        Label lblYouLabel = new Label();
        lblOpponentShip = new Label();
        lblYouShip = new Label();
        lblYouHull = new Label();
        lblYouShields = new Label();
        lblOpponentShields = new Label();
        lblOpponentHull = new Label();
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
        picContinuous = new PictureBox();
        ilContinuous = new ImageList(components);
        PictureBox picEncounterType = new PictureBox();
        ImageList ilEncounterType = new ImageList(components);
        picTribbles00 = new PictureBox();
        ilTribbles = new ImageList(components);
        picTribbles50 = new PictureBox();
        picTribbles10 = new PictureBox();
        picTribbles40 = new PictureBox();
        picTribbles20 = new PictureBox();
        picTribbles30 = new PictureBox();
        picTribbles04 = new PictureBox();
        picTribbles03 = new PictureBox();
        picTribbles02 = new PictureBox();
        picTribbles01 = new PictureBox();
        picTribbles05 = new PictureBox();
        picTribbles11 = new PictureBox();
        picTribbles12 = new PictureBox();
        picTribbles13 = new PictureBox();
        picTribbles14 = new PictureBox();
        picTribbles15 = new PictureBox();
        picTribbles21 = new PictureBox();
        picTribbles22 = new PictureBox();
        picTribbles23 = new PictureBox();
        picTribbles24 = new PictureBox();
        picTribbles25 = new PictureBox();
        picTribbles31 = new PictureBox();
        picTribbles32 = new PictureBox();
        picTribbles33 = new PictureBox();
        picTribbles34 = new PictureBox();
        picTribbles35 = new PictureBox();
        picTribbles41 = new PictureBox();
        picTribbles51 = new PictureBox();
        picTribbles42 = new PictureBox();
        picTribbles52 = new PictureBox();
        picTribbles43 = new PictureBox();
        picTribbles53 = new PictureBox();
        picTribbles44 = new PictureBox();
        picTribbles45 = new PictureBox();
        picTribbles54 = new PictureBox();
        picTribbles55 = new PictureBox();
        tmrTick = new Timer(components);
        SuspendLayout();
        // lblEncounter
        lblEncounter.setLocation(new Point(8, 152));
        lblEncounter.setName("lblEncounter");
        lblEncounter.setSize(new FormSize(232, 26));
        lblEncounter.setTabIndex(0);
        lblEncounter.setText("At 20 clicks from Tarchannen, you encounter the famous Captain Ahab.");
        // picShipYou
        picShipYou.setBackColor(Color.white);
        picShipYou.setBorderStyle(BorderStyle.FixedSingle);
        picShipYou.setLocation(new Point(26, 24));
        picShipYou.setName("picShipYou");
        picShipYou.setSize(new FormSize(70, 58));
        picShipYou.setTabIndex(13);
        picShipYou.setTabStop(false);
        picShipYou.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventArgs e) {
                picShipYou_Paint(sender, e);
            }
        });
        // picShipOpponent
        picShipOpponent.setBackColor(Color.white);
        picShipOpponent.setBorderStyle(BorderStyle.FixedSingle);
        picShipOpponent.setLocation(new Point(138, 24));
        picShipOpponent.setName("picShipOpponent");
        picShipOpponent.setSize(new FormSize(70, 58));
        picShipOpponent.setTabIndex(14);
        picShipOpponent.setTabStop(false);
        picShipOpponent.setPaint(new EventHandler<>() {
            @Override
            public void handle(Object sender, PaintEventArgs e) {
                picShipOpponent_Paint(sender, e);
            }
        });
        // lblAction
        lblAction.setLocation(new Point(8, 192));
        lblAction.setName("lblAction");
        lblAction.setSize(new FormSize(232, 39));
        lblAction.setTabIndex(15);
        lblAction.setText("\"We know you removed illegal goods from the Marie Celeste. You must give them up at once!\"");
        // lblOpponentLabel
        lblOpponentLabel.setAutoSize(true);
        lblOpponentLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblOpponentLabel.setLocation(new Point(141, 8));
        lblOpponentLabel.setName("lblOpponentLabel");
        lblOpponentLabel.setSize(new FormSize(59, 16));
        lblOpponentLabel.setTabIndex(16);
        lblOpponentLabel.setText("Opponent:");
        // lblYouLabel
        lblYouLabel.setAutoSize(true);
        lblYouLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblYouLabel.setLocation(new Point(45, 8));
        lblYouLabel.setName("lblYouLabel");
        lblYouLabel.setSize(new FormSize(28, 16));
        lblYouLabel.setTabIndex(17);
        lblYouLabel.setText("You:");
        // lblOpponentShip
        lblOpponentShip.setLocation(new Point(138, 88));
        lblOpponentShip.setName("lblOpponentShip");
        lblOpponentShip.setSize(new FormSize(80, 13));
        lblOpponentShip.setTabIndex(18);
        lblOpponentShip.setText("Space Monster");
        // lblYouShip
        lblYouShip.setLocation(new Point(26, 88));
        lblYouShip.setName("lblYouShip");
        lblYouShip.setSize(new FormSize(100, 13));
        lblYouShip.setTabIndex(19);
        lblYouShip.setText("Grasshopper");
        // lblYouHull
        lblYouHull.setLocation(new Point(26, 104));
        lblYouHull.setName("lblYouHull");
        lblYouHull.setSize(new FormSize(68, 13));
        lblYouHull.setTabIndex(20);
        lblYouHull.setText("Hull at 100%");
        // lblYouShields
        lblYouShields.setLocation(new Point(26, 120));
        lblYouShields.setName("lblYouShields");
        lblYouShields.setSize(new FormSize(86, 13));
        lblYouShields.setTabIndex(21);
        lblYouShields.setText("Shields at 100%");
        // lblOpponentShields
        lblOpponentShields.setLocation(new Point(138, 120));
        lblOpponentShields.setName("lblOpponentShields");
        lblOpponentShields.setSize(new FormSize(86, 13));
        lblOpponentShields.setTabIndex(23);
        lblOpponentShields.setText("Shields at 100%");
        // lblOpponentHull
        lblOpponentHull.setLocation(new Point(138, 104));
        lblOpponentHull.setName("lblOpponentHull");
        lblOpponentHull.setSize(new FormSize(68, 13));
        lblOpponentHull.setTabIndex(22);
        lblOpponentHull.setText("Hull at 100%");
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
                buttonYield_Click(sender, e);
            }
        });
        // picContinuous
        picContinuous.setLocation(new Point(214, 247));
        picContinuous.setName("picContinuous");
        picContinuous.setSize(new FormSize(9, 9));
        picContinuous.setTabIndex(38);
        picContinuous.setTabStop(false);
        picContinuous.setVisible(false);
        // ilContinuous
        ilContinuous.setImageSize(new FormSize(9, 9));
        ilContinuous.setImageStream(((ImageListStreamer) (resources.GetObject("ilContinuous.ImageStream"))));
        ilContinuous.setTransparentColor(Color.white);
        // picEncounterType
        picEncounterType.setLocation(new Point(220, 2));
        picEncounterType.setName("picEncounterType");
        picEncounterType.setSize(new FormSize(12, 12));
        picEncounterType.setTabIndex(39);
        picEncounterType.setTabStop(false);
        // ilEncounterType
        ilEncounterType.setImageSize(new FormSize(12, 12));
        ilEncounterType.setImageStream(((ImageListStreamer) (resources.GetObject("ilEncounterType.ImageStream"))));
        ilEncounterType.setTransparentColor(Color.white);
        // picTribbles00
        picTribbles00.setBackColor(SystemColors.Control);
        picTribbles00.setLocation(new Point(16, 16));
        picTribbles00.setName("picTribbles00");
        picTribbles00.setSize(new FormSize(12, 12));
        picTribbles00.setTabIndex(41);
        picTribbles00.setTabStop(false);
        picTribbles00.setVisible(false);
        picTribbles00.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // ilTribbles
        ilTribbles.setImageSize(new FormSize(12, 12));
        ilTribbles.setImageStream(((ImageListStreamer) (resources.GetObject("ilTribbles.ImageStream"))));
        ilTribbles.setTransparentColor(Color.white);
        // picTribbles50
        picTribbles50.setBackColor(SystemColors.Control);
        picTribbles50.setLocation(new Point(16, 224));
        picTribbles50.setName("picTribbles50");
        picTribbles50.setSize(new FormSize(12, 12));
        picTribbles50.setTabIndex(42);
        picTribbles50.setTabStop(false);
        picTribbles50.setVisible(false);
        picTribbles50.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles10
        picTribbles10.setBackColor(SystemColors.Control);
        picTribbles10.setLocation(new Point(8, 56));
        picTribbles10.setName("picTribbles10");
        picTribbles10.setSize(new FormSize(12, 12));
        picTribbles10.setTabIndex(43);
        picTribbles10.setTabStop(false);
        picTribbles10.setVisible(false);
        picTribbles10.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles40
        picTribbles40.setBackColor(SystemColors.Control);
        picTribbles40.setLocation(new Point(8, 184));
        picTribbles40.setName("picTribbles40");
        picTribbles40.setSize(new FormSize(12, 12));
        picTribbles40.setTabIndex(44);
        picTribbles40.setTabStop(false);
        picTribbles40.setVisible(false);
        picTribbles40.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles20
        picTribbles20.setBackColor(SystemColors.Control);
        picTribbles20.setLocation(new Point(8, 96));
        picTribbles20.setName("picTribbles20");
        picTribbles20.setSize(new FormSize(12, 12));
        picTribbles20.setTabIndex(45);
        picTribbles20.setTabStop(false);
        picTribbles20.setVisible(false);
        picTribbles20.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles30
        picTribbles30.setBackColor(SystemColors.Control);
        picTribbles30.setLocation(new Point(16, 136));
        picTribbles30.setName("picTribbles30");
        picTribbles30.setSize(new FormSize(12, 12));
        picTribbles30.setTabIndex(46);
        picTribbles30.setTabStop(false);
        picTribbles30.setVisible(false);
        picTribbles30.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles04
        picTribbles04.setBackColor(SystemColors.Control);
        picTribbles04.setLocation(new Point(176, 8));
        picTribbles04.setName("picTribbles04");
        picTribbles04.setSize(new FormSize(12, 12));
        picTribbles04.setTabIndex(47);
        picTribbles04.setTabStop(false);
        picTribbles04.setVisible(false);
        picTribbles04.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles03
        picTribbles03.setBackColor(SystemColors.Control);
        picTribbles03.setLocation(new Point(128, 8));
        picTribbles03.setName("picTribbles03");
        picTribbles03.setSize(new FormSize(12, 12));
        picTribbles03.setTabIndex(48);
        picTribbles03.setTabStop(false);
        picTribbles03.setVisible(false);
        picTribbles03.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles02
        picTribbles02.setBackColor(SystemColors.Control);
        picTribbles02.setLocation(new Point(96, 16));
        picTribbles02.setName("picTribbles02");
        picTribbles02.setSize(new FormSize(12, 12));
        picTribbles02.setTabIndex(49);
        picTribbles02.setTabStop(false);
        picTribbles02.setVisible(false);
        picTribbles02.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles01
        picTribbles01.setBackColor(SystemColors.Control);
        picTribbles01.setLocation(new Point(56, 8));
        picTribbles01.setName("picTribbles01");
        picTribbles01.setSize(new FormSize(12, 12));
        picTribbles01.setTabIndex(50);
        picTribbles01.setTabStop(false);
        picTribbles01.setVisible(false);
        picTribbles01.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles05
        picTribbles05.setBackColor(SystemColors.Control);
        picTribbles05.setLocation(new Point(208, 16));
        picTribbles05.setName("picTribbles05");
        picTribbles05.setSize(new FormSize(12, 12));
        picTribbles05.setTabIndex(51);
        picTribbles05.setTabStop(false);
        picTribbles05.setVisible(false);
        picTribbles05.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles11
        picTribbles11.setBackColor(SystemColors.Control);
        picTribbles11.setLocation(new Point(32, 80));
        picTribbles11.setName("picTribbles11");
        picTribbles11.setSize(new FormSize(12, 12));
        picTribbles11.setTabIndex(52);
        picTribbles11.setTabStop(false);
        picTribbles11.setVisible(false);
        picTribbles11.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles12
        picTribbles12.setBackColor(SystemColors.Control);
        picTribbles12.setLocation(new Point(88, 56));
        picTribbles12.setName("picTribbles12");
        picTribbles12.setSize(new FormSize(12, 12));
        picTribbles12.setTabIndex(53);
        picTribbles12.setTabStop(false);
        picTribbles12.setVisible(false);
        picTribbles12.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles13
        picTribbles13.setBackColor(SystemColors.Control);
        picTribbles13.setLocation(new Point(128, 40));
        picTribbles13.setName("picTribbles13");
        picTribbles13.setSize(new FormSize(12, 12));
        picTribbles13.setTabIndex(54);
        picTribbles13.setTabStop(false);
        picTribbles13.setVisible(false);
        picTribbles13.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles14
        picTribbles14.setBackColor(SystemColors.Control);
        picTribbles14.setLocation(new Point(192, 72));
        picTribbles14.setName("picTribbles14");
        picTribbles14.setSize(new FormSize(12, 12));
        picTribbles14.setTabIndex(55);
        picTribbles14.setTabStop(false);
        picTribbles14.setVisible(false);
        picTribbles14.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles15
        picTribbles15.setBackColor(SystemColors.Control);
        picTribbles15.setLocation(new Point(216, 48));
        picTribbles15.setName("picTribbles15");
        picTribbles15.setSize(new FormSize(12, 12));
        picTribbles15.setTabIndex(56);
        picTribbles15.setTabStop(false);
        picTribbles15.setVisible(false);
        picTribbles15.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles21
        picTribbles21.setBackColor(SystemColors.Control);
        picTribbles21.setLocation(new Point(56, 96));
        picTribbles21.setName("picTribbles21");
        picTribbles21.setSize(new FormSize(12, 12));
        picTribbles21.setTabIndex(57);
        picTribbles21.setTabStop(false);
        picTribbles21.setVisible(false);
        picTribbles21.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles22
        picTribbles22.setBackColor(SystemColors.Control);
        picTribbles22.setLocation(new Point(96, 80));
        picTribbles22.setName("picTribbles22");
        picTribbles22.setSize(new FormSize(12, 12));
        picTribbles22.setTabIndex(58);
        picTribbles22.setTabStop(false);
        picTribbles22.setVisible(false);
        picTribbles22.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles23
        picTribbles23.setBackColor(SystemColors.Control);
        picTribbles23.setLocation(new Point(136, 88));
        picTribbles23.setName("picTribbles23");
        picTribbles23.setSize(new FormSize(12, 12));
        picTribbles23.setTabIndex(59);
        picTribbles23.setTabStop(false);
        picTribbles23.setVisible(false);
        picTribbles23.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles24
        picTribbles24.setBackColor(SystemColors.Control);
        picTribbles24.setLocation(new Point(176, 104));
        picTribbles24.setName("picTribbles24");
        picTribbles24.setSize(new FormSize(12, 12));
        picTribbles24.setTabIndex(60);
        picTribbles24.setTabStop(false);
        picTribbles24.setVisible(false);
        picTribbles24.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles25
        picTribbles25.setBackColor(SystemColors.Control);
        picTribbles25.setLocation(new Point(216, 96));
        picTribbles25.setName("picTribbles25");
        picTribbles25.setSize(new FormSize(12, 12));
        picTribbles25.setTabIndex(61);
        picTribbles25.setTabStop(false);
        picTribbles25.setVisible(false);
        picTribbles25.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles31
        picTribbles31.setBackColor(SystemColors.Control);
        picTribbles31.setLocation(new Point(56, 128));
        picTribbles31.setName("picTribbles31");
        picTribbles31.setSize(new FormSize(12, 12));
        picTribbles31.setTabIndex(62);
        picTribbles31.setTabStop(false);
        picTribbles31.setVisible(false);
        picTribbles31.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles32
        picTribbles32.setBackColor(SystemColors.Control);
        picTribbles32.setLocation(new Point(96, 120));
        picTribbles32.setName("picTribbles32");
        picTribbles32.setSize(new FormSize(12, 12));
        picTribbles32.setTabIndex(63);
        picTribbles32.setTabStop(false);
        picTribbles32.setVisible(false);
        picTribbles32.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles33
        picTribbles33.setBackColor(SystemColors.Control);
        picTribbles33.setLocation(new Point(128, 128));
        picTribbles33.setName("picTribbles33");
        picTribbles33.setSize(new FormSize(12, 12));
        picTribbles33.setTabIndex(64);
        picTribbles33.setTabStop(false);
        picTribbles33.setVisible(false);
        picTribbles33.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles34
        picTribbles34.setBackColor(SystemColors.Control);
        picTribbles34.setLocation(new Point(168, 144));
        picTribbles34.setName("picTribbles34");
        picTribbles34.setSize(new FormSize(12, 12));
        picTribbles34.setTabIndex(65);
        picTribbles34.setTabStop(false);
        picTribbles34.setVisible(false);
        picTribbles34.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles35
        picTribbles35.setBackColor(SystemColors.Control);
        picTribbles35.setLocation(new Point(208, 128));
        picTribbles35.setName("picTribbles35");
        picTribbles35.setSize(new FormSize(12, 12));
        picTribbles35.setTabIndex(66);
        picTribbles35.setTabStop(false);
        picTribbles35.setVisible(false);
        picTribbles35.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles41
        picTribbles41.setBackColor(SystemColors.Control);
        picTribbles41.setLocation(new Point(48, 176));
        picTribbles41.setName("picTribbles41");
        picTribbles41.setSize(new FormSize(12, 12));
        picTribbles41.setTabIndex(67);
        picTribbles41.setTabStop(false);
        picTribbles41.setVisible(false);
        picTribbles41.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles51
        picTribbles51.setBackColor(SystemColors.Control);
        picTribbles51.setLocation(new Point(64, 216));
        picTribbles51.setName("picTribbles51");
        picTribbles51.setSize(new FormSize(12, 12));
        picTribbles51.setTabIndex(68);
        picTribbles51.setTabStop(false);
        picTribbles51.setVisible(false);
        picTribbles51.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles42
        picTribbles42.setBackColor(SystemColors.Control);
        picTribbles42.setLocation(new Point(88, 168));
        picTribbles42.setName("picTribbles42");
        picTribbles42.setSize(new FormSize(12, 12));
        picTribbles42.setTabIndex(69);
        picTribbles42.setTabStop(false);
        picTribbles42.setVisible(false);
        picTribbles42.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles52
        picTribbles52.setBackColor(SystemColors.Control);
        picTribbles52.setLocation(new Point(96, 224));
        picTribbles52.setName("picTribbles52");
        picTribbles52.setSize(new FormSize(12, 12));
        picTribbles52.setTabIndex(70);
        picTribbles52.setTabStop(false);
        picTribbles52.setVisible(false);
        picTribbles52.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles43
        picTribbles43.setBackColor(SystemColors.Control);
        picTribbles43.setLocation(new Point(136, 176));
        picTribbles43.setName("picTribbles43");
        picTribbles43.setSize(new FormSize(12, 12));
        picTribbles43.setTabIndex(71);
        picTribbles43.setTabStop(false);
        picTribbles43.setVisible(false);
        picTribbles43.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles53
        picTribbles53.setBackColor(SystemColors.Control);
        picTribbles53.setLocation(new Point(144, 216));
        picTribbles53.setName("picTribbles53");
        picTribbles53.setSize(new FormSize(12, 12));
        picTribbles53.setTabIndex(72);
        picTribbles53.setTabStop(false);
        picTribbles53.setVisible(false);
        picTribbles53.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles44
        picTribbles44.setBackColor(SystemColors.Control);
        picTribbles44.setLocation(new Point(184, 184));
        picTribbles44.setName("picTribbles44");
        picTribbles44.setSize(new FormSize(12, 12));
        picTribbles44.setTabIndex(73);
        picTribbles44.setTabStop(false);
        picTribbles44.setVisible(false);
        picTribbles44.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles45
        picTribbles45.setBackColor(SystemColors.Control);
        picTribbles45.setLocation(new Point(216, 176));
        picTribbles45.setName("picTribbles45");
        picTribbles45.setSize(new FormSize(12, 12));
        picTribbles45.setTabIndex(74);
        picTribbles45.setTabStop(false);
        picTribbles45.setVisible(false);
        picTribbles45.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles54
        picTribbles54.setBackColor(SystemColors.Control);
        picTribbles54.setLocation(new Point(176, 224));
        picTribbles54.setName("picTribbles54");
        picTribbles54.setSize(new FormSize(12, 12));
        picTribbles54.setTabIndex(75);
        picTribbles54.setTabStop(false);
        picTribbles54.setVisible(false);
        picTribbles54.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // picTribbles55
        picTribbles55.setBackColor(SystemColors.Control);
        picTribbles55.setLocation(new Point(208, 216));
        picTribbles55.setName("picTribbles55");
        picTribbles55.setSize(new FormSize(12, 12));
        picTribbles55.setTabIndex(76);
        picTribbles55.setTabStop(false);
        picTribbles55.setVisible(false);
        picTribbles55.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                picTribbles_Click(sender, e);
            }
        });
        // tmrTick
        tmrTick.setInterval(1000);
        tmrTick.Tick = new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                tmrTick_Tick(sender, e);
            }
        };
        // FormEncounter
        setAutoScaleBaseSize(new FormSize(5, 13));
        setClientSize(new FormSize(234, 271));
        setControlBox(false);
        Controls.add(picTribbles55);
        Controls.add(picTribbles54);
        Controls.add(picTribbles45);
        Controls.add(picTribbles44);
        Controls.add(picTribbles53);
        Controls.add(picTribbles43);
        Controls.add(picTribbles52);
        Controls.add(picTribbles42);
        Controls.add(picTribbles51);
        Controls.add(picTribbles41);
        Controls.add(picTribbles35);
        Controls.add(picTribbles34);
        Controls.add(picTribbles33);
        Controls.add(picTribbles32);
        Controls.add(picTribbles31);
        Controls.add(picTribbles25);
        Controls.add(picTribbles24);
        Controls.add(picTribbles23);
        Controls.add(picTribbles22);
        Controls.add(picTribbles21);
        Controls.add(picTribbles15);
        Controls.add(picTribbles14);
        Controls.add(picTribbles13);
        Controls.add(picTribbles12);
        Controls.add(picTribbles11);
        Controls.add(picTribbles05);
        Controls.add(picTribbles01);
        Controls.add(picTribbles02);
        Controls.add(picTribbles03);
        Controls.add(picTribbles04);
        Controls.add(picTribbles30);
        Controls.add(picTribbles20);
        Controls.add(picTribbles40);
        Controls.add(picTribbles10);
        Controls.add(picTribbles50);
        Controls.add(picTribbles00);
        Controls.add(picEncounterType);
        Controls.add(picContinuous);
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
        Controls.add(lblOpponentShields);
        Controls.add(lblOpponentHull);
        Controls.add(lblYouShields);
        Controls.add(lblYouHull);
        Controls.add(lblYouShip);
        Controls.add(lblOpponentShip);
        Controls.add(lblYouLabel);
        Controls.add(lblOpponentLabel);
        Controls.add(lblAction);
        Controls.add(picShipOpponent);
        Controls.add(picShipYou);
        Controls.add(lblEncounter);
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
            picEncounterType.setImage(ilEncounterType.getImages()[game.EncounterImageIndex()]);
        } else {
            picEncounterType.setVisible(false);
        }
        lblEncounter.setText(game.EncounterTextInitial());
        lblAction.setText(game.EncounterActionInitial());
    }


    private void DisableAuto() {
        tmrTick.Stop();
        game.setEncounterContinueFleeing(false);
        game.setEncounterContinueAttacking(false);
        buttonInt.setVisible(false);
        picContinuous.setVisible(false);
    }

    private void ExecuteAction() {
        _result = game.EncounterExecuteAction(this);
        if (_result == EncounterResult.Continue) {
            UpdateButtons();
            UpdateShipStats();
            lblEncounter.setText(game.EncounterText());
            lblAction.setText(game.EncounterAction());
            if (game.getEncounterContinueFleeing() || game.getEncounterContinueAttacking()) {
                tmrTick.Start();
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
                    picContinuous.setVisible(visible[i]);
                }
            }
        }
        if (picContinuous.getVisible()) {
            picContinuous.setImage(ilContinuous.getImages()[contImg = (contImg + 1) % 2]);
        }
    }

    private void UpdateShipInfo() {
        lblYouShip.setText(cmdrship.Name());
        lblOpponentShip.setText(opponent.Name());
        UpdateShipStats();
    }

    private void UpdateShipStats() {
        lblYouHull.setText(cmdrship.HullText());
        lblYouShields.setText(cmdrship.ShieldText());
        lblOpponentHull.setText(opponent.HullText());
        lblOpponentShields.setText(opponent.ShieldText());
        picShipYou.Refresh();
        picShipOpponent.Refresh();
    }

    private void UpdateTribbles() {
        PictureBox[] tribbles = new PictureBox[]{
                picTribbles00, picTribbles01, picTribbles02, picTribbles03, picTribbles04, picTribbles05,
                picTribbles10, picTribbles11, picTribbles12, picTribbles13, picTribbles14, picTribbles15,
                picTribbles20, picTribbles21, picTribbles22, picTribbles23, picTribbles24, picTribbles25,
                picTribbles30, picTribbles31, picTribbles32, picTribbles33, picTribbles34, picTribbles35,
                picTribbles40, picTribbles41, picTribbles42, picTribbles43, picTribbles44, picTribbles45,
                picTribbles50, picTribbles51, picTribbles52, picTribbles53, picTribbles54, picTribbles55
        };
        int toShow = Math.min(tribbles.length, (int) Math.sqrt(cmdrship.getTribbles() / Math.ceil(Constants.MaxTribbles / Math.pow(tribbles.length + 1, 2))));
        for (int i = 0; i < toShow; i++) {
            int index = Functions.GetRandom(tribbles.length);
            while (tribbles[index].getVisible()) {
                index = (index + 1) % tribbles.length;
            }
            tribbles[index].setImage(ilTribbles.getImages()[Functions.GetRandom(ilTribbles.getImages().length)]);
            tribbles[index].setVisible(true);
        }
    }

    private void buttonAttack_Click(Object sender, EventArgs e) {
        DisableAuto();
        if (game.EncounterVerifyAttack(this)) {
            ExecuteAction();
        }
    }

    private void buttonBoard_Click(Object sender, EventArgs e) {
        if (game.EncounterVerifyBoard(this)) {
            Exit(EncounterResult.Normal);
        }
    }

    private void buttonBribe_Click(Object sender, EventArgs e) {
        if (game.EncounterVerifyBribe(this)) {
            Exit(EncounterResult.Normal);
        }
    }

    private void buttonDrink_Click(Object sender, EventArgs e) {
        game.EncounterDrink(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonFlee_Click(Object sender, EventArgs e) {
        DisableAuto();
        if (game.EncounterVerifyFlee(this)) {
            ExecuteAction();
        }
    }

    private void buttonIgnore_Click(Object sender, EventArgs e) {
        DisableAuto();
        Exit(EncounterResult.Normal);
    }

    private void buttonInt_Click(Object sender, EventArgs e) {
        DisableAuto();
    }

    private void buttonMeet_Click(Object sender, EventArgs e) {
        game.EncounterMeet(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonPlunder_Click(Object sender, EventArgs e) {
        DisableAuto();
        game.EncounterPlunder(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonSubmit_Click(Object sender, EventArgs e) {
        if (game.EncounterVerifySubmit(this)) {
            Exit(cmdrship.IllegalSpecialCargo() ? EncounterResult.Arrested : EncounterResult.Normal);
        }
    }

    private void buttonSurrender_Click(Object sender, EventArgs e) {
        DisableAuto();
        _result = game.EncounterVerifySurrender(this);
        if (_result != EncounterResult.Continue) {
            Close();
        }
    }

    private void buttonTrade_Click(Object sender, EventArgs e) {
        game.EncounterTrade(this);
        Exit(EncounterResult.Normal);
    }

    private void buttonYield_Click(Object sender, EventArgs e) {
        _result = game.EncounterVerifyYield(this);
        if (_result != EncounterResult.Continue) {
            Close();
        }
    }

    private void picShipOpponent_Paint(Object sender, PaintEventArgs e) {
        Functions.PaintShipImage(opponent, e.Graphics, picShipOpponent.getBackColor());
    }

    private void picShipYou_Paint(Object sender, PaintEventArgs e) {
        Functions.PaintShipImage(cmdrship, e.Graphics, picShipYou.getBackColor());
    }

    private void picTribbles_Click(Object sender, EventArgs e) {
        FormAlert.Alert(AlertType.TribblesSqueek, this);
    }

    private void tmrTick_Tick(Object sender, EventArgs e) {
        DisableAuto();
        ExecuteAction();
    }

    public EncounterResult Result() {
        return _result;
    }
}
