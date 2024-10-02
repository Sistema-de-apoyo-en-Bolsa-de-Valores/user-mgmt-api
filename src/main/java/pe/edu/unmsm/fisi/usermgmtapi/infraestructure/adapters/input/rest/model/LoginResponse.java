package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class LoginResponse {
    private String token;
    private LocalDate timestamp;
    private String message;
    private Integer code;
}
