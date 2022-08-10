package com.graphql.aidan.client;

import org.springframework.web.reactive.function.client.WebClient;

public class ClientApp {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8080/graphql");
//        WebClientGraphQLClient client;
    }
}
