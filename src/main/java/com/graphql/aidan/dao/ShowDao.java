package com.graphql.aidan.dao;

import com.graphql.aidan.show.Show;

import java.util.ArrayList;
import java.util.List;

public class ShowDao implements IShowDao {

    private final List<Show> shows;

    public ShowDao() {
        shows = new ArrayList<>(List.of(
                new Show("Breaking Bad", 2010),
                new Show("Game Of Thrones", 2007),
                new Show("Friends", 1990)
        ));
    }

    public Show getShow(String title) {
        if (shows.stream().noneMatch(show -> show.getTitle().equals(title)))
            throw new IllegalArgumentException("Show does not exist");
        return shows.stream().filter(show -> show.getTitle().equals(title)).toList().get(0);
    }

    public List<Show> getShows() {
        return shows;
    }
}
