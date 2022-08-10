package com.graphql.aidan.show;

public class Rating {
    private float avgStars;
    private int numOfReviews;

    public Rating() {
    }

    public float getAvgStars() {
        return avgStars;
    }

    public void rate(float newRating) {
        this.avgStars = ((this.avgStars * numOfReviews) + newRating) / (numOfReviews+1);
        numOfReviews++;
    }
}
