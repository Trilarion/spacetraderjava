package org.winforms.events;

// TODO what is this good for
abstract public class EventHandler<Sender, Data extends EventData> {  // TODO generic interface instead
    abstract public void handle(Sender sender, Data data);  // TODO Sender extend from interface
}
