package org.winforms;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;


/**
 * A utility class with fields and methods for managing the details of a JLabel descendant.
 *
 * @author Gregory
 */
class SpecialImageJLabel extends JLabel {  // TODO better name and documentation of usage
    private static final long serialVersionUID = 1L;
    EventHandler<Object, PaintEventData> paintEventHandler;
    PictureBox pictureBox;
    Color background;

    @Override
    public void paintComponent(Graphics graphics) {
        tryBackground(background, graphics);
        tryEventHandler(paintEventHandler, graphics);
        super.paintComponent(graphics);
    }

    private void tryBackground(Color background, Graphics graphics) {
        if (background == null) {
            return;
        }
        graphics.setColor(background);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void tryEventHandler(EventHandler<Object, PaintEventData> handler, Graphics graphics) {
        if (handler != null) {
            handler.handle(pictureBox, new PaintEventData(graphics));
        }
    }
}
