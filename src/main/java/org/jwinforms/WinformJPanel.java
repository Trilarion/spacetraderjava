package org.jwinforms;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class WinformJPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final WinformPane form;
    Map<Component, Integer> tabOrderMap = new HashMap<Component, Integer>(0);
    WfImage BackgroundImage = null;

    public WinformJPanel(WinformPane wp) {
        super(null); // That's what winforms use.
        form = wp;
        setFocusTraversalPolicy(new SortingFocusTraversalPolicy(new Comparator<Component>() {
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

    public void add(final WinformControl wc) {
        if (wc instanceof Button) {
            handleDialogResult((Button) wc);
        }
        Component c = wc.asSwingObject();
        add(c);
        setFocusOrder(c, wc.getTabIndex());
        c.addMouseListener(wc.getMouseListener());
    }

    public void addAll(Collection<? extends WinformControl> c) {
        for (WinformControl wc : c) {
            this.add(wc);
        }
    }

    public void addAll(WinformControl... coll) {
        for (WinformControl winformControl : coll) {
            this.add(winformControl);
        }
    }

    void handleDialogResult(final Button b) {
        if (b.DialogResult != null) {
            b.setClick(new ChainedEventHandler<Object, EventArgs>(b.click) {
                @Override
                public void instanceHandle(Object sender, EventArgs e) {
                    form.setResult(b.DialogResult);
                    form.dispose();
                }
            });
        }
    }
}
