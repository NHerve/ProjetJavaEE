package montp.data.dao;

import montp.data.model.Client;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ClientDAO extends GenericDAO<Client> {
    public ClientDAO(){super(Client.class);}

    public List<Client> getAll() {
        return em.createQuery("SELECT cli FROM Client cli order by cli.id")
                .getResultList();
    }
}
