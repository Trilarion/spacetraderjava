package org.spacetrader.ui;

import org.spacetrader.model.crew.Commander;
import org.spacetrader.controller.Game;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;
import java.util.Arrays;


public class FormBuyRepairs extends wfForm {
    private final NumericUpDown numAmount;

    public FormBuyRepairs() {
        Label labelQuestion = new Label();
        numAmount = new NumericUpDown();
        Button buttonOk = new Button();
        Button buttonMax = new Button();
        Button buttonNothing = new Button();
                SuspendLayout();
        // labelQuestion
        labelQuestion.setAutoSize(true);
        labelQuestion.setLocation(new Point(8, 8));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new SizeF(13, 227));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to spend on repairs?");
        // numAmount
        numAmount.setLocation(new Point(232, 6));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new SizeF(20, 44));
        numAmount.setTabIndex(1);
        numAmount.setValue(888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(69, 32));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new SizeF(22, 41));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.OK);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(117, 32));
        buttonMax.setName("buttonMax");
        buttonMax.setSize(new SizeF(22, 41));
        buttonMax.setTabIndex(3);
        buttonMax.setText("Max");
        // buttonNothing
        buttonNothing.setDialogResult(DialogResult.Cancel);
        buttonNothing.setFlatStyle(FlatStyle.Flat);
        buttonNothing.setLocation(new Point(165, 32));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new SizeF(22, 53));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // FormBuyRepairs
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonNothing);
        setClientSize(new SizeF(63, 286));
        setControlBox(false);
        Controls.addAll(Arrays.asList(buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormBuyRepairs");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Hull Repair");
                ResumeLayout(false);
        Game game = Game.getCurrentGame();
        Commander commander = game.Commander();
        numAmount.setMaximum(Math.min(commander.getCash(), (commander.getShip().HullStrength() - commander.getShip().getHull()) * commander.getShip().getRepairCost()));
        numAmount.setValue(numAmount.getMaximum());
    }

    // TODO This action is not connected in the .NET version either.
    private void buttonMax_Click(Object sender, EventData e) {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}