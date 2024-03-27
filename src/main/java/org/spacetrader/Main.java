package org.spacetrader;

import org.spacetrader.ui.MainWindow;

import javax.swing.*;

public class Main {
    /**
     * Main entry point for the game.
     */
    public static void main(final String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (final ClassNotFoundException | InstantiationException | IllegalAccessException |
                       UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        final MainWindow mainWindow = new MainWindow();
        mainWindow.showWindow();
    }

}
