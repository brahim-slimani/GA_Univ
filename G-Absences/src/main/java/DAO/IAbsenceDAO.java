package DAO;

import Entities.Absence;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IAbsenceDAO extends IGenericDAO<Absence> {

    List<Absence> AbsencesNonJust();
    List<Absence> AbsencesJust();
}
