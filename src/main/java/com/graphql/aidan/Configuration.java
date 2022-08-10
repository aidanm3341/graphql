package com.graphql.aidan;

import com.graphql.aidan.dao.IShowDao;
import com.graphql.aidan.dao.ShowDao;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public IShowDao getShowDao() {
        return new ShowDao();
    }
}
