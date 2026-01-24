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
        summary = "Listar recursos",
        description = "Lista recursos com paginação e filtros opcionais"
)
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
})
public @interface ResponseListOk {
}
