package org.example.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tut {
    private String title;
    private String content;
    private String createdYear;
}
