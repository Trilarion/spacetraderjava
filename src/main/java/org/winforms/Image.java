package org.winforms;

import java.awt.*;

// TODO why abstract, wants to be an Interface instead?
abstract public class Image {
    abstract public java.awt.Image asSwingImage();

    abstract public int getHeight();

    abstract public int getWidth();

    abstract public void setTransparentColor(Color transparentColor);
}
