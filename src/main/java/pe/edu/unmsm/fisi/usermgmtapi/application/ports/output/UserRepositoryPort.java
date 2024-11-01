package pe.edu.unmsm.fisi.usermgmtapi.application.ports.output;

import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    void deleteUserById(Long id);
    List<User> getAllUsers();
    Optional<User> getUserByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsById(Long id);
}
