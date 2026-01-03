package med.voll.api.CRUD.api.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.core.response.ApiResultUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ApiResultUtil<Object> api;

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ApiResult<Object>> handleServiceException(
            ServiceException ex) {

        return api.resultErro(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                ""
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResult<Object>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {

        String mensagemUsuario = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse("Dados inválidos");

        return api.resultErro(
                HttpStatus.BAD_REQUEST,
                "Erro de validação",
                mensagemUsuario
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResult<Object>> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex) {

        String mensagemUsuario = "Valor inválido para um dos campos do request";

        if (ex.getCause() instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException ife) {

            String campo = ife.getPath()
                    .stream()
                    .map(ref -> ref.getFieldName())
                    .findFirst()
                    .orElse("campo");

            String valor = ife.getValue().toString();

            mensagemUsuario = String.format(
                    "Valor inválido para o campo '%s': '%s'",
                    campo, valor
            );
        }

        return api.resultErro(
                HttpStatus.BAD_REQUEST,
                "Erro de desserialização",
                mensagemUsuario
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResult<Object>> handleConstraintViolation(
            ConstraintViolationException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getConstraintViolations().forEach(violation -> {
            String campo = violation.getPropertyPath().toString();
            String mensagem = violation.getMessage();
            erros.put(campo, mensagem);
        });

        return api.resultErro(
                HttpStatus.BAD_REQUEST,
                "Erro de validação",
                "Parâmetros inválidos",
                erros
        );
    }


}
