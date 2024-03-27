package org.spacetrader.ui;

import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.Label;
import org.winforms.widget.Spinner;
import org.winforms.dialog.DialogResult;
import org.winforms.style.FlatStyle;
import org.winforms.style.FormBorderStyle;
import org.winforms.alignment.FormStartPosition;
import org.winforms.event.EventData;

import java.awt.*;
import java.util.Arrays;


public class DialogBuyRepairs extends Dialog {
    private final Spinner numAmount;

    public DialogBuyRepairs() {
        final Label labelQuestion = new Label();
        numAmount = new Spinner();
        final Button buttonOk = new Button();
        final Button buttonMax = new Button();
        final Button buttonNothing = new Button();
        suspendLayout();
        // labelQuestion
        labelQuestion.setAutoSize(true);
        labelQuestion.setLocation(new Point(8, 8));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new Dimension(227, 13));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to spend on repairs?");
        // numAmount
        numAmount.setLocation(new Point(232, 6));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new Dimension(44, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(69, 32));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new Dimension(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.OK);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(117, 32));
        buttonMax.setName("buttonMax");
        buttonMax.setSize(new Dimension(41, 22));
        buttonMax.setTabIndex(3);
        buttonMax.setText("Max");
        // buttonNothing
        buttonNothing.setDialogResult(DialogResult.Cancel);
        buttonNothing.setFlatStyle(FlatStyle.Flat);
        buttonNothing.setLocation(new Point(165, 32));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new Dimension(53, 22));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // FormBuyRepairs
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonNothing);
        setClientSize(new Dimension(286, 63));
        setControlBox(false);
        Controls.addAll(Arrays.asList(buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormBuyRepairs");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Hull Repair");
        resumeLayout(false);
        final Game game = Game.getCurrentGame();
        final Commander commander = game.Commander();
        numAmount.setMaximum(Math.min(commander.getCash(), (commander.getShip().HullStrength() - commander.getShip().getHull()) * commander.getShip().getRepairCost()));
        numAmount.setValue(numAmount.getMaximum());
    }

    // TODO This action is not connected in the .NET version either.
    private void buttonMax_Click(final Object sender, final EventData e) {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
