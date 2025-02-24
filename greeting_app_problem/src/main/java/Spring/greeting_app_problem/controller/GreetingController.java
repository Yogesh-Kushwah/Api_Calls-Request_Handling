package Spring.greeting_app_problem.controller;

<<<<<<< HEAD
import Spring.greeting_app_problem.service.GreetingService;
import org.springframework.web.bind.annotation.*;
=======

import Spring.greeting_app_problem.service.GreetingService;


>>>>>>> 3a3d9bb26ff135996afbe7474a66a430c5602b5d

import java.util.Map;

@RestController
@RequestMapping("/greet")
public class GreetingController {


    //UC01

    @GetMapping
    public Map<String, String> getGreeting() {
        return Map.of("message", "Hello from GET method!");
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        return Map.of("message", "Hello from POST method!", "received", request.get("name"));
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        return Map.of("message", "Hello from PUT method!", "updated", request.get("name"));
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello from DELETE method!");
    }


<<<<<<< HEAD
=======

>>>>>>> 3a3d9bb26ff135996afbe7474a66a430c5602b5d
//UC02
    //Extend GreetingController to use Services Layer to get Simple Greeting message ”Hello World”


    private final GreetingService greetingService;

    // Constructor-based Dependency Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
<<<<<<< HEAD

=======
>>>>>>> 3a3d9bb26ff135996afbe7474a66a430c5602b5d
    }

    @GetMapping("/q")
    public Map<String, String> getGree() {
        return Map.of("message", greetingService.getGreetingMessage());
    }

<<<<<<< HEAD

    //UC 03

    // GET method with optional parameters for firstName and lastName
    @GetMapping("/p")
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        String greetingMessage = greetingService.generateGreeting(firstName, lastName);
        return "{\"message\": \"" + greetingMessage + "\"}";
    }
=======
>>>>>>> 3a3d9bb26ff135996afbe7474a66a430c5602b5d
}