package com.graphql.aidan.show;

import com.graphql.aidan.dao.IShowDao;
import com.graphql.aidan.dao.ShowDao;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowDatafetcher {

    @Autowired
    private IShowDao showDao;

    public ShowDatafetcher() {
    }

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter == null) {
            return showDao.getShows();
        }

        return showDao.getShows().stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}
