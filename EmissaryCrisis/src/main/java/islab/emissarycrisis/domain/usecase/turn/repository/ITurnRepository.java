package islab.emissarycrisis.domain.usecase.turn.repository;

import islab.emissarycrisis.domain.model.turn.Turn;

public interface ITurnRepository {
    void addTurn(Turn turn);
    Turn getTurn(int turnNum);
}
