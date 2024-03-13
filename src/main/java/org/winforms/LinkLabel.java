package org.winforms;

// TODO documentation of purpose
public class LinkLabel extends Label {
    public EventHandler<Object, LinkLabelLinkClickedEventData> linkClicked;
    public LinkArea linkArea;
    public LinkHolder links = new LinkHolder();
}
