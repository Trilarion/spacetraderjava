package org.spacetrader.ui;

import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.ship.Ship;
import org.winforms.controls.Button;
import org.winforms.controls.Label;
import org.winforms.*;
import org.winforms.controls.Dialog;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;
import java.util.Arrays;


public class DialogJettison extends Dialog {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Label labelBays;
    private final Button[] buttonJettisonQuantity;

    public DialogJettison() {
        Button buttonJettisonAll9 = new Button();
        Button buttonJettisonQuantity9 = new Button();
        Button buttonJettisonAll8 = new Button();
        Button buttonJettisonQuantity8 = new Button();
        Button buttonJettisonAll7 = new Button();
        Button buttonJettisonQuantity7 = new Button();
        Button buttonJettisonAll6 = new Button();
        Button buttonJettisonQuantity6 = new Button();
        Button buttonJettisonAll5 = new Button();
        Button buttonJettisonQuantity5 = new Button();
        Button buttonJettisonAll4 = new Button();
        Button buttonJettisonQuantity4 = new Button();
        Button buttonJettisonAll3 = new Button();
        Button buttonJettisonQuantity3 = new Button();
        Button buttonJettisonAll2 = new Button();
        Button buttonJettisonQuantity2 = new Button();
        Button buttonJettisonAll1 = new Button();
        Button buttonJettisonQuantity1 = new Button();
        Button buttonJettisonAll0 = new Button();
        Button buttonJettisonQuantity0 = new Button();
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
        Label labelBaysLabel = new Label();
        labelBays = new Label();
        Button buttonDone = new Button();
        suspendLayout();
        // buttonJettisonAll9
        buttonJettisonAll9.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll9.setLocation(new Point(100, 220));
        buttonJettisonAll9.setName("buttonJettisonAll9");
        buttonJettisonAll9.setSize(new Dimension(32, 22));
        buttonJettisonAll9.setTabIndex(141);
        buttonJettisonAll9.setText("All");
        buttonJettisonAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity9
        buttonJettisonQuantity9.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity9.setLocation(new Point(68, 220));
        buttonJettisonQuantity9.setName("buttonJettisonQuantity9");
        buttonJettisonQuantity9.setSize(new Dimension(28, 22));
        buttonJettisonQuantity9.setTabIndex(140);
        buttonJettisonQuantity9.setText("88");
        buttonJettisonQuantity9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll8
        buttonJettisonAll8.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll8.setLocation(new Point(100, 196));
        buttonJettisonAll8.setName("buttonJettisonAll8");
        buttonJettisonAll8.setSize(new Dimension(32, 22));
        buttonJettisonAll8.setTabIndex(139);
        buttonJettisonAll8.setText("All");
        buttonJettisonAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity8
        buttonJettisonQuantity8.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity8.setLocation(new Point(68, 196));
        buttonJettisonQuantity8.setName("buttonJettisonQuantity8");
        buttonJettisonQuantity8.setSize(new Dimension(28, 22));
        buttonJettisonQuantity8.setTabIndex(138);
        buttonJettisonQuantity8.setText("88");
        buttonJettisonQuantity8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll7
        buttonJettisonAll7.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll7.setLocation(new Point(100, 172));
        buttonJettisonAll7.setName("buttonJettisonAll7");
        buttonJettisonAll7.setSize(new Dimension(32, 22));
        buttonJettisonAll7.setTabIndex(137);
        buttonJettisonAll7.setText("All");
        buttonJettisonAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity7
        buttonJettisonQuantity7.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity7.setLocation(new Point(68, 172));
        buttonJettisonQuantity7.setName("buttonJettisonQuantity7");
        buttonJettisonQuantity7.setSize(new Dimension(28, 22));
        buttonJettisonQuantity7.setTabIndex(136);
        buttonJettisonQuantity7.setText("88");
        buttonJettisonQuantity7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll6
        buttonJettisonAll6.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll6.setLocation(new Point(100, 148));
        buttonJettisonAll6.setName("buttonJettisonAll6");
        buttonJettisonAll6.setSize(new Dimension(32, 22));
        buttonJettisonAll6.setTabIndex(135);
        buttonJettisonAll6.setText("All");
        buttonJettisonAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity6
        buttonJettisonQuantity6.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity6.setLocation(new Point(68, 148));
        buttonJettisonQuantity6.setName("buttonJettisonQuantity6");
        buttonJettisonQuantity6.setSize(new Dimension(28, 22));
        buttonJettisonQuantity6.setTabIndex(134);
        buttonJettisonQuantity6.setText("88");
        buttonJettisonQuantity6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll5
        buttonJettisonAll5.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll5.setLocation(new Point(100, 124));
        buttonJettisonAll5.setName("buttonJettisonAll5");
        buttonJettisonAll5.setSize(new Dimension(32, 22));
        buttonJettisonAll5.setTabIndex(133);
        buttonJettisonAll5.setText("All");
        buttonJettisonAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity5
        buttonJettisonQuantity5.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity5.setLocation(new Point(68, 124));
        buttonJettisonQuantity5.setName("buttonJettisonQuantity5");
        buttonJettisonQuantity5.setSize(new Dimension(28, 22));
        buttonJettisonQuantity5.setTabIndex(132);
        buttonJettisonQuantity5.setText("88");
        buttonJettisonQuantity5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll4
        buttonJettisonAll4.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll4.setLocation(new Point(100, 100));
        buttonJettisonAll4.setName("buttonJettisonAll4");
        buttonJettisonAll4.setSize(new Dimension(32, 22));
        buttonJettisonAll4.setTabIndex(131);
        buttonJettisonAll4.setText("All");
        buttonJettisonAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity4
        buttonJettisonQuantity4.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity4.setLocation(new Point(68, 100));
        buttonJettisonQuantity4.setName("buttonJettisonQuantity4");
        buttonJettisonQuantity4.setSize(new Dimension(28, 22));
        buttonJettisonQuantity4.setTabIndex(130);
        buttonJettisonQuantity4.setText("88");
        buttonJettisonQuantity4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll3
        buttonJettisonAll3.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll3.setLocation(new Point(100, 76));
        buttonJettisonAll3.setName("buttonJettisonAll3");
        buttonJettisonAll3.setSize(new Dimension(32, 22));
        buttonJettisonAll3.setTabIndex(129);
        buttonJettisonAll3.setText("All");
        buttonJettisonAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity3
        buttonJettisonQuantity3.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity3.setLocation(new Point(68, 76));
        buttonJettisonQuantity3.setName("buttonJettisonQuantity3");
        buttonJettisonQuantity3.setSize(new Dimension(28, 22));
        buttonJettisonQuantity3.setTabIndex(128);
        buttonJettisonQuantity3.setText("88");
        buttonJettisonQuantity3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll2
        buttonJettisonAll2.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll2.setLocation(new Point(100, 52));
        buttonJettisonAll2.setName("buttonJettisonAll2");
        buttonJettisonAll2.setSize(new Dimension(32, 22));
        buttonJettisonAll2.setTabIndex(127);
        buttonJettisonAll2.setText("All");
        buttonJettisonAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity2
        buttonJettisonQuantity2.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity2.setLocation(new Point(68, 52));
        buttonJettisonQuantity2.setName("buttonJettisonQuantity2");
        buttonJettisonQuantity2.setSize(new Dimension(28, 22));
        buttonJettisonQuantity2.setTabIndex(126);
        buttonJettisonQuantity2.setText("88");
        buttonJettisonQuantity2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll1
        buttonJettisonAll1.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll1.setLocation(new Point(100, 28));
        buttonJettisonAll1.setName("buttonJettisonAll1");
        buttonJettisonAll1.setSize(new Dimension(32, 22));
        buttonJettisonAll1.setTabIndex(125);
        buttonJettisonAll1.setText("All");
        buttonJettisonAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity1
        buttonJettisonQuantity1.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity1.setLocation(new Point(68, 28));
        buttonJettisonQuantity1.setName("buttonJettisonQuantity1");
        buttonJettisonQuantity1.setSize(new Dimension(28, 22));
        buttonJettisonQuantity1.setTabIndex(124);
        buttonJettisonQuantity1.setText("88");
        buttonJettisonQuantity1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonAll0
        buttonJettisonAll0.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll0.setLocation(new Point(100, 4));
        buttonJettisonAll0.setName("buttonJettisonAll0");
        buttonJettisonAll0.setSize(new Dimension(32, 22));
        buttonJettisonAll0.setTabIndex(123);
        buttonJettisonAll0.setText("All");
        buttonJettisonAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // buttonJettisonQuantity0
        buttonJettisonQuantity0.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQuantity0.setLocation(new Point(68, 4));
        buttonJettisonQuantity0.setName("buttonJettisonQuantity0");
        buttonJettisonQuantity0.setSize(new Dimension(28, 22));
        buttonJettisonQuantity0.setTabIndex(122);
        buttonJettisonQuantity0.setText("88");
        buttonJettisonQuantity0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonJettison_Click(sender, data);
            }
        });
        // labelTradeCommodity9
        labelTradeCommodity9.setAutoSize(true);
        labelTradeCommodity9.setLocation(new Point(8, 224));
        labelTradeCommodity9.setName("labelTradeCommodity9");
        labelTradeCommodity9.setSize(new Dimension(40, 13));
        labelTradeCommodity9.setTabIndex(151);
        labelTradeCommodity9.setText("Robots");
        // labelTradeCommodity8
        labelTradeCommodity8.setAutoSize(true);
        labelTradeCommodity8.setLocation(new Point(8, 200));
        labelTradeCommodity8.setName("labelTradeCommodity8");
        labelTradeCommodity8.setSize(new Dimension(51, 13));
        labelTradeCommodity8.setTabIndex(150);
        labelTradeCommodity8.setText("Narcotics");
        // labelTradeCommodity2
        labelTradeCommodity2.setAutoSize(true);
        labelTradeCommodity2.setLocation(new Point(8, 56));
        labelTradeCommodity2.setName("labelTradeCommodity2");
        labelTradeCommodity2.setSize(new Dimension(30, 13));
        labelTradeCommodity2.setTabIndex(149);
        labelTradeCommodity2.setText("Food");
        // labelTradeCommodity0
        labelTradeCommodity0.setAutoSize(true);
        labelTradeCommodity0.setLocation(new Point(8, 8));
        labelTradeCommodity0.setName("labelTradeCommodity0");
        labelTradeCommodity0.setSize(new Dimension(34, 13));
        labelTradeCommodity0.setTabIndex(148);
        labelTradeCommodity0.setText("Water");
        // labelTradeCommodity1
        labelTradeCommodity1.setAutoSize(true);
        labelTradeCommodity1.setLocation(new Point(8, 32));
        labelTradeCommodity1.setName("labelTradeCommodity1");
        labelTradeCommodity1.setSize(new Dimension(27, 13));
        labelTradeCommodity1.setTabIndex(147);
        labelTradeCommodity1.setText("Furs");
        // labelTradeCommodity6
        labelTradeCommodity6.setAutoSize(true);
        labelTradeCommodity6.setLocation(new Point(8, 152));
        labelTradeCommodity6.setName("labelTradeCommodity6");
        labelTradeCommodity6.setSize(new Dimension(50, 13));
        labelTradeCommodity6.setTabIndex(146);
        labelTradeCommodity6.setText("Medicine");
        // labelTradeCommodity5
        labelTradeCommodity5.setAutoSize(true);
        labelTradeCommodity5.setLocation(new Point(8, 128));
        labelTradeCommodity5.setName("labelTradeCommodity5");
        labelTradeCommodity5.setSize(new Dimension(49, 13));
        labelTradeCommodity5.setTabIndex(145);
        labelTradeCommodity5.setText("Firearms");
        // labelTradeCommodity4
        labelTradeCommodity4.setAutoSize(true);
        labelTradeCommodity4.setLocation(new Point(8, 104));
        labelTradeCommodity4.setName("labelTradeCommodity4");
        labelTradeCommodity4.setSize(new Dimension(41, 13));
        labelTradeCommodity4.setTabIndex(144);
        labelTradeCommodity4.setText("Games");
        // labelTradeCommodity3
        labelTradeCommodity3.setAutoSize(true);
        labelTradeCommodity3.setLocation(new Point(8, 80));
        labelTradeCommodity3.setName("labelTradeCommodity3");
        labelTradeCommodity3.setSize(new Dimension(23, 13));
        labelTradeCommodity3.setTabIndex(143);
        labelTradeCommodity3.setText("Ore");
        // labelTradeCommodity7
        labelTradeCommodity7.setAutoSize(true);
        labelTradeCommodity7.setLocation(new Point(8, 176));
        labelTradeCommodity7.setName("labelTradeCommodity7");
        labelTradeCommodity7.setSize(new Dimension(53, 13));
        labelTradeCommodity7.setTabIndex(142);
        labelTradeCommodity7.setText("Machines");
        // labelBaysLabel
        labelBaysLabel.setAutoSize(true);
        labelBaysLabel.setLocation(new Point(144, 8));
        labelBaysLabel.setName("labelBaysLabel");
        labelBaysLabel.setSize(new Dimension(33, 13));
        labelBaysLabel.setTabIndex(152);
        labelBaysLabel.setText("Bays:");
        // labelBays
        labelBays.setLocation(new Point(176, 8));
        labelBays.setName("labelBays");
        labelBays.setSize(new Dimension(33, 13));
        labelBays.setTabIndex(153);
        labelBays.setText("88/88");
        // buttonDone
        buttonDone.setDialogResult(DialogResult.Cancel);
        buttonDone.setFlatStyle(FlatStyle.Flat);
        buttonDone.setLocation(new Point(87, 252));
        buttonDone.setName("buttonDone");
        buttonDone.setSize(new Dimension(44, 22));
        buttonDone.setTabIndex(154);
        buttonDone.setText("Done");
        // FormJettison
        setAcceptButton(buttonDone);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonDone);
        setClientSize(new Dimension(218, 283));
        Controls.addAll(Arrays.asList(
                buttonDone,
                labelBays,
                labelBaysLabel,
                labelTradeCommodity9,
                labelTradeCommodity8,
                labelTradeCommodity2,
                labelTradeCommodity0,
                labelTradeCommodity1,
                labelTradeCommodity6,
                labelTradeCommodity5,
                labelTradeCommodity4,
                labelTradeCommodity3,
                labelTradeCommodity7,
                buttonJettisonAll9,
                buttonJettisonQuantity9,
                buttonJettisonAll8,
                buttonJettisonQuantity8,
                buttonJettisonAll7,
                buttonJettisonQuantity7,
                buttonJettisonAll6,
                buttonJettisonQuantity6,
                buttonJettisonAll5,
                buttonJettisonQuantity5,
                buttonJettisonAll4,
                buttonJettisonQuantity4,
                buttonJettisonAll3,
                buttonJettisonQuantity3,
                buttonJettisonAll2,
                buttonJettisonQuantity2,
                buttonJettisonAll1,
                buttonJettisonQuantity1,
                buttonJettisonAll0,
                buttonJettisonQuantity0));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormJettison");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Jettison Cargo");
        resumeLayout(false);
        buttonJettisonQuantity = new Button[]{
                buttonJettisonQuantity0,
                buttonJettisonQuantity1,
                buttonJettisonQuantity2,
                buttonJettisonQuantity3,
                buttonJettisonQuantity4,
                buttonJettisonQuantity5,
                buttonJettisonQuantity6,
                buttonJettisonQuantity7,
                buttonJettisonQuantity8,
                buttonJettisonQuantity9
        };
        Button[] buttonJettisonAll = {
                buttonJettisonAll0,
                buttonJettisonAll1,
                buttonJettisonAll2,
                buttonJettisonAll3,
                buttonJettisonAll4,
                buttonJettisonAll5,
                buttonJettisonAll6,
                buttonJettisonAll7,
                buttonJettisonAll8,
                buttonJettisonAll9
        };
        UpdateAll();
    }


    private void Jettison(int tradeItem, boolean all) {
        game.CargoJettison(tradeItem, all, this);
        UpdateAll();
    }

    private void UpdateAll() {
        Ship ship = commander.getShip();
        for (int i = 0; i < buttonJettisonQuantity.length; i++) {
            buttonJettisonQuantity[i].setText("" + ship.Cargo()[i]);
        }
        labelBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
    }

    private void buttonJettison_Click(Object sender, EventData e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Quantity");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        Jettison(index, all);
    }
}
