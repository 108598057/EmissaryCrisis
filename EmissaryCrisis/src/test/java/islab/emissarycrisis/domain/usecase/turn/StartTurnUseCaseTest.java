package islab.emissarycrisis.domain.usecase.turn;

import islab.emissarycrisis.domain.adapter.repository.cardPool.InMemoryCardPoolRepository;
import islab.emissarycrisis.domain.adapter.repository.gamecard.InMemoryGameCardRepository;
import islab.emissarycrisis.domain.adapter.repository.player.InMemoryPlayerRepository;
import islab.emissarycrisis.domain.adapter.repository.turn.InMemoryTurnRepository;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.Utility;
import islab.emissarycrisis.domain.usecase.cardPool.create.CreateCardPoolUseCase;
import islab.emissarycrisis.domain.usecase.cardPool.create.CreateCardPoolUseCaseOutput;
import islab.emissarycrisis.domain.usecase.cardPool.repository.ICardPoolRepository;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.handler.turn.TurnEventHandler;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;
import islab.emissarycrisis.domain.usecase.turn.repository.ITurnRepository;
import islab.emissarycrisis.domain.usecase.turn.start.StartTurnUseCase;
import islab.emissarycrisis.domain.usecase.turn.start.StartTurnUseCaseInput;
import islab.emissarycrisis.domain.usecase.turn.start.StartTurnUseCaseOutput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StartTurnUseCaseTest {
    private  static IPlayerRepository playerRepository ;
    private static ITurnRepository turnRepository ;
    private static IGameCardRepository gameCardRepository;
    private static ICardPoolRepository cardPoolRepository;
    private static List<Player> players;
    private static DomainEventBus eventBus ;

    @BeforeAll
    public static void setup(){
        playerRepository = new InMemoryPlayerRepository();
        turnRepository = new InMemoryTurnRepository();
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

        eventBus.register( new TurnEventHandler(playerRepository, cardPoolRepository, eventBus));
    }

    @Test
    public void StartTurnUseCase() {
        StartTurnUseCase startTurnUseCase = new StartTurnUseCase( turnRepository, eventBus ) ;
        StartTurnUseCaseInput startTurnUseCaseInput = new StartTurnUseCaseInput() ;
        StartTurnUseCaseOutput startTurnUseCaseOutput = new StartTurnUseCaseOutput() ;

        startTurnUseCaseInput.setPlayerId(players.get(0).getId()) ;
        startTurnUseCaseInput.setTurnNum( 2 ) ;
        startTurnUseCaseInput.setNumber(2) ;

        startTurnUseCase.execute( startTurnUseCaseInput, startTurnUseCaseOutput );

        assertEquals(Integer.valueOf(2), startTurnUseCaseOutput.getTurnNum());
        assertEquals(Integer.valueOf(2), startTurnUseCaseOutput.getNumber());
    }

    @Test
    public void StartTurnShouldDraw() {
        StartTurnUseCase startTurnUseCase = new StartTurnUseCase(turnRepository, eventBus) ;
        StartTurnUseCaseInput startTurnUseCaseInput = new StartTurnUseCaseInput() ;
        StartTurnUseCaseOutput startTurnUseCaseOutput = new StartTurnUseCaseOutput() ;

        startTurnUseCaseInput.setPlayerId(players.get(0).getId()) ;
        startTurnUseCaseInput.setTurnNum(2) ;
        startTurnUseCaseInput.setNumber(2) ;

        startTurnUseCase.execute( startTurnUseCaseInput, startTurnUseCaseOutput );

        assertEquals(Integer.valueOf(2), startTurnUseCaseOutput.getTurnNum());
        assertEquals(Integer.valueOf(2), startTurnUseCaseOutput.getNumber());
        assertEquals(8,cardPoolRepository.getCardPool().getGameCards().size());
        assertEquals(5,playerRepository.getPlayer(players.get(0).getId()).getGameCards().size());
    }
}
