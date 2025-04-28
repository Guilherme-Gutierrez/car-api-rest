package com.car.controller;

import com.car.domain.model.Carro;
import com.car.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/carros")
@Tag(name = "Cars Controller", description = "REST API for car information")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    @Operation(summary = "Get all cars", description = "Retrieve a list of all registered cars")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<Carro>> findAll(){
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a car by ID", description = "Retrieve a specific car based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Car not found")
    })
    public ResponseEntity<Carro> findById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping()
    @Operation(summary = "Create a new car", description = "Create a new car and return the created car's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Car created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid car data provided")
    })
    public ResponseEntity<Carro> create(@RequestBody Carro carroParaCriar){
        var carroCriado = carService.create(carroParaCriar);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carroCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(carroCriado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a car", description = "Update the data of an existing car based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car updated successfully"),
            @ApiResponse(responseCode = "404", description = "Car not found"),
            @ApiResponse(responseCode = "422", description = "Invalid car data provided")
    })
    public ResponseEntity<Carro> update(@PathVariable Integer id, @RequestBody Carro carro){
        return ResponseEntity.ok(carService.update(id, carro));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a car", description = "Delete an existing car based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Car deleted successfully"),
            @ApiResponse(responseCode = "404",description = "Car not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
