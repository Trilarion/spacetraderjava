package org.winforms;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// TODO documentation of usage
public class wfPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private final wfPane form;
    Map<Component, Integer> tabOrderMap = new HashMap<>(0);
    wfImage BackgroundImage = null;

    public wfPanel(wfPane wp) {
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
        if (BackgroundImage != null) {
            g.drawImage(BackgroundImage.asSwingImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    public void setFocusOrder(Component c, int i) {
        if (i == -1) {
            tabOrderMap.remove(c);
        } else {
            tabOrderMap.put(c, i);
        }
    }

    public void add(final wfControl wc) {
        if (wc instanceof Button) {
            handleDialogResult((Button) wc);
        }
        Component c = wc.asSwingObject();
        add(c);
        setFocusOrder(c, wc.getTabIndex());
        c.addMouseListener(wc.getMouseListener());
    }

    public void addAll(Collection<? extends wfControl> c) {
        for (wfControl wc : c) {
            this.add(wc);
        }
    }

    public void addAll(wfControl... coll) {
        for (wfControl wfControl : coll) {
            this.add(wfControl);
        }
    }

    void handleDialogResult(final Button b) {
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
