package org.winforms;

import org.winforms.enums.DialogResult;

import java.awt.*;

// TODO documentation of usage
public interface Pane {

    Component asSwingObject();

    void dispose();

    void setResult(DialogResult dialogResult);
}
