package spacetrader.gui;
import jwinforms.BorderStyle;
import jwinforms.Button;
import jwinforms.DialogResult;
import jwinforms.EventArgs;
import jwinforms.EventHandler;
import jwinforms.FlatStyle;
import jwinforms.Font;
import jwinforms.FontStyle;
import jwinforms.FormBorderStyle;
import jwinforms.FormStartPosition;
import jwinforms.GraphicsUnit;
import jwinforms.GroupBox;
import jwinforms.Label;
import jwinforms.ListBox;
import jwinforms.PictureBox;
import jwinforms.Size;
import jwinforms.WinformForm;
import org.gts.bst.ship.equip.EquipmentType;
import org.gts.bst.ship.equip.GadgetType;
import spacetrader.Commander;
import spacetrader.Consts;
import spacetrader.Equipment;
import spacetrader.Functions;
import spacetrader.Gadget;
import spacetrader.Game;
import spacetrader.Shield;
import spacetrader.Ship;
import spacetrader.Strings;
import spacetrader.Weapon;
import spacetrader.enums.AlertType;


public class FormEquipment extends WinformForm {
  private Button btnClose;
  private Button btnBuy;
  private Button btnSell;
  private GroupBox boxSell;
  private GroupBox boxBuy;
  private GroupBox boxShipInfo;
  private Label lblName;
  private Label lblDescription;
  private Label lblSellPrice;
  private Label lblBuyPrice;
  private Label lblSellGadgets;
  private Label lblSellShields;
  private Label lblSellWeapons;
  private Label lblBuyGadgets;
  private Label lblBuyShields;
  private Label lblBuyWeapons;
  private Label lblBuyPriceLabel;
  private Label lblSellPriceLabel;
  private Label lblNameLabel;
  private Label lblTypeLabel;
  private Label lblType;
  private Label lblPowerLabel;
  private Label lblChargeLabel;
  private Label lblPower;
  private Label lblCharge;
  private Label lblSellWeaponNoSlots;
  private Label lblSellShieldNoSlots;
  private Label lblSellGadgetNoSlots;
  private Label lblBuyWeaponNone;
  private Label lblBuyShieldNone;
  private Label lblBuyGadgetNone;
  private ListBox lstSellWeapon;
  private ListBox lstSellShield;
  private ListBox lstSellGadget;
  private ListBox lstBuyGadget;
  private ListBox lstBuyShield;
  private ListBox lstBuyWeapon;
  private PictureBox picEquipment;
  private Game game = Game.CurrentGame();
  private Equipment[] equipBuy = Consts.EquipmentForSale;
  private Equipment selectedEquipment = null;
  private boolean sellSideSelected = false;
  private boolean handlingSelect = false;

  public FormEquipment() {
    InitializeComponent();
    UpdateBuy();
    UpdateSell();
  }

  // Required method for Designer support - do not modify the contents of this method with the code editor.
  private void InitializeComponent() {
    this.btnClose = new Button();
    this.boxSell = new GroupBox();
    this.lblSellGadgetNoSlots = new Label();
    this.lblSellShieldNoSlots = new Label();
    this.lblSellWeaponNoSlots = new Label();
    this.lblSellGadgets = new Label();
    this.lblSellShields = new Label();
    this.lblSellWeapons = new Label();
    this.lstSellGadget = new ListBox();
    this.lstSellShield = new ListBox();
    this.lstSellWeapon = new ListBox();
    this.boxBuy = new GroupBox();
    this.lblBuyGadgetNone = new Label();
    this.lblBuyShieldNone = new Label();
    this.lblBuyWeaponNone = new Label();
    this.lblBuyGadgets = new Label();
    this.lblBuyShields = new Label();
    this.lblBuyWeapons = new Label();
    this.lstBuyGadget = new ListBox();
    this.lstBuyShield = new ListBox();
    this.lstBuyWeapon = new ListBox();
    this.boxShipInfo = new GroupBox();
    this.lblCharge = new Label();
    this.lblPower = new Label();
    this.lblChargeLabel = new Label();
    this.lblPowerLabel = new Label();
    this.lblType = new Label();
    this.lblTypeLabel = new Label();
    this.lblNameLabel = new Label();
    this.btnSell = new Button();
    this.btnBuy = new Button();
    this.lblBuyPriceLabel = new Label();
    this.lblBuyPrice = new Label();
    this.lblSellPriceLabel = new Label();
    this.picEquipment = new PictureBox();
    this.lblSellPrice = new Label();
    this.lblDescription = new Label();
    this.lblName = new Label();
    this.boxSell.SuspendLayout();
    this.boxBuy.SuspendLayout();
    this.boxShipInfo.SuspendLayout();
    this.SuspendLayout();
    // btnClose
    this.btnClose.setDialogResult(DialogResult.Cancel);
    this.btnClose.setLocation(new java.awt.Point(-32, -32));
    this.btnClose.setName("btnClose");
    this.btnClose.setSize(new Size(32, 32));
    this.btnClose.setTabIndex(32);
    this.btnClose.setTabStop(false);
    this.btnClose.setText("X");
    // boxSell
    this.boxSell.Controls.add(this.lblSellGadgetNoSlots);
    this.boxSell.Controls.add(this.lblSellShieldNoSlots);
    this.boxSell.Controls.add(this.lblSellWeaponNoSlots);
    this.boxSell.Controls.add(this.lblSellGadgets);
    this.boxSell.Controls.add(this.lblSellShields);
    this.boxSell.Controls.add(this.lblSellWeapons);
    this.boxSell.Controls.add(this.lstSellGadget);
    this.boxSell.Controls.add(this.lstSellShield);
    this.boxSell.Controls.add(this.lstSellWeapon);
    this.boxSell.setLocation(new java.awt.Point(4, 2));
    this.boxSell.setName("boxSell");
    this.boxSell.setSize(new Size(144, 304));
    this.boxSell.setTabIndex(1);
    this.boxSell.setTabStop(false);
    this.boxSell.setText("Current Inventory");
    // lblSellGadgetNoSlots
    this.lblSellGadgetNoSlots.setLocation(new java.awt.Point(24, 228));
    this.lblSellGadgetNoSlots.setName("lblSellGadgetNoSlots");
    this.lblSellGadgetNoSlots.setSize(new Size(104, 16));
    this.lblSellGadgetNoSlots.setTabIndex(149);
    this.lblSellGadgetNoSlots.setText("No slots");
    this.lblSellGadgetNoSlots.setVisible(false);
    // lblSellShieldNoSlots
    this.lblSellShieldNoSlots.setLocation(new java.awt.Point(24, 132));
    this.lblSellShieldNoSlots.setName("lblSellShieldNoSlots");
    this.lblSellShieldNoSlots.setSize(new Size(104, 16));
    this.lblSellShieldNoSlots.setTabIndex(148);
    this.lblSellShieldNoSlots.setText("No slots");
    this.lblSellShieldNoSlots.setVisible(false);
    // lblSellWeaponNoSlots
    this.lblSellWeaponNoSlots.setLocation(new java.awt.Point(24, 36));
    this.lblSellWeaponNoSlots.setName("lblSellWeaponNoSlots");
    this.lblSellWeaponNoSlots.setSize(new Size(104, 16));
    this.lblSellWeaponNoSlots.setTabIndex(147);
    this.lblSellWeaponNoSlots.setText("No slots");
    this.lblSellWeaponNoSlots.setVisible(false);
    // lblSellGadgets
    this.lblSellGadgets.setAutoSize(true);
    this.lblSellGadgets.setLocation(new java.awt.Point(8, 212));
    this.lblSellGadgets.setName("lblSellGadgets");
    this.lblSellGadgets.setSize(new Size(47, 16));
    this.lblSellGadgets.setTabIndex(146);
    this.lblSellGadgets.setText("Gadgets");
    // lblSellShields
    this.lblSellShields.setAutoSize(true);
    this.lblSellShields.setLocation(new java.awt.Point(8, 116));
    this.lblSellShields.setName("lblSellShields");
    this.lblSellShields.setSize(new Size(41, 16));
    this.lblSellShields.setTabIndex(145);
    this.lblSellShields.setText("Shields");
    // lblSellWeapons
    this.lblSellWeapons.setAutoSize(true);
    this.lblSellWeapons.setLocation(new java.awt.Point(8, 20));
    this.lblSellWeapons.setName("lblSellWeapons");
    this.lblSellWeapons.setSize(new Size(52, 16));
    this.lblSellWeapons.setTabIndex(144);
    this.lblSellWeapons.setText("Weapons");
    // lstSellGadget
    this.lstSellGadget.setBorderStyle(BorderStyle.FixedSingle);
    this.lstSellGadget.setLocation(new java.awt.Point(8, 228));
    this.lstSellGadget.setName("lstSellGadget");
    this.lstSellGadget.setSize(new Size(128, 67));
    this.lstSellGadget.setTabIndex(3);
    this.lstSellGadget.setDoubleClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SellClick(sender, e);
      }
    });
    this.lstSellGadget.setSelectedIndexChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SelectedIndexChanged(sender, e);
      }
    });
    // lstSellShield
    this.lstSellShield.setBorderStyle(BorderStyle.FixedSingle);
    this.lstSellShield.setLocation(new java.awt.Point(8, 132));
    this.lstSellShield.setName("lstSellShield");
    this.lstSellShield.setSize(new Size(128, 67));
    this.lstSellShield.setTabIndex(2);
    this.lstSellShield.setDoubleClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SellClick(sender, e);
      }
    });
    this.lstSellShield.setSelectedIndexChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SelectedIndexChanged(sender, e);
      }
    });
    // lstSellWeapon
    this.lstSellWeapon.setBorderStyle(BorderStyle.FixedSingle);
    this.lstSellWeapon.setLocation(new java.awt.Point(8, 36));
    this.lstSellWeapon.setName("lstSellWeapon");
    this.lstSellWeapon.setSize(new Size(128, 67));
    this.lstSellWeapon.setTabIndex(1);
    this.lstSellWeapon.setDoubleClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SellClick(sender, e);
      }
    });
    this.lstSellWeapon.setSelectedIndexChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SelectedIndexChanged(sender, e);
      }
    });
    // boxBuy
    this.boxBuy.Controls.add(this.lblBuyGadgetNone);
    this.boxBuy.Controls.add(this.lblBuyShieldNone);
    this.boxBuy.Controls.add(this.lblBuyWeaponNone);
    this.boxBuy.Controls.add(this.lblBuyGadgets);
    this.boxBuy.Controls.add(this.lblBuyShields);
    this.boxBuy.Controls.add(this.lblBuyWeapons);
    this.boxBuy.Controls.add(this.lstBuyGadget);
    this.boxBuy.Controls.add(this.lstBuyShield);
    this.boxBuy.Controls.add(this.lstBuyWeapon);
    this.boxBuy.setLocation(new java.awt.Point(156, 2));
    this.boxBuy.setName("boxBuy");
    this.boxBuy.setSize(new Size(144, 304));
    this.boxBuy.setTabIndex(2);
    this.boxBuy.setTabStop(false);
    this.boxBuy.setText("Equipment For Sale");
    // lblBuyGadgetNone
    this.lblBuyGadgetNone.setLocation(new java.awt.Point(24, 228));
    this.lblBuyGadgetNone.setName("lblBuyGadgetNone");
    this.lblBuyGadgetNone.setSize(new Size(104, 16));
    this.lblBuyGadgetNone.setTabIndex(150);
    this.lblBuyGadgetNone.setText("None for sale");
    this.lblBuyGadgetNone.setVisible(false);
    // lblBuyShieldNone
    this.lblBuyShieldNone.setLocation(new java.awt.Point(24, 132));
    this.lblBuyShieldNone.setName("lblBuyShieldNone");
    this.lblBuyShieldNone.setSize(new Size(104, 16));
    this.lblBuyShieldNone.setTabIndex(149);
    this.lblBuyShieldNone.setText("None for sale");
    this.lblBuyShieldNone.setVisible(false);
    // lblBuyWeaponNone
    this.lblBuyWeaponNone.setLocation(new java.awt.Point(24, 36));
    this.lblBuyWeaponNone.setName("lblBuyWeaponNone");
    this.lblBuyWeaponNone.setSize(new Size(104, 16));
    this.lblBuyWeaponNone.setTabIndex(148);
    this.lblBuyWeaponNone.setText("None for sale");
    this.lblBuyWeaponNone.setVisible(false);
    // lblBuyGadgets
    this.lblBuyGadgets.setAutoSize(true);
    this.lblBuyGadgets.setLocation(new java.awt.Point(8, 212));
    this.lblBuyGadgets.setName("lblBuyGadgets");
    this.lblBuyGadgets.setSize(new Size(47, 16));
    this.lblBuyGadgets.setTabIndex(143);
    this.lblBuyGadgets.setText("Gadgets");
    // lblBuyShields
    this.lblBuyShields.setAutoSize(true);
    this.lblBuyShields.setLocation(new java.awt.Point(8, 116));
    this.lblBuyShields.setName("lblBuyShields");
    this.lblBuyShields.setSize(new Size(41, 16));
    this.lblBuyShields.setTabIndex(142);
    this.lblBuyShields.setText("Shields");
    // lblBuyWeapons
    this.lblBuyWeapons.setAutoSize(true);
    this.lblBuyWeapons.setLocation(new java.awt.Point(8, 20));
    this.lblBuyWeapons.setName("lblBuyWeapons");
    this.lblBuyWeapons.setSize(new Size(52, 16));
    this.lblBuyWeapons.setTabIndex(141);
    this.lblBuyWeapons.setText("Weapons");
    // lstBuyGadget
    this.lstBuyGadget.setBorderStyle(BorderStyle.FixedSingle);
    this.lstBuyGadget.setLocation(new java.awt.Point(8, 228));
    this.lstBuyGadget.setName("lstBuyGadget");
    this.lstBuyGadget.setSize(new Size(128, 67));
    this.lstBuyGadget.setTabIndex(6);
    this.lstBuyGadget.setDoubleClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        BuyClick(sender, e);
      }
    });
    this.lstBuyGadget.setSelectedIndexChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SelectedIndexChanged(sender, e);
      }
    });
    // lstBuyShield
    this.lstBuyShield.setBorderStyle(BorderStyle.FixedSingle);
    this.lstBuyShield.setLocation(new java.awt.Point(8, 132));
    this.lstBuyShield.setName("lstBuyShield");
    this.lstBuyShield.setSize(new Size(128, 67));
    this.lstBuyShield.setTabIndex(5);
    this.lstBuyShield.setDoubleClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        BuyClick(sender, e);
      }
    });
    this.lstBuyShield.setSelectedIndexChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SelectedIndexChanged(sender, e);
      }
    });
    // lstBuyWeapon
    this.lstBuyWeapon.setBorderStyle(BorderStyle.FixedSingle);
    this.lstBuyWeapon.setLocation(new java.awt.Point(8, 36));
    this.lstBuyWeapon.setName("lstBuyWeapon");
    this.lstBuyWeapon.setSize(new Size(128, 67));
    this.lstBuyWeapon.setTabIndex(4);
    this.lstBuyWeapon.setDoubleClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        BuyClick(sender, e);
      }
    });
    this.lstBuyWeapon.setSelectedIndexChanged(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SelectedIndexChanged(sender, e);
      }
    });
    // boxShipInfo
    this.boxShipInfo.Controls.add(this.lblCharge);
    this.boxShipInfo.Controls.add(this.lblPower);
    this.boxShipInfo.Controls.add(this.lblChargeLabel);
    this.boxShipInfo.Controls.add(this.lblPowerLabel);
    this.boxShipInfo.Controls.add(this.lblType);
    this.boxShipInfo.Controls.add(this.lblTypeLabel);
    this.boxShipInfo.Controls.add(this.lblNameLabel);
    this.boxShipInfo.Controls.add(this.btnSell);
    this.boxShipInfo.Controls.add(this.btnBuy);
    this.boxShipInfo.Controls.add(this.lblBuyPriceLabel);
    this.boxShipInfo.Controls.add(this.lblBuyPrice);
    this.boxShipInfo.Controls.add(this.lblSellPriceLabel);
    this.boxShipInfo.Controls.add(this.picEquipment);
    this.boxShipInfo.Controls.add(this.lblSellPrice);
    this.boxShipInfo.Controls.add(this.lblName);
    this.boxShipInfo.Controls.add(this.lblDescription);
    this.boxShipInfo.setLocation(new java.awt.Point(308, 2));
    this.boxShipInfo.setName("boxShipInfo");
    this.boxShipInfo.setSize(new Size(208, 304));
    this.boxShipInfo.setTabIndex(3);
    this.boxShipInfo.setTabStop(false);
    this.boxShipInfo.setText("Equipment Information");
    // lblCharge
    this.lblCharge.setLocation(new java.awt.Point(80, 164));
    this.lblCharge.setName("lblCharge");
    this.lblCharge.setSize(new Size(116, 16));
    this.lblCharge.setTabIndex(67);
    this.lblCharge.setText("888");
    // lblPower
    this.lblPower.setLocation(new java.awt.Point(80, 148));
    this.lblPower.setName("lblPower");
    this.lblPower.setSize(new Size(116, 16));
    this.lblPower.setTabIndex(66);
    this.lblPower.setText("888");
    // lblChargeLabel
    this.lblChargeLabel.setAutoSize(true);
    this.lblChargeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    this.lblChargeLabel.setLocation(new java.awt.Point(8, 164));
    this.lblChargeLabel.setName("lblChargeLabel");
    this.lblChargeLabel.setSize(new Size(46, 16));
    this.lblChargeLabel.setTabIndex(65);
    this.lblChargeLabel.setText("Charge:");
    // lblPowerLabel
    this.lblPowerLabel.setAutoSize(true);
    this.lblPowerLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    this.lblPowerLabel.setLocation(new java.awt.Point(8, 148));
    this.lblPowerLabel.setName("lblPowerLabel");
    this.lblPowerLabel.setSize(new Size(41, 16));
    this.lblPowerLabel.setTabIndex(64);
    this.lblPowerLabel.setText("Power:");
    // lblType
    this.lblType.setLocation(new java.awt.Point(80, 100));
    this.lblType.setName("lblType");
    this.lblType.setSize(new Size(116, 16));
    this.lblType.setTabIndex(63);
    this.lblType.setText("Weapon");
    // lblTypeLabel
    this.lblTypeLabel.setAutoSize(true);
    this.lblTypeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    this.lblTypeLabel.setLocation(new java.awt.Point(8, 100));
    this.lblTypeLabel.setName("lblTypeLabel");
    this.lblTypeLabel.setSize(new Size(34, 16));
    this.lblTypeLabel.setTabIndex(62);
    this.lblTypeLabel.setText("Type:");
    // lblNameLabel
    this.lblNameLabel.setAutoSize(true);
    this.lblNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    this.lblNameLabel.setLocation(new java.awt.Point(8, 84));
    this.lblNameLabel.setName("lblNameLabel");
    this.lblNameLabel.setSize(new Size(39, 16));
    this.lblNameLabel.setTabIndex(61);
    this.lblNameLabel.setText("Name:");
    // btnSell
    this.btnSell.setFlatStyle(FlatStyle.Flat);
    this.btnSell.setLocation(new java.awt.Point(103, 272));
    this.btnSell.setName("btnSell");
    this.btnSell.setSize(new Size(58, 22));
    this.btnSell.setTabIndex(8);
    this.btnSell.setText("Sell");
    this.btnSell.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        SellClick(sender, e);
      }
    });
    // btnBuy
    this.btnBuy.setFlatStyle(FlatStyle.Flat);
    this.btnBuy.setLocation(new java.awt.Point(31, 272));
    this.btnBuy.setName("btnBuy");
    this.btnBuy.setSize(new Size(58, 22));
    this.btnBuy.setTabIndex(7);
    this.btnBuy.setText("Buy");
    this.btnBuy.setClick(new EventHandler<Object, EventArgs>() {
      @Override
      public void handle(Object sender, EventArgs e) {
        BuyClick(sender, e);
      }
    });
    // lblBuyPriceLabel
    this.lblBuyPriceLabel.setAutoSize(true);
    this.lblBuyPriceLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    this.lblBuyPriceLabel.setLocation(new java.awt.Point(8, 116));
    this.lblBuyPriceLabel.setName("lblBuyPriceLabel");
    this.lblBuyPriceLabel.setSize(new Size(58, 16));
    this.lblBuyPriceLabel.setTabIndex(57);
    this.lblBuyPriceLabel.setText("Buy Price:");
    // lblBuyPrice
    this.lblBuyPrice.setLocation(new java.awt.Point(80, 116));
    this.lblBuyPrice.setName("lblBuyPrice");
    this.lblBuyPrice.setSize(new Size(116, 16));
    this.lblBuyPrice.setTabIndex(56);
    this.lblBuyPrice.setText("888,888 cr.");
    // lblSellPriceLabel
    this.lblSellPriceLabel.setAutoSize(true);
    this.lblSellPriceLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte)(0))));
    this.lblSellPriceLabel.setLocation(new java.awt.Point(8, 132));
    this.lblSellPriceLabel.setName("lblSellPriceLabel");
    this.lblSellPriceLabel.setSize(new Size(58, 16));
    this.lblSellPriceLabel.setTabIndex(55);
    this.lblSellPriceLabel.setText("Sell Price:");
    // picEquipment
    this.picEquipment.setBackColor(java.awt.Color.white);
    this.picEquipment.setBorderStyle(BorderStyle.FixedSingle);
    this.picEquipment.setLocation(new java.awt.Point(71, 20));
    this.picEquipment.setName("picEquipment");
    this.picEquipment.setSize(new Size(66, 54));
    this.picEquipment.setTabIndex(54);
    this.picEquipment.setTabStop(false);
    this.picEquipment.setVisible(false);
    // lblSellPrice
    this.lblSellPrice.setLocation(new java.awt.Point(80, 132));
    this.lblSellPrice.setName("lblSellPrice");
    this.lblSellPrice.setSize(new Size(116, 16));
    this.lblSellPrice.setTabIndex(52);
    this.lblSellPrice.setText("888,888 cr.");
    // lblDescription
    this.lblDescription.setLocation(new java.awt.Point(8, 188));
    this.lblDescription.setName("lblDescription");
    this.lblDescription.setSize(new Size(196, 75));
    this.lblDescription.setTabIndex(47);
    // lblName
    this.lblName.setLocation(new java.awt.Point(80, 84));
    this.lblName.setName("lblName");
    this.lblName.setSize(new Size(116, 16));
    this.lblName.setTabIndex(35);
    this.lblName.setText("Auto-Repair System");
    // FormEquipment
    this.setAutoScaleBaseSize(new Size(5, 13));
    this.setCancelButton(this.btnClose);
    this.setClientSize(new Size(522, 311));
    this.Controls.add(this.boxShipInfo);
    this.Controls.add(this.boxBuy);
    this.Controls.add(this.boxSell);
    this.Controls.add(this.btnClose);
    this.setFormBorderStyle(FormBorderStyle.FixedDialog);
    this.setMaximizeBox(false);
    this.setMinimizeBox(false);
    this.setName("FormEquipment");
    this.setShowInTaskbar(false);
    this.setStartPosition(FormStartPosition.CenterParent);
    this.setText("Buy/Sell Equipment");
    this.boxSell.ResumeLayout(false);
    this.boxBuy.ResumeLayout(false);
    this.boxShipInfo.ResumeLayout(false);
    this.ResumeLayout(false);
  }

  private void Buy() {
    if(selectedEquipment != null && !sellSideSelected) {
      Commander cmdr = game.Commander();
      EquipmentType baseType = selectedEquipment.EquipmentType();
      if(baseType == EquipmentType.Gadget && cmdr.getShip().HasGadget(((Gadget)selectedEquipment).Type()) && ((Gadget)selectedEquipment).Type() != GadgetType.ExtraCargoBays) {
        FormAlert.Alert(AlertType.EquipmentAlreadyOwn, this);
      } else if(cmdr.getDebt() > 0) {
        FormAlert.Alert(AlertType.DebtNoBuy, this);
      } else if(selectedEquipment.Price() > cmdr.CashToSpend()) {
        FormAlert.Alert(AlertType.EquipmentIF, this);
      } else if((baseType == EquipmentType.Weapon && cmdr.getShip().FreeSlotsWeapon() == 0)
          || (baseType == EquipmentType.Shield && cmdr.getShip().FreeSlotsShield() == 0)
          || (baseType == EquipmentType.Gadget && cmdr.getShip().FreeSlotsGadget() == 0)) {
        FormAlert.Alert(AlertType.EquipmentNotEnoughSlots, this);
      } else if(FormAlert.Alert(AlertType.EquipmentBuy, this, selectedEquipment.Name(), Functions.FormatNumber(selectedEquipment.Price())) == DialogResult.Yes) {
        cmdr.getShip().AddEquipment(selectedEquipment);
        cmdr.setCash(cmdr.getCash() - selectedEquipment.Price());
        DeselectAll();
        UpdateSell();
        game.getParentWindow().UpdateAll();
      }
    }
  }

  private void DeselectAll() {
    lstSellWeapon.clearSelected();
    lstSellShield.clearSelected();
    lstSellGadget.clearSelected();
    lstBuyWeapon.clearSelected();
    lstBuyShield.clearSelected();
    lstBuyGadget.clearSelected();
  }

  private void Sell() {
    if(selectedEquipment != null && sellSideSelected) {
      if(FormAlert.Alert(AlertType.EquipmentSell, this) == DialogResult.Yes) {
        // The slot is the selected index. Two of the three list boxes will have selected indices of -1, so adding 2 to the total cancels those out.
        int slot = lstSellWeapon.getSelectedIndex() + lstSellShield.getSelectedIndex() + lstSellGadget.getSelectedIndex() + 2;
        Commander cmdr = game.Commander();
        if(selectedEquipment.EquipmentType() == EquipmentType.Gadget
            && (((Gadget)selectedEquipment).Type() == GadgetType.ExtraCargoBays || ((Gadget)selectedEquipment).Type() == GadgetType.HiddenCargoBays) && cmdr.getShip().FreeCargoBays() < 5) {
          FormAlert.Alert(AlertType.EquipmentExtraBaysInUse, this);
        } else {
          cmdr.setCash(cmdr.getCash() + selectedEquipment.SellPrice());
          cmdr.getShip().RemoveEquipment(selectedEquipment.EquipmentType(), slot);
          UpdateSell();
          game.getParentWindow().UpdateAll();
        }
      }
    }
  }

  private void UpdateBuy() {
    for(int i = 0; i < equipBuy.length; i++) {
      if(equipBuy[i].Price() > 0) {
        switch(equipBuy[i].EquipmentType()) {
          case Weapon:
            lstBuyWeapon.Items.add(equipBuy[i]);
            break;
          case Shield:
            lstBuyShield.Items.add(equipBuy[i]);
            break;
          case Gadget:
            lstBuyGadget.Items.add(equipBuy[i]);
            break;
        }
      }
    }
    ListBox[] buyBoxes = new ListBox[] {lstBuyWeapon, lstBuyShield, lstBuyGadget};
    Label[] buyLabels = new Label[] {lblBuyWeaponNone, lblBuyShieldNone, lblBuyGadgetNone};
    for(int i = 0; i < buyBoxes.length; i++) {
      boolean entries = (buyBoxes[i].Items.size() > 0);
      buyBoxes[i].setVisible(entries);
      buyLabels[i].setVisible(!entries);
      if(entries) {
        buyBoxes[i].setHeight(buyBoxes[i].getItemHeight() * Math.min(buyBoxes[i].Items.size(), 5) + 2);
      }
    }
  }

  private void UpdateInfo() {
    boolean visible = selectedEquipment != null;
    picEquipment.setVisible(visible);
    lblNameLabel.setVisible(visible);
    lblTypeLabel.setVisible(visible);
    lblBuyPriceLabel.setVisible(visible);
    lblSellPriceLabel.setVisible(visible);
    lblPowerLabel.setVisible(visible);
    lblChargeLabel.setVisible(visible);
    if(selectedEquipment == null) {
      lblName.setText("");
      lblType.setText("");
      lblDescription.setText("");
      lblBuyPrice.setText("");
      lblSellPrice.setText("");
      lblPower.setText("");
      lblCharge.setText("");
      btnBuy.setVisible(false);
      btnSell.setVisible(false);
    } else {
      String power = "";
      String charge = "";
      switch(selectedEquipment.EquipmentType()) {
        case Weapon:
          power = "" + ((Weapon)selectedEquipment).Power();
          charge = Strings.NA;
          break;
        case Shield:
          power = "" + ((Shield)selectedEquipment).Power();
          charge = sellSideSelected ? "" + ((Shield)selectedEquipment).getCharge() : Strings.NA;
          break;
        case Gadget:
          power = Strings.NA;
          charge = Strings.NA;
          break;
      }
      lblName.setText(selectedEquipment.Name());
      lblType.setText(Strings.EquipmentTypes[selectedEquipment.EquipmentType().CastToInt()]);
      lblDescription.setText(Strings.EquipmentDescriptions[selectedEquipment.EquipmentType().CastToInt()][selectedEquipment.SubType().CastToInt()]);
      lblBuyPrice.setText(Functions.FormatMoney(selectedEquipment.Price()));
      lblSellPrice.setText(Functions.FormatMoney(selectedEquipment.SellPrice()));
      lblPower.setText(power);
      lblCharge.setText(charge);
      picEquipment.setImage(selectedEquipment.Image());
      btnBuy.setVisible(!sellSideSelected && (selectedEquipment.Price() > 0));
      btnSell.setVisible(sellSideSelected);
    }
  }

  private void UpdateSell() {
    sellSideSelected = false;
    selectedEquipment = null;
    UpdateInfo();
    lstSellWeapon.Items.clear();
    lstSellShield.Items.clear();
    lstSellGadget.Items.clear();
    Ship ship = Game.CurrentGame().Commander().getShip();
    Equipment[] equipSell;
    int index;
    equipSell = ship.EquipmentByType(EquipmentType.Weapon);
    for(index = 0; index < equipSell.length; index++) {
      lstSellWeapon.Items.add(equipSell[index] == null ? (Object)Strings.EquipmentFreeSlot : equipSell[index]);
    }
    equipSell = ship.EquipmentByType(EquipmentType.Shield);
    for(index = 0; index < equipSell.length; index++) {
      lstSellShield.Items.add(equipSell[index] == null ? (Object)Strings.EquipmentFreeSlot : equipSell[index]);
    }
    equipSell = ship.EquipmentByType(EquipmentType.Gadget);
    for(index = 0; index < equipSell.length; index++) {
      lstSellGadget.Items.add(equipSell[index] == null ? (Object)Strings.EquipmentFreeSlot : equipSell[index]);
    }
    ListBox[] sellBoxes = new ListBox[] {lstSellWeapon, lstSellShield, lstSellGadget};
    Label[] sellLabels = new Label[] {lblSellWeaponNoSlots, lblSellShieldNoSlots, lblSellGadgetNoSlots};
    for(int i = 0; i < sellBoxes.length; i++) {
      boolean entries = (sellBoxes[i].Items.size() > 0);
      sellBoxes[i].setVisible(entries);
      sellLabels[i].setVisible(!entries);
      if(entries) {
        sellBoxes[i].setHeight(sellBoxes[i].getItemHeight() * Math.min(sellBoxes[i].Items.size(), 5) + 2);
      }
    }
  }

  private void BuyClick(Object sender, EventArgs e) {
    if(selectedEquipment != null) {
      Buy();
    }
  }

  private void SelectedIndexChanged(Object sender, EventArgs e) {
    if(!handlingSelect) {
      handlingSelect = true;
      Object obj = ((ListBox)sender).getSelectedItem();
      DeselectAll();
      ((ListBox)sender).setSelectedItem(obj);
      sellSideSelected = (((ListBox)sender).getName().indexOf("Sell") >= 0);
      if(obj instanceof Equipment) {
        selectedEquipment = (Equipment)obj;
      } else {
        selectedEquipment = null;
      }
      handlingSelect = false;
      UpdateInfo();
    }
  }

  private void SellClick(Object sender, EventArgs e) {
    if(selectedEquipment != null) {
      Sell();
    }
  }

  public static void main(String[] args) throws Exception {
    FormEquipment form = new FormEquipment();
    Launcher.runForm(form);
  }
}
