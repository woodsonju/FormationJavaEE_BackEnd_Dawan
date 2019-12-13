package fr.dawan.formation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.dawan.formation.domain.Adresse;

@Configuration
@ComponentScan(basePackages = "fr.dawan.formation")
public class AppConfig {
	@Bean
	public Adresse adresse() {
		return new Adresse(1, "rue des fleurs", "95000", "PARIS");
	}
}
