package com.example.tasklist.repository

import com.example.tasklist.datasource.DataSource
import com.example.tasklist.model.TaskModel

class TaskRepository {
    private val dataSource: DataSource = DataSource()

    fun saveTask(taskModel: TaskModel) {
        dataSource.saveTask(taskModel)
    }
}