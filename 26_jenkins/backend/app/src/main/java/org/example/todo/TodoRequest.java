package org.example.todo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/** Payload for creating or fully replacing a todo. */
public record TodoRequest(
        @NotBlank(message = "title must not be blank")
        @Size(max = 200, message = "title must be at most 200 characters")
        String title,
        Boolean completed) {

    /** A missing "completed" field means the todo is not done. */
    public boolean isCompleted() {
        return Boolean.TRUE.equals(completed);
    }
}
