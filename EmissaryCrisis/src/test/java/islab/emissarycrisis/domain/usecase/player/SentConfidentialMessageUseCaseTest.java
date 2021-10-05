package islab.emissarycrisis.domain.usecase.player;

import islab.emissarycrisis.domain.adapter.repository.gamecard.InMemoryGameCardRepository;
import islab.emissarycrisis.domain.adapter.repository.player.InMemoryPlayerRepository;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.Utility;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;
import islab.emissarycrisis.domain.usecase.player.sent.SentConfidentialMessageUseCase;
import islab.emissarycrisis.domain.usecase.player.sent.SentConfidentialMessageUseCaseInput;
import islab.emissarycrisis.domain.usecase.player.sent.SentConfidentialMessageUseCaseOutput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SentConfidentialMessageUseCaseTest {
    private static IPlayerRepository playerRepository;
    private static IGameCardRepository gameCardRepository;
    private static List<Player> players;
    private static DomainEventBus eventBus ;

    @BeforeAll
    public static void setup(){
        playerRepository = new InMemoryPlayerRepository();
        gameCardRepository = new InMemoryGameCardRepository();
        Utility utility = new Utility();
        players = utility.createPlayers();
        for(Player player : players)
            playerRepository.addPlayer(player);
        for(GameCard card : utility.createGameCards())
            gameCardRepository.add(card);
        eventBus = new DomainEventBus();
    }

    @Test
    public void sentConfidentialMessageUseCase() {
        SentConfidentialMessageUseCase sentConfidentialMessageUseCase = new SentConfidentialMessageUseCase(playerRepository, gameCardRepository,eventBus);
        SentConfidentialMessageUseCaseInput input = new SentConfidentialMessageUseCaseInput();
        SentConfidentialMessageUseCaseOutput output = new SentConfidentialMessageUseCaseOutput();

        input.setFromPlayerId(players.get(0).getId());
        input.setToPlayerId(players.get(1).getId());
        input.setGameCardId(players.get(0).getGameCards().get(0));

        sentConfidentialMessageUseCase.execute(input, output);

        assertEquals(Integer.valueOf(2), output.getHandCardCount());
    }
}
