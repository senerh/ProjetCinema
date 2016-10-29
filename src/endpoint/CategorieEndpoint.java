package endpoint;

import model.CategorieEntity;
import service.CategorieService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategorieEndpoint {

    private CategorieService categorieService;

    public CategorieEndpoint() {
        categorieService = new CategorieService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategorieEntity> getCategorieEntityList() {
        return categorieService.getCategorieEntityList();
    }

    @GET
    @Path("/{code-cat}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategorieEntity getCategorieEntity(@PathParam("code-cat") String codeCat) {
        return categorieService.getCategorieById(codeCat);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCategorieEntity(CategorieEntity categorieEntity) {
        categorieService.putCategorie(categorieEntity);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postCategorieEntity(CategorieEntity categorieEntity) {
        categorieService.postCategorie(categorieEntity);
    }

    @DELETE
    @Path("/{code-cat}")
    public void deleteCategorieEntity(@PathParam("code-cat") String codeCat) {
        categorieService.deleteCategorie(codeCat);
    }

}
