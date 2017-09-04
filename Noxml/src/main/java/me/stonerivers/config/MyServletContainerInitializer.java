package me.stonerivers.config;

import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by zhang on 2017/7/16.
 */
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        ctx.addListener("org.springframework.web.context.request.RequestContextListener");

        FilterRegistration.Dynamic encodingFilter
                = ctx.addFilter("encodingFilter", org.springframework.web.filter.CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

        ctx.addListener(new RequestContextListener());
    }


}
