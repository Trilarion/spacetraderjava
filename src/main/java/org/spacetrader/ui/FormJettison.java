package org.spacetrader.ui;

import org.spacetrader.model.crew.Commander;
import org.spacetrader.controller.Game;
import org.spacetrader.model.ship.Ship;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;
import java.util.Arrays;


public class FormJettison extends form {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Label labelBays;
    private final Button[] buttonJettisonQty;

    public FormJettison() {
        Button buttonJettisonAll9 = new Button();
        Button buttonJettisonQty9 = new Button();
        Button buttonJettisonAll8 = new Button();
        Button buttonJettisonQty8 = new Button();
        Button buttonJettisonAll7 = new Button();
        Button buttonJettisonQty7 = new Button();
        Button buttonJettisonAll6 = new Button();
        Button buttonJettisonQty6 = new Button();
        Button buttonJettisonAll5 = new Button();
        Button buttonJettisonQty5 = new Button();
        Button buttonJettisonAll4 = new Button();
        Button buttonJettisonQty4 = new Button();
        Button buttonJettisonAll3 = new Button();
        Button buttonJettisonQty3 = new Button();
        Button buttonJettisonAll2 = new Button();
        Button buttonJettisonQty2 = new Button();
        Button buttonJettisonAll1 = new Button();
        Button buttonJettisonQty1 = new Button();
        Button buttonJettisonAll0 = new Button();
        Button buttonJettisonQty0 = new Button();
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
        // buttonJettisonQty9
        buttonJettisonQty9.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty9.setLocation(new Point(68, 220));
        buttonJettisonQty9.setName("buttonJettisonQty9");
        buttonJettisonQty9.setSize(new Dimension(28, 22));
        buttonJettisonQty9.setTabIndex(140);
        buttonJettisonQty9.setText("88");
        buttonJettisonQty9.setClick(new EventHandler<>() {
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
        // buttonJettisonQty8
        buttonJettisonQty8.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty8.setLocation(new Point(68, 196));
        buttonJettisonQty8.setName("buttonJettisonQty8");
        buttonJettisonQty8.setSize(new Dimension(28, 22));
        buttonJettisonQty8.setTabIndex(138);
        buttonJettisonQty8.setText("88");
        buttonJettisonQty8.setClick(new EventHandler<>() {
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
        // buttonJettisonQty7
        buttonJettisonQty7.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty7.setLocation(new Point(68, 172));
        buttonJettisonQty7.setName("buttonJettisonQty7");
        buttonJettisonQty7.setSize(new Dimension(28, 22));
        buttonJettisonQty7.setTabIndex(136);
        buttonJettisonQty7.setText("88");
        buttonJettisonQty7.setClick(new EventHandler<>() {
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
        // buttonJettisonQty6
        buttonJettisonQty6.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty6.setLocation(new Point(68, 148));
        buttonJettisonQty6.setName("buttonJettisonQty6");
        buttonJettisonQty6.setSize(new Dimension(28, 22));
        buttonJettisonQty6.setTabIndex(134);
        buttonJettisonQty6.setText("88");
        buttonJettisonQty6.setClick(new EventHandler<>() {
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
        // buttonJettisonQty5
        buttonJettisonQty5.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty5.setLocation(new Point(68, 124));
        buttonJettisonQty5.setName("buttonJettisonQty5");
        buttonJettisonQty5.setSize(new Dimension(28, 22));
        buttonJettisonQty5.setTabIndex(132);
        buttonJettisonQty5.setText("88");
        buttonJettisonQty5.setClick(new EventHandler<>() {
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
        // buttonJettisonQty4
        buttonJettisonQty4.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty4.setLocation(new Point(68, 100));
        buttonJettisonQty4.setName("buttonJettisonQty4");
        buttonJettisonQty4.setSize(new Dimension(28, 22));
        buttonJettisonQty4.setTabIndex(130);
        buttonJettisonQty4.setText("88");
        buttonJettisonQty4.setClick(new EventHandler<>() {
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
        // buttonJettisonQty3
        buttonJettisonQty3.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty3.setLocation(new Point(68, 76));
        buttonJettisonQty3.setName("buttonJettisonQty3");
        buttonJettisonQty3.setSize(new Dimension(28, 22));
        buttonJettisonQty3.setTabIndex(128);
        buttonJettisonQty3.setText("88");
        buttonJettisonQty3.setClick(new EventHandler<>() {
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
        // buttonJettisonQty2
        buttonJettisonQty2.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty2.setLocation(new Point(68, 52));
        buttonJettisonQty2.setName("buttonJettisonQty2");
        buttonJettisonQty2.setSize(new Dimension(28, 22));
        buttonJettisonQty2.setTabIndex(126);
        buttonJettisonQty2.setText("88");
        buttonJettisonQty2.setClick(new EventHandler<>() {
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
        // buttonJettisonQty1
        buttonJettisonQty1.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty1.setLocation(new Point(68, 28));
        buttonJettisonQty1.setName("buttonJettisonQty1");
        buttonJettisonQty1.setSize(new Dimension(28, 22));
        buttonJettisonQty1.setTabIndex(124);
        buttonJettisonQty1.setText("88");
        buttonJettisonQty1.setClick(new EventHandler<>() {
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
        // buttonJettisonQty0
        buttonJettisonQty0.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty0.setLocation(new Point(68, 4));
        buttonJettisonQty0.setName("buttonJettisonQty0");
        buttonJettisonQty0.setSize(new Dimension(28, 22));
        buttonJettisonQty0.setTabIndex(122);
        buttonJettisonQty0.setText("88");
        buttonJettisonQty0.setClick(new EventHandler<>() {
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
                buttonJettisonQty9,
                buttonJettisonAll8,
                buttonJettisonQty8,
                buttonJettisonAll7,
                buttonJettisonQty7,
                buttonJettisonAll6,
                buttonJettisonQty6,
                buttonJettisonAll5,
                buttonJettisonQty5,
                buttonJettisonAll4,
                buttonJettisonQty4,
                buttonJettisonAll3,
                buttonJettisonQty3,
                buttonJettisonAll2,
                buttonJettisonQty2,
                buttonJettisonAll1,
                buttonJettisonQty1,
                buttonJettisonAll0,
                buttonJettisonQty0));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormJettison");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Jettison Cargo");
        resumeLayout(false);
        buttonJettisonQty = new Button[]{
                buttonJettisonQty0,
                buttonJettisonQty1,
                buttonJettisonQty2,
                buttonJettisonQty3,
                buttonJettisonQty4,
                buttonJettisonQty5,
                buttonJettisonQty6,
                buttonJettisonQty7,
                buttonJettisonQty8,
                buttonJettisonQty9
        };
        Button[] buttonJettisonAll = new Button[]{
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
        for (int i = 0; i < buttonJettisonQty.length; i++) {
            buttonJettisonQty[i].setText("" + ship.Cargo()[i]);
        }
        labelBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
    }

    private void buttonJettison_Click(Object sender, EventData e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Qty");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        Jettison(index, all);
    }
}
