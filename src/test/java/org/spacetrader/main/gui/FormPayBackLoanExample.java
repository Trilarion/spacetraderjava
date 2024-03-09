package org.spacetrader.main.gui;

public class FormPayBackLoanExample {

    private FormPayBackLoanExample() {}

    public static void main(String[] args) throws Exception {
        FormPayBackLoan form = new FormPayBackLoan();
        Launcher.runForm(form);
        System.out.println(form.Amount());
    }
}
