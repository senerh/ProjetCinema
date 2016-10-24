package endpoint;

import model.ActeurEntity;
import model.PersonnageEntity;
import service.ActeurService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/acteurs")
public class ActeurEndpoint {

    private ActeurService acteurService;

    public ActeurEndpoint() {
        acteurService = new ActeurService();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<ActeurEntity> getActeurEntityList() {
        return acteurService.getActeurEntityList();
    }

    @GET
    @Path("/{no-act}")
    @Produces(MediaType.APPLICATION_XML)
    public ActeurEntity getActeurEntity(@PathParam("no-act") int noAct) {
        return acteurService.getActeurEntity(noAct);
    }

    @GET
    @Path("/{no-act}/personnages")
    @Produces(MediaType.APPLICATION_XML)
    public List<PersonnageEntity> getPersonnageEntityList(@PathParam("no-act") int noAct) {
        List<PersonnageEntity> personnageEntityList = acteurService.getPersonnageEntityListByActeur(noAct);
        return personnageEntityList;
    }
}
