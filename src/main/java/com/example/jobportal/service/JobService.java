package com.example.jobportal.service;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobService {
    private final JobRepository repo;
    public JobService(JobRepository repo) { this.repo = repo; }

    public List<Job> find(String q, String location, String jobType, Integer minSalary, Integer maxSalary) {
        List<Job> list = repo.findAll();
        return list.stream()
                .filter(j -> q == null || q.isBlank() ||
                        j.getTitle().toLowerCase().contains(q.toLowerCase()) ||
                        (j.getCompanyName() != null && j.getCompanyName().toLowerCase().contains(q.toLowerCase()))
                )
                .filter(j -> location == null || location.isBlank() || (j.getLocation() != null && j.getLocation().toLowerCase().contains(location.toLowerCase())))
                .filter(j -> jobType == null || jobType.isBlank() || (j.getJobType() != null && j.getJobType().equalsIgnoreCase(jobType)))
                .filter(j -> minSalary == null || (j.getSalaryMin() != null && j.getSalaryMin() >= minSalary))
                .filter(j -> maxSalary == null || (j.getSalaryMax() != null && j.getSalaryMax() <= maxSalary))
                .collect(Collectors.toList());
    }

    public Job save(Job job) { return repo.save(job); }
    public Optional<Job> findById(Long id) { return repo.findById(id); }
}
