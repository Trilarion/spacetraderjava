package org.spacetrader.ui;

import org.spacetrader.controller.Functions;
import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;
import java.util.Arrays;


public class FormGetLoan extends wfForm {
    private NumericUpDown numAmount;

    public FormGetLoan(int max) {
        Label labelQuestion = new Label();
        numAmount = new NumericUpDown();
        Button buttonOk = new Button();
        Button buttonMax = new Button();
        Button buttonNothing = new Button();
        Label labelStatement = new Label();
        ((ISupportInitialize) (numAmount)).beginInit();
        SuspendLayout();
        // labelQuestion
        labelQuestion.setAutoSize(true);
        labelQuestion.setLocation(new Point(8, 24));
        labelQuestion.setName("labelQuestion");
        labelQuestion.setSize(new FormSize(178, 13));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to borrow?");
        // numAmount
        numAmount.setLocation(new Point(184, 22));
        numAmount.setMaximum(99999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new FormSize(58, 20));
        numAmount.setTabIndex(1);
        numAmount.ThousandsSeparator = true;
        numAmount.setValue(88888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(52, 48));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new FormSize(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.OK);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(100, 48));
        buttonMax.setName("buttonMax");
        buttonMax.setSize(new FormSize(41, 22));
        buttonMax.setTabIndex(3);
        buttonMax.setText("Max");
        buttonMax.setClick(new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData e) {
                buttonMax_Click();
            }
        });
        // buttonNothing
        buttonNothing.setDialogResult(DialogResult.Cancel);
        buttonNothing.setFlatStyle(FlatStyle.Flat);
        buttonNothing.setLocation(new Point(148, 48));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new FormSize(53, 22));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // labelStatement
        labelStatement.setLocation(new Point(8, 8));
        labelStatement.setName("labelStatement");
        labelStatement.setSize(new FormSize(189, 13));
        labelStatement.setTabIndex(5);
        labelStatement.setText("You can borrow up to 88,888 credits.");
        // FormGetLoan
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonNothing);
        setClientSize(new FormSize(252, 79));
        setControlBox(false);
        Controls.addAll(Arrays.asList(labelStatement, buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormGetLoan");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Get Loan");
        ((ISupportInitialize) (numAmount)).endInit();
        ResumeLayout(false);
        numAmount.setMaximum(max);
        numAmount.setValue(numAmount.getMinimum());
        labelStatement.setText(Functions.StringVars("You can borrow up to ^1.", Functions.Multiples(max, Strings.MoneyUnit)));
    }


    private void buttonMax_Click() {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
