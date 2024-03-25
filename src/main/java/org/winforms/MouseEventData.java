package org.winforms;

import org.winforms.enums.MouseButtons;

import java.awt.event.MouseEvent;


public class MouseEventData implements EventData {
    public final MouseButtons button;
    public final int x, y;

    public MouseEventData(MouseEvent e) {

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
