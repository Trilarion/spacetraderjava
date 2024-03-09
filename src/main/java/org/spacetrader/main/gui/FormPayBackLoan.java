package org.spacetrader.main.gui;
import java.awt.Point;
import jwinforms.Button;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.FormSize;
import jwinforms.ISupportInitialize;
import jwinforms.Label;
import jwinforms.NumericUpDown;
import jwinforms.WinformForm;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;
import org.spacetrader.main.Commander;
import org.spacetrader.main.Functions;
import org.spacetrader.main.Game;
import org.spacetrader.main.Strings;


public class FormPayBackLoan extends WinformForm {
  private Button btnOk;
  private Button btnMax;
  private Button btnNothing;
  private Label lblQuestion;
  private Label lblStatement;
  private NumericUpDown numAmount;
  private final Game game = Game.CurrentGame();
  private final Commander cmdr = game.Commander();

  public FormPayBackLoan() {
    InitializeComponent();
    int max = Math.min(cmdr.getDebt(), cmdr.getCash());
    numAmount.setMaximum(max);
    numAmount.setValue(numAmount.getMinimum());
    lblStatement.setText(Functions.StringVars("You have a debt of ^1.", Functions.Multiples(cmdr.getDebt(), Strings.MoneyUnit)));
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    lblQuestion = new Label();
    numAmount = new NumericUpDown();
    btnOk = new Button();
    btnMax = new Button();
    btnNothing = new Button();
    lblStatement = new Label();
    ((ISupportInitialize)(numAmount)).BeginInit();
    SuspendLayout();
    // lblQuestion
    lblQuestion.setAutoSize(true);
    lblQuestion.setLocation(new Point(8, 24));
    lblQuestion.setName("lblQuestion");
    lblQuestion.setSize(new FormSize(188, 13));
    lblQuestion.setTabIndex(3);
    lblQuestion.setText("How much do you want to pay back?");
    // numAmount
    numAmount.setLocation(new Point(196, 22));
    numAmount.setMaximum(999999);
    numAmount.setMinimum(1);
    numAmount.setName("numAmount");
    numAmount.setSize(new FormSize(58, 20));
    numAmount.setTabIndex(1);
    numAmount.ThousandsSeparator = true;
    numAmount.setValue(88888);
    // btnOk
    btnOk.setDialogResult(DialogResult.OK);
    btnOk.setFlatStyle(FlatStyle.Flat);
    btnOk.setLocation(new Point(58, 48));
    btnOk.setName("btnOk");
    btnOk.setSize(new FormSize(41, 22));
    btnOk.setTabIndex(2);
    btnOk.setText("Ok");
    // btnMax
    btnMax.setDialogResult(DialogResult.OK);
    btnMax.setFlatStyle(FlatStyle.Flat);
    btnMax.setLocation(new Point(106, 48));
    btnMax.setName("btnMax");
    btnMax.setSize(new FormSize(41, 22));
    btnMax.setTabIndex(3);
    btnMax.setText("Max");
    btnMax.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnMax_Click();
      }
    });
    // btnNothing
    btnNothing.setDialogResult(DialogResult.Cancel);
    btnNothing.setFlatStyle(FlatStyle.Flat);
    btnNothing.setLocation(new Point(154, 48));
    btnNothing.setName("btnNothing");
    btnNothing.setSize(new FormSize(53, 22));
    btnNothing.setTabIndex(4);
    btnNothing.setText("Nothing");
    // lblStatement
    lblStatement.setLocation(new Point(8, 8));
    lblStatement.setName("lblStatement");
    lblStatement.setSize(new FormSize(176, 13));
    lblStatement.setTabIndex(5);
    lblStatement.setText("You have a debt of 88,888 credits.");
    // FormPayBackLoan
    setAcceptButton(btnOk);
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnNothing);
    setClientSize(new FormSize(264, 79));
    setControlBox(false);
    Controls.addAll(lblStatement, btnNothing, btnMax, btnOk, numAmount, lblQuestion);
    setFormBorderStyle(FormBorderStyle.FixedDialog);
    setName("FormPayBackLoan");
    setShowInTaskbar(false);
    setStartPosition(FormStartPosition.CenterParent);
    setText("Pay Back Loan");
    ((ISupportInitialize)(numAmount)).EndInit();
    ResumeLayout(false);
  }

  private void btnMax_Click() {
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
