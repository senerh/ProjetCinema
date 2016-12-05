package dao;

import model.FilmEntity;
import model.PersonnageEntity;
import org.hibernate.query.Query;

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

    public void deleteFilmEntity(int noFilm) {
        session.beginTransaction();
        try {
            FilmEntity filmEntity = session.get(FilmEntity.class, noFilm);
            Query query = session.createQuery("delete PersonnageEntity where noFilm = :noFilm");
            query.setParameter("noFilm", noFilm);
            query.executeUpdate();
            session.delete(filmEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Error while trying to delete a Film with its Personnages.", e);
        } finally {
            session.close();
        }
    }
}


