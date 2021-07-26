package com.piotrsarnecki.demo_gym.rest;


import com.piotrsarnecki.demo_gym.rest.dto.GymDTO;
import com.piotrsarnecki.demo_gym.services.GymService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GymController {

    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping("/gym")
    public List<GymDTO> findGyms() {
        return gymService.findGyms();
    }

    @PostMapping("/gym")
    public GymDTO addGym(@Valid @RequestBody GymDTO gymDTO) {
        return gymService.addGym(gymDTO);
    }

    @DeleteMapping("/gym/{id}")
    public ResponseEntity deleteGym(@PathVariable(name = "id") Long id) {
        gymService.deleteGym(id);
        return ResponseEntity.ok().build();
    }

}
