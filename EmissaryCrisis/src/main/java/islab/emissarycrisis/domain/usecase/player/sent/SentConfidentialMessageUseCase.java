package islab.emissarycrisis.domain.usecase.player.sent;

import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;

public class SentConfidentialMessageUseCase {
    private IPlayerRepository playerRepository;
    private IGameCardRepository gameCardRepository;

    public SentConfidentialMessageUseCase(IPlayerRepository playerRepository, IGameCardRepository gameCardRepository) {
        this.playerRepository = playerRepository;
        this.gameCardRepository = gameCardRepository;
    }

    public void execute(SentConfidentialMessageUseCaseInput input, SentConfidentialMessageUseCaseOutput output) {
        Player fromPlayer = playerRepository.getPlayer(input.getFromPlayerId());
        GameCard card = gameCardRepository.getGameCard(input.getGameCardId());

        fromPlayer.sentConfidentialMessage(card);

        output.setFromPlayerId(fromPlayer.getId());
        output.setHandCardCount(fromPlayer.getGameCards().size());
    }
}
