package pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.model.response;

import lombok.Builder;

@Builder
public record UserSearchResponse(Long id, String username, String password, String email, String name, String lastname) {}
