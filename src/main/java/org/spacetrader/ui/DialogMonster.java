package org.spacetrader.ui;

import org.spacetrader.Constants;
import org.spacetrader.model.ModelUtils;
import org.spacetrader.controller.Game;
import org.spacetrader.model.crew.Commander;
import org.spacetrader.model.crew.CrewMember;
import org.spacetrader.model.enums.ShipyardId;
import org.spacetrader.model.system.StarSystem;
import org.spacetrader.util.Utils;
import org.winforms.util.Font;
import org.winforms.link.Link;
import org.winforms.link.LinkArea;
import org.winforms.link.LinkLabel;
import org.winforms.alignment.ContentAlignment;
import org.winforms.alignment.FormStartPosition;
import org.winforms.widget.Button;
import org.winforms.widget.Dialog;
import org.winforms.widget.Label;
import org.winforms.widget.Panel;
import org.winforms.widget.*;
import org.winforms.dialog.DialogResult;
import org.winforms.event.EventHandler;
import org.winforms.style.BorderStyle;
import org.winforms.style.FontStyle;
import org.winforms.style.FormBorderStyle;

import java.awt.*;
import java.util.ArrayList;


public class DialogMonster extends Dialog {
    private static final int SplitSystems = 31;
    private final Game game = Game.getCurrentGame();
    private final Commander commander = game.Commander();
    private final Label labelMercIds;
    private final Label labelMercNames;
    private final Label labelMercSkillsPilot;
    private final Label labelMercSkillsFighter;
    private final Label labelMercSkillsTrader;
    private final Label labelMercSkillsEngineer;
    private final Label labelQuests;
    private final Label labelShipyards;
    private final LinkLabel labelMercSystems;
    private final LinkLabel labelMercSystems2;
    private final LinkLabel labelQuestSystems;
    private final LinkLabel labelShipyardSystems;
    private Integer[] mercIds;
    private Integer[] questSystemIds;
    private Integer[] shipyardSystemIds;

    public DialogMonster() {
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
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setSize(new Dimension(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // pictureLine1
        pictureLine1.setBackgroundColor(Color.darkGray);
        pictureLine1.setLocation(new Point(4, 40));
        pictureLine1.setSize(new Dimension(609, 1));
        pictureLine1.setTabIndex(133);
        pictureLine1.setTabStop(false);
        // pictureLine0
        pictureLine0.setBackgroundColor(Color.darkGray);
        pictureLine0.setLocation(new Point(234, 8));
        pictureLine0.setSize(new Dimension(1, 347));
        pictureLine0.setTabIndex(132);
        pictureLine0.setTabStop(false);
        // labelQuestsLabel
        labelQuestsLabel.setAutoSize(true);
        labelQuestsLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 10F));
        labelQuestsLabel.setLocation(new Point(88, 4));
        labelQuestsLabel.setSize(new Dimension(50, 19));
        labelQuestsLabel.setTabIndex(134);
        labelQuestsLabel.setText("Quests");
        // labelMercLabel
        labelMercLabel.setAutoSize(true);
        labelMercLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 10F));
        labelMercLabel.setLocation(new Point(348, 4));
        labelMercLabel.setSize(new Dimension(84, 19));
        labelMercLabel.setTabIndex(141);
        labelMercLabel.setText("Mercenaries");
        // labelMercSkillLabelPilot
        labelMercSkillLabelPilot.setAutoSize(true);
        labelMercSkillLabelPilot.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercSkillLabelPilot.setLocation(new Point(341, 24));
        labelMercSkillLabelPilot.setSize(new Dimension(12, 16));
        labelMercSkillLabelPilot.setTabIndex(7);
        labelMercSkillLabelPilot.setTabStop(true);
        labelMercSkillLabelPilot.setText("P");
        labelMercSkillLabelPilot.textAlignment = ContentAlignment.TopRight;
        labelMercSkillLabelPilot.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelMercSkillLabelFighter
        labelMercSkillLabelFighter.setAutoSize(true);
        labelMercSkillLabelFighter.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercSkillLabelFighter.setLocation(new Point(362, 24));
        labelMercSkillLabelFighter.setSize(new Dimension(11, 16));
        labelMercSkillLabelFighter.setTabIndex(8);
        labelMercSkillLabelFighter.setTabStop(true);
        labelMercSkillLabelFighter.setText("F");
        labelMercSkillLabelFighter.textAlignment = ContentAlignment.TopRight;
        labelMercSkillLabelFighter.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelMercSkillLabelTrader
        labelMercSkillLabelTrader.setAutoSize(true);
        labelMercSkillLabelTrader.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercSkillLabelTrader.setLocation(new Point(382, 24));
        labelMercSkillLabelTrader.setSize(new Dimension(11, 16));
        labelMercSkillLabelTrader.setTabIndex(9);
        labelMercSkillLabelTrader.setTabStop(true);
        labelMercSkillLabelTrader.setText("T");
        labelMercSkillLabelTrader.textAlignment = ContentAlignment.TopRight;
        labelMercSkillLabelTrader.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelMercSkillLabelEngineer
        labelMercSkillLabelEngineer.setAutoSize(true);
        labelMercSkillLabelEngineer.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercSkillLabelEngineer.setLocation(new Point(401, 24));
        labelMercSkillLabelEngineer.setSize(new Dimension(12, 16));
        labelMercSkillLabelEngineer.setTabIndex(10);
        labelMercSkillLabelEngineer.setTabStop(true);
        labelMercSkillLabelEngineer.setText("E");
        labelMercSkillLabelEngineer.textAlignment = ContentAlignment.TopRight;
        labelMercSkillLabelEngineer.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelMercSystemLabel
        labelMercSystemLabel.setAutoSize(true);
        labelMercSystemLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercSystemLabel.setLocation(new Point(425, 24));
        labelMercSystemLabel.setSize(new Dimension(43, 16));
        labelMercSystemLabel.setTabIndex(11);
        labelMercSystemLabel.setTabStop(true);
        labelMercSystemLabel.setText("System");
        labelMercSystemLabel.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelQuestSystemLabel
        labelQuestSystemLabel.setAutoSize(true);
        labelQuestSystemLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelQuestSystemLabel.setLocation(new Point(13, 24));
        labelQuestSystemLabel.setSize(new Dimension(43, 16));
        labelQuestSystemLabel.setTabIndex(1);
        labelQuestSystemLabel.setTabStop(true);
        labelQuestSystemLabel.setText("System");
        labelQuestSystemLabel.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelQuestDescLabel
        labelQuestDescLabel.setAutoSize(true);
        labelQuestDescLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelQuestDescLabel.setLocation(new Point(85, 24));
        labelQuestDescLabel.setSize(new Dimension(63, 16));
        labelQuestDescLabel.setTabIndex(2);
        labelQuestDescLabel.setTabStop(true);
        labelQuestDescLabel.setText("Description");
        labelQuestDescLabel.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelMercIDLabel
        labelMercIDLabel.setAutoSize(true);
        labelMercIDLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercIDLabel.setLocation(new Point(247, 24));
        labelMercIDLabel.setSize(new Dimension(16, 16));
        labelMercIDLabel.setTabIndex(5);
        labelMercIDLabel.setTabStop(true);
        labelMercIDLabel.setText("ID");
        labelMercIDLabel.textAlignment = ContentAlignment.TopRight;
        labelMercIDLabel.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelMercNameLabel
        labelMercNameLabel.setAutoSize(true);
        labelMercNameLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelMercNameLabel.setLocation(new Point(268, 24));
        labelMercNameLabel.setSize(new Dimension(35, 16));
        labelMercNameLabel.setTabIndex(6);
        labelMercNameLabel.setTabStop(true);
        labelMercNameLabel.setText("Name");
        labelMercNameLabel.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelShipyardsDescLabel
        labelShipyardsDescLabel.setAutoSize(true);
        labelShipyardsDescLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelShipyardsDescLabel.setLocation(new Point(85, 258));
        labelShipyardsDescLabel.setSize(new Dimension(63, 16));
        labelShipyardsDescLabel.setTabIndex(4);
        labelShipyardsDescLabel.setTabStop(true);
        labelShipyardsDescLabel.setText("Description");
        labelShipyardsDescLabel.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelShipyardsSystemLabel
        labelShipyardsSystemLabel.setAutoSize(true);
        labelShipyardsSystemLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 8.25F));
        labelShipyardsSystemLabel.setLocation(new Point(13, 258));
        labelShipyardsSystemLabel.setSize(new Dimension(43, 16));
        labelShipyardsSystemLabel.setTabIndex(3);
        labelShipyardsSystemLabel.setTabStop(true);
        labelShipyardsSystemLabel.setText("System");
        labelShipyardsSystemLabel.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SortLinkClicked(sender, data);
            }
        };
        // labelShipyardsLabel
        labelShipyardsLabel.setAutoSize(true);
        labelShipyardsLabel.setFont(new Font("Microsoft Sans Serif", FontStyle.Bold, (int) 10F));
        labelShipyardsLabel.setLocation(new Point(79, 238));
        labelShipyardsLabel.setSize(new Dimension(68, 19));
        labelShipyardsLabel.setTabIndex(155);
        labelShipyardsLabel.setText("Shipyards");
        // pnlMercs
        pnlMercs.autoScroll = true;
        pnlMercs.setBorderStyle(BorderStyle.FixedSingle);
        pnlMercs.add(labelMercSkillsPilot);
        pnlMercs.add(labelMercSkillsFighter);
        pnlMercs.add(labelMercSkillsTrader);
        pnlMercs.add(labelMercSkillsEngineer);
        pnlMercs.add(labelMercSystems);
        pnlMercs.add(labelMercIds);
        pnlMercs.add(labelMercNames);
        pnlMercs.add(labelMercSystems2);
        pnlMercs.setLocation(new Point(239, 44));
        pnlMercs.setSize(new Dimension(371, 307));
        pnlMercs.setTabIndex(158);
        // labelMercSkillsPilot
        labelMercSkillsPilot.setLocation(new Point(93, 4));
        labelMercSkillsPilot.setSize(new Dimension(20, 563));
        labelMercSkillsPilot.setTabIndex(144);
        labelMercSkillsPilot.textAlignment = ContentAlignment.TopRight;
        // labelMercSkillsFighter
        labelMercSkillsFighter.setLocation(new Point(113, 4));
        labelMercSkillsFighter.setSize(new Dimension(20, 563));
        labelMercSkillsFighter.setTabIndex(145);
        labelMercSkillsFighter.textAlignment = ContentAlignment.TopRight;
        // labelMercSkillsTrader
        labelMercSkillsTrader.setLocation(new Point(133, 4));
        labelMercSkillsTrader.setSize(new Dimension(20, 563));
        labelMercSkillsTrader.setTabIndex(146);
        labelMercSkillsTrader.textAlignment = ContentAlignment.TopRight;
        // labelMercSkillsEngineer
        labelMercSkillsEngineer.setLocation(new Point(153, 4));
        labelMercSkillsEngineer.setSize(new Dimension(20, 563));
        labelMercSkillsEngineer.setTabIndex(147);
        labelMercSkillsEngineer.textAlignment = ContentAlignment.TopRight;
        // labelMercSystems
        labelMercSystems.linkArea = new LinkArea(0, 0);
        labelMercSystems.setLocation(new Point(185, 4));
        labelMercSystems.setSize(new Dimension(160, 387));
        labelMercSystems.setTabIndex(14);
        labelMercSystems.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SystemLinkClicked(sender, data);
            }
        };
        // labelMercIds
        labelMercIds.setLocation(new Point(0, 4));
        labelMercIds.setSize(new Dimension(23, 563));
        labelMercIds.setTabIndex(142);
        labelMercIds.textAlignment = ContentAlignment.TopRight;
        // labelMercNames
        labelMercNames.setLocation(new Point(28, 4));
        labelMercNames.setSize(new Dimension(69, 563));
        labelMercNames.setTabIndex(141);
        // labelMercSystems2
        labelMercSystems2.linkArea = new LinkArea(0, 0);
        labelMercSystems2.setLocation(new Point(185, 391));
        labelMercSystems2.setSize(new Dimension(160, 175));
        labelMercSystems2.setTabIndex(148);
        labelMercSystems2.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SystemLinkClicked(sender, data);
            }
        };
        // pnlQuests
        pnlQuests.autoScroll = true;
        pnlQuests.setBorderStyle(BorderStyle.FixedSingle);
        pnlQuests.add(labelQuests);
        pnlQuests.add(labelQuestSystems);
        pnlQuests.setLocation(new Point(8, 44));
        pnlQuests.setSize(new Dimension(222, 182));
        pnlQuests.setTabIndex(159);
        // labelQuests
        labelQuests.setLocation(new Point(76, 4));
        labelQuests.setSize(new Dimension(120, 350));
        labelQuests.setTabIndex(48);
        // labelQuestSystems
        labelQuestSystems.linkArea = new LinkArea(0, 0);
        labelQuestSystems.setLocation(new Point(4, 4));
        labelQuestSystems.setSize(new Dimension(68, 350));
        labelQuestSystems.setTabIndex(12);
        labelQuestSystems.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SystemLinkClicked(sender, data);
            }
        };
        // pnlShipyards
        pnlShipyards.setBorderStyle(BorderStyle.FixedSingle);
        pnlShipyards.add(labelShipyards);
        pnlShipyards.add(labelShipyardSystems);
        pnlShipyards.setLocation(new Point(8, 278));
        pnlShipyards.setSize(new Dimension(222, 73));
        pnlShipyards.setTabIndex(160);
        // labelShipyards
        labelShipyards.setLocation(new Point(76, 4));
        labelShipyards.setSize(new Dimension(120, 63));
        labelShipyards.setTabIndex(158);
        // labelShipyardSystems
        labelShipyardSystems.linkArea = new LinkArea(0, 0);
        labelShipyardSystems.setLocation(new Point(4, 4));
        labelShipyardSystems.setSize(new Dimension(68, 63));
        labelShipyardSystems.setTabIndex(13);
        labelShipyardSystems.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, Link data) {
                SystemLinkClicked(sender, data);
            }
        };
        // pictureLine2
        pictureLine2.setBackgroundColor(Color.darkGray);
        pictureLine2.setLocation(new Point(4, 274));
        pictureLine2.setSize(new Dimension(222, 1));
        pictureLine2.setTabIndex(161);
        pictureLine2.setTabStop(false);
        // FormMonster
        setAutoScaleBaseSize(new Dimension(5, 13));
        setCancelButton(buttonClose);
        setClientSize(new Dimension(617, 358));
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
        pnlMercs.resumeLayout(false);
        pnlQuests.resumeLayout(false);
        pnlShipyards.resumeLayout(false);
        resumeLayout(false);
        PopulateIdArrays();
        SetLabelHeights();
        UpdateAll();
    }


    private int Compare(int a, int b, String sortWhat, String sortBy) {
        int compareVal = 0;
        if ("M".equals(sortWhat)) { // Mercenaries
            CrewMember A = game.Mercenaries()[a];
            CrewMember B = game.Mercenaries()[b];
            boolean strCompare = false;
            Object valA = null;
            Object valB = null;
            switch (SomeStringsForSwitch.valueOf(sortBy)) {
                case I: // Id
                    valA = A.Id().getId();
                    valB = B.Id().getId();
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
            StarSystem A = game.getUniverse()[a];
            StarSystem B = game.getUniverse()[b];
            if ("D".equals(sortBy)) { // Description
                String nameA = "";
                String nameB = "";
                switch (SomeStringsForSwitch.valueOf(sortWhat)) {
                    case Q: // Quests
                        nameA = A.SpecialEvent().getTitle();
                        nameB = B.SpecialEvent().getTitle();
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
                ? ModelUtils.StringVars(Strings.MercOnBoard, merc.CurrentSystem().Name()) : merc.CurrentSystem().Name()));
    }

    private void PopulateIdArrays() {
        // Populate the mercenary ids array.
        ArrayList<Integer> ids = new ArrayList<>();
        for (CrewMember merc : game.Mercenaries()) {
            if (!Utils.arrayContains(Constants.SpecialCrewMemberIds, merc.Id())) {
                ids.add(merc.Id().getId());
            }
        }
        mercIds = ids.toArray(new Integer[0]);
        // Populate the quest and shipyard system ids arrays.
        ArrayList<Integer> quests = new ArrayList<>();
        ArrayList<Integer> shipyards = new ArrayList<>();
        for (StarSystem system : game.getUniverse()) {
            if (system.ShowSpecialButton()) {
                quests.add(system.Id().getId());
            }
            if (system.ShipyardId() != ShipyardId.NA) {
                shipyards.add(system.Id().getId());
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
        labelMercSystems.links.clear();
        labelMercSystems2.links.clear();
        for (int i = 0; i < mercIds.length; i++) {
            CrewMember merc = game.Mercenaries()[mercIds[i]];
            boolean link = merc.CurrentSystem() != null && !commander.getShip().HasCrew(merc.Id());
            labelMercIds.setText(labelMercIds.getText() + ((merc.Id().getId()) + Strings.newline));
            labelMercNames.setText(labelMercNames.getText() + (merc.Name() + Strings.newline));
            labelMercSkillsPilot.setText(labelMercSkillsPilot.getText() + (merc.Pilot() + Strings.newline));
            labelMercSkillsFighter.setText(labelMercSkillsFighter.getText() + (merc.Fighter() + Strings.newline));
            labelMercSkillsTrader.setText(labelMercSkillsTrader.getText() + (merc.Trader() + Strings.newline));
            labelMercSkillsEngineer.setText(labelMercSkillsEngineer.getText() + (merc.Engineer() + Strings.newline));
            if (i < SplitSystems) {
                int start = labelMercSystems.getText().length();
                labelMercSystems.setText(labelMercSystems.getText() + (CurrentSystemDisplay(merc) + Strings.newline));
                if (link) {
                    labelMercSystems.links.add(start, merc.CurrentSystem().Name().length(), merc.CurrentSystem().Name());
                }
            } else {
                int start = labelMercSystems2.getText().length();
                labelMercSystems2.setText(labelMercSystems2.getText() + (CurrentSystemDisplay(merc) + Strings.newline));
                if (link) {
                    labelMercSystems2.links.add(start, merc.CurrentSystem().Name().length(), merc.CurrentSystem().Name());
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
        labelQuestSystems.links.clear();
        for (Integer questSystemId : questSystemIds) {
            StarSystem system = game.getUniverse()[questSystemId];
            int start = labelQuestSystems.getText().length();
            labelQuestSystems.setText(labelQuestSystems.getText() + (system.Name() + Strings.newline));
            labelQuests.setText(labelQuests.getText() + (system.SpecialEvent().getTitle() + Strings.newline));
            labelQuestSystems.links.add(start, system.Name().length(), system.Name());
        }
        labelQuestSystems.setText(labelQuestSystems.getText().trim());
        labelQuests.setText(labelQuests.getText().trim());
    }

    private void UpdateShipyards() {
        labelShipyardSystems.setText("");
        labelShipyards.setText("");
        labelShipyardSystems.links.clear();
        for (Integer shipyardSystemId : shipyardSystemIds) {
            StarSystem system = game.getUniverse()[shipyardSystemId];
            int start = labelShipyardSystems.getText().length();
            labelShipyardSystems.setText(labelShipyardSystems.getText() + (system.Name() + Strings.newline));
            labelShipyards.setText(labelShipyards.getText() + (system.Shipyard().Name() + Strings.newline));
            labelShipyardSystems.links.add(start, system.Name().length(), system.Name());
        }
        labelShipyardSystems.setText(labelShipyardSystems.getText().trim());
        labelShipyards.setText(labelShipyards.getText().trim());
    }

    private void SystemLinkClicked(Object sender, Link e) {
        game.setSelectedSystemByName(e.linkData.toString());
        game.getParentWindow().updateAll();
        Close();
    }

    private void SortLinkClicked(Object sender, Link e) {
        Sort(((LinkLabel) sender).getName().substring(3, 1), ((LinkLabel) sender).getText().substring(0, 1));
        UpdateAll();
    }
}
