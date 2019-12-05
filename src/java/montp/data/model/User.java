package montp.data.model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SECURITY_USER")
public class User extends GenericEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    @Column(nullable = false, unique = true)
    private String adresseMail;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    private Date dateNaissance;
    private String adressePostal;
    private String codePostal;
    private String ville;
    private String numTel;
    private Double chiffreAffaire;
    private Integer tauxCharge;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String mdp;
    @Column(columnDefinition = "TEXT")
    private String oldMdp;
    @ManyToMany
    @JoinTable(name = "SECURITY_USER_GROUP",
            joinColumns = @JoinColumn(name = "adresseMail",
                    referencedColumnName = "adresseMail"),
            inverseJoinColumns = @JoinColumn(name = "groupname",
                    referencedColumnName = "groupname"))
    private List<Group> groups;

    public User(String mail,String password,String nom,String prenom){
        this.adresseMail = mail;
        this.mdp = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(){

    }

    //region SetterGetter


    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdressePostal() {
        return adressePostal;
    }

    public void setAdressePostal(String adressePostal) {
        this.adressePostal = adressePostal;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public Double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(Double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public Integer getTauxCharge() {
        return tauxCharge;
    }

    public void setTauxCharge(Integer tauxCharge) {
        this.tauxCharge = tauxCharge;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getOldMdp() {
        return oldMdp;
    }

    public void setOldMdp(String oldMdp) {
        this.oldMdp = oldMdp;
    }
    //endregion
}
