package org.winforms;

import org.winforms.widget.JStatusBar;
import org.winforms.widget.StatusBarSection;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;

public class JStatusBarExample {

    private JStatusBarExample() {}

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JStatusBar panel = new JStatusBar();
        Container pane = frame.getContentPane();
        pane.add(panel, BorderLayout.SOUTH);
        panel.addSection(new StatusBarSection("left"), false);
        panel.addSection(new StatusBarSection("Foo bar!"), false);
        panel.addSection(new StatusBarSection("--fill--"), true);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
