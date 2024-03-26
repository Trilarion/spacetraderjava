package org.winforms.controls;

import org.winforms.events.EventData;
import org.winforms.events.EventHandler;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// TODO documentation of usage
public class TextField extends Control<JTextField> {

    public TextField() {
        super(new JTextField());
    }

    public void setTextChanged(final EventHandler<Object, EventData> valueChanged) {
        asJTextField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                valueChanged.handle(TextField.this, null);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                valueChanged.handle(TextField.this, null);
            }
        });
    }

    public String getText() {
        return asJTextField().getText();
    }

    public void setText(String text) {
        asJTextField().setText(text);
    }

    public JTextField asJTextField() {
        return (JTextField) swingComponent;
    }
}
