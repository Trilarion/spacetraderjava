package org.winforms.image;

import org.winforms.widget.PictureBox;
import org.winforms.event.EventHandler;

import javax.swing.*;
import java.awt.*;


/**
 * A utility class with fields and methods for managing the details of a JLabel descendant.
 *
 * @author Gregory
 */
public class ImageLabel extends JLabel {  // TODO better name and documentation of usage

    private static final long serialVersionUID = 1L;
    public EventHandler<Object, org.winforms.util.Graphics> paintEventHandler;
    public PictureBox pictureBox;
    public Color background;

    @Override
    public void paintComponent(java.awt.Graphics graphics) {
        tryBackground(background, graphics);
        tryEventHandler(paintEventHandler, graphics);
        super.paintComponent(graphics);
    }

    private void tryBackground(Color background, java.awt.Graphics graphics) {
        if (background == null) {
            return;
        }
        graphics.setColor(background);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void tryEventHandler(EventHandler<Object, org.winforms.util.Graphics> handler, java.awt.Graphics graphics) {
        if (handler != null) {
            handler.handle(pictureBox, new org.winforms.util.Graphics(graphics));
        }
    }
}
