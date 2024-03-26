package org.winforms;


import org.winforms.events.EventData;
import org.winforms.events.EventHandler;

public abstract class ChainedEventHandler<Sender, Data extends EventData> extends EventHandler<Sender, Data> {
    private final EventHandler<Sender, Data> chain;

    public ChainedEventHandler(EventHandler<Sender, Data> chain) {
        this.chain = chain;
    }

    @Override
    public void handle(Sender sender, Data data) {
        if (null != chain) {
            chain.handle(sender, data);
        }
        instanceHandle(sender, data);
    }

    abstract protected void instanceHandle(Sender sender, Data e);
}
