package spacetrader.gui;
import java.awt.Point;
import java.util.Arrays;
import jwinforms.Button;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.Font;
import jwinforms.FormSize;
import jwinforms.GraphicsUnit;
import jwinforms.Label;
import jwinforms.WinformForm;
import jwinforms.enums.ContentAlignment;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FontStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;
import spacetrader.Commander;
import spacetrader.Consts;
import spacetrader.Functions;
import spacetrader.Game;
import spacetrader.Strings;
import spacetrader.enums.AlertType;


public class FormViewBank extends WinformForm {
  private Button btnGetLoan;
  private Button btnBuyInsurance;
  private Button btnPayBack;
  private Button btnClose;
  private Label lblLoan;
  private Label lblCurrentDebtLabel;
  private Label lblMaxLoanLabel;
  private Label lblCurrentDebt;
  private Label lblMaxLoan;
  private Label lblNoClaim;
  private Label lblShipValue;
  private Label lblNoClaimLabel;
  private Label lblShipValueLabel;
  private Label lblInsurance;
  private Label lblInsAmt;
  private Label lblInsAmtLabel;
  private Label lblMaxNoClaim;
  private final Game game = Game.CurrentGame();
  private final Commander cmdr = game.Commander();
  private final int MaxLoan = cmdr.getPoliceRecordScore() >= Consts.PoliceRecordScoreClean
      ? Math.min(25000, Math.max(1000, cmdr.Worth() / 5000 * 500)) : 500;

  public FormViewBank() {
    InitializeComponent();
    UpdateAll();
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    lblLoan = new Label();
    lblCurrentDebtLabel = new Label();
    lblMaxLoanLabel = new Label();
    lblCurrentDebt = new Label();
    lblMaxLoan = new Label();
    btnGetLoan = new Button();
    btnBuyInsurance = new Button();
    lblNoClaim = new Label();
    lblShipValue = new Label();
    lblNoClaimLabel = new Label();
    lblShipValueLabel = new Label();
    lblInsurance = new Label();
    lblInsAmt = new Label();
    lblInsAmtLabel = new Label();
    btnPayBack = new Button();
    btnClose = new Button();
    lblMaxNoClaim = new Label();
    SuspendLayout();
    // lblLoan
    lblLoan.setAutoSize(true);
    lblLoan.setFont(new Font("Microsoft Sans Serif", 12F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblLoan.setLocation(new Point(8, 8));
    lblLoan.setName("lblLoan");
    lblLoan.setSize(new FormSize(44, 19));
    lblLoan.setTabIndex(1);
    lblLoan.setText("Loan");
    // lblCurrentDebtLabel
    lblCurrentDebtLabel.setAutoSize(true);
    lblCurrentDebtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblCurrentDebtLabel.setLocation(new Point(16, 32));
    lblCurrentDebtLabel.setName("lblCurrentDebtLabel");
    lblCurrentDebtLabel.setSize(new FormSize(75, 13));
    lblCurrentDebtLabel.setTabIndex(2);
    lblCurrentDebtLabel.setText("Current Debt:");
    // lblMaxLoanLabel
    lblMaxLoanLabel.setAutoSize(true);
    lblMaxLoanLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
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
    // btnGetLoan
    btnGetLoan.setFlatStyle(FlatStyle.Flat);
    btnGetLoan.setLocation(new Point(16, 72));
    btnGetLoan.setName("btnGetLoan");
    btnGetLoan.setSize(new FormSize(61, 22));
    btnGetLoan.setTabIndex(1);
    btnGetLoan.setText("Get Loan");
    btnGetLoan.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnGetLoan_Click(sender, e);
      }
    });
    // btnBuyInsurance
    btnBuyInsurance.setFlatStyle(FlatStyle.Flat);
    btnBuyInsurance.setLocation(new Point(16, 196));
    btnBuyInsurance.setName("btnBuyInsurance");
    btnBuyInsurance.setSize(new FormSize(90, 22));
    btnBuyInsurance.setTabIndex(3);
    btnBuyInsurance.setText("Stop Insurance");
    btnBuyInsurance.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnBuyInsurance_Click(sender, e);
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
    lblNoClaimLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblNoClaimLabel.setLocation(new Point(16, 156));
    lblNoClaimLabel.setName("lblNoClaimLabel");
    lblNoClaimLabel.setSize(new FormSize(106, 13));
    lblNoClaimLabel.setTabIndex(25);
    lblNoClaimLabel.setText("No-Claim Discount:");
    // lblShipValueLabel
    lblShipValueLabel.setAutoSize(true);
    lblShipValueLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblShipValueLabel.setLocation(new Point(16, 136));
    lblShipValueLabel.setName("lblShipValueLabel");
    lblShipValueLabel.setSize(new FormSize(65, 13));
    lblShipValueLabel.setTabIndex(24);
    lblShipValueLabel.setText("Ship Value:");
    // lblInsurance
    lblInsurance.setAutoSize(true);
    lblInsurance.setFont(new Font("Microsoft Sans Serif", 12F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
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
    lblInsAmtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    lblInsAmtLabel.setLocation(new Point(16, 176));
    lblInsAmtLabel.setName("lblInsAmtLabel");
    lblInsAmtLabel.setSize(new FormSize(38, 13));
    lblInsAmtLabel.setTabIndex(29);
    lblInsAmtLabel.setText("Costs:");
    // btnPayBack
    btnPayBack.setFlatStyle(FlatStyle.Flat);
    btnPayBack.setLocation(new Point(88, 72));
    btnPayBack.setName("btnPayBack");
    btnPayBack.setSize(new FormSize(90, 22));
    btnPayBack.setTabIndex(2);
    btnPayBack.setText("Pay Back Loan");
    btnPayBack.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPayBack_Click(sender, e);
      }
    });
    // btnClose
    btnClose.setDialogResult(DialogResult.Cancel);
    btnClose.setLocation(new Point(-32, -32));
    btnClose.setName("btnClose");
    btnClose.setSize(new FormSize(26, 27));
    btnClose.setTabIndex(32);
    btnClose.setTabStop(false);
    btnClose.setText("X");
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
    setCancelButton(btnClose);
    setClientSize(new FormSize(226, 231));
    Controls.addAll(Arrays.asList(
        lblMaxNoClaim,
        btnClose,
        btnPayBack,
        lblInsAmt,
        lblInsAmtLabel,
        lblNoClaimLabel,
        lblShipValueLabel,
        lblInsurance,
        lblMaxLoanLabel,
        lblCurrentDebtLabel,
        lblLoan,
        btnBuyInsurance,
        lblNoClaim,
        lblShipValue,
        btnGetLoan,
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
  }

  private void UpdateAll() {
    // Loan Info
    lblCurrentDebt.setText(Functions.FormatMoney(cmdr.getDebt()));
    lblMaxLoan.setText(Functions.FormatMoney(MaxLoan));
    btnPayBack.setVisible((cmdr.getDebt() > 0));
    // Insurance Info
    lblShipValue.setText(Functions.FormatMoney(cmdr.getShip().BaseWorth(true)));
    lblNoClaim.setText(Functions.FormatPercent(cmdr.NoClaim()));
    lblMaxNoClaim.setVisible((cmdr.NoClaim() == Consts.MaxNoClaim));
    lblInsAmt.setText(Functions.StringVars(Strings.MoneyRateSuffix, Functions.FormatMoney(game.InsuranceCosts())));
    btnBuyInsurance.setText(Functions.StringVars("^1 Insurance", cmdr.getInsurance() ? "Stop" : "Buy"));
  }

  private void btnGetLoan_Click(Object sender, EventArgs e) {
    if(cmdr.getDebt() >= MaxLoan) {
      FormAlert.Alert(AlertType.DebtTooLargeLoan, this);
    } else {
      FormGetLoan form = new FormGetLoan(MaxLoan - cmdr.getDebt());
      if(form.ShowDialog(this) == DialogResult.OK) {
        cmdr.setCash(cmdr.getCash() + form.Amount());
        cmdr.setDebt(cmdr.getDebt() + form.Amount());
        UpdateAll();
        game.getParentWindow().UpdateAll();
      }
    }
  }

  private void btnPayBack_Click(Object sender, EventArgs e) {
    if(cmdr.getDebt() == 0) {
      FormAlert.Alert(AlertType.DebtNone, this);
    } else {
      FormPayBackLoan form = new FormPayBackLoan();
      if(form.ShowDialog(this) == DialogResult.OK) {
        cmdr.setCash(cmdr.getCash() - form.Amount());
        cmdr.setDebt(cmdr.getDebt() - form.Amount());
        UpdateAll();
        game.getParentWindow().UpdateAll();
      }
    }
  }

  private void btnBuyInsurance_Click(Object sender, EventArgs e) {
    if(cmdr.getInsurance()) {
      if(FormAlert.Alert(AlertType.InsuranceStop, this) == DialogResult.Yes) {
        cmdr.setInsurance(false);
        cmdr.NoClaim(0);
      }
    } else if(!cmdr.getShip().getEscapePod()) {
      FormAlert.Alert(AlertType.InsuranceNoEscapePod, this);
    } else {
      cmdr.setInsurance(true);
      cmdr.NoClaim(0);
    }
    UpdateAll();
    game.getParentWindow().UpdateAll();
  }
}
