package com.graphql.aidan.dao;

import com.graphql.aidan.show.Show;

import java.util.List;

public interface IShowDao {
    List<Show> getShows();
    Show getShow(String title);
}
