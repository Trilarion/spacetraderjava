package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.DialogResult;
import org.jwinforms.enums.FlatStyle;
import org.jwinforms.enums.FormBorderStyle;
import org.jwinforms.enums.FormStartPosition;
import org.spacetrader.main.Game;
import org.spacetrader.main.Ship;

import java.awt.*;


public class FormPlunder extends WinformForm {
    private final Game game = Game.CurrentGame();
    private Button[] btnPlunderQty;
    private Label lblBays;

    public FormPlunder() {
        Button btnPlunderAll9 = new Button();
        Button btnPlunderQty9 = new Button();
        Button btnPlunderAll8 = new Button();
        Button btnPlunderQty8 = new Button();
        Button btnPlunderAll7 = new Button();
        Button btnPlunderQty7 = new Button();
        Button btnPlunderAll6 = new Button();
        Button btnPlunderQty6 = new Button();
        Button btnPlunderAll5 = new Button();
        Button btnPlunderQty5 = new Button();
        Button btnPlunderAll4 = new Button();
        Button btnPlunderQty4 = new Button();
        Button btnPlunderAll3 = new Button();
        Button btnPlunderQty3 = new Button();
        Button btnPlunderAll2 = new Button();
        Button btnPlunderQty2 = new Button();
        Button btnPlunderAll1 = new Button();
        Button btnPlunderQty1 = new Button();
        Button btnPlunderAll0 = new Button();
        Button btnPlunderQty0 = new Button();
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
        Button btnJettison = new Button();
        SuspendLayout();
        // btnPlunderAll9
        btnPlunderAll9.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll9.setLocation(new Point(100, 220));
        btnPlunderAll9.setName("btnPlunderAll9");
        btnPlunderAll9.setSize(new FormSize(32, 22));
        btnPlunderAll9.setTabIndex(141);
        btnPlunderAll9.setText("All");
        btnPlunderAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty9
        btnPlunderQty9.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty9.setLocation(new Point(68, 220));
        btnPlunderQty9.setName("btnPlunderQty9");
        btnPlunderQty9.setSize(new FormSize(28, 22));
        btnPlunderQty9.setTabIndex(140);
        btnPlunderQty9.setText("88");
        btnPlunderQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll8
        btnPlunderAll8.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll8.setLocation(new Point(100, 196));
        btnPlunderAll8.setName("btnPlunderAll8");
        btnPlunderAll8.setSize(new FormSize(32, 22));
        btnPlunderAll8.setTabIndex(139);
        btnPlunderAll8.setText("All");
        btnPlunderAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty8
        btnPlunderQty8.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty8.setLocation(new Point(68, 196));
        btnPlunderQty8.setName("btnPlunderQty8");
        btnPlunderQty8.setSize(new FormSize(28, 22));
        btnPlunderQty8.setTabIndex(138);
        btnPlunderQty8.setText("88");
        btnPlunderQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll7
        btnPlunderAll7.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll7.setLocation(new Point(100, 172));
        btnPlunderAll7.setName("btnPlunderAll7");
        btnPlunderAll7.setSize(new FormSize(32, 22));
        btnPlunderAll7.setTabIndex(137);
        btnPlunderAll7.setText("All");
        btnPlunderAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty7
        btnPlunderQty7.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty7.setLocation(new Point(68, 172));
        btnPlunderQty7.setName("btnPlunderQty7");
        btnPlunderQty7.setSize(new FormSize(28, 22));
        btnPlunderQty7.setTabIndex(136);
        btnPlunderQty7.setText("88");
        btnPlunderQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll6
        btnPlunderAll6.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll6.setLocation(new Point(100, 148));
        btnPlunderAll6.setName("btnPlunderAll6");
        btnPlunderAll6.setSize(new FormSize(32, 22));
        btnPlunderAll6.setTabIndex(135);
        btnPlunderAll6.setText("All");
        btnPlunderAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty6
        btnPlunderQty6.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty6.setLocation(new Point(68, 148));
        btnPlunderQty6.setName("btnPlunderQty6");
        btnPlunderQty6.setSize(new FormSize(28, 22));
        btnPlunderQty6.setTabIndex(134);
        btnPlunderQty6.setText("88");
        btnPlunderQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll5
        btnPlunderAll5.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll5.setLocation(new Point(100, 124));
        btnPlunderAll5.setName("btnPlunderAll5");
        btnPlunderAll5.setSize(new FormSize(32, 22));
        btnPlunderAll5.setTabIndex(133);
        btnPlunderAll5.setText("All");
        btnPlunderAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty5
        btnPlunderQty5.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty5.setLocation(new Point(68, 124));
        btnPlunderQty5.setName("btnPlunderQty5");
        btnPlunderQty5.setSize(new FormSize(28, 22));
        btnPlunderQty5.setTabIndex(132);
        btnPlunderQty5.setText("88");
        btnPlunderQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll4
        btnPlunderAll4.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll4.setLocation(new Point(100, 100));
        btnPlunderAll4.setName("btnPlunderAll4");
        btnPlunderAll4.setSize(new FormSize(32, 22));
        btnPlunderAll4.setTabIndex(131);
        btnPlunderAll4.setText("All");
        btnPlunderAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty4
        btnPlunderQty4.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty4.setLocation(new Point(68, 100));
        btnPlunderQty4.setName("btnPlunderQty4");
        btnPlunderQty4.setSize(new FormSize(28, 22));
        btnPlunderQty4.setTabIndex(130);
        btnPlunderQty4.setText("88");
        btnPlunderQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll3
        btnPlunderAll3.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll3.setLocation(new Point(100, 76));
        btnPlunderAll3.setName("btnPlunderAll3");
        btnPlunderAll3.setSize(new FormSize(32, 22));
        btnPlunderAll3.setTabIndex(129);
        btnPlunderAll3.setText("All");
        btnPlunderAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty3
        btnPlunderQty3.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty3.setLocation(new Point(68, 76));
        btnPlunderQty3.setName("btnPlunderQty3");
        btnPlunderQty3.setSize(new FormSize(28, 22));
        btnPlunderQty3.setTabIndex(128);
        btnPlunderQty3.setText("88");
        btnPlunderQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll2
        btnPlunderAll2.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll2.setLocation(new Point(100, 52));
        btnPlunderAll2.setName("btnPlunderAll2");
        btnPlunderAll2.setSize(new FormSize(32, 22));
        btnPlunderAll2.setTabIndex(127);
        btnPlunderAll2.setText("All");
        btnPlunderAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty2
        btnPlunderQty2.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty2.setLocation(new Point(68, 52));
        btnPlunderQty2.setName("btnPlunderQty2");
        btnPlunderQty2.setSize(new FormSize(28, 22));
        btnPlunderQty2.setTabIndex(126);
        btnPlunderQty2.setText("88");
        btnPlunderQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll1
        btnPlunderAll1.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll1.setLocation(new Point(100, 28));
        btnPlunderAll1.setName("btnPlunderAll1");
        btnPlunderAll1.setSize(new FormSize(32, 22));
        btnPlunderAll1.setTabIndex(125);
        btnPlunderAll1.setText("All");
        btnPlunderAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty1
        btnPlunderQty1.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty1.setLocation(new Point(68, 28));
        btnPlunderQty1.setName("btnPlunderQty1");
        btnPlunderQty1.setSize(new FormSize(28, 22));
        btnPlunderQty1.setTabIndex(124);
        btnPlunderQty1.setText("88");
        btnPlunderQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderAll0
        btnPlunderAll0.setFlatStyle(FlatStyle.Flat);
        btnPlunderAll0.setLocation(new Point(100, 4));
        btnPlunderAll0.setName("btnPlunderAll0");
        btnPlunderAll0.setSize(new FormSize(32, 22));
        btnPlunderAll0.setTabIndex(123);
        btnPlunderAll0.setText("All");
        btnPlunderAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // btnPlunderQty0
        btnPlunderQty0.setFlatStyle(FlatStyle.Flat);
        btnPlunderQty0.setLocation(new Point(68, 4));
        btnPlunderQty0.setName("btnPlunderQty0");
        btnPlunderQty0.setSize(new FormSize(28, 22));
        btnPlunderQty0.setTabIndex(122);
        btnPlunderQty0.setText("88");
        btnPlunderQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnPlunder_Click(sender, e);
            }
        });
        // lblTradeCommodity9
        lblTradeCommodity9.setAutoSize(true);
        lblTradeCommodity9.setLocation(new Point(8, 224));
        lblTradeCommodity9.setName("lblTradeCommodity9");
        lblTradeCommodity9.setSize(new FormSize(41, 13));
        lblTradeCommodity9.setTabIndex(151);
        lblTradeCommodity9.setText("Robots");
        // lblTradeCommodity8
        lblTradeCommodity8.setAutoSize(true);
        lblTradeCommodity8.setLocation(new Point(8, 200));
        lblTradeCommodity8.setName("lblTradeCommodity8");
        lblTradeCommodity8.setSize(new FormSize(52, 13));
        lblTradeCommodity8.setTabIndex(150);
        lblTradeCommodity8.setText("Narcotics");
        // lblTradeCommodity2
        lblTradeCommodity2.setAutoSize(true);
        lblTradeCommodity2.setLocation(new Point(8, 56));
        lblTradeCommodity2.setName("lblTradeCommodity2");
        lblTradeCommodity2.setSize(new FormSize(31, 13));
        lblTradeCommodity2.setTabIndex(149);
        lblTradeCommodity2.setText("Food");
        // lblTradeCommodity0
        lblTradeCommodity0.setAutoSize(true);
        lblTradeCommodity0.setLocation(new Point(8, 8));
        lblTradeCommodity0.setName("lblTradeCommodity0");
        lblTradeCommodity0.setSize(new FormSize(36, 13));
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
        lblTradeCommodity5.setSize(new FormSize(46, 13));
        lblTradeCommodity5.setTabIndex(145);
        lblTradeCommodity5.setText("Firearms");
        // lblTradeCommodity4
        lblTradeCommodity4.setAutoSize(true);
        lblTradeCommodity4.setLocation(new Point(8, 104));
        lblTradeCommodity4.setName("lblTradeCommodity4");
        lblTradeCommodity4.setSize(new FormSize(40, 13));
        lblTradeCommodity4.setTabIndex(144);
        lblTradeCommodity4.setText("Games");
        // lblTradeCommodity3
        lblTradeCommodity3.setAutoSize(true);
        lblTradeCommodity3.setLocation(new Point(8, 80));
        lblTradeCommodity3.setName("lblTradeCommodity3");
        lblTradeCommodity3.setSize(new FormSize(24, 13));
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
        lblBays.setSize(new FormSize(48, 13));
        lblBays.setTabIndex(153);
        lblBays.setText("888/888");
        // btnDone
        btnDone.setDialogResult(DialogResult.Cancel);
        btnDone.setFlatStyle(FlatStyle.Flat);
        btnDone.setLocation(new Point(87, 252));
        btnDone.setName("btnDone");
        btnDone.setSize(new FormSize(44, 22));
        btnDone.setTabIndex(154);
        btnDone.setText("Done");
        // btnJettison
        btnJettison.setFlatStyle(FlatStyle.Flat);
        btnJettison.setLocation(new Point(150, 24));
        btnJettison.setName("btnJettison");
        btnJettison.setSize(new FormSize(53, 22));
        btnJettison.setTabIndex(155);
        btnJettison.setText("Jettison");
        btnJettison.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnJettison_Click();
            }
        });
        // FormPlunder
        setAcceptButton(btnDone);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnDone);
        setClientSize(new FormSize(230, 283));
        Controls.add(btnJettison);
        Controls.add(btnDone);
        Controls.add(lblBays);
        Controls.add(lblBaysLabel);
        Controls.add(lblTradeCommodity9);
        Controls.add(lblTradeCommodity8);
        Controls.add(lblTradeCommodity2);
        Controls.add(lblTradeCommodity0);
        Controls.add(lblTradeCommodity1);
        Controls.add(lblTradeCommodity6);
        Controls.add(lblTradeCommodity5);
        Controls.add(lblTradeCommodity4);
        Controls.add(lblTradeCommodity3);
        Controls.add(lblTradeCommodity7);
        Controls.add(btnPlunderAll9);
        Controls.add(btnPlunderQty9);
        Controls.add(btnPlunderAll8);
        Controls.add(btnPlunderQty8);
        Controls.add(btnPlunderAll7);
        Controls.add(btnPlunderQty7);
        Controls.add(btnPlunderAll6);
        Controls.add(btnPlunderQty6);
        Controls.add(btnPlunderAll5);
        Controls.add(btnPlunderQty5);
        Controls.add(btnPlunderAll4);
        Controls.add(btnPlunderQty4);
        Controls.add(btnPlunderAll3);
        Controls.add(btnPlunderQty3);
        Controls.add(btnPlunderAll2);
        Controls.add(btnPlunderQty2);
        Controls.add(btnPlunderAll1);
        Controls.add(btnPlunderQty1);
        Controls.add(btnPlunderAll0);
        Controls.add(btnPlunderQty0);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormPlunder");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Plunder Cargo");
        ResumeLayout(false);
        PerformLayout();
        btnPlunderQty = new Button[]{
                btnPlunderQty0, btnPlunderQty1, btnPlunderQty2, btnPlunderQty3, btnPlunderQty4,
                btnPlunderQty5, btnPlunderQty6, btnPlunderQty7, btnPlunderQty8, btnPlunderQty9
        };
        Button[] btnPlunderAll = new Button[]{
                btnPlunderAll0, btnPlunderAll1, btnPlunderAll2, btnPlunderAll3, btnPlunderAll4,
                btnPlunderAll5, btnPlunderAll6, btnPlunderAll7, btnPlunderAll8, btnPlunderAll9
        };
        UpdateAll();
    }


    private void Plunder(int tradeItem, boolean all) {
        game.CargoPlunder(tradeItem, all, this);
        UpdateAll();
    }

    private void UpdateAll() {
        Ship ship = game.Commander().getShip();
        Ship opp = game.getOpponent();
        for (int i = 0; i < btnPlunderQty.length; i++) {
            btnPlunderQty[i].setText("" + opp.Cargo()[i]);
        }
        lblBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
    }

    private void btnJettison_Click() {
        (new FormJettison()).ShowDialog(this);
    }

    private void btnPlunder_Click(Object sender, EventArgs e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Qty");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        Plunder(index, all);
    }
}
