package Controllers;


import DAO.IAbsenceDAOLocal;
import DAO.IJustificationDAOLocal;
import Entities.Absence;
import Entities.EtatAbsence;
import Entities.Justification;
import Entities.TypeJustification;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ManagedBean
@SessionScoped
public class JustifieControl implements Serializable {

    @EJB private IJustificationDAOLocal js;
    @EJB private IAbsenceDAOLocal ab;

    private List<Justification> AbsenceJustifies;

    private Absence absence;
    private String typeJustification;

    @PostConstruct
    public void init(){
        this.AbsenceJustifies = new ArrayList<Justification>();
        this.AbsenceJustifies = js.findAll();
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

        this.AbsenceJustifies = js.findAll();

        return "absencesJustifies";

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
}
