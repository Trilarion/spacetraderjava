package org.spacetrader.ui;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.equipment.GadgetType;
import org.spacetrader.util.Utils;
import org.winforms.util.Font;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.GroupBox;
import org.winforms.widget.Label;
import org.winforms.dialog.DialogResult;
import org.winforms.style.FontStyle;
import org.winforms.style.FormBorderStyle;
import org.winforms.alignment.FormStartPosition;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class DialogViewShip extends Dialog {
    private final Label labelSpecialCargo;
    private final Label labelEquipLabel;
    private final Label labelEquip;
    private final Game game = Game.getCurrentGame();
    private final Ship ship = game.Commander().getShip();

    public DialogViewShip() {
        final Label labelTypeLabel = new Label();
        final Label labelType = new Label();
        final Button buttonClose = new Button();
        labelEquipLabel = new Label();
        labelEquip = new Label();
        final GroupBox boxSpecialCargo = new GroupBox();
        labelSpecialCargo = new Label();
        boxSpecialCargo.suspendLayout();
        suspendLayout();
        // labelTypeLabel
        labelTypeLabel.setAutoSize(true);
        labelTypeLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTypeLabel.setLocation(new Point(8, 8));
        labelTypeLabel.setSize(new Dimension(34, 13));
        labelTypeLabel.setTabIndex(2);
        labelTypeLabel.setText("Type:");
        // labelType
        labelType.setLocation(new Point(80, 8));
        labelType.setSize(new Dimension(100, 13));
        labelType.setTabIndex(4);
        labelType.setText("Grasshopper");
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setSize(new Dimension(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelEquipLabel
        labelEquipLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelEquipLabel.setLocation(new Point(8, 34));
        labelEquipLabel.setSize(new Dimension(64, 176));
        labelEquipLabel.setTabIndex(43);
        labelEquipLabel.setText("Hull:\r\n\r\nEquipment:\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nUnfilled:");
        // labelEquip
        labelEquip.setLocation(new Point(80, 34));
        labelEquip.setSize(new Dimension(120, 176));
        labelEquip.setTabIndex(44);
        labelEquip.setText("Hardened\r\n\r\n1 Military Laser\r\n1 Morgan's Laser\r\n1 Energy Shield\r\n1 Reflective Shi"
                + "eld\r\n1 Lightning Shield\r\nNavigating System\r\nAuto-Repair System\r\n10 Extra Cargo Bays\r\nAn Escape Pod\r\n"
                + "\r\n1 weapon slot\r\n1 gadget slot");
        // boxSpecialCargo
        boxSpecialCargo.controls.addAll(labelSpecialCargo);
        boxSpecialCargo.setLocation(new Point(192, 8));
        boxSpecialCargo.setSize(new Dimension(200, 204));
        boxSpecialCargo.setTabIndex(64);
        boxSpecialCargo.setTabStop(false);
        boxSpecialCargo.setText("Special Cargo");
        // labelSpecialCargo
        labelSpecialCargo.setLocation(new Point(8, 16));
        labelSpecialCargo.setSize(new Dimension(190, 176));
        labelSpecialCargo.setTabIndex(0);
        labelSpecialCargo.setText("No special items.");
        // FormViewShip
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new Dimension(402, 219));
        Controls.addAll(Arrays.asList(boxSpecialCargo, labelEquip, labelEquipLabel, buttonClose, labelTypeLabel, labelType));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Current Ship");
        boxSpecialCargo.resumeLayout(false);
        resumeLayout(false);
        labelType.setText(ship.Name());
        labelEquipLabel.setText("");
        labelEquip.setText("");
        DisplayEquipment();
        DisplaySpecialCargo();
    }


    private void DisplayEquipment() {
        if (game.getQuestStatusScarab() == SpecialEvent.StatusScarabDone) {
            labelEquipLabel.setText(labelEquipLabel.getText() + ("Hull:" + Strings.newline + Strings.newline));
            labelEquip.setText(labelEquip.getText() + ("Hardened" + Strings.newline + Strings.newline));
        }
        boolean equipPrinted = false;
        for (int i = 0; i < Constants.WeaponObjects.length; i++) {
            int count = 0;
            for (int j = 0; j < ship.Weapons().length; j++) {
                if (ship.Weapons()[j] != null && ship.Weapons()[j].Type() == Constants.WeaponObjects[i].Type()) {
                    count++;
                }
            }
            if (count > 0) {
                labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
                labelEquip.setText(labelEquip.getText() + (ModelUtils.Multiples(count, Constants.WeaponObjects[i].Name()) + Strings.newline));
                equipPrinted = true;
            }
        }
        for (int i = 0; i < Constants.Shields.length; i++) {
            int count = 0;
            for (int j = 0; j < ship.Shields().length; j++) {
                if (ship.Shields()[j] != null && ship.Shields()[j].Type() == Constants.Shields[i].Type()) {
                    count++;
                }
            }
            if (count > 0) {
                labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
                labelEquip.setText(labelEquip.getText() + (ModelUtils.Multiples(count, Constants.Shields[i].Name()) + Strings.newline));
                equipPrinted = true;
            }
        }
        for (int i = 0; i < Constants.Gadgets.length; i++) {
            int count = 0;
            for (int j = 0; j < ship.Gadgets().length; j++) {
                if (ship.Gadgets()[j] != null && ship.Gadgets()[j].Type() == Constants.Gadgets[i].Type()) {
                    count++;
                }
            }
            if (count > 0) {
                labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
                if (i == GadgetType.ExtraCargoBays.asInteger() || i == GadgetType.HiddenCargoBays.asInteger()) {
                    count *= 5;
                    labelEquip.setText(labelEquip.getText() + (ModelUtils.FormatNumber(count) + Constants.Gadgets[i].Name().substring(1) + Strings.newline));
                } else {
                    labelEquip.setText(labelEquip.getText() + (ModelUtils.Multiples(count, Constants.Gadgets[i].Name()) + Strings.newline));
                }
                equipPrinted = true;
            }
        }
        if (ship.getEscapePod()) {
            labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
            labelEquip.setText(labelEquip.getText() + ("1 " + Strings.ShipInfoEscapePod + Strings.newline));
            equipPrinted = true;
        }
        if (ship.FreeSlots() > 0) {
            labelEquipLabel.setText(labelEquipLabel.getText() + ((equipPrinted ? Strings.newline : "") + "Unfilled:"));
            labelEquip.setText(labelEquip.getText() + (equipPrinted ? Strings.newline : ""));
            if (ship.FreeSlotsWeapon() > 0) {
                labelEquip.setText(labelEquip.getText() + (ModelUtils.Multiples(ship.FreeSlotsWeapon(), "weapon slot") + Strings.newline));
            }
            if (ship.FreeSlotsShield() > 0) {
                labelEquip.setText(labelEquip.getText() + (ModelUtils.Multiples(ship.FreeSlotsShield(), "shield slot") + Strings.newline));
            }
            if (ship.FreeSlotsGadget() > 0) {
                labelEquip.setText(labelEquip.getText() + (ModelUtils.Multiples(ship.FreeSlotsGadget(), "gadget slot") + Strings.newline));
            }
        }
    }

    private void DisplaySpecialCargo() {
        final ArrayList<String> specialCargo = new ArrayList<>(12);
        if (ship.getTribbles() > 0) {
            if (ship.getTribbles() == Constants.MaxTribbles) {
                specialCargo.add(Strings.SpecialCargoTribblesInfest);
            } else {
                specialCargo.add(ModelUtils.Multiples(ship.getTribbles(), Strings.SpecialCargoTribblesCute) + ".");
            }
        }
        if (game.getQuestStatusJapori() == SpecialEvent.StatusJaporiInTransit) {
            specialCargo.add(Strings.SpecialCargoJapori);
        }
        if (ship.ArtifactOnBoard()) {
            specialCargo.add(Strings.SpecialCargoArtifact);
        }
        if (game.getQuestStatusJarek() == SpecialEvent.StatusJarekDone) {
            specialCargo.add(Strings.SpecialCargoJarek);
        }
        if (ship.ReactorOnBoard()) {
            specialCargo.add(Strings.SpecialCargoReactor);
            specialCargo.add(ModelUtils.Multiples(10 - ((game.getQuestStatusReactor() - 1) / 2), "bay") + Strings.SpecialCargoReactorBays);
        }
        if (ship.SculptureOnBoard()) {
            specialCargo.add(Strings.SpecialCargoSculpture);
        }
        if (game.getCanSuperWarp()) {
            specialCargo.add(Strings.SpecialCargoExperiment);
        }
        labelSpecialCargo.setText(specialCargo.isEmpty()
                ? Strings.SpecialCargoNone
                : Utils.stringsJoin(Strings.newline + Strings.newline, ModelUtils.arrayListtoStringArray(specialCargo)));
    }
}
