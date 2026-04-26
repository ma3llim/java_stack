package com.sameer.spring_boot_rest;

import com.sameer.spring_boot_rest.model.JobPost;
import com.sameer.spring_boot_rest.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    private JobServices services;

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs(){
        return services.getAllJobs();
    }

    @GetMapping("/jobdetails/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return services.getJob(postId);
    }

    @PostMapping("/jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        services.addJob(jobPost);
    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        services.updateJob(jobPost);
        return services.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        services.deleteJob(postId);
        return  "Deleted Successfully";
    }
}
