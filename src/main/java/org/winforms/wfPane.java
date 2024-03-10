package org.winforms;

import org.winforms.enums.DialogResult;

import java.awt.*;


public interface wfPane {
    Component asSwingObject();

    void dispose();

    void setResult(DialogResult dialogResult);
}
