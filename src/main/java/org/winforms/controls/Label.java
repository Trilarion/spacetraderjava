package org.winforms.controls;

import org.winforms.Image;
import org.winforms.enums.ContentAlignment;

import javax.swing.*;


// TODO documentation
public class Label extends Control<JLabel> {

    private static final String NEWLINE_LITERAL = "\n";
    private static final String END = "</HTML>";
    private static final String START = "<HTML>";
    private static final String NEWLINE = "<br>";
    public ContentAlignment imageAlignment;
    public ContentAlignment textAlignment;
    private boolean convertedToHtml;

    public Label() {
        super(new JLabel());
    }

    public String getText() {
        String text = ((JLabel) swingComponent).getText();
        if (convertedToHtml) {
            text = text.substring(START.length(), text.length() - END.length());
            text = text.replaceAll(NEWLINE, NEWLINE_LITERAL);
        }
        return text;
    }

    public void setText(String text) {
        if (15 < text.length()) {
            convertedToHtml = true;
            text = START + text.replaceAll(NEWLINE_LITERAL + "\\s*", NEWLINE) + END;
        } else {
            convertedToHtml = false;
        }
        ((JLabel) swingComponent).setText(text);
    }

    public void setImage(Image image) {
        ((JLabel) swingComponent).setIcon(new ImageIcon(image.asSwingImage()));
    }
}
