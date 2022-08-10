package com.graphql.aidan;

import com.graphql.aidan.show.ShowDatafetcher;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(classes = {DgsAutoConfiguration.class, ShowDatafetcher.class})
public class ShowDatafetcherTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @Test
    void shows() {
        List<String> titles = dgsQueryExecutor.executeAndExtractJsonPath(
                "{ shows { title releaseYear } }",
                "data.shows[*].title"
        );

        assertThat(titles).contains("Breaking Bad");
    }
}
