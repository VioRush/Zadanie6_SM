package com.example.zadanie6;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskStorage {
    private static final TaskStorage taskStorage = new TaskStorage();
    private final List<Task> tasks;

    public static TaskStorage getInstance() { return taskStorage; }

    private TaskStorage() {
        tasks = new ArrayList<>();
        for (int i=1; i<=100; i++){
            Task task = new Task();
            task.setName("Zadanie #" + i);
            task.setDone(i%3 == 0);
            tasks.add(task);
        }

    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public List<Task> getTasks(){
        return tasks;
    }

    /*
    public Task getTask(UUID id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }*/
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Task getTask(UUID taskId){
        return tasks.stream()
                .filter(x->x.getId().equals(taskId))
                .collect(Collectors.toList())
                .get(0);
    }
}
