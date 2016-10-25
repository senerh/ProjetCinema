package endpoint;


import model.FilmEntity;
import service.FilmService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}