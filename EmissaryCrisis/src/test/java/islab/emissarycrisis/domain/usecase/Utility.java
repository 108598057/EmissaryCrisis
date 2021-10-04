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

    public List<GameCard> createCardPool() {
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

        card = new GameCard();
        card.setId("4");
        card.setColor("black");
        card.setName("鎖定");
        card.setType("密電");
        gameCards.add(card);

        card = new GameCard();
        card.setId("5");
        card.setColor("blue");
        card.setName("破譯");
        card.setType("密電");
        gameCards.add(card);

        card = new GameCard();
        card.setId("6");
        card.setColor("red");
        card.setName("燒毀");
        card.setType("直達");
        gameCards.add(card);

        card = new GameCard();
        card.setId("7");
        card.setColor("black");
        card.setName("轉移");
        card.setType("直達");
        gameCards.add(card);

        card = new GameCard();
        card.setId("8");
        card.setColor("blue");
        card.setName("調虎離山");
        card.setType("密電");
        gameCards.add(card);

        card = new GameCard();
        card.setId("9");
        card.setColor("red");
        card.setName("博弈");
        card.setType("直達");
        gameCards.add(card);

        card = new GameCard();
        card.setId("10");
        card.setColor("black");
        card.setName("真偽莫辨");
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
        player.setGameCards(convertCardIds(createGameCards()));
        player.setCampCard(createCampCard());

        return player;
    }

    public List<String> convertCardIds(List<GameCard> cards){
        List<String> cardIds = new ArrayList<>();
        for(GameCard card : cards){
            cardIds.add(card.getId());
        }

        return cardIds;
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
