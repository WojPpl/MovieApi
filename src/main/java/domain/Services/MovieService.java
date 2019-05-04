package domain.Services;

import domain.Actor;
import domain.Comment;
import domain.Movie;
import domain.Rate;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private static List<Movie> db = new ArrayList<Movie>();
    private static List<Actor> dba = new ArrayList<Actor>();

    private static int currentId = 1;

    public List<Movie> getAll() {
        return db;
    }

    public Movie get(int id){
        for(Movie m : db) {
            if(m.getId()==id)
                return m;
        }
        return null;
    }

    public void add(Movie m) {
        m.setId(++currentId);
        db.add(m);
    }

    public void update(Movie movie){
        for(Movie m : db) {
            if(m.getId()==movie.getId()){
                m.setName(movie.getName());
                m.setDescription(movie.getDescription());
                m.setType(movie.getType());
                m.setDirector(movie.getDirector());
                m.setYear(movie.getYear());
            }
        }
    }

    public void delete(Movie m){
        db.remove(m);
    }

    public void addComment(int id, Comment comment) {
        List<Comment> currentComments;
        for(Movie m : db) {
            if(m.getId()==id) {
                currentComments = m.getComments();
                currentComments.add(comment);
                m.setComments(currentComments);
            }
        }
    }

    public List<Comment> showComments(int id) {
        for(Movie m : db) {
            if(m.getId()==id)
                return m.getComments();
        }
        return null;
    }

    public void removeComment(int id, int idc) {
        List<Comment> currentComments;
        final Comment[] commentToDelete = {new Comment()};
        for(Movie m : db) {
            if(m.getId()==id) {
                currentComments = m.getComments();
                List<Comment> finalCurrentComments = currentComments;
                currentComments.forEach(comment -> {
                    if(comment.getId()==idc) {
                        commentToDelete[0] = comment;
                    }
                });
                currentComments.remove(commentToDelete[0]);
                m.setComments(finalCurrentComments);
            }
        }
    }

    public void addRate(int id, Rate rate) {
        List<Rate> currentRates;
        for (Movie m : db) {
            if(m.getId() == id) {
                currentRates = m.getRates();
                currentRates.add(rate);
                m.setRates(currentRates);
            }
        }
    }

    public void addActor(int id, Actor actor) {
        List<Actor> currentActors;
        for (Movie m : db) {
            if(m.getId() == id) {
                currentActors = m.getActors();
                currentActors.add(actor);
                m.setActors(currentActors);
            }
        }
    }

    public List<Actor> showActors(int id) {
        for(Movie m : db) {
            if(m.getId()==id)
                return m.getActors();
        }
        return null;
    }
}
