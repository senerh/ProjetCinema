package service;

import dao.ActeurDAO;
import model.ActeurEntity;
import model.PersonnageEntity;

import java.util.List;

public class ActeurService {

    private ActeurDAO acteurDAO;

    public ActeurService() {
        acteurDAO = new ActeurDAO();
    }

    public List<ActeurEntity> getActeurEntityList() {
        return acteurDAO.getEntityList();
    }

    public ActeurEntity getActeurEntity(int noAct) {
        return acteurDAO.getEntityById(noAct);
    }

    public List<PersonnageEntity> getPersonnageEntityListByActeur(int noAct) {
        return acteurDAO.getPersonnageEntityListByActeur(noAct);
    }

    public void putActeur(ActeurEntity acteurEntity) {
        acteurDAO.putEntity(acteurEntity);
    }
}
