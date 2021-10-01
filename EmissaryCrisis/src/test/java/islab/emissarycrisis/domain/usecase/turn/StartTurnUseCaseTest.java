package islab.emissarycrisis.domain.usecase.turn;

import islab.emissarycrisis.domain.adapter.repository.gamecard.InMemoryGameCardRepository;
import islab.emissarycrisis.domain.adapter.repository.player.InMemoryPlayerRepository;
import islab.emissarycrisis.domain.adapter.repository.turn.InMemoryTurnRepository;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.Utility;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;
import islab.emissarycrisis.domain.usecase.turn.repository.ITurnRepository;
import islab.emissarycrisis.domain.usecase.turn.start.StartTurnUseCase;
import islab.emissarycrisis.domain.usecase.turn.start.StartTurnUseCaseInput;
import islab.emissarycrisis.domain.usecase.turn.start.StartTurnUseCaseOutput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StartTurnUseCaseTest {

    private  static IPlayerRepository playerRepository ;
    private static ITurnRepository turnRepository ;
    private static DomainEventBus eventBus ;

    @BeforeAll
    public static void setup(){
        playerRepository = new InMemoryPlayerRepository() ;
        turnRepository = new InMemoryTurnRepository() ;
        eventBus = new DomainEventBus() ;

        eventBus.register( new TurnEventHandler(playerRepository, eventBus) );
    }

    @Test
    public void StartTurnUseCase(  ) {
        StartTurnUseCase startTurnUseCase = new StartTurnUseCase( turnRepository, eventBus ) ;
        StartTurnUseCaseInput startTurnUseCaseInput = new StartTurnUseCaseInput() ;
        StartTurnUseCaseOutput startTurnUseCaseOutput = new StartTurnUseCaseOutput() ;

        startTurnUseCaseInput.setPlayerId( 1 ) ;
        startTurnUseCaseInput.setTurnNum( 2 ) ;
        startTurnUseCaseInput.setNumber(2) ;

        startTurnUseCase.execute( startTurnUseCaseInput, startTurnUseCaseOutput );

        assertEquals(Integer.valueOf(2), startTurnUseCaseOutput.getTurnNum());
        assertEquals(Integer.valueOf(2), startTurnUseCaseOutput.getNumber());
    }

}
