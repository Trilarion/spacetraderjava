package org.winforms;

import java.awt.Graphics;

// TODO documentation of usage
public class PaintEventData extends EventData {
    public final org.winforms.Graphics Graphics;

    public PaintEventData(org.winforms.Graphics graphics) {
        Graphics = graphics;
    }

    public PaintEventData(Graphics awtGraphics) {
        this(new org.winforms.Graphics(awtGraphics));
    }
}
