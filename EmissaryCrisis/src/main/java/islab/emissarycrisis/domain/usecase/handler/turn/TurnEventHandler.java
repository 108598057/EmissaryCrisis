package islab.emissarycrisis.domain.usecase.handler.turn;

import com.google.common.eventbus.Subscribe;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.turn.event.TurnStarted;
import islab.emissarycrisis.domain.usecase.cardPool.repository.ICardPoolRepository;
import islab.emissarycrisis.domain.usecase.gamecard.repository.IGameCardRepository;
import islab.emissarycrisis.domain.usecase.player.draw.DrawUseCase;
import islab.emissarycrisis.domain.usecase.player.draw.DrawUseCaseInput;
import islab.emissarycrisis.domain.usecase.player.draw.DrawUseCaseOutput;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;

public class TurnEventHandler {
    private IPlayerRepository playerRepository;
    private DomainEventBus eventBus ;
    private ICardPoolRepository cardPoolRepository;

    public TurnEventHandler(IPlayerRepository playerRepository, ICardPoolRepository cardPoolRepository, DomainEventBus eventBus){
        this.playerRepository = playerRepository ;
        this.cardPoolRepository = cardPoolRepository;
        this.eventBus = eventBus ;
    }

    @Subscribe
    public void drawHandleEvent(TurnStarted turnStarted) {
        DrawUseCase drawUseCase = new DrawUseCase(playerRepository, cardPoolRepository, eventBus);
        DrawUseCaseInput input = new DrawUseCaseInput();
        DrawUseCaseOutput output = new DrawUseCaseOutput();

        input.setPlayerId(turnStarted.getPlayerId());
        input.setNumber(turnStarted.getNumber());

        drawUseCase.execute(input, output);
    }
}
