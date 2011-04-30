package spacetrader.gui;
import java.awt.Point;
import java.util.Arrays;
import javax.swing.UnsupportedLookAndFeelException;
import jwinforms.Button;
import jwinforms.enums.DialogResult;
import jwinforms.EventArgs;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.FormSize;
import jwinforms.enums.FormStartPosition;
import jwinforms.ISupportInitialize;
import jwinforms.Label;
import jwinforms.NumericUpDown;
import jwinforms.WinformControl;
import jwinforms.WinformForm;
import spacetrader.Commander;
import spacetrader.Game;


public class FormBuyRepairs extends WinformForm {
  private Button btnOk;
  private Button btnMax;
  private Button btnNothing;
  private Label lblQuestion;
  private NumericUpDown numAmount;
  private Game game = Game.CurrentGame();

  public FormBuyRepairs() {
    InitializeComponent();
    Commander cmdr = game.Commander();
    numAmount.setMaximum(Math.min(cmdr.getCash(), (cmdr.getShip().HullStrength() - cmdr.getShip().getHull()) * cmdr.getShip().getRepairCost()));
    numAmount.setValue(numAmount.getMaximum());
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    lblQuestion = new Label();
    numAmount = new NumericUpDown();
    btnOk = new Button();
    btnMax = new Button();
    btnNothing = new Button();
    ((ISupportInitialize)(numAmount)).BeginInit();
    SuspendLayout();
    // lblQuestion
    lblQuestion.setAutoSize(true);
    lblQuestion.setLocation(new Point(8, 8));
    lblQuestion.setName("lblQuestion");
    lblQuestion.setSize(new FormSize(227, 13));
    lblQuestion.setTabIndex(3);
    lblQuestion.setText("How much do you want to spend on repairs?");
    // numAmount
    numAmount.setLocation(new Point(232, 6));
    numAmount.setMaximum(999);
    numAmount.setMinimum(1);
    numAmount.setName("numAmount");
    numAmount.setSize(new FormSize(44, 20));
    numAmount.setTabIndex(1);
    numAmount.setValue(888);
    // btnOk
    btnOk.setDialogResult(DialogResult.OK);
    btnOk.setFlatStyle(FlatStyle.Flat);
    btnOk.setLocation(new Point(69, 32));
    btnOk.setName("btnOk");
    btnOk.setSize(new FormSize(41, 22));
    btnOk.setTabIndex(2);
    btnOk.setText("Ok");
    // btnMax
    btnMax.setDialogResult(DialogResult.OK);
    btnMax.setFlatStyle(FlatStyle.Flat);
    btnMax.setLocation(new Point(117, 32));
    btnMax.setName("btnMax");
    btnMax.setSize(new FormSize(41, 22));
    btnMax.setTabIndex(3);
    btnMax.setText("Max");
    // btnNothing
    btnNothing.setDialogResult(DialogResult.Cancel);
    btnNothing.setFlatStyle(FlatStyle.Flat);
    btnNothing.setLocation(new Point(165, 32));
    btnNothing.setName("btnNothing");
    btnNothing.setSize(new FormSize(53, 22));
    btnNothing.setTabIndex(4);
    btnNothing.setText("Nothing");
    // FormBuyRepairs
    setAcceptButton(btnOk);
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnNothing);
    setClientSize(new FormSize(286, 63));
    setControlBox(false);
    Controls.addAll(Arrays.asList(new WinformControl[] {btnNothing, btnMax, btnOk, numAmount, lblQuestion}));
    setFormBorderStyle(FormBorderStyle.FixedDialog);
    setName("FormBuyRepairs");
    setShowInTaskbar(false);
    setStartPosition(FormStartPosition.CenterParent);
    setText("Hull Repair");
    ((ISupportInitialize)(numAmount)).EndInit();
    ResumeLayout(false);
  }

  // This action is not connected in the .NET version either.
  private void btnMax_Click(Object sender, EventArgs e) {
    numAmount.setValue(numAmount.getMaximum());
  }

  public int Amount() {
    return numAmount.getValue();
  }

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    FormBuyRepairs form = new FormBuyRepairs();
    Launcher.runForm(form);
    System.out.println(form.Amount());
  }
}
