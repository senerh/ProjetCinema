package dao;

import org.hibernate.Session;
import util.HibernateUtil;

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

    public Entity getEntityById(Serializable id) {
        session.beginTransaction();
        Entity entityById = session.get(entityClass, id);
        session.getTransaction().commit();

        return entityById;
    }

    public void updateEntity(Entity entity) {
        session.beginTransaction();
        try {
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Error while trying to update instance of <~" + entityClass.getName() + "~>.", e);
        } finally {
            session.close();
        }
    }

    public Entity saveEntity(Entity entity) {
        session.beginTransaction();
        try {
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Error while trying to save instance of <~" + entityClass.getName() + "~>.", e);
        } finally {
            session.close();
        }
        return entity;
    }

    public void deleteEntity(Serializable id) {
        session.beginTransaction();
        try {
            Entity entity = session.get(entityClass, id);
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Error while trying to delete instance of <~" + entityClass.getName() + "~>.", e);
        } finally {
            session.close();
        }
    }
}
