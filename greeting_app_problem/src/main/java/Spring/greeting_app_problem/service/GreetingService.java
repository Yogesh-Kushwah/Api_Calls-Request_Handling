package Spring.greeting_app_problem.service;

import Spring.greeting_app_problem.model.Greeting;
import Spring.greeting_app_problem.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GreetingService {


    private final GreetingRepository greetingRepository;

    // Constructor-based Dependency Injection
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // UC02: Simple Greeting
    public String getGreetingMessage() {
        return "Hello World";
    }

    // UC03: Generate Greeting Based on User Input
    public String generateGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello " + firstName + "!";
        } else if (lastName != null) {
            return "Hello " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }

    // UC04: Save Greeting to Database
    public Greeting saveGreeting(String firstName, String lastName) {
        String message = generateGreeting(firstName, lastName);
        Greeting greeting = new Greeting();

        greeting.setFirstName(firstName);
        greeting.setLastName(lastName);
        greeting.setMessage(message);

        System.out.println("Saving Greeting: " + firstName + " " + lastName); // Debugging
        return greetingRepository.save(greeting);
    }


    // UC05: Find a Greeting by ID
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    // UC06: Retrieve All Greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // UC07: Update an Existing Greeting
    public Greeting updateGreeting(Long id, String firstName, String lastName) {
        // Find existing Greeting by ID
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));

        // Update the fields if new values are provided
        if (firstName != null) {
            existingGreeting.setFirstName(firstName);
        }
        if (lastName != null) {
            existingGreeting.setLastName(lastName);
        }

        // Generate a new message based on updated names
        existingGreeting.setMessage(generateGreeting(firstName, lastName));

        // Save the updated Greeting to the database
        return greetingRepository.save(existingGreeting);
    }

    // Delete a Greeting by ID
    public void deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
    }


}

