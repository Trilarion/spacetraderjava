package org.spacetrader.ui;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.equipment.*;
import org.winforms.util.Font;
import org.winforms.alignment.FormStartPosition;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.Label;
import org.winforms.widget.*;
import org.winforms.dialog.DialogResult;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;
import org.winforms.style.BorderStyle;
import org.winforms.style.FlatStyle;
import org.winforms.style.FontStyle;
import org.winforms.style.FormBorderStyle;

import java.awt.*;


public class DialogEquipment extends Dialog {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Ship ship = commander.getShip();
    private final Button buttonBuy;
    private final Button buttonSell;
    private final Label labelName;
    private final Label labelDescription;
    private final Label labelSellPrice;
    private final Label labelBuyPrice;
    private final Label labelBuyPriceLabel;
    private final Label labelSellPriceLabel;
    private final Label labelNameLabel;
    private final Label labelTypeLabel;
    private final Label labelType;
    private final Label labelPowerLabel;
    private final Label labelChargeLabel;
    private final Label labelPower;
    private final Label labelCharge;
    private final Label labelSellWeaponNoSlots;
    private final Label labelSellShieldNoSlots;
    private final Label labelSellGadgetNoSlots;
    private final Label labelBuyWeaponNone;
    private final Label labelBuyShieldNone;
    private final Label labelBuyGadgetNone;
    private final ListBox listSellWeapon;
    private final ListBox listSellShield;
    private final ListBox listSellGadget;
    private final ListBox listBuyGadget;
    private final ListBox listBuyShield;
    private final ListBox listBuyWeapon;
    private final PictureBox pictureEquipment;
    private final Equipment[] equipBuy = Constants.EquipmentForSale;
    private Equipment selectedEquipment;
    private boolean sellSideSelected;
    private boolean handlingSelect;

    public DialogEquipment() {
        final Button buttonClose = new Button();
        final GroupBox boxSell = new GroupBox();
        labelSellGadgetNoSlots = new Label();
        labelSellShieldNoSlots = new Label();
        labelSellWeaponNoSlots = new Label();
        final Label labelSellGadgets = new Label();
        final Label labelSellShields = new Label();
        final Label labelSellWeapons = new Label();
        listSellGadget = new ListBox();
        listSellShield = new ListBox();
        listSellWeapon = new ListBox();
        final GroupBox boxBuy = new GroupBox();
        labelBuyGadgetNone = new Label();
        labelBuyShieldNone = new Label();
        labelBuyWeaponNone = new Label();
        final Label labelBuyGadgets = new Label();
        final Label labelBuyShields = new Label();
        final Label labelBuyWeapons = new Label();
        listBuyGadget = new ListBox();
        listBuyShield = new ListBox();
        listBuyWeapon = new ListBox();
        final GroupBox boxShipInfo = new GroupBox();
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
        boxSell.suspendLayout();
        boxBuy.suspendLayout();
        boxShipInfo.suspendLayout();
        suspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new Dimension(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // boxSell
        boxSell.controls.add(labelSellGadgetNoSlots);
        boxSell.controls.add(labelSellShieldNoSlots);
        boxSell.controls.add(labelSellWeaponNoSlots);
        boxSell.controls.add(labelSellGadgets);
        boxSell.controls.add(labelSellShields);
        boxSell.controls.add(labelSellWeapons);
        boxSell.controls.add(listSellGadget);
        boxSell.controls.add(listSellShield);
        boxSell.controls.add(listSellWeapon);
        boxSell.setLocation(new Point(4, 2));
        boxSell.setName("boxSell");
        boxSell.setSize(new Dimension(144, 304));
        boxSell.setTabIndex(1);
        boxSell.setTabStop(false);
        boxSell.setText("Current Inventory");
        // labelSellGadgetNoSlots
        labelSellGadgetNoSlots.setLocation(new Point(24, 228));
        labelSellGadgetNoSlots.setName("labelSellGadgetNoSlots");
        labelSellGadgetNoSlots.setSize(new Dimension(104, 16));
        labelSellGadgetNoSlots.setTabIndex(149);
        labelSellGadgetNoSlots.setText("No slots");
        labelSellGadgetNoSlots.setVisible(false);
        // labelSellShieldNoSlots
        labelSellShieldNoSlots.setLocation(new Point(24, 132));
        labelSellShieldNoSlots.setName("labelSellShieldNoSlots");
        labelSellShieldNoSlots.setSize(new Dimension(104, 16));
        labelSellShieldNoSlots.setTabIndex(148);
        labelSellShieldNoSlots.setText("No slots");
        labelSellShieldNoSlots.setVisible(false);
        // labelSellWeaponNoSlots
        labelSellWeaponNoSlots.setLocation(new Point(24, 36));
        labelSellWeaponNoSlots.setName("labelSellWeaponNoSlots");
        labelSellWeaponNoSlots.setSize(new Dimension(104, 16));
        labelSellWeaponNoSlots.setTabIndex(147);
        labelSellWeaponNoSlots.setText("No slots");
        labelSellWeaponNoSlots.setVisible(false);
        // labelSellGadgets
        labelSellGadgets.setAutoSize(true);
        labelSellGadgets.setLocation(new Point(8, 212));
        labelSellGadgets.setName("labelSellGadgets");
        labelSellGadgets.setSize(new Dimension(47, 16));
        labelSellGadgets.setTabIndex(146);
        labelSellGadgets.setText("Gadgets");
        // labelSellShields
        labelSellShields.setAutoSize(true);
        labelSellShields.setLocation(new Point(8, 116));
        labelSellShields.setName("labelSellShields");
        labelSellShields.setSize(new Dimension(41, 16));
        labelSellShields.setTabIndex(145);
        labelSellShields.setText("Shields");
        // labelSellWeapons
        labelSellWeapons.setAutoSize(true);
        labelSellWeapons.setLocation(new Point(8, 20));
        labelSellWeapons.setName("labelSellWeapons");
        labelSellWeapons.setSize(new Dimension(52, 16));
        labelSellWeapons.setTabIndex(144);
        labelSellWeapons.setText("Weapons");
        // listSellGadget
        listSellGadget.setBorderStyle(BorderStyle.FixedSingle);
        listSellGadget.setLocation(new Point(8, 228));
        listSellGadget.setName("listSellGadget");
        listSellGadget.setSize(new Dimension(128, 67));
        listSellGadget.setTabIndex(3);
        listSellGadget.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SellClick();
            }
        });
        listSellGadget.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // listSellShield
        listSellShield.setBorderStyle(BorderStyle.FixedSingle);
        listSellShield.setLocation(new Point(8, 132));
        listSellShield.setName("listSellShield");
        listSellShield.setSize(new Dimension(128, 67));
        listSellShield.setTabIndex(2);
        listSellShield.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SellClick();
            }
        });
        listSellShield.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // listSellWeapon
        listSellWeapon.setBorderStyle(BorderStyle.FixedSingle);
        listSellWeapon.setLocation(new Point(8, 36));
        listSellWeapon.setName("listSellWeapon");
        listSellWeapon.setSize(new Dimension(128, 67));
        listSellWeapon.setTabIndex(1);
        listSellWeapon.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SellClick();
            }
        });
        listSellWeapon.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // boxBuy
        boxBuy.controls.add(labelBuyGadgetNone);
        boxBuy.controls.add(labelBuyShieldNone);
        boxBuy.controls.add(labelBuyWeaponNone);
        boxBuy.controls.add(labelBuyGadgets);
        boxBuy.controls.add(labelBuyShields);
        boxBuy.controls.add(labelBuyWeapons);
        boxBuy.controls.add(listBuyGadget);
        boxBuy.controls.add(listBuyShield);
        boxBuy.controls.add(listBuyWeapon);
        boxBuy.setLocation(new Point(156, 2));
        boxBuy.setName("boxBuy");
        boxBuy.setSize(new Dimension(144, 304));
        boxBuy.setTabIndex(2);
        boxBuy.setTabStop(false);
        boxBuy.setText("Equipment For Sale");
        // labelBuyGadgetNone
        labelBuyGadgetNone.setLocation(new Point(24, 228));
        labelBuyGadgetNone.setName("labelBuyGadgetNone");
        labelBuyGadgetNone.setSize(new Dimension(104, 16));
        labelBuyGadgetNone.setTabIndex(150);
        labelBuyGadgetNone.setText("None for sale");
        labelBuyGadgetNone.setVisible(false);
        // labelBuyShieldNone
        labelBuyShieldNone.setLocation(new Point(24, 132));
        labelBuyShieldNone.setName("labelBuyShieldNone");
        labelBuyShieldNone.setSize(new Dimension(104, 16));
        labelBuyShieldNone.setTabIndex(149);
        labelBuyShieldNone.setText("None for sale");
        labelBuyShieldNone.setVisible(false);
        // labelBuyWeaponNone
        labelBuyWeaponNone.setLocation(new Point(24, 36));
        labelBuyWeaponNone.setName("labelBuyWeaponNone");
        labelBuyWeaponNone.setSize(new Dimension(104, 16));
        labelBuyWeaponNone.setTabIndex(148);
        labelBuyWeaponNone.setText("None for sale");
        labelBuyWeaponNone.setVisible(false);
        // labelBuyGadgets
        labelBuyGadgets.setAutoSize(true);
        labelBuyGadgets.setLocation(new Point(8, 212));
        labelBuyGadgets.setName("labelBuyGadgets");
        labelBuyGadgets.setSize(new Dimension(47, 16));
        labelBuyGadgets.setTabIndex(143);
        labelBuyGadgets.setText("Gadgets");
        // labelBuyShields
        labelBuyShields.setAutoSize(true);
        labelBuyShields.setLocation(new Point(8, 116));
        labelBuyShields.setName("labelBuyShields");
        labelBuyShields.setSize(new Dimension(41, 16));
        labelBuyShields.setTabIndex(142);
        labelBuyShields.setText("Shields");
        // labelBuyWeapons
        labelBuyWeapons.setAutoSize(true);
        labelBuyWeapons.setLocation(new Point(8, 20));
        labelBuyWeapons.setName("labelBuyWeapons");
        labelBuyWeapons.setSize(new Dimension(52, 16));
        labelBuyWeapons.setTabIndex(141);
        labelBuyWeapons.setText("Weapons");
        // listBuyGadget
        listBuyGadget.setBorderStyle(BorderStyle.FixedSingle);
        listBuyGadget.setLocation(new Point(8, 228));
        listBuyGadget.setName("listBuyGadget");
        listBuyGadget.setSize(new Dimension(128, 67));
        listBuyGadget.setTabIndex(6);
        listBuyGadget.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                BuyClick(sender, data);
            }
        });
        listBuyGadget.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // listBuyShield
        listBuyShield.setBorderStyle(BorderStyle.FixedSingle);
        listBuyShield.setLocation(new Point(8, 132));
        listBuyShield.setName("listBuyShield");
        listBuyShield.setSize(new Dimension(128, 67));
        listBuyShield.setTabIndex(5);
        listBuyShield.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                BuyClick(sender, data);
            }
        });
        listBuyShield.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // listBuyWeapon
        listBuyWeapon.setBorderStyle(BorderStyle.FixedSingle);
        listBuyWeapon.setLocation(new Point(8, 36));
        listBuyWeapon.setName("listBuyWeapon");
        listBuyWeapon.setSize(new Dimension(128, 67));
        listBuyWeapon.setTabIndex(4);
        listBuyWeapon.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                BuyClick(sender, data);
            }
        });
        listBuyWeapon.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // boxShipInfo
        boxShipInfo.controls.add(labelCharge);
        boxShipInfo.controls.add(labelPower);
        boxShipInfo.controls.add(labelChargeLabel);
        boxShipInfo.controls.add(labelPowerLabel);
        boxShipInfo.controls.add(labelType);
        boxShipInfo.controls.add(labelTypeLabel);
        boxShipInfo.controls.add(labelNameLabel);
        boxShipInfo.controls.add(buttonSell);
        boxShipInfo.controls.add(buttonBuy);
        boxShipInfo.controls.add(labelBuyPriceLabel);
        boxShipInfo.controls.add(labelBuyPrice);
        boxShipInfo.controls.add(labelSellPriceLabel);
        boxShipInfo.controls.add(pictureEquipment);
        boxShipInfo.controls.add(labelSellPrice);
        boxShipInfo.controls.add(labelName);
        boxShipInfo.controls.add(labelDescription);
        boxShipInfo.setLocation(new Point(308, 2));
        boxShipInfo.setName("boxShipInfo");
        boxShipInfo.setSize(new Dimension(208, 304));
        boxShipInfo.setTabIndex(3);
        boxShipInfo.setTabStop(false);
        boxShipInfo.setText("Equipment Information");
        // labelCharge
        labelCharge.setLocation(new Point(80, 164));
        labelCharge.setName("labelCharge");
        labelCharge.setSize(new Dimension(116, 16));
        labelCharge.setTabIndex(67);
        labelCharge.setText("888");
        // labelPower
        labelPower.setLocation(new Point(80, 148));
        labelPower.setName("labelPower");
        labelPower.setSize(new Dimension(116, 16));
        labelPower.setTabIndex(66);
        labelPower.setText("888");
        // labelChargeLabel
        labelChargeLabel.setAutoSize(true);
        labelChargeLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelChargeLabel.setLocation(new Point(8, 164));
        labelChargeLabel.setName("labelChargeLabel");
        labelChargeLabel.setSize(new Dimension(46, 16));
        labelChargeLabel.setTabIndex(65);
        labelChargeLabel.setText("Charge:");
        // labelPowerLabel
        labelPowerLabel.setAutoSize(true);
        labelPowerLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelPowerLabel.setLocation(new Point(8, 148));
        labelPowerLabel.setName("labelPowerLabel");
        labelPowerLabel.setSize(new Dimension(41, 16));
        labelPowerLabel.setTabIndex(64);
        labelPowerLabel.setText("Power:");
        // labelType
        labelType.setLocation(new Point(80, 100));
        labelType.setName("labelType");
        labelType.setSize(new Dimension(116, 16));
        labelType.setTabIndex(63);
        labelType.setText("Weapon");
        // labelTypeLabel
        labelTypeLabel.setAutoSize(true);
        labelTypeLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTypeLabel.setLocation(new Point(8, 100));
        labelTypeLabel.setName("labelTypeLabel");
        labelTypeLabel.setSize(new Dimension(34, 16));
        labelTypeLabel.setTabIndex(62);
        labelTypeLabel.setText("Type:");
        // labelNameLabel
        labelNameLabel.setAutoSize(true);
        labelNameLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelNameLabel.setLocation(new Point(8, 84));
        labelNameLabel.setName("labelNameLabel");
        labelNameLabel.setSize(new Dimension(39, 16));
        labelNameLabel.setTabIndex(61);
        labelNameLabel.setText("Name:");
        // buttonSell
        buttonSell.setFlatStyle(FlatStyle.Flat);
        buttonSell.setLocation(new Point(103, 272));
        buttonSell.setName("buttonSell");
        buttonSell.setSize(new Dimension(58, 22));
        buttonSell.setTabIndex(8);
        buttonSell.setText("Sell");
        buttonSell.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SellClick();
            }
        });
        // buttonBuy
        buttonBuy.setFlatStyle(FlatStyle.Flat);
        buttonBuy.setLocation(new Point(31, 272));
        buttonBuy.setName("buttonBuy");
        buttonBuy.setSize(new Dimension(58, 22));
        buttonBuy.setTabIndex(7);
        buttonBuy.setText("Buy");
        buttonBuy.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                BuyClick(sender, data);
            }
        });
        // labelBuyPriceLabel
        labelBuyPriceLabel.setAutoSize(true);
        labelBuyPriceLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelBuyPriceLabel.setLocation(new Point(8, 116));
        labelBuyPriceLabel.setName("labelBuyPriceLabel");
        labelBuyPriceLabel.setSize(new Dimension(58, 16));
        labelBuyPriceLabel.setTabIndex(57);
        labelBuyPriceLabel.setText("Buy Price:");
        // labelBuyPrice
        labelBuyPrice.setLocation(new Point(80, 116));
        labelBuyPrice.setName("labelBuyPrice");
        labelBuyPrice.setSize(new Dimension(116, 16));
        labelBuyPrice.setTabIndex(56);
        labelBuyPrice.setText("888,888 cr.");
        // labelSellPriceLabel
        labelSellPriceLabel.setAutoSize(true);
        labelSellPriceLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelSellPriceLabel.setLocation(new Point(8, 132));
        labelSellPriceLabel.setName("labelSellPriceLabel");
        labelSellPriceLabel.setSize(new Dimension(58, 16));
        labelSellPriceLabel.setTabIndex(55);
        labelSellPriceLabel.setText("Sell Price:");
        // pictureEquipment
        pictureEquipment.setBackgroundColor(Color.white);
        pictureEquipment.setBorderStyle(BorderStyle.FixedSingle);
        pictureEquipment.setLocation(new Point(71, 20));
        pictureEquipment.setName("pictureEquipment");
        pictureEquipment.setSize(new Dimension(66, 54));
        pictureEquipment.setTabIndex(54);
        pictureEquipment.setTabStop(false);
        pictureEquipment.setVisible(false);
        // labelSellPrice
        labelSellPrice.setLocation(new Point(80, 132));
        labelSellPrice.setName("labelSellPrice");
        labelSellPrice.setSize(new Dimension(116, 16));
        labelSellPrice.setTabIndex(52);
        labelSellPrice.setText("888,888 cr.");
        // labelDescription
        labelDescription.setLocation(new Point(8, 188));
        labelDescription.setName("labelDescription");
        labelDescription.setSize(new Dimension(196, 75));
        labelDescription.setTabIndex(47);
        // labelName
        labelName.setLocation(new Point(80, 84));
        labelName.setName("labelName");
        labelName.setSize(new Dimension(116, 16));
        labelName.setTabIndex(35);
        labelName.setText("Auto-Repair System");
        // FormEquipment
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new Dimension(522, 311));
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
        boxSell.resumeLayout(false);
        boxBuy.resumeLayout(false);
        boxShipInfo.resumeLayout(false);
        resumeLayout(false);
        UpdateBuy();
        UpdateSell();
    }

    private void Buy() {
        if (selectedEquipment != null && !sellSideSelected) {
            final EquipmentType baseType = selectedEquipment.EquipmentType();
            if (baseType == EquipmentType.Gadget && ship.HasGadget(((Gadget) selectedEquipment).Type())
                    && ((Gadget) selectedEquipment).Type() != GadgetType.ExtraCargoBays) {
                DialogAlert.Alert(AlertType.EquipmentAlreadyOwn, this);
            } else if (commander.getDebt() > 0) {
                DialogAlert.Alert(AlertType.DebtNoBuy, this);
            } else if (selectedEquipment.Price() > commander.CashToSpend()) {
                DialogAlert.Alert(AlertType.EquipmentIF, this);
            } else if ((baseType == EquipmentType.Weapon && ship.FreeSlotsWeapon() == 0)
                    || (baseType == EquipmentType.Shield && ship.FreeSlotsShield() == 0)
                    || (baseType == EquipmentType.Gadget && ship.FreeSlotsGadget() == 0)) {
                DialogAlert.Alert(AlertType.EquipmentNotEnoughSlots, this);
            } else if (DialogAlert.Alert(AlertType.EquipmentBuy, this, selectedEquipment.Name(), ModelUtils.FormatNumber(selectedEquipment.Price())) == DialogResult.Yes) {
                ship.addEquipment(selectedEquipment);
                commander.setCash(commander.getCash() - selectedEquipment.Price());
                DeselectAll();
                UpdateSell();
                game.getParentWindow().updateAll();
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
            if (DialogAlert.Alert(AlertType.EquipmentSell, this) == DialogResult.Yes) {
                // The slot is the selected index. Two of the three list boxes will have selected indices of -1, so adding 2 to the total cancels those out.
                final int slot = listSellWeapon.getSelectedIndex() + listSellShield.getSelectedIndex() + listSellGadget.getSelectedIndex() + 2;
                if (selectedEquipment.EquipmentType() == EquipmentType.Gadget
                        && (((Gadget) selectedEquipment).Type() == GadgetType.ExtraCargoBays || ((Gadget) selectedEquipment).Type() == GadgetType.HiddenCargoBays)
                        && ship.FreeCargoBays() < 5) {
                    DialogAlert.Alert(AlertType.EquipmentExtraBaysInUse, this);
                } else {
                    commander.setCash(commander.getCash() + selectedEquipment.SellPrice());
                    ship.RemoveEquipment(selectedEquipment.EquipmentType(), slot);
                    UpdateSell();
                    game.getParentWindow().updateAll();
                }
            }
        }
    }

    private void UpdateBuy() {
        for (final Equipment equipment : equipBuy) {
            if (equipment.Price() > 0) {
                switch (equipment.EquipmentType()) {
                    case Weapon:
                        listBuyWeapon.Items.addElement(equipment);
                        break;
                    case Shield:
                        listBuyShield.Items.addElement(equipment);
                        break;
                    case Gadget:
                        listBuyGadget.Items.addElement(equipment);
                        break;
                }
            }
        }
        final ListBox[] buyBoxes = {listBuyWeapon, listBuyShield, listBuyGadget};
        final Label[] buyLabels = {labelBuyWeaponNone, labelBuyShieldNone, labelBuyGadgetNone};
        for (int i = 0; i < buyBoxes.length; i++) {
            final boolean entries = (!buyBoxes[i].Items.isEmpty());
            buyBoxes[i].setVisible(entries);
            buyLabels[i].setVisible(!entries);
            if (entries) {
                buyBoxes[i].setHeight(buyBoxes[i].getItemHeight() * Math.min(buyBoxes[i].Items.size(), 5) + 2);
            }
        }
    }

    private void UpdateInfo() {
        final boolean visible = selectedEquipment != null;
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
            labelType.setText(Strings.EquipmentTypes[selectedEquipment.EquipmentType().getId()]);
            labelDescription.setText(Strings.EquipmentDescriptions[selectedEquipment.EquipmentType().getId()][selectedEquipment.SubType().asInteger()]);
            labelBuyPrice.setText(ModelUtils.FormatMoney(selectedEquipment.Price()));
            labelSellPrice.setText(ModelUtils.FormatMoney(selectedEquipment.SellPrice()));
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
        equipSell = ship.getEquipmentByType(EquipmentType.Weapon);
        for (index = 0; index < equipSell.length; index++) {
            final Object obj = equipSell[index] == null ? Strings.EquipmentFreeSlot : equipSell[index];
            listSellWeapon.Items.addElement(obj);
        }
        equipSell = ship.getEquipmentByType(EquipmentType.Shield);
        for (index = 0; index < equipSell.length; index++) {
            final Object obj = equipSell[index] == null ? Strings.EquipmentFreeSlot : equipSell[index];
            listSellShield.Items.addElement(obj);
        }
        equipSell = ship.getEquipmentByType(EquipmentType.Gadget);
        for (index = 0; index < equipSell.length; index++) {
            final Object obj = equipSell[index] == null ? Strings.EquipmentFreeSlot : equipSell[index];
            listSellGadget.Items.addElement(obj);
        }
        final ListBox[] sellBoxes = {listSellWeapon, listSellShield, listSellGadget};
        final Label[] sellLabels = {labelSellWeaponNoSlots, labelSellShieldNoSlots, labelSellGadgetNoSlots};
        for (int i = 0; i < sellBoxes.length; i++) {
            final boolean entries = (!sellBoxes[i].Items.isEmpty());
            sellBoxes[i].setVisible(entries);
            sellLabels[i].setVisible(!entries);
            if (entries) {
                sellBoxes[i].setHeight(sellBoxes[i].getItemHeight() * Math.min(sellBoxes[i].Items.size(), 5) + 2);
            }
        }
    }

    private void BuyClick(final Object sender, final EventData e) {
        if (selectedEquipment != null) {
            Buy();
        }
    }

    private void SelectedIndexChanged(final Object sender, final EventData e) {
        if (!handlingSelect) {
            handlingSelect = true;
            final Object obj = ((ListBox) sender).getSelectedItem();
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
