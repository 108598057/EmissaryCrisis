package islab.emissarycrisis.domain.model.turn;

import islab.emissarycrisis.domain.model.DomainEventHolder;
import islab.emissarycrisis.domain.model.turn.event.TurnStarted;

public class Turn extends DomainEventHolder {
    private String playerId ;
    private Integer turnNum ;
    private Integer number ;

    public Turn(String playerId, Integer turnNum, Integer number) {
        super();
        this.playerId = playerId;
        this.turnNum = turnNum;
        this.number = number;
        this.addEvent( new TurnStarted( playerId, 2 ) );
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(Integer turnNum) {
        this.turnNum = turnNum;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
