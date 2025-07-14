package user_service.demo.exceptions;

public class CreateUpdateEntityException extends RuntimeException {
    public CreateUpdateEntityException(String message) {
        super(message);
    }
}
