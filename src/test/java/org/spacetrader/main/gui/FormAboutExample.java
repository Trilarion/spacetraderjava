package org.spacetrader.main.gui;

import org.spacetrader.ui.FormAbout;

import javax.swing.*;

public class FormAboutExample {

    private FormAboutExample() {}

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        new FormAbout().ShowDialog(null);
    }
}
