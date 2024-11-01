package pe.edu.unmsm.fisi.usermgmtapi.infrastructure.repository.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.output.UserRepositoryPort;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.repository.mapper.UserEntityMapper;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.repository.model.UserEntity;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = this.userEntityMapper.userToUserEntity(user);
        UserEntity savedUserEntity = this.userJpaRepository.save(userEntity);
        return this.userEntityMapper.userEntityToUser(savedUserEntity);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<UserEntity> userEntity = this.userJpaRepository.findById(id);
        return userEntity.map(this.userEntityMapper::userEntityToUser);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userJpaRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userEntityMapper.userEntitiesToUsers(this.userJpaRepository.findAll());
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<UserEntity> userEntity = this.userJpaRepository.findByUsernameIgnoreCase(username);
        return userEntity.map(this.userEntityMapper::userEntityToUser);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.userJpaRepository.existsByUsernameIgnoreCase(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.userJpaRepository.existsByEmailIgnoreCase(email);
    }

    @Override
    public boolean existsById(Long id) {
        return this.userJpaRepository.existsById(id);
    }
}
