package org.taskmanager.cli;

import org.taskmanager.exception.DuplicateTaskException;
import org.taskmanager.exception.TaskNotFoundException;
import org.taskmanager.model.Priority;
import org.taskmanager.model.Status;
import org.taskmanager.model.Task;
import org.taskmanager.service.TaskManager;
import org.taskmanager.service.TaskReminderService;
import org.taskmanager.utils.TaskComparator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskCLI {
    private final TaskManager taskManager;
    private final TaskReminderService taskReminderService;
    private final Scanner scanner;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TaskCLI(TaskManager taskManager, TaskReminderService taskReminderService) {
        this.taskManager = taskManager;
        this.taskReminderService = taskReminderService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("================================================");
        System.out.println("     WELCOME TO THE TASK MANAGER       ");
        System.out.println("================================================");
        handleHelp();

        boolean running = true;
        while (running) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            // Split into command token and trailing arguments string
            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String args = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "add" -> handleAdd();
                case "update" -> handleUpdate(args);
                case "delete" -> handleDelete(args);
                case "list" -> handleList(args);
                case "filter" -> handleFilter(args);
                case "search" -> handleSearch(args);
                case "reminder" -> handleReminder(args);
                case "help" -> handleHelp();
                case "exit" -> {
                    System.out.println("Shutting down core services...");
                    taskReminderService.shutdown();
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Unknown command. Type 'help' for options.");
            }
        }
    }

    private void handleAdd() {
        System.out.println("--- Create New Task ---");
        String title = promptRequired("Enter Title: ");
        System.out.print("Enter Description: ");
        String description = scanner.nextLine().trim();

        Priority priority = promptEnum("Enter Priority (HIGH, MEDIUM, LOW): ", Priority.class);
        Status status = promptEnum("Enter Status (TODO, IN_PROGRESS, DONE, CANCELLED): ", Status.class);
        LocalDateTime dueDate = promptDate("Enter Due Date (yyyy-MM-dd) [Optional - Enter to skip]: ");

        System.out.print("Enter Assignee [Optional - Enter to skip]: ");
        String assignee = scanner.nextLine().trim();
        if (assignee.isEmpty()) assignee = null;

        // Execute step within safe error boundaries (Step 8.13)
        try {
            Task task = new Task.Builder()
                    .id(UUID.randomUUID())
                    .title(title)
                    .description(description)
                    .priority(priority)
                    .status(status)
                    .dueDate(dueDate)
                    .assignedTo(assignee)
                    .build();

            taskManager.addTask(task);
            System.out.println("Task created successfully! Generated ID: " + task.getId());
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleUpdate(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("✕ Error: Missing Task UUID. Usage: update <UUID>");
            return;
        }

        try {
            // 1. Parse UUID from args
            UUID existingId = UUID.fromString(args.trim());

            // 2. Fetch task with taskManager.getById()
            Task existing = taskManager.getById(existingId);

            System.out.println("\n--- Updating Task [" + existingId + "] ---");
            System.out.println("(Leave field blank and press Enter to keep current value)");

            // 3. For each field: Print current value, prompt, parse/validate if entered
            System.out.print("Title [" + existing.getTitle() + "]: ");
            String titleInput = scanner.nextLine().trim();
            String title = titleInput.isEmpty() ? existing.getTitle() : titleInput;

            System.out.print("Description [" + existing.getDescription() + "]: ");
            String descInput = scanner.nextLine().trim();
            String description = descInput.isEmpty() ? existing.getDescription() : descInput;

            System.out.print("Priority [" + existing.getPriority() + "] (HIGH, MEDIUM, LOW): ");
            String prioInput = scanner.nextLine().trim().toUpperCase();
            Priority priority = prioInput.isEmpty() ? existing.getPriority() : Priority.valueOf(prioInput);

            System.out.print("Status [" + existing.getStatus() + "] (TODO, IN_PROGRESS, DONE, CANCELLED): ");
            String statInput = scanner.nextLine().trim().toUpperCase();
            Status status = statInput.isEmpty() ? existing.getStatus() : Status.valueOf(statInput);

            System.out.print("Due Date [" + (existing.getDueDate() != null ? existing.getDueDate().toLocalDate() : "None") + "] (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine().trim();
            java.time.LocalDateTime dueDate = dateInput.isEmpty() ? existing.getDueDate() : java.time.LocalDate.parse(dateInput, dateFormatter).atStartOfDay();

            System.out.print("Assignee [" + (existing.getAssignedTo() != null ? existing.getAssignedTo() : "None") + "]: ");
            String assInput = scanner.nextLine().trim();
            String assignedTo = assInput.isEmpty() ? existing.getAssignedTo() : assInput;

            // 4. Build new Task with Builder (preserve original ID)
            Task updatedTask = new Task.Builder()
                    .id(existingId)
                    .title(title)
                    .description(description)
                    .priority(priority)
                    .status(status)
                    .dueDate(dueDate)
                    .assignedTo(assignedTo)
                    .build();

            // 5. Call taskManager.updateTask(updated)
            taskManager.updateTask(updatedTask);
            System.out.println("✔ Success: Task updated successfully!");

        } catch (Exception e) {
            // Step 8.13: Routing validation exceptions automatically
            handleException(e);
        }
    }

    private void handleDelete(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("✕ Error: Missing Task UUID. Usage: delete <UUID>");
            return;
        }

        try {
            // 1. Parse UUID from args
            UUID id = UUID.fromString(args.trim());

            // Verify task exists before asking confirmation
            taskManager.getById(id);

            // 2. Prompt "Are you sure?"
            System.out.print("Are you sure you want to delete this task? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            // 3. Evaluate confirmation routing
            if (confirmation.equals("yes") || confirmation.equals("y")) {
                taskManager.delete(id);
                System.out.println("✔ Success: Task deleted successfully.");
            } else {
                System.out.println("✕ Cancelled: Deletion aborted.");
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleList(String args) {
        try {
            // 1. Get all tasks
            List<Task> list = new ArrayList<>((Collection) taskManager.listAll());

            // 2. If args contains --sort, extract field and apply matching Comparator
            if (args != null && args.contains("--sort")) {
                // Extracts whatever comes after "--sort "
                String sortField = args.replace("--sort", "").trim().toLowerCase();

                switch (sortField) {
                    case "date", "duedate" -> list.sort(TaskComparator.DUE_DATE_COMPARATOR);
                    case "priority" -> list.sort(TaskComparator.PriorityComparator);
                    case "combined" -> list.sort(TaskComparator.CombinedComparator);
                    default -> System.out.println("⚠ Warning: Unknown sort option. Displaying default order.");
                }
            }

            // 3. Print table using System.out.printf() with formatted columns
            if (list.isEmpty()) {
                System.out.println("No tasks currently stored in system memory registry.");
                return;
            }

            System.out.println("\n" + "-".repeat(122));
            System.out.printf("| %-36s | %-15s | %-10s | %-11s | %-12s | %-15s |\n", "TASK ID", "TITLE", "PRIORITY", "STATUS", "DUE DATE", "ASSIGNEE");
            System.out.println("-".repeat(122));

            for (Task t : list) {
                String dateString = t.getDueDate() != null ? t.getDueDate().toLocalDate().toString() : "N/A";
                String assigneeString = t.getAssignedTo() != null ? t.getAssignedTo() : "Unassigned";

                System.out.printf("| %-36s | %-15.15s | %-10s | %-11s | %-12s | %-15.15s |\n",
                        t.getId(),
                        t.getTitle(),
                        t.getPriority(),
                        t.getStatus(),
                        dateString,
                        assigneeString);
            }
            System.out.println("-".repeat(122));

        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleFilter(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("✕ Error: Missing filter options.");
            System.out.println("Usage:\n  filter --status <STATUS>\n  filter --priority <PRIORITY>\n  filter --assignee <NAME>");
            return;
        }

        try {
            // Split space between flag and criteria value (e.g. ["--status", "TODO"])
            String[] tokens = args.trim().split("\\s+", 2);
            if (tokens.length < 2) {
                System.out.println("✕ Error: Missing filter value criteria parameter.");
                return;
            }

            String flag = tokens[0].toLowerCase();
            String criterion = tokens[1].trim();
            java.util.Collection<Task> filteredResults;

            switch (flag) {
                case "--status" -> {
                    Status status = Status.valueOf(criterion.toUpperCase());
                    filteredResults = taskManager.filterByStatus(status);
                }
                case "--priority" -> {
                    Priority priority = Priority.valueOf(criterion.toUpperCase());
                    filteredResults = taskManager.filterByPriority(priority);
                }
                case "--assignee" -> {
                    filteredResults = taskManager.filterByAssignee(criterion);
                }
                default -> {
                    System.out.println("✕ Error: Unknown filter flag token choice '" + flag + "'.");
                    return;
                }
            }

            printTaskTable(filteredResults);

        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleSearch(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("✕ Error: Missing search keyword string query. Usage: search <keyword>");
            return;
        }

        try {
            String keyword = args.trim();
            java.util.Collection<Task> searchResults = taskManager.search(keyword);
            printTaskTable(searchResults);

        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleReminder(String args) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("✕ Error: Missing arguments. Usage: reminder <UUID> <minutes>");
            return;
        }

        try {
            String[] tokens = args.trim().split("\\s+");
            if (tokens.length < 2) {
                System.out.println("✕ Error: Invalid argument format sequence matching. Usage: reminder <UUID> <minutes>");
                return;
            }

            UUID taskId = UUID.fromString(tokens[0]);
            long minutesBefore = Long.parseLong(tokens[1]);

            // Triggers the background execution thread timers
            taskReminderService.scheduleReminder(taskId, minutesBefore);
            System.out.println("✔ Background thread reminder validation queue checked for Task ID: " + taskId);

        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleHelp() {
        System.out.println("\n==========================================================================");
        System.out.println("                     COMMAND LINE INTERFACE SYSTEM USAGE                  ");
        System.out.println("==========================================================================");
        System.out.printf("  %-40s %s\n", "add", "Create an entirely new task through an interactive wizard form.");
        System.out.printf("  %-40s %s\n", "update <UUID>", "Edit specific parameters of a task using default placeholders.");
        System.out.printf("  %-40s %s\n", "delete <UUID>", "Remove task storage references securely with a confirmation check.");
        System.out.printf("  %-40s %s\n", "list [--sort <date|priority|combined>]", "Display structured entries arranged in aligned data columns.");
        System.out.printf("  %-40s %s\n", "filter <--status|--priority|--assignee> <val>", "Query task metrics matching targeted category criteria flags.");
        System.out.printf("  %-40s %s\n", "search <keyword>", "Scan descriptive records across tracking criteria attributes.");
        System.out.printf("  %-40s %s\n", "reminder <UUID> <minutes>", "Queue up an automated asynchronous alert for a task deadline.");
        System.out.printf("  %-40s %s\n", "help", "Print this command options directory.");
        System.out.printf("  %-40s %s\n", "exit", "Gracefully stop running worker threads and shut down the shell.");
        System.out.println("==========================================================================\n");
    }

    private String promptRequired(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("✕ Input validation error: This field cannot be empty. Please try again.");
        }
    }

    private <E extends Enum<E>> E promptEnum(String message, Class<E> enumClass) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return Enum.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                System.out.println("✕ Input validation error: Invalid option. Choose exactly from the listed values.");
            }
        }
    }

    private LocalDateTime promptDate(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return null; // Allowed empty to signify no deadline
            }
            try {
                // Parses string "yyyy-MM-dd" into a LocalDate, then converts to 00:00 midnight LocalDateTime
                return LocalDate.parse(input, dateFormatter).atStartOfDay();
            } catch (DateTimeParseException e) {
                System.out.println("✕ Input validation error: Incorrect date format. You must use 'yyyy-MM-dd' (e.g., 2026-07-18).");
            }
        }
    }

    private void handleException(Exception e) {
        System.out.println(); // Print an empty line for visual spacing

        if (e instanceof TaskNotFoundException) {
            System.out.println("✕ Operational Error: Task not found.");

        } else if (e instanceof DuplicateTaskException) {
            System.out.println("✕ Data Integrity Error: Task already exists.");

        } else if (e instanceof IllegalArgumentException) {
            System.out.println("✕ Input Validation Error: Invalid input option or unknown selection value.");

        } else if (e instanceof DateTimeParseException) {
            System.out.println("✕ Formatting Error: Invalid date format. Please look closely at the pattern guidelines (yyyy-MM-dd).");

        } else {
            // Fallback catch-all for system errors (like NullPointer or IO anomalies)
            System.out.println("✕ Critical System Error: An unexpected processing exception occurred -> " + e.getMessage());
        }
    }

    private void printTaskTable(java.util.Collection<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No matching rows tracked under current storage query filters.");
            return;
        }
        System.out.println("\n" + "-".repeat(122));
        System.out.printf("| %-36s | %-15s | %-10s | %-11s | %-12s | %-15s |\n", "TASK ID", "TITLE", "PRIORITY", "STATUS", "DUE DATE", "ASSIGNEE");
        System.out.println("-".repeat(122));
        for (Task t : tasks) {
            String dateStr = t.getDueDate() != null ? t.getDueDate().toLocalDate().toString() : "N/A";
            String assignStr = t.getAssignedTo() != null ? t.getAssignedTo() : "Unassigned";
            System.out.printf("| %-36s | %-15.15s | %-10s | %-11s | %-12s | %-15.15s |\n",
                    t.getId(), t.getTitle(), t.getPriority(), t.getStatus(), dateStr, assignStr);
        }
        System.out.println("-".repeat(122));
    }
}
