package myservice.service;

public record Dog(String name, String ownerId, Boolean doesBark) implements IPet {
}
