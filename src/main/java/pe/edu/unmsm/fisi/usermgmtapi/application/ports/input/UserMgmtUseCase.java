package pe.edu.unmsm.fisi.usermgmtapi.application.ports.input;

import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;

import java.util.List;

public interface UserMgmtUseCase {
     User saveUser(User user);
     User getUserById(Long id);
     void deleteUserById(Long id);
     List<User> getAllUsers();
     User getUserByUsername(String username);
}
