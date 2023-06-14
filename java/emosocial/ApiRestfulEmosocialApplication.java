package emosocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Mateo Josue Rodriguez Chico
 *
 * @version 1.0
 *
 */

@SpringBootApplication
public class ApiRestfulEmosocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfulEmosocialApplication.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            
           
    @Override
    public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("*")
          .allowedHeaders("*");
            }
        };
    }
}
