package org.spacetrader.ui;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.ship.Ship;
import org.spacetrader.model.ship.equipment.GadgetType;
import org.spacetrader.util.Util;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FontStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FormViewShip extends form {
    private final Label labelSpecialCargo;
    private final Label labelEquipLabel;
    private final Label labelEquip;
    private final Game game = Game.getCurrentGame();
    private final Ship ship = game.Commander().getShip();

    public FormViewShip() {
        Label labelTypeLabel = new Label();
        Label labelType = new Label();
        Button buttonClose = new Button();
        labelEquipLabel = new Label();
        labelEquip = new Label();
        GroupBox boxSpecialCargo = new GroupBox();
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
        if (SpecialEvent.StatusScarabDone == game.getQuestStatusScarab()) {
            labelEquipLabel.setText(labelEquipLabel.getText() + ("Hull:" + Strings.newline + Strings.newline));
            labelEquip.setText(labelEquip.getText() + ("Hardened" + Strings.newline + Strings.newline));
        }
        boolean equipPrinted = false;
        for (int i = 0; i < Constants.WeaponObjects.length; i++) {
            int count = 0;
            for (int j = 0; j < ship.Weapons().length; j++) {
                if (null != ship.Weapons()[j] && ship.Weapons()[j].Type() == Constants.WeaponObjects[i].Type()) {
                    count++;
                }
            }
            if (0 < count) {
                labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
                labelEquip.setText(labelEquip.getText() + (Functions.Multiples(count, Constants.WeaponObjects[i].Name()) + Strings.newline));
                equipPrinted = true;
            }
        }
        for (int i = 0; i < Constants.Shields.length; i++) {
            int count = 0;
            for (int j = 0; j < ship.Shields().length; j++) {
                if (null != ship.Shields()[j] && ship.Shields()[j].Type() == Constants.Shields[i].Type()) {
                    count++;
                }
            }
            if (0 < count) {
                labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
                labelEquip.setText(labelEquip.getText() + (Functions.Multiples(count, Constants.Shields[i].Name()) + Strings.newline));
                equipPrinted = true;
            }
        }
        for (int i = 0; i < Constants.Gadgets.length; i++) {
            int count = 0;
            for (int j = 0; j < ship.Gadgets().length; j++) {
                if (null != ship.Gadgets()[j] && ship.Gadgets()[j].Type() == Constants.Gadgets[i].Type()) {
                    count++;
                }
            }
            if (0 < count) {
                labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
                if (i == GadgetType.ExtraCargoBays.asInteger() || i == GadgetType.HiddenCargoBays.asInteger()) {
                    count *= 5;
                    labelEquip.setText(labelEquip.getText() + (Functions.FormatNumber(count) + Constants.Gadgets[i].Name().substring(1) + Strings.newline));
                } else {
                    labelEquip.setText(labelEquip.getText() + (Functions.Multiples(count, Constants.Gadgets[i].Name()) + Strings.newline));
                }
                equipPrinted = true;
            }
        }
        if (ship.getEscapePod()) {
            labelEquipLabel.setText(labelEquipLabel.getText() + (equipPrinted ? Strings.newline : "Equipment:" + Strings.newline));
            labelEquip.setText(labelEquip.getText() + ("1 " + Strings.ShipInfoEscapePod + Strings.newline));
            equipPrinted = true;
        }
        if (0 < ship.FreeSlots()) {
            labelEquipLabel.setText(labelEquipLabel.getText() + ((equipPrinted ? Strings.newline : "") + "Unfilled:"));
            labelEquip.setText(labelEquip.getText() + (equipPrinted ? Strings.newline : ""));
            if (0 < ship.FreeSlotsWeapon()) {
                labelEquip.setText(labelEquip.getText() + (Functions.Multiples(ship.FreeSlotsWeapon(), "weapon slot") + Strings.newline));
            }
            if (0 < ship.FreeSlotsShield()) {
                labelEquip.setText(labelEquip.getText() + (Functions.Multiples(ship.FreeSlotsShield(), "shield slot") + Strings.newline));
            }
            if (0 < ship.FreeSlotsGadget()) {
                labelEquip.setText(labelEquip.getText() + (Functions.Multiples(ship.FreeSlotsGadget(), "gadget slot") + Strings.newline));
            }
        }
    }

    private void DisplaySpecialCargo() {
        ArrayList<String> specialCargo = new ArrayList<>(12);
        if (0 < ship.getTribbles()) {
            if (Constants.MaxTribbles == ship.getTribbles()) {
                specialCargo.add(Strings.SpecialCargoTribblesInfest);
            } else {
                specialCargo.add(Functions.Multiples(ship.getTribbles(), Strings.SpecialCargoTribblesCute) + ".");
            }
        }
        if (SpecialEvent.StatusJaporiInTransit == game.getQuestStatusJapori()) {
            specialCargo.add(Strings.SpecialCargoJapori);
        }
        if (ship.ArtifactOnBoard()) {
            specialCargo.add(Strings.SpecialCargoArtifact);
        }
        if (SpecialEvent.StatusJarekDone == game.getQuestStatusJarek()) {
            specialCargo.add(Strings.SpecialCargoJarek);
        }
        if (ship.ReactorOnBoard()) {
            specialCargo.add(Strings.SpecialCargoReactor);
            specialCargo.add(Functions.Multiples(10 - ((game.getQuestStatusReactor() - 1) / 2), "bay") + Strings.SpecialCargoReactorBays);
        }
        if (ship.SculptureOnBoard()) {
            specialCargo.add(Strings.SpecialCargoSculpture);
        }
        if (game.getCanSuperWarp()) {
            specialCargo.add(Strings.SpecialCargoExperiment);
        }
        labelSpecialCargo.setText(specialCargo.isEmpty()
                ? Strings.SpecialCargoNone
                : Util.stringsJoin(Strings.newline + Strings.newline, Functions.arrayListtoStringArray(specialCargo)));
    }
}
