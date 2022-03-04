package com.sumit.catalogue.model;

import java.util.List;

public class UserRatings {

    private List<Ratings> ratings;

    public UserRatings() {
    }

    public UserRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }
}
