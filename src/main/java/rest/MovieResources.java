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

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Path("/{id}/comments")
    public Response addComment(@PathParam("id") int id, Comment comment) {
        db.addComment(id, comment);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Movie result = db.get(id);
        if(result==null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @GET
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComments(@PathParam("id") int id) {
        List<Comment> result = db.showComments(id);
        if(result==null) {
            return Response.status(404).build();
        }

        return Response.ok(result).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes (MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Movie m) {
        Movie result = db.get(id);
        if(result==null)
            return Response.status(404).build();
        m.setId(id);
        db.update(m);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Movie result = db.get(id);
        if(result==null)
            return  Response.status(404).build();
        db.delete(result);
        return Response.ok().build();
    }

}
