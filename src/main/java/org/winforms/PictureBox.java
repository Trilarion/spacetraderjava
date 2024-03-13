package org.winforms;

import org.winforms.enums.BorderStyle;
import org.winforms.enums.PictureBoxSizeMode;

import javax.swing.*;
import java.awt.*;

// TODO documentation of usage
public class PictureBox extends Control {
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

    public void setImage(Image image) {
        if (image != null) {
            asJLabel().setIcon(new ImageIcon(image.asSwingImage()));
        }
    }

    public void setMouseDown(EventHandler<Object, MouseEventData> mouseDown) {
        mouseListener.pressed = mouseDown;
    }

    public void setPaint(EventHandler<Object, Graphics> paint) {
        if (asJLabel().paintEventHandler != null) {
            throw new Error("2 handlers same event");
        }
        asJLabel().paintEventHandler = paint;
    }
}
