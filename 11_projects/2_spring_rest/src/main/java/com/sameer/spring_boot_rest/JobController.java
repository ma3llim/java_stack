package com.sameer.spring_boot_rest;

import com.sameer.spring_boot_rest.model.JobPost;
import com.sameer.spring_boot_rest.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    private JobServices services;

    @GetMapping("/jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return services.getAllJobs();
    }

    @GetMapping("/jobdetails/{postId}")
    @ResponseBody
    public JobPost getJob(@PathVariable int postId){
        return services.getJob(postId);
    }

    @PostMapping("/jobPost")
    @ResponseBody
    public void addJob(@RequestBody JobPost jobPost){
        services.addJob(jobPost);
    }
}
