package com.example.individual_assignment.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.individual_assignment.model.Task;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskRoomDatabaseRepository {

    private TaskRoomDatabase taskRoomDatabase;
    private TaskDao taskDao;
    private LiveData<List<Task>> taskList;
    private Executor executor = Executors.newSingleThreadExecutor();

    public TaskRoomDatabaseRepository(Context context) {
        taskRoomDatabase = TaskRoomDatabase.getDatabase(context);
        taskDao = taskRoomDatabase.taskDao();
        taskList = taskDao.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {return taskList;}

    public void insert(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDao.insert(task);
            }
        });
    }

    public void insertAll(final List<Task> tasks) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDao.insert(tasks);
            }
        });
    }

    public void update(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDao.update(task);
            }
        });
    }

    public void delete(final Task task) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDao.delete(task);
            }
        });
    }

    public void deleteAll(final List<Task> tasks) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                taskDao.delete(tasks);
            }
        });
    }
}
