package org.spacetrader.ui;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.cargo.CargoSellOperation;
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


public class DialogCargoSell extends Dialog {
    private final Spinner numAmount;

    public DialogCargoSell(int item, int maxAmount, CargoSellOperation op, int price) {
        Label labelQuestion = new Label();
        Label labelStatement = new Label();
        numAmount = new Spinner();
        Button buttonOk = new Button();
        Button buttonAll = new Button();
        Button buttonNone = new Button();
        Label labelPaid = new Label();
        Label labelProfit = new Label();
        // labelQuestion
        labelQuestion.setLocation(new Point(8, 50));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new Dimension(160, 13));
        labelQuestion.setTabIndex(1);
        labelQuestion.setText("How many do you want to sell?");
        // labelStatement
        labelStatement.setLocation(new Point(8, 8));
        labelStatement.setName("labelStatement");
        labelStatement.setSize(new Dimension(302, 13));
        labelStatement.setTabIndex(3);
        labelStatement.setText("The trader wants to by Machines, and offers 8,888 cr. each.");
        // numAmount
        numAmount.setLocation(new Point(168, 48));
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new Dimension(38, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(88);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.Ok);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(83, 74));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new Dimension(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonAll
        buttonAll.setDialogResult(DialogResult.Ok);
        buttonAll.setFlatStyle(FlatStyle.Flat);
        buttonAll.setLocation(new Point(131, 74));
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
        buttonNone.setLocation(new Point(179, 74));
        buttonNone.setName("buttonNone");
        buttonNone.setSize(new Dimension(41, 22));
        buttonNone.setTabIndex(4);
        buttonNone.setText("None");
        // labelPaid
        labelPaid.setLocation(new Point(8, 21));
        labelPaid.setName("labelPaid");
        labelPaid.setSize(new Dimension(280, 13));
        labelPaid.setTabIndex(5);
        labelPaid.setText("You paid about 8,888 cr. per unit, and can sell 88 units.");
        // labelProfit
        labelProfit.setLocation(new Point(8, 34));
        labelProfit.setName("labelProfit");
        labelProfit.setSize(new Dimension(200, 13));
        labelProfit.setTabIndex(6);
        labelProfit.setText("It costs 8,888 cr. per unit for disposal.");
        // FormsellCargo
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonNone);
        setClientSize(new Dimension(302, 105));
        setControlBox(false);
        Controls.add(labelProfit);
        Controls.add(labelPaid);
        Controls.add(buttonNone);
        Controls.add(buttonAll);
        Controls.add(buttonOk);
        Controls.add(numAmount);
        Controls.add(labelQuestion);
        Controls.add(labelStatement);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormsellCargo");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Sell Xxxxxxxxxx");
        resumeLayout(false);
        Game game = Game.getCurrentGame();
        Commander commander = game.Commander();
        int cost = commander.PriceCargo()[item] / commander.getShip().Cargo()[item];
        numAmount.setMaximum(maxAmount);
        numAmount.setValue(numAmount.getMinimum());
        setText(ModelUtils.StringVars(Strings.CargoTitle, Strings.sellCargoOps[op.getId()], Constants.TradeItems[item].Name()));
        labelQuestion.setText(ModelUtils.StringVars("How many do you want to ^1?", Strings.sellCargoOps[op.getId()].toLowerCase()));
        labelPaid.setText(ModelUtils.StringVars(op == CargoSellOperation.SellTrader
                ? "You paid about ^1 per unit, and can sell ^2." : "You paid about ^1 per unit.", ModelUtils.formatMoney(cost), ModelUtils.multiples(maxAmount, Strings.CargoUnit)));
        labelProfit.setText(ModelUtils.StringVars("Your ^1 per unit is ^2", price >= cost
                ? "profit" : "loss", ModelUtils.formatMoney(price >= cost ? price - cost : cost - price)));
        // Override defaults for some ops.
        switch (op) {
            case Dump:
                labelStatement.setText(ModelUtils.StringVars(Strings.sellCargoStatementDump, Strings.sellCargoOps[op.getId()].toLowerCase(), ModelUtils.formatNumber(maxAmount)));
                labelProfit.setText(ModelUtils.StringVars("It costs ^1 per unit for disposal.", ModelUtils.formatMoney(-price)));
                break;
            case Jettison:
                labelStatement.setText(ModelUtils.StringVars(Strings.sellCargoStatementDump, Strings.sellCargoOps[op.getId()].toLowerCase(), ModelUtils.formatNumber(maxAmount)));
                break;
            case SellSystem:
                labelStatement.setText(ModelUtils.StringVars("You can sell up to ^1 at ^2 each.", ModelUtils.formatNumber(maxAmount), ModelUtils.formatMoney(price)));
                break;
            case SellTrader:
                labelStatement.setText(ModelUtils.StringVars("The trader wants to buy ^1 and offers ^2 each.", Constants.TradeItems[item].Name(), ModelUtils.formatMoney(price)));
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
