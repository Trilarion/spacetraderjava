package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.controller.enums.AlertType;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormViewBank extends wfForm {
    private final Game game = Game.CurrentGame();
    private final Commander cmdr = game.Commander();
    private final int MaxLoan = cmdr.getPoliceRecordScore() >= Constants.PoliceRecordScoreClean
            ? Math.min(25000, Math.max(1000, cmdr.Worth() / 5000 * 500)) : 500;
    private Button buttonBuyInsurance;
    private Button buttonPayBack;
    private Label lblCurrentDebt;
    private Label lblMaxLoan;
    private Label lblNoClaim;
    private Label lblShipValue;
    private Label lblInsAmt;
    private Label lblMaxNoClaim;

    public FormViewBank() {
        Label lblLoan = new Label();
        Label lblCurrentDebtLabel = new Label();
        Label lblMaxLoanLabel = new Label();
        lblCurrentDebt = new Label();
        lblMaxLoan = new Label();
        Button buttonGetLoan = new Button();
        buttonBuyInsurance = new Button();
        lblNoClaim = new Label();
        lblShipValue = new Label();
        Label lblNoClaimLabel = new Label();
        Label lblShipValueLabel = new Label();
        Label lblInsurance = new Label();
        lblInsAmt = new Label();
        Label lblInsAmtLabel = new Label();
        buttonPayBack = new Button();
        Button buttonClose = new Button();
        lblMaxNoClaim = new Label();
        SuspendLayout();
        // lblLoan
        lblLoan.setAutoSize(true);
        lblLoan.setFont(new Font("Microsoft Sans Serif", 12F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblLoan.setLocation(new Point(8, 8));
        lblLoan.setName("lblLoan");
        lblLoan.setSize(new FormSize(44, 19));
        lblLoan.setTabIndex(1);
        lblLoan.setText("Loan");
        // lblCurrentDebtLabel
        lblCurrentDebtLabel.setAutoSize(true);
        lblCurrentDebtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblCurrentDebtLabel.setLocation(new Point(16, 32));
        lblCurrentDebtLabel.setName("lblCurrentDebtLabel");
        lblCurrentDebtLabel.setSize(new FormSize(75, 13));
        lblCurrentDebtLabel.setTabIndex(2);
        lblCurrentDebtLabel.setText("Current Debt:");
        // lblMaxLoanLabel
        lblMaxLoanLabel.setAutoSize(true);
        lblMaxLoanLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMaxLoanLabel.setLocation(new Point(16, 52));
        lblMaxLoanLabel.setName("lblMaxLoanLabel");
        lblMaxLoanLabel.setSize(new FormSize(88, 13));
        lblMaxLoanLabel.setTabIndex(3);
        lblMaxLoanLabel.setText("Maximum Loan:");
        // lblCurrentDebt
        lblCurrentDebt.setLocation(new Point(136, 32));
        lblCurrentDebt.setName("lblCurrentDebt");
        lblCurrentDebt.setSize(new FormSize(56, 13));
        lblCurrentDebt.setTabIndex(4);
        lblCurrentDebt.setText("88,888 cr.");
        lblCurrentDebt.TextAlign = ContentAlignment.TopRight;
        // lblMaxLoan
        lblMaxLoan.setLocation(new Point(136, 52));
        lblMaxLoan.setName("lblMaxLoan");
        lblMaxLoan.setSize(new FormSize(56, 13));
        lblMaxLoan.setTabIndex(5);
        lblMaxLoan.setText("88,888 cr.");
        lblMaxLoan.TextAlign = ContentAlignment.TopRight;
        // buttonGetLoan
        buttonGetLoan.setFlatStyle(FlatStyle.Flat);
        buttonGetLoan.setLocation(new Point(16, 72));
        buttonGetLoan.setName("buttonGetLoan");
        buttonGetLoan.setSize(new FormSize(61, 22));
        buttonGetLoan.setTabIndex(1);
        buttonGetLoan.setText("Get Loan");
        buttonGetLoan.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
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
            public void handle(Object sender, EventArgs e) {
                buttonBuyInsurance_Click(sender, e);
            }
        });
        // lblNoClaim
        lblNoClaim.setLocation(new Point(154, 156));
        lblNoClaim.setName("lblNoClaim");
        lblNoClaim.setSize(new FormSize(32, 13));
        lblNoClaim.setTabIndex(27);
        lblNoClaim.setText("88%");
        lblNoClaim.TextAlign = ContentAlignment.TopRight;
        // lblShipValue
        lblShipValue.setLocation(new Point(136, 136));
        lblShipValue.setName("lblShipValue");
        lblShipValue.setSize(new FormSize(56, 13));
        lblShipValue.setTabIndex(26);
        lblShipValue.setText("88,888 cr.");
        lblShipValue.TextAlign = ContentAlignment.TopRight;
        // lblNoClaimLabel
        lblNoClaimLabel.setAutoSize(true);
        lblNoClaimLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblNoClaimLabel.setLocation(new Point(16, 156));
        lblNoClaimLabel.setName("lblNoClaimLabel");
        lblNoClaimLabel.setSize(new FormSize(106, 13));
        lblNoClaimLabel.setTabIndex(25);
        lblNoClaimLabel.setText("No-Claim Discount:");
        // lblShipValueLabel
        lblShipValueLabel.setAutoSize(true);
        lblShipValueLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblShipValueLabel.setLocation(new Point(16, 136));
        lblShipValueLabel.setName("lblShipValueLabel");
        lblShipValueLabel.setSize(new FormSize(65, 13));
        lblShipValueLabel.setTabIndex(24);
        lblShipValueLabel.setText("Ship Value:");
        // lblInsurance
        lblInsurance.setAutoSize(true);
        lblInsurance.setFont(new Font("Microsoft Sans Serif", 12F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblInsurance.setLocation(new Point(8, 112));
        lblInsurance.setName("lblInsurance");
        lblInsurance.setSize(new FormSize(81, 19));
        lblInsurance.setTabIndex(23);
        lblInsurance.setText("Insurance");
        // lblInsAmt
        lblInsAmt.setLocation(new Point(136, 176));
        lblInsAmt.setName("lblInsAmt");
        lblInsAmt.setSize(new FormSize(82, 13));
        lblInsAmt.setTabIndex(30);
        lblInsAmt.setText("8,888 cr. daily");
        lblInsAmt.TextAlign = ContentAlignment.TopRight;
        // lblInsAmtLabel
        lblInsAmtLabel.setAutoSize(true);
        lblInsAmtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblInsAmtLabel.setLocation(new Point(16, 176));
        lblInsAmtLabel.setName("lblInsAmtLabel");
        lblInsAmtLabel.setSize(new FormSize(38, 13));
        lblInsAmtLabel.setTabIndex(29);
        lblInsAmtLabel.setText("Costs:");
        // buttonPayBack
        buttonPayBack.setFlatStyle(FlatStyle.Flat);
        buttonPayBack.setLocation(new Point(88, 72));
        buttonPayBack.setName("buttonPayBack");
        buttonPayBack.setSize(new FormSize(90, 22));
        buttonPayBack.setTabIndex(2);
        buttonPayBack.setText("Pay Back Loan");
        buttonPayBack.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
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
        // lblMaxNoClaim
        lblMaxNoClaim.setAutoSize(true);
        lblMaxNoClaim.setLocation(new Point(182, 156));
        lblMaxNoClaim.setName("lblMaxNoClaim");
        lblMaxNoClaim.setSize(new FormSize(33, 13));
        lblMaxNoClaim.setTabIndex(33);
        lblMaxNoClaim.setText("(max)");
        lblMaxNoClaim.setVisible(false);
        // FormViewBank
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(226, 231));
        Controls.addAll(Arrays.asList(
                lblMaxNoClaim,
                buttonClose,
                buttonPayBack,
                lblInsAmt,
                lblInsAmtLabel,
                lblNoClaimLabel,
                lblShipValueLabel,
                lblInsurance,
                lblMaxLoanLabel,
                lblCurrentDebtLabel,
                lblLoan,
                buttonBuyInsurance,
                lblNoClaim,
                lblShipValue,
                buttonGetLoan,
                lblMaxLoan,
                lblCurrentDebt));
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
        lblCurrentDebt.setText(Functions.FormatMoney(cmdr.getDebt()));
        lblMaxLoan.setText(Functions.FormatMoney(MaxLoan));
        buttonPayBack.setVisible((cmdr.getDebt() > 0));
        // Insurance Info
        lblShipValue.setText(Functions.FormatMoney(cmdr.getShip().BaseWorth(true)));
        lblNoClaim.setText(Functions.FormatPercent(cmdr.NoClaim()));
        lblMaxNoClaim.setVisible((cmdr.NoClaim() == Constants.MaxNoClaim));
        lblInsAmt.setText(Functions.StringVars(Strings.MoneyRateSuffix, Functions.FormatMoney(game.InsuranceCosts())));
        buttonBuyInsurance.setText(Functions.StringVars("^1 Insurance", cmdr.getInsurance() ? "Stop" : "Buy"));
    }

    private void buttonGetLoan_Click(Object sender, EventArgs e) {
        if (cmdr.getDebt() >= MaxLoan) {
            FormAlert.Alert(AlertType.DebtTooLargeLoan, this);
        } else {
            FormGetLoan form = new FormGetLoan(MaxLoan - cmdr.getDebt());
            if (form.ShowDialog(this) == DialogResult.OK) {
                cmdr.setCash(cmdr.getCash() + form.Amount());
                cmdr.setDebt(cmdr.getDebt() + form.Amount());
                UpdateAll();
                game.getParentWindow().UpdateAll();
            }
        }
    }

    private void buttonPayBack_Click(Object sender, EventArgs e) {
        if (cmdr.getDebt() == 0) {
            FormAlert.Alert(AlertType.DebtNone, this);
        } else {
            FormPayBackLoan form = new FormPayBackLoan();
            if (form.ShowDialog(this) == DialogResult.OK) {
                cmdr.setCash(cmdr.getCash() - form.Amount());
                cmdr.setDebt(cmdr.getDebt() - form.Amount());
                UpdateAll();
                game.getParentWindow().UpdateAll();
            }
        }
    }

    private void buttonBuyInsurance_Click(Object sender, EventArgs e) {
        if (cmdr.getInsurance()) {
            if (FormAlert.Alert(AlertType.InsuranceStop, this) == DialogResult.Yes) {
                cmdr.setInsurance(false);
                cmdr.NoClaim(0);
            }
        } else if (!cmdr.getShip().getEscapePod()) {
            FormAlert.Alert(AlertType.InsuranceNoEscapePod, this);
        } else {
            cmdr.setInsurance(true);
            cmdr.NoClaim(0);
        }
        UpdateAll();
        game.getParentWindow().UpdateAll();
    }
}
