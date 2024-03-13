package org.winforms;

import org.winforms.enums.AnchorStyles;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GroupBox extends wfControl {
    public final wfPanel Controls;
    private final TitledBorder border;
    public AnchorStyles Anchor;

    public GroupBox() {
        super(new wfPanel(null));
        Controls = (wfPanel) swingComponent;
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