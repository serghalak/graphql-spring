package myservice.service;

public record Cat(String name, String ownerId, Boolean doesMeow) implements IPet {
}
