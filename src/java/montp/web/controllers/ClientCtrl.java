package montp.web.controllers;

import montp.data.dao.ClientDAO;
import montp.data.dao.UserDAO;
import montp.data.model.Client;
import montp.data.model.User;
import montp.tools.Tools;
import montp.web.FacesTools;
import org.primefaces.event.CellEditEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@RequestScoped
@Named
public class ClientCtrl implements Serializable {

    @Inject
    private ClientDAO clientDAO;
    private Client client = new  Client();
    private List<Client> listClient;
    private List<Client> listClientFiltre;

    @PostConstruct
    public void init(){
        listClient = clientDAO.getAll();
    }

    public void add(){
        if(client.getType()){
            clientDAO.insert(client);
            FacesTools.addMessage(FacesMessage.SEVERITY_INFO,
                    "client ajouter");

        }else{
            client.setPrenom(client.getNomContact());
            client.setNomContact(null);
            clientDAO.insert(client);
            FacesTools.addMessage(FacesMessage.SEVERITY_INFO,
                    "client ajouter");
        }

        client = new Client();
        init();
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {

            client = listClient.get(event.getRowIndex());

            String colName = event.getColumn().getClientId().split(":")[event.getColumn().getClientId().split(":").length-1];

            switch (colName){
                case "colNom" :
                    client.setNom(newValue.toString());
                    break;

                case "colNomContact" :
                    client.setNomContact(newValue.toString());
                    break;

                case "colPrenom" :
                    client.setPrenom(newValue.toString());
                    break;

                case "colMail" :
                    client.setAdresseMail(newValue.toString());
                    break;

                case "colTel" :
                    client.setNumTel(newValue.toString());
                    break;

                case "colAdresse" :
                    client.setAdresseMail(newValue.toString());
                    break;

                case "colCodePostal" :
                    client.setCodePostal(newValue.toString());
                    break;
                case "colVille" :
                    client.setVille(newValue.toString());
                    break;
            }

            clientDAO.update(client);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void delete(Client client){
        clientDAO.delete(client);
        init();
        FacesTools.addMessage(FacesMessage.SEVERITY_FATAL,
                "client supprimer");
    }


    //region SetteGetter


    public List<Client> getListClientFiltre() {
        return listClientFiltre;
    }

    public void setListClientFiltre(List<Client> listClientFiltre) {
        this.listClientFiltre = listClientFiltre;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    //endregion
}
