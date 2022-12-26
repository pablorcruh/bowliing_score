package org.example.domain;

import java.util.List;

public class ScoreBoardRow {

    private String playerName;

    private RegularSlot[] regularSlots = new RegularSlot[11];

    public void addRegularSlot(RegularSlot regularSlot){
        this.regularSlots[regularSlot.getPositionSlot()] = regularSlot;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public RegularSlot[] getRegularSlots() {
        return regularSlots;
    }

    public void setRegularSlots(RegularSlot[] regularSlots) {
        this.regularSlots = regularSlots;
    }

}
