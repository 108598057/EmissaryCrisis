package islab.emissarycrisis.domain.usecase.player.sent;

import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;

public class SentConfidentialMessageUseCase {
    private IPlayerRepository playerRepository;
    private IGameCardRepository gameCardRepository;
    private DomainEventBus eventBus ;

    public SentConfidentialMessageUseCase(IPlayerRepository playerRepository, IGameCardRepository gameCardRepository, DomainEventBus eventBus) {
        this.playerRepository = playerRepository;
        this.gameCardRepository = gameCardRepository;
        this.eventBus = eventBus;
    }

    public void execute(SentConfidentialMessageUseCaseInput input, SentConfidentialMessageUseCaseOutput output) {
        Player fromPlayer = playerRepository.getPlayer(input.getFromPlayerId());
        Player toPlayer = playerRepository.getPlayer(input.getToPlayerId());
        GameCard card = gameCardRepository.getGameCard(input.getGameCardId());

        fromPlayer.sentConfidentialMessage(toPlayer.getId() ,card.getId());
        eventBus.postAll(fromPlayer);

        output.setFromPlayerId(fromPlayer.getId());
        output.setHandCardCount(fromPlayer.getGameCards().size());
    }
}
