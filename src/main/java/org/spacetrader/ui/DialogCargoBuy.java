package org.spacetrader.ui;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.cargo.CargoBuyOperation;
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
import org.winforms.event.EventHandler;

import java.awt.*;


public class DialogCargoBuy extends Dialog {
    private final Spinner numAmount;

    public DialogCargoBuy(int item, int maxAmount, CargoBuyOperation op) {
        Label labelQuestion = new Label();
        Label labelStatement = new Label();
        numAmount = new Spinner();
        Button buttonOk = new Button();
        Button buttonAll = new Button();
        Button buttonNone = new Button();
        Label labelAvailable = new Label();
        Label labelAfford = new Label();
        suspendLayout();
        // labelQuestion
        labelQuestion.setAutoSize(true);
        labelQuestion.setLocation(new Point(8, 24));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new Dimension(161, 16));
        labelQuestion.setTabIndex(1);
        labelQuestion.setText("How many do you want to buy?");
        // labelStatement
        labelStatement.setLocation(new Point(8, 8));
        labelStatement.setName("labelStatement");
        labelStatement.setSize(new Dimension(326, 13));
        labelStatement.setTabIndex(3);
        labelStatement.setText("The trader wants to sell Machines for the price of 8,888 cr. each.");
        // numAmount
        numAmount.setLocation(new Point(168, 22));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new Dimension(44, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(1);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(95, 48));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new Dimension(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonAll
        buttonAll.setDialogResult(DialogResult.OK);
        buttonAll.setFlatStyle(FlatStyle.Flat);
        buttonAll.setLocation(new Point(143, 48));
        buttonAll.setName("buttonAll");
        buttonAll.setSize(new Dimension(41, 22));
        buttonAll.setTabIndex(3);
        buttonAll.setText("All");
        buttonAll.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonAll_Click(sender, data);
            }
        });
        // buttonNone
        buttonNone.setDialogResult(DialogResult.Cancel);
        buttonNone.setFlatStyle(FlatStyle.Flat);
        buttonNone.setLocation(new Point(191, 48));
        buttonNone.setName("buttonNone");
        buttonNone.setSize(new Dimension(41, 22));
        buttonNone.setTabIndex(4);
        buttonNone.setText("None");
        // labelAvailable
        labelAvailable.setLocation(new Point(8, 21));
        labelAvailable.setName("labelAvailable");
        labelAvailable.setSize(new Dimension(163, 13));
        labelAvailable.setTabIndex(5);
        labelAvailable.setText("The trader has 88 units for sale.");
        labelAvailable.setVisible(false);
        // labelAfford
        labelAfford.setLocation(new Point(8, 34));
        labelAfford.setName("labelAfford");
        labelAfford.setSize(new Dimension(157, 13));
        labelAfford.setTabIndex(6);
        labelAfford.setText("You can afford to buy 88 units.");
        labelAfford.setVisible(false);
        // FormCargoBuy
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonNone);
        setClientSize(new Dimension(326, 105));
        setControlBox(false);
        Controls.add(buttonNone);
        Controls.add(buttonAll);
        Controls.add(buttonOk);
        Controls.add(numAmount);
        Controls.add(labelQuestion);
        Controls.add(labelStatement);
        Controls.add(labelAfford);
        Controls.add(labelAvailable);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormCargoBuy");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Buy Xxxxxxxxxx");
        resumeLayout(false);
        numAmount.setMaximum(maxAmount);
        numAmount.setValue(numAmount.getMinimum());
        setText(ModelUtils.StringVars(Strings.CargoTitle, Strings.CargoBuyOps[op.id], Constants.TradeItems[item].Name()));
        labelQuestion.setText(ModelUtils.StringVars("How many do you want to ^1?", Strings.CargoBuyOps[op.id].toLowerCase()));
        Game game = Game.getCurrentGame();
        Commander commander = game.Commander();
        switch (op) {
            case BuySystem:
                labelStatement.setText(ModelUtils.StringVars("At ^1 each, you can buy up to ^2.", ModelUtils.FormatMoney(game.PriceCargoBuy()[item]), ModelUtils.FormatNumber(maxAmount)));
                setHeight(buttonOk.getTop() + buttonOk.getHeight() + 34);
                break;
            case BuyTrader:
                int afford = Math.min(commander.getCash() / game.PriceCargoBuy()[item], commander.getShip().FreeCargoBays());
                if (afford < maxAmount) {
                    numAmount.setMaximum(afford);
                }
                labelStatement.setText(ModelUtils.StringVars("The trader wants to sell ^1 for the price of ^2 each.", Constants.TradeItems[item].Name(), ModelUtils.FormatMoney(game.PriceCargoBuy()[item])));
                labelAvailable.setText(ModelUtils.StringVars("The trader has ^1 for sale.", ModelUtils.Multiples(game.getOpponent().Cargo()[item], Strings.CargoUnit)));
                labelAfford.setText(ModelUtils.StringVars("You can afford to buy ^1.", ModelUtils.Multiples(afford, Strings.CargoUnit)));
                labelAvailable.setVisible(true);
                labelAfford.setVisible(true);
                buttonOk.setTop(buttonOk.getTop() + 26);
                buttonAll.setTop(buttonAll.getTop() + 26);
                buttonNone.setTop(buttonNone.getTop() + 26);
                labelQuestion.setTop(labelQuestion.getTop() + 26);
                numAmount.setTop(numAmount.getTop() + 26);
                break;
            case InPlunder:
                labelStatement.setText(ModelUtils.StringVars("Your victim has ^1 of these goods.", ModelUtils.FormatNumber(game.getOpponent().Cargo()[item])));
                setHeight(buttonOk.getTop() + buttonOk.getHeight() + 34);
                break;
        }
    }


    private void buttonAll_Click(Object sender, EventData e) {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
