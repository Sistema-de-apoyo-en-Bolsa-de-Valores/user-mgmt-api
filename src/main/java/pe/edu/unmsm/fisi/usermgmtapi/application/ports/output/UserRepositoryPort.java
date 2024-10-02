package pe.edu.unmsm.fisi.usermgmtapi.application.ports.output;

import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    void saveUser(User user);
    User getUserById(String userId);
    boolean deleteUserById(String userId);
    Optional<User> updateUser(User user);
    List<User> getAllUsers();
    Optional<User> userByUsername(String username);
}
