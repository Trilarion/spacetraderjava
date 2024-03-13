package org.winforms;

import org.winforms.enums.ComboBoxStyle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ComboBox extends Control {
    public final DefaultComboBoxModel Items = new DefaultComboBoxModel<>();
    public ComboBoxStyle DropDownStyle;

    public ComboBox() {
        super(new JComboBox<>());
        asJComboBox().setModel(Items);
    }

    public JComboBox<Object> asJComboBox() {
        return (JComboBox<Object>) swingComponent;
    }

    public Object getSelectedItem() {
        return asJComboBox().getSelectedItem();
    }

    public int getSelectedIndex() {
        return asJComboBox().getSelectedIndex();
    }

    public void setSelectedIndex(int index) {
        asJComboBox().setSelectedIndex(index);
    }

    public void setSelectedIndexChanged(final EventHandler<Object, EventData> handler) {
        asJComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handler.handle(ComboBox.this, null);
            }
        });
    }
}
