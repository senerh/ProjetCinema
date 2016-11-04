package dao;

import model.FilmEntity;
import model.RealisateurEntity;

import java.util.List;

public class RealisateurDAO extends AbstractDAO<RealisateurEntity> {

    public RealisateurDAO() {
        super(RealisateurEntity.class);
    }

    public List<FilmEntity> getFilmEntityListByRealisateur(int noRea) {
        session.beginTransaction();
        RealisateurEntity realisateurEntity = session.get(RealisateurEntity.class, noRea);
        List<FilmEntity> filmEntityList = realisateurEntity.getFilmsByNoRea();
        filmEntityList.size();
        session.getTransaction().commit();

        return filmEntityList;
    }

}
