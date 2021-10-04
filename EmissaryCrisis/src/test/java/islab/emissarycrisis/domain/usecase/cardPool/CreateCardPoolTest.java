package islab.emissarycrisis.domain.usecase.cardPool;

import islab.emissarycrisis.domain.adapter.repository.cardPool.InMemoryCardPoolRepository;
import islab.emissarycrisis.domain.adapter.repository.gamecard.InMemoryGameCardRepository;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.usecase.Utility;
import islab.emissarycrisis.domain.usecase.cardPool.create.CreateCardPoolUseCase;
import islab.emissarycrisis.domain.usecase.cardPool.create.CreateCardPoolUseCaseOutput;
import islab.emissarycrisis.domain.usecase.cardPool.repository.ICardPoolRepository;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CreateCardPoolTest {

    private static IGameCardRepository gameCardRepository;
    private static ICardPoolRepository cardPoolRepository;
    private static DomainEventBus eventBus;
    @BeforeAll
    public static void setup(){
        gameCardRepository = new InMemoryGameCardRepository();
        cardPoolRepository = new InMemoryCardPoolRepository();
        Utility utility = new Utility();
        for(GameCard card : utility.createCardPool())
            gameCardRepository.add(card);
        eventBus = new DomainEventBus();
    }

    @Test
    public void createCardPoolUseCase(){
        CreateCardPoolUseCase createCardPoolUseCase = new CreateCardPoolUseCase(gameCardRepository, cardPoolRepository, eventBus);
        CreateCardPoolUseCaseOutput createCardPoolUseCaseOutput = new CreateCardPoolUseCaseOutput();

        createCardPoolUseCase.execute(createCardPoolUseCaseOutput);

        assertEquals(10, createCardPoolUseCaseOutput.getCardNumber());

    }
}
