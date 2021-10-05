package islab.emissarycrisis.domain.model.player;

import islab.emissarycrisis.domain.model.DomainEventHolder;
import islab.emissarycrisis.domain.model.cardPool.CardPool;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.event.ConfidentialMessageSent;
import islab.emissarycrisis.domain.model.player.event.GameCardDrawn;
import islab.emissarycrisis.domain.model.turn.event.TurnStarted;
import islab.emissarycrisis.domain.usecase.player.sent.SentConfidentialMessageUseCase;

import java.util.List;

public class Player extends DomainEventHolder {
    private String id;
    private CampCard campCard;
    private List<String> gameCards;
    private List<Message> messages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CampCard getCampCard() {
        return campCard;
    }

    public void setCampCard(CampCard campCard) {
        this.campCard = campCard;
    }

    public List<String> getGameCards() {
        return gameCards;
    }

    public void setGameCards(List<String> gameCards) {
        this.gameCards = gameCards;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void sentConfidentialMessage(String toPlayerId, String cardId) {
        for(String handCardId : gameCards)
            if(handCardId.equals(cardId)){
                gameCards.remove(handCardId);
                break;
            }
        this.addEvent( new ConfidentialMessageSent(this.getId(),toPlayerId, cardId));
    }

    public void draw(CardPool cardPool, Integer number) {
        List<String> cardIds = cardPool.draw(number);
        gameCards.addAll(cardIds);
        addEvent(new GameCardDrawn(id, cardIds));
    }
}
