package com.yuanzheng.springbootvscode;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class SBApplication implements ApplicationRunner {
	// ApplicationRunner 和 CommandLineRunner 可用于数据配置和预处理 参数类型不一样
	public static void main(String[] args) {
		SpringApplication.run(SBApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			/*
			 * for (String name : beanNames) { System.out.println(name); }
			 */
		};

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/* 可以在springBoot启动时执行 预处理 */
		System.out.println("启动时就打印的数据！");
	}

	@Bean
	public RestTemplate getRestTemplate() { // 发送http请求
		return new RestTemplate();
	}

	/* 方法1 浏览器同源策略，解决跨域问题 */
	/* 方法2 也可以在controller里进行添加 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/student").allowedOrigins("http://localhost/9000");
			}

		};
	}

	/*
	 * 1.pom依赖 2.basePackage配置 3.EnableSwagger2注解
	 * 4.http://localhost:8080/doc.html
	 */
	@Bean
	public Docket studentApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.yuanzheng.springbootvscode.controllers")).build();

	}

}
