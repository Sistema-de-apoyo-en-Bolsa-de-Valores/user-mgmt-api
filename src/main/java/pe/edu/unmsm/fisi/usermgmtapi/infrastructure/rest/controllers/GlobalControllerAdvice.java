package pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.edu.unmsm.fisi.usermgmtapi.domain.exceptions.UserAlreadyRegisteredException;
import pe.edu.unmsm.fisi.usermgmtapi.domain.exceptions.UserNotFoundException;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.model.response.GenericResponse;

import java.time.LocalDate;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    protected GenericResponse handleNotFound(UserNotFoundException ex) {
        return GenericResponse.builder()
                .timestamp(LocalDate.now())
                .messages(List.of(ex.getMessage()))
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyRegisteredException.class)
    protected GenericResponse handleConflict(UserAlreadyRegisteredException ex) {
        return GenericResponse.builder()
                .timestamp(LocalDate.now())
                .messages(ex.getMessages())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected GenericResponse handleBadRequest(BindException ex) {
        return GenericResponse.builder()
                .timestamp(LocalDate.now())
                .messages(ex.getBindingResult().getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toList())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected GenericResponse handleGenericException(Exception ex) {
        return GenericResponse.builder()
                .timestamp(LocalDate.now())
                .messages(List.of(ex.getMessage()))
                .build();
    }
}
