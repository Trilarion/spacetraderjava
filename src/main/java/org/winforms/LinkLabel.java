package org.winforms;

// TODO documentation of purpose
public class LinkLabel extends Label {
    public EventHandler<Object, LinkLabelLinkClickedEventData> LinkClicked;
    public LinkArea LinkArea;
    public LinkHolder Links = new LinkHolder();
}
