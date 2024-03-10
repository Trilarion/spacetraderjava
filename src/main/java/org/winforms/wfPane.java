package org.winforms;

import org.winforms.enums.DialogResult;

import java.awt.*;

// TODO documentation of usage
public interface wfPane {
    Component asSwingObject();

    void dispose();

    void setResult(DialogResult dialogResult);
}
