package org.winforms;

import org.winforms.enums.StatusBarPanelAutoSize;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// TODO documentation of usage
public class StatusBar extends wfControl {
    public StatusBar Panels = this;
    public EventHandler<Object, StatusBarPanelClickEventData> PanelClick;
    public boolean ShowPanels;
    public boolean SizingGrip;

    public StatusBar() {
        super(new JStatusBar());
    }

    public void addAll(Iterable<StatusBarPanel> asList) {
        for (StatusBarPanel panel : asList) {
            add(panel);
        }
    }

    private void add(StatusBarPanel panel) {
        asJStatusBar().addSection(panel.asJStatusBarSection(), panel.AutoSize == StatusBarPanelAutoSize.Spring);
        panel.asJStatusBarSection().addMouseListener(new MouseAdapterExtension(panel));
    }

    private JStatusBar asJStatusBar() {
        return (JStatusBar) swingComponent;
    }


    private class MouseAdapterExtension extends MouseAdapter {
        private final StatusBarPanel source;

        MouseAdapterExtension(StatusBarPanel source) {
            super();
            this.source = source;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (PanelClick != null) {
                PanelClick.handle(source, new StatusBarPanelClickEventData(source));
            }
        }
    }
}
