@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tasklist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tasklist.model.TaskModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskList(navController: NavController) {
    val myTaskList: MutableList<TaskModel> = mutableListOf(
        TaskModel("Frango", "...", 3),
        TaskModel("Arroz", "...", 3),
        TaskModel("Feijão", "...", 1),
        TaskModel("Brócolis", "...", 2),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Lista de tarefas",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = Color.White,
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("SaveTask")
                },
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn( modifier = Modifier.padding(innerPadding)) {
            items(myTaskList) {
                TaskItem(it)
            }
        }
    }
}