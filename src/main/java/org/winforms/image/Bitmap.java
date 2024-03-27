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

    public Bitmap(final Image source) {
        image = ((Bitmap) source).image;  // TODO casts necessary?
        imageUrl = ((Bitmap) source).imageUrl;
    }

    public Bitmap(final String fileName) { // TODO move the reading of the Image to some static helper class
        try {
            final File input = new File(fileName);
            imageUrl = input.toURI().toURL();
            image = ImageIO.read(input);
        } catch (final IOException e) {
            throw new Error(e);
        }
    }

    public Bitmap(final URL imageUrl) {
        try {
            this.imageUrl = imageUrl;
            image = ImageIO.read(imageUrl);
        } catch (final IOException e) {
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
    public void setTransparentColor(final Color transparentColor) {
        if (transSet) {
            throw new Error("setTransparentColor called twice");
        }
        transSet = true;
        if (transparentColor == null) {
            return;
        }
        // Don't yet support all colors.
        if (!transparentColor.equals(Color.white)) {
            final BufferedImage bi = (BufferedImage) asSwingImage();
            final int[] pixel = bi.getRaster().getPixel(0, 0, new int[4]);
            System.out.print("Trying to set unknown background: color at 0x0:");
            for (final int i : pixel) {
                System.out.print(" " + i);
            }
            System.out.println();
            //		throw new Error("This bg color not yet supported");
            return;
        }
        final int transparent = 0;
        this.transparent = transparentColor;
        final BufferedImage bufferedImage = (BufferedImage) asSwingImage();
        final BufferedImage newImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        final int[] arr = new int[1];
        final WritableRaster raster1 = bufferedImage.getRaster();
        final WritableRaster raster2 = newImage.getRaster();
        final ColorTranslate translate = new ColorTranslate(bufferedImage.getColorModel(), transparent);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                raster1.getPixel(x, y, arr);
                raster2.setPixel(x, y, translate.translate(arr[0]));
            }
        }

        image = newImage;
    }

    private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        image = ImageIO.read(imageUrl);
        setTransparentColor(transparent);
    }

    public int toArgb(final int col, final int row) {
        // note that alpha is ignored.
        return image.getRGB(col, row);
    }
}
