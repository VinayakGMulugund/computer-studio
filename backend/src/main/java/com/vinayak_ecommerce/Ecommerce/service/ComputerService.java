package com.vinayak_ecommerce.Ecommerce.service;


import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.repository.ComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComputerService {

    @Autowired
    ComputerRepo computerRepo;

    public Computer save(Computer computer) {
        return computerRepo.save(computer);
    }

    public List<Computer> getAllComputers() {
        return computerRepo.findAll();
    }

    public Optional<Computer> getComputer(long id) {
        return computerRepo.findById(id);
    }

    public List<Computer> getDefaultComputers() {
        List<Computer> computers = computerRepo.findAll();
        return computers.stream().filter(computer -> computer.getName()!= null && !computer.getName().isEmpty()).collect(Collectors.toList());
    }
}
