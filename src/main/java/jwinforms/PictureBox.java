package jwinforms;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import jwinforms.enums.BorderStyle;


public class PictureBox extends WinformControl implements ISupportInitialize {
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
  @SuppressWarnings("deprecation")
  public void setBorderStyle(BorderStyle borderStyle) {
    switch(borderStyle) {
      case FixedSingle:
        asJLabel().setBorder(BorderFactory.createLineBorder(Color.black, 1));
        break;
      default:
        throw new Error();
    }
  }

  private SpecialImageJLabel asJLabel() {
    return ((SpecialImageJLabel)swingVersion);
  }

  public void Refresh() {
    asJLabel().repaint();
  }

  public void setImage(WfImage image) {
    if(image != null) {
      asJLabel().setIcon(new ImageIcon(image.asSwingImage()));
    }
  }

  public void setMouseDown(EventHandler<Object, MouseEventArgs> mouseDown) {
    mouseListener.pressed = mouseDown;
  }

  public void setPaint(EventHandler<Object, PaintEventArgs> paint) {
    if(asJLabel().paintEventHandler != null) {
      throw new Error("2 handlers same event");
    }
    asJLabel().paintEventHandler = paint;
  }
}
