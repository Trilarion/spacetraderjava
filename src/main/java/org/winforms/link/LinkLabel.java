package org.winforms.link;

import org.winforms.widget.Label;
import org.winforms.event.EventHandler;


// TODO documentation of purpose
public class LinkLabel extends Label {
    public EventHandler<Object, Link> linkClicked;
    public LinkArea linkArea;
    public LinkHolder links = new LinkHolder();
}
