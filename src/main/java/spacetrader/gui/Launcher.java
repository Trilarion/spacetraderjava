package spacetrader.gui;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jwinforms.WinformForm;
import jwinforms.enums.DialogResult;


public class Launcher {
  public static void runForm(WinformForm wf) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    SwingUtilities.updateComponentTreeUI(wf.asSwingObject());
    DialogResult res = wf.ShowDialog(null);
    System.out.println("Dialog result: " + res);
  }
}
