package org.winforms;

import org.winforms.enums.AnchorStyles;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GroupBox extends wfControl {
    public final wfPanel Controls;
    public AnchorStyles Anchor;
    private TitledBorder border;

    public GroupBox() {
        super(new wfPanel(null));
        Controls = (wfPanel) swingVersion;
        border = BorderFactory.createTitledBorder("");
        asJPanel().setBorder(border);
    }

    public String getText() {
        return border.getTitle();
    }

    public void setText(String text) {
        border.setTitle(text);
    }

    public wfPanel asJPanel() {
        return Controls;
    }
}
