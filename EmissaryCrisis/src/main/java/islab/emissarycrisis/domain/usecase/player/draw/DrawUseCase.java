package islab.emissarycrisis.domain.usecase.player.draw;

import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.cardPool.CardPool;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.cardPool.repository.ICardPoolRepository;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;

public class DrawUseCase {
    private IPlayerRepository playerRepository;
    private DomainEventBus eventBus ;
    private ICardPoolRepository cardPoolRepository;

    public DrawUseCase(IPlayerRepository playerRepository, ICardPoolRepository cardPoolRepository, DomainEventBus eventBus) {
        this.playerRepository = playerRepository;
        this.cardPoolRepository = cardPoolRepository;
        this.eventBus = eventBus;
    }

    public void execute(DrawUseCaseInput drawUseCaseInput, DrawUseCaseOutput drawUseCaseOutput){
        Player player = playerRepository.getPlayer(drawUseCaseInput.getPlayerId());
        CardPool cardPool = cardPoolRepository.getCardPool();

        player.draw(cardPool, drawUseCaseInput.getNumber());

        cardPoolRepository.updateCardPool(cardPool);
        playerRepository.updatePlayer(player);

        eventBus.postAll(player);

        drawUseCaseOutput.setHandCardNumber(player.getGameCards().size());
    }
}
