package com.example.jobportal.controller;

import com.example.jobportal.model.Application;
import com.example.jobportal.repository.ApplicationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apply")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {
    private final ApplicationRepository repo;
    public ApplicationController(ApplicationRepository repo) { this.repo = repo; }

    @PostMapping
    public Application apply(@RequestBody Application application) {
        return repo.save(application);
    }
}
