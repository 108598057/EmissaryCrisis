package islab.emissarycrisis.domain.model.player.event;

import islab.emissarycrisis.domain.model.DomainEvent;

public class ConfidentialMessageSent implements DomainEvent {
    private String fromPlayerId;
    private String toPlayerId;
    private String cardId;

    public ConfidentialMessageSent(String fromPlayerId, String toPlayerId, String cardId){
        this.fromPlayerId = fromPlayerId;
        this.toPlayerId = toPlayerId;
        this.cardId = cardId;
    }

    public String getFromPlayerId() {
        return fromPlayerId;
    }

    public void setFromPlayerId(String fromPlayerId) {
        this.fromPlayerId = fromPlayerId;
    }

    public String getToPlayerId() {
        return toPlayerId;
    }

    public void setToPlayerId(String toPlayerId) {
        this.toPlayerId = toPlayerId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
