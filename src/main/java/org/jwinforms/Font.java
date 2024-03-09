package org.jwinforms;

import org.jwinforms.enums.FontStyle;

public class Font extends java.awt.Font {
    private static final long serialVersionUID = 1L;
    public final String FontFamily;
    public final String Name;

    public Font(String name, float size) {
        this(name, FontStyle.Regular, size);
    }

    public Font(String name, float size, FontStyle style, int point, int b) {
        this(name, style, (int) size);
    }

    private Font(String name, FontStyle style, float size) {
        super(name, style.awtFontstyle, (int) (size * 1.3));
        Name = getName();
        FontFamily = getFamily();
    }

    Font(java.awt.Font source) {
        super(source);
        Name = getName();
        FontFamily = getFamily();
    }
}
