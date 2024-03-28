package org.winforms.util;

import org.winforms.style.FontStyle;

public class Font extends java.awt.Font {

    private static final long serialVersionUID = 1L;
    public final String fontFamily;
    public final String fontName;

    public Font(String fontName, float size) {
        this(fontName, FontStyle.Regular, size);
    }

    public Font(String fontName, FontStyle style, float size) {
        super(fontName, style.awtFontstyle, (int) (size * 1.3));
        this.fontName = getName();
        fontFamily = getFamily();
    }

    public Font(java.awt.Font source) {
        super(source);
        fontName = getName();
        fontFamily = getFamily();
    }
}
