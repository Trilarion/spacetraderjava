package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.controller.enums.ShipyardId;
import org.spacetrader.util.ArrayList;
import org.spacetrader.util.Util;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.Panel;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;


public class FormMonster extends wfForm {
    private final Game game = Game.CurrentGame();
    private final Commander cmdr = game.Commander();
    private final int SplitSystems = 31;
    private Label lblMercIds;
    private Label lblMercNames;
    private Label lblMercSkillsPilot;
    private Label lblMercSkillsFighter;
    private Label lblMercSkillsTrader;
    private Label lblMercSkillsEngineer;
    private Label lblQuests;
    private Label lblShipyards;
    private LinkLabel lblMercSystems;
    private LinkLabel lblMercSystems2;
    private LinkLabel lblQuestSystems;
    private LinkLabel lblShipyardSystems;
    private Integer[] mercIds;
    private Integer[] questSystemIds;
    private Integer[] shipyardSystemIds;

    public FormMonster() {
        Button buttonClose = new Button();
        PictureBox picLine1 = new PictureBox();
        PictureBox picLine0 = new PictureBox();
        Label lblQuestsLabel = new Label();
        Label lblMercLabel = new Label();
        LinkLabel lblMercSkillLabelPilot = new LinkLabel();
        LinkLabel lblMercSkillLabelFighter = new LinkLabel();
        LinkLabel lblMercSkillLabelTrader = new LinkLabel();
        LinkLabel lblMercSkillLabelEngineer = new LinkLabel();
        LinkLabel lblMercSystemLabel = new LinkLabel();
        LinkLabel lblQuestSystemLabel = new LinkLabel();
        LinkLabel lblQuestDescLabel = new LinkLabel();
        LinkLabel lblMercIDLabel = new LinkLabel();
        LinkLabel lblMercNameLabel = new LinkLabel();
        LinkLabel lblShipyardsDescLabel = new LinkLabel();
        LinkLabel lblShipyardsSystemLabel = new LinkLabel();
        Label lblShipyardsLabel = new Label();
        Panel pnlMercs = new Panel();
        lblMercSkillsPilot = new Label();
        lblMercSkillsFighter = new Label();
        lblMercSkillsTrader = new Label();
        lblMercSkillsEngineer = new Label();
        lblMercSystems = new LinkLabel();
        lblMercIds = new Label();
        lblMercNames = new Label();
        lblMercSystems2 = new LinkLabel();
        Panel pnlQuests = new Panel();
        lblQuests = new Label();
        lblQuestSystems = new LinkLabel();
        Panel pnlShipyards = new Panel();
        lblShipyards = new Label();
        lblShipyardSystems = new LinkLabel();
        PictureBox picLine2 = new PictureBox();
        pnlMercs.SuspendLayout();
        pnlQuests.SuspendLayout();
        pnlShipyards.SuspendLayout();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setSize(new FormSize(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // picLine1
        picLine1.setBackColor(Color.darkGray);
        picLine1.setLocation(new Point(4, 40));
        picLine1.setSize(new FormSize(609, 1));
        picLine1.setTabIndex(133);
        picLine1.setTabStop(false);
        // picLine0
        picLine0.setBackColor(Color.darkGray);
        picLine0.setLocation(new Point(234, 8));
        picLine0.setSize(new FormSize(1, 347));
        picLine0.setTabIndex(132);
        picLine0.setTabStop(false);
        // lblQuestsLabel
        lblQuestsLabel.setAutoSize(true);
        lblQuestsLabel.setFont(new Font("Microsoft Sans Serif", 10F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblQuestsLabel.setLocation(new Point(88, 4));
        lblQuestsLabel.setSize(new FormSize(50, 19));
        lblQuestsLabel.setTabIndex(134);
        lblQuestsLabel.setText("Quests");
        // lblMercLabel
        lblMercLabel.setAutoSize(true);
        lblMercLabel.setFont(new Font("Microsoft Sans Serif", 10F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercLabel.setLocation(new Point(348, 4));
        lblMercLabel.setSize(new FormSize(84, 19));
        lblMercLabel.setTabIndex(141);
        lblMercLabel.setText("Mercenaries");
        // lblMercSkillLabelPilot
        lblMercSkillLabelPilot.setAutoSize(true);
        lblMercSkillLabelPilot.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercSkillLabelPilot.setLocation(new Point(341, 24));
        lblMercSkillLabelPilot.setSize(new FormSize(12, 16));
        lblMercSkillLabelPilot.setTabIndex(7);
        lblMercSkillLabelPilot.setTabStop(true);
        lblMercSkillLabelPilot.setText("P");
        lblMercSkillLabelPilot.TextAlign = ContentAlignment.TopRight;
        lblMercSkillLabelPilot.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblMercSkillLabelFighter
        lblMercSkillLabelFighter.setAutoSize(true);
        lblMercSkillLabelFighter.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercSkillLabelFighter.setLocation(new Point(362, 24));
        lblMercSkillLabelFighter.setSize(new FormSize(11, 16));
        lblMercSkillLabelFighter.setTabIndex(8);
        lblMercSkillLabelFighter.setTabStop(true);
        lblMercSkillLabelFighter.setText("F");
        lblMercSkillLabelFighter.TextAlign = ContentAlignment.TopRight;
        lblMercSkillLabelFighter.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblMercSkillLabelTrader
        lblMercSkillLabelTrader.setAutoSize(true);
        lblMercSkillLabelTrader.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercSkillLabelTrader.setLocation(new Point(382, 24));
        lblMercSkillLabelTrader.setSize(new FormSize(11, 16));
        lblMercSkillLabelTrader.setTabIndex(9);
        lblMercSkillLabelTrader.setTabStop(true);
        lblMercSkillLabelTrader.setText("T");
        lblMercSkillLabelTrader.TextAlign = ContentAlignment.TopRight;
        lblMercSkillLabelTrader.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblMercSkillLabelEngineer
        lblMercSkillLabelEngineer.setAutoSize(true);
        lblMercSkillLabelEngineer.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercSkillLabelEngineer.setLocation(new Point(401, 24));
        lblMercSkillLabelEngineer.setSize(new FormSize(12, 16));
        lblMercSkillLabelEngineer.setTabIndex(10);
        lblMercSkillLabelEngineer.setTabStop(true);
        lblMercSkillLabelEngineer.setText("E");
        lblMercSkillLabelEngineer.TextAlign = ContentAlignment.TopRight;
        lblMercSkillLabelEngineer.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblMercSystemLabel
        lblMercSystemLabel.setAutoSize(true);
        lblMercSystemLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercSystemLabel.setLocation(new Point(425, 24));
        lblMercSystemLabel.setSize(new FormSize(43, 16));
        lblMercSystemLabel.setTabIndex(11);
        lblMercSystemLabel.setTabStop(true);
        lblMercSystemLabel.setText("System");
        lblMercSystemLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblQuestSystemLabel
        lblQuestSystemLabel.setAutoSize(true);
        lblQuestSystemLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblQuestSystemLabel.setLocation(new Point(13, 24));
        lblQuestSystemLabel.setSize(new FormSize(43, 16));
        lblQuestSystemLabel.setTabIndex(1);
        lblQuestSystemLabel.setTabStop(true);
        lblQuestSystemLabel.setText("System");
        lblQuestSystemLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblQuestDescLabel
        lblQuestDescLabel.setAutoSize(true);
        lblQuestDescLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblQuestDescLabel.setLocation(new Point(85, 24));
        lblQuestDescLabel.setSize(new FormSize(63, 16));
        lblQuestDescLabel.setTabIndex(2);
        lblQuestDescLabel.setTabStop(true);
        lblQuestDescLabel.setText("Description");
        lblQuestDescLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblMercIDLabel
        lblMercIDLabel.setAutoSize(true);
        lblMercIDLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercIDLabel.setLocation(new Point(247, 24));
        lblMercIDLabel.setSize(new FormSize(16, 16));
        lblMercIDLabel.setTabIndex(5);
        lblMercIDLabel.setTabStop(true);
        lblMercIDLabel.setText("ID");
        lblMercIDLabel.TextAlign = ContentAlignment.TopRight;
        lblMercIDLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblMercNameLabel
        lblMercNameLabel.setAutoSize(true);
        lblMercNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblMercNameLabel.setLocation(new Point(268, 24));
        lblMercNameLabel.setSize(new FormSize(35, 16));
        lblMercNameLabel.setTabIndex(6);
        lblMercNameLabel.setTabStop(true);
        lblMercNameLabel.setText("Name");
        lblMercNameLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblShipyardsDescLabel
        lblShipyardsDescLabel.setAutoSize(true);
        lblShipyardsDescLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblShipyardsDescLabel.setLocation(new Point(85, 258));
        lblShipyardsDescLabel.setSize(new FormSize(63, 16));
        lblShipyardsDescLabel.setTabIndex(4);
        lblShipyardsDescLabel.setTabStop(true);
        lblShipyardsDescLabel.setText("Description");
        lblShipyardsDescLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblShipyardsSystemLabel
        lblShipyardsSystemLabel.setAutoSize(true);
        lblShipyardsSystemLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblShipyardsSystemLabel.setLocation(new Point(13, 258));
        lblShipyardsSystemLabel.setSize(new FormSize(43, 16));
        lblShipyardsSystemLabel.setTabIndex(3);
        lblShipyardsSystemLabel.setTabStop(true);
        lblShipyardsSystemLabel.setText("System");
        lblShipyardsSystemLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SortLinkClicked(sender, e);
            }
        };
        // lblShipyardsLabel
        lblShipyardsLabel.setAutoSize(true);
        lblShipyardsLabel.setFont(new Font("Microsoft Sans Serif", 10F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        lblShipyardsLabel.setLocation(new Point(79, 238));
        lblShipyardsLabel.setSize(new FormSize(68, 19));
        lblShipyardsLabel.setTabIndex(155);
        lblShipyardsLabel.setText("Shipyards");
        // pnlMercs
        pnlMercs.AutoScroll = true;
        pnlMercs.setBorderStyle(BorderStyle.FixedSingle);
        pnlMercs.Controls.add(lblMercSkillsPilot);
        pnlMercs.Controls.add(lblMercSkillsFighter);
        pnlMercs.Controls.add(lblMercSkillsTrader);
        pnlMercs.Controls.add(lblMercSkillsEngineer);
        pnlMercs.Controls.add(lblMercSystems);
        pnlMercs.Controls.add(lblMercIds);
        pnlMercs.Controls.add(lblMercNames);
        pnlMercs.Controls.add(lblMercSystems2);
        pnlMercs.setLocation(new Point(239, 44));
        pnlMercs.setSize(new FormSize(371, 307));
        pnlMercs.setTabIndex(158);
        // lblMercSkillsPilot
        lblMercSkillsPilot.setLocation(new Point(93, 4));
        lblMercSkillsPilot.setSize(new FormSize(20, 563));
        lblMercSkillsPilot.setTabIndex(144);
        lblMercSkillsPilot.TextAlign = ContentAlignment.TopRight;
        // lblMercSkillsFighter
        lblMercSkillsFighter.setLocation(new Point(113, 4));
        lblMercSkillsFighter.setSize(new FormSize(20, 563));
        lblMercSkillsFighter.setTabIndex(145);
        lblMercSkillsFighter.TextAlign = ContentAlignment.TopRight;
        // lblMercSkillsTrader
        lblMercSkillsTrader.setLocation(new Point(133, 4));
        lblMercSkillsTrader.setSize(new FormSize(20, 563));
        lblMercSkillsTrader.setTabIndex(146);
        lblMercSkillsTrader.TextAlign = ContentAlignment.TopRight;
        // lblMercSkillsEngineer
        lblMercSkillsEngineer.setLocation(new Point(153, 4));
        lblMercSkillsEngineer.setSize(new FormSize(20, 563));
        lblMercSkillsEngineer.setTabIndex(147);
        lblMercSkillsEngineer.TextAlign = ContentAlignment.TopRight;
        // lblMercSystems
        lblMercSystems.LinkArea = new LinkArea(0, 0);
        lblMercSystems.setLocation(new Point(185, 4));
        lblMercSystems.setSize(new FormSize(160, 387));
        lblMercSystems.setTabIndex(14);
        lblMercSystems.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SystemLinkClicked(sender, e);
            }
        };
        // lblMercIds
        lblMercIds.setLocation(new Point(0, 4));
        lblMercIds.setSize(new FormSize(23, 563));
        lblMercIds.setTabIndex(142);
        lblMercIds.TextAlign = ContentAlignment.TopRight;
        // lblMercNames
        lblMercNames.setLocation(new Point(28, 4));
        lblMercNames.setSize(new FormSize(69, 563));
        lblMercNames.setTabIndex(141);
        // lblMercSystems2
        lblMercSystems2.LinkArea = new LinkArea(0, 0);
        lblMercSystems2.setLocation(new Point(185, 391));
        lblMercSystems2.setSize(new FormSize(160, 175));
        lblMercSystems2.setTabIndex(148);
        lblMercSystems2.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SystemLinkClicked(sender, e);
            }
        };
        // pnlQuests
        pnlQuests.AutoScroll = true;
        pnlQuests.setBorderStyle(BorderStyle.FixedSingle);
        pnlQuests.Controls.add(lblQuests);
        pnlQuests.Controls.add(lblQuestSystems);
        pnlQuests.setLocation(new Point(8, 44));
        pnlQuests.setSize(new FormSize(222, 182));
        pnlQuests.setTabIndex(159);
        // lblQuests
        lblQuests.setLocation(new Point(76, 4));
        lblQuests.setSize(new FormSize(120, 350));
        lblQuests.setTabIndex(48);
        // lblQuestSystems
        lblQuestSystems.LinkArea = new LinkArea(0, 0);
        lblQuestSystems.setLocation(new Point(4, 4));
        lblQuestSystems.setSize(new FormSize(68, 350));
        lblQuestSystems.setTabIndex(12);
        lblQuestSystems.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SystemLinkClicked(sender, e);
            }
        };
        // pnlShipyards
        pnlShipyards.setBorderStyle(BorderStyle.FixedSingle);
        pnlShipyards.Controls.add(lblShipyards);
        pnlShipyards.Controls.add(lblShipyardSystems);
        pnlShipyards.setLocation(new Point(8, 278));
        pnlShipyards.setSize(new FormSize(222, 73));
        pnlShipyards.setTabIndex(160);
        // lblShipyards
        lblShipyards.setLocation(new Point(76, 4));
        lblShipyards.setSize(new FormSize(120, 63));
        lblShipyards.setTabIndex(158);
        // lblShipyardSystems
        lblShipyardSystems.LinkArea = new LinkArea(0, 0);
        lblShipyardSystems.setLocation(new Point(4, 4));
        lblShipyardSystems.setSize(new FormSize(68, 63));
        lblShipyardSystems.setTabIndex(13);
        lblShipyardSystems.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventArgs e) {
                SystemLinkClicked(sender, e);
            }
        };
        // picLine2
        picLine2.setBackColor(Color.darkGray);
        picLine2.setLocation(new Point(4, 274));
        picLine2.setSize(new FormSize(222, 1));
        picLine2.setTabIndex(161);
        picLine2.setTabStop(false);
        // FormMonster
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(617, 358));
        Controls.add(picLine2);
        Controls.add(pnlShipyards);
        Controls.add(pnlQuests);
        Controls.add(picLine1);
        Controls.add(picLine0);
        Controls.add(pnlMercs);
        Controls.add(lblShipyardsLabel);
        Controls.add(lblShipyardsDescLabel);
        Controls.add(lblShipyardsSystemLabel);
        Controls.add(lblMercNameLabel);
        Controls.add(lblMercIDLabel);
        Controls.add(lblQuestDescLabel);
        Controls.add(lblQuestSystemLabel);
        Controls.add(lblMercSystemLabel);
        Controls.add(lblMercSkillLabelEngineer);
        Controls.add(lblMercSkillLabelTrader);
        Controls.add(lblMercSkillLabelFighter);
        Controls.add(lblMercSkillLabelPilot);
        Controls.add(lblMercLabel);
        Controls.add(lblQuestsLabel);
        Controls.add(buttonClose);
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Monster.com Job Listing");
        pnlMercs.ResumeLayout(false);
        pnlQuests.ResumeLayout(false);
        pnlShipyards.ResumeLayout(false);
        ResumeLayout(false);
        PopulateIdArrays();
        SetLabelHeights();
        UpdateAll();
    }


    private int Compare(int a, int b, String sortWhat, String sortBy) {
        int compareVal = 0;
        if (sortWhat.equals("M")) { // Mercenaries
            CrewMember A = game.Mercenaries()[a];
            CrewMember B = game.Mercenaries()[b];
            boolean strCompare = false;
            Object valA = null;
            Object valB = null;
            switch (SomeStringsForSwitch.valueOf(sortBy)) {
                case I: // Id
                    valA = A.Id().CastToInt();
                    valB = B.Id().CastToInt();
                    break;
                case N: // Name
                    valA = A.Name();
                    valB = B.Name();
                    strCompare = true;
                    break;
                case P: // Pilot
                    valA = A.Pilot();
                    valB = B.Pilot();
                    break;
                case F: // Fighter
                    valA = A.Fighter();
                    valB = B.Fighter();
                    break;
                case T: // Trader
                    valA = A.Trader();
                    valB = B.Trader();
                    break;
                case E: // Engineer
                    valA = A.Engineer();
                    valB = B.Engineer();
                    break;
                case S: // System
                    valA = CurrentSystemDisplay(A);
                    valB = CurrentSystemDisplay(B);
                    strCompare = true;
                    break;
            }
            if (strCompare) {
                compareVal = ((String) valA).compareTo((String) valB);
            } else {
                compareVal = ((Integer) valA).compareTo((Integer) valB);
            }
            // Secondary sort by Name
            if (compareVal == 0 && !"N".equals(sortBy)) {
                compareVal = A.Name().compareTo(B.Name());
            }
        } else {
            StarSystem A = game.Universe()[a];
            StarSystem B = game.Universe()[b];
            if (sortBy.equals("D")) { // Description
                String nameA = "";
                String nameB = "";
                switch (SomeStringsForSwitch.valueOf(sortWhat)) {
                    case Q: // Quests
                        nameA = A.SpecialEvent().Title();
                        nameB = B.SpecialEvent().Title();
                        break;
                    case S: // Shipyards
                        nameA = A.Shipyard().Name();
                        nameB = B.Shipyard().Name();
                        break;
                }
                compareVal = nameA.compareTo(nameB);
            }
            if (compareVal == 0) { // Default sort - System Name
                compareVal = A.Name().compareTo(B.Name());
            }
        }
        return compareVal;
    }

    private String CurrentSystemDisplay(CrewMember merc) {
        return (merc.CurrentSystem() == null
                ? Strings.Unknown : (cmdr.getShip().HasCrew(merc.Id())
                ? Functions.StringVars(Strings.MercOnBoard, merc.CurrentSystem().Name()) : merc.CurrentSystem().Name()));
    }

    private void PopulateIdArrays() {
        // Populate the mercenary ids array.
        ArrayList<Integer> ids = new ArrayList<>();
        for (CrewMember merc : game.Mercenaries()) {
            if (!Util.ArrayContains(Constants.SpecialCrewMemberIds, merc.Id())) {
                ids.add(merc.Id().CastToInt());
            }
        }
        mercIds = ids.toArray(new Integer[0]);
        // Populate the quest and shipyard system ids arrays.
        ArrayList<Integer> quests = new ArrayList<>();
        ArrayList<Integer> shipyards = new ArrayList<>();
        for (StarSystem system : game.Universe()) {
            if (system.ShowSpecialButton()) {
                quests.add(system.Id().CastToInt());
            }
            if (system.ShipyardId() != ShipyardId.NA) {
                shipyards.add(system.Id().CastToInt());
            }
        }
        questSystemIds = quests.toArray(new Integer[0]);
        shipyardSystemIds = shipyards.toArray(new Integer[0]);
        // Sort the arrays.
        Sort("M", "N"); // Sort mercenaries by name.
        Sort("Q", "S"); // Sort quests by system name.
        Sort("S", "S"); // Sort shipyards by system name.
    }

    private void SetLabelHeights() {
        int questHeight = (int) Math.ceil(questSystemIds.length * 12.5) + 1;
        lblQuests.setHeight(questHeight);
        lblQuestSystems.setHeight(questHeight);
        int shipyardHeight = (int) Math.ceil(shipyardSystemIds.length * 12.5) + 1;
        lblShipyards.setHeight(shipyardHeight);
        lblShipyardSystems.setHeight(shipyardHeight);
        int mercHeight = (int) Math.ceil(mercIds.length * 12.5) + 1;
        lblMercIds.setHeight(mercHeight);
        lblMercNames.setHeight(mercHeight);
        lblMercSkillsPilot.setHeight(mercHeight);
        lblMercSkillsFighter.setHeight(mercHeight);
        lblMercSkillsTrader.setHeight(mercHeight);
        lblMercSkillsEngineer.setHeight(mercHeight);
        // Due to a limitation of the LinkLabel control, no more than 32 links can exist in the LinkLabel.
        lblMercSystems.setHeight((int) Math.ceil(Math.min(mercIds.length, SplitSystems) * 12.5) + 1);
        if (mercIds.length > SplitSystems) {
            lblMercSystems2.setVisible(true);
            lblMercSystems2.setHeight((int) Math.ceil((mercIds.length - SplitSystems) * 12.5) + 1);
        } else {
            lblMercSystems2.setVisible(false);
            lblMercSystems2.setTop(lblMercSystems.getTop());
        }
    }

    private void Sort(String sortWhat, String sortBy) {
        Integer[] array = null;
        switch (SomeStringsForSwitch.valueOf(sortWhat)) {
            case M:
                array = mercIds;
                break;
            case Q:
                array = questSystemIds;
                break;
            case S:
                array = shipyardSystemIds;
                break;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (Compare(array[j], array[j + 1], sortWhat, sortBy) > 0) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void UpdateAll() {
        UpdateMercs();
        UpdateQuests();
        UpdateShipyards();
    }

    private void UpdateMercs() {
        lblMercIds.setText("");
        lblMercNames.setText("");
        lblMercSkillsPilot.setText("");
        lblMercSkillsFighter.setText("");
        lblMercSkillsTrader.setText("");
        lblMercSkillsEngineer.setText("");
        lblMercSystems.setText("");
        lblMercSystems2.setText("");
        lblMercSystems.Links.clear();
        lblMercSystems2.Links.clear();
        for (int i = 0; i < mercIds.length; i++) {
            CrewMember merc = game.Mercenaries()[mercIds[i]];
            boolean link = merc.CurrentSystem() != null && !cmdr.getShip().HasCrew(merc.Id());
            lblMercIds.setText(lblMercIds.getText() + ((merc.Id().CastToInt()) + Strings.newline));
            lblMercNames.setText(lblMercNames.getText() + (merc.Name() + Strings.newline));
            lblMercSkillsPilot.setText(lblMercSkillsPilot.getText() + (merc.Pilot() + Strings.newline));
            lblMercSkillsFighter.setText(lblMercSkillsFighter.getText() + (merc.Fighter() + Strings.newline));
            lblMercSkillsTrader.setText(lblMercSkillsTrader.getText() + (merc.Trader() + Strings.newline));
            lblMercSkillsEngineer.setText(lblMercSkillsEngineer.getText() + (merc.Engineer() + Strings.newline));
            if (i < SplitSystems) {
                int start = lblMercSystems.getText().length();
                lblMercSystems.setText(lblMercSystems.getText() + (CurrentSystemDisplay(merc) + Strings.newline));
                if (link) {
                    lblMercSystems.Links.add(start, merc.CurrentSystem().Name().length(), merc.CurrentSystem().Name());
                }
            } else {
                int start = lblMercSystems2.getText().length();
                lblMercSystems2.setText(lblMercSystems2.getText() + (CurrentSystemDisplay(merc) + Strings.newline));
                if (link) {
                    lblMercSystems2.Links.add(start, merc.CurrentSystem().Name().length(), merc.CurrentSystem().Name());
                }
            }
        }
        lblMercIds.setText(lblMercIds.getText().trim());
        lblMercNames.setText(lblMercNames.getText().trim());
        lblMercSkillsPilot.setText(lblMercSkillsPilot.getText().trim());
        lblMercSkillsFighter.setText(lblMercSkillsFighter.getText().trim());
        lblMercSkillsTrader.setText(lblMercSkillsTrader.getText().trim());
        lblMercSkillsEngineer.setText(lblMercSkillsEngineer.getText().trim());
        lblMercSystems.setText(lblMercSystems.getText().trim());
        lblMercSystems2.setText(lblMercSystems2.getText().trim());
    }

    private void UpdateQuests() {
        lblQuestSystems.setText("");
        lblQuests.setText("");
        lblQuestSystems.Links.clear();
        for (Integer questSystemId : questSystemIds) {
            StarSystem system = game.Universe()[questSystemId];
            int start = lblQuestSystems.getText().length();
            lblQuestSystems.setText(lblQuestSystems.getText() + (system.Name() + Strings.newline));
            lblQuests.setText(lblQuests.getText() + (system.SpecialEvent().Title() + Strings.newline));
            lblQuestSystems.Links.add(start, system.Name().length(), system.Name());
        }
        lblQuestSystems.setText(lblQuestSystems.getText().trim());
        lblQuests.setText(lblQuests.getText().trim());
    }

    private void UpdateShipyards() {
        lblShipyardSystems.setText("");
        lblShipyards.setText("");
        lblShipyardSystems.Links.clear();
        for (Integer shipyardSystemId : shipyardSystemIds) {
            StarSystem system = game.Universe()[shipyardSystemId];
            int start = lblShipyardSystems.getText().length();
            lblShipyardSystems.setText(lblShipyardSystems.getText() + (system.Name() + Strings.newline));
            lblShipyards.setText(lblShipyards.getText() + (system.Shipyard().Name() + Strings.newline));
            lblShipyardSystems.Links.add(start, system.Name().length(), system.Name());
        }
        lblShipyardSystems.setText(lblShipyardSystems.getText().trim());
        lblShipyards.setText(lblShipyards.getText().trim());
    }

    private void SystemLinkClicked(Object sender, LinkLabelLinkClickedEventArgs e) {
        game.setSelectedSystemByName(e.Link.LinkData.toString());
        game.getParentWindow().UpdateAll();
        Close();
    }

    private void SortLinkClicked(Object sender, LinkLabelLinkClickedEventArgs e) {
        Sort(((LinkLabel) sender).getName().substring(3, 1), ((LinkLabel) sender).getText().substring(0, 1));
        UpdateAll();
    }
}
