package org.winforms.mouse;

import org.winforms.event.EventData;
import org.winforms.event.EventHandler;
import org.winforms.event.MouseEventData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO documentation of usage
public class MouseListener extends MouseAdapter {
    private final EventHandler<Object, EventData> normalClick;
    private final EventHandler<Object, EventData> doubleClick;
    private final Object sender;

    public MouseListener(final Object o, final EventHandler<Object, EventData> e1, final EventHandler<Object, EventData> e2) {
        sender = o;
        normalClick = e1;
        doubleClick = e2;
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
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
