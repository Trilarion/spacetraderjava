package org.jwinforms.enums;

import java.awt.*;


public enum FontStyle {
    Bold(Font.BOLD),
    Italics(Font.ITALIC),
    Regular(Font.PLAIN);
    public final int awtFontstyle;

    FontStyle(int i) {
        awtFontstyle = i;
    }
}
