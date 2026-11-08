package org.example.todo;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

/** In-memory todo store. Data is lost when the application restarts. */
@Service
public class TodoService {

    private final Map<Long, Todo> todos = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Todo> findAll() {
        return todos.values().stream()
                .sorted(Comparator.comparingLong(Todo::id))
                .toList();
    }

    public Todo findById(long id) {
        Todo todo = todos.get(id);
        if (todo == null) {
            throw new TodoNotFoundException(id);
        }
        return todo;
    }

    public Todo create(TodoRequest request) {
        long id = nextId.getAndIncrement();
        Todo todo = new Todo(id, request.title().trim(), request.isCompleted(), Instant.now());
        todos.put(id, todo);
        return todo;
    }

    public Todo replace(long id, TodoRequest request) {
        return update(id, request.title(), request.isCompleted());
    }

    public Todo patch(long id, TodoPatchRequest request) {
        return update(id, request.title(), request.completed());
    }

    private Todo update(long id, String title, Boolean completed) {
        Todo updated = todos.computeIfPresent(id, (key, existing) -> new Todo(
                existing.id(),
                title != null ? title.trim() : existing.title(),
                completed != null ? completed : existing.completed(),
                existing.createdAt()));
        if (updated == null) {
            throw new TodoNotFoundException(id);
        }
        return updated;
    }

    public void delete(long id) {
        if (todos.remove(id) == null) {
            throw new TodoNotFoundException(id);
        }
    }

    public int deleteCompleted() {
        int before = todos.size();
        todos.values().removeIf(Todo::completed);
        return before - todos.size();
    }
}
