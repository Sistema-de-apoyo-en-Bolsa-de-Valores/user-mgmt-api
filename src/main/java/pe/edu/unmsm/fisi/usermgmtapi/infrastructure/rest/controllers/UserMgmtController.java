package pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.input.UserMgmtUseCase;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.mapper.UserDtoMapper;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.model.request.UserSaveRequest;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.model.response.UserSearchResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/user")
public class UserMgmtController {
    private final UserMgmtUseCase userMgmtUseCase;
    private final UserDtoMapper userDtoMapper;

    @PostMapping
    public ResponseEntity<UserSearchResponse> saveUser(@RequestBody @Valid UserSaveRequest request) {
        User user = this.userMgmtUseCase.saveUser(this.userDtoMapper.userSaveRequestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userDtoMapper.userToUserSearchResponse(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSearchResponse> getUserById(@PathVariable Long id) {
        User user = this.userMgmtUseCase.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.userDtoMapper.userToUserSearchResponse(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.BodyBuilder deleteUserById(@PathVariable Long id) {
        this.userMgmtUseCase.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<UserSearchResponse>> getUsers(@RequestParam(required = false) String username) {
        List<User> users = username == null || username.isBlank() ? this.userMgmtUseCase.getAllUsers() : List.of(this.userMgmtUseCase.getUserByUsername(username));
        return ResponseEntity.status(HttpStatus.OK).body(this.userDtoMapper.usersToUserSearchResponseList(users));
    }
}
