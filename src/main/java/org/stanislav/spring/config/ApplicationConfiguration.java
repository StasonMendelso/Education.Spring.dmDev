package org.stanislav.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.stanislav.spring.database.pool.ConnectionPool;
import org.stanislav.spring.database.repository.CrudRepository;
import org.stanislav.spring.database.repository.UserRepository;
import org.stanislav.web.config.WebConfiguration;

/**
 * @author Stanislav Hlova
 */
//@ImportResource(value = "classpath:application.xml")
@Import(value = {WebConfiguration.class})
@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {

        @Bean("connectionPool2")
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool connectionPool2(@Value("${database.username}") String username){
                return new ConnectionPool(username,10);
        }

        @Bean
        public ConnectionPool connectionPool3(){
                return new ConnectionPool("test-pool",25);
        }
        @Bean
        @Profile("production|web")
        // ! & |
        public UserRepository userRepository2(ConnectionPool connectionPool2){
                return new UserRepository(connectionPool2);
        }
        @Bean
        public UserRepository userRepository3(){
                ConnectionPool connectionPool1 = connectionPool3();
                ConnectionPool connectionPool2 = connectionPool3();
                return new UserRepository(connectionPool3());
        }

}
