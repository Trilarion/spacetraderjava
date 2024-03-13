package org.spacetrader.ui;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.model.events.SpecialEvent;
import org.spacetrader.model.enums.CrewMemberId;
import org.spacetrader.model.events.SpecialEventType;
import org.spacetrader.util.Util;
import org.winforms.Button;
import org.winforms.*;
import org.winforms.enums.DialogResult;
import org.winforms.enums.FormBorderStyle;
import org.winforms.enums.FormStartPosition;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FormViewQuests extends wfForm {
    private final Game game = Game.getCurrentGame();
    private final LinkLabel labelQuests;

    public FormViewQuests() {
        Button buttonClose = new Button();
        labelQuests = new LinkLabel();
        SuspendLayout();
        // buttonClose
        buttonClose.setDialogResult(DialogResult.Cancel);
        buttonClose.setLocation(new Point(-32, -32));
        buttonClose.setName("buttonClose");
        buttonClose.setSize(new SizeF(32, 32));
        buttonClose.setTabIndex(32);
        buttonClose.setTabStop(false);
        buttonClose.setText("X");
        // labelQuests
        labelQuests.linkArea = new LinkArea(0, 0);
        labelQuests.setLocation(new Point(8, 8));
        labelQuests.setName("labelQuests");
        labelQuests.setSize(new SizeF(312, 368));
        labelQuests.setTabIndex(44);
        labelQuests.setText("Kill the space monster at Acamar.\n\n"
                + "Get your lightning shield at Zalkon.\n\n"
                + "Deliver antidote to Japori.\n\n"
                + "Deliver the alien artifact to Professor Berger at some hi-tech system.\n\n"
                + "Bring ambassador Jarek to Devidia. Jarek is wondering why the journey is taking so long, and is no longer of much help in negotiating trades.\n\n"
                + "Inform Gemulon about alien invasion within 8 days.\n\n"
                + "Stop Dr. Fehler's experiment at Daled within 8 days.\n\n"
                + "Deliver the unstable reactor to Nix before it consumes all its fuel.\n\n"
                + "Find and destroy the Scarab (which is hiding at the exit to a wormhole).\n\n"
                + "Smuggle Jonathan Wild to Kravat. Wild is getting impatient, and will no longer aid your crew along the way.\n\n"
                + "Get rid of those pesky tribbles.\n\n"
                + "Claim your moon at Utopia.");
        labelQuests.linkClicked = new EventHandler<>() {
            @Override
            public void handle(Object sender, LinkLabelLinkClickedEventData data) {
                labelQuests_LinkClicked(sender, data);
            }
        };
        // FormViewQuests
        setAutoScaleBaseSize(new SizeF(13, 5));
        setCancelButton(buttonClose);
        setClientSize(new SizeF(325, 378));
        Controls.addAll(Arrays.asList(buttonClose, labelQuests));
        setFormBorderStyle(FormBorderStyle.FixedDialog);
        setMaximizeBox(false);
        setMinimizeBox(false);
        setName("FormViewQuests");
        setShowInTaskbar(false);
        setStartPosition(FormStartPosition.CenterParent);
        setText("Quests");
        ResumeLayout(false);
        UpdateAll();
    }


    private String[] GetQuestStrings() {
        ArrayList<String> quests = new ArrayList<>(12);
        if (game.getQuestStatusGemulon() > SpecialEvent.StatusGemulonNotStarted && game.getQuestStatusGemulon() < SpecialEvent.StatusGemulonDate) {
            if (game.getQuestStatusGemulon() == SpecialEvent.StatusGemulonDate - 1) {
                quests.add(Strings.QuestGemulonInformTomorrow);
            } else {
                quests.add(Functions.StringVars(Strings.QuestGemulonInformDays, Functions.Multiples(SpecialEvent.StatusGemulonDate - game.getQuestStatusGemulon(), "day")));
            }
        } else if (game.getQuestStatusGemulon() == SpecialEvent.StatusGemulonFuel) {
            quests.add(Strings.QuestGemulonFuel);
        }
        if (game.getQuestStatusExperiment() > SpecialEvent.StatusExperimentNotStarted && game.getQuestStatusExperiment() < SpecialEvent.StatusExperimentDate) {
            if (game.getQuestStatusExperiment() == SpecialEvent.StatusExperimentDate - 1) {
                quests.add(Strings.QuestExperimentInformTomorrow);
            } else {
                quests.add(Functions.StringVars(Strings.QuestExperimentInformDays, Functions.Multiples(SpecialEvent.StatusExperimentDate - game.getQuestStatusExperiment(), "day")));
            }
        }
        if (game.Commander().getShip().ReactorOnBoard()) {
            if (game.getQuestStatusReactor() == SpecialEvent.StatusReactorFuelOk) {
                quests.add(Strings.QuestReactor);
            } else {
                quests.add(Strings.QuestReactorFuel);
            }
        } else if (game.getQuestStatusReactor() == SpecialEvent.StatusReactorDelivered) {
            quests.add(Strings.QuestReactorLaser);
        }
        if (game.getQuestStatusSpaceMonster() == SpecialEvent.StatusSpaceMonsterAtAcamar) {
            quests.add(Strings.QuestSpaceMonsterKill);
        }
        if (game.getQuestStatusJapori() == SpecialEvent.StatusJaporiInTransit) {
            quests.add(Strings.QuestJaporiDeliver);
        }
        switch (game.getQuestStatusDragonfly()) {
            case SpecialEvent.StatusDragonflyFlyBaratas:
                quests.add(Strings.QuestDragonflyBaratas);
                break;
            case SpecialEvent.StatusDragonflyFlyMelina:
                quests.add(Strings.QuestDragonflyMelina);
                break;
            case SpecialEvent.StatusDragonflyFlyRegulas:
                quests.add(Strings.QuestDragonflyRegulas);
                break;
            case SpecialEvent.StatusDragonflyFlyZalkon:
                quests.add(Strings.QuestDragonflyZalkon);
                break;
            case SpecialEvent.StatusDragonflyDestroyed:
                quests.add(Strings.QuestDragonflyShield);
                break;
        }
        switch (game.getQuestStatusPrincess()) {
            case SpecialEvent.StatusPrincessFlyCentauri:
                quests.add(Strings.QuestPrincessCentauri);
                break;
            case SpecialEvent.StatusPrincessFlyInthara:
                quests.add(Strings.QuestPrincessInthara);
                break;
            case SpecialEvent.StatusPrincessFlyQonos:
                quests.add(Strings.QuestPrincessQonos);
                break;
            case SpecialEvent.StatusPrincessRescued:
                if (game.Commander().getShip().PrincessOnBoard()) {
                    if (game.getQuestStatusPrincess() == SpecialEvent.StatusPrincessImpatient) {
                        quests.add(Functions.StringVars(Strings.QuestPrincessReturningImpatient, game.Mercenaries()[CrewMemberId.Princess.getId()].Name()));
                    } else {
                        quests.add(Functions.StringVars(Strings.QuestPrincessReturning, game.Mercenaries()[CrewMemberId.Princess.getId()].Name()));
                    }
                } else {
                    quests.add(Functions.StringVars(Strings.QuestPrincessReturn, game.Mercenaries()[CrewMemberId.Princess.getId()].Name()));
                }
                break;
            case SpecialEvent.StatusPrincessReturned:
                quests.add(Strings.QuestPrincessQuantum);
                break;
        }
        if (game.getQuestStatusScarab() == SpecialEvent.StatusScarabHunting) {
            quests.add(Strings.QuestScarabFind);
        } else if (game.getQuestStatusScarab() == SpecialEvent.StatusScarabDestroyed) {
            if (Constants.SpecialEvents[SpecialEventType.ScarabUpgradeHull.getId()].Location() == null) {
                quests.add(Functions.StringVars(Strings.QuestScarabNotify, Constants.SpecialEvents[SpecialEventType.ScarabDestroyed.getId()].Location().Name()));
            } else {
                quests.add(Functions.StringVars(Strings.QuestScarabHull, Constants.SpecialEvents[SpecialEventType.ScarabUpgradeHull.getId()].Location().Name()));
            }
        }
        if (game.Commander().getShip().SculptureOnBoard()) {
            quests.add(Strings.QuestSculpture);
        } else if (game.getQuestStatusReactor() == SpecialEvent.StatusReactorDelivered) {
            quests.add(Strings.QuestSculptureHiddenBays);
        }
        if (game.getQuestStatusArtifact() == SpecialEvent.StatusArtifactOnBoard) {
            quests.add(Strings.QuestArtifact);
        }
        if (game.Commander().getShip().JarekOnBoard()) {
            if (game.getQuestStatusJarek() == SpecialEvent.StatusJarekImpatient) {
                quests.add(Strings.QuestJarekImpatient);
            } else {
                quests.add(Strings.QuestJarek);
            }
        }
        if (game.Commander().getShip().WildOnBoard()) {
            if (game.getQuestStatusWild() == SpecialEvent.StatusWildImpatient) {
                quests.add(Strings.QuestWildImpatient);
            } else {
                quests.add(Strings.QuestWild);
            }
        }
        if (game.Commander().getShip().getTribbles() > 0) {
            quests.add(Strings.QuestTribbles);
        }
        if (game.getQuestStatusMoon() == SpecialEvent.StatusMoonBought) {
            quests.add(Strings.QuestMoon);
        }
        return Functions.ArrayListtoStringArray(quests);
    }

    private void UpdateAll() {
        String[] quests = GetQuestStrings();
        if (quests.length == 0) {
            labelQuests.setText(Strings.QuestNone);
        } else {
            labelQuests.setText(Util.stringsJoin(Strings.newline + Strings.newline, quests));
            for (int i = 0; i < Strings.SystemNames.length; i++) {
                String systemName = Strings.SystemNames[i];
                int start = 0;
                int index = -1;
                while ((index = labelQuests.getText().indexOf(systemName, start)) >= 0) {
                    labelQuests.links.add(index, systemName.length(), systemName);
                    start = index + systemName.length();
                }
            }
        }
    }

    private void labelQuests_LinkClicked(Object sender, LinkLabelLinkClickedEventData e) {
        game.setSelectedSystemByName(e.Link.LinkData.toString());
        game.getParentWindow().UpdateAll();
        Close();
    }
}
