package org.jwinforms;

import java.awt.*;


abstract public class WfImage {
    abstract public Image asSwingImage();

    abstract public int getHeight();

    abstract public int getWidth();

    abstract public void setTransparentColor(Color transparentColor);
}
