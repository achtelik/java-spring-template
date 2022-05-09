package it.achtelik.javaspringtemplate.shares.swagger.applications.configs;

import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import it.achtelik.javaspringtemplate.shares.exceptionhandling.entrypoints.rest.ApplicationErrorWebExceptionHandlerResponseDto;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;

public class SwaggerBeanConfiguration {

    @Bean
    public OpenApiCustomiser applicationOpenApiCustomiser() {
        return openApi -> openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
            operation.getResponses().addApiResponse("400",
                    createApiResponse("Incomplete or wrong client data.",
                            ApplicationErrorWebExceptionHandlerResponseDto.class));

            operation.getResponses().addApiResponse("500",
                    createApiResponse("Internal server error.",
                            ApplicationErrorWebExceptionHandlerResponseDto.class));
        }));
    }

    private ApiResponse createApiResponse(String description, Class<?> apiResponseClass) {
        ResolvedSchema classSchema = ModelConverters.getInstance()
                .readAllAsResolvedSchema(new AnnotatedType(apiResponseClass));
        return new ApiResponse().description(description)
                .content(new Content()
                        .addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
                                new MediaType().schema(classSchema.schema)));
    }
}
