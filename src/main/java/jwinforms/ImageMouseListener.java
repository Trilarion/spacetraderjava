package jwinforms;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * A utility class with fields and methods for managing the details of a MouseAdapter class.
 * @author Gregory
 */
class ImageMouseListener extends MouseAdapter {
  private final PictureBox pictureBox;
  public EventHandler<Object, MouseEventArgs> pressed;

  ImageMouseListener(PictureBox pictureBox) {
    this.pictureBox = pictureBox;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    tryEvent(pressed, new MouseEventArgs(e));
  }

  private void tryEvent(EventHandler<Object, MouseEventArgs> handler, MouseEventArgs e) {
    if(handler != null) {
      handler.handle(pictureBox, e);
    }
  }
}
