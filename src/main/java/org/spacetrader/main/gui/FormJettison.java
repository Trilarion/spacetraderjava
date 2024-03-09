package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Container;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.DialogResult;
import org.jwinforms.enums.FlatStyle;
import org.jwinforms.enums.FormBorderStyle;
import org.jwinforms.enums.FormStartPosition;
import org.spacetrader.main.Commander;
import org.spacetrader.main.Game;
import org.spacetrader.main.Ship;

import java.awt.*;
import java.util.Arrays;


public class FormJettison extends WinformForm {
    private final Game game = Game.CurrentGame();
    private final Commander cmdr = game.Commander();
    private Label lblBays;
    private Container components = null;
    private Button[] btnJettisonQty;

    public FormJettison() {
        Button btnJettisonAll9 = new Button();
        Button btnJettisonQty9 = new Button();
        Button btnJettisonAll8 = new Button();
        Button btnJettisonQty8 = new Button();
        Button btnJettisonAll7 = new Button();
        Button btnJettisonQty7 = new Button();
        Button btnJettisonAll6 = new Button();
        Button btnJettisonQty6 = new Button();
        Button btnJettisonAll5 = new Button();
        Button btnJettisonQty5 = new Button();
        Button btnJettisonAll4 = new Button();
        Button btnJettisonQty4 = new Button();
        Button btnJettisonAll3 = new Button();
        Button btnJettisonQty3 = new Button();
        Button btnJettisonAll2 = new Button();
        Button btnJettisonQty2 = new Button();
        Button btnJettisonAll1 = new Button();
        Button btnJettisonQty1 = new Button();
        Button btnJettisonAll0 = new Button();
        Button btnJettisonQty0 = new Button();
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
        Button btnDone = new Button();
        SuspendLayout();
        // btnJettisonAll9
        btnJettisonAll9.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll9.setLocation(new Point(100, 220));
        btnJettisonAll9.setName("btnJettisonAll9");
        btnJettisonAll9.setSize(new FormSize(32, 22));
        btnJettisonAll9.setTabIndex(141);
        btnJettisonAll9.setText("All");
        btnJettisonAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty9
        btnJettisonQty9.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty9.setLocation(new Point(68, 220));
        btnJettisonQty9.setName("btnJettisonQty9");
        btnJettisonQty9.setSize(new FormSize(28, 22));
        btnJettisonQty9.setTabIndex(140);
        btnJettisonQty9.setText("88");
        btnJettisonQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll8
        btnJettisonAll8.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll8.setLocation(new Point(100, 196));
        btnJettisonAll8.setName("btnJettisonAll8");
        btnJettisonAll8.setSize(new FormSize(32, 22));
        btnJettisonAll8.setTabIndex(139);
        btnJettisonAll8.setText("All");
        btnJettisonAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty8
        btnJettisonQty8.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty8.setLocation(new Point(68, 196));
        btnJettisonQty8.setName("btnJettisonQty8");
        btnJettisonQty8.setSize(new FormSize(28, 22));
        btnJettisonQty8.setTabIndex(138);
        btnJettisonQty8.setText("88");
        btnJettisonQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll7
        btnJettisonAll7.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll7.setLocation(new Point(100, 172));
        btnJettisonAll7.setName("btnJettisonAll7");
        btnJettisonAll7.setSize(new FormSize(32, 22));
        btnJettisonAll7.setTabIndex(137);
        btnJettisonAll7.setText("All");
        btnJettisonAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty7
        btnJettisonQty7.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty7.setLocation(new Point(68, 172));
        btnJettisonQty7.setName("btnJettisonQty7");
        btnJettisonQty7.setSize(new FormSize(28, 22));
        btnJettisonQty7.setTabIndex(136);
        btnJettisonQty7.setText("88");
        btnJettisonQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll6
        btnJettisonAll6.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll6.setLocation(new Point(100, 148));
        btnJettisonAll6.setName("btnJettisonAll6");
        btnJettisonAll6.setSize(new FormSize(32, 22));
        btnJettisonAll6.setTabIndex(135);
        btnJettisonAll6.setText("All");
        btnJettisonAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty6
        btnJettisonQty6.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty6.setLocation(new Point(68, 148));
        btnJettisonQty6.setName("btnJettisonQty6");
        btnJettisonQty6.setSize(new FormSize(28, 22));
        btnJettisonQty6.setTabIndex(134);
        btnJettisonQty6.setText("88");
        btnJettisonQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll5
        btnJettisonAll5.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll5.setLocation(new Point(100, 124));
        btnJettisonAll5.setName("btnJettisonAll5");
        btnJettisonAll5.setSize(new FormSize(32, 22));
        btnJettisonAll5.setTabIndex(133);
        btnJettisonAll5.setText("All");
        btnJettisonAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty5
        btnJettisonQty5.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty5.setLocation(new Point(68, 124));
        btnJettisonQty5.setName("btnJettisonQty5");
        btnJettisonQty5.setSize(new FormSize(28, 22));
        btnJettisonQty5.setTabIndex(132);
        btnJettisonQty5.setText("88");
        btnJettisonQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll4
        btnJettisonAll4.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll4.setLocation(new Point(100, 100));
        btnJettisonAll4.setName("btnJettisonAll4");
        btnJettisonAll4.setSize(new FormSize(32, 22));
        btnJettisonAll4.setTabIndex(131);
        btnJettisonAll4.setText("All");
        btnJettisonAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty4
        btnJettisonQty4.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty4.setLocation(new Point(68, 100));
        btnJettisonQty4.setName("btnJettisonQty4");
        btnJettisonQty4.setSize(new FormSize(28, 22));
        btnJettisonQty4.setTabIndex(130);
        btnJettisonQty4.setText("88");
        btnJettisonQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll3
        btnJettisonAll3.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll3.setLocation(new Point(100, 76));
        btnJettisonAll3.setName("btnJettisonAll3");
        btnJettisonAll3.setSize(new FormSize(32, 22));
        btnJettisonAll3.setTabIndex(129);
        btnJettisonAll3.setText("All");
        btnJettisonAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty3
        btnJettisonQty3.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty3.setLocation(new Point(68, 76));
        btnJettisonQty3.setName("btnJettisonQty3");
        btnJettisonQty3.setSize(new FormSize(28, 22));
        btnJettisonQty3.setTabIndex(128);
        btnJettisonQty3.setText("88");
        btnJettisonQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll2
        btnJettisonAll2.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll2.setLocation(new Point(100, 52));
        btnJettisonAll2.setName("btnJettisonAll2");
        btnJettisonAll2.setSize(new FormSize(32, 22));
        btnJettisonAll2.setTabIndex(127);
        btnJettisonAll2.setText("All");
        btnJettisonAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty2
        btnJettisonQty2.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty2.setLocation(new Point(68, 52));
        btnJettisonQty2.setName("btnJettisonQty2");
        btnJettisonQty2.setSize(new FormSize(28, 22));
        btnJettisonQty2.setTabIndex(126);
        btnJettisonQty2.setText("88");
        btnJettisonQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll1
        btnJettisonAll1.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll1.setLocation(new Point(100, 28));
        btnJettisonAll1.setName("btnJettisonAll1");
        btnJettisonAll1.setSize(new FormSize(32, 22));
        btnJettisonAll1.setTabIndex(125);
        btnJettisonAll1.setText("All");
        btnJettisonAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty1
        btnJettisonQty1.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty1.setLocation(new Point(68, 28));
        btnJettisonQty1.setName("btnJettisonQty1");
        btnJettisonQty1.setSize(new FormSize(28, 22));
        btnJettisonQty1.setTabIndex(124);
        btnJettisonQty1.setText("88");
        btnJettisonQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonAll0
        btnJettisonAll0.setFlatStyle(FlatStyle.Flat);
        btnJettisonAll0.setLocation(new Point(100, 4));
        btnJettisonAll0.setName("btnJettisonAll0");
        btnJettisonAll0.setSize(new FormSize(32, 22));
        btnJettisonAll0.setTabIndex(123);
        btnJettisonAll0.setText("All");
        btnJettisonAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
            }
        });
        // btnJettisonQty0
        btnJettisonQty0.setFlatStyle(FlatStyle.Flat);
        btnJettisonQty0.setLocation(new Point(68, 4));
        btnJettisonQty0.setName("btnJettisonQty0");
        btnJettisonQty0.setSize(new FormSize(28, 22));
        btnJettisonQty0.setTabIndex(122);
        btnJettisonQty0.setText("88");
        btnJettisonQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click(sender, e);
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
        // btnDone
        btnDone.setDialogResult(DialogResult.Cancel);
        btnDone.setFlatStyle(FlatStyle.Flat);
        btnDone.setLocation(new Point(87, 252));
        btnDone.setName("btnDone");
        btnDone.setSize(new FormSize(44, 22));
        btnDone.setTabIndex(154);
        btnDone.setText("Done");
        // FormJettison
        setAcceptButton(btnDone);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnDone);
        setClientSize(new FormSize(218, 283));
        Controls.addAll(Arrays.asList(
                btnDone,
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
                btnJettisonAll9,
                btnJettisonQty9,
                btnJettisonAll8,
                btnJettisonQty8,
                btnJettisonAll7,
                btnJettisonQty7,
                btnJettisonAll6,
                btnJettisonQty6,
                btnJettisonAll5,
                btnJettisonQty5,
                btnJettisonAll4,
                btnJettisonQty4,
                btnJettisonAll3,
                btnJettisonQty3,
                btnJettisonAll2,
                btnJettisonQty2,
                btnJettisonAll1,
                btnJettisonQty1,
                btnJettisonAll0,
                btnJettisonQty0));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormJettison");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Jettison Cargo");
        ResumeLayout(false);
        btnJettisonQty = new Button[]{
                btnJettisonQty0,
                btnJettisonQty1,
                btnJettisonQty2,
                btnJettisonQty3,
                btnJettisonQty4,
                btnJettisonQty5,
                btnJettisonQty6,
                btnJettisonQty7,
                btnJettisonQty8,
                btnJettisonQty9
        };
        Button[] btnJettisonAll = new Button[]{
                btnJettisonAll0,
                btnJettisonAll1,
                btnJettisonAll2,
                btnJettisonAll3,
                btnJettisonAll4,
                btnJettisonAll5,
                btnJettisonAll6,
                btnJettisonAll7,
                btnJettisonAll8,
                btnJettisonAll9
        };
        UpdateAll();
    }


    private void Jettison(int tradeItem, boolean all) {
        game.CargoJettison(tradeItem, all, this);
        UpdateAll();
    }

    private void UpdateAll() {
        Ship ship = cmdr.getShip();
        for (int i = 0; i < btnJettisonQty.length; i++) {
            btnJettisonQty[i].setText("" + ship.Cargo()[i]);
        }
        lblBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
    }

    private void btnJettison_Click(Object sender, EventArgs e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Qty");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        Jettison(index, all);
    }
}
