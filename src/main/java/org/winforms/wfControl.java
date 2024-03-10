package org.winforms;

import org.winforms.enums.BorderStyle;

import java.awt.Font;
import java.awt.*;
import java.awt.event.MouseListener;

// TODO documentation of usage
public class wfControl implements ISupportInitialize {

    protected final Component swingComponent;
    EventHandler<Object, EventData> click;
    EventHandler<Object, EventData> doubleClick;
    private String Name;
    private Color ForeColor;
    private int tabIndex;
    private Color BackColor;

    @Deprecated
    public wfControl() {
        this(null);
    }

    public wfControl(Component swingComponent) {
        super();
        this.swingComponent = swingComponent;
    }

    public void setDoubleClick(EventHandler<Object, EventData> doubleClick) {
        this.doubleClick = doubleClick;
    }

    public MouseListener getMouseListener() {
        return new wfMouseListener(this, click, doubleClick);
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public Component asSwingObject() {
        return swingComponent;
    }

    public Color getBackColor() {
        return BackColor;
    }

    /**
     * TODO not really deprecated, just doesn't work.
     */
    public void setBackColor(Color backColor) {
        BackColor = backColor;
    }

    public org.winforms.Font getFont() {
        Font font = swingComponent.getFont();
        return font == null ? null : new org.winforms.Font(font);
    }

    public void setFont(Font font) {
        swingComponent.setFont(font);
    }

    public Color getForeColor() {
        return ForeColor;
    }

    public void setForeColor(Color foreColor) {
        ForeColor = foreColor;
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
        return Name;
    }

    /**
     * I think this is nothing.
     */
    public void setName(String name) {
        Name = name;
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

    public void ResumeLayout(boolean b) {
        // TODO Auto-generated method stub
    }

    public void setAutoSize(boolean autoSize) {
        // /TODO impl.
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
    }

    public void setLocation(Point location) {
        swingComponent.setLocation(location);
    }

    public void setMouseEnter(EventHandler<Object, EventData> mouseEnter) {
    }

    public void setMouseLeave(EventHandler<Object, EventData> mouseLeave) {
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

    public void SuspendLayout() {
        // TODO Auto-generated method stub
    }

    @Override
    public void beginInit() {
        // TODO Auto-generated method stub
    }

    @Override
    public void endInit() {
        // TODO Auto-generated method stub
    }
}
