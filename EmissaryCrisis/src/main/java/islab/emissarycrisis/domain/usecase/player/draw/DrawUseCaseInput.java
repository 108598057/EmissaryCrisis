package islab.emissarycrisis.domain.usecase.player.draw;

public class DrawUseCaseInput {
    private String playerId;
    private Integer number;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
