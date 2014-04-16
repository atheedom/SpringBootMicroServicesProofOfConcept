package org.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
    	SpringApplication app = new SpringApplication(Application.class);
    	app.setShowBanner(false); // removes the spring leaf
    	app.run(args);
    }
}
