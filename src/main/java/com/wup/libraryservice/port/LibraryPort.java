package com.wup.libraryservice.port;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LibraryPort {

    private WebClient webClient = WebClient.create("localhost:8081");

    public void portTest(StatInfoForPort info) {
        webClient.post()
                .uri("/library-stats")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(info), StatInfoForPort.class).retrieve();
    }

}
