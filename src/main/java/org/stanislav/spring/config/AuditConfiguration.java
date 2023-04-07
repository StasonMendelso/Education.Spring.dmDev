package org.stanislav.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.stanislav.spring.ApplicationRunner;

import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@Configuration
@EnableJpaAuditing
@EnableEnversRepositories(basePackageClasses = ApplicationRunner.class) //перепоределяет свойства EnableJpaAuditing
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        // In real: SecurityContext.getCurrentUser().getEmail();
        return () -> Optional.of("stanislav");
    }

}
