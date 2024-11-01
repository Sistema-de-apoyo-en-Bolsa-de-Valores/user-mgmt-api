package pe.edu.unmsm.fisi.usermgmtapi.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("El usuario no fue encontrado.");
    }
}
