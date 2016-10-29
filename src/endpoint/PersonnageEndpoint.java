package endpoint;

import model.PersonnageEntity;
import service.PersonnageService;

import javax.ws.rs.*;
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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putPersonnageEntity(PersonnageEntity personnageEntity) {
        personnageService.putPersonnage(personnageEntity);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postPersonnageEntity(PersonnageEntity personnageEntity) {
        personnageService.postPersonnage(personnageEntity);
    }

    @DELETE
    @Path("/{no-film}/{no-act}")
    public void deletePersonnageEntity(
            @PathParam("no-film") int noFilm,
            @PathParam("no-act") int noAct) {
        personnageService.deletePersonnage(noFilm, noAct);
    }
}
