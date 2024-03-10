package org.winforms;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CheckBox extends wfControl {
    public CheckBox() {
        super(new JCheckBox());
    }

    public JCheckBox asJCheckBox() {
        return ((JCheckBox) swingComponent);
    }

    public String getText() {
        return asJCheckBox().getText();
    }

    public void setText(String text) {
        asJCheckBox().setText(text);
    }

    public boolean isChecked() {
        return asJCheckBox().isSelected();
    }

    public void setChecked(boolean checked) {
        asJCheckBox().setSelected(checked);
    }

    public void setCheckedChanged(final EventHandler<Object, EventData> handler) {
        asJCheckBox().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                handler.handle(CheckBox.this, null);
            }
        });
    }
}
