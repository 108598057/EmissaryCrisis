package islab.emissarycrisis.domain.usecase;

import islab.emissarycrisis.domain.model.gamecard.GameCard;
import islab.emissarycrisis.domain.model.player.CampCard;
import islab.emissarycrisis.domain.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    public Utility() {
    }

    public List<GameCard> createGameCards() {
        List<GameCard> gameCards = new ArrayList<>();
        GameCard card = new GameCard();
        card.setId("1");
        card.setColor("black");
        card.setName("識破");
        card.setType("直達");
        gameCards.add(card);

        card = new GameCard();
        card.setId("2");
        card.setColor("blue");
        card.setName("試探");
        card.setType("密電");
        gameCards.add(card);

        card = new GameCard();
        card.setId("3");
        card.setColor("red");
        card.setName("調包");
        card.setType("文本");
        gameCards.add(card);

        return gameCards;
    }

    public CampCard createCampCard() {
        CampCard campCard = new CampCard();
        campCard.setId("1");
        campCard.setName("醬油");
        return campCard;
    }

    public Player createPlayer(String id) {
        Player player = new Player();
        player.setId(id);
        player.setGameCards(createGameCards());
        player.setCampCard(createCampCard());

        return player;
    }

    public List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(createPlayer("tk"));
        players.add(createPlayer("zm"));
        players.add(createPlayer("ev"));
        players.add(createPlayer("yj"));
        players.add(createPlayer("cl"));
        return players;
    }
}
