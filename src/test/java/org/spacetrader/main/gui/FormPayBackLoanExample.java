package org.spacetrader.main.gui;

import org.spacetrader.ui.DialogPayBackLoan;

public class FormPayBackLoanExample {

    private FormPayBackLoanExample() {}

    public static void main(String[] args) throws Exception {
        DialogPayBackLoan form = new DialogPayBackLoan();
        form.ShowDialog(null);
        System.out.println(form.Amount());
    }
}
