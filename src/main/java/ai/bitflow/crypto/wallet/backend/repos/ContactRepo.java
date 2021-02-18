package ai.bitflow.crypto.wallet.backend.repos;

import ai.bitflow.crypto.wallet.backend.entities.Contact;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ContactRepo implements PanacheRepository<Contact> {

    public Contact findByName(String name){
        return find("name", name).firstResult();
    }

    public List<Contact> findAlive(){
        return list("status", "alive");
    }

    public void deleteStefs(){
        delete("name", "Stef");
    }

}