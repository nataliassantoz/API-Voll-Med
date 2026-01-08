package med.voll.api.CRUD.api.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String mensagem){
        super(mensagem);
    }
}
