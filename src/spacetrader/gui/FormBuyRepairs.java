package spacetrader.gui;
import java.awt.Point;
import java.util.Arrays;
import javax.swing.UnsupportedLookAndFeelException;
import jwinforms.Button;
import jwinforms.DialogResult;
import jwinforms.EventArgs;
import jwinforms.FlatStyle;
import jwinforms.FormBorderStyle;
import jwinforms.FormStartPosition;
import jwinforms.ISupportInitialize;
import jwinforms.Label;
import jwinforms.NumericUpDown;
import jwinforms.FormSize;
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
    numAmount.setMaximum(Math.min(cmdr.getCash(), (cmdr.getShip().HullStrength() - cmdr.getShip().getHull())
        * cmdr.getShip().getRepairCost()));
    numAmount.setValue(numAmount.getMaximum());
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    this.lblQuestion = new Label();
    this.numAmount = new NumericUpDown();
    this.btnOk = new Button();
    this.btnMax = new Button();
    this.btnNothing = new Button();
    ((ISupportInitialize)(this.numAmount)).BeginInit();
    this.SuspendLayout();
    // lblQuestion
    this.lblQuestion.setAutoSize(true);
    this.lblQuestion.setLocation(new Point(8, 8));
    this.lblQuestion.setName("lblQuestion");
    this.lblQuestion.setSize(new FormSize(227, 13));
    this.lblQuestion.setTabIndex(3);
    this.lblQuestion.setText("How much do you want to spend on repairs?");
    // numAmount
    this.numAmount.setLocation(new Point(232, 6));
    this.numAmount.setMaximum(999);
    this.numAmount.setMinimum(1);
    this.numAmount.setName("numAmount");
    this.numAmount.setSize(new FormSize(44, 20));
    this.numAmount.setTabIndex(1);
    this.numAmount.setValue(888);
    // btnOk
    this.btnOk.setDialogResult(DialogResult.OK);
    this.btnOk.setFlatStyle(FlatStyle.Flat);
    this.btnOk.setLocation(new Point(69, 32));
    this.btnOk.setName("btnOk");
    this.btnOk.setSize(new FormSize(41, 22));
    this.btnOk.setTabIndex(2);
    this.btnOk.setText("Ok");
    // btnMax
    this.btnMax.setDialogResult(DialogResult.OK);
    this.btnMax.setFlatStyle(FlatStyle.Flat);
    this.btnMax.setLocation(new Point(117, 32));
    this.btnMax.setName("btnMax");
    this.btnMax.setSize(new FormSize(41, 22));
    this.btnMax.setTabIndex(3);
    this.btnMax.setText("Max");
    // btnNothing
    this.btnNothing.setDialogResult(DialogResult.Cancel);
    this.btnNothing.setFlatStyle(FlatStyle.Flat);
    this.btnNothing.setLocation(new Point(165, 32));
    this.btnNothing.setName("btnNothing");
    this.btnNothing.setSize(new FormSize(53, 22));
    this.btnNothing.setTabIndex(4);
    this.btnNothing.setText("Nothing");
    // FormBuyRepairs
    this.setAcceptButton(this.btnOk);
    this.setAutoScaleBaseSize(new FormSize(5, 13));
    this.setCancelButton(this.btnNothing);
    this.setClientSize(new FormSize(286, 63));
    this.setControlBox(false);
    this.Controls.addAll(Arrays.asList(new WinformControl[] {this.btnNothing, this.btnMax, this.btnOk, this.numAmount, this.lblQuestion}));
    this.setFormBorderStyle(FormBorderStyle.FixedDialog);
    this.setName("FormBuyRepairs");
    this.setShowInTaskbar(false);
    this.setStartPosition(FormStartPosition.CenterParent);
    this.setText("Hull Repair");
    ((ISupportInitialize)(this.numAmount)).EndInit();
    this.ResumeLayout(false);
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
