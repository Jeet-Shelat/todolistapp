package com.example.todolistapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayTasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_tasks)

        // Ensure this ID matches the one in your XML layout file
        val textViewTasks: TextView = findViewById(R.id.textViewTasks)

        val todoList: ArrayList<String>? = intent.getStringArrayListExtra("TODO_LIST")

        if (todoList != null && todoList.isNotEmpty()) {
            val displayText = todoList.joinToString(separator = "\n")
            textViewTasks.text = displayText
        } else {
            textViewTasks.text = "No tasks in the list"
        }
    }
}
