package com.graphql.aidan.show;

import com.graphql.aidan.dao.IShowDao;
import com.graphql.aidan.dao.ShowDao;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.BeanProperty;

@DgsComponent
public class RatingMutation {

    @Autowired
    private IShowDao showDao;

    public RatingMutation() {
    }

    @DgsData(parentType = "Mutation", field = "addRating")
    public Rating addRating(@InputArgument("input") RatingInput ratingInput) {
        System.out.println("Rated " + ratingInput.getTitle() + " with " + ratingInput.getStars() + " stars") ;
        Rating rating = showDao.getShow(ratingInput.getTitle()).getRating();
        rating.rate(ratingInput.getStars());
        System.out.println("New average is " + rating.getAvgStars());
        return rating;
    }
}
