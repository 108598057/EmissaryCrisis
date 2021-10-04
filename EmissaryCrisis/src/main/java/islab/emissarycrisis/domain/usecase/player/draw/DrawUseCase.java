package islab.emissarycrisis.domain.usecase.player.draw;

import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;

public class DrawUseCase {
    private IPlayerRepository playerRepository;
    private DomainEventBus eventBus ;
    public DrawUseCase(IPlayerRepository playerRepository, DomainEventBus eventBus){
        this.playerRepository = playerRepository;
        this.eventBus = eventBus;
    }

//    public void execute(DrawUseCaseInput drawUseCaseInput, DrawUseCaseOutput drawUseCaseOutput){
//
//    }
}
