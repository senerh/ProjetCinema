package dao;

import model.ActeurEntity;
import model.PersonnageEntity;
import org.hibernate.query.Query;

import java.util.List;

public class ActeurDAO extends AbstractDAO<ActeurEntity> {

    public ActeurDAO() {
        super(ActeurEntity.class);
    }

    public List<PersonnageEntity> getPersonnageEntityListByActeur(int noAct) {
        session.beginTransaction();
        ActeurEntity acteurEntity = session.get(ActeurEntity.class, noAct);
        List<PersonnageEntity> personnageEntityList = acteurEntity.getPersonnagesByNoAct();
        //??? Pour charger la liste de personnages, il faut être dans une transaction
        //??? Appel d'une méthode sur la liste de personnages pour la charger car on est en lazy
        personnageEntityList.size();
        session.getTransaction().commit();
        return personnageEntityList;
    }

    public void deleteActeurEntity(int noAct) {
        session.beginTransaction();
        try {
            ActeurEntity acteurEntity = session.get(ActeurEntity.class, noAct);
            Query query = session.createQuery("delete PersonnageEntity where noAct = :noAct");
            query.setParameter("noAct", noAct);
            query.executeUpdate();
            session.delete(acteurEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Error while trying to delete an Acteur with its Personnages.", e);
        } finally {
            session.close();
        }
    }
}
