package org.winforms;

import java.awt.*;

// TODO is this needed, can it be replaced by Dimension
public class SizeF extends Dimension {
    private static final long serialVersionUID = 1L;

    public SizeF(int height, int width) {
        super(width, height);
    }  // TODO attention, order of width and height mixed up
}
