package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo3.reto3.model.Computer;
import com.usa.ciclo3.reto3.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Alix Rincón
 */
@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computadorRepository;

    /**
     * 
     * @return
     */
    public List<Computer> getAll() {
        return computadorRepository.getAll();
    }

    /**
     * 
     * @param id
     * @return
     */
    public Optional<Computer> getComputerId(int id) {
        return computadorRepository.getComputerId(id);
    }
    
    /**
     * 
     * @param computer
     * @return
     */
    public Computer saveComputer(Computer computer) {
        if (computer.getId() == null) {
            return computadorRepository.saveComputer(computer);
        } else {
            Optional<Computer> consulta = computadorRepository.getComputerId(computer.getId());
            if (consulta.isEmpty()) {
                return computadorRepository.saveComputer(computer);
            } else {
                return computer;
            }
        }
    }

    /**
     * 
     * @param computer
     * @return
     */
    public Computer updateComputer(Computer computer) {
        if (computer.getId() != null) {
            Optional<Computer> e = computadorRepository.getComputerId(computer.getId());
            if (!e.isEmpty()) {
                if (computer.getName() != null) {
                    e.get().setName(computer.getName());
                }
                if (computer.getBrand() != null) {
                    e.get().setBrand(computer.getBrand());
                }
                if (computer.getYear() != null) {
                    e.get().setYear(computer.getYear());
                }
                if (computer.getDescription() != null) {
                    e.get().setDescription(computer.getDescription());
                }
                if (computer.getCategory() != null) {
                    e.get().setCategory(computer.getCategory());
                }
                computadorRepository.saveComputer(e.get());
                return e.get();
            } else {
                return computer;
            }
        } else {
            return computer;
        }
    }

    /**
     * 
     * @param computerId
     * @return
     */
    public boolean deleteComputerById(int computerId) {
        Boolean aBoolean = getComputerId(computerId).map(computer -> {
            computadorRepository.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
