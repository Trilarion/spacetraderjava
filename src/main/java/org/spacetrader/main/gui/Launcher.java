package org.spacetrader.main.gui;

import org.jwinforms.WinformForm;
import org.jwinforms.enums.DialogResult;

import javax.swing.*;


public class Launcher {
    public static void runForm(WinformForm wf) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.updateComponentTreeUI(wf.asSwingObject());
        DialogResult res = wf.ShowDialog(null);
        System.out.println("Dialog result: " + res);
    }
}
