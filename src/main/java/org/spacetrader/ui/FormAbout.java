package org.spacetrader.ui;

import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FontStyle;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;


public class FormAbout extends wfForm {

    public FormAbout() {
        ComponentResourceManager resources = new ComponentResourceManager(FormAbout.class);
        Button buttonClose = new Button();
        Label lblTitle = new Label();
        Label lblAbout = new Label();
        PictureBox picLogo = new PictureBox();
        ((ISupportInitialize) (picLogo)).BeginInit();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setSize(new FormSize(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
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
        picLogo.setImage(((wfImage) (resources.GetObject("picLogo.Image"))));
        picLogo.setLocation(new Point(8, 8));
        picLogo.setSize(new FormSize(160, 160));
        picLogo.setTabIndex(35);
        picLogo.setTabStop(false);
        // FormAbout
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(446, 191));
        Controls.add(picLogo);
        Controls.add(lblAbout);
        Controls.add(lblTitle);
        Controls.add(buttonClose);
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
