package islab.emissarycrisis.domain.usecase.gamecard.repository;

import islab.emissarycrisis.domain.model.gamecard.GameCard;

public interface IGameCardRepository {
    GameCard getGameCard(String gameCardId);
    void add(GameCard card);
}
