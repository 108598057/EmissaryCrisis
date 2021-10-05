package islab.emissarycrisis.domain.model.turn.event;

import islab.emissarycrisis.domain.model.DomainEvent;

public class TurnStarted implements DomainEvent {

    private String playerId ;
    private Integer number ;

    public TurnStarted() {
    }

    public TurnStarted(String playerId, Integer number) {
        this.playerId = playerId;
        this.number = number;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
