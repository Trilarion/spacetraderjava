package jwinforms;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;
import jwinforms.enums.HorizontalAlignment;


public class NumericUpDown extends WinformControl {
  private final SpinnerNumberModel model = new SpinnerNumberModel();
  public HorizontalAlignment TextAlign;
  public boolean ThousandsSeparator;

  public NumericUpDown() {
    super(new JSpinner());
    JSpinner spinner = asJSpinner();
    spinner.setModel(model);
    // this bunch of code selects all text when entering the spinner.
    ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e) {
        if(e.getSource() instanceof JTextComponent) {
          final JTextComponent textComponent = ((JTextComponent)e.getSource());
          SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              textComponent.selectAll();
            }
          });
        }
      }
    });
  }

  public void Select(int i, int length) {
    //TODO Auto-generated method stub
  }

  public void setValueChanged(final EventHandler<Object, EventArgs> valueChanged) {
    asJSpinner().addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        valueChanged.handle(NumericUpDown.this, null);
      }
    });
  }

  private JSpinner asJSpinner() {
    return (JSpinner)swingVersion;
  }

  public void setMaximum(int maximum) {
    model.setMaximum(maximum);
  }

  public int getMaximum() {
    Integer maximum = (Integer)model.getMaximum();
    return maximum == null ? Integer.MAX_VALUE : maximum;
  }

  public void setMinimum(int minimum) {
    model.setMinimum(minimum);
  }

  public int getMinimum() {
    Integer minimum = (Integer)model.getMinimum();
    return minimum == null ? 0 : minimum;
  }

  public void setValue(int value) {
    asJSpinner().setValue(value);
  }

  /**
   * In .NET, this means that the field can be manipulated by the buttons/arrows, just not by directly inputing text into it.
   * TODO: implement this. Possibly by installing filter on key-presses.
   * @param b read only
   */
  public void setReadOnly(boolean b) {
    asJSpinner().setEnabled(!b);
  }

  public void setLeave(EventHandler<Object, EventArgs> leave) {
  }

  public int getValue() {
    return (Integer)asJSpinner().getValue();
  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
  }

  public void setIncrement(int increment) {
    model.setStepSize(increment);
  }
}
