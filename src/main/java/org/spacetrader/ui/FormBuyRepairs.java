package org.spacetrader.ui;

import org.spacetrader.controller.Commander;
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
        ((ISupportInitialize) (numAmount)).beginInit();
        SuspendLayout();
        // labelQuestion
        labelQuestion.setAutoSize(true);
        labelQuestion.setLocation(new Point(8, 8));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new FormSize(227, 13));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to spend on repairs?");
        // numAmount
        numAmount.setLocation(new Point(232, 6));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new FormSize(44, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(69, 32));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new FormSize(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.OK);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(117, 32));
        buttonMax.setName("buttonMax");
        buttonMax.setSize(new FormSize(41, 22));
        buttonMax.setTabIndex(3);
        buttonMax.setText("Max");
        // buttonNothing
        buttonNothing.setDialogResult(DialogResult.Cancel);
        buttonNothing.setFlatStyle(FlatStyle.Flat);
        buttonNothing.setLocation(new Point(165, 32));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new FormSize(53, 22));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // FormBuyRepairs
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonNothing);
        setClientSize(new FormSize(286, 63));
        setControlBox(false);
        Controls.addAll(Arrays.asList(buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormBuyRepairs");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Hull Repair");
        ((ISupportInitialize) (numAmount)).endInit();
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
