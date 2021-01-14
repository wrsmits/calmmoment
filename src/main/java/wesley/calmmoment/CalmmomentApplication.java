package wesley.calmmoment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("wesley.calmmoment.*")
@EnableJpaRepositories("wesley.calmmoment.*")
@ComponentScan(basePackages = {"wesley.calmmoment.*"})
public class CalmmomentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalmmomentApplication.class, args);
    }

}
