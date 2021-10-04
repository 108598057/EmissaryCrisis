package islab.emissarycrisis.domain.usecase.player;

import islab.emissarycrisis.domain.adapter.repository.gamecard.InMemoryGameCardRepository;
import islab.emissarycrisis.domain.adapter.repository.player.InMemoryPlayerRepository;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.Utility;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DrawUseCaseTest {

    private static IPlayerRepository playerRepository ;
    private static IGameCardRepository gameCardRepository;
    private static List<Player> players;
    private static DomainEventBus eventBus ;
    @BeforeAll
    public static void setup(){
        playerRepository = new InMemoryPlayerRepository() ;
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
    public void drawUseCase() {
//        DrawUseCase drawUseCase = new DrawUseCase(playerRepository, gameCardRepository, eventBus);
//        DrawUseCaseInput input = new DrawUseCaseInput();
//        DrawUseCaseOutput output = new DrawUseCaseOutput();
//
//        input.setPlayerId(players.get(0).getId());
//        input.setDrawCardNumber(2);
//
//        drawUseCase.execute(input, output);
//
//
//
//        assertEquals(5,output.getHandCardNumber());
//


    }
}
