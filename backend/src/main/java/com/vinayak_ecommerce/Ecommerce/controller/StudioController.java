package com.vinayak_ecommerce.Ecommerce.controller;


import com.vinayak_ecommerce.Ecommerce.model.Studio;
import com.vinayak_ecommerce.Ecommerce.model.utils.StudioDto;
import com.vinayak_ecommerce.Ecommerce.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/studio")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping("")
    public Studio getStudio() {
        return studioService.getStudio();
    }

    @PutMapping("")
    public Studio updateStudio(@RequestBody StudioDto studioDto) {
        return studioService.updateStudio(studioDto);
    }
}
