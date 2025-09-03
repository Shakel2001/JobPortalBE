package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
@CrossOrigin(origins = "*")
public class JobController {
    private final JobRepository repo;

    public JobController(JobRepository repo) {
        this.repo = repo;
    }

    // Create Job (Draft or Publish)
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return repo.save(job);
    }

    // Get All Jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return repo.findAll();
    }

    // Get All Published Jobs
    @GetMapping("/published")
    public List<Job> getPublishedJobs() {
        return repo.findByStatusIgnoreCase("published");
    }


    // Get Single Job
    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }
}
