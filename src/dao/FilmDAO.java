package dao;

import model.FilmEntity;
import java.util.List;

public class FilmDAO extends AbstractDAO {

    public List<FilmEntity> getFilmEntityList() {
        return (List<FilmEntity>) getEntityList(FilmEntity.class);
    }
}


