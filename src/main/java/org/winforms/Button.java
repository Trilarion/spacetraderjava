package org.winforms;

import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Button extends wfControl {
    Action userAction;
    DialogResult DialogResult;

    public Button() {
        super(new JButton());
    }

    public String getText() {
        return asJButton().getText();
    }

    public void setText(String text) {
        asJButton().setText(text);
    }

    @Override
    public void setSize(Dimension size) {
        // width should be bigger because font is bigger(?).
        super.setSize(new Dimension(size.width, size.height));
    }

    public JButton asJButton() {
        return (JButton) swingComponent;
    }

    public void setDialogResult(DialogResult dialogResult) {
        DialogResult = dialogResult;
    }

    @Override
    @SuppressWarnings("serial")
    public void setClick(final EventHandler<Object, EventData> click) {
        userAction = new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                click.handle(Button.this, null);
            }
        };
        userAction.putValue(AbstractAction.NAME, getText());
        asJButton().setAction(userAction);
        super.setClick(click);
    }

    public void setFlatStyle(FlatStyle flatStyle) {
        switch (flatStyle) {
            case Flat:
                asJButton().setBorder(BorderFactory.createLineBorder(Color.black));
                return;
            default:
                throw new Error("Unknown FlatStyle");
        }
    }
}
