package org.jwinforms;

import org.jwinforms.enums.DialogResult;
import org.jwinforms.enums.FlatStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Button extends WinformControl {
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
        return (JButton) swingVersion;
    }

    public void setDialogResult(DialogResult dialogResult) {
        DialogResult = dialogResult;
    }

    @Override
    @SuppressWarnings("serial")
    public void setClick(final EventHandler<Object, EventArgs> click) {
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
        // I think this is default.
        //asJButtton().setBorder(BorderFactory.createRaisedBevelBorder());
    }
}
