package org.spacetrader.model;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Game;
import org.spacetrader.model.enums.Activity;
import org.spacetrader.model.enums.OpponentType;
import org.spacetrader.model.enums.PoliticalSystemType;
import org.spacetrader.model.enums.Difficulty;
import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.model.cargo.TradeItemType;
import org.spacetrader.model.ship.ShipType;
import org.spacetrader.ui.Strings;


// TODO part of the model
public class PoliticalSystem {
    private final PoliticalSystemType type;
    private final int reactionIllegal; // Reaction level of illegal goods 0 = total acceptance (determines how police reacts if they find you carry them)
    private final Activity activityPolice; // Activity level of police force 0 = no police (determines occurrentrence rate)
    private final Activity activityPirates; // Activity level of pirates 0 = no pirates
    private final Activity activityTraders; // Activity level of traders 0 = no traders
    private final TechLevel minTech; // Minimum tech level needed
    private final TechLevel maxTech; // Maximum tech level where this is found
    private final int bribeLevel; // Indicates how easily someone can be bribed 0 = unbribable/high bribe costs
    private final boolean drugsOk; // Drugs can be traded (if not, people aren't interested or the government is too strict)
    private final boolean firearmsOk; // Firearms can be traded (if not, people aren't interested or the government is too strict)
    private final TradeItemType wanted; // Trade item requested in particular in this type of government

    public PoliticalSystem(PoliticalSystemType type, int reactionIllegal, Activity activityPolice,
                           Activity activityPirates, Activity activityTraders, TechLevel minTechLevel, TechLevel maxTechLevel,
                           int bribeLevel, boolean drugsOk, boolean firearmsOk, TradeItemType wanted) {
        this.type = type;
        this.reactionIllegal = reactionIllegal;
        this.activityPolice = activityPolice;
        this.activityPirates = activityPirates;
        this.activityTraders = activityTraders;
        minTech = minTechLevel;
        maxTech = maxTechLevel;
        this.bribeLevel = bribeLevel;
        this.drugsOk = drugsOk;
        this.firearmsOk = firearmsOk;
        this.wanted = wanted;
    }

    public boolean ShipTypeLikely(ShipType shipType, OpponentType oppType) {
        boolean likely = false;
        int diffMod = Math.max(0, Game.getCurrentGame().Difficulty().getId() - Difficulty.Normal.getId());
        switch (oppType) {
            case Pirate:
                likely = ActivityPirates().getId() + diffMod >= Constants.ShipSpecs[shipType.getId()].Pirates().getId();
                break;
            case Police:
                likely = ActivityPolice().getId() + diffMod >= Constants.ShipSpecs[shipType.getId()].Police().getId();
                break;
            case Trader:
                likely = ActivityTraders().getId() + diffMod >= Constants.ShipSpecs[shipType.getId()].Traders().getId();
                break;
        }
        return likely;
    }

    public Activity ActivityPirates() {
        return activityPirates;
    }

    public Activity ActivityPolice() {
        return activityPolice;
    }

    public Activity ActivityTraders() {
        return activityTraders;
    }

    public int BribeLevel() {
        return bribeLevel;
    }

    public boolean DrugsOk() {
        return drugsOk;
    }

    public boolean FirearmsOk() {
        return firearmsOk;
    }

    public TechLevel MaximumTechLevel() {
        return maxTech;
    }

    public TechLevel MinimumTechLevel() {
        return minTech;
    }

    public String Name() {
        return Strings.PoliticalSystemNames[type.getId()];
    }

    public int ReactionIllegal() {
        return reactionIllegal;
    }

    public PoliticalSystemType Type() {
        return type;
    }

    public TradeItemType Wanted() {
        return wanted;
    }
}
