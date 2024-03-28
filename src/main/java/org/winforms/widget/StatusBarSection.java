package org.winforms.widget;

import javax.swing.Icon;
import javax.swing.*;

// TODO documentation and composition (Control<>)
public class StatusBarSection extends JLabel {
    private static final long serialVersionUID = 1L;

    public StatusBarSection() {
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(Icon image) {
        super(image);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(String text) {
        super(text);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }
}
