package jwinforms;
import javax.swing.DefaultComboBoxModel;


public class MyComboBoxModel extends DefaultComboBoxModel<Object> {
  private static final long serialVersionUID = 1L;
  // TODO inline methods, use super-class.

  public Object get(int index) {
    return getElementAt(index);
  }

  public void add(Object obj) {
    this.addElement(obj);
  }

  public void AddRange(Object... objects) {
    for(Object obj : objects) {
      add(obj);
    }
  }

  public void Insert(int index, Object obj) {
    insertElementAt(obj, index);
  }

  public void remove(int index) {
    removeElementAt(index);
  }
}
