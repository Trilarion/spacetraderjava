package org.winforms.util;

import org.winforms.style.FontStyle;

public class Font extends java.awt.Font {

    private static final long serialVersionUID = 1L;
    public final String fontFamily;
    public final String fontName;

    public Font(final String fontName, final float size) {
        this(fontName, FontStyle.Regular, size);
    }

    public Font(final String fontName, final FontStyle style, final float size) {
        super(fontName, style.awtFontstyle, (int) (size * 1.3));
        this.fontName = getName();
        fontFamily = getFamily();
    }

    public Font(final java.awt.Font source) {
        super(source);
        fontName = getName();
        fontFamily = getFamily();
    }
}
