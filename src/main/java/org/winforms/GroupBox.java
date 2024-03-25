package org.winforms;

import org.winforms.enums.AnchorStyles;

import javax.swing.*;
import javax.swing.border.TitledBorder;

// TODO document implementation and usage
public class GroupBox extends Control {

    public final wfPanel controls;
    private final TitledBorder border;
    public AnchorStyles anchor;

    public GroupBox() {
        super(new wfPanel(null));
        controls = (wfPanel) swingComponent;
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
        return controls;
    }
}
