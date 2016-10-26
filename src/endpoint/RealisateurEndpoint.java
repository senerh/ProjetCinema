package endpoint;

import model.FilmEntity;
import model.RealisateurEntity;
import service.RealisateurService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("realisateurs")
public class RealisateurEndpoint {

    private RealisateurService realisateurService;

    public RealisateurEndpoint() {
        realisateurService = new RealisateurService();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<RealisateurEntity> getRealisateurEntityList() {
        return realisateurService.getRealisateurEntityList();
    }

    @GET
    @Path("/{no-rea}")
    @Produces(MediaType.APPLICATION_XML)
    public RealisateurEntity getRealisateurEntity(@PathParam("no-rea") int noRea) {
        return realisateurService.getRealisateurEntityById(noRea);
    }

    @GET
    @Path("/{no-rea}/films")
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmEntity> getFilmEntityList(@PathParam("no-rea") int noRea) {
        return realisateurService.getFilmEntityListByRealisteur(noRea);
    }
}
