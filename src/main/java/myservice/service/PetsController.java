package myservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class PetsController {

    private String newName;
    private final PetService petService;

    public PetsController(PetService petService) {
        this.petService = petService;
    }


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

    @QueryMapping
    Pet favoritePet() {
        return petService.getFavoritePet();
    }

//    @SchemaMapping(typeName = "Pet", field = "owner")
//    Person owner(Pet pet) {
//        //return petService.getPerson(pet.ownerId());
//        return petService.getPerson(pet.name());
//    }
    //@SchemaMapping(typeName = "Pet", field = "owner")
    @QueryMapping
    /*Map<String, String>*/Owner owner(@Argument Pet pet) {
//        return Map.of("firstName","Andi",
//                "lastName","Marek");
        return new Owner(pet.name(), pet.color());
    }


    //add wmethods for own  Resolver
    @QueryMapping
    IPet favoriteIPet() {
        return petService.getFavoriteIPet();
    }
    @SchemaMapping
    Person owner(Dog dog) {
        return petService.getPerson(dog.ownerId());
    }
    @SchemaMapping
    Person owner(Cat cat) {
        return petService.getPerson(cat.ownerId());
    }
}
