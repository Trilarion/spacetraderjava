package org.winforms;

// TODO what is this good for
abstract public class EventHandler<Sender, Data> {  // TODO generic interface instead
    abstract public void handle(Sender sender, Data data);
}
