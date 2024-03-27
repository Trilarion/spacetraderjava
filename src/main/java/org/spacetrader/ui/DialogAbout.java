package org.spacetrader.ui;

import org.winforms.util.Font;
import org.winforms.image.Image;
import org.winforms.resource.ResourceManager;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.Label;
import org.winforms.widget.PictureBox;
import org.winforms.dialog.DialogResult;
import org.winforms.style.FontStyle;
import org.winforms.style.FormBorderStyle;
import org.winforms.alignment.FormStartPosition;

import java.awt.*;


public class DialogAbout extends Dialog {

    public DialogAbout() {
        final ResourceManager resources = new ResourceManager(DialogAbout.class);
        final Button buttonClose = new Button();
        final Label labelTitle = new Label();
        final Label labelAbout = new Label();
        final PictureBox pictureLogo = new PictureBox();
        suspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setSize(new Dimension(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelTitle
        labelTitle.setAutoSize(true);
        labelTitle.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelTitle.setLocation(new Point(172, 8));
        labelTitle.setSize(new Dimension(187, 13));
        labelTitle.setTabIndex(33);
        labelTitle.setText("Space Trader for Windows 2.01");
        // labelAbout
        labelAbout.setLocation(new Point(172, 32));
        labelAbout.setSize(new Dimension(272, 160));
        labelAbout.setTabIndex(34);
        labelAbout.setText(resources.getString("labelAbout.Text"));
        // pictureLogo
        pictureLogo.setImage(((Image) (resources.getObject("pictureLogo.Image"))));
        pictureLogo.setLocation(new Point(8, 8));
        pictureLogo.setSize(new Dimension(160, 160));
        pictureLogo.setTabIndex(35);
        pictureLogo.setTabStop(false);
        // FormAbout
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new Dimension(446, 191));
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
        resumeLayout(false);
        PerformLayout();
    }

}
