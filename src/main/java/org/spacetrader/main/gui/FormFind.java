package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.DialogResult;
import org.jwinforms.enums.FlatStyle;
import org.jwinforms.enums.FormBorderStyle;
import org.jwinforms.enums.FormStartPosition;

import java.awt.*;


public class FormFind extends WinformForm {
    private static String text = "";
    private static boolean boxChecked = false;
    private Button btnOk;
    private Button btnCancel;
    private CheckBox chkTrack;
    private Label lblText;
    private TextBox txtSystem;

    public FormFind() {
        InitializeComponent();
        txtSystem.setText(text);
        chkTrack.setChecked(boxChecked);
    }

    // Required method for Designer support - do not modify the contents of this method with the code editor.
    private void InitializeComponent() {
        lblText = new Label();
        btnOk = new Button();
        btnCancel = new Button();
        txtSystem = new TextBox();
        chkTrack = new CheckBox();
        SuspendLayout();
        // lblText
        lblText.setAutoSize(true);
        lblText.setLocation(new Point(8, 8));
        lblText.setName("lblText");
        lblText.setSize(new FormSize(177, 13));
        lblText.setTabIndex(3);
        lblText.setText("Which system are you looking for?");
        // btnOk
        btnOk.setDialogResult(DialogResult.OK);
        btnOk.setFlatStyle(FlatStyle.Flat);
        btnOk.setLocation(new Point(43, 68));
        btnOk.setName("btnOk");
        btnOk.setSize(new FormSize(40, 22));
        btnOk.setTabIndex(3);
        btnOk.setText("Ok");
        // btnCancel
        btnCancel.setDialogResult(DialogResult.Cancel);
        btnCancel.setFlatStyle(FlatStyle.Flat);
        btnCancel.setLocation(new Point(91, 68));
        btnCancel.setName("btnCancel");
        btnCancel.setSize(new FormSize(50, 22));
        btnCancel.setTabIndex(4);
        btnCancel.setText("Cancel");
        // txtSystem
        txtSystem.setLocation(new Point(8, 24));
        txtSystem.setName("txtSystem");
        txtSystem.setSize(new FormSize(168, 20));
        txtSystem.setTabIndex(1);
        txtSystem.setText("");
        // chkTrack
        chkTrack.setLocation(new Point(8, 48));
        chkTrack.setName("chkTrack");
        chkTrack.setSize(new FormSize(112, 16));
        chkTrack.setTabIndex(2);
        chkTrack.setText("Track this system");
        // FormFind
        setAcceptButton(btnOk);
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnCancel);
        setClientSize(new FormSize(184, 97));
        setControlBox(false);
        Controls.addAll(chkTrack, txtSystem, btnCancel, btnOk, lblText);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setName("FormFind");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Find System");
        Closed = new EventHandler<Object, EventArgs>() {
            @Override
            public void handle(Object sender, EventArgs e) {
                FormFind_Closed(sender, e);
            }
        };
        ResumeLayout(false);
    }

    private void FormFind_Closed(Object sender, EventArgs e) {
        text = txtSystem.getText();
        boxChecked = chkTrack.isChecked();
    }

    public String SystemName() {
        return txtSystem.getText();
    }

    public boolean TrackSystem() {
        return chkTrack.isChecked();
    }
}
