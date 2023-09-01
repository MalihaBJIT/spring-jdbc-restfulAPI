package com.maliha.springjdbcrestapi.controller;

import com.maliha.springjdbcrestapi.model.PetStore;
import com.maliha.springjdbcrestapi.repository.PetRepository;
import com.maliha.springjdbcrestapi.repository.PetRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    @Autowired
    private PetRepositoryInterface petRepositoryInterface;

    @GetMapping("/pet/all")
    public ResponseEntity<List<PetStore>> getAllPet() {
        List<PetStore> candidateList = petRepositoryInterface.getAll();
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }
    @GetMapping("/pet/{id}")
    public ResponseEntity<PetStore> getPetById(@PathVariable Integer id) {
        PetStore petStore = petRepositoryInterface.getById(id).get();
        return new ResponseEntity<>(petStore, HttpStatus.OK);
    }
    @PostMapping("/pet")
    public ResponseEntity<Void> addPet(@RequestBody PetStore petStore) {
        petRepositoryInterface.add(petStore);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
//    @DeleteMapping("/pet/delete/{id}")
//    public ResponseEntity<Void> deleteCandidate(@PathVariable Integer id) {
//        petRepositoryInterface.delete(id);
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
    @DeleteMapping("/pet/delete/{id}")
    public boolean deleteCandidate(@PathVariable Integer id) {
        petRepositoryInterface.delete(id);
        return true;
    }

}
