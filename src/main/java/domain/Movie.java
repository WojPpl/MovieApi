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
    private Float avargeRate;

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

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public Float getAvargeRate() {
        return avargeRate;
    }

    public void setAvargeRate(List<Rate> rates) {
        final Float[] sum = {Float.valueOf(0)};
        final int[] counter = {0};

        rates.forEach(rate -> {
           sum[0] = sum[0] + rate.getRate();
           counter[0]++;
        });

        this.avargeRate = sum[0] / counter[0];
    }
}
