package org.spacetrader.ui;

import org.spacetrader.controller.*;
import org.spacetrader.controller.enums.ShipyardId;
import java.util.ArrayList;
import org.spacetrader.util.Util;
import org.winforms.Button;
import org.winforms.Font;
import org.winforms.Label;
import org.winforms.Panel;
import org.winforms.*;
import org.winforms.enums.*;

import java.awt.*;


public class FormMonster extends wfForm {
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final int SplitSystems = 31;
    private Label labelMercIds;
    private Label labelMercNames;
    private Label labelMercSkillsPilot;
    private Label labelMercSkillsFighter;
    private Label labelMercSkillsTrader;
    private Label labelMercSkillsEngineer;
    private Label labelQuests;
    private Label labelShipyards;
    private LinkLabel labelMercSystems;
    private LinkLabel labelMercSystems2;
    private LinkLabel labelQuestSystems;
    private LinkLabel labelShipyardSystems;
    private Integer[] mercIds;
    private Integer[] questSystemIds;
    private Integer[] shipyardSystemIds;

    public FormMonster() {
        Button buttonClose = new Button();
        PictureBox pictureLine1 = new PictureBox();
        PictureBox pictureLine0 = new PictureBox();
        Label labelQuestsLabel = new Label();
        Label labelMercLabel = new Label();
        LinkLabel labelMercSkillLabelPilot = new LinkLabel();
        LinkLabel labelMercSkillLabelFighter = new LinkLabel();
        LinkLabel labelMercSkillLabelTrader = new LinkLabel();
        LinkLabel labelMercSkillLabelEngineer = new LinkLabel();
        LinkLabel labelMercSystemLabel = new LinkLabel();
        LinkLabel labelQuestSystemLabel = new LinkLabel();
        LinkLabel labelQuestDescLabel = new LinkLabel();
        LinkLabel labelMercIDLabel = new LinkLabel();
        LinkLabel labelMercNameLabel = new LinkLabel();
        LinkLabel labelShipyardsDescLabel = new LinkLabel();
        LinkLabel labelShipyardsSystemLabel = new LinkLabel();
        Label labelShipyardsLabel = new Label();
        Panel pnlMercs = new Panel();
        labelMercSkillsPilot = new Label();
        labelMercSkillsFighter = new Label();
        labelMercSkillsTrader = new Label();
        labelMercSkillsEngineer = new Label();
        labelMercSystems = new LinkLabel();
        labelMercIds = new Label();
        labelMercNames = new Label();
        labelMercSystems2 = new LinkLabel();
        Panel pnlQuests = new Panel();
        labelQuests = new Label();
        labelQuestSystems = new LinkLabel();
        Panel pnlShipyards = new Panel();
        labelShipyards = new Label();
        labelShipyardSystems = new LinkLabel();
        PictureBox pictureLine2 = new PictureBox();
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
        // pictureLine1
        pictureLine1.setBackColor(Color.darkGray);
        pictureLine1.setLocation(new Point(4, 40));
        pictureLine1.setSize(new FormSize(609, 1));
        pictureLine1.setTabIndex(133);
        pictureLine1.setTabStop(false);
        // pictureLine0
        pictureLine0.setBackColor(Color.darkGray);
        pictureLine0.setLocation(new Point(234, 8));
        pictureLine0.setSize(new FormSize(1, 347));
        pictureLine0.setTabIndex(132);
        pictureLine0.setTabStop(false);
        // labelQuestsLabel
        labelQuestsLabel.setAutoSize(true);
        labelQuestsLabel.setFont(new Font("Microsoft Sans Serif", 10F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelQuestsLabel.setLocation(new Point(88, 4));
        labelQuestsLabel.setSize(new FormSize(50, 19));
        labelQuestsLabel.setTabIndex(134);
        labelQuestsLabel.setText("Quests");
        // labelMercLabel
        labelMercLabel.setAutoSize(true);
        labelMercLabel.setFont(new Font("Microsoft Sans Serif", 10F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercLabel.setLocation(new Point(348, 4));
        labelMercLabel.setSize(new FormSize(84, 19));
        labelMercLabel.setTabIndex(141);
        labelMercLabel.setText("Mercenaries");
        // labelMercSkillLabelPilot
        labelMercSkillLabelPilot.setAutoSize(true);
        labelMercSkillLabelPilot.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercSkillLabelPilot.setLocation(new Point(341, 24));
        labelMercSkillLabelPilot.setSize(new FormSize(12, 16));
        labelMercSkillLabelPilot.setTabIndex(7);
        labelMercSkillLabelPilot.setTabStop(true);
        labelMercSkillLabelPilot.setText("P");
        labelMercSkillLabelPilot.TextAlign = ContentAlignment.TopRight;
        labelMercSkillLabelPilot.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelMercSkillLabelFighter
        labelMercSkillLabelFighter.setAutoSize(true);
        labelMercSkillLabelFighter.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercSkillLabelFighter.setLocation(new Point(362, 24));
        labelMercSkillLabelFighter.setSize(new FormSize(11, 16));
        labelMercSkillLabelFighter.setTabIndex(8);
        labelMercSkillLabelFighter.setTabStop(true);
        labelMercSkillLabelFighter.setText("F");
        labelMercSkillLabelFighter.TextAlign = ContentAlignment.TopRight;
        labelMercSkillLabelFighter.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelMercSkillLabelTrader
        labelMercSkillLabelTrader.setAutoSize(true);
        labelMercSkillLabelTrader.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercSkillLabelTrader.setLocation(new Point(382, 24));
        labelMercSkillLabelTrader.setSize(new FormSize(11, 16));
        labelMercSkillLabelTrader.setTabIndex(9);
        labelMercSkillLabelTrader.setTabStop(true);
        labelMercSkillLabelTrader.setText("T");
        labelMercSkillLabelTrader.TextAlign = ContentAlignment.TopRight;
        labelMercSkillLabelTrader.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelMercSkillLabelEngineer
        labelMercSkillLabelEngineer.setAutoSize(true);
        labelMercSkillLabelEngineer.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercSkillLabelEngineer.setLocation(new Point(401, 24));
        labelMercSkillLabelEngineer.setSize(new FormSize(12, 16));
        labelMercSkillLabelEngineer.setTabIndex(10);
        labelMercSkillLabelEngineer.setTabStop(true);
        labelMercSkillLabelEngineer.setText("E");
        labelMercSkillLabelEngineer.TextAlign = ContentAlignment.TopRight;
        labelMercSkillLabelEngineer.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelMercSystemLabel
        labelMercSystemLabel.setAutoSize(true);
        labelMercSystemLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercSystemLabel.setLocation(new Point(425, 24));
        labelMercSystemLabel.setSize(new FormSize(43, 16));
        labelMercSystemLabel.setTabIndex(11);
        labelMercSystemLabel.setTabStop(true);
        labelMercSystemLabel.setText("System");
        labelMercSystemLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelQuestSystemLabel
        labelQuestSystemLabel.setAutoSize(true);
        labelQuestSystemLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelQuestSystemLabel.setLocation(new Point(13, 24));
        labelQuestSystemLabel.setSize(new FormSize(43, 16));
        labelQuestSystemLabel.setTabIndex(1);
        labelQuestSystemLabel.setTabStop(true);
        labelQuestSystemLabel.setText("System");
        labelQuestSystemLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelQuestDescLabel
        labelQuestDescLabel.setAutoSize(true);
        labelQuestDescLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelQuestDescLabel.setLocation(new Point(85, 24));
        labelQuestDescLabel.setSize(new FormSize(63, 16));
        labelQuestDescLabel.setTabIndex(2);
        labelQuestDescLabel.setTabStop(true);
        labelQuestDescLabel.setText("Description");
        labelQuestDescLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelMercIDLabel
        labelMercIDLabel.setAutoSize(true);
        labelMercIDLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercIDLabel.setLocation(new Point(247, 24));
        labelMercIDLabel.setSize(new FormSize(16, 16));
        labelMercIDLabel.setTabIndex(5);
        labelMercIDLabel.setTabStop(true);
        labelMercIDLabel.setText("ID");
        labelMercIDLabel.TextAlign = ContentAlignment.TopRight;
        labelMercIDLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelMercNameLabel
        labelMercNameLabel.setAutoSize(true);
        labelMercNameLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelMercNameLabel.setLocation(new Point(268, 24));
        labelMercNameLabel.setSize(new FormSize(35, 16));
        labelMercNameLabel.setTabIndex(6);
        labelMercNameLabel.setTabStop(true);
        labelMercNameLabel.setText("Name");
        labelMercNameLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelShipyardsDescLabel
        labelShipyardsDescLabel.setAutoSize(true);
        labelShipyardsDescLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelShipyardsDescLabel.setLocation(new Point(85, 258));
        labelShipyardsDescLabel.setSize(new FormSize(63, 16));
        labelShipyardsDescLabel.setTabIndex(4);
        labelShipyardsDescLabel.setTabStop(true);
        labelShipyardsDescLabel.setText("Description");
        labelShipyardsDescLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelShipyardsSystemLabel
        labelShipyardsSystemLabel.setAutoSize(true);
        labelShipyardsSystemLabel.setFont(new Font("Microsoft Sans Serif", 8.25F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelShipyardsSystemLabel.setLocation(new Point(13, 258));
        labelShipyardsSystemLabel.setSize(new FormSize(43, 16));
        labelShipyardsSystemLabel.setTabIndex(3);
        labelShipyardsSystemLabel.setTabStop(true);
        labelShipyardsSystemLabel.setText("System");
        labelShipyardsSystemLabel.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SortLinkClicked(sender, e);
            }
        };
        // labelShipyardsLabel
        labelShipyardsLabel.setAutoSize(true);
        labelShipyardsLabel.setFont(new Font("Microsoft Sans Serif", 10F, FontStyle.Bold, GraphicsUnit.Point, ((byte) (0))));
        labelShipyardsLabel.setLocation(new Point(79, 238));
        labelShipyardsLabel.setSize(new FormSize(68, 19));
        labelShipyardsLabel.setTabIndex(155);
        labelShipyardsLabel.setText("Shipyards");
        // pnlMercs
        pnlMercs.AutoScroll = true;
        pnlMercs.setBorderStyle(BorderStyle.FixedSingle);
        pnlMercs.Controls.add(labelMercSkillsPilot);
        pnlMercs.Controls.add(labelMercSkillsFighter);
        pnlMercs.Controls.add(labelMercSkillsTrader);
        pnlMercs.Controls.add(labelMercSkillsEngineer);
        pnlMercs.Controls.add(labelMercSystems);
        pnlMercs.Controls.add(labelMercIds);
        pnlMercs.Controls.add(labelMercNames);
        pnlMercs.Controls.add(labelMercSystems2);
        pnlMercs.setLocation(new Point(239, 44));
        pnlMercs.setSize(new FormSize(371, 307));
        pnlMercs.setTabIndex(158);
        // labelMercSkillsPilot
        labelMercSkillsPilot.setLocation(new Point(93, 4));
        labelMercSkillsPilot.setSize(new FormSize(20, 563));
        labelMercSkillsPilot.setTabIndex(144);
        labelMercSkillsPilot.TextAlign = ContentAlignment.TopRight;
        // labelMercSkillsFighter
        labelMercSkillsFighter.setLocation(new Point(113, 4));
        labelMercSkillsFighter.setSize(new FormSize(20, 563));
        labelMercSkillsFighter.setTabIndex(145);
        labelMercSkillsFighter.TextAlign = ContentAlignment.TopRight;
        // labelMercSkillsTrader
        labelMercSkillsTrader.setLocation(new Point(133, 4));
        labelMercSkillsTrader.setSize(new FormSize(20, 563));
        labelMercSkillsTrader.setTabIndex(146);
        labelMercSkillsTrader.TextAlign = ContentAlignment.TopRight;
        // labelMercSkillsEngineer
        labelMercSkillsEngineer.setLocation(new Point(153, 4));
        labelMercSkillsEngineer.setSize(new FormSize(20, 563));
        labelMercSkillsEngineer.setTabIndex(147);
        labelMercSkillsEngineer.TextAlign = ContentAlignment.TopRight;
        // labelMercSystems
        labelMercSystems.LinkArea = new LinkArea(0, 0);
        labelMercSystems.setLocation(new Point(185, 4));
        labelMercSystems.setSize(new FormSize(160, 387));
        labelMercSystems.setTabIndex(14);
        labelMercSystems.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SystemLinkClicked(sender, e);
            }
        };
        // labelMercIds
        labelMercIds.setLocation(new Point(0, 4));
        labelMercIds.setSize(new FormSize(23, 563));
        labelMercIds.setTabIndex(142);
        labelMercIds.TextAlign = ContentAlignment.TopRight;
        // labelMercNames
        labelMercNames.setLocation(new Point(28, 4));
        labelMercNames.setSize(new FormSize(69, 563));
        labelMercNames.setTabIndex(141);
        // labelMercSystems2
        labelMercSystems2.LinkArea = new LinkArea(0, 0);
        labelMercSystems2.setLocation(new Point(185, 391));
        labelMercSystems2.setSize(new FormSize(160, 175));
        labelMercSystems2.setTabIndex(148);
        labelMercSystems2.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SystemLinkClicked(sender, e);
            }
        };
        // pnlQuests
        pnlQuests.AutoScroll = true;
        pnlQuests.setBorderStyle(BorderStyle.FixedSingle);
        pnlQuests.Controls.add(labelQuests);
        pnlQuests.Controls.add(labelQuestSystems);
        pnlQuests.setLocation(new Point(8, 44));
        pnlQuests.setSize(new FormSize(222, 182));
        pnlQuests.setTabIndex(159);
        // labelQuests
        labelQuests.setLocation(new Point(76, 4));
        labelQuests.setSize(new FormSize(120, 350));
        labelQuests.setTabIndex(48);
        // labelQuestSystems
        labelQuestSystems.LinkArea = new LinkArea(0, 0);
        labelQuestSystems.setLocation(new Point(4, 4));
        labelQuestSystems.setSize(new FormSize(68, 350));
        labelQuestSystems.setTabIndex(12);
        labelQuestSystems.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SystemLinkClicked(sender, e);
            }
        };
        // pnlShipyards
        pnlShipyards.setBorderStyle(BorderStyle.FixedSingle);
        pnlShipyards.Controls.add(labelShipyards);
        pnlShipyards.Controls.add(labelShipyardSystems);
        pnlShipyards.setLocation(new Point(8, 278));
        pnlShipyards.setSize(new FormSize(222, 73));
        pnlShipyards.setTabIndex(160);
        // labelShipyards
        labelShipyards.setLocation(new Point(76, 4));
        labelShipyards.setSize(new FormSize(120, 63));
        labelShipyards.setTabIndex(158);
        // labelShipyardSystems
        labelShipyardSystems.LinkArea = new LinkArea(0, 0);
        labelShipyardSystems.setLocation(new Point(4, 4));
        labelShipyardSystems.setSize(new FormSize(68, 63));
        labelShipyardSystems.setTabIndex(13);
        labelShipyardSystems.LinkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData e) {
                SystemLinkClicked(sender, e);
            }
        };
        // pictureLine2
        pictureLine2.setBackColor(Color.darkGray);
        pictureLine2.setLocation(new Point(4, 274));
        pictureLine2.setSize(new FormSize(222, 1));
        pictureLine2.setTabIndex(161);
        pictureLine2.setTabStop(false);
        // FormMonster
        setAutoScaleBaseSize(new FormSize(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new FormSize(617, 358));
        Controls.add(pictureLine2);
        Controls.add(pnlShipyards);
        Controls.add(pnlQuests);
        Controls.add(pictureLine1);
        Controls.add(pictureLine0);
        Controls.add(pnlMercs);
        Controls.add(labelShipyardsLabel);
        Controls.add(labelShipyardsDescLabel);
        Controls.add(labelShipyardsSystemLabel);
        Controls.add(labelMercNameLabel);
        Controls.add(labelMercIDLabel);
        Controls.add(labelQuestDescLabel);
        Controls.add(labelQuestSystemLabel);
        Controls.add(labelMercSystemLabel);
        Controls.add(labelMercSkillLabelEngineer);
        Controls.add(labelMercSkillLabelTrader);
        Controls.add(labelMercSkillLabelFighter);
        Controls.add(labelMercSkillLabelPilot);
        Controls.add(labelMercLabel);
        Controls.add(labelQuestsLabel);
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
                ? Strings.Unknown : (commander.getShip().HasCrew(merc.Id())
                ? Functions.StringVars(Strings.MercOnBoard, merc.CurrentSystem().Name()) : merc.CurrentSystem().Name()));
    }

    private void PopulateIdArrays() {
        // Populate the mercenary ids array.
        ArrayList<Integer> ids = new ArrayList<>();
        for (CrewMember merc : game.Mercenaries()) {
            if (!Util.arrayContains(Constants.SpecialCrewMemberIds, merc.Id())) {
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
        labelQuests.setHeight(questHeight);
        labelQuestSystems.setHeight(questHeight);
        int shipyardHeight = (int) Math.ceil(shipyardSystemIds.length * 12.5) + 1;
        labelShipyards.setHeight(shipyardHeight);
        labelShipyardSystems.setHeight(shipyardHeight);
        int mercHeight = (int) Math.ceil(mercIds.length * 12.5) + 1;
        labelMercIds.setHeight(mercHeight);
        labelMercNames.setHeight(mercHeight);
        labelMercSkillsPilot.setHeight(mercHeight);
        labelMercSkillsFighter.setHeight(mercHeight);
        labelMercSkillsTrader.setHeight(mercHeight);
        labelMercSkillsEngineer.setHeight(mercHeight);
        // Due to a limitation of the LinkLabel control, no more than 32 links can exist in the LinkLabel.
        labelMercSystems.setHeight((int) Math.ceil(Math.min(mercIds.length, SplitSystems) * 12.5) + 1);
        if (mercIds.length > SplitSystems) {
            labelMercSystems2.setVisible(true);
            labelMercSystems2.setHeight((int) Math.ceil((mercIds.length - SplitSystems) * 12.5) + 1);
        } else {
            labelMercSystems2.setVisible(false);
            labelMercSystems2.setTop(labelMercSystems.getTop());
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
        labelMercIds.setText("");
        labelMercNames.setText("");
        labelMercSkillsPilot.setText("");
        labelMercSkillsFighter.setText("");
        labelMercSkillsTrader.setText("");
        labelMercSkillsEngineer.setText("");
        labelMercSystems.setText("");
        labelMercSystems2.setText("");
        labelMercSystems.Links.clear();
        labelMercSystems2.Links.clear();
        for (int i = 0; i < mercIds.length; i++) {
            CrewMember merc = game.Mercenaries()[mercIds[i]];
            boolean link = merc.CurrentSystem() != null && !commander.getShip().HasCrew(merc.Id());
            labelMercIds.setText(labelMercIds.getText() + ((merc.Id().CastToInt()) + Strings.newline));
            labelMercNames.setText(labelMercNames.getText() + (merc.Name() + Strings.newline));
            labelMercSkillsPilot.setText(labelMercSkillsPilot.getText() + (merc.Pilot() + Strings.newline));
            labelMercSkillsFighter.setText(labelMercSkillsFighter.getText() + (merc.Fighter() + Strings.newline));
            labelMercSkillsTrader.setText(labelMercSkillsTrader.getText() + (merc.Trader() + Strings.newline));
            labelMercSkillsEngineer.setText(labelMercSkillsEngineer.getText() + (merc.Engineer() + Strings.newline));
            if (i < SplitSystems) {
                int start = labelMercSystems.getText().length();
                labelMercSystems.setText(labelMercSystems.getText() + (CurrentSystemDisplay(merc) + Strings.newline));
                if (link) {
                    labelMercSystems.Links.add(start, merc.CurrentSystem().Name().length(), merc.CurrentSystem().Name());
                }
            } else {
                int start = labelMercSystems2.getText().length();
                labelMercSystems2.setText(labelMercSystems2.getText() + (CurrentSystemDisplay(merc) + Strings.newline));
                if (link) {
                    labelMercSystems2.Links.add(start, merc.CurrentSystem().Name().length(), merc.CurrentSystem().Name());
                }
            }
        }
        labelMercIds.setText(labelMercIds.getText().trim());
        labelMercNames.setText(labelMercNames.getText().trim());
        labelMercSkillsPilot.setText(labelMercSkillsPilot.getText().trim());
        labelMercSkillsFighter.setText(labelMercSkillsFighter.getText().trim());
        labelMercSkillsTrader.setText(labelMercSkillsTrader.getText().trim());
        labelMercSkillsEngineer.setText(labelMercSkillsEngineer.getText().trim());
        labelMercSystems.setText(labelMercSystems.getText().trim());
        labelMercSystems2.setText(labelMercSystems2.getText().trim());
    }

    private void UpdateQuests() {
        labelQuestSystems.setText("");
        labelQuests.setText("");
        labelQuestSystems.Links.clear();
        for (Integer questSystemId : questSystemIds) {
            StarSystem system = game.Universe()[questSystemId];
            int start = labelQuestSystems.getText().length();
            labelQuestSystems.setText(labelQuestSystems.getText() + (system.Name() + Strings.newline));
            labelQuests.setText(labelQuests.getText() + (system.SpecialEvent().Title() + Strings.newline));
            labelQuestSystems.Links.add(start, system.Name().length(), system.Name());
        }
        labelQuestSystems.setText(labelQuestSystems.getText().trim());
        labelQuests.setText(labelQuests.getText().trim());
    }

    private void UpdateShipyards() {
        labelShipyardSystems.setText("");
        labelShipyards.setText("");
        labelShipyardSystems.Links.clear();
        for (Integer shipyardSystemId : shipyardSystemIds) {
            StarSystem system = game.Universe()[shipyardSystemId];
            int start = labelShipyardSystems.getText().length();
            labelShipyardSystems.setText(labelShipyardSystems.getText() + (system.Name() + Strings.newline));
            labelShipyards.setText(labelShipyards.getText() + (system.Shipyard().Name() + Strings.newline));
            labelShipyardSystems.Links.add(start, system.Name().length(), system.Name());
        }
        labelShipyardSystems.setText(labelShipyardSystems.getText().trim());
        labelShipyards.setText(labelShipyards.getText().trim());
    }

    private void SystemLinkClicked(Object sender, LinkLabelLinkClickedEventData e) {
        game.setSelectedSystemByName(e.Link.LinkData.toString());
        game.getParentWindow().UpdateAll();
        Close();
    }

    private void SortLinkClicked(Object sender, LinkLabelLinkClickedEventData e) {
        Sort(((LinkLabel) sender).getName().substring(3, 1), ((LinkLabel) sender).getText().substring(0, 1));
        UpdateAll();
    }
}
