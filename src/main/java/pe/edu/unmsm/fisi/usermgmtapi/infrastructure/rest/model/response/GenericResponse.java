package pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.model.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record GenericResponse(LocalDate timestamp,
                              List<String> messages) {}
