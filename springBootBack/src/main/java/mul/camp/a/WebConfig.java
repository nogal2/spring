package mul.camp.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {	// 외부에서 접속을 해줬을때 허가를 내주는 클래스
		//WebMvcConfigurer.super.addCorsMappings(registry);
		
		// registry.addMapping("/**").allowedOrigins("http://localhost:8090");	// /**
		registry.addMapping("/**").allowedOrigins("*");	// 누구나 접속해도 상관 없다
		
	}
	
}
