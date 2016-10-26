package service;

import dao.PersonnageDAO;
import model.PersonnageEntity;

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
        return personnageDAO.getPersonnageEntityById(noFilm, noAct);
    }
}
