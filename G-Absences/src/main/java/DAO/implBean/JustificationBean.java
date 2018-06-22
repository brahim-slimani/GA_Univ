package DAO.implBean;

import DAO.GenericFacade;
import DAO.IJustificationDAO;
import DAO.IJustificationDAOLocal;
import Entities.Justification;

import javax.ejb.Stateless;

@Stateless(name = "JustificationBeanEJB")
public class JustificationBean extends GenericFacade<Justification> implements IJustificationDAO, IJustificationDAOLocal {

}
