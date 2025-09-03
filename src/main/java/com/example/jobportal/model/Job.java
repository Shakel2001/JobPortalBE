package com.example.jobportal.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "company_name")
    private String companyName;

    private String location;        // e.g. Bangalore

    @Column(name = "job_type")
    private String jobType;         // Full-time / Contract / Remote

    private String experience;      // "1-3 yr"

    @Column(name = "salary_min")
    private Integer salaryMin;      // monthly in INR (e.g. 50000)

    @Column(name = "salary_max")
    private Integer salaryMax;

    @Column(length = 2000)
    private String description;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "dead_line")
    private String deadline;

    @Column(name = "status")
    private String status;
}
