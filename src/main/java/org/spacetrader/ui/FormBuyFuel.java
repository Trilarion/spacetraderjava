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


public class FormBuyFuel extends wfForm {
    private final NumericUpDown numAmount;

    public FormBuyFuel() {
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
        labelQuestion.setSize(new FormSize(211, 13));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to spend on fuel?");
        // numAmount
        numAmount.setLocation(new Point(216, 6));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new FormSize(44, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(61, 32));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new FormSize(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.OK);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(109, 32));
        buttonMax.setName("buttonMax");
        buttonMax.setSize(new FormSize(41, 22));
        buttonMax.setTabIndex(3);
        buttonMax.setText("Max");
        buttonMax.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonMax_Click();
            }
        });
        // buttonNothing
        buttonNothing.setDialogResult(DialogResult.Cancel);
        buttonNothing.setFlatStyle(FlatStyle.Flat);
        buttonNothing.setLocation(new Point(157, 32));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new FormSize(53, 22));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // FormBuyFuel
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonNothing);
        setClientSize(new FormSize(270, 63));
        setControlBox(false);
        Controls.addAll(Arrays.asList(buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormBuyFuel");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Buy Fuel");
        ((ISupportInitialize) (numAmount)).endInit();
        ResumeLayout(false);
        Game game = Game.getCurrentGame();
        Commander commander = game.Commander();
        numAmount.setMaximum(Math.min(commander.getCash(), (commander.getShip().FuelTanks() - commander.getShip().getFuel()) * commander.getShip().getFuelCost()));
        numAmount.setValue(numAmount.getMaximum());
    }


    private void buttonMax_Click() {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
