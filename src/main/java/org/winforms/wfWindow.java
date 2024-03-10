package org.winforms;

import org.winforms.enums.DialogResult;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import javax.swing.*;
import java.awt.*;

// TODO documentation of usage
public class wfWindow extends wfControl implements wfPane {

    protected final wfPanel Controls;
    private final JFrame frame;
    protected Integer Left, Top;
    protected FormWindowState WindowState;
    DialogResult result;
    // Must encapsulate most of these.
    private FormSize AutoScaleBaseSize;
    private FormBorderStyle FormBorderStyle;
    private boolean ControlBox;
    private boolean MinimizeBox;
    private boolean MaximizeBox;
    private EventHandler<Object, CancelEventData> Closing;
    private String Title;
    private EventHandler<Object, EventData> onLoad;

    public wfWindow() {
        // super(new WinformJPanel());
        super(new JFrame());
        frame = (JFrame) swingComponent;
        // panel = (WinformJPanel)swingVersion;
        wfPanel panel = new wfPanel(this);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        Controls = panel;
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ///////////// implementation ends here.

    public void ShowWindow() {
        EventHandler<Object, EventData> loadHandler = onLoad;
        if (loadHandler != null) {
            loadHandler.handle(this, null);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fixLocation();

        frame.setVisible(true);
    }

    private void fixLocation() {
        frame.setLocationRelativeTo(null);
    }

    public void Close() {
        // TODO am I sure I want this?
        System.exit(0);
    }

    public FormSize getAutoScaleBaseSize() {
        return AutoScaleBaseSize;
    }

    public void setAutoScaleBaseSize(FormSize autoScaleBaseSize) {
        AutoScaleBaseSize = autoScaleBaseSize;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setLoad(EventHandler<Object, EventData> load) {
        onLoad = load;
    }

    public EventHandler<Object, CancelEventData> getClosing() {
        return Closing;
    }

    public void setClosing(EventHandler<Object, CancelEventData> closing) {
        Closing = closing;
    }

    public void setStartPosition(FormStartPosition startPosition) {
        //TODO implmnt method.
    }

    public void setMenu(MainMenu menu) {
        frame.getContentPane().add(menu.asSwingObject(), BorderLayout.PAGE_START);
    }

    public boolean getControlBox() {
        return ControlBox;
    }

    public void setControlBox(boolean controlBox) {
        ControlBox = controlBox;
    }

    public boolean getMinimizeBox() {
        return MinimizeBox;
    }

    public void setMinimizeBox(boolean minimizeBox) {
        MinimizeBox = minimizeBox;
    }

    public boolean getMaximizeBox() {
        return MaximizeBox;
    }

    public void setMaximizeBox(boolean maximizeBox) {
        MaximizeBox = maximizeBox;
    }

    public void setIcon(Icon icon) {
        //		Image icon = Toolkit.getDefaultToolkit().getImage("icon.gif");
        frame.setIconImage(icon.asSwingImage());
    }

    public FormBorderStyle getFormBorderStyle() {
        return FormBorderStyle;
    }

    public void setFormBorderStyle(FormBorderStyle formBorderStyle) {
        FormBorderStyle = formBorderStyle;
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

    protected enum FormWindowState {
        Normal
    }
}
