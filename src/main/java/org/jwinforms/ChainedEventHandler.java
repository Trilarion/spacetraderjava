package org.jwinforms;


public abstract class ChainedEventHandler<Sender, Args> extends EventHandler<Sender, Args> {
    private final EventHandler<Sender, Args> chain;

    public ChainedEventHandler(EventHandler<Sender, Args> chain) {
        super();
        this.chain = chain;
    }

    @Override
    public void handle(Sender sender, Args e) {
        if (chain != null) {
            chain.handle(sender, e);
        }
        this.instanceHandle(sender, e);
    }

    abstract protected void instanceHandle(Sender sender, Args e);
}
