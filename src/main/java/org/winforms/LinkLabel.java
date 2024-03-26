package org.winforms;

import org.winforms.controls.Label;
import org.winforms.events.EventHandler;


// TODO documentation of purpose
public class LinkLabel extends Label {
    public EventHandler<Object, Link> linkClicked;
    public LinkArea linkArea;
    public LinkHolder links = new LinkHolder();
}
