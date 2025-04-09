package com.example.tasklist.datasource

import android.util.Log
import com.example.tasklist.model.TaskModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class DataSource {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val now = Clock.System.now().toLocalDateTime(TimeZone.UTC)

    fun saveTask(taskModel: TaskModel) {
        val taskPayload = mapOf(
            "title" to taskModel.title,
            "description" to taskModel.description,
            "priority" to taskModel.priority,
            "createdAt" to now.date,
        )
        firestore
            .collection("tarefas")
            .document("$now-${taskModel.title}")
            .set(taskPayload)
            .addOnSuccessListener { Log.d("Firestore", "Documento salvo: $now-${taskModel.title}.") }
            .addOnFailureListener { Log.d("Firestore", "Erro ao salvar o documento: $now-${taskModel.title}.") }
            .addOnCanceledListener { Log.d("Firestore", "A ação foi cancelada.") }
            .addOnCompleteListener { Log.d("Firestore", "Ação finalizada.") }
    }
}