package com.example.individual_assignment.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.individual_assignment.database.TaskRoomDatabaseRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private TaskRoomDatabaseRepository taskRoomDatabaseRepository;
    private LiveData<List<Task>> taskList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        taskRoomDatabaseRepository = new TaskRoomDatabaseRepository(application.getApplicationContext());
        taskList = taskRoomDatabaseRepository.getAllTasks();
    }

    public LiveData<List<Task>> getTaskList() {return taskList;}
    public void insert(Task task) {taskRoomDatabaseRepository.insert(task);}
    public void update(Task task) {taskRoomDatabaseRepository.update(task);}
    public void delete(Task task) {taskRoomDatabaseRepository.delete(task);}
    public void deleteAll(List<Task> taskList) {taskRoomDatabaseRepository.deleteAll(taskList);}
    public void insertAll(List<Task> taskList) {taskRoomDatabaseRepository.insertAll(taskList);}
}
