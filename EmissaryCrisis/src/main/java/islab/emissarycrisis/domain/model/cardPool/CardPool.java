package islab.emissarycrisis.domain.model.cardPool;

import islab.emissarycrisis.domain.model.DomainEventHolder;

import java.util.List;

public class CardPool extends DomainEventHolder {
    private List<String> gameCards;

    public List<String> getGameCards() {
        return gameCards;
    }

    public void setGameCards(List<String> gameCards) {
        this.gameCards = gameCards;
    }

}
