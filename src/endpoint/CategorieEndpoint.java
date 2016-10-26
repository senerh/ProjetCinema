package endpoint;

import model.CategorieEntity;
import service.CategorieService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategorieEndpoint {

    private CategorieService categorieService;

    public CategorieEndpoint() {
        categorieService = new CategorieService();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CategorieEntity> getCategorieEntityList() {
        return categorieService.getCategorieEntityList();
    }

    @GET
    @Path("/{code-cat}")
    @Produces(MediaType.APPLICATION_XML)
    public CategorieEntity getCategorieEntity(@PathParam("code-cat") String codeCat) {
        return categorieService.getCategorieById(codeCat);
    }

}
