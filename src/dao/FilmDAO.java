package dao;

import model.CategorieEntity;
import model.FilmEntity;
import model.RealisateurEntity;

import java.util.List;

public class FilmDAO extends AbstractDAO<FilmEntity> {

    public FilmDAO() {
        super(FilmEntity.class);
    }

    public RealisateurEntity getRealisateurByFilm(int noFilm) {
        session.beginTransaction();
        FilmEntity filmEntity = session.get(FilmEntity.class, noFilm);
        RealisateurEntity realisateurEntity = filmEntity.getRealisateurByNoRea();
        realisateurEntity.getNomRea();
        session.getTransaction().commit();

        return realisateurEntity;
    }

    public CategorieEntity getCategorieEntityByFilm(int noFilm) {
        session.beginTransaction();
        FilmEntity filmEntity = session.get(FilmEntity.class, noFilm);
        CategorieEntity categorieEntity = filmEntity.getCategorieByCodeCat();
        categorieEntity.getCodeCat();
        session.getTransaction().commit();

        return categorieEntity;
    }

}


