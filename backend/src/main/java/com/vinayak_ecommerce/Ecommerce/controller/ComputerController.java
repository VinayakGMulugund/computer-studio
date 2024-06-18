package com.vinayak_ecommerce.Ecommerce.controller;


import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/computer")
@CrossOrigin(origins = "http://localhost:4200")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping("")
    public List<Computer> getDefaultComputers() {
        return computerService.getDefaultComputers();
    }

    @GetMapping("/all")
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @GetMapping("/{id}")
    public Optional<Computer> getComputer(@PathVariable String id) {
        return computerService.getComputer(Long.parseLong((id)));
    }

    @PostMapping("/{studioId}")
    public Computer generateComputer(@PathVariable String studioId) {
        return computerService.generateComputer(studioId);
    }

//    @PostMapping("")
//    public Computer createComputer(@RequestBody Computer computer) {
//        return computerService.createComputer(computer);
//    }

    @PutMapping("")
    public Computer updateComputer(@RequestBody Computer computer) {
        return computerService.updateComputer(computer);
    }
}
