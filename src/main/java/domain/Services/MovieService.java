package domain.Services;

import domain.Actor;
import domain.Comment;
import domain.Movie;

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

    public void addComment(Movie movie, Comment comment) {
        List<Comment> currentComments = new ArrayList<Comment>();
        for(Movie m : db) {
            if(m.getId()==movie.getId()) {
                currentComments = movie.getComments();
                currentComments.add(comment);
                m.setComments(currentComments);
            }
        }
    }

    public void removeComment(Movie  movie, int id) {
        List<Comment> currentComments = new ArrayList<Comment>();
        final Comment[] commentToDelete = {new Comment()};
        for(Movie m : db) {
            if(m.getId()==movie.getId()) {
                currentComments = movie.getComments();
                List<Comment> finalCurrentComments = currentComments;
                currentComments.forEach(comment -> {
                    if(comment.getId()==id) {
                        commentToDelete[0] = comment;
                    }
                });
                currentComments.remove(commentToDelete[0]);
                m.setComments(currentComments);
            }
        }
    }

}
