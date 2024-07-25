package io.github.BGPtII.ch15javacollectionsframework;

/**
 * Tasks have a description (can't be empty) and a priority of 1-9 inclusive in order of urgency
 */
public class Task implements Comparable<Task> {

    private String description;
    private int priority;

    public Task(String description, int priority) {
        if (priority < 1 || priority > 9) {
            throw new IllegalArgumentException("priority must be between 1 & 9 inclusive");
        }
        this.description = description;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task t) {
        return Integer.compare(getPriority(), t.getPriority());
    }

    @Override
    public String toString() {
        return "Task{description='" + description + "',priority=" + priority + "}";
    }

}
