package islab.emissarycrisis.domain.model;

import com.google.common.eventbus.EventBus;

import java.util.List;

public class DomainEventBus extends EventBus{

    public DomainEventBus(){
        super();
    }

    public void postAll(DomainEventHolder eventHolder){

        List<DomainEvent> domainEvents = eventHolder.getEvents();

        for (DomainEvent event: domainEvents){
            post(event);
        }

        eventHolder.clearEvents();
    }
}
