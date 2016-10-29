package endpoint;

import model.PersonnageEntity;
import service.PersonnageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/personnages")
public class PersonnageEndpoint {

    private PersonnageService personnageService;

    public PersonnageEndpoint() {
        personnageService = new PersonnageService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonnageEntity> getPersonnageEntityList() {
        return personnageService.getPersonnageEntityList();
    }

    @GET
    @Path("/{no-film}/{no-act}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonnageEntity getPersonnageEntity(
            @PathParam("no-film") int noFilm,
            @PathParam("no-act") int noAct) {
        return personnageService.getPersonnageEntityById(noFilm, noAct);
    }
}
