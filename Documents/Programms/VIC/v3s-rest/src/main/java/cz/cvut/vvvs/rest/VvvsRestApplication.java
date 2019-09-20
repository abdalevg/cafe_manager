package cz.cvut.vvvs.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:spring/app-context-services.xml"})
public class VvvsRestApplication extends SpringBootServletInitializer {

	/**
	 * Start point for JAR profile with embedded Tomcat
	 */
	public static void main(String[] args) {
		SpringApplication.run(VvvsRestApplication.class, args);
	}

	/**
	 * Start point for WAR profile
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VvvsRestApplication.class);
	}
}
