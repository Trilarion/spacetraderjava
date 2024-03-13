package org.spacetrader.ui;

import org.spacetrader.controller.Game;
import org.spacetrader.controller.GameOptions;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormOptions extends wfForm {
    private final CheckBox checkBoxFuel;
    private final CheckBox checkBoxContinuousAttack;
    private final CheckBox checkBoxAttackFleeing;
    private final CheckBox checkBoxDisable;
    private final CheckBox checkBoxNewspaper;
    private final CheckBox checkBoxNewspaperShow;
    private final CheckBox checkBoxRange;
    private final CheckBox checkBoxStopTracking;
    private final CheckBox checkBoxLoan;
    private final CheckBox checkBoxIgnoreTradersDealing;
    private final CheckBox checkBoxReserveMoney;
    private final CheckBox checkBoxIgnoreTraders;
    private final CheckBox checkBoxIgnorePirates;
    private final CheckBox checkBoxIgnorePolice;
    private final CheckBox checkBoxRepair;
    private final NumericUpDown numEmpty;
    private final GameOptions opts = new GameOptions(false);
    private boolean initializing = true;

    public FormOptions() {
        Button buttonOk = new Button();
        Button buttonCancel = new Button();
        Label labelEmpty = new Label();
        checkBoxFuel = new CheckBox();
        checkBoxContinuousAttack = new CheckBox();
        checkBoxAttackFleeing = new CheckBox();
        checkBoxNewspaper = new CheckBox();
        checkBoxRange = new CheckBox();
        checkBoxStopTracking = new CheckBox();
        checkBoxLoan = new CheckBox();
        checkBoxIgnoreTradersDealing = new CheckBox();
        checkBoxReserveMoney = new CheckBox();
        checkBoxIgnoreTraders = new CheckBox();
        checkBoxIgnorePirates = new CheckBox();
        checkBoxIgnorePolice = new CheckBox();
        checkBoxRepair = new CheckBox();
        Label labelIgnore = new Label();
        numEmpty = new NumericUpDown();
        Button buttonSave = new Button();
        Button buttonLoad = new Button();
        checkBoxNewspaperShow = new CheckBox();
        checkBoxDisable = new CheckBox();
                SuspendLayout();
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(14, 240));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new SizeF(22, 40));
        buttonOk.setTabIndex(15);
        buttonOk.setText("Ok");
        // buttonCancel
        buttonCancel.setDialogResult(DialogResult.Cancel);
        buttonCancel.setFlatStyle(FlatStyle.Flat);
        buttonCancel.setLocation(new Point(62, 240));
        buttonCancel.setName("buttonCancel");
        buttonCancel.setSize(new SizeF(22, 49));
        buttonCancel.setTabIndex(16);
        buttonCancel.setText("Cancel");
        // labelEmpty
        labelEmpty.setAutoSize(true);
        labelEmpty.setLocation(new Point(52, 90));
        labelEmpty.setName("labelEmpty");
        labelEmpty.setSize(new SizeF(16, 292));
        labelEmpty.setTabIndex(38);
        labelEmpty.setText("Cargo Bays to leave empty when buying goods in-system");
        // checkBoxFuel
        checkBoxFuel.setLocation(new Point(8, 8));
        checkBoxFuel.setName("checkBoxFuel");
        checkBoxFuel.setSize(new SizeF(16, 160));
        checkBoxFuel.setTabIndex(1);
        checkBoxFuel.setText("Get full fuel tanks on arrival");
        checkBoxFuel.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxContinuousAttack
        checkBoxContinuousAttack.setLocation(new Point(8, 176));
        checkBoxContinuousAttack.setName("checkBoxContinuousAttack");
        checkBoxContinuousAttack.setSize(new SizeF(16, 163));
        checkBoxContinuousAttack.setTabIndex(13);
        checkBoxContinuousAttack.setText("Continuous attack and flight");
        checkBoxContinuousAttack.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxAttackFleeing
        checkBoxAttackFleeing.setLocation(new Point(24, 192));
        checkBoxAttackFleeing.setName("checkBoxAttackFleeing");
        checkBoxAttackFleeing.setSize(new SizeF(16, 177));
        checkBoxAttackFleeing.setTabIndex(14);
        checkBoxAttackFleeing.setText("Continue attacking fleeing ship");
        checkBoxAttackFleeing.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxNewspaper
        checkBoxNewspaper.setLocation(new Point(8, 40));
        checkBoxNewspaper.setName("checkBoxNewspaper");
        checkBoxNewspaper.setSize(new SizeF(16, 155));
        checkBoxNewspaper.setTabIndex(3);
        checkBoxNewspaper.setText("Always pay for newspaper");
        checkBoxNewspaper.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxRange
        checkBoxRange.setLocation(new Point(184, 8));
        checkBoxRange.setName("checkBoxRange");
        checkBoxRange.setSize(new SizeF(16, 175));
        checkBoxRange.setTabIndex(5);
        checkBoxRange.setText("Show range to tracked system");
        checkBoxRange.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxStopTracking
        checkBoxStopTracking.setLocation(new Point(184, 24));
        checkBoxStopTracking.setName("checkBoxStopTracking");
        checkBoxStopTracking.setSize(new SizeF(16, 139));
        checkBoxStopTracking.setTabIndex(6);
        checkBoxStopTracking.setText("Stop tracking on arrival");
        checkBoxStopTracking.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxLoan
        checkBoxLoan.setLocation(new Point(184, 56));
        checkBoxLoan.setName("checkBoxLoan");
        checkBoxLoan.setSize(new SizeF(16, 124));
        checkBoxLoan.setTabIndex(4);
        checkBoxLoan.setText("Remind about loans");
        checkBoxLoan.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxIgnoreTradersDealing
        checkBoxIgnoreTradersDealing.setLocation(new Point(152, 152));
        checkBoxIgnoreTradersDealing.setName("checkBoxIgnoreTradersDealing");
        checkBoxIgnoreTradersDealing.setSize(new SizeF(16, 133));
        checkBoxIgnoreTradersDealing.setTabIndex(12);
        checkBoxIgnoreTradersDealing.setText("Ignore dealing traders");
        checkBoxIgnoreTradersDealing.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxReserveMoney
        checkBoxReserveMoney.setLocation(new Point(184, 40));
        checkBoxReserveMoney.setName("checkBoxReserveMoney");
        checkBoxReserveMoney.setSize(new SizeF(16, 176));
        checkBoxReserveMoney.setTabIndex(7);
        checkBoxReserveMoney.setText("Reserve money for warp costs");
        checkBoxReserveMoney.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxIgnoreTraders
        checkBoxIgnoreTraders.setLocation(new Point(136, 136));
        checkBoxIgnoreTraders.setName("checkBoxIgnoreTraders");
        checkBoxIgnoreTraders.setSize(new SizeF(16, 62));
        checkBoxIgnoreTraders.setTabIndex(11);
        checkBoxIgnoreTraders.setText("Traders");
        checkBoxIgnoreTraders.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxIgnorePirates
        checkBoxIgnorePirates.setLocation(new Point(8, 136));
        checkBoxIgnorePirates.setName("checkBoxIgnorePirates");
        checkBoxIgnorePirates.setSize(new SizeF(16, 58));
        checkBoxIgnorePirates.setTabIndex(9);
        checkBoxIgnorePirates.setText("Pirates");
        checkBoxIgnorePirates.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxIgnorePolice
        checkBoxIgnorePolice.setLocation(new Point(74, 136));
        checkBoxIgnorePolice.setName("checkBoxIgnorePolice");
        checkBoxIgnorePolice.setSize(new SizeF(16, 54));
        checkBoxIgnorePolice.setTabIndex(10);
        checkBoxIgnorePolice.setText("Police");
        checkBoxIgnorePolice.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxRepair
        checkBoxRepair.setLocation(new Point(8, 24));
        checkBoxRepair.setName("checkBoxRepair");
        checkBoxRepair.setSize(new SizeF(16, 167));
        checkBoxRepair.setTabIndex(2);
        checkBoxRepair.setText("Get full hull repairs on arrival");
        checkBoxRepair.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // labelIgnore
        labelIgnore.setAutoSize(true);
        labelIgnore.setLocation(new Point(8, 120));
        labelIgnore.setName("labelIgnore");
        labelIgnore.setSize(new SizeF(16, 152));
        labelIgnore.setTabIndex(52);
        labelIgnore.setText("Always ignore when it is safe:");
        // numEmpty
        numEmpty.setLocation(new Point(8, 88));
        numEmpty.setMaximum(99);
        numEmpty.setName("numEmpty");
        numEmpty.setSize(new SizeF(20, 40));
        numEmpty.setTabIndex(8);
        numEmpty.setValue(88);
        numEmpty.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // buttonSave
        buttonSave.setFlatStyle(FlatStyle.Flat);
        buttonSave.setLocation(new Point(119, 240));
        buttonSave.setName("buttonSave");
        buttonSave.setSize(new SizeF(22, 107));
        buttonSave.setTabIndex(17);
        buttonSave.setText("Save As Defaults");
        buttonSave.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonSave_Click();
            }
        });
        // buttonLoad
        buttonLoad.setFlatStyle(FlatStyle.Flat);
        buttonLoad.setLocation(new Point(234, 240));
        buttonLoad.setName("buttonLoad");
        buttonLoad.setSize(new SizeF(22, 114));
        buttonLoad.setTabIndex(18);
        buttonLoad.setText("Load from Defaults");
        buttonLoad.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonLoad_Click();
            }
        });
        // checkBoxNewspaperShow
        checkBoxNewspaperShow.setLocation(new Point(24, 56));
        checkBoxNewspaperShow.setName("checkBoxNewspaperShow");
        checkBoxNewspaperShow.setSize(new SizeF(16, 160));
        checkBoxNewspaperShow.setTabIndex(53);
        checkBoxNewspaperShow.setText("Show newspaper on arrival");
        checkBoxNewspaperShow.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // checkBoxDisable
        checkBoxDisable.setLocation(new Point(8, 208));
        checkBoxDisable.setName("checkBoxDisable");
        checkBoxDisable.setSize(new SizeF(16, 244));
        checkBoxDisable.setTabIndex(54);
        checkBoxDisable.setText("Attempt to disable opponents when possible");
        checkBoxDisable.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                controlChanged();
            }
        });
        // FormOptions
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonCancel);
        setClientSize(new SizeF(271, 362));
        Controls.add(checkBoxDisable);
        Controls.add(checkBoxLoan);
        Controls.add(checkBoxNewspaperShow);
        Controls.add(buttonLoad);
        Controls.add(buttonSave);
        Controls.add(numEmpty);
        Controls.add(labelIgnore);
        Controls.add(labelEmpty);
        Controls.add(checkBoxRepair);
        Controls.add(checkBoxIgnorePolice);
        Controls.add(checkBoxIgnorePirates);
        Controls.add(checkBoxIgnoreTraders);
        Controls.add(checkBoxReserveMoney);
        Controls.add(checkBoxIgnoreTradersDealing);
        Controls.add(checkBoxStopTracking);
        Controls.add(checkBoxRange);
        Controls.add(checkBoxNewspaper);
        Controls.add(checkBoxAttackFleeing);
        Controls.add(checkBoxContinuousAttack);
        Controls.add(checkBoxFuel);
        Controls.add(buttonCancel);
        Controls.add(buttonOk);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormOptions");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Options");
                ResumeLayout(false);
        Game game = Game.getCurrentGame();
        if (game != null) {
            opts.CopyValues(game.Options());
        } else {
            opts.LoadFromDefaults(false, this);
            buttonOk.setEnabled(false);
            // no game set, only allow to change default options
        }
        UpdateAll();
    }


    private void UpdateAll() {
        initializing = true;
        checkBoxFuel.setChecked(opts.getAutoFuel());
        checkBoxRepair.setChecked(opts.getAutoRepair());
        checkBoxNewspaper.setChecked(opts.getNewsAutoPay());
        checkBoxNewspaperShow.setChecked(opts.getNewsAutoShow());
        checkBoxLoan.setChecked(opts.getRemindLoans());
        checkBoxRange.setChecked(opts.getShowTrackedRange());
        checkBoxStopTracking.setChecked(opts.getTrackAutoOff());
        checkBoxReserveMoney.setChecked(opts.getReserveMoney());
        numEmpty.setValue(opts.getLeaveEmpty());
        checkBoxIgnorePirates.setChecked(opts.getAlwaysIgnorePirates());
        checkBoxIgnorePolice.setChecked(opts.getAlwaysIgnorePolice());
        checkBoxIgnoreTraders.setChecked(opts.getAlwaysIgnoreTraders());
        checkBoxIgnoreTradersDealing.setChecked(opts.getAlwaysIgnoreTradeInOrbit());
        checkBoxContinuousAttack.setChecked(opts.getContinuousAttack());
        checkBoxAttackFleeing.setChecked(opts.getContinuousAttackFleeing());
        checkBoxDisable.setChecked(opts.getDisableOpponents());
        UpdateContinueAttackFleeing();
        UpdateIgnoreTradersDealing();
        UpdateNewsAutoShow();
        initializing = false;
    }

    private void UpdateContinueAttackFleeing() {
        if (!checkBoxContinuousAttack.isChecked()) {
            checkBoxAttackFleeing.setChecked(false);
        }
        checkBoxAttackFleeing.setEnabled(checkBoxContinuousAttack.isChecked());
    }

    private void UpdateIgnoreTradersDealing() {
        if (!checkBoxIgnoreTraders.isChecked()) {
            checkBoxIgnoreTradersDealing.setChecked(false);
        }
        checkBoxIgnoreTradersDealing.setEnabled(checkBoxIgnoreTraders.isChecked());
    }

    private void UpdateNewsAutoShow() {
        if (!checkBoxNewspaper.isChecked()) {
            checkBoxNewspaperShow.setChecked(false);
        }
        checkBoxNewspaperShow.setEnabled(checkBoxNewspaper.isChecked());
    }

    private void buttonLoad_Click() {
        opts.LoadFromDefaults(true, this);
        UpdateAll();
    }

    private void buttonSave_Click() {
        opts.SaveAsDefaults(this);
    }

    private void controlChanged() {
        if (!initializing) {
            initializing = true;
            UpdateContinueAttackFleeing();
            UpdateIgnoreTradersDealing();
            UpdateNewsAutoShow();
            initializing = false;
            opts.setAutoFuel(checkBoxFuel.isChecked());
            opts.setAutoRepair(checkBoxRepair.isChecked());
            opts.setNewsAutoPay(checkBoxNewspaper.isChecked());
            opts.setNewsAutoShow(checkBoxNewspaperShow.isChecked());
            opts.setRemindLoans(checkBoxLoan.isChecked());
            opts.setShowTrackedRange(checkBoxRange.isChecked());
            opts.setTrackAutoOff(checkBoxStopTracking.isChecked());
            opts.setReserveMoney(checkBoxReserveMoney.isChecked());
            opts.setLeaveEmpty(numEmpty.getValue());
            opts.setAlwaysIgnorePirates(checkBoxIgnorePirates.isChecked());
            opts.setAlwaysIgnorePolice(checkBoxIgnorePolice.isChecked());
            opts.setAlwaysIgnoreTraders(checkBoxIgnoreTraders.isChecked());
            opts.setAlwaysIgnoreTradeInOrbit(checkBoxIgnoreTradersDealing.isChecked());
            opts.setContinuousAttack(checkBoxContinuousAttack.isChecked());
            opts.setContinuousAttackFleeing(checkBoxAttackFleeing.isChecked());
            opts.setDisableOpponents(checkBoxDisable.isChecked());
        }
    }

    public GameOptions Options() {
        return opts;
    }
}
