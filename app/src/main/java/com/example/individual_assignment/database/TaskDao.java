package com.example.individual_assignment.database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.individual_assignment.model.Task;

import java.util.List;

@Dao
public interface TaskDao {


    @Insert
    void insert(Task task);

    @Insert
    void insert(List<Task> tasks);

    @Delete
    void delete(Task task);

    @Delete
    void delete(List<Task> tasks);

    @Update
    void update(Task task);

    @Query("SELECT * FROM task_Table")
    public LiveData<List<Task>> getAllTasks();
}
