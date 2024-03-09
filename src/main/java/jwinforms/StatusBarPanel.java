package jwinforms;
import java.awt.Dimension;
import jwinforms.enums.StatusBarPanelAutoSize;
import swingextra.JStatusBarSection;


public class StatusBarPanel implements ISupportInitialize {
  private JStatusBarSection jpanel = new JStatusBarSection(" ");
  public final StatusBarPanelAutoSize AutoSize;

  public StatusBarPanel() {
    this(StatusBarPanelAutoSize.None);
  }

  public StatusBarPanel(StatusBarPanelAutoSize autoSize) {
    AutoSize = autoSize;
  }

  public void setText(String text) {
    if(text.isEmpty()) {
      text = "  ";
    }
    jpanel.setText(text);
  }

  public void setWidth(int w) {
    int h = jpanel.getHeight();
    jpanel.setSize(w, h);
  }

  public JStatusBarSection asJStatusBarSection() {
    return jpanel;
  }

  public void setMinWidth(int width) {
    int height = jpanel.getPreferredSize().height;
    jpanel.setPreferredSize(new Dimension(width, height));
    jpanel.setMinimumSize(new Dimension(width, height));
  }

  @Override
  public void BeginInit() {
    // TODO Auto-generated method stub
  }

  @Override
  public void EndInit() {
    // TODO Auto-generated method stub
  }
}
