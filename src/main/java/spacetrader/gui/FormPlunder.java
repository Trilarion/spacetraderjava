package spacetrader.gui;
import java.awt.Point;
import jwinforms.Button;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.FormSize;
import jwinforms.Label;
import jwinforms.WinformForm;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FlatStyle;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;
import spacetrader.Game;
import spacetrader.Ship;


public class FormPlunder extends WinformForm {
  private final Game game = Game.CurrentGame();
  private Button btnPlunderAll9;
  private Button btnPlunderQty9;
  private Button btnPlunderAll8;
  private Button btnPlunderQty8;
  private Button btnPlunderAll7;
  private Button btnPlunderQty7;
  private Button btnPlunderAll6;
  private Button btnPlunderQty6;
  private Button btnPlunderAll5;
  private Button btnPlunderQty5;
  private Button btnPlunderAll4;
  private Button btnPlunderQty4;
  private Button btnPlunderAll3;
  private Button btnPlunderQty3;
  private Button btnPlunderAll2;
  private Button btnPlunderQty2;
  private Button btnPlunderAll1;
  private Button btnPlunderQty1;
  private Button btnPlunderAll0;
  private Button btnPlunderQty0;
  private Button btnDone;
  private Button btnJettison;
  private Button[] btnPlunderQty;
  private Button[] btnPlunderAll;
  private Label lblTradeCmdty9;
  private Label lblTradeCmdty8;
  private Label lblTradeCmdty2;
  private Label lblTradeCmdty0;
  private Label lblTradeCmdty1;
  private Label lblTradeCmdty6;
  private Label lblTradeCmdty5;
  private Label lblTradeCmdty4;
  private Label lblTradeCmdty3;
  private Label lblTradeCmdty7;
  private Label lblBaysLabel;
  private Label lblBays;

  public FormPlunder() {
    InitializeComponent();
    btnPlunderQty = new Button[]{
      btnPlunderQty0, btnPlunderQty1, btnPlunderQty2, btnPlunderQty3, btnPlunderQty4,
      btnPlunderQty5, btnPlunderQty6, btnPlunderQty7, btnPlunderQty8, btnPlunderQty9
    };
    btnPlunderAll = new Button[]{
      btnPlunderAll0, btnPlunderAll1, btnPlunderAll2, btnPlunderAll3, btnPlunderAll4,
      btnPlunderAll5, btnPlunderAll6, btnPlunderAll7, btnPlunderAll8, btnPlunderAll9
    };
    UpdateAll();
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    btnPlunderAll9 = new Button();
    btnPlunderQty9 = new Button();
    btnPlunderAll8 = new Button();
    btnPlunderQty8 = new Button();
    btnPlunderAll7 = new Button();
    btnPlunderQty7 = new Button();
    btnPlunderAll6 = new Button();
    btnPlunderQty6 = new Button();
    btnPlunderAll5 = new Button();
    btnPlunderQty5 = new Button();
    btnPlunderAll4 = new Button();
    btnPlunderQty4 = new Button();
    btnPlunderAll3 = new Button();
    btnPlunderQty3 = new Button();
    btnPlunderAll2 = new Button();
    btnPlunderQty2 = new Button();
    btnPlunderAll1 = new Button();
    btnPlunderQty1 = new Button();
    btnPlunderAll0 = new Button();
    btnPlunderQty0 = new Button();
    lblTradeCmdty9 = new Label();
    lblTradeCmdty8 = new Label();
    lblTradeCmdty2 = new Label();
    lblTradeCmdty0 = new Label();
    lblTradeCmdty1 = new Label();
    lblTradeCmdty6 = new Label();
    lblTradeCmdty5 = new Label();
    lblTradeCmdty4 = new Label();
    lblTradeCmdty3 = new Label();
    lblTradeCmdty7 = new Label();
    lblBaysLabel = new Label();
    lblBays = new Label();
    btnDone = new Button();
    btnJettison = new Button();
    SuspendLayout();
    // btnPlunderAll9
    btnPlunderAll9.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll9.setLocation(new Point(100, 220));
    btnPlunderAll9.setName("btnPlunderAll9");
    btnPlunderAll9.setSize(new FormSize(32, 22));
    btnPlunderAll9.setTabIndex(141);
    btnPlunderAll9.setText("All");
    btnPlunderAll9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty9
    btnPlunderQty9.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty9.setLocation(new Point(68, 220));
    btnPlunderQty9.setName("btnPlunderQty9");
    btnPlunderQty9.setSize(new FormSize(28, 22));
    btnPlunderQty9.setTabIndex(140);
    btnPlunderQty9.setText("88");
    btnPlunderQty9.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll8
    btnPlunderAll8.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll8.setLocation(new Point(100, 196));
    btnPlunderAll8.setName("btnPlunderAll8");
    btnPlunderAll8.setSize(new FormSize(32, 22));
    btnPlunderAll8.setTabIndex(139);
    btnPlunderAll8.setText("All");
    btnPlunderAll8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty8
    btnPlunderQty8.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty8.setLocation(new Point(68, 196));
    btnPlunderQty8.setName("btnPlunderQty8");
    btnPlunderQty8.setSize(new FormSize(28, 22));
    btnPlunderQty8.setTabIndex(138);
    btnPlunderQty8.setText("88");
    btnPlunderQty8.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll7
    btnPlunderAll7.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll7.setLocation(new Point(100, 172));
    btnPlunderAll7.setName("btnPlunderAll7");
    btnPlunderAll7.setSize(new FormSize(32, 22));
    btnPlunderAll7.setTabIndex(137);
    btnPlunderAll7.setText("All");
    btnPlunderAll7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty7
    btnPlunderQty7.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty7.setLocation(new Point(68, 172));
    btnPlunderQty7.setName("btnPlunderQty7");
    btnPlunderQty7.setSize(new FormSize(28, 22));
    btnPlunderQty7.setTabIndex(136);
    btnPlunderQty7.setText("88");
    btnPlunderQty7.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll6
    btnPlunderAll6.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll6.setLocation(new Point(100, 148));
    btnPlunderAll6.setName("btnPlunderAll6");
    btnPlunderAll6.setSize(new FormSize(32, 22));
    btnPlunderAll6.setTabIndex(135);
    btnPlunderAll6.setText("All");
    btnPlunderAll6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty6
    btnPlunderQty6.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty6.setLocation(new Point(68, 148));
    btnPlunderQty6.setName("btnPlunderQty6");
    btnPlunderQty6.setSize(new FormSize(28, 22));
    btnPlunderQty6.setTabIndex(134);
    btnPlunderQty6.setText("88");
    btnPlunderQty6.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll5
    btnPlunderAll5.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll5.setLocation(new Point(100, 124));
    btnPlunderAll5.setName("btnPlunderAll5");
    btnPlunderAll5.setSize(new FormSize(32, 22));
    btnPlunderAll5.setTabIndex(133);
    btnPlunderAll5.setText("All");
    btnPlunderAll5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty5
    btnPlunderQty5.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty5.setLocation(new Point(68, 124));
    btnPlunderQty5.setName("btnPlunderQty5");
    btnPlunderQty5.setSize(new FormSize(28, 22));
    btnPlunderQty5.setTabIndex(132);
    btnPlunderQty5.setText("88");
    btnPlunderQty5.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll4
    btnPlunderAll4.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll4.setLocation(new Point(100, 100));
    btnPlunderAll4.setName("btnPlunderAll4");
    btnPlunderAll4.setSize(new FormSize(32, 22));
    btnPlunderAll4.setTabIndex(131);
    btnPlunderAll4.setText("All");
    btnPlunderAll4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty4
    btnPlunderQty4.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty4.setLocation(new Point(68, 100));
    btnPlunderQty4.setName("btnPlunderQty4");
    btnPlunderQty4.setSize(new FormSize(28, 22));
    btnPlunderQty4.setTabIndex(130);
    btnPlunderQty4.setText("88");
    btnPlunderQty4.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll3
    btnPlunderAll3.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll3.setLocation(new Point(100, 76));
    btnPlunderAll3.setName("btnPlunderAll3");
    btnPlunderAll3.setSize(new FormSize(32, 22));
    btnPlunderAll3.setTabIndex(129);
    btnPlunderAll3.setText("All");
    btnPlunderAll3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty3
    btnPlunderQty3.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty3.setLocation(new Point(68, 76));
    btnPlunderQty3.setName("btnPlunderQty3");
    btnPlunderQty3.setSize(new FormSize(28, 22));
    btnPlunderQty3.setTabIndex(128);
    btnPlunderQty3.setText("88");
    btnPlunderQty3.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll2
    btnPlunderAll2.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll2.setLocation(new Point(100, 52));
    btnPlunderAll2.setName("btnPlunderAll2");
    btnPlunderAll2.setSize(new FormSize(32, 22));
    btnPlunderAll2.setTabIndex(127);
    btnPlunderAll2.setText("All");
    btnPlunderAll2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty2
    btnPlunderQty2.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty2.setLocation(new Point(68, 52));
    btnPlunderQty2.setName("btnPlunderQty2");
    btnPlunderQty2.setSize(new FormSize(28, 22));
    btnPlunderQty2.setTabIndex(126);
    btnPlunderQty2.setText("88");
    btnPlunderQty2.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll1
    btnPlunderAll1.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll1.setLocation(new Point(100, 28));
    btnPlunderAll1.setName("btnPlunderAll1");
    btnPlunderAll1.setSize(new FormSize(32, 22));
    btnPlunderAll1.setTabIndex(125);
    btnPlunderAll1.setText("All");
    btnPlunderAll1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty1
    btnPlunderQty1.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty1.setLocation(new Point(68, 28));
    btnPlunderQty1.setName("btnPlunderQty1");
    btnPlunderQty1.setSize(new FormSize(28, 22));
    btnPlunderQty1.setTabIndex(124);
    btnPlunderQty1.setText("88");
    btnPlunderQty1.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderAll0
    btnPlunderAll0.setFlatStyle(FlatStyle.Flat);
    btnPlunderAll0.setLocation(new Point(100, 4));
    btnPlunderAll0.setName("btnPlunderAll0");
    btnPlunderAll0.setSize(new FormSize(32, 22));
    btnPlunderAll0.setTabIndex(123);
    btnPlunderAll0.setText("All");
    btnPlunderAll0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // btnPlunderQty0
    btnPlunderQty0.setFlatStyle(FlatStyle.Flat);
    btnPlunderQty0.setLocation(new Point(68, 4));
    btnPlunderQty0.setName("btnPlunderQty0");
    btnPlunderQty0.setSize(new FormSize(28, 22));
    btnPlunderQty0.setTabIndex(122);
    btnPlunderQty0.setText("88");
    btnPlunderQty0.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnPlunder_Click(sender, e);
      }
    });
    // lblTradeCmdty9
    lblTradeCmdty9.setAutoSize(true);
    lblTradeCmdty9.setLocation(new Point(8, 224));
    lblTradeCmdty9.setName("lblTradeCmdty9");
    lblTradeCmdty9.setSize(new FormSize(41, 13));
    lblTradeCmdty9.setTabIndex(151);
    lblTradeCmdty9.setText("Robots");
    // lblTradeCmdty8
    lblTradeCmdty8.setAutoSize(true);
    lblTradeCmdty8.setLocation(new Point(8, 200));
    lblTradeCmdty8.setName("lblTradeCmdty8");
    lblTradeCmdty8.setSize(new FormSize(52, 13));
    lblTradeCmdty8.setTabIndex(150);
    lblTradeCmdty8.setText("Narcotics");
    // lblTradeCmdty2
    lblTradeCmdty2.setAutoSize(true);
    lblTradeCmdty2.setLocation(new Point(8, 56));
    lblTradeCmdty2.setName("lblTradeCmdty2");
    lblTradeCmdty2.setSize(new FormSize(31, 13));
    lblTradeCmdty2.setTabIndex(149);
    lblTradeCmdty2.setText("Food");
    // lblTradeCmdty0
    lblTradeCmdty0.setAutoSize(true);
    lblTradeCmdty0.setLocation(new Point(8, 8));
    lblTradeCmdty0.setName("lblTradeCmdty0");
    lblTradeCmdty0.setSize(new FormSize(36, 13));
    lblTradeCmdty0.setTabIndex(148);
    lblTradeCmdty0.setText("Water");
    // lblTradeCmdty1
    lblTradeCmdty1.setAutoSize(true);
    lblTradeCmdty1.setLocation(new Point(8, 32));
    lblTradeCmdty1.setName("lblTradeCmdty1");
    lblTradeCmdty1.setSize(new FormSize(27, 13));
    lblTradeCmdty1.setTabIndex(147);
    lblTradeCmdty1.setText("Furs");
    // lblTradeCmdty6
    lblTradeCmdty6.setAutoSize(true);
    lblTradeCmdty6.setLocation(new Point(8, 152));
    lblTradeCmdty6.setName("lblTradeCmdty6");
    lblTradeCmdty6.setSize(new FormSize(50, 13));
    lblTradeCmdty6.setTabIndex(146);
    lblTradeCmdty6.setText("Medicine");
    // lblTradeCmdty5
    lblTradeCmdty5.setAutoSize(true);
    lblTradeCmdty5.setLocation(new Point(8, 128));
    lblTradeCmdty5.setName("lblTradeCmdty5");
    lblTradeCmdty5.setSize(new FormSize(46, 13));
    lblTradeCmdty5.setTabIndex(145);
    lblTradeCmdty5.setText("Firearms");
    // lblTradeCmdty4
    lblTradeCmdty4.setAutoSize(true);
    lblTradeCmdty4.setLocation(new Point(8, 104));
    lblTradeCmdty4.setName("lblTradeCmdty4");
    lblTradeCmdty4.setSize(new FormSize(40, 13));
    lblTradeCmdty4.setTabIndex(144);
    lblTradeCmdty4.setText("Games");
    // lblTradeCmdty3
    lblTradeCmdty3.setAutoSize(true);
    lblTradeCmdty3.setLocation(new Point(8, 80));
    lblTradeCmdty3.setName("lblTradeCmdty3");
    lblTradeCmdty3.setSize(new FormSize(24, 13));
    lblTradeCmdty3.setTabIndex(143);
    lblTradeCmdty3.setText("Ore");
    // lblTradeCmdty7
    lblTradeCmdty7.setAutoSize(true);
    lblTradeCmdty7.setLocation(new Point(8, 176));
    lblTradeCmdty7.setName("lblTradeCmdty7");
    lblTradeCmdty7.setSize(new FormSize(53, 13));
    lblTradeCmdty7.setTabIndex(142);
    lblTradeCmdty7.setText("Machines");
    // lblBaysLabel
    lblBaysLabel.setAutoSize(true);
    lblBaysLabel.setLocation(new Point(144, 8));
    lblBaysLabel.setName("lblBaysLabel");
    lblBaysLabel.setSize(new FormSize(33, 13));
    lblBaysLabel.setTabIndex(152);
    lblBaysLabel.setText("Bays:");
    // lblBays
    lblBays.setLocation(new Point(176, 8));
    lblBays.setName("lblBays");
    lblBays.setSize(new FormSize(48, 13));
    lblBays.setTabIndex(153);
    lblBays.setText("888/888");
    // btnDone
    btnDone.setDialogResult(DialogResult.Cancel);
    btnDone.setFlatStyle(FlatStyle.Flat);
    btnDone.setLocation(new Point(87, 252));
    btnDone.setName("btnDone");
    btnDone.setSize(new FormSize(44, 22));
    btnDone.setTabIndex(154);
    btnDone.setText("Done");
    // btnJettison
    btnJettison.setFlatStyle(FlatStyle.Flat);
    btnJettison.setLocation(new Point(150, 24));
    btnJettison.setName("btnJettison");
    btnJettison.setSize(new FormSize(53, 22));
    btnJettison.setTabIndex(155);
    btnJettison.setText("Jettison");
    btnJettison.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        btnJettison_Click();
      }
    });
    // FormPlunder
    setAcceptButton(btnDone);
    setAutoScaleBaseSize(new FormSize(5, 13));
    setCancelButton(btnDone);
    setClientSize(new FormSize(230, 283));
    Controls.add(btnJettison);
    Controls.add(btnDone);
    Controls.add(lblBays);
    Controls.add(lblBaysLabel);
    Controls.add(lblTradeCmdty9);
    Controls.add(lblTradeCmdty8);
    Controls.add(lblTradeCmdty2);
    Controls.add(lblTradeCmdty0);
    Controls.add(lblTradeCmdty1);
    Controls.add(lblTradeCmdty6);
    Controls.add(lblTradeCmdty5);
    Controls.add(lblTradeCmdty4);
    Controls.add(lblTradeCmdty3);
    Controls.add(lblTradeCmdty7);
    Controls.add(btnPlunderAll9);
    Controls.add(btnPlunderQty9);
    Controls.add(btnPlunderAll8);
    Controls.add(btnPlunderQty8);
    Controls.add(btnPlunderAll7);
    Controls.add(btnPlunderQty7);
    Controls.add(btnPlunderAll6);
    Controls.add(btnPlunderQty6);
    Controls.add(btnPlunderAll5);
    Controls.add(btnPlunderQty5);
    Controls.add(btnPlunderAll4);
    Controls.add(btnPlunderQty4);
    Controls.add(btnPlunderAll3);
    Controls.add(btnPlunderQty3);
    Controls.add(btnPlunderAll2);
    Controls.add(btnPlunderQty2);
    Controls.add(btnPlunderAll1);
    Controls.add(btnPlunderQty1);
    Controls.add(btnPlunderAll0);
    Controls.add(btnPlunderQty0);
    setFormBorderStyle(FormBorderStyle.FixedDialog);
    setMaximizeBox(false);
    setMinimizeBox(false);
    setName("FormPlunder");
    setShowInTaskbar(false);
    setStartPosition(FormStartPosition.CenterParent);
    setText("Plunder Cargo");
    ResumeLayout(false);
    PerformLayout();
  }

  private void Plunder(int tradeItem, boolean all) {
    game.CargoPlunder(tradeItem, all, this);
    UpdateAll();
  }

  private void UpdateAll() {
    Ship ship = game.Commander().getShip();
    Ship opp = game.getOpponent();
    for(int i = 0; i < btnPlunderQty.length; i++) {
      btnPlunderQty[i].setText("" + opp.Cargo()[i]);
    }
    lblBays.setText(ship.FilledCargoBays() + "/" + ship.CargoBays());
  }

  private void btnJettison_Click() {
    (new FormJettison()).ShowDialog(this);
  }

  private void btnPlunder_Click(Object sender, EventArgs e) {
    String name = ((Button)sender).getName();
    boolean all = name.indexOf("Qty") < 0;
    int index = Integer.parseInt(name.substring(name.length() - 1));
    Plunder(index, all);
  }
}
