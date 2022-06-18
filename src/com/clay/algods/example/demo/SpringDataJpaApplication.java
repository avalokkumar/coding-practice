package algods.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
/*	@Bean
	InitializingBean seedData(ShopRepository repo) {
		
		return () ->{
			repo.save(new Shop(UUID.randomUUID(), "Demo Shop", "Ranchi"));
			repo.save(new Shop(UUID.randomUUID(), "Random Shop", "Raipur"));
			repo.save(new Shop(UUID.randomUUID(), "Electronic Shop", "Bangalore"));
		};
	}
*/
	@Bean
	CommandLineRunner runQuery(ShopRepository repo) {
		
		return args -> repo.findAll().forEach(System.out::println);
	}
	
	
}

