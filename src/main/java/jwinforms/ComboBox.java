package jwinforms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import jwinforms.enums.ComboBoxStyle;


public class ComboBox extends WinformControl {
  public final MyComboBoxModel Items = new MyComboBoxModel();
  // probably don't care.
  public ComboBoxStyle DropDownStyle;

  public ComboBox() {
    super(new JComboBox<Object>());
    ComboBox.this.asJComboBox().setModel(Items);
  }

  public JComboBox<Object> asJComboBox() {
    return (JComboBox<Object>)swingVersion;
  }

  public Object getSelectedItem() {
    return asJComboBox().getSelectedItem();
  }

  public int getSelectedIndex() {
    return asJComboBox().getSelectedIndex();
  }

  public void setSelectedIndex(int index) {
    asJComboBox().setSelectedIndex(index);
  }

  public void setSelectedIndexChanged(final EventHandler<Object, EventArgs> handler) {
    asJComboBox().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        handler.handle(ComboBox.this, null);
      }
    });
  }
}
