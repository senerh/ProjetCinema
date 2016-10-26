package dao;

import model.PersonnageEntity;
import org.hibernate.query.Query;

import java.util.List;

public class PersonnageDAO extends AbstractDAO<PersonnageEntity> {

    public PersonnageDAO() {
        super(PersonnageEntity.class);
    }

    public PersonnageEntity getPersonnageEntityById(int noFilm, int noAct) {
        session.beginTransaction();
        Query query = session.createQuery("from PersonnageEntity where noFilm = :noFilm and noAct = :noAct");
        query.setParameter("noFilm", noFilm);
        query.setParameter("noAct", noAct);
        PersonnageEntity personnageEntity = (PersonnageEntity) query.uniqueResult();
        session.getTransaction().commit();

        return personnageEntity;
    }
}
