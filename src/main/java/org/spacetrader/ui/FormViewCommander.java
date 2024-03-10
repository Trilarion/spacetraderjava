package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;
import java.util.Arrays;


public class FormViewCommander extends wfForm {

    public FormViewCommander() {
        Label labelNameLabel = new Label();
        Label labelName = new Label();
        Label labelDifficulty = new Label();
        Button buttonClose = new Button();
        Label labelTimeLabel = new Label();
        Label labelCashLabel = new Label();
        Label labelDebtLabel = new Label();
        Label labelNetWorthLabel = new Label();
        Label labelDifficultyLabel = new Label();
        Label labelTime = new Label();
        GroupBox boxSkills = new GroupBox();
        Label labelEngineer = new Label();
        Label labelTrader = new Label();
        Label labelFighter = new Label();
        Label labelPilot = new Label();
        Label labelEngineerLabel = new Label();
        Label labelTraderLabel = new Label();
        Label labelFighterLabel = new Label();
        Label labelPilotLabel = new Label();
        GroupBox boxFinances = new GroupBox();
        Label labelCash = new Label();
        Label labelDebt = new Label();
        Label labelNetWorth = new Label();
        GroupBox boxNotoriety = new GroupBox();
        Label labelPoliceLabel = new Label();
        Label labelReputationLabel = new Label();
        Label labelKillsLabel = new Label();
        Label labelKills = new Label();
        Label labelReputation = new Label();
        Label labelRecord = new Label();
        Label labelBountyLabel = new Label();
        Label labelBounty = new Label();
        boxSkills.SuspendLayout();
        boxFinances.SuspendLayout();
        boxNotoriety.SuspendLayout();
        SuspendLayout();
        // labelNameLabel
        labelNameLabel.setAutoSize(true);
        labelNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelNameLabel.setLocation(new Point(8, 8));
        labelNameLabel.setName("labelNameLabel");
        labelNameLabel.setSize(new FormSize(39, 16));
        labelNameLabel.setTabIndex(2);
        labelNameLabel.setText("Name:");
        // labelName
        labelName.setLocation(new Point(69, 8));
        labelName.setName("labelName");
        labelName.setSize(new FormSize(155, 13));
        labelName.setTabIndex(4);
        labelName.setText("XXXXXXXXXXXXXXXXXX");
        // labelDifficulty
        labelDifficulty.setLocation(new Point(69, 24));
        labelDifficulty.setName("labelDifficulty");
        labelDifficulty.setSize(new FormSize(58, 13));
        labelDifficulty.setTabIndex(5);
        labelDifficulty.setText("Impossible");
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new FormSize(26, 27));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelTimeLabel
        labelTimeLabel.setAutoSize(true);
        labelTimeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTimeLabel.setLocation(new Point(8, 40));
        labelTimeLabel.setName("labelTimeLabel");
        labelTimeLabel.setSize(new FormSize(34, 16));
        labelTimeLabel.setTabIndex(37);
        labelTimeLabel.setText("Time:");
        // labelCashLabel
        labelCashLabel.setAutoSize(true);
        labelCashLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelCashLabel.setLocation(new Point(8, 16));
        labelCashLabel.setName("labelCashLabel");
        labelCashLabel.setSize(new FormSize(35, 16));
        labelCashLabel.setTabIndex(38);
        labelCashLabel.setText("Cash:");
        // labelDebtLabel
        labelDebtLabel.setAutoSize(true);
        labelDebtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelDebtLabel.setLocation(new Point(8, 32));
        labelDebtLabel.setName("labelDebtLabel");
        labelDebtLabel.setSize(new FormSize(32, 16));
        labelDebtLabel.setTabIndex(39);
        labelDebtLabel.setText("Debt:");
        // labelNetWorthLabel
        labelNetWorthLabel.setAutoSize(true);
        labelNetWorthLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelNetWorthLabel.setLocation(new Point(8, 48));
        labelNetWorthLabel.setName("labelNetWorthLabel");
        labelNetWorthLabel.setSize(new FormSize(60, 16));
        labelNetWorthLabel.setTabIndex(40);
        labelNetWorthLabel.setText("Net Worth:");
        // labelDifficultyLabel
        labelDifficultyLabel.setAutoSize(true);
        labelDifficultyLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelDifficultyLabel.setLocation(new Point(8, 24));
        labelDifficultyLabel.setName("labelDifficultyLabel");
        labelDifficultyLabel.setSize(new FormSize(53, 16));
        labelDifficultyLabel.setTabIndex(43);
        labelDifficultyLabel.setText("Difficulty:");
        // labelTime
        labelTime.setLocation(new Point(69, 40));
        labelTime.setName("labelTime");
        labelTime.setSize(new FormSize(66, 13));
        labelTime.setTabIndex(44);
        labelTime.setText("88,888 days");
        // boxSkills
        boxSkills.Controls.addAll(labelEngineer, labelTrader, labelFighter, labelPilot, labelEngineerLabel, labelTraderLabel, labelFighterLabel, labelPilotLabel);
        boxSkills.setLocation(new Point(8, 64));
        boxSkills.setName("boxSkills");
        boxSkills.setSize(new FormSize(216, 56));
        boxSkills.setTabIndex(49);
        boxSkills.setTabStop(false);
        boxSkills.setText("Skills");
        // labelEngineer
        labelEngineer.setLocation(new Point(167, 32));
        labelEngineer.setName("labelEngineer");
        labelEngineer.setSize(new FormSize(40, 13));
        labelEngineer.setTabIndex(56);
        labelEngineer.setText("88 (88)");
        // labelTrader
        labelTrader.setLocation(new Point(58, 32));
        labelTrader.setName("labelTrader");
        labelTrader.setSize(new FormSize(40, 13));
        labelTrader.setTabIndex(55);
        labelTrader.setText("88 (88)");
        // labelFighter
        labelFighter.setLocation(new Point(167, 16));
        labelFighter.setName("labelFighter");
        labelFighter.setSize(new FormSize(40, 13));
        labelFighter.setTabIndex(54);
        labelFighter.setText("88 (88)");
        // labelPilot
        labelPilot.setLocation(new Point(58, 16));
        labelPilot.setName("labelPilot");
        labelPilot.setSize(new FormSize(40, 13));
        labelPilot.setTabIndex(53);
        labelPilot.setText("88 (88)");
        // labelEngineerLabel
        labelEngineerLabel.setAutoSize(true);
        labelEngineerLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelEngineerLabel.setLocation(new Point(104, 32));
        labelEngineerLabel.setName("labelEngineerLabel");
        labelEngineerLabel.setSize(new FormSize(55, 16));
        labelEngineerLabel.setTabIndex(52);
        labelEngineerLabel.setText("Engineer:");
        // labelTraderLabel
        labelTraderLabel.setAutoSize(true);
        labelTraderLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTraderLabel.setLocation(new Point(8, 32));
        labelTraderLabel.setName("labelTraderLabel");
        labelTraderLabel.setSize(new FormSize(42, 16));
        labelTraderLabel.setTabIndex(51);
        labelTraderLabel.setText("Trader:");
        // labelFighterLabel
        labelFighterLabel.setAutoSize(true);
        labelFighterLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelFighterLabel.setLocation(new Point(104, 16));
        labelFighterLabel.setName("labelFighterLabel");
        labelFighterLabel.setSize(new FormSize(44, 16));
        labelFighterLabel.setTabIndex(50);
        labelFighterLabel.setText("Fighter:");
        // labelPilotLabel
        labelPilotLabel.setAutoSize(true);
        labelPilotLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelPilotLabel.setLocation(new Point(8, 16));
        labelPilotLabel.setName("labelPilotLabel");
        labelPilotLabel.setSize(new FormSize(31, 16));
        labelPilotLabel.setTabIndex(49);
        labelPilotLabel.setText("Pilot:");
        // boxFinances
        boxFinances.Controls.addAll(labelCash, labelDebt, labelNetWorth, labelNetWorthLabel, labelCashLabel, labelDebtLabel);
        boxFinances.setLocation(new Point(8, 128));
        boxFinances.setName("boxFinances");
        boxFinances.setSize(new FormSize(216, 72));
        boxFinances.setTabIndex(50);
        boxFinances.setTabStop(false);
        boxFinances.setText("Finances");
        // labelCash
        labelCash.setLocation(new Point(104, 16));
        labelCash.setName("labelCash");
        labelCash.setSize(new FormSize(70, 13));
        labelCash.setTabIndex(43);
        labelCash.setText("8,888,888 cr.");
        labelCash.TextAlign = ContentAlignment.TopRight;
        // labelDebt
        labelDebt.setLocation(new Point(104, 32));
        labelDebt.setName("labelDebt");
        labelDebt.setSize(new FormSize(70, 13));
        labelDebt.setTabIndex(42);
        labelDebt.setText("8,888,888 cr.");
        labelDebt.TextAlign = ContentAlignment.TopRight;
        // labelNetWorth
        labelNetWorth.setLocation(new Point(104, 48));
        labelNetWorth.setName("labelNetWorth");
        labelNetWorth.setSize(new FormSize(70, 13));
        labelNetWorth.setTabIndex(41);
        labelNetWorth.setText("8,888,888 cr.");
        labelNetWorth.TextAlign = ContentAlignment.TopRight;
        // boxNotoriety
        boxNotoriety.Controls.addAll(labelBountyLabel, labelBounty, labelPoliceLabel, labelReputationLabel, labelKillsLabel, labelKills, labelReputation, labelRecord);
        boxNotoriety.setLocation(new Point(8, 208));
        boxNotoriety.setName("boxNotoriety");
        boxNotoriety.setSize(new FormSize(216, 88));
        boxNotoriety.setTabIndex(51);
        boxNotoriety.setTabStop(false);
        boxNotoriety.setText("Notoriety");
        // labelPoliceLabel
        labelPoliceLabel.setAutoSize(true);
        labelPoliceLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelPoliceLabel.setLocation(new Point(8, 48));
        labelPoliceLabel.setName("labelPoliceLabel");
        labelPoliceLabel.setSize(new FormSize(81, 16));
        labelPoliceLabel.setTabIndex(46);
        labelPoliceLabel.setText("Police Record:");
        // labelReputationLabel
        labelReputationLabel.setAutoSize(true);
        labelReputationLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelReputationLabel.setLocation(new Point(8, 32));
        labelReputationLabel.setName("labelReputationLabel");
        labelReputationLabel.setSize(new FormSize(65, 16));
        labelReputationLabel.setTabIndex(45);
        labelReputationLabel.setText("Reputation:");
        // labelKillsLabel
        labelKillsLabel.setAutoSize(true);
        labelKillsLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelKillsLabel.setLocation(new Point(8, 16));
        labelKillsLabel.setName("labelKillsLabel");
        labelKillsLabel.setSize(new FormSize(30, 16));
        labelKillsLabel.setTabIndex(44);
        labelKillsLabel.setText("Kills:");
        // labelKills
        labelKills.setLocation(new Point(104, 16));
        labelKills.setName("labelKills");
        labelKills.setSize(new FormSize(33, 13));
        labelKills.setTabIndex(43);
        labelKills.setText("8,888");
        // labelReputation
        labelReputation.setLocation(new Point(104, 32));
        labelReputation.setName("labelReputation");
        labelReputation.setSize(new FormSize(88, 13));
        labelReputation.setTabIndex(42);
        labelReputation.setText("Mostly Harmless");
        // labelRecord
        labelRecord.setLocation(new Point(104, 48));
        labelRecord.setName("labelRecord");
        labelRecord.setSize(new FormSize(63, 13));
        labelRecord.setTabIndex(41);
        labelRecord.setText("Psychopath");
        // labelBountyLabel
        labelBountyLabel.setAutoSize(true);
        labelBountyLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelBountyLabel.setLocation(new Point(8, 64));
        labelBountyLabel.setName("labelBountyLabel");
        labelBountyLabel.setSize(new FormSize(84, 16));
        labelBountyLabel.setTabIndex(48);
        labelBountyLabel.setText("Bounty offered:");
        labelBountyLabel.setVisible(false);
        // labelBounty
        labelBounty.setLocation(new Point(104, 64));
        labelBounty.setName("labelBounty");
        labelBounty.setSize(new FormSize(72, 13));
        labelBounty.setTabIndex(47);
        labelBounty.setText("8,888,888 cr.");
        labelBounty.setVisible(false);
        // FormViewCommander
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(232, 304));
        Controls.addAll(Arrays.asList(boxNotoriety, boxFinances, boxSkills, labelTime,
                labelDifficultyLabel, labelTimeLabel, labelNameLabel, buttonClose, labelDifficulty,
                labelName));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormViewCommander");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Commander Status");
        boxSkills.ResumeLayout(false);
        boxFinances.ResumeLayout(false);
        boxNotoriety.ResumeLayout(false);
        ResumeLayout(false);
        Game game = Game.getCurrentGame();
        Commander commander = game.Commander();
        labelName.setText(commander.Name());
        labelDifficulty.setText(Strings.DifficultyLevels[game.Difficulty().CastToInt()]);
        labelTime.setText(Functions.Multiples(commander.getDays(), Strings.TimeUnit));
        labelPilot.setText(commander.Pilot() + " (" + commander.getShip().Pilot() + ")");
        labelFighter.setText(commander.Fighter() + " (" + commander.getShip().Fighter() + ")");
        labelTrader.setText(commander.Trader() + " (" + commander.getShip().Trader() + ")");
        labelEngineer.setText(commander.Engineer() + " (" + commander.getShip().Engineer() + ")");
        labelCash.setText(Functions.FormatMoney(commander.getCash()));
        labelDebt.setText(Functions.FormatMoney(commander.getDebt()));
        labelNetWorth.setText(Functions.FormatMoney(commander.Worth()));
        labelKills.setText(Functions.FormatNumber(commander.getKillsPirate() + commander.getKillsPolice() + commander.getKillsTrader()));
        labelRecord.setText(PoliceRecord.GetPoliceRecordFromScore(commander.getPoliceRecordScore()).Name());
        labelReputation.setText(Reputation.GetReputationFromScore(commander.getReputationScore()).Name());
        int score = commander.getPoliceRecordScore();
        if (score <= Constants.PoliceRecordScoreCrook) {
            labelBountyLabel.setVisible(true);
            labelBountyLabel.setText("Bounty offered:");
            labelBounty.setVisible(true);
            labelBounty.setText(Functions.FormatMoney(-1000 * score));
        } else if (score >= Constants.PoliceRecordScoreTrusted) {
            labelBountyLabel.setVisible(true);
            labelBountyLabel.setText("Angry kingpins:");
            labelBounty.setVisible(true);
            labelBounty.setText(Functions.FormatNumber(score / 5));
        } else {
            labelBountyLabel.setVisible(false);
            labelBounty.setVisible(false);
        }
    }

}
