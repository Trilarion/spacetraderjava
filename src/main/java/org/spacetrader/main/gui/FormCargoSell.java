package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Container;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.DialogResult;
import org.jwinforms.enums.FlatStyle;
import org.jwinforms.enums.FormBorderStyle;
import org.jwinforms.enums.FormStartPosition;
import org.spacetrader.cargo.CargoSellOp;
import org.spacetrader.main.*;

import java.awt.*;


public class FormCargoSell extends WinformForm {
    private final Game game = Game.CurrentGame();
    private final Commander cmdr = game.Commander();
    private Button btnOk;
    private Button btnAll;
    private Button btnNone;
    private Label lblStatement;
    private Label lblQuestion;
    private Label lblPaid;
    private Label lblProfit;
    private NumericUpDown numAmount;
    private Container components = null;

    public FormCargoSell(int item, int maxAmount, CargoSellOp op, int price) {
        InitializeComponent();
        int cost = cmdr.PriceCargo()[item] / cmdr.getShip().Cargo()[item];
        numAmount.setMaximum(maxAmount);
        numAmount.setValue(numAmount.getMinimum());
        setText(Functions.StringVars(Strings.CargoTitle, Strings.CargoSellOps[op.CastToInt()], Consts.TradeItems[item].Name()));
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
                lblStatement.setText(Functions.StringVars("The trader wants to buy ^1 and offers ^2 each.", Consts.TradeItems[item].Name(), Functions.FormatMoney(price)));
                break;
        }
    }

    // Required method for Designer support - do not modify the contents of this method with the code editor.
    private void InitializeComponent() {
        lblQuestion = new Label();
        lblStatement = new Label();
        numAmount = new NumericUpDown();
        btnOk = new Button();
        btnAll = new Button();
        btnNone = new Button();
        lblPaid = new Label();
        lblProfit = new Label();
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
        // btnOk
        btnOk.setDialogResult(DialogResult.OK);
        btnOk.setFlatStyle(FlatStyle.Flat);
        btnOk.setLocation(new Point(83, 74));
        btnOk.setName("btnOk");
        btnOk.setSize(new FormSize(41, 22));
        btnOk.setTabIndex(2);
        btnOk.setText("Ok");
        // btnAll
        btnAll.setDialogResult(DialogResult.OK);
        btnAll.setFlatStyle(FlatStyle.Flat);
        btnAll.setLocation(new Point(131, 74));
        btnAll.setName("btnAll");
        btnAll.setSize(new FormSize(41, 22));
        btnAll.setTabIndex(3);
        btnAll.setText("All");
        btnAll.setClick(new EventHandler<Object, EventArgs>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                btnAll_Click(sender, e);
            }
        });
        // btnNone
        btnNone.setDialogResult(DialogResult.Cancel);
        btnNone.setFlatStyle(FlatStyle.Flat);
        btnNone.setLocation(new Point(179, 74));
        btnNone.setName("btnNone");
        btnNone.setSize(new FormSize(41, 22));
        btnNone.setTabIndex(4);
        btnNone.setText("None");
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
        setAcceptButton(btnOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnNone);
        setClientSize(new FormSize(302, 105));
        setControlBox(false);
        Controls.add(lblProfit);
        Controls.add(lblPaid);
        Controls.add(btnNone);
        Controls.add(btnAll);
        Controls.add(btnOk);
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
    }

    private void btnAll_Click(Object sender, EventArgs e) {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
