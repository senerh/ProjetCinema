package hibernate;

import org.hibernate.Session;


public class Main {

    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.close();
    }
}
