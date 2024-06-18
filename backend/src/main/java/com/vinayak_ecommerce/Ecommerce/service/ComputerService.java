package com.vinayak_ecommerce.Ecommerce.service;


import com.vinayak_ecommerce.Ecommerce.model.Computer;
import com.vinayak_ecommerce.Ecommerce.model.Product;
import com.vinayak_ecommerce.Ecommerce.model.Studio;
import com.vinayak_ecommerce.Ecommerce.repository.ComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepo computerRepo;

    @Autowired
    private StudioService studioService;

    public Computer save(Computer computer) {
        if (computer.getTotal_price() == 0) {
            computer.setTotal_price(generateTotalPrice(computer));
        }
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

    public Computer generateComputer(String studioId) {
        Studio studio = studioService.getStudio();
        Computer computer = convertStudioToComputer(studio);
        return computerRepo.save(computer);
    }

    private Computer convertStudioToComputer(Studio studio) {
        Computer computer = new Computer();
        computer.setName("");
        computer.setGpu(studio.getGpu());
        computer.setBody(studio.getBody());
        computer.setCpu(studio.getCpu());
        computer.setPsu(studio.getPsu());
        computer.setRam(studio.getRam());
        computer.setStorage(studio.getStorage());
        computer.setMotherboard(studio.getMotherboard());
        computer.setTotal_price(generateTotalPrice(computer));
        return computer;
    }

    public Computer createComputer(Computer computer) {
        if (computer.getName().isEmpty()) {
            computer.setName("");
        }
        if (computer.getTotal_price() == 0) {
            computer.setTotal_price(generateTotalPrice(computer));
        }
        return computerRepo.save(computer);
    }

    public Computer updateComputer(Computer computer) {
        if (computer.getName().isEmpty()) {
            computer.setName("");
        }
        computer.setTotal_price(generateTotalPrice(computer));
        return computerRepo.save(computer);
    }

    private long generateTotalPrice(Computer computer) {
        return (long)(computer.getGpu().getPrice() + computer.getPsu().getPrice()
                + computer.getMotherboard().getPrice()
                + computer.getCpu().getPrice() + computer.getRam().getPrice() + computer.getStorage().getPrice()
                + computer.getBody().getPrice());
    }
}
