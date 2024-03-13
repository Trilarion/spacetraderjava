package org.spacetrader.ui;

import org.spacetrader.model.crew.Commander;
import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.model.cargo.CargoSellOperation;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormCargoSell extends wfForm {
    private final NumericUpDown numAmount;

    public FormCargoSell(int item, int maxAmount, CargoSellOperation op, int price) {
        Label labelQuestion = new Label();
        Label labelStatement = new Label();
        numAmount = new NumericUpDown();
        Button buttonOk = new Button();
        Button buttonAll = new Button();
        Button buttonNone = new Button();
        Label labelPaid = new Label();
        Label labelProfit = new Label();
                SuspendLayout();
        // labelQuestion
        labelQuestion.setLocation(new Point(8, 50));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new SizeF(13, 160));
        labelQuestion.setTabIndex(1);
        labelQuestion.setText("How many do you want to sell?");
        // labelStatement
        labelStatement.setLocation(new Point(8, 8));
        labelStatement.setName("labelStatement");
        labelStatement.setSize(new SizeF(13, 302));
        labelStatement.setTabIndex(3);
        labelStatement.setText("The trader wants to by Machines, and offers 8,888 cr. each.");
        // numAmount
        numAmount.setLocation(new Point(168, 48));
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new SizeF(20, 38));
        numAmount.setTabIndex(1);
        numAmount.setValue(88);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(83, 74));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new SizeF(22, 41));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonAll
        buttonAll.setDialogResult(DialogResult.OK);
        buttonAll.setFlatStyle(FlatStyle.Flat);
        buttonAll.setLocation(new Point(131, 74));
        buttonAll.setName("buttonAll");
        buttonAll.setSize(new SizeF(22, 41));
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
        buttonNone.setSize(new SizeF(22, 41));
        buttonNone.setTabIndex(4);
        buttonNone.setText("None");
        // labelPaid
        labelPaid.setLocation(new Point(8, 21));
        labelPaid.setName("labelPaid");
        labelPaid.setSize(new SizeF(13, 280));
        labelPaid.setTabIndex(5);
        labelPaid.setText("You paid about 8,888 cr. per unit, and can sell 88 units.");
        // labelProfit
        labelProfit.setLocation(new Point(8, 34));
        labelProfit.setName("labelProfit");
        labelProfit.setSize(new SizeF(13, 200));
        labelProfit.setTabIndex(6);
        labelProfit.setText("It costs 8,888 cr. per unit for disposal.");
        // FormCargoSell
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonNone);
        setClientSize(new SizeF(105, 302));
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
        setName("FormCargoSell");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Sell Xxxxxxxxxx");
                ResumeLayout(false);
        Game game = Game.getCurrentGame();
        Commander commander = game.Commander();
        int cost = commander.PriceCargo()[item] / commander.getShip().Cargo()[item];
        numAmount.setMaximum(maxAmount);
        numAmount.setValue(numAmount.getMinimum());
        setText(Functions.StringVars(Strings.CargoTitle, Strings.CargoSellOps[op.getId()], Constants.TradeItems[item].Name()));
        labelQuestion.setText(Functions.StringVars("How many do you want to ^1?", Strings.CargoSellOps[op.getId()].toLowerCase()));
        labelPaid.setText(Functions.StringVars(op == CargoSellOperation.SellTrader
                ? "You paid about ^1 per unit, and can sell ^2." : "You paid about ^1 per unit.", Functions.FormatMoney(cost), Functions.Multiples(maxAmount, Strings.CargoUnit)));
        labelProfit.setText(Functions.StringVars("Your ^1 per unit is ^2", price >= cost
                ? "profit" : "loss", Functions.FormatMoney(price >= cost ? price - cost : cost - price)));
        // Override defaults for some ops.
        switch (op) {
            case Dump:
                labelStatement.setText(Functions.StringVars(Strings.CargoSellStatementDump, Strings.CargoSellOps[op.getId()].toLowerCase(), Functions.FormatNumber(maxAmount)));
                labelProfit.setText(Functions.StringVars("It costs ^1 per unit for disposal.", Functions.FormatMoney(-price)));
                break;
            case Jettison:
                labelStatement.setText(Functions.StringVars(Strings.CargoSellStatementDump, Strings.CargoSellOps[op.getId()].toLowerCase(), Functions.FormatNumber(maxAmount)));
                break;
            case SellSystem:
                labelStatement.setText(Functions.StringVars("You can sell up to ^1 at ^2 each.", Functions.FormatNumber(maxAmount), Functions.FormatMoney(price)));
                break;
            case SellTrader:
                labelStatement.setText(Functions.StringVars("The trader wants to buy ^1 and offers ^2 each.", Constants.TradeItems[item].Name(), Functions.FormatMoney(price)));
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