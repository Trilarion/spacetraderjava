package org.spacetrader.ui;

import org.spacetrader.controller.Functions;
import org.spacetrader.controller.HighScoreRecord;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.SizeF;
import org.winforms.enums.ContentAlignment;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;
import org.winforms.wfForm;

import java.awt.*;
import java.util.Arrays;


public class FormViewHighScores extends wfForm {

    public FormViewHighScores() {
        Button buttonClose = new Button();
        Label labelRank0 = new Label();
        Label labelRank2 = new Label();
        Label labelRank1 = new Label();
        Label labelScore0 = new Label();
        Label labelScore1 = new Label();
        Label labelScore2 = new Label();
        Label labelName0 = new Label();
        Label labelName1 = new Label();
        Label labelName2 = new Label();
        Label labelStatus0 = new Label();
        Label labelStatus1 = new Label();
        Label labelStatus2 = new Label();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new SizeF(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelRank0
        labelRank0.setAutoSize(true);
        labelRank0.setLocation(new Point(8, 8));
        labelRank0.setName("labelRank0");
        labelRank0.setSize(new SizeF(13, 14));
        labelRank0.setTabIndex(33);
        labelRank0.setText("1.");
        labelRank0.TextAlign = ContentAlignment.TopRight;
        // labelRank2
        labelRank2.setAutoSize(true);
        labelRank2.setLocation(new Point(8, 136));
        labelRank2.setName("labelRank2");
        labelRank2.setSize(new SizeF(13, 14));
        labelRank2.setTabIndex(34);
        labelRank2.setText("3.");
        labelRank2.TextAlign = ContentAlignment.TopRight;
        // labelRank1
        labelRank1.setAutoSize(true);
        labelRank1.setLocation(new Point(8, 72));
        labelRank1.setName("labelRank1");
        labelRank1.setSize(new SizeF(13, 14));
        labelRank1.setTabIndex(35);
        labelRank1.setText("2.");
        labelRank1.TextAlign = ContentAlignment.TopRight;
        // labelScore0
        labelScore0.setLocation(new Point(168, 8));
        labelScore0.setName("labelScore0");
        labelScore0.setSize(new SizeF(13, 43));
        labelScore0.setTabIndex(36);
        labelScore0.setText("888.8%");
        labelScore0.TextAlign = ContentAlignment.TopRight;
        labelScore0.setVisible(false);
        // labelScore1
        labelScore1.setLocation(new Point(168, 72));
        labelScore1.setName("labelScore1");
        labelScore1.setSize(new SizeF(13, 43));
        labelScore1.setTabIndex(37);
        labelScore1.setText("888.8%");
        labelScore1.TextAlign = ContentAlignment.TopRight;
        labelScore1.setVisible(false);
        // labelScore2
        labelScore2.setLocation(new Point(168, 136));
        labelScore2.setName("labelScore2");
        labelScore2.setSize(new SizeF(13, 43));
        labelScore2.setTabIndex(38);
        labelScore2.setText("888.8%");
        labelScore2.TextAlign = ContentAlignment.TopRight;
        labelScore2.setVisible(false);
        // labelName0
        labelName0.setLocation(new Point(24, 8));
        labelName0.setName("labelName0");
        labelName0.setSize(new SizeF(13, 144));
        labelName0.setTabIndex(39);
        labelName0.setText("Empty");
        // labelName1
        labelName1.setLocation(new Point(24, 72));
        labelName1.setName("labelName1");
        labelName1.setSize(new SizeF(13, 144));
        labelName1.setTabIndex(40);
        labelName1.setText("Empty");
        // labelName2
        labelName2.setLocation(new Point(24, 136));
        labelName2.setName("labelName2");
        labelName2.setSize(new SizeF(13, 144));
        labelName2.setTabIndex(41);
        labelName2.setText("Empty");
        // labelStatus0
        labelStatus0.setLocation(new Point(24, 24));
        labelStatus0.setName("labelStatus0");
        labelStatus0.setSize(new SizeF(26, 200));
        labelStatus0.setTabIndex(42);
        labelStatus0.setText("Claimed moon in 888,888 days, worth 8,888,888 credits on impossible level.");
        labelStatus0.setVisible(false);
        // labelStatus1
        labelStatus1.setLocation(new Point(24, 88));
        labelStatus1.setName("labelStatus1");
        labelStatus1.setSize(new SizeF(26, 200));
        labelStatus1.setTabIndex(43);
        labelStatus1.setText("Claimed moon in 888,888 days, worth 8,888,888 credits on impossible level.");
        labelStatus1.setVisible(false);
        // labelStatus2
        labelStatus2.setLocation(new Point(24, 152));
        labelStatus2.setName("labelStatus2");
        labelStatus2.setSize(new SizeF(26, 200));
        labelStatus2.setTabIndex(44);
        labelStatus2.setText("Claimed moon in 888,888 days, worth 8,888,888 credits on impossible level.");
        labelStatus2.setVisible(false);
        // FormViewHighScores
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonClose);
        setClientSize(new SizeF(191, 218));
        Controls.addAll(Arrays.asList(
                labelStatus2, labelStatus1, labelStatus0, labelName2, labelName1, labelName0,
                labelScore2, labelScore1, labelScore0, labelRank1, labelRank2, labelRank0, buttonClose));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormViewHighScores");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("High Scores");
        ResumeLayout(false);
        Label[] labelName = new Label[]{labelName0, labelName1, labelName2};
        Label[] labelScore = new Label[]{labelScore0, labelScore1, labelScore2};
        Label[] labelStatus = new Label[]{labelStatus0, labelStatus1, labelStatus2};
        HighScoreRecord[] highScores = Functions.GetHighScores(this);
        for (int i = highScores.length - 1; i >= 0 && highScores[i] != null; i--) {
            labelName[2 - i].setText(highScores[i].Name());
            labelScore[2 - i].setText(Functions.FormatNumber(highScores[i].Score() / 10) + "." + highScores[i].Score() % 10);
            labelStatus[2 - i].setText(Functions.StringVars(Strings.HighScoreStatus, new String[]{
                    Strings.GameCompletionTypes[highScores[i].Type().getId()],
                    Functions.Multiples(highScores[i].Days(), Strings.TimeUnit),
                    Functions.Multiples(highScores[i].Worth(), Strings.MoneyUnit),
                    Strings.DifficultyLevels[highScores[i].Difficulty().getId()].toLowerCase()
            }));
            labelScore[2 - i].setVisible(true);
            labelStatus[2 - i].setVisible(true);
        }
    }

}
