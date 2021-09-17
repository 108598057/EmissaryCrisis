package islab.emissarycrisis.domain.model.player;

import islab.emissarycrisis.domain.model.gamecard.GameCard;

import java.util.List;

public class Player {
    private String id;
    private CampCard campCard;
    private List<GameCard> gameCards;
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

    public List<GameCard> getGameCards() {
        return gameCards;
    }

    public void setGameCards(List<GameCard> gameCards) {
        this.gameCards = gameCards;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void sentConfidentialMessage(GameCard card) {
        for(GameCard handCard : gameCards)
            if(handCard.getId().equals(card.getId())){
                gameCards.remove(handCard);
                break;
            }
    }
}
