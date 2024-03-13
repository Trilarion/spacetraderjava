package org.spacetrader.ui;

import org.spacetrader.model.enums.Difficulty;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormNewCommander extends wfForm {
    private final Button buttonOk;
    private final ComboBox selDifficulty;
    private final Label labelPoints;
    private final NumericUpDown numFighter;
    private final NumericUpDown numTrader;
    private final NumericUpDown numEngineer;
    private final NumericUpDown numPilot;
    private final TextBox txtName;

    public FormNewCommander() {
        Label labelName = new Label();
        txtName = new TextBox();
        Button buttonClose = new Button();
        Label labelDifficulty = new Label();
        Label labelSkillPoints = new Label();
        Label labelPilot = new Label();
        Label labelFighter = new Label();
        Label labelTrader = new Label();
        Label labelEngineer = new Label();
        selDifficulty = new ComboBox();
        numPilot = new NumericUpDown();
        numFighter = new NumericUpDown();
        numTrader = new NumericUpDown();
        numEngineer = new NumericUpDown();
        buttonOk = new Button();
        Label labelPointsRemaining = new Label();
        labelPoints = new Label();
                                        SuspendLayout();
        // labelName
        labelName.setAutoSize(true);
        labelName.setLocation(new Point(8, 8));
        labelName.setName("labelName");
        labelName.setSize(new SizeF(13, 38));
        labelName.setTabIndex(0);
        labelName.setText("Name:");
        // txtName
        txtName.setLocation(new Point(72, 5));
        txtName.setName("txtName");
        txtName.setSize(new SizeF(20, 120));
        txtName.setTabIndex(1);
        txtName.setText("");
        txtName.setTextChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                txtName_TextChanged(sender, data);
            }
        });
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new SizeF(31, 30));
        buttonClose.setTabIndex(33);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelDifficulty
        labelDifficulty.setAutoSize(true);
        labelDifficulty.setLocation(new Point(8, 40));
        labelDifficulty.setName("labelDifficulty");
        labelDifficulty.setSize(new SizeF(13, 50));
        labelDifficulty.setTabIndex(34);
        labelDifficulty.setText("Difficulty:");
        // labelSkillPoints
        labelSkillPoints.setAutoSize(true);
        labelSkillPoints.setLocation(new Point(8, 72));
        labelSkillPoints.setName("labelSkillPoints");
        labelSkillPoints.setSize(new SizeF(13, 63));
        labelSkillPoints.setTabIndex(35);
        labelSkillPoints.setText("Skill Points:");
        // labelPilot
        labelPilot.setAutoSize(true);
        labelPilot.setLocation(new Point(16, 96));
        labelPilot.setName("labelPilot");
        labelPilot.setSize(new SizeF(13, 29));
        labelPilot.setTabIndex(36);
        labelPilot.setText("Pilot:");
        // labelFighter
        labelFighter.setAutoSize(true);
        labelFighter.setLocation(new Point(16, 120));
        labelFighter.setName("labelFighter");
        labelFighter.setSize(new SizeF(13, 43));
        labelFighter.setTabIndex(37);
        labelFighter.setText("Fighter:");
        // labelTrader
        labelTrader.setAutoSize(true);
        labelTrader.setLocation(new Point(16, 144));
        labelTrader.setName("labelTrader");
        labelTrader.setSize(new SizeF(13, 41));
        labelTrader.setTabIndex(38);
        labelTrader.setText("Trader:");
        // labelEngineer
        labelEngineer.setAutoSize(true);
        labelEngineer.setLocation(new Point(16, 168));
        labelEngineer.setName("labelEngineer");
        labelEngineer.setSize(new SizeF(13, 53));
        labelEngineer.setTabIndex(39);
        labelEngineer.setText("Engineer:");
        // selDifficulty
        selDifficulty.DropDownStyle = ComboBoxStyle.DropDownList;
        for (Object obj : new Object[]{"Beginner", "Easy", "Normal", "Hard", "Impossible"}) {  // TODO get these from the enum Difficulty
            selDifficulty.Items.addElement(obj);
        }
        selDifficulty.setLocation(new Point(72, 37));
        selDifficulty.setName("selDifficulty");
        selDifficulty.setSize(new SizeF(21, 120));
        selDifficulty.setTabIndex(2);
        // numPilot
        numPilot.setLocation(new Point(72, 94));
        numPilot.setMaximum(10);
        numPilot.setMinimum(1);
        numPilot.setName("numPilot");
        numPilot.setSize(new SizeF(20, 36));
        numPilot.setTabIndex(3);
        numPilot.TextAlign = HorizontalAlignment.Center;
        numPilot.setValue(1);
        numPilot.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numPilot.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        numPilot.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numFighter
        numFighter.setLocation(new Point(72, 118));
        numFighter.setMaximum(10);
        numFighter.setMinimum(1);
        numFighter.setName("numFighter");
        numFighter.setSize(new SizeF(20, 36));
        numFighter.setTabIndex(4);
        numFighter.TextAlign = HorizontalAlignment.Center;
        numFighter.setValue(1);
        numFighter.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numFighter.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        numFighter.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numTrader
        numTrader.setLocation(new Point(72, 142));
        numTrader.setMaximum(10);
        numTrader.setMinimum(1);
        numTrader.setName("numTrader");
        numTrader.setSize(new SizeF(20, 36));
        numTrader.setTabIndex(5);
        numTrader.TextAlign = HorizontalAlignment.Center;
        numTrader.setValue(1);
        numTrader.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numTrader.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        numTrader.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // numEngineer
        numEngineer.setLocation(new Point(72, 166));
        numEngineer.setMaximum(10);
        numEngineer.setMinimum(1);
        numEngineer.setName("numEngineer");
        numEngineer.setSize(new SizeF(20, 36));
        numEngineer.setTabIndex(6);
        numEngineer.TextAlign = HorizontalAlignment.Center;
        numEngineer.setValue(1);
        numEngineer.setEnter(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueEnter(sender, data);
            }
        });
        numEngineer.setValueChanged(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        numEngineer.setLeave(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                num_ValueChanged(sender, data);
            }
        });
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setEnabled(false);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(83, 200));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new SizeF(22, 36));
        buttonOk.setTabIndex(7);
        buttonOk.setText("Ok");
        buttonOk.setEnabled(false);
        // labelPointsRemaining
        labelPointsRemaining.setAutoSize(true);
        labelPointsRemaining.setLocation(new Point(91, 72));
        labelPointsRemaining.setName("labelPointsRemaining");
        labelPointsRemaining.setSize(new SizeF(13, 90));
        labelPointsRemaining.setTabIndex(40);
        labelPointsRemaining.setText("points remaining.");
        // labelPoints
        labelPoints.setLocation(new Point(73, 72));
        labelPoints.setName("labelPoints");
        labelPoints.setSize(new SizeF(13, 17));
        labelPoints.setTabIndex(41);
        labelPoints.setText("16");
        labelPoints.TextAlign = ContentAlignment.TopRight;
        // FormNewCommander
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonClose);
        setClientSize(new SizeF(231, 202));
        Controls.addAll(Arrays.asList(
                labelPoints, labelPointsRemaining, labelEngineer, labelTrader, labelFighter, labelPilot, labelSkillPoints, labelDifficulty,
                labelName, buttonOk, numEngineer, numTrader, numFighter, numPilot, selDifficulty, buttonClose, txtName));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormNewCommander");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("New Commander");
                                        ResumeLayout(false);
        selDifficulty.setSelectedIndex(2);
    }


    private void UpdateOkEnabled() {
        buttonOk.setEnabled(labelPoints.getText().equals("0") && !txtName.getText().isEmpty());
    }

    private void num_ValueChanged(Object sender, EventData e) {
        int points = 20 - (Pilot() + Fighter() + Trader() + Engineer());
        labelPoints.setText("" + points);
        numPilot.setMaximum(Math.min(10, Pilot() + points));
        numFighter.setMaximum(Math.min(10, Fighter() + points));
        numTrader.setMaximum(Math.min(10, Trader() + points));
        numEngineer.setMaximum(Math.min(10, Engineer() + points));
        UpdateOkEnabled();
    }

    private void num_ValueEnter(Object sender, EventData e) {
        ((NumericUpDown) sender).Select(0, ("" + ((NumericUpDown) sender).getValue()).length());
    }

    private void txtName_TextChanged(Object sender, EventData e) {
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
