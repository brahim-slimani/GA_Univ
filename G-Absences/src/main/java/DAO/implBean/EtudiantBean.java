package DAO.implBean;

import DAO.GenericFacade;
import DAO.IEtudiantDAO;
import DAO.IEtudiantDAOLocal;
import Entities.Etudiant;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "EtudiantBeanEJB")
public class EtudiantBean extends GenericFacade<Etudiant> implements IEtudiantDAO, IEtudiantDAOLocal {

    @Override
    public List<Etudiant> lesEtudiantsAbsents() {

        Query q = em.createQuery("SELECT e FROM Etudiant e WHERE size(e.LesAbsences) > 0");
        return q.getResultList();

    }
}
