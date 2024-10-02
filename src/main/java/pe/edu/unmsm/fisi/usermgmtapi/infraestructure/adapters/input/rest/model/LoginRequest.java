package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
