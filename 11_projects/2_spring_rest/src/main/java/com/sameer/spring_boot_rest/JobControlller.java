package com.sameer.spring_boot_rest;

import com.sameer.spring_boot_rest.model.JobPost;
import com.sameer.spring_boot_rest.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JobControlller {
    @Autowired
    private JobServices services;

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return services.getAllJobs();
    }
}
