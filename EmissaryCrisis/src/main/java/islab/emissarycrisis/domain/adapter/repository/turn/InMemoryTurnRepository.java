package islab.emissarycrisis.domain.adapter.repository.turn;

import islab.emissarycrisis.domain.model.turn.Turn;
import islab.emissarycrisis.domain.usecase.turn.repository.ITurnRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTurnRepository implements ITurnRepository {

    List<Turn> turnList ;

    public InMemoryTurnRepository(){
        turnList = new ArrayList<Turn>() ;
    }

    @Override
    public void addTurn(Turn turn) {
        this.turnList.add( turn ) ;
    }

    @Override
    public Turn getTurn(int turnNum) {

        for( Turn turn : this.turnList ) {
            if ( turn.getTurnNum() == turnNum )
                return turn ;
        }

        return null ;
    }
}
