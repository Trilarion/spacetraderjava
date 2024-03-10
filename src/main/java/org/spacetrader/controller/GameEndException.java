package org.spacetrader.controller;

import org.spacetrader.controller.enums.GameEndType;


// TODO document and describe usage
public class GameEndException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GameEndException(GameEndType endType) {
        Game.getCurrentGame().setEndStatus(endType);
    }
}
