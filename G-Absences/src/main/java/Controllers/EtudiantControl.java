package Controllers;


import DAO.IEtudiantDAOLocal;
import Entities.Etudiant;
import Entities.Sexe;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Named
@SessionScoped
public class EtudiantControl implements Serializable {

    @EJB
    private IEtudiantDAOLocal et;

    private List<Etudiant> listeEtudiants;

    private String code;
    private String nom;
    private String prenom;
    private String promotion;
    private String specialite;
    private String email;
    private String genre;

    private Etudiant student;

    @PostConstruct
    public void init(){
        this.listeEtudiants = new ArrayList<Etudiant>();
        this.listeEtudiants = et.findAll();
    }

    public String ajouterEtudiant(){
        Etudiant etudiant = new Etudiant();

        etudiant.setCodeEtudiant(code);
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setGenre(Sexe.valueOf(genre));
        etudiant.setPromotion(promotion);
        etudiant.setSpecialite(specialite);
        etudiant.setEmail(email);

        et.create(etudiant);

        init();

        clearInputs();

        return "listeEtudiants";
    }

    public String formUpdateEtudiant(int idEtudiant){

        student = et.find(idEtudiant);

        return "updateEtudiant.xhtml";
    }


    public String modifierEtudiant(Etudiant etudiant){

        et.edit(etudiant);
        init();

        return "listeEtudiants.xhtml";
    }

    public String supprimerEtudiant(int idEtudiant){

        Etudiant e = et.find(idEtudiant);
        et.remove(e);
        init();

        return "listeEtudiants.xhtml";
    }


    public void clearInputs(){
        code = "";
        nom = "";
        prenom = "";
        email = "";
        genre = "";
        promotion = "";
        specialite = "";
    }



    public String lienForm(){
        return "formEtudiant";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public IEtudiantDAOLocal getEt() {
        return et;
    }

    public void setEt(IEtudiantDAOLocal et) {
        this.et = et;
    }

    public List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public void setListeEtudiants(List<Etudiant> listeEtudiants) {
        this.listeEtudiants = listeEtudiants;
    }

    public Etudiant getStudent() {
        return student;
    }

    public void setStudent(Etudiant student) {
        this.student = student;
    }
}
