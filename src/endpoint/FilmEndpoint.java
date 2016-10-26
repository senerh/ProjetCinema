package endpoint;


import model.FilmEntity;
import model.PersonnageEntity;
import service.FilmService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/films")
public class FilmEndpoint {

    private FilmService filmService;

    public FilmEndpoint() {
        filmService = new FilmService();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<FilmEntity> getFilmEntityList() {
        return filmService.getfilmEntityList();
    }

    @GET
    @Path("/{no-film}")
    @Produces(MediaType.APPLICATION_XML)
    public FilmEntity getFilmEntityById(@PathParam("no-film") int noFilm) {
        return filmService.getFilmEntityById(noFilm);
    }

    @GET
    @Path("/{no-film}/personnages")
    @Produces(MediaType.APPLICATION_XML)
    public List<PersonnageEntity> getPersonnageEntityListByFim(@PathParam("no-film") int noFilm) {
        return filmService.getPersonnageEntityListByFilm(noFilm);
    }
}