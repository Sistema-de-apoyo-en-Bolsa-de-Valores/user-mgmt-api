package pe.edu.unmsm.fisi.usermgmtapi.domain.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class UserAlreadyRegisteredException extends RuntimeException{
    private final List<String> messages;
}
