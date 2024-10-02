package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class Response {
    private String message;
}
