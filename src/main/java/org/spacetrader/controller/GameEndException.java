package org.spacetrader.controller;

import org.spacetrader.controller.enums.GameEndType;


public class GameEndException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GameEndException(GameEndType endType) {
        Game.CurrentGame().setEndStatus(endType);
    }
}
