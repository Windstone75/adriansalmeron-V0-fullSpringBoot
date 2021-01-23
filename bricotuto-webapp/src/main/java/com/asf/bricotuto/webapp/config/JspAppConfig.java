package com.asf.bricotuto.webapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.asf.bricotuto.webapp.interceptor.UrlLocaleInterceptor;
import com.asf.bricotuto.webapp.interceptor.UrlLocaleResolver;

@EnableWebMvc
@Configuration
@Import(value = { LoginSecurityConfig.class })
@ImportResource("classpath:/bootstrapContext.xml")
@ComponentScan(basePackages = "com.asf.bricotuto")
public class JspAppConfig extends WebMvcConfigurationSupport {

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images");
		reg.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css");
	}

	@Bean
	public InternalResourceViewResolver jspPageViewResolver() {
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
		jspViewResolver.setViewClass(JstlView.class);
		jspViewResolver.setPrefix("/WEB-INF/jsp/");
		jspViewResolver.setSuffix(".jsp");
		return jspViewResolver;
	}
	//*******************************************
	//******** Internalization (i18n ) **********
	//*******************************************
    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
 
        // Read i18n/messages_xxx.properties file.
        // For example: i18n/messages_en.properties
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
