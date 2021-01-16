package com.asf.bricotuto.webapp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ImportResource("classpath:/bootstrapContext.xml")
@ComponentScan(basePackages = "com.asf.bricotuto")
public class BricoTutoWebAppConfig extends WebMvcConfigurationSupport{	

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("imgs/**", "css/**")
		.addResourceLocations("classpath:/static/images", "classpath:/static/css/");
	}
	
	@Bean
	public InternalResourceViewResolver jspPageViewResolver() {
		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
		jspViewResolver.setViewClass(JstlView.class);
		jspViewResolver.setPrefix("/WEB-INF/JSP/");
		jspViewResolver.setSuffix(".jsp");
		return jspViewResolver;
	}
}


