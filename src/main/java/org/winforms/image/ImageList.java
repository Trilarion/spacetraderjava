package org.winforms.image;

import org.winforms.util.Graphics;
import org.winforms.util.Rectangle;

import java.awt.*;
import java.util.ArrayList;

// TODO document implementation and usage
public class ImageList {
    public Object colorDepth;
    private Image[] images;
    private Dimension size;

    public void draw(Graphics graphics, int x, int y, int imageIndex) {
        graphics.drawImage(images[imageIndex], x, y, new Rectangle(0, 0, size.width, size.height));
    }

    public Image[] getImages() {
        return images;
    }

    public void setImageStream(ImageListStreamer imageStream) {
        ArrayList<Image> al = new ArrayList<>();
        for (Image image : imageStream.images) {
            al.add(image);
        }
        images = al.toArray(new Image[0]);
    }

    public void setTransparentColor(Color transparentColor) {
        for (Image image : images) {
            image.setTransparentColor(transparentColor);
        }
    }

    public void setImageSize(Dimension imageSize) {
        size = imageSize;
    }
}


