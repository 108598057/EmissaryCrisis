package islab.emissarycrisis.domain.model.cardPool;

import islab.emissarycrisis.domain.model.DomainEventHolder;

import java.util.ArrayList;
import java.util.List;

public class CardPool extends DomainEventHolder {
    private List<String> gameCards;

    public List<String> getGameCards() {
        return gameCards;
    }

    public void setGameCards(List<String> gameCards) {
        this.gameCards = gameCards;
    }

    public List<String> draw(Integer number) {
        List<String> cardIds = new ArrayList<>();
        for(int k = 0; k < number; k++) {
            cardIds.add(gameCards.remove(0));
        }
        return cardIds;
    }
}
