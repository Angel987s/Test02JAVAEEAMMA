package org.esfe.Test02JAVAEEAMMA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication@ComponentScan(basePackages = {"org.esfe.Test02JAVAEEAMMA"}) // Asegúrate de incluir el paquete de tus servicios

public class Test02JavaeeammaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test02JavaeeammaApplication.class, args);
	}

}
