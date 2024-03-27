package org.winforms.widget;

import org.winforms.image.Icon;
import org.winforms.dialog.Pane;
import org.winforms.dialog.DialogResult;
import org.winforms.style.FormBorderStyle;
import org.winforms.alignment.FormStartPosition;
import org.winforms.event.CancelEventData;
import org.winforms.event.EventData;
import org.winforms.event.EventHandler;

import javax.swing.*;
import java.awt.*;

// TODO documentation of usage
public class Window extends Control<JFrame> implements Pane {

    protected final wfPanel controls;
    private final JFrame frame;
    protected Integer Left, Top;
    protected FormWindowState windowState;
    DialogResult result;
    // Must encapsulate most of these.
    private Dimension autoScaleBaseSize;
    private FormBorderStyle formBorderStyle;
    private boolean controlBox;
    private boolean minimizeBox;
    private boolean maximizeBox;
    private EventHandler<Object, CancelEventData> closing;
    private String title;
    private EventHandler<Object, EventData> onLoad;

    public Window() {
        // super(new WinformJPanel());
        super(new JFrame());
        frame = swingComponent;
        // panel = (WinformJPanel)swingVersion;
        final wfPanel panel = new wfPanel(this);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        controls = panel;
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showWindow() {
        final EventHandler<Object, EventData> loadHandler = onLoad;
        if (loadHandler != null) {
            loadHandler.handle(this, null);
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fixLocation();

        frame.setVisible(true);
    }

    private void fixLocation() {
        frame.setLocationRelativeTo(null);
    }

    public void close() {
        // TODO am I sure I want this?
        System.exit(0);
    }

    public Dimension getAutoScaleBaseSize() {
        return autoScaleBaseSize;
    }

    public void setAutoScaleBaseSize(final Dimension autoScaleBaseSize) {
        this.autoScaleBaseSize = autoScaleBaseSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setLoad(final EventHandler<Object, EventData> load) {
        onLoad = load;
    }

    public EventHandler<Object, CancelEventData> getClosing() {
        return closing;
    }

    public void setClosing(final EventHandler<Object, CancelEventData> closing) {
        this.closing = closing;
    }

    public void setStartPosition(final FormStartPosition startPosition) {
        // TODO implementation?
    }

    public void setMenu(final MenuBar menu) {
        frame.getContentPane().add(menu.asSwingObject(), BorderLayout.PAGE_START);
    }

    public boolean getControlBox() {
        return controlBox;
    }

    public void setControlBox(final boolean controlBox) {
        this.controlBox = controlBox;
    }

    public boolean getMinimizeBox() {
        return minimizeBox;
    }

    public void setMinimizeBox(final boolean minimizeBox) {
        this.minimizeBox = minimizeBox;
    }

    public boolean getMaximizeBox() {
        return maximizeBox;
    }

    public void setMaximizeBox(final boolean maximizeBox) {
        this.maximizeBox = maximizeBox;
    }

    public void setIcon(final Icon icon) {
        //		Image icon = Toolkit.getDefaultToolkit().getImage("icon.gif");
        frame.setIconImage(icon.asSwingImage());
    }

    public FormBorderStyle getFormBorderStyle() {
        return formBorderStyle;
    }

    public void setFormBorderStyle(final FormBorderStyle formBorderStyle) {
        this.formBorderStyle = formBorderStyle;
    }

    public void setClientSize(final Dimension clientSize) {
        // higher, cause decorations count in swing.
        frame.setSize(new Dimension(clientSize.width, clientSize.height + 45));
    }

    public String getText() {
        return frame.getTitle();
    }

    public void setText(final String text) {
        frame.setTitle(text);
    }

    public void setStatusBar(final StatusBar statusBar) {
        frame.getContentPane().add(statusBar.asSwingObject(), BorderLayout.PAGE_END);
    }

    @Override
    public void dispose() {
        frame.dispose();
    }

    @Override
    public void setResult(final DialogResult dialogResult) {
        result = dialogResult;
    }

    protected enum FormWindowState {  // TODO need for this
        Normal
    }
}
