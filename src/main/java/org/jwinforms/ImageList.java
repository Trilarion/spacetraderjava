package org.jwinforms;

import java.awt.*;
import java.awt.image.ColorModel;
import java.util.ArrayList;


public class ImageList {
    public Object ColorDepth;
    private WfImage[] images;
    private FormSize size;

    public ImageList(IContainer components) {
    }

    public void Draw(Graphics graphics, int x, int y, int imageIndex) {
        graphics.DrawImage(images[imageIndex], x, y, new Rectangle(0, 0, size.width, size.height), 0);
    }

    public WfImage[] getImages() {
        return images;
    }

    public void setImageStream(ImageListStreamer imageStream) {
        ArrayList<WfImage> al = new ArrayList<WfImage>();
        for (WfImage image : imageStream.images) {
            al.add(image);
        }
        images = al.toArray(new WfImage[0]);
    }

    public void setTransparentColor(Color transparentColor) {
        for (WfImage image : images) {
            image.setTransparentColor(transparentColor);
        }
    }

    public void setImageSize(FormSize imageSize) {
        size = imageSize;
    }
}


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
