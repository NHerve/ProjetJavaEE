package montp.data.dao;

import montp.data.model.Facture;
import montp.data.model.LigneFacturation;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class LigneFacturationDAO extends GenericDAO<LigneFacturation> {
    public LigneFacturationDAO(){super(LigneFacturation.class);}

    public List<LigneFacturation> getAll() {
        return em.createQuery("SELECT lf FROM LigneFacturation lf order by lf.id")
                .getResultList();
    }
}
