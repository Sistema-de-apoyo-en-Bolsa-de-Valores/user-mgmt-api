package pe.edu.unmsm.fisi.usermgmtapi.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.input.UserMgmtUseCase;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.output.UserRepositoryPort;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserMgmtService implements UserMgmtUseCase{
    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;




    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepositoryPort.saveUser(user);
    }
}
