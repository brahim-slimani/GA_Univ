package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericFacade<T> implements IGenericDAO<T> {

    @PersistenceContext(unitName = "persistenceUnit2")
    protected EntityManager em;

    private Class<T> entityClass;

    public GenericFacade() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }


    public void create(T entity) {
        em.persist(entity);
    }

    public void edit(T entity) {
        em.merge(entity);
    }

    public void remove(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public T find(Object id) {
        return em.find(this.entityClass, id);
    }

    public List<T> findAll() {
        Query q = em.createQuery("SELECT c FROM " + this.entityClass.getSimpleName() + " c");
        return q.getResultList();
    }

    public Long Count() {
        Query q = em.createQuery("select count(c) from " + this.entityClass.getSimpleName() + " c");
        return (Long) q.getSingleResult();
    }


}
