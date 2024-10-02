package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.input.AuthUseCase;
import pe.edu.unmsm.fisi.usermgmtapi.application.service.AuthService;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.LoginRequest;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.LoginResponse;
@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthUseCase authService;
    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        if(response.getCode() == 200)
            return ResponseEntity.ok(response);
        return ResponseEntity.badRequest().body(response);
    }
}
