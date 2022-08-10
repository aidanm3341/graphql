package com.graphql.aidan;

import com.graphql.aidan.dao.IShowDao;
import com.graphql.aidan.show.Show;
import com.graphql.aidan.show.ShowDatafetcher;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@EnableAutoConfiguration
@SpringBootTest(classes = {DgsQueryExecutor.class, ShowDatafetcher.class})
public class ShowDatafetcherTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @MockBean
    IShowDao showDao;

    @BeforeEach
    void setup() {
        when(showDao.getShows()).thenReturn(List.of(
                new Show("Bobs Burgers", 2010),
                new Show("Game Of Thrones", 2007),
                new Show("Friends", 1990)
        ));
    }

    @Test
    void shows() {
        List<String> titles = dgsQueryExecutor.executeAndExtractJsonPath(
                "{ shows { title releaseYear rating { avgStars } } }",
                "data.shows[*].title"
        );

        assertThat(titles).contains("Bobs Burgers");
    }
}
