package org.winforms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO documentation of usage
public class Timer {

    public EventHandler<Object, EventData> Tick;
    private javax.swing.Timer timer = new javax.swing.Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            Tick.handle(Timer.this, null);
        }
    });

    public Timer(IContainer components) {
    }

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
