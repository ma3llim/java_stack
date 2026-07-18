package org.taskmanager.service;

import org.taskmanager.exception.TaskNotFoundException;
import org.taskmanager.model.Status;
import org.taskmanager.model.Task;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class TaskReminderService {
    private volatile boolean running = true;
    private final TaskManager taskManager;
    private final ScheduledExecutorService scheduler;
    private final Map<UUID, ScheduledFuture<?>> activeReminders;

    public TaskReminderService(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.activeReminders = new HashMap<>();
    }

    public void scheduleReminder(UUID taskId, long minutesBefore) {
        Task task;
        try {
            task = taskManager.getById(taskId);
        } catch (TaskNotFoundException e) {
            System.out.println("Task not found");
            return;
        }

        if (task.getDueDate() == null) {
            System.out.println("Task has no due date");
            return;
        }

        // Calculate the delay: (Task Due time - current time) - minutesBefore
        //                       5:00 - 4:00 - 15 = 45
        // Calculate reminder time
        LocalDateTime reminderTime = task.getDueDate().minusMinutes(minutesBefore);
        // Calculate delay from now
        long delayInMinutes = Duration.between(LocalDateTime.now(), reminderTime).toMinutes();

        if (delayInMinutes <= 0) {
            System.out.println("Reminder time already passed");
            return;
        }
        if (activeReminders.containsKey(taskId)) {
            ScheduledFuture<?> existingReminder = activeReminders.remove(taskId);
            if (existingReminder != null) {
                existingReminder.cancel(false);
            }
        }

        ScheduledFuture<?> futureTask = scheduler.schedule(() -> {
            System.out.println("REMINDER: Task Title: " + task.getTitle() + " | Due Date: " + task.getDueDate() + " | Assigned To: " + task.getAssignedTo());
            activeReminders.remove(taskId);
        }, delayInMinutes, TimeUnit.MINUTES);

        activeReminders.put(taskId, futureTask);
    }

    public void cancelReminder(UUID taskId) {
        boolean existingActiveReminders = activeReminders.containsKey(taskId);
        if (existingActiveReminders) {
            ScheduledFuture<?> cancelReminder = activeReminders.remove(taskId);
            if (cancelReminder != null) {
                cancelReminder.cancel(false);
            }
            System.out.println("Reminder cancelled for task [" + taskId + "]");
        } else {
            System.out.println("No active reminder found for task [" + taskId + "]");
        }
    }

    public void cancelAllReminders() {
        if (activeReminders.isEmpty()) {
            System.out.println("No active reminders to cancel");
            return;
        }
        for (ScheduledFuture<?> scheduledFuture : activeReminders.values()) {
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
        }
        activeReminders.clear();
        System.out.println("All active reminders have been successfully canceled.");
    }

    public void startOverdueCheck(long periodMinutes) {
        scheduler.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now();

            var overdueTasks = taskManager.filterByDueDateBefore(now).filter(task -> task.getStatus() != Status.DONE && task.getStatus() != Status.CANCELLED).toList();
            if (overdueTasks.isEmpty()) {
                System.out.println("\n=== OVERDUE TASKS ALERT (" + now + ") ===");

                // Loop and print details for each task
                overdueTasks.forEach(task -> {
                    System.out.println("ID: " + task.getId()
                            + " | Title: " + task.getTitle()
                            + " | Due: " + task.getDueDate()
                            + " | Priority: " + task.getPriority()
                            + " | Assigned To: " + task.getAssignedTo());
                });
                System.out.println("============================================\n");
            } else {
                // Step 5.6: Silent or light-debug message
                System.out.println("No overdue tasks found at " + now);
            }
        }, 0, periodMinutes, TimeUnit.MINUTES);
    }

    public void shutdown() {
        this.running = false;
        System.out.println("Stopping reminder service; no new reminders will be accepted.");
        cancelAllReminders();
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Executor did not terminate in 5 seconds. Forcing shutdown...");
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Shutdown interrupted. Forcing immediate executor termination.");
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Reminder service shut down");
    }
}
