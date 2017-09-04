package me.stonerivers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zhang on 2017/7/15.
 */
@Configuration
@ComponentScan(basePackages = "me.stonerivers",
        excludeFilters = {
        @ComponentScan.Filter(value = org.springframework.stereotype.Controller.class),
        @ComponentScan.Filter(value = org.springframework.web.bind.annotation.ControllerAdvice.class)
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationContextConfig {
    @Bean
    public String message() {
        return "lala";
    }

}
