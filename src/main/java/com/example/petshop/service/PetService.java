package com.example.petshop.service;

import com.example.petshop.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * PetService uses the singleton repository internally. This service can be injected by Spring controllers.
 */
@Service
public class PetService {

    private final PetRepositorySingleton repo = PetRepositorySingleton.getInstance();

    public List<Pet> getAll() {
        return repo.findAll();
    }

    public Optional<Pet> getById(Long id) {
        return repo.findById(id);
    }

    public Pet create(Pet pet) {
        pet.setId(null); // ensure id is assigned by repo
        return repo.save(pet);
    }

    public Optional<Pet> update(Long id, Pet pet) {
        return repo.findById(id).map(existing -> {
            existing.setName(pet.getName());
            existing.setType(pet.getType());
            existing.setAge(pet.getAge());
            repo.save(existing);
            return existing;
        });
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
