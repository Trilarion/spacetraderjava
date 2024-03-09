package org.jwinforms;

import org.jwinforms.enums.BorderStyle;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class ListBox extends WinformControl {
    public final MyListModel Items = new MyListModel();

    public ListBox() {
        super(new JList<>());
        ListBox.this.asJList().setModel(Items);
    }

    @Override

    public void setBorderStyle(BorderStyle borderStyle) {
        if (borderStyle != BorderStyle.FixedSingle) {
            throw new Error("Unknown border style");
        }
        asJList().setBorder(BorderFactory.createLineBorder(Color.black, 1));
    }

    public void clearSelected() {
        asJList().clearSelection();
    }

    public JList<Object> asJList() {
        return (JList<Object>) swingVersion;
    }

    public void setSelectedIndexChanged(final EventHandler<Object, EventArgs> handler) {
        asJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
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

    public void setSelectedItem(Object selectedItem) {
        asJList().setSelectedValue(selectedItem, true);
    }
}
