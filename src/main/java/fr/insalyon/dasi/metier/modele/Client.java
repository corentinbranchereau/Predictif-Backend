package fr.insalyon.dasi.metier.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author thibautgravey
 */
@Entity
public class Client extends Utilisateur implements Serializable {

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String adresse_postale;
    
    @OneToOne
    private ProfilAstral profilAstral;
    
    @OneToMany(mappedBy="client")
    private List<Consultation> consultations;

    protected Client() {
    }
    
     public Client(String nom, String prenom, Genre genre, String email, String mdp, Date dateNaissance, String adresse_postale, String telephone) {
        super(nom, prenom, email, mdp, genre, telephone);
        this.dateNaissance = dateNaissance;
        this.adresse_postale = adresse_postale;
        this.profilAstral=null;
        this.consultations=new ArrayList<>();
    }

     
     public void addConsultation(Consultation consultation)
    {
        this.consultations.add(consultation);
        if(consultation.getClient() != this)
        {
            consultation.setClient(this);
        }
    }
     
    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
     
    public ProfilAstral getProfilAstral() {
        return profilAstral;
    }

    public void setProfilAstral(ProfilAstral profilAstral) {
        this.profilAstral = profilAstral;
    }
    
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse_postale() {
        return adresse_postale;
    }

    public void setAdresse_postale(String adresse_postale) {
        this.adresse_postale = adresse_postale;
    }

    @Override
    public String toString() {
        return super.toString() + ", type=Client, dateNaissance=" + dateNaissance + ", adresse_postale=" + adresse_postale + ", " + profilAstral;
    }
}
