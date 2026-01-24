package med.voll.api.CRUD.core.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfiguration {

    @Bean
    public GroupedOpenApi pacientesApi() {
        return GroupedOpenApi.builder()
                .group("Pacientes")
                .pathsToMatch("/pacientes/**")
                .build();
    }

    @Bean
    public GroupedOpenApi medicosApi() {
        return GroupedOpenApi.builder()
                .group("Médicos")
                .pathsToMatch("/medico/**")
                .build();
    }
}
