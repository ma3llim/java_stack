package com.sameer.JobApp.servives;

import com.sameer.JobApp.model.JobPost;
import com.sameer.JobApp.repositories.JobRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServices {
    private final JobRepo jobRepo;

    public JobServices(JobRepo jobRepo){
        this.jobRepo = jobRepo;
    }

    public void addJob(JobPost jobPost){
        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }
}
