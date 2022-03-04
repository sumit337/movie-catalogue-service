package com.sumit.catalogue.model;

import com.sumit.catalogue.constants.MovieRating;

public class Ratings {
    private int movieId;

    private MovieRating movieRating;
    public Ratings(){

    }
    public Ratings(int movieId, MovieRating movieRating) {
        this.movieId = movieId;
        this.movieRating = movieRating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }
}
