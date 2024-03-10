package org.winforms;

import java.awt.image.ColorModel;

class ColorTranslate {
    private final static int[] transparent = new int[]{0, 0, 0, 0};
    public ColorModel model;
    public int reference;

    public ColorTranslate(ColorModel model, int reference) {
        this.model = model;
        this.reference = reference;
    }

    int[] translate(int pixel) {
        if (pixel == reference) {
            return transparent;
        } else {
            return new int[]{model.getRed(pixel), model.getGreen(pixel), model.getBlue(pixel), 255};
        }
    }
}
