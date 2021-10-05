package islab.emissarycrisis.domain.model.player.event;

import islab.emissarycrisis.domain.model.DomainEvent;

import java.util.List;

public class GameCardDrawn implements DomainEvent {
    public GameCardDrawn(String id, List<String> cardIds) {
    }
}
