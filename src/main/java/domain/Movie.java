package domain;

import java.util.List;

public class Movie {

    private int id;
    private String name;
    private String description;
    private Genre type;
    private String director;
    private int year;
    private List<Comment> comments;
    private List<Actor> actors;
    private List<Rate> rates;

    public enum Genre {
        Action,
        Animated,
        Crime,
        Comedy,
        ComedyDrama,
        Drama,
        Horror,
        Fantasy,
        SciFI,
        Thriller
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getType() {
        return type;
    }

    public void setType(Genre type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
