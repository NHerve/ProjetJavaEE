package montp.data.model;

import javax.persistence.*;

@Entity
public class LigneFacturation extends GenericEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private Double prixUni;
    @Column(nullable = false)
    private Integer quantite;

    public LigneFacturation() {
    }

    public LigneFacturation(String libelle, Double prixUni, Integer quantite) {
        this.libelle = libelle;
        this.prixUni = prixUni;
        this.quantite = quantite;
    }


    //region GetterSetter

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrixUni() {
        return prixUni;
    }

    public void setPrixUni(Double prixUni) {
        this.prixUni = prixUni;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
    //endregion
}
