package com.asf.bricotuto.webapp.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@EnableWebMvc
@Configuration
@Import(value = { LoginSecurityConfig.class })
@ImportResource("classpath:/bootstrapContext.xml")
@ComponentScan(basePackages = "com.asf.bricotuto")
public class JspAppConfig extends WebMvcConfigurationSupport{	

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("images/**").addResourceLocations("/WEB-INF/images");
		reg.addResourceHandler("css/**").addResourceLocations("/WEB-INF/css");
	}
	
	@Bean
	public InternalResourceViewResolver jspPageViewResolver() {
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
		jspViewResolver.setViewClass(JstlView.class);
		jspViewResolver.setPrefix("/WEB-INF/jsp/");
		jspViewResolver.setSuffix(".jsp");
		return jspViewResolver;
	}
}


