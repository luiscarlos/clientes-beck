package br.com.lc.clientes.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizaçãoConfig {

	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("messages.properties");
		messageSource.setDefaultEncoding("ISO-8859-1");
		messageSource.setDefaultLocale(Locale.getDefault());
		return messageSource;
	}
	
	
	@Bean
	public LocalValidatorFactoryBean validatorFactoryBean() {
		
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
		
	}
}
