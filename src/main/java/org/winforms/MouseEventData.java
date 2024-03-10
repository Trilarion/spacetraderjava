package org.winforms;

import java.awt.event.MouseEvent;


public class MouseEventData extends EventData {
    public final MouseButtons Button;
    public final int X, Y;

    public MouseEventData(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
        Button = findMouseButton(e.getButton());
    }

    private MouseButtons findMouseButton(int button) {
        switch (button) {
            case MouseEvent.BUTTON1:
                return MouseButtons.Left;
            case MouseEvent.BUTTON2:
                return MouseButtons.Right;
            default:
                throw new Error("Unknown mouse button: " + button);
        }
    }
}
