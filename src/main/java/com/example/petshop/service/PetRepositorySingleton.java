package com.example.petshop.service;

import com.example.petshop.model.Pet;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * PetRepositorySingleton demonstrates a classic Singleton pattern (thread-safe, lazy initialization).
 * It stores pets in-memory using a HashMap for simplicity.
 */
public class PetRepositorySingleton {

    private static volatile PetRepositorySingleton instance;
    private final Map<Long, Pet> store = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    private PetRepositorySingleton() {
        // private constructor to prevent instantiation
        // seed with a sample pet
        Pet p = new Pet(idGenerator.getAndIncrement(), "Rex", "Dog", 3);
        store.put(p.getId(), p);
    }

    public static PetRepositorySingleton getInstance() {
        if (instance == null) {
            synchronized (PetRepositorySingleton.class) {
                if (instance == null) {
                    instance = new PetRepositorySingleton();
                }
            }
        }
        return instance;
    }

    public List<Pet> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Pet> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Pet save(Pet pet) {
        if (pet.getId() == null) {
            pet.setId(idGenerator.getAndIncrement());
        }
        store.put(pet.getId(), pet);
        return pet;
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }

    public void clear() {
        store.clear();
    }
}
