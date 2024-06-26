package org.winforms.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URL;

// TODO documentation of usage
public class Bitmap extends Image implements Icon, Serializable {

    private static final long serialVersionUID = 2134761799614301086L;
    final URL imageUrl;
    transient BufferedImage image;
    transient boolean transSet;
    Color transparent;

    public Bitmap(Image source) {
        image = ((Bitmap) source).image;  // TODO casts necessary?
        imageUrl = ((Bitmap) source).imageUrl;
    }

    public Bitmap(String fileName) { // TODO move the reading of the Image to some static helper class
        try {
            File input = new File(fileName);
            imageUrl = input.toURI().toURL();
            image = ImageIO.read(input);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public Bitmap(URL imageUrl) {
        try {
            this.imageUrl = imageUrl;
            image = ImageIO.read(imageUrl);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    @Override
    public java.awt.Image asSwingImage() {
        return image;
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public void setTransparentColor(Color transparentColor) {
        if (transSet) {
            throw new Error("setTransparentColor called twice");
        }
        transSet = true;
        if (transparentColor == null) {
            return;
        }
        // Don't yet support all colors.
        if (!transparentColor.equals(Color.white)) {
            BufferedImage bi = (BufferedImage) asSwingImage();
            int[] pixel = bi.getRaster().getPixel(0, 0, new int[4]);
            System.out.print("Trying to set unknown background: color at 0x0:");
            for (int i : pixel) {
                System.out.print(" " + i);
            }
            System.out.println();
            //		throw new Error("This bg color not yet supported");
            return;
        }
        final int transparent = 0;
        this.transparent = transparentColor;
        BufferedImage bufferedImage = (BufferedImage) asSwingImage();
        BufferedImage newImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        int[] arr = new int[1];
        WritableRaster raster1 = bufferedImage.getRaster();
        WritableRaster raster2 = newImage.getRaster();
        ColorTranslate translate = new ColorTranslate(bufferedImage.getColorModel(), transparent);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                raster1.getPixel(x, y, arr);
                raster2.setPixel(x, y, translate.translate(arr[0]));
            }
        }

        image = newImage;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        image = ImageIO.read(imageUrl);
        setTransparentColor(transparent);
    }

    public int toArgb(int col, int row) {
        // note that alpha is ignored.
        return image.getRGB(col, row);
    }
}
