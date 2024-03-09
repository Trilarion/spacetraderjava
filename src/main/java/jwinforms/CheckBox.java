package jwinforms;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CheckBox extends WinformControl {
  public CheckBox() {
    super(new JCheckBox());
  }

  public JCheckBox asJCheckBox() {
    return ((JCheckBox)swingVersion);
  }

  public String getText() {
    return asJCheckBox().getText();
  }

  public boolean isChecked() {
    return asJCheckBox().isSelected();
  }

  public void setChecked(boolean checked) {
    asJCheckBox().setSelected(checked);
  }

  public void setCheckedChanged(final EventHandler<Object, EventArgs> handler) {
    asJCheckBox().addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        handler.handle(CheckBox.this, null);
      }
    });
  }

  public void setText(String text) {
    asJCheckBox().setText(text);
  }
}
