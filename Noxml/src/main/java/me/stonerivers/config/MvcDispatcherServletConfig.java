package me.stonerivers.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang on 2017/7/15.
 */
@Configuration
@ComponentScan(basePackages = "me.stonerivers",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(value = org.springframework.stereotype.Controller.class),
                @ComponentScan.Filter(value = org.springframework.web.bind.annotation.ControllerAdvice.class)
        }
)
//@ImportResource(value = "classpath:simple-metrics-launcher.xml")
@EnableWebMvc
public class MvcDispatcherServletConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
        configurer.ignoreAcceptHeader(true);
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
        configurer.useJaf(true);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverter());
        converters.add(stringHttpMessageConverter());
    }


    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes = Arrays.asList(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig());
        return fastJsonHttpMessageConverter;
    }

    @Bean
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.SkipTransientField,
                SerializerFeature.QuoteFieldNames);
        return fastJsonConfig;
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        stringHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML));
        stringHttpMessageConverter.setWriteAcceptCharset(false);
        return stringHttpMessageConverter;
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
