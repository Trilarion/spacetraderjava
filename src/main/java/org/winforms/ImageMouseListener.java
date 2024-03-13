package org.winforms;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * A utility class with fields and methods for managing the details of a MouseAdapter class.
 *
 * @author Gregory
 */
class ImageMouseListener extends MouseAdapter {

    private final PictureBox pictureBox;
    public EventHandler<Object, MouseEventData> pressed;

    ImageMouseListener(PictureBox pictureBox) {
        this.pictureBox = pictureBox;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        tryEvent(pressed, new MouseEventData(e));
    }

    private void tryEvent(EventHandler<Object, MouseEventData> handler, MouseEventData e) {
        if (handler != null) {
            handler.handle(pictureBox, e);
        }
    }
}
