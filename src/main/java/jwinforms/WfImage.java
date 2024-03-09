package jwinforms;
import java.awt.Color;
import java.awt.Image;


abstract public class WfImage {
  abstract public Image asSwingImage();

  abstract public int getHeight();

  abstract public int getWidth();

  abstract public void setTransparentColor(Color transparentColor);
}
