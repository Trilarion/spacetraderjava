package jwinforms;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;


public class WinformWindow extends WinformControl implements WinformPane {
  private final JFrame frame;
  private final WinformJPanel panel;
  protected final WinformJPanel Controls;
  DialogResult result;
  protected Integer Left, Top;
  protected FormWindowState WindowState;
  // Must encapsulate most of these.
  private FormSize AutoScaleBaseSize;
  private FormBorderStyle FormBorderStyle;
  private Icon Icon;
  private boolean ControlBox;
  private boolean MinimizeBox;
  private boolean MaximizeBox;
  private EventHandler<Object, CancelEventArgs> Closing;
  private String Title;
  private EventHandler<Object, EventArgs> onLoad;

  public WinformWindow() {
    // super(new WinformJPanel());
    super(new JFrame());
    frame = (JFrame)swingVersion;
    // panel = (WinformJPanel)swingVersion;
    panel = new WinformJPanel(this);
    frame.getContentPane().add(panel, BorderLayout.CENTER);
    Controls = panel;
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  // ///////////// implementation ends here.

  protected enum FormWindowState {
    Normal
  }

  public void ShowWindow() {
    EventHandler<Object, EventArgs> loadHandler = onLoad;
    if(loadHandler != null) {
      loadHandler.handle(this, null);
    }
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fixLocation();

    frame.setVisible(true);
  }

  private void fixLocation() {
    frame.setLocationRelativeTo(null);
  }

  public void Close() {
    // TODO am I sure I want this?
    System.exit(0);
  }

  @Override
  public void ResumeLayout(boolean foo) {
  }

  public void setAutoScaleBaseSize(FormSize autoScaleBaseSize) {
    AutoScaleBaseSize = autoScaleBaseSize;
  }

  public FormSize getAutoScaleBaseSize() {
    return AutoScaleBaseSize;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public String getTitle() {
    return Title;
  }

  public void setLoad(EventHandler<Object, EventArgs> load) {
    onLoad = load;
  }

  public void setClosing(EventHandler<Object, CancelEventArgs> closing) {
    Closing = closing;
  }

  public EventHandler<Object, CancelEventArgs> getClosing() {
    return Closing;
  }

  public void setStartPosition(FormStartPosition startPosition) {
    //TODO implmnt method.
  }

  public void setMenu(MainMenu menu) {
    frame.getContentPane().add(menu.asSwingObject(), BorderLayout.PAGE_START);
  }

  public void setControlBox(boolean controlBox) {
    ControlBox = controlBox;
  }

  public boolean getControlBox() {
    return ControlBox;
  }

  public void setMinimizeBox(boolean minimizeBox) {
    MinimizeBox = minimizeBox;
  }

  public boolean getMinimizeBox() {
    return MinimizeBox;
  }

  public void setMaximizeBox(boolean maximizeBox) {
    MaximizeBox = maximizeBox;
  }

  public boolean getMaximizeBox() {
    return MaximizeBox;
  }

  public void setIcon(Icon icon) {
    Icon = icon;
//		Image icon = Toolkit.getDefaultToolkit().getImage("icon.gif");
    frame.setIconImage(icon.asSwingImage());
  }

  public void setFormBorderStyle(FormBorderStyle formBorderStyle) {
    FormBorderStyle = formBorderStyle;
  }

  public FormBorderStyle getFormBorderStyle() {
    return FormBorderStyle;
  }

  public void setClientSize(Dimension clientSize) {
    // heigher, cause decorations count in swing.
    frame.setSize(new Dimension(clientSize.width, clientSize.height + 45));
  }

  public String getText() {
    return frame.getTitle();
  }

  public void setText(String text) {
    frame.setTitle(text);
  }

  public void setStatusBar(StatusBar statusBar) {
    frame.getContentPane().add(statusBar.asSwingObject(), BorderLayout.PAGE_END);
  }

  @Override
  public void dispose() {
    frame.dispose();
  }

  @Override
  public void setResult(DialogResult dialogResult) {
    result = dialogResult;
  }
}
