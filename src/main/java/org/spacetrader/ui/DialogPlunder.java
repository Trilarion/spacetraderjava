package org.spacetrader.ui;

import org.spacetrader.controller.Game;
import org.spacetrader.model.ship.Ship;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.Label;
import org.winforms.dialog.DialogResult;
import org.winforms.style.FlatStyle;
import org.winforms.style.FormBorderStyle;
import org.winforms.alignment.FormStartPosition;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import java.awt.*;


public class DialogPlunder extends Dialog {
    private final Game game = Game.getCurrentGame();
    private final Button[] buttonPlunderQuantity;
    private final Label labelBays;

    public DialogPlunder() {
        final Button buttonPlunderAll9 = new Button();
        final Button buttonPlunderQuantity9 = new Button();
        final Button buttonPlunderAll8 = new Button();
        final Button buttonPlunderQuantity8 = new Button();
        final Button buttonPlunderAll7 = new Button();
        final Button buttonPlunderQuantity7 = new Button();
        final Button buttonPlunderAll6 = new Button();
        final Button buttonPlunderQuantity6 = new Button();
        final Button buttonPlunderAll5 = new Button();
        final Button buttonPlunderQuantity5 = new Button();
        final Button buttonPlunderAll4 = new Button();
        final Button buttonPlunderQuantity4 = new Button();
        final Button buttonPlunderAll3 = new Button();
        final Button buttonPlunderQuantity3 = new Button();
        final Button buttonPlunderAll2 = new Button();
        final Button buttonPlunderQuantity2 = new Button();
        final Button buttonPlunderAll1 = new Button();
        final Button buttonPlunderQuantity1 = new Button();
        final Button buttonPlunderAll0 = new Button();
        final Button buttonPlunderQuantity0 = new Button();
        final Label labelTradeCommodity9 = new Label();
        final Label labelTradeCommodity8 = new Label();
        final Label labelTradeCommodity2 = new Label();
        final Label labelTradeCommodity0 = new Label();
        final Label labelTradeCommodity1 = new Label();
        final Label labelTradeCommodity6 = new Label();
        final Label labelTradeCommodity5 = new Label();
        final Label labelTradeCommodity4 = new Label();
        final Label labelTradeCommodity3 = new Label();
        final Label labelTradeCommodity7 = new Label();
        final Label labelBaysLabel = new Label();
        labelBays = new Label();
        final Button buttonDone = new Button();
        final Button buttonJettison = new Button();
        suspendLayout();
        // buttonPlunderAll9
        buttonPlunderAll9.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll9.setLocation(new Point(100, 220));
        buttonPlunderAll9.setName("buttonPlunderAll9");
        buttonPlunderAll9.setSize(new Dimension(32, 22));
        buttonPlunderAll9.setTabIndex(141);
        buttonPlunderAll9.setText("All");
        buttonPlunderAll9.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity9
        buttonPlunderQuantity9.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity9.setLocation(new Point(68, 220));
        buttonPlunderQuantity9.setName("buttonPlunderQuantity9");
        buttonPlunderQuantity9.setSize(new Dimension(28, 22));
        buttonPlunderQuantity9.setTabIndex(140);
        buttonPlunderQuantity9.setText("88");
        buttonPlunderQuantity9.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll8
        buttonPlunderAll8.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll8.setLocation(new Point(100, 196));
        buttonPlunderAll8.setName("buttonPlunderAll8");
        buttonPlunderAll8.setSize(new Dimension(32, 22));
        buttonPlunderAll8.setTabIndex(139);
        buttonPlunderAll8.setText("All");
        buttonPlunderAll8.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity8
        buttonPlunderQuantity8.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity8.setLocation(new Point(68, 196));
        buttonPlunderQuantity8.setName("buttonPlunderQuantity8");
        buttonPlunderQuantity8.setSize(new Dimension(28, 22));
        buttonPlunderQuantity8.setTabIndex(138);
        buttonPlunderQuantity8.setText("88");
        buttonPlunderQuantity8.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll7
        buttonPlunderAll7.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll7.setLocation(new Point(100, 172));
        buttonPlunderAll7.setName("buttonPlunderAll7");
        buttonPlunderAll7.setSize(new Dimension(32, 22));
        buttonPlunderAll7.setTabIndex(137);
        buttonPlunderAll7.setText("All");
        buttonPlunderAll7.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity7
        buttonPlunderQuantity7.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity7.setLocation(new Point(68, 172));
        buttonPlunderQuantity7.setName("buttonPlunderQuantity7");
        buttonPlunderQuantity7.setSize(new Dimension(28, 22));
        buttonPlunderQuantity7.setTabIndex(136);
        buttonPlunderQuantity7.setText("88");
        buttonPlunderQuantity7.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll6
        buttonPlunderAll6.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll6.setLocation(new Point(100, 148));
        buttonPlunderAll6.setName("buttonPlunderAll6");
        buttonPlunderAll6.setSize(new Dimension(32, 22));
        buttonPlunderAll6.setTabIndex(135);
        buttonPlunderAll6.setText("All");
        buttonPlunderAll6.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity6
        buttonPlunderQuantity6.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity6.setLocation(new Point(68, 148));
        buttonPlunderQuantity6.setName("buttonPlunderQuantity6");
        buttonPlunderQuantity6.setSize(new Dimension(28, 22));
        buttonPlunderQuantity6.setTabIndex(134);
        buttonPlunderQuantity6.setText("88");
        buttonPlunderQuantity6.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll5
        buttonPlunderAll5.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll5.setLocation(new Point(100, 124));
        buttonPlunderAll5.setName("buttonPlunderAll5");
        buttonPlunderAll5.setSize(new Dimension(32, 22));
        buttonPlunderAll5.setTabIndex(133);
        buttonPlunderAll5.setText("All");
        buttonPlunderAll5.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity5
        buttonPlunderQuantity5.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity5.setLocation(new Point(68, 124));
        buttonPlunderQuantity5.setName("buttonPlunderQuantity5");
        buttonPlunderQuantity5.setSize(new Dimension(28, 22));
        buttonPlunderQuantity5.setTabIndex(132);
        buttonPlunderQuantity5.setText("88");
        buttonPlunderQuantity5.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll4
        buttonPlunderAll4.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll4.setLocation(new Point(100, 100));
        buttonPlunderAll4.setName("buttonPlunderAll4");
        buttonPlunderAll4.setSize(new Dimension(32, 22));
        buttonPlunderAll4.setTabIndex(131);
        buttonPlunderAll4.setText("All");
        buttonPlunderAll4.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity4
        buttonPlunderQuantity4.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity4.setLocation(new Point(68, 100));
        buttonPlunderQuantity4.setName("buttonPlunderQuantity4");
        buttonPlunderQuantity4.setSize(new Dimension(28, 22));
        buttonPlunderQuantity4.setTabIndex(130);
        buttonPlunderQuantity4.setText("88");
        buttonPlunderQuantity4.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll3
        buttonPlunderAll3.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll3.setLocation(new Point(100, 76));
        buttonPlunderAll3.setName("buttonPlunderAll3");
        buttonPlunderAll3.setSize(new Dimension(32, 22));
        buttonPlunderAll3.setTabIndex(129);
        buttonPlunderAll3.setText("All");
        buttonPlunderAll3.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity3
        buttonPlunderQuantity3.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity3.setLocation(new Point(68, 76));
        buttonPlunderQuantity3.setName("buttonPlunderQuantity3");
        buttonPlunderQuantity3.setSize(new Dimension(28, 22));
        buttonPlunderQuantity3.setTabIndex(128);
        buttonPlunderQuantity3.setText("88");
        buttonPlunderQuantity3.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll2
        buttonPlunderAll2.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll2.setLocation(new Point(100, 52));
        buttonPlunderAll2.setName("buttonPlunderAll2");
        buttonPlunderAll2.setSize(new Dimension(32, 22));
        buttonPlunderAll2.setTabIndex(127);
        buttonPlunderAll2.setText("All");
        buttonPlunderAll2.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity2
        buttonPlunderQuantity2.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity2.setLocation(new Point(68, 52));
        buttonPlunderQuantity2.setName("buttonPlunderQuantity2");
        buttonPlunderQuantity2.setSize(new Dimension(28, 22));
        buttonPlunderQuantity2.setTabIndex(126);
        buttonPlunderQuantity2.setText("88");
        buttonPlunderQuantity2.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll1
        buttonPlunderAll1.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll1.setLocation(new Point(100, 28));
        buttonPlunderAll1.setName("buttonPlunderAll1");
        buttonPlunderAll1.setSize(new Dimension(32, 22));
        buttonPlunderAll1.setTabIndex(125);
        buttonPlunderAll1.setText("All");
        buttonPlunderAll1.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity1
        buttonPlunderQuantity1.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity1.setLocation(new Point(68, 28));
        buttonPlunderQuantity1.setName("buttonPlunderQuantity1");
        buttonPlunderQuantity1.setSize(new Dimension(28, 22));
        buttonPlunderQuantity1.setTabIndex(124);
        buttonPlunderQuantity1.setText("88");
        buttonPlunderQuantity1.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderAll0
        buttonPlunderAll0.setFlatStyle(FlatStyle.Flat);
        buttonPlunderAll0.setLocation(new Point(100, 4));
        buttonPlunderAll0.setName("buttonPlunderAll0");
        buttonPlunderAll0.setSize(new Dimension(32, 22));
        buttonPlunderAll0.setTabIndex(123);
        buttonPlunderAll0.setText("All");
        buttonPlunderAll0.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // buttonPlunderQuantity0
        buttonPlunderQuantity0.setFlatStyle(FlatStyle.Flat);
        buttonPlunderQuantity0.setLocation(new Point(68, 4));
        buttonPlunderQuantity0.setName("buttonPlunderQuantity0");
        buttonPlunderQuantity0.setSize(new Dimension(28, 22));
        buttonPlunderQuantity0.setTabIndex(122);
        buttonPlunderQuantity0.setText("88");
        buttonPlunderQuantity0.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonPlunder_Click(sender, data);
            }
        });
        // labelTradeCommodity9
        labelTradeCommodity9.setAutoSize(true);
        labelTradeCommodity9.setLocation(new Point(8, 224));
        labelTradeCommodity9.setName("labelTradeCommodity9");
        labelTradeCommodity9.setSize(new Dimension(41, 13));
        labelTradeCommodity9.setTabIndex(151);
        labelTradeCommodity9.setText("Robots");
        // labelTradeCommodity8
        labelTradeCommodity8.setAutoSize(true);
        labelTradeCommodity8.setLocation(new Point(8, 200));
        labelTradeCommodity8.setName("labelTradeCommodity8");
        labelTradeCommodity8.setSize(new Dimension(52, 13));
        labelTradeCommodity8.setTabIndex(150);
        labelTradeCommodity8.setText("Narcotics");
        // labelTradeCommodity2
        labelTradeCommodity2.setAutoSize(true);
        labelTradeCommodity2.setLocation(new Point(8, 56));
        labelTradeCommodity2.setName("labelTradeCommodity2");
        labelTradeCommodity2.setSize(new Dimension(31, 13));
        labelTradeCommodity2.setTabIndex(149);
        labelTradeCommodity2.setText("Food");
        // labelTradeCommodity0
        labelTradeCommodity0.setAutoSize(true);
        labelTradeCommodity0.setLocation(new Point(8, 8));
        labelTradeCommodity0.setName("labelTradeCommodity0");
        labelTradeCommodity0.setSize(new Dimension(36, 13));
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
        labelTradeCommodity5.setSize(new Dimension(46, 13));
        labelTradeCommodity5.setTabIndex(145);
        labelTradeCommodity5.setText("Firearms");
        // labelTradeCommodity4
        labelTradeCommodity4.setAutoSize(true);
        labelTradeCommodity4.setLocation(new Point(8, 104));
        labelTradeCommodity4.setName("labelTradeCommodity4");
        labelTradeCommodity4.setSize(new Dimension(40, 13));
        labelTradeCommodity4.setTabIndex(144);
        labelTradeCommodity4.setText("Games");
        // labelTradeCommodity3
        labelTradeCommodity3.setAutoSize(true);
        labelTradeCommodity3.setLocation(new Point(8, 80));
        labelTradeCommodity3.setName("labelTradeCommodity3");
        labelTradeCommodity3.setSize(new Dimension(24, 13));
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
        labelBays.setSize(new Dimension(48, 13));
        labelBays.setTabIndex(153);
        labelBays.setText("888/888");
        // buttonDone
        buttonDone.setDialogResult(DialogResult.Cancel);
        buttonDone.setFlatStyle(FlatStyle.Flat);
        buttonDone.setLocation(new Point(87, 252));
        buttonDone.setName("buttonDone");
        buttonDone.setSize(new Dimension(44, 22));
        buttonDone.setTabIndex(154);
        buttonDone.setText("Done");
        // buttonJettison
        buttonJettison.setFlatStyle(FlatStyle.Flat);
        buttonJettison.setLocation(new Point(150, 24));
        buttonJettison.setName("buttonJettison");
        buttonJettison.setSize(new Dimension(53, 22));
        buttonJettison.setTabIndex(155);
        buttonJettison.setText("Jettison");
        buttonJettison.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                buttonJettison_Click();
            }
        });
        // FormPlunder
        setAcceptButton(buttonDone);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonDone);
        setClientSize(new Dimension(230, 283));
        Controls.add(buttonJettison);
        Controls.add(buttonDone);
        Controls.add(labelBays);
        Controls.add(labelBaysLabel);
        Controls.add(labelTradeCommodity9);
        Controls.add(labelTradeCommodity8);
        Controls.add(labelTradeCommodity2);
        Controls.add(labelTradeCommodity0);
        Controls.add(labelTradeCommodity1);
        Controls.add(labelTradeCommodity6);
        Controls.add(labelTradeCommodity5);
        Controls.add(labelTradeCommodity4);
        Controls.add(labelTradeCommodity3);
        Controls.add(labelTradeCommodity7);
        Controls.add(buttonPlunderAll9);
        Controls.add(buttonPlunderQuantity9);
        Controls.add(buttonPlunderAll8);
        Controls.add(buttonPlunderQuantity8);
        Controls.add(buttonPlunderAll7);
        Controls.add(buttonPlunderQuantity7);
        Controls.add(buttonPlunderAll6);
        Controls.add(buttonPlunderQuantity6);
        Controls.add(buttonPlunderAll5);
        Controls.add(buttonPlunderQuantity5);
        Controls.add(buttonPlunderAll4);
        Controls.add(buttonPlunderQuantity4);
        Controls.add(buttonPlunderAll3);
        Controls.add(buttonPlunderQuantity3);
        Controls.add(buttonPlunderAll2);
        Controls.add(buttonPlunderQuantity2);
        Controls.add(buttonPlunderAll1);
        Controls.add(buttonPlunderQuantity1);
        Controls.add(buttonPlunderAll0);
        Controls.add(buttonPlunderQuantity0);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormPlunder");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Plunder Cargo");
        resumeLayout(false);
        PerformLayout();
        buttonPlunderQuantity = new Button[]{
                buttonPlunderQuantity0, buttonPlunderQuantity1, buttonPlunderQuantity2, buttonPlunderQuantity3, buttonPlunderQuantity4,
                buttonPlunderQuantity5, buttonPlunderQuantity6, buttonPlunderQuantity7, buttonPlunderQuantity8, buttonPlunderQuantity9
        };
        final Button[] buttonPlunderAll = {
                buttonPlunderAll0, buttonPlunderAll1, buttonPlunderAll2, buttonPlunderAll3, buttonPlunderAll4,
                buttonPlunderAll5, buttonPlunderAll6, buttonPlunderAll7, buttonPlunderAll8, buttonPlunderAll9
        };
        UpdateAll();
    }


    private void Plunder(final int tradeItem, final boolean all) {
        game.CargoPlunder(tradeItem, all, this);
        UpdateAll();
    }

    private void UpdateAll() {
        final Ship ship = game.Commander().getShip();
        final Ship opp = game.getOpponent();
        for (int i = 0; i < buttonPlunderQuantity.length; i++) {
            buttonPlunderQuantity[i].setText("" + opp.Cargo()[i]);
        }
        labelBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
    }

    private void buttonJettison_Click() {
        (new DialogJettison()).ShowDialog(this);
    }

    private void buttonPlunder_Click(final Object sender, final EventData e) {
        final String name = ((Button) sender).getName();
        final boolean all = !name.contains("Quantity");
        final int index = Integer.parseInt(name.substring(name.length() - 1));
        Plunder(index, all);
    }
}
