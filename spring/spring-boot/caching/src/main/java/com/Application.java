package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 
 * @author nikhil
 * the @EnableCaching flags provides a hint to the container to search for methods that
 * have cacheable
 *<p> Application without cache
 *<p> Add @Enablecaching so it finds methods that can be cached
 *<p> fail the application with Multiple Implementations
 *<p> resolve the failure with Qualifier
 */
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}