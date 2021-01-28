package greeting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping(path = "/{name}")
    public Object greet(@PathVariable String name, @RequestParam String language) {
        String localizedGreeting = new RestTemplate().getForObject(
                String.format("http://wiremock:8080/greeting/%s", language), String.class);
        return ResponseEntity.ok().body(String.format("%s %s!", localizedGreeting, name));
    }
}
