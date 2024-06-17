package com.vinayak_ecommerce.Ecommerce.service;

import com.vinayak_ecommerce.Ecommerce.model.Studio;
import com.vinayak_ecommerce.Ecommerce.model.User;
import com.vinayak_ecommerce.Ecommerce.model.utils.StudioDto;
import com.vinayak_ecommerce.Ecommerce.repository.ProductRepo;
import com.vinayak_ecommerce.Ecommerce.repository.StudioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class StudioService {
    @Autowired
    private StudioRepo studioRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepo productRepo;

    public Studio getStudio() throws RuntimeException {
        User user = userService.getCurrentUser();
        return user.getStudio();
    }

    public Studio updateStudio(StudioDto studioDto) {
        User user = userService.getCurrentUser();
        Studio studio = user.getStudio();
        studio.setBody(productRepo.findById(studioDto.getBodyId()).orElse(null));
        studio.setGpu(productRepo.findById(studioDto.getGpuId()).orElse(null));
        studio.setCpu(productRepo.findById(studioDto.getCpuId()).orElse(null));
        studio.setPsu(productRepo.findById(studioDto.getPsuId()).orElse(null));
        studio.setRam(productRepo.findById(studioDto.getRamId()).orElse(null));
        studio.setMotherboard(productRepo.findById(studioDto.getMotherboardId()).orElse(null));
        studio.setStorage(productRepo.findById(studioDto.getStorageId()).orElse(null));
        return studioRepo.save(studio);
    }
}
