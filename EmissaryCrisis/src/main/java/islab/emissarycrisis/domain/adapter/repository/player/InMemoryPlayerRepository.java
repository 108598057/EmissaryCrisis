package islab.emissarycrisis.domain.adapter.repository.player;

import islab.emissarycrisis.domain.model.player.Player;
import islab.emissarycrisis.domain.usecase.player.repository.IPlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPlayerRepository implements IPlayerRepository {
    public List<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(String playerId) {
        for(Player player : players)
            if(player.getId().equals(playerId))
                return player;
        return null;
    }

    @Override
    public void updatePlayer(Player player) {
        for(int k = 0; k < players.size(); k++) {
            if(players.get(k).getId().equals(player.getId()))
                players.set(k, player);
        }
    }
}
