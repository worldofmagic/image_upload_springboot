package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.murphy.controller.PackageInfo;

/**
 * Java based Web context configuration class.
 * <p>
 * Including argument resolution, message converter, view resolution etc.,
 */
@ComponentScan(basePackageClasses = PackageInfo.class)
@Configuration
@EnableWebMvc
public class SpringMVCApplicationContext extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false).favorParameter(false);
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(gsonHttpMessageConverter());
//        converters.add(byteArrayHttpMessageConverter());
    }

    private HttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        messageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return messageConverter;
    }

//    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public HandlerAdapter handlerAdapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        return adapter;
    }

    @Bean
    public AbstractHandlerMapping defaultAnnotationHandlerMapping() {
        RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
        mapping.setUseSuffixPatternMatch(false);
        //Seems those parameters not important anymore after I use URI as parameter instead
//        mapping.setUrlDecode(false);
//        mapping.setAlwaysUseFullPath(true);
        return mapping;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowedHeaders("*");
    }
  
}
