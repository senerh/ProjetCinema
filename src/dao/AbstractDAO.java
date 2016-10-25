package dao;

import util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class AbstractDAO<Entity> {

    private final Class<Entity> entityClass;
    protected Session session;

    public AbstractDAO(Class<Entity> entityClass) {
        this.entityClass = entityClass;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Entity> getEntityList() {
        session.beginTransaction();
        List<Entity> entityList = session.createQuery("from " + entityClass.getName()).list();
        session.getTransaction().commit();

        return entityList;
    }

    public Entity getEntityById(int id) {
        return getEntityById((Serializable) id);
    }

    public Entity getEntityById(String id) {
        return getEntityById((Serializable) id);
    }

    private Entity getEntityById(Serializable id) {
        session.beginTransaction();
        Entity entityById = session.get(entityClass, id);
        session.getTransaction().commit();

        return entityById;
    }

}
