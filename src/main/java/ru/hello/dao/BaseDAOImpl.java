package ru.hello.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import ru.hello.model.ObjectWithId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDAOImpl<T, PK extends Serializable> implements BaseDAO<T, PK> {

    protected Class<?> clazz() {
        return (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @PersistenceContext
    protected EntityManager em;

    protected Session session() {
        Session session = (Session) em.getDelegate();
        if (!session.isOpen()) {
            session = session.getSessionFactory().openSession();
        }
        return session;
    }

    protected Criteria createCriteria() {
        return session().createCriteria(clazz());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T find(PK id) {
        if (id == null) return null;
        return (T) em.find(clazz(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return session().createCriteria(clazz()).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> distinctFindAll() {
        return session().createCriteria(clazz()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public <T> T save(T entity) {
        if (em.contains(entity) || (entity instanceof ObjectWithId && ((ObjectWithId) entity).getId() != null)) {
            entity = em.merge(entity);
        } else {
            em.persist(entity);
        }
        em.flush();
        return entity;
    }

    @Override
    public void delete(PK id) {
        em.remove(em.getReference(clazz(), id));
        em.flush();
    }

    @Override
    public void delete(T t) {
        t = em.merge(t);
        em.remove(t);
    }

    @Override
    public T create(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T read(PK id) {
        return find(id);
    }

    @Override
    public T update(T t) {
        return em.merge(t);
    }
}