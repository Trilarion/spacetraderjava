package org.spacetrader.main.gui;

import org.spacetrader.ui.DialogBuyRepairs;

import javax.swing.*;

public class FormBuyRepairsExample {

    private FormBuyRepairsExample() {}

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        DialogBuyRepairs form = new DialogBuyRepairs();
        form.ShowDialog(null);
        System.out.println(form.Amount());
    }
}
