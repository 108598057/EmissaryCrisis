package islab.emissarycrisis.domain.adapter.repository.gamecard;

import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGameCardRepository implements IGameCardRepository {
    private List<GameCard> cards = new ArrayList<>();

    @Override
    public GameCard getGameCard(String gameCardId) {
        for(GameCard card : cards)
            if(card.getId().equals(gameCardId))
                return card;
        return null;
    }

    @Override
    public void add(GameCard card) {
        cards.add(card);
    }
}
