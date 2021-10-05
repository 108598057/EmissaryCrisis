package islab.emissarycrisis.domain.usecase.player;

import islab.emissarycrisis.domain.adapter.repository.cardPool.InMemoryCardPoolRepository;
import islab.emissarycrisis.domain.adapter.repository.gamecard.InMemoryGameCardRepository;
import islab.emissarycrisis.domain.adapter.repository.player.InMemoryPlayerRepository;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.Utility;
import islab.emissarycrisis.domain.usecase.cardPool.create.CreateCardPoolUseCase;
import islab.emissarycrisis.domain.usecase.cardPool.create.CreateCardPoolUseCaseOutput;
import islab.emissarycrisis.domain.usecase.cardPool.repository.ICardPoolRepository;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.player.draw.DrawUseCase;
import islab.emissarycrisis.domain.usecase.player.draw.DrawUseCaseInput;
import islab.emissarycrisis.domain.usecase.player.draw.DrawUseCaseOutput;
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
    private static ICardPoolRepository cardPoolRepository;
    private static List<Player> players;
    private static DomainEventBus eventBus ;
    @BeforeAll
    public static void setup(){
        playerRepository = new InMemoryPlayerRepository() ;
        gameCardRepository = new InMemoryGameCardRepository();
        cardPoolRepository = new InMemoryCardPoolRepository();
        eventBus = new DomainEventBus();

        Utility utility = new Utility();
        players = utility.createPlayers();
        for(Player player : players)
            playerRepository.addPlayer(player);
        for(GameCard card : utility.createCardPool())
            gameCardRepository.add(card);

        CreateCardPoolUseCase createCardPoolUseCase = new CreateCardPoolUseCase(gameCardRepository, cardPoolRepository, eventBus);
        CreateCardPoolUseCaseOutput createCardPoolUseCaseOutput = new CreateCardPoolUseCaseOutput();
        createCardPoolUseCase.execute(createCardPoolUseCaseOutput);
    }

    @Test
    public void drawUseCase() {
        DrawUseCase drawUseCase = new DrawUseCase(playerRepository, cardPoolRepository, eventBus);
        DrawUseCaseInput input = new DrawUseCaseInput();
        DrawUseCaseOutput output = new DrawUseCaseOutput();

        input.setPlayerId(players.get(0).getId());
        input.setNumber(2);

        drawUseCase.execute(input, output);

        assertEquals(5,output.getHandCardNumber());
        assertEquals(8,cardPoolRepository.getCardPool().getGameCards().size());
        assertEquals(5,playerRepository.getPlayer(players.get(0).getId()).getGameCards().size());
    }
}
