package org.winforms.controls;

import org.winforms.controls.Control;

import javax.swing.*;

// TODO documentation of usage
public class Panel extends Control<JPanel> {

    public boolean autoScroll;

    public Panel() {
        super(new JPanel());
    }

    public void add(Control control) {
        ((JPanel) swingComponent).add(control.swingComponent);
    }
}
