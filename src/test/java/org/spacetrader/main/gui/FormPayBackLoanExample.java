package org.spacetrader.main.gui;

import org.spacetrader.Main;
import org.spacetrader.ui.FormPayBackLoan;

public class FormPayBackLoanExample {

    private FormPayBackLoanExample() {}

    public static void main(String[] args) throws Exception {
        FormPayBackLoan form = new FormPayBackLoan();
        Main.runForm(form);
        System.out.println(form.Amount());
    }
}
