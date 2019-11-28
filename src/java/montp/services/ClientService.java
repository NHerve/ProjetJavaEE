package montp.services;

import montp.data.dao.ClientDAO;
import montp.data.model.Client;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientService extends GenericService<Client, ClientDAO> {
}
