package islab.emissarycrisis.domain.usecase.handler.turn;

import com.google.common.eventbus.Subscribe;
import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.turn.event.TurnStarted;
import islab.emissarycrisis.domain.usecase.player.draw.DrawUseCase;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;

public class TurnEventHandler {

    private IPlayerRepository playerRepository ;
    private DomainEventBus eventBus ;

    public TurnEventHandler( IPlayerRepository playerRepository, DomainEventBus eventBus ){
        this.playerRepository = playerRepository ;
        this.eventBus = eventBus ;
    }

    @Subscribe
    public void drawHandleEvent(TurnStarted turnStarted) {
//        DrawUseCase drawUseCase = new DrawUseCase();
//        DrawUseCaseInput drawUseCaseInput = new DrawUseCaseInput() ;
//        DrawUseCaseOutput drawUseCaseOutput = new DrawUseCaseOutput() ;
//
//        drawUseCase.setPlayerId( turnStarted.getPlayerId() ) ;
//        drawUseCase.setNumber( turnStarted.getNumber() ) ;
//
//        drawUseCase.execute( drawUseCaseInput, drawUseCaseOutput ) ;
    }

}
