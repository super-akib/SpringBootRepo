package com.nit;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.nit.model.User;
import com.nit.service.PaymentService;

@SpringBootApplication
public class PaymentSystemApplication {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("system");
        dataSource.setPassword("akib");
        return dataSource;
    }
    
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(PaymentSystemApplication.class, args);

        // Get user bean object from IOC container
        User user = applicationContext.getBean(User.class);

        // Get service class object from IOC 
        PaymentService service = applicationContext.getBean(PaymentService.class);

        // Set User properties using setter methods
        user.setUserId(10122);
        user.setUserName("jake");
        user.setEmailId("jake23@gmail.com");

        // Invoke the service method 
        service.processUserPayment(user, 5000, "paypal");

        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
