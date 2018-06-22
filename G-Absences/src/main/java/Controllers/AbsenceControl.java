package Controllers;


import DAO.IAbsenceDAOLocal;
import DAO.IEtudiantDAOLocal;
import DAO.IJustificationDAOLocal;
import Entities.*;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ManagedBean
@SessionScoped
public class AbsenceControl implements Serializable {
    @EJB
    private IAbsenceDAOLocal ab;
    @EJB
    private IEtudiantDAOLocal et;
    @EJB
    private IJustificationDAOLocal js;

    private String code;
    private String nom;
    private String prenom;
    private String promotion;
    private String specialite;
    private Date dateAbsence;

    private Etudiant studentAbsent;

    private Absence absencesForUpdate;

    private List<Absence> lesAbsences;
    private List<Absence> lesAbsencesNonJust;

    private List<Justification> AbsenceJustifies;
    private Absence absence;
    private String typeJustification;


    @PostConstruct
    public void init(){
        this.lesAbsences = new ArrayList<Absence>();
        this.lesAbsencesNonJust = new ArrayList<Absence>();
        this.AbsenceJustifies = new ArrayList<Justification>();

        this.lesAbsences = ab.findAll();
        this.lesAbsencesNonJust = ab.AbsencesNonJust();
        this.AbsenceJustifies = js.findAll();
    }

    public String formAbsence(int idEtudiant){
        studentAbsent = et.find(idEtudiant);
        return "formAbsence.xhtml";
    }

    public String validerAbsence(Etudiant etudiant){

        Absence absence = new Absence();
        absence.setEtudiant(etudiant);
        absence.setEtat(EtatAbsence.Injustifie);
        absence.setDateAbsence(dateAbsence);

        ab.create(absence);

        init();

        return "listeAbsences.xhtml";
    }

    public String lienJustifie(int idAbsence){
        absence = ab.find(idAbsence);

        return "formJustifie";

    }

    public String validerJustification(int idAbsence){
        Absence abs = ab.find(idAbsence);
        Justification just = new Justification();
        just.setAbsence(abs);
        just.setType(TypeJustification.Autres.valueOf(typeJustification));
        abs.setJustification(just);
        abs.setEtat(EtatAbsence.Justifie);
        ab.edit(abs);

        init();

        return "absencesJustifies";

    }

    public String formUpdateAbsence(int idA){
        absencesForUpdate = ab.find(idA);

        return "updateAbsence";

    }

    public String modifierAbsence(Absence absence){

        if(absence.getEtat().equals("Injustifie")){
            js.remove(absence.getJustification());
        }

        ab.edit(absence);
        init();

        return "listeAbsences";
    }

    public String supprimerAbsence(int idA){

        ab.remove(ab.find(idA));
        init();

        return "listeAbsences";
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

    public Date getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(Date dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public Etudiant getStudentAbsent() {
        return studentAbsent;
    }

    public void setStudentAbsent(Etudiant studentAbsent) {
        this.studentAbsent = studentAbsent;
    }

    public List<Absence> getLesAbsences() {
        return lesAbsences;
    }

    public void setLesAbsences(List<Absence> lesAbsences) {
        this.lesAbsences = lesAbsences;
    }

    public List<Absence> getLesAbsencesNonJust() {
        return lesAbsencesNonJust;
    }

    public void setLesAbsencesNonJust(List<Absence> lesAbsencesNonJust) {
        this.lesAbsencesNonJust = lesAbsencesNonJust;
    }

    public List<Justification> getAbsenceJustifies() {
        return AbsenceJustifies;
    }

    public void setAbsenceJustifies(List<Justification> absenceJustifies) {
        AbsenceJustifies = absenceJustifies;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }

    public String getTypeJustification() {
        return typeJustification;
    }

    public void setTypeJustification(String typeJustification) {
        this.typeJustification = typeJustification;
    }

    public Absence getAbsencesForUpdate() {
        return absencesForUpdate;
    }

    public void setAbsencesForUpdate(Absence absencesForUpdate) {
        this.absencesForUpdate = absencesForUpdate;
    }
}
