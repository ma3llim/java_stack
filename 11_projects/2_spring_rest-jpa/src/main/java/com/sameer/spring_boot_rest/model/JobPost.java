package com.sameer.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDate;
    private int reqExperience;
    private List<String> postTechStack;
    private String postDesc;

    public JobPost() {
    }

    public JobPost(int postId, String postProfile, String postDate, int reqExperience, List<String> postTechStack, String postDesc) {
        this.postId = postId;
        this.postProfile = postProfile;
        this.postDate = postDate;
        this.reqExperience = reqExperience;
        this.postTechStack = postTechStack;
        this.postDesc = postDesc;
    }
}