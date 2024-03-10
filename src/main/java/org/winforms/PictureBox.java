package org.winforms;

import org.winforms.enums.BorderStyle;
import org.winforms.enums.PictureBoxSizeMode;

import javax.swing.*;
import java.awt.*;

// TODO documentation of usage
public class PictureBox extends wfControl implements ISupportInitialize {
    public PictureBoxSizeMode SizeMode;
    private ImageMouseListener mouseListener;

    public PictureBox() {
        super(new SpecialImageJLabel());
        asJLabel().pictureBox = PictureBox.this;
        mouseListener = new ImageMouseListener(PictureBox.this);
        asJLabel().addMouseListener(mouseListener);
    }

    @Override
    public void setBackColor(Color backColor) {
        asJLabel().background = backColor;
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

    private SpecialImageJLabel asJLabel() {
        return ((SpecialImageJLabel) swingComponent);
    }

    public void Refresh() {
        asJLabel().repaint();
    }

    public void setImage(wfImage image) {
        if (image != null) {
            asJLabel().setIcon(new ImageIcon(image.asSwingImage()));
        }
    }

    public void setMouseDown(EventHandler<Object, MouseEventData> mouseDown) {
        mouseListener.pressed = mouseDown;
    }

    public void setPaint(EventHandler<Object, PaintEventData> paint) {
        if (asJLabel().paintEventHandler != null) {
            throw new Error("2 handlers same event");
        }
        asJLabel().paintEventHandler = paint;
    }
}
