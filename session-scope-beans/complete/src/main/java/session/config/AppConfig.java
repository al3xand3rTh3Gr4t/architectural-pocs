package session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import session.dto.Card;
import session.dto.User;
import session.dto.UserContext;

@Configuration
public class AppConfig {

    @Bean
//    @Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope(value=WebApplicationContext.SCOPE_SESSION)
    public User user() {
        return new User();
    }

    @Bean
    public UserContext userContext() {
        return new UserContext();
    }
    
    @Bean
    public Card card() {
        return new Card();
    }

}