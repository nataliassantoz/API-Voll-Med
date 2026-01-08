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
        summary = "Alterar status de em médico",
        description = "Ativa ou desativa a flag do perfil de um médico"
)
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Status alterado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Parâmetro inválido"),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado")
})
public @interface ResponseStatusChangeOk {
}
