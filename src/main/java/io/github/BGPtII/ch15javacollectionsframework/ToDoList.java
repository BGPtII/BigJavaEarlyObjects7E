package io.github.BGPtII.ch15javacollectionsframework;

import java.util.PriorityQueue;

/**
 * Priority is measured from 1-9 inclusive in order of urgency
 */
public class ToDoList {

    private PriorityQueue<Task> taskList;

    public ToDoList() {
        this.taskList = new PriorityQueue<>();
    }

    public void addTask(String description, int priority) {
        taskList.add(new Task(description, priority));
    }

    public Task next() {
        return taskList.poll();
    }

}
