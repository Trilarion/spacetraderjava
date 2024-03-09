package jwinforms;
import java.awt.Component;
import jwinforms.enums.DialogResult;


public interface WinformPane {
  Component asSwingObject();

  void dispose();

  void setResult(DialogResult dialogResult);
}
