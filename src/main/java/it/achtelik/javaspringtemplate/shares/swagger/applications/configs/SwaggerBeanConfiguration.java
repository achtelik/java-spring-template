package it.achtelik.javaspringtemplate.shares.swagger.applications.configs;

import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import it.achtelik.javaspringtemplate.shares.exceptionhandling.entrypoints.rest.ApplicationErrorWebExceptionHandlerResponseDto;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerBeanConfiguration {

    @Bean
    public OpenApiCustomiser applicationOpenApiCustomiser() {
        return new OpenApiCustomiser() {
            @Override
            public void customise(OpenAPI openApi) {
                openApi.getInfo()
                        .title("Java Spring Template - OpenApi")
                        .description("This is a example project which shows different use case implementations.")
                        .contact(new Contact().email("like@you"))
                        .version("0.0.1")
                        .license(new License().name("Apache License 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.txt"))
                        .termsOfService("https://no-terms.com");

                final List<ApiResponseContainer> globalApiResponseContainer = Arrays.asList(
                        createApiResponse(HttpStatus.BAD_REQUEST, "Incomplete or wrong client data.",
                                ApplicationErrorWebExceptionHandlerResponseDto.class),
                        createApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error.",
                                ApplicationErrorWebExceptionHandlerResponseDto.class)
                );
                globalApiResponseContainer.forEach(apiResponseContainer -> {
                    openApi.schema(apiResponseContainer.resolvedSchema.schema.getName(), apiResponseContainer.resolvedSchema.schema);
                    openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation ->
                            operation.getResponses().addApiResponse(String.valueOf(apiResponseContainer.httpStatus.value()), apiResponseContainer.apiResponse())));
                });
            }
        };
    }

    private ApiResponseContainer createApiResponse(HttpStatus httpStatus, String description, Class<?> apiResponseClass) {
        ResolvedSchema classSchema = ModelConverters.getInstance()
                .readAllAsResolvedSchema(new AnnotatedType(apiResponseClass));
        ApiResponse apiResponse = new ApiResponse().description(description)
                .content(new Content()
                        .addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
                                new MediaType().schema(new Schema<>().$ref(classSchema.schema.getName()))));
        return new ApiResponseContainer(httpStatus, classSchema, apiResponse);
    }

    private record ApiResponseContainer(HttpStatus httpStatus, ResolvedSchema resolvedSchema, ApiResponse apiResponse) {
    }
}
