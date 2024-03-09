package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Font;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.*;
import org.spacetrader.main.*;

import java.awt.*;
import java.util.Arrays;


public class FormViewCommander extends WinformForm {
    private final Game game = Game.CurrentGame();

    public FormViewCommander() {
        Label lblNameLabel = new Label();
        Label lblName = new Label();
        Label lblDifficulty = new Label();
        Button btnClose = new Button();
        Label lblTimeLabel = new Label();
        Label lblCashLabel = new Label();
        Label lblDebtLabel = new Label();
        Label lblNetWorthLabel = new Label();
        Label lblDifficultyLabel = new Label();
        Label lblTime = new Label();
        GroupBox boxSkills = new GroupBox();
        Label lblEngineer = new Label();
        Label lblTrader = new Label();
        Label lblFighter = new Label();
        Label lblPilot = new Label();
        Label lblEngineerLabel = new Label();
        Label lblTraderLabel = new Label();
        Label lblFighterLabel = new Label();
        Label lblPilotLabel = new Label();
        GroupBox boxFinances = new GroupBox();
        Label lblCash = new Label();
        Label lblDebt = new Label();
        Label lblNetWorth = new Label();
        GroupBox boxNotoriety = new GroupBox();
        Label lblPoliceLabel = new Label();
        Label lblReputationLabel = new Label();
        Label lblKillsLabel = new Label();
        Label lblKills = new Label();
        Label lblReputation = new Label();
        Label lblRecord = new Label();
        Label lblBountyLabel = new Label();
        Label lblBounty = new Label();
        boxSkills.SuspendLayout();
        boxFinances.SuspendLayout();
        boxNotoriety.SuspendLayout();
        SuspendLayout();
        // lblNameLabel
        lblNameLabel.setAutoSize(true);
        lblNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblNameLabel.setLocation(new Point(8, 8));
        lblNameLabel.setName("lblNameLabel");
        lblNameLabel.setSize(new FormSize(39, 16));
        lblNameLabel.setTabIndex(2);
        lblNameLabel.setText("Name:");
        // lblName
        lblName.setLocation(new Point(69, 8));
        lblName.setName("lblName");
        lblName.setSize(new FormSize(155, 13));
        lblName.setTabIndex(4);
        lblName.setText("XXXXXXXXXXXXXXXXXX");
        // lblDifficulty
        lblDifficulty.setLocation(new Point(69, 24));
        lblDifficulty.setName("lblDifficulty");
        lblDifficulty.setSize(new FormSize(58, 13));
        lblDifficulty.setTabIndex(5);
        lblDifficulty.setText("Impossible");
        // btnClose
        btnClose.setDialogResult(DialogResult.Cancel);
        btnClose.setLocation(new Point(-32, -32));
        btnClose.setName("btnClose");
        btnClose.setSize(new FormSize(26, 27));
        btnClose.setTabIndex(32);
        btnClose.setTabStop(false);
        btnClose.setText("X");
        // lblTimeLabel
        lblTimeLabel.setAutoSize(true);
        lblTimeLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTimeLabel.setLocation(new Point(8, 40));
        lblTimeLabel.setName("lblTimeLabel");
        lblTimeLabel.setSize(new FormSize(34, 16));
        lblTimeLabel.setTabIndex(37);
        lblTimeLabel.setText("Time:");
        // lblCashLabel
        lblCashLabel.setAutoSize(true);
        lblCashLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblCashLabel.setLocation(new Point(8, 16));
        lblCashLabel.setName("lblCashLabel");
        lblCashLabel.setSize(new FormSize(35, 16));
        lblCashLabel.setTabIndex(38);
        lblCashLabel.setText("Cash:");
        // lblDebtLabel
        lblDebtLabel.setAutoSize(true);
        lblDebtLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblDebtLabel.setLocation(new Point(8, 32));
        lblDebtLabel.setName("lblDebtLabel");
        lblDebtLabel.setSize(new FormSize(32, 16));
        lblDebtLabel.setTabIndex(39);
        lblDebtLabel.setText("Debt:");
        // lblNetWorthLabel
        lblNetWorthLabel.setAutoSize(true);
        lblNetWorthLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblNetWorthLabel.setLocation(new Point(8, 48));
        lblNetWorthLabel.setName("lblNetWorthLabel");
        lblNetWorthLabel.setSize(new FormSize(60, 16));
        lblNetWorthLabel.setTabIndex(40);
        lblNetWorthLabel.setText("Net Worth:");
        // lblDifficultyLabel
        lblDifficultyLabel.setAutoSize(true);
        lblDifficultyLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblDifficultyLabel.setLocation(new Point(8, 24));
        lblDifficultyLabel.setName("lblDifficultyLabel");
        lblDifficultyLabel.setSize(new FormSize(53, 16));
        lblDifficultyLabel.setTabIndex(43);
        lblDifficultyLabel.setText("Difficulty:");
        // lblTime
        lblTime.setLocation(new Point(69, 40));
        lblTime.setName("lblTime");
        lblTime.setSize(new FormSize(66, 13));
        lblTime.setTabIndex(44);
        lblTime.setText("88,888 days");
        // boxSkills
        boxSkills.Controls.addAll(lblEngineer, lblTrader, lblFighter, lblPilot, lblEngineerLabel, lblTraderLabel, lblFighterLabel, lblPilotLabel);
        boxSkills.setLocation(new Point(8, 64));
        boxSkills.setName("boxSkills");
        boxSkills.setSize(new FormSize(216, 56));
        boxSkills.setTabIndex(49);
        boxSkills.setTabStop(false);
        boxSkills.setText("Skills");
        // lblEngineer
        lblEngineer.setLocation(new Point(167, 32));
        lblEngineer.setName("lblEngineer");
        lblEngineer.setSize(new FormSize(40, 13));
        lblEngineer.setTabIndex(56);
        lblEngineer.setText("88 (88)");
        // lblTrader
        lblTrader.setLocation(new Point(58, 32));
        lblTrader.setName("lblTrader");
        lblTrader.setSize(new FormSize(40, 13));
        lblTrader.setTabIndex(55);
        lblTrader.setText("88 (88)");
        // lblFighter
        lblFighter.setLocation(new Point(167, 16));
        lblFighter.setName("lblFighter");
        lblFighter.setSize(new FormSize(40, 13));
        lblFighter.setTabIndex(54);
        lblFighter.setText("88 (88)");
        // lblPilot
        lblPilot.setLocation(new Point(58, 16));
        lblPilot.setName("lblPilot");
        lblPilot.setSize(new FormSize(40, 13));
        lblPilot.setTabIndex(53);
        lblPilot.setText("88 (88)");
        // lblEngineerLabel
        lblEngineerLabel.setAutoSize(true);
        lblEngineerLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblEngineerLabel.setLocation(new Point(104, 32));
        lblEngineerLabel.setName("lblEngineerLabel");
        lblEngineerLabel.setSize(new FormSize(55, 16));
        lblEngineerLabel.setTabIndex(52);
        lblEngineerLabel.setText("Engineer:");
        // lblTraderLabel
        lblTraderLabel.setAutoSize(true);
        lblTraderLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTraderLabel.setLocation(new Point(8, 32));
        lblTraderLabel.setName("lblTraderLabel");
        lblTraderLabel.setSize(new FormSize(42, 16));
        lblTraderLabel.setTabIndex(51);
        lblTraderLabel.setText("Trader:");
        // lblFighterLabel
        lblFighterLabel.setAutoSize(true);
        lblFighterLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblFighterLabel.setLocation(new Point(104, 16));
        lblFighterLabel.setName("lblFighterLabel");
        lblFighterLabel.setSize(new FormSize(44, 16));
        lblFighterLabel.setTabIndex(50);
        lblFighterLabel.setText("Fighter:");
        // lblPilotLabel
        lblPilotLabel.setAutoSize(true);
        lblPilotLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblPilotLabel.setLocation(new Point(8, 16));
        lblPilotLabel.setName("lblPilotLabel");
        lblPilotLabel.setSize(new FormSize(31, 16));
        lblPilotLabel.setTabIndex(49);
        lblPilotLabel.setText("Pilot:");
        // boxFinances
        boxFinances.Controls.addAll(lblCash, lblDebt, lblNetWorth, lblNetWorthLabel, lblCashLabel, lblDebtLabel);
        boxFinances.setLocation(new Point(8, 128));
        boxFinances.setName("boxFinances");
        boxFinances.setSize(new FormSize(216, 72));
        boxFinances.setTabIndex(50);
        boxFinances.setTabStop(false);
        boxFinances.setText("Finances");
        // lblCash
        lblCash.setLocation(new Point(104, 16));
        lblCash.setName("lblCash");
        lblCash.setSize(new FormSize(70, 13));
        lblCash.setTabIndex(43);
        lblCash.setText("8,888,888 cr.");
        lblCash.TextAlign = ContentAlignment.TopRight;
        // lblDebt
        lblDebt.setLocation(new Point(104, 32));
        lblDebt.setName("lblDebt");
        lblDebt.setSize(new FormSize(70, 13));
        lblDebt.setTabIndex(42);
        lblDebt.setText("8,888,888 cr.");
        lblDebt.TextAlign = ContentAlignment.TopRight;
        // lblNetWorth
        lblNetWorth.setLocation(new Point(104, 48));
        lblNetWorth.setName("lblNetWorth");
        lblNetWorth.setSize(new FormSize(70, 13));
        lblNetWorth.setTabIndex(41);
        lblNetWorth.setText("8,888,888 cr.");
        lblNetWorth.TextAlign = ContentAlignment.TopRight;
        // boxNotoriety
        boxNotoriety.Controls.addAll(lblBountyLabel, lblBounty, lblPoliceLabel, lblReputationLabel, lblKillsLabel, lblKills, lblReputation, lblRecord);
        boxNotoriety.setLocation(new Point(8, 208));
        boxNotoriety.setName("boxNotoriety");
        boxNotoriety.setSize(new FormSize(216, 88));
        boxNotoriety.setTabIndex(51);
        boxNotoriety.setTabStop(false);
        boxNotoriety.setText("Notoriety");
        // lblPoliceLabel
        lblPoliceLabel.setAutoSize(true);
        lblPoliceLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblPoliceLabel.setLocation(new Point(8, 48));
        lblPoliceLabel.setName("lblPoliceLabel");
        lblPoliceLabel.setSize(new FormSize(81, 16));
        lblPoliceLabel.setTabIndex(46);
        lblPoliceLabel.setText("Police Record:");
        // lblReputationLabel
        lblReputationLabel.setAutoSize(true);
        lblReputationLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblReputationLabel.setLocation(new Point(8, 32));
        lblReputationLabel.setName("lblReputationLabel");
        lblReputationLabel.setSize(new FormSize(65, 16));
        lblReputationLabel.setTabIndex(45);
        lblReputationLabel.setText("Reputation:");
        // lblKillsLabel
        lblKillsLabel.setAutoSize(true);
        lblKillsLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblKillsLabel.setLocation(new Point(8, 16));
        lblKillsLabel.setName("lblKillsLabel");
        lblKillsLabel.setSize(new FormSize(30, 16));
        lblKillsLabel.setTabIndex(44);
        lblKillsLabel.setText("Kills:");
        // lblKills
        lblKills.setLocation(new Point(104, 16));
        lblKills.setName("lblKills");
        lblKills.setSize(new FormSize(33, 13));
        lblKills.setTabIndex(43);
        lblKills.setText("8,888");
        // lblReputation
        lblReputation.setLocation(new Point(104, 32));
        lblReputation.setName("lblReputation");
        lblReputation.setSize(new FormSize(88, 13));
        lblReputation.setTabIndex(42);
        lblReputation.setText("Mostly Harmless");
        // lblRecord
        lblRecord.setLocation(new Point(104, 48));
        lblRecord.setName("lblRecord");
        lblRecord.setSize(new FormSize(63, 13));
        lblRecord.setTabIndex(41);
        lblRecord.setText("Psychopath");
        // lblBountyLabel
        lblBountyLabel.setAutoSize(true);
        lblBountyLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblBountyLabel.setLocation(new Point(8, 64));
        lblBountyLabel.setName("lblBountyLabel");
        lblBountyLabel.setSize(new FormSize(84, 16));
        lblBountyLabel.setTabIndex(48);
        lblBountyLabel.setText("Bounty offered:");
        lblBountyLabel.setVisible(false);
        // lblBounty
        lblBounty.setLocation(new Point(104, 64));
        lblBounty.setName("lblBounty");
        lblBounty.setSize(new FormSize(72, 13));
        lblBounty.setTabIndex(47);
        lblBounty.setText("8,888,888 cr.");
        lblBounty.setVisible(false);
        // FormViewCommander
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnClose);
        setClientSize(new FormSize(232, 304));
        Controls.addAll(Arrays.asList(boxNotoriety, boxFinances, boxSkills, lblTime,
                lblDifficultyLabel, lblTimeLabel, lblNameLabel, btnClose, lblDifficulty,
                lblName));
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
        Commander cmdr = game.Commander();
        lblName.setText(cmdr.Name());
        lblDifficulty.setText(Strings.DifficultyLevels[game.Difficulty().CastToInt()]);
        lblTime.setText(Functions.Multiples(cmdr.getDays(), Strings.TimeUnit));
        lblPilot.setText(cmdr.Pilot() + " (" + cmdr.getShip().Pilot() + ")");
        lblFighter.setText(cmdr.Fighter() + " (" + cmdr.getShip().Fighter() + ")");
        lblTrader.setText(cmdr.Trader() + " (" + cmdr.getShip().Trader() + ")");
        lblEngineer.setText(cmdr.Engineer() + " (" + cmdr.getShip().Engineer() + ")");
        lblCash.setText(Functions.FormatMoney(cmdr.getCash()));
        lblDebt.setText(Functions.FormatMoney(cmdr.getDebt()));
        lblNetWorth.setText(Functions.FormatMoney(cmdr.Worth()));
        lblKills.setText(Functions.FormatNumber(cmdr.getKillsPirate() + cmdr.getKillsPolice() + cmdr.getKillsTrader()));
        lblRecord.setText(PoliceRecord.GetPoliceRecordFromScore(cmdr.getPoliceRecordScore()).Name());
        lblReputation.setText(Reputation.GetReputationFromScore(cmdr.getReputationScore()).Name());
        int score = cmdr.getPoliceRecordScore();
        if (score <= Constants.PoliceRecordScoreCrook) {
            lblBountyLabel.setVisible(true);
            lblBountyLabel.setText("Bounty offered:");
            lblBounty.setVisible(true);
            lblBounty.setText(Functions.FormatMoney(-1000 * score));
        } else if (score >= Constants.PoliceRecordScoreTrusted) {
            lblBountyLabel.setVisible(true);
            lblBountyLabel.setText("Angry kingpins:");
            lblBounty.setVisible(true);
            lblBounty.setText(Functions.FormatNumber(score / 5));
        } else {
            lblBountyLabel.setVisible(false);
            lblBounty.setVisible(false);
        }
    }

}
