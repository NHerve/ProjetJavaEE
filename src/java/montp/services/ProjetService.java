package montp.services;

import montp.data.dao.ProjetDAO;
import montp.data.model.Projet;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjetService extends GenericService<Projet, ProjetDAO> {
}
