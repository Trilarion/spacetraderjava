package org.winforms.resource;

import org.winforms.image.Bitmap;

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

    protected ResourceManager(final URL url, final String path) {
        this.path = path;
        try {
            properties.load(url.openStream());
        } catch (final IOException ex) {
            Logger.getLogger(ResourceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResourceManager(final Class<?> c) {
        this(ResourceManager.classLoader.getResource(ResourceManager.classToPath(c) + c.getSimpleName() + ".properties"), ResourceManager.classToPath(c));
    }

    private static String classToPath(final Class<?> c) {
        final String path = c.getCanonicalName().replace('.', '/');
        return path.substring(0, path.lastIndexOf('/') + 1);
    }

    public Object getObject(final String s) {
        final String objectType = properties.getProperty(s + ".type", null);
        if (objectType == null) {
            throw new Error("No object type for: " + s);
        }
        switch (objectType) {
            case "ImageListStreamer":
                // value is name of properties file with image names in it
                final String streamFilename = properties.getProperty(s);
                try {
                    return new ImageStreamResourceManager(ResourceManager.classLoader.getResource(path + streamFilename), path).getStream();
                } catch (final NullPointerException e) {
                    throw new Error("NPE while seeking for " + path + streamFilename);
                }
            case "Image":
                final String imageName = properties.getProperty(s);
                return getImage(imageName);
            default:
                throw new Error("Unknown object type " + objectType);
        }
    }

    public Object getImage(final String string) {
        return new Bitmap(ResourceManager.classLoader.getResource(string.trim()));
    }

    public String getString(final String string) {
        return properties.getProperty(string);
    }
}
