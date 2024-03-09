package org.jwinforms;

import java.awt.Graphics;


public class PaintEventArgs extends EventArgs {
    public final org.jwinforms.Graphics Graphics;

    public PaintEventArgs(org.jwinforms.Graphics graphics) {
        Graphics = graphics;
    }

    public PaintEventArgs(Graphics awtGraphics) {
        this(new org.jwinforms.Graphics(awtGraphics));
    }
}
