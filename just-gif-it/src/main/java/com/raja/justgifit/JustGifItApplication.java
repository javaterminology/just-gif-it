package com.raja.justgifit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication(exclude = {JmxAutoConfiguration.class,
		WebSocketMessagingAutoConfiguration.class,
		JacksonAutoConfiguration.class})
public class JustGifItApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustGifItApplication.class, args);
	}
	
	
	//deregister beans from auto configurations using setenabled = false
	@Bean
	public FilterRegistrationBean deRegisterHiddenHttpMethodFilter(HiddenHttpMethodFilter filter){
		
		FilterRegistrationBean register = new  FilterRegistrationBean(filter);
		register.setEnabled(false);
		
		return register;
	}
	
	@Bean
	public FilterRegistrationBean deRegisterHttpPutFormContentFilter(HttpPutFormContentFilter filter){
		
		FilterRegistrationBean register = new  FilterRegistrationBean(filter);
		register.setEnabled(false);
		
		return register;
	}
	
	@Bean
	public FilterRegistrationBean deRegisterRequestContextFilter(RequestContextFilter filter){
		
		FilterRegistrationBean register = new  FilterRegistrationBean(filter);
		register.setEnabled(false);
		
		return register;
	}

}