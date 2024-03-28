package org.winforms.widget;

import org.winforms.dialog.DialogResult;
import org.winforms.style.FlatStyle;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Wrapper around JButton
 */
public class Button extends Control<JButton> {

    public Action userAction;
    public DialogResult dialogResult;

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
        return swingComponent;
    }

    public void setDialogResult(DialogResult dialogResult) {
        this.dialogResult = dialogResult;
    }

    @Override
    @SuppressWarnings("serial")
    public void setClick(EventHandler<Object, EventData> click) {
        userAction = new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                click.handle(Button.this, null);
            }
        };
        userAction.putValue(Action.NAME, getText());
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

    public void setToolTip(String text) {  // TODO could be static in utils or so
        asJButton().setToolTipText(text);
    }
}
