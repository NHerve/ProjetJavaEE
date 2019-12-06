package montp.web.controllers;

import montp.data.dao.ClientDAO;
import montp.data.dao.FactureDAO;
import montp.data.dao.LigneFacturationDAO;
import montp.data.dao.ProjetDAO;
import montp.data.model.Client;
import montp.data.model.Facture;
import montp.data.model.LigneFacturation;
import montp.data.model.Projet;
import montp.web.FacesTools;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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
public class FactureCtrl implements Serializable {

    @Inject
    private ProjetDAO projetDAO;
    @Inject
    private FactureDAO factureDAO;
    @Inject
    LigneFacturationDAO ligneFactDAO;

    private Facture facture = new  Facture();
    private List<Projet> listProjet;
    private List<Facture> listFacture;
    private List<LigneFacturation> listLigneFacture;
    private LigneFacturation ligneFact;

    @PostConstruct
    public void init(){
        listProjet = projetDAO.getAll();
        listFacture = factureDAO.getAll();
        listLigneFacture = ligneFactDAO.getAll();
    }

    public void add(){

        factureDAO.insert(facture);
        FacesTools.addMessage(FacesMessage.SEVERITY_INFO,
                "facture ajouter");

        facture = new Facture();
        init();
    }

    public void delete(Facture facture){
        factureDAO.delete(facture);
        init();
        FacesTools.addMessage(FacesMessage.SEVERITY_FATAL,
                "facture supprimer");
    }

    public void onAddNew() {
        ligneFact = new LigneFacturation();
        listLigneFacture.add(ligneFact);
        FacesMessage msg = new FacesMessage("New ligne de facturation added", ligneFact.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //region SetteGetter


    public List<LigneFacturation> getListLigneFacture() {
        return listLigneFacture;
    }

    public void setListLigneFacture(List<LigneFacturation> listLigneFacture) {
        this.listLigneFacture = listLigneFacture;
    }

    public ProjetDAO getProjetDAO() {
        return projetDAO;
    }

    public void setProjetDAO(ProjetDAO projetDAO) {
        this.projetDAO = projetDAO;
    }

    public FactureDAO getFactureDAO() {
        return factureDAO;
    }

    public void setFactureDAO(FactureDAO factureDAO) {
        this.factureDAO = factureDAO;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public List<Projet> getListProjet() {
        return listProjet;
    }

    public void setListProjet(List<Projet> listProjet) {
        this.listProjet = listProjet;
    }

    public List<Facture> getListFacture() {
        return listFacture;
    }

    public void setListFacture(List<Facture> listFacture) {
        this.listFacture = listFacture;
    }

    //endregion
}
