package Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Justification")
public class Justification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJustification;

    @OrderColumn

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeJustification type;

    @OneToOne
    @JoinColumn(name = "idAbsence")
    private Absence absence;

    public Justification() {
    }

    public Justification(TypeJustification type, Absence absence) {
        this.type = type;
        this.absence = absence;
    }

    public int getIdJustification() {
        return idJustification;
    }

    public void setIdJustification(int idJustification) {
        this.idJustification = idJustification;
    }

    public TypeJustification getType() {
        return type;
    }

    public void setType(TypeJustification type) {
        this.type = type;
    }

    public Absence getAbsence() {
        return absence;
    }

    public void setAbsence(Absence absence) {
        this.absence = absence;
    }
}
