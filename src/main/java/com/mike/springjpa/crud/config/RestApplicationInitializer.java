package com.mike.springjpa.crud.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 *  - AbstractAnnotationConfigDispatcherServletInitializer. This is a replacement for the traditional web.xml,
 *    providing information on configuration and deployment of the web components that make up a web application.
 *  - It is gotten extended of AbstractAnnotationConfigDispatcherServletInitializer and override his methods.
 *
 * @author: Miguel Angel Gonzalez Hernandez
 * @version: 22/09/2018/A
 * @see <a href = "https://github.com/miguel776/" /> https://github.com/miguel776/ – Spring proyect backend; MVC, JPA, Maven, Toncat embedded </a>
 */
public class RestApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * - This methods provide the config classes to the core module
     *
     * @return Class<?>[]
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { InfrastructureConfig.class };
    }

    /**
     * - This methods provide the config classes to the core module
     *
     * @return Class<?>[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { RestApplicationConfig.class };
    }

    /**
     * - This methods provide a mapping of the servlet dispatcher of the application.
     *
     * @return Class<?>[]
     */
    @Override
    public String[] getServletMappings() {
        return new String[] { "/" };
    }
}
