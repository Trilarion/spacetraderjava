package org.winforms;

import org.winforms.events.EventData;

import java.awt.*;

// TODO document implementation and usage

/**
 * Can be used as EventData.
 */
public class Graphics implements EventData {  // TODO this can do so much more than just be an event data
    private final java.awt.Graphics graphics;

    public Graphics(java.awt.Graphics graphics) {
        this.graphics = graphics;
    }

    public void drawEllipse(Color color, int x, int y, int width, int height) {
        graphics.setColor(color);
        graphics.drawOval(x, y, width, height);
    }

    public void drawLine(Color color, int x1, int y1, int x2, int y2) {
        graphics.setColor(color);
        graphics.drawLine(x1, y1, x2, y2);
    }

    public void fillRectangle(Color color, int x, int y, int width, int height) {
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height);
    }

    public void fillPolygon(Color color, Point[] points) {
        graphics.setColor(color);
        int[] xs = new int[points.length];
        int[] ys = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            xs[i] = point.x;
            ys[i] = point.y;
        }
        graphics.fillPolygon(xs, ys, points.length);
    }

    public void drawString(String text, org.winforms.Font font, Color color, int x, int y) {
        graphics.setColor(color);
        graphics.setFont(font);
        graphics.drawString(text, x, y);
    }

    public void clear(java.awt.Color backgroundColor) {
        java.awt.Color color = graphics.getColor();
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, 1000000, 1000000);
        graphics.setColor(color);
    }

    public void drawImage(org.winforms.Image img, int x, int y, org.winforms.Rectangle rect) {
        graphics.drawImage(img.asSwingImage(), x, y, x + rect.Width, y + rect.Height, rect.X, rect.Y, rect.X + rect.Width, rect.Y + rect.Height, null);
    }

    public Dimension measureString(String text, java.awt.Font font) {
        if (null == graphics) {
            return new Dimension(text.length() * 5, 30);
        }
        FontMetrics metrics = graphics.getFontMetrics(font);
        int w = metrics.stringWidth(text);
        int h = metrics.getHeight();
        return new Dimension(w, h);
    }
}
