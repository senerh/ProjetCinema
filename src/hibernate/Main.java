package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {

    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        Main ht = new Main();
        ht.sessionFactory = new Configuration().configure().buildSessionFactory();
        ht.getData();
    }

    public void getData(){
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from ActeurEntity").list();
        System.out.println(list.size());
        session.getTransaction().commit();
        session.close();
    }
}
