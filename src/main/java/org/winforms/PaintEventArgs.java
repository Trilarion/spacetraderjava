package org.winforms;

import java.awt.Graphics;


public class PaintEventArgs extends EventArgs {
    public final org.winforms.Graphics Graphics;

    public PaintEventArgs(org.winforms.Graphics graphics) {
        Graphics = graphics;
    }

    public PaintEventArgs(Graphics awtGraphics) {
        this(new org.winforms.Graphics(awtGraphics));
    }
}
