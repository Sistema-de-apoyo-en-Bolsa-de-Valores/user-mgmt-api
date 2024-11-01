package pe.edu.unmsm.fisi.usermgmtapi.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.input.UserMgmtUseCase;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.output.UserRepositoryPort;
import pe.edu.unmsm.fisi.usermgmtapi.domain.exceptions.UserAlreadyRegisteredException;
import pe.edu.unmsm.fisi.usermgmtapi.domain.exceptions.UserNotFoundException;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserMgmtService implements UserMgmtUseCase {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User saveUser(User user) {
        List<String> messagesAvailability = new ArrayList<>();
        if (this.userRepositoryPort.existsByUsername(user.getUsername())) {
            messagesAvailability.add("El nombre de usuario no está disponible.");
        }
        if (this.userRepositoryPort.existsByEmail(user.getEmail())) {
            messagesAvailability.add("El correo no está disponible.");
        }
        if (messagesAvailability.isEmpty()) {
            return userRepositoryPort.saveUser(user);
        }
        throw new UserAlreadyRegisteredException(messagesAvailability);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> foundUser = this.userRepositoryPort.getUserById(id);
        if (foundUser.isPresent()) {
            return foundUser.get();
        }
        throw new UserNotFoundException();
    }

    @Override
    public void deleteUserById(Long id) {
        if (!this.userRepositoryPort.existsById(id)) {
            throw new UserNotFoundException();
        }
        this.userRepositoryPort.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepositoryPort.getAllUsers();
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> foundUser = this.userRepositoryPort.getUserByUsername(username);
        if (foundUser.isPresent()) {
            return foundUser.get();
        }
        throw new UserNotFoundException();
    }
}
