package myservice.service;

import org.springframework.stereotype.Service;

@Service
public class PetService {

    Pet getFavoritePet() {
        //new Person("2", "John", "tomson"
        return new Pet("Khasan", "garay");
    }

    Person getPerson(String id) {
        return new Person("2", "John", "tomson");
    }

    IPet getFavoriteIPet() {
        //new Person("2", "John", "tomson"
        System.out.println("getFavoriteIPet called");
        return new Dog("Khasan", "garay", true);
    }
}
