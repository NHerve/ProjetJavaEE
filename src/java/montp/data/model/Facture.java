package montp.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Facture extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Projet projet;
    @Column(nullable = false)
    private Integer numFacture;
    @Column(nullable = false)
    private Integer statutFacture;
    @Column(nullable = false)
    private Date dateEdition;
    @Column(nullable = false)
    private Date dateLimite;
    private Integer typePaiement;
    private Date datePaiement;
    @OneToMany(fetch = FetchType.EAGER)
    private List<LigneFacturation> listLigne;

    //region GetterSetter

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Integer getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(Integer numFacture) {
        this.numFacture = numFacture;
    }

    public Integer getStatutFacture() {
        return statutFacture;
    }

    public void setStatutFacture(Integer statutFacture) {
        this.statutFacture = statutFacture;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Integer getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(Integer typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public List<LigneFacturation> getListLigne() {
        return listLigne;
    }

    public void setListLigne(List<LigneFacturation> listLigne) {
        this.listLigne = listLigne;
    }
    //endregion
}
