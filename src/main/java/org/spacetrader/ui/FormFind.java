package org.spacetrader.ui;

import org.winforms.Button;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FlatStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormFind extends wfForm {
    private static String text = "";
    private static boolean boxChecked = false;
    private final CheckBox checkBoxTrack;
    private final TextBox txtSystem;

    public FormFind() {
        Label labelText = new Label();
        Button buttonOk = new Button();
        Button buttonCancel = new Button();
        txtSystem = new TextBox();
        checkBoxTrack = new CheckBox();
        SuspendLayout();
        // labelText
        labelText.setAutoSize(true);
        labelText.setLocation(new Point(8, 8));
        labelText.setName("labelText");
        labelText.setSize(new SizeF(13, 177));
        labelText.setTabIndex(3);
        labelText.setText("Which system are you looking for?");
        // buttonOk
        buttonOk.setDialogResult(DialogResult.OK);
        buttonOk.setFlatStyle(FlatStyle.Flat);
        buttonOk.setLocation(new Point(43, 68));
        buttonOk.setName("buttonOk");
        buttonOk.setSize(new SizeF(22, 40));
        buttonOk.setTabIndex(3);
        buttonOk.setText("Ok");
        // buttonCancel
        buttonCancel.setDialogResult(DialogResult.Cancel);
        buttonCancel.setFlatStyle(FlatStyle.Flat);
        buttonCancel.setLocation(new Point(91, 68));
        buttonCancel.setName("buttonCancel");
        buttonCancel.setSize(new SizeF(22, 50));
        buttonCancel.setTabIndex(4);
        buttonCancel.setText("Cancel");
        // txtSystem
        txtSystem.setLocation(new Point(8, 24));
        txtSystem.setName("txtSystem");
        txtSystem.setSize(new SizeF(20, 168));
        txtSystem.setTabIndex(1);
        txtSystem.setText("");
        // checkBoxTrack
        checkBoxTrack.setLocation(new Point(8, 48));
        checkBoxTrack.setName("checkBoxTrack");
        checkBoxTrack.setSize(new SizeF(16, 112));
        checkBoxTrack.setTabIndex(2);
        checkBoxTrack.setText("Track this system");
        // FormFind
        setAcceptButton(buttonOk);
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonCancel);
        setClientSize(new SizeF(97, 184));
        setControlBox(false);
        Controls.addAll(checkBoxTrack, txtSystem, buttonCancel, buttonOk, labelText);
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
        ResumeLayout(false);
        txtSystem.setText(text);
        checkBoxTrack.setChecked(boxChecked);
    }


    private void FormFind_Closed(Object sender, EventData e) {
        text = txtSystem.getText();
        boxChecked = checkBoxTrack.isChecked();
    }

    public String SystemName() {
        return txtSystem.getText();
    }

    public boolean TrackSystem() {
        return checkBoxTrack.isChecked();
    }
}
