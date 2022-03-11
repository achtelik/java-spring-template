package it.achtelik.javaspringtemplate.test.basics;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
public class AbstractBaseContainerTest {

    @Autowired
    protected ApplicationContext context;
    @Autowired
    protected MongoTemplate mongoTemplate;

    protected WebTestClient webTestClient;

    static {
        final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));
        mongoDBContainer.start();
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl());
    }

    @BeforeEach
    public void beforeEach() {
        mongoTemplate.getDb().drop();
        webTestClient = WebTestClient
                .bindToApplicationContext(this.context)
                .apply(SecurityMockServerConfigurers.springSecurity())
                .configureClient()
                .build();
    }
}
