package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.model.Computer;
import com.usa.ciclo3.reto3.repository.crud.ComputerCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerRepository {

    @Autowired
    private ComputerCrudRepository computadorCrudRepository;

    public List<Computer> getAll() {
        return (List<Computer>) computadorCrudRepository.findAll();
    }

    public Optional<Computer> getComputerId(int id) {
        return computadorCrudRepository.findById(id);
    }

    public Computer saveComputer(Computer computer) {
        return computadorCrudRepository.save(computer);
    }

    public void delete(Computer computer){
        computadorCrudRepository.delete(computer);
    }

}
