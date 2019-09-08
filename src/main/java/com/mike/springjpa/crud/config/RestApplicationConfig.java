package com.mike.springjpa.crud.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * - This class is use to configure the MVC module of spring, it is an implementation of WebMvcConfigurer with empty
 *   methods allowing subclasses to override only the methods they're interested in.
 * - WebMvcConfigurer Defines callback methods to customize the Java-based configuration for Spring MVC enabled via @EnableWebMvc, this annotated configuration
 *   classes may implement this interface to be called back and given a chance to customize the default configuration.
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.mike.springjpa.crud.controller")
public class RestApplicationConfig extends WebMvcConfigurerAdapter{

    /**
     * - Implementation of HttpMessageConverter that can read and write JSON using Jackson 2.x's ObjectMapper.
     *   This converter can be used to bind to typed beans, or untyped HashMap instances.
     *   By default, this converter supports application/json and application/*+json with UTF-8 character set
     *
     * @return MappingJackson2HttpMessageConverter
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
        return converter;
    }

    /**
     * - This ViewResolver allows us to set properties such as prefix or suffix to the view name to generate the final view page URL
     *
     * @return ViewResolver
     */
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}