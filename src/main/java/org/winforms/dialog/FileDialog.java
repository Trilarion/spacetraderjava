package org.winforms.dialog;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


public class FileDialog {
    protected final JFileChooser chooser = new JFileChooser();
    private String buttonText;
    private String filter; // TODO why is filter not used, use?

    public static FileDialog createOpenFileDialog() {
        FileDialog dialog = new FileDialog();
        dialog.setTitle("Open");
        dialog.buttonText = "Open";
        return dialog;
    }

    public static FileDialog createSaveFileDialog() {  // TODO be able to set default file name extension
        FileDialog dialog = new FileDialog();
        dialog.setTitle("Save As");
        dialog.buttonText = "Save";
        return dialog;
    }

    public void setTitle(String title) {
        chooser.setDialogTitle(title);
    }

    protected void setButtonText(String text) {
        buttonText = text;
    }

    public DialogResult ShowDialog(Pane owner) {
        int returnVal = chooser.showDialog(owner.asSwingObject(), buttonText);
        switch (returnVal) {
            case JFileChooser.CANCEL_OPTION:
            case JFileChooser.ERROR_OPTION:
                return DialogResult.Cancel;
            case JFileChooser.APPROVE_OPTION:
                return DialogResult.OK;
            default:
                throw new Error("JFileChooser returned unknown value " + returnVal);
        }
    }

    public void setInitialDirectory(String dir) {
        chooser.setCurrentDirectory(new File(dir));
    }

    public void setFilter(String filter) {
        //setFilter("Windows Bitmaps (*.bmp)|*bmp")
        String[] parts = filter.split("\\|");
        String desc = parts[0];
        String[] extensions = parts[1].split(";");
        // I assume the format is "*.bmp;*.text;*.gif".
        for (int i = 0; i < extensions.length; i++) {
            String extension = extensions[i];
            extensions[i] = extension.substring(extension.lastIndexOf('.') + 1);
        }
        FileFilter filefilter = new FileNameExtensionFilter(desc, extensions);
        chooser.setFileFilter(filefilter);
    }

    public void setDefaultExt(String defaultExt) {
        // TODO implement
    }

    public String getFileName() {
        return chooser.getSelectedFile().getAbsolutePath();
    }

    public void setFileName(String fileName) {
        chooser.setSelectedFile(new File(fileName));
    }
}
