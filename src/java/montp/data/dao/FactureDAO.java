package montp.data.dao;

import montp.data.model.Facture;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FactureDAO extends GenericDAO<Facture> {
    public FactureDAO(){super(Facture.class);}
}

