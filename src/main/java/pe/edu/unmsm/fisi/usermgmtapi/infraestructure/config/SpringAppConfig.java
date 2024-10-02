package pe.edu.unmsm.fisi.usermgmtapi.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.unmsm.fisi.usermgmtapi.application.ports.output.UserRepositoryPort;
import pe.edu.unmsm.fisi.usermgmtapi.infraestructure.adapters.output.users.repository.UserRepositoryAdapter;

@Configuration
public class SpringAppConfig {
    @Bean
    public UserRepositoryPort userRepositoryPort(UserRepositoryAdapter adapter) {
        return adapter;
    }
}
