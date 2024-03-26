package org.spacetrader.ui;

import org.winforms.controls.Button;
import org.winforms.controls.Dialog;
import org.winforms.controls.Label;
import org.winforms.controls.TextField;
import org.winforms.controls.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;
import org.winforms.events.EventData;
import org.winforms.events.EventHandler;

import java.awt.*;


public class DialogFind extends Dialog {
    private static String text = "";
    private static boolean boxChecked;
    private final CheckBox checkBoxTrack;
    private final TextField textSystem;

    public DialogFind() {
        Label labelText = new Label();
        Button buttonOk = new Button();
        Button buttonCancel = new Button();
        textSystem = new TextField();
        checkBoxTrack = new CheckBox();
        suspendLayout();
        // labelText
        labelText.setAutoSize(true);
        labelText.setLocation(new Point(8, 8));
        labelText.setName("labelText");
        labelText.setSize(new Dimension(177, 13));
        labelText.setTabIndex(3);
        labelText.setText("Which system are you looking for?");
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(43, 68));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new Dimension(40, 22));
        buttonOk.setTabIndex(3);
        buttonOk.setText("Ok");
        // buttonCancel
        buttonCancel.setDialogResult(DialogResult.Cancel);
        buttonCancel.setFlatStyle(FlatStyle.Flat);
        buttonCancel.setLocation(new Point(91, 68));
        buttonCancel.setName("buttonCancel");
        buttonCancel.setSize(new Dimension(50, 22));
        buttonCancel.setTabIndex(4);
        buttonCancel.setText("Cancel");
        // textSystem
        textSystem.setLocation(new Point(8, 24));
        textSystem.setName("textSystem");
        textSystem.setSize(new Dimension(168, 20));
        textSystem.setTabIndex(1);
        textSystem.setText("");
        // checkBoxTrack
        checkBoxTrack.setLocation(new Point(8, 48));
        checkBoxTrack.setName("checkBoxTrack");
        checkBoxTrack.setSize(new Dimension(112, 16));
        checkBoxTrack.setTabIndex(2);
        checkBoxTrack.setText("Track this system");
        // FormFind
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonCancel);
        setClientSize(new Dimension(184, 97));
        setControlBox(false);
        Controls.addAll(checkBoxTrack, textSystem, buttonCancel, buttonOk, labelText);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormFind");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Find System");
        Closed = new EventHandler<>() {
            @Override
            public void handle(Object sender, EventData data) {
                FormFind_Closed(sender, data);
            }
        };
        resumeLayout(false);
        textSystem.setText(text);
        checkBoxTrack.setChecked(boxChecked);
    }


    private void FormFind_Closed(Object sender, EventData e) {
        text = textSystem.getText();
        boxChecked = checkBoxTrack.isChecked();
    }

    public String SystemName() {
        return textSystem.getText();
    }

    public boolean TrackSystem() {
        return checkBoxTrack.isChecked();
    }
}
