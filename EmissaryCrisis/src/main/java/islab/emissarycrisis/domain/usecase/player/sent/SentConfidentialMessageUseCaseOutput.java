package islab.emissarycrisis.domain.usecase.player.sent;

public class SentConfidentialMessageUseCaseOutput {
    private String fromPlayerId;
    private Integer handCardCount;

    public String getFromPlayerId() {
        return fromPlayerId;
    }

    public void setFromPlayerId(String fromPlayerId) {
        this.fromPlayerId = fromPlayerId;
    }

    public Integer getHandCardCount() {
        return handCardCount;
    }

    public void setHandCardCount(Integer handCardCount) {
        this.handCardCount = handCardCount;
    }
}
