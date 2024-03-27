package org.winforms.widget;

import javax.swing.Icon;
import javax.swing.*;

// TODO documentation and composition (Control<>)
public class StatusBarSection extends JLabel {
    private static final long serialVersionUID = 1L;

    public StatusBarSection() {
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(final Icon image, final int horizontalAlignment) {
        super(image, horizontalAlignment);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(final Icon image) {
        super(image);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(final String text, final Icon icon, final int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(final String text, final int horizontalAlignment) {
        super(text, horizontalAlignment);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public StatusBarSection(final String text) {
        super(text);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }
}
