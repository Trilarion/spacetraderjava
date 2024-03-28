package org.winforms.resource;

import org.winforms.util.Convertor;
import org.winforms.util.Lisp;
import org.winforms.image.Image;
import org.winforms.image.ImageListStreamer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class ImageStreamResourceManager extends ResourceManager {
    public ImageStreamResourceManager(URL url, String s) {
        super(url, s);
    }

    public ImageListStreamer getStream() {
        List<Map.Entry<Object, Object>> ls = new ArrayList<>(properties.entrySet());
        Collections.sort(ls, new EntryComparator());
        Iterable<Image> images = Lisp.map(ls, new Convertor<>() {
            @Override
            public Image convert(Map.Entry<Object, Object> entry) {
                return (Image) getImage((String) entry.getValue());
            }
        });
        return new ImageListStreamer(images);
    }

    private static class EntryComparator implements Comparator<Map.Entry<Object, Object>> {
        @Override
        public int compare(Map.Entry<Object, Object> arg0, Map.Entry<Object, Object> arg1) {
            String left = (String) arg0.getKey();
            String right = (String) arg1.getKey();
            return left.compareTo(right);
        }
    }
}
