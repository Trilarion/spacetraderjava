package org.spacetrader.ui;

import org.spacetrader.controller.Commander;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.Ship;
import org.winforms.Button;
import org.winforms.Container;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;
import java.util.Arrays;


public class FormJettison extends wfForm {
    private final Game game = Game.CurrentGame();
    private final Commander cmdr = game.Commander();
    private Label lblBays;
    private Container components = null;
    private Button[] buttonJettisonQty;

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
        Label lblBaysLabel = new Label();
        lblBays = new Label();
        Button buttonDone = new Button();
        SuspendLayout();
        // buttonJettisonAll9
        buttonJettisonAll9.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll9.setLocation(new Point(100, 220));
        buttonJettisonAll9.setName("buttonJettisonAll9");
        buttonJettisonAll9.setSize(new FormSize(32, 22));
        buttonJettisonAll9.setTabIndex(141);
        buttonJettisonAll9.setText("All");
        buttonJettisonAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty9
        buttonJettisonQty9.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty9.setLocation(new Point(68, 220));
        buttonJettisonQty9.setName("buttonJettisonQty9");
        buttonJettisonQty9.setSize(new FormSize(28, 22));
        buttonJettisonQty9.setTabIndex(140);
        buttonJettisonQty9.setText("88");
        buttonJettisonQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll8
        buttonJettisonAll8.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll8.setLocation(new Point(100, 196));
        buttonJettisonAll8.setName("buttonJettisonAll8");
        buttonJettisonAll8.setSize(new FormSize(32, 22));
        buttonJettisonAll8.setTabIndex(139);
        buttonJettisonAll8.setText("All");
        buttonJettisonAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty8
        buttonJettisonQty8.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty8.setLocation(new Point(68, 196));
        buttonJettisonQty8.setName("buttonJettisonQty8");
        buttonJettisonQty8.setSize(new FormSize(28, 22));
        buttonJettisonQty8.setTabIndex(138);
        buttonJettisonQty8.setText("88");
        buttonJettisonQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll7
        buttonJettisonAll7.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll7.setLocation(new Point(100, 172));
        buttonJettisonAll7.setName("buttonJettisonAll7");
        buttonJettisonAll7.setSize(new FormSize(32, 22));
        buttonJettisonAll7.setTabIndex(137);
        buttonJettisonAll7.setText("All");
        buttonJettisonAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty7
        buttonJettisonQty7.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty7.setLocation(new Point(68, 172));
        buttonJettisonQty7.setName("buttonJettisonQty7");
        buttonJettisonQty7.setSize(new FormSize(28, 22));
        buttonJettisonQty7.setTabIndex(136);
        buttonJettisonQty7.setText("88");
        buttonJettisonQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll6
        buttonJettisonAll6.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll6.setLocation(new Point(100, 148));
        buttonJettisonAll6.setName("buttonJettisonAll6");
        buttonJettisonAll6.setSize(new FormSize(32, 22));
        buttonJettisonAll6.setTabIndex(135);
        buttonJettisonAll6.setText("All");
        buttonJettisonAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty6
        buttonJettisonQty6.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty6.setLocation(new Point(68, 148));
        buttonJettisonQty6.setName("buttonJettisonQty6");
        buttonJettisonQty6.setSize(new FormSize(28, 22));
        buttonJettisonQty6.setTabIndex(134);
        buttonJettisonQty6.setText("88");
        buttonJettisonQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll5
        buttonJettisonAll5.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll5.setLocation(new Point(100, 124));
        buttonJettisonAll5.setName("buttonJettisonAll5");
        buttonJettisonAll5.setSize(new FormSize(32, 22));
        buttonJettisonAll5.setTabIndex(133);
        buttonJettisonAll5.setText("All");
        buttonJettisonAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty5
        buttonJettisonQty5.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty5.setLocation(new Point(68, 124));
        buttonJettisonQty5.setName("buttonJettisonQty5");
        buttonJettisonQty5.setSize(new FormSize(28, 22));
        buttonJettisonQty5.setTabIndex(132);
        buttonJettisonQty5.setText("88");
        buttonJettisonQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll4
        buttonJettisonAll4.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll4.setLocation(new Point(100, 100));
        buttonJettisonAll4.setName("buttonJettisonAll4");
        buttonJettisonAll4.setSize(new FormSize(32, 22));
        buttonJettisonAll4.setTabIndex(131);
        buttonJettisonAll4.setText("All");
        buttonJettisonAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty4
        buttonJettisonQty4.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty4.setLocation(new Point(68, 100));
        buttonJettisonQty4.setName("buttonJettisonQty4");
        buttonJettisonQty4.setSize(new FormSize(28, 22));
        buttonJettisonQty4.setTabIndex(130);
        buttonJettisonQty4.setText("88");
        buttonJettisonQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll3
        buttonJettisonAll3.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll3.setLocation(new Point(100, 76));
        buttonJettisonAll3.setName("buttonJettisonAll3");
        buttonJettisonAll3.setSize(new FormSize(32, 22));
        buttonJettisonAll3.setTabIndex(129);
        buttonJettisonAll3.setText("All");
        buttonJettisonAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty3
        buttonJettisonQty3.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty3.setLocation(new Point(68, 76));
        buttonJettisonQty3.setName("buttonJettisonQty3");
        buttonJettisonQty3.setSize(new FormSize(28, 22));
        buttonJettisonQty3.setTabIndex(128);
        buttonJettisonQty3.setText("88");
        buttonJettisonQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll2
        buttonJettisonAll2.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll2.setLocation(new Point(100, 52));
        buttonJettisonAll2.setName("buttonJettisonAll2");
        buttonJettisonAll2.setSize(new FormSize(32, 22));
        buttonJettisonAll2.setTabIndex(127);
        buttonJettisonAll2.setText("All");
        buttonJettisonAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty2
        buttonJettisonQty2.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty2.setLocation(new Point(68, 52));
        buttonJettisonQty2.setName("buttonJettisonQty2");
        buttonJettisonQty2.setSize(new FormSize(28, 22));
        buttonJettisonQty2.setTabIndex(126);
        buttonJettisonQty2.setText("88");
        buttonJettisonQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll1
        buttonJettisonAll1.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll1.setLocation(new Point(100, 28));
        buttonJettisonAll1.setName("buttonJettisonAll1");
        buttonJettisonAll1.setSize(new FormSize(32, 22));
        buttonJettisonAll1.setTabIndex(125);
        buttonJettisonAll1.setText("All");
        buttonJettisonAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty1
        buttonJettisonQty1.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty1.setLocation(new Point(68, 28));
        buttonJettisonQty1.setName("buttonJettisonQty1");
        buttonJettisonQty1.setSize(new FormSize(28, 22));
        buttonJettisonQty1.setTabIndex(124);
        buttonJettisonQty1.setText("88");
        buttonJettisonQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonAll0
        buttonJettisonAll0.setFlatStyle(FlatStyle.Flat);
        buttonJettisonAll0.setLocation(new Point(100, 4));
        buttonJettisonAll0.setName("buttonJettisonAll0");
        buttonJettisonAll0.setSize(new FormSize(32, 22));
        buttonJettisonAll0.setTabIndex(123);
        buttonJettisonAll0.setText("All");
        buttonJettisonAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // buttonJettisonQty0
        buttonJettisonQty0.setFlatStyle(FlatStyle.Flat);
        buttonJettisonQty0.setLocation(new Point(68, 4));
        buttonJettisonQty0.setName("buttonJettisonQty0");
        buttonJettisonQty0.setSize(new FormSize(28, 22));
        buttonJettisonQty0.setTabIndex(122);
        buttonJettisonQty0.setText("88");
        buttonJettisonQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click(sender, e);
            }
        });
        // lblTradeCommodity9
        lblTradeCommodity9.setAutoSize(true);
        lblTradeCommodity9.setLocation(new Point(8, 224));
        lblTradeCommodity9.setName("lblTradeCommodity9");
        lblTradeCommodity9.setSize(new FormSize(40, 13));
        lblTradeCommodity9.setTabIndex(151);
        lblTradeCommodity9.setText("Robots");
        // lblTradeCommodity8
        lblTradeCommodity8.setAutoSize(true);
        lblTradeCommodity8.setLocation(new Point(8, 200));
        lblTradeCommodity8.setName("lblTradeCommodity8");
        lblTradeCommodity8.setSize(new FormSize(51, 13));
        lblTradeCommodity8.setTabIndex(150);
        lblTradeCommodity8.setText("Narcotics");
        // lblTradeCommodity2
        lblTradeCommodity2.setAutoSize(true);
        lblTradeCommodity2.setLocation(new Point(8, 56));
        lblTradeCommodity2.setName("lblTradeCommodity2");
        lblTradeCommodity2.setSize(new FormSize(30, 13));
        lblTradeCommodity2.setTabIndex(149);
        lblTradeCommodity2.setText("Food");
        // lblTradeCommodity0
        lblTradeCommodity0.setAutoSize(true);
        lblTradeCommodity0.setLocation(new Point(8, 8));
        lblTradeCommodity0.setName("lblTradeCommodity0");
        lblTradeCommodity0.setSize(new FormSize(34, 13));
        lblTradeCommodity0.setTabIndex(148);
        lblTradeCommodity0.setText("Water");
        // lblTradeCommodity1
        lblTradeCommodity1.setAutoSize(true);
        lblTradeCommodity1.setLocation(new Point(8, 32));
        lblTradeCommodity1.setName("lblTradeCommodity1");
        lblTradeCommodity1.setSize(new FormSize(27, 13));
        lblTradeCommodity1.setTabIndex(147);
        lblTradeCommodity1.setText("Furs");
        // lblTradeCommodity6
        lblTradeCommodity6.setAutoSize(true);
        lblTradeCommodity6.setLocation(new Point(8, 152));
        lblTradeCommodity6.setName("lblTradeCommodity6");
        lblTradeCommodity6.setSize(new FormSize(50, 13));
        lblTradeCommodity6.setTabIndex(146);
        lblTradeCommodity6.setText("Medicine");
        // lblTradeCommodity5
        lblTradeCommodity5.setAutoSize(true);
        lblTradeCommodity5.setLocation(new Point(8, 128));
        lblTradeCommodity5.setName("lblTradeCommodity5");
        lblTradeCommodity5.setSize(new FormSize(49, 13));
        lblTradeCommodity5.setTabIndex(145);
        lblTradeCommodity5.setText("Firearms");
        // lblTradeCommodity4
        lblTradeCommodity4.setAutoSize(true);
        lblTradeCommodity4.setLocation(new Point(8, 104));
        lblTradeCommodity4.setName("lblTradeCommodity4");
        lblTradeCommodity4.setSize(new FormSize(41, 13));
        lblTradeCommodity4.setTabIndex(144);
        lblTradeCommodity4.setText("Games");
        // lblTradeCommodity3
        lblTradeCommodity3.setAutoSize(true);
        lblTradeCommodity3.setLocation(new Point(8, 80));
        lblTradeCommodity3.setName("lblTradeCommodity3");
        lblTradeCommodity3.setSize(new FormSize(23, 13));
        lblTradeCommodity3.setTabIndex(143);
        lblTradeCommodity3.setText("Ore");
        // lblTradeCommodity7
        lblTradeCommodity7.setAutoSize(true);
        lblTradeCommodity7.setLocation(new Point(8, 176));
        lblTradeCommodity7.setName("lblTradeCommodity7");
        lblTradeCommodity7.setSize(new FormSize(53, 13));
        lblTradeCommodity7.setTabIndex(142);
        lblTradeCommodity7.setText("Machines");
        // lblBaysLabel
        lblBaysLabel.setAutoSize(true);
        lblBaysLabel.setLocation(new Point(144, 8));
        lblBaysLabel.setName("lblBaysLabel");
        lblBaysLabel.setSize(new FormSize(33, 13));
        lblBaysLabel.setTabIndex(152);
        lblBaysLabel.setText("Bays:");
        // lblBays
        lblBays.setLocation(new Point(176, 8));
        lblBays.setName("lblBays");
        lblBays.setSize(new FormSize(33, 13));
        lblBays.setTabIndex(153);
        lblBays.setText("88/88");
        // buttonDone
        buttonDone.setDialogResult(DialogResult.Cancel);
        buttonDone.setFlatStyle(FlatStyle.Flat);
        buttonDone.setLocation(new Point(87, 252));
        buttonDone.setName("buttonDone");
        buttonDone.setSize(new FormSize(44, 22));
        buttonDone.setTabIndex(154);
        buttonDone.setText("Done");
        // FormJettison
        setAcceptButton(buttonDone);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonDone);
        setClientSize(new FormSize(218, 283));
        Controls.addAll(Arrays.asList(
                buttonDone,
                lblBays,
                lblBaysLabel,
                lblTradeCommodity9,
                lblTradeCommodity8,
                lblTradeCommodity2,
                lblTradeCommodity0,
                lblTradeCommodity1,
                lblTradeCommodity6,
                lblTradeCommodity5,
                lblTradeCommodity4,
                lblTradeCommodity3,
                lblTradeCommodity7,
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
        ResumeLayout(false);
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
        Ship ship = cmdr.getShip();
        for (int i = 0; i < buttonJettisonQty.length; i++) {
            buttonJettisonQty[i].setText("" + ship.Cargo()[i]);
        }
        lblBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
    }

    private void buttonJettison_Click(Object sender, EventArgs e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Qty");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        Jettison(index, all);
    }
}
