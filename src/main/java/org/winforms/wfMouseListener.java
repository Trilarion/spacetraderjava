package org.winforms;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class wfMouseListener extends MouseAdapter {
    private final EventHandler<Object, EventArgs> normalClick;
    private final EventHandler<Object, EventArgs> doubleClick;
    private final Object sender;

    public wfMouseListener(Object o, EventHandler<Object, EventArgs> e1, EventHandler<Object, EventArgs> e2) {
        sender = o;
        normalClick = e1;
        doubleClick = e2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getClickCount()) {
            case 1:
                if (normalClick != null) {
                    normalClick.handle(sender, new MouseEventArgs(e));
                }
                break;
            case 2:
            case 3:
                if (doubleClick != null) {
                    doubleClick.handle(sender, new MouseEventArgs(e));
                }
                break;
            default:
                // ignore?
        }
    }
}
