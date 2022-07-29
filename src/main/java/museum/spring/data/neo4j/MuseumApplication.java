package museum.spring.data.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 * @author Michael J. Simons
 */
@SpringBootApplication
@EntityScan("movies.spring.data.neo4j.entity")
public class MuseumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuseumApplication.class, args);
    }
}
