package org.spacetrader.controller;

import org.spacetrader.model.events.SpecialEventType;
import org.spacetrader.ui.Strings;

// TODO part of model
public class SpecialEvent {
    public final static int MoonCost = 500000;
    public final static int StatusArtifactNotStarted = 0;
    public final static int StatusArtifactOnBoard = 1;
    public final static int StatusArtifactDone = 2;
    public final static int StatusDragonflyNotStarted = 0;
    public final static int StatusDragonflyFlyBaratas = 1;
    public final static int StatusDragonflyFlyMelina = 2;
    public final static int StatusDragonflyFlyRegulas = 3;
    public final static int StatusDragonflyFlyZalkon = 4;
    public final static int StatusDragonflyDestroyed = 5;
    public final static int StatusDragonflyDone = 6;
    public final static int StatusExperimentNotStarted = 0;
    public final static int StatusExperimentStarted = 1;
    public final static int StatusExperimentDate = 11;
    public final static int StatusExperimentPerformed = 12;
    public final static int StatusExperimentCancelled = 13;
    public final static int StatusGemulonNotStarted = 0;
    public final static int StatusGemulonStarted = 1;
    public final static int StatusGemulonDate = 7;
    public final static int StatusGemulonTooLate = 8;
    public final static int StatusGemulonFuel = 9;
    public final static int StatusGemulonDone = 10;
    public final static int StatusJaporiNotStarted = 0;
    public final static int StatusJaporiInTransit = 1;
    public final static int StatusJaporiDone = 2;
    public final static int StatusJarekNotStarted = 0;
    public final static int StatusJarekStarted = 1;
    public final static int StatusJarekImpatient = 11;
    public final static int StatusJarekDone = 12;
    public final static int StatusMoonNotStarted = 0;
    public final static int StatusMoonBought = 1;
    public final static int StatusMoonDone = 2;
    public final static int StatusPrincessNotStarted = 0;
    public final static int StatusPrincessFlyCentauri = 1;
    public final static int StatusPrincessFlyInthara = 2;
    public final static int StatusPrincessFlyQonos = 3;
    public final static int StatusPrincessRescued = 4;
    public final static int StatusPrincessImpatient = 14;
    public final static int StatusPrincessReturned = 15;
    public final static int StatusPrincessDone = 16;
    public final static int StatusReactorNotStarted = 0;
    public final static int StatusReactorFuelOk = 1;
    public final static int StatusReactorDate = 20;
    public final static int StatusReactorDelivered = 21;
    public final static int StatusReactorDone = 22;
    public final static int StatusScarabNotStarted = 0;
    public final static int StatusScarabHunting = 1;
    public final static int StatusScarabDestroyed = 2;
    public final static int StatusScarabDone = 3;
    public final static int StatusSculptureNotStarted = 0;
    public final static int StatusSculptureInTransit = 1;
    public final static int StatusSculptureDelivered = 2;
    public final static int StatusSculptureDone = 3;
    public final static int StatusSpaceMonsterNotStarted = 0;
    public final static int StatusSpaceMonsterAtAcamar = 1;
    public final static int StatusSpaceMonsterDestroyed = 2;
    public final static int StatusSpaceMonsterDone = 3;
    public final static int StatusWildNotStarted = 0;
    public final static int StatusWildStarted = 1;
    public final static int StatusWildImpatient = 11;
    public final static int StatusWildDone = 12;
    private final SpecialEventType _type;
    private final int _price;
    private final int _occurrentrence;
    private final boolean _messageOnly;

    public SpecialEvent(SpecialEventType type, int price, int occurrentrence, boolean messageOnly) {
        _type = type;
        _price = price;
        _occurrentrence = occurrentrence;
        _messageOnly = messageOnly;
    }

    public StarSystem Location() {
        StarSystem location = null;
        StarSystem[] universe = Game.getCurrentGame().Universe();
        for (int i = 0; i < universe.length && location == null; i++) {
            if (universe[i].SpecialEventType() == Type()) {
                location = universe[i];
            }
        }
        return location;
    }

    public boolean MessageOnly() {
        return _messageOnly;
    }

    public int Occurrentrence() {
        return _occurrentrence;
    }

    public int Price() {
        return _price;
    }

    public String String() {
        return Strings.SpecialEventStrings[_type.CastToInt()];
    }

    public String Title() {
        return Strings.SpecialEventTitles[_type.CastToInt()];
    }

    public SpecialEventType Type() {
        return _type;
    }
}
