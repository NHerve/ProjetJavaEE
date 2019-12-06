package montp.data.dao;

import montp.data.model.Facture;
import montp.data.model.Projet;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FactureDAO extends GenericDAO<Facture> {
    public FactureDAO(){super(Facture.class);}

    public List<Facture> getAll() {
        return em.createQuery("SELECT fact FROM Facture fact order by fact.id")
                .getResultList();
    }
}

