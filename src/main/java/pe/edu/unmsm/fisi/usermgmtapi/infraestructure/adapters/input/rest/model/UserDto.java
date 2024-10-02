package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model;

import lombok.Data;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    public User fromDto(){
        User user = new User();
        user.setId(this.id);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setName(this.name);
        user.setLastname(this.lastname);
        return user;
    }
}
