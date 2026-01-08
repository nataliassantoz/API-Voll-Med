package med.voll.api.CRUD.api.swagger.responses;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Buscar médico por identificador",
        description = "Busca um  médico a partir de um identificador único"
)
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Recurso encontrado"),
        @ApiResponse(responseCode = "400", description = "Identificador inválido"),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado")
})
public @interface ResponseGetOk {
}
