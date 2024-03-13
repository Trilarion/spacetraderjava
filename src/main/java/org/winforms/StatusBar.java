package org.winforms;

import org.winforms.enums.StatusBarPanelAutoSize;

// TODO documentation of usage
public class StatusBar extends Control {

    public EventHandler<Object, StatusBarPanelClickEventData> panelClick;
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
