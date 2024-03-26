package org.winforms;

import org.winforms.controls.PictureBox;
import org.winforms.events.EventHandler;

import javax.swing.*;
import java.awt.*;


/**
 * A utility class with fields and methods for managing the details of a JLabel descendant.
 *
 * @author Gregory
 */
public class ImageLabel extends JLabel {  // TODO better name and documentation of usage

    private static final long serialVersionUID = 1L;
    public EventHandler<Object, Graphics> paintEventHandler;
    public PictureBox pictureBox;
    public Color background;

    @Override
    public void paintComponent(java.awt.Graphics graphics) {
        tryBackground(background, graphics);
        tryEventHandler(paintEventHandler, graphics);
        super.paintComponent(graphics);
    }

    private void tryBackground(Color background, java.awt.Graphics graphics) {
        if (null == background) {
            return;
        }
        graphics.setColor(background);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void tryEventHandler(EventHandler<Object, Graphics> handler, java.awt.Graphics graphics) {
        if (null != handler) {
            handler.handle(pictureBox, new Graphics(graphics));
        }
    }
}
