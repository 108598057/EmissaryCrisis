package islab.emissarycrisis.domain.model.turn.event;

import islab.emissarycrisis.domain.model.DomainEvent;

public class TurnStarted implements DomainEvent {

    private int playerId ;
    private int number ;

    public TurnStarted() {
    }

    public TurnStarted(int playerId, int number) {
        this.playerId = playerId;
        this.number = number;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
