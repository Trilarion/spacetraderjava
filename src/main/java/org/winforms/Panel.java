package org.winforms;

import javax.swing.*;


public class Panel extends wfControl {
    public Panel Controls = this;
    public boolean AutoScroll;

    public Panel() {
        super(new JPanel());
    }

    public void add(wfControl control) {
        ((JPanel) swingVersion).add(control.swingVersion);
    }
}
