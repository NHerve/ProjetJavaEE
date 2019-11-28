package montp.services;

import montp.data.dao.LigneFacturationDAO;
import montp.data.model.LigneFacturation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LigneFacturationService extends GenericService<LigneFacturation, LigneFacturationDAO> {
}
