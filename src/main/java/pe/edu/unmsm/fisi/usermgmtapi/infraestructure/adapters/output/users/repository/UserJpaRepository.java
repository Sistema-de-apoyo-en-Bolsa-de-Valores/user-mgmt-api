package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.output.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.output.users.model.UserEntity;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}
