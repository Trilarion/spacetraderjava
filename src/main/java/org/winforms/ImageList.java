package org.winforms;

import java.awt.*;
import java.util.ArrayList;


public class ImageList {
    public Object ColorDepth;
    private wfImage[] images;
    private SizeF size;

    public ImageList() {
    }

    public void Draw(Graphics graphics, int x, int y, int imageIndex) {
        graphics.DrawImage(images[imageIndex], x, y, new Rectangle(0, 0, size.width, size.height), 0);
    }

    public wfImage[] getImages() {
        return images;
    }

    public void setImageStream(ImageListStreamer imageStream) {
        ArrayList<wfImage> al = new ArrayList<>();
        for (wfImage image : imageStream.images) {
            al.add(image);
        }
        images = al.toArray(new wfImage[0]);
    }

    public void setTransparentColor(Color transparentColor) {
        for (wfImage image : images) {
            image.setTransparentColor(transparentColor);
        }
    }

    public void setImageSize(SizeF imageSize) {
        size = imageSize;
    }
}


