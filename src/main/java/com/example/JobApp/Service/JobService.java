package com.example.JobApp.Service;

import com.example.JobApp.Model.JobPost;
import com.example.JobApp.Repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> searchJobs(String keyword) {
        return repo.searchJobs(keyword);
    }
}