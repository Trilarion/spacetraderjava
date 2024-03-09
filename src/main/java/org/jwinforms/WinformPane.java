package org.jwinforms;

import org.jwinforms.enums.DialogResult;

import java.awt.*;


public interface WinformPane {
    Component asSwingObject();

    void dispose();

    void setResult(DialogResult dialogResult);
}
