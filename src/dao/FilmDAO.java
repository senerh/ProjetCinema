package dao;

import model.FilmEntity;
import model.PersonnageEntity;

import java.util.List;

public class FilmDAO extends AbstractDAO<FilmEntity> {

    public FilmDAO() {
        super(FilmEntity.class);
    }

    public List<PersonnageEntity> getPersonnageEntityListByFilm(int noFilm) {
        session.beginTransaction();
        FilmEntity filmEntity = session.get(FilmEntity.class, noFilm);
        List<PersonnageEntity> personnageEntityList = filmEntity.getPersonnagesByNoFilm();
        personnageEntityList.size();
        session.getTransaction().commit();

        return personnageEntityList;
    }
}


