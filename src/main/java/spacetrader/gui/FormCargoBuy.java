package spacetrader.gui;
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
import org.gts.bst.cargo.CargoBuyOp;
import spacetrader.Commander;
import spacetrader.Consts;
import spacetrader.Functions;
import spacetrader.Game;
import spacetrader.Strings;


public class FormCargoBuy extends WinformForm {
  private final Game game = Game.CurrentGame();
  private final Commander cmdr = game.Commander();
  private Button btnOk;
  private Button btnAll;
  private Button btnNone;
  private Label lblQuestion;
  private Label lblStatement;
  private Label lblAvailable;
  private Label lblAfford;
  private NumericUpDown numAmount;

  public FormCargoBuy(int item, int maxAmount, CargoBuyOp op) {
    InitializeComponent();
    numAmount.setMaximum(maxAmount);
    numAmount.setValue(numAmount.getMinimum());
    setText(Functions.StringVars(Strings.CargoTitle, Strings.CargoBuyOps[op.id], Consts.TradeItems[item].Name()));
    lblQuestion.setText(Functions.StringVars("How many do you want to ^1?", Strings.CargoBuyOps[op.id].toLowerCase()));
    switch(op) {
      case BuySystem:
        lblStatement.setText(Functions.StringVars("At ^1 each, you can buy up to ^2.", Functions.FormatMoney(game.PriceCargoBuy()[item]), Functions.FormatNumber(maxAmount)));
        setHeight(btnOk.getTop() + btnOk.getHeight() + 34);
        break;
      case BuyTrader:
        int afford = Math.min(cmdr.getCash() / game.PriceCargoBuy()[item], cmdr.getShip().FreeCargoBays());
        if(afford < maxAmount) {
          numAmount.setMaximum(afford);
        }
        lblStatement.setText(Functions.StringVars("The trader wants to sell ^1 for the price of ^2 each.", Consts.TradeItems[item].Name(), Functions.FormatMoney(game.PriceCargoBuy()[item])));
        lblAvailable.setText(Functions.StringVars("The trader has ^1 for sale.", Functions.Multiples(game.getOpponent().Cargo()[item], Strings.CargoUnit)));
        lblAfford.setText(Functions.StringVars("You can afford to buy ^1.", Functions.Multiples(afford, Strings.CargoUnit)));
        lblAvailable.setVisible(true);
        lblAfford.setVisible(true);
        btnOk.setTop(btnOk.getTop() + 26);
        btnAll.setTop(btnAll.getTop() + 26);
        btnNone.setTop(btnNone.getTop() + 26);
        lblQuestion.setTop(lblQuestion.getTop() + 26);
        numAmount.setTop(numAmount.getTop() + 26);
        break;
      case InPlunder:
        lblStatement.setText(Functions.StringVars("Your victim has ^1 of these goods.", Functions.FormatNumber(game.getOpponent().Cargo()[item])));
        setHeight(btnOk.getTop() + btnOk.getHeight() + 34);
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
    lblAvailable = new Label();
    lblAfford = new Label();
    ((ISupportInitialize)(numAmount)).BeginInit();
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
    // btnOk
    btnOk.setDialogResult(DialogResult.OK);
    btnOk.setFlatStyle(FlatStyle.Flat);
    btnOk.setLocation(new Point(95, 48));
    btnOk.setName("btnOk");
    btnOk.setSize(new FormSize(41, 22));
    btnOk.setTabIndex(2);
    btnOk.setText("Ok");
    // btnAll
    btnAll.setDialogResult(DialogResult.OK);
    btnAll.setFlatStyle(FlatStyle.Flat);
    btnAll.setLocation(new Point(143, 48));
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
    btnNone.setLocation(new Point(191, 48));
    btnNone.setName("btnNone");
    btnNone.setSize(new FormSize(41, 22));
    btnNone.setTabIndex(4);
    btnNone.setText("None");
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
    setAcceptButton(btnOk);
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnNone);
    setClientSize(new FormSize(326, 105));
    setControlBox(false);
    Controls.add(btnNone);
    Controls.add(btnAll);
    Controls.add(btnOk);
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
    ((ISupportInitialize)(numAmount)).EndInit();
    ResumeLayout(false);
  }

  private void btnAll_Click(Object sender, EventArgs e) {
    numAmount.setValue(numAmount.getMaximum());
  }

  public int Amount() {
    return numAmount.getValue();
  }
}
