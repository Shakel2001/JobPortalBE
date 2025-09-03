package com.example.jobportal.config;

import com.example.jobportal.model.Job;
import com.example.jobportal.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {
    private final JobRepository repo;
    public SeedData(JobRepository repo) { this.repo = repo; }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
            repo.save(Job.builder().title("Full Stack Developer").companyName("Amazon").location("Bangalore").experience("1-3 yr").jobType("Onsite").salaryMin(50000).salaryMax(80000).description("Build great web apps").logoUrl("").build());
            repo.save(Job.builder().title("Node Js Developer").companyName("Tesla").location("Pune").experience("1-3 yr").jobType("Onsite").salaryMin(45000).salaryMax(70000).description("Node + Express + Mongo").logoUrl("").build());
            // add 4-6 items to look like your screenshot
        }
    }
}
