package org.spacetrader.ui;

import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.winforms.Font;
import org.winforms.controls.Button;
import org.winforms.controls.Dialog;
import org.winforms.controls.Label;
import org.winforms.controls.PictureBox;
import org.winforms.enums.*;

import java.awt.*;


public class DialogCosts extends Dialog {

    public DialogCosts() {
        Button buttonClose = new Button();
        Label labelMerc = new Label();
        Label labelIns = new Label();
        Label labelInt = new Label();
        Label labelTax = new Label();
        Label labelTotal = new Label();
        Label labelTotalLabel = new Label();
        Label labelTaxLabel = new Label();
        Label labelIntLabel = new Label();
        Label labelMercLabel = new Label();
        Label labelInsLabel = new Label();
        PictureBox pictureLine = new PictureBox();
        suspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new Dimension(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelMerc
        labelMerc.setLocation(new Point(104, 8));
        labelMerc.setName("labelMerc");
        labelMerc.setSize(new Dimension(39, 13));
        labelMerc.setTabIndex(36);
        labelMerc.setText("888 cr.");
        labelMerc.textAlignment = ContentAlignment.TopRight;
        // labelIns
        labelIns.setLocation(new Point(104, 24));
        labelIns.setName("labelIns");
        labelIns.setSize(new Dimension(39, 13));
        labelIns.setTabIndex(40);
        labelIns.setText("888 cr.");
        labelIns.textAlignment = ContentAlignment.TopRight;
        // labelInt
        labelInt.setLocation(new Point(104, 40));
        labelInt.setName("labelInt");
        labelInt.setSize(new Dimension(39, 13));
        labelInt.setTabIndex(44);
        labelInt.setText("888 cr.");
        labelInt.textAlignment = ContentAlignment.TopRight;
        // labelTax
        labelTax.setLocation(new Point(104, 56));
        labelTax.setName("labelTax");
        labelTax.setSize(new Dimension(39, 13));
        labelTax.setTabIndex(48);
        labelTax.setText("888 cr.");
        labelTax.textAlignment = ContentAlignment.TopRight;
        // labelTotal
        labelTotal.setLocation(new Point(104, 79));
        labelTotal.setName("labelTotal");
        labelTotal.setSize(new Dimension(39, 13));
        labelTotal.setTabIndex(52);
        labelTotal.setText("888 cr.");
        labelTotal.textAlignment = ContentAlignment.TopRight;
        // labelTotalLabel
        labelTotalLabel.setAutoSize(true);
        labelTotalLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTotalLabel.setLocation(new Point(8, 79));
        labelTotalLabel.setName("labelTotalLabel");
        labelTotalLabel.setSize(new Dimension(34, 13));
        labelTotalLabel.setTabIndex(7);
        labelTotalLabel.setText("Total:");
        // labelTaxLabel
        labelTaxLabel.setAutoSize(true);
        labelTaxLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTaxLabel.setLocation(new Point(8, 56));
        labelTaxLabel.setName("labelTaxLabel");
        labelTaxLabel.setSize(new Dimension(84, 13));
        labelTaxLabel.setTabIndex(6);
        labelTaxLabel.setText("Wormhole Tax:");
        // labelIntLabel
        labelIntLabel.setAutoSize(true);
        labelIntLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelIntLabel.setLocation(new Point(8, 40));
        labelIntLabel.setName("labelIntLabel");
        labelIntLabel.setSize(new Dimension(47, 13));
        labelIntLabel.setTabIndex(5);
        labelIntLabel.setText("Interest:");
        // labelMercLabel
        labelMercLabel.setAutoSize(true);
        labelMercLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercLabel.setLocation(new Point(8, 8));
        labelMercLabel.setName("labelMercLabel");
        labelMercLabel.setSize(new Dimension(72, 13));
        labelMercLabel.setTabIndex(4);
        labelMercLabel.setText("Mercenaries:");
        // labelInsLabel
        labelInsLabel.setAutoSize(true);
        labelInsLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelInsLabel.setLocation(new Point(8, 24));
        labelInsLabel.setName("labelInsLabel");
        labelInsLabel.setSize(new Dimension(59, 13));
        labelInsLabel.setTabIndex(3);
        labelInsLabel.setText("Insurance:");
        // pictureLine
        pictureLine.setBackgroundColor(Color.darkGray);
        pictureLine.setLocation(new Point(6, 73));
        pictureLine.setName("pictureLine");
        pictureLine.setSize(new Dimension(138, 1));
        pictureLine.setTabIndex(134);
        pictureLine.setTabStop(false);
        // FormCosts
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new Dimension(148, 99));
        Controls.addAll(pictureLine, labelTotal, labelTax, labelInt, labelIns, labelMerc, buttonClose, labelInsLabel, labelTotalLabel, labelTaxLabel, labelIntLabel, labelMercLabel);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormCosts");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Cost Specification");
        resumeLayout(false);
        Game game = Game.getCurrentGame();
        labelMerc.setText(Functions.FormatMoney(game.MercenaryCosts()));
        labelIns.setText(Functions.FormatMoney(game.InsuranceCosts()));
        labelInt.setText(Functions.FormatMoney(game.InterestCosts()));
        labelTax.setText(Functions.FormatMoney(game.WormholeCosts()));
        labelTotal.setText(Functions.FormatMoney(game.CurrentCosts()));
    }

}
