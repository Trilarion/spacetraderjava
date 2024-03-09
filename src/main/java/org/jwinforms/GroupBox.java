package org.jwinforms;

import org.jwinforms.enums.AnchorStyles;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GroupBox extends WinformControl {
    public final WinformJPanel Controls;
    public AnchorStyles Anchor;
    private TitledBorder border;

    public GroupBox() {
        super(new WinformJPanel(null));
        Controls = (WinformJPanel) swingVersion;
        border = BorderFactory.createTitledBorder("");
        asJPanel().setBorder(border);
    }

    @Override
    public void SuspendLayout() {
    }

    public String getText() {
        return border.getTitle();
    }

    public void setText(String text) {
        border.setTitle(text);
    }

    public WinformJPanel asJPanel() {
        return Controls;
    }
}
