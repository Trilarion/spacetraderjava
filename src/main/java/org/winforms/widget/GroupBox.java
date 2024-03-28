package org.winforms.widget;

import org.winforms.style.AnchorStyle;

import javax.swing.*;
import javax.swing.border.TitledBorder;

// TODO document implementation and usage
public class GroupBox extends Control<wfPanel> {

    public final wfPanel controls;
    private final TitledBorder border;
    public AnchorStyle anchor;

    public GroupBox() {
        super(new wfPanel(null));
        controls = swingComponent;
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
