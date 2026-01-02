package med.voll.api.CRUD.core.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ApiResultUtil <T> {

    private final String MSG_USUARIO = "Operação realizada com sucesso";

    public ResponseEntity<ApiResult<T>> resultSucesso(HttpStatus httpStatus) {
        return this.resultSucesso(httpStatus, MSG_USUARIO, null);
    }

    public ResponseEntity<ApiResult<T>> resultSucesso(HttpStatus httpStatus, T dados) {
        return this.resultSucesso(httpStatus, MSG_USUARIO, dados);
    }

    public ResponseEntity<ApiResult<T>> resultSucesso(HttpStatus httpStatus, String msgUsuario, T dados) {
        return ResponseEntity
                .status(httpStatus)
                .body(this.entidadeResult(httpStatus.value(), null, msgUsuario, dados));
    }

    public ResponseEntity<ApiResult<T>> resultErro(HttpStatus httpStatus, String msgTecnica, String msgUsuario) {
        return ResponseEntity
                .status(httpStatus)
                .body(this.entidadeResult(httpStatus.value(), msgTecnica, msgUsuario, null));
    }

    public ResponseEntity<ApiResult<T>> resultErro(HttpStatus httpStatus, String msgTecnica, String msgUsuario, T dados) {
        return ResponseEntity
                .status(httpStatus)
                .body(this.entidadeResult(httpStatus.value(), msgTecnica, msgUsuario, dados));
    }

    private ApiResult<T> entidadeResult(int cdRetorno, String msgTecnica, String msgUsuario, T dados) {

        ApiResult<T> result = new ApiResult<>();
        Object object = new HashMap<>();

        result.setCdRetorno(cdRetorno);
        result.setMsgUsuario(msgUsuario);
        result.setMsgTecnica(msgTecnica);
        result.setDados(dados);
        return result;
    }
}
