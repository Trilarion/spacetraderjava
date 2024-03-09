package org.spacetrader.main.gui;
import java.awt.Point;
import java.util.Arrays;
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
import org.spacetrader.main.Game;


public class FormBuyFuel extends WinformForm {
  private final Game game = Game.CurrentGame();
  private final Commander cmdr = game.Commander();
  private Button btnOk;
  private Button btnMax;
  private Button btnNothing;
  private Label lblQuestion;
  private NumericUpDown numAmount;

  public FormBuyFuel() {
    InitializeComponent();
    numAmount.setMaximum(Math.min(cmdr.getCash(), (cmdr.getShip().FuelTanks() - cmdr.getShip().getFuel()) * cmdr.getShip().getFuelCost()));
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
    lblQuestion.setSize(new FormSize(211, 13));
    lblQuestion.setTabIndex(3);
    lblQuestion.setText("How much do you want to spend on fuel?");
    // numAmount
    numAmount.setLocation(new Point(216, 6));
    numAmount.setMaximum(999);
    numAmount.setMinimum(1);
    numAmount.setName("numAmount");
    numAmount.setSize(new FormSize(44, 20));
    numAmount.setTabIndex(1);
    numAmount.setValue(888);
    // btnOk
    btnOk.setDialogResult(DialogResult.OK);
    btnOk.setFlatStyle(FlatStyle.Flat);
    btnOk.setLocation(new Point(61, 32));
    btnOk.setName("btnOk");
    btnOk.setSize(new FormSize(41, 22));
    btnOk.setTabIndex(2);
    btnOk.setText("Ok");
    // btnMax
    btnMax.setDialogResult(DialogResult.OK);
    btnMax.setFlatStyle(FlatStyle.Flat);
    btnMax.setLocation(new Point(109, 32));
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
    btnNothing.setLocation(new Point(157, 32));
    btnNothing.setName("btnNothing");
    btnNothing.setSize(new FormSize(53, 22));
    btnNothing.setTabIndex(4);
    btnNothing.setText("Nothing");
    // FormBuyFuel
    setAcceptButton(btnOk);
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnNothing);
    setClientSize(new FormSize(270, 63));
    setControlBox(false);
    Controls.addAll(Arrays.asList(btnNothing, btnMax, btnOk, numAmount, lblQuestion));
    setFormBorderStyle(FormBorderStyle.FixedDialog);
    setName("FormBuyFuel");
    setShowInTaskbar(false);
    setStartPosition(FormStartPosition.CenterParent);
    setText("Buy Fuel");
    ((ISupportInitialize)(numAmount)).EndInit();
    ResumeLayout(false);
  }

  private void btnMax_Click() {
    numAmount.setValue(numAmount.getMaximum());
  }

  public int Amount() {
    return numAmount.getValue();
  }
}
