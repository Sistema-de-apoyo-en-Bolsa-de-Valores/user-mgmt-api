package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.input.UserMgmtUseCase;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.Response;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.input.rest.model.UserDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserMgmtController {

        private final UserMgmtUseCase userMgmtUseCase;


        @PostMapping("/create")
        public ResponseEntity<Response> createUser(@RequestBody UserDto user) {
            userMgmtUseCase.createUser(user.fromDto());
            return ResponseEntity.ok(Response.builder().message("Created").build());
        }
}
