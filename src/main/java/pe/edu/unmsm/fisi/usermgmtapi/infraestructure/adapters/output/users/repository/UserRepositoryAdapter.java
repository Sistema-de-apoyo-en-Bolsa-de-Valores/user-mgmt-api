package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.output.users.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.output.UserRepositoryPort;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.output.users.model.UserEntity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userJpaRepository;


    @Override
    public void saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setLastname(user.getLastname());
        userEntity.setEmail(user.getEmail());
        userEntity.setBlockedUntil(LocalDate.of(1900,1,1));
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setAccountNonExpired(Boolean.TRUE);
        userEntity.setAccountNonLocked(Boolean.TRUE);
        userJpaRepository.save(userEntity);
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public boolean deleteUserById(String userId) {
        return false;
    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public Optional<User> userByUsername(String username) {
        if (userJpaRepository.existsByUsername(username)) {
            UserEntity userEntity = userJpaRepository.findByUsername(username).orElseThrow();
            return Optional.of(userEntity.toUser());
        }
        return Optional.empty();
    }
}
