package dao;

import model.ActeurEntity;
import model.PersonnageEntity;

import java.util.List;

public class ActeurDAO extends AbstractDAO {

    public List<ActeurEntity> getActeurEntityList() {
        session.beginTransaction();
        List<ActeurEntity> acteurEntityList = session.createQuery("from ActeurEntity").list();
        session.getTransaction().commit();
        return acteurEntityList;
    }

    public ActeurEntity getActeurEntity(int noAct) {
        session.beginTransaction();
        ActeurEntity acteurEntity = session.get(ActeurEntity.class, noAct);
        session.getTransaction().commit();
        return acteurEntity;
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
}
