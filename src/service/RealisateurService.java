package service;

import dao.RealisateurDAO;
import model.FilmEntity;
import model.RealisateurEntity;

import java.util.List;

public class RealisateurService {

    private RealisateurDAO realisateurDAO;

    public RealisateurService() {
        realisateurDAO = new RealisateurDAO();
    }

    public List<RealisateurEntity> getRealisateurEntityList() {
        return realisateurDAO.getEntityList();
    }

    public RealisateurEntity getRealisateurEntityById(int noRea) {
        return realisateurDAO.getEntityById(noRea);
    }

    public List<FilmEntity> getFilmEntityListByRealisteur(int noRea) {
        return realisateurDAO.getFilmEntityListByRealisateur(noRea);
    }
}
