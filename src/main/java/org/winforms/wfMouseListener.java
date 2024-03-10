package org.winforms;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO documentation of usage
public class wfMouseListener extends MouseAdapter {
    private final EventHandler<Object, EventData> normalClick;
    private final EventHandler<Object, EventData> doubleClick;
    private final Object sender;

    public wfMouseListener(Object o, EventHandler<Object, EventData> e1, EventHandler<Object, EventData> e2) {
        sender = o;
        normalClick = e1;
        doubleClick = e2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getClickCount()) {
            case 1:
                if (normalClick != null) {
                    normalClick.handle(sender, new MouseEventData(e));
                }
                break;
            case 2:
            case 3:
                if (doubleClick != null) {
                    doubleClick.handle(sender, new MouseEventData(e));
                }
                break;
            default:
                // ignore?
        }
    }
}
