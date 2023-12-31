package com.asf.adriansalmeron.webapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.asf.adriansalmeron.webapp.interceptor.UrlLocaleInterceptor;
import com.asf.adriansalmeron.webapp.interceptor.UrlLocaleResolver;

@EnableWebMvc
@Configuration
@Import(value = { LoginSecurityConfig.class })
@ImportResource("classpath:/config/webappContext.xml")
public class WebMvcConfig implements WebMvcConfigurer {

	// *******************************************
	// ******** add Resource Handlers **********
	// *******************************************
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler(
	                "/images/**",
	                "/css/**",
	                "/js/**")
	                .addResourceLocations(
	                        "classpath:/static/images/",
	                        "classpath:/static/css/",
	                        "classpath:/static/js/");
			}

	// *******************************************
	// ******** Internalization (i18n ) **********
	// *******************************************
	@Bean(name = "messageSource")
	public MessageSource getMessageResource() {
		ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
		messageResource.setBasename("classpath:i18n/messages");
		messageResource.setDefaultEncoding("UTF-8");
		return messageResource;
	}

	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver() {
		LocaleResolver resolver = new UrlLocaleResolver();
		return resolver;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
		registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/fr/*", "/es/*");
	}

}
