package endpoint;

import model.ActeurEntity;
import model.PersonnageEntity;
import service.ActeurService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/acteurs")
public class ActeurEndpoint {

    private ActeurService acteurService;

    public ActeurEndpoint() {
        acteurService = new ActeurService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActeurEntity> getActeurEntityList() {
        return acteurService.getActeurEntityList();
    }

    @GET
    @Path("/{no-act}")
    @Produces(MediaType.APPLICATION_JSON)
    public ActeurEntity getActeurEntity(@PathParam("no-act") int noAct) {
        return acteurService.getActeurEntity(noAct);
    }

    @GET
    @Path("/{no-act}/personnages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonnageEntity> getPersonnageEntityList(@PathParam("no-act") int noAct) {
        List<PersonnageEntity> personnageEntityList = acteurService.getPersonnageEntityListByActeur(noAct);
        return personnageEntityList;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putActeurEntity(ActeurEntity acteurEntity) {
        acteurService.putActeur(acteurEntity);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActeurEntity postActeurEntity(ActeurEntity acteurEntity) {
        return acteurService.postActeur(acteurEntity);
    }

    @DELETE
    @Path("{no-act}")
    public void deleteActeurEntity(@PathParam("no-act") int noAct) {
        acteurService.deleteActeur(noAct);
    }

}
