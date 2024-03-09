package org.spacetrader.main.gui;

import javax.swing.*;

public class FormBuyRepairsExample {

    private FormBuyRepairsExample() {}

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        FormBuyRepairs form = new FormBuyRepairs();
        Launcher.runForm(form);
        System.out.println(form.Amount());
    }
}
