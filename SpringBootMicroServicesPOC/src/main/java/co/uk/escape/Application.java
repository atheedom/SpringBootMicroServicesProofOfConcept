package co.uk.escape;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import co.uk.escape.domain.User;
import co.uk.escape.domain.UserRepository;

@EnableWebMvc
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Autowired
	UserRepository userRepository;
	
    public static void main(String[] args) {
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
    public InitializingBean populateTestData(final UserRepository userRepository){   	
    	return new InitializingBean(){
			@Override
			public void afterPropertiesSet() throws Exception {
		    	userRepository.save(new User("jsmith","John","Smith", "jsmaith@hotmail.com"));
		    	userRepository.save(new User("atheedom","Alex","Theedom", "atheedom@gmail.com"));
		    	System.out.println(userRepository.findAll());		
			}		
    	};
    }

}
