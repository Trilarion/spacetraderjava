package org.spacetrader.ui;

import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.crew.CrewMember;
import org.spacetrader.model.enums.AlertType;
import org.spacetrader.model.enums.CrewMemberId;
import org.spacetrader.model.ship.Ship;
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


public class DialogViewPersonnel extends Dialog {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Ship ship = commander.getShip();
    private final Button buttonHireFire;
    private final Label labelRate;
    private final Label labelName;
    private final Label labelEngineer;
    private final Label labelTrader;
    private final Label labelFighter;
    private final Label labelPilot;
    private final Label labelEngineerLabel;
    private final Label labelTraderLabel;
    private final Label labelFighterLabel;
    private final Label labelPilotLabel;
    private final Label labelCrewNoQuarters;
    private final Label labelForHireNone;
    private final ListBox listForHire;
    private final ListBox listCrew;
    private CrewMember selectedCrewMember;
    private boolean handlingSelect;

    public DialogViewPersonnel() {
        final Button buttonClose = new Button();
        final GroupBox boxCurrentCrew = new GroupBox();
        listCrew = new ListBox();
        final GroupBox boxForHire = new GroupBox();
        listForHire = new ListBox();
        final GroupBox boxInfo = new GroupBox();
        buttonHireFire = new Button();
        labelRate = new Label();
        labelName = new Label();
        labelEngineer = new Label();
        labelTrader = new Label();
        labelFighter = new Label();
        labelPilot = new Label();
        labelEngineerLabel = new Label();
        labelTraderLabel = new Label();
        labelFighterLabel = new Label();
        labelPilotLabel = new Label();
        labelCrewNoQuarters = new Label();
        labelForHireNone = new Label();
        boxCurrentCrew.suspendLayout();
        boxForHire.suspendLayout();
        boxInfo.suspendLayout();
        suspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new Dimension(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // boxCurrentCrew
        boxCurrentCrew.controls.add(labelCrewNoQuarters);
        boxCurrentCrew.controls.add(listCrew);
        boxCurrentCrew.setLocation(new Point(8, 8));
        boxCurrentCrew.setName("boxCurrentCrew");
        boxCurrentCrew.setSize(new Dimension(144, 114));
        boxCurrentCrew.setTabIndex(33);
        boxCurrentCrew.setTabStop(false);
        boxCurrentCrew.setText("Current Crew");
        // listCrew
        listCrew.setBorderStyle(BorderStyle.FixedSingle);
        listCrew.setLocation(new Point(8, 24));
        listCrew.setName("listCrew");
        listCrew.setSize(new Dimension(126, 80));
        listCrew.setTabIndex(6);
        listCrew.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                HireFire(sender, data);
            }
        });
        listCrew.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // boxForHire
        boxForHire.controls.add(labelForHireNone);
        boxForHire.controls.add(listForHire);
        boxForHire.setLocation(new Point(160, 8));
        boxForHire.setName("boxForHire");
        boxForHire.setSize(new Dimension(144, 114));
        boxForHire.setTabIndex(34);
        boxForHire.setTabStop(false);
        boxForHire.setText("Mercenaries For Hire");
        // listForHire
        listForHire.setBorderStyle(BorderStyle.FixedSingle);
        listForHire.setLocation(new Point(8, 24));
        listForHire.setName("listForHire");
        listForHire.setSize(new Dimension(126, 80));
        listForHire.setTabIndex(5);
        listForHire.setDoubleClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                HireFire(sender, data);
            }
        });
        listForHire.setSelectedIndexChanged(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                SelectedIndexChanged(sender, data);
            }
        });
        // boxInfo
        boxInfo.controls.add(buttonHireFire);
        boxInfo.controls.add(labelRate);
        boxInfo.controls.add(labelName);
        boxInfo.controls.add(labelEngineer);
        boxInfo.controls.add(labelTrader);
        boxInfo.controls.add(labelFighter);
        boxInfo.controls.add(labelPilot);
        boxInfo.controls.add(labelEngineerLabel);
        boxInfo.controls.add(labelTraderLabel);
        boxInfo.controls.add(labelFighterLabel);
        boxInfo.controls.add(labelPilotLabel);
        boxInfo.setLocation(new Point(312, 8));
        boxInfo.setName("boxInfo");
        boxInfo.setSize(new Dimension(168, 114));
        boxInfo.setTabIndex(35);
        boxInfo.setTabStop(false);
        boxInfo.setText("Mercenary Information");
        // buttonHireFire
        buttonHireFire.setFlatStyle(FlatStyle.Flat);
        buttonHireFire.setLocation(new Point(120, 80));
        buttonHireFire.setName("buttonHireFire");
        buttonHireFire.setSize(new Dimension(36, 22));
        buttonHireFire.setTabIndex(4);
        buttonHireFire.setText("Hire");
        buttonHireFire.setClick(new EventHandler<>() {
            @Override
            public void handle(final Object sender, final EventData data) {
                HireFire(sender, data);
            }
        });
        // labelRate
        labelRate.setLocation(new Point(104, 40));
        labelRate.setName("labelRate");
        labelRate.setSize(new Dimension(59, 13));
        labelRate.setTabIndex(97);
        labelRate.setText("88 cr. daily");
        // labelName
        labelName.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelName.setLocation(new Point(12, 18));
        labelName.setName("labelName");
        labelName.setSize(new Dimension(72, 13));
        labelName.setTabIndex(96);
        labelName.setText("Xxxxxxxxxxx");
        // labelEngineer
        labelEngineer.setLocation(new Point(64, 88));
        labelEngineer.setName("labelEngineer");
        labelEngineer.setSize(new Dimension(17, 13));
        labelEngineer.setTabIndex(95);
        labelEngineer.setText("88");
        // labelTrader
        labelTrader.setLocation(new Point(64, 72));
        labelTrader.setName("labelTrader");
        labelTrader.setSize(new Dimension(17, 13));
        labelTrader.setTabIndex(94);
        labelTrader.setText("88");
        // labelFighter
        labelFighter.setLocation(new Point(64, 56));
        labelFighter.setName("labelFighter");
        labelFighter.setSize(new Dimension(17, 13));
        labelFighter.setTabIndex(93);
        labelFighter.setText("88");
        // labelPilot
        labelPilot.setLocation(new Point(64, 40));
        labelPilot.setName("labelPilot");
        labelPilot.setSize(new Dimension(17, 13));
        labelPilot.setTabIndex(92);
        labelPilot.setText("88");
        // labelEngineerLabel
        labelEngineerLabel.setAutoSize(true);
        labelEngineerLabel.setLocation(new Point(12, 88));
        labelEngineerLabel.setName("labelEngineerLabel");
        labelEngineerLabel.setSize(new Dimension(53, 16));
        labelEngineerLabel.setTabIndex(91);
        labelEngineerLabel.setText("Engineer:");
        // labelTraderLabel
        labelTraderLabel.setAutoSize(true);
        labelTraderLabel.setLocation(new Point(12, 72));
        labelTraderLabel.setName("labelTraderLabel");
        labelTraderLabel.setSize(new Dimension(41, 16));
        labelTraderLabel.setTabIndex(90);
        labelTraderLabel.setText("Trader:");
        // labelFighterLabel
        labelFighterLabel.setAutoSize(true);
        labelFighterLabel.setLocation(new Point(12, 56));
        labelFighterLabel.setName("labelFighterLabel");
        labelFighterLabel.setSize(new Dimension(43, 16));
        labelFighterLabel.setTabIndex(89);
        labelFighterLabel.setText("Fighter:");
        // labelPilotLabel
        labelPilotLabel.setAutoSize(true);
        labelPilotLabel.setLocation(new Point(12, 40));
        labelPilotLabel.setName("labelPilotLabel");
        labelPilotLabel.setSize(new Dimension(29, 16));
        labelPilotLabel.setTabIndex(88);
        labelPilotLabel.setText("Pilot:");
        // labelCrewNoQuarters
        labelCrewNoQuarters.setLocation(new Point(16, 24));
        labelCrewNoQuarters.setName("labelCrewNoQuarters");
        labelCrewNoQuarters.setSize(new Dimension(120, 16));
        labelCrewNoQuarters.setTabIndex(7);
        labelCrewNoQuarters.setText("No quarters available");
        labelCrewNoQuarters.setVisible(false);
        // labelForHireNone
        labelForHireNone.setLocation(new Point(16, 24));
        labelForHireNone.setName("labelForHireNone");
        labelForHireNone.setSize(new Dimension(120, 16));
        labelForHireNone.setTabIndex(8);
        labelForHireNone.setText("No one for hire");
        labelForHireNone.setVisible(false);
        // FormViewPersonnel
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new Dimension(488, 129));
        Controls.add(boxInfo);
        Controls.add(boxForHire);
        Controls.add(boxCurrentCrew);
        Controls.add(buttonClose);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormViewPersonnel");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Personnel");
        boxCurrentCrew.resumeLayout(false);
        boxForHire.resumeLayout(false);
        boxInfo.resumeLayout(false);
        resumeLayout(false);
        UpdateAll();
    }


    private void DeselectAll() {
        listForHire.clearSelected();
        listCrew.clearSelected();
    }

    private void UpdateAll() {
        selectedCrewMember = null;
        UpdateForHire();
        UpdateCurrentCrew();
        UpdateInfo();
    }

    private void UpdateCurrentCrew() {
        final CrewMember[] crew = ship.Crew();
        listCrew.Items.clear();
        for (int i = 1; i < crew.length; i++) {
            if (crew[i] == null) {
                listCrew.Items.addElement(Strings.PersonnelVacancy);
            } else {
                listCrew.Items.addElement(crew[i]);
            }
        }
        final boolean entries = (!listCrew.Items.isEmpty());
        listCrew.setVisible(entries);
        labelCrewNoQuarters.setVisible(!entries);
        if (entries) {
            listCrew.setHeight(listCrew.getItemHeight() * Math.min(listCrew.Items.size(), 6) + 2);
        } else { //TODO: remove this when Strings are moved to resource.
            labelCrewNoQuarters.setText(Strings.PersonnelNoQuarters);
        }
    }

    private void UpdateForHire() {
        final CrewMember[] mercs = commander.CurrentSystem().MercenariesForHire();
        listForHire.Items.clear();
        for (final CrewMember merc : mercs) {
            listForHire.Items.addElement(merc);
        }
        final boolean entries = (!listForHire.Items.isEmpty());
        listForHire.setVisible(entries);
        labelForHireNone.setVisible(!entries);
        if (entries) {
            listForHire.setHeight(listForHire.getItemHeight() * Math.min(listForHire.Items.size(), 6) + 2);
        } else { // TODO: remove this when Strings are moved to resource.
            labelForHireNone.setText(Strings.PersonnelNoMercenaries);
        }
    }

    private void UpdateInfo() {
        boolean visible = false;
        boolean rateVisible = false;
        boolean hireFireVisible = false;
        if (selectedCrewMember != null) {
            visible = true;
            if (selectedCrewMember.Rate() > 0) {
                rateVisible = true;
            }
            labelName.setText(selectedCrewMember.Name());
            labelRate.setText(ModelUtils.StringVars(Strings.MoneyRateSuffix, ModelUtils.FormatMoney(selectedCrewMember.Rate())));
            labelPilot.setText(selectedCrewMember.Pilot() + "");
            labelFighter.setText(selectedCrewMember.Fighter() + "");
            labelTrader.setText(selectedCrewMember.Trader() + "");
            labelEngineer.setText(selectedCrewMember.Engineer() + "");
            buttonHireFire.setText(ship.HasCrew(selectedCrewMember.Id()) ? Strings.MercenaryFire : Strings.MercenaryHire);
            hireFireVisible = rateVisible || selectedCrewMember.Id() == CrewMemberId.Zeethibal;
        }
        labelName.setVisible(visible);
        labelRate.setVisible(rateVisible);
        labelPilotLabel.setVisible(visible);
        labelFighterLabel.setVisible(visible);
        labelTraderLabel.setVisible(visible);
        labelEngineerLabel.setVisible(visible);
        labelPilot.setVisible(visible);
        labelFighter.setVisible(visible);
        labelTrader.setVisible(visible);
        labelEngineer.setVisible(visible);
        buttonHireFire.setVisible(hireFireVisible);
    }

    private void HireFire(final Object sender, final EventData e) {
        if (selectedCrewMember != null && buttonHireFire.getVisible()) {
            if (ship.HasCrew(selectedCrewMember.Id())) {
                if (DialogAlert.Alert(AlertType.CrewFireMercenary, this, selectedCrewMember.Name()) == DialogResult.Yes) {
                    ship.handleFire(selectedCrewMember.Id());
                    UpdateAll();
                    game.getParentWindow().updateAll();
                }
            } else {
                if (ship.FreeCrewQuarters() == 0) {
                    DialogAlert.Alert(AlertType.CrewNoQuarters, this, selectedCrewMember.Name());
                } else {
                    ship.Hire(selectedCrewMember);
                    UpdateAll();
                    game.getParentWindow().updateAll();
                }
            }
        }
    }

    private void SelectedIndexChanged(final Object sender, final EventData e) {
        if (!handlingSelect) {
            handlingSelect = true;
            final Object obj = ((ListBox) sender).getSelectedItem();
            DeselectAll();
            if (obj instanceof CrewMember) {
                ((ListBox) sender).setSelectedItem(obj);
                selectedCrewMember = (CrewMember) obj;
            } else {
                selectedCrewMember = null;
            }
            handlingSelect = false;
            UpdateInfo();
        }
    }
}
