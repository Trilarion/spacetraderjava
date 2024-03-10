package org.spacetrader.ui;

import org.spacetrader.controller.Game;
import org.spacetrader.controller.GameOptions;
import org.spacetrader.controller.enums.AlertType;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormOptions extends wfForm {
    private CheckBox chkFuel;
    private CheckBox chkContinuousAttack;
    private CheckBox chkAttackFleeing;
    private CheckBox chkDisable;
    private CheckBox chkNewspaper;
    private CheckBox chkNewspaperShow;
    private CheckBox chkRange;
    private CheckBox chkStopTracking;
    private CheckBox chkLoan;
    private CheckBox chkIgnoreTradersDealing;
    private CheckBox chkReserveMoney;
    private CheckBox chkIgnoreTraders;
    private CheckBox chkIgnorePirates;
    private CheckBox chkIgnorePolice;
    private CheckBox chkRepair;
    private NumericUpDown numEmpty;
    private boolean initializing = true;
    private GameOptions opts = new GameOptions(false);

    public FormOptions() {
        Button buttonOk = new Button();
        Button buttonCancel = new Button();
        Label lblEmpty = new Label();
        chkFuel = new CheckBox();
        chkContinuousAttack = new CheckBox();
        chkAttackFleeing = new CheckBox();
        chkNewspaper = new CheckBox();
        chkRange = new CheckBox();
        chkStopTracking = new CheckBox();
        chkLoan = new CheckBox();
        chkIgnoreTradersDealing = new CheckBox();
        chkReserveMoney = new CheckBox();
        chkIgnoreTraders = new CheckBox();
        chkIgnorePirates = new CheckBox();
        chkIgnorePolice = new CheckBox();
        chkRepair = new CheckBox();
        Label lblIgnore = new Label();
        numEmpty = new NumericUpDown();
        Button buttonSave = new Button();
        Button buttonLoad = new Button();
        chkNewspaperShow = new CheckBox();
        chkDisable = new CheckBox();
        ((ISupportInitialize) (numEmpty)).BeginInit();
        SuspendLayout();
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(14, 240));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new FormSize(40, 22));
        buttonOk.setTabIndex(15);
        buttonOk.setText("Ok");
        // buttonCancel
        buttonCancel.setDialogResult(DialogResult.Cancel);
        buttonCancel.setFlatStyle(FlatStyle.Flat);
        buttonCancel.setLocation(new Point(62, 240));
        buttonCancel.setName("buttonCancel");
        buttonCancel.setSize(new FormSize(49, 22));
        buttonCancel.setTabIndex(16);
        buttonCancel.setText("Cancel");
        // lblEmpty
        lblEmpty.setAutoSize(true);
        lblEmpty.setLocation(new Point(52, 90));
        lblEmpty.setName("lblEmpty");
        lblEmpty.setSize(new FormSize(292, 16));
        lblEmpty.setTabIndex(38);
        lblEmpty.setText("Cargo Bays to leave empty when buying goods in-system");
        // chkFuel
        chkFuel.setLocation(new Point(8, 8));
        chkFuel.setName("chkFuel");
        chkFuel.setSize(new FormSize(160, 16));
        chkFuel.setTabIndex(1);
        chkFuel.setText("Get full fuel tanks on arrival");
        chkFuel.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkContinuousAttack
        chkContinuousAttack.setLocation(new Point(8, 176));
        chkContinuousAttack.setName("chkContinuousAttack");
        chkContinuousAttack.setSize(new FormSize(163, 16));
        chkContinuousAttack.setTabIndex(13);
        chkContinuousAttack.setText("Continuous attack and flight");
        chkContinuousAttack.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkAttackFleeing
        chkAttackFleeing.setLocation(new Point(24, 192));
        chkAttackFleeing.setName("chkAttackFleeing");
        chkAttackFleeing.setSize(new FormSize(177, 16));
        chkAttackFleeing.setTabIndex(14);
        chkAttackFleeing.setText("Continue attacking fleeing ship");
        chkAttackFleeing.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkNewspaper
        chkNewspaper.setLocation(new Point(8, 40));
        chkNewspaper.setName("chkNewspaper");
        chkNewspaper.setSize(new FormSize(155, 16));
        chkNewspaper.setTabIndex(3);
        chkNewspaper.setText("Always pay for newspaper");
        chkNewspaper.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkRange
        chkRange.setLocation(new Point(184, 8));
        chkRange.setName("chkRange");
        chkRange.setSize(new FormSize(175, 16));
        chkRange.setTabIndex(5);
        chkRange.setText("Show range to tracked system");
        chkRange.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkStopTracking
        chkStopTracking.setLocation(new Point(184, 24));
        chkStopTracking.setName("chkStopTracking");
        chkStopTracking.setSize(new FormSize(139, 16));
        chkStopTracking.setTabIndex(6);
        chkStopTracking.setText("Stop tracking on arrival");
        chkStopTracking.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkLoan
        chkLoan.setLocation(new Point(184, 56));
        chkLoan.setName("chkLoan");
        chkLoan.setSize(new FormSize(124, 16));
        chkLoan.setTabIndex(4);
        chkLoan.setText("Remind about loans");
        chkLoan.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkIgnoreTradersDealing
        chkIgnoreTradersDealing.setLocation(new Point(152, 152));
        chkIgnoreTradersDealing.setName("chkIgnoreTradersDealing");
        chkIgnoreTradersDealing.setSize(new FormSize(133, 16));
        chkIgnoreTradersDealing.setTabIndex(12);
        chkIgnoreTradersDealing.setText("Ignore dealing traders");
        chkIgnoreTradersDealing.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkReserveMoney
        chkReserveMoney.setLocation(new Point(184, 40));
        chkReserveMoney.setName("chkReserveMoney");
        chkReserveMoney.setSize(new FormSize(176, 16));
        chkReserveMoney.setTabIndex(7);
        chkReserveMoney.setText("Reserve money for warp costs");
        chkReserveMoney.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkIgnoreTraders
        chkIgnoreTraders.setLocation(new Point(136, 136));
        chkIgnoreTraders.setName("chkIgnoreTraders");
        chkIgnoreTraders.setSize(new FormSize(62, 16));
        chkIgnoreTraders.setTabIndex(11);
        chkIgnoreTraders.setText("Traders");
        chkIgnoreTraders.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkIgnorePirates
        chkIgnorePirates.setLocation(new Point(8, 136));
        chkIgnorePirates.setName("chkIgnorePirates");
        chkIgnorePirates.setSize(new FormSize(58, 16));
        chkIgnorePirates.setTabIndex(9);
        chkIgnorePirates.setText("Pirates");
        chkIgnorePirates.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkIgnorePolice
        chkIgnorePolice.setLocation(new Point(74, 136));
        chkIgnorePolice.setName("chkIgnorePolice");
        chkIgnorePolice.setSize(new FormSize(54, 16));
        chkIgnorePolice.setTabIndex(10);
        chkIgnorePolice.setText("Police");
        chkIgnorePolice.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkRepair
        chkRepair.setLocation(new Point(8, 24));
        chkRepair.setName("chkRepair");
        chkRepair.setSize(new FormSize(167, 16));
        chkRepair.setTabIndex(2);
        chkRepair.setText("Get full hull repairs on arrival");
        chkRepair.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // lblIgnore
        lblIgnore.setAutoSize(true);
        lblIgnore.setLocation(new Point(8, 120));
        lblIgnore.setName("lblIgnore");
        lblIgnore.setSize(new FormSize(152, 16));
        lblIgnore.setTabIndex(52);
        lblIgnore.setText("Always ignore when it is safe:");
        // numEmpty
        numEmpty.setLocation(new Point(8, 88));
        numEmpty.setMaximum(99);
        numEmpty.setName("numEmpty");
        numEmpty.setSize(new FormSize(40, 20));
        numEmpty.setTabIndex(8);
        numEmpty.setValue(88);
        numEmpty.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // buttonSave
        buttonSave.setFlatStyle(FlatStyle.Flat);
        buttonSave.setLocation(new Point(119, 240));
        buttonSave.setName("buttonSave");
        buttonSave.setSize(new FormSize(107, 22));
        buttonSave.setTabIndex(17);
        buttonSave.setText("Save As Defaults");
        buttonSave.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonSave_Click();
            }
        });
        // buttonLoad
        buttonLoad.setFlatStyle(FlatStyle.Flat);
        buttonLoad.setLocation(new Point(234, 240));
        buttonLoad.setName("buttonLoad");
        buttonLoad.setSize(new FormSize(114, 22));
        buttonLoad.setTabIndex(18);
        buttonLoad.setText("Load from Defaults");
        buttonLoad.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                buttonLoad_Click();
            }
        });
        // chkNewspaperShow
        chkNewspaperShow.setLocation(new Point(24, 56));
        chkNewspaperShow.setName("chkNewspaperShow");
        chkNewspaperShow.setSize(new FormSize(160, 16));
        chkNewspaperShow.setTabIndex(53);
        chkNewspaperShow.setText("Show newspaper on arrival");
        chkNewspaperShow.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // chkDisable
        chkDisable.setLocation(new Point(8, 208));
        chkDisable.setName("chkDisable");
        chkDisable.setSize(new FormSize(244, 16));
        chkDisable.setTabIndex(54);
        chkDisable.setText("Attempt to disable opponents when possible");
        chkDisable.setCheckedChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                controlChanged();
            }
        });
        // FormOptions
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonCancel);
        setClientSize(new FormSize(362, 271));
        Controls.add(chkDisable);
        Controls.add(chkLoan);
        Controls.add(chkNewspaperShow);
        Controls.add(buttonLoad);
        Controls.add(buttonSave);
        Controls.add(numEmpty);
        Controls.add(lblIgnore);
        Controls.add(lblEmpty);
        Controls.add(chkRepair);
        Controls.add(chkIgnorePolice);
        Controls.add(chkIgnorePirates);
        Controls.add(chkIgnoreTraders);
        Controls.add(chkReserveMoney);
        Controls.add(chkIgnoreTradersDealing);
        Controls.add(chkStopTracking);
        Controls.add(chkRange);
        Controls.add(chkNewspaper);
        Controls.add(chkAttackFleeing);
        Controls.add(chkContinuousAttack);
        Controls.add(chkFuel);
        Controls.add(buttonCancel);
        Controls.add(buttonOk);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormOptions");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Options");
        ((ISupportInitialize) (numEmpty)).EndInit();
        ResumeLayout(false);
        Game game = Game.CurrentGame();
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
        chkFuel.setChecked(opts.getAutoFuel());
        chkRepair.setChecked(opts.getAutoRepair());
        chkNewspaper.setChecked(opts.getNewsAutoPay());
        chkNewspaperShow.setChecked(opts.getNewsAutoShow());
        chkLoan.setChecked(opts.getRemindLoans());
        chkRange.setChecked(opts.getShowTrackedRange());
        chkStopTracking.setChecked(opts.getTrackAutoOff());
        chkReserveMoney.setChecked(opts.getReserveMoney());
        numEmpty.setValue(opts.getLeaveEmpty());
        chkIgnorePirates.setChecked(opts.getAlwaysIgnorePirates());
        chkIgnorePolice.setChecked(opts.getAlwaysIgnorePolice());
        chkIgnoreTraders.setChecked(opts.getAlwaysIgnoreTraders());
        chkIgnoreTradersDealing.setChecked(opts.getAlwaysIgnoreTradeInOrbit());
        chkContinuousAttack.setChecked(opts.getContinuousAttack());
        chkAttackFleeing.setChecked(opts.getContinuousAttackFleeing());
        chkDisable.setChecked(opts.getDisableOpponents());
        UpdateContinueAttackFleeing();
        UpdateIgnoreTradersDealing();
        UpdateNewsAutoShow();
        initializing = false;
    }

    private void UpdateContinueAttackFleeing() {
        if (!chkContinuousAttack.isChecked()) {
            chkAttackFleeing.setChecked(false);
        }
        chkAttackFleeing.setEnabled(chkContinuousAttack.isChecked());
    }

    private void UpdateIgnoreTradersDealing() {
        if (!chkIgnoreTraders.isChecked()) {
            chkIgnoreTradersDealing.setChecked(false);
        }
        chkIgnoreTradersDealing.setEnabled(chkIgnoreTraders.isChecked());
    }

    private void UpdateNewsAutoShow() {
        if (!chkNewspaper.isChecked()) {
            chkNewspaperShow.setChecked(false);
        }
        chkNewspaperShow.setEnabled(chkNewspaper.isChecked());
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
            opts.setAutoFuel(chkFuel.isChecked());
            opts.setAutoRepair(chkRepair.isChecked());
            opts.setNewsAutoPay(chkNewspaper.isChecked());
            opts.setNewsAutoShow(chkNewspaperShow.isChecked());
            opts.setRemindLoans(chkLoan.isChecked());
            opts.setShowTrackedRange(chkRange.isChecked());
            opts.setTrackAutoOff(chkStopTracking.isChecked());
            opts.setReserveMoney(chkReserveMoney.isChecked());
            opts.setLeaveEmpty(numEmpty.getValue());
            opts.setAlwaysIgnorePirates(chkIgnorePirates.isChecked());
            opts.setAlwaysIgnorePolice(chkIgnorePolice.isChecked());
            opts.setAlwaysIgnoreTraders(chkIgnoreTraders.isChecked());
            opts.setAlwaysIgnoreTradeInOrbit(chkIgnoreTradersDealing.isChecked());
            opts.setContinuousAttack(chkContinuousAttack.isChecked());
            opts.setContinuousAttackFleeing(chkAttackFleeing.isChecked());
            opts.setDisableOpponents(chkDisable.isChecked());
        }
    }

    public GameOptions Options() {
        return opts;
    }
}
