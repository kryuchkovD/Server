package com.samsung.springtest.controller;

import com.samsung.springtest.domain.Sites;
import com.samsung.springtest.service.SitesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SitesController {

    private final SitesService sitesService;

    @PostMapping("/sites")
    public Sites add(@RequestBody Sites sites){
        return sitesService.add(sites);
    }

    @GetMapping("/sites")
    public List<Sites> getAll() {
        return sitesService.getAll();
    }

    @GetMapping("/sites/{id}")
    public Sites getById(@PathVariable long id) {
        return sitesService.getById(id);
    }

    @PutMapping("/sites")
    public Sites update(@RequestBody Sites sites){
        return sitesService.update(sites);
    }

    @DeleteMapping("/sites/{id}")
    public void deleteById(@PathVariable long id){
        sitesService.deleteById(id);
    }
}
