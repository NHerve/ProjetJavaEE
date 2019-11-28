package montp.data.dao;

import montp.data.model.Client;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientDAO extends GenericDAO<Client> {
    public ClientDAO(){super(Client.class);}
}
