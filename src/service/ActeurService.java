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
        return acteurDAO.getActeurEntityList();
    }

    public ActeurEntity getActeurEntity(int noAct) {
        return acteurDAO.getActeurEntity(noAct);
    }

    public List<PersonnageEntity> getPersonnageEntityListByActeur(int noAct) {
        return acteurDAO.getPersonnageEntityListByActeur(noAct);
    }

}
