package org.winforms.widget;

import org.winforms.mouse.MouseListener;
import org.winforms.style.BorderStyle;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import java.awt.*;

// TODO documentation of usage
public class Control<T extends Component> {  // TODO make generic for the type of component that we get

    protected final T swingComponent;
    public EventHandler<Object, EventData> click;
    public EventHandler<Object, EventData> doubleClick;
    private String name;
    private Color foregroundColor;
    private int tabIndex;
    private Color backgroundColor;

    public Control(T swingComponent) {
        this.swingComponent = swingComponent;
    }

    public void setDoubleClick(EventHandler<Object, EventData> doubleClick) {
        this.doubleClick = doubleClick;
    }

    public java.awt.event.MouseListener getMouseListener() {
        return new MouseListener(this, click, doubleClick);
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public T asSwingObject() {
        return swingComponent;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * TODO not really deprecated, just doesn't work.
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public org.winforms.util.Font getFont() {
        Font font = swingComponent.getFont();
        return font == null ? null : new org.winforms.util.Font(font);
    }

    public void setFont(Font font) {
        swingComponent.setFont(font);
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public int getHeight() {
        return getSize().height;
    }

    public void setHeight(int height) {
        Dimension size = (Dimension) getSize().clone();
        size.height = height;
        setSize(size);
    }

    public int getLeft() {
        return swingComponent.getLocation().x;
    }

    public void setLeft(int left) {
        Point location = (Point) swingComponent.getLocation().clone();
        location.x = left;
        swingComponent.setLocation(location);
    }

    public String getName() {
        return name;
    }

    /**
     * I think this is nothing.
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getTop() {
        return swingComponent.getLocation().y;
    }

    public void setTop(int top) {
        Point location = (Point) swingComponent.getLocation().clone();
        location.y = top;
        swingComponent.setLocation(location);
    }

    public boolean getVisible() {
        return swingComponent.isVisible();
    }

    public void setVisible(boolean visible) {
        swingComponent.setVisible(visible);
    }

    public int getWidth() {
        return getSize().width;
    }

    public void setWidth(int width) {
        Dimension size = (Dimension) getSize().clone();
        size.width = width;
        setSize(size);
    }

    public void resumeLayout(boolean b) {
        // TODO implementation?
    }

    public void setAutoSize(boolean autoSize) {
        // TODO implementation?
    }

    @Deprecated
    public void setBorderStyle(BorderStyle borderStyle) {
    }

    public void setClick(EventHandler<Object, EventData> click) {
        this.click = click;
    }

    public void setEnabled(boolean enabled) {
        swingComponent.setEnabled(enabled);
    }

    public void setEnter(EventHandler<Object, EventData> enter) {
        // TODO implementation?
    }

    public void setLocation(Point location) {
        swingComponent.setLocation(location);
    }

    public void setMouseEnter(EventHandler<Object, EventData> mouseEnter) {
        // TODO implementation?
    }

    public void setMouseLeave(EventHandler<Object, EventData> mouseLeave) {
        // TODO implementation?
    }

    Dimension getSize() {
        return swingComponent.getPreferredSize();
    }

    public void setSize(Dimension size) {
        swingComponent.setPreferredSize(size);
        swingComponent.setSize(size);
    }

    public void setTabStop(boolean tabStop) {
        swingComponent.setFocusable(tabStop);
    }

}
