package me.stonerivers.config.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by zhang on 2017/9/5.
 */
@Configuration
@Profile("dev")
public class Dev {
    @Bean
    public String message() {
        return "msg-dev";
    }

}
