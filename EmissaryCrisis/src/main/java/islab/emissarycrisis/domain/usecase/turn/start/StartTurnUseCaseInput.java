package islab.emissarycrisis.domain.usecase.turn.start;

public class StartTurnUseCaseInput {
    private int playerId ;
    private int turnNum ;
    private int number ;

    public StartTurnUseCaseInput() {
    }

    public StartTurnUseCaseInput(int playerId, int turnNum) {
        this.playerId = playerId;
        this.turnNum = turnNum;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public void setNumber(int i) {
        this.number = i ;
    }

    public int getNumber(){
        return this.number ;
    }
}
