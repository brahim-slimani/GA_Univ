package DAO.implBean;

import DAO.GenericFacade;
import DAO.IAbsenceDAO;
import DAO.IAbsenceDAOLocal;
import Entities.Absence;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "AbsenceBeanEJB")
public class AbsenceBean extends GenericFacade<Absence> implements IAbsenceDAO, IAbsenceDAOLocal {

    @Override
    public List<Absence> AbsencesNonJust() {
        Query q = em.createQuery("SELECT a FROM Absence a WHERE etat = 'Injustifie' ");
        return q.getResultList();

    }

    @Override
    public List<Absence> AbsencesJust() {
        Query q = em.createQuery("SELECT a FROM Absence a WHERE etat = 'Justifie' ");
        return q.getResultList();
    }
}
