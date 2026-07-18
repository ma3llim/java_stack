package org.taskmanager.utils;

import org.taskmanager.model.Task;

import java.util.Comparator;

public class TaskComparator {
    public static final Comparator<Task> DUE_DATE_COMPARATOR = Comparator.comparing(Task::getDueDate, Comparator.nullsLast(Comparator.naturalOrder()));
    public static final Comparator<Task> PriorityComparator = Comparator.comparing(Task::getPriority);
    public static final Comparator<Task> CombinedComparator = DUE_DATE_COMPARATOR.thenComparing(PriorityComparator);
}
