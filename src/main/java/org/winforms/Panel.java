package org.winforms;

import javax.swing.*;

// TODO documentation of usage
public class Panel extends wfControl {
    public Panel Controls = this;
    public boolean AutoScroll;

    public Panel() {
        super(new JPanel());
    }

    public void add(wfControl control) {
        ((JPanel) swingComponent).add(control.swingComponent);
    }
}
