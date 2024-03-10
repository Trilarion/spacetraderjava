package org.winforms;

import org.winforms.enums.BorderStyle;

import java.awt.Font;
import java.awt.*;
import java.awt.event.MouseListener;


public class wfControl implements ISupportInitialize {
    protected final Component swingVersion;
    EventHandler<Object, EventArgs> click;
    EventHandler<Object, EventArgs> doubleClick;
    private String Name;
    private Color ForeColor;
    private int tabIndex;
    private Color BackColor;

    @Deprecated
    public wfControl() {
        this(null);
    }

    public wfControl(Component swingVersion) {
        super();
        this.swingVersion = swingVersion;
    }

    public void setDoubleClick(EventHandler<Object, EventArgs> doubleClick) {
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
        return swingVersion;
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
        Font font = swingVersion.getFont();
        return font == null ? null : new org.winforms.Font(font);
    }

    public void setFont(Font font) {
        swingVersion.setFont(font);
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
        return swingVersion.getLocation().x;
    }

    public void setLeft(int left) {
        Point location = (Point) swingVersion.getLocation().clone();
        location.x = left;
        swingVersion.setLocation(location);
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
        return swingVersion.getLocation().y;
    }

    public void setTop(int top) {
        Point location = (Point) swingVersion.getLocation().clone();
        location.y = top;
        swingVersion.setLocation(location);
    }

    public boolean getVisible() {
        return swingVersion.isVisible();
    }

    public void setVisible(boolean visible) {
        swingVersion.setVisible(visible);
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

    public void setClick(EventHandler<Object, EventArgs> click) {
        this.click = click;
    }

    public void setEnabled(boolean enabled) {
        swingVersion.setEnabled(enabled);
    }

    public void setEnter(EventHandler<Object, EventArgs> enter) {
    }

    public void setLocation(Point location) {
        swingVersion.setLocation(location);
    }

    public void setMouseEnter(EventHandler<Object, EventArgs> mouseEnter) {
    }

    public void setMouseLeave(EventHandler<Object, EventArgs> mouseLeave) {
    }

    Dimension getSize() {
        return swingVersion.getPreferredSize();
    }

    public void setSize(Dimension size) {
        swingVersion.setPreferredSize(size);
        swingVersion.setSize(size);
    }

    public void setTabStop(boolean tabStop) {
        swingVersion.setFocusable(tabStop);
    }

    public void SuspendLayout() {
        // TODO Auto-generated method stub
    }

    @Override
    public void BeginInit() {
        // TODO Auto-generated method stub
    }

    @Override
    public void EndInit() {
        // TODO Auto-generated method stub
    }
}
