package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Font;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.DialogResult;
import org.jwinforms.enums.FontStyle;
import org.jwinforms.enums.FormBorderStyle;
import org.jwinforms.enums.FormStartPosition;

import java.awt.*;


public class FormAbout extends WinformForm {

    public FormAbout() {
        ComponentResourceManager resources = new ComponentResourceManager(FormAbout.class);
        Button btnClose = new Button();
        Label lblTitle = new Label();
        Label lblAbout = new Label();
        PictureBox picLogo = new PictureBox();
        ((ISupportInitialize) (picLogo)).BeginInit();
        SuspendLayout();
        // btnClose
        btnClose.setDialogResult(DialogResult.Cancel);
        btnClose.setLocation(new Point(-32, -32));
        btnClose.setSize(new FormSize(32, 32));
        btnClose.setTabIndex(32);
        btnClose.setTabStop(false);
        btnClose.setText("X");
        // lblTitle
        lblTitle.setAutoSize(true);
        lblTitle.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTitle.setLocation(new Point(172, 8));
        lblTitle.setSize(new FormSize(187, 13));
        lblTitle.setTabIndex(33);
        lblTitle.setText("Space Trader for Windows 2.01");
        // lblAbout
        lblAbout.setLocation(new Point(172, 32));
        lblAbout.setSize(new FormSize(272, 160));
        lblAbout.setTabIndex(34);
        lblAbout.setText(resources.GetString("lblAbout.Text"));
        // picLogo
        picLogo.setImage(((WfImage) (resources.GetObject("picLogo.Image"))));
        picLogo.setLocation(new Point(8, 8));
        picLogo.setSize(new FormSize(160, 160));
        picLogo.setTabIndex(35);
        picLogo.setTabStop(false);
        // FormAbout
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnClose);
        setClientSize(new FormSize(446, 191));
        Controls.add(picLogo);
        Controls.add(lblAbout);
        Controls.add(lblTitle);
        Controls.add(btnClose);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("About Space Trader");
        ((ISupportInitialize) (picLogo)).EndInit();
        ResumeLayout(false);
        PerformLayout();
    }

}
