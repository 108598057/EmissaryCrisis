package islab.emissarycrisis.domain.usecase.cardPool.repository;

import islab.emissarycrisis.domain.model.cardPool.CardPool;


public interface ICardPoolRepository {
    public CardPool getCardPool();
    public void setCardPool(CardPool cardPool);
}
