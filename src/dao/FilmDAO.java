package dao;

import model.CategorieEntity;
import model.FilmEntity;
import model.RealisateurEntity;

import java.util.List;

public class FilmDAO extends AbstractDAO<FilmEntity> {

    public FilmDAO() {
        super(FilmEntity.class);
    }

}


