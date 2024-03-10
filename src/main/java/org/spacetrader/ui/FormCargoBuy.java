package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.model.cargo.CargoBuyOp;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormCargoBuy extends wfForm {
    private NumericUpDown numAmount;

    public FormCargoBuy(int item, int maxAmount, CargoBuyOp op) {
        Label lblQuestion = new Label();
        Label lblStatement = new Label();
        numAmount = new NumericUpDown();
        Button buttonOk = new Button();
        Button buttonAll = new Button();
        Button buttonNone = new Button();
        Label lblAvailable = new Label();
        Label lblAfford = new Label();
        ((ISupportInitialize) (numAmount)).BeginInit();
        SuspendLayout();
        // lblQuestion
        lblQuestion.setAutoSize(true);
        lblQuestion.setLocation(new Point(8, 24));
        lblQuestion.setName("lblQuestion");
        lblQuestion.setSize(new FormSize(161, 16));
        lblQuestion.setTabIndex(1);
        lblQuestion.setText("How many do you want to buy?");
        // lblStatement
        lblStatement.setLocation(new Point(8, 8));
        lblStatement.setName("lblStatement");
        lblStatement.setSize(new FormSize(326, 13));
        lblStatement.setTabIndex(3);
        lblStatement.setText("The trader wants to sell Machines for the price of 8,888 cr. each.");
        // numAmount
        numAmount.setLocation(new Point(168, 22));
        numAmount.setMaximum(999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new FormSize(44, 20));
        numAmount.setTabIndex(1);
        numAmount.setValue(1);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(95, 48));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new FormSize(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonAll
        buttonAll.setDialogResult(DialogResult.OK);
        buttonAll.setFlatStyle(FlatStyle.Flat);
        buttonAll.setLocation(new Point(143, 48));
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
        buttonNone.setLocation(new Point(191, 48));
        buttonNone.setName("buttonNone");
        buttonNone.setSize(new FormSize(41, 22));
        buttonNone.setTabIndex(4);
        buttonNone.setText("None");
        // lblAvailable
        lblAvailable.setLocation(new Point(8, 21));
        lblAvailable.setName("lblAvailable");
        lblAvailable.setSize(new FormSize(163, 13));
        lblAvailable.setTabIndex(5);
        lblAvailable.setText("The trader has 88 units for sale.");
        lblAvailable.setVisible(false);
        // lblAfford
        lblAfford.setLocation(new Point(8, 34));
        lblAfford.setName("lblAfford");
        lblAfford.setSize(new FormSize(157, 13));
        lblAfford.setTabIndex(6);
        lblAfford.setText("You can afford to buy 88 units.");
        lblAfford.setVisible(false);
        // FormCargoBuy
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonNone);
        setClientSize(new FormSize(326, 105));
        setControlBox(false);
        Controls.add(buttonNone);
        Controls.add(buttonAll);
        Controls.add(buttonOk);
        Controls.add(numAmount);
        Controls.add(lblQuestion);
        Controls.add(lblStatement);
        Controls.add(lblAfford);
        Controls.add(lblAvailable);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormCargoBuy");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Buy Xxxxxxxxxx");
        ((ISupportInitialize) (numAmount)).EndInit();
        ResumeLayout(false);
        numAmount.setMaximum(maxAmount);
        numAmount.setValue(numAmount.getMinimum());
        setText(Functions.StringVars(Strings.CargoTitle, Strings.CargoBuyOps[op.id], Constants.TradeItems[item].Name()));
        lblQuestion.setText(Functions.StringVars("How many do you want to ^1?", Strings.CargoBuyOps[op.id].toLowerCase()));
        Game game = Game.CurrentGame();
        Commander cmdr = game.Commander();
        switch (op) {
            case BuySystem:
                lblStatement.setText(Functions.StringVars("At ^1 each, you can buy up to ^2.", Functions.FormatMoney(game.PriceCargoBuy()[item]), Functions.FormatNumber(maxAmount)));
                setHeight(buttonOk.getTop() + buttonOk.getHeight() + 34);
                break;
            case BuyTrader:
                int afford = Math.min(cmdr.getCash() / game.PriceCargoBuy()[item], cmdr.getShip().FreeCargoBays());
                if (afford < maxAmount) {
                    numAmount.setMaximum(afford);
                }
                lblStatement.setText(Functions.StringVars("The trader wants to sell ^1 for the price of ^2 each.", Constants.TradeItems[item].Name(), Functions.FormatMoney(game.PriceCargoBuy()[item])));
                lblAvailable.setText(Functions.StringVars("The trader has ^1 for sale.", Functions.Multiples(game.getOpponent().Cargo()[item], Strings.CargoUnit)));
                lblAfford.setText(Functions.StringVars("You can afford to buy ^1.", Functions.Multiples(afford, Strings.CargoUnit)));
                lblAvailable.setVisible(true);
                lblAfford.setVisible(true);
                buttonOk.setTop(buttonOk.getTop() + 26);
                buttonAll.setTop(buttonAll.getTop() + 26);
                buttonNone.setTop(buttonNone.getTop() + 26);
                lblQuestion.setTop(lblQuestion.getTop() + 26);
                numAmount.setTop(numAmount.getTop() + 26);
                break;
            case InPlunder:
                lblStatement.setText(Functions.StringVars("Your victim has ^1 of these goods.", Functions.FormatNumber(game.getOpponent().Cargo()[item])));
                setHeight(buttonOk.getTop() + buttonOk.getHeight() + 34);
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
