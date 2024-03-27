package org.winforms.widget;

import org.winforms.mouse.MouseAdapterExtension;
import org.winforms.event.EventHandler;

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
        asJStatusBar().addSection(panel.asJStatusBarSection(), panel.autoSize == StatusBarPanelAutoSize.Spring);
        panel.asJStatusBarSection().addMouseListener(new MouseAdapterExtension(this, panel));
    }

    private JStatusBar asJStatusBar() {
        return (JStatusBar) swingComponent;
    }

}
