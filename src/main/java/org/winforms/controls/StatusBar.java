package org.winforms.controls;

import org.winforms.EventHandler;
import org.winforms.JStatusBar;
import org.winforms.MouseAdapterExtension;
import org.winforms.StatusBarPanel;
import org.winforms.controls.Control;
import org.winforms.enums.StatusBarPanelAutoSize;

// TODO documentation of usage
public class StatusBar extends Control<JStatusBar> {

    public EventHandler<Object, StatusBarPanel> panelClick;
    public boolean showPanels;
    public boolean sizingGrip;

    public StatusBar() {
        super(new JStatusBar());
    }

    public void addAll(Iterable<StatusBarPanel> asList) {
        for (StatusBarPanel panel : asList) {
            add(panel);
        }
    }

    private void add(StatusBarPanel panel) {
        asJStatusBar().addSection(panel.asJStatusBarSection(), StatusBarPanelAutoSize.Spring == panel.autoSize);
        panel.asJStatusBarSection().addMouseListener(new MouseAdapterExtension(this, panel));
    }

    private JStatusBar asJStatusBar() {
        return (JStatusBar) swingComponent;
    }

}
