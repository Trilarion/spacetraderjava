package org.winforms.widget;

import org.winforms.util.Graphics;
import org.winforms.image.ImageLabel;
import org.winforms.image.ImageMouseListener;
import org.winforms.image.Image;
import org.winforms.style.BorderStyle;
import org.winforms.image.PictureBoxSizeMode;
import org.winforms.event.EventHandler;
import org.winforms.event.MouseEventData;

import javax.swing.*;
import java.awt.*;

// TODO documentation of usage
public class PictureBox extends Control<ImageLabel> {

    private final ImageMouseListener mouseListener;
    public PictureBoxSizeMode SizeMode;

    public PictureBox() {
        super(new ImageLabel());
        asJLabel().pictureBox = this;
        mouseListener = new ImageMouseListener(this);
        asJLabel().addMouseListener(mouseListener);
    }

    @Override
    public void setBackgroundColor(final Color backgroundColor) {
        asJLabel().background = backgroundColor;
    }

    @Override
    public void setBorderStyle(final BorderStyle borderStyle) {
        switch (borderStyle) {
            case FixedSingle:
                asJLabel().setBorder(BorderFactory.createLineBorder(Color.black, 1));
                break;
            default:
                throw new Error();
        }
    }

    private ImageLabel asJLabel() {
        return swingComponent;
    }

    public void refresh() {
        asJLabel().repaint();
    }

    public void setImage(final Image image) {
        if (image != null) {
            asJLabel().setIcon(new ImageIcon(image.asSwingImage()));
        }
    }

    public void setMouseDown(final EventHandler<Object, MouseEventData> mouseDown) {
        mouseListener.pressed = mouseDown;
    }

    public void setPaint(final EventHandler<Object, Graphics> paint) {
        if (asJLabel().paintEventHandler != null) {
            throw new Error("2 handlers same event");
        }
        asJLabel().paintEventHandler = paint;
    }
}
