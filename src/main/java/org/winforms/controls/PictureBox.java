package org.winforms.controls;

import org.winforms.EventHandler;
import org.winforms.Graphics;
import org.winforms.ImageLabel;
import org.winforms.ImageMouseListener;
import org.winforms.MouseEventData;
import org.winforms.enums.BorderStyle;
import org.winforms.enums.PictureBoxSizeMode;

import javax.swing.*;
import java.awt.*;

// TODO documentation of usage
public class PictureBox extends Control<ImageLabel> {

    private final ImageMouseListener mouseListener;
    public PictureBoxSizeMode SizeMode;

    public PictureBox() {
        super(new ImageLabel());
        asJLabel().pictureBox = PictureBox.this;
        mouseListener = new ImageMouseListener(PictureBox.this);
        asJLabel().addMouseListener(mouseListener);
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        asJLabel().background = backgroundColor;
    }

    @Override
    public void setBorderStyle(BorderStyle borderStyle) {
        switch (borderStyle) {
            case FixedSingle:
                asJLabel().setBorder(BorderFactory.createLineBorder(Color.black, 1));
                break;
            default:
                throw new Error();
        }
    }

    private ImageLabel asJLabel() {
        return ((ImageLabel) swingComponent);
    }

    public void refresh() {
        asJLabel().repaint();
    }

    public void setImage(org.winforms.Image image) {
        if (null != image) {
            asJLabel().setIcon(new ImageIcon(image.asSwingImage()));
        }
    }

    public void setMouseDown(EventHandler<Object, MouseEventData> mouseDown) {
        mouseListener.pressed = mouseDown;
    }

    public void setPaint(EventHandler<Object, Graphics> paint) {
        if (null != asJLabel().paintEventHandler) {
            throw new Error("2 handlers same event");
        }
        asJLabel().paintEventHandler = paint;
    }
}
