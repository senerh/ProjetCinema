package service;

import dao.FilmDAO;
import model.CategorieEntity;
import model.FilmEntity;
import model.PersonnageEntity;
import model.RealisateurEntity;

import java.util.List;

public class FilmService {

    private FilmDAO filmDAO;

    public FilmService() {
        filmDAO = new FilmDAO();
    }

    public List<FilmEntity> getfilmEntityList() {
        return filmDAO.getEntityList();
    }

    public FilmEntity getFilmEntityById(int noFilm) {
        return filmDAO.getEntityById(noFilm);
    }

    public List<PersonnageEntity> getPersonnageEntityListByFilm(int noFilm) {
        return filmDAO.getPersonnageEntityListByFilm(noFilm);
    }

    public void putFilm(FilmEntity filmEntity) {
        filmDAO.updateEntity(filmEntity);
    }

    public FilmEntity postFilm(FilmEntity filmEntity) {
        return filmDAO.saveEntity(filmEntity);
    }


    public void deleteFilm(int noFilm) {
        filmDAO.deleteEntity(noFilm);
    }
}
