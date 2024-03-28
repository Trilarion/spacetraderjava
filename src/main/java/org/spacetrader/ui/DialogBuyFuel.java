package org.spacetrader.ui;

import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.winforms.widget.*;
import org.winforms.dialog.DialogResult;
import org.winforms.style.FlatStyle;
import org.winforms.style.FormBorderStyle;
import org.winforms.alignment.FormStartPosition;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.Label;

import java.awt.*;
import java.util.Arrays;


public class DialogBuyFuel extends Dialog {
    private final Spinner numAmount;

    public DialogBuyFuel() {
        Label labelQuestion = new Label();
        numAmount = new Spinner();
        Button buttonOk = new Button();
        Button buttonMax = new Button();
        Button buttonNothing = new Button();
        // labelQuestion
        labelQuestion.setAutoSize(true);
        labelQuestion.setLocation(new Point(8, 8));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new Dimension(211, 13));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to spend on fuel?");
        // numAmount
        numAmount.setLocation(new Point(216, 6));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new Dimension(44, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.Ok);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(61, 32));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new Dimension(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.Ok);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(109, 32));
        buttonMax.setName("buttonMax");
        buttonMax.setSize(new Dimension(41, 22));
        buttonMax.setTabIndex(3);
        buttonMax.setText("Max");
        buttonMax.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonMax_Click();
            }
        });
        // buttonNothing
        buttonNothing.setDialogResult(DialogResult.Cancel);
        buttonNothing.setFlatStyle(FlatStyle.Flat);
        buttonNothing.setLocation(new Point(157, 32));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new Dimension(53, 22));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // FormBuyFuel
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonNothing);
        setClientSize(new Dimension(270, 63));
        setControlBox(false);
        Controls.addAll(Arrays.asList(buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormBuyFuel");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Buy Fuel");
        resumeLayout(false);
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
