package org.spacetrader.ui;

import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.winforms.controls.Button;
import org.winforms.controls.Label;
import org.winforms.*;
import org.winforms.controls.Spinner;
import org.winforms.controls.Dialog;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class DialogPayBackLoan extends Dialog {
    private final Spinner numAmount;

    public DialogPayBackLoan() {
        Label labelQuestion = new Label();
        numAmount = new Spinner();
        Button buttonOk = new Button();
        Button buttonMax = new Button();
        Button buttonNothing = new Button();
        Label labelStatement = new Label();
        suspendLayout();
        // labelQuestion
        labelQuestion.setAutoSize(true);
        labelQuestion.setLocation(new Point(8, 24));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new Dimension(188, 13));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to pay back?");
        // numAmount
        numAmount.setLocation(new Point(196, 22));
        numAmount.setMaximum(999999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new Dimension(58, 20));
        numAmount.setTabIndex(1);
        numAmount.thousandsSeparator = true;
        numAmount.setValue(88888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(58, 48));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new Dimension(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.OK);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(106, 48));
        buttonMax.setName("buttonMax");
        buttonMax.setSize(new Dimension(41, 22));
        buttonMax.setTabIndex(3);
        buttonMax.setText("Max");
        buttonMax.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                buttonMax_Click();
            }
        });
        // buttonNothing
        buttonNothing.setDialogResult(DialogResult.Cancel);
        buttonNothing.setFlatStyle(FlatStyle.Flat);
        buttonNothing.setLocation(new Point(154, 48));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new Dimension(53, 22));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // labelStatement
        labelStatement.setLocation(new Point(8, 8));
        labelStatement.setName("labelStatement");
        labelStatement.setSize(new Dimension(176, 13));
        labelStatement.setTabIndex(5);
        labelStatement.setText("You have a debt of 88,888 credits.");
        // FormPayBackLoan
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonNothing);
        setClientSize(new Dimension(264, 79));
        setControlBox(false);
        Controls.addAll(labelStatement, buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormPayBackLoan");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Pay Back Loan");
        resumeLayout(false);
        Game game = Game.getCurrentGame();
        Commander commander = game.Commander();
        int max = Math.min(commander.getDebt(), commander.getCash());
        numAmount.setMaximum(max);
        numAmount.setValue(numAmount.getMinimum());
        labelStatement.setText(Functions.StringVars("You have a debt of ^1.", Functions.Multiples(commander.getDebt(), Strings.MoneyUnit)));
    }


    private void buttonMax_Click() {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
