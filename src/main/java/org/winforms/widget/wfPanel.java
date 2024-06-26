package org.winforms.widget;

import org.winforms.dialog.Pane;
import org.winforms.event.ChainedEventHandler;
import org.winforms.event.EventData;
import org.winforms.image.Image;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// TODO documentation of usage
public class wfPanel extends JPanel {  // TODO there is another Panel, what is the difference to this Panel

    private static final long serialVersionUID = 1L;
    private final Pane form;
    public Image backgroundImage;
    Map<Component, Integer> tabOrderMap = new HashMap<>(0);

    public wfPanel(Pane wp) {
        super(null); // That's what winforms use.
        form = wp;
        setFocusTraversalPolicy(new SortingFocusTraversalPolicy(new Comparator<>() {
            @Override
            public int compare(Component o1, Component o2) {
                return tabOrderMap.get(o1).compareTo(tabOrderMap.get(o2));
            }
        }) {
            @Override
            protected boolean accept(Component component) {
                return tabOrderMap.containsKey(component);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage.asSwingImage(), 0, 0, getWidth(), getHeight(), null);
        }
    }

    public void setFocusOrder(Component c, int i) {
        if (i == -1) {
            tabOrderMap.remove(c);
        } else {
            tabOrderMap.put(c, i);
        }
    }

    public void add(Control wc) {
        if (wc instanceof org.winforms.widget.Button) {
            handleDialogResult((org.winforms.widget.Button) wc);
        }
        Component c = wc.asSwingObject();
        add(c);
        setFocusOrder(c, wc.getTabIndex());
        c.addMouseListener(wc.getMouseListener());
    }

    public void addAll(Collection<? extends Control> c) {
        for (Control wc : c) {
            add(wc);
        }
    }

    public void addAll(Control... coll) {
        for (Control Control : coll) {
            add(Control);
        }
    }

    void handleDialogResult(Button b) {
        if (b.dialogResult != null) {
            b.setClick(new ChainedEventHandler<>(b.click) {
                @Override
                public void instanceHandle(Object sender, EventData e) {
                    form.setResult(b.dialogResult);
                    form.dispose();
                }
            });
        }
    }
}
