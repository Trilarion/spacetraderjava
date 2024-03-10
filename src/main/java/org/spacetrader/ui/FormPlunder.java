package org.spacetrader.ui;

import org.spacetrader.controller.Game;
import org.spacetrader.controller.Ship;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormPlunder extends wfForm {
    private final Game game = Game.CurrentGame();
    private Button[] buttonPlunderQty;
    private Label lblBays;

    public FormPlunder() {
        Button buttonPlunderAll9 = new Button();
        Button buttonPlunderQty9 = new Button();
        Button buttonPlunderAll8 = new Button();
        Button buttonPlunderQty8 = new Button();
        Button buttonPlunderAll7 = new Button();
        Button buttonPlunderQty7 = new Button();
        Button buttonPlunderAll6 = new Button();
        Button buttonPlunderQty6 = new Button();
        Button buttonPlunderAll5 = new Button();
        Button buttonPlunderQty5 = new Button();
        Button buttonPlunderAll4 = new Button();
        Button buttonPlunderQty4 = new Button();
        Button buttonPlunderAll3 = new Button();
        Button buttonPlunderQty3 = new Button();
        Button buttonPlunderAll2 = new Button();
        Button buttonPlunderQty2 = new Button();
        Button buttonPlunderAll1 = new Button();
        Button buttonPlunderQty1 = new Button();
        Button buttonPlunderAll0 = new Button();
        Button buttonPlunderQty0 = new Button();
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
        Button buttonJettison = new Button();
        SuspendLayout();
        // buttonPlunderAll9
        buttonPlunderAll9.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll9.setLocation(new Point(100, 220));
        buttonPlunderAll9.setName("buttonPlunderAll9");
        buttonPlunderAll9.setSize(new FormSize(32, 22));
        buttonPlunderAll9.setTabIndex(141);
        buttonPlunderAll9.setText("All");
        buttonPlunderAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty9
        buttonPlunderQty9.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty9.setLocation(new Point(68, 220));
        buttonPlunderQty9.setName("buttonPlunderQty9");
        buttonPlunderQty9.setSize(new FormSize(28, 22));
        buttonPlunderQty9.setTabIndex(140);
        buttonPlunderQty9.setText("88");
        buttonPlunderQty9.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll8
        buttonPlunderAll8.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll8.setLocation(new Point(100, 196));
        buttonPlunderAll8.setName("buttonPlunderAll8");
        buttonPlunderAll8.setSize(new FormSize(32, 22));
        buttonPlunderAll8.setTabIndex(139);
        buttonPlunderAll8.setText("All");
        buttonPlunderAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty8
        buttonPlunderQty8.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty8.setLocation(new Point(68, 196));
        buttonPlunderQty8.setName("buttonPlunderQty8");
        buttonPlunderQty8.setSize(new FormSize(28, 22));
        buttonPlunderQty8.setTabIndex(138);
        buttonPlunderQty8.setText("88");
        buttonPlunderQty8.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll7
        buttonPlunderAll7.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll7.setLocation(new Point(100, 172));
        buttonPlunderAll7.setName("buttonPlunderAll7");
        buttonPlunderAll7.setSize(new FormSize(32, 22));
        buttonPlunderAll7.setTabIndex(137);
        buttonPlunderAll7.setText("All");
        buttonPlunderAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty7
        buttonPlunderQty7.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty7.setLocation(new Point(68, 172));
        buttonPlunderQty7.setName("buttonPlunderQty7");
        buttonPlunderQty7.setSize(new FormSize(28, 22));
        buttonPlunderQty7.setTabIndex(136);
        buttonPlunderQty7.setText("88");
        buttonPlunderQty7.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll6
        buttonPlunderAll6.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll6.setLocation(new Point(100, 148));
        buttonPlunderAll6.setName("buttonPlunderAll6");
        buttonPlunderAll6.setSize(new FormSize(32, 22));
        buttonPlunderAll6.setTabIndex(135);
        buttonPlunderAll6.setText("All");
        buttonPlunderAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty6
        buttonPlunderQty6.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty6.setLocation(new Point(68, 148));
        buttonPlunderQty6.setName("buttonPlunderQty6");
        buttonPlunderQty6.setSize(new FormSize(28, 22));
        buttonPlunderQty6.setTabIndex(134);
        buttonPlunderQty6.setText("88");
        buttonPlunderQty6.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll5
        buttonPlunderAll5.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll5.setLocation(new Point(100, 124));
        buttonPlunderAll5.setName("buttonPlunderAll5");
        buttonPlunderAll5.setSize(new FormSize(32, 22));
        buttonPlunderAll5.setTabIndex(133);
        buttonPlunderAll5.setText("All");
        buttonPlunderAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty5
        buttonPlunderQty5.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty5.setLocation(new Point(68, 124));
        buttonPlunderQty5.setName("buttonPlunderQty5");
        buttonPlunderQty5.setSize(new FormSize(28, 22));
        buttonPlunderQty5.setTabIndex(132);
        buttonPlunderQty5.setText("88");
        buttonPlunderQty5.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll4
        buttonPlunderAll4.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll4.setLocation(new Point(100, 100));
        buttonPlunderAll4.setName("buttonPlunderAll4");
        buttonPlunderAll4.setSize(new FormSize(32, 22));
        buttonPlunderAll4.setTabIndex(131);
        buttonPlunderAll4.setText("All");
        buttonPlunderAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty4
        buttonPlunderQty4.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty4.setLocation(new Point(68, 100));
        buttonPlunderQty4.setName("buttonPlunderQty4");
        buttonPlunderQty4.setSize(new FormSize(28, 22));
        buttonPlunderQty4.setTabIndex(130);
        buttonPlunderQty4.setText("88");
        buttonPlunderQty4.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll3
        buttonPlunderAll3.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll3.setLocation(new Point(100, 76));
        buttonPlunderAll3.setName("buttonPlunderAll3");
        buttonPlunderAll3.setSize(new FormSize(32, 22));
        buttonPlunderAll3.setTabIndex(129);
        buttonPlunderAll3.setText("All");
        buttonPlunderAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty3
        buttonPlunderQty3.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty3.setLocation(new Point(68, 76));
        buttonPlunderQty3.setName("buttonPlunderQty3");
        buttonPlunderQty3.setSize(new FormSize(28, 22));
        buttonPlunderQty3.setTabIndex(128);
        buttonPlunderQty3.setText("88");
        buttonPlunderQty3.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll2
        buttonPlunderAll2.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll2.setLocation(new Point(100, 52));
        buttonPlunderAll2.setName("buttonPlunderAll2");
        buttonPlunderAll2.setSize(new FormSize(32, 22));
        buttonPlunderAll2.setTabIndex(127);
        buttonPlunderAll2.setText("All");
        buttonPlunderAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty2
        buttonPlunderQty2.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty2.setLocation(new Point(68, 52));
        buttonPlunderQty2.setName("buttonPlunderQty2");
        buttonPlunderQty2.setSize(new FormSize(28, 22));
        buttonPlunderQty2.setTabIndex(126);
        buttonPlunderQty2.setText("88");
        buttonPlunderQty2.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll1
        buttonPlunderAll1.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll1.setLocation(new Point(100, 28));
        buttonPlunderAll1.setName("buttonPlunderAll1");
        buttonPlunderAll1.setSize(new FormSize(32, 22));
        buttonPlunderAll1.setTabIndex(125);
        buttonPlunderAll1.setText("All");
        buttonPlunderAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty1
        buttonPlunderQty1.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty1.setLocation(new Point(68, 28));
        buttonPlunderQty1.setName("buttonPlunderQty1");
        buttonPlunderQty1.setSize(new FormSize(28, 22));
        buttonPlunderQty1.setTabIndex(124);
        buttonPlunderQty1.setText("88");
        buttonPlunderQty1.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderAll0
        buttonPlunderAll0.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll0.setLocation(new Point(100, 4));
        buttonPlunderAll0.setName("buttonPlunderAll0");
        buttonPlunderAll0.setSize(new FormSize(32, 22));
        buttonPlunderAll0.setTabIndex(123);
        buttonPlunderAll0.setText("All");
        buttonPlunderAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
            }
        });
        // buttonPlunderQty0
        buttonPlunderQty0.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQty0.setLocation(new Point(68, 4));
        buttonPlunderQty0.setName("buttonPlunderQty0");
        buttonPlunderQty0.setSize(new FormSize(28, 22));
        buttonPlunderQty0.setTabIndex(122);
        buttonPlunderQty0.setText("88");
        buttonPlunderQty0.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonPlunder_Click(sender, e);
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
        // buttonDone
        buttonDone.setDialogResult(DialogResult.Cancel);
        buttonDone.setFlatStyle(FlatStyle.Flat);
        buttonDone.setLocation(new Point(87, 252));
        buttonDone.setName("buttonDone");
        buttonDone.setSize(new FormSize(44, 22));
        buttonDone.setTabIndex(154);
        buttonDone.setText("Done");
        // buttonJettison
        buttonJettison.setFlatStyle(FlatStyle.Flat);
        buttonJettison.setLocation(new Point(150, 24));
        buttonJettison.setName("buttonJettison");
        buttonJettison.setSize(new FormSize(53, 22));
        buttonJettison.setTabIndex(155);
        buttonJettison.setText("Jettison");
        buttonJettison.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonJettison_Click();
            }
        });
        // FormPlunder
        setAcceptButton(buttonDone);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonDone);
        setClientSize(new FormSize(230, 283));
        Controls.add(buttonJettison);
        Controls.add(buttonDone);
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
        Controls.add(buttonPlunderAll9);
        Controls.add(buttonPlunderQty9);
        Controls.add(buttonPlunderAll8);
        Controls.add(buttonPlunderQty8);
        Controls.add(buttonPlunderAll7);
        Controls.add(buttonPlunderQty7);
        Controls.add(buttonPlunderAll6);
        Controls.add(buttonPlunderQty6);
        Controls.add(buttonPlunderAll5);
        Controls.add(buttonPlunderQty5);
        Controls.add(buttonPlunderAll4);
        Controls.add(buttonPlunderQty4);
        Controls.add(buttonPlunderAll3);
        Controls.add(buttonPlunderQty3);
        Controls.add(buttonPlunderAll2);
        Controls.add(buttonPlunderQty2);
        Controls.add(buttonPlunderAll1);
        Controls.add(buttonPlunderQty1);
        Controls.add(buttonPlunderAll0);
        Controls.add(buttonPlunderQty0);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormPlunder");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Plunder Cargo");
        ResumeLayout(false);
        PerformLayout();
        buttonPlunderQty = new Button[]{
                buttonPlunderQty0, buttonPlunderQty1, buttonPlunderQty2, buttonPlunderQty3, buttonPlunderQty4,
                buttonPlunderQty5, buttonPlunderQty6, buttonPlunderQty7, buttonPlunderQty8, buttonPlunderQty9
        };
        Button[] buttonPlunderAll = new Button[]{
                buttonPlunderAll0, buttonPlunderAll1, buttonPlunderAll2, buttonPlunderAll3, buttonPlunderAll4,
                buttonPlunderAll5, buttonPlunderAll6, buttonPlunderAll7, buttonPlunderAll8, buttonPlunderAll9
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
        for (int i = 0; i < buttonPlunderQty.length; i++) {
            buttonPlunderQty[i].setText("" + opp.Cargo()[i]);
        }
        lblBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
    }

    private void buttonJettison_Click() {
        (new FormJettison()).ShowDialog(this);
    }

    private void buttonPlunder_Click(Object sender, EventArgs e) {
        String name = ((Button) sender).getName();
        boolean all = !name.contains("Qty");
        int index = Integer.parseInt(name.substring(name.length() - 1));
        Plunder(index, all);
    }
}
