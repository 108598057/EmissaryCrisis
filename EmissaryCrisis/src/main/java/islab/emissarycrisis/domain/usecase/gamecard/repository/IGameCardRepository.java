package islab.emissarycrisis.domain.usecase.gamecard.repository;

import islab.emissarycrisis.domain.model.gamecard.GameCard;

import java.util.List;

public interface IGameCardRepository {
    GameCard getGameCard(String gameCardId);
    void add(GameCard card);
    public List<GameCard> getGameCards();
}
