package spacetrader.gui;
import jwinforms.Button;
import jwinforms.DialogResult;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.FlatStyle;
import jwinforms.FormBorderStyle;
import jwinforms.FormStartPosition;
import jwinforms.ISupportInitialize;
import jwinforms.Label;
import jwinforms.NumericUpDown;
import jwinforms.Size;
import jwinforms.WinformForm;
import spacetrader.Commander;
import spacetrader.Functions;
import spacetrader.Game;
import spacetrader.Strings;


public class FormPayBackLoan extends WinformForm {
  private Button btnOk;
  private Button btnMax;
  private Button btnNothing;
  private Label lblQuestion;
  private Label lblStatement;
  private NumericUpDown numAmount;
  private Game game = Game.CurrentGame();

  public FormPayBackLoan() {
    InitializeComponent();
    Commander cmdr = game.Commander();
    int max = Math.min(cmdr.getDebt(), cmdr.getCash());
    numAmount.setMaximum(max);
    numAmount.setValue(numAmount.getMinimum());
    lblStatement.setText(Functions.StringVars(Strings.BankLoanStatementDebt, Functions.Multiples(cmdr.getDebt(), Strings.MoneyUnit)));
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    this.lblQuestion = new Label();
    this.numAmount = new NumericUpDown();
    this.btnOk = new Button();
    this.btnMax = new Button();
    this.btnNothing = new Button();
    this.lblStatement = new Label();
    ((ISupportInitialize)(this.numAmount)).BeginInit();
    this.SuspendLayout();
    // lblQuestion
    this.lblQuestion.setAutoSize(true);
    this.lblQuestion.setLocation(new java.awt.Point(8, 24));
    this.lblQuestion.setName("lblQuestion");
    this.lblQuestion.setSize(new Size(188, 13));
    this.lblQuestion.setTabIndex(3);
    this.lblQuestion.setText("How much do you want to pay back?");
    // numAmount
    this.numAmount.setLocation(new java.awt.Point(196, 22));
    this.numAmount.setMaximum(999999);
    this.numAmount.setMinimum(1);
    this.numAmount.setName("numAmount");
    this.numAmount.setSize(new Size(58, 20));
    this.numAmount.setTabIndex(1);
    this.numAmount.ThousandsSeparator = true;
    this.numAmount.setValue(88888);
    // btnOk
    this.btnOk.setDialogResult(DialogResult.OK);
    this.btnOk.setFlatStyle(FlatStyle.Flat);
    this.btnOk.setLocation(new java.awt.Point(58, 48));
    this.btnOk.setName("btnOk");
    this.btnOk.setSize(new Size(41, 22));
    this.btnOk.setTabIndex(2);
    this.btnOk.setText("Ok");
    // btnMax
    this.btnMax.setDialogResult(DialogResult.OK);
    this.btnMax.setFlatStyle(FlatStyle.Flat);
    this.btnMax.setLocation(new java.awt.Point(106, 48));
    this.btnMax.setName("btnMax");
    this.btnMax.setSize(new Size(41, 22));
    this.btnMax.setTabIndex(3);
    this.btnMax.setText("Max");
    this.btnMax.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnMax_Click(sender, e);
      }
    });
    // btnNothing
    this.btnNothing.setDialogResult(DialogResult.Cancel);
    this.btnNothing.setFlatStyle(FlatStyle.Flat);
    this.btnNothing.setLocation(new java.awt.Point(154, 48));
    this.btnNothing.setName("btnNothing");
    this.btnNothing.setSize(new Size(53, 22));
    this.btnNothing.setTabIndex(4);
    this.btnNothing.setText("Nothing");
    // lblStatement
    this.lblStatement.setLocation(new java.awt.Point(8, 8));
    this.lblStatement.setName("lblStatement");
    this.lblStatement.setSize(new Size(176, 13));
    this.lblStatement.setTabIndex(5);
    this.lblStatement.setText("You have a debt of 88,888 credits.");
    // FormPayBackLoan
    this.setAcceptButton(this.btnOk);
    this.setAutoScaleBaseSize(new Size(5, 13));
    this.setCancelButton(this.btnNothing);
    this.setClientSize(new Size(264, 79));
    this.setControlBox(false);
    this.Controls.addAll(this.lblStatement, this.btnNothing, this.btnMax, this.btnOk, this.numAmount, this.lblQuestion);
    this.setFormBorderStyle(FormBorderStyle.FixedDialog);
    this.setName("FormPayBackLoan");
    this.setShowInTaskbar(false);
    this.setStartPosition(FormStartPosition.CenterParent);
    this.setText("Pay Back Loan");
    ((ISupportInitialize)(this.numAmount)).EndInit();
    this.ResumeLayout(false);
  }

  private void btnMax_Click(Object sender, EventArgs e) {
    numAmount.setValue(numAmount.getMaximum());
  }

  public int Amount() {
    return numAmount.getValue();
  }

  public static void main(String[] args) throws Exception {
    FormPayBackLoan form = new FormPayBackLoan();
    Launcher.runForm(form);
    System.out.println(form.Amount());
  }
}
