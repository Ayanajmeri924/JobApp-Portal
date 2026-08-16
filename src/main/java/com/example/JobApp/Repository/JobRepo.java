package com.example.JobApp.Repository;

import com.example.JobApp.Model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JobRepo {

    // Initial dummy data
    private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have Spring Boot knowledge", 2, Arrays.asList("Java", "Spring Boot", "SQL")),
            new JobPost(2, "Frontend Developer", "React and Bootstrap expertise needed", 1, Arrays.asList("JavaScript", "React", "CSS")),
            new JobPost(3, "Data Engineer", "Python and SQL background required", 3, Arrays.asList("Python", "SQL", "Spark"))
    ));

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost job) {
        jobs.add(job);
    }

    public List<JobPost> searchJobs(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return jobs;
        }
        String lowerKeyword = keyword.toLowerCase();
        return jobs.stream()
                .filter(job -> job.getPostProfile().toLowerCase().contains(lowerKeyword) ||
                        job.getPostDesc().toLowerCase().contains(lowerKeyword) ||
                        job.getPostTechStack().stream().anyMatch(tech -> tech.toLowerCase().contains(lowerKeyword)))
                .collect(Collectors.toList());
    }
}