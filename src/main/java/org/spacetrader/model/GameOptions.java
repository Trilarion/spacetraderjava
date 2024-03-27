package org.spacetrader.model;

import org.spacetrader.Constants;
import org.winforms.dialog.Pane;

import java.util.Hashtable;


public class GameOptions extends SerializableObject {
    /**
     * Automatically ignores pirates when it is safe to do so
     */
    private boolean alwaysIgnorePirates;
    /**
     * Automatically ignores police when it is safe to do so
     */
    private boolean alwaysIgnorePolice;
    /**
     * Automatically ignores Trade in Orbit when it is safe to do so
     */
    private boolean alwaysIgnoreTradeInOrbit;
    /**
     * Automatically ignores traders when it is safe to do so
     */
    private boolean alwaysIgnoreTraders = true;
    /**
     * Automatically get a full tank when arriving in a new system
     */
    private boolean autoFuel;
    /**
     * Automatically get a full hull repair when arriving in a new system
     */
    private boolean autoRepair;
    /**
     * Continuous attack/flee mode
     */
    private boolean continuousAttack;
    /**
     * Continue attack on fleeing ship
     */
    private boolean continuousAttackFleeing;
    /**
     * Disable opponents when possible (when you have disabling weapons and the opponent is a pirate, trader, or mantis)
     */
    private boolean disableOpponents;
    /**
     * by default, ask each time someone buys a newspaper
     */
    private boolean newsAutoPay;
    /**
     * by default, don't show newspaper
     */
    private boolean newsAutoShow;
    /**
     * remind you every five days about outstanding loan balances
     */
    private boolean remindLoans = true;
    /**
     * Keep enough money for insurance and mercenaries
     */
    private boolean reserveMoney;
    /**
     * display range when tracking a system on Short Range Chart
     */
    private boolean showTrackedRange = true;
    /**
     * Automatically stop tracking a system when you get to it?
     */
    private boolean trackAutoOff = true;
    /**
     * Number of cargo bays to leave empty when buying goods
     */
    private int leaveEmpty;

    public GameOptions(Hashtable hash) {
        super(hash);
        alwaysIgnorePirates = GetValueFromHash(hash, "_alwaysIgnorePirates", alwaysIgnorePirates);
        alwaysIgnorePolice = GetValueFromHash(hash, "_alwaysIgnorePolice", alwaysIgnorePolice);
        alwaysIgnoreTradeInOrbit = GetValueFromHash(hash, "_alwaysIgnoreTradeInOrbit", alwaysIgnoreTradeInOrbit);
        alwaysIgnoreTraders = GetValueFromHash(hash, "_alwaysIgnoreTraders", alwaysIgnoreTraders);
        autoFuel = GetValueFromHash(hash, "_autoFuel", autoFuel);
        autoRepair = GetValueFromHash(hash, "_autoRepair", autoRepair);
        continuousAttack = GetValueFromHash(hash, "_continuousAttack", continuousAttack);
        continuousAttackFleeing = GetValueFromHash(hash, "_continuousAttackFleeing", continuousAttackFleeing);
        disableOpponents = GetValueFromHash(hash, "_disableOpponents", disableOpponents);
        newsAutoPay = GetValueFromHash(hash, "_newsAutoPay", newsAutoPay);
        newsAutoShow = GetValueFromHash(hash, "_newsAutoShow", newsAutoShow);
        remindLoans = GetValueFromHash(hash, "_remindLoans", remindLoans);
        reserveMoney = GetValueFromHash(hash, "_reserveMoney", reserveMoney);
        showTrackedRange = GetValueFromHash(hash, "_showTrackedRange", showTrackedRange);
        trackAutoOff = GetValueFromHash(hash, "_trackAutoOff", trackAutoOff);
        leaveEmpty = GetValueFromHash(hash, "_leaveEmpty", leaveEmpty);
    }

    public GameOptions(boolean loadFromDefaults) {
        if (loadFromDefaults) {
            LoadFromDefaults(false);
        }
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_alwaysIgnorePirates", alwaysIgnorePirates);
        hash.put("_alwaysIgnorePolice", alwaysIgnorePolice);
        hash.put("_alwaysIgnoreTradeInOrbit", alwaysIgnoreTradeInOrbit);
        hash.put("_alwaysIgnoreTraders", alwaysIgnoreTraders);
        hash.put("_autoFuel", autoFuel);
        hash.put("_autoRepair", autoRepair);
        hash.put("_continuousAttack", continuousAttack);
        hash.put("_continuousAttackFleeing", continuousAttackFleeing);
        hash.put("_disableOpponents", disableOpponents);
        hash.put("_newsAutoPay", newsAutoPay);
        hash.put("_newsAutoShow", newsAutoShow);
        hash.put("_remindLoans", remindLoans);
        hash.put("_reserveMoney", reserveMoney);
        hash.put("_showTrackedRange", showTrackedRange);
        hash.put("_trackAutoOff", trackAutoOff);
        hash.put("_leaveEmpty", leaveEmpty);
        return hash;
    }

    public void CopyValues(GameOptions source) {
        alwaysIgnorePirates = source.alwaysIgnorePirates;
        alwaysIgnorePolice = source.alwaysIgnorePolice;
        alwaysIgnoreTradeInOrbit = source.alwaysIgnoreTradeInOrbit;
        alwaysIgnoreTraders = source.alwaysIgnoreTraders;
        autoFuel = source.autoFuel;
        autoRepair = source.autoRepair;
        continuousAttack = source.continuousAttack;
        continuousAttackFleeing = source.continuousAttackFleeing;
        disableOpponents = source.disableOpponents;
        newsAutoPay = source.newsAutoPay;
        newsAutoShow = source.newsAutoShow;
        remindLoans = source.remindLoans;
        reserveMoney = source.reserveMoney;
        showTrackedRange = source.showTrackedRange;
        trackAutoOff = source.trackAutoOff;
        leaveEmpty = source.leaveEmpty;
    }

    public void LoadFromDefaults(boolean errorIfFileNotFound) {
        LoadFromDefaults(errorIfFileNotFound, null);
    }

    public void LoadFromDefaults(boolean errorIfFileNotFound, Pane owner) {
        GameOptions defaults = null;
        Object obj = ModelUtils.LoadFile(Constants.DefaultSettingsFile, !errorIfFileNotFound, owner);
        if (obj == null) {
            defaults = new GameOptions(false);
        } else {
            defaults = new GameOptions((Hashtable) obj);
        }
        CopyValues(defaults);
    }

    public void SaveAsDefaults(Pane owner) {
        ModelUtils.SaveFile(Constants.DefaultSettingsFile, Serialize(), owner);
    }

    public boolean getAlwaysIgnorePirates() {
        return alwaysIgnorePirates;
    }

    public void setAlwaysIgnorePirates(boolean value) {
        alwaysIgnorePirates = value;
    }

    public boolean getAlwaysIgnorePolice() {
        return alwaysIgnorePolice;
    }

    public void setAlwaysIgnorePolice(boolean value) {
        alwaysIgnorePolice = value;
    }

    public boolean getAlwaysIgnoreTradeInOrbit() {
        return alwaysIgnoreTradeInOrbit;
    }

    public void setAlwaysIgnoreTradeInOrbit(boolean value) {
        alwaysIgnoreTradeInOrbit = value;
    }

    public boolean getAlwaysIgnoreTraders() {
        return alwaysIgnoreTraders;
    }

    public void setAlwaysIgnoreTraders(boolean value) {
        alwaysIgnoreTraders = value;
    }

    public boolean getAutoFuel() {
        return autoFuel;
    }

    public void setAutoFuel(boolean value) {
        autoFuel = value;
    }

    public boolean getAutoRepair() {
        return autoRepair;
    }

    public void setAutoRepair(boolean value) {
        autoRepair = value;
    }

    public boolean getContinuousAttack() {
        return continuousAttack;
    }

    public void setContinuousAttack(boolean value) {
        continuousAttack = value;
    }

    public boolean getContinuousAttackFleeing() {
        return continuousAttackFleeing;
    }

    public void setContinuousAttackFleeing(boolean value) {
        continuousAttackFleeing = value;
    }

    public boolean getDisableOpponents() {
        return disableOpponents;
    }

    public void setDisableOpponents(boolean value) {
        disableOpponents = value;
    }

    public int getLeaveEmpty() {
        return leaveEmpty;
    }

    public void setLeaveEmpty(int value) {
        leaveEmpty = value;
    }

    public boolean getNewsAutoPay() {
        return newsAutoPay;
    }

    public void setNewsAutoPay(boolean value) {
        newsAutoPay = value;
    }

    public boolean getNewsAutoShow() {
        return newsAutoShow;
    }

    public void setNewsAutoShow(boolean value) {
        newsAutoShow = value;
    }

    public boolean getRemindLoans() {
        return remindLoans;
    }

    public void setRemindLoans(boolean value) {
        remindLoans = value;
    }

    public boolean getReserveMoney() {
        return reserveMoney;
    }

    public void setReserveMoney(boolean value) {
        reserveMoney = value;
    }

    public boolean getShowTrackedRange() {
        return showTrackedRange;
    }

    public void setShowTrackedRange(boolean value) {
        showTrackedRange = value;
    }

    public boolean getTrackAutoOff() {
        return trackAutoOff;
    }

    public void setTrackAutoOff(boolean value) {
        trackAutoOff = value;
    }
}
