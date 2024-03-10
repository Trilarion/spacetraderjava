package org.spacetrader.ui;

import org.spacetrader.util.Path;
import org.winforms.FileDialog;


public class SaveFileDialog extends FileDialog {
    public SaveFileDialog() {
        setTitle("Save As");
        setButtonText("Save");
    }

    @Override
    public String getFileName() {
        return Path.getDefaultExtension(super.getFileName(), ".sav");
    }
}
