package endpoint;


import model.FilmEntity;
import model.PersonnageEntity;
import service.FilmService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/films")
public class FilmEndpoint {

    private FilmService filmService;

    public FilmEndpoint() {
        filmService = new FilmService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmEntity> getFilmEntityList() {
        return filmService.getfilmEntityList();
    }

    @GET
    @Path("/{no-film}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmEntity getFilmEntityById(@PathParam("no-film") int noFilm) {
        return filmService.getFilmEntityById(noFilm);
    }

    @GET
    @Path("/{no-film}/personnages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonnageEntity> getPersonnageEntityListByFim(@PathParam("no-film") int noFilm) {
        return filmService.getPersonnageEntityListByFilm(noFilm);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putFilmEnity(FilmEntity filmEntity) {
        filmService.putFilm(filmEntity);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public FilmEntity postFilmEntity(FilmEntity filmEntity) {
        return filmService.postFilm(filmEntity);
    }

    @DELETE
    @Path("/{no-film}")
    public void deleteFilmEntity(@PathParam("no-film") int noFilm) {
        filmService.deleteFilm(noFilm);
    }
}