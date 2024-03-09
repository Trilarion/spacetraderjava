package org.jwinforms;

import javax.swing.*;
import java.awt.*;


public class JStatusBar extends JPanel {
    private static final long serialVersionUID = 1L;

    public JStatusBar() {
        super(new GridBagLayout());
    }

    public void addSection(JStatusBarSection section, boolean stretch) {
        GridBagConstraints c = new GridBagConstraints();
        if (stretch) {
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;
        } else {
            c.fill = GridBagConstraints.NONE;
            c.weightx = 0.0;
        }
        this.add(section, c);
    }
}
