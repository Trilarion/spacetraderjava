package jwinforms;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import javax.swing.JDialog;
import jwinforms.enums.DialogResult;
import jwinforms.enums.FormBorderStyle;
import jwinforms.enums.FormStartPosition;


public class WinformForm extends WinformControl implements WinformPane {
  private final JDialog jdialog;
  private final WinformJPanel panel;
  protected final WinformJPanel Controls;
  DialogResult result;
  // Must encapsulate most of these.
  private FormSize AutoScaleBaseSize;
  private boolean ShowInTaskbar;
  private boolean MinimizeBox;
  private boolean MaximizeBox;
  private FormStartPosition StartPosition;
  private EventHandler<Object, CancelEventArgs> Closing;
  private EventHandler<Object, EventArgs> Load;
  private Button AcceptButton;
  private Button CancelButton;
  protected EventHandler<Object, EventArgs> Closed;
  private String Title;
  private WinformPane parent;

  public WinformForm() {
    // super(new WinformJPanel());
    super(new JDialog());
    jdialog = (JDialog)swingVersion;
    // panel = (WinformJPanel)swingVersion;
    panel = new WinformJPanel(this);
    jdialog.setContentPane(panel);
    Controls = panel;
    jdialog.setResizable(false);
  }

  // ///////////// implementation ends here.
  public Graphics CreateGraphics() {
    return new Graphics(jdialog.getGraphics());
  }

  public DialogResult ShowDialog() {
    return ShowDialog(null);
  }

  // This should be "modal", i.e. - parent is blocked.
  public DialogResult ShowDialog(WinformPane owner) {
    parent = owner;

    fixLocation();
    panel.addMouseListener(getMouseListener());
    jdialog.setModalityType(ModalityType.APPLICATION_MODAL);

    jdialog.setVisible(true);

    return result;
  }

  private void fixLocation() {
    if(StartPosition == null) {
      return;
    }
    switch(StartPosition) {
      case CenterParent:
        jdialog.setLocationRelativeTo(parent == null ? null : parent.asSwingObject());
        break;
      case Manual:
        break;
      default:
        throw new Error("Unknown startPosition kind: " + StartPosition);
    }
  }

  public void Close() {
    jdialog.setVisible(false);
  }

  @Override
  public void ResumeLayout(boolean foo) {
  }

  public void PerformLayout() {
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

  public void setAcceptButton(Button acceptButton) {
    jdialog.getRootPane().setDefaultButton(acceptButton.asJButtton());
  }

  public Button getAcceptButton() {
    return AcceptButton;
  }

  // TODO handle.
  public void setCancelButton(Button cancelButton) {
    CancelButton = cancelButton;
  }

  public Button getCancelButton() {
    return CancelButton;
  }

  public void setLoad(EventHandler<Object, EventArgs> load) {
    Load = load;
  }

  public EventHandler<Object, EventArgs> getLoad() {
    return Load;
  }

  public void setClosing(EventHandler<Object, CancelEventArgs> closing) {
    Closing = closing;
  }

  public EventHandler<Object, CancelEventArgs> getClosing() {
    return Closing;
  }

  public void setStartPosition(FormStartPosition startPosition) {
    StartPosition = startPosition;
  }

  public void setControlBox(boolean controlBox) {
    jdialog.setDefaultCloseOperation(controlBox ? JDialog.DISPOSE_ON_CLOSE : JDialog.DO_NOTHING_ON_CLOSE);
  }

  // TODO ShowInTaskbar
  public void setShowInTaskbar(boolean showInTaskbar) {
    ShowInTaskbar = showInTaskbar;
  }

  public boolean getShowInTaskbar() {
    return ShowInTaskbar;
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

  public void setFormBorderStyle(FormBorderStyle style) {
    switch(style) {
      case FixedDialog:
        jdialog.setUndecorated(false);
        break;
      case FixedSingle:
        jdialog.setUndecorated(false);
        break;
      case None:
        jdialog.setUndecorated(true);
        break;

      default:
        throw new Error("Unknown border style: " + style);
    }
  }

  public void setClientSize(Dimension clientSize) {
    // bigger, cause decorations count in swing.
    if(clientSize == null) {
      System.out.println("null here");
      return;
    }
    setSize(new Dimension(clientSize.width + 10, clientSize.height + 30));
  }

  public String getText() {
    return jdialog.getTitle();
  }

  public void setText(String text) {
    jdialog.setTitle(text);
  }

  @Override
  public void dispose() {
    jdialog.dispose();
  }

  @Override
  public void setResult(DialogResult dialogResult) {
    result = dialogResult;
  }

  protected void setBackgroundImage(WfImage backgroundImage) {
    panel.BackgroundImage = backgroundImage;
  }

  protected WfImage getBackgroundImage() {
    return panel.BackgroundImage;
  }
}
