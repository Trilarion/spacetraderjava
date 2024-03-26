package org.winforms;

import org.winforms.events.EventData;
import org.winforms.events.EventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO documentation of usage
public class Timer {

    public EventHandler<Object, EventData> tick;
    private final javax.swing.Timer timer = new javax.swing.Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            tick.handle(Timer.this, null);
        }
    });

    public void setInterval(int interval) {
        timer.setDelay(interval);
        timer.setInitialDelay(interval);
    }

    public void Start() {
        timer.start();
    }

    public void Stop() {
        timer.stop();
    }
}
