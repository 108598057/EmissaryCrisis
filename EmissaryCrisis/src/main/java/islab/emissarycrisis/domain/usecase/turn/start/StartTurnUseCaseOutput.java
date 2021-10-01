package islab.emissarycrisis.domain.usecase.turn.start;

public class StartTurnUseCaseOutput {

    private int turnNum ;
    private int number ;

    public StartTurnUseCaseOutput() {
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
