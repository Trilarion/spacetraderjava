package org.spacetrader.ui;

import org.spacetrader.model.ModelUtils;
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
import java.util.Arrays;


public class DialogGetLoan extends Dialog {
    private final Spinner numAmount;

    public DialogGetLoan(final int max) {
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
        labelQuestion.setSize(new Dimension(178, 13));
        labelQuestion.setTabIndex(3);
        labelQuestion.setText("How much do you want to borrow?");
        // numAmount
        numAmount.setLocation(new Point(184, 22));
        numAmount.setMaximum(99999);
        numAmount.setMinimum(1);
        numAmount.setName("numAmount");
        numAmount.setSize(new Dimension(58, 20));
        numAmount.setTabIndex(1);
        numAmount.thousandsSeparator = true;
        numAmount.setValue(88888);
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(52, 48));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new Dimension(41, 22));
        buttonOk.setTabIndex(2);
        buttonOk.setText("Ok");
        // buttonMax
        buttonMax.setDialogResult(DialogResult.OK);
        buttonMax.setFlatStyle(FlatStyle.Flat);
        buttonMax.setLocation(new Point(100, 48));
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
        buttonNothing.setLocation(new Point(148, 48));
        buttonNothing.setName("buttonNothing");
        buttonNothing.setSize(new Dimension(53, 22));
        buttonNothing.setTabIndex(4);
        buttonNothing.setText("Nothing");
        // labelStatement
        labelStatement.setLocation(new Point(8, 8));
        labelStatement.setName("labelStatement");
        labelStatement.setSize(new Dimension(189, 13));
        labelStatement.setTabIndex(5);
        labelStatement.setText("You can borrow up to 88,888 credits.");
        // FormGetLoan
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonNothing);
        setClientSize(new Dimension(252, 79));
        setControlBox(false);
        Controls.addAll(Arrays.asList(labelStatement, buttonNothing, buttonMax, buttonOk, numAmount, labelQuestion));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormGetLoan");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Get Loan");
        resumeLayout(false);
        numAmount.setMaximum(max);
        numAmount.setValue(numAmount.getMinimum());
        labelStatement.setText(ModelUtils.StringVars("You can borrow up to ^1.", ModelUtils.Multiples(max, Strings.MoneyUnit)));
    }


    private void buttonMax_Click() {
        numAmount.setValue(numAmount.getMaximum());
    }

    public int Amount() {
        return numAmount.getValue();
    }
}
