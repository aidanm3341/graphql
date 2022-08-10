package com.graphql.aidan.show;

public class Show {
    private final String title;
    private final Integer releaseYear;
    private final Rating rating;

    public Show(String title, Integer releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = new Rating();
    }

    public String getTitle() {
        return title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Rating getRating() {
        return rating;
    }
}
