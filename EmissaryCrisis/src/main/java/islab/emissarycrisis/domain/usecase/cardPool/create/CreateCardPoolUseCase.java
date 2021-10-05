package islab.emissarycrisis.domain.usecase.cardPool.create;

import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.cardPool.CardPool;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.usecase.cardPool.repository.ICardPoolRepository;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;

import java.util.ArrayList;
import java.util.List;

public class CreateCardPoolUseCase {
    private IGameCardRepository gameCardRepository;
    private ICardPoolRepository cardPoolRepository;
    private DomainEventBus eventBus;
    public CreateCardPoolUseCase (IGameCardRepository gameCardRepository, ICardPoolRepository cardPoolRepository, DomainEventBus eventBus){
        this.gameCardRepository = gameCardRepository;
        this.cardPoolRepository = cardPoolRepository;
        this.eventBus = eventBus;
    }

    public void execute(CreateCardPoolUseCaseOutput createCardPoolUseCaseOutput){
        CardPool cardPool = new CardPool();
        List<String> cardIds = new ArrayList<>();
        for (GameCard card : gameCardRepository.getGameCards()){
            cardIds.add(card.getId());
        }
        cardPool.setGameCards(cardIds);

        cardPoolRepository.updateCardPool(cardPool);

        eventBus.postAll(cardPool);

        createCardPoolUseCaseOutput.setCardNumber(cardPool.getGameCards().size());
    }
}
