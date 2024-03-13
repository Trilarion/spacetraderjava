package org.winforms;

// TODO documentation of usage
public class ToolTip {

    public ToolTip() {}

    public void SetToolTip(Button item, String text) {  // TODO could be static in utils or so
        item.asJButton().setToolTipText(text);
    }
}
