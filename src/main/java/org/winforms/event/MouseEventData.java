package org.winforms.event;

import org.winforms.mouse.MouseButtons;

import java.awt.event.MouseEvent;


public class MouseEventData implements EventData {
    public final MouseButtons button;
    public final int x, y;

    public MouseEventData(final MouseEvent e) {

        x = e.getX();
        y = e.getY();

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                button = MouseButtons.Left;
                break;
            case MouseEvent.BUTTON2:
                button = MouseButtons.Right;
                break;
            default:
                throw new RuntimeException("Unknown mouse button: " + e.getButton());
        }
    }

}
