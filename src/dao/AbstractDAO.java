package dao;

import model.ActeurEntity;
import util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AbstractDAO {

    protected Session session;

    public AbstractDAO() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<?> getEntityList(Class entity) {
        session.beginTransaction();
        List<?> entityList = session.createQuery("from "+entity.getName()).list();
        session.getTransaction().commit();

        return entityList;
    }

    public Object getEntityById(Class entity, int id) {
        session.beginTransaction();
        Object entityById = session.get(entity, id);
        session.getTransaction().commit();

        return entityById;
    }

}
