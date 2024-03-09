package org.jwinforms;

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
        panel.addSection(new JStatusBarSection("left"), false);
        panel.addSection(new JStatusBarSection("Foo bar!"), false);
        panel.addSection(new JStatusBarSection("--fill--"), true);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
