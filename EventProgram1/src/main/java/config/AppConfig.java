package config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import sbean.Event;

@Configuration
@ComponentScan(basePackages = "sbean")
public class AppConfig
{  
	@Bean
    public Event eventObj()
    {       	
    	return new Event("21-05-2024","1:30 pm","NIT ameerpet hydrabad","Currently i am in a Lab");
    }
}
