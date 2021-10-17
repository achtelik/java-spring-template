package it.achtelik.javaspringtemplate;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class JavaSpringTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringTemplateApplication.class, args);
    }

}
