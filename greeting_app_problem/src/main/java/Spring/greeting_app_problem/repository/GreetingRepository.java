package Spring.greeting_app_problem.repository;

import Spring.greeting_app_problem.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
