package org.spacetrader.main.gui;

import org.spacetrader.ui.DialogAbout;

import javax.swing.*;

public class FormAboutExample {

    private FormAboutExample() {}

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        new DialogAbout().ShowDialog(null);
    }
}
