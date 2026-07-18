package org.taskmanager.service;

import org.taskmanager.exception.DuplicateTaskException;
import org.taskmanager.exception.TaskNotFoundException;
import org.taskmanager.model.Priority;
import org.taskmanager.model.Status;
import org.taskmanager.model.Task;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class TaskManager {
    private final HashMap<UUID, Task> taskHashMap = new HashMap<>();

    public HashMap<UUID, Task> getTaskHashMap() {
        return taskHashMap;
    }

    public Task addTask(Task task) throws DuplicateTaskException {
        boolean taskExisted = taskHashMap.containsKey(task.getId());
        if (taskExisted) {
            throw new DuplicateTaskException(task.getId());
        }
        taskHashMap.put(task.getId(), task);
        return task;
    }

    public Task updateTask(Task task) throws TaskNotFoundException {
        if (!taskHashMap.containsKey(task.getId())) {
            throw new TaskNotFoundException("Task with ID " + task.getId() + " not found");
        }
        taskHashMap.compute(task.getId(), (id, existingTask) -> task);
        return task;
    }

    public Task delete(UUID taskId) throws TaskNotFoundException {
        if (!taskHashMap.containsKey(taskId)) {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found");
        }

        return taskHashMap.remove(taskId);
    }

    public Task getById(UUID taskId) throws TaskNotFoundException {
        return Optional.ofNullable(taskHashMap.get(taskId)).orElseThrow(() -> new TaskNotFoundException("Task with ID " + taskId + " not found"));
    }

    public List<Task> listAll() {
        return taskHashMap.values().stream().toList();
    }

    public Collection<Task> filterByStatus(Status status) {
        return taskHashMap.values().stream().filter(task -> task.getStatus() == status).toList();
    }

    public Collection<Task> filterByPriority(Priority priority) {
        return taskHashMap.values().stream().filter(task -> task.getPriority() == priority).toList();
    }

    public Collection<Task> filterByAssignee(String assignee) {
        return taskHashMap.values().stream()
                .filter(task -> task.getAssignedTo() != null)
                .filter(task -> task.getAssignedTo().equalsIgnoreCase(assignee)).toList();
    }

    public Stream<Task> filterByDueDateBefore(LocalDateTime time) {
        return taskHashMap.values().stream()
                .filter(task -> task.getDueDate() != null)
                .filter(task -> task.getDueDate().isBefore(time));
    }

    public Collection<Task> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return taskHashMap.values();
        }
        String lowerKeyword = keyword.trim().toLowerCase();

        return taskHashMap.values().stream().filter(task -> {
            boolean titleMatches = task.getTitle() != null && task.getTitle().toLowerCase().contains(lowerKeyword);
            boolean descMatches = task.getDescription() != null && task.getDescription().toLowerCase().contains(lowerKeyword);
            return titleMatches || descMatches;
        }).toList();
    }
}
