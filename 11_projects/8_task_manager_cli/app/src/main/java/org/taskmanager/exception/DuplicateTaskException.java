package org.taskmanager.exception;

import java.util.UUID;

public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(UUID taskId) {
        super("Task already exists with ID: " + taskId);
    }
}
