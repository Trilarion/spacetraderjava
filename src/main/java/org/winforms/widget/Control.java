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

    public Control(final T swingComponent) {
        this.swingComponent = swingComponent;
    }

    public void setDoubleClick(final EventHandler<Object, EventData> doubleClick) {
        this.doubleClick = doubleClick;
    }

    public java.awt.event.MouseListener getMouseListener() {
        return new MouseListener(this, click, doubleClick);
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(final int tabIndex) {
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
    public void setBackgroundColor(final Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public org.winforms.util.Font getFont() {
        final Font font = swingComponent.getFont();
        return font == null ? null : new org.winforms.util.Font(font);
    }

    public void setFont(final Font font) {
        swingComponent.setFont(font);
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(final Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public int getHeight() {
        return getSize().height;
    }

    public void setHeight(final int height) {
        final Dimension size = (Dimension) getSize().clone();
        size.height = height;
        setSize(size);
    }

    public int getLeft() {
        return swingComponent.getLocation().x;
    }

    public void setLeft(final int left) {
        final Point location = (Point) swingComponent.getLocation().clone();
        location.x = left;
        swingComponent.setLocation(location);
    }

    public String getName() {
        return name;
    }

    /**
     * I think this is nothing.
     */
    public void setName(final String name) {
        this.name = name;
    }

    public int getTop() {
        return swingComponent.getLocation().y;
    }

    public void setTop(final int top) {
        final Point location = (Point) swingComponent.getLocation().clone();
        location.y = top;
        swingComponent.setLocation(location);
    }

    public boolean getVisible() {
        return swingComponent.isVisible();
    }

    public void setVisible(final boolean visible) {
        swingComponent.setVisible(visible);
    }

    public int getWidth() {
        return getSize().width;
    }

    public void setWidth(final int width) {
        final Dimension size = (Dimension) getSize().clone();
        size.width = width;
        setSize(size);
    }

    public void resumeLayout(final boolean b) {
        // TODO implementation?
    }

    public void setAutoSize(final boolean autoSize) {
        // TODO implementation?
    }

    @Deprecated
    public void setBorderStyle(final BorderStyle borderStyle) {
    }

    public void setClick(final EventHandler<Object, EventData> click) {
        this.click = click;
    }

    public void setEnabled(final boolean enabled) {
        swingComponent.setEnabled(enabled);
    }

    public void setEnter(final EventHandler<Object, EventData> enter) {
        // TODO implementation?
    }

    public void setLocation(final Point location) {
        swingComponent.setLocation(location);
    }

    public void setMouseEnter(final EventHandler<Object, EventData> mouseEnter) {
        // TODO implementation?
    }

    public void setMouseLeave(final EventHandler<Object, EventData> mouseLeave) {
        // TODO implementation?
    }

    Dimension getSize() {
        return swingComponent.getPreferredSize();
    }

    public void setSize(final Dimension size) {
        swingComponent.setPreferredSize(size);
        swingComponent.setSize(size);
    }

    public void setTabStop(final boolean tabStop) {
        swingComponent.setFocusable(tabStop);
    }

    public void suspendLayout() {
        // TODO implementation?

    }
}
