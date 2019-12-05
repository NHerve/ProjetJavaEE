package montp.data.dao;

import montp.data.model.Client;
import montp.data.model.Projet;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProjetDAO extends GenericDAO<Projet> {
    public ProjetDAO(){super(Projet.class);}

    public List<Projet> getAll() {
        return em.createQuery("SELECT pro FROM Projet pro order by pro.id")
                .getResultList();
    }

    public List<Projet> getAllStatutStart() {
        List<Projet> listPro = em.createQuery("SELECT pro FROM Projet pro WHERE pro.statut=:param order by pro.id")
                .setParameter("param", 4)
                .getResultList();

        return listPro;
    }
}
