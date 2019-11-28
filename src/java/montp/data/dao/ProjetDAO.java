package montp.data.dao;

import montp.data.model.Projet;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjetDAO extends GenericDAO<Projet> {
    public ProjetDAO(){super(Projet.class);}
}
