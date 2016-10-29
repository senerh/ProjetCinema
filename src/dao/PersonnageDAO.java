package dao;

import model.PersonnageEntity;
import org.hibernate.query.Query;

import java.util.List;

public class PersonnageDAO extends AbstractDAO<PersonnageEntity> {

    public PersonnageDAO() {
        super(PersonnageEntity.class);
    }

}
