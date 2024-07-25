package io.github.BGPtII.ch15javacollectionsframework;

public class ToDoListDemo {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Mow the lawn", 3);
        toDoList.addTask("Eat breakfast", 1);
        System.out.println(toDoList.next());
    }

}
