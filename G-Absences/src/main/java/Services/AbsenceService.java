package Services;


import DAO.IAbsenceDAOLocal;
import DAO.IEtudiantDAOLocal;
import DAO.IJustificationDAOLocal;
import Entities.Absence;
import Entities.Etudiant;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/absence")
public class AbsenceService {

    @EJB
    IAbsenceDAOLocal ab;

    @EJB
    IEtudiantDAOLocal et;

    @EJB
    private IJustificationDAOLocal js;


    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Absence find(@QueryParam("id") int id)
    {
        return ab.find(id);
    }



    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/all")
    public ArrayList<String> getAbsences(){

        ArrayList<Absence> absences = new ArrayList<Absence>();
        absences = (ArrayList<Absence>) ab.findAll();

        ArrayList<String> l = new ArrayList<>();

        for(Absence a:absences)
            l.add(a.getEtudiant().getNom()+" "+a.getEtudiant().getPrenom()+" absenté le : "+a.getDateAbsence());

        return l;

    }


//    @GET
//    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//    @Path("/allStudent")
//    public ArrayList<Etudiant> getStudents(){
//
//        return (ArrayList<Etudiant>) et.findAll();
//
//    }





}
