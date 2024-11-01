package pe.edu.unmsm.fisi.usermgmtapi.infrastructure.repository.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.repository.model.UserEntity;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder)
public interface UserEntityMapper {
    User userEntityToUser(UserEntity userEntity);

    List<User> userEntitiesToUsers(List<UserEntity> userEntities);

    UserEntity userToUserEntity(User user);
}
