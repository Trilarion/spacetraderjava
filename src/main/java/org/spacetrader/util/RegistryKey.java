package org.spacetrader.util;

import java.io.*;
import java.util.Properties;

// TODO what is this good for?
public class RegistryKey {

    protected final Properties properties = new Properties();
    private final File file;

    public RegistryKey(File regfile) {
        file = regfile;
        FileInputStream stream = null;
        try {
            regfile.createNewFile();
            stream = new FileInputStream(regfile);
            properties.load(stream);
        } catch (IOException e) {
            throw new Error("Can't create/load regfile.");
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            properties.store(stream, "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void SetValue(String settingName, String settingValue) {
        properties.setProperty(settingName, settingValue);
    }
}
