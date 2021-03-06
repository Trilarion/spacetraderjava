package spacetrader.stub;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class RegistryKey {
  private final File file;
  protected final Properties properties = new Properties();

  public RegistryKey(File regfile) {
    this.file = regfile;
    FileInputStream stream = null;
    try {
      regfile.createNewFile();
      stream = new FileInputStream(regfile);
      properties.load(stream);
    } catch(IOException e) {
      throw new Error("Can't create/load regfile.");
    } finally {
      if(stream != null) {
        try {
          stream.close();
        } catch(IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public Object GetValue(String settingName) {
    return properties.getProperty(settingName);
  }

  public void Close() {
    FileOutputStream stream;
    try {
      stream = new FileOutputStream(file);
    } catch(FileNotFoundException e) {
      e.printStackTrace();
      return;
    }
    try {
      properties.store(stream, "");
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        stream.close();
      } catch(IOException e) {
        e.printStackTrace();
        return;
      }
    }
  }

  public void SetValue(String settingName, String settingValue) {
    properties.setProperty(settingName, settingValue);
  }
}
