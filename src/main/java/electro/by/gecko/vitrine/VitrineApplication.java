package electro.by.gecko.vitrine;

import electro.by.gecko.vitrine.service.file.StorageProperties;
import electro.by.gecko.vitrine.service.file.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class VitrineApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitrineApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
