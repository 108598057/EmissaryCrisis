package islab.emissarycrisis.domain.model.turn;

import islab.emissarycrisis.domain.model.DomainEventHolder;
import islab.emissarycrisis.domain.model.turn.event.TurnStarted;

public class Turn extends DomainEventHolder {

    private int playerId ;
    private int turnNum ;
    private int number ;

    public Turn(int playerId, int turnNum, int number) {
        super();
        this.playerId = playerId;
        this.turnNum = turnNum;
        this.number = number;
        this.addEvent( new TurnStarted( playerId, 2 ) );
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
