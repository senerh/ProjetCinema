package dao;

import model.ActeurEntity;

import java.util.List;

public class ActeurDAO extends AbstractDAO {

    public ActeurEntity getActeurEntity(int noAct) {
        ActeurEntity acteurEntity = session.get(ActeurEntity.class, noAct);
        return acteurEntity;
    }

    public List<ActeurEntity> getActeurEntityList() {
        session.beginTransaction();
        List<ActeurEntity> acteurEntityList = session.createQuery("from ActeurEntity").list();
        session.getTransaction().commit();
        return acteurEntityList;
    }
}
