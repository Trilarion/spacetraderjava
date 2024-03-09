package org.jwinforms;


public class ToolTip {
    public ToolTip(IContainer components) {
    }

    public void SetToolTip(Button item, String text) {
        item.asJButton().setToolTipText(text);
    }
}
