package islab.emissarycrisis.domain.usecase.turn.start;

import islab.emissarycrisis.domain.model.DomainEventBus;
import islab.emissarycrisis.domain.model.turn.Turn;
import islab.emissarycrisis.domain.usecase.turn.repository.ITurnRepository;

public class StartTurnUseCase {

    private ITurnRepository turnRepository ;
    private DomainEventBus eventBus;

    public StartTurnUseCase(ITurnRepository turnRepository, DomainEventBus eventBus ) {
        this.eventBus = eventBus ;
        this.turnRepository = turnRepository ;
    }

    public void execute(StartTurnUseCaseInput startTurnCaseInput, StartTurnUseCaseOutput startTurnCaseOutput){
        Turn turn = new Turn( startTurnCaseInput.getPlayerId(), startTurnCaseInput.getTurnNum(), startTurnCaseInput.getNumber() ) ;

        eventBus.postAll(turn);

        startTurnCaseOutput.setTurnNum( turn.getTurnNum() );
        startTurnCaseOutput.setNumber( turn.getNumber() ) ;
    }

}
