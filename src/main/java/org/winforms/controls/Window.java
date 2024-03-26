package org.winforms.controls;

import org.winforms.Icon;
import org.winforms.Pane;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;
import org.winforms.events.CancelEventData;
import org.winforms.events.EventData;
import org.winforms.events.EventHandler;
import org.winforms.wfPanel;

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
        frame = (JFrame) swingComponent;
        // panel = (WinformJPanel)swingVersion;
        wfPanel panel = new wfPanel(this);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        controls = panel;
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showWindow() {
        EventHandler<Object, EventData> loadHandler = onLoad;
        if (null != loadHandler) {
            loadHandler.handle(this, null);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void setAutoScaleBaseSize(Dimension autoScaleBaseSize) {
        this.autoScaleBaseSize = autoScaleBaseSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLoad(EventHandler<Object, EventData> load) {
        onLoad = load;
    }

    public EventHandler<Object, CancelEventData> getClosing() {
        return closing;
    }

    public void setClosing(EventHandler<Object, CancelEventData> closing) {
        this.closing = closing;
    }

    public void setStartPosition(FormStartPosition startPosition) {
        // TODO implementation?
    }

    public void setMenu(MenuBar menu) {
        frame.getContentPane().add(menu.asSwingObject(), BorderLayout.PAGE_START);
    }

    public boolean getControlBox() {
        return controlBox;
    }

    public void setControlBox(boolean controlBox) {
        this.controlBox = controlBox;
    }

    public boolean getMinimizeBox() {
        return minimizeBox;
    }

    public void setMinimizeBox(boolean minimizeBox) {
        this.minimizeBox = minimizeBox;
    }

    public boolean getMaximizeBox() {
        return maximizeBox;
    }

    public void setMaximizeBox(boolean maximizeBox) {
        this.maximizeBox = maximizeBox;
    }

    public void setIcon(Icon icon) {
        //		Image icon = Toolkit.getDefaultToolkit().getImage("icon.gif");
        frame.setIconImage(icon.asSwingImage());
    }

    public FormBorderStyle getFormBorderStyle() {
        return formBorderStyle;
    }

    public void setFormBorderStyle(FormBorderStyle formBorderStyle) {
        this.formBorderStyle = formBorderStyle;
    }

    public void setClientSize(Dimension clientSize) {
        // higher, cause decorations count in swing.
        frame.setSize(new Dimension(clientSize.width, clientSize.height + 45));
    }

    public String getText() {
        return frame.getTitle();
    }

    public void setText(String text) {
        frame.setTitle(text);
    }

    public void setStatusBar(StatusBar statusBar) {
        frame.getContentPane().add(statusBar.asSwingObject(), BorderLayout.PAGE_END);
    }

    @Override
    public void dispose() {
        frame.dispose();
    }

    @Override
    public void setResult(DialogResult dialogResult) {
        result = dialogResult;
    }

    protected enum FormWindowState {  // TODO need for this
        Normal
    }
}
