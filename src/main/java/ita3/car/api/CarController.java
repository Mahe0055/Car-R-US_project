package ita3.car.api;

import ita3.car.entity.Car;
import ita3.car.repository.ICarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    ICarRepository carRepository;

    //constructor for car repository
    public CarController(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //Read All - cars
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> index() {
        //The return for find all cars in car repo, will be a 'OK' http status
        return ResponseEntity.status(HttpStatus.OK).body(carRepository.findAll());
    }

    //Read One - car by id
   @GetMapping("/cars/{id}")
    public Optional<Car> readOne(@PathVariable long id){
    return carRepository.findById(id);
    }

    // Create -> POST
    @PostMapping("/cars")
    public Car create(@RequestBody Car car){
        Car savedCar = carRepository.save(car);
        return savedCar;
    }

    // Update -> PUT
    @PutMapping("/cars/{id}")
    public Car update(@PathVariable long id, @RequestBody Car car){
        Car updatedCar = carRepository.save(car);
        return updatedCar;
    }

    // Delete -> Delete
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        carRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
