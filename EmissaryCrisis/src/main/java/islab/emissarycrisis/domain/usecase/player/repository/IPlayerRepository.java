package islab.emissarycrisis.domain.usecase.player.repository;

import islab.emissarycrisis.domain.model.player.Player;

public interface IPlayerRepository {
    void addPlayer(Player player);
    Player getPlayer(String playerId);
}
