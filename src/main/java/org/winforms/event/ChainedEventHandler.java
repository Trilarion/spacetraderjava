package org.winforms.event;


public abstract class ChainedEventHandler<Sender, Data extends EventData> extends EventHandler<Sender, Data> {
    private final EventHandler<Sender, Data> chain;

    protected ChainedEventHandler(EventHandler<Sender, Data> chain) {
        this.chain = chain;
    }

    @Override
    public void handle(Sender sender, Data data) {
        if (chain != null) {
            chain.handle(sender, data);
        }
        instanceHandle(sender, data);
    }

    abstract protected void instanceHandle(Sender sender, Data e);
}
