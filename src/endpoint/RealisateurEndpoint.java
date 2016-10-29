package endpoint;

import model.FilmEntity;
import model.RealisateurEntity;
import service.RealisateurService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("realisateurs")
public class RealisateurEndpoint {

    private RealisateurService realisateurService;

    public RealisateurEndpoint() {
        realisateurService = new RealisateurService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RealisateurEntity> getRealisateurEntityList() {
        return realisateurService.getRealisateurEntityList();
    }

    @GET
    @Path("/{no-rea}")
    @Produces(MediaType.APPLICATION_JSON)
    public RealisateurEntity getRealisateurEntity(@PathParam("no-rea") int noRea) {
        return realisateurService.getRealisateurEntityById(noRea);
    }

    @GET
    @Path("/{no-rea}/films")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmEntity> getFilmEntityList(@PathParam("no-rea") int noRea) {
        return realisateurService.getFilmEntityListByRealisteur(noRea);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putRealisateurEntity(RealisateurEntity realisateurEntity) {
        realisateurService.putRealisateur(realisateurEntity);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RealisateurEntity postRealisateurEntity(RealisateurEntity realisateurEntity) {
        return realisateurService.postRealisateur(realisateurEntity);
    }

    @DELETE
    @Path("/{no-rea}")
    public void deleteRealisateurEntity(@PathParam("no-rea") int noRea) {
        realisateurService.deleteRealisateur(noRea);
    }
}
