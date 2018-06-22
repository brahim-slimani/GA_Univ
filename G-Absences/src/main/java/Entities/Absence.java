package Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Absence")
public class Absence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbsence;

    @OrderColumn

    @NotNull
    //@Past
    @Temporal(TemporalType.DATE)
    private Date dateAbsence;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatAbsence etat;

    @ManyToOne
    @JoinColumn(name = "idEtudiant")
    private Etudiant etudiant;

    @OneToOne(mappedBy = "absence", cascade = CascadeType.ALL)
    private Justification justification;

    public Absence() {
    }

    public Absence(Date dateAbsence, EtatAbsence etat, Etudiant etudiant, Justification justification) {
        this.dateAbsence = dateAbsence;
        this.etat = etat;
        this.etudiant = etudiant;
        this.justification = justification;
    }

    public int getIdAbsence() {
        return idAbsence;
    }

    public void setIdAbsence(int idAbsence) {
        this.idAbsence = idAbsence;
    }

    public Date getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(Date dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public EtatAbsence getEtat() {
        return etat;
    }

    public void setEtat(EtatAbsence etat) {
        this.etat = etat;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Justification getJustification() {
        return justification;
    }

    public void setJustification(Justification justification) {
        this.justification = justification;
    }
}
