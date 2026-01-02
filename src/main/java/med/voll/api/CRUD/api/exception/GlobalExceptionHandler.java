package med.voll.api.CRUD.api.exception;

import lombok.RequiredArgsConstructor;
import med.voll.api.CRUD.core.response.ApiResult;
import med.voll.api.CRUD.core.response.ApiResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
