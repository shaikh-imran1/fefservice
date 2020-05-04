package com.tat.f2fservice.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
	public static final Contact DEFAULT_CONTACT = new Contact("Your name here", "your url here", "Your Contact here");
	 public static final ApiInfo API_INFO = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

	private Set<String> produces = new TreeSet<>(Arrays.asList("application/json", "application/xml"));
	private Set<String> consumes = new TreeSet<>(Arrays.asList("application/json","application/xml"));

	@Bean
	public Docket getDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO)
														.produces(produces)
														.consumes(consumes);
	}
}


