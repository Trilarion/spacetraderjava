package org.jwinforms;

import javax.swing.*;


public class Panel extends WinformControl {
    public Panel Controls = this;
    public boolean AutoScroll;

    public Panel() {
        super(new JPanel());
    }

    public void add(WinformControl control) {
        ((JPanel) swingVersion).add(control.swingVersion);
    }
}
