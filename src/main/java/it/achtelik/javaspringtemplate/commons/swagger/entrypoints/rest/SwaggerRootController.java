package it.achtelik.javaspringtemplate.commons.swagger.entrypoints.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerRootController {

    @GetMapping("/")
    public ResponseEntity<Object> getRoot() {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, "/backend/swagger-ui.html").build();
    }
}
