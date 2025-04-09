package com.example.tasklist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tasklist.ui.theme.TasklistTheme
import com.example.tasklist.view.LoginScreen
import com.example.tasklist.view.SaveTask
import com.example.tasklist.view.TaskList
import com.example.tasklist.view.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasklistTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome") {
                    composable(route = "taskList") { TaskList(navController) }
                    composable(route = "saveTask") { SaveTask(navController) }
                    composable(route = "welcome") { WelcomeScreen(navController) }
                    composable(route = "login") { LoginScreen(navController) }
                }
            }
        }
    }
}