package com.usa.ciclo3.reto3.web;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo3.reto3.model.Computer;
import com.usa.ciclo3.reto3.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Alix Rincón
 */
@RestController
@RequestMapping("api/Computer")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ComputerController {
    @Autowired
    private ComputerService computadorService;    

    @GetMapping("/all")
    public List<Computer>getComputers(){
        return computadorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Computer>getComputerById(@PathVariable("id") int id){
        return computadorService.getComputerId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer computador){
        return computadorService.saveComputer(computador);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer update(@RequestBody Computer bike) {
        return computadorService.updateComputer(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int computerId) {
        return computadorService.deleteComputerById(computerId);
    } 

}
