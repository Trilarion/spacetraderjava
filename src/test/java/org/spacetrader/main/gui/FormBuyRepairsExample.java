package org.spacetrader.main.gui;

import org.spacetrader.ui.FormBuyRepairs;

import javax.swing.*;

public class FormBuyRepairsExample {

    private FormBuyRepairsExample() {}

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        FormBuyRepairs form = new FormBuyRepairs();
        form.ShowDialog(null);
        System.out.println(form.Amount());
    }
}
