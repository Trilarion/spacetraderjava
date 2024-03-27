package org.winforms.style;

import java.awt.*;


public enum FontStyle {
    Bold(Font.BOLD),
    Italics(Font.ITALIC),
    Regular(Font.PLAIN);
    public final int awtFontstyle;

    FontStyle(final int i) {
        awtFontstyle = i;
    }
}
