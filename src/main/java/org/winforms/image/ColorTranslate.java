package org.winforms.image;

import java.awt.image.ColorModel;

// TODO documentation
public class ColorTranslate {
    private final static int[] transparent = {0, 0, 0, 0};
    public ColorModel model;
    public int reference;

    public ColorTranslate(ColorModel model, int reference) {
        this.model = model;
        this.reference = reference;
    }

    int[] translate(int pixel) {
        if (pixel == reference) {
            return ColorTranslate.transparent;
        } else {
            return new int[]{model.getRed(pixel), model.getGreen(pixel), model.getBlue(pixel), 255};
        }
    }
}
