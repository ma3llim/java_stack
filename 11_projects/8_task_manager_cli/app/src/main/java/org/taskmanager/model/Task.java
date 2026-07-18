package org.taskmanager.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Task implements Comparable<Task>{
    private final UUID id;
    private final String title;
    private final String description;
    private final Priority priority;
    private final Status status;
    private final LocalDateTime dueDate;
    private final String assignedTo;

    private Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        this.status = builder.status;
        this.dueDate = builder.dueDate;
        this.assignedTo = builder.assignedTo;
    }

    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Priority getPriority() {
        return priority;
    }
    public Status getStatus() {
        return status;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public String getAssignedTo() {
        return assignedTo;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }

    @Override
    public int compareTo(Task other){
        return this.id.compareTo(other.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return  true;
        if(o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return  Objects.equals(id, task.id);
    }

    public static class Builder{
        private UUID id;
        private String title;
        private String description;
        private Priority priority;
        private Status status;
        private LocalDateTime dueDate;
        private String assignedTo;

        public Builder id(UUID id){
            this.id = id;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder priority(Priority priority){
            this.priority = priority;
            return this;
        }
        public Builder status(Status status){
            this.status = status;
            return this;
        }
        public Builder dueDate(LocalDateTime dueDate){
            this.dueDate = dueDate;
            return this;
        }
        public Builder assignedTo(String assignedTo){
            this.assignedTo = assignedTo;
            return this;
        }

        public Task build(){
            if(this.id == null){
                this.id = UUID.randomUUID();
            }
            return new Task(this);
        }
    }
}
