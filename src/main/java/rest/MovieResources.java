package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Movie;
import domain.Actor;
import domain.Comment;
import domain.Rate;
import domain.Services.MovieService;

import java.util.List;

@Path("/movies")
public class MovieResources {

    private MovieService db = new MovieService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll() {
        return db.getAll();
    }

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    public Response Add(Movie movie) {
        db.add(movie);
        return Response.ok(movie.getId()).build();
    }
}
