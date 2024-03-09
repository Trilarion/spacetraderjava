package jwinforms;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import jwinforms.enums.BorderStyle;


public class ListBox extends WinformControl {
  public final MyListModel Items = new MyListModel();

  @Override
  @SuppressWarnings("deprecation")
  public void setBorderStyle(BorderStyle borderStyle) {
    if(borderStyle != BorderStyle.FixedSingle) {
      throw new Error("Unknown border style");
    }
    asJList().setBorder(BorderFactory.createLineBorder(Color.black, 1));
  }

  public ListBox() {
    super(new JList<Object>());
    ListBox.this.asJList().setModel(Items);
  }

  public void clearSelected() {
    asJList().clearSelection();
  }

  public JList<Object> asJList() {
    return (JList<Object>)swingVersion;
  }

  public void setSelectedIndexChanged(final EventHandler<Object, EventArgs> handler) {
    asJList().addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        handler.handle(ListBox.this, null);
      }
    });
  }

  public int getSelectedIndex() {
    return asJList().getSelectedIndex();
  }

  public int getItemHeight() {
    return 15;
  }

  public void setSelectedItem(Object selectedItem) {
    asJList().setSelectedValue(selectedItem, true);
  }

  public Object getSelectedItem() {
    return asJList().getSelectedValue();
  }
}
