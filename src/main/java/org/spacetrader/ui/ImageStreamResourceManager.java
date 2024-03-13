package org.spacetrader.ui;

import org.spacetrader.util.Convertor;
import org.spacetrader.util.Lisp;
import org.winforms.ImageListStreamer;
import org.winforms.ResourceManager;
import org.winforms.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;


public class ImageStreamResourceManager extends ResourceManager {
    public ImageStreamResourceManager(URL url, String s) {
        super(url, s);
    }

    public ImageListStreamer getStream() {
        List<Entry<Object, Object>> ls = new ArrayList<>(properties.entrySet());
        Collections.sort(ls, new Comparator<>() {
            @Override
            public int compare(Entry<Object, Object> arg0, Entry<Object, Object> arg1) {
                String left = (String) arg0.getKey();
                String right = (String) arg1.getKey();
                return left.compareTo(right);
            }
        });
        Iterable<Image> images = Lisp.map(ls, new Convertor<>() {
            @Override
            public Image convert(Entry<Object, Object> entry) {
                return (Image) getImage((String) entry.getValue());
            }
        });
        return new ImageListStreamer(images);
    }
}
