package dao;

import util.HibernateUtil;
import org.hibernate.Session;

public class AbstractDAO {

    protected Session session;

    public AbstractDAO() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
