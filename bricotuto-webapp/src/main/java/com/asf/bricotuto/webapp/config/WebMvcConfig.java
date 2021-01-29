package com.asf.bricotuto.webapp.config;

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
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.asf.bricotuto.webapp.interceptor.UrlLocaleInterceptor;
import com.asf.bricotuto.webapp.interceptor.UrlLocaleResolver;

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
		registry.addResourceHandler("/images/**","{locale:en|fr|es}/images/**").addResourceLocations("/resources/images/");
		registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");	
	}

	// *******************************************
	// ******** View Resolver **********
	// *******************************************
	@Bean
	public InternalResourceViewResolver jspPageViewResolver() {
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
		jspViewResolver.setViewClass(JstlView.class);
		jspViewResolver.setPrefix("/WEB-INF/jsp/");
		jspViewResolver.setSuffix(".jsp");
		return jspViewResolver;
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
