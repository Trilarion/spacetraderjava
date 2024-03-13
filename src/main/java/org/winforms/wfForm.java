package org.winforms;

import org.winforms.enums.DialogResult;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import javax.swing.*;
import java.awt.Dialog.ModalityType;
import java.awt.*;

// TODO documentation of usage
public class wfForm extends wfControl implements wfPane {

    protected final wfPanel Controls;
    private final JDialog jdialog;
    private final wfPanel panel;
    protected EventHandler<Object, EventData> Closed;
    DialogResult result;
    // Must encapsulate most of these.
    private SizeF AutoScaleBaseSize;
    private boolean ShowInTaskbar;
    private boolean MinimizeBox;
    private boolean MaximizeBox;
    private FormStartPosition StartPosition;
    private EventHandler<Object, CancelEventData> Closing;
    private EventHandler<Object, EventData> Load;
    private Button AcceptButton;
    private Button CancelButton;
    private String Title;
    private wfPane parent;

    public wfForm() {
        // super(new WinformJPanel());
        super(new JDialog());
        jdialog = (JDialog) swingComponent;
        // panel = (WinformJPanel)swingVersion;
        panel = new wfPanel(this);
        jdialog.setContentPane(panel);
        Controls = panel;
        jdialog.setResizable(false);
    }

    // ///////////// implementation ends here.
    public Graphics CreateGraphics() {
        return new Graphics(jdialog.getGraphics());
    }

    public DialogResult ShowDialog() {
        return ShowDialog(null);
    }

    // This should be "modal", i.e. - parent is blocked.
    public DialogResult ShowDialog(wfPane owner) {
        parent = owner;

        fixLocation();
        panel.addMouseListener(getMouseListener());
        jdialog.setModalityType(ModalityType.APPLICATION_MODAL);

        jdialog.setVisible(true);

        return result;
    }

    private void fixLocation() {
        if (StartPosition == null) {
            return;
        }
        switch (StartPosition) {
            case CenterParent:
                jdialog.setLocationRelativeTo(parent == null ? null : parent.asSwingObject());
                break;
            case Manual:
                break;
            default:
                throw new Error("Unknown startPosition kind: " + StartPosition);
        }
    }

    public void Close() {
        jdialog.setVisible(false);
    }

    public void PerformLayout() {
        // TODO implementation?
    }

    public SizeF getAutoScaleBaseSize() {
        return AutoScaleBaseSize;
    }

    public void setAutoScaleBaseSize(SizeF autoScaleBaseSize) {
        AutoScaleBaseSize = autoScaleBaseSize;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Button getAcceptButton() {
        return AcceptButton;
    }

    public void setAcceptButton(Button acceptButton) {
        jdialog.getRootPane().setDefaultButton(acceptButton.asJButton());
    }

    public Button getCancelButton() {
        return CancelButton;
    }

    // TODO handle.
    public void setCancelButton(Button cancelButton) {
        CancelButton = cancelButton;
    }

    public EventHandler<Object, EventData> getLoad() {
        return Load;
    }

    public void setLoad(EventHandler<Object, EventData> load) {
        Load = load;
    }

    public EventHandler<Object, CancelEventData> getClosing() {
        return Closing;
    }

    public void setClosing(EventHandler<Object, CancelEventData> closing) {
        Closing = closing;
    }

    public void setStartPosition(FormStartPosition startPosition) {
        StartPosition = startPosition;
    }

    public void setControlBox(boolean controlBox) {
        jdialog.setDefaultCloseOperation(controlBox ? JDialog.DISPOSE_ON_CLOSE : JDialog.DO_NOTHING_ON_CLOSE);
    }

    public boolean getShowInTaskbar() {
        return ShowInTaskbar;
    }

    // TODO ShowInTaskbar
    public void setShowInTaskbar(boolean showInTaskbar) {
        ShowInTaskbar = showInTaskbar;
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

    public void setFormBorderStyle(FormBorderStyle style) {
        switch (style) {
            case FixedDialog:
                jdialog.setUndecorated(false);
                break;
            case FixedSingle:
                jdialog.setUndecorated(false);
                break;
            case None:
                jdialog.setUndecorated(true);
                break;

            default:
                throw new Error("Unknown border style: " + style);
        }
    }

    public void setClientSize(Dimension clientSize) {
        // bigger, cause decorations count in swing.
        if (clientSize == null) {
            System.out.println("null here");
            return;
        }
        setSize(new Dimension(clientSize.width + 10, clientSize.height + 30));
    }

    public String getText() {
        return jdialog.getTitle();
    }

    public void setText(String text) {
        jdialog.setTitle(text);
    }

    @Override
    public void dispose() {
        jdialog.dispose();
    }

    @Override
    public void setResult(DialogResult dialogResult) {
        result = dialogResult;
    }

    protected wfImage getBackgroundImage() {
        return panel.BackgroundImage;
    }

    protected void setBackgroundImage(wfImage backgroundImage) {
        panel.BackgroundImage = backgroundImage;
    }
}