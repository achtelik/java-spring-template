package it.achtelik.javaspringtemplate.shares.swagger.entrypoints.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class SwaggerRootController {

    private String basePath;

    public SwaggerRootController(@Value("${spring.webflux.base-path}") String basePath) {
        this.basePath = basePath;
    }

    @GetMapping()
    public Mono<Void> getRoot(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        response.getHeaders().setLocation(URI.create(basePath + "/swagger-ui.html"));
        return response.setComplete();
    }
}
