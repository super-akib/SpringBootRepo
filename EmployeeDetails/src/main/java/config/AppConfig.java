package config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import sbean.Employee;

@Configuration
@ComponentScan(basePackages = "sbean")
public class AppConfig 
{  
	@Bean(name ="list")
    public ArrayList<Employee>  empObj()
    {
    	return new ArrayList<Employee>();
    }
}
