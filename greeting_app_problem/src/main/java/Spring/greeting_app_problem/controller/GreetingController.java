package Spring.greeting_app_problem.controller;

import Spring.greeting_app_problem.service.GreetingService;

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

//UC02
    //Extend GreetingController to use Services Layer to get Simple Greeting message ”Hello World”


    private final GreetingService greetingService;

    // Constructor-based Dependency Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;

    }

    @GetMapping("/q")
    public Map<String, String> getGree() {
        return Map.of("message", greetingService.getGreetingMessage());
    }



    //UC 03

    // GET method with optional parameters for firstName and lastName
    @GetMapping("/p")
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        String greetingMessage = greetingService.generateGreeting(firstName, lastName);
        return "{\"message\": \"" + greetingMessage + "\"}";
    }

}
