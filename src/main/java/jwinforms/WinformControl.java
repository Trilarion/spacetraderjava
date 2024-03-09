package jwinforms;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseListener;
import jwinforms.enums.BorderStyle;


public class WinformControl implements ISupportInitialize {
  protected final Component swingVersion;
  private String Name;
  private Color ForeColor;
  private int tabIndex;
  EventHandler<Object, EventArgs> click;
  EventHandler<Object, EventArgs> doubleClick;
  private Color BackColor;

  public void setDoubleClick(EventHandler<Object, EventArgs> doubleClick) {
    this.doubleClick = doubleClick;
  }

  public MouseListener getMouseListener() {
    return new WinformMouseListener(this, click, doubleClick);
  }

  public int getTabIndex() {
    return tabIndex;
  }

  @Deprecated
  public WinformControl() {
    this(null);
  }

  public WinformControl(Component swingVersion) {
    super();
    this.swingVersion = swingVersion;
  }

  public Component asSwingObject() {
    return swingVersion;
  }

  public Color getBackColor() {
    return BackColor;
  }

  /**
   * @todo not really deprecated, just doesn't work.
   * @param backColor
   */
  public void setBackColor(Color backColor) {
    BackColor = backColor;
  }

  public jwinforms.Font getFont() {
    Font font = swingVersion.getFont();
    return font == null ? null : new jwinforms.Font(font);
  }

  public Color getForeColor() {
    return ForeColor;
  }

  public int getHeight() {
    return getSize().height;
  }

  public int getLeft() {
    return swingVersion.getLocation().x;
  }

  public String getName() {
    return Name;
  }

  public int getTop() {
    return swingVersion.getLocation().y;
  }

  public boolean getVisible() {
    return swingVersion.isVisible();
  }

  public int getWidth() {
    return getSize().width;
  }

  public void ResumeLayout(boolean b) {
    // TODO Auto-generated method stub
  }

  public void setAutoSize(boolean autoSize) {
    // /TODO impl.
  }

  @Deprecated
  public void setBorderStyle(BorderStyle borderStyle) {
  }

  public void setClick(EventHandler<Object, EventArgs> click) {
    this.click = click;
  }

  public void setEnabled(boolean enabled) {
    swingVersion.setEnabled(enabled);
  }

  public void setEnter(EventHandler<Object, EventArgs> enter) {
  }

  public void setFont(Font font) {
    swingVersion.setFont(font);
  }

  public void setForeColor(Color foreColor) {
    ForeColor = foreColor;
  }

  public void setHeight(int height) {
    Dimension size = (Dimension)getSize().clone();
    size.height = height;
    setSize(size);
  }

  public void setLeft(int left) {
    Point location = (Point)swingVersion.getLocation().clone();
    location.x = left;
    swingVersion.setLocation(location);
  }

  public void setLocation(Point location) {
    swingVersion.setLocation(location);
  }

  public void setMouseEnter(EventHandler<Object, EventArgs> mouseEnter) {
  }

  public void setMouseLeave(EventHandler<Object, EventArgs> mouseLeave) {
  }

  /**
   * I think this is nothing.
   *
   * @param name
   */
  public void setName(String name) {
    Name = name;
  }

  public void setSize(Dimension size) {
    swingVersion.setPreferredSize(size);
    swingVersion.setSize(size);
  }

  Dimension getSize() {
    return swingVersion.getPreferredSize();
  }

  public void setTabIndex(int tabIndex) {
    this.tabIndex = tabIndex;
  }

  public void setTabStop(boolean tabStop) {
    swingVersion.setFocusable(tabStop);
  }

  public void setTop(int top) {
    Point location = (Point)swingVersion.getLocation().clone();
    location.y = top;
    swingVersion.setLocation(location);
  }

  public void setVisible(boolean visible) {
    swingVersion.setVisible(visible);
  }

  public void setWidth(int width) {
    Dimension size = (Dimension)getSize().clone();
    size.width = width;
    setSize(size);
  }

  public void SuspendLayout() {
    // TODO Auto-generated method stub
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
