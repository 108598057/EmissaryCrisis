package islab.emissarycrisis.domain.usecase.turn.start;

public class StartTurnUseCaseInput {
    private String playerId ;
    private Integer turnNum ;
    private Integer number ;

    public StartTurnUseCaseInput() {
    }

    public StartTurnUseCaseInput(String playerId, Integer turnNum) {
        this.playerId = playerId;
        this.turnNum = turnNum;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(Integer turnNum) {
        this.turnNum = turnNum;
    }

    public void setNumber(Integer i) {
        this.number = i ;
    }

    public Integer getNumber(){
        return this.number ;
    }
}
