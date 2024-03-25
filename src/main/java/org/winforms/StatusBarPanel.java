package org.winforms;

import org.winforms.enums.StatusBarPanelAutoSize;

import java.awt.*;

// TODO documentation of usage
public class StatusBarPanel implements EventData {

    public final StatusBarPanelAutoSize autoSize;
    private final JStatusBarSection jpanel = new JStatusBarSection(" ");

    public StatusBarPanel() {
        this(StatusBarPanelAutoSize.None);
    }

    public StatusBarPanel(StatusBarPanelAutoSize autoSize) {
        this.autoSize = autoSize;
    }

    public void setText(String text) {
        if (text.isEmpty()) {
            text = "  ";
        }
        jpanel.setText(text);
    }

    public void setWidth(int w) {
        int h = jpanel.getHeight();
        jpanel.setSize(w, h);
    }

    public JStatusBarSection asJStatusBarSection() {
        return jpanel;
    }

    public void setMinWidth(int width) {
        int height = jpanel.getPreferredSize().height;
        jpanel.setPreferredSize(new Dimension(width, height));
        jpanel.setMinimumSize(new Dimension(width, height));
    }

}
