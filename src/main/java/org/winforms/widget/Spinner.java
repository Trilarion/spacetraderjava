package org.winforms.widget;

import org.winforms.alignment.HorizontalAlignment;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Spinner extends Control<JSpinner> {

    private final SpinnerNumberModel model = new SpinnerNumberModel();
    public HorizontalAlignment textAlignment;
    public boolean thousandsSeparator;

    public Spinner() {
        super(new JSpinner());
        JSpinner spinner = asJSpinner();
        spinner.setModel(model);
        // this bunch of code selects all text when entering the spinner.
        ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().addFocusListener(new MyFocusAdapter());
    }

    public void select(int i, int length) {
        // TODO implement
    }

    public void setValueChanged(final EventHandler<Object, EventData> valueChanged) {
        asJSpinner().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueChanged.handle(Spinner.this, null);
            }
        });
    }

    private JSpinner asJSpinner() {
        return (JSpinner) swingComponent;
    }

    public int getMaximum() {
        Integer maximum = (Integer) model.getMaximum();
        return maximum == null ? Integer.MAX_VALUE : maximum;
    }

    public void setMaximum(int maximum) {
        model.setMaximum(maximum);
    }

    public int getMinimum() {
        Integer minimum = (Integer) model.getMinimum();
        return minimum == null ? 0 : minimum;
    }

    public void setMinimum(int minimum) {
        model.setMinimum(minimum);
    }

    /**
     * In .NET, this means that the field can be manipulated by the buttons/arrows, just not by directly inputing text into it.
     * TODO: implement this. Possibly by installing filter on key-presses.
     *
     * @param b read only
     */
    public void setReadOnly(boolean b) {
        asJSpinner().setEnabled(!b);
    }

    public void setLeave(EventHandler<Object, EventData> leave) {
        // TODO implement (or do nothing)
    }

    public int getValue() {
        return (Integer) asJSpinner().getValue();
    }

    public void setValue(int value) {
        asJSpinner().setValue(value);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    public void setIncrement(int increment) {
        model.setStepSize(increment);
    }

    private static class MyFocusAdapter extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource() instanceof JTextComponent) {
                final JTextComponent textComponent = ((JTextComponent) e.getSource());
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        textComponent.selectAll();
                    }
                });
            }
        }
    }
}
