package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.output.users.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;

import java.time.LocalDate;

@Entity
@Table(name = "tb_users")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private LocalDate blockedUntil;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;

    public User toUser(){
        User user = new User();
        user.setId(this.id);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setName(this.name);
        user.setLastname(this.lastname);
        user.setBlockedUntil(this.blockedUntil);
        user.setAccountNonExpired(this.accountNonExpired);
        user.setAccountNonLocked(this.accountNonLocked);
        return user;
    }

    public UserEntity(Long id, String username, String password, String email, String name, String lastname, LocalDate blockedUntil, Boolean accountNonExpired, Boolean accountNonLocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.blockedUntil = blockedUntil;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
    }

    public static UserEntity fromDomainModel(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getLastname(), user.getBlockedUntil(), user.getAccountNonExpired(), user.getAccountNonLocked());

    }
}
