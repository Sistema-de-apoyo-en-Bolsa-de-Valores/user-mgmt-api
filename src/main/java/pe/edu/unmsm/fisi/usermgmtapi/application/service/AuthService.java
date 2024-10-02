package pe.edu.unmsm.fisi.usermgmtapi.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.input.AuthUseCase;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.output.UserRepositoryPort;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.LoginRequest;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.LoginResponse;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.util.JwtUtil;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthUseCase {
    private final JwtUtil jwtUtil;
    private final UserRepositoryPort userRepositoryPort;
    private final AuthenticationManager authenticationManager;
    @Override
    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepositoryPort.userByUsername(request.getUsername()).orElse(null);
        if(user != null) {
            String jwt = jwtUtil.generateToken(user);
            return LoginResponse.builder().message(user.getUsername() + " OK").token(jwt).code(200).build();
        }
        return LoginResponse.builder().message("Invalid username or password").code(401).build();
    }
}
