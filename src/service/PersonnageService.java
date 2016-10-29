package service;

import dao.PersonnageDAO;
import model.PersonnageEntity;
import model.PersonnageEntityPK;

import java.util.List;

public class PersonnageService {

    private PersonnageDAO personnageDAO;

    public PersonnageService() {
        personnageDAO = new PersonnageDAO();
    }

    public List<PersonnageEntity> getPersonnageEntityList() {
        return personnageDAO.getEntityList();
    }

    public PersonnageEntity getPersonnageEntityById(int noFilm, int noAct) {
        PersonnageEntityPK pk = new PersonnageEntityPK();
        pk.setNoFilm(noFilm);
        pk.setNoAct(noAct);
        return personnageDAO.getEntityById(pk);
    }

    public void putPersonnage(PersonnageEntity personnageEntity) {
        personnageDAO.updateEntity(personnageEntity);
    }

    public void postPersonnage(PersonnageEntity personnageEntity) {
        personnageDAO.saveEntity(personnageEntity);
    }

    public void deletePersonnage(int noFilm, int noAct) {
        PersonnageEntityPK pk = new PersonnageEntityPK();
        pk.setNoFilm(noFilm);
        pk.setNoAct(noAct);
        personnageDAO.deleteEntity(pk);
    }
}
