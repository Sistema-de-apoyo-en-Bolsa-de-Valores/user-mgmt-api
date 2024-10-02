package pe.edu.unmsm.fisi.usermgmtapi.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private LocalDate blockedUntil;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;


}
