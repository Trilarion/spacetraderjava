package org.spacetrader.ui;

import org.spacetrader.model.Difficulty;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormNewCommander extends wfForm {
    private Button buttonOk;
    private ComboBox selDifficulty;
    private Label lblPoints;
    private NumericUpDown numFighter;
    private NumericUpDown numTrader;
    private NumericUpDown numEngineer;
    private NumericUpDown numPilot;
    private TextBox txtName;

    public FormNewCommander() {
        Label lblName = new Label();
        txtName = new TextBox();
        Button buttonClose = new Button();
        Label lblDifficulty = new Label();
        Label lblSkillPoints = new Label();
        Label lblPilot = new Label();
        Label lblFighter = new Label();
        Label lblTrader = new Label();
        Label lblEngineer = new Label();
        selDifficulty = new ComboBox();
        numPilot = new NumericUpDown();
        numFighter = new NumericUpDown();
        numTrader = new NumericUpDown();
        numEngineer = new NumericUpDown();
        buttonOk = new Button();
        Label lblPointsRemaining = new Label();
        lblPoints = new Label();
        ((ISupportInitialize) (numPilot)).BeginInit();
        ((ISupportInitialize) (numFighter)).BeginInit();
        ((ISupportInitialize) (numTrader)).BeginInit();
        ((ISupportInitialize) (numEngineer)).BeginInit();
        SuspendLayout();
        // lblName
        lblName.setAutoSize(true);
        lblName.setLocation(new Point(8, 8));
        lblName.setName("lblName");
        lblName.setSize(new FormSize(38, 13));
        lblName.setTabIndex(0);
        lblName.setText("Name:");
        // txtName
        txtName.setLocation(new Point(72, 5));
        txtName.setName("txtName");
        txtName.setSize(new FormSize(120, 20));
        txtName.setTabIndex(1);
        txtName.setText("");
        txtName.setTextChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                txtName_TextChanged(sender, e);
            }
        });
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new FormSize(30, 31));
        buttonClose.setTabIndex(33);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // lblDifficulty
        lblDifficulty.setAutoSize(true);
        lblDifficulty.setLocation(new Point(8, 40));
        lblDifficulty.setName("lblDifficulty");
        lblDifficulty.setSize(new FormSize(50, 13));
        lblDifficulty.setTabIndex(34);
        lblDifficulty.setText("Difficulty:");
        // lblSkillPoints
        lblSkillPoints.setAutoSize(true);
        lblSkillPoints.setLocation(new Point(8, 72));
        lblSkillPoints.setName("lblSkillPoints");
        lblSkillPoints.setSize(new FormSize(63, 13));
        lblSkillPoints.setTabIndex(35);
        lblSkillPoints.setText("Skill Points:");
        // lblPilot
        lblPilot.setAutoSize(true);
        lblPilot.setLocation(new Point(16, 96));
        lblPilot.setName("lblPilot");
        lblPilot.setSize(new FormSize(29, 13));
        lblPilot.setTabIndex(36);
        lblPilot.setText("Pilot:");
        // lblFighter
        lblFighter.setAutoSize(true);
        lblFighter.setLocation(new Point(16, 120));
        lblFighter.setName("lblFighter");
        lblFighter.setSize(new FormSize(43, 13));
        lblFighter.setTabIndex(37);
        lblFighter.setText("Fighter:");
        // lblTrader
        lblTrader.setAutoSize(true);
        lblTrader.setLocation(new Point(16, 144));
        lblTrader.setName("lblTrader");
        lblTrader.setSize(new FormSize(41, 13));
        lblTrader.setTabIndex(38);
        lblTrader.setText("Trader:");
        // lblEngineer
        lblEngineer.setAutoSize(true);
        lblEngineer.setLocation(new Point(16, 168));
        lblEngineer.setName("lblEngineer");
        lblEngineer.setSize(new FormSize(53, 13));
        lblEngineer.setTabIndex(39);
        lblEngineer.setText("Engineer:");
        // selDifficulty
        selDifficulty.DropDownStyle = ComboBoxStyle.DropDownList;
        selDifficulty.Items.AddRange("Beginner", "Easy", "Normal", "Hard", "Impossible");
        selDifficulty.setLocation(new Point(72, 37));
        selDifficulty.setName("selDifficulty");
        selDifficulty.setSize(new FormSize(120, 21));
        selDifficulty.setTabIndex(2);
        // numPilot
        numPilot.setLocation(new Point(72, 94));
        numPilot.setMaximum(10);
        numPilot.setMinimum(1);
        numPilot.setName("numPilot");
        numPilot.setSize(new FormSize(36, 20));
        numPilot.setTabIndex(3);
        numPilot.TextAlign = HorizontalAlignment.Center;
        numPilot.setValue(1);
        numPilot.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueEnter(sender, e);
            }
        });
        numPilot.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        numPilot.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        // numFighter
        numFighter.setLocation(new Point(72, 118));
        numFighter.setMaximum(10);
        numFighter.setMinimum(1);
        numFighter.setName("numFighter");
        numFighter.setSize(new FormSize(36, 20));
        numFighter.setTabIndex(4);
        numFighter.TextAlign = HorizontalAlignment.Center;
        numFighter.setValue(1);
        numFighter.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueEnter(sender, e);
            }
        });
        numFighter.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        numFighter.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        // numTrader
        numTrader.setLocation(new Point(72, 142));
        numTrader.setMaximum(10);
        numTrader.setMinimum(1);
        numTrader.setName("numTrader");
        numTrader.setSize(new FormSize(36, 20));
        numTrader.setTabIndex(5);
        numTrader.TextAlign = HorizontalAlignment.Center;
        numTrader.setValue(1);
        numTrader.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueEnter(sender, e);
            }
        });
        numTrader.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        numTrader.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        // numEngineer
        numEngineer.setLocation(new Point(72, 166));
        numEngineer.setMaximum(10);
        numEngineer.setMinimum(1);
        numEngineer.setName("numEngineer");
        numEngineer.setSize(new FormSize(36, 20));
        numEngineer.setTabIndex(6);
        numEngineer.TextAlign = HorizontalAlignment.Center;
        numEngineer.setValue(1);
        numEngineer.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueEnter(sender, e);
            }
        });
        numEngineer.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        numEngineer.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                num_ValueChanged(sender, e);
            }
        });
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setEnabled(false);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(83, 200));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new FormSize(36, 22));
        buttonOk.setTabIndex(7);
        buttonOk.setText("Ok");
        buttonOk.setEnabled(false);
        // lblPointsRemaining
        lblPointsRemaining.setAutoSize(true);
        lblPointsRemaining.setLocation(new Point(91, 72));
        lblPointsRemaining.setName("lblPointsRemaining");
        lblPointsRemaining.setSize(new FormSize(90, 13));
        lblPointsRemaining.setTabIndex(40);
        lblPointsRemaining.setText("points remaining.");
        // lblPoints
        lblPoints.setLocation(new Point(73, 72));
        lblPoints.setName("lblPoints");
        lblPoints.setSize(new FormSize(17, 13));
        lblPoints.setTabIndex(41);
        lblPoints.setText("16");
        lblPoints.TextAlign = ContentAlignment.TopRight;
        // FormNewCommander
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(202, 231));
        Controls.addAll(Arrays.asList(
                lblPoints, lblPointsRemaining, lblEngineer, lblTrader, lblFighter, lblPilot, lblSkillPoints, lblDifficulty,
                lblName, buttonOk, numEngineer, numTrader, numFighter, numPilot, selDifficulty, buttonClose, txtName));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormNewCommander");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("New Commander");
        ((ISupportInitialize) (numPilot)).EndInit();
        ((ISupportInitialize) (numFighter)).EndInit();
        ((ISupportInitialize) (numTrader)).EndInit();
        ((ISupportInitialize) (numEngineer)).EndInit();
        ResumeLayout(false);
        selDifficulty.setSelectedIndex(2);
    }


    private void UpdateOkEnabled() {
        buttonOk.setEnabled(lblPoints.getText().equals("0") && !txtName.getText().isEmpty());
    }

    private void num_ValueChanged(Object sender, EventArgs e) {
        int points = 20 - (Pilot() + Fighter() + Trader() + Engineer());
        lblPoints.setText("" + points);
        numPilot.setMaximum(Math.min(10, Pilot() + points));
        numFighter.setMaximum(Math.min(10, Fighter() + points));
        numTrader.setMaximum(Math.min(10, Trader() + points));
        numEngineer.setMaximum(Math.min(10, Engineer() + points));
        UpdateOkEnabled();
    }

    private void num_ValueEnter(Object sender, EventArgs e) {
        ((NumericUpDown) sender).Select(0, ("" + ((NumericUpDown) sender).getValue()).length());
    }

    private void txtName_TextChanged(Object sender, EventArgs e) {
        UpdateOkEnabled();
    }

    public String CommanderName() {
        return txtName.getText();
    }

    public Difficulty Difficulty() {
        return Difficulty.FromInt(selDifficulty.getSelectedIndex());
    }

    public int Pilot() {
        return numPilot.getValue();
    }

    public int Fighter() {
        return numFighter.getValue();
    }

    public int Trader() {
        return numTrader.getValue();
    }

    public int Engineer() {
        return numEngineer.getValue();
    }
}
