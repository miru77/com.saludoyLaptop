package com.example.com.saludoyLaptop.controller;

import com.example.com.saludoyLaptop.entities.Laptop;
import com.example.com.saludoyLaptop.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //ejercicio 1

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {
        Optional<Laptop> bookOpt = laptopRepository.findById(id);  //permite envolver un Book o un Null
        //opcion 1
        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();
    }


    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }


    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Borrar una laptop de la base de datos
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {

        if(!laptopRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borrar  todas la Laptos
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return  ResponseEntity.noContent().build();
    }

}