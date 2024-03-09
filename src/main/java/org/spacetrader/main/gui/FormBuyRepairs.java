package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.DialogResult;
import org.jwinforms.enums.FlatStyle;
import org.jwinforms.enums.FormBorderStyle;
import org.jwinforms.enums.FormStartPosition;
import org.spacetrader.main.Commander;
import org.spacetrader.main.Game;

import java.awt.*;
import java.util.Arrays;


public class FormBuyRepairs extends WinformForm {
    private final Game game = Game.CurrentGame();
    private NumericUpDown numAmount;

    public FormBuyRepairs() {
        Label lblQuestion = new Label();
        numAmount = new NumericUpDown();
        Button btnOk = new Button();
        Button btnMax = new Button();
        Button btnNothing = new Button();
        ((ISupportInitialize) (numAmount)).BeginInit();
        SuspendLayout();
        // lblQuestion
        lblQuestion.setAutoSize(true);
        lblQuestion.setLocation(new Point(8, 8));
        lblQuestion.setName("lblQuestion");
        lblQuestion.setSize(new FormSize(227, 13));
        lblQuestion.setTabIndex(3);
        lblQuestion.setText("How much do you want to spend on repairs?");
        // numAmount
        numAmount.setLocation(new Point(232, 6));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new FormSize(44, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(888);
        // btnOk
        btnOk.setDialogResult(DialogResult.OK);
        btnOk.setFlatStyle(FlatStyle.Flat);
        btnOk.setLocation(new Point(69, 32));
        btnOk.setName("btnOk");
        btnOk.setSize(new FormSize(41, 22));
        btnOk.setTabIndex(2);
        btnOk.setText("Ok");
        // btnMax
        btnMax.setDialogResult(DialogResult.OK);
        btnMax.setFlatStyle(FlatStyle.Flat);
        btnMax.setLocation(new Point(117, 32));
        btnMax.setName("btnMax");
        btnMax.setSize(new FormSize(41, 22));
        btnMax.setTabIndex(3);
        btnMax.setText("Max");
        // btnNothing
        btnNothing.setDialogResult(DialogResult.Cancel);
        btnNothing.setFlatStyle(FlatStyle.Flat);
        btnNothing.setLocation(new Point(165, 32));
        btnNothing.setName("btnNothing");
        btnNothing.setSize(new FormSize(53, 22));
        btnNothing.setTabIndex(4);
        btnNothing.setText("Nothing");
        // FormBuyRepairs
        setAcceptButton(btnOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnNothing);
        setClientSize(new FormSize(286, 63));
        setControlBox(false);
        Controls.addAll(Arrays.asList(btnNothing, btnMax, btnOk, numAmount, lblQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormBuyRepairs");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Hull Repair");
        ((ISupportInitialize) (numAmount)).EndInit();
        ResumeLayout(false);
        Commander cmdr = game.Commander();
        numAmount.setMaximum(Math.min(cmdr.getCash(), (cmdr.getShip().HullStrength() - cmdr.getShip().getHull()) * cmdr.getShip().getRepairCost()));
        numAmount.setValue(numAmount.getMaximum());
    }

    // TODO This action is not connected in the .NET version either.
    private void btnMax_Click(Object sender, EventArgs e) {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
