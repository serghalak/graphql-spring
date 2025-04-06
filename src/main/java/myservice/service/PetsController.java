package myservice.service;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetsController {

    private String newName;

    @QueryMapping
    List<Pet> pets() {
        return List.of(
                new Pet("Luna", "cappuchino"),
                new Pet("Skipper", "black")
        );
    }

    @MutationMapping
    User changeUser(@Argument String newName) {
        this.newName = newName;
        return new User(newName, new Address("OldStreet", "OldCountry"));
    }
}
