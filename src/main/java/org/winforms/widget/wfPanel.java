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

    public wfPanel(final Pane wp) {
        super(null); // That's what winforms use.
        form = wp;
        setFocusTraversalPolicy(new SortingFocusTraversalPolicy(new Comparator<>() {
            @Override
            public int compare(final Component o1, final Component o2) {
                return tabOrderMap.get(o1).compareTo(tabOrderMap.get(o2));
            }
        }) {
            @Override
            protected boolean accept(final Component component) {
                return tabOrderMap.containsKey(component);
            }
        });
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage.asSwingImage(), 0, 0, getWidth(), getHeight(), null);
        }
    }

    public void setFocusOrder(final Component c, final int i) {
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
        final Component c = wc.asSwingObject();
        add(c);
        setFocusOrder(c, wc.getTabIndex());
        c.addMouseListener(wc.getMouseListener());
    }

    public void addAll(final Collection<? extends Control> c) {
        for (final Control wc : c) {
            add(wc);
        }
    }

    public void addAll(final Control... coll) {
        for (final Control Control : coll) {
            add(Control);
        }
    }

    void handleDialogResult(Button b) {
        if (b.dialogResult != null) {
            b.setClick(new ChainedEventHandler<>(b.click) {
                @Override
                public void instanceHandle(final Object sender, final EventData e) {
                    form.setResult(b.dialogResult);
                    form.dispose();
                }
            });
        }
    }
}
