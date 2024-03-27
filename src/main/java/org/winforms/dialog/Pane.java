package org.winforms.dialog;

import java.awt.*;

// TODO documentation of usage
public interface Pane {

    Component asSwingObject();

    void dispose();

    void setResult(DialogResult dialogResult);
}
