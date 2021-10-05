package islab.emissarycrisis.domain.adapter.repository.cardPool;

import islab.emissarycrisis.domain.model.cardPool.CardPool;
import islab.emissarycrisis.domain.usecase.cardPool.repository.ICardPoolRepository;


public class InMemoryCardPoolRepository implements ICardPoolRepository {

    private CardPool cardPool;

    @Override
    public CardPool getCardPool(){
        return cardPool;
    }

    @Override
    public void updateCardPool(CardPool cardPool){
        this.cardPool = cardPool;
    }
}
