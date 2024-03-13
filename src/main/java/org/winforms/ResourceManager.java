package org.winforms;

import org.spacetrader.ui.ImageStreamResourceManager;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO documentation
public class ResourceManager {

    private static final ClassLoader classLoader = ResourceManager.class.getClassLoader();
    protected final Properties properties = new Properties();
    private final String path;  // TODO meaning of path?

    protected ResourceManager(URL url, String path) {
        this.path = path;
        try {
            properties.load(url.openStream());
        } catch (IOException ex) {
            Logger.getLogger(ResourceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResourceManager(Class<?> c) {
        this(classLoader.getResource(classToPath(c) + c.getSimpleName() + ".properties"), classToPath(c));
    }

    private static String classToPath(Class<?> c) {
        String path = c.getCanonicalName().replace('.', '/');
        return path.substring(0, path.lastIndexOf('/') + 1);
    }

    public Object getObject(String s) {
        String objectType = properties.getProperty(s + ".type", null);
        if (objectType == null) {
            throw new Error("No object type for: " + s);
        }
        switch (objectType) {
            case "ImageListStreamer":
                // value is name of properties file with image names in it
                String streamFilename = properties.getProperty(s);
                try {
                    return new ImageStreamResourceManager(classLoader.getResource(path + streamFilename), path).getStream();
                } catch (NullPointerException e) {
                    throw new Error("NPE while seeking for " + path + streamFilename);
                }
            case "Image":
                String imageName = properties.getProperty(s);
                return getImage(imageName);
            default:
                throw new Error("Unknown object type " + objectType);
        }
    }

    public Object getImage(String string) {
        return new Bitmap(classLoader.getResource(string.trim()));
    }

    public String getString(String string) {
        return properties.getProperty(string);
    }
}
