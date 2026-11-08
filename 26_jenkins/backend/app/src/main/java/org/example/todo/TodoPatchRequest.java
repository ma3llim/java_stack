package org.example.todo;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/** Payload for partially updating a todo; null fields are left unchanged. */
public record TodoPatchRequest(
        @Size(max = 200, message = "title must be at most 200 characters")
        @Pattern(regexp = "(?s).*\\S.*", message = "title must not be blank")
        String title,
        Boolean completed) {
}
