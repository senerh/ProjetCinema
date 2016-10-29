package service;

import dao.CategorieDAO;
import model.CategorieEntity;

import java.util.List;

public class CategorieService {

    private CategorieDAO categorieDAO;

    public CategorieService() {
        categorieDAO = new CategorieDAO();
    }

    public List<CategorieEntity> getCategorieEntityList() {
        return categorieDAO.getEntityList();
    }

    public CategorieEntity getCategorieById(String codeCat) {
        return categorieDAO.getEntityById(codeCat);
    }

    public void putCategorie(CategorieEntity categorieEntity) {
        categorieDAO.updateEntity(categorieEntity);
    }

    public void postCategorie(CategorieEntity categorieEntity) {
        categorieDAO.persistEntity(categorieEntity);
    }

    public void deleteCategorie(String codeCat) {
        categorieDAO.deleteEntity(codeCat);
    }
}
