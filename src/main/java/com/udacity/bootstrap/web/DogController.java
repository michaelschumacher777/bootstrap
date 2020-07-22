package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogServiceImpl dogService;

    @Autowired
    public void setDogService(DogServiceImpl dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.retrieveAllDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getDogBreeds() {
        return new ResponseEntity<List<String>>(dogService.retrieveDogBreeds(), HttpStatus.OK);
    }

    @GetMapping("/{id}/breedById")
    public ResponseEntity<String> getDogBreedsById (@PathVariable Long id) {
        return new ResponseEntity<String>(dogService.retrieveDogBreedById(id),HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getDogNames() {
        return new ResponseEntity<List<String>>(dogService.retrieveDogNames(), HttpStatus.OK);
    }
}
