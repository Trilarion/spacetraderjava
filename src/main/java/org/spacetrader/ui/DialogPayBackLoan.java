package org.spacetrader.ui;

import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.Label;
import org.winforms.widget.Spinner;
import org.winforms.dialog.DialogResult;
import org.winforms.style.FlatStyle;
import org.winforms.style.FormBorderStyle;
import org.winforms.alignment.FormStartPosition;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import java.awt.*;


public class DialogPayBackLoan extends Dialog {
    private final Spinner numAmount;

    public DialogPayBackLoan() {
        final Label labelQuestion = new Label();
        numAmount = new Spinner();
        final Button buttonOk = new Button();
        final Button buttonMax = new Button();
        final Button buttonNothing = new Button();
        final Label labelStatement = new Label();
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
            public void handle(final Object sender, final EventData data) {
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
        final Game game = Game.getCurrentGame();
        final Commander commander = game.Commander();
        final int max = Math.min(commander.getDebt(), commander.getCash());
        numAmount.setMaximum(max);
        numAmount.setValue(numAmount.getMinimum());
        labelStatement.setText(ModelUtils.StringVars("You have a debt of ^1.", ModelUtils.Multiples(commander.getDebt(), Strings.MoneyUnit)));
    }


    private void buttonMax_Click() {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
