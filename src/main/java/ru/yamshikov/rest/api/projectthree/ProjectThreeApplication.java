package ru.yamshikov.rest.api.projectthree;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(	info = @Info(
					title = "Weather Sensor REST API",
					version = "0.0.1",
					description = "REST API для работы с погодными датчиками"))
public class ProjectThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectThreeApplication.class, args);
	}

}
