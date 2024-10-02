package pe.edu.unmsm.fisi.usermgmtapi.application.ports.input;

import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.LoginRequest;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.LoginResponse;

public interface AuthUseCase {
    LoginResponse login(LoginRequest request);
}
