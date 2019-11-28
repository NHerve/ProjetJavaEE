package montp.services;

import montp.data.dao.FactureDAO;
import montp.data.model.Facture;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FactureService extends GenericService<Facture, FactureDAO> {
}
