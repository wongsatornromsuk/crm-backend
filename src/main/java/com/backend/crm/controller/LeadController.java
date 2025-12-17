package com.backend.crm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.backend.crm.entity.Account;
import com.backend.crm.entity.Lead;
import com.backend.crm.service.LeadService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leads")
public class LeadController {

    private final LeadService service;

    public LeadController(LeadService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lead> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Lead getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/stage/{stage}")
    public List<Lead> getByStage(@PathVariable String stage) {
        return service.getByStage(stage);
    }

    @GetMapping("/stage-not-converted")
    public List<Lead> getByStageNotConverted() {
        return service.getByStageNotConverted();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lead create(@RequestBody Lead lead) {
        return service.create(lead);
    }

    @PostMapping("/convert/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account convertLead(@PathVariable Long id) {
        return service.convertLead(id);
    }

    @PutMapping("/{id}")
    public Lead update(@PathVariable Long id,
                           @RequestBody Lead lead) {
        return service.update(id, lead);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

