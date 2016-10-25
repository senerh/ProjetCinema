package service;

import dao.FilmDAO;
import model.FilmEntity;

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

}
