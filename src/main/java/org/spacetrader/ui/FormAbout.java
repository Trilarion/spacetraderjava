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
        ResourceManager resources = new ResourceManager(FormAbout.class);
        Button buttonClose = new Button();
        Label labelTitle = new Label();
        Label labelAbout = new Label();
        PictureBox pictureLogo = new PictureBox();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setSize(new SizeF(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelTitle
        labelTitle.setAutoSize(true);
        labelTitle.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelTitle.setLocation(new Point(172, 8));
        labelTitle.setSize(new SizeF(13, 187));
        labelTitle.setTabIndex(33);
        labelTitle.setText("Space Trader for Windows 2.01");
        // labelAbout
        labelAbout.setLocation(new Point(172, 32));
        labelAbout.setSize(new SizeF(160, 272));
        labelAbout.setTabIndex(34);
        labelAbout.setText(resources.GetString("labelAbout.Text"));
        // pictureLogo
        pictureLogo.setImage(((wfImage) (resources.GetObject("pictureLogo.Image"))));
        pictureLogo.setLocation(new Point(8, 8));
        pictureLogo.setSize(new SizeF(160, 160));
        pictureLogo.setTabIndex(35);
        pictureLogo.setTabStop(false);
        // FormAbout
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonClose);
        setClientSize(new SizeF(191, 446));
        Controls.add(pictureLogo);
        Controls.add(labelAbout);
        Controls.add(labelTitle);
        Controls.add(buttonClose);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("About Space Trader");
                ResumeLayout(false);
        PerformLayout();
    }

}
