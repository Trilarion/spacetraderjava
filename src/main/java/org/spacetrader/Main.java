package org.spacetrader;

import org.spacetrader.ui.MainWindow;

import javax.swing.*;

public class Main {
    /**
     * Main entry point for the game.
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MainWindow mainWindow = new MainWindow();
        mainWindow.ShowWindow();
    }

}
