package org.winforms;

// TODO what is this good for
abstract public class EventHandler<Sender, Data> {
    abstract public void handle(Sender sender, Data e);
}
