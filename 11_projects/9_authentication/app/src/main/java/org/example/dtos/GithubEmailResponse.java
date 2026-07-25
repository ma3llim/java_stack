package org.example.dtos;

import lombok.Data;

@Data
public class GithubEmailResponse {
    private String email;
    private boolean primary;
    private boolean verified;
}