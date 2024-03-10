package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.model.cargo.CargoSellOp;
import org.winforms.Button;
import org.winforms.Container;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormCargoSell extends wfForm {
    private NumericUpDown numAmount;
    private Container components = null;

    public FormCargoSell(int item, int maxAmount, CargoSellOp op, int price) {
        Label lblQuestion = new Label();
        Label lblStatement = new Label();
        numAmount = new NumericUpDown();
        Button buttonOk = new Button();
        Button buttonAll = new Button();
        Button buttonNone = new Button();
        Label lblPaid = new Label();
        Label lblProfit = new Label();
        ((ISupportInitialize) (numAmount)).BeginInit();
        SuspendLayout();
        // lblQuestion
        lblQuestion.setLocation(new Point(8, 50));
        lblQuestion.setName("lblQuestion");
        lblQuestion.setSize(new FormSize(160, 13));
        lblQuestion.setTabIndex(1);
        lblQuestion.setText("How many do you want to sell?");
        // lblStatement
        lblStatement.setLocation(new Point(8, 8));
        lblStatement.setName("lblStatement");
        lblStatement.setSize(new FormSize(302, 13));
        lblStatement.setTabIndex(3);
        lblStatement.setText("The trader wants to by Machines, and offers 8,888 cr. each.");
        // numAmount
        numAmount.setLocation(new Point(168, 48));
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new FormSize(38, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(88);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(83, 74));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new FormSize(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonAll
        buttonAll.setDialogResult(DialogResult.OK);
        buttonAll.setFlatStyle(FlatStyle.Flat);
        buttonAll.setLocation(new Point(131, 74));
        buttonAll.setName("buttonAll");
        buttonAll.setSize(new FormSize(41, 22));
        buttonAll.setTabIndex(3);
        buttonAll.setText("All");
        buttonAll.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonAll_Click(sender, e);
            }
        });
        // buttonNone
        buttonNone.setDialogResult(DialogResult.Cancel);
        buttonNone.setFlatStyle(FlatStyle.Flat);
        buttonNone.setLocation(new Point(179, 74));
        buttonNone.setName("buttonNone");
        buttonNone.setSize(new FormSize(41, 22));
        buttonNone.setTabIndex(4);
        buttonNone.setText("None");
        // lblPaid
        lblPaid.setLocation(new Point(8, 21));
        lblPaid.setName("lblPaid");
        lblPaid.setSize(new FormSize(280, 13));
        lblPaid.setTabIndex(5);
        lblPaid.setText("You paid about 8,888 cr. per unit, and can sell 88 units.");
        // lblProfit
        lblProfit.setLocation(new Point(8, 34));
        lblProfit.setName("lblProfit");
        lblProfit.setSize(new FormSize(200, 13));
        lblProfit.setTabIndex(6);
        lblProfit.setText("It costs 8,888 cr. per unit for disposal.");
        // FormCargoSell
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonNone);
        setClientSize(new FormSize(302, 105));
        setControlBox(false);
        Controls.add(lblProfit);
        Controls.add(lblPaid);
        Controls.add(buttonNone);
        Controls.add(buttonAll);
        Controls.add(buttonOk);
        Controls.add(numAmount);
        Controls.add(lblQuestion);
        Controls.add(lblStatement);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormCargoSell");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Sell Xxxxxxxxxx");
        ((ISupportInitialize) (numAmount)).EndInit();
        ResumeLayout(false);
        Game game = Game.CurrentGame();
        Commander cmdr = game.Commander();
        int cost = cmdr.PriceCargo()[item] / cmdr.getShip().Cargo()[item];
        numAmount.setMaximum(maxAmount);
        numAmount.setValue(numAmount.getMinimum());
        setText(Functions.StringVars(Strings.CargoTitle, Strings.CargoSellOps[op.CastToInt()], Constants.TradeItems[item].Name()));
        lblQuestion.setText(Functions.StringVars("How many do you want to ^1?", Strings.CargoSellOps[op.CastToInt()].toLowerCase()));
        lblPaid.setText(Functions.StringVars(op == CargoSellOp.SellTrader
                ? "You paid about ^1 per unit, and can sell ^2." : "You paid about ^1 per unit.", Functions.FormatMoney(cost), Functions.Multiples(maxAmount, Strings.CargoUnit)));
        lblProfit.setText(Functions.StringVars("Your ^1 per unit is ^2", price >= cost
                ? "profit" : "loss", Functions.FormatMoney(price >= cost ? price - cost : cost - price)));
        // Override defaults for some ops.
        switch (op) {
            case Dump:
                lblStatement.setText(Functions.StringVars(Strings.CargoSellStatementDump, Strings.CargoSellOps[op.CastToInt()].toLowerCase(), Functions.FormatNumber(maxAmount)));
                lblProfit.setText(Functions.StringVars("It costs ^1 per unit for disposal.", Functions.FormatMoney(-price)));
                break;
            case Jettison:
                lblStatement.setText(Functions.StringVars(Strings.CargoSellStatementDump, Strings.CargoSellOps[op.CastToInt()].toLowerCase(), Functions.FormatNumber(maxAmount)));
                break;
            case SellSystem:
                lblStatement.setText(Functions.StringVars("You can sell up to ^1 at ^2 each.", Functions.FormatNumber(maxAmount), Functions.FormatMoney(price)));
                break;
            case SellTrader:
                lblStatement.setText(Functions.StringVars("The trader wants to buy ^1 and offers ^2 each.", Constants.TradeItems[item].Name(), Functions.FormatMoney(price)));
                break;
        }
    }


    private void buttonAll_Click(Object sender, EventArgs e) {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
