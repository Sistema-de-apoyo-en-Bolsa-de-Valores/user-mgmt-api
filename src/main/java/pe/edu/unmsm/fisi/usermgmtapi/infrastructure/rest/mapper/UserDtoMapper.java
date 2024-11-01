package pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.unmsm.fisi.usermgmtapi.domain.model.User;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.model.request.UserSaveRequest;
import pe.edu.unmsm.fisi.usermgmtapi.infrastructure.rest.model.response.UserSearchResponse;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder)
public interface UserDtoMapper {

    @Mapping(target = "id", ignore = true)
    User userSaveRequestToUser(UserSaveRequest userSaveRequest);

    UserSearchResponse userToUserSearchResponse(User user);

    List<UserSearchResponse> usersToUserSearchResponseList(List<User> users);
}
