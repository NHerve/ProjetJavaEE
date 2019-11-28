package montp.data.dao;

import montp.data.model.LigneFacturation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LigneFacturationDAO extends GenericDAO<LigneFacturation> {
    public LigneFacturationDAO(){super(LigneFacturation.class);}
}
