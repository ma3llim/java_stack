package com.sameer.JobApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data // this is use in places of getter and setters
@NoArgsConstructor // default constructor
@AllArgsConstructor // constructor with parameter
@Component
public class JobPost {
    private int postId;
    private String postProfile;
    private String postDate;
    private int reqExperience;
    private List<String> postTechStack;
    private String postDesc;
}
