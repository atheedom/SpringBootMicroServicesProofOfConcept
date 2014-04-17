package org.microservices;

import org.microservices.entity.User;
import org.microservices.control.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Autowired
	UserRepository repository;
	
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
    	SpringApplication app = new SpringApplication(Application.class);
    	app.setShowBanner(false); // removes the spring leaf
    	app.run(args);
    }
  
    
    @Bean
    public WebMvcConfigurerAdapter mvcViewConfigurer() {
    	return new WebMvcConfigurerAdapter() {
    		@Override
    		public void addViewControllers(ViewControllerRegistry registry){
    			registry.addViewController("/users").setViewName("users");
    		}		
		};
    }
    
    
    
    @Bean
    public InitializingBean populateTestData(final UserRepository repository){   	
    	return new InitializingBean(){
			@Override
			public void afterPropertiesSet() throws Exception {
//		    	repository.save(new User("jsmith","John","Smith"));
//		    	repository.save(new User("atheedom","Alex","Theedom"));
//		    	System.out.println(repository.findAll());		
			}		
    	};
    }

}
