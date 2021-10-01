package islab.emissarycrisis.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DomainEventHolder {

    private List<DomainEvent> domainEventList ;

    public DomainEventHolder(){
        this.domainEventList = new ArrayList<>();
    }

    public List<DomainEvent> getEvents() {
        return Collections.unmodifiableList( this.domainEventList ) ;
    }

    public void addEvent(DomainEvent event){
        this.domainEventList.add(event) ;
    }

    public void clearEvents(){
        this.domainEventList.clear();
    }

}
