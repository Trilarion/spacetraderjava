package org.spacetrader.main.gui;

import org.jwinforms.Button;
import org.jwinforms.Font;
import org.jwinforms.Label;
import org.jwinforms.*;
import org.jwinforms.enums.*;
import org.spacetrader.main.Functions;
import org.spacetrader.main.Game;

import java.awt.*;


public class FormCosts extends WinformForm {

    public FormCosts() {
        Button btnClose = new Button();
        Label lblMerc = new Label();
        Label lblIns = new Label();
        Label lblInt = new Label();
        Label lblTax = new Label();
        Label lblTotal = new Label();
        Label lblTotalLabel = new Label();
        Label lblTaxLabel = new Label();
        Label lblIntLabel = new Label();
        Label lblMercLabel = new Label();
        Label lblInsLabel = new Label();
        PictureBox picLine = new PictureBox();
        SuspendLayout();
        // btnClose
        btnClose.setDialogResult(DialogResult.Cancel);
        btnClose.setLocation(new Point(-32, -32));
        btnClose.setName("btnClose");
        btnClose.setSize(new FormSize(32, 32));
        btnClose.setTabIndex(32);
        btnClose.setTabStop(false);
        btnClose.setText("X");
        // lblMerc
        lblMerc.setLocation(new Point(104, 8));
        lblMerc.setName("lblMerc");
        lblMerc.setSize(new FormSize(39, 13));
        lblMerc.setTabIndex(36);
        lblMerc.setText("888 cr.");
        lblMerc.TextAlign = ContentAlignment.TopRight;
        // lblIns
        lblIns.setLocation(new Point(104, 24));
        lblIns.setName("lblIns");
        lblIns.setSize(new FormSize(39, 13));
        lblIns.setTabIndex(40);
        lblIns.setText("888 cr.");
        lblIns.TextAlign = ContentAlignment.TopRight;
        // lblInt
        lblInt.setLocation(new Point(104, 40));
        lblInt.setName("lblInt");
        lblInt.setSize(new FormSize(39, 13));
        lblInt.setTabIndex(44);
        lblInt.setText("888 cr.");
        lblInt.TextAlign = ContentAlignment.TopRight;
        // lblTax
        lblTax.setLocation(new Point(104, 56));
        lblTax.setName("lblTax");
        lblTax.setSize(new FormSize(39, 13));
        lblTax.setTabIndex(48);
        lblTax.setText("888 cr.");
        lblTax.TextAlign = ContentAlignment.TopRight;
        // lblTotal
        lblTotal.setLocation(new Point(104, 79));
        lblTotal.setName("lblTotal");
        lblTotal.setSize(new FormSize(39, 13));
        lblTotal.setTabIndex(52);
        lblTotal.setText("888 cr.");
        lblTotal.TextAlign = ContentAlignment.TopRight;
        // lblTotalLabel
        lblTotalLabel.setAutoSize(true);
        lblTotalLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTotalLabel.setLocation(new Point(8, 79));
        lblTotalLabel.setName("lblTotalLabel");
        lblTotalLabel.setSize(new FormSize(34, 13));
        lblTotalLabel.setTabIndex(7);
        lblTotalLabel.setText("Total:");
        // lblTaxLabel
        lblTaxLabel.setAutoSize(true);
        lblTaxLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblTaxLabel.setLocation(new Point(8, 56));
        lblTaxLabel.setName("lblTaxLabel");
        lblTaxLabel.setSize(new FormSize(84, 13));
        lblTaxLabel.setTabIndex(6);
        lblTaxLabel.setText("Wormhole Tax:");
        // lblIntLabel
        lblIntLabel.setAutoSize(true);
        lblIntLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblIntLabel.setLocation(new Point(8, 40));
        lblIntLabel.setName("lblIntLabel");
        lblIntLabel.setSize(new FormSize(47, 13));
        lblIntLabel.setTabIndex(5);
        lblIntLabel.setText("Interest:");
        // lblMercLabel
        lblMercLabel.setAutoSize(true);
        lblMercLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercLabel.setLocation(new Point(8, 8));
        lblMercLabel.setName("lblMercLabel");
        lblMercLabel.setSize(new FormSize(72, 13));
        lblMercLabel.setTabIndex(4);
        lblMercLabel.setText("Mercenaries:");
        // lblInsLabel
        lblInsLabel.setAutoSize(true);
        lblInsLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblInsLabel.setLocation(new Point(8, 24));
        lblInsLabel.setName("lblInsLabel");
        lblInsLabel.setSize(new FormSize(59, 13));
        lblInsLabel.setTabIndex(3);
        lblInsLabel.setText("Insurance:");
        // picLine
        picLine.setBackColor(Color.darkGray);
        picLine.setLocation(new Point(6, 73));
        picLine.setName("picLine");
        picLine.setSize(new FormSize(138, 1));
        picLine.setTabIndex(134);
        picLine.setTabStop(false);
        // FormCosts
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(btnClose);
        setClientSize(new FormSize(148, 99));
        Controls.addAll(picLine, lblTotal, lblTax, lblInt, lblIns, lblMerc, btnClose, lblInsLabel, lblTotalLabel, lblTaxLabel, lblIntLabel, lblMercLabel);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormCosts");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Cost Specification");
        ResumeLayout(false);
        Game game = Game.CurrentGame();
        lblMerc.setText(Functions.FormatMoney(game.MercenaryCosts()));
        lblIns.setText(Functions.FormatMoney(game.InsuranceCosts()));
        lblInt.setText(Functions.FormatMoney(game.InterestCosts()));
        lblTax.setText(Functions.FormatMoney(game.WormholeCosts()));
        lblTotal.setText(Functions.FormatMoney(game.CurrentCosts()));
    }

}
