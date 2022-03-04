package com.sumit.catalogue.model;

import com.sumit.catalogue.constants.MovieRating;

public class Catalogue {
    private String movieName;
    private String movieDescription;
    private MovieRating rating;

    public Catalogue(String movieName, String movieDescription, MovieRating rating) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }
}
