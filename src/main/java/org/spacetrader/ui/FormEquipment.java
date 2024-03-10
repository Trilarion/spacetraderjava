package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.controller.enums.AlertType;
import org.spacetrader.model.ship.equipment.*;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;


public class FormEquipment extends wfForm {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Ship ship = commander.getShip();
    private Button buttonBuy;
    private Button buttonSell;
    private Label labelName;
    private Label labelDescription;
    private Label labelSellPrice;
    private Label labelBuyPrice;
    private Label labelBuyPriceLabel;
    private Label labelSellPriceLabel;
    private Label labelNameLabel;
    private Label labelTypeLabel;
    private Label labelType;
    private Label labelPowerLabel;
    private Label labelChargeLabel;
    private Label labelPower;
    private Label labelCharge;
    private Label labelSellWeaponNoSlots;
    private Label labelSellShieldNoSlots;
    private Label labelSellGadgetNoSlots;
    private Label labelBuyWeaponNone;
    private Label labelBuyShieldNone;
    private Label labelBuyGadgetNone;
    private ListBox listSellWeapon;
    private ListBox listSellShield;
    private ListBox listSellGadget;
    private ListBox listBuyGadget;
    private ListBox listBuyShield;
    private ListBox listBuyWeapon;
    private PictureBox pictureEquipment;
    private Equipment selectedEquipment = null;
    private Equipment[] equipBuy = Constants.EquipmentForSale;
    private boolean sellSideSelected = false;
    private boolean handlingSelect = false;

    public FormEquipment() {
        Button buttonClose = new Button();
        GroupBox boxSell = new GroupBox();
        labelSellGadgetNoSlots = new Label();
        labelSellShieldNoSlots = new Label();
        labelSellWeaponNoSlots = new Label();
        Label labelSellGadgets = new Label();
        Label labelSellShields = new Label();
        Label labelSellWeapons = new Label();
        listSellGadget = new ListBox();
        listSellShield = new ListBox();
        listSellWeapon = new ListBox();
        GroupBox boxBuy = new GroupBox();
        labelBuyGadgetNone = new Label();
        labelBuyShieldNone = new Label();
        labelBuyWeaponNone = new Label();
        Label labelBuyGadgets = new Label();
        Label labelBuyShields = new Label();
        Label labelBuyWeapons = new Label();
        listBuyGadget = new ListBox();
        listBuyShield = new ListBox();
        listBuyWeapon = new ListBox();
        GroupBox boxShipInfo = new GroupBox();
        labelCharge = new Label();
        labelPower = new Label();
        labelChargeLabel = new Label();
        labelPowerLabel = new Label();
        labelType = new Label();
        labelTypeLabel = new Label();
        labelNameLabel = new Label();
        buttonSell = new Button();
        buttonBuy = new Button();
        labelBuyPriceLabel = new Label();
        labelBuyPrice = new Label();
        labelSellPriceLabel = new Label();
        pictureEquipment = new PictureBox();
        labelSellPrice = new Label();
        labelDescription = new Label();
        labelName = new Label();
        boxSell.SuspendLayout();
        boxBuy.SuspendLayout();
        boxShipInfo.SuspendLayout();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new FormSize(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // boxSell
        boxSell.Controls.add(labelSellGadgetNoSlots);
        boxSell.Controls.add(labelSellShieldNoSlots);
        boxSell.Controls.add(labelSellWeaponNoSlots);
        boxSell.Controls.add(labelSellGadgets);
        boxSell.Controls.add(labelSellShields);
        boxSell.Controls.add(labelSellWeapons);
        boxSell.Controls.add(listSellGadget);
        boxSell.Controls.add(listSellShield);
        boxSell.Controls.add(listSellWeapon);
        boxSell.setLocation(new Point(4, 2));
        boxSell.setName("boxSell");
        boxSell.setSize(new FormSize(144, 304));
        boxSell.setTabIndex(1);
        boxSell.setTabStop(false);
        boxSell.setText("Current Inventory");
        // labelSellGadgetNoSlots
        labelSellGadgetNoSlots.setLocation(new Point(24, 228));
        labelSellGadgetNoSlots.setName("labelSellGadgetNoSlots");
        labelSellGadgetNoSlots.setSize(new FormSize(104, 16));
        labelSellGadgetNoSlots.setTabIndex(149);
        labelSellGadgetNoSlots.setText("No slots");
        labelSellGadgetNoSlots.setVisible(false);
        // labelSellShieldNoSlots
        labelSellShieldNoSlots.setLocation(new Point(24, 132));
        labelSellShieldNoSlots.setName("labelSellShieldNoSlots");
        labelSellShieldNoSlots.setSize(new FormSize(104, 16));
        labelSellShieldNoSlots.setTabIndex(148);
        labelSellShieldNoSlots.setText("No slots");
        labelSellShieldNoSlots.setVisible(false);
        // labelSellWeaponNoSlots
        labelSellWeaponNoSlots.setLocation(new Point(24, 36));
        labelSellWeaponNoSlots.setName("labelSellWeaponNoSlots");
        labelSellWeaponNoSlots.setSize(new FormSize(104, 16));
        labelSellWeaponNoSlots.setTabIndex(147);
        labelSellWeaponNoSlots.setText("No slots");
        labelSellWeaponNoSlots.setVisible(false);
        // labelSellGadgets
        labelSellGadgets.setAutoSize(true);
        labelSellGadgets.setLocation(new Point(8, 212));
        labelSellGadgets.setName("labelSellGadgets");
        labelSellGadgets.setSize(new FormSize(47, 16));
        labelSellGadgets.setTabIndex(146);
        labelSellGadgets.setText("Gadgets");
        // labelSellShields
        labelSellShields.setAutoSize(true);
        labelSellShields.setLocation(new Point(8, 116));
        labelSellShields.setName("labelSellShields");
        labelSellShields.setSize(new FormSize(41, 16));
        labelSellShields.setTabIndex(145);
        labelSellShields.setText("Shields");
        // labelSellWeapons
        labelSellWeapons.setAutoSize(true);
        labelSellWeapons.setLocation(new Point(8, 20));
        labelSellWeapons.setName("labelSellWeapons");
        labelSellWeapons.setSize(new FormSize(52, 16));
        labelSellWeapons.setTabIndex(144);
        labelSellWeapons.setText("Weapons");
        // listSellGadget
        listSellGadget.setBorderStyle(BorderStyle.FixedSingle);
        listSellGadget.setLocation(new Point(8, 228));
        listSellGadget.setName("listSellGadget");
        listSellGadget.setSize(new FormSize(128, 67));
        listSellGadget.setTabIndex(3);
        listSellGadget.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SellClick();
            }
        });
        listSellGadget.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SelectedIndexChanged(sender, e);
            }
        });
        // listSellShield
        listSellShield.setBorderStyle(BorderStyle.FixedSingle);
        listSellShield.setLocation(new Point(8, 132));
        listSellShield.setName("listSellShield");
        listSellShield.setSize(new FormSize(128, 67));
        listSellShield.setTabIndex(2);
        listSellShield.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SellClick();
            }
        });
        listSellShield.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SelectedIndexChanged(sender, e);
            }
        });
        // listSellWeapon
        listSellWeapon.setBorderStyle(BorderStyle.FixedSingle);
        listSellWeapon.setLocation(new Point(8, 36));
        listSellWeapon.setName("listSellWeapon");
        listSellWeapon.setSize(new FormSize(128, 67));
        listSellWeapon.setTabIndex(1);
        listSellWeapon.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SellClick();
            }
        });
        listSellWeapon.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SelectedIndexChanged(sender, e);
            }
        });
        // boxBuy
        boxBuy.Controls.add(labelBuyGadgetNone);
        boxBuy.Controls.add(labelBuyShieldNone);
        boxBuy.Controls.add(labelBuyWeaponNone);
        boxBuy.Controls.add(labelBuyGadgets);
        boxBuy.Controls.add(labelBuyShields);
        boxBuy.Controls.add(labelBuyWeapons);
        boxBuy.Controls.add(listBuyGadget);
        boxBuy.Controls.add(listBuyShield);
        boxBuy.Controls.add(listBuyWeapon);
        boxBuy.setLocation(new Point(156, 2));
        boxBuy.setName("boxBuy");
        boxBuy.setSize(new FormSize(144, 304));
        boxBuy.setTabIndex(2);
        boxBuy.setTabStop(false);
        boxBuy.setText("Equipment For Sale");
        // labelBuyGadgetNone
        labelBuyGadgetNone.setLocation(new Point(24, 228));
        labelBuyGadgetNone.setName("labelBuyGadgetNone");
        labelBuyGadgetNone.setSize(new FormSize(104, 16));
        labelBuyGadgetNone.setTabIndex(150);
        labelBuyGadgetNone.setText("None for sale");
        labelBuyGadgetNone.setVisible(false);
        // labelBuyShieldNone
        labelBuyShieldNone.setLocation(new Point(24, 132));
        labelBuyShieldNone.setName("labelBuyShieldNone");
        labelBuyShieldNone.setSize(new FormSize(104, 16));
        labelBuyShieldNone.setTabIndex(149);
        labelBuyShieldNone.setText("None for sale");
        labelBuyShieldNone.setVisible(false);
        // labelBuyWeaponNone
        labelBuyWeaponNone.setLocation(new Point(24, 36));
        labelBuyWeaponNone.setName("labelBuyWeaponNone");
        labelBuyWeaponNone.setSize(new FormSize(104, 16));
        labelBuyWeaponNone.setTabIndex(148);
        labelBuyWeaponNone.setText("None for sale");
        labelBuyWeaponNone.setVisible(false);
        // labelBuyGadgets
        labelBuyGadgets.setAutoSize(true);
        labelBuyGadgets.setLocation(new Point(8, 212));
        labelBuyGadgets.setName("labelBuyGadgets");
        labelBuyGadgets.setSize(new FormSize(47, 16));
        labelBuyGadgets.setTabIndex(143);
        labelBuyGadgets.setText("Gadgets");
        // labelBuyShields
        labelBuyShields.setAutoSize(true);
        labelBuyShields.setLocation(new Point(8, 116));
        labelBuyShields.setName("labelBuyShields");
        labelBuyShields.setSize(new FormSize(41, 16));
        labelBuyShields.setTabIndex(142);
        labelBuyShields.setText("Shields");
        // labelBuyWeapons
        labelBuyWeapons.setAutoSize(true);
        labelBuyWeapons.setLocation(new Point(8, 20));
        labelBuyWeapons.setName("labelBuyWeapons");
        labelBuyWeapons.setSize(new FormSize(52, 16));
        labelBuyWeapons.setTabIndex(141);
        labelBuyWeapons.setText("Weapons");
        // listBuyGadget
        listBuyGadget.setBorderStyle(BorderStyle.FixedSingle);
        listBuyGadget.setLocation(new Point(8, 228));
        listBuyGadget.setName("listBuyGadget");
        listBuyGadget.setSize(new FormSize(128, 67));
        listBuyGadget.setTabIndex(6);
        listBuyGadget.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                BuyClick(sender, e);
            }
        });
        listBuyGadget.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SelectedIndexChanged(sender, e);
            }
        });
        // listBuyShield
        listBuyShield.setBorderStyle(BorderStyle.FixedSingle);
        listBuyShield.setLocation(new Point(8, 132));
        listBuyShield.setName("listBuyShield");
        listBuyShield.setSize(new FormSize(128, 67));
        listBuyShield.setTabIndex(5);
        listBuyShield.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                BuyClick(sender, e);
            }
        });
        listBuyShield.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SelectedIndexChanged(sender, e);
            }
        });
        // listBuyWeapon
        listBuyWeapon.setBorderStyle(BorderStyle.FixedSingle);
        listBuyWeapon.setLocation(new Point(8, 36));
        listBuyWeapon.setName("listBuyWeapon");
        listBuyWeapon.setSize(new FormSize(128, 67));
        listBuyWeapon.setTabIndex(4);
        listBuyWeapon.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                BuyClick(sender, e);
            }
        });
        listBuyWeapon.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SelectedIndexChanged(sender, e);
            }
        });
        // boxShipInfo
        boxShipInfo.Controls.add(labelCharge);
        boxShipInfo.Controls.add(labelPower);
        boxShipInfo.Controls.add(labelChargeLabel);
        boxShipInfo.Controls.add(labelPowerLabel);
        boxShipInfo.Controls.add(labelType);
        boxShipInfo.Controls.add(labelTypeLabel);
        boxShipInfo.Controls.add(labelNameLabel);
        boxShipInfo.Controls.add(buttonSell);
        boxShipInfo.Controls.add(buttonBuy);
        boxShipInfo.Controls.add(labelBuyPriceLabel);
        boxShipInfo.Controls.add(labelBuyPrice);
        boxShipInfo.Controls.add(labelSellPriceLabel);
        boxShipInfo.Controls.add(pictureEquipment);
        boxShipInfo.Controls.add(labelSellPrice);
        boxShipInfo.Controls.add(labelName);
        boxShipInfo.Controls.add(labelDescription);
        boxShipInfo.setLocation(new Point(308, 2));
        boxShipInfo.setName("boxShipInfo");
        boxShipInfo.setSize(new FormSize(208, 304));
        boxShipInfo.setTabIndex(3);
        boxShipInfo.setTabStop(false);
        boxShipInfo.setText("Equipment Information");
        // labelCharge
        labelCharge.setLocation(new Point(80, 164));
        labelCharge.setName("labelCharge");
        labelCharge.setSize(new FormSize(116, 16));
        labelCharge.setTabIndex(67);
        labelCharge.setText("888");
        // labelPower
        labelPower.setLocation(new Point(80, 148));
        labelPower.setName("labelPower");
        labelPower.setSize(new FormSize(116, 16));
        labelPower.setTabIndex(66);
        labelPower.setText("888");
        // labelChargeLabel
        labelChargeLabel.setAutoSize(true);
        labelChargeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelChargeLabel.setLocation(new Point(8, 164));
        labelChargeLabel.setName("labelChargeLabel");
        labelChargeLabel.setSize(new FormSize(46, 16));
        labelChargeLabel.setTabIndex(65);
        labelChargeLabel.setText("Charge:");
        // labelPowerLabel
        labelPowerLabel.setAutoSize(true);
        labelPowerLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelPowerLabel.setLocation(new Point(8, 148));
        labelPowerLabel.setName("labelPowerLabel");
        labelPowerLabel.setSize(new FormSize(41, 16));
        labelPowerLabel.setTabIndex(64);
        labelPowerLabel.setText("Power:");
        // labelType
        labelType.setLocation(new Point(80, 100));
        labelType.setName("labelType");
        labelType.setSize(new FormSize(116, 16));
        labelType.setTabIndex(63);
        labelType.setText("Weapon");
        // labelTypeLabel
        labelTypeLabel.setAutoSize(true);
        labelTypeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTypeLabel.setLocation(new Point(8, 100));
        labelTypeLabel.setName("labelTypeLabel");
        labelTypeLabel.setSize(new FormSize(34, 16));
        labelTypeLabel.setTabIndex(62);
        labelTypeLabel.setText("Type:");
        // labelNameLabel
        labelNameLabel.setAutoSize(true);
        labelNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelNameLabel.setLocation(new Point(8, 84));
        labelNameLabel.setName("labelNameLabel");
        labelNameLabel.setSize(new FormSize(39, 16));
        labelNameLabel.setTabIndex(61);
        labelNameLabel.setText("Name:");
        // buttonSell
        buttonSell.setFlatStyle(FlatStyle.Flat);
        buttonSell.setLocation(new Point(103, 272));
        buttonSell.setName("buttonSell");
        buttonSell.setSize(new FormSize(58, 22));
        buttonSell.setTabIndex(8);
        buttonSell.setText("Sell");
        buttonSell.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                SellClick();
            }
        });
        // buttonBuy
        buttonBuy.setFlatStyle(FlatStyle.Flat);
        buttonBuy.setLocation(new Point(31, 272));
        buttonBuy.setName("buttonBuy");
        buttonBuy.setSize(new FormSize(58, 22));
        buttonBuy.setTabIndex(7);
        buttonBuy.setText("Buy");
        buttonBuy.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                BuyClick(sender, e);
            }
        });
        // labelBuyPriceLabel
        labelBuyPriceLabel.setAutoSize(true);
        labelBuyPriceLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelBuyPriceLabel.setLocation(new Point(8, 116));
        labelBuyPriceLabel.setName("labelBuyPriceLabel");
        labelBuyPriceLabel.setSize(new FormSize(58, 16));
        labelBuyPriceLabel.setTabIndex(57);
        labelBuyPriceLabel.setText("Buy Price:");
        // labelBuyPrice
        labelBuyPrice.setLocation(new Point(80, 116));
        labelBuyPrice.setName("labelBuyPrice");
        labelBuyPrice.setSize(new FormSize(116, 16));
        labelBuyPrice.setTabIndex(56);
        labelBuyPrice.setText("888,888 cr.");
        // labelSellPriceLabel
        labelSellPriceLabel.setAutoSize(true);
        labelSellPriceLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelSellPriceLabel.setLocation(new Point(8, 132));
        labelSellPriceLabel.setName("labelSellPriceLabel");
        labelSellPriceLabel.setSize(new FormSize(58, 16));
        labelSellPriceLabel.setTabIndex(55);
        labelSellPriceLabel.setText("Sell Price:");
        // pictureEquipment
        pictureEquipment.setBackColor(Color.white);
        pictureEquipment.setBorderStyle(BorderStyle.FixedSingle);
        pictureEquipment.setLocation(new Point(71, 20));
        pictureEquipment.setName("pictureEquipment");
        pictureEquipment.setSize(new FormSize(66, 54));
        pictureEquipment.setTabIndex(54);
        pictureEquipment.setTabStop(false);
        pictureEquipment.setVisible(false);
        // labelSellPrice
        labelSellPrice.setLocation(new Point(80, 132));
        labelSellPrice.setName("labelSellPrice");
        labelSellPrice.setSize(new FormSize(116, 16));
        labelSellPrice.setTabIndex(52);
        labelSellPrice.setText("888,888 cr.");
        // labelDescription
        labelDescription.setLocation(new Point(8, 188));
        labelDescription.setName("labelDescription");
        labelDescription.setSize(new FormSize(196, 75));
        labelDescription.setTabIndex(47);
        // labelName
        labelName.setLocation(new Point(80, 84));
        labelName.setName("labelName");
        labelName.setSize(new FormSize(116, 16));
        labelName.setTabIndex(35);
        labelName.setText("Auto-Repair System");
        // FormEquipment
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(522, 311));
        Controls.add(boxShipInfo);
        Controls.add(boxBuy);
        Controls.add(boxSell);
        Controls.add(buttonClose);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormEquipment");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Buy/Sell Equipment");
        boxSell.ResumeLayout(false);
        boxBuy.ResumeLayout(false);
        boxShipInfo.ResumeLayout(false);
        ResumeLayout(false);
        UpdateBuy();
        UpdateSell();
    }

    private void Buy() {
        if (selectedEquipment != null && !sellSideSelected) {
            EquipmentType baseType = selectedEquipment.EquipmentType();
            if (baseType == EquipmentType.Gadget && ship.HasGadget(((Gadget) selectedEquipment).Type())
                    && ((Gadget) selectedEquipment).Type() != GadgetType.ExtraCargoBays) {
                FormAlert.Alert(AlertType.EquipmentAlreadyOwn, this);
            } else if (commander.getDebt() > 0) {
                FormAlert.Alert(AlertType.DebtNoBuy, this);
            } else if (selectedEquipment.Price() > commander.CashToSpend()) {
                FormAlert.Alert(AlertType.EquipmentIF, this);
            } else if ((baseType == EquipmentType.Weapon && ship.FreeSlotsWeapon() == 0)
                    || (baseType == EquipmentType.Shield && ship.FreeSlotsShield() == 0)
                    || (baseType == EquipmentType.Gadget && ship.FreeSlotsGadget() == 0)) {
                FormAlert.Alert(AlertType.EquipmentNotEnoughSlots, this);
            } else if (FormAlert.Alert(AlertType.EquipmentBuy, this, selectedEquipment.Name(), Functions.FormatNumber(selectedEquipment.Price())) == DialogResult.Yes) {
                ship.AddEquipment(selectedEquipment);
                commander.setCash(commander.getCash() - selectedEquipment.Price());
                DeselectAll();
                UpdateSell();
                game.getParentWindow().UpdateAll();
            }
        }
    }

    private void DeselectAll() {
        listSellWeapon.clearSelected();
        listSellShield.clearSelected();
        listSellGadget.clearSelected();
        listBuyWeapon.clearSelected();
        listBuyShield.clearSelected();
        listBuyGadget.clearSelected();
    }

    private void Sell() {
        if (selectedEquipment != null && sellSideSelected) {
            if (FormAlert.Alert(AlertType.EquipmentSell, this) == DialogResult.Yes) {
                // The slot is the selected index. Two of the three list boxes will have selected indices of -1, so adding 2 to the total cancels those out.
                int slot = listSellWeapon.getSelectedIndex() + listSellShield.getSelectedIndex() + listSellGadget.getSelectedIndex() + 2;
                if (selectedEquipment.EquipmentType() == EquipmentType.Gadget
                        && (((Gadget) selectedEquipment).Type() == GadgetType.ExtraCargoBays || ((Gadget) selectedEquipment).Type() == GadgetType.HiddenCargoBays)
                        && ship.FreeCargoBays() < 5) {
                    FormAlert.Alert(AlertType.EquipmentExtraBaysInUse, this);
                } else {
                    commander.setCash(commander.getCash() + selectedEquipment.SellPrice());
                    ship.RemoveEquipment(selectedEquipment.EquipmentType(), slot);
                    UpdateSell();
                    game.getParentWindow().UpdateAll();
                }
            }
        }
    }

    private void UpdateBuy() {
        for (Equipment equipment : equipBuy) {
            if (equipment.Price() > 0) {
                switch (equipment.EquipmentType()) {
                    case Weapon:
                        listBuyWeapon.Items.add(equipment);
                        break;
                    case Shield:
                        listBuyShield.Items.add(equipment);
                        break;
                    case Gadget:
                        listBuyGadget.Items.add(equipment);
                        break;
                }
            }
        }
        ListBox[] buyBoxes = new ListBox[]{listBuyWeapon, listBuyShield, listBuyGadget};
        Label[] buyLabels = new Label[]{labelBuyWeaponNone, labelBuyShieldNone, labelBuyGadgetNone};
        for (int i = 0; i < buyBoxes.length; i++) {
            boolean entries = (!buyBoxes[i].Items.isEmpty());
            buyBoxes[i].setVisible(entries);
            buyLabels[i].setVisible(!entries);
            if (entries) {
                buyBoxes[i].setHeight(buyBoxes[i].getItemHeight() * Math.min(buyBoxes[i].Items.size(), 5) + 2);
            }
        }
    }

    private void UpdateInfo() {
        boolean visible = selectedEquipment != null;
        pictureEquipment.setVisible(visible);
        labelNameLabel.setVisible(visible);
        labelTypeLabel.setVisible(visible);
        labelBuyPriceLabel.setVisible(visible);
        labelSellPriceLabel.setVisible(visible);
        labelPowerLabel.setVisible(visible);
        labelChargeLabel.setVisible(visible);
        if (selectedEquipment == null) {
            labelName.setText("");
            labelType.setText("");
            labelDescription.setText("");
            labelBuyPrice.setText("");
            labelSellPrice.setText("");
            labelPower.setText("");
            labelCharge.setText("");
            buttonBuy.setVisible(false);
            buttonSell.setVisible(false);
        } else {
            String power = "";
            String charge = "";
            switch (selectedEquipment.EquipmentType()) {
                case Weapon:
                    power = "" + ((Weapon) selectedEquipment).Power();
                    charge = Strings.NA;
                    break;
                case Shield:
                    power = "" + ((Shield) selectedEquipment).Power();
                    charge = sellSideSelected ? "" + ((Shield) selectedEquipment).getCharge() : Strings.NA;
                    break;
                case Gadget:
                    power = Strings.NA;
                    charge = Strings.NA;
                    break;
            }
            labelName.setText(selectedEquipment.Name());
            labelType.setText(Strings.EquipmentTypes[selectedEquipment.EquipmentType().CastToInt()]);
            labelDescription.setText(Strings.EquipmentDescriptions[selectedEquipment.EquipmentType().CastToInt()][selectedEquipment.SubType().asInteger()]);
            labelBuyPrice.setText(Functions.FormatMoney(selectedEquipment.Price()));
            labelSellPrice.setText(Functions.FormatMoney(selectedEquipment.SellPrice()));
            labelPower.setText(power);
            labelCharge.setText(charge);
            pictureEquipment.setImage(selectedEquipment.Image());
            buttonBuy.setVisible(!sellSideSelected && (selectedEquipment.Price() > 0));
            buttonSell.setVisible(sellSideSelected);
        }
    }

    private void UpdateSell() {
        sellSideSelected = false;
        selectedEquipment = null;
        UpdateInfo();
        listSellWeapon.Items.clear();
        listSellShield.Items.clear();
        listSellGadget.Items.clear();
        Equipment[] equipSell;
        int index;
        equipSell = ship.EquipmentByType(EquipmentType.Weapon);
        for (index = 0; index < equipSell.length; index++) {
            listSellWeapon.Items.add(equipSell[index] == null ? Strings.EquipmentFreeSlot : equipSell[index]);
        }
        equipSell = ship.EquipmentByType(EquipmentType.Shield);
        for (index = 0; index < equipSell.length; index++) {
            listSellShield.Items.add(equipSell[index] == null ? Strings.EquipmentFreeSlot : equipSell[index]);
        }
        equipSell = ship.EquipmentByType(EquipmentType.Gadget);
        for (index = 0; index < equipSell.length; index++) {
            listSellGadget.Items.add(equipSell[index] == null ? Strings.EquipmentFreeSlot : equipSell[index]);
        }
        ListBox[] sellBoxes = new ListBox[]{listSellWeapon, listSellShield, listSellGadget};
        Label[] sellLabels = new Label[]{labelSellWeaponNoSlots, labelSellShieldNoSlots, labelSellGadgetNoSlots};
        for (int i = 0; i < sellBoxes.length; i++) {
            boolean entries = (!sellBoxes[i].Items.isEmpty());
            sellBoxes[i].setVisible(entries);
            sellLabels[i].setVisible(!entries);
            if (entries) {
                sellBoxes[i].setHeight(sellBoxes[i].getItemHeight() * Math.min(sellBoxes[i].Items.size(), 5) + 2);
            }
        }
    }

    private void BuyClick(Object sender, EventData e) {
        if (selectedEquipment != null) {
            Buy();
        }
    }

    private void SelectedIndexChanged(Object sender, EventData e) {
        if (!handlingSelect) {
            handlingSelect = true;
            Object obj = ((ListBox) sender).getSelectedItem();
            DeselectAll();
            ((ListBox) sender).setSelectedItem(obj);
            sellSideSelected = (((ListBox) sender).getName().contains("Sell"));
            if (obj instanceof Equipment) {
                selectedEquipment = (Equipment) obj;
            } else {
                selectedEquipment = null;
            }
            handlingSelect = false;
            UpdateInfo();
        }
    }

    private void SellClick() {
        if (selectedEquipment != null) {
            Sell();
        }
    }
}
