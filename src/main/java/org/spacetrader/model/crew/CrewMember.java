package org.spacetrader.model.crew;

import org.spacetrader.controller.Constants;
import org.spacetrader.controller.Functions;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.SerializableObject;
import org.spacetrader.model.enums.CrewMemberId;
import org.spacetrader.model.enums.Difficulty;
import org.spacetrader.model.enums.SkillType;
import org.spacetrader.model.enums.StarSystemId;
import org.spacetrader.model.system.StarSystem;
import org.spacetrader.ui.Strings;
import org.spacetrader.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

// TODO part of model
public class CrewMember extends SerializableObject {

    private final CrewMemberId crewMemberId;
    private StarSystemId currentSystemId = StarSystemId.NA;
    private int[] skills = new int[4];

    public CrewMember(CrewMemberId id, int pilot, int fighter, int trader, int engineer, StarSystemId currentSystemId) {
        crewMemberId = id;
        Pilot(pilot);  // TODO change to setPilotSkill, getPilotSkill, ...
        Fighter(fighter);
        Trader(trader);
        Engineer(engineer);
        this.currentSystemId = currentSystemId;
    }

    public CrewMember(CrewMember baseCrewMember) {
        crewMemberId = baseCrewMember.Id();
        Pilot(baseCrewMember.Pilot());
        Fighter(baseCrewMember.Fighter());
        Trader(baseCrewMember.Trader());
        Engineer(baseCrewMember.Engineer());
        currentSystemId = baseCrewMember.currentSystemId;
    }

    public CrewMember(Hashtable hash) {
        super(hash);
        crewMemberId = CrewMemberId.FromInt(GetValueFromHash(hash, "_id", Integer.class));
        skills = GetValueFromHash(hash, "_skills", skills, int[].class);
        currentSystemId = StarSystemId.FromInt(GetValueFromHash(hash, "_currentSystemId", Integer.class));
    }

    private void ChangeRandomSkill(int amount) {
        ArrayList<Integer> skillIdList = new ArrayList<>(4);
        for (int i = 0; i < Skills().length; i++) {
            if (0 < Skills()[i] + amount && Constants.MaxSkill > Skills()[i] + amount) {
                skillIdList.add(i);
            }
        }
        if (!skillIdList.isEmpty()) {
            int skill = skillIdList.get(Functions.GetRandom(skillIdList.size()));
            int currentTrader = Game.getCurrentGame().Commander().getShip().Trader();
            Skills()[skill] += amount;
            if (Game.getCurrentGame().Commander().getShip().Trader() != currentTrader) {
                Game.getCurrentGame().RecalculateBuyPrices(Game.getCurrentGame().Commander().CurrentSystem());
            }
        }
    }

    // *************************************************************************
    // Increase one of the skills.
    // *************************************************************************
    public void IncreaseRandomSkill() {
        ChangeRandomSkill(1);
    }

    // *************************************************************************
    // NthLowest Skill. Returns skill with the nth lowest score (i.e., 2 is the second-worst skill).
    // If there is a tie, it will return in the order of Pilot, Fighter, Trader, Engineer.
    // JAF - rewrote this to be more efficient.
    // *************************************************************************
    public int NthLowestSkill(int n) {
        int[] skillIds = {0, 1, 2, 3};
        for (int j = 0; 3 > j; j++) {
            for (int i = 0; i < 3 - j; i++) {
                if (Skills()[skillIds[i]] > Skills()[skillIds[i + 1]]) {
                    int temp = skillIds[i];
                    skillIds[i] = skillIds[i + 1];
                    skillIds[i + 1] = temp;
                }
            }
        }
        return skillIds[n - 1];
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_id", crewMemberId);
        hash.put("_skills", skills);
        hash.put("_currentSystemId", currentSystemId);
        return hash;
    }

    // *************************************************************************
    // Randomly tweak the skills.
    // *************************************************************************
    public void TonicTweakRandomSkill() {
        int[] oldSkills = Arrays.copyOf(Skills(), Skills().length);
        if (Game.getCurrentGame().Difficulty().getId() < Difficulty.Hard.getId()) {
            // add one to a random skill, subtract one from a random skill
            while (Skills()[0] == oldSkills[0] && Skills()[1] == oldSkills[1] && Skills()[2] == oldSkills[2] && Skills()[3] == oldSkills[3]) {
                ChangeRandomSkill(1);
                ChangeRandomSkill(-1);
            }
        } else {
            // add one to two random skills, subtract three from one random skill
            ChangeRandomSkill(1);
            ChangeRandomSkill(1);
            ChangeRandomSkill(-3);
        }
    }

    @Override
    public String toString() {
        return Name();
    }

    public StarSystem CurrentSystem() {
        return StarSystemId.NA == currentSystemId ? null : Game.getCurrentGame().Universe()[currentSystemId.getId()];
    }

    public void CurrentSystem(StarSystem value) {
        currentSystemId = value.Id();
    }

    public StarSystemId getCurrentSystemId() {
        return currentSystemId;
    }

    public void setCurrentSystemId(StarSystemId currentSystemId) {
        this.currentSystemId = currentSystemId;
    }

    public int Engineer() {
        return skills[SkillType.Engineer.getId()];
    }

    public void Engineer(int value) {
        skills[SkillType.Engineer.getId()] = value;
    }

    public int Fighter() {
        return skills[SkillType.Fighter.getId()];
    }

    public void Fighter(int value) {
        skills[SkillType.Fighter.getId()] = value;
    }

    public CrewMemberId Id() {
        return crewMemberId;
    }

    public String Name() {
        return Strings.CrewMemberNames[crewMemberId.getId()];
    }

    public int Pilot() {
        return skills[SkillType.Pilot.getId()];
    }

    public void Pilot(int value) {
        skills[SkillType.Pilot.getId()] = value;
    }

    public int Rate() {
        return Util.arrayContains(Constants.SpecialCrewMemberIds, Id()) || CrewMemberId.Zeethibal == Id()
                ? 0 : (Pilot() + Fighter() + Trader() + Engineer()) * 3;
    }

    public int[] Skills() {
        return skills;
    }

    public int Trader() {
        return skills[SkillType.Trader.getId()];
    }

    public void Trader(int value) {
        skills[SkillType.Trader.getId()] = value;
    }
}
