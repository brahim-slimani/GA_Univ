package DAO;

import Entities.Etudiant;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IEtudiantDAO extends IGenericDAO<Etudiant> {

    List<Etudiant> lesEtudiantsAbsents ();
}
