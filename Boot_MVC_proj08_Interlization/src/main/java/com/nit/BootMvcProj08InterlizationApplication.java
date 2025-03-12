package com.nit;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj08InterlizationApplication 
{
	@Bean(name="localeREsolver")// fixed bean id

	public LocaleResolver localeResolver() {
	    SessionLocaleResolver resolver = new SessionLocaleResolver();
	    resolver.setDefaultLocale(Locale.ENGLISH);
	    return resolver;
	}

	@Bean
	public LocaleChangeInterceptor createCIntercepter()
	{
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		interceptor.setParamName("lang"); // default is local
		
		return  interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj08InterlizationApplication.class, args);
	}

}
