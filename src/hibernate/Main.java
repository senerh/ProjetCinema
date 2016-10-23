package hibernate;

import model.ActeurEntity;
import model.PersonnageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
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
        List<ActeurEntity> acteurEntityList = session.createQuery("from ActeurEntity").list();
        ActeurEntity acteurEntity = acteurEntityList.get(0);
        System.out.println(acteurEntity.getPrenAct() + " " + acteurEntity.getNomAct());
        List<PersonnageEntity> personnageEntities = acteurEntity.getPersonnagesByNoAct();
        for(PersonnageEntity personnageEntity : personnageEntities) {
            System.out.println(personnageEntity.getNomPers());
        }
        session.getTransaction().commit();
        session.close();
    }
}
