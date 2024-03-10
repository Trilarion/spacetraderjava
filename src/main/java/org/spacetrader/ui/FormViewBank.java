package org.spacetrader.ui;

import org.spacetrader.controller.Commander;
import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.enums.AlertType;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormViewBank extends wfForm {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final int MaxLoan = commander.getPoliceRecordScore() >= Constants.PoliceRecordScoreClean
            ? Math.min(25000, Math.max(1000, commander.Worth() / 5000 * 500)) : 500;
    private final Button buttonBuyInsurance;
    private final Button buttonPayBack;
    private final Label labelCurrentDebt;
    private final Label labelMaxLoan;
    private final Label labelNoClaim;
    private final Label labelShipValue;
    private final Label labelInsAmt;
    private final Label labelMaxNoClaim;

    public FormViewBank() {
        Label labelLoan = new Label();
        Label labelCurrentDebtLabel = new Label();
        Label labelMaxLoanLabel = new Label();
        labelCurrentDebt = new Label();
        labelMaxLoan = new Label();
        Button buttonGetLoan = new Button();
        buttonBuyInsurance = new Button();
        labelNoClaim = new Label();
        labelShipValue = new Label();
        Label labelNoClaimLabel = new Label();
        Label labelShipValueLabel = new Label();
        Label labelInsurance = new Label();
        labelInsAmt = new Label();
        Label labelInsAmtLabel = new Label();
        buttonPayBack = new Button();
        Button buttonClose = new Button();
        labelMaxNoClaim = new Label();
        SuspendLayout();
        // labelLoan
        labelLoan.setAutoSize(true);
        labelLoan.setFont(new Font("Microsoft Sans Serif", 12F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelLoan.setLocation(new Point(8, 8));
        labelLoan.setName("labelLoan");
        labelLoan.setSize(new FormSize(44, 19));
        labelLoan.setTabIndex(1);
        labelLoan.setText("Loan");
        // labelCurrentDebtLabel
        labelCurrentDebtLabel.setAutoSize(true);
        labelCurrentDebtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelCurrentDebtLabel.setLocation(new Point(16, 32));
        labelCurrentDebtLabel.setName("labelCurrentDebtLabel");
        labelCurrentDebtLabel.setSize(new FormSize(75, 13));
        labelCurrentDebtLabel.setTabIndex(2);
        labelCurrentDebtLabel.setText("Current Debt:");
        // labelMaxLoanLabel
        labelMaxLoanLabel.setAutoSize(true);
        labelMaxLoanLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMaxLoanLabel.setLocation(new Point(16, 52));
        labelMaxLoanLabel.setName("labelMaxLoanLabel");
        labelMaxLoanLabel.setSize(new FormSize(88, 13));
        labelMaxLoanLabel.setTabIndex(3);
        labelMaxLoanLabel.setText("Maximum Loan:");
        // labelCurrentDebt
        labelCurrentDebt.setLocation(new Point(136, 32));
        labelCurrentDebt.setName("labelCurrentDebt");
        labelCurrentDebt.setSize(new FormSize(56, 13));
        labelCurrentDebt.setTabIndex(4);
        labelCurrentDebt.setText("88,888 cr.");
        labelCurrentDebt.TextAlign = ContentAlignment.TopRight;
        // labelMaxLoan
        labelMaxLoan.setLocation(new Point(136, 52));
        labelMaxLoan.setName("labelMaxLoan");
        labelMaxLoan.setSize(new FormSize(56, 13));
        labelMaxLoan.setTabIndex(5);
        labelMaxLoan.setText("88,888 cr.");
        labelMaxLoan.TextAlign = ContentAlignment.TopRight;
        // buttonGetLoan
        buttonGetLoan.setFlatStyle(FlatStyle.Flat);
        buttonGetLoan.setLocation(new Point(16, 72));
        buttonGetLoan.setName("buttonGetLoan");
        buttonGetLoan.setSize(new FormSize(61, 22));
        buttonGetLoan.setTabIndex(1);
        buttonGetLoan.setText("Get Loan");
        buttonGetLoan.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonGetLoan_Click(sender, e);
            }
        });
        // buttonBuyInsurance
        buttonBuyInsurance.setFlatStyle(FlatStyle.Flat);
        buttonBuyInsurance.setLocation(new Point(16, 196));
        buttonBuyInsurance.setName("buttonBuyInsurance");
        buttonBuyInsurance.setSize(new FormSize(90, 22));
        buttonBuyInsurance.setTabIndex(3);
        buttonBuyInsurance.setText("Stop Insurance");
        buttonBuyInsurance.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonBuyInsurance_Click(sender, e);
            }
        });
        // labelNoClaim
        labelNoClaim.setLocation(new Point(154, 156));
        labelNoClaim.setName("labelNoClaim");
        labelNoClaim.setSize(new FormSize(32, 13));
        labelNoClaim.setTabIndex(27);
        labelNoClaim.setText("88%");
        labelNoClaim.TextAlign = ContentAlignment.TopRight;
        // labelShipValue
        labelShipValue.setLocation(new Point(136, 136));
        labelShipValue.setName("labelShipValue");
        labelShipValue.setSize(new FormSize(56, 13));
        labelShipValue.setTabIndex(26);
        labelShipValue.setText("88,888 cr.");
        labelShipValue.TextAlign = ContentAlignment.TopRight;
        // labelNoClaimLabel
        labelNoClaimLabel.setAutoSize(true);
        labelNoClaimLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelNoClaimLabel.setLocation(new Point(16, 156));
        labelNoClaimLabel.setName("labelNoClaimLabel");
        labelNoClaimLabel.setSize(new FormSize(106, 13));
        labelNoClaimLabel.setTabIndex(25);
        labelNoClaimLabel.setText("No-Claim Discount:");
        // labelShipValueLabel
        labelShipValueLabel.setAutoSize(true);
        labelShipValueLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelShipValueLabel.setLocation(new Point(16, 136));
        labelShipValueLabel.setName("labelShipValueLabel");
        labelShipValueLabel.setSize(new FormSize(65, 13));
        labelShipValueLabel.setTabIndex(24);
        labelShipValueLabel.setText("Ship Value:");
        // labelInsurance
        labelInsurance.setAutoSize(true);
        labelInsurance.setFont(new Font("Microsoft Sans Serif", 12F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelInsurance.setLocation(new Point(8, 112));
        labelInsurance.setName("labelInsurance");
        labelInsurance.setSize(new FormSize(81, 19));
        labelInsurance.setTabIndex(23);
        labelInsurance.setText("Insurance");
        // labelInsAmt
        labelInsAmt.setLocation(new Point(136, 176));
        labelInsAmt.setName("labelInsAmt");
        labelInsAmt.setSize(new FormSize(82, 13));
        labelInsAmt.setTabIndex(30);
        labelInsAmt.setText("8,888 cr. daily");
        labelInsAmt.TextAlign = ContentAlignment.TopRight;
        // labelInsAmtLabel
        labelInsAmtLabel.setAutoSize(true);
        labelInsAmtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelInsAmtLabel.setLocation(new Point(16, 176));
        labelInsAmtLabel.setName("labelInsAmtLabel");
        labelInsAmtLabel.setSize(new FormSize(38, 13));
        labelInsAmtLabel.setTabIndex(29);
        labelInsAmtLabel.setText("Costs:");
        // buttonPayBack
        buttonPayBack.setFlatStyle(FlatStyle.Flat);
        buttonPayBack.setLocation(new Point(88, 72));
        buttonPayBack.setName("buttonPayBack");
        buttonPayBack.setSize(new FormSize(90, 22));
        buttonPayBack.setTabIndex(2);
        buttonPayBack.setText("Pay Back Loan");
        buttonPayBack.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonPayBack_Click(sender, e);
            }
        });
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new FormSize(26, 27));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelMaxNoClaim
        labelMaxNoClaim.setAutoSize(true);
        labelMaxNoClaim.setLocation(new Point(182, 156));
        labelMaxNoClaim.setName("labelMaxNoClaim");
        labelMaxNoClaim.setSize(new FormSize(33, 13));
        labelMaxNoClaim.setTabIndex(33);
        labelMaxNoClaim.setText("(max)");
        labelMaxNoClaim.setVisible(false);
        // FormViewBank
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(226, 231));
        Controls.addAll(Arrays.asList(
                labelMaxNoClaim,
                buttonClose,
                buttonPayBack,
                labelInsAmt,
                labelInsAmtLabel,
                labelNoClaimLabel,
                labelShipValueLabel,
                labelInsurance,
                labelMaxLoanLabel,
                labelCurrentDebtLabel,
                labelLoan,
                buttonBuyInsurance,
                labelNoClaim,
                labelShipValue,
                buttonGetLoan,
                labelMaxLoan,
                labelCurrentDebt));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormViewBank");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Bank");
        ResumeLayout(false);
        UpdateAll();
    }


    private void UpdateAll() {
        // Loan Info
        labelCurrentDebt.setText(Functions.FormatMoney(commander.getDebt()));
        labelMaxLoan.setText(Functions.FormatMoney(MaxLoan));
        buttonPayBack.setVisible((commander.getDebt() > 0));
        // Insurance Info
        labelShipValue.setText(Functions.FormatMoney(commander.getShip().BaseWorth(true)));
        labelNoClaim.setText(Functions.FormatPercent(commander.NoClaim()));
        labelMaxNoClaim.setVisible((commander.NoClaim() == Constants.MaxNoClaim));
        labelInsAmt.setText(Functions.StringVars(Strings.MoneyRateSuffix, Functions.FormatMoney(game.InsuranceCosts())));
        buttonBuyInsurance.setText(Functions.StringVars("^1 Insurance", commander.getInsurance() ? "Stop" : "Buy"));
    }

    private void buttonGetLoan_Click(Object sender, EventData e) {
        if (commander.getDebt() >= MaxLoan) {
            FormAlert.Alert(AlertType.DebtTooLargeLoan, this);
        } else {
            FormGetLoan form = new FormGetLoan(MaxLoan - commander.getDebt());
            if (form.ShowDialog(this) == DialogResult.OK) {
                commander.setCash(commander.getCash() + form.Amount());
                commander.setDebt(commander.getDebt() + form.Amount());
                UpdateAll();
                game.getParentWindow().UpdateAll();
            }
        }
    }

    private void buttonPayBack_Click(Object sender, EventData e) {
        if (commander.getDebt() == 0) {
            FormAlert.Alert(AlertType.DebtNone, this);
        } else {
            FormPayBackLoan form = new FormPayBackLoan();
            if (form.ShowDialog(this) == DialogResult.OK) {
                commander.setCash(commander.getCash() - form.Amount());
                commander.setDebt(commander.getDebt() - form.Amount());
                UpdateAll();
                game.getParentWindow().UpdateAll();
            }
        }
    }

    private void buttonBuyInsurance_Click(Object sender, EventData e) {
        if (commander.getInsurance()) {
            if (FormAlert.Alert(AlertType.InsuranceStop, this) == DialogResult.Yes) {
                commander.setInsurance(false);
                commander.NoClaim(0);
            }
        } else if (!commander.getShip().getEscapePod()) {
            FormAlert.Alert(AlertType.InsuranceNoEscapePod, this);
        } else {
            commander.setInsurance(true);
            commander.NoClaim(0);
        }
        UpdateAll();
        game.getParentWindow().UpdateAll();
    }
}
