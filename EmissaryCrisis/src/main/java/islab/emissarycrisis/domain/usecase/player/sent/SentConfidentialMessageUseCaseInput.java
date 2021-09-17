package islab.emissarycrisis.domain.usecase.player.sent;

public class SentConfidentialMessageUseCaseInput {
    private String fromPlayerId;
    private String toPlayerId;
    private String gameCardId;

    public String getFromPlayerId() {
        return fromPlayerId;
    }

    public void setFromPlayerId(String fromPlayerId) {
        this.fromPlayerId = fromPlayerId;
    }

    public String getToPlayerId() {
        return toPlayerId;
    }

    public void setToPlayerId(String toPlayerId) {
        this.toPlayerId = toPlayerId;
    }

    public String getGameCardId() {
        return gameCardId;
    }

    public void setGameCardId(String gameCardId) {
        this.gameCardId = gameCardId;
    }
}
