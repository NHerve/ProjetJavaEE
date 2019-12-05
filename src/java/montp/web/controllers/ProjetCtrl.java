package montp.web.controllers;

import montp.data.dao.ClientDAO;
import montp.data.dao.ProjetDAO;
import montp.data.model.Client;
import montp.data.model.Projet;
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

@RequestScoped
@Named
public class ProjetCtrl implements Serializable {

    @Inject
    private ProjetDAO projetDAO;
    @Inject
    private ClientDAO clientDAO;
    private Projet projet = new  Projet();
    private List<Projet> listProjet;
    private List<Client> listClient;
    private Boolean boolDisplay;

    @PostConstruct
    public void init(){
        listProjet = projetDAO.getAll();
        listClient = clientDAO.getAll();
        boolDisplay = true;
    }

    public void add(){

        projetDAO.insert(projet);
        FacesTools.addMessage(FacesMessage.SEVERITY_INFO,
                "projet ajouter");

        projet = new Projet();
        init();
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {

            projet = listProjet.get(event.getRowIndex());

            String colName = event.getColumn().getClientId().split(":")[event.getColumn().getClientId().split(":").length-1];

            switch (colName){
                case "colNom" :
                    projet.setNom(newValue.toString());
                    break;
                case "colClient" :
                    projet.setClient((Client)newValue);
                    break;
                case "colStatut" :
                    projet.setStatut((Integer) newValue);
                    break;

            }

            projetDAO.update(projet);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void delete(Projet projet){
        projetDAO.delete(projet);
        init();
        FacesTools.addMessage(FacesMessage.SEVERITY_FATAL,
                "projet supprimer");
    }

    public void getStart(){
        if(boolDisplay){
            listProjet = projetDAO.getAll();
        }else {
            listProjet = projetDAO.getAllStatutStart();
        }
    }

    //region SetteGetter


    public Boolean getBoolDisplay() {
        return boolDisplay;
    }

    public void setBoolDisplay(Boolean boolDisplay) {
        this.boolDisplay = boolDisplay;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    public ProjetDAO getProjetDAO() {
        return projetDAO;
    }

    public void setProjetDAO(ProjetDAO projetDAO) {
        this.projetDAO = projetDAO;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<Projet> getListProjet() {
        return listProjet;
    }

    public void setListProjet(List<Projet> listProjet) {
        this.listProjet = listProjet;
    }


    //endregion
}
