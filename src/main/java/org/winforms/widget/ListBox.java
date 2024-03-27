package org.winforms.widget;

import org.winforms.style.BorderStyle;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

// TODO documentation of properties and usage
public class ListBox extends Control<JList> {

    public final DefaultListModel Items = new DefaultListModel<>();

    public ListBox() {
        super(new JList<>());
        asJList().setModel(Items);
    }

    @Override

    public void setBorderStyle(final BorderStyle borderStyle) {
        if (borderStyle != BorderStyle.FixedSingle) {
            throw new Error("Unknown border style");
        }
        asJList().setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

    public void clearSelected() {
        asJList().clearSelection();
    }

    public JList<Object> asJList() {
        return (JList<Object>) swingComponent;
    }

    public void setSelectedIndexChanged(EventHandler<Object, EventData> handler) {
        asJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                handler.handle(ListBox.this, null);
            }
        });
    }

    public int getSelectedIndex() {
        return asJList().getSelectedIndex();
    }

    public int getItemHeight() {
        return 15;
    }

    public Object getSelectedItem() {
        return asJList().getSelectedValue();
    }

    public void setSelectedItem(final Object selectedItem) {
        asJList().setSelectedValue(selectedItem, true);
    }
}
